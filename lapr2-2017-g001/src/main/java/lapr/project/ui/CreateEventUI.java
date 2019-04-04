/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lapr.project.controller.CreateEventController;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Organiser;
import lapr.project.model.StaffMember;
import lapr.project.model.User;
import lapr.project.utils.Utils;

/**
 *
 * @author MariaJoão
 */
public class CreateEventUI {

    private CreateEventController controller;

    public CreateEventUI(ExhibitionCentre exhibitionCentre){
        this.controller= new CreateEventController(exhibitionCentre);
        String title="";
        String description="";
        String startDateString;
        String endDateString;
        String place="";
        String user1="";
        String fromFile="";
        boolean file=false, answer=false;
        Date startDate = new Date(), endDate= new Date();
        List<Organiser> organisersToPrint = new ArrayList<>();
        int userPos=0, nDays=0;
        String lines = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
        String lines2 = "--------------------------";
       
        UtilsUI.printLine("");        
        UtilsUI.printLine(lines);  
        UtilsUI.printLine("           CREATE EVENT           ");
        UtilsUI.printLine(lines);  
        while(!answer){
    
            fromFile= UtilsUI.readLineFromConsole("DO YOU WISH TO LOAD EVENT FROM FILE OR DO YOU WISH TO CREATE HERE A NEW ONE? ENTER 'Y' TO LOAD EVENT FROM FILE OR 'N' TO CREATE A NEW ONE: ");
            if("y".equalsIgnoreCase(fromFile)){
                    answer=true;
                    String filename= UtilsUI.readLineFromConsole("ABSOLUTE PATH TO FILE : ");
                    
                    if(controller.getEventFromFile(filename)){ 
                        title=controller.getEvent().getTitle();
                        description= controller.getEvent().getDescription();
                        place = controller.getEvent().getPlace();
                        List<StaffMember> list= controller.getEvent().getStaffRegister().getStaffList();
                        List<Organiser> list2=controller.getEvent().getOrganiserRegister().getOrganiserList();
                        printEventFile(title, description, startDate, endDate, place,list, list2, nDays);
                    }else{
                        new MainMenu(exhibitionCentre);
                    }
            }else if("n".equalsIgnoreCase(fromFile)){
                    answer=true;
                    title = UtilsUI.readLineFromConsole("TITLE: ");
                    description = UtilsUI.readLineFromConsole("DESCRIPTION: ");
                    startDateString =UtilsUI.readLineFromConsole("START DATE (YYYY-MM-DD): ");
                    startDate= validateStartDateFormat(startDateString);
                    endDateString =UtilsUI.readLineFromConsole("END DATE (YYYY-MM-DD): ");
                    endDate=validateEndDateFormat(endDateString, startDate);        
                    place = UtilsUI.readLineFromConsole("PLACE: ");
                    while(nDays<1){
                        try{
                            nDays = Integer.parseInt(UtilsUI.readLineFromConsole("NUMBER OF DAYS FOR OPEN APPLICATIONS: "));
                            if(nDays<1){
                             UtilsUI.printError("NUMBER INSERTED NOT VALID. INSERT NUMBER BIGGER THAN 0. PLEASE TRY AGAIN.");

                            }    
                            }catch(NumberFormatException e){

                            UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");

                        }           
                    }
                    while(!"X".equalsIgnoreCase(user1)){

                        int n=1;
                        userPos=0;
                        UtilsUI.printLine(lines2);
                        UtilsUI.printLine("          USERS           ");
                        UtilsUI.printLine(lines2);

                        for (User user : controller.getUsersAvailable()) {
                            UtilsUI.printLine(n+" - "+user.getUsername());
                            n++;
                        }
                        UtilsUI.printLine(lines2);

                        user1=UtilsUI.readLineFromConsole("PICK ORGANISER (WRITE X WHEN YOU ARE DONE): ");
                        readOrganiser(user1, userPos, n, organisersToPrint);


                    }
            controller.setData(title, description, startDate, endDate, place);
            printEvent(title, description, startDate, endDate, place,organisersToPrint, nDays);
            
            }else{
                UtilsUI.printError("INVALID CHARACTER. PLEASE ANSWER AGAIN.");
                
            }


        }
        
        
        String resposta="";
        while(!"y".equalsIgnoreCase(resposta) && !"c".equalsIgnoreCase(resposta)){
            resposta=UtilsUI.readLineFromConsole("DO YOU CONFIRM THIS EVENT? (WRITE 'Y' TO CONFIRM OR 'C' TO CANCEL): ");
            if(!"y".equalsIgnoreCase(resposta) && !"c".equalsIgnoreCase(resposta)){
                UtilsUI.printError("INVALID CHARACTER. PLEASE ANSWER AGAIN.");
            }
        }
        if("c".equalsIgnoreCase(resposta)){
            UtilsUI.printWarning("EVENT CANCELED");
            new MainMenu(exhibitionCentre);
        }else if("y".equalsIgnoreCase(resposta)){
            controller.registerEvent(); 
            controller.registerLog();
            UtilsUI.printConfirmation("EVENT SAVED");
            new MainMenu(exhibitionCentre);        

        }
    }

    private Date validateStartDateFormat(String startDateString) {
    boolean validate=false;
    Date today= new Date();
    Date startDate=new Date();
    //Validates date format
        while(!validate){
            startDate=Utils.changeFormat(startDate,startDateString);
            if(Utils.changeFormat(startDate,startDateString)==null){

                UtilsUI.printError("INVALID FORMAT, PLEASE TRY AGAIN.");                
                startDateString =UtilsUI.readLineFromConsole("START DATE (YYYY-MM-DD): ");               
               
            }else if(!controller.compareDates(today,startDate)){
                UtilsUI.printError("DATE EXPIRED, PLEASE TRY AGAIN.");
                startDateString =UtilsUI.readLineFromConsole("START DATE (YYYY-MM-DD): ");                

            }else{

                validate=true;

            }
        }
        
        return startDate;
        //validates date timming

    }

    private Date validateEndDateFormat(String endDateString, Date startDate) {
    boolean validate=false;
    Date endDate= new Date();            
        while(!validate){
            endDate=Utils.changeFormat(endDate,endDateString);
            if(Utils.changeFormat(endDate,endDateString)==null){
                UtilsUI.printError("INVALID FORMAT, PLEASE TRY AGAIN.");                
                endDateString =UtilsUI.readLineFromConsole("END DATE (YYYY-MM-DD): ");
                
            }else if(!controller.compareDates(startDate, endDate)){
                
                UtilsUI.printError("END DATE MUST BE AFTER START DATE. PLEASE TRY AGAIN.");
                endDateString =UtilsUI.readLineFromConsole("END DATE (YYYY-MM-DD): ");                

            }else{
                validate=true;
            }
        }
        return endDate;
    }
    
    private void printEventFile(String title, String description, Date startDate, Date endDate, String place, List<StaffMember> list, List<Organiser> list2, int nDays){
        String lines = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
        String lines2 = "--------------------------";
        UtilsUI.printLine("");        
        UtilsUI.printLine(lines);  
        UtilsUI.printLine("           CREATED EVENT          ");
        UtilsUI.printLine(lines);  
        UtilsUI.printLine("TITLE: "+title);
        UtilsUI.printLine("DESCRIPTION: "+description);
        UtilsUI.printLine("START DATE : "+startDate.toString());
        UtilsUI.printLine("END DATE : "+endDate.toString());
        UtilsUI.printLine("PLACE: "+place);
        UtilsUI.printLine("NUMBER OF DAYS FOR OPEN APPLICATIONS: "+nDays);
        UtilsUI.printLine(lines2);
        UtilsUI.printLine("      STAFF MEMBERS        ");
        UtilsUI.printLine(lines2);
        int n=1;
            for (StaffMember o : list) {
                UtilsUI.printLine(n+" - "+o.getStaff().getUsername());
                n++;
            }
        UtilsUI.printLine(lines2);
        UtilsUI.printLine(lines2);
        UtilsUI.printLine("        ORGANISERS        ");
        UtilsUI.printLine(lines2);
        int n2=1;
            for (Organiser o : list2) {
                UtilsUI.printLine(n2+" - "+o.getOrganiser().getUsername());
                n2++;
            }
        UtilsUI.printLine(lines2);
    }
    private void printEvent(String title, String description, Date startDate, Date endDate, String place, List<Organiser> list, int nDays){
        String lines = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
        String lines2 = "--------------------------";
        UtilsUI.printLine("");        
        UtilsUI.printLine(lines);  
        UtilsUI.printLine("           CREATED EVENT          ");
        UtilsUI.printLine(lines);  
        UtilsUI.printLine("TITLE: "+title);
        UtilsUI.printLine("DESCRIPTION: "+description);
        UtilsUI.printLine("START DATE : "+startDate.toString());
        UtilsUI.printLine("END DATE : "+endDate.toString());
        UtilsUI.printLine("PLACE: "+place);
        UtilsUI.printLine("NUMBER OF DAYS FOR OPEN APPLICATIONS: "+nDays);
        UtilsUI.printLine(lines2);
        UtilsUI.printLine("        ORGANISERS        ");
        UtilsUI.printLine(lines2);
        int n=1;
            for (Organiser o : list) {
                UtilsUI.printLine(n+" - "+o.getOrganiser().getUsername());
                n++;
            }
        UtilsUI.printLine(lines2);
    }

    private void readOrganiser(String user1, int userPos, int n, List<Organiser> organisersToPrint) {
        try{
                userPos= Integer.parseInt(user1);
                if(userPos<n){
                    Organiser o = controller.createOrganiser(controller.getUsersAvailable(), userPos);
                    boolean answer = controller.addOrganiser(o);
                    if(!answer){
                        UtilsUI.printError("USER ALLREADY ADDED. PLEASE TRY AGAIN.");
                    }else{
                        organisersToPrint.add(o);
                    }
                }else{
                    UtilsUI.printError("NUMBER OUT OF BOUNDARIES. PLEASE TRY AGAIN.");

                }
            }catch(NumberFormatException e){
                if(!"X".equalsIgnoreCase(user1)){
                    UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");

                }
            }           
    }
}

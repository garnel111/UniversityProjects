/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.ArrayList;
import java.util.List;
import lapr.project.controller.UpdateOrWithdrawApplicationController;
import lapr.project.model.Application;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Keyword;
import lapr.project.model.Workshop;

/**
 *
 * @author MariaJoão
 */
public final class UpdateOrWithdrawApplicationUI {
    
    UpdateOrWithdrawApplicationController controller;
    
    public UpdateOrWithdrawApplicationUI(ExhibitionCentre centre ){
        
        this.controller= new UpdateOrWithdrawApplicationController(centre);
        
        String lines = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
        String description;
        String companyName;        
        int nInvites=-1;
        int n=1;
        int app_number=-1;
        int phoneNumber;
        int vatNumber=0;
        double area;
        List<Keyword> keywords; 
        UtilsUI.printLine("");        
        UtilsUI.printLine(lines);  
        UtilsUI.printLine("           UPDATE OR WITHDRAW APPLICATION TO EVENT           ");
        UtilsUI.printLine(lines);  
        if(!showApplications(app_number,n, centre)){
               new MainMenu(centre);        
        }else{
        String resposta1= getResposta(centre);
        
                
        if("u".equalsIgnoreCase(resposta1)){
        
        UtilsUI.printLine("******WRITE 'M' TO MAINTAIN PREVIOUS FIELD OR WRITE NEW CHOICE (ON ALL FIELDS) ******");    
        description = UtilsUI.readLineFromConsole("DESCRIPTION (CURRENT ONE IS '"+controller.getA().getDescription()+"'): ");
        if("m".equalsIgnoreCase(description)){
            description= controller.getA().getDescription();
        }
        nInvites = readInvites(nInvites);
        keywords = readKeywords();
        area = readArea();
        
        
        companyName = UtilsUI.readLineFromConsole("COMPANY NAME (CURRENT ONE IS "+controller.getA().getNameOfCompany()+") :");
        if("m".equalsIgnoreCase(companyName)){
            companyName= controller.getA().getNameOfCompany();
        }
        
        phoneNumber= readPhoneNumber();
        
        boolean vat=false;
        String vat_string;
        while(!vat){
            try{
                vat_string = UtilsUI.readLineFromConsole("VAT NUMBER: ");
                if("m".equalsIgnoreCase(vat_string)){
                    vatNumber=controller.getA().getVatNumber();
                }else{
                    vatNumber= Integer.parseInt(vat_string);
                }
                vat=true;
                }catch(NumberFormatException e){

                UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
                vat=false;    
            }           
        } 
        List<Workshop> workshop_list = new ArrayList<>();
        
        String maintain_workshops="";
        UtilsUI.printLine("CURRENT WORKSHOPS: ");
        controller.getA().getWorkshopList().forEach((w) -> {
            UtilsUI.printLine("- "+w.getDescription());
            });
        while(!"y".equalsIgnoreCase(maintain_workshops) && !"n".equalsIgnoreCase(maintain_workshops)){
            maintain_workshops = UtilsUI.readLineFromConsole("DO YOU WISH TO MAINTAIN THIS WORSHOPS? (WRITE 'y' IF YES OR 'n' IF NO) : ");   
            if(!"y".equalsIgnoreCase(maintain_workshops) && !"n".equalsIgnoreCase(maintain_workshops)){
                UtilsUI.printError("INVALID CHARACTER. PLEASE ANSWER AGAIN.");
            }
        }
        if("y".equalsIgnoreCase(maintain_workshops)){
           workshop_list = controller.getA().getWorkshopList();
        }
        else{
            String resposta_workshops="";
            while(!"y".equalsIgnoreCase(resposta_workshops) && !"n".equalsIgnoreCase(resposta_workshops)){
                resposta_workshops=UtilsUI.readLineFromConsole("DO YOU WISH TO DO WORKSHOPS? (WRITE 'Y' IF YES OR 'N' IF NO): ");
                if(!"y".equalsIgnoreCase(resposta_workshops) && !"n".equalsIgnoreCase(resposta_workshops)){
                    UtilsUI.printError("INVALID CHARACTER. PLEASE ANSWER AGAIN.");
                }               
            }

            if("y".equalsIgnoreCase(resposta_workshops)){
                workshop_list=readWorkshops(controller.getEvent());   
            }
        }
        String resposta="";
        while(!"y".equalsIgnoreCase(resposta) && !"c".equalsIgnoreCase(resposta)){
            resposta=UtilsUI.readLineFromConsole("DO YOU CONFIRM THIS APPLICATION? (WRITE 'Y' TO CONFIRM OR 'C' TO CANCEL): ");
            if(!"y".equalsIgnoreCase(resposta) && !"c".equalsIgnoreCase(resposta)){
                UtilsUI.printError("INVALID CHARACTER. PLEASE ANSWER AGAIN.");
            }
        }
        
        if("c".equalsIgnoreCase(resposta)){
            UtilsUI.printWarning("APPLICATION CANCELED");
            new MainMenu(centre);
        }else if("y".equalsIgnoreCase(resposta)){
            controller.setData(description,nInvites,keywords,area,companyName, phoneNumber, vatNumber,workshop_list );
            controller.updateApplication();
            controller.registerLog("updated");
            UtilsUI.printConfirmation("APPLICATION SAVED");
            new MainMenu(centre);        

        }
        }   
        }
        
    }
    public List<Workshop> readWorkshops(Event e){
        boolean vat=false;
        String lines2 = "---------------------------";
        List<Workshop> list= new ArrayList<>();
        int number_of_workshops;
        while(!vat){
            try{
                number_of_workshops = Integer.parseInt(UtilsUI.readLineFromConsole("HOW MANY WORKSHOPS DO YOU WISH TO EXECUTE (NOTE: EVENT HAS "+e.getRooms()+" ROOMS AVAILABLE): "));
                if(number_of_workshops<=e.getRooms()){                   
                    
                    for (int i = 0; i < number_of_workshops; i++) {
                        Workshop w= new Workshop();
                        String description;
                        int duration=0;
                        List<String> equip= new ArrayList<>();
                        UtilsUI.printLine(lines2);    
                        UtilsUI.printLine("       WORKSHOP "+(i+1)+"  ");                     
                        UtilsUI.printLine(lines2);    
                        description = UtilsUI.readLineFromConsole("DESCRIPTION: ");
                        boolean ans=false;
                        while(!ans){
                            try{
                                duration = Integer.parseInt(UtilsUI.readLineFromConsole("DURATION (HOURS): "));
                                ans=true;
                                }catch(NumberFormatException ex){

                                UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
                                ans=false;    
                            }           
                        }
                        String done="";
                        while(!"x".equalsIgnoreCase(done)){
                            done=UtilsUI.readLineFromConsole("NECESSARY EQUIPMENT (WRITE 'X' WHEN YOU ARE DONE):  ");
                            if(!"x".equalsIgnoreCase(done)){ 
                                equip.add(done);
                            }
                        }
                        w.setDescription(description);
                        w.setDurationInHours(duration);
                        w.setNecessaryEquipment(equip);
                        list.add(w);
                    }
                    vat=true;
                }else{
                UtilsUI.printError("NUMBER OF WORSHOPS EXCEEDED. PLEASE TRY AGAIN.");
                 vat=false;   
                }
                }catch(NumberFormatException ex){

                UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
                vat=false;    
            }           
        }
        return list;
       }

    private boolean showApplications(int app_number, int n, ExhibitionCentre centre) {
        String lines2 = "---------------------------";
        while(app_number==-1){
                UtilsUI.printLine(lines2);
                UtilsUI.printLine("     YOUR APPLICATIONS    ");
                UtilsUI.printLine(lines2);

                for (Application a : controller.getUserApplications()) {
                        UtilsUI.printLine(n+" - "+a.getDescription());
                        n++;
                    }
                UtilsUI.printLine(n+" - GO BACK");
                UtilsUI.printLine(lines2);

                try{
                        app_number = Integer.parseInt(UtilsUI.readLineFromConsole("PICK APPLICATION: "));
                        if(app_number==n){
                            return false;
                        }
                        controller.setA(n-2);

                        if(app_number <1 || app_number>n){
                            UtilsUI.printError("NUMBER INSERTED NOT VALID. INSERT NUMBER INSIDE LIMITS. PLEASE TRY AGAIN.");
                            app_number=-1;                            
                        }
                        
                        }catch(NumberFormatException e){

                        UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
                        app_number=-1;                            

                    }           
        }    
        
        return true;
    }

    private String getResposta(ExhibitionCentre centre) {
    String resposta1="";
        while(!"w".equalsIgnoreCase(resposta1) && !"u".equalsIgnoreCase(resposta1)){
            resposta1=UtilsUI.readLineFromConsole("DO YOU WISH TO WITHDRAW OR UPDATE APPLICATION? (WRITE 'W' TO WHITHDRAW OR 'U' TO UPDATE): ");
            if(!"w".equalsIgnoreCase(resposta1) && !"u".equalsIgnoreCase(resposta1)){
                UtilsUI.printError("INVALID CHARACTER. PLEASE ANSWER AGAIN.");
            }
        }
        
        if("w".equalsIgnoreCase(resposta1)){
            if(controller.withdrawApplication()){
                UtilsUI.printConfirmation("APPLICATION REMOVED");
                controller.registerLog("removed");
                new MainMenu(centre);
            }else{
                UtilsUI.printError("AN ERROR HAS OCCOURED. WITHDRAW FAILED.");
                new MainMenu(centre);
            }
        }
        return resposta1;
    }

    private int readInvites(int nInvites) {
        String inv_string;
        while(nInvites<0){
            try{

                inv_string = UtilsUI.readLineFromConsole("NUMBER OF INVITES (CURRENT ONE IS '"+controller.getA().getNumberInvites()+"'): ");
                if("m".equalsIgnoreCase(inv_string)){
                    nInvites=controller.getA().getNumberInvites();
                }else{
                    nInvites=Integer.parseInt(inv_string);
                }
                if(nInvites<0){
                 UtilsUI.printError("NUMBER INSERTED NOT VALID. INSERT NUMBER BIGGER OR EQUAL TO 0. PLEASE TRY AGAIN.");

                }    
                }catch(NumberFormatException e){

                UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");

            }           
        }    
    return nInvites;
    }

    private List<Keyword> readKeywords() {
        List<Keyword> keywords= new ArrayList<>();
        String maintain_keywords="";
        String keyTemp;
        int nKeywords=0;
        UtilsUI.printLine("CURRENT KEYWORDS: ");
        controller.getA().getKeywordList().forEach(keyword -> {
            UtilsUI.printLine("- "+keyword.getValue());
            });
        while(!"y".equalsIgnoreCase(maintain_keywords) && !"n".equalsIgnoreCase(maintain_keywords)){
            maintain_keywords = UtilsUI.readLineFromConsole("DO YOU WISH TO MAINTAIN THIS KEYWORDS? (WRITE 'y' IF YES OR 'n' IF NO) : ");   
            if(!"y".equalsIgnoreCase(maintain_keywords) && !"n".equalsIgnoreCase(maintain_keywords)){
                UtilsUI.printError("INVALID CHARACTER. PLEASE ANSWER AGAIN.");
            }
        }
        if("y".equalsIgnoreCase(maintain_keywords)){
            keywords = controller.getA().getKeywordList();
        }
        
        if("n".equalsIgnoreCase(maintain_keywords)){
            while(nKeywords<5){
                    keyTemp=UtilsUI.readLineFromConsole("ISERT A KEYWORD (MINUMUM 2 MAXIMUM 5) (WRITE X WHEN YOU ARE DONE) : ");
                    if(!"x".equalsIgnoreCase(keyTemp)){
                        Keyword k= new Keyword();
                        k.setValue(keyTemp);
                        keywords.add(k);
                        nKeywords++;                   
                    }else{
                       if(nKeywords<2){

                            UtilsUI.printError("YOU NEED AT LEAST 2 KEYWORDS.");

                       }else{
                           break;
                       } 
                    }
            }
        }
        return keywords;
    }

    private double readArea() {
        String area_string;
        double area=-1;
        while(area<=0){
            try{
                area_string = UtilsUI.readLineFromConsole("WANTED BOOTH AREA (m2) (CURRENT ONE IS "+controller.getA().getBoothArea()+" m2) : ");
                if("m".equalsIgnoreCase(area_string)){
                    area= controller.getA().getBoothArea();
                }else{
                    area=Double.parseDouble(area_string);                   
                }
                if(area<=0){
                 UtilsUI.printError("NUMBER INSERTED NOT VALID. INSERT NUMBER BIGGER THAN 0. PLEASE TRY AGAIN.");

                }    
                }catch(NumberFormatException e){

                UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");

            }           
        }
        return area;
    }

    private int readPhoneNumber() {
        int phoneNumber=0;
        String phone_number_string;
        while(!controller.validatePhoneNumber(phoneNumber)){
            try{
                phone_number_string = UtilsUI.readLineFromConsole("PHONE NUMBER (CURRENT ONE IS "+controller.getA().getPhoneNumber()+") :");
                if("m".equalsIgnoreCase(phone_number_string)){
                    phoneNumber=controller.getA().getPhoneNumber();
                }else{
                    phoneNumber=Integer.parseInt(phone_number_string);
                }
                if(!controller.validatePhoneNumber(phoneNumber)){
                 UtilsUI.printError("NUMBER INSERTED NOT VALID. YOU SHOULD INSERT 9 DIGIT NUMBER. PLEASE TRY AGAIN.");

                }    
                }catch(NumberFormatException e){

                UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");

            }           
        }
        return phoneNumber;
    }
}

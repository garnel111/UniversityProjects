/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import lapr.project.controller.ReviewApplicationController;
import lapr.project.model.Application;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;

/**
 *
 * @author MariaJoão
 */
public class ReviewApplicationUI {
    
    ReviewApplicationController controller;
    
    public ReviewApplicationUI(ExhibitionCentre centre){
        this.controller= new ReviewApplicationController(centre);
        chooseEvent(); 
        chooseApplication();
        int staffTopicKnowledge= makeReview("Topic on Knowledge (0 to 5)");
        int eventAdequacy= makeReview("Event Adequacy (0 to 5)");
        int inviteAdequacy= makeReview("Invite Adequacy (0 to 5)");
        int areaAdequacy= makeReview("Area Adequacy  (0 to 5)");
        int recommendation= makeReview("Recommendation (0 to 5)");
        
        boolean decision=getDecision();
                String resposta="";
        while(!"y".equalsIgnoreCase(resposta) && !"c".equalsIgnoreCase(resposta)){
            resposta=UtilsUI.readLineFromConsole("DO YOU CONFIRM THIS REVIEW? (WRITE 'Y' TO CONFIRM OR 'C' TO CANCEL): ");
            if(!"y".equalsIgnoreCase(resposta) && !"c".equalsIgnoreCase(resposta)){
                UtilsUI.printError("INVALID CHARACTER. PLEASE ANSWER AGAIN.");
            }
        }
        if("c".equalsIgnoreCase(resposta)){
            UtilsUI.printWarning("REVIEW CANCELED");
            new MainMenu(centre);
        }else if("y".equalsIgnoreCase(resposta)){
            controller.setData(staffTopicKnowledge,eventAdequacy, inviteAdequacy, areaAdequacy, recommendation, decision);
            controller.submitReview();
            controller.registerLog();
            UtilsUI.printConfirmation("REVIEW SAVED");
            new MainMenu(centre);        

        }
    }

    private void chooseApplication() {
        String lines2 = "--------------------------";
        int app_number=-1;
        int n=0;
        while(app_number==-1){
                UtilsUI.printLine(lines2);
                UtilsUI.printLine("     YOUR APPLICATIONS    ");
                UtilsUI.printLine(lines2);
                n=0;
                for (Application a : controller.getStaffApplications()) {
                        UtilsUI.printLine((n+1)+" - "+a.getDescription());
                        n++;
                    }
                UtilsUI.printLine(lines2);

                try{
                        app_number = Integer.parseInt(UtilsUI.readLineFromConsole("PICK APPLICATION: "));
                        if(app_number <0 || app_number>n){
                            UtilsUI.printError("NUMBER INSERTED NOT VALID. INSERT NUMBER INSIDE LIMITS. PLEASE TRY AGAIN.");
                            app_number=-1;                            
                        }else{
                           controller.setApplication(app_number-1);
                       }    
                        }catch(NumberFormatException e){

                        UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
                        app_number=-1;                            

                    }           
        }     }

    private void chooseEvent() {
        String lines2 = "--------------------------";
        int event_number=-1;
        int n=0;
        while(event_number==-1){
                n=0;
                UtilsUI.printLine(lines2);
                UtilsUI.printLine("          EVENTS          ");
                UtilsUI.printLine(lines2);

                for (Event e : controller.getEvents()) {
                        UtilsUI.printLine((n+1)+" - "+e.getTitle());
                        n++;
                    }
                UtilsUI.printLine(lines2);

                try{
                        event_number = Integer.parseInt(UtilsUI.readLineFromConsole("PICK EVENT: "));
                        if(event_number <0 || event_number>n){
                            UtilsUI.printError("NUMBER INSERTED NOT VALID. INSERT NUMBER INSIDE LIMITS. PLEASE TRY AGAIN.");
                            event_number=-1;                            
                        }else{
                             controller.setEvent(event_number-1);

                        }    
                        }catch(NumberFormatException e){

                        UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
                        event_number=-1;                            

                    }           
        }     }

    private int makeReview(String field) {
        int param=-1;
        while(param<0 || param>5){
            try{
                param = Integer.parseInt(UtilsUI.readLineFromConsole(field.toUpperCase()+" : "));
                if(param<0 || param>5){
                 UtilsUI.printError("NUMBER INSERTED NOT VALID. INSERT NUMBER BETWEEN 0 AND 5. PLEASE TRY AGAIN.");
                 param=-1;
                }    
                }catch(NumberFormatException e){
                param=-1;
                UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");

            }           
        }
        return param;


    }

    private boolean getDecision() {
        String resposta="", a="a", r="r";
        while(!a.equalsIgnoreCase(resposta) && !r.equalsIgnoreCase(resposta)){
            resposta=UtilsUI.readLineFromConsole("FINAL DECISION (WRITE 'A' TO ACCEPT OR 'R' TO REJECT APPLICATION): ");
            if(!a.equalsIgnoreCase(resposta) && !r.equalsIgnoreCase(resposta)){
                UtilsUI.printError("INVALID CHARACTER. PLEASE ANSWER AGAIN.");
            }
        }
        return a.equals(resposta);
    }

    
    
}

    


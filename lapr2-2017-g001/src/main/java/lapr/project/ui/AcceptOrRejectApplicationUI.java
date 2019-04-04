/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import lapr.project.controller.AcceptOrRejectApplicationController;
import lapr.project.model.Application;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Review;

/**
 *
 * @author MariaJoão
 */

public class AcceptOrRejectApplicationUI {
   
    AcceptOrRejectApplicationController controller;
    String lines = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    String lines2 = "--------------------------";
    public AcceptOrRejectApplicationUI(ExhibitionCentre centre){
        this.controller= new AcceptOrRejectApplicationController(centre);
        if(!chooseEvent(centre)){
            new MainMenu(centre);
        }else{ 
        if(!chooseApplication(centre)){
            new MainMenu(centre);
            
        }else{
        decision(centre);
            
        }        
        }
    }

    private boolean chooseEvent(ExhibitionCentre centre) {
        int event_number=-1;
        int n=0;
        while(event_number==-1){
                UtilsUI.printLine(lines2);
                UtilsUI.printLine("          EVENTS          ");
                UtilsUI.printLine(lines2);

                for (Event e : controller.getEventsFromUser()) {
                        UtilsUI.printLine((n+1)+" - "+e.getTitle());
                        n++;
                    }
                UtilsUI.printLine((n+1)+" - GO BACK");
                UtilsUI.printLine(lines2);

                try{
                        event_number = Integer.parseInt(UtilsUI.readLineFromConsole("PICK EVENT: "));
                        if(event_number==(n+1)){
                                return false;

                        }else{
                            controller.setEvent(event_number-1);
                        }
                        if(event_number <1 || event_number>n){
                            UtilsUI.printError("NUMBER INSERTED NOT VALID. INSERT NUMBER INSIDE LIMITS. PLEASE TRY AGAIN.");
                            event_number=-1;                            
                        }    
                        }catch(NumberFormatException e){

                        UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
                        event_number=-1;                            

                    }           
        }
        return true;
    }

    private boolean chooseApplication(ExhibitionCentre centre) {
        String lines3 = "-------------------------------------------";
        int app_number=-1;
        int n=0;
        while(app_number==-1){
                UtilsUI.printLine(lines3);
                UtilsUI.printLine("       APPLICATIONS FROM "+controller.getEvent().getTitle()+"      ");
                UtilsUI.printLine(lines3);

                for (Application a : controller.getApplicationsFromEvent()) {
                        UtilsUI.printLine((n+1)+" - "+a.getDescription());
                        n++;
                    }
                UtilsUI.printLine((n+1)+" - GO BACK");
                UtilsUI.printLine(lines3);

                try{
                    app_number = Integer.parseInt(UtilsUI.readLineFromConsole("PICK APPLICATION: "));

                    if(app_number==(n+1)){
                                return false;

                        }else{
                        controller.setApplication(app_number-1);
                    }
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

    private void decision(ExhibitionCentre centre) {
        listReviews();
        String resposta1="";
        UtilsUI.printLine(lines2);
        while(!"a".equalsIgnoreCase(resposta1) && !"r".equalsIgnoreCase(resposta1)){
            resposta1=UtilsUI.readLineFromConsole("DO YOU WISH TO ACCEPT OR REJECT THIS APPLICATION? (WRITE 'A' TO ACCEPT OR 'R' TO REJECT): ");
            if(!"a".equalsIgnoreCase(resposta1) && !"r".equalsIgnoreCase(resposta1)){
                UtilsUI.printError("INVALID CHARACTER. PLEASE ANSWER AGAIN.");
            }
        }
        
        if("a".equalsIgnoreCase(resposta1)){
            if(controller.registerDecision("ACCEPTED")){
                UtilsUI.printConfirmation("APPLICATION ACCEPTED");
                new MainMenu(centre);
            }else{
                UtilsUI.printError("AN ERROR HAS OCCOURED. WITHDRAW FAILED.");
                new MainMenu(centre);
            }
        }else{
            if(controller.registerDecision("REJECTED")){
                UtilsUI.printConfirmation("APPLICATION REJECTED");
                new MainMenu(centre);
            }else{
                UtilsUI.printError("AN ERROR HAS OCCOURED. WITHDRAW FAILED.");
                new MainMenu(centre);
            }            
        }
    }

    private void listReviews() {
        for (Review r : controller.getApplication().getListReview()) {
            UtilsUI.printLine(lines2);
            UtilsUI.printLine("REVIEW FROM "+r.getAssignedStaffMember().getStaff().getUsername());
            UtilsUI.printLine(lines2);
            UtilsUI.printLine("EVENT ADEQUACY: "+r.getEventAdequacy());
            UtilsUI.printLine("AREA ADEQUACY: "+r.getAreaAdequacy());
            UtilsUI.printLine("INVITE ADEQUACY: "+r.getInviteAdequacy());
            UtilsUI.printLine("KNOWLEGE ON TOPIC: "+r.getStaffTopicKnowledge());
            UtilsUI.printLine("RECOMENDATION: "+r.getRecommendation());
            UtilsUI.printLine("DECISION: "+r.getDecision());

        }
    }
}

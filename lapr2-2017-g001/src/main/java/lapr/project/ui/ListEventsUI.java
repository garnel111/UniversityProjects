/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import lapr.project.controller.ListEventsController;
import lapr.project.model.Application;
import lapr.project.model.ApplicationState;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Keyword;

/**
 *
 * @author MariaJoão
 */
public class ListEventsUI {
   
    ListEventsController controller; 
    public ListEventsUI(ExhibitionCentre centre, String state){
        this.controller= new ListEventsController(centre);
        boolean answer=false;
        switch(state){
            case "SUBMITTED":
                controller.setState(ApplicationState.CREATED);
                break;
            case "REVIEW-PENDING":
                controller.setState(ApplicationState.IN_EVALUALTION);
                break;
            case "ACCEPTED":
                controller.setState(ApplicationState.ACCEPTED);
                break;
            case "REJECTED":
                controller.setState(ApplicationState.REJECTED);
                break;                
                
        }
        String event;   
        String lines = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
        String lines2 = "--------------------------";
        String lines3 = "-------------------------------------------------------------------";
        int event_index = 0;
        UtilsUI.printLine("");        
        UtilsUI.printLine(lines);  
        UtilsUI.printLine("      LIST EVENT'S "+state.toUpperCase()+" APPLICATIONS       ");
        UtilsUI.printLine(lines);  
        
        while(!answer){

            int n=1;
            UtilsUI.printLine(lines2);
            UtilsUI.printLine("       YOUR EVENTS        ");
            UtilsUI.printLine(lines2);

            for (Event e : controller.getEventsFromUser()) {
                UtilsUI.printLine(n+" - "+e.getTitle());
                n++;
            }
            UtilsUI.printLine(lines2);

            event=UtilsUI.readLineFromConsole("PICK EVENT: ");
            try{
                event_index= Integer.parseInt(event);
                if(event_index>0 && event_index<=controller.getEventsFromUser().size()){
                    answer=true;
                }else{
                    UtilsUI.printError("NUMBER OUT OF BOUNDARIES. PLEASE TRY AGAIN.");
                }
            }catch(NumberFormatException e){
                    UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
                    answer=false;    
            }   

        }
        controller.eventPicked(event_index-1);
        UtilsUI.printLine(lines3);

        UtilsUI.printLine("     "+state.toUpperCase()+" APPLICATIONS OF "+controller.getEvent().getTitle()+"      ");
        UtilsUI.printLine(lines3);
        
        for (Application a : controller.getEvent().getEventApplicationByState(controller.getState())) {
            UtilsUI.printLine("APLICATION: "+a.getDescription());
            UtilsUI.printLine("        WANTED BOOTH AREA: "+a.getBoothArea()+"m2");
            UtilsUI.printLine("        NUMBER OF INVITES: "+a.getNumberInvites());
            UtilsUI.printLine("        KEYWORDS: ");

            for (Keyword k : a.getKeywordList()) {
                UtilsUI.printLine("              "+k.getValue()+"; ");
            }
            UtilsUI.printLine("");
        }
        controller.registerLog();
        UtilsUI.readLineFromConsole("PRESS ENTER TO GO BACK TO MAIN MENU: ");
        new MainMenu(centre);
    }
    
}

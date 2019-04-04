/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import lapr.project.controller.EventAcceptanceRateController;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;

/**
 *
 * @author MariaJoão
 */
public class EventAcceptanceRateUI {
    
    
    EventAcceptanceRateController controller;
    
    public EventAcceptanceRateUI(ExhibitionCentre centre){
        
        this.controller= new EventAcceptanceRateController(centre);
        choseEvent(); 
        double rate= controller.acceptanceRate();
        UtilsUI.printLine("ACCEPTANCE RATE OF "+controller.getEvent().getTitle()+" IS: "+String.format("%.2f", rate)+"%");
        controller.registerLog();
        UtilsUI.readLineFromConsole("PRESS ENTER TO GO BACK TO MAIN MENU: ");
        new MainMenu(centre);
    }

    private void choseEvent() {
        String lines = "--------------------------";
        int event_number=-1;
        int n=0;
        while(event_number==-1){
            n=0;
                UtilsUI.printLine(lines);
                UtilsUI.printLine("          EVENTS          ");
                UtilsUI.printLine(lines);

                for (Event e : controller.getEvents()) {
                        UtilsUI.printLine((n+1)+" - "+e.getTitle());
                        n++;
                    }
                UtilsUI.printLine(lines);

                try{
                        event_number = Integer.parseInt(UtilsUI.readLineFromConsole("PICK EVENT: "));
                        controller.setEvent(event_number-1);
                        if(event_number <1 || event_number>n){
                            UtilsUI.printError("NUMBER INSERTED NOT VALID. INSERT NUMBER INSIDE LIMITS. PLEASE TRY AGAIN.");
                            event_number=-1;                            
                        }    
                        }catch(NumberFormatException e){

                        UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
                        event_number=-1;                            

                    }           
        }     }
    
}

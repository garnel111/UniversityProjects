/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;


import lapr.project.controller.StartSubmissionPeriodController;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;

/**
 *
 * @author André Silva
 */
public class StartSubmissionPeriodUI {
    
    StartSubmissionPeriodController controller;
    int n = 1;
    
    public StartSubmissionPeriodUI(ExhibitionCentre exhibitionCentre){
        String event_selected_string = ""; 
        String lines = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
        String lines2 = "--------------------------";
        int event_selected = 0;
        boolean right=false;
        this.controller = new StartSubmissionPeriodController(exhibitionCentre);
        UtilsUI.printLine(lines);  
        UtilsUI.printLine("           START EVENT'S APPLICATION SUBMISSION PERIOD           ");
        UtilsUI.printLine(lines);  
        while(!right){
                UtilsUI.printLine(lines2);
                UtilsUI.printLine("          EVENTS          ");
                UtilsUI.printLine(lines2);
                UtilsUI.printLine("EVENTS OF "+exhibitionCentre.getUserOnline().getName());


                for (Event event : controller.findEventByOrganiserAndState(exhibitionCentre.getUserOnline())) {
                    System.out.println(n + " - "+event.toString2());
                    n++;
                }
                UtilsUI.printLine(n+ " - GO BACK");
                System.out.println(lines2);
                event_selected_string=UtilsUI.readLineFromConsole("PICK EVENNT: ");
                if(event_selected_string.equalsIgnoreCase(String.valueOf(n))){
                    new MainMenu(exhibitionCentre);
                }else{
                            try{
                                event_selected= Integer.parseInt(event_selected_string);
                                if(event_selected>n || event_selected<1){
                                    UtilsUI.printError("NUMBER OUT OF BOUNDARIES. PLEASE TRY AGAIN.");
                                 n=1;   
                                }else{
                                    right=true;
                                }
                            }catch(NumberFormatException e){
                              UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
                              n=1;  
                            }
                    }
                    if(controller.changeStateEventToSubmission(event_selected-1)){
                        UtilsUI.printConfirmation("SUBMISSION PERIOD OPEN");
                        controller.registerLog();
                    }else{
                        UtilsUI.printError("IT WAS NOT POSSIBLE TO OPEN SUBMISSIN PERIOD");
                    }
                        new MainMenu(exhibitionCentre);
        }
    }
}

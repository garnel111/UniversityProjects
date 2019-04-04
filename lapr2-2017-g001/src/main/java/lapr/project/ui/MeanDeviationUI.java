/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.List;
import lapr.project.controller.MeanDeviationController;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.User;

/**
 *
 * @author JM
 */
public class MeanDeviationUI {
    
    private MeanDeviationController controller;
    
    public MeanDeviationUI (ExhibitionCentre exhibitionCentre){
        this.controller = new MeanDeviationController(exhibitionCentre);
        String selection = "";
        String selection2 = "";
        String lines = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";

        //Request selection of employee
        UtilsUI.printLine("");
        UtilsUI.printLine(lines);
        UtilsUI.printLine("        Mean Deviation Calculation        ");
        UtilsUI.printLine(lines);

        //Apresentar employees
        UtilsUI.printLine("STAFF MEMBERS:");
        List<User> employees = controller.getStaffList();
        for (User u : employees) {
            UtilsUI.printLine("username: "+u.getUsername()+" -- Name: "+u.getName());
        }

        //Seleccionar employee
        UtilsUI.printLine("SELECT STAFF MEMBER USERNAME ('Q' TO QUIT)");
        selection = UtilsUI.readLineFromConsole("USERNAME: ");

        while (!controller.staffExists(selection) && (!"Q".equalsIgnoreCase(selection))) {
            UtilsUI.printError("STAFF MEMBER NOT FOUND!\nPLEASE TRY AGAIN");
            UtilsUI.printLine("STAFF MEMBER:");
            for (User u : employees) {
            UtilsUI.printLine("username: "+u.getUsername()+" -- Name: "+u.getName());
            }

            //Seleccionar employee
            UtilsUI.printLine("SELECT STAFF MEMBER USERNAME ('Q' TO QUIT)");
            selection = UtilsUI.readLineFromConsole("USERNAME: ");
        }
        
        
        //Apresentar eventos
        UtilsUI.printLine("\nEVENTS:");
        List<Event> events = controller.getEvents(selection);
        for (Event e : events) {
            UtilsUI.printLine("event:: "+e.getTitle());
        }

        //Seleccionar evento
        UtilsUI.printLine("SELECT EVENT TITLE ('Q' TO QUIT)");
        selection2 = UtilsUI.readLineFromConsole("TITLE: ");

        while (!controller.eventExists(selection2, selection) && (!"Q".equalsIgnoreCase(selection2))) {
            UtilsUI.printError("EVENT NOT FOUND!\nPLEASE TRY AGAIN");
            UtilsUI.printLine("EVENT:");
            for (Event e : events) {
            UtilsUI.printLine("event: "+e.getTitle());
            }

            //Seleccionar employee
            UtilsUI.printLine("SELECT EVENT TITLE ('Q' TO QUIT)");
            selection2 = UtilsUI.readLineFromConsole("TITLE: ");
        }
        
        
        if (!"Q".equalsIgnoreCase(selection2)) {

            //Staff e evento seleccionados e encontrados
            //Calcular
            double mean = controller.calcMeanDev(selection, selection2);
            UtilsUI.printLine("STAFF MEMBER: " + controller.findUser(selection).getName() +"\n" + 
                    controller.findEvent(selection2).getTitle() + String.format("  -->  MEAN DEVITION: %.2f",mean));
        }
        
        UtilsUI.readLineFromConsole("CLICK ENTER TO GO BACK TO MAIN MENU");
        new MainMenu(exhibitionCentre); 
        
    }
    
    
}

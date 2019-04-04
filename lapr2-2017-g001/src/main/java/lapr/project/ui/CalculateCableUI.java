/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.StandConnection;
import lapr.project.controller.CalculateCableController;

/**
 *
 * @author JM
 */
public class CalculateCableUI {

    private CalculateCableController controller;

    public CalculateCableUI(ExhibitionCentre exhibitionCentre) {
        this.controller = new CalculateCableController(exhibitionCentre);
        String selection = "";
        String lines = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";

        //Request selection of event
        UtilsUI.printLine("");
        UtilsUI.printLine(lines);
        UtilsUI.printLine("        Electrical Cable Calculation        ");
        UtilsUI.printLine(lines);

        //Apresentar eventos
        UtilsUI.printLine("EVENTS:");
        List<Event> events = controller.getEventList();
        for (Event ev : events) {
            UtilsUI.printLine(ev.getTitle());
        }

        //Selecctionar evento
        UtilsUI.printLine("SELECT EVENT ('Q' TO QUIT)");
        selection = UtilsUI.readLineFromConsole("EVENT TITLE: ");

        while (!controller.eventExists(selection) && (!selection.equalsIgnoreCase("Q"))) {
            UtilsUI.printError("EVENT NOT FOUND!\nPLEASE TRY AGAIN");
            UtilsUI.printLine("EVENTS:");
            for (Event ev : events) {
                UtilsUI.printLine(ev.getTitle());
            }

            //Seleccionar evento
            UtilsUI.printLine("SELECT EVENT ('Q' TO QUIT)");
            selection = UtilsUI.readLineFromConsole("EVENT TITLE: ");
        }
        
        if(!controller.hasStands(controller.findEvent(selection))){
            UtilsUI.printError("THE EVENT SELECTED HAS NO STANDS!");
            new InitialMenuUI(exhibitionCentre);
        }

        if ((!selection.equalsIgnoreCase("Q"))&&(controller.hasStands(controller.findEvent(selection)))) {

            //Evento seleccionado e encontrado
            //Calcular
            ArrayList<StandConnection> tree = new ArrayList<>(controller.calcPath(selection));
            double length = controller.calcLength(selection);

            for (StandConnection connect : tree) {
               UtilsUI.printLine(connect.toString());
            }
            UtilsUI.printLine("Total: " + length + " meters");
            controller.registerLog(selection);
         }
        UtilsUI.readLineFromConsole("PRESS ENTER TO GO BACK TO MAIN MENU");
        new InitialMenuUI(exhibitionCentre);

    }

}

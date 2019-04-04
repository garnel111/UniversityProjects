/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.List;
import lapr.project.controller.MeanRatingController;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.User;

/**
 *
 * @author JM
 */
public class MeanRatingUI {
    
    private MeanRatingController controller;
    
    public MeanRatingUI (ExhibitionCentre exhibitionCentre){
        this.controller = new MeanRatingController(exhibitionCentre);
        String selection = "";
        String lines = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";

        //Request selection of employee
        UtilsUI.printLine("");
        UtilsUI.printLine(lines);
        UtilsUI.printLine("        Mean Rating Calculation        ");
        UtilsUI.printLine(lines);
        int i=0;
        int selected_staff=-1;
        while(selected_staff==-1){
            UtilsUI.printLine("STAFF MEMBERS:");
            List<User> employees = controller.getStaffList();
            for (User u : employees) {
                UtilsUI.printLine((i+1)+"- username: "+u.getUsername()+" -- Name: "+u.getName());
                i++;
            }
        UtilsUI.printLine("SELECT STAFF MEMBER USERNAME ('Q' TO QUIT)");
        try{
             selected_staff = Integer.parseInt(UtilsUI.readLineFromConsole("STAFF MEMBER: "));
             if(selected_staff <1 || selected_staff>(i)){
               UtilsUI.printError("NUMBER INSERTED NOT VALID. INSERT NUMBER INSIDE LIMITS. PLEASE TRY AGAIN.");
               i=0;
               selected_staff=-1;
             }else{
               controller.staffPosition(selected_staff-1);
               double mean = controller.calcMeanRating(controller.getUsername((selected_staff-1)));
               UtilsUI.printLine("STAFF MEMBER: " + controller.findUser(controller.getUsername(selected_staff-1)).getName() + String.format("  -->  MEAN RATING: %.2f",mean));
             }    
        }catch(NumberFormatException e){
            if ("Q".equalsIgnoreCase(selection)) {
             UtilsUI.printWarning("CALCULATION CANCELED");
            }else{
            UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
            i=0;
               selected_staff=-1;

            }
        }
                          
        }
        
        UtilsUI.readLineFromConsole("PRESS ENTER TO GO BACK TO MENU");
        
        new MainMenu(exhibitionCentre); 
        
    }
    
    
}

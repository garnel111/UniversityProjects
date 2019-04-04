/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import lapr.project.model.ExhibitionCentre;
import lapr.project.utils.Utils;

/**
 *
 * @author MariaJoão
 */
public class InitialMenuUI {
    private ExhibitionCentre centre;
    
    public InitialMenuUI(ExhibitionCentre centre){
        String lines = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
     
        String opt;
        this.centre=centre;
        UtilsUI.printLine(lines);
        UtilsUI.printLine("             WELLCOME            ");
        UtilsUI.printLine(lines);
        
     
        
        UtilsUI.printLine("             1.LOGIN             ");
        UtilsUI.printLine("            2.REGISTER           ");
        UtilsUI.printLine(lines);
      
        opt = UtilsUI.readLineFromConsole("INSERT OPTION: ");
        switch(Integer.parseInt(opt)){
         
            case 1:
                new LoginUI(centre);    
            break;  
             case 2:
                 new UserRegistrationUI(centre);
            break; 
        }
    }
}

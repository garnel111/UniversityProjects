/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;
import lapr.project.controller.LoginController;
import lapr.project.model.ExhibitionCentre;

/**
 *
 * @author MariaJoão
 */
public class LoginUI {
    
    LoginController controller;
    public LoginUI(ExhibitionCentre centre){
        String lines = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";

        this.controller = new LoginController(centre);
        Console console = System.console();
        Scanner scanner = new Scanner(System.in);

        String username = "";
        String passwordString=new String();
        char[] password;
        boolean accepted=false;
       while(!accepted){
        //Request user data
        UtilsUI.printLine("");
        UtilsUI.printLine(lines);
        UtilsUI.printLine("           USER LOGIN        ");
        UtilsUI.printLine(lines);

        username = UtilsUI.readLineFromConsole("USERNAME: ");
        if (console != null) {
            password = console.readPassword("PASSWORD: ");
            passwordString= new String(password);
            Arrays.fill(password, ' ');
        }else{
            passwordString = UtilsUI.readLineFromConsole("PASSWORD: ");
            
        }

        if(!controller.login(username, passwordString)){
            UtilsUI.printError("USERNAME OR PASSOWORD ARE WRONG. PLEASE TRY AGAIN");
            
        }else{
            accepted=true;
            controller.registerLog(username);
            new MainMenu(centre);
        }
        
       }
    }    
}

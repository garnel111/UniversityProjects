/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import lapr.project.controller.UserRegistrationController;
import lapr.project.model.ExhibitionCentre;

/**
 *
 * @author JM
 */
public class UserRegistrationUI {

    private UserRegistrationController controller;

    /**
     * Constructor
     * @param exhibitionCentre Exhibition centre
     */
    public UserRegistrationUI(ExhibitionCentre exhibitionCentre) {
        this.controller = new UserRegistrationController(exhibitionCentre);
        String lines = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";

        String name;
        String email;
        String username;
        String passwordString;

        //Request user data
        UtilsUI.printLine("");
        UtilsUI.printLine(lines);
        UtilsUI.printLine("        USER REGISTRATION        ");
        UtilsUI.printLine(lines);

        name = UtilsUI.readLineFromConsole("NAME: ");
        email = UtilsUI.readLineFromConsole("EMAIL: ");
        username = UtilsUI.readLineFromConsole("USERNAME: ");
        passwordString = UtilsUI.readLineFromConsole("PASSWORD: ");

        while (!controller.isName(name)) {
            UtilsUI.printError("The name inserted is not valid!\nPlease try again.");
            name = UtilsUI.readLineFromConsole("NAME: ");
        }

        while (!controller.isEmail(email)) {
            UtilsUI.printError("The email inserted is not valid!\nPlease try again.");
            email = UtilsUI.readLineFromConsole("EMAIL: ");
        }

        while (!controller.isUsername(username)) {
            UtilsUI.printError("The username inserted is not valid!\nPlease try again.");
            username = UtilsUI.readLineFromConsole("USERNAME: ");
        }

        while (!controller.isPassword(passwordString)) {
            UtilsUI.printError("The password inserted is not valid!\nPlease try again.");
            passwordString = UtilsUI.readLineFromConsole("PASSWORD: ");
        }

        controller.setData(name, email, username, passwordString);

        if (controller.addUser()) {
            //confirma sucesso
            UtilsUI.printConfirmation("User registered!");
            controller.registerLog(username);
        } else {
            UtilsUI.printError("User registration failed!");
        }

        new InitialMenuUI(exhibitionCentre);

    }

}

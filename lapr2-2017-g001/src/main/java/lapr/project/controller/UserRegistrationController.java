/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Role;
import lapr.project.model.User;
import static lapr.project.utils.PasswordEncryption.encryptPassword;
import lapr.project.utils.Utils;

/**
 *
 * @author JM
 */
public class UserRegistrationController {

    private ExhibitionCentre exhibitionCentre;
    private User user;

    /**
     * Constructor
     *
     * @param exhibitionCentre Exhibition centre in use, introduced as parameter
     */
    public UserRegistrationController(ExhibitionCentre exhibitionCentre) {
        this.exhibitionCentre = exhibitionCentre;
        this.user = new User();
    }

    /**
     * Method to store/modify data
     *
     * @param name Name to be stored in the User
     * @param email Email to be stored in the User
     * @param username Username to be stored in the User
     * @param password Password to be stored in the User
     */
    public void setData(String name, String email, String username, String password) {
        this.user.setName(name);
        this.user.setEmail(email);
        this.user.setUsername(username);
        this.user.setPassword(encryptPassword(password));
        this.user.setRole(Role.PARTICIPANT);
    }

    /**
     * Method to add the current user to the User list in the exhibition centre
     *
     * @return a boolean value defining if the user was successfully added to
     * the register
     */
    public boolean addUser() {
        return this.exhibitionCentre.getUserRegister().addUser(this.user);
    }

    /**
     * Method to return the current user
     *
     * @return The user stored
     */
    public User getUser() {
        return user;
    }

    /**
     * Method to verify if the String name is valid (only letters and spaces)
     *
     * @param name String to verify
     * @return boolean value defining the string as valid or not
     */
    public boolean isName(String name) {
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method to verify if the String email is valid (one "@", valid email and
     * server)
     *
     * @param email String with the email adress to verify
     * @return boolean value defining the string as valid or not
     */
    public boolean isEmail(String email) {
        if (!email.contains("@")) {
            return false;
        }

        String[] emailSplit = email.split("@");
        if (emailSplit.length != 2) {
            return false;
        }

        if (!emailSplit[1].contains(".")) {
            return false;
        }

        return (!"".equals(emailSplit[0]));

    }

    /**
     * Method to verify if the String username is valid (not empty)
     *
     * @param username string to verify
     * @return boolean value defining the string as valid or not
     */
    public boolean isUsername(String username) {

        if (username.equals("")) {
            return false;
        }

        return true;
    }

    /**
     * Method to verify if the String password is valid (only digits and >=8)
     *
     * @param passString string with the inserted password
     * @return boolean value defining the password as valid or not
     */
    public boolean isPassword(String passString) {
        int n = 0;
        int dif = 0;
        char[] chars = passString.toCharArray();
        for (char c : chars) {
            n++;
            if (!Character.isDigit(c)) {
                return false;
            }
            if (chars[0] != c) {
                dif++;
            }
        }
        //8 dígitos
        if (n != 8) {
            return false;
        }
        //não podem ser todos iguais
        if (dif == 0) {
            return false;
        }
        return true;
    }

    /**
     * Method to write to the log the User registration
     *
     * @param username Username of the registered user
     */
    public void registerLog(String username) {
        Utils.writeLog(username + " Registered;", "logs");
    }
}

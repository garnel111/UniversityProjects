/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.data.UserDB;
import lapr.project.model.User;

/**
 * @author mjdg1
 */
public class LoginController {

    String mail;
    String password;
    UserDB userDB;

    /**
     * @param mail as a String Mail
     * @param password as a String pass
     * @param userDB as a UserDB
     */
    public LoginController(String mail, String password, UserDB userDB) {
        this.mail = mail;
        this.password = password;
        this.userDB = userDB;
    }
    /**
     * @param pass as a String password
     * @param eMail as a String Email
     */
    public LoginController(String pass, String eMail) {
        this.password = pass;
        this.mail = eMail;

    }

    /**
     * @return a UserDB
     */
    public UserDB getUserDB() {
        return userDB;
    }

    public void setUserDB(UserDB userDB) {
        this.userDB = userDB;
    }

    User user;
    // User userToLog = new User(mail,  password);
    String stringWarnning = "Error on mail";

    /**
     * LoginController construtor without paramethers
     */
    public LoginController() {
        userDB = new UserDB();
        user = new User();

    }



    void setUserDataBase(UserDB udb) {

        this.userDB = udb;
    }

    /**
     * @param password as a String pass
     * @param mail as a String Mail
     * @return a User
     */
    public User getUSerByMailAndPass(String password, String mail) {
        UserDB userDBBeforeLogged = new UserDB();
        User userLogged = userDBBeforeLogged.getUserByMailAndPass(password, mail);
        if (userLogged != null) {
            setUser(userLogged);
            return userLogged;
        } else {
            throw new IllegalArgumentException("");
        }
    }

    public String getMail() {

        return mail;
    }


    /**
     * @return a User
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user  as a User
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @param mail as a String mail
     */
    public void setUserEmail(String mail) {
        this.mail = mail;
    }

    /**
     * @param pass as a String password
     */
    void setUserPass(String pass) {
        this.password = pass;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.Objects;

/**
 *
 * @author MariaJoão
 */
public class User {

    private String name;
    private String email;
    private String username;
    private double password;
    private Role role;
    /**
     * Constructor
     *
     * @param name Name to be stored in the User
     * @param email Email to be stored in the User
     * @param username Username to be stored in the User
     * @param password Password to be stored in the User
     * @param role
     */
    public User(String name, String email, String username, double password, Role role) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role=role;
    }
    public User(String name, String email, String username, double password) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    /**
     * Empty constructor
     */
    public User() {

    }

    /**
     * Copy constructor
     *
     * @param otherUser User to be copied
     */
    public User(User otherUser) {
        this.email = otherUser.email;
        this.name = otherUser.name;
        this.password = otherUser.password;
        this.username = otherUser.username;
        this.role=otherUser.role;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public double getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(double password) {
        this.password = password;
    }

    /**
     * Method to compare 2 Users using the attributes
     *
     * @param otherObject
     * @return boolean value indicating if the users match
     */
    @Override
    public boolean equals(Object otherObject) {
        if(this == otherObject){
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass())  {
            return false;
        }
        User user = (User) otherObject;
        return (user.email.equals(this.email) && user.name.equals(this.name) && Double.compare(user.password, this.password)==0 && user.username.equals(this.username));
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + Objects.hashCode(this.email);
        hash = 83 * hash + Objects.hashCode(this.username);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.password) ^ (Double.doubleToLongBits(this.password) >>> 32));
        hash = 83 * hash + Objects.hashCode(this.role);
        return hash;
    }

    
    @Override
    public String toString() {
        return "User:{" + "name=" + name + ", email=" + email + ", username=" + username + ", password=" + password + '}';
    }

    /**
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(Role role) {
        this.role = role;
    }

}

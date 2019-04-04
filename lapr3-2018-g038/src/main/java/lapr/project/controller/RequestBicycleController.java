/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.sql.SQLException;
import lapr.project.data.BicycleDB;
import lapr.project.model.*;
/**
 *
 * @author Vitor Paiva
 */
public class RequestBicycleController {

    User user;
    BicycleDB requestbicycleDB;
    String bicycletype;
    Park park;
    long getBicycle = 0;

    /**
     * RequestBicycleController construtor whith no parametheres
     */
    public RequestBicycleController() {
        
        requestbicycleDB = new BicycleDB();
        park = new Park();
        
    }

    /**
     * @param user  as a User
     * @param park as a PArk
     * @param bikeType as a bike biketype
     */
      public RequestBicycleController(User user, Park park, String bikeType) {
        this.user =  user;
        requestbicycleDB = new BicycleDB();
        this.park = park;
        this.bicycletype=bikeType;
    }


    /**
     * @param user as a User
     * @param park as a Park
     * @param bicycletype as the type of the bicycle
     * @return the user request bicycle
     * @throws ClassNotFoundException
     * @throws SQLException
     */
     public long requestBicycle(User user,Park park,String bicycletype) throws ClassNotFoundException, SQLException{
                   
             getBicycle = requestbicycleDB.UserRequestBicycle(park, bicycletype, user);
            return getBicycle;
        }

    /**
     * @return a USer
     */
    public User getUser() {
            return  user;                 
    }

    /**
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @param requestbicycleDB
     */
    public void setRequestbicycleDB(BicycleDB requestbicycleDB) {
        this.requestbicycleDB = requestbicycleDB;
    }

    /**
     * @return the  bicycle type in a String
     */
    public String getBicycletype() {
        return bicycletype;
    }

    /**
     * @param bicycletype  as a string bicycletype
     */
    public void setBicycletype(String bicycletype) {
        this.bicycletype = bicycletype;
    }

    /**
     * @return a Park object
     */
    public Park getPark() {
        return park;
    }

    /**
     * @param park as a PArk object
     */
    public void setPark(Park park) {
        this.park = park;
    }
     
     
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import javafx.util.Pair;
import lapr.project.data.*;
import lapr.project.model.*;
import lapr.project.utils.CalcForCalories;
import lapr.project.utils.TripHelper;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author manuel.garnel
 */
public class TripController {

    private TripDb tripDb = new TripDb();
    private ParkDB parkDB = new ParkDB();

    private double mass = 0.00;
    private UserDB userDB = new UserDB();
    AtmosphericConditionsDB atmosphericConditionsDB = new AtmosphericConditionsDB();
    TripHelper tripHelper = new TripHelper();

    User user = new User();
    private BicycleDB bdb;


    public double calculateAmountCalories(double energy) {
        double constantConversion = 4.186;
        return (energy / constantConversion);
    }

    public double getUserMass(User user) {

        double mass = user.getMass(user);
        double value = user.getWeight();
        return mass;
    }

//    public Pair<Park, Park> getParkPair(long trip_Id, User user) {
//        // System.out.println("Get Two parks from database");
//        Pair<Park, Park> parkPair;
//        String parkOrigin = getParkOrigin(trip_Id);
//        String parkDestiny = getParkDestiny(trip_Id);
//
//        parkPair = new Pair<>(tripHelper.getParksPair(parkOrigin, parkDestiny).getKey(), tripHelper.getParksPair(parkOrigin, parkDestiny).getValue());
//        return parkPair;
//
//    }
//
//
//    /*
//     *Calucular a enrgia consumida entre dois parques sem POI
//     */
//
//    public double getEnergyBurnedBetweenTwoParks(long trip_Id, User user, long vrK, long vaK) throws IOException {
//
//        double mass = getUserMass(user);
//        Park origin = getParkPair(trip_Id, user).getKey();
//        Park destiny = getParkPair(trip_Id, user).getValue();
//        double slopeAngle = tripHelper.calculateAngleSlope(origin.getName(), destiny.getName());
//
//        /*
//         * Air drag (PD)
//         * Power with wind
//         */
//
//        /*
//         * getting way direction from dataBase
//         */
//        int wayDirectionWind = atmosphericConditionsDB.getWindWayDirection(origin.getName(), destiny.getName());
//
//        /*
//         * getting velocity on SI unit
//         */
//        double velocity = tripHelper.returnSIUnitVelocity(vrK);
//        double timeOfTrip = CalcForCalories.calculateTimeOfTrip(velocity, tripHelper.getDistanceBetweenParksAndRespectiveAltitudes(origin.getName(), destiny.getName()).getValue());
//
//        double power_PD_UP = tripHelper.totalPowerWithWind(mass, vrK, vaK, wayDirectionWind, slopeAngle);
//
//
//        //System.out.println("power:\t" + power_PD_UP + " W");
//
//        double energyConsumed = CalcForCalories.calculateEnergyConsumed(power_PD_UP, timeOfTrip);
//
//        // System.out.println("Energia Consumida " + energyConsumed + " J");
//        calculateAmountCalories(energyConsumed);
//
//      //  System.out.println("Energia consumida em kcal :" + (calculateAmountCalories(energyConsumed) / 1000) + " kcal");
//
//      //  System.out.println("Potência :" + power_PD_UP + " W");
//        return power_PD_UP;
//    }


    public String getParkOrigin(long trip_Id) {
        Pair<Long, Long> origDestPark = tripDb.getOriginAndDestinyParksIdByTripId(trip_Id);

        long park_Id = origDestPark.getKey();
        String parkOrigin = parkDB.getParkById(park_Id);
        return parkOrigin;
    }

    public String getParkDestiny(long trip_Id) {
        Pair<Long, Long> origDestPark = tripDb.getOriginAndDestinyParksIdByTripId(trip_Id);
        long park_Id = origDestPark.getValue();
        String parkDestiny = parkDB.getParkById(park_Id);
        return parkDestiny;
    }

    public void setTripDb(TripDb tripDb) {
        this.tripDb = tripDb;
    }

    public void setUserDB(UserDB userDbMocked) {
        this.userDB = userDbMocked;
    }

    public void setParkDB(ParkDB parkDB) {
        this.parkDB = parkDB;
    }

    public void setTripHelper(TripHelper trpHelper) {
        this.tripHelper = trpHelper;
    }


    /*
     * US17 -  User returns a bike, the park availability should be updated.
     */

    public boolean updateParkAvailability(Bicycle bicycle, Trip trip, Park destinationPark) throws SQLException {
        return (isBykeNonEletric(bicycle) ? updateNonElectric(bicycle, trip, destinationPark) : updateElectric(bicycle, trip, destinationPark));
    }


    public boolean isBykeNonEletric(Bicycle bicycle) {
        return (!bicycle.getType().equals("Electric"));
    }

    public boolean updateNonElectric(Bicycle bicycle, Trip trip, Park destinationPark) throws SQLException {
        ParkDB parkDB = new ParkDB();
        BicycleDB bDB = new BicycleDB();

        Park parkDestin;
        String namePark = destinationPark.getName();
        parkDestin = parkDB.getParkByName(namePark);
        int counterNonElectricBicycle = bDB.countBikeByType(bicycle.getType(), destinationPark.getName());

        long maxNonElectricCapacity = parkDestin.getMaxCapacityNonEletric();

        return (validateUpdate(counterNonElectricBicycle, maxNonElectricCapacity, parkDB, destinationPark, bicycle));
    }

    public boolean updateElectric(Bicycle bicycle, Trip trip, Park destinationPark) throws SQLException {

        String nameParkA = destinationPark.getName();
        BicycleDB bDB = new BicycleDB();
        ParkDB parkDBA = new ParkDB();

        Park parkDestinA;
        parkDestinA = parkDBA.getParkByName(nameParkA);
        int counterElectricBicycle = bDB.countBikeByType(bicycle.getType(), destinationPark.getName());


        long maxNonElectricCapacity = parkDestinA.getMaxCapacityEletric();
        return (validateUpdate(counterElectricBicycle, maxNonElectricCapacity, parkDBA, destinationPark, bicycle));
    }

    public boolean validateUpdate(int counterNonOrElectricBicycle, long maxNonOrElectricCapacity, ParkDB parkDB, Park destinationPark, Bicycle bicycle) throws SQLException {
        if (counterNonOrElectricBicycle < maxNonOrElectricCapacity) {
            parkDB.updateBicycleOnDestinyPark(destinationPark, bicycle);
            return true;
        }
        return false;
    }


    public void setbDB(BicycleDB bDB) {
        this.bdb = bDB;
    }

    /*
     * calcular tempo viagem entre dois pontos
     */

    public Pair<Long,Long> getEnergyBurnedBetweenTwoPOI(long vrk, long vak, long angulo, String poiOrigin, String poiDestiny) throws IOException {
        double mass = getUserMass(user);
        double slopeAngle = angulo * Math.cos(angulo); // componente tangencial da velocidade do vento
        int wayDirectionWind = 1;
        /*
         * getting velocity on SI unit
         */
        double velocity = tripHelper.returnSIUnitVelocity(vrk);
        double timeOfTrip = CalcForCalories.calculateTimeOfTrip(velocity, tripHelper.getDistanceBetweenPOIAndRespectiveAltitudes(poiOrigin, poiDestiny).getValue());
        long power_PD_UP = (long) tripHelper.totalPowerWithWind(mass, vrk, vak, wayDirectionWind, slopeAngle);
        double energyConsumed = CalcForCalories.calculateEnergyConsumed(power_PD_UP, timeOfTrip);
        calculateAmountCalories(energyConsumed);
        long energiaCalorias = (long) (calculateAmountCalories(energyConsumed) / 1000);
        return new Pair<Long, Long>(power_PD_UP, energiaCalorias);

    }

    public void setUser(User user) {
        this.user = user;
    }
}

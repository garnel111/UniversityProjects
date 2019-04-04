/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lapr.project.data.ParkDB;
import lapr.project.model.Park;
import lapr.project.utils.CalcMethods;

/**
 * @author magal
 */
public class ParkController {

    float userLat;
    float userLong;
    String parkName;
    ParkDB parkDataBase;
    float distance;
    Park parque;

    /**
     * construtor with no paramethers
     */
    public ParkController() {
        parkDataBase = new ParkDB();
        parque = new Park();
    }

    /**
     * @param userLat  as a user Latitude position
     * @param userLong as a user Longitude position
     * @param parkName as a PArk name String
     */
    public ParkController(float userLat, float userLong, String parkName) {
        this.userLat = userLat;
        this.userLong = userLong;
        this.parkName = parkName;
        parkDataBase = new ParkDB();
        parque = new Park();
    }

    /**
     * @param userLat           as a user Latitude position
     * @param userLong          as a user Longitude position
     * @param parkName          as a PArk name String
     * @param maxCapacityElect  as maximum electric capacity
     * @param maxCapacityNElect as maximum Non electric capacity
     * @return
     */
    public boolean addNewPark(float userLat, float userLong, String parkName, long maxCapacityElect, long maxCapacityNElect) {
        Park park = new Park(parkName, userLat, userLong, maxCapacityNElect, maxCapacityElect);
        parkDataBase.newPark(park);
        return true;
    }

    /**
     * @param parkName as a name park String
     * @return a boolean
     */
    public boolean removePark(String parkName) {
        return parkDataBase.removePark(parkName);
    }

    /**
     * @param parkName as a name park String
     * @return float distance  to park
     * @throws IOException
     */
    public float distanceToPark(String parkName) throws IOException {
        parque = parkDataBase.getParkByName(parkName);
        float parkLat = parque.getLatitude();
        float parkLong = parque.getLongitude();
        return (float) CalcMethods.calcDistanceBetweenCoordinates(userLat, userLong, parkLat, parkLong);
    }

    /**
     * @param numOfParks as a number of parks
     * @return a list of nearest parks
     * @throws IOException
     * @throws SQLException
     */
    public List<Map<String, Float>> nearestParks(int numOfParks) throws IOException, SQLException {
        List<String> parkList = parkDataBase.getParkNames();
        List<Map<String, Float>> parkDist = new ArrayList<>();
        List<Map<String, Float>> nearest = new ArrayList<>();

        for (String p : parkList) {
            Map<String, Float> pd = new HashMap<>();
            pd.put(p, distanceToPark(p));
            parkDist.add(pd);
        }

        parkDist = orderByMapValue(parkDist);

        //filter 'numOfParks' closer
        for (int i = 0; i < numOfParks; i++) {
            if (parkDist.size() > i && parkDist.size() != i) {
                nearest.add(parkDist.get(i));
            }
        }
        return nearest;
    }

    /**
     * @param pdist as a list of distances to the point
     * @return the list<Map<String, Float>>
     */
    public List<Map<String, Float>> orderByMapValue(List<Map<String, Float>> pdist) {
        Collections.sort(pdist, new Comparator<Map<String, Float>>() {
            @Override
            public int compare(Map<String, Float> p1, Map<String, Float> p2) {
                Collection<Float> v1 = p1.values();
                Collection<Float> v2 = p2.values();
                if (!v1.isEmpty() && !v2.isEmpty()) {
                    return v1.iterator().next().compareTo(v2.iterator().next());
                } else {
                    return 0;
                }
            }
        });
        return pdist;
    }

    /**
     * @param parkName as a park name String
     * @return
     */
    public Park getParkByName(String parkName) {
        return parkDataBase.getParkByName(parkName);
    }

    /**
     * @param userLat as a user Latitude
     */
    public void setUserLat(float userLat) {
        this.userLat = userLat;
    }

    /**
     * @param userLong as a user longitude
     */
    public void setUserLong(float userLong) {
        this.userLong = userLong;
    }

    /**
     * @return the user latitude
     */
    public float getUserLat() {
        return userLat;
    }

    /**
     * @return the User longitude
     */
    public float getUserLong() {
        return userLong;
    }

    /**
     * @param parkDataBase tas a parkdatabase objet
     */
    public void setParkDataBase(ParkDB parkDataBase) {
        this.parkDataBase = parkDataBase;
    }

    /**
     * @return the name of the park in a string
     */
    public String getParkName() {
        return parkName;
    }

    public Park getParkByCoordinates(BigDecimal v, BigDecimal v1) throws SQLException {
        return parkDataBase.getParkByCoordinates(v,v1);
    }
}

package lapr.project.controller;

import javafx.util.Pair;
import lapr.project.data.BicycleDB;
import lapr.project.data.ParkDB;
import lapr.project.data.PoiConnectionsDB;
import lapr.project.model.Bicycle;
import lapr.project.model.Park;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import lapr.project.data.AdministratorDB;
import lapr.project.model.Administrator;

public class AdministratorController {

    /**
     * An administrator
     */
    private Administrator admin;

    private AdministratorDB administratorDataBase = new AdministratorDB();
    private ParkDB parkDb = new ParkDB();
    private BicycleDB bicycleDB = new BicycleDB();
    private Park park = new Park();
    private Bicycle bike = new Bicycle();
    boolean result;
    private AdministratorDB administratorDB;

    /*
     *  : Add a Bicycleto a park
     */
    public AdministratorController(ArrayList<String> poiList) {
        this.poiList = poiList;
    }


    /*
     * US_23: Administrator wants to know bearing wind information
     */
    /**
     * @param of a list of points
     */
    private ArrayList<String> poiList = new ArrayList<>();

    /**
     * empty construtor of an AdmnistratorController
     */
    public AdministratorController() {
        administratorDataBase = new AdministratorDB();
        admin = new Administrator();
        parkDb = new ParkDB();
    }

    /**
     * Method that creates a new instance of Administrator and add to data base.
     *
     * @param name
     * @param email
     * @param password
     * @return true if add a new administrator or false if not.
     */
    public boolean newAdministrator(String name, String email, String password) {

        if (!validateAdministrator(email)) {
            Administrator nAdmin = new Administrator(name, email, password);
            return administratorDataBase.newAdministrator(nAdmin);
        }
        return false;
    }

    /**
     * Method that returns the administrator.
     *
     * @param email
     * @return user
     */
    public Administrator getAdministratorByEmail(String email) {
        admin = administratorDataBase.getAdministratorByEmail(email);
        return admin;
    }

    /**
     * Method that verifies if the administrator exists through your email
     *
     * @param email
     * @return true case if user exists or false in case of not exists
     */
    public boolean validateAdministrator(String email) {

        if (administratorDataBase.getAdministratorByEmail(email) != null) {
            return true;
        }
        return false;
    }

    /*
     * US_23: Administrator wants to know bearing wind information
     */

    /**
     * @param poiList as an arraylist of POI(point of interest)
     * @return HashMap<String                                                                                                                               ,                                                                                                                                                                                                                                                               String>
     */
    public TreeMap<String, String> getOriginAndDestinyPairsList(ArrayList<String> poiList) {
        int i = 0;

        TreeMap<String, String> pointsConnectedPairsList = new TreeMap<>();
        for (i = 0; i < poiList.size() - 1; i++) {
            int j = i;
            pointsConnectedPairsList.put(poiList.get(j), poiList.get(j + 1));

        }
        return pointsConnectedPairsList;
    }

    /**
     * @param poiList as an arraylist of POI(point of interest)
     * @return Map<Pair                                                                                                                                                                                                                                                               <                                                                                                                                                                                                                                                               String                                                                                                                                                                                                                                                               ,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               String>, Pair<Pair<Long, Long>, Long>>
     */
    public Map<Pair<String, String>, Pair<Pair<Long, Long>, Long>> poiListFromDataBase(ArrayList<String> poiList) {
        PoiConnectionsDB poiConnectionsDB = new PoiConnectionsDB();
        Map<Pair<String, String>, Pair<Pair<Long, Long>, Long>> valuesFromPoiConnectionTable = new HashMap<>();
        Map<String, String> poiOriginAndDestiny = getOriginAndDestinyPairsList(poiList);
        valuesFromPoiConnectionTable = poiConnectionsDB.getVelAndWind(poiOriginAndDestiny);
        return valuesFromPoiConnectionTable;
    }

    public boolean verifyParkExistence(Park park) {
        ParkDB parkDB = new ParkDB();
         result = parkDB.checkParkExistence(park);
        return result;
    }

    public void setParkDb(ParkDB parkDb) {
        this.parkDb = parkDb;
    }

    /**
     * Set userDataBase to instance.
     *
     * @param administratorDataBase
     */
    public void setAdministratorDataBase(AdministratorDB administratorDataBase) {
        this.administratorDataBase = administratorDataBase;
    }

    public boolean addByciclesOnly(Bicycle bike, Park park) throws SQLException {
        BicycleDB bDB = new BicycleDB();
        ParkDB parkDB = new ParkDB();
        Park parkWithAllParamthers = parkDB.getParkByLatitudeAndLongitudeValues(park.getLatitude(), park.getLongitude());

        bDB.addBicycle(bike.getBicycleMass(), bike.getKm(), bike.getType(), parkWithAllParamthers.getName());
        long bikeId = bDB.getBikeIDbyDescription(bike.getDescription());
        parkDB.updateBicycleOnDestinyPark(park, bike);
        return true;
    }

    public void setBicycleDB(BicycleDB bicycleDB) {
        bicycleDB = bicycleDB;
    }


    public void setPark(Park park12) {
        park =park12;
    }

    public void setBike(Bicycle bike12) {
        bike = bike12;
    }

    public void setAdministratorDB(AdministratorDB administratorDB) {
        this.administratorDB = administratorDataBase;
    }

    public AdministratorDB getAdministratorDB() {
        return administratorDB;
    }
}

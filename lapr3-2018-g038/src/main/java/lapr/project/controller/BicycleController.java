package lapr.project.controller;

import lapr.project.data.BicycleDB;
import lapr.project.data.ParkDB;
import lapr.project.model.Bicycle;
import lapr.project.model.Park;
import lapr.project.model.Trip;

import java.sql.SQLException;

/**
 *
 */
public class BicycleController {

    private Bicycle bicycle;
    private float userLat = 0;
    private float userLong = 0;
    private BicycleDB bDB = null;
    private ParkDB pdb;

    /**
     * @param bicycle
     */
    public BicycleController(Bicycle bicycle) {
        this.bicycle = bicycle;
    }


    /**
     * empty paramethers construtor for BicycleController
     */
    public BicycleController() {
        bDB = new BicycleDB();
        pdb = new ParkDB();
        bicycle = new Bicycle(0.0F, 0.0F, "");
    }

    /**
     * @param b  bicycle
     * @param namePark as a park name String
     * @return boolean
     */
    public boolean addBicycle(Bicycle b, String namePark) {

        pdb = new ParkDB();

        if (b == null || namePark.isEmpty()) {
            return false;
        } else {
            if ("Electric".equals(b.getType())) {
                return validateEletricByke(pdb, b, namePark);

            } else {
                validateNonEletricByke(pdb, b, namePark);
            }
            return false;
        }

    }


    /**
     * @return bicyckeDB
     */
    public BicycleDB getbDB() {
        return bDB;
    }

    /**
     * @param bDB as a bicycledatabase object
     */
    public void setbDB(BicycleDB bDB) {
        this.bDB = bDB;
    }

    /**
     * @param id of the bicycle
     * @return a Bicycle
     */
    public Bicycle getBicycleById(long id) {
        return bicycle;
    }

    /**
     * @param pdb parkdatabase object
     * @param b bicycle object
     * @param namePark
     * @return a boolean
     */
    public boolean validateEletricByke(ParkDB pdb, Bicycle b, String namePark) {
        if (bDB.countBikeByType(b.getType(), namePark) < pdb.getParkByName(namePark).getMaxCapacityElectric()) {
            bDB.addBicycle(b.getBicycleMass(), b.getKm(), b.getType(), namePark);
            return true;
        }
        return false;

    }

    /**
     * @param pdb parkdatabase object
     * @param b bicycle object
     * @param namePark name of the park
     * @return a boolean
     */
    public boolean validateNonEletricByke(ParkDB pdb, Bicycle b, String namePark) {

        if (bDB.countBikeByType(b.getType(), namePark) < pdb.getParkByName(namePark).getMaxCapacityNonEletric()) {
            bDB.addBicycle(b.getBicycleMass(), b.getKm(), b.getType(), namePark);
            return true;
        }
        return false;
    }


    /**
     * @param pdb as a parkDB object
     */
    void setParkDB(ParkDB pdb) {
        this.pdb = pdb;
    }


}

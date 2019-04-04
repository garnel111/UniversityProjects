/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.controller.ParkController;
import lapr.project.data.ParkDB;

import java.util.Objects;

/**
 * @author magal
 */
public class Park {

    /**
     * id, atribute of park
     */
    long id;
    /**
     * admin_id, atribute of park
     */
    long admin_Id;
    /**
     * name, atribute of park
     */
    String name;
    /**
     * latitude, atribute of park
     */
    float latitude;
    /**
     * longitude, atribute of park
     */
    float longitude;
    /**
     * maxCapacityNonEletric, atribute of park
     */
    long maxCapacityNonEletric;
    /**
     * maxCapacityElectric, atribute of park
     */
    long maxCapacityElectric;
    /**
     * slotList, atribute of park
     */


    /**
     * Complete Contructor Park
     *
     * @param name
     * @param latitude
     * @param longitude
     * @param maxCapacityNonElectric
     * @param maxCapacityElectric
     */
    public Park(String name, float latitude, float longitude, long maxCapacityNonElectric, long maxCapacityElectric) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.maxCapacityNonEletric = maxCapacityNonElectric;
        this.maxCapacityElectric = maxCapacityElectric;

    }

    public Park() {
        this.name = "Omissao";
        this.latitude = (float) 0.0000000;
        this.longitude = (float) 0.000000;
        this.maxCapacityNonEletric = 500;
        this.maxCapacityElectric = 500;
    }

    public long getId() {
        return this.id;
    }

    public long getAdmin_Id() {
        return admin_Id;
    }

    public String getName() {
        return name;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public long getMaxCapacityNonEletric() {
        return maxCapacityNonEletric;
    }

    public long getMaxCapacityElectric() {
        return maxCapacityElectric;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAdmin_Id(long admin_Id) {
        this.admin_Id = admin_Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setMaxCapacityNonElectric(long maxCapacityNonEletric) {
        this.maxCapacityNonEletric = maxCapacityNonEletric;
    }

    public void setMaxCapacityElectric(long maxCapacityElectric) {
        this.maxCapacityElectric = maxCapacityElectric;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Float.floatToIntBits(this.latitude);
        hash = 29 * hash + Float.floatToIntBits(this.longitude);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Park other = (Park) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.latitude) != Float.floatToIntBits(other.latitude)) {
            return false;
        }
        if (Float.floatToIntBits(this.longitude) != Float.floatToIntBits(other.longitude)) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }

    public Park getParkByName(String parkOrigin) {
        ParkDB parkDB = new ParkDB();
        return parkDB.getParkByName(parkOrigin);
    }

    public long getMaxCapacityEletric() {
        return maxCapacityElectric;
    }

}

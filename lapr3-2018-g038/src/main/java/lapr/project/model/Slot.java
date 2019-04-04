/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 * @author Thais Farias
 */
public class Slot {

    private int id;
    private long bikeId;
    private long parkId;

    public Slot() {
        //Construtor vazio
    }

    public long getBikeId() {
        return bikeId;
    }

    public long getParkId() {
        return parkId;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }


    public void setBikeId(long bikeId) {
        this.bikeId = bikeId;
    }

    public void setParkId(long id) {
        this.parkId = id;
    }
}

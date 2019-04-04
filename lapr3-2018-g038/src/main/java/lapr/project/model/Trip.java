/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import javafx.util.Pair;
import lapr.project.data.TripDb;

import java.util.Date;

/**
 * @author manuel.garnel
 */
public class Trip {

    long userId = 0;
    long request_Id = 0;
    long bicycle_Id = 0;
    long originPark_Id = 0;
    long destinationPark_Id = 0;
    Date startDate = null;
    Date endDate = null;
    long tripId = 0;
    TripDb tripDb = null;

    //Date datestartPorOmissao = 2018-12-12;
//Date dateendPorOmissao = 2018-12-17;
    public Trip() {
    }

    public Trip(long userId, long request_Id, long bicycle_Id, long originalPark_Id, long destinationPark_Id) {

        this.userId = userId;
        this.request_Id = request_Id;
        this.bicycle_Id = bicycle_Id;
        this.originPark_Id = originalPark_Id;
        this.destinationPark_Id = destinationPark_Id;

    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRequest_Id() {
        return request_Id;
    }

    public void setRequest_Id(long request_Id) {
        this.request_Id = request_Id;
    }

    public long getBicycle_Id() {
        return bicycle_Id;
    }

    public void setBicycle_Id(long bicycle_Id) {
        this.bicycle_Id = bicycle_Id;
    }

    public long getOriginPark_Id() {
        return originPark_Id;
    }

    public void setOriginalPark_Id(long originalPark_Id) {
        this.originPark_Id = originalPark_Id;
    }

    public long getDestinationPark_Id() {
        return destinationPark_Id;
    }

    public void setDestinationPark_Id(long destinationPark_Id) {
        this.destinationPark_Id = destinationPark_Id;
    }

    public Pair<Long, Long> getOriginAndDestinyParksById(long trip_Id) {
        Pair<Long, Long> originAndDestinyIDs = tripDb.getOriginAndDestinyParksIdByTripId(trip_Id);
        return (originAndDestinyIDs);
    }

    public long getTripId() {
        return tripId;
    }

    public void setTripId(long tripId) {
        this.tripId = tripId;
    }

    public void setTripDB(TripDb tripDb) {
        this.tripDb = tripDb;
    }
}

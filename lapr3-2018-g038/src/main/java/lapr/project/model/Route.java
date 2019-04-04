/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.data.mapGraph.Graph;

/**
 * @author josemagalhaes
 */
public class Route {

    private long id;
    private long tripId;
    private String type;

    private Graph<Location, String> percurso;


    public Route() {
        this.percurso = new Graph<>(false);
    }

    public Route(long id, long tripId, String type) {
        this.id = id;
        this.tripId = tripId;
        this.type = type;
        this.percurso = new Graph<>(false);
    }

    public void insertLocation(Location loc) {
        percurso.insertVertex(loc);
    }

    public void insertConnection(Location origem, Location destino, String info, double dist) {
        percurso.insertEdge(origem, destino, info, dist);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTripId() {
        return tripId;
    }

    public void setTripId(long tripId) {
        this.tripId = tripId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Graph<Location, String> getPercurso() {
        return percurso;
    }

    public void setPercurso(Graph<Location, String> percurso) {
        this.percurso = percurso;
    }
}

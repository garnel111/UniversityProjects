/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import lapr.project.data.mapGraph.Graph;
import lapr.project.data.mapGraph.GraphAlgorithms;
import lapr.project.data.ParkDB;
import lapr.project.data.PoiDB;
import lapr.project.data.RouteDB;
import lapr.project.model.Location;
import lapr.project.model.POI;
import lapr.project.model.Park;
import lapr.project.model.Route;
import lapr.project.utils.CalcMethods;

/**
 * @author josemagalhaes
 */
public class RouteController {

    RouteDB routeDataBase;
    private Park originPark;
    private Park destinationPark;
    String routeType;
    List<POI> touristicPoints;

    private Graph<Location, String> fullNetwork;
    private Graph<Location, String> parkNetwork;
    private Graph<Location, String> poiNetwork;

    ParkDB pDB;
    PoiDB poiDB;

    Route rota;


    public RouteController() throws IOException, SQLException {
        this.routeDataBase = new RouteDB();
        this.pDB = new ParkDB();
        this.poiDB = new PoiDB();
        this.rota = new Route();

        originPark = null;
        destinationPark = null;
        routeType = null;
        touristicPoints = new ArrayList<>();

        fullNetwork = new Graph<>(false);
        parkNetwork = new Graph<>(false);
        poiNetwork = new Graph<>(false);

    }

    public RouteController(Park originPark, Park destinationPark, String routeType) throws IOException, SQLException {
        this.originPark = originPark;
        this.destinationPark = destinationPark;
        this.routeType = routeType;
        this.touristicPoints = new ArrayList<>();
        this.routeDataBase = new RouteDB();
        this.pDB = new ParkDB();
        this.poiDB = new PoiDB();
        this.rota = new Route();

        fullNetwork = new Graph<>(false);
        parkNetwork = new Graph<>(false);
        poiNetwork = new Graph<>(false);

    }

    public RouteController(Park originPark, Park destinationPark, String routeType, List<POI> touristicPoints) throws IOException, SQLException {
        this.originPark = originPark;
        this.destinationPark = destinationPark;
        this.routeType = routeType;
        this.touristicPoints = touristicPoints;

        fullNetwork = new Graph<>(false);
        parkNetwork = new Graph<>(false);
        poiNetwork = new Graph<>(false);

    }


    /**
     * Cria o grafo da Rede
     *
     * @throws SQLException
     * @throws IOException
     */
    public boolean createNetworks() throws SQLException, IOException {

        //Buscar todas as localizações
        List<Location> locations = getAllLocations();
        //Inserir as localizações no grafo
        for (Location l : locations) {
            if(l.getLocation()!=null){
                fullNetwork.insertVertex(l);
                if (l.getLocation() instanceof Park) {
                    parkNetwork.insertVertex(l);
                }
                if (l.getLocation() instanceof POI) {
                    poiNetwork.insertVertex(l);
                }
            }

        }

        //Percorrer a locations e criar os Edges
        for (Location l : locations) {
            if(l.getLocation()!=null){
                for (int i = locations.indexOf(l) + 1; i < locations.size() - 1; i++) {
                    Location l2 = locations.get(i);
                    float lat1 = l.getLatitude();
                    float long1 = l.getLongitude();
                    float lat2 = l2.getLatitude();
                    float long2 = l2.getLongitude();

                    double dist = CalcMethods.calcDistanceBetweenCoordinates(lat1, long1, lat2, long2);

                    //Insere o edge no grafo
                    fullNetwork.insertEdge(l, l2, l.getName() + "-" + l2.getName(), dist);
                    if (l.getLocation() instanceof Park && l2.getLocation() instanceof Park) {
                        parkNetwork.insertEdge(l, l2, l.getName() + "-" + l2.getName(), dist);
                    }
                    if (l.getLocation() instanceof POI && l2.getLocation() instanceof POI) {
                        poiNetwork.insertEdge(l, l2, l.getName() + "-" + l2.getName(), dist);
                    }
                }
            }

        }
        //Redes criadas
        return true;
    }


    /**
     * Retorna todas as localizações existentes na DB
     *
     * @return
     * @throws SQLException
     */
    public List<Location> getAllLocations() throws SQLException {
        List<Location> locations = new ArrayList<>();

        //Buscar todos os Parques à BD
        List<String> parkNames = pDB.getParkNames();

        for (String p : parkNames) {
            Park parque = pDB.getParkByName(p);
            Location current = new Location();
            current.setLocation(parque);
            locations.add(current);
        }


        //Buscar todos os POIs à BD
        List<String> poiNames = poiDB.getPOInames();

        for (String p : poiNames) {
            POI poi = poiDB.getPoiByName(p);
            Location current = new Location();
            current.setLocation(poi);
            locations.add(current);
        }

        return locations;
    }




    public Route calculateRoute() {
        Route percurso = new Route();

        if ("Shortest".equalsIgnoreCase(routeType) && touristicPoints.isEmpty()) {
            return calcShortestRouteNoPOIs();
        }

        if ("Shortest".equalsIgnoreCase(routeType) && !touristicPoints.isEmpty()) {
            return calcShortestRoute(originPark, destinationPark, touristicPoints);
        }


        return percurso;
    }

    public Route calcShortestRouteNoPOIs() {
        Route shortest = new Route();
        LinkedList<Location> shortestPath = new LinkedList<>();
        double totalDist = 0;

        Location Vorigin = new Location();
        Vorigin.setLocation(originPark);
        Location Vdestination = new Location();
        Vdestination.setLocation(destinationPark);
        totalDist = GraphAlgorithms.shortestPath(parkNetwork, Vorigin, Vdestination, shortestPath);

        System.out.println("shortestPath: "+shortestPath);

        for(int i=0;i<shortestPath.size()-1;i++){
            shortest.getPercurso().insertVertex(shortestPath.get(i));
            shortest.getPercurso().insertVertex(shortestPath.get(i+1));
            double peso = parkNetwork.getEdge(shortestPath.get(i),shortestPath.get(i+1)).getWeight();
            shortest.getPercurso().insertEdge(shortestPath.get(i),shortestPath.get(i+1),parkNetwork.getEdge(shortestPath.get(i),shortestPath.get(i+1)).getElement()
                    ,peso);
        }
        return shortest;
    }


    public Route calcShortestRoute(Park origin, Park destination, List<POI> pois) {
        Route shortest = new Route();
        LinkedList<Location> shortestPath = new LinkedList<>();
        double totalDist = 0;

        Location Vorigin = new Location();
        Vorigin.setLocation(origin);
        Location Vdestination = new Location();
        Vorigin.setLocation(destination);

        //Rota sem POIs
        if (pois.isEmpty()) {
            totalDist = GraphAlgorithms.shortestPath(fullNetwork, Vorigin, Vdestination, shortestPath);
        }


        return shortest;
    }






    public Park getOriginPark() {
        return originPark;
    }

    public void setOriginPark(Park originPark) {
        this.originPark = originPark;
    }

    public Park getDestinationPark() {
        return destinationPark;
    }

    public void setDestinationPark(Park destinationPark) {
        this.destinationPark = destinationPark;
    }

    public String getRouteType() {
        return routeType;
    }

    public void setRouteType(String routeType) {
        this.routeType = routeType;
    }

    public List<POI> getTouristicPoints() {
        return touristicPoints;
    }

    public void setTouristicPoints(List<POI> touristicPoints) {
        this.touristicPoints = touristicPoints;
    }

    public void setRouteDataBase(RouteDB routeDataBase) {
        this.routeDataBase = routeDataBase;
    }

    public void setpDB(ParkDB pDB) {
        this.pDB = pDB;
    }

    public ParkDB getpDB() {
        return pDB;
    }

    public void setPoiDB(PoiDB poiDB) {
        this.poiDB = poiDB;
    }

    public PoiDB getPoiDB() {
        return poiDB;
    }

    public Graph<Location, String> getFullNetwork() {
        return fullNetwork;
    }

    public Graph<Location, String> getParkNetwork() {
        return parkNetwork;
    }

    public Graph<Location, String> getPoiNetwork() {
        return poiNetwork;
    }
}

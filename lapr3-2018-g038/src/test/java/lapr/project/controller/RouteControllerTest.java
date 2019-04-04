package lapr.project.controller;

import lapr.project.data.mapGraph.Graph;
import lapr.project.data.ParkDB;
import lapr.project.data.PoiDB;
import lapr.project.data.RouteDB;
import lapr.project.model.Location;
import lapr.project.model.POI;
import lapr.project.model.Park;
import lapr.project.model.Route;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RouteControllerTest {

    RouteController rc;

    public RouteControllerTest() throws IOException, SQLException {
        //PROPRIEDADES DA BASE DE DADOS (NÃO COMENTAR!)
        //load database properties
        try {
            Properties properties
                    = new Properties(System.getProperties());
            InputStream input = new FileInputStream("target/classes/application.properties");
            properties.load(input);
            input.close();
            System.setProperties(properties);

        } catch (IOException e) {
            e.printStackTrace();
        }
//FIM DAS PROPRIEDADES DA BASE DE DADOS
        rc = new RouteController();

    }

    @Test
    public void createNetworks() throws IOException, SQLException {
        rc = new RouteController();//mock(RouteController.class);
//        when(rc.createNetworks()).thenReturn(true);

        boolean result = rc.createNetworks();
        assertTrue(result);
    }

    @Test
    public void getAllLocations() throws SQLException {
        rc = mock(RouteController.class);
        List<Location> loc = new ArrayList<>();
        when(rc.getAllLocations()).thenReturn(loc);
        assertEquals(loc,rc.getAllLocations());
    }

    @Test
    public void calculateRoute() throws IOException, SQLException {
        rc = mock(RouteController.class);
        Park p1 = new Park("teste", 12.21F, 21.12F, 5, 6);
        Park p2 = new Park("teste2", 123.21F, 321.12F, 5, 6);
        Route r = new Route();
        List<POI> pois = new ArrayList<>();
        when(rc.calcShortestRoute(p1,p2,pois)).thenReturn(r);
        rc.setRouteType("Shortest");

        assertEquals(null,rc.calculateRoute());
    }

    @Test
    public void calculateRoute2() throws IOException, SQLException {
        rc = mock(RouteController.class);
        Park p1 = new Park("teste", 12.21F, 21.12F, 5, 6);
        Park p2 = new Park("teste2", 123.21F, 321.12F, 5, 6);
        Route r = new Route();
        List<POI> pois = new ArrayList<>();
        when(rc.calcShortestRoute(p1,p2,pois)).thenReturn(r);
        rc.setRouteType("teste");

        assertEquals(null,rc.calculateRoute());
    }

    @Test
    public void calculateRoute3() throws IOException, SQLException {
        rc = mock(RouteController.class);
        Park p1 = new Park("teste", 12.21F, 21.12F, 5, 6);
        Park p2 = new Park("teste2", 123.21F, 321.12F, 5, 6);
        Route r = new Route();
        List<POI> pois = new ArrayList<>();
        when(rc.calculateRoute()).thenReturn(r);
        rc.setRouteType("teste");


        assertEquals(r,rc.calculateRoute());
    }

    @Test
    public void getOriginPark() throws IOException, SQLException {
//        RouteController rc = mock(RouteController.class);
//        when(rc.createNetworks()).thenReturn(true);
        Park p = new Park("teste", 12.21F, 21.12F, 5, 6);
        Park p2 = new Park("teste2", 123.21F, 321.12F, 5, 6);
        rc = new RouteController(p,p2,"teste");
        rc.setOriginPark(p);
//        when(rc.getOriginPark()).thenReturn(p);

        assertEquals(p, rc.getOriginPark());
    }

    @Test
    public void setOriginPark() throws IOException, SQLException {
        rc = new RouteController();
        Park p = new Park("teste", 12.21F, 21.12F, 5, 6);
        rc.setOriginPark(p);

        assertEquals(p, rc.getOriginPark());
    }

    @Test
    public void getDestinationPark() throws IOException, SQLException {

        Park p = new Park("teste", 12.21F, 21.12F, 5, 6);
        Park p2 = new Park("teste2", 123.21F, 321.12F, 5, 6);
        List<POI> pois = new ArrayList<>();
        rc = new RouteController(p,p2,"Shortest",pois);
        rc.setDestinationPark(p);

        assertEquals(p, rc.getDestinationPark());
    }

    @Test
    public void setDestinationPark() throws IOException, SQLException {
        rc = new RouteController();
        Park p = new Park("teste", 12.21F, 21.12F, 5, 6);
        rc.setDestinationPark(p);

        assertEquals(p, rc.getDestinationPark());
    }

    @Test
    public void getRouteType() throws IOException, SQLException {
        rc = new RouteController();
        rc.setRouteType("teste");

        assertEquals("teste", rc.getRouteType());
    }

    @Test
    public void setRouteType() throws IOException, SQLException {
        rc = new RouteController();
        rc.setRouteType("teste");

        assertEquals("teste", rc.getRouteType());
    }

    @Test
    public void getTouristicPoints() throws IOException, SQLException {
        rc = new RouteController();
        List<POI> pois = new ArrayList<>();
        rc.setTouristicPoints(pois);
        assertEquals(pois, rc.getTouristicPoints());
    }

    @Test
    public void setTouristicPoints() throws IOException, SQLException {
        rc = new RouteController();
        List<POI> pois = new ArrayList<>();
        rc.setTouristicPoints(pois);
        assertEquals(pois, rc.getTouristicPoints());
    }

    @Test
    public void setRouteDataBase() throws IOException, SQLException {
        rc = new RouteController();
        RouteDB db = mock(RouteDB.class);
        rc.setRouteDataBase(db);
        assertEquals(db,rc.routeDataBase);
    }

    @Test
    public void setpDB() throws IOException, SQLException {
        rc = new RouteController();
//        when(rc.createNetworks()).thenReturn(true);
        ParkDB pdb = mock(ParkDB.class);
//        when(rc.getpDB()).thenReturn(pdb);

        rc.setpDB(pdb);

        assertEquals(pdb, rc.getpDB());
    }

    @Test
    public void setPoiDB() throws IOException, SQLException {
//        RouteController rc = mock(RouteController.class);
        rc = new RouteController();
//        when(rc.createNetworks()).thenReturn(true);

        PoiDB p = mock(PoiDB.class);//new PoiDB();
//        when(rc.getPoiDB()).thenReturn(p);
        rc.setPoiDB(p);

        assertEquals(p, rc.getPoiDB());
    }

    @Test
    public void getFullNetwork() throws IOException, SQLException {
        rc = new RouteController();
//        when(rc.createNetworks()).thenReturn(true);
        Graph<Location, String> r = rc.getFullNetwork();

        assertEquals(r,rc.getFullNetwork());
    }

    @Test
    public void getParkNetwork() throws IOException, SQLException {
        rc = new RouteController();
//        when(rc.createNetworks()).thenReturn(true);
        Graph<Location, String> r = rc.getParkNetwork();

        assertEquals(r,rc.getParkNetwork());
    }

    @Test
    public void getPoiNetwork() throws IOException, SQLException {
        rc = new RouteController();
//        when(rc.createNetworks()).thenReturn(true);
        Graph<Location, String> r = rc.getPoiNetwork();

        assertEquals(r,rc.getPoiNetwork());
    }
}

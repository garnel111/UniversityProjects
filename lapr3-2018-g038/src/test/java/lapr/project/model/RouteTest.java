package lapr.project.model;

import lapr.project.data.mapGraph.Edge;
import lapr.project.data.mapGraph.Graph;
import lapr.project.data.mapGraph.Vertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RouteTest {

    @Test
    void insertLocation() {
        Route r = new Route();
        Park p = new Park("teste",12.12F,21.21F,5,6);
        Location l = new Location(p);
        r.insertLocation(l);

        assertEquals(l,r.getPercurso().vertices().iterator().next());
    }

    @Test
    void insertConnection() {
        Route r = new Route();
        Park p = new Park("teste",12.12F,21.21F,5,6);
        Location l1 = new Location(p);
        Park p2 = new Park("teste2",123.123F,321.321F,6,5);
        Location l2 = new Location(p);
        Edge<Location,Object> e = new Edge<Location, Object>("teste",5,new Vertex<Location, Object>(0,l1),new Vertex<Location, Object>(1,l2));
        r.insertConnection(l1, l2, "teste",5);

        assertEquals(e,r.getPercurso().edges().iterator().next());
    }

    @Test
    void getId() {
        Route r = new Route(1234,4321,"teste");

        assertEquals(1234,r.getId());
    }

    @Test
    void setId() {
        Route r = new Route();
        r.setId(1234);

        assertEquals(1234,r.getId());
    }

    @Test
    void getTripId() {
        Route r = new Route();
        r.setTripId(1234);

        assertEquals(1234,r.getTripId());
    }

    @Test
    void setTripId() {
        Route r = new Route();
        r.setTripId(1234);

        assertEquals(1234,r.getTripId());
    }

    @Test
    void getType() {
        Route r = new Route();
        r.setType("teste");

        assertEquals("teste",r.getType());
    }

    @Test
    void setType() {
        Route r = new Route();
        r.setType("teste");

        assertEquals("teste",r.getType());
    }

    @Test
    void getPercurso() {
        Route r = new Route();
        Graph<Location, String> p = new Graph<>(false);

        r.setPercurso(p);

        assertEquals(p,r.getPercurso());
    }

    @Test
    void setPercurso() {
        Route r = new Route();
        Graph<Location, String> p = new Graph<>(false);

        r.setPercurso(p);

        assertEquals(p,r.getPercurso());
    }
}
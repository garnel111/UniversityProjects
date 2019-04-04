package lapr.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    @Test
    void getLocation() {
        Park p = new Park();
        Location l = new Location(p);

        assertEquals(p,l.getLocation());
    }

    @Test
    void setLocation() {
        Park p = new Park();
        Location l = new Location();
        boolean result = l.setLocation(p);

        assertEquals(p,l.getLocation());
        assertTrue(result);
    }

    @Test
    void setLocationPOI() {
        POI p = new POI();
        Location l = new Location(p);
        boolean result = l.setLocation(p);

        assertEquals(p,l.getLocation());
        assertTrue(result);
    }

    @Test
    void setLocationFalse() {
        Object p = new Object();
        Location l = new Location();
        boolean result = l.setLocation(p);

        assertFalse(result);
    }

    @Test
    void getId() {
        Park p = new Park();
        p.setId(1234);
        Location l = new Location(p);

        assertEquals(1234,l.getId());
    }

    @Test
    void getName() {
        Park p = new Park();
        p.setName("teste");
        Location l = new Location(p);

        assertEquals("teste",l.getName());
    }

    @Test
    void getNameNull() {
        Location l = new Location();

        assertEquals(null,l.getName());
    }

    @Test
    void getLatitude() {
        Park p = new Park();
        p.setLatitude(12.21F);
        Location l = new Location(p);

        assertEquals(12.21F,l.getLatitude());
    }

    @Test
    void getLongitude() {
        Park p = new Park();
        p.setLongitude(12.21F);
        Location l = new Location(p);

        assertEquals(12.21F,l.getLongitude());
    }

    @Test
    void getParque() {
        Park p = new Park();
        Location l = new Location(p);

        assertEquals(p,l.getParque());
    }

    @Test
    void setParque() {
        Park p = new Park();
        Location l = new Location();
        l.setParque(p);

        assertEquals(p,l.getLocation());
    }

    @Test
    void getPoi() {
        POI p = new POI();
        Location l = new Location(p);

        assertEquals(p,l.getPoi());
    }

    @Test
    void setPoi() {
        POI p = new POI();
        Location l = new Location();
        l.setPoi(p);

        assertEquals(p,l.getPoi());
    }
}
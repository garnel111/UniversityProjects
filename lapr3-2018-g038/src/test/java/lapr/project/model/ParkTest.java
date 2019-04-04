/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;

import lapr.project.controller.LoginController;
import lapr.project.controller.ParkController;
import lapr.project.data.ParkDB;
import lapr.project.data.UserDB;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Thais Farias
 */
public class ParkTest {

    public ParkTest() {
    }

    /**
     * Test of getId method, of class Park.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");

        Park instance = new Park("Park", 12, 10, 14, 15);
        long expResult = 10L;
        instance.setId(10L);
        long result = instance.getId();
        assertEquals(expResult, result);

    }

    /**
     * Test of getAdmin_Id method, of class Park.
     */
    @Test
    public void testGetAdmin_Id() {
        System.out.println("getAdmin_Id");

        Park instance = new Park("Park", 12, 10, 14, 15);
        long expResult = 8L;
        instance.toString();
        instance.setAdmin_Id(8L);
        long result = instance.getAdmin_Id();
        assertEquals(expResult, result);

    }

    /**
     * Test of getName method, of class Park.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Park instance = new Park("Park", 12, 10, 14, 15);
        String expResult = "Park";
        String result = instance.getName();
        assertEquals(expResult, result);

    }

    /**
     * Test of getLatitude method, of class Park.
     */
    @Test
    public void testGetLatitude() {
        System.out.println("getLatitude");
        Park instance = new Park("Park", 8.4887f, 12f, 10, 15);
        float expResult = 8.4887F;
        float result = instance.getLatitude();
        assertEquals(expResult, result);

    }

    /**
     * Test of getLongitude method, of class Park.
     */
    @Test
    public void testGetLongitude() {
        System.out.println("getLongitude");

        Park instance = new Park("Park", 10f, -4.4887f, 10, 15);
        float expResult = -4.4887F;
        float result = instance.getLongitude();
        assertEquals(expResult, result);

    }

    /**
     * Test of getMaxCapacityNonElectric method, of class Park.
     */
    @Test
    public void testGetMaxCapacityNonElectric() {
        System.out.println("getMaxCapacityNonElectric");
        Park instance = new Park("Park", 10, -4.4887F, 10, 15);
        long expResult = 10L;
        long result = instance.getMaxCapacityNonEletric();
        assertEquals(expResult, result);

    }

    /**
     * Test of getMaxCapacityElectric method, of class Park.
     */
    @Test
    public void testGetMaxCapacityElectric() {
        System.out.println("getMaxCapacityElectric");

        Park instance = new Park("Park", 10, -4.4887F, 10, 255);
        long expResult = 255L;
        System.out.println(instance.toString());
        long result = instance.getMaxCapacityElectric();
        assertEquals(expResult, result);

    }

    /**
     * Test of setId method, of class Park.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        long id = 0L;
        Park instance = new Park();
        instance.setId(id);

    }

    /**
     * Test of setAdmin_Id method, of class Park.
     */
    @Test
    public void testSetAdmin_Id() {
        System.out.println("setAdmin_Id");
        long admin_Id = 0L;
        Park instance = new Park();
        instance.setAdmin_Id(admin_Id);

    }


    /**
     * Test of hashCode method, of class Park.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Park instance = new Park("Bikes Park", 7.241584f, -12.112489f, 12, 24);
        int expResult = -470677338;
        int result = instance.hashCode();
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class Park.
     */
    @Test
    public void testEqualsDifferentLatitude() {
        System.out.println("equals");

        Park instance = new Park("Bikes Park", 7.241584f, -12.112489f, 12, 24);
        Park park = new Park();
        park.setName("Bikes Park");
        park.setLatitude(9.241584f);
        park.setLongitude(-12.112489f);
        park.setMaxCapacityElectric(12);
        park.setMaxCapacityNonElectric(24);

        assertTrue(!park.equals(instance));

    }


    /**
     * Test of equals method, of class Park.
     */
    @Test
    public void testEqualsDifferentLongttude() {
        System.out.println("equals");

        Park instance = new Park("Bikes Park", 7.241584f, -12.112489f, 12, 24);
        Park park = new Park();
        park.setName("Bikes Park");
        park.setLatitude(7.241584f);
        park.setLongitude(-10.012489f);
        park.setMaxCapacityElectric(12);
        park.setMaxCapacityNonElectric(24);

        assertTrue(!park.equals(instance));

    }

    /**
     * Test of equals method, of class Park.
     */
    @Test
    public void testEqualsParkName() {
        System.out.println("equals");

        Park instance = new Park("Bikes Park", 7.241584f, -12.112489f, 12, 24);
        Park park = new Park();
        park.setName("Bikes Park");
        park.setLatitude(7.241584f);
        park.setLongitude(-12.112489f);
        park.setMaxCapacityElectric(12);
        park.setMaxCapacityNonElectric(24);

        assertTrue(park.equals(instance));

    }

    /**
     * Test of equals method, of class Park.
     */
    @Test
    public void testEqualsNull() {
        System.out.println("equals");

        Park instance = null;
        Park park = new Park();
        park.setName("Bikes Park");
        park.setLatitude(7.241584f);
        park.setLongitude(-12.112489f);
        park.setMaxCapacityElectric(12);
        park.setMaxCapacityNonElectric(24);

        assertFalse(park.equals(instance));

    }

    /**
     * Test of equals method, of class Park.
     */
    @Test
    public void testEqualsDifferentClass() {
        System.out.println("equals");

        User instance = new User();
        Park park = new Park();
        park.setName("Bikes Park");
        park.setLatitude(7.241584f);
        park.setLongitude(-12.112489f);
        park.setMaxCapacityElectric(12);
        park.setMaxCapacityNonElectric(24);

        assertFalse(park.equals(instance));

    }

    /**
     * Test of equals method, of class Park.
     */
    @Test
    public void testEqualsDifferentId() {
        System.out.println("equals");

        Park instance = new Park("Bikes Park", 7.241584f, -12.112489f, 12, 24);
        instance.setId(2);
        Park park = new Park();
        park.setId(1);
        park.setName("Bikes Park");
        park.setLatitude(7.241584f);
        park.setLongitude(-10.012489f);
        park.setMaxCapacityElectric(12);
        park.setMaxCapacityNonElectric(24);

        assertFalse(park.equals(instance));

    }

    /**
     * Test of equals method, of class Park.
     */
    @Test
    public void testEqualsDifferentName() {
        System.out.println("equals");

        Park instance = new Park("Bikes Park", 7.241584f, -10.012489f, 12, 24);
        Park park = new Park();
        park.setName("Bikes Park 2");
        park.setLatitude(7.241584f);
        park.setLongitude(-10.012489f);
        park.setMaxCapacityElectric(12);
        park.setMaxCapacityNonElectric(24);

        assertFalse(park.equals(instance));

    }

    @Test
    public void testHashCodeWithIdBig() {
        System.out.println("Test hash code ");
        Park instance = new Park();
        instance.setId(999999999);

        int expResult = 241278131;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    @Test
    public void testHashCodeWithIdNegativeAndBig() {
        System.out.println("HashCodeWithIdNegativeAndBig ");
        Park instance = new Park();
        instance.setId(-999999999);

        int expResult = 241253742;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetParkByName() {
        // ParkDB pdb = mock(ParkDB.class);
        ParkController parkCTRL = mock(ParkController.class);
        Park parkReturned = new Park();
        Park expectedPark = parkReturned;
        when(parkCTRL.getParkByName("ISEP_PAQUE")).thenReturn(parkReturned);
        Park result = parkCTRL.getParkByName("ISEP_PAQUE");
        assertEquals(expectedPark, result);

    }

}

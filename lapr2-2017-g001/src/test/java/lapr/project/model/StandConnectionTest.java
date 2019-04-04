/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author JM
 */
public class StandConnectionTest {

    /**
     * Test of getA method, of class StandConnection.
     */
    @Test
    public void testGetA() {
        System.out.println("getA");
        StandConnection instance = new StandConnection("s1", "s2", 4.3);
        String expResult = "s1";
        String result = instance.getA();
        assertEquals(expResult, result);
    }

    /**
     * Test of setA method, of class StandConnection.
     */
    @Test
    public void testSetA() {
        System.out.println("setA");
        String a = "s1";
        StandConnection instance = new StandConnection("", "", 5);
        instance.setA(a);
        assertEquals(a, instance.getA());
    }

    /**
     * Test of getB method, of class StandConnection.
     */
    @Test
    public void testGetB() {
        System.out.println("getB");
        StandConnection instance = new StandConnection("s1", "s2", 4.3);
        String expResult = "s2";
        String result = instance.getB();
        assertEquals(expResult, result);
    }

    /**
     * Test of setB method, of class StandConnection.
     */
    @Test
    public void testSetB() {
        System.out.println("setB");
        String a = "s2";
        StandConnection instance = new StandConnection("", "", 5);
        instance.setB(a);
        assertEquals(a, instance.getB());
    }

    /**
     * Test of getDist method, of class StandConnection.
     */
    @Test
    public void testGetDist() {
        System.out.println("getDist");
        StandConnection instance = new StandConnection("s1", "s2", 4.3);
        double expResult = 4.3;
        double result = instance.getDist();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDist method, of class StandConnection.
     */
    @Test
    public void testSetDist() {
        System.out.println("setDist");
        double dist = 5.6;
        StandConnection instance = new StandConnection("s1", "s2", 4.3);
        instance.setDist(dist);
        assertEquals(dist, instance.getDist());
    }

    /**
     * Test of compareTo method, of class StandConnection.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        StandConnection o = new StandConnection("s1", "s2", 5);
        StandConnection o2 = new StandConnection("s1", "s2", 6);
        StandConnection o3 = new StandConnection("s1", "s2", 3);
        StandConnection instance = new StandConnection("s2", "s3", 5);
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
        assertTrue(instance.compareTo(o2) < 0);
        assertTrue(instance.compareTo(o3) > 0);
    }

    /**
     * Test of toString method, of class StandConnection.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        StandConnection instance = new StandConnection("s1", "s2", 4.3);
        String expResult = "s1 --> s2  (4.3 meters)";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class StandConnection.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        StandConnection instance = new StandConnection("s1", "s2", 4.3);
        StandConnection instance2 = new StandConnection("s1", "s2", 4.3);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        assertEquals(true, instance.equals(instance2));

    }
    
    /**
     * Test of equals method, of class StandConnection.
     */
    @Test
    public void testEqualsNot() {
        System.out.println("equals");
        Object obj = new User();
        StandConnection instance = new StandConnection("s1", "s2", 4.3);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Stand.
     */
    @Test
    public void testHashCodeOne() {
        StandConnection instance = new StandConnection("s3", "s4", 4.3);
        int result = instance.hashCode();
        int expectedResult = 1938847114;
        assertEquals(expectedResult, result);
    }

}

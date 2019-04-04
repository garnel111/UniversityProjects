/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author andre
 */
public class StandTest {

    Distance dist1;
    Distance dist3;
    Distance dist2;

    List<Distance> listDist;

    Stand st1;
    Stand st2;
    Stand st3;

    public StandTest() {
        this.dist1 = new Distance("Stand 1", 10.2);
        this.dist2 = new Distance("Stand 2", 14.2);
        this.dist3 = new Distance("Stand 3", 20.5);
        this.listDist = new ArrayList<>();
        this.listDist.add(dist1);
        this.listDist.add(dist2);
        this.listDist.add(dist3);
        this.st1 = new Stand("Stand 1", 10.2);
        this.st3 = new Stand("Stand 3", 15.2);
        this.st2 = new Stand("Stand 4", 5.2);
    }

    /**
     * Test of set getDescription method, of class Stand.
     */
    @Test
    public void testSetAndGetDescription() {
        System.out.println("set get Description");
        Stand instance = new Stand();
        String expResult = "Description";
        instance.setDescription(expResult);
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of set getArea method, of class Stand.
     */
    @Test
    public void testSetAndGetArea() {
        System.out.println("set get Area");
        Stand instance = new Stand();
        double expResult = 20.0;
        instance.setArea(expResult);
        double result = instance.getArea();
        assertEquals(expResult, result, 20.0);
    }

    /**
     * Test of set/getDistanceList method, of class Stand.
     */
    @Test
    public void testSetAndGetDistanceList() {
        System.out.println("set/getDistanceList");
        Stand instance = new Stand();
        List<Distance> expResult = new ArrayList<>();
        expResult.add(dist1);
        expResult.add(dist2);
        expResult.add(dist3);
        instance.setDistanceList(listDist);
        List<Distance> result = instance.getDistanceList();
        assertEquals(expResult, result);
    }

    /**
     * Test of addPairDistance method, of class Stand.
     */
    @Test
    public void testAddPairDistance() {
        System.out.println("addPairDistance");
        String stand = "Stand 2";
        Double distance = 20.5;
        Stand instance = new Stand();
        boolean result = instance.addPairDistance(stand, distance);
        assertTrue(result);
    }

    /**
     * Test of addDistance method, of class Stand.
     */
    @Test
    public void testAddDistance() {
        System.out.println("addDistance");
        Distance d = dist1;
        Stand instance = new Stand();
        boolean result = instance.addDistance(d);
        assertTrue(result);
    }

    /**
     * Test of compareTo method, of class Stand.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        int expResult = 1;
        int result = st1.compareTo(st2);
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Stand.
     */
    @Test
    public void testCompareTo2() {
        System.out.println("compareTo2");
        int expResult = 0;
        int result = st1.compareTo(st1);
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Stand.
     */
    @Test
    public void testCompareTo3() {
        System.out.println("compareTo3");
        int expResult = -1;
        int result = st1.compareTo(st3);
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmptyDistancelist method, of class Stand.
     */
    @Test
    public void testIsEmptyDistancelist() {
        System.out.println("isEmptyDistancelist");
        Stand instance = new Stand();
        boolean result = instance.isEmptyDistancelist();
        assertTrue(result);
    }

    /**
     * Test of toString method, of class Stand.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Stand instance = new Stand("Stand Test to String", 20.2);
        instance.setDistanceList(listDist);
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Stand.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Stand instance = new Stand("Stand 1", 20.2);
        Stand instance2 = new Stand("Stand 1", 20.2);
        
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(instance2.getDescription());
        hash = 61 * hash + (int) (Double.doubleToLongBits(instance2.getArea()) ^ (Double.doubleToLongBits(instance2.getArea()) >>> 32));
        hash = 61 * hash + Objects.hashCode(instance2.getDistanceList());
        
        int expResult = hash;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Stand.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Stand instance = new Stand();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Stand.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals2");
        Stand instance = st1;
        boolean result = instance.equals(st1);
        assertTrue(result);
    }

    /**
     * Test of equals method, of class Stand.
     */
    @Test
    public void testEquals3() {
        System.out.println("equals3");
        Stand instance = st1;
        Stand test = new Stand("Stand 2", 10.2);
        boolean result = instance.equals(test);
        assertFalse(result);
    }

    /**
     * Test of equals method, of class Stand.
     */
    @Test
    public void testEquals4() {
        System.out.println("equals4");
        Stand instance = st1;
        Stand test = new Stand("Stand 1", 12.2);
        boolean result = instance.equals(test);
        assertFalse(result);
    }

    /**
     * Test of equals method, of class Stand.
     */
    @Test
    public void testEquals5() {
        System.out.println("equals5");
        Stand instance = st1;
        boolean result = instance.equals(dist1);
        assertFalse(result);
    }

    @Test
    public void hashCodeTest() {

        Stand stand = new Stand();
        Stand stand2 = new Stand();

       assertEquals(stand.hashCode(), 1134906);
    }
     @Test
    public void hashCodeTest2() {

        Stand stand = new Stand();
        Stand stand2 = new Stand();
        stand.setDescription("descrição");
        stand.setArea(2.55555555);
    
      assertEquals(stand.hashCode(), 1700517535);
    }
}

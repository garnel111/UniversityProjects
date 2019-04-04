package lapr.project.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author manuel.garnel
 */
public class BicycleTest {

    public BicycleTest() {
    }

    /**
     * Test of getIdBicycle method, of class Bicycle.
     */
    @Test
    public void testGetIdBicycle() {
        System.out.println("getIdBicycle");
        Bicycle instance = new Bicycle();
        long expResult = 121312;
        instance.setIdBicycle(expResult);
        long result = instance.getIdBicycle();
        assertEquals(expResult, result);
        // 
    }

    @Test
    public void testGetKmBicycle() {
        System.out.println("GetKmBicycle");
        Bicycle instance = new Bicycle();
        float expResult = 1212;
        instance.setKm(expResult);
        float result = instance.getKm();
        assertEquals(expResult, result);
        // 
    }

    @Test
    public void getBicycleMass() {
        System.out.println("getBicycleMass");
        Bicycle instance = new Bicycle();
        float expResult = 1212;
        instance.setBicycleMass(expResult);
        float result = instance.getBicycleMass();
        assertEquals(expResult, result);
        // 
    }
}

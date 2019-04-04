package lapr.project.utils;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CalcMethodsTest {

    @Test
    void testCalcDistanceBetweenCoordinates() throws IOException {
        //Rotunda da Boavista: 41.158087, -8.629120
        //ISEP_PARK: 41.179025, -8.607782
        //dist = 2934.1719
        System.out.println("testCalcDistanceBetweenCoordinates");
        double expResult = 2934.1719F;
        double result = CalcMethods.calcDistanceBetweenCoordinates(41.158087F,-8.629120F,41.179025F,-8.607782F);
        assertEquals(expResult,result,0.0001);
    }

    @Test
    void calcPointElevation() throws IOException {
        System.out.println("calcPointElevation");
        //41.179025, -8.607782
        double expResult = 106.2765F;
        double result = CalcMethods.calcPointElevation(41.179025F,-8.607782F);
        assertEquals(expResult,result,0.0001);
    }
}
package lapr.project.utils;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcForCaloriesTest {

    @Test
    public void testcalculateTimeOTrip() {
        System.out.println(" Test calculate time of trip");
        double expectedResult = 1.2;
        double result= CalcForCalories.calculateTimeOfTrip(25,30.00);
        assertEquals(expectedResult, result);
    }
    @Test
    public void testcalculateEnergyConsumed() {
        System.out.println(" Test calculate Consumed Energy");
        double expectedResult = 600;
        double result= CalcForCalories.calculateEnergyConsumed(20,30.00);
        assertEquals(expectedResult, result);
    }
}

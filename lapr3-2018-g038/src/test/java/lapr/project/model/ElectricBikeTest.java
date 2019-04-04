package lapr.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ElectricBikeTest {
    public ElectricBikeTest() {
    }


    @Test
    public void testSetCharge() {
        System.out.println("test setCharge");
        ElectricBike instance = new ElectricBike(12,125,"Electric");
        instance.setType("Electric");
        instance.setCharge("Electric", 35);
        float result = instance.getCharge();
        assertEquals(result,35);
    }
    @Test
    public void testSetChargeTwo() {
        System.out.println("test setCharge");
        ElectricBike instance = new ElectricBike(12,125,"Electric");
        instance.setType("Electric");
        instance.setCharge(  35);
        float result = instance.getCharge();
        assertEquals(result,35);
    }
    @Test
    public void testGetMaxBatteryValue() {
        System.out.println("testGetMaxBatteryValue");
        ElectricBike instance = new ElectricBike(12,125,"Electric");
        instance.setType("Electric");
        instance.setMaxBatteryValue( 100);
        float result = instance.getMaxBatteryValue();
        assertEquals(result,100);
    }

    @Test
    public void testGetCurrentBatteryValue() {
        System.out.println("test Get Current ActualBatteryValue");
        ElectricBike instance = new ElectricBike(12,125,"Electric");
        instance.setType("Electric");
        instance.setCurrentyBatteryLevel(40);
        float result = instance.getCurrentyBatteryLevel();
        assertEquals(result,40);
    }
    @Test
    public void testsetMaxBatterye() {
        System.out.println("test setMaxBattery");
        ElectricBike instance = new ElectricBike();
        instance.setType("Electric");
        instance.setMaxBattery(40);
        instance.setCurrentyBattery(30);
        instance.setCurrentyBatteryLevel(30);
        float result = instance.getCurrentyBatteryLevel();
        assertEquals(result,30);
    }

}


package lapr.project.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhysicalConstantsTest {

    @Test
    void constructorTest() {
        PhysicalConstants p = new PhysicalConstants();
        assertTrue(p instanceof PhysicalConstants);
    }

    @Test
    void getDragCoefficientStreamlined_Body() {
        assertEquals(1.4, PhysicalConstants.getDragCoefficientStreamlined_Body());
    }

    @Test
    void getStreamlinedHalfBody() {
        assertEquals(1.004, PhysicalConstants.getStreamlinedHalfBody());
    }

    @Test
    void getGravityAceleration() {
        assertEquals(9.8, PhysicalConstants.getGravityAceleration());
    }

    @Test
    void getFrictionalLossesK1() {
        assertEquals(0.0053, PhysicalConstants.getFrictionalLossesK1());
    }

    @Test
    void getAerodynamicDragK2() {
        assertEquals(1.100, PhysicalConstants.getAerodynamicDragK2());
    }

    @Test
    void getAirDensity() {
        assertEquals(1.225, PhysicalConstants.getAirDensity());
    }

    @Test
    void getCRR() {
        assertEquals(0.0045, PhysicalConstants.getCRR());
    }
}
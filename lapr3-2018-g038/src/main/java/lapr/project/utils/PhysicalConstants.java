package lapr.project.utils;

public class PhysicalConstants {

    public PhysicalConstants() {
    }

    public static final double DragCoefficientStreamlined_Body = 1.4;
    public static final double STREAMLINED_HALF_BODY = 1.004;
    public static final double GRAVITY_ACELERATION = 9.8;
    public static final double frictionalLossesK1 = 0.0053;
    public static final double aerodynamicDragK2 = 1.100;
    public static final double AIR_DENSITY = 1.225;
    public static final double CRR = 0.0045;


    public static double getDragCoefficientStreamlined_Body() {
        return DragCoefficientStreamlined_Body;
    }

    public static double getStreamlinedHalfBody() {
        return STREAMLINED_HALF_BODY;
    }

    public static double getGravityAceleration() {
        return GRAVITY_ACELERATION;
    }

    public static double getFrictionalLossesK1() {
        return frictionalLossesK1;
    }

    public static double getAerodynamicDragK2() {
        return aerodynamicDragK2;
    }

    public static double getAirDensity() {
        return AIR_DENSITY;
    }

    public static double getCRR() {
        return CRR;
    }
}

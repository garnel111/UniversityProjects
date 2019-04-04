package lapr.project.utils;

public class CalcForCalories {

    public static double calculateTimeOfTrip(double vr, Double distance) {
        long timeOfTrip;
        double l = (distance / vr);
        return l;
    }

    public static double calculateEnergyConsumed(double power_pd_up, double timeOfTrip) {
        return power_pd_up * timeOfTrip;
    }
}

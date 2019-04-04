package lapr.project.utils;


import javafx.util.Pair;
import lapr.project.controller.ParkController;
import lapr.project.model.POI;
import lapr.project.model.Park;

import java.io.IOException;

import static lapr.project.utils.PhysicalConstants.*;
import static lapr.project.utils.PhysicalConstants.STREAMLINED_HALF_BODY;

public class TripHelper {

    private ParkController pkControlller = new ParkController();
    private Park park1 = new Park();
    private Park parkOrigin = new Park();
    private Park parkDestiny = new Park();
    private TripHelper trpHelper;

    public double totalPowerWithWind(double mass, double vrK, double vak, int wayDirection, double angle) {
        //http://www.tribology-abc.com/calculators/cycling.htm
        //https://www.gribble.org/cycling/power_v_speed.html
        trpHelper = new TripHelper();

        double vr = trpHelper.returnSIUnitVelocity(vrK);
        double va = trpHelper.returnSIUnitVelocity(vak);
        double CRR = PhysicalConstants.CRR;
        double g = PhysicalConstants.GRAVITY_ACELERATION;
        double cyclerMass = mass;
        double slope_angle = angle;

        double airDrag_PD = calculate_Pd(vr, va, wayDirection);
        double resistanceRolling_Pr = calculate_Pr(vr, mass, slope_angle, CRR);
        double climbingPower_Ps = calculate_Ps(vr, mass, slope_angle);

        return airDrag_PD + resistanceRolling_Pr + calculate_Ps(vr, mass, slope_angle);
    }


    public static double calculate_Pd(double vr, double va, int wayDirection) {
        if (wayDirection == 0) {
            return (0.5 * (AIR_DENSITY) * Math.pow(vr, 3) * STREAMLINED_HALF_BODY);
        } else {
            double air_Velocity = (wayDirectionIsPositive(wayDirection) ? sumVa(va, vr) : subVa(va, vr));
            return (0.5 * (AIR_DENSITY) * Math.pow(air_Velocity, 2) * vr * STREAMLINED_HALF_BODY);
        }
    }

    public static double sumVa(double va, double vr) {
        return va + vr;
    }

    public static double subVa(double va, double vr) {
        return va - vr;
    }

    public static boolean wayDirectionIsPositive(int wayDirection) {
        if (wayDirection == 1) {
            return true;
        }
        if (wayDirection == -1) {
            return false;
        } else {
            throw new IllegalArgumentException("Cann´t be different of 1 or -1");
        }

    }

    public static double calculate_Pr(double vr, double mass, double angle1, double CRR) {
        return (vr * mass * GRAVITY_ACELERATION * Math.cos(Math.atan(angle1)) * PhysicalConstants.CRR);
    }

    /*
     * Climbing power
     */

    public static double calculate_Ps(double vr, double mass, double angle1) {

        double andgle = Math.abs(angle1);
        return (vr * mass * GRAVITY_ACELERATION * Math.sin(Math.atan(angle1)));


    }


    public double returnSIUnitVelocity(double vr) {
        return ((vr * 1000) / 3600);
    }

    public Pair<Park, Park> getParksPair(String parkOrigin, String parkDestiny) {


        Park originPark = park1.getParkByName(parkOrigin);

        Park destinyPark = park1.getParkByName(parkDestiny);
        Pair<Park, Park> parksConnected = new Pair<Park, Park>(originPark, destinyPark);
        return parksConnected;
    }

    public Pair<Double, Double> getDistanceBetweenParksAndRespectiveAltitudes(String originPark, String destinyPark) throws IOException {
        Park origin = getParksPair(originPark, destinyPark).getKey();
        Park destiny = getParksPair(originPark, destinyPark).getValue();
        double altitude = getAltitudeBetweenTwoParks(getAltitude(origin), getAltitude(destiny));

        double distanceBetweenParks = CalcMethods.calcDistanceBetweenCoordinates(origin.getLatitude(), origin.getLongitude(), destiny.getLatitude(), origin.getLongitude());
        Pair<Double, Double> distanceAndAltitude = new Pair<Double, Double>(altitude, distanceBetweenParks);
        return distanceAndAltitude;
    }

    public double getAltitudeBetweenTwoParks(double altitudeOrigin, double altitudeDestiny) {
        return (altitudeDestiny - altitudeOrigin);
    }

    public double getAltitude(Park park) throws IOException {
        return (CalcMethods.calcPointElevation(park.getLatitude(), park.getLongitude()));

    }

    public double calculateAngleSlope(String originPark, String destinyPark) throws IOException {
        double y = getDistanceBetweenParksAndRespectiveAltitudes(originPark, destinyPark).getKey();
        double d = getDistanceBetweenParksAndRespectiveAltitudes(originPark, destinyPark).getValue();
        return (y / (Math.sqrt(Math.pow(d, 2) - Math.pow(y, 2))));
    }

    public void setParkController(ParkController parkController) {
        this.pkControlller = parkController;
    }

    public void setParkOrigin(Park parkOrigin) {
        this.parkOrigin = parkOrigin;
    }

    public void setPArkDestiny(Park parkDestiny) {
        this.parkDestiny = parkDestiny;
    }

    public double totalPowerWithoutWind(double vrK) {

        double vr = returnSIUnitVelocity(vrK);

        return (0.5 * (AIR_DENSITY) * Math.pow(vr, 3) * STREAMLINED_HALF_BODY);
    }

    public Pair<Double, Double> getDistanceBetweenPOIAndRespectiveAltitudes(String poiOrigin, String poiDestiny) throws IOException {
        POI origin = getPoi_Pair(poiOrigin, poiDestiny).getKey();
        POI destiny = getPoi_Pair(poiOrigin, poiDestiny).getValue();
        double altitude = getAltitudeBetweenTwoPois(getPOIAltitude(origin), getPOIAltitude(destiny));

        double distanceBetweenParks = CalcMethods.calcDistanceBetweenCoordinates(origin.getLatitude(), origin.getLongitude(), destiny.getLatitude(), origin.getLongitude());
        Pair<Double, Double> distanceAndAltitude = new Pair<Double, Double>(altitude, distanceBetweenParks);
        return distanceAndAltitude;


    }

    public double getAltitudeBetweenTwoPois(double poi1Altitude, double poi2Altitude) {
        return (poi2Altitude - poi1Altitude);
    }

    public double getPOIAltitude(POI origin) throws IOException {
        return (origin != null ? (CalcMethods.calcPointElevation(origin.getLatitude(), origin.getLongitude())) : -1000);
    }

    public Pair<POI, POI> getPoi_Pair(String poiOrigin, String poiDestiny) {
        POI poi = new POI();
        POI originPOI = poi.getPOIByName(poiOrigin);
        POI destinyPOOI = poi.getPOIByName(poiDestiny);
        Pair<POI, POI> poisConnected = new Pair<POI, POI>(originPOI, destinyPOOI);
        return poisConnected;
    }
}

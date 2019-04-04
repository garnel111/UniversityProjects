package lapr.project.assessment;

import lapr.project.data.mapGraph.Graph;
import lapr.project.controller.AdministratorController;
import lapr.project.controller.ParkController;
import lapr.project.controller.RouteController;
import lapr.project.model.*;
import lapr.project.utils.CalcMethods;

import java.io.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Facade implements Serviceable {

    static int contagem;

    @Override
    public int addBicycles(String s) {
        return 0;
    }

    @Override
    public int addParks(String s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int addPOIs(String s) {

        return 0;
    }

    @Override
    public int addUsers(String s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int addPaths(String s) {
        return 0;
    }

    @Override
    public int getNumberOfBicyclesAtPark(double v, double v1, String s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getFreeSlotsAtPArk(double v, double v1, String s) {
        throw new UnsupportedOperationException();
    }

    /**
     * Distance is returns in metres, rounded to the unit e.g. (281,58 rounds
     * to 282);
     *
     * @param v  Latitude in degrees.
     * @param v1 Longitude in degrees.
     * @param s  Filename for output.
     */
    @Override
    public void getNearestParks(double v, double v1, String s) {
        BufferedWriter writer = null;
        ParkController pC = new ParkController();
        int x = 5;//number of parks to present
        pC.setUserLat((float) v);
        pC.setUserLong((float) v1);
        List<Map<String, Float>> nearest = new ArrayList<>();
        FileWriter f = null;
        try {
            nearest = pC.nearestParks(x);//Calcula os parques mais próximos
            writer = new BufferedWriter(f = new FileWriter(s));
            for (Map<String, Float> m : nearest) {
                Park p = pC.getParkByName(m.entrySet().iterator().next().getKey());

                writer.write(String.valueOf(p.getLatitude()) + ",");
                writer.write(String.valueOf(p.getLongitude()) + ",");
                writer.write(String.valueOf(m.entrySet().iterator().next().getValue()));
                writer.newLine();
            }
            writer.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(f!=null) f.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int distanceTo(double v, double v1, double v2, double v3) {
        int dist = 0;
        try {
            dist = Math.round((float) CalcMethods.calcDistanceBetweenCoordinates((float) v, (float) v1, (float) v2, (float) v3));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dist;
    }

    @Override
    public long unlockBicycle(String s, String s1) {
        return 0;
    }

    @Override
    public long lockBicycle(String s, double v, double v1) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double getUserCurrentDebt(String s, String s1) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double getUserCurrentPoints(String s, String s1) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long unlockAnyBicycleAtPark(double v, double v1, String s,
                                       String s1) {
        return 0;
    }

    @Override
    public long unlockAnyElectricBicycleAtPark(double v, double v1, String s,
                                               String s1) {
        return 0;
    }

    @Override
    public double calculateElectricalEnergyToTravelFromOneLocationToAnother(
            double v, double v1, double v2, double v3, String s) {
        return 0;
    }

    @Override
    public int suggestElectricalBicyclesToGoFromOneParkToAnother(double v,
                                                                 double v1,
                                                                 double v2,
                                                                 double v3,
                                                                 String s,
                                                                 String s1) {
        return 0;
    }

    @Override
    public long forHowLongWasTheBicycleUnlocked(String s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long shortestRouteBetweenTwoParks(double v, double v1, double v2, double v3, String s) {
        BufferedWriter writer = null;
        RouteController rc;
        ParkController pc;
        FileWriter f = null;
        try {
            writer = new BufferedWriter(f = new FileWriter(s));
            pc = new ParkController();
            Park p0 = pc.getParkByCoordinates(BigDecimal.valueOf(v), BigDecimal.valueOf(v1));
            Park p1 = pc.getParkByCoordinates(BigDecimal.valueOf(v2), BigDecimal.valueOf(v3));


            rc = new RouteController(p0, p1, "Shortest");


            Route r = rc.calculateRoute();
            Graph<Location, String> g = r.getPercurso();
            Location next = g.outgoingEdges(new Location(p0)).iterator().next().getVDest();
            //Origem p0
            writer.write(p0.getName() + " -> ");
            while (next != new Location(p1)) {
                writer.write(next.getName() + " -> ");
                next = g.outgoingEdges(next).iterator().next().getVDest();

            }
            writer.write(p1.getName());


            writer.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(f!=null) f.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return 0;
    }

    @Override
    public long mostEnergyEfficientRouteBetweenTwoParks(double v, double v1,
                                                        double v2, double v3,
                                                        String s, String s1,
                                                        String s2) {
        return 0;
    }

    @Override
    public long shortestRouteBetweenTwoParksForGivenPOIs(double v, double v1,
                                                         double v2, double v3,
                                                         String s, String s1) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long getParkChargingReportForPark(double v, double v1, String s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int suggestRoutesBetweenTwoLocations(double v, double v1, double v2,
                                                double v3, String s, String s1,
                                                int i, boolean b, String s2,
                                                String s3, String s4) {
        return 0;
    }

    @Override
    public double getInvoiceForMonth(int i, String s, String s1) {
        throw new UnsupportedOperationException();
    }

    /*
     * Helper Methods to method addByke
     */
    private boolean parkExist(Park park) {
        AdministratorController admCtrl = new AdministratorController();
        return (admCtrl.verifyParkExistence(park));
    }

}

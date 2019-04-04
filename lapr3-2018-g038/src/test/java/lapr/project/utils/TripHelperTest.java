package lapr.project.utils;

import javafx.util.Pair;
import lapr.project.controller.BicycleController;
import lapr.project.controller.ParkController;
import lapr.project.controller.RouteController;
import lapr.project.data.ParkDB;
import lapr.project.data.PoiDB;
import lapr.project.data.TripDb;
import lapr.project.data.UserDB;
import lapr.project.model.Bicycle;
import lapr.project.model.POI;
import lapr.project.model.Park;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


//@RunWith(PowerMockRunner.class)
//@PrepareForTest(Static.class)
public class TripHelperTest {

    /*
     * Trip controller
     */

    public TripHelperTest() {

            //PROPRIEDADES DA BASE DE DADOS (NÃO COMENTAR!)
            //load database properties
            try {
                Properties properties
                        = new Properties(System.getProperties());
                InputStream input = new FileInputStream("target/classes/application.properties");
                properties.load(input);
                input.close();
                System.setProperties(properties);

            } catch (IOException e) {
                e.printStackTrace();
            }
//FIM DAS PROPRIEDADES DA BASE DE DADOS



    }


    /*
     * Start tests fot PD
     */
    @Test
    public void testGetSumWithPositiveValues() {
        System.out.println("test GetSum WithPositive Values");
        double va = 25;
        double vr = 50;
        TripHelper.sumVa(25, 50);
        double result = TripHelper.sumVa(25, 50);
        double expectedResult = 75;
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetSumWithNullValues() {
        System.out.println("test GetSum With Null Values");
        double va = 0;
        double vr = 0;

        double result = TripHelper.sumVa(va, vr);
        double expectedResult = 0;
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetSumWithNegativeValues() {
        System.out.println("test GetSum WithNegative Values");
        double va = -10;
        double vr = -12;
        double result = TripHelper.sumVa(va, vr);
        double expectedResult = -22;
        assertEquals(expectedResult, result);

    }

    @Test
    public void testGetSumWithBigValues() {
        System.out.println("test GetSum With Big Values");
        double va = 1000000000;
        double vr = 999999999;
        double result = TripHelper.sumVa(va, vr);
        double expectedResult = 1.999999999E9;
        assertEquals(result, expectedResult);
    }


    @Test
    public void wayDirectionIsPositiveAndResultShouldBeTrue() {
        System.out.println("Test wayDirectionIsPositive should return true");

        int wayDirection = 1;
        boolean result = true;

        assertTrue(TripHelper.wayDirectionIsPositive(wayDirection));

    }

    @Test
    public void wayDirectionIsPositiveAndResultShouldBeFalse() {
        System.out.println("Test wayDirectionIsPositive should be false");

        int wayDirection = -1;
        boolean result = false;

        assertFalse(TripHelper.wayDirectionIsPositive(wayDirection));

    }

    @Test()
    public void wayDirectionIsPositiveAndResultShouldThrowException() {
        System.out.println("Test wayDirectionIsPositiveAndResultShouldThrowException");

        boolean thrown = false;
        try {
            int wayDirection = 0;

            TripHelper.wayDirectionIsPositive(wayDirection);

        } catch (IllegalArgumentException e) {
            thrown = true;

        }
        assertTrue(thrown);

    }

    @Test
    public void testGetSubWithPositiveValues() {
        System.out.println("test GetSub With Positive Values");
        double va = 25;
        double vr = 50;
        TripHelper.subVa(25, 50);
        double result = TripHelper.subVa(25, 50);
        double expectedResult = -25;
        assertEquals(expectedResult, result);
    }


    @Test
    public void calculatePd() {
        /*
         * Air drag (PD)
         */
        System.out.println("Test calculate Pd");
        TripHelper tripHelper = new TripHelper();
        double result = 765.625;
        double mass = 71;
        double resultPD_PR = 10071.864331811385;
        double expectedResult = tripHelper.totalPowerWithWind(mass, 50, 25, -1, 30);
        System.out.println("especte" + expectedResult);
        assertEquals(resultPD_PR, expectedResult);
    }

    /*
     * Start tests fot ____
     */
    @Test
    public void calculatePowerWithPositiveValues() {
        System.out.println("Power with wind  and positive values");
        TripHelper tripHelper = new TripHelper();
        double power_PD = tripHelper.totalPowerWithWind(71, 50, 25, 1, 0.17);
        System.out.println("power:\t" + power_PD + " W");
        assertEquals(5369.515831460256, power_PD);

    }

    @Test
    public void calculatePowerWayDirectionNegativeValue() {
        System.out.println("Power with wind and negative way direction");
        TripHelper tripHelper = new TripHelper();
        double power_PD = tripHelper.totalPowerWithWind(71, 50, 25, -1, 0.17);
        System.out.println("power:\t" + power_PD + " W");

        assertEquals(2074.3876593066198, power_PD);

    }

    @Test
    public void calculatePowerMassNull() {
        System.out.println("Power with wind and negative way direction");
        TripHelper tripHelper = new TripHelper();
        double power_PD = tripHelper.totalPowerWithWind(0, 50, 25, -1, 0.17);
        System.out.println("power:\t" + power_PD + " W");

        assertEquals(411.89102151920446, power_PD);

    }

    @Test
    public void calculatePowerWithWayNull() {
        System.out.println("Power with wind and nullway direction");
        TripHelper tripHelper = new TripHelper();
        double power_PD = tripHelper.totalPowerWithWind(0, 50, 25, 0, 0.17);
        System.out.println("power:\t" + power_PD + " W");

        assertEquals(1647.5640860768176, power_PD);
    }

    @Test
    public void calculatePs() {
        System.out.println("Calculate Ps");
        double result = TripHelper.calculate_Ps(25, 70, 0.14);

        assertEquals(2377.810533765067, result);
    }

    @Test
    public void testcalculateAltitude() throws IOException {
        System.out.println("Test calculate altitude");
        TripHelper tHelper = new TripHelper();


        ParkController pc = new ParkController();
        ParkDB pdb = mock(ParkDB.class);
        pc.setParkDataBase(pdb);

        Park park1 = new Park();
        park1.setName("p1");
        park1.setLatitude(41.177384F);
        park1.setLongitude(-8.608033F);

        double expectedResult = tHelper.getAltitude(park1);
        double result = 108.5596160888672;
        assertEquals(result, expectedResult);

    }

    @Test
    public void testgetParksByName() throws IOException {
        System.out.println("Test get parks by name");
        Park park1 = new Park();
        park1.setName("Isep_Park");
        park1.setId(1);
        Park park2 = new Park();
        park2.setName("FCUP_Park");
        park2.setId(2);
        TripHelper tHelper = new TripHelper();
        ParkController parkController = mock(ParkController.class);
        tHelper.setParkController(parkController);

        when(parkController.getParkByName("Isep_Park")).thenReturn(park1);
        when(parkController.getParkByName("FCUP_Park")).thenReturn(park2);
        Park parkA = parkController.getParkByName("Isep_Park");
        Park parkB = parkController.getParkByName("FCUP_Park");
        assertEquals(park1, parkA);
        assertEquals(park2, parkB);

    }


    @Test
    public void testgetParkDestinyByValue() {
        System.out.println("Test get ParkDestiny By Value");
        long trip_Id = 100000000;

        UserDB userDB = mock(UserDB.class);
        TripDb tripDb = mock(TripDb.class);
        ParkDB parkDB = mock(ParkDB.class);
        Park parkOrigin = mock(Park.class);
        Park parkDestiny = mock(Park.class);

        TripHelper trpHelper = new TripHelper();
        trpHelper.setParkOrigin(parkOrigin);
        trpHelper.setPArkDestiny(parkDestiny);

        Park t1 = new Park();
        t1.setName("ISEP_PARK");

        Park t2 = new Park();
        t2.setName("FCUP_PARK");


        when(parkOrigin.getParkByName("ISEP_PARK")).thenReturn(t1);
        when(parkDestiny.getParkByName("FCUP_PARK")).thenReturn(t2);
        Park parkOriginReturned = parkOrigin.getParkByName("ISEP_PARK");
        Park parkDestinyReturned = parkDestiny.getParkByName("FCUP_PARK");
        Pair<Park, Park> parksConnected = new Pair<Park, Park>(parkOriginReturned, parkDestinyReturned);
        assertEquals("ISEP_PARK", parksConnected.getKey().getName());
        assertEquals("FCUP_PARK", parksConnected.getValue().getName());

    }

    @Test
    public void testcalculateAngleSlope() throws IOException {
        System.out.println("Calculate angle slope test");
        TripHelper trpHelper = mock(TripHelper.class);
        when(trpHelper.getDistanceBetweenParksAndRespectiveAltitudes("ISEP_PARK", "FCUP_PARK")).thenReturn(new Pair<Double, Double>(2.300, 1.200));
        trpHelper.getDistanceBetweenParksAndRespectiveAltitudes("ISEP_PARK", "FCUP_PARK");
        double expectedResult = trpHelper.calculateAngleSlope("ISEP_PARK", "FCUP_PARK");
        assertEquals(expectedResult, 0.00);

    }

    @Test
    public void testcalculateTotalPowerWithoutWind() throws IOException {
        System.out.println("Calculate total power without wind");
        TripHelper tripHelper = new TripHelper();

        double result = 205.9455107596022;
        double expectedResult = tripHelper.totalPowerWithoutWind(25);
        System.out.println("Expected Power: " + expectedResult);
        assertEquals(expectedResult, result);

    }

    @Test
    public void testcalculateTotalPowerWithWindWithHighVelocity() throws IOException {
        System.out.println("Calculate total power without wind and high velocity");
        TripHelper tripHelper = new TripHelper();

        double result = 2.059455107596022E11;
        double expectedResult = tripHelper.totalPowerWithoutWind(25000);
        System.out.println("Expected Power: " + expectedResult);
        assertEquals(expectedResult, result);

    }

    @Test
    public void testcalculateTotalPowerWithoutWindWithNegativeVelocity() throws IOException {
        System.out.println("Calculate total power without wind and negative high velocity");
        //TripHelper trpHelper = mock(TripHelper.class);
TripHelper tripHelper = new TripHelper();
        double result = -2.059455107596022E11;
        double expectedResult = tripHelper.totalPowerWithoutWind(-25000);
        System.out.println("Expected Power: " + expectedResult);
        assertEquals(expectedResult, result);

    }


    @Test
    public void testCalculateAngleSlope() throws IOException {

        System.out.println("testCalculateAngleSlope");
        Bicycle bicycle = new Bicycle();
        bicycle.setType("Electric");
        String nameParkOrigin = "ISEP_PArk";
        String nameParkDestiny = "FCUP_PARK";

        BicycleController bicycleController = mock(BicycleController.class);
        TripHelper tripHelper = mock(TripHelper.class);//Criação da classe mock
        Pair<Double, Double> pairVAlues = new Pair<>(2.5, 3.5);

        when(tripHelper.getDistanceBetweenParksAndRespectiveAltitudes(nameParkOrigin, nameParkDestiny)).thenReturn(pairVAlues);
        when(tripHelper.calculateAngleSlope(nameParkOrigin, nameParkDestiny)).thenCallRealMethod();

        double result = tripHelper.calculateAngleSlope(nameParkOrigin, nameParkDestiny);
        assertEquals(result, 1.0206207261596576);


    }


    @Test
    public void testGetAltitudeBetweenTwoParksShouldReturneValue() {
        System.out.println("testGetAltitudeBetweenTwoParksShouldReturneValue ");
        double altitudeOrigin = 10;
        double altitudeDestiny = 20;
        TripHelper trpHelper = new TripHelper();
        double expectedResult = 10;

        double result = trpHelper.getAltitudeBetweenTwoParks(altitudeOrigin, altitudeDestiny);

        assertEquals(expectedResult, result);


    }

    @Test
    public void testGetAltitudeBetweenTwoParksShouldNegativeReturneValue() {
        System.out.println("testGetAltitudeBetweenTwoParksShouldNegativeReturneValue ");
        double altitudeOrigin = 20;
        double altitudeDestiny = 10;
        TripHelper trpHelper = new TripHelper();
        double expectedResult = -10;

        double result = trpHelper.getAltitudeBetweenTwoParks(altitudeOrigin, altitudeDestiny);

        assertEquals(expectedResult, result);
    }


    @Test
    public void testGetParks_Pair() throws IOException {
        System.out.println("test GET getParksPair");
        // TripHelper trpHelper = new TripHelper();
        Park park = mock(Park.class);
        Park parkOrigin = new Park();
        Park parkDestiny = new Park();
        TripHelper tripHelper = mock(TripHelper.class);//Criação da classe mock
        when(park.getParkByName("ISEP_PARK")).thenReturn(parkOrigin);
        when(park.getParkByName("FCUP_PARK")).thenReturn(parkDestiny);

        Pair<Park, Park> parksConnected = new Pair<>(park.getParkByName("ISEP_PARK"), park.getParkByName("FCUP_PARK"));
        Pair<Park, Park> result = tripHelper.getParksPair("ISEP_PARK", "FCUP_PARK");

        assertNull(result);
    }


    @Test
    public void testGetParks_P() throws IOException {
        System.out.println("test GET getParksPair");
        // TripHelper trpHelper = new TripHelper();
        Park park = mock(Park.class);
        Park parkOrigin = new Park();
        parkOrigin.setLatitude(1231242);
        parkOrigin.setLongitude(32523532);
        parkOrigin.setId(1);
        parkOrigin.setMaxCapacityElectric(2);
        parkOrigin.setAdmin_Id(2);
        parkOrigin.setName("ISEP_PARK");

        Park parkDestiny = new Park();
        parkDestiny.setLatitude(12331242);
        parkDestiny.setLongitude(32523532);
        parkDestiny.setId(2);
        parkDestiny.setMaxCapacityElectric(23);
        parkDestiny.setAdmin_Id(232);
        parkDestiny.setName("FCUP_PARK");
        TripHelper tripHelper = mock(TripHelper.class);//Criação da classe mock
        when(park.getParkByName("ISEP_PARK")).thenReturn(parkOrigin);
        when(park.getParkByName("FCUP_PARK")).thenReturn(parkDestiny);
        when(tripHelper.getParksPair(park.getParkByName("ISEP_PARK").getName(),  park.getParkByName("FCUP_PARK").getName())).thenCallRealMethod();
          parkOrigin = park.getParkByName("ISEP_PARK");
        parkDestiny =park.getParkByName("FCUP_PARK");
        Pair<Park, Park> parksConnected = new Pair<>(parkOrigin,parkDestiny);
        Pair<Park, Park> result = tripHelper.getParksPair(park.getName(), parkDestiny.getName());

        assertNull(result);
    }
    @Test
    public void testGetAltitudeBetweenTwoPOIShouldNegativeReturneValue() {
        System.out.println("test Get Altitude Between Two POI Should Be Negative Return Value ");
        double altitudeOrigin = 20;
        double altitudeDestiny = 10;
        TripHelper trpHelper = new TripHelper();
        double expectedResult = 10;

        double result = trpHelper.getAltitudeBetweenTwoPois(altitudeDestiny, altitudeOrigin);

        assertEquals(expectedResult, result);
    }
    @Test
    public void testGetPOIALtitude() throws IOException {
TripHelper trpHelper = new TripHelper();
        POI poi = new POI();
        poi.setLatitude((float) 2.34324234);
        poi.setLongitude((float) 5.342353454);


        CalcMethods.calcPointElevation(2.34324234f, 5.342353454f);
        trpHelper.getPOIAltitude(poi);

        assertEquals(3415.228515625, trpHelper.getPOIAltitude(poi));
    }


    @Test
    void getPoi_Pair() {
        TripHelper th = new TripHelper();
        POI poi = new POI();
        POI po = new POI();
        POI pd = new POI();
        PoiDB pdb = mock(PoiDB.class);
        when(pdb.getPoiByName("teste")).thenReturn(po);
        when(pdb.getPoiByName("teste2")).thenReturn(pd);


        poi.setPOIDB(pdb);

        Pair<POI,POI> exp = new Pair<>(null,null);

        assertEquals(exp,th.getPoi_Pair("teste","teste2"));

    }

}
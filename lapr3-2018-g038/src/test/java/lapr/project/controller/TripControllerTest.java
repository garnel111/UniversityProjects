/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.io.IOException;
import java.sql.SQLException;

import javafx.util.Pair;
import lapr.project.data.*;
import lapr.project.model.*;
import lapr.project.utils.TripHelper;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

/**
 * @author manuel.garnel
 */
public class TripControllerTest {

    public TripControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetUserMass() {
        TripController tripCtrl = new TripController();
        User user = new User();
        UserDB userDbMocked = mock(UserDB.class);
        long user_Id = 600000;
        long request_Id = 500000;
        long bicycle_Id = 600;

        long originPark_Id = 400;
        long destinationPark_Id = 401;
        User user1 = new User();
        user1.setUsername("Manuel");
        user1.setEmail("1131325@isep.ipp.pt");
        user1.setCardNumber("155555521");
        user1.setPassword("qwertyManuel");
        user1.setHeight(1.69);
        user1.setIdUser(5050);
        user1.setWeight(71);
        user1.setPoints(30);
        Trip trip1 = new Trip();
        trip1.setUserId(user_Id);
        trip1.setBicycle_Id(bicycle_Id);
        trip1.setOriginalPark_Id(originPark_Id);
        trip1.setDestinationPark_Id(destinationPark_Id);
        Trip trip = new Trip(user_Id, request_Id, bicycle_Id, originPark_Id, destinationPark_Id);
        double weight = 0.05;
        when(userDbMocked.getUserMass("Manuel")).thenReturn(weight);
        double result = userDbMocked.getUserMass("Manuel");
        user.setWeight(result);
        assertEquals(0.05, result);
        verify(userDbMocked, atLeastOnce()).getUserMass("Manuel");
    }

    @Test
    public void testGetUserMassShouldBeNotNull() {

        TripController tripCtrl = mock(TripController.class);
        User user = new User();
        user.setUsername("Manuel");
        UserDB userDbMocked = mock(UserDB.class);
        tripCtrl.setUserDB(userDbMocked);
        double weight = -122;
        double expectedResult = -0.000001;
        when(userDbMocked.getUserMass("Manuel")).thenReturn(weight);
        when(tripCtrl.getUserMass(user)).thenReturn(weight);
        assertNotEquals(expectedResult, userDbMocked.getUserMass("Manuel"));
        double result2 = tripCtrl.getUserMass(user);
        assertNotEquals(expectedResult, result2);
        verify(userDbMocked, atLeastOnce()).getUserMass("Manuel");
        verify(tripCtrl, atLeastOnce()).getUserMass(user);

    }

    @Test
    public void testGetUserMassShouldBePositive() {

        TripController tripCtrl = mock(TripController.class);
        User user = new User();
        user.setUsername("Manuel1");
        UserDB userDbMocked = mock(UserDB.class);
        tripCtrl.setUserDB(userDbMocked);
        double weight = 0;
        double expectedResult = 0;
        when(userDbMocked.getUserMass("Manuel1")).thenReturn(weight);
        when(tripCtrl.getUserMass(user)).thenReturn(weight);
        assertEquals(expectedResult, userDbMocked.getUserMass("Manuel1"));
        double result2 = tripCtrl.getUserMass(user);
        assertEquals(expectedResult, result2);
        verify(userDbMocked, atLeastOnce()).getUserMass("Manuel1");
        verify(tripCtrl, atLeastOnce()).getUserMass(user);

    }

//    @Test
//    public void testGetValues() throws IOException {
//
//        TripController tripCtrl = mock(TripController.class);
//        User user = new User();
//        user.setUsername("Manuel1");
//        UserDB userDbMocked = mock(UserDB.class);
//        tripCtrl.setUserDB(userDbMocked);
//        double weight = 0;
//        double expectedResult = 1000.000;
//        when(tripCtrl.getEnergyBurnedBetweenTwoParks(60000, user, 50, 25)).thenReturn(1000.000);
//        double result = tripCtrl.getEnergyBurnedBetweenTwoParks(60000, user, 50, 25);
//        assertEquals(expectedResult, result);
//
//
//    }

//    @Test
//    public void testGetHighValues() throws IOException {
//
//        TripController tripCtrl = mock(TripController.class);
//        User user = new User();
//        user.setUsername("Manuel1");
//        UserDB userDbMocked = mock(UserDB.class);
//        tripCtrl.setUserDB(userDbMocked);
//
//        double expectedResult = 999999999.9999999;
//        when(tripCtrl.getEnergyBurnedBetweenTwoParks(999999999, user, 50, 25)).thenReturn(999999999.9999999);
//        double result = tripCtrl.getEnergyBurnedBetweenTwoParks(999999999, user, 50, 25);
//        assertEquals(expectedResult, result);
//
//
//    }

    @Test
    public void testgetParkOrigin() {

        long trip_Id = 100000000;
        System.out.println("test get ParkOrigin");
        TripDb tripDb = mock(TripDb.class);
        ParkDB parkDB = mock(ParkDB.class);
        TripController trpCtrl = new TripController();
        trpCtrl.setTripDb(tripDb);
        trpCtrl.setParkDB(parkDB);
        long park_Id = 2000000000;
        long parkOr = 1000;
        long parkDest = 2000;
        String parkOrigin = "ISEP_PARK";
        Pair<Long, Long> originAndDestinyPArks = new Pair<>(parkOr, parkDest);
        Pair<Long, Long> originAndDestinyParksResult = null;
        when(tripDb.getOriginAndDestinyParksIdByTripId(trip_Id)).thenReturn(originAndDestinyPArks);

        originAndDestinyParksResult = tripDb.getOriginAndDestinyParksIdByTripId(trip_Id);
        long keyResult = originAndDestinyParksResult.getKey();
        long valueResult = originAndDestinyParksResult.getValue();
        assertEquals(parkOr, keyResult);
        assertEquals(parkDest, valueResult);


    }

    @Test
    public void testgetParkOriginByKey() {
        System.out.println("Test get ParkOrigin ByKey");
        long trip_Id = 100000000;
        System.out.println("test get ParkOrigin Two");
        TripDb tripDb = mock(TripDb.class);
        ParkDB parkDB = mock(ParkDB.class);
        TripController trpCtrl = new TripController();
        trpCtrl.setTripDb(tripDb);
        trpCtrl.setParkDB(parkDB);
        long park_Id = 2000000000;
        long parkOr = 1000;
        long parkDest = 2000;
        String parkOrigin = "ISEP_PARK";
        Pair<Long, Long> originAndDestinyPArks = new Pair<>(parkOr, parkDest);
        Pair<Long, Long> originAndDestinyParksResult = null;
        when(tripDb.getOriginAndDestinyParksIdByTripId(trip_Id)).thenReturn(new Pair<Long, Long>(parkOr, parkDest));
        originAndDestinyParksResult = tripDb.getOriginAndDestinyParksIdByTripId(trip_Id);
        long originAndDestinyPArksTeste = originAndDestinyParksResult.getKey();
        long expectedResult = 1000;
        assertEquals(expectedResult, originAndDestinyPArksTeste);
    }

//    @Test
//    public void testgetParkOriginByValue() {
//        System.out.println("Test get ParkDestiny By Value");
//        long trip_Id = 100000000;
//
//        UserDB userDB = mock(UserDB.class);
//        TripDb tripDb = mock(TripDb.class);
//        ParkDB parkDB = mock(ParkDB.class);
//
//        TripController trpCtrl = new TripController();
//        trpCtrl.setTripDb(tripDb);
//        trpCtrl.setParkDB(parkDB);
//        trpCtrl.setUserDB(userDB);
//
//        long park_Id = 2000000000;
//        long parkOr = 1000;
//        long parkDest = 2000;
//        String parkOrigin = "ISEP_PARK";
//        Park pkOrigin = new Park();
//        pkOrigin.setName(parkOrigin);
//        Pair<Long, Long> originAndDestinyPArks = new Pair<>(parkOr, parkDest);
//        Pair<Long, Long> originAndDestinyParksResult = null;
//
//        when(tripDb.getOriginAndDestinyParksIdByTripId(trip_Id)).thenReturn(new Pair<>(parkOr, parkDest));
//        when(parkDB.getParkByName("parkOr")).thenReturn(pkOrigin);
//
//        originAndDestinyParksResult = tripDb.getOriginAndDestinyParksIdByTripId(trip_Id);
//
//        long originAndDestinyPArksTeste = originAndDestinyParksResult.getKey();
//        Park parkOriginResult = parkDB.getParkByName("parkOr");
//        String park = trpCtrl.getParkOrigin(trip_Id);
//        String park2 = trpCtrl.getParkDestiny(trip_Id);
//
//        String expectedResult = "ISEP_PARK";
//        assertEquals(expectedResult, parkOriginResult.getName());
//        assertNull(park);
//
//        assertEquals(1000, originAndDestinyPArksTeste);
//
//    }

    @Test
    public void testgetParkDestinyByValue() {
        System.out.println("Test get ParkDestiny By Value");
        long trip_Id = 100000000;
        UserDB userDB = mock(UserDB.class);
        TripDb tripDb = mock(TripDb.class);
        ParkDB parkDB = mock(ParkDB.class);
        TripController trpCtrl = new TripController();
        trpCtrl.setTripDb(tripDb);
        trpCtrl.setParkDB(parkDB);
        trpCtrl.setUserDB(userDB);
        long park_Id = 2000000000;
        long parkOr = 1000;
        long parkDest = 2000;
        String parkOrigin = "ISEP_PARK";
        String pkDestiny = "FCUP_PARK";
        Park pkOrigin = new Park();
        Park parkDestiny = new Park();
        parkDestiny.setName("FCUP_PARK");
        pkOrigin.setName(parkOrigin);
        Pair<Long, Long> originAndDestinyPArks = new Pair<>(parkOr, parkDest);
        Pair<Long, Long> originAndDestinyParksResult = null;

        when(tripDb.getOriginAndDestinyParksIdByTripId(trip_Id)).thenReturn(new Pair<Long, Long>(parkOr, parkDest));
        when(parkDB.getParkByName("parkOr")).thenReturn(pkOrigin);
        when(parkDB.getParkByName("parkDestiny")).thenReturn(parkDestiny);


        originAndDestinyParksResult = tripDb.getOriginAndDestinyParksIdByTripId(trip_Id);

        long originAndDestinyPArksTeste = originAndDestinyParksResult.getValue();
        Park parkOriginResult = parkDB.getParkByName("parkOr");
        parkDB.getParkByName("parkDestiny");
        //String parkTESTEA =  trpCtrl.getParkDestiny(trip_Id);
        String expectedResult = "ISEP_PARK";
        assertEquals(expectedResult, parkOriginResult.getName());
        //assertNull(parkTESTEA);

        assertEquals(2000, originAndDestinyPArksTeste);
        verify(tripDb).getOriginAndDestinyParksIdByTripId(trip_Id);
        verify(parkDB).getParkByName("parkOr");
    }

    @Test
    public void testCalculateAmountCalories() {
        double energy = 4186;
        TripController trpCtrl = new TripController();
        double expectedResult = 1000;
        double result = trpCtrl.calculateAmountCalories(energy);
        assertEquals(result, expectedResult);
    }

/*
    @Test
    public void testgetParkPair() throws IOException {
        System.out.println("Test get Park Pair");
        long trip_Id = 100;

        UserDB userDBMocked = mock(UserDB.class);
        TripDb tripDbMocked = mock(TripDb.class);
        ParkDB parkDBMocked = mock(ParkDB.class);
        AtmosphericConditionsDB atmosphericConditionsDBMocked = mock(AtmosphericConditionsDB.class);
        TripHelper trpHelper = mock(TripHelper.class);
        TripController tripController = mock(TripController.class);

        //mocking getParkPair
        User user = new User();
        user.setWeight(70.00);
        user.setMass(70.00);

        Park originPark = new Park();
        originPark.setName("ISEP_PARK");
        originPark.setId(1);

        Park destinyPark = new Park();
        destinyPark.setName("FCUP_PARK");
        originPark.setId(2);
        Pair<Park, Park> originAndDestinyParks = new Pair<Park, Park>(originPark, destinyPark);

        when(tripController.getUserMass(user)).thenReturn(70.00);
        when(tripController.getParkPair(trip_Id, user)).thenReturn(new Pair<Park, Park>(originPark, destinyPark));
        Pair<Park, Park> originAndDestinyParks1 = tripController.getParkPair(trip_Id, user);

        // when(tripController.getParkPair(trip_Id, user).getKey()).thenReturn(originPark);
        // when(tripController.getParkPair(trip_Id, user).getValue()).thenReturn(destinyPark);
        when(trpHelper.calculateAngleSlope("ISEP_PARK", "FCUP_PARK")).thenReturn(1.25);
        when(trpHelper.returnSIUnitVelocity(25)).thenReturn(13.00);
        when(trpHelper.totalPowerWithWind(70, 25, 50, 1, 1.2)).thenReturn(13.00);

        assertEquals(0.00, tripController.getEnergyBurnedBetweenTwoParks(trip_Id, user, 25, 50));

    }
*/

    @Test
    public void testisBykeNonEletricShouldReturnTrue() {
        System.out.println("test is Byke Non Eletric should return true");

        TripController tripController = new TripController();
        String parkName = "";
        boolean expResult = true;

        String type = "Mountain";


        Bicycle b = new Bicycle(12, 200, type);


        boolean result = tripController.isBykeNonEletric(b);
        assertEquals(expResult, result);

    }

    @Test
    public void testisBykeNonEletricShouldReturnFalse() {
        System.out.println("test is Byke Non Eletric should return false");
        TripController tripController = new TripController();
        String parkName = "";
        boolean expResult = false;

        String type = "Electric";

        BicycleController bController = new BicycleController();

        Bicycle b = new Bicycle(12, 200, type);


        boolean result = tripController.isBykeNonEletric(b);
        assertEquals(expResult, result);

    }

    @Test
    public void testUpdateNonElectricShouldReturnExpectedResultTrue() throws SQLException {
        System.out.println("test is Byke Non Eletric should return true");

        long maxCap = 36;
        int counterNonElectricBicycle = 35;

        ParkDB pdb = mock(ParkDB.class);//Criação da classe mock
        BicycleDB bDB = mock(BicycleDB.class);
        TripController tController = new TripController();

        Park parkDestination = new Park();
        parkDestination.setName("FCUP_PARK");

        Bicycle bike = new Bicycle();

        Trip trip = new Trip();

        bike.setIdBicycle(12);
        bike.setType("Mountain");

        tController.setParkDB(pdb);
        tController.setbDB(bDB);

        when(bDB.countBikeByType(bike.getType(), parkDestination.getName())).thenReturn(35);
        when(pdb.getParkByName("FCUP_PARK")).thenReturn(parkDestination);
        when(pdb.updateBicycleOnDestinyPark(parkDestination, bike)).thenReturn(true);

        bDB.countBikeByType(bike.getType(), parkDestination.getName());
        pdb.getParkByName("FCUP_PARK");
        pdb.updateBicycleOnDestinyPark(parkDestination, bike);

        parkDestination.setMaxCapacityNonElectric(maxCap);

        long maxNonElectricCapacity = parkDestination.getMaxCapacityNonEletric();

        parkDestination = pdb.getParkByName("FCUP_PARK");

        counterNonElectricBicycle = bDB.countBikeByType(bike.getType(), parkDestination.getName());

        // boolean result = pdb.updateBicycleOnDestinyPark(parkDestination, bike);
        boolean result = tController.validateUpdate(counterNonElectricBicycle, maxNonElectricCapacity, pdb, parkDestination, bike);


        assertTrue(result);

    }

    @Test
    public void testUpdateNonElectricShouldReturnExpectedResultFalse() throws SQLException {
        System.out.println("test is Byke Non Eletric should return true");
        TripController tController = new TripController();
        long maxCap = 36;
        int counterNonElectricBicycle = 36;

        ParkDB pdb = mock(ParkDB.class);//Criação da classe mock
        BicycleDB bDB = mock(BicycleDB.class);
        BicycleController bController = new BicycleController();

        Park parkDestination = new Park();
        parkDestination.setName("FCUP_PARK");

        Bicycle bike = new Bicycle();

        Trip trip = new Trip();

        bike.setIdBicycle(12);
        bike.setType("Mountain");

        bController.setParkDB(pdb);
        bController.setbDB(bDB);

        when(bDB.countBikeByType(bike.getType(), parkDestination.getName())).thenReturn(35);
        when(pdb.getParkByName("FCUP_PARK")).thenReturn(parkDestination);
        when(pdb.updateBicycleOnDestinyPark(parkDestination, bike)).thenReturn(false);

        bDB.countBikeByType(bike.getType(), parkDestination.getName());
        pdb.getParkByName("FCUP_PARK");
        pdb.updateBicycleOnDestinyPark(parkDestination, bike);

        parkDestination.setMaxCapacityNonElectric(maxCap);

        long maxNonElectricCapacity = parkDestination.getMaxCapacityNonEletric();

        parkDestination = pdb.getParkByName("FCUP_PARK");

        counterNonElectricBicycle = bDB.countBikeByType(bike.getType(), parkDestination.getName());

        // boolean result = pdb.updateBicycleOnDestinyPark(parkDestination, bike);
        boolean result = tController.validateUpdate(35, 34, pdb, parkDestination, bike);


        assertFalse(result);

    }

    @Test
    public void testUpdateNonElectricShouldReturnExpectedResult() throws SQLException {
        System.out.println("test is Byke Non Eletric should return true");
        TripController tController = new TripController();
        long maxCap = 36;
        int counterNonElectricBicycle = 36;

        ParkDB pdb = mock(ParkDB.class);//Criação da classe mock
        BicycleDB bDB = mock(BicycleDB.class);
        BicycleController bController = new BicycleController();

        Park parkDestination = new Park();
        parkDestination.setName("FCUP_PARK");

        Bicycle bike = new Bicycle();

        Trip trip = new Trip();

        bike.setIdBicycle(12);
        bike.setType("Mountain");

        bController.setParkDB(pdb);
        bController.setbDB(bDB);

        when(bDB.countBikeByType(bike.getType(), parkDestination.getName())).thenReturn(35);
        when(pdb.getParkByName("FCUP_PARK")).thenReturn(parkDestination);
        when(pdb.updateBicycleOnDestinyPark(parkDestination, bike)).thenReturn(true);

        bDB.countBikeByType(bike.getType(), parkDestination.getName());
        pdb.getParkByName("FCUP_PARK");
        pdb.updateBicycleOnDestinyPark(parkDestination, bike);

        parkDestination.setMaxCapacityNonElectric(maxCap);
        long maxNonElectricCapacity = parkDestination.getMaxCapacityNonEletric();
        parkDestination = pdb.getParkByName("FCUP_PARK");
        counterNonElectricBicycle = bDB.countBikeByType(bike.getType(), parkDestination.getName());
        // boolean result = pdb.updateBicycleOnDestinyPark(parkDestination, bike);
        boolean result = tController.validateUpdate(35, 35, pdb, parkDestination, bike);
        assertFalse(result);

    }


    @Test

    public void updateParkAvailabilityShouldReturnTrue() throws SQLException {
        System.out.println("updateParkAvailabilityShouldReturnTrue");
        TripController tController = mock(TripController.class);
        Bicycle bicycle = new Bicycle();
        Trip trip = new Trip();
        Park destinationPark = new Park();
        BicycleController bicycleController = mock(BicycleController.class);
        when(tController.isBykeNonEletric(bicycle)).thenReturn(true);    // Mock implementation
        when(tController.updateNonElectric(bicycle, trip, destinationPark)).thenReturn(true);    // Mock implementation
        when(tController.updateParkAvailability(bicycle, trip, destinationPark)).thenCallRealMethod();  // Real implementation
        boolean result = tController.updateParkAvailability(bicycle, trip, destinationPark);
        assertTrue(result);


    }

    @Test
    public void updateParkAvailabilityShouldReturnFalse() throws SQLException {
        System.out.println("updateParkAvailabilityShouldReturnFalse");
        Bicycle bicycle = new Bicycle();
        Trip trip = new Trip();

        Park destinationPark = new Park();
        TripController tController = mock(TripController.class);
        when(tController.isBykeNonEletric(bicycle)).thenReturn(false);    // Mock implementation
        when(tController.updateNonElectric(bicycle, trip, destinationPark)).thenReturn(false);    // Mock implementation
        when(tController.updateParkAvailability(bicycle, trip, destinationPark)).thenCallRealMethod();  // Real implementation
        boolean result = tController.updateParkAvailability(bicycle, trip, destinationPark);
        assertFalse(result);


    }

    @Test
    public void updateParkAvailabilit() throws SQLException {
        System.out.println("updateParkAvailabilityShouldReturn");
        Bicycle bicycle = new Bicycle();

        Trip trip = new Trip();
        Park destinationPark = new Park();
        TripController tController = mock(TripController.class);
        when(tController.isBykeNonEletric(bicycle)).thenReturn(false);    // Mock implementation
        when(tController.updateNonElectric(bicycle, trip, destinationPark)).thenReturn(false);    // Mock implementation
        when(tController.updateParkAvailability(bicycle, trip, destinationPark)).thenCallRealMethod();  // Real implementation
        boolean result = tController.updateParkAvailability(bicycle, trip, destinationPark);
        boolean result2 = tController.updateNonElectric(bicycle, trip, destinationPark);
        System.out.println(result2);
        assertFalse(result);
        assertFalse(result2);


    }

    @Test
    public void testUpdateNonElectricShouldReturnExpecte() throws SQLException {
        System.out.println("test is Byke Non Eletric should return true");

        long maxCap = 36;
        int counterNonElectricBicycle = 36;

        ParkDB pdb = mock(ParkDB.class);//Criação da classe mock
        BicycleDB bDB = mock(BicycleDB.class);
        BicycleController bController = new BicycleController();

        Park parkDestination = new Park();
        parkDestination.setName("FCUP_PARK");

        Bicycle bike = new Bicycle();
        TripController tController = new TripController();
        Trip trip = new Trip();

        bike.setIdBicycle(12);
        bike.setType("Mountain");

        bController.setParkDB(pdb);
        bController.setbDB(bDB);

        when(bDB.countBikeByType(bike.getType(), parkDestination.getName())).thenReturn(35);
        when(pdb.getParkByName("FCUP_PARK")).thenReturn(parkDestination);
        when(pdb.updateBicycleOnDestinyPark(parkDestination, bike)).thenReturn(true);

        bDB.countBikeByType(bike.getType(), parkDestination.getName());
        pdb.getParkByName("FCUP_PARK");
        pdb.updateBicycleOnDestinyPark(parkDestination, bike);

        parkDestination.setMaxCapacityNonElectric(maxCap);
        long maxNonElectricCapacity = parkDestination.getMaxCapacityNonEletric();
        parkDestination = pdb.getParkByName("FCUP_PARK");
        counterNonElectricBicycle = bDB.countBikeByType(bike.getType(), parkDestination.getName());
        // boolean result = pdb.updateBicycleOnDestinyPark(parkDestination, bike);
        boolean result = tController.validateUpdate(35, 35, pdb, parkDestination, bike);
        assertFalse(result);
    }

    @Test
    public void testGetParkOrigin() throws SQLException {
        long tripId = 600000;
        long key = 10;
        long value = 12;
        TripDb tripDb = mock(TripDb.class);
        ParkDB pdb = mock(ParkDB.class);//Criação da classe mock
        TripController tripController = new TripController();
        tripController.setTripDb(tripDb);
        tripController.setParkDB(pdb);
        Pair<Long, Long> origin_destinyParks = new Pair<Long, Long>(key, value);

        when(tripDb.getOriginAndDestinyParksIdByTripId(600000)).thenReturn(new Pair<Long, Long>(key, value));
        // when(tripDb.getOriginAndDestinyParksIdByTripId(600000).getValue()).thenReturn(new Pair<Long,Long>(key, value).getValue());
        when(pdb.getParkById((long) 12)).thenReturn("FCUP_PARK");
        when(pdb.getParkById((long) 10)).thenReturn("ISEP_PARK");

        String parkOrigin = pdb.getParkById((long) 10);
        String parkDestin = pdb.getParkById((long) 12);
        tripDb.getOriginAndDestinyParksIdByTripId(600000);
        tripController.getParkOrigin(600000);
        tripController.getParkDestiny(600000);
        parkOrigin = "FCUP_PARK";

        assertEquals("ISEP_PARK", tripController.getParkOrigin(600000));
        assertEquals("FCUP_PARK", tripController.getParkDestiny(600000));
    }

    @Test
    public void getUserMass()   {
        TripController tripController = new TripController();

        User user = mock(User.class);
        tripController.setUser(user);
        when(user.getMass(user)).thenReturn((double) 70);
        double resultMass = user.getMass(user);
        double resultWeight= user.getWeight();


        tripController.getUserMass(user);
        assertEquals(70,tripController.getUserMass(user));
    }
    @Test
    public void getSetTripHelper()   {
        TripHelper tripHlp = new TripHelper();
        TripController tripController = new TripController();
     tripController.setTripHelper(tripHlp);
    }

}

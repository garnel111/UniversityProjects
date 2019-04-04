package lapr.project.controller;

import lapr.project.data.BicycleDB;
import lapr.project.data.ParkDB;
import lapr.project.model.Bicycle;
import lapr.project.model.Park;
import lapr.project.model.Trip;
import org.junit.jupiter.api.Test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BicycleControllerTest {

    //BicycleController bController;
    public BicycleControllerTest() {
    }


    /**
     * Test of addBicycle method, of class BicycleController, for non electric
     * bikes.
     */
    @Test
    public void testAddBicycleNonElectric() {
        System.out.println("addBicycle");
        String parkName = "ParkOne";
        boolean expResult = true;

        Bicycle b = new Bicycle();
        b.setIdBicycle(001);
        b.setBicycleMass(10.1F);
        b.setKm(10.5F);
        b.setType("Mountain");

        BicycleController bController = mock(BicycleController.class);

        when(bController.addBicycle(b, parkName)).thenReturn(true);
        boolean result = bController.addBicycle(b, parkName);
        assertEquals(expResult, result);
        verify(bController).addBicycle(b, parkName);
    }

    /**
     * Test of addBicycle method, of class BicycleController, for electric
     * bikes.
     */
    @Test
    public void testAddBicycleElectric() {
        System.out.println("addBicycle");
        String parkName = "ParkOne";
        boolean expResult = true;

        Bicycle b = new Bicycle(10.1F, 5.4F, "Eletric");


        //b.setBicycleMass(10.1F);
        //b.setKm(10.5F);
        //b.setType("Electric");

        BicycleController bController = mock(BicycleController.class);

        when(bController.addBicycle(b, parkName)).thenReturn(true);
        boolean result = bController.addBicycle(b, parkName);
        assertEquals(expResult, result);
        verify(bController).addBicycle(b, parkName);
    }

    /**
     * Test of addBicycle method, of class BicycleController, for null bike.
     */
    @Test
    public void testAddBicycleNull() {
        System.out.println("addBicycle");
        String parkName = "ParkOne";
        boolean expResult = false;

        BicycleController bController = mock(BicycleController.class);
        Bicycle b = null;

        when(bController.addBicycle(b, parkName)).thenReturn(false);
        boolean result = bController.addBicycle(b, parkName);
        assertEquals(expResult, result);
        verify(bController).addBicycle(b, parkName);
    }

    /**
     * Test of addBicycle method, of class BicycleController, for null park.
     */
    @Test
    public void testAddBicycleParkNull() {
        System.out.println("addBicycle");
        String parkName = null;
        boolean expResult = false;
        float mass = 12;
        float km = 200;
        long bicycleId = 400;
        String type = "mountain";

        BicycleController bController = mock(BicycleController.class);

        Bicycle b = new Bicycle();
        b.getBicycleMass();
        b.getIdBicycle();
        b.getKm();
        b.getType();

        b.setBicycleMass(mass);
        b.setIdBicycle(bicycleId);
        b.setKm(km);
        b.setType(type);

        when(bController.addBicycle(b, parkName)).thenReturn(false);

        boolean result = bController.addBicycle(b, parkName);
        assertEquals(expResult, result);
        verify(bController).addBicycle(b, parkName);
    }

    @Test
    public void testAddBicycleN() {
        System.out.println("addBicycle");
        String parkName = "";
        boolean expResult = true;
        float mass = 10;
        Bicycle b = null;
        BicycleController bicycleController = new BicycleController(b);

        BicycleController bController = mock(BicycleController.class);


        when(bController.addBicycle(b, parkName)).thenReturn(true);
        boolean result = bController.addBicycle(b, parkName);
        assertEquals(expResult, result);
        verify(bController).addBicycle(b, parkName);
    }
    @Test
    public void testAddBicycleNullAndParkNull() {
        System.out.println("testAddBicycleNullAndParkNull");
        String parkName = null;
        boolean expResult = false;
        float mass = 10;
        Bicycle b = null;
        BicycleController bicycleController = new BicycleController(b);

        BicycleController bController = mock(BicycleController.class);


        when(bController.addBicycle(b, parkName)).thenReturn(false);
        boolean result = bController.addBicycle(b, parkName);
        assertEquals(expResult, result);
        verify(bController).addBicycle(b, parkName);
    }

    @Test
    public void testAddBiKeAndParkNull() {
        System.out.println("addBicycle");
        String parkName = null;
        boolean expResult = false;

        String type = "mountain";

        BicycleController bController = new BicycleController();

        Bicycle b = null;
        bController.addBicycle(b, parkName);

        bController.getBicycleById(1);

        //  when(bController.addBicycle(b, parkName)).thenReturn(false);
        boolean result = bController.addBicycle(b, parkName);
        assertEquals(expResult, result);
        //verify(bController).addBicycle(b, parkName);
    }

    @Test
    public void testAddBicycleNullOne() {
        System.out.println("addBicycle");
        String parkName = "park1";
        boolean expResult = false;

        String type = "mountain";

        BicycleController bController = new BicycleController();

        Bicycle b = null;
        bController.addBicycle(b, parkName);

        //  when(bController.addBicycle(b, parkName)).thenReturn(false);
        boolean result = bController.addBicycle(b, parkName);
        assertEquals(expResult, result);
        //verify(bController).addBicycle(b, parkName);
    }


    @Test
    public void testAddBikeNull() {
        System.out.println("addBicycle");
        String parkName = "park1";

        Park park1 = new Park("park1", 4534, 8535, 34234, 343434);
        boolean expResult = true;
        Bicycle b = new Bicycle();

        ParkDB pdb1 = mock(ParkDB.class);
        BicycleDB bdb = mock(BicycleDB.class);

        BicycleController bikCtrl = new BicycleController();
        bikCtrl.setbDB(bdb);
        bikCtrl.setParkDB(pdb1);

        b.getBicycleMass();
        b.getIdBicycle();
        b.getKm();
        b.getType();
        float mass = 0;

        b.setBicycleMass(mass);
        long bicycleId = 0;
        b.setIdBicycle(bicycleId);
        float km = 0;

        b.setKm(km);
        b.setType("mountain");

        String type = "mountain";

        BicycleController bController = new BicycleController();

        // when(bController.addBicycle(b, parkName)).thenReturn(false);
        when(bdb.addBicycle(mass, km, type, parkName)).thenReturn(true);
        when(bdb.countBikeByType(type, parkName)).thenReturn(5);
        when(pdb1.getParkByName(parkName)).thenReturn(park1);

        //bController.addBicycle(b, parkName);
        boolean result = bdb.addBicycle(mass, km, type, parkName);
        assertEquals(expResult, result);
        //verify(bController).addBicycle(b, parkName);
    }

    @Test
    public void testAddBikeNull111() {
        System.out.println("addBicycle");
        String parkName = "park1";

        Park park1 = new Park("park1", 4534, 8535, 34234, 34343);
        int expResult = 5;
        Bicycle b = new Bicycle();

        ParkDB pdb = mock(ParkDB.class);
        BicycleDB bdb = mock(BicycleDB.class);

        BicycleController bikCtrl = new BicycleController();
        bikCtrl.setbDB(bdb);
        bikCtrl.setParkDB(pdb);

        b.getBicycleMass();
        b.getIdBicycle();
        b.getKm();
        b.getType();
        float mass = 0;

        b.setBicycleMass(mass);
        long bicycleId = 0;
        b.setIdBicycle(bicycleId);
        float km = 0;

        b.setKm(km);
        b.setType("mountain");

        String type = "mountain";

        // when(bController.addBicycle(b, parkName)).thenReturn(false);
        when(bdb.countBikeByType(type, parkName)).thenReturn(5);
        when(pdb.getParkByName(parkName)).thenReturn(park1);
        when(bikCtrl.validateEletricByke(pdb, b, parkName)).thenReturn(true);
        //bController.addBicycle(b, parkName);

        when(bikCtrl.validateEletricByke(pdb, b, parkName)).thenCallRealMethod();
        int result = bdb.countBikeByType(type, parkName);
        assertEquals(expResult, result);
        //verify(bController).addBicycle(b, parkName);
    }


    @Test
    public void testAdd() {
        System.out.println("addBicycle");
        String parkName = "";
        boolean expResult = false;

        String type = "mountain";

        BicycleController bController = mock(BicycleController.class);//new BicycleController();
        bController.setbDB(mock(BicycleDB.class));

        Bicycle b = new Bicycle(0, 0, null);
        when(bController.addBicycle(b, parkName)).thenReturn(false);
        bController.addBicycle(b, parkName);

//        when(bController.getbDB().addBicycle(b.getBicycleMass(),b.getKm(),b.getType(),parkName)).thenReturn(false);
        boolean result = bController.addBicycle(b, parkName);
        assertEquals(expResult, result);
    }


//    @Test
//    public void testisBykeNonEletricShouldReturnTrue() {
//        System.out.println("test is Byke Non Eletric should return true");
//        String parkName = "";
//        boolean expResult = true;
//
//        String type = "Mountain";
//
//        BicycleController bController = new BicycleController();
//
//        Bicycle b = new Bicycle(12, 200, type);
//
//
//        boolean result = bController.isBykeNonEletric(b);
//        assertEquals(expResult, result);
//
//    }

//    @Test
//    public void testisBykeNonEletricShouldReturnFalse() {
//        System.out.println("test is Byke Non Eletric should return false");
//        String parkName = "";
//        boolean expResult = false;
//
//        String type = "Electric";
//
//        BicycleController bController = new BicycleController();
//
//        Bicycle b = new Bicycle(12, 200, type);
//
//
//        boolean result = bController.isBykeNonEletric(b);
//        assertEquals(expResult, result);
//
//    }

    @Test
    public void testUpdateNonElectricShouldReturnTrue() throws SQLException {
        System.out.println("test is Byke Non Eletric should return true");

        long maxCap = 35;
        long counterNonElectricBicycle = 20;

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

        when(bDB.countBikeByType(bike.getType(), parkDestination.getName())).thenReturn(20);
        when(pdb.updateBicycleOnDestinyPark(parkDestination, bike)).thenReturn(true);
        when(pdb.getParkByName("FCUP_PARK")).thenReturn(parkDestination);


        parkDestination.setMaxCapacityNonElectric(maxCap);
        long maxNonElectricCapacity = parkDestination.getMaxCapacityNonEletric();

        parkDestination = pdb.getParkByName("FCUP_PARK");

        counterNonElectricBicycle = bDB.countBikeByType(bike.getType(), parkDestination.getName());
        boolean result = pdb.updateBicycleOnDestinyPark(parkDestination, bike);
        assertTrue(result);

    }


//    @Test
//    public void testUpdateNonElectricShouldReturnExpectedResultTrue() throws SQLException {
//        System.out.println("test is Byke Non Eletric should return true");
//        TripController tripController = new TripController();
//        long maxCap = 36;
//        int counterNonElectricBicycle = 35;
//
//        ParkDB pdb = mock(ParkDB.class);//Criação da classe mock
//        BicycleDB bDB = mock(BicycleDB.class);
//        BicycleController bController = new BicycleController();
//
//        Park parkDestination = new Park();
//        parkDestination.setName("FCUP_PARK");
//
//        Bicycle bike = new Bicycle();
//
//        Trip trip = new Trip();
//
//        bike.setIdBicycle(12);
//        bike.setType("Mountain");
//
//        bController.setParkDB(pdb);
//        bController.setbDB(bDB);
//
//        when(bDB.countBikeByType(bike.getType(), parkDestination.getName())).thenReturn(35);
//        when(pdb.getParkByName("FCUP_PARK")).thenReturn(parkDestination);
//        when(pdb.updateBicycleOnDestinyPark(parkDestination, bike)).thenReturn(true);
//
//        bDB.countBikeByType(bike.getType(), parkDestination.getName());
//        pdb.getParkByName("FCUP_PARK");
//        pdb.updateBicycleOnDestinyPark(parkDestination, bike);
//
//        parkDestination.setMaxCapacityNonElectric(maxCap);
//
//        long maxNonElectricCapacity = parkDestination.getMaxCapacityNonEletric();
//
//        parkDestination = pdb.getParkByName("FCUP_PARK");
//
//        counterNonElectricBicycle = bDB.countBikeByType(bike.getType(), parkDestination.getName());
//
//        // boolean result = pdb.updateBicycleOnDestinyPark(parkDestination, bike);
//        boolean result = bController.validateUpdate(counterNonElectricBicycle, maxNonElectricCapacity, pdb, parkDestination, bike);
//
//
//        assertTrue(result);
//
//    }

//    @Test
//    public void testUpdateNonElectricShouldReturnExpectedResultFalse() throws SQLException {
//        System.out.println("test is Byke Non Eletric should return true");
//
//        long maxCap = 36;
//        int counterNonElectricBicycle = 36;
//
//        ParkDB pdb = mock(ParkDB.class);//Criação da classe mock
//        BicycleDB bDB = mock(BicycleDB.class);
//        BicycleController bController = new BicycleController();
//
//        Park parkDestination = new Park();
//        parkDestination.setName("FCUP_PARK");
//
//        Bicycle bike = new Bicycle();
//
//        Trip trip = new Trip();
//
//        bike.setIdBicycle(12);
//        bike.setType("Mountain");
//
//        bController.setParkDB(pdb);
//        bController.setbDB(bDB);
//
//        when(bDB.countBikeByType(bike.getType(), parkDestination.getName())).thenReturn(35);
//        when(pdb.getParkByName("FCUP_PARK")).thenReturn(parkDestination);
//        when(pdb.updateBicycleOnDestinyPark(parkDestination, bike)).thenReturn(false);
//
//        bDB.countBikeByType(bike.getType(), parkDestination.getName());
//        pdb.getParkByName("FCUP_PARK");
//        pdb.updateBicycleOnDestinyPark(parkDestination, bike);
//
//        parkDestination.setMaxCapacityNonElectric(maxCap);
//
//        long maxNonElectricCapacity = parkDestination.getMaxCapacityNonEletric();
//
//        parkDestination = pdb.getParkByName("FCUP_PARK");
//
//        counterNonElectricBicycle = bDB.countBikeByType(bike.getType(), parkDestination.getName());
//
//        // boolean result = pdb.updateBicycleOnDestinyPark(parkDestination, bike);
//        boolean result = bController.validateUpdate(35, 34, pdb, parkDestination, bike);
//
//
//        assertFalse(result);
//
//    }

//    @Test
//    public void testUpdateNonElectricShouldReturnExpectedResult() throws SQLException {
//        System.out.println("test is Byke Non Eletric should return true");
//
//        long maxCap = 36;
//        int counterNonElectricBicycle = 36;
//
//        ParkDB pdb = mock(ParkDB.class);//Criação da classe mock
//        BicycleDB bDB = mock(BicycleDB.class);
//        BicycleController bController = new BicycleController();
//
//        Park parkDestination = new Park();
//        parkDestination.setName("FCUP_PARK");
//
//        Bicycle bike = new Bicycle();
//
//        Trip trip = new Trip();
//
//        bike.setIdBicycle(12);
//        bike.setType("Mountain");
//
//        bController.setParkDB(pdb);
//        bController.setbDB(bDB);
//
//        when(bDB.countBikeByType(bike.getType(), parkDestination.getName())).thenReturn(35);
//        when(pdb.getParkByName("FCUP_PARK")).thenReturn(parkDestination);
//        when(pdb.updateBicycleOnDestinyPark(parkDestination, bike)).thenReturn(true);
//
//        bDB.countBikeByType(bike.getType(), parkDestination.getName());
//        pdb.getParkByName("FCUP_PARK");
//        pdb.updateBicycleOnDestinyPark(parkDestination, bike);
//
//        parkDestination.setMaxCapacityNonElectric(maxCap);
//        long maxNonElectricCapacity = parkDestination.getMaxCapacityNonEletric();
//        parkDestination = pdb.getParkByName("FCUP_PARK");
//        counterNonElectricBicycle = bDB.countBikeByType(bike.getType(), parkDestination.getName());
//        // boolean result = pdb.updateBicycleOnDestinyPark(parkDestination, bike);
//        boolean result = bController.validateUpdate(35, 35, pdb, parkDestination, bike);
//        assertFalse(result);
//
//    }

    @Test
    public void testValidatElectricBikeShouldReturnTrue() throws SQLException {
        System.out.println("test is Byke Non Eletric should return true");

        long maxCap = 36;
        int counterNonElectricBicycle = 35;

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

        parkDestination.setMaxCapacityElectric(maxCap);
        long maxElectricCapacity = parkDestination.getMaxCapacityElectric();
        parkDestination = pdb.getParkByName("FCUP_PARK");
        counterNonElectricBicycle = bDB.countBikeByType(bike.getType(), parkDestination.getName());
        // boolean result = pdb.updateBicycleOnDestinyPark(parkDestination, bike);
        boolean result = bController.validateEletricByke(pdb, bike, "FCUP_PARK");
        assertTrue(result);

    }


    @Test
    public void testValidatElectricBikeShouldReturnFalse() throws SQLException {
        System.out.println("test is Byke Non Eletric should return false");

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

        boolean result = bController.validateEletricByke(pdb, bike, "FCUP_PARK");
        assertTrue(result);

    }

    @Test
    public void testValidatElectricBikeChanginCOnditionalBoundary() throws SQLException {
        System.out.println("test is Byke Non Eletric should return false");

        long maxCap = -36000;
        int counterNonElectricBicycle;

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

        when(bDB.countBikeByType(bike.getType(), parkDestination.getName())).thenReturn(-35999);
        when(pdb.getParkByName("FCUP_PARK")).thenReturn(parkDestination);
        when(pdb.updateBicycleOnDestinyPark(parkDestination, bike)).thenReturn(true);

        bDB.countBikeByType(bike.getType(), parkDestination.getName());
        pdb.getParkByName("FCUP_PARK");
        pdb.updateBicycleOnDestinyPark(parkDestination, bike);

        parkDestination.setMaxCapacityNonElectric(maxCap);
        long maxNonElectricCapacity = parkDestination.getMaxCapacityNonEletric();
        parkDestination = pdb.getParkByName("FCUP_PARK");
        counterNonElectricBicycle = bDB.countBikeByType(bike.getType(), parkDestination.getName());

        boolean result = bController.validateEletricByke(pdb, bike, "FCUP_PARK");
        assertTrue(result);

    }


    @Test
    public void testValidateNonEletricBikeShouldReturnTrue() throws SQLException {
        System.out.println("test is Byke Non Eletric should return true");

        long maxCap = 36000;
        int counterNonElectricBicycle;

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

        when(bDB.countBikeByType(bike.getType(), parkDestination.getName())).thenReturn(35999);
        when(pdb.getParkByName("FCUP_PARK")).thenReturn(parkDestination);
        when(pdb.updateBicycleOnDestinyPark(parkDestination, bike)).thenReturn(true);

        bDB.countBikeByType(bike.getType(), parkDestination.getName());
        pdb.getParkByName("FCUP_PARK");
        pdb.updateBicycleOnDestinyPark(parkDestination, bike);

        parkDestination.setMaxCapacityNonElectric(maxCap);
        long maxNonElectricCapacity = parkDestination.getMaxCapacityNonEletric();
        parkDestination = pdb.getParkByName("FCUP_PARK");
        counterNonElectricBicycle = bDB.countBikeByType(bike.getType(), parkDestination.getName());

        boolean result = bController.validateNonEletricByke(pdb, bike, "FCUP_PARK");
        assertTrue(result);

    }


    @Test
    public void testValidateNonEletricBikeShouldReturnFalse() throws SQLException {
        System.out.println("test is Byke Non Eletric should return false");

        long maxCap = -36000;
        int counterNonElectricBicycle;

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

        when(bDB.countBikeByType(bike.getType(), parkDestination.getName())).thenReturn(-35000);
        when(pdb.getParkByName("FCUP_PARK")).thenReturn(parkDestination);
        when(pdb.updateBicycleOnDestinyPark(parkDestination, bike)).thenReturn(true);

        bDB.countBikeByType(bike.getType(), parkDestination.getName());
        pdb.getParkByName("FCUP_PARK");
        pdb.updateBicycleOnDestinyPark(parkDestination, bike);

        parkDestination.setMaxCapacityNonElectric(maxCap);
        long maxNonElectricCapacity = parkDestination.getMaxCapacityNonEletric();
        parkDestination = pdb.getParkByName("FCUP_PARK");
        counterNonElectricBicycle = bDB.countBikeByType(bike.getType(), parkDestination.getName());

        boolean result = bController.validateNonEletricByke(pdb, bike, "FCUP_PARK");
        assertFalse(result);

    }

//    @Test
//
//    public void updateParkAvailabilityShouldReturnTrue() throws SQLException {
//        System.out.println("updateParkAvailabilityShouldReturnTrue");
//        Bicycle bicycle = new Bicycle();
//        Trip trip = new Trip();
//        Park destinationPark = new Park();
//        BicycleController bicycleController = mock(BicycleController.class);
//        when(bicycleController.isBykeNonEletric(bicycle)).thenReturn(true);    // Mock implementation
//        when(bicycleController.updateNonElectric(bicycle, trip, destinationPark)).thenReturn(true);    // Mock implementation
//        when(bicycleController.updateParkAvailability(bicycle, trip, destinationPark)).thenCallRealMethod();  // Real implementation
//        boolean result = bicycleController.updateParkAvailability(bicycle, trip, destinationPark);
//        assertTrue(result);
//
//
//    }

//    @Test
//    public void updateParkAvailabilityShouldReturnFalse() throws SQLException {
//        System.out.println("updateParkAvailabilityShouldReturnFalse");
//        Bicycle bicycle = new Bicycle();
//        Trip trip = new Trip();
//        Park destinationPark = new Park();
//        BicycleController bicycleController = mock(BicycleController.class);
//        when(bicycleController.isBykeNonEletric(bicycle)).thenReturn(false);    // Mock implementation
//        when(bicycleController.updateNonElectric(bicycle, trip, destinationPark)).thenReturn(false);    // Mock implementation
//        when(bicycleController.updateParkAvailability(bicycle, trip, destinationPark)).thenCallRealMethod();  // Real implementation
//        boolean result = bicycleController.updateParkAvailability(bicycle, trip, destinationPark);
//        assertFalse(result);
//
//
//    }

    @Test
    public void addBicycleShouldReturnFalse() {
        System.out.println("addBicycleShouldReturnTrue");
        Bicycle bicycle = new Bicycle();
        bicycle.setType("Electric");
        String namePark = "FCUP_PARK";

        BicycleController bicycleController = mock(BicycleController.class);
        ParkDB pdb = mock(ParkDB.class);//Criação da classe mock
        bicycleController.setParkDB(pdb);
        when(bicycleController.validateEletricByke(pdb, bicycle, "FCUP_PARK")).thenReturn(true);
        when(bicycleController.validateNonEletricByke(pdb, bicycle, "FCUP_PARK")).thenReturn(true);
        when(bicycleController.addBicycle(bicycle, namePark)).thenCallRealMethod();
        boolean result = bicycleController.addBicycle(bicycle, namePark);

        assertFalse(result);


    }

    @Test
    public void addBicycleNonElectricShouldReturn() {
        System.out.println("addBicycleNonElectricShouldReturn");
        Bicycle bicycle = new Bicycle();
        bicycle.setType("Mountain");
        String namePark = "FCUP_PARK";

        BicycleController bicycleController = mock(BicycleController.class);
        ParkDB pdb = mock(ParkDB.class);//Criação da classe mock
        bicycleController.setParkDB(pdb);
        when(bicycleController.validateEletricByke(pdb, bicycle, "FCUP_PARK")).thenReturn(false);
        when(bicycleController.validateNonEletricByke(pdb, bicycle, "FCUP_PARK")).thenReturn(true);
        when(bicycleController.addBicycle(bicycle, namePark)).thenCallRealMethod();
        boolean result = bicycleController.addBicycle(bicycle, namePark);

        assertFalse(result);


    }


    @Test
    public void addBicycleElectricShouldReturn() {
        System.out.println("addBicycleNonElectricShouldReturn");
        Bicycle bicycle = new Bicycle();
        bicycle.setType("Electric");
        String namePark = "FCUP_PARK";

        BicycleController bicycleController = mock(BicycleController.class);
        ParkDB pdb = mock(ParkDB.class);//Criação da classe mock
        bicycleController.setParkDB(pdb);
        when(bicycleController.validateEletricByke(pdb, bicycle, "FCUP_PARK")).thenReturn(true);
        when(bicycleController.validateNonEletricByke(pdb, bicycle, "FCUP_PARK")).thenReturn(false);
        when(bicycleController.addBicycle(bicycle, namePark)).thenCallRealMethod();
        boolean result = bicycleController.addBicycle(bicycle, namePark);

        assertFalse(result);


    }

//    @Test
//    public void updateParkAvailabilit() throws SQLException {
//        System.out.println("updateParkAvailabilityShouldReturn");
//        Bicycle bicycle = new Bicycle();
//        Trip trip = new Trip();
//        Park destinationPark = new Park();
//        BicycleController bicycleController = mock(BicycleController.class);
//        when(bicycleController.isBykeNonEletric(bicycle)).thenReturn(false);    // Mock implementation
//        when(bicycleController.updateNonElectric(bicycle, trip, destinationPark)).thenReturn(false);    // Mock implementation
//        when(bicycleController.updateParkAvailability(bicycle, trip, destinationPark)).thenCallRealMethod();  // Real implementation
//        boolean result = bicycleController.updateParkAvailability(bicycle, trip, destinationPark);
//        boolean result2 = bicycleController.updateNonElectric(bicycle, trip, destinationPark);
//        System.out.println(result2);
//        assertFalse(result);
//        assertFalse(result2);
//
//
//    }

}
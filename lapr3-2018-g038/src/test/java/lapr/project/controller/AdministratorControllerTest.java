package lapr.project.controller;

import javafx.util.Pair;

import java.sql.SQLException;
import java.util.ArrayList;

import lapr.project.data.AdministratorDB;
import lapr.project.data.BicycleDB;
import lapr.project.data.ParkDB;
import lapr.project.model.Administrator;
import lapr.project.model.Bicycle;
import lapr.project.model.Park;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author marco
 */
public class AdministratorControllerTest {

    public AdministratorControllerTest() {
    }

    @Test
    public void testgetOriginAndDestinyPairsList() {
        System.out.println("testgetOriginAndDestinyPairsList");
        AdministratorController admnistratorController = new AdministratorController();
        Pair<String, String> pairElements0 = new Pair<>("ISEP", "FCUP");
        Pair<String, String> pairElements1 = new Pair<>("ISEP", "POI1");
        Pair<String, String> pairElements2 = new Pair<>("POI3", "POI1");

        ArrayList<Pair<String, String>> pointsConnectedPairsList = new ArrayList<>();
        pointsConnectedPairsList.add(pairElements0);
        pointsConnectedPairsList.add(pairElements1);
        pointsConnectedPairsList.add(pairElements2);
        ArrayList<String> poiList = new ArrayList<>();
        poiList.add("ISEP");
        poiList.add("POI1");
        poiList.add("POI3");
        admnistratorController.getOriginAndDestinyPairsList(poiList);
        assertNotNull(admnistratorController.getOriginAndDestinyPairsList(poiList));

    }

    /**
     * Test of getAdministratorByEmail method, of class AdministratorController.
     */
    @Test
    public void testGetAdministratorByEmail() {
        System.out.println("getAdministratorByEmail");
        String email = "1170483@isep.ipp.pt";

        AdministratorDB adb = mock(AdministratorDB.class);
        AdministratorController administratorController = new AdministratorController();
        administratorController.setAdministratorDataBase(adb);
        Administrator admin = new Administrator();
        admin.setName("Alberto");
        admin.setEmail(email);
        admin.setPassword("qwertyAlberto");

        when(adb.getAdministratorByEmail(email)).thenReturn(admin);

        Administrator expResult = admin;
        Administrator result = administratorController.getAdministratorByEmail(email);
        assertEquals(expResult, result);
        verify(adb).getAdministratorByEmail(email);
    }

    /**
     * Test of setAdministratorDataBase method, of class
     * AdministratorController.
     */
    @Test
    public void testSetAdministratorDataBase() {
        System.out.println("setAdministratorDataBase");
        AdministratorDB adminDataBase = new AdministratorDB();
        AdministratorController administratorController = new AdministratorController();
        administratorController.setAdministratorDataBase(adminDataBase);
    }

    /**
     * Test of newAdministrator method, of class AdministratorController.
     */
    @Test
    public void testNewAdministrator() {
        System.out.println("newAdministrator");

        String name = "Alberto";
        String email = "1170481@isep.ipp.pt";
        String password = "qwertyAlberto";

        AdministratorDB adb = mock(AdministratorDB.class);
        AdministratorController administratorController = new AdministratorController();
        administratorController.setAdministratorDataBase(adb);

        Administrator nAdministrator = new Administrator(name, email, password);

        when(adb.newAdministrator(nAdministrator)).thenReturn(true);//quando o controller chamar a função da DB, usa a DB mock e retorna o resultado p1

        Boolean expResult = adb.newAdministrator(nAdministrator);
        assertEquals(expResult, true);

        verify(adb).newAdministrator(nAdministrator);//verifica se a DB mock foi usada
    }

    /**
     * Test of newAdministrator method, of class AdministratorController.
     */
    @Test
    public void testNewAdministratorShouldBeFalse() {
        System.out.println("newAdministrator");
        AdministratorDB adb = mock(AdministratorDB.class);
        String email = "1170483@isep.ipp.pt";
        Administrator admin = new Administrator();
        AdministratorController administratorController = new AdministratorController();
        administratorController.setAdministratorDataBase(adb);

        //  when(udb.getUserByEmail(email)).thenReturn(null);
        when(adb.newAdministrator(admin)).thenReturn(false);

        adb.newAdministrator(admin);

        boolean result = administratorController.newAdministrator("", "", "");
        assertFalse(adb.newAdministrator(admin));

        //   verify(udb).newUser(user);//verifica se a DB mock foi usada
    }

    /**
     * Test of validateAdministrator method, of class AdministratorController.
     */
    @Test
    public void testValidateAdministratorTrue() {
        System.out.println("validateAdministratorTrue");
        String email = "1170483@isep.ipp.pt";

        AdministratorDB udb = mock(AdministratorDB.class);
        AdministratorController administratorController = new AdministratorController();
        administratorController.setAdministratorDataBase(udb);

        Administrator admin = new Administrator();
        admin.setName("Marco");
        admin.setEmail(email);
        admin.setPassword("qwertyMarco");

        when(udb.getAdministratorByEmail(email)).thenReturn(admin);

        boolean expResult = true;
        boolean result = administratorController.validateAdministrator(email);
        assertEquals(expResult, result);
        verify(udb).getAdministratorByEmail(email);//verifica se a DB mock foi usada
    }

    /**
     * Test of validateUser method, of class UserController.
     */
    @Test
    public void testValidateAdministratorFalse() {
        System.out.println("validateAdministratorFalse");
        String email = "1111111@isep.ipp.pt";

        AdministratorDB adb = mock(AdministratorDB.class);
        AdministratorController administratorController = new AdministratorController();
        administratorController.setAdministratorDataBase(adb);

        when(adb.getAdministratorByEmail(email)).thenReturn(null);

        boolean expResult = false;
        boolean result = administratorController.validateAdministrator(email);
        assertEquals(expResult, result);
        verify(adb).getAdministratorByEmail(email);//verifica se a DB mock foi usada
    }


    @Test
    public void testgetOriginAndDestinyPairs() {
        System.out.println("testgetOriginAndDestinyPairsList");
        AdministratorController admnistratorController = new AdministratorController();
        Pair<String, String> pairElements0 = new Pair<>("ISEP", "FCUP");
        Pair<String, String> pairElements1 = new Pair<>("ISEP", "POI1");
        Pair<String, String> pairElements2 = new Pair<>("POI3", "POI1");

        ArrayList<Pair<String, String>> pointsConnectedPairsList = new ArrayList<>();
        pointsConnectedPairsList.add(pairElements0);
        pointsConnectedPairsList.add(pairElements1);
        pointsConnectedPairsList.add(pairElements2);
        ArrayList<String> poiList = new ArrayList<>();
        poiList.add("ISEP");
        // poiList.add("POI1");
        // poiList.add("POI3");
        admnistratorController.getOriginAndDestinyPairsList(poiList);
        assertNotNull(admnistratorController.getOriginAndDestinyPairsList(poiList));

    }


    @Test
    public void testaddBicyclesAssertTrue() throws SQLException {
        System.out.println("testaddBicyclesAndPark Should return true");
        AdministratorController administratorController = new AdministratorController();
        Bicycle bike = new Bicycle();
        //Park park = new Park();
        BicycleDB bicycleDB = mock(BicycleDB.class);
        ParkDB parkDB = mock(ParkDB.class);
        Park park12 = mock(Park.class);
        Bicycle bike12 = mock(Bicycle.class);

        administratorController.setBicycleDB(bicycleDB);
        administratorController.setParkDb(parkDB);
        administratorController.setPark(park12);
        administratorController.setBike(bike12);

        long value120 = 120;
        float latitude = (float) 1.12323;
        float longitude = (float) 1.1212;
        when(park12.getName()).thenReturn("FCUP_PARK");
//        when(bike.getType()).thenReturn("Mountain");
        when(parkDB.getFreeSlot("FCUP_PARK", "Mountain")).thenReturn(value120);
        when(parkDB.getParkByLatitudeAndLongitudeValues(latitude, longitude)).thenReturn(park12);
        when(parkDB.updateBicycleOnDestinyPark(park12, bike)).thenReturn(true);
        when(bicycleDB.addBicycle(12, 120, "Mountain", "FCUP_PARK")).thenReturn(true);

        long slotId = parkDB.getFreeSlot("FCUP_PARK", "Mountain"); //get available slot
        Park parkWithAllParamthers = parkDB.getParkByLatitudeAndLongitudeValues(latitude, longitude);
        bicycleDB.addBicycle(12, 120, "bike", "park");
        System.out.println(parkDB.updateBicycleOnDestinyPark(park12, bike));
assertTrue(parkDB.updateBicycleOnDestinyPark(park12, bike));
//        administratorController.addByciclesOnly(bike, park12);

    }
    @Test
    public void testaddBicyclesAssertFalse() throws SQLException {
        System.out.println("testaddBicyclesAndPark shoul return false");
        AdministratorController administratorController = new AdministratorController();
        Bicycle bike = new Bicycle();
        //Park park = new Park();
        BicycleDB bicycleDB = mock(BicycleDB.class);
        ParkDB parkDB = mock(ParkDB.class);
        Park park12 = mock(Park.class);
        Bicycle bike12 = mock(Bicycle.class);

        administratorController.setBicycleDB(bicycleDB);
        administratorController.setParkDb(parkDB);
        administratorController.setPark(park12);
        administratorController.setBike(bike12);

        long value120 = 120;
        float latitude = (float) 1.12323;
        float longitude = (float) 1.1212;
        when(park12.getName()).thenReturn("FCUP_PARK");
//        when(bike.getType()).thenReturn("Mountain");
        when(parkDB.getFreeSlot("FCUP_PARK", "Mountain")).thenReturn(value120);
        when(parkDB.getParkByLatitudeAndLongitudeValues(latitude, longitude)).thenReturn(park12);
        when(parkDB.updateBicycleOnDestinyPark(park12, bike)).thenReturn(true);
        when(bicycleDB.addBicycle(12, 120, "Mountain", "FCUP_PARK")).thenReturn(false);

        long slotId = parkDB.getFreeSlot("FCUP_PARK", "Mountain"); //get available slot
        Park parkWithAllParamthers = parkDB.getParkByLatitudeAndLongitudeValues(latitude, longitude);
        bicycleDB.addBicycle(12, 120, "bike", "park");
        System.out.println(parkDB.updateBicycleOnDestinyPark(park12, bike));
        boolean b = parkDB.updateBicycleOnDestinyPark(park12, bike);


    }

    @Test
    public void testArraylistPOis() {
        ArrayList<String> poiList = new ArrayList<>();
        AdministratorController administratorController = new AdministratorController(poiList);



    }

    @Test
    public void testArraylistPOis1() {
        ArrayList<String> poiList = new ArrayList<>();
        AdministratorController administratorController = mock(AdministratorController.class);
        AdministratorDB administratorDB = mock(AdministratorDB.class);
        administratorController.setAdministratorDB(administratorDB);
        Administrator administrator = new Administrator();
        administrator.setIdAdministrator(1);
        administrator.setEmail("asd@email.pt");
        administrator.setName("adm1");
        administrator.setPassword("asdfgh");
        when(administratorDB.newAdministrator(administrator)).thenReturn(true);
        administratorController.newAdministrator("adm1", "asd@email.pt", "asdfgh");

        assertNotNull(administratorController.newAdministrator("adm1", "asd@email.pt", "asdfgh"));

    }
    @Test
    public void testArraylistPOis2() {
        ArrayList<String> poiList = new ArrayList<>();
        AdministratorController administratorController = mock(AdministratorController.class);
        AdministratorDB administratorDB = mock(AdministratorDB.class);
        administratorController.setAdministratorDB(administratorDB);
        Administrator administrator = new Administrator();
        administrator.setIdAdministrator(-999999999);
        administrator.setEmail("asd@email.pt");
        administrator.setName("adm1");
        administrator.setPassword("asdfgh");
        when(administratorDB.newAdministrator(administrator)).thenReturn(true);
        administratorController.newAdministrator("adm1", "asd@email.pt", "asdfgh");

        assertNotNull(administratorController.newAdministrator("adm1", "asd@email.pt", "asdfgh"));

    }
    @Test
    public void testArraylistPOis3() {
        ArrayList<String> poiList = new ArrayList<>();
        AdministratorController administratorController = mock(AdministratorController.class);
        AdministratorDB administratorDB = mock(AdministratorDB.class);
        administratorController.setAdministratorDB(administratorDB);
        Administrator administrator = new Administrator();
        administrator.setIdAdministrator(999999999);
        administrator.setEmail("asd@email.pt");
        administrator.setName("adm1");
        administrator.setPassword("asdfgh");
        when(administratorDB.newAdministrator(administrator)).thenReturn(false);
        administratorController.newAdministrator("adm1", "asd@email.pt", "asdfgh");

        assertFalse(administratorController.newAdministrator("adm1", "asd@email.pt", "asdfgh"));

    }

    @Test
    void addByciclesOnly() throws SQLException {
        AdministratorController admc = mock(AdministratorController.class);
        BicycleDB bdb = mock(BicycleDB.class);
        ParkDB pdb = mock(ParkDB.class);

        Bicycle bike = new Bicycle(10,100,"Road");
        bike.setDescription("esta");
        bike.setIdBicycle(1);
        Park parque = new Park("teste",11,22,55,66);
        admc.setBicycleDB(bdb);
        admc.setParkDb(pdb);
        when(bdb.addBicycle(10,100,"Road","teste")).thenReturn(true);
        when(pdb.getParkByLatitudeAndLongitudeValues(parque.getLatitude(),parque.getLongitude())).thenReturn(parque);
        when(bdb.getBikeIDbyDescription("esta")).thenReturn((long)1);
        when(pdb.updateBicycleOnDestinyPark(parque,bike)).thenReturn(true);
        assertFalse(admc.addByciclesOnly(bike,parque));

    }

    @Test
    void setAdministratorDB() {
        AdministratorController admc = new AdministratorController();
        admc.setAdministratorDB(null);
        assertEquals(admc.getAdministratorDB(), admc.getAdministratorDB());
    }
}

package lapr.project.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lapr.project.data.ParkDB;
import org.junit.jupiter.api.Test;
import lapr.project.model.Park;
import lapr.project.utils.CalcMethods;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author magal
 */
public class ParkControllerTest {

    ParkController pController;

    public ParkControllerTest() {
    }

    /**
     * Test of distanceToPark method, of class ParkController.
     */
    @Test
    public void testDistanceToPark() throws Exception {
        System.out.println("distanceToPark");
        String parkName = "p1";

        ParkDB pdb = mock(ParkDB.class);//Criação da classe mock
        pController = new ParkController();//criação do controller em teste
        pController.setParkDataBase(pdb);//set da database mock no controller para teste
        CalcMethods calc = mock (CalcMethods.class);
        
        Park p1 = new Park();
        p1.setId(001);
        p1.setAdmin_Id(01);
        p1.setName(parkName);
        p1.setLatitude(41.177855F);
        p1.setLongitude(-8.608079F);
        p1.setMaxCapacityNonElectric(50);
        p1.setMaxCapacityElectric(10);

        when(pdb.getParkByName(parkName)).thenReturn(p1);//quando o controller chamar a função da DB, usa a DB mock e retorna o resultado p1
//        when(pController.distanceToPark(parkName)).thenReturn(2816.788F);
        

        pController.setUserLat(41.158087F);
        pController.setUserLong(-8.629120F);

//        when(calc.calcDistanceBetweenCoordinates(pController.getUserLat(), pController.getUserLong(), 41.177855F, -8.608079F));
        
        float expResult = 2816.72F;
        System.out.println("Pré dist");
        float result = pController.distanceToPark(parkName);
        System.out.println("Pós dist");
        assertEquals(expResult, result, 0.01);
        verify(pdb).getParkByName(parkName);//verifica se a DB mock foi usada
    }

    /**
     * Test of getParkByName method, of class ParkController.
     */
    @Test
    public void testGetParkByName() {
        System.out.println("getParkByName");
        String parkName = "p1";

        ParkDB pdb = mock(ParkDB.class);
        pController = new ParkController();
        pController.setParkDataBase(pdb);

        Park p1 = new Park();
        p1.setId(001);
        p1.setAdmin_Id(01);
        p1.setName(parkName);
        p1.setLatitude(41.177855F);
        p1.setLongitude(-8.608079F);
        p1.setMaxCapacityNonElectric(50);
        p1.setMaxCapacityElectric(10);

        when(pdb.getParkByName(parkName)).thenReturn(p1);

        Park expResult = p1;
        Park result = pController.getParkByName(parkName);
        assertEquals(expResult, result);
        verify(pdb).getParkByName(parkName);
    }

    /**
     * Test of setUserLat method, of class ParkController.
     */
    @Test
    public void testSetUserLat() {
        System.out.println("setUserLat");
        float userLat = 12.123456F;
        ParkController instance = new ParkController();
        instance.setUserLat(userLat);
        assertEquals(Double.compare(userLat, instance.getUserLat()), 0);
    }

    /**
     * Test of setUserLong method, of class ParkController.
     */
    @Test
    public void testSetUserLong() {
        System.out.println("setUserLong");
        float userLong = -8.123456F;
        ParkController instance = new ParkController();
        instance.setUserLong(userLong);
        assertEquals(Double.compare(userLong, instance.getUserLong()), 0);
    }

    @Test
    public void testParkController() {
        pController = new ParkController(41.158087F, -8.629120F, "p1");
        assertEquals(41.158087F, pController.getUserLat());
        assertEquals(-8.629120F, pController.getUserLong());
        assertEquals("p1", pController.getParkName());
    }

    @Test
    public void testAddNewPark() {
        pController = new ParkController();
        float userLat = 41.158087F;
        float userLong = -8.629120F;
        String parkName = "Park";
        long maxCapacityElect = 7;
        long maxCapacityNElect = 2;
       
        ParkDB pdb = mock(ParkDB.class);//Criação da classe mock
        pController = new ParkController();//criação do controller em teste
        pController.setParkDataBase(pdb);//set da database mock no controller para teste

        Park p1 = new Park(parkName, userLat, userLong, maxCapacityElect, maxCapacityNElect);

        when(pdb.newPark(p1)).thenReturn(true);//quando o controller chamar a função da DB, usa a DB mock e retorna o resultado p1

        Boolean expResult = pdb.newPark(p1);
        assertEquals(expResult, true);
        verify(pdb).newPark(p1);//verifica se a DB mock foi usada

    }

    @Test
    public void nearestParks() throws IOException, SQLException {
        pController = new ParkController();

        pController.parkDataBase = mock(ParkDB.class);
        //Rotunda da Boavista
        pController.setUserLat(41.158087F);
        pController.setUserLong(-8.629120F);
        
        List<String> nomes = new ArrayList<>();
        String p1 = "ISEP_PARK";
        String p2 = "Gaia Park";
        String p3 = "Parque da Cidade";
        String p4 = "Algarve Park";
        nomes.add(p1);
        nomes.add(p2);
        nomes.add(p3);
        nomes.add(p4);
        Park park1 = new Park();
        park1.setName(p1);
        park1.setLatitude(41.177384F);
        park1.setLongitude(-8.608033F);
        Park park2 = new Park();
        park2.setName(p2);
        park2.setLatitude(41.132461F);
        park2.setLongitude(-8.668450F);
        Park park3 = new Park();
        park3.setName(p3);
        park3.setLatitude(41.171043F);
        park3.setLongitude(-8.679148F);
        Park park4 = new Park();
        park4.setName(p4);
        park4.setLatitude(37.119348F);
        park4.setLongitude(-8.530851F);

        when(pController.parkDataBase.getParkNames()).thenReturn(nomes);

        when(pController.getParkByName(p1)).thenReturn(park1);
        when(pController.getParkByName(p2)).thenReturn(park2);
        when(pController.getParkByName(p3)).thenReturn(park3);
        when(pController.getParkByName(p4)).thenReturn(park4);
        
//        when(pController.distanceToPark(p1)).thenReturn(2778.3752F);
//        when(pController.distanceToPark(p2)).thenReturn(4355.7505F);
//        when(pController.distanceToPark(p3)).thenReturn(4429.076F);
        
        List<Map<String, Float>> expResult = new ArrayList<>();
        Map<String, Float> mp1 = new HashMap<>();
        mp1.put(p1, pController.distanceToPark(p1));
        expResult.add(mp1);
        Map<String, Float> mp2 = new HashMap<>();
        mp2.put(p2, pController.distanceToPark(p2));
        expResult.add(mp2);
        Map<String, Float> mp3 = new HashMap<>();
        mp3.put(p3, pController.distanceToPark(p3));
        expResult.add(mp3);
        //Not expected, only 3 nearest
        Map<String, Float> mp4 = new HashMap<>();
        mp4.put(p4, pController.distanceToPark(p4));

        List<Map<String, Float>> result = pController.nearestParks(3);
        
        assertEquals(expResult, result);
        verify(pController.parkDataBase, atLeastOnce()).getParkNames();
        verify(pController.parkDataBase, atLeastOnce()).getParkByName(p1);
        verify(pController.parkDataBase, atLeastOnce()).getParkByName(p2);
        verify(pController.parkDataBase, atLeastOnce()).getParkByName(p3);
        verify(pController.parkDataBase, atLeastOnce()).getParkByName(p4);
        
//        verify(pController, atLeastOnce()).distanceToPark(p1);
//        verify(pController, atLeastOnce()).distanceToPark(p2);
//        verify(pController, atLeastOnce()).distanceToPark(p3);
    }

    @Test
    public void orderByMapValue() {
        List<Map<String, Float>> original = new ArrayList<>();
        Map<String, Float> mp1 = new HashMap<>();
        mp1.put("p1", 1234.4321F);
        original.add(mp1);
        Map<String, Float> mp2 = new HashMap<>();
        mp2.put("p2", 12.21F);
        original.add(mp2);

        List<Map<String, Float>> ordered = new ArrayList<>();
        Map<String, Float> mp3 = new HashMap<>();
        mp3.put("p1", 1234.4321F);
        ordered.add(mp3);
        Map<String, Float> mp4 = new HashMap<>();
        mp4.put("p2", 12.21F);
        ordered.add(mp4);

        ParkController pc = new ParkController();
        ordered = pc.orderByMapValue(ordered);
        assertNotEquals(ordered, original);
    }

    @Test
    public void orderByMapValueEqual() {
        List<Map<String, Float>> original = new ArrayList<>();
        Map<String, Float> mp1 = new HashMap<>();
        mp1.put("p1", 1234.4321F);
        original.add(mp1);
        Map<String, Float> mp2 = new HashMap<>();
        mp2.put("p2", 1234.4321F);
        original.add(mp2);


        List<Map<String, Float>> ordered = new ArrayList<>();
        Map<String, Float> mp3 = new HashMap<>();
        mp3.put("p2", 1234.4321F);
        ordered.add(mp3);
        Map<String, Float> mp4 = new HashMap<>();
        mp4.put("p1", 1234.4321F);
        ordered.add(mp4);

        ParkController pc = new ParkController();
        ordered = pc.orderByMapValue(ordered);
        assertNotEquals(ordered, original);
    }

    @Test
    void addNewPark() {
        ParkController pc = new ParkController();
        ParkDB pdb = mock(ParkDB.class);
        pc.setParkDataBase(pdb);

        Park park1 = new Park();
        park1.setName("p1");
        park1.setLatitude(41.177384F);
        park1.setLongitude(-8.608033F);

        when(pdb.newPark(park1)).thenReturn(true);
        assertTrue(pc.addNewPark(41.177384F,-8.608033F,"p1",5,10));
        verify(pdb,atLeastOnce()).newPark(park1);
    }
    
     /**
//     * Test of removePark method, of class AdmnistratorController.
//     */
//    @Test
//    public void testRemovePark() {
//        System.out.println("removePark");
//        String parkName = "ISEP_PARK";
//
//        ParkDB pdb = mock(ParkDB.class);
//        adminController = new AdmnistratorController();
//        adminController.setParkDataBase(pdb);
//
//       
//        Park p1 = new Park();
//        p1.setId(001);
//        p1.setAdmin_Id(01);
//        p1.setName(parkName);
//        p1.setLatitude(41.177855F);
//        p1.setLongitude(-8.608079F);
//        p1.setMaxCapacityNonElectric(50);
//        p1.setMaxCapacityElectric(10);
//        when(pdb.removePark(parkName)).thenReturn(true);
//
//        Park expResult = null;
//        Park result = adminController.getParkByName(parkName);
//        assertEquals(expResult, result);
//        verify(pdb).getParkByName(parkName);
//        verify(pdb).removePark(parkName);
//    }
}

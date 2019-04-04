/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author andre
 */
public class WorkshopTest {
    
    public WorkshopTest() {
    }

    /**
     * Test of getWantToAttend method, of class Workshop.
     */
    @Test
    public void testSetAndGetWantToAttend() {
        System.out.println("set/getWantToAttend");
        Workshop instance = new Workshop();
        List<Boolean> wantToAttend = new ArrayList<>();
        wantToAttend.add(Boolean.TRUE);
        wantToAttend.add(Boolean.TRUE);
        wantToAttend.add(Boolean.FALSE);
        instance.setWantToAttend(wantToAttend);
        List<Boolean> result = instance.getWantToAttend();
        assertEquals(wantToAttend, result);
    }

    /**
     * Test of setNecessaryEquipment method, of class Workshop.
     */
    @Test
    public void testSetNecessaryEquipment() {
        System.out.println("setNecessaryEquipment");
        List<String> necessaryEquip = new ArrayList<>();
        necessaryEquip.add("Lavatorio");
        necessaryEquip.add("Agua potavél");
        necessaryEquip.add("Quadro");
        Workshop instance = new Workshop();
        instance.setNecessaryEquipment(necessaryEquip);
    }

    /**
     * Test of addAtendeeDecision method, of class Workshop.
     */
    @Test
    public void testAddAtendeeDecision() {
        System.out.println("addAtendeeDecision");
        Boolean d = Boolean.TRUE;
        Workshop instance = new Workshop();
        instance.addAtendeeDecision(d);
    }

    /**
     * Test of getDescription method, of class Workshop.
     */
    @Test
    public void testSetAndGetDescription() {
        System.out.println("set/getDescription");
        Workshop instance = new Workshop();
        String expResult = "Description";
        instance.setDescription(expResult);
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDurationInHours method, of class Workshop.
     */
    @Test
    public void testGetDurationInHours() {
        System.out.println("getDurationInHours");
        Workshop instance = new Workshop();
        int expResult = 3;
        instance.setDurationInHours(expResult);
        int result = instance.getDurationInHours();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Workshop.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object otherObject = null;
        Workshop instance = new Workshop();
        boolean expResult = false;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Workshop.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals2");
        List<String> necessaryEquip = new ArrayList<>();
        necessaryEquip.add("Lavatorio");
        necessaryEquip.add("Agua potavél");
        necessaryEquip.add("Quadro");
        Workshop instance = new Workshop("description", 5, necessaryEquip);
        
        Workshop instance2 = new Workshop("description2", 5, necessaryEquip);
        
        Object otherObject = instance2;
        boolean expResult = false;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Workshop.
     */
    @Test
    public void testEquals3() {
        System.out.println("equals3");
        
        List<Boolean> wantToAttend = new ArrayList<>();
        wantToAttend.add(Boolean.TRUE);
        wantToAttend.add(Boolean.TRUE);
        wantToAttend.add(Boolean.FALSE);
        
        List<String> necessaryEquip = new ArrayList<>();
        necessaryEquip.add("Lavatorio");
        necessaryEquip.add("Agua potavél");
        necessaryEquip.add("Quadro");
        Workshop instance = new Workshop("description", 5, necessaryEquip);
        instance.setWantToAttend(wantToAttend);
        
        Workshop instance2 = new Workshop("description", 6, necessaryEquip);
        instance2.setWantToAttend(wantToAttend);
        
        Object otherObject = instance2;
        boolean expResult = false;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of equals method, of class Workshop.
     */
    @Test
    public void testEquals5() {
        System.out.println("equals5");
        List<Boolean> wantToAttend = new ArrayList<>();
        wantToAttend.add(Boolean.TRUE);
        wantToAttend.add(Boolean.TRUE);
        wantToAttend.add(Boolean.FALSE);
        
        List<String> necessaryEquip = new ArrayList<>();
        necessaryEquip.add("Lavatorio");
        necessaryEquip.add("Agua potavél");
        necessaryEquip.add("Quadro");
        Workshop instance = new Workshop("description", 5, necessaryEquip);
        instance.setWantToAttend(wantToAttend);
        
        User user = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.ATENDEE);
        StaffMember staff = new StaffMember(user);
        Review rv = new Review("text", 0, 0, 0, 0, Decision.DECLINED, staff);
        
        Object otherObject = rv;
        boolean expResult = false;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Workshop.
     */
    @Test
    public void testEquals4() {
        System.out.println("equals4");
        
        List<Boolean> wantToAttend = new ArrayList<>();
        wantToAttend.add(Boolean.TRUE);
        wantToAttend.add(Boolean.TRUE);
        wantToAttend.add(Boolean.FALSE);
        
        List<Boolean> wantToAttend2 = new ArrayList<>();
        wantToAttend.add(Boolean.FALSE);
        wantToAttend.add(Boolean.TRUE);
        wantToAttend.add(Boolean.TRUE);
        
        List<String> necessaryEquip = new ArrayList<>();
        necessaryEquip.add("Lavatorio");
        necessaryEquip.add("Agua potavél");
        necessaryEquip.add("Quadro");
        Workshop instance = new Workshop("description", 2, necessaryEquip);
        instance.setWantToAttend(wantToAttend);
        
        Workshop instance2 = new Workshop("description", 2, necessaryEquip);
        instance2.setWantToAttend(wantToAttend2);
        
        Object otherObject = instance2;
        boolean expResult = false;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Workshop.
     */
    @Test
    public void testEquals6() {
        System.out.println("equals6");
        List<Boolean> wantToAttend = new ArrayList<>();
        wantToAttend.add(Boolean.TRUE);
        wantToAttend.add(Boolean.TRUE);
        wantToAttend.add(Boolean.FALSE);
        
        List<String> necessaryEquip = new ArrayList<>();
        necessaryEquip.add("Lavatorio");
        necessaryEquip.add("Agua potavél");
        necessaryEquip.add("Quadro");
        Workshop instance = new Workshop("description", 5, necessaryEquip);
        instance.setWantToAttend(wantToAttend);
        
        
        List<String> necessaryEquip2 = new ArrayList<>();
        necessaryEquip2.add("Esgoto");
        necessaryEquip2.add("madeira");
        necessaryEquip2.add("Quadro");
        Workshop instance2 = new Workshop("description", 5, necessaryEquip2);
        instance2.setWantToAttend(wantToAttend);
        
        Object otherObject = instance2;
        boolean result = instance.equals(otherObject);
        assertFalse(result);
    }
    

    /**
     * Test of hashCode method, of class Workshop.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        List<String> necessaryEquip = new ArrayList<>();
        necessaryEquip.add("Lavatorio");
        necessaryEquip.add("Agua potavél");
        necessaryEquip.add("Quadro");
        Workshop instance = new Workshop("description", 5, necessaryEquip);
        int expResult = -423737489;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author andre
 */
public class EventManagerTest {
    
    public EventManagerTest() {
    }
    

    /**
     * Test of getEventManager method, of class EventManager.
     */
    @Test
    public void testSetAndGetEventManager() {
        System.out.println("set get EventManager");
        EventManager instance = new EventManager();
        User expResult = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.ATENDEE);
        instance.setEventManager(expResult);
        User result = instance.getEventManager();
        assertEquals(expResult, result);
    }
    
}

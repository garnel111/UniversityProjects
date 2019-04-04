/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import lapr.project.model.Event;
import lapr.project.model.EventState;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Organiser;
import lapr.project.model.OrganiserRegister;
import lapr.project.model.Role;
import lapr.project.model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author MariaJoão
 */
public class CreateEventControllerTest {

    
  
    /**
     * Test of getUsersAvailable method, of class CreateEventController.
     */
 
    @Test
    public void testGetUsersAvailable() {
        System.out.println("getUsersAvailable");
        ExhibitionCentre centre= new  ExhibitionCentre();
        CreateEventController instance = new CreateEventController(centre);
        User u1= new User();
        u1.setRole(Role.EMPLOYEE);
        u1.setUsername("maria");   
        u1.setEmail("email1");
        User u3= new User();
        u3.setRole(Role.EMPLOYEE);
        u3.setUsername("tiago");
        u1.setEmail("email2");
        centre.getUserRegister().addUser(u1);
        System.out.println(u1.getUsername());
        centre.getUserRegister().addUser(u3);
        List<User> expResult = new ArrayList<>();
        expResult.add(u1);
        expResult.add(u3);        
        List<User> result = instance.getUsersAvailable();
        assertEquals(result, expResult);
    }
 
 

    /**
     * Test of checkFormat method, of class CreateEventController.
     */


    /**
     * Test of validateDateGap method, of class CreateEventController.
     */
    @Test
    public void testCompareDates() {
        System.out.println("test CompareDates");
        Date date1 = new Date();
        Date date2 = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.set( Calendar.HOUR_OF_DAY, 0 );
        calendar.set( Calendar.MINUTE, 0 );
        calendar.set( Calendar.SECOND, 0 );
        date1= calendar.getTime();
        calendar.set( Calendar.HOUR_OF_DAY, 2 );
        date2= calendar.getTime();

        
        ExhibitionCentre centre= new ExhibitionCentre();
        CreateEventController instance = new CreateEventController(centre);
        boolean expResult = true;
        boolean result = instance.compareDates(date1, date2);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of createOrganiser method, of class CreateEventController.
     */
    @Test
    public void testCreateOrganiser() {
        System.out.println("createOrganiser");
        ExhibitionCentre centre= new  ExhibitionCentre();
        CreateEventController instance = new CreateEventController(centre);
        
        int userPos=3;
        
        User u1= new User();
        u1.setUsername("user1");
        u1.setEmail("email@email.pt");
        u1.setPassword(0.1);
        u1.setName("Joao");
        User u2= new User();
        u2.setUsername("user2");
        u2.setEmail("email1@email.pt");
        u2.setPassword(0.1);
        u2.setName("Joao2");
        User u3= new User();
        u3.setUsername("user3");
        u3.setEmail("email2@email.pt");
        u3.setPassword(0.1);
        u3.setName("Joao3");
        
        Organiser expResult= new Organiser();
        expResult.setOrganiser(u3);
        
        List<User> usersAvailable = new ArrayList<>();
        usersAvailable.add(u1);
        usersAvailable.add(u2);
        usersAvailable.add(u3);
        
        Organiser result = instance.createOrganiser(usersAvailable, userPos);
        boolean x=result.equals(expResult);
        assertEquals(result,expResult);
        }

    /**
     * Test of addOrganiser method, of class CreateEventController.
     */
    @Test
    public void testAddOrganiser() {
        System.out.println("addOrganiser");
            
        ExhibitionCentre centre= new  ExhibitionCentre();
        CreateEventController instance = new CreateEventController(centre);
        User u1= new User();
        u1.setUsername("user1");
        Organiser o = new Organiser(); 
        o.setOrganiser(u1);
        boolean expResult = true;
        boolean result = instance.addOrganiser(o);
        assertEquals(expResult, result);

    }

    /**
     * Test of setData method, of class CreateEventController.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        ExhibitionCentre centre= new  ExhibitionCentre();
        CreateEventController instance = new CreateEventController(centre);
        Event expResult= new Event();
        String title = "title";
        String description = "desc";
        String place = "place";
        expResult.setDescription(description);
        expResult.setTitle(title);
        expResult.setPlace(place);
        expResult.setEventState(EventState.CREATED);
        expResult.setOrganisersRegister(new OrganiserRegister());
        instance.setData(title, description, null, null, place);
        Event result= instance.getEvent();            
        assertEquals(result, expResult);

    }

    /**
     * Test of registerEvent method, of class CreateEventController.
     */
    @Test
    public void testRegisterEvent() {
        System.out.println("registerEvent");
        ExhibitionCentre centre= new  ExhibitionCentre();
        CreateEventController instance = new CreateEventController(centre);
        
        Event e1= new Event();
        String title = "title";
        String description = "desc";
        String place = "place";
        e1.setDescription(description);
        e1.setTitle(title);
        e1.setPlace(place);
        instance.setEvent(e1);
        
        instance.registerEvent();
        
        boolean result= centre.getEventRegister().exists(e1);
        boolean expResult= true;

        assertEquals(expResult, result);

    }

    /**
     * Test of getEvent method, of class CreateEventController.
     */
    @Test
    public void testGetEvent() {
        System.out.println("getEvent");
        ExhibitionCentre centre= new  ExhibitionCentre();
        CreateEventController instance = new CreateEventController(centre);
        
        Event expResult = new Event();
        expResult.setTitle("event1");
        instance.setEvent(expResult);
        
        Event result = instance.getEvent();
        
        assertEquals(expResult, result);

    }

    /**
     * Test of setEvent method, of class CreateEventController.
     */
    @Test
    public void testSetEvent() {
        System.out.println("setEvent");
        ExhibitionCentre centre= new  ExhibitionCentre();
        CreateEventController instance = new CreateEventController(centre);
        
        Event expResult = new Event();
        expResult.setTitle("event1");
        instance.setEvent(expResult);
        
        Event result = instance.getEvent();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getOr method, of class CreateEventController.
     */
    @Test
    public void testGetOr() {
        System.out.println("getOr");
        ExhibitionCentre centre= new  ExhibitionCentre();
        CreateEventController instance = new CreateEventController(centre);
        OrganiserRegister expResult= new OrganiserRegister();
        Organiser o= new Organiser();
        User u1= new User();
        u1.setName("name");
        o.setOrganiser(u1);
        expResult.addOrganiser(o);        
        instance.setOr(expResult);
        OrganiserRegister result = instance.getOr();
        assertEquals(expResult, result);

    }

    /**
     * Test of setOr method, of class CreateEventController.
     */
    @Test
    public void testSetOr() {
        System.out.println("setOr");
        ExhibitionCentre centre= new  ExhibitionCentre();
        CreateEventController instance = new CreateEventController(centre);
        OrganiserRegister expResult= new OrganiserRegister();
        Organiser o= new Organiser();
        User u1= new User();
        u1.setName("name");
        o.setOrganiser(u1);
        expResult.addOrganiser(o);  
        instance.setOr(expResult);
        OrganiserRegister result = instance.getOr();
        assertEquals(expResult, result);
    }
    
}

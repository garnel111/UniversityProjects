/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Application;
import lapr.project.model.ApplicationRegister;
import lapr.project.model.ApplicationState;
import lapr.project.model.Event;
import lapr.project.model.EventRegister;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Organiser;
import lapr.project.model.OrganiserRegister;
import lapr.project.model.Role;
import lapr.project.model.User;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author MariaJoão
 */
public class AssignStaffMemberToReviewControllerTest {
    
    public AssignStaffMemberToReviewControllerTest() {
    }
    
    /**
     * Test of getEventsFromOrganiser method, of class AssignStaffMemberToReviewController.
     */
    @Test
    public void testGetEventsFromOrganiser() {
        System.out.println("getEventsFromOrganiser");
        ExhibitionCentre centre= new ExhibitionCentre();
        AssignStaffMemberToReviewController instance = new AssignStaffMemberToReviewController(centre);
        EventRegister er= new EventRegister();
        OrganiserRegister or= new OrganiserRegister();
        User u1 = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.EMPLOYEE);
        Organiser o = new Organiser();
        o.setOrganiser(u1);
        or.addOrganiser(o);
        
        Event e1= new Event();
        e1.setTitle("event1");
        e1.addOrganiserRegister(or);
        Event e2= new Event();
        e2.setTitle("event2");
        e2.addOrganiserRegister(or);
        Event e3= new Event();
        e3.setTitle("event3");
        
        centre.setUserOnline(u1);
                
        er.addEvent(e1);
        er.addEvent(e2);
        er.addEvent(e3);
        
        centre.setEventRegister(er);
        List<Event> expResult= new ArrayList<>();
        expResult.add(e1);
        expResult.add(e2);
        
        List<Event> result=instance.getEventsFromOrganiser();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEvent method, of class AssignStaffMemberToReviewController.
     */
    @Test
    public void testGetEvent() {
        System.out.println("getEvent");
        ExhibitionCentre centre= new ExhibitionCentre();
        EventRegister er= new EventRegister();
        OrganiserRegister or= new OrganiserRegister();
        User u1 = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.EMPLOYEE);
        Organiser o = new Organiser();
        o.setOrganiser(u1);
        or.addOrganiser(o);
        
        Event e1= new Event();
        e1.setTitle("event1");
        e1.addOrganiserRegister(or);
        Event e2= new Event();
        e2.setTitle("event2");
        e2.addOrganiserRegister(or);
        Event e3= new Event();
        e3.setTitle("event3");
        
        centre.setUserOnline(u1);
                
        er.addEvent(e1);
        er.addEvent(e2);
        er.addEvent(e3);
        
        centre.setEventRegister(er);

        AssignStaffMemberToReviewController instance = new AssignStaffMemberToReviewController(centre);
        instance.setEvent(0);        
        assertEquals(e1, instance.getEvent());

    }

    /**
     * Test of setEvent method, of class AssignStaffMemberToReviewController.
     */
    @Test
    public void testSetEvent() {
        ExhibitionCentre centre= new ExhibitionCentre();
        EventRegister er= new EventRegister();
        OrganiserRegister or= new OrganiserRegister();
        User u1 = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.EMPLOYEE);
        Organiser o = new Organiser();
        o.setOrganiser(u1);
        or.addOrganiser(o);
        
        Event e1= new Event();
        e1.setTitle("event1");
        e1.addOrganiserRegister(or);
        Event e2= new Event();
        e2.setTitle("event2");
        e2.addOrganiserRegister(or);
        Event e3= new Event();
        e3.setTitle("event3");
        
        centre.setUserOnline(u1);
                
        er.addEvent(e1);
        er.addEvent(e2);
        er.addEvent(e3);
        
        centre.setEventRegister(er);

        AssignStaffMemberToReviewController instance = new AssignStaffMemberToReviewController(centre);
        instance.setEvent(0);        
        assertEquals(e1, instance.getEvent());
    }

    /**
     * Test of getApplication method, of class AssignStaffMemberToReviewController.
     */
    @Test
    public void testGetApplication() {
        ExhibitionCentre centre= new ExhibitionCentre();
        EventRegister er= new EventRegister();
        OrganiserRegister or= new OrganiserRegister();
        User u1 = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.EMPLOYEE);
        Organiser o = new Organiser();
        o.setOrganiser(u1);
        or.addOrganiser(o);
        
        Event e1= new Event();
        e1.setTitle("event1");
        e1.addOrganiserRegister(or);
        Event e2= new Event();
        e2.setTitle("event2");
        e2.addOrganiserRegister(or);
        Event e3= new Event();
        e3.setTitle("event3");
        
        centre.setUserOnline(u1);
                
        er.addEvent(e1);
        er.addEvent(e2);
        er.addEvent(e3);
        ApplicationRegister app= new ApplicationRegister();
        Application a = new Application();
        a.setDescription("app1");
        a.setState(ApplicationState.CREATED);
        app.addApplication(a);
        e1.setApplicationRegister(app);
        centre.setEventRegister(er);

        AssignStaffMemberToReviewController instance = new AssignStaffMemberToReviewController(centre);
        instance.setEvent(0);        
        instance.setApplication(0);
        assertEquals(a, instance.getApplication());
    }

    /**
     * Test of setApplication method, of class AssignStaffMemberToReviewController.
     */
    @Test
    public void testSetApplication() {
        System.out.println("setApplication");
        ExhibitionCentre centre= new ExhibitionCentre();
        EventRegister er= new EventRegister();
        OrganiserRegister or= new OrganiserRegister();
        User u1 = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.EMPLOYEE);
        Organiser o = new Organiser();
        o.setOrganiser(u1);
        or.addOrganiser(o);
        
        Event e1= new Event();
        e1.setTitle("event1");
        e1.addOrganiserRegister(or);
        Event e2= new Event();
        e2.setTitle("event2");
        e2.addOrganiserRegister(or);
        Event e3= new Event();
        e3.setTitle("event3");
        
        centre.setUserOnline(u1);
                
        er.addEvent(e1);
        er.addEvent(e2);
        er.addEvent(e3);
        ApplicationRegister app= new ApplicationRegister();
        Application a = new Application();
        a.setDescription("app1");
        a.setState(ApplicationState.CREATED);
        
        app.addApplication(a);
        e1.setApplicationRegister(app);
        centre.setEventRegister(er);

        AssignStaffMemberToReviewController instance = new AssignStaffMemberToReviewController(centre);
        instance.setEvent(0);        
        instance.setApplication(0);
        assertEquals(a, instance.getApplication());
    }

    /**
     * Test of getApplicationsFromEvent method, of class AssignStaffMemberToReviewController.
     */
    @Test
    public void testGetApplicationsFromEvent() {
        System.out.println("getApplicationsFromEvent");

    }

    /**
     * Test of getStaffMembersFromEvent method, of class AssignStaffMemberToReviewController.
     */
    @Test
    public void testGetStaffMembersFromEvent() {
        System.out.println("getStaffMembersFromEvent");

    }

    /**
     * Test of getStaff method, of class AssignStaffMemberToReviewController.
     */
    @Test
    public void testGetStaff() {
        System.out.println("getStaff");

    }

    /**
     * Test of setStaff method, of class AssignStaffMemberToReviewController.
     */
    @Test
    public void testSetStaff() {
        System.out.println("setStaff");

    }

    /**
     * Test of assignMember method, of class AssignStaffMemberToReviewController.
     */
    @Test
    public void testAssignMember() {
        System.out.println("assignMember");

    }

    /**
     * Test of registerLog method, of class AssignStaffMemberToReviewController.
     */
    @Test
    public void testRegisterLog() {
        System.out.println("registerLog");

    }
    
}

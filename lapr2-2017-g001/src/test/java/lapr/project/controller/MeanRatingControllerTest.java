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
import lapr.project.model.Decision;
import lapr.project.model.Event;
import lapr.project.model.EventRegister;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Keyword;
import lapr.project.model.Review;
import lapr.project.model.Role;
import lapr.project.model.StaffMember;
import lapr.project.model.StaffRegister;
import lapr.project.model.User;
import lapr.project.model.UserRegister;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author JM
 */
public class MeanRatingControllerTest {

    /**
     * Test of getStaffList method, of class MeanRatingController.
     */
    @Test
    public void testGetStaffList() {
        System.out.println("getStaffList");
        ExhibitionCentre centre = new ExhibitionCentre();
        User user1 = new User("José", "j@gmail.com", "jose", 0.1234, Role.EMPLOYEE);
        User user2 = new User("Luís", "l@gmail.com", "luis", 0.4321, Role.PARTICIPANT);
        UserRegister userRegister = new UserRegister();
        userRegister.addUser(user1);
        userRegister.addUser(user2);
        centre.setUserRegister(userRegister);
        Event event1 = new Event();
        Application app1 = new Application();
        StaffMember staff1 = new StaffMember(user1);
        Review rev1 = new Review("rev1", 5, 5, 5, 5, Decision.DECLINED, staff1);
        List<Review> revList = new ArrayList<>();
        revList.add(rev1);
        app1.setListReview(revList);
        ApplicationRegister appReg = new ApplicationRegister();
        appReg.addApplication(app1);
        event1.setApplicationRegister(appReg);
        EventRegister eventRegister = new EventRegister();
        eventRegister.addEvent(event1);
        centre.setEventRegister(eventRegister);
        StaffRegister staffRegister = new StaffRegister();
        staffRegister.addStaffMember(staff1);
        event1.setStaffRegister(staffRegister);
        
        MeanRatingController instance = new MeanRatingController(centre);
        List<User> expResult = new ArrayList<>();
        expResult.add(user1);
        System.out.println(instance.getStaffList().toString());
        List<User> result = instance.getStaffList();
        assertEquals(expResult, result);
    }

    /**
     * Test of calcMeanRating method, of class MeanRatingController.
     */
    @Test
    public void testCalcMeanRating() {
        ExhibitionCentre centre = new ExhibitionCentre();
        Event event1 = new Event();
        Event event2 = new Event();

        User user = new User("João Silva", "js@gmail.com", "js", 0.1234, Role.EMPLOYEE);
        StaffMember staff1 = new StaffMember(user);
        User user2 = new User("António Pereira", "ap@gmail.com", "ap", 0.4321, Role.EMPLOYEE);
        StaffMember staff2 = new StaffMember(user2);

        UserRegister userRegister = new UserRegister();
        userRegister.addUser(user);
        userRegister.addUser(user2);
        centre.setUserRegister(userRegister);
        List<Keyword> keys = new ArrayList<>();
        Keyword k = new Keyword("keywords");
        keys.add(k);

        Review rev1 = new Review("rev1", 5, 5, 5, 5, Decision.ACCEPTED, staff1);
        rev1.setAreaAdequacy(5);
        Review rev2 = new Review("rev2", 5, 5, 5, 5, Decision.ACCEPTED, staff2);
        rev2.setAreaAdequacy(5);
        List<Review> revList = new ArrayList<>();
        revList.add(rev1);
        revList.add(rev2);

        List<Review> revList2 = new ArrayList<>();
        revList2.add(rev2);

        Application app1 = new Application("app1", keys, revList);
        Application app12 = new Application("app12", keys, revList2);

        List<Application> appList = new ArrayList<>();
        appList.add(app1);
        appList.add(app12);

        ApplicationRegister appRegister = new ApplicationRegister(appList);
        event1.setApplicationRegister(appRegister);

        //Event2
        Review rev3 = new Review("rev3", 0, 0, 0, 0, Decision.ACCEPTED, staff1);
        rev3.setAreaAdequacy(0);
        Review rev4 = new Review("rev4", 0, 0, 0, 0, Decision.ACCEPTED, staff2);
        rev4.setAreaAdequacy(0);
        List<Review> revList3 = new ArrayList<>();
        revList.add(rev3);
        revList.add(rev4);

        List<Review> revList4 = new ArrayList<>();
        revList2.add(rev4);

        Application app2 = new Application("app2", keys, revList3);
        Application app22 = new Application("app22", keys, revList4);

        List<Application> appList2 = new ArrayList<>();
        appList2.add(app2);
        appList2.add(app22);

        ApplicationRegister appRegister2 = new ApplicationRegister(appList2);
        event2.setApplicationRegister(appRegister2);

        //Adds ao centro
        List<Event> eventList = new ArrayList<>();
        eventList.add(event1);
        eventList.add(event2);

        EventRegister eventRegister = new EventRegister(eventList);

        centre.setEventRegister(eventRegister);

        MeanRatingController instance = new MeanRatingController(centre);

        String username = "js";
        double expResult = 2.5;
        double result = instance.calcMeanRating(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of findUser method, of class MeanRatingController.
     */
    @Test
    public void testFindUser() {
        System.out.println("findUser");

        ExhibitionCentre centre = new ExhibitionCentre();

        User user = new User("João Silva", "js@gmail.com", "js", 0.1234, Role.EMPLOYEE);
        User user2 = new User("António Pereira", "ap@gmail.com", "ap", 0.4321, Role.EMPLOYEE);

        UserRegister userRegister = new UserRegister();
        userRegister.addUser(user);
        userRegister.addUser(user2);
        centre.setUserRegister(userRegister);

        String username = "js";
        MeanRatingController instance = new MeanRatingController(centre);
        User expResult = user;
        User result = instance.findUser(username);
        assertEquals(expResult, result);
        assertEquals(null, instance.findUser("a"));
    }

    /**
     * Test of staffExists method, of class MeanRatingController.
     */
    @Test
    public void testStaffExists() {
        System.out.println("staffExists");
        ExhibitionCentre centre = new ExhibitionCentre();

        User user = new User("João Silva", "js@gmail.com", "js", 0.1234, Role.EMPLOYEE);
        User user2 = new User("António Pereira", "ap@gmail.com", "ap", 0.4321, Role.EMPLOYEE);

        UserRegister userRegister = new UserRegister();
        userRegister.addUser(user);
        userRegister.addUser(user2);
        centre.setUserRegister(userRegister);
        Event event1 = new Event();
        StaffMember staff1 = new StaffMember(user);
        StaffRegister staffRegister = new StaffRegister();
        staffRegister.addStaffMember(staff1);
        event1.setStaffRegister(staffRegister);
        EventRegister eventRegister = new EventRegister();
        eventRegister.addEvent(event1);
        centre.setEventRegister(eventRegister);

        String username = "js";
        MeanRatingController instance = new MeanRatingController(centre);
        boolean expResult = true;
        boolean result = instance.staffExists(username);
        assertEquals(expResult, result);
        assertEquals(false, instance.staffExists("a"));
    }

}

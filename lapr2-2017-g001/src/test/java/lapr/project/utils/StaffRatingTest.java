/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

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
import lapr.project.model.User;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 *
 * @author JM
 */
public class StaffRatingTest {

    /**
     * Test of meanRating method, of class StaffRating.
     */
    @Test
    public void testMeanRating() {
        System.out.println("meanRating");
        ExhibitionCentre centre = new ExhibitionCentre();
        Event event1 = new Event();
        Event event2 = new Event();

        User user = new User("João Silva", "js@gmail.com", "js", 0.1234, Role.EMPLOYEE);
        StaffMember staff1 = new StaffMember(user);
        User user2 = new User("António Pereira", "ap@gmail.com", "ap", 0.4321, Role.EMPLOYEE);
        StaffMember staff2 = new StaffMember(user2);

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

        //Fim dos dados
        StaffRating rating = new StaffRating(centre);
        assertEquals(2.5, rating.meanRating(user));

    }

    /**
     * Test of meanRating method, of class StaffRating.
     */
    @Test
    public void testMeanRatingZero() {
        System.out.println("meanRating");
        ExhibitionCentre centre = new ExhibitionCentre();
        Event event1 = new Event();
        Event event2 = new Event();
        EventRegister eventRegister = new EventRegister();
        eventRegister.addEvent(event1);
        eventRegister.addEvent(event2);
        centre.setEventRegister(eventRegister);
        User user = new User("José", "j@gmail.com", "jose", 0.1234, Role.EMPLOYEE);
        StaffRating rating = new StaffRating(centre);
        assertEquals(0, rating.meanRating(user));
    }

    /**
     * Test of meanDeviation method, of class StaffRating.
     */
    @Test
    public void testMeanDeviation() {
        System.out.println("meanDeviation");

        ExhibitionCentre centre = new ExhibitionCentre();
        Event event1 = new Event();
        Event event2 = new Event();

        User user = new User("João Silva", "js@gmail.com", "js", 0.1234, Role.EMPLOYEE);
        StaffMember staff1 = new StaffMember(user);
        User user2 = new User("António Pereira", "ap@gmail.com", "ap", 0.4321, Role.EMPLOYEE);
        StaffMember staff2 = new StaffMember(user2);

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
        event2.setApplicationRegister(appRegister);

        //Adds ao centro
        List<Event> eventList = new ArrayList<>();
        eventList.add(event1);
        eventList.add(event2);

        EventRegister eventRegister = new EventRegister(eventList);

        centre.setEventRegister(eventRegister);

        //Fim dos dados
        StaffRating rating = new StaffRating(centre);
        assertEquals(2.5, rating.meanDeviation(user, event1));
    }

    /**
     * Test of meanDeviation method, of class StaffRating.
     */
    @Test
    public void testMeanDeviationZero() {
        System.out.println("meanDeviation");
        ExhibitionCentre centre = new ExhibitionCentre();
        Event event1 = new Event();
        Event event2 = new Event();
        EventRegister eventRegister = new EventRegister();
        eventRegister.addEvent(event1);
        eventRegister.addEvent(event2);
        centre.setEventRegister(eventRegister);
        User user = new User("José", "j@gmail.com", "jose", 0.1234, Role.EMPLOYEE);
        StaffRating rating = new StaffRating(centre);
        assertEquals(0, rating.meanDeviation(user, event1));
    }

    /**
     * Test of eventMean method, of class StaffRating.
     */
    @Test
    public void testEventMean() {
        System.out.println("eventMean");

        ExhibitionCentre centre = new ExhibitionCentre();
        Event event1 = new Event();

        User user = new User("João Silva", "js@gmail.com", "js", 0.1234, Role.EMPLOYEE);
        StaffMember staff1 = new StaffMember(user);
        User user2 = new User("António Pereira", "ap@gmail.com", "ap", 0.4321, Role.EMPLOYEE);
        StaffMember staff2 = new StaffMember(user2);

        List<Keyword> keys = new ArrayList<>();
        Keyword k = new Keyword("keywords");
        keys.add(k);

        Review rev1 = new Review("rev1", 5, 5, 5, 5, Decision.ACCEPTED, staff1);
        rev1.setAreaAdequacy(5);
        Review rev2 = new Review("rev2", 0, 0, 0, 0, Decision.ACCEPTED, staff2);
        rev2.setAreaAdequacy(0);
        List<Review> revList = new ArrayList<>();
        revList.add(rev1);

        List<Review> revList2 = new ArrayList<>();
        revList2.add(rev2);

        Application app1 = new Application("app1", keys, revList);
        Application app12 = new Application("app12", keys, revList2);

        List<Application> appList = new ArrayList<>();
        appList.add(app1);
        appList.add(app12);

        ApplicationRegister appRegister = new ApplicationRegister(appList);
        event1.setApplicationRegister(appRegister);

        //Adds ao centro
        List<Event> eventList = new ArrayList<>();
        eventList.add(event1);

        EventRegister eventRegister = new EventRegister(eventList);

        centre.setEventRegister(eventRegister);

        //Fim dos dados
        StaffRating rating = new StaffRating(centre);
        assertEquals(2.5, rating.eventMean(event1));
    }

}

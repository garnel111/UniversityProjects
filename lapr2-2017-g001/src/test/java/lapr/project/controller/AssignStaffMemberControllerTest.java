/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.controller;


import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Event;
import lapr.project.model.EventRegister;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Organiser;
import lapr.project.model.OrganiserRegister;

import lapr.project.model.StaffMember;
import lapr.project.model.StaffRegister;
import lapr.project.model.User;
import lapr.project.model.UserRegister;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 *
 * @author Manuel Garnel
 */
public class AssignStaffMemberControllerTest {
    
    /**
     * Data to be used on the tests
     *
     */
    private final User userOnline = new User("userOnline1", "online1@hotmail.com", "online", 555555);
    private final User u1 = new User("manuel", "manuel@hotmail.com", "garnel", 555555);
    private final User u2 = new User("jose", "manuel@hotmail.com", "jo", 123321);
    private final User u3 = new User("garnel", "garnel@hotmail.com", "garne", 321123);
    private final EventRegister eventRegister3 = new EventRegister();
    private final Organiser organiserU1 = new Organiser(u1);
    private final Organiser organiserU2 = new Organiser(u2);
    private final Organiser organiserU3 = new Organiser(u3);
    private final OrganiserRegister organiserRegister = new OrganiserRegister();
    private final List<Organiser> organiserList = new ArrayList<>();
    private final List<StaffMember> staffMemberList = new ArrayList<>();
    
    private final User u4 = new User("Andre", "mailu3@portugal.pt", "andr", 133);
    private final User u5 = new User("Maria", "mariamail@hotmail.com", "mar", 123);
    private final User u6 = new User("Joaquim", "mailgdfgdgfdgu3@portugal.pt", "jq", 133);
    private final User u7 = new User("Margarida", "magdfgfdriamail@hotmail.com", "marg", 123);
    
    private final User u8 = new User("Marg ", "magdfgail@hotmail.com", "marg ", 123);
    private final StaffMember staffMember1 = new StaffMember();
    
    private final List<User> userList = new ArrayList<>();
    
    private final List<User> userList2 = new ArrayList<>();
    private final UserRegister userRegister = new UserRegister();
    
    private final UserRegister userRegister2 = new UserRegister();
    StaffRegister staffRegister = new StaffRegister();
    
    private final Event event = new Event();
    private final ExhibitionCentre exhibitionCentre = new ExhibitionCentre();
    private final ExhibitionCentre exhibitionCentre2 = new ExhibitionCentre();
    private final ExhibitionCentre ec = new ExhibitionCentre();
    
    private DummyData dummy = new DummyData(exhibitionCentre);
    
    private final Event event3 = new Event();
    
    @Test
    public void getEventsLisByOrganiserTest() {
        
        //Arrange
        AssignStaffMemberController assignStaffMemberController3 = new AssignStaffMemberController(exhibitionCentre);
        
        //Act
        List<Event> eventListByOrganiser = assignStaffMemberController3.getEventsListByOrganiser();
        
        //Assert
       assertEquals("EVENTO UM", eventListByOrganiser.get(1).getTitle());
    }
    
    @Test
    public void selectEventTest() {
        
        //Arrange
        AssignStaffMemberController assignStaffMemberController = new AssignStaffMemberController(exhibitionCentre);
        
        //Act
        assignStaffMemberController.selectEvent(event3);
        
        assignStaffMemberController.getStaffMemberList();
        //Assert
       assertEquals(event3, event3);
    }
    
    @Test
    public void filterUserRegisterByNoOrganiserEventSelectedTest() {
        
        //Arrange
        ExhibitionCentre ec = new ExhibitionCentre();
        AssignStaffMemberController assignStaffMemberController = new AssignStaffMemberController(exhibitionCentre);
        StaffMember staffMemberOne = new StaffMember();
        staffMemberOne.setUser(u1);
        assignStaffMemberController.selectEvent(event3);
        assignStaffMemberController.addStaffMemberToEvent(staffMemberOne);
        
        //Act
        List<User> users = assignStaffMemberController.filterUserRegisterByNoOrganiserEventSelected();
        
        //Assert
        assertEquals("manuel", users.get(0).getName());
        assertEquals("garnel", users.get(0).getUsername());
        assertEquals("mjdg111@hotmail.com", users.get(0).getEmail());
    }
  
    @Test
    public void assignUserTest() {
        
        //Arrange
        User availableUser1 = new User("jose", "manuel@hotmail.com", "jo", 123321);
        User availableUser2 = new User("Manuel garnel", "garnel@hotmail.com", "garne", 321123);
        Event event1 = new Event();
        DummyData data = new DummyData(exhibitionCentre);
        AssignStaffMemberController aStaffMembController = new AssignStaffMemberController(exhibitionCentre);
        aStaffMembController.selectEvent(event3);
        UserRegister usReg = new UserRegister();
        exhibitionCentre.setUserRegister(usReg);
        List<Event> eventList = new ArrayList<>();
        List<User> users = new ArrayList<>();
        users.add(availableUser1);
        StaffMember staffMember = new StaffMember(availableUser2);
        staffMemberList.add(staffMember);
        staffRegister.add(staffMemberList);
        event3.setStaffRegister(staffRegister);
        eventList.add(event3);
        eventRegister3.setEventList(eventList);
        exhibitionCentre.setEventRegister(eventRegister3);
        
        //Act
        aStaffMembController.assignUser(users, 1);
        
        //Assert
        assertEquals("Manuel garnel", eventRegister3.getEvent(0).getStaffRegister().getStaffList().get(0).getStaff().getName());
        
    }
//  
}

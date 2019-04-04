/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lapr.project.model.Application;
import lapr.project.model.ApplicationRegister;
import lapr.project.model.ApplicationState;
import lapr.project.model.Decision;
import lapr.project.model.Event;
import lapr.project.model.EventRegister;
import lapr.project.model.EventState;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Keyword;
import lapr.project.model.Organiser;
import lapr.project.model.OrganiserRegister;
import lapr.project.model.Review;
import lapr.project.model.Role;
import lapr.project.model.StaffMember;
import lapr.project.model.StaffRegister;
import lapr.project.model.Stand;
import lapr.project.model.StandRegister;
import lapr.project.model.User;
import lapr.project.model.UserRegister;
import lapr.project.model.Workshop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author andre
 */
public class LoginControllerTest {
    
    //Application_________________________________
    ApplicationRegister appRegister = new ApplicationRegister();
    ApplicationRegister appRegister2 = new ApplicationRegister();
        
    Application app1 = new Application("description");
    Application app2 = new Application("description2");

    Keyword keyword1 = new Keyword("keyword1");
    Keyword keyword2 = new Keyword("keyword2");
    Keyword keyword3 = new Keyword("keyword3");
    Keyword keyword4 = new Keyword("keyword4");

    List<Keyword> listKey = new ArrayList<>();

    List<Boolean> wantToAttend = new ArrayList<>();

    List<String> necessaryEquip = new ArrayList<>();

    Workshop w1 = new Workshop("description w1", 3, necessaryEquip);        
    Workshop w2 = new Workshop("description w2", 2, necessaryEquip);

    List<Workshop> listWo = new ArrayList<>();

    User user = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.ATENDEE);
    StaffMember staff = new StaffMember(user);
    Review rv1 = new Review("RV1", 4, 4, 5, 3, Decision.DECLINED, staff);
    Review rv2 = new Review("RV2", 4, 4, 5, 3, Decision.DECLINED, staff);
    Review rv3 = new Review("RV3", 4, 4, 5, 3, Decision.ACCEPTED, staff);
    List<Review> listRev = new ArrayList<>();

    List<Application> listApp = new ArrayList<>();
    List<Application> listApp2 = new ArrayList<>();
    
    ExhibitionCentre exhibitionCentre;
    
    User user1 = new User("manuel", "mjdg111@hotmail.com", "garnel", 123, Role.ATENDEE);
    User user2 = new User("jose", "mail2@hotmail.com", "jo", 123 , Role.ATENDEE);
    User user3 = new User("sandra", "sandra@hotmail.com", "antunex", 123 , Role.ATENDEE);
    User user4 = new User("staffElement1_manuel", "mjdg111@hotmail.com", "garnel23", 123 , Role.ATENDEE);
    User user5 = new User("staffElment2_jose", "Jose@hotmail.com", "Jose1234", 123, Role.ATENDEE);
    User user6 = new User("O2", "mail2@hotmail.com", "orga2", 123, Role.ATENDEE);    
    User user7 = new User("Andre", "mailu3", "andr", 133 , Role.ATENDEE);
    User user8 = new User("Luisa", "Luisa@hotmail.com", "mar", 123, Role.EMPLOYEE);   
    User user9 = new User("Joaquim", "mailgdfgdgfdgu3", "jq", 133, Role.ATENDEE);
    User user10 = new User("Margarida", "magdfgfdriamail@hotmail.com", "marg", 123, Role.ATENDEE);
    
    Organiser org1;
    Organiser org2;
    Organiser org3;
    
    Date data1, data2, data3, data4;
    
    OrganiserRegister organiserRegister4 = new OrganiserRegister();
    
    List<Organiser> organiserList4 = new ArrayList<>();
  
    StaffRegister staffRegister4 = new StaffRegister();
    StaffRegister staffRegister = new StaffRegister();
    
    List<StaffMember> staffMemberListEvent4 = new ArrayList<>(); 
    List<StaffMember> staffMemberListEvent = new ArrayList<>(); 
    
    StandRegister standRegister = new StandRegister();
    StandRegister standRegister2 = new StandRegister();
    Stand s1 = new Stand("STAND1", 2.50);
    Stand s2 = new Stand("STAND2", 2.10);
        
    
    Event event4;
    
    EventRegister eventRegister = new EventRegister();
    
    public EventRegister getEventRegister() {
        return eventRegister;
    }
    
    public void setEventRegsiter(EventRegister eventRegsiter) {
        this.eventRegister = eventRegsiter;
    }
    
    //*****************************************************************************************
    //************************Criar registo de utilizadores***********************************

    /**
     *
     */
    public UserRegister createUsers() {
        UserRegister userRegister = new UserRegister();
        
        List<User> usersCentre = new ArrayList<>();
        
        usersCentre.add(user1);
        usersCentre.add(user2);
        usersCentre.add(user3);
        usersCentre.add(user4);
        usersCentre.add(user5);
        usersCentre.add(user6);
    
        usersCentre.add(user7);
        usersCentre.add(user8);
        usersCentre.add(user9);       
        usersCentre.add(user10);
        
        userRegister.setUserList(usersCentre);        
       
        return userRegister;

    }
    
    public LoginControllerTest() throws ParseException{
        
        /*
        Event 4
        */
        
        listKey.add(keyword1);
        listKey.add(keyword2);
        listKey.add(keyword3);
        listKey.add(keyword4);
        app1.setKeywordList(listKey);
        app2.setKeywordList(listKey);
        
        wantToAttend.add(Boolean.TRUE);
        wantToAttend.add(Boolean.TRUE);
        wantToAttend.add(Boolean.FALSE);
        
        listRev.add(rv1);
        listRev.add(rv2);
        listRev.add(rv3);
        
        necessaryEquip.add("Lavatorio");
        necessaryEquip.add("Agua potavél");
        necessaryEquip.add("Quadro");
        
        app1.setBoothArea(5);
        app1.setState(ApplicationState.ACCEPTED);
        app1.setNameOfCompany("nameOfCompany");
        app1.setDescription("description");
        app1.setUserThatSubmited(user);
        app1.setListReview(listRev);
        
        app2.setBoothArea(7);
        app2.setState(ApplicationState.CREATED);
        app2.setNameOfCompany("nameOfCompany 2");
        app2.setDescription("description 2");
        app2.setUserThatSubmited(user);
        app2.setListReview(listRev);
        
        w1.setWantToAttend(wantToAttend);
        w2.setWantToAttend(wantToAttend); 
        
        listWo.add(w2);
        listWo.add(w1);
        app1.setWorkshopList(listWo);
        app2.setWorkshopList(listWo);
        
        listApp.add(app1);
        listApp.add(app2);        
        listApp2.add(app1);
        
        appRegister.setApplicationList(listApp);
        appRegister2.setApplicationList(listApp2);

        org1 = new Organiser();
        org1.setOrganiser(user1);
        org2 = new Organiser();
        org2.setOrganiser(user2);


        organiserList4.add(org2);
        organiserList4.add(org1);

        organiserRegister4.setOrganiserList(organiserList4);

        StaffMember staff41 = new StaffMember();
        StaffMember staff42 = new StaffMember();
        StaffMember staff43 = new StaffMember(user3);

        staff41.setUser(user4);
        staff42.setUser(user5);
        staffMemberListEvent4.add(staff41);
        staffMemberListEvent4.add(staff42);
        staffMemberListEvent.add(staff43);

        staffRegister4.add(staffMemberListEvent4);
        staffRegister.add(staffMemberListEvent);
        
        standRegister.addStand(s1);
        standRegister2.addStand(s2);

        this.event4 = new Event(organiserRegister4);

        this.event4.setTitle("EVENTO 4");
        event4.setEventState(EventState.CREATED);
        event4.addOrganiserRegister(organiserRegister4);
        event4.setStaffRegister(staffRegister4);
        event4.setDaysApplication(4);
        event4.setStartDate(data1);
        event4.setEndDate(data2);        
        event4.setApplicationRegister(appRegister);
        event4.setDateEndApplications(data4);
        event4.setDaysApplication(4);
        event4.setStandRegister(standRegister);
        event4.setDateEndApplications(data2);
        
        eventRegister.addEvent(event4);       
        
        UserRegister userRegister = new UserRegister();
        userRegister = createUsers();
        
        this.exhibitionCentre = new ExhibitionCentre(eventRegister, userRegister);
        this.exhibitionCentre.setUserOnline(user1);
    }

    /**
     * Test of login method, of class LoginController.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String username = "Username";
        String passwordString = "123456";
        LoginController instance = new LoginController(exhibitionCentre);
        boolean expResult = false;
        boolean result = instance.login(username, passwordString);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of login method, of class LoginController.
     */
    @Test
    public void testLogin2() {
        System.out.println("login2");
        String username = "garnel123";
        String passwordString = "123";
        lapr.project.controller.LoginController instance = new lapr.project.controller.LoginController(exhibitionCentre);
        boolean expResult = false;
        boolean result = instance.login(username, passwordString);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerLog method, of class LoginController.
     */
    @Test
    public void testRegisterLog() {
        System.out.println("registerLog");
        String username = "";
        LoginController instance = new LoginController(exhibitionCentre);
        instance.registerLog(username);
    }
    
}

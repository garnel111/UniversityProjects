/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.model.Event;
import lapr.project.model.EventRegister;
import lapr.project.model.EventState;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Organiser;
import lapr.project.model.OrganiserRegister;
import lapr.project.model.Role;
import lapr.project.model.StaffMember;
import lapr.project.model.StaffRegister;
import lapr.project.model.User;
import lapr.project.model.UserRegister;

/**
 *
 * @author Manuel Garnel
 */
public final class DummyData {
    
    private final Organiser org1;
    private final Organiser org2;
    private final Organiser org3;
    private final Event event1;
    private final Event event2;
    private final Event event3;
    private Date data1, data2, data3, data4;
    
    private OrganiserRegister organiserRegister = new OrganiserRegister();
    private OrganiserRegister organiserRegister2 = new OrganiserRegister();
    private OrganiserRegister organiserRegister3 = new OrganiserRegister();
    
    private List<Organiser> organiserList = new ArrayList<>();
    private List<Organiser> organiserList2 = new ArrayList<>();
    private List<Organiser> organiserList3 = new ArrayList<>();
    
    private StaffRegister staffRegister1 = new StaffRegister();
    private List<StaffMember> staffMemberListEvent1 = new ArrayList<>();
    
    ExhibitionCentre exhibitionCentre;
    User user1 = new User("manuel", "mjdg111@hotmail.com", "garnel", 123, Role.ATENDEE);
    User user2 = new User("jose", "mail2@hotmail.com", "jo", 123, Role.ATENDEE);
    User user3 = new User("sandra", "sandra@hotmail.com", "antunex", 123, Role.ATENDEE);
    User user4 = new User("staffElement1_manuel", "mjdg111@hotmail.com", "garnel23", 123, Role.ATENDEE);
    User user5 = new User("staffElment2_jose", "Jose@hotmail.com", "Jose1234", 123, Role.ATENDEE);
    User user6 = new User("O2", "mail2@hotmail.com", "orga2", 123, Role.ATENDEE);
    User user7 = new User("Andre", "mailu3", "andr", 133, Role.ATENDEE);
    User user8 = new User("Luisa", "Luisa@hotmail.com", "mar", 123, Role.EMPLOYEE);
    User user9 = new User("Joaquim", "mailgdfgdgfdgu3", "jq", 133, Role.ATENDEE);
    User user10 = new User("Margarida", "magdfgfdriamail@hotmail.com", "marg", 123, Role.ATENDEE);
    
    //*****************************************************************************************
    //************************Criar registo de utilizadores***********************************
    public void createUsers() {
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
        
        exhibitionCentre.setUserRegister(userRegister);
        
    }
    
    //*********************************************************************************************
    private EventRegister eventRegister = new EventRegister();
    
    public EventRegister getEventRegister() {
        return eventRegister;
    }
    
    public void setEventRegsiter(EventRegister eventRegsiter) {
        this.eventRegister = eventRegsiter;
    }
    
    public DummyData(ExhibitionCentre exhibitionCentre) {
        
        this.exhibitionCentre = exhibitionCentre;
        
        try {
            data1 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse("2018-06-12");
        } catch (ParseException ex) {
            Logger.getLogger(DummyData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            data2 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse("2018-06-17");
        } catch (ParseException ex) {
            Logger.getLogger(DummyData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            data3 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse("2018-06-19");
        } catch (ParseException ex) {
            Logger.getLogger(DummyData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            data4 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse("2018-06-22");
        } catch (ParseException ex) {
            Logger.getLogger(DummyData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        createUsers();
        /*
        Event 1
        
        */
        
        org1 = new Organiser();
        org1.setOrganiser(user1);
        org2 = new Organiser();
        org2.setOrganiser(user2);
        org3 = new Organiser();
        org3.setOrganiser(user3);
        
        organiserList.add(org2);
        organiserList.add(org1);
        organiserList.add(org3);
        organiserRegister.setOrganiserList(organiserList);
        
        StaffMember staff11 = new StaffMember();
        StaffMember staff12 = new StaffMember();
        
        staff11.setUser(user4);
        staff12.setUser(user5);
        staffMemberListEvent1.add(staff11);
        staffMemberListEvent1.add(staff12);
        
        staffRegister1.add(staffMemberListEvent1);
        
        this.event1 = new Event(organiserRegister);
        
        this.event1.setTitle("EVENTO UM");
        event1.setEventState(EventState.READY_FOR_APPLICATION);
        event1.addOrganiserRegister(organiserRegister);
        event1.setStaffRegister(staffRegister1);
        event1.setDaysApplication(4);
        event1.setStartDate(data1);
        event1.setEndDate(data2);
        eventRegister.addEvent(event1);
        
        /*
        Event 2
        */
        Organiser org22 = new Organiser();
        org22.setOrganiser(user7);
        Organiser org222 = new Organiser();
        org222.setOrganiser(user8);
        organiserList2.add(org22);
        organiserList2.add(org222);
        organiserRegister2.setOrganiserList(organiserList2);
        this.event2 = new Event(organiserRegister2);
        event2.setTitle("Evento 2");
        event2.setEventState(EventState.READY_FOR_APPLICATION);
        event2.addOrganiserRegister(organiserRegister2);
        event2.setDaysApplication(5);
        event2.setStartDate(data3);
        event2.setEndDate(data4);
        eventRegister.addEvent(event2);
        
        /*
        Event 3
        */
        Organiser org31 = new Organiser();
        org31.setOrganiser(user9);
        Organiser org32 = new Organiser();
        org32.setOrganiser(user10);
        organiserList3.add(org31);
        organiserList3.add(org32);
        
        organiserRegister3.setOrganiserList(organiserList3);
        this.event3 = new Event(organiserRegister3);
        event3.setTitle("Evento 3");
        event3.setEventState(EventState.READY_FOR_APPLICATION);
        event3.addOrganiserRegister(organiserRegister3);
        
        eventRegister.addEvent(event1);
        eventRegister.addEvent(event2);
        eventRegister.addEvent(event3);
        exhibitionCentre.setEventRegister(eventRegister);
        
        exhibitionCentre.setUserOnline(user1);
        
    }
    
    public Date getDate1() {
        return this.data1;
    }
    
    public Date getDate2() {
        return this.data2;
    }
    
    public OrganiserRegister getOrganiserRegister() {
        return organiserRegister;
    }
    
    public void setOrganiserRegister(OrganiserRegister organiserRegister) {
        this.organiserRegister = organiserRegister;
    }
    
}

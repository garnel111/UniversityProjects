/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import lapr.project.controller.DummyData;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

/**
 *
 * @author andre
 */
public class StaffRegisterTest {
    
    private DummyData data;
    
    private ExhibitionCentre centre = new ExhibitionCentre();
    
    private ExhibitionCentre exhibitionCentre;
    
    private User user1 = new User("manuel", "mjdg111@hotmail.com", "garnel", 123, Role.ATENDEE);
    private User user2 = new User("jose", "mail2@hotmail.com", "jo", 123, Role.ATENDEE);
    private User user3 = new User("sandra", "sandra@hotmail.com", "antunex", 123, Role.ATENDEE);
    private User user4 = new User("staffElement1_manuel", "mjdg111@hotmail.com", "garnel23", 123, Role.ATENDEE);
    private User user5 = new User("staffElment2_jose", "Jose@hotmail.com", "Jose1234", 123, Role.ATENDEE);
    private User user6 = new User("O2", "mail2@hotmail.com", "orga2", 123, Role.ATENDEE);
    private User user7 = new User("Andre", "mailu3", "andr", 133, Role.ATENDEE);
    private User user8 = new User("Luisa", "Luisa@hotmail.com", "mar", 123, Role.EMPLOYEE);
    private User user9 = new User("Joaquim", "mailgdfgdgfdgu3", "jq", 133, Role.ATENDEE);
    private User user10 = new User("Margarida", "magdfgfdriamail@hotmail.com", "marg", 123, Role.ATENDEE);
    
    Organiser org1;
    Organiser org2;
    Organiser org3;
    
    Date data1, data2, data3, data4;
    
    OrganiserRegister organiserRegister4 = new OrganiserRegister();
    
    List<Organiser> organiserList4 = new ArrayList<>();
    
    StaffRegister staffRegister4 = new StaffRegister();
    
    List<StaffMember> staffMemberListEvent4 = new ArrayList<>();
    
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
    
    public StaffRegisterTest() {
        data = new DummyData(centre);
        
        /*
        Event 4
        
        */
        org1 = new Organiser();
        org1.setOrganiser(user1);
        org2 = new Organiser();
        org2.setOrganiser(user2);
        
        organiserList4.add(org2);
        organiserList4.add(org1);
        
        organiserRegister4.setOrganiserList(organiserList4);
        
        StaffMember staff41 = new StaffMember();
        StaffMember staff42 = new StaffMember();
        
        staff41.setUser(user4);
        staff42.setUser(user5);
        staffMemberListEvent4.add(staff41);
        staffMemberListEvent4.add(staff42);
        
        staffRegister4.add(staffMemberListEvent4);
        
        this.event4 = new Event(organiserRegister4);
        
        this.event4.setTitle("EVENTO 4");
        event4.setEventState(EventState.CREATED);
        event4.addOrganiserRegister(organiserRegister4);
        event4.setStaffRegister(staffRegister4);
        event4.setDaysApplication(4);
        event4.setStartDate(data1);
        event4.setEndDate(data2);
        eventRegister.addEvent(event4);
        
        UserRegister userRegister = new UserRegister();
        userRegister = createUsers();
        
        this.exhibitionCentre = new ExhibitionCentre(eventRegister, userRegister);
    }
    
    /**
     * Test of addStaffMember method, of class StaffRegister.
     */
    @Test
    public void testAddStaffMember() {
        System.out.println("addStaffMember");
        StaffMember sm = new StaffMember(user3);
        StaffRegister instance = new StaffRegister(staffMemberListEvent4);
        boolean expResult = true;
        boolean result = instance.addStaffMember(sm);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of addStaffMember method, of class StaffRegister.
     */
    @Test
    public void testStaffRegister() {
        System.out.println("StaffRegister");
        StaffMember sm = new StaffMember(user3);
        StaffRegister instance = new StaffRegister(staffMemberListEvent4);
        boolean expResult = true;
        boolean result = instance.addStaffMember(sm);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of addStaffMember method, of class StaffRegister.
     */
    @Test
    public void testAddStaffMember2() {
        System.out.println("addStaffMember2");
        StaffMember sm = new StaffMember(user4);
        StaffRegister instance = new StaffRegister(staffMemberListEvent4);
        boolean expResult = false;
        boolean result = instance.addStaffMember(sm);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of isExist method, of class StaffRegister.
     */
    @Test
    public void testIsExist() {
        System.out.println("isExist");
        User user = user1;
        boolean expResult = false;
        boolean result = staffRegister4.isExist(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of isExist method, of class StaffRegister.
     */
    @Test
    public void testIsExist2() {
        System.out.println("isExist2");
        User user = user4;
        boolean expResult = true;
        boolean result = staffRegister4.isExist(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of getStaffMemberByUsername method, of class StaffRegister.
     */
    @Test
    public void testGetStaffMemberByUsername() {
        System.out.println("getStaffMemberByUsername");
        String username = "garnel23";
        StaffRegister instance = new StaffRegister(staffMemberListEvent4);
        StaffMember expResult = new StaffMember(user4);
        StaffMember result = instance.getStaffMemberByUsername(username);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getStaffMemberByUsername method, of class StaffRegister.
     */
    @Test
    public void testGetStaffMemberByUsername2() {
        System.out.println("getStaffMemberByUsername2");
        String username = "dx4534";
        StaffRegister instance = new StaffRegister(staffMemberListEvent4);
        StaffMember expResult = null;
        StaffMember result = instance.getStaffMemberByUsername(username);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isEmpty method, of class StaffRegister.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        StaffRegister instance = new StaffRegister();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of isEmpty method, of class StaffRegister.
     */
    @Test
    public void testIsEmpty2() {
        System.out.println("isEmpty2");
        StaffRegister instance = new StaffRegister(staffMemberListEvent4);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of sizeStaffList method, of class StaffRegister.
     */
    @Test
    public void testSizeStaffList() {
        System.out.println("sizeStaffList");
        StaffRegister instance = new StaffRegister();
        int expResult = 0;
        int result = instance.sizeStaffList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of sizeStaffList method, of class StaffRegister.
     */
    @Test
    public void testSizeStaffList2() {
        System.out.println("sizeStaffList2");
        StaffRegister instance = new StaffRegister(staffMemberListEvent4);
        int expResult = 2;
        int result = instance.sizeStaffList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of equals method, of class StaffRegister.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object otherObject = null;
        StaffRegister instance = new StaffRegister(staffMemberListEvent4);
        boolean expResult = false;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of equals method, of class StaffRegister.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals2");
        Object otherObject = staffMemberListEvent4;
        StaffRegister instance = new StaffRegister(staffMemberListEvent4);
        boolean expResult = false;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of equals method, of class StaffRegister.
     */
    @Test
    public void testEquals3() {
        System.out.println("equals3");
        Object otherObject = data.getEventRegister().getEvent(0);
        StaffRegister instance = new StaffRegister(staffMemberListEvent4);
        boolean expResult = false;
        boolean result = instance.equals(otherObject);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     * Test of add method, of class StaffRegister.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        List<StaffMember> staffMemberListEvent1 = null;
        StaffRegister instance = new StaffRegister();
        instance.add(staffMemberListEvent1);
    }
    
    /**
     * Test of getStaffList method, of class StaffRegister.
     */
    @Test
    public void testGetStaffList() {
        System.out.println("getStaffList");
        StaffRegister instance = new StaffRegister();
        List<StaffMember> expResult = new ArrayList<>();
        List<StaffMember> result = instance.getStaffList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStaffList method, of class StaffRegister.
     */
    @Test
    public void testSetStaffList() {
        System.out.println("setStaffList");
        StaffRegister instance = new StaffRegister();
        instance.setStaffList(staffMemberListEvent4);
    }
    
    /**
     * Test of toString method, of class StaffRegister.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        StaffRegister instance = new StaffRegister(staffMemberListEvent4);
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of hashCode method, of class StaffRegister.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        StaffRegister instance = new StaffRegister(staffMemberListEvent4);
        int expResult = instance.hashCode();
        
        System.out.println("hash" + instance.hashCode());
        
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of createStaffMember method, of class StaffRegister.
     */
    @Test
    public void testCreateStaffMember() {
        System.out.println("createStaffMember");
        User user = new User("Name name", "email@server.com", "user", 0.1234);
        StaffMember expResult = new StaffMember(user);
        List<StaffMember> staffList = new ArrayList<>();
        staffList.add(expResult);
        StaffRegister instance = new StaffRegister();
        System.out.println("s" + instance.getStaffList());
        
        instance.createStaffMember();
        assertNotNull(instance.createStaffMember());
    }
    
    @Test
    public void testHashCodeTwo() {
        System.out.println("hashCode");
        StaffRegister instance = new StaffRegister(staffMemberListEvent4);
        int expResult = instance.hashCode();
        System.out.println("hash" + instance.hashCode());
        int result = instance.hashCode();
        assertEquals(expResult, result);
        int hash = 0;
        hash = 37 * hash + instance.hashCode();
        System.out.println("hasss" + hash);
        assertEquals(hash, instance.hashCode());
        
    }
    
    @Test
    public void testHashCodeThree() {
        System.out.println("hashCode");
        StaffRegister instance = new StaffRegister(staffMemberListEvent4);
        System.out.println("hash" + instance.hashCode());
        int result = instance.hashCode();
        
        int expectResult = 5;
        expectResult = 37 * expectResult + Objects.hashCode(staffMemberListEvent4);
        
        assertEquals(expectResult, result);
    }
    
}

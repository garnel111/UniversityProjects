/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.utils.Utils;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

/**
 *
 * @author JM
 */
public class UserRegisterTest {

    /**
     * Test of getUserList method, of class UserRegister.
     */
    @Test
    public void testGetUserList() {
        System.out.println("getUserList");
        List<User> lista = new ArrayList<User>();
        User user1 = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        lista.add(user1);
        UserRegister instance = new UserRegister(lista);
        instance.addUser(user1);
        List<User> expResult = new ArrayList<>();
        expResult.add(user1);
        List<User> result = instance.getUserList();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUserList method, of class UserRegister.
     */
    @Test
    public void testSetUserList() {
        System.out.println("setUserList");
        List<User> userList = new ArrayList<>();
        User user1 = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        userList.add(user1);
        UserRegister instance = new UserRegister();
        instance.setUserList(userList);
        assertEquals(userList, instance.getUserList());
    }

    /**
     * Test of addUser method, of class UserRegister.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        User user1 = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        UserRegister instance = new UserRegister();
        instance.addUser(user1);
        assertEquals(user1, instance.getUserList().get(0));
    }
    
    /**
     * Test of addUser method, of class UserRegister.
     */
    @Test
    public void testAddUserNot() {
        System.out.println("addUser");
        User user1 = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        User user2 = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        UserRegister instance = new UserRegister();
        assertEquals(true,instance.addUser(user1));
        assertEquals(false, instance.addUser(user2));
    }

    /**
     * Test of userExists method, of class UserRegister.
     */
    @Test
    public void testUserExists() {
        System.out.println("userExists");
        User user1 = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        User user3 = new User("Nome Nome", "email@server.com", "userdiferente", 0.1234);
        User user2 = new User("Nomes Nomes", "emails@server.com", "user2", 0.4321);
        UserRegister instance = new UserRegister();
        instance.addUser(user1);
        boolean expResult = true;
        boolean result = instance.userExists(user1);
        assertEquals(expResult, result);
        assertEquals(expResult, instance.userExists(user3));
        assertEquals(false, instance.userExists(user2));
    }
    
    /**
     * Test of getAvailableUsersWithoutOrganisers method, of class UserRegister.
     */
       @Test
    public void testgetAvailablesUsersWithoutOrganisersTest() {
        System.out.println("getAvailablesUsersWithoutOrganisers");
        User user1 = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        User user2 = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        User user3 = new User("Nomes Nomes", "emails@servesr.com", "user3", 0.4321);
        UserRegister instance = new UserRegister();
        OrganiserRegister orgReg= new OrganiserRegister();
        Organiser org = new Organiser(user2);
        orgReg.addOrganiser(org);
        instance.addUser(user1);
        instance.addUser(user3);
        List<User> filtered = instance.getAvailableUsersWithoutOrganisers(orgReg.getOrganiserList());
        for(User u : filtered){
            assertFalse(u.equals(user2));
        }
    }
    

    /**
     * Test of getAvailableUsersWithoutStaffMember method, of class UserRegister.
     */
    @Test
    public void testGetAvailableUsersWithoutStaffMember() {
        System.out.println("getAvailableUsersWithoutStaffMember");
        User user1 = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        user1.setRole(Role.EMPLOYEE);
        User user2 = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        user2.setRole(Role.EMPLOYEE);
        User user3 = new User("Nomes Nomes", "emails@servesr.com", "user3", 0.4321);
        user3.setRole(Role.EMPLOYEE);
        User user4 = new User("Nomes Nomesss", "emailsss@servesr.com", "user4", 0.43321);
        user4.setRole(Role.ATENDEE);
        UserRegister instance = new UserRegister();
        StaffRegister staffReg= new StaffRegister();
        StaffMember staff = new StaffMember(user2);
        staffReg.addStaffMember(staff);
        instance.addUser(user1);
        instance.addUser(user3);
        instance.addUser(user4);
        List<User> copia = Utils.getCopia(instance.getUserList());
        List<User> filtered = instance.getAvailableUsersWithoutStaffMember(staffReg.getStaffList(),copia);
        for(User u : filtered){
            assertFalse(u.equals(user2));
            assertFalse(u.equals(user4));
        }
    }
}

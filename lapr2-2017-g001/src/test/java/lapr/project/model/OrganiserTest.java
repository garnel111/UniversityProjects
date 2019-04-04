/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Manuel Garnel
 */
public class OrganiserTest {
    
    /**
     * Test of getName method, of class Organiser.
     */
    @Test
    public void GetNameTest() {
        System.out.println("getName");
        User instance = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        String expResult = "Nome Nome";
        String result = instance.getName();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equalsUser method, of class Organiser.
     */
    @Test
    public void equalsTest() {
        System.out.println("toString");
        
        //Arrange
        User user = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        User otherUser = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        
        Organiser organiser = new Organiser(user);
        boolean expectedResult = true;
        
        Object obj = new Organiser(otherUser);
        
        //Act
        boolean result = organiser.equals(obj);
        
        //Assert
        assertEquals(result, expectedResult);
        
    }
    
    @Test
    public void notEqualsTest() {
        System.out.println("toString");
        
        //Arrange
        User user = new User("Name name", "email@server.com", "user1", 0.1234);
        User otherUser = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        
        Organiser organiser = new Organiser(user);
        boolean expectedResult = true;
        
        Object obj = new Organiser(otherUser);
        
        //Act
        boolean result = organiser.equals(obj);
        
        //Assert
        assertNotEquals(result, expectedResult);
        
    }
    
    /**
     * Test of hashCode method, of class Organiser.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Organiser organiserHashCode = new Organiser();
        int result = organiserHashCode.hashCode();
        int hash = -1779632894;
        int expectedResult = organiserHashCode.hashCode();
        assertEquals(hash, result);
        assertEquals(expectedResult, result);
        
    }
    
    @Test
    public void compareToTest() {
        User user1 = new User("Filipa", "filipa@server.com", "user1", 0.1234);
        Organiser organiser1 = new Organiser(user1);
        
        User user2 = new User("Filipa", "filipa@server.com", "user1", 0.1234);
        Organiser organiser2 = new Organiser(user2);
        int result = organiser1.compareTo(organiser2);
        System.out.println("result" + result);
        assertEquals(0, result);
    }
    
    @Test
    public void notEqualsObjectsDiferentsClassesTest() {
        
        //Arrange
        User user = new User("Name name", "email@server.com", "user1", 0.1234);
        User otherUser = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        
        Organiser organiser = new Organiser(user);
        Organiser otherOrganiser = new Organiser(otherUser);
        StaffMember staffmemb = new StaffMember();
        boolean expectedResult = true;
        
        Object obj = new StaffMember();
        
        //Act
        boolean result = organiser.equals(obj);
        
        //Assert
        assertNotEquals(result, expectedResult);
        
    }
    
    @Test
    public void testToString2() {
        System.out.println("toString");
        
        User user = new User("Name name", "email@server.com", "user1", 0.1234);
        Organiser organiser = new Organiser(user);
        
        String expResult = organiser.toString();
        String result = "UserName:user1 Nome:Name name";
        
        assertEquals(expResult, result);
    }
    
}

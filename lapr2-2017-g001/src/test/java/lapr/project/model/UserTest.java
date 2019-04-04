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
 * @author JM
 */
public class UserTest {

    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        User instance = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        String expResult = "Nome Nome";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class User.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        User instance2 = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        String name = "José Magalhães";
        User instance = new User(instance2);
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        User instance = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        String expResult = "email@server.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class User.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "email@server.com";
        User instance = new User();
        instance.setEmail(email);
        assertEquals(email, instance.getEmail());
    }

    /**
     * Test of getUsername method, of class User.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        User instance = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        String expResult = "user1";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsername method, of class User.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "user1";
        User instance = new User();
        instance.setUsername(username);
        assertEquals(username, instance.getUsername());
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        User instance = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        double expResult = 0.1234;
        double result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        double password = 0.1234;
        User instance = new User();
        instance.setPassword(password);
        assertEquals(password, instance.getPassword());
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        User instance = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        String expResult = "User:{name=Nome Nome, email=email@server.com, username=user1, password=0.1234}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equalsUser method, of class User.
     */
    @Test
    public void testEqualsUser() {
        System.out.println("equalsUser");
        User userNull = null;
        User user1 = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        User user1a = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        User user2 = new User("Nomes", "emails@server.com", "user2", 0.4321);
        boolean expResult = true;
        boolean result = user1.equals(user1a);
        boolean result2 = user1.equals(user2);
        assertEquals(false, user1.equals(userNull));
        assertEquals(expResult, result);
        assertNotEquals(expResult, result2);
    }

    /**
     * Test of hashCode method, of class User.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        User instance = new User();
        int expResult = -1779633265;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of hashCode method, of class User.
     */
    @Test
    public void testHashCode2() {
        System.out.println("hashCode");
        User instance = new User("José","j@gmail.com","jose",0.1234);
        double password=instance.getPassword();
        instance.setRole(Role.EMPLOYEE);
        int hash=5;
        hash = 83 * hash + instance.getName().hashCode();
        hash = 83 * hash + instance.getEmail().hashCode();
        hash = 83 * hash + instance.getUsername().hashCode();
        hash = 83 * hash + (int) (Double.doubleToLongBits(password) ^ (Double.doubleToLongBits(password) >>> 32));
        hash = 83 * hash + instance.getRole().hashCode();
        
        assertEquals(hash, instance.hashCode());
        
    }
}

package lapr.project.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author marco
 */
public class UserTest {
    
    public UserTest() {
    }

    /**
     * Test of getUsername method, of class User.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        User instance = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 0, 50);
        String expResult = "Matilde";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        User instance = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 0, 50);
        String expResult = "matilde@hotmail.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        User instance = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 0, 50);
        String expResult = "qwerty";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCardNumber method, of class User.
     */
    @Test
    public void testGetCardNumber() {
        System.out.println("getCardNumber");
        User instance = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 0, 50);
        String expResult = "4544000019821545";
        String result = instance.getCardNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHeight method, of class User.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        User instance = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 0, 50);
        double expResult = 1.65;
        double result = instance.getHeight();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWeight method, of class User.
     */
    @Test
    public void testGetWeight() {
        System.out.println("getWeight");
        User instance = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 0, 50);
        double expResult = 55;
        double result = instance.getWeight();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPoints method, of class User.
     */
    @Test
    public void testGetPoints() {
        System.out.println("getPoints");
        User instance = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 0, 50);
        long expResult = 0;
        long result = instance.getPoints();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInitialCost method, of class User.
     */
    @Test
    public void testGetInitialCost() {
        System.out.println("getInitialCost");
        User instance = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 0, 50);
        double expResult = 50;
        double result = instance.getInitialCost();
        assertEquals(expResult, result, 0.5);
    }

    /**
     * Test of EncryptBase64Encoder method, of class User.
     */
    @Test
    public void testEncryptBase64Encoder() {
        System.out.println("EncryptBase64Encoder");
        String password = "qwerty";
        String expResult = "cXdlcnR5";
        String result = User.encryptBase64Encoder(password);
        assertEquals(expResult, result);
    }

    /**
     * Test of DecryptBase64Decoder method, of class User.
     */
    @Test
    public void testDecryptBase64Decoder() {
        System.out.println("DecryptBase64Decoder");
        String password = "cXdlcnR5";
        String expResult = "qwerty";
        String result = User.decryptBase64Decoder(password);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class User.
     */
    @Test
    public void testHashCode() {
        System.out.println("Test hash code");
        User instance = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 1, 50);
        int expResult = -541767163;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEqualsDifferentWeight() {
        System.out.println("Test Different Weight");
        User instance = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 1, 50);
        
        User user = new User();
        user.setUsername("Matilde");
        user.setEmail("matilde@hotmail.com");
        user.setPassword("qwerty");
        user.setCardNumber("4544000019821545");
        user.setHeight(1.65);
        user.setWeight(56);
        user.setPoints(1);
        user.setInitialCost(50);
        assertTrue(!user.equals(instance));
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEqualsDifferentIdUser() {
        System.out.println("Test Different idUser");
        User instance = new User();
        instance.setIdUser(0);
        long expResult = 1;
        long result = instance.getIdUser();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEqualsDifferentUsername() {
        System.out.println("Test Different Username");
        User instance = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 1, 50);
        User user = new User("Marta", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 1, 50);
        assertTrue(!user.equals(instance));
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testSameUser() {
        System.out.println("Test Same Username");
        User instance = new User("matilde@hotmail.com", "qwerty");
        User user = new User("matilde@hotmail.com", "qwerty");
        assertTrue(user.equals(instance));
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEqualsDifferentEmail() {
        System.out.println("Test Different Email");
        User instance = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 1, 50);
        User user = new User("Matilde", "marta@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 1, 50);
        assertTrue(!user.equals(instance));
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEqualsDifferentPoints() {
        System.out.println("Test Different Points");
        User instance = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 1, 50);
        User user = new User("Marta", "matilde2@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 0, 50);
        assertTrue(!user.equals(instance));
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEqualsDifferentInitialCost() {
        System.out.println("Test Different InitialCost");
        User instance = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 1, 50);
        User user = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 1, 51);
        assertTrue(!user.equals(instance));
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEqualsDifferentCardNumber() {
        System.out.println("Test Different Card Number");
        User instance = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 0, 50);
        User user = new User("Matilde", "matilde@hotmail.com", "qwerty", "4744000019821545", 1.65, 55, 0, 50);
        assertTrue(!user.equals(instance));
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEqualsDifferentPassword() {
        System.out.println("Test Different Password");
        User instance = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 0, 50);
        User user = new User("Matilde", "matilde@hotmail.com", "qwerty2", "4544000019821545", 1.65, 55, 0, 50);
        assertTrue(!user.equals(instance));
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEquals() {
        System.out.println("Test Equals");
        User instance = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 1, 50);
        User user = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 1, 50);
        assertTrue(user.equals(instance));
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEqualsDifferenteIdUser() {
        System.out.println("Test equals - false diferente idUser ");
        User user = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 0, 50);
        user.setIdUser(0);
        User user1 = new User("username1", "anotheremail@mail.com", "qwerty2", "4704000022219545", 1.74, 75, 0, 50);
        user.setIdUser(1);
        boolean expResult = false;
        boolean result = user.equals(user1);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEqualsTrue() {
        System.out.println("Test equals - true ");
        User user = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 0, 50);
        User instance = user;
        boolean expResult = true;
        boolean result = instance.equals(user);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEqualDifferentObj() {
        System.out.println("Test equals - false ");
        User user = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 0, 50);
        User instance = new User("username1", "anotheremail@mail.com", "qwerty2", "4704000022219545", 1.74, 75, 0, 50);
        boolean expResult = false;
        boolean result = instance.equals(user);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEqualsNull() {
        System.out.println("Test equals - null ");
        User instance = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 0, 50);
        User user = null;
        boolean expResult = false;
        boolean result = instance.equals(user);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEqualsDifferentClass() {
        System.out.println("Test equals - null ");
        User instance = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 0, 50);
        String password = "qwerty";
        boolean expResult = false;
        boolean result = instance.equals(password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetId() {
        System.out.println("Test Get Id");
        User instance = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 1, 50);
        long result = instance.getIdUser();
        int expResult = 0;
        
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class User.
     */
    @Test
    public void testHashCodeTwo() {
        System.out.println("Test hash code Two");
        User instance = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 1, 50);
        instance.setIdUser(999999999);
        int expResult = -791834044;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testHashCodeThree() {
        System.out.println("Test hash code Three");
        User instance = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 1, 50);
        instance.setIdUser(-999999999);
        int expResult = 1332318339;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testHashCodeFour() {
        System.out.println("Test hash code Four");
        User instance = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 1, 50);
        instance.setPoints(-999999999);
        
        int expResult = -1736080646;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testHashCodeFive() {
        System.out.println("Test hash code Five");
        User instance = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 1, 50);
        instance.setPoints(999999999);
        
        int expResult = -1736080557;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCostEquals() {
        System.out.println("Test Cost not equals");
        User instance = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 1, 60);
        double result = instance.getInitialCost();
        double expResult = 60.0000;
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCostNotEquals() {
        System.out.println("Test Cost not equals");
        User instance = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 1, 60);
        double result = instance.getInitialCost();
        double expResult = 50.0000;
        assertNotEquals(expResult, result);
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        long idUser = 0;
        String username = "Matilde";
        String email = "matilde@hotmail.com";
        String password = "qwerty";
        String cardNumber = "4544000019821545";
        double height = 1.65;
        double weight = 55;
        long points = 0;
        double initialCost = 50;
        User instance = new User(username, email, password, cardNumber, height, weight, points, initialCost);
        String expResult = "User{" + "idUser=" + idUser + ", username=" + username + ", email=" + email + ", password=" + password + ", cardNumber=" + cardNumber + ", height=" + height + ", weight=" + weight + ", points=" + points + ", initialCost=" + initialCost + '}';;
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}

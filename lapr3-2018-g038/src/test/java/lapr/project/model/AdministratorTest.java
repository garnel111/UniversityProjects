package lapr.project.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author marco
 */
public class AdministratorTest {
    
    public AdministratorTest() {
    }

    /**
     * Test of getIdAdministrator method, of class Administrator.
     */
    @Test
    public void testGetIdAdministrator() {
        System.out.println("getIdAdministrator");
        Administrator instance = new Administrator("amandio@hotmail.com", "qwerty");
        long expResult = 0;
        long result = instance.getIdAdministrator();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Administrator.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Administrator instance = new Administrator("Amândio", "amandio@hotmail.com", "qwerty");
        String expResult = "Amândio";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class Administrator.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Administrator instance = new Administrator("amandio@hotmail.com", "qwerty");
        String expResult = "amandio@hotmail.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class Administrator.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Administrator instance = new Administrator("amandio@hotmail.com", "qwerty");
        String expResult = "qwerty";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdAdministrator method, of class Administrator.
     */
    @Test
    public void testSetIdAdministrator() {
        System.out.println("setIdAdministrator");
        long idAdministrator = 1;
        Administrator instance = new Administrator();
        instance.setIdAdministrator(idAdministrator);
        
    }

    /**
     * Test of setName method, of class Administrator.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Amândio";
        Administrator instance = new Administrator();
        instance.setName(name);
        
    }

    /**
     * Test of setEmail method, of class Administrator.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "amandio@hotmail.com";
        Administrator instance = new Administrator();
        instance.setEmail(email);
    }

    /**
     * Test of setPassword method, of class Administrator.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "qwerty";
        Administrator instance = new Administrator();
        instance.setPassword(password);
    }

    /**
     * Test of hashCode method, of class Administrator.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Administrator instance = new Administrator();
        int expResult = 100755605;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of hashCode method, of class Administrator.
     */
    @Test
    public void testHashCodeTwo() {
        System.out.println("Test hashCode Two");
        Administrator instance = new Administrator("Carlos", "carlos@hotmail.com", "qwerty");
        instance.setIdAdministrator(999999999);
        int expResult = 1251980295;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Administrator.
     */
    @Test
    public void testHashCodeThree() {
        System.out.println("Test hashCode Three");
        Administrator instance = new Administrator("Carlos", "carlos@hotmail.com", "qwerty");
        instance.setIdAdministrator(-999999999);
        int expResult = 1251679532;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEquals() {
        System.out.println("Test Equals");
        Administrator instance = new Administrator("Carlos", "carlos@hotmail.com", "qwerty");
        Administrator admin = new Administrator("Carlos", "carlos@hotmail.com", "qwerty");
        assertTrue(admin.equals(instance));
    }

    /**
     * Test of equals method, of class Administrator.
     */
    @Test
    public void testEqualsTrue() {
        System.out.println("Test equals - true ");
        Administrator admin = new Administrator("Carlos", "carlos@hotmail.com", "qwerty");
        Administrator instance = admin;
        boolean expResult = true;
        boolean result = instance.equals(admin);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Administrator.
     */
    @Test
    public void testEqualDifferentObj() {
        System.out.println("Test equals - false ");
        Administrator admin = new Administrator("Carlos", "carlos@hotmail.com", "qwerty");
        Administrator instance = new Administrator("Pedro", "pedro@hotmail.com", "qwerty2");
        boolean expResult = false;
        boolean result = instance.equals(admin);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Administrator.
     */
    @Test
    public void testEqualsNull() {
        System.out.println("Test equals - null ");
        Administrator instance = new Administrator("Carlos", "carlos@hotmail.com", "qwerty");
        Administrator admin = null;
        boolean expResult = false;
        boolean result = instance.equals(admin);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Administrator.
     */
    @Test
    public void testEqualsDifferentClass() {
        System.out.println("Test equals - null ");
        Administrator admin = new Administrator("Carlos", "carlos@hotmail.com", "qwerty");
        String password = "qwerty";
        boolean expResult = false;
        boolean result = admin.equals(password);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Administrator.
     */
    @Test
    public void testEqualsDifferenteIdAdministrator() {
        System.out.println("Test equals - false diferente idAdministrator ");
        Administrator instance = new Administrator("Carlos", "carlos@hotmail.com", "qwerty");
        instance.setIdAdministrator(0);
        Administrator admin = new Administrator("Pedro", "pedro@hotmail.com", "qwerty2");
        admin.setIdAdministrator(1);
        boolean expResult = false;
        boolean result = instance.equals(admin);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Administrator.
     */
    @Test
    public void testEqualsDifferentName() {
        System.out.println("Test Different  Name");
        Administrator admin = new Administrator("Carlos", "carlos@hotmail.com", "qwerty");
        Administrator instance = new Administrator("Pedro", "carlos@hotmail.com", "qwerty");
        assertTrue(!admin.equals(instance));
    }

    /**
     * Test of equals method, of class Administrator.
     */
    @Test
    public void testEqualsDifferentEmail() {
        System.out.println("Test Different  Email");
        Administrator admin = new Administrator("Carlos", "carlos@hotmail.com", "qwerty");
        Administrator instance = new Administrator("Carlos", "pedro@hotmail.com", "qwerty");
        assertTrue(!admin.equals(instance));
    }

    /**
     * Test of equals method, of class Administrator.
     */
    @Test
    public void testEqualsDifferentPassword() {
        System.out.println("Test Different Password");
        Administrator admin = new Administrator("Carlos", "carlos@hotmail.com", "qwerty");
        Administrator instance = new Administrator("Carlos", "carlos@hotmail.com", "qwerty2");
        assertTrue(!admin.equals(instance));
    }
    
}

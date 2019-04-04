/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author andre
 */
public class StaffMemberTest {
    
    public StaffMemberTest() {
    }

    /**
     * Test of getStaff method, of class StaffMember.
     */
    @Test
    public void testGetStaff() {
        System.out.println("getStaff");
        User user1 = new User("manuel", "mjdg111@hotmail.com", "garnel", 123, Role.ATENDEE);
        StaffMember instance = new StaffMember(user1);
        User expResult = new User("manuel", "mjdg111@hotmail.com", "garnel", 123, Role.ATENDEE);
        User result = instance.getStaff();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUser method, of class StaffMember.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        User staff = new User("manuel", "mjdg111@hotmail.com", "garnel", 123, Role.ATENDEE);
        StaffMember instance = new StaffMember();
        instance.setUser(staff);
        User expResult = new User("manuel", "mjdg111@hotmail.com", "garnel", 123, Role.ATENDEE);
        User result = instance.getStaff();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class StaffMember.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        User staff = new User("manuel", "mjdg111@hotmail.com", "garnel", 123, Role.ATENDEE);
        StaffMember instance = new StaffMember(staff);
        User staff2 = new User("manuel", "mjdg111@hotmail.com", "garnel", 123, Role.ATENDEE);
        StaffMember instance2 = new StaffMember(staff2);
        String expResult = instance2.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class StaffMember.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        StaffMember instance = new StaffMember();
        int expResult = -1779632642;
        int result = instance.hashCode();
       
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class StaffMember.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        User staff = new User("manuel", "mjdg111@hotmail.com", "garnel", 123, Role.ATENDEE);
        User staff2 = new User("manuel", "mjdg111@hotmail.com", "garnel", 123, Role.ATENDEE);
        StaffMember instance = new StaffMember(staff);
        StaffMember otherStaff = new StaffMember(staff2); 
        int expResult = 0;
        int result = instance.compareTo(otherStaff);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of compareTo method, of class StaffMember.
     */
    @Test
    public void testCompareTo2() {
        System.out.println("compareTo2");
        User staff = new User("manuel", "mjdg111@hotmail.com", "garnel", 123, Role.ATENDEE);
        User staff2 = new User("jose", "mail2@hotmail.com", "jo", 123 , Role.ATENDEE);
        StaffMember instance = new StaffMember(staff);
        StaffMember otherStaff = new StaffMember(staff2); 
        int expResult = -3;
        int result = instance.compareTo(otherStaff);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of compareTo method, of class StaffMember.
     */
    @Test
    public void testCompareTo3() {
        System.out.println("compareTo3");
        User staff2 = new User("manuel", "mjdg111@hotmail.com", "garnel", 123, Role.ATENDEE);
        User staff = new User("jose", "mail2@hotmail.com", "jo", 123 , Role.ATENDEE);
        StaffMember instance = new StaffMember(staff);
        StaffMember otherStaff = new StaffMember(staff2); 
        int expResult = 3;
        int result = instance.compareTo(otherStaff);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class StaffMember.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        User staff = new User("manuel", "mjdg111@hotmail.com", "garnel", 123, Role.ATENDEE);
        User staff2 = new User("manuel", "mjdg111@hotmail.com", "garnel", 123, Role.ATENDEE);
        StaffMember instance = new StaffMember(staff);
        StaffMember instance2 = new StaffMember(staff2);                
        Object obj = instance2;
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class StaffMember.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals2");
        User staff = new User("manuel", "mjdg111@hotmail.com", "garnel", 123, Role.ATENDEE);
        User staff2 = new User("manuel", "mjdg1211@hotmail.com", "garnel", 123, Role.ATENDEE);
        StaffMember instance = new StaffMember(staff);
        StaffMember instance2 = new StaffMember(staff2);                
        Object obj = instance2;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class StaffMember.
     */
    @Test
    public void testEquals3() {
        System.out.println("equals3");
        User staff = new User("manuel", "mjdg111@hotmail.com", "garnel2", 123, Role.ATENDEE);        
        StaffMember instance = new StaffMember(staff);                
        Object obj = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class StaffMember.
     */
    @Test
    public void testEquals4() {
        System.out.println("equals4");
        User staff = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.ATENDEE);
        User organiser = new User("manuel", "mjdg111@hotmail.com", "garnel", 123, Role.ATENDEE);
        StaffMember instance = new StaffMember(staff);
        Organiser org = new Organiser();
        org.setOrganiser(organiser);
        Object obj = organiser;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
//    /**
//     * Test of hashCode method, of class StaffMember.
//     */
    @Test
    public void testHashCodeTwo() {
        System.out.println("hashCode");
        StaffMember instance = new StaffMember();
        int expResult = instance.hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
}

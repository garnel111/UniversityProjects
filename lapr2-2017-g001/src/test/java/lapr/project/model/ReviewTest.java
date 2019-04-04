/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.model;

import java.util.Objects;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author andre
 */
public class ReviewTest {
    
    StaffMember staffMemberReviewer = new StaffMember();
    Review reviewOne = new Review("RV1", 4, 4, 5, 2, Decision.DECLINED, staffMemberReviewer);
    
    public ReviewTest() {
    }
    
    /**
     * Test of set/getText method, of class Review.
     */
    @Test
    public void testSetAndGetText() {
        System.out.println("set/getText");
        Review instance = new Review();
        String expResult = "Text Review";
        instance.setText(expResult);
        String result = instance.getText();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of set/getStaffTopicKnowledge method, of class Review.
     */
    @Test
    public void testSetAndGetStaffTopicKnowledge() {
        System.out.println("set/getStaffTopicKnowledge");
        Review instance = new Review();
        int expResult = 4;
        instance.setStaffTopicKnowledge(expResult);
        int result = instance.getStaffTopicKnowledge();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of set/getEventAdequacy method, of class Review.
     */
    @Test
    public void testSetAndGetEventAdequacy() {
        System.out.println("set/getEventAdequacy");
        Review instance = new Review();
        int expResult = 5;
        instance.setEventAdequacy(expResult);
        int result = instance.getEventAdequacy();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of set/getInviteAdequacy method, of class Review.
     */
    @Test
    public void testSetAndGetInviteAdequacy() {
        System.out.println("set/getInviteAdequacy");
        Review instance = new Review();
        int expResult = 3;
        instance.setInviteAdequacy(expResult);
        int result = instance.getInviteAdequacy();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of set/getRecommendation method, of class Review.
     */
    @Test
    public void testSetAndGetRecommendation() {
        System.out.println("set/getRecommendation");
        Review instance = new Review();
        int expResult = 5;
        instance.setRecommendation(expResult);
        int result = instance.getRecommendation();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of set/getDecision method, of class Review.
     */
    @Test
    public void testSetAndGetDecision() {
        System.out.println("set/getDecision");
        Review instance = new Review();
        Decision expResult = Decision.ACCEPTED;
        instance.setDecision(expResult);
        Decision result = instance.getDecision();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of set/getDecision method, of class Review.
     */
    @Test
    public void testSetAndGetDecision2() {
        System.out.println("set/getDecision2");
        Review instance = new Review();
        Decision expResult = Decision.DECLINED;
        instance.setDecision(expResult);
        Decision result = instance.getDecision();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of set/getAssignedStaffMember method, of class Review.
     */
    @Test
    public void testSetAndGetAssignedStaffMember() {
        System.out.println("set/getAssignedStaffMember");
        Review instance = new Review();
        User user = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.ATENDEE);
        StaffMember expResult = new StaffMember(user);
        instance.setAssignedStaffMember(expResult);
        StaffMember result = instance.getAssignedStaffMember();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Review.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Review instance = new Review();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Review.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals2");
        User user = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.ATENDEE);
        StaffMember staff = new StaffMember(user);
        Review rv1 = new Review("RV1", 4, 4, 5, 3, Decision.DECLINED, staff);
        Review instance = new Review("RV1", 4, 4, 5, 3, Decision.DECLINED, staff);
        Object o = rv1;
        
        boolean result = instance.equals(instance);
        assertTrue(result);
    }
    
    /**
     * Test of equals method, of class Review.
     */
    @Test
    public void testEquals3() {
        System.out.println("equals3");
        User user = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.ATENDEE);
        StaffMember staff = new StaffMember(user);
        Review rv1 = new Review("RV2", 4, 4, 5, 3, Decision.DECLINED, staff);
        Object o = rv1;
        Review instance = new Review("RV1", 4, 4, 5, 3, Decision.DECLINED, staff);
        boolean result = instance.equals(o);
        assertFalse(result);
    }
    
    /**
     * Test of equals method, of class Review.
     */
    @Test
    public void testEquals4() {
        System.out.println("equals4");
        User user = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.ATENDEE);
        StaffMember staff = new StaffMember(user);
        Review rv1 = new Review("RV1", 5, 4, 5, 3, Decision.DECLINED, staff);
        Object o = rv1;
        Review instance = new Review("RV1", 4, 4, 5, 3, Decision.DECLINED, staff);
        boolean result = instance.equals(o);
        assertFalse(result);
    }
    
    /**
     * Test of equals method, of class Review.
     */
    @Test
    public void testEquals5() {
        System.out.println("equals5");
        User user = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.ATENDEE);
        StaffMember staff = new StaffMember(user);
        Review rv1 = new Review("RV1", 4, 5, 5, 3, Decision.DECLINED, staff);
        Object o = rv1;
        Review instance = new Review("RV1", 4, 4, 5, 3, Decision.DECLINED, staff);
        boolean result = instance.equals(o);
        assertFalse(result);
    }
    
    /**
     * Test of equals method, of class Review.
     */
    @Test
    public void testEquals6() {
        System.out.println("equals6");
        User user = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.ATENDEE);
        StaffMember staff = new StaffMember(user);
        Review rv1 = new Review("RV1", 4, 4, 4, 3, Decision.DECLINED, staff);
        Object o = rv1;
        Review instance = new Review("RV1", 4, 4, 5, 3, Decision.DECLINED, staff);
        boolean result = instance.equals(o);
        assertFalse(result);
    }
    
    /**
     * Test of equals method, of class Review.
     */
    @Test
    public void testEquals7() {
        System.out.println("equals7");
        User user = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.ATENDEE);
        StaffMember staff = new StaffMember(user);
        Review rv1 = new Review("RV1", 4, 4, 5, 2, Decision.DECLINED, staff);
        Object o = rv1;
        Review instance = new Review("RV1", 4, 4, 5, 3, Decision.DECLINED, staff);
        boolean result = instance.equals(o);
        assertFalse(result);
    }
    
    /**
     * Test of equals method, of class Review.
     */
    @Test
    public void testEquals8() {
        System.out.println("equals8");
        User user = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.ATENDEE);
        StaffMember staff = new StaffMember(user);
        Review rv1 = new Review("RV1", 4, 4, 5, 2, Decision.ACCEPTED, staff);
        Object o = rv1;
        Review instance = new Review("RV1", 4, 4, 5, 2, Decision.DECLINED, staff);
        boolean result = instance.equals(o);
        assertFalse(result);
    }
    
    /**
     * Test of equals method, of class Review.
     */
    @Test
    public void testEquals9() {
        System.out.println("equals9");
        User user = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.ATENDEE);
        StaffMember staff = new StaffMember(user);
        User user2 = new User("manuel", "mjdg111@hotmail.com", "garnel", 12345, Role.ATENDEE);
        StaffMember staff2 = new StaffMember(user2);
        Review rv1 = new Review("RV1", 4, 4, 5, 2, Decision.DECLINED, staff);
        Object o = rv1;
        Review instance = new Review("RV1", 4, 4, 5, 2, Decision.DECLINED, staff2);
        boolean result = instance.equals(o);
        assertFalse(result);
    }
    
    /**
     * Test of equals method, of class Review.
     */
    @Test
    public void testEquals10() {
        System.out.println("equals10");
        User user = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.ATENDEE);
        StaffMember staff = new StaffMember(user);
        Object o = user;
        Review instance = new Review("RV1", 4, 4, 5, 2, Decision.DECLINED, staff);
        boolean result = instance.equals(o);
        assertFalse(result);
    }

 @Test

    public void testHashCode() {

        System.out.println("hashCode");

        User user = new User("manuel", "mjdg111@hotmail.com", "garnel", 1234, Role.ATENDEE);

        StaffMember staff = new StaffMember(user);
      
        int expResult = 5;

        expResult = 71 * expResult + Objects.hashCode("text");

        expResult = 71 * expResult + 3;

        expResult = 71 * expResult + 4;

        expResult = 71 * expResult + 4;

        expResult = 71 * expResult + 3;

        expResult = 71 * expResult + Objects.hashCode(Decision.ACCEPTED);

        expResult = 71 * expResult + Objects.hashCode(staff);
       
        Review instance = new Review("text", 3, 4, 4, 3, Decision.ACCEPTED, staff);

        int result = instance.hashCode();
       
        assertEquals(expResult, result);

    }
}

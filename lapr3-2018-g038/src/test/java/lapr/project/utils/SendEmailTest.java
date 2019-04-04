package lapr.project.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 *
 * @author marco
 */
public class SendEmailTest {

    public SendEmailTest() {
    }

    /**
     * Test of ValidatesendEmailTrue method, of class SendEmail.
     */
    @Test
    public void testValidatesendEmailTrue() {
        System.out.println("ValidatesendEmailTrue");
        String email = "marcopinheiro21@hotmail.com";
        boolean result = SendEmail.ValidatesendEmail(email);

        boolean expectedResult = true;
        assertEquals(expectedResult, result);
    }
    /**
     * Test of ValidatesendEmailFalse method, of class SendEmail.
     */
    @Test
    public void testValidatesendEmailFalse() {
        System.out.println("ValidatesendEmailFalse");
        String email = "";
        boolean result = SendEmail.ValidatesendEmail(email);
        boolean expectedResult = false;
        assertEquals(expectedResult, result);
    }


}

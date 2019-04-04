/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import lapr.project.utils.PasswordEncryption;
import static org.junit.jupiter.api.Assertions.assertEquals;
 
import org.junit.jupiter.api.Test;

/**
 *
 * @author JM
 */
public class PasswordEncryptionTest {

    /**
     * Test of encryptPassword method, of class PasswordEncryption.
     */
    @Test
    public void testEncryptPassword() {
        System.out.println("encryptPassword");
        String password = "1321";
        double expResult = 0.4375;
        System.out.println(PasswordEncryption.encryptPassword(password));
        double result = PasswordEncryption.encryptPassword(password);
        assertEquals(expResult, result);
    }
}

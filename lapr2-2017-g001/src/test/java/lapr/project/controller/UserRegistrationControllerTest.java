/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.ExhibitionCentre;
import lapr.project.utils.PasswordEncryption;
import lapr.project.model.User;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author JM
 */
public class UserRegistrationControllerTest {

    /**
     * Test of setData method, of class UserRegistrationController.
     */
    @Test
    public void testSetData() {
        System.out.println("setData");
        User user = new User("nome completo", "email@server.com", "user", PasswordEncryption.encryptPassword("12345678"));
        String name = "nome completo";
        String email = "email@server.com";
        String username = "user";
        String password = "12345678";
        ExhibitionCentre centre = new ExhibitionCentre();
        UserRegistrationController instance = new UserRegistrationController(centre);
        instance.setData(name, email, username, password);
        assertEquals(user.getName(), instance.getUser().getName());
        assertEquals(user.getEmail(), instance.getUser().getEmail());
        assertEquals(user.getUsername(), instance.getUser().getUsername());
        assertEquals(user.getPassword(), instance.getUser().getPassword());

    }

    /**
     * Test of addUser method, of class UserRegistrationController.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        String name = "nome completo";
        String email = "email@server.com";
        String username = "user";
        String password = "12345678";
        ExhibitionCentre centre = new ExhibitionCentre();
        UserRegistrationController instance = new UserRegistrationController(centre);
        instance.setData(name, email, username, password);
        instance.addUser();
        assertTrue(centre.getUserRegister().getUserList().contains(instance.getUser()));

    }

    /**
     * Test of isName method, of class UserRegistrationUI.
     */
    @Test
    public void testIsName() {
        System.out.println("isName");
        String name = "Nome Nome";
        ExhibitionCentre centre = new ExhibitionCentre();
        UserRegistrationController instance = new UserRegistrationController(centre);
        boolean expResult = true;
        boolean result = instance.isName(name);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isName method, of class UserRegistrationUI.
     */
    @Test
    public void testIsNameNumber() {
        System.out.println("isName");
        String name = "123 José";
        ExhibitionCentre centre = new ExhibitionCentre();
        UserRegistrationController instance = new UserRegistrationController(centre);
        boolean expResult = false;
        boolean result = instance.isName(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmail method, of class UserRegistrationUI.
     */
    @Test
    public void testIsEmail() {
        System.out.println("isEmail");
        String email = "emailtest@gmail.com";
        ExhibitionCentre centre = new ExhibitionCentre();
        UserRegistrationController instance = new UserRegistrationController(centre);
        boolean expResult = true;
        boolean result = instance.isEmail(email);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isEmail method, of class UserRegistrationUI.
     */
    @Test
    public void testIsEmailEmptyFirst() {
        System.out.println("isEmail");
        String email = "@gmail.com";
        ExhibitionCentre centre = new ExhibitionCentre();
        UserRegistrationController instance = new UserRegistrationController(centre);
        boolean expResult = false;
        boolean result = instance.isEmail(email);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isEmail method, of class UserRegistrationUI.
     */
    @Test
    public void testIsEmailEmpty() {
        System.out.println("isEmail");
        String email = "";
        ExhibitionCentre centre = new ExhibitionCentre();
        UserRegistrationController instance = new UserRegistrationController(centre);
        boolean expResult = false;
        boolean result = instance.isEmail(email);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isEmail method, of class UserRegistrationUI.
     */
    @Test
    public void testIsEmailMultipleAt() {
        System.out.println("isEmail");
        String email = "emailtest@gmail.com@hotmail.com";
        ExhibitionCentre centre = new ExhibitionCentre();
        UserRegistrationController instance = new UserRegistrationController(centre);
        boolean expResult = false;
        boolean result = instance.isEmail(email);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isEmail method, of class UserRegistrationUI.
     */
    @Test
    public void testIsEmailNoAt() {
        System.out.println("isEmail");
        String email = "emailtestgmail.com";
        ExhibitionCentre centre = new ExhibitionCentre();
        UserRegistrationController instance = new UserRegistrationController(centre);
        boolean expResult = false;
        boolean result = instance.isEmail(email);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isEmail method, of class UserRegistrationUI.
     */
    @Test
    public void testIsEmailNoPoint() {
        System.out.println("isEmail");
        String email = "emailtest@gmailcom";
        ExhibitionCentre centre = new ExhibitionCentre();
        UserRegistrationController instance = new UserRegistrationController(centre);
        boolean expResult = false;
        boolean result = instance.isEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of isUsername method, of class UserRegistrationUI.
     */
    @Test
    public void testIsUsername() {
        System.out.println("isUsername");
        String username = "user123";
        ExhibitionCentre centre = new ExhibitionCentre();
        UserRegistrationController instance = new UserRegistrationController(centre);
        boolean expResult = true;
        boolean result = instance.isUsername(username);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isUsername method, of class UserRegistrationUI.
     */
    @Test
    public void testIsUsernameEmpty() {
        System.out.println("isUsername");
        String username = "";
        ExhibitionCentre centre = new ExhibitionCentre();
        UserRegistrationController instance = new UserRegistrationController(centre);
        boolean expResult = false;
        boolean result = instance.isUsername(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of isPassword method, of class UserRegistrationUI.
     */
    @Test
    public void testIsPassword() {
        System.out.println("isPassword");
        String passString = "12345678";
        ExhibitionCentre centre = new ExhibitionCentre();
        UserRegistrationController instance = new UserRegistrationController(centre);
        boolean expResult = true;
        boolean result = instance.isPassword(passString);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of isPassword method, of class UserRegistrationUI.
     */
    @Test
    public void testIsPasswordNotNumbers() {
        System.out.println("isPassword");
        String passString = "12345abc";
        ExhibitionCentre centre = new ExhibitionCentre();
        UserRegistrationController instance = new UserRegistrationController(centre);
        boolean expResult = false;
        boolean result = instance.isPassword(passString);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isPassword method, of class UserRegistrationUI.
     */
    @Test
    public void testIsPasswordLength() {
        System.out.println("isPassword");
        String passString = "1234567";
        ExhibitionCentre centre = new ExhibitionCentre();
        UserRegistrationController instance = new UserRegistrationController(centre);
        boolean expResult = false;
        boolean result = instance.isPassword(passString);
        assertEquals(expResult, result);
    }

    /**
     * Test of isPassword method, of class UserRegistrationUI.
     */
    @Test
    public void testIsPasswordSame() {
        System.out.println("isPassword");
        String passString = "00000000";
        ExhibitionCentre centre = new ExhibitionCentre();
        UserRegistrationController instance = new UserRegistrationController(centre);
        boolean expResult = false;
        boolean result = instance.isPassword(passString);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getUser method, of class UserRegistrationController.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        User user = new User("nome completo", "email@server.com", "user", PasswordEncryption.encryptPassword("12345678"));
        ExhibitionCentre centre = new ExhibitionCentre();
        UserRegistrationController instance = new UserRegistrationController(centre);
        instance.setData("nome completo", "email@server.com", "user", "12345678");
        User expResult = user;
        User result = instance.getUser();
        assertEquals(expResult, result);
    }

}

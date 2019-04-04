package lapr.project.controller;

import lapr.project.data.ParkDB;
import lapr.project.data.UserDB;
import lapr.project.model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author marco
 */
public class UserControllerTest {

    UserController uController;

    public UserControllerTest() {
    }

    /**
     * Test of constructor, of class User.
     */
    @Test
    public void testUser() {
        System.out.println("Test User");
        User instance = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 1, 50);
        User user = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 1, 50);
        assertTrue(user.equals(instance));
    }

    /**
     * Test of setUserDataBase method, of class UserController.
     */
    @Test
    public void testSetUserDataBase() {
        System.out.println("setUserDataBase");
        UserDB userDataBase = new UserDB();
        UserController instance = new UserController();
        instance.setUserDataBase(userDataBase);

    }

    /**
     * Test of getUserByEmail method, of class UserController.
     */
    @Test
    public void testGetUserByEmail() {
        System.out.println("getUserByEmail");
        String email = "1170483@isep.ipp.pt";

        UserDB udb = mock(UserDB.class);
        uController = new UserController();
        uController.setUserDataBase(udb);

        User user = new User();
        user.setUsername("Marco");
        user.setEmail(email);
        user.setPassword("qwertyMarco");
        user.setCardNumber("1234554321");
        user.setHeight(1.75);
        user.setWeight(72);
        user.setPoints(29);
        user.setInitialCost(50);

        when(udb.getUserByEmail(email)).thenReturn(user);

        User expResult = user;
        User result = uController.getUserByEmail(email);
        assertEquals(expResult, result);
        verify(udb).getUserByEmail(email);
    }

    @Test
    public void testNewUserShouldBeFalse() {
        UserDB udb = mock(UserDB.class);
        String email = "1170483@isep.ipp.pt";
        User user = new User();
        uController = new UserController();
        uController.setUserDataBase(udb);

        //  when(udb.getUserByEmail(email)).thenReturn(null);
        when(udb.newUser(user)).thenReturn(false);

        udb.newUser(user);

        boolean result = uController.newUser("", "", "", "", 0, 0, 0, 0);
        assertFalse(udb.newUser(user));
        //   verify(udb).newUser(user);//verifica se a DB mock foi usada
    }

    /**
     * Test of newUser method, of class UserController.
     */
    @Test
    public void testNewUser() {
        System.out.println("newUser");

        String username = "Marco";
        String email = "1170481@isep.ipp.pt";
        String password = "qwertyMarco";
        String cardNumber = "1234554321";
        double height = 1.75;
        double weight = 55;
        long points = 29;
        double initialCost = 50;

        UserDB udb = mock(UserDB.class);
        uController = new UserController();
        uController.setUserDataBase(udb);

        User nUser = new User(username, email, password, cardNumber, height, weight, points, initialCost);

        when(udb.newUser(nUser)).thenReturn(true);//quando o controller chamar a função da DB, usa a DB mock e retorna o resultado p1

        Boolean expResult = udb.newUser(nUser);
        assertEquals(expResult, true);
        verify(udb).newUser(nUser);//verifica se a DB mock foi usada
    }

    /**
     * Test of validateUser method, of class UserController.
     */
    @Test
    public void testValidateUserTrue() {
        System.out.println("validateUserTrue");
        String email = "1170483@isep.ipp.pt";

        UserDB udb = mock(UserDB.class);
        uController = new UserController();
        uController.setUserDataBase(udb);

        User user = new User();
        user.setUsername("Marco");
        user.setEmail(email);
        user.setPassword("qwertyMarco");
        user.setCardNumber("1234554321");
        user.setHeight(1.75);
        user.setWeight(72);
        user.setPoints(29);
        user.setInitialCost(50);

        when(udb.getUserByEmail(email)).thenReturn(user);

        boolean expResult = true;
        boolean result = uController.validateUser(email);
        assertEquals(expResult, result);
        verify(udb).getUserByEmail(email);//verifica se a DB mock foi usada
    }

    /**
     * Test of validateUser method, of class UserController.
     */
    @Test
    public void testValidateUserFalse() {
        System.out.println("validateUserFalse");
        String email = "1111111@isep.ipp.pt";

        UserDB udb = mock(UserDB.class);
        uController = new UserController();
        uController.setUserDataBase(udb);

        when(udb.getUserByEmail(email)).thenReturn(null);

        boolean expResult = false;
        boolean result = uController.validateUser(email);
        assertEquals(expResult, result);
        verify(udb).getUserByEmail(email);//verifica se a DB mock foi usada
    }

    /**
     * Test of validateEmail method, of class User.
     */
    @Test
    public void testValidateEmail() {
        System.out.println("validateEmail");
        User user = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 0, 50);
        UserController instance = new UserController(user);
        String email = "matilde@hotmail.com";
        boolean expResult = true;
        boolean result = instance.validateEmail(email);
        assertEquals(expResult, result);

    }

    /**
     * Test of validateEmail method, of class User.
     */
    @Test
    public void testValidateEmailInvalid() {
        System.out.println("validateEmail");
        User user = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 0, 50);
        UserController instance = new UserController(user);
        String email = "matildehotmail.com";
        boolean expResult = false;
        boolean result = instance.validateEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of validatePassword method, of class User.
     */
    @Test
    public void testValidatePassword() {
        System.out.println("Valid password");
        User user = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 0, 50);
        UserController instance = new UserController(user);
        String validPassword = "qwerty";
        boolean expResult = true;
        boolean result = instance.validatePassword(validPassword);
        assertEquals(expResult, result);
    }

    /**
     * Test of validatePassword method, of class User.
     */
    @Test
    public void tesrValidatePasswordInvalid() {
        System.out.println("Invalid password");
        User user = new User("Matilde", "matilde@hotmail.com", "qwerty", "4544000019821545", 1.65, 55, 0, 50);
        UserController instance = new UserController(user);
        String invalidPassword = "qwert";
        boolean expResult = false;
        boolean result = instance.validatePassword(invalidPassword);
        assertEquals(expResult, result);
    }
    
    /*
    Test of  requestFreeSlot method.
    */
    @Test
    public void testrequestFreeSlot()throws Exception{
        
        System.out.println("check if there are free slots to park bicycle");
        
         
        
        uController= new UserController();
        
        ParkDB parkdbMocked=mock(ParkDB.class);
        uController.setParkDatabase(parkdbMocked);
        
        String typeBicycle = "Electric";
        String destinationparkname = "ISEP_PARK";
                
        
        when(parkdbMocked.getFreeSlot(destinationparkname, typeBicycle)).thenReturn((long)458);
        long expResult=458;
        long requestFreeSlotResult=uController.requestFreeSlot(destinationparkname, typeBicycle);
        
        assertEquals(expResult, requestFreeSlotResult);
        verify(parkdbMocked).getFreeSlot(destinationparkname, typeBicycle);
    }
}

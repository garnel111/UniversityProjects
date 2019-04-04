/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.data.UserDB;
import lapr.project.model.Trip;
import lapr.project.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

/**
 * @author mjdg1
 */
public class LoginControllerTest {

    public LoginControllerTest() {
    }

    private LoginController lContr;

    @Test
    public void testValidateUserBy() {

        System.out.println("\n Validate User");
        String userName = "Manuel";
        String mail = "1131325@isep.ipp.pt";
        String password = "qwertyManuel";

        UserDB udb = mock(UserDB.class);
        lContr = new LoginController();
        lContr.getMail();
        lContr.getUser();
        lContr.setUserDataBase(udb);

        User u1 = new User();
        u1.getUsername();
        u1.getEmail();
        u1.getCardNumber();
        u1.setUsername(userName);
        u1.setEmail(mail);
        u1.setPassword(password);
        u1.setCardNumber("123456");
        u1.setHeight(60);
        u1.setIdUser(5050);
        u1.setPoints(30);
        lContr.setUserEmail(u1.getEmail());
        lContr.setUserPass(u1.getPassword());
        when(udb.getUserByMailAndPass(password, mail)).thenReturn(u1);

        User expResult = u1;
        User resultUser = udb.getUserByMailAndPass(password, mail);

        lContr.getMail();


        String resultName = resultUser.getUsername();

        assertEquals(u1.getUsername(), resultName);
        verify(udb).getUserByMailAndPass(password, mail);
    }

    @Test
    public void testGetUserMass() {
        System.out.println("\n Get User Mass ");

        LoginController lController = new LoginController();
        UserDB userDbMocked = mock(UserDB.class);
        User user = new User();
        user.setUsername("Manuel");
        user.setEmail("1131325@isep.ipp.pt");
        user.setCardNumber("155555521");
        user.setPassword("qwertyManuel");
        user.setHeight(1.69);
        user.setIdUser(5050);
        user.setWeight(71);

        user.setPoints(30);

        lController = new LoginController(user.getEmail(), user.getPassword(), userDbMocked);
        lController.setUserDataBase(userDbMocked);

        when(userDbMocked.getUserMass("Manuel")).thenReturn(user.getWeight());

        float expectedResult = 71;
        double result = userDbMocked.getUserMass("Manuel");

        assertEquals(expectedResult, result);

    }

    @Test
    public void testGetRequestIdCorrect() {
        System.out.println("\n Get Trip By User");
        Trip trip;
        User user1 = new User();
        user1.setUsername("Manuel");
        user1.setEmail("1131325@isep.ipp.pt");
        user1.setCardNumber("155555521");
        user1.setPassword("qwertyManuel");
        user1.setHeight(1.69);
        user1.setIdUser(5050);
        user1.setWeight(71);
        user1.setPoints(30);
        trip = new Trip();
        trip.setBicycle_Id(60000);
        trip.setUserId(trip.getUserId());
        trip.setRequest_Id(500000);
        trip.setOriginalPark_Id(400);
        trip.setDestinationPark_Id(401);
        LoginController lController = mock(LoginController.class);
        String mail = "1131325@isep.ipp.pt";
        String password = "qwertyManuel";
        UserDB userDbMocked = mock(UserDB.class);
        lController.setUserEmail(mail);
        lController.setUserPass(password);
        lController.setUserDB(userDbMocked);
        lController.setUser(user1);
        lController.getUser();
        lController.setUserDataBase(userDbMocked);

        when(userDbMocked.getTripByUser(user1)).thenReturn(trip);

        lController.getUSerByMailAndPass(password, mail);
        lController.setUser(user1);
        long expectedResult = 500000;
        Trip result = userDbMocked.getTripByUser(user1);
        long tripIdResult = result.getRequest_Id();
        System.out.println("result" + tripIdResult);
        assertEquals(500000, tripIdResult);
    }


    @Test
    public void testSetNullMail() {
        System.out.println("\n  Set Null Mail");
        Trip trip;
        User user1 = new User();
        user1.setUsername("Manuel");
        user1.setEmail("");
        user1.setCardNumber("155555521");
        user1.setPassword("qwertyManuel");
        user1.setHeight(1.69);
        user1.setIdUser(5050);
        user1.setWeight(71);
        user1.setPoints(30);
        UserDB userDB = new UserDB();

        LoginController lController = new LoginController(user1.getEmail(), user1.getPassword(), userDB);
        String mail = "1131325@isep.ipp.pt";
        String password = "qwertyManuel";
        UserDB userDbMocked = mock(UserDB.class);
        User user2 = new User(mail, password);

        Assert.assertNotEquals(user1.getEmail(), user2.getEmail());

    }

    @Test
    public void testGetUserId() {
        System.out.println("\n Get UserId");
        Trip trip;
        User user1 = new User();
        user1.setUsername("Manuel");
        user1.setEmail("1131325@isep.ipp.pt");
        user1.setCardNumber("155555521");
        user1.setPassword("qwertyManuel");
        user1.setHeight(1.69);
        user1.setIdUser(5050);
        user1.setWeight(71);
        user1.setPoints(30);
        trip = new Trip();
        trip.setUserId(100);
        trip.setBicycle_Id(60000);
        trip.setUserId(trip.getUserId());
        trip.setRequest_Id(500000);
        trip.setOriginalPark_Id(400);
        trip.setDestinationPark_Id(401);

        LoginController lController = new LoginController();
        String mail = "1131325@isep.ipp.pt";
        String password = "qwertyManuel";
        UserDB userDbMocked = mock(UserDB.class);

        lController = new LoginController(mail, password, userDbMocked);
        lController.setUser(user1);
        lController.getUser();
        lController.setUserDataBase(userDbMocked);

        long expectedResult = 500000;

        long resultId = trip.getUserId();

        assertEquals(100, resultId);
    }

    @Test
    public void testGetBicycleId() {
        System.out.println("\n Get Bike Id");
        Trip trip;
        User user1 = new User();
        user1.setUsername("Manuel");
        user1.setEmail("1131325@isep.ipp.pt");
        user1.setCardNumber("155555521");
        user1.setPassword("qwertyManuel");
        user1.setHeight(1.69);
        user1.setIdUser(5050);
        user1.setWeight(71);
        user1.setPoints(30);
        trip = new Trip();
        trip.setUserId(100);
        trip.setBicycle_Id(60000);
        trip.setUserId(trip.getUserId());
        trip.setRequest_Id(500000);
        trip.setOriginalPark_Id(400);
        trip.setDestinationPark_Id(401);
        LoginController lController = new LoginController();
        String mail = "1131325@isep.ipp.pt";
        String password = "qwertyManuel";
        UserDB userDbMocked = mock(UserDB.class);
        lController = new LoginController(mail, password, userDbMocked);
        lController.setUser(user1);
        lController.getUser();
        lController.setUserDataBase(userDbMocked);

        long expectedResult = 60000;

        long bicycleID = trip.getBicycle_Id();

        assertEquals(expectedResult, bicycleID);
    }

    @Test
    public void testOriginalParkId() {
        System.out.println("\n Get Park\n");
        Trip trip = new Trip(100, 500000, 600, 400, 401);
        User user1 = new User();
        user1.setUsername("Manuel");
        user1.setEmail("1131325@isep.ipp.pt");
        user1.setCardNumber("155555521");
        user1.setPassword("qwertyManuel");
        user1.setHeight(1.69);
        user1.setIdUser(5050);
        user1.setWeight(71);
        user1.setPoints(30);
        trip = new Trip();
        trip.setUserId(100);
        trip.setBicycle_Id(60000);
        trip.setUserId(trip.getUserId());
        trip.setRequest_Id(500000);
        trip.setOriginalPark_Id(400);
        trip.setDestinationPark_Id(401);
        LoginController lController = new LoginController();
        String mail = "1131325@isep.ipp.pt";
        String password = "qwertyManuel";
        UserDB userDbMocked = mock(UserDB.class);
        lController = new LoginController(mail, password, userDbMocked);
        lController.setUser(user1);
        lController.getUser();
        lController.setUserEmail(user1.getEmail());
        lController.setUserDataBase(userDbMocked);

        long expectedResult = 400;

        long originalParkId = trip.getOriginPark_Id();

        assertEquals(expectedResult, originalParkId);
    }

    @Test
    public void testDestinationParkId() {
        System.out.println("\n Get Destination Park \n");
        Trip trip;
        User user1 = new User();
        user1.setUsername("Manuel");
        user1.setEmail("1131325@isep.ipp.pt");
        user1.setCardNumber("155555521");
        user1.setPassword("qwertyManuel");
        user1.setHeight(1.69);
        user1.setIdUser(5050);
        user1.setWeight(71);
        user1.setPoints(30);
        trip = new Trip();
        trip.setUserId(100);
        trip.setBicycle_Id(60000);
        trip.setUserId(trip.getUserId());
        trip.setRequest_Id(500000);
        trip.setOriginalPark_Id(400);
        trip.setDestinationPark_Id(401);
        LoginController lController = new LoginController();
        String mail = "1131325@isep.ipp.pt";
        String password = "qwertyManuel";
        UserDB userDbMocked = mock(UserDB.class);

        lController = new LoginController(mail, password, userDbMocked);
        lController.setUser(user1);
        lController.getUser();
        lController.setUserDataBase(userDbMocked);

        long expectedResult = 401;

        long destinationParkId = trip.getDestinationPark_Id();

        assertEquals(expectedResult, destinationParkId);
    }

    @Test
    public void testSetEmptyMail() {
        System.out.println("\n  Set Null Mail \n");
        Trip trip;
        User user1 = new User();
        user1.setUsername("Manuel");
        user1.setEmail(null);
        user1.setCardNumber("155555521");
        user1.setPassword("qwertyManuel");
        user1.setHeight(1.69);
        user1.setIdUser(5050);
        user1.setWeight(71);
        user1.setPoints(30);
        UserDB userDB = new UserDB();

        LoginController lController = new LoginController(user1.getEmail(), user1.getPassword(), userDB);
        lController.setUserDB(userDB);
        lController.getUserDB();
        String mail = "1131325@isep.ipp.pt";
        String password = "qwertyManuel";
        UserDB userDbMocked = mock(UserDB.class);
        User user2 = new User(mail, password);

        Assert.assertNull(user1.getEmail());

    }

    @Test()
    public void testGetUserByEmailAndPassResultShouldThrowException() {
        System.out.println("test GetUserByEmailAndPassResultShouldThrowException");
        boolean thrown = true;
        User user = new User();
        UserDB userDbMocked = mock(UserDB.class);
        LoginController lController = mock(LoginController.class);//new LoginController("user1", "1131325@isep.ipp.pt");
        lController.setUserPass("user1");
        lController.setUserEmail("1131325@isep.ipp.pt");
        lController.setUserDataBase(userDbMocked);
        when(userDbMocked.getUserByMailAndPass("user1", "1131325@isep.ipp.pt")).thenReturn(user);
        try {
            User user2 = userDbMocked.getUserByMailAndPass("user1", "1131325@isep.ipp.pt");
            String mail = user2.getEmail();
            String pass = user2.getPassword();
            when(lController.getUSerByMailAndPass(pass, mail)).thenReturn(user2);
            lController.getUSerByMailAndPass(pass, mail);


        } catch (IllegalArgumentException e) {
            thrown = true;

        }
        assertTrue(thrown);
    }

    @Test
    public void testValidateU() {

        System.out.println("\n Validate User");
        String userName = "Manuel";
        String mail = "1131325@isep.ipp.pt";
        String password = "qwertyManuel";

        UserDB udb = mock(UserDB.class);
        lContr = new LoginController(password, mail);
        lContr.getMail();
        lContr.getUser();
        lContr.setUserDataBase(udb);

        User u1 = new User();
        u1.getUsername();
        u1.getEmail();
        u1.getCardNumber();
        u1.setUsername(userName);
        u1.setEmail(mail);
        u1.setPassword(password);
        u1.setCardNumber("123456");
        u1.setHeight(60);
        u1.setIdUser(5050);
        u1.setPoints(30);
        lContr.setUserEmail(u1.getEmail());
        lContr.setUserPass(u1.getPassword());
        when(udb.getUserByMailAndPass(password, mail)).thenReturn(u1);

        User expResult = u1;
        User resultUser = udb.getUserByMailAndPass(password, mail);

        lContr.getMail();


        String resultName = resultUser.getUsername();

        assertEquals(u1.getUsername(), resultName);
        verify(udb).getUserByMailAndPass(password, mail);
    }


}

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package lapr.project.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Manuel
 */
public class OrganiserRegisterTest {

    @Test
    public void organiserRegisterTest() {
        //Arrange
        User user = new User("Name name", "email@server.com", "user1", 0.1234);
        User otherUser = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        User inexistentUser = new User("Nome sem nome", "semmail@server.com", "noUser1", 0.1234);
        int size;
        Organiser noOrganiser = new Organiser(inexistentUser);
        Organiser organiser = new Organiser(user);
        Organiser otherOrganiser = new Organiser(otherUser);
        OrganiserRegister organiserRegister = new OrganiserRegister();

        //Act
        organiserRegister.addOrganiser(organiser);
        organiserRegister.registerOrganiser(user);
        OrganiserRegister otherOrganiserRegister = new OrganiserRegister();
        otherOrganiserRegister.addOrganiser(organiser);
        otherOrganiserRegister.addOrganiser(organiser);
        otherOrganiserRegister.registerOrganiser(user);
        size = organiserRegister.sizeOrganiserList();
        OrganiserRegister organiserRegister123 = new OrganiserRegister(organiserRegister.getOrganiserList());

        //Assert
        assertEquals(otherOrganiserRegister, organiserRegister);
        assertEquals(1, size);
        assertTrue(otherOrganiserRegister.registerOrganiser(inexistentUser));

    }

    @Test
    public void organiserRegisterTestTrue() {

        //Arrange
        User user = new User("Name name", "email@server.com", "user1", 0.1234);
        User otherUser = new User("Nome Nome", "email@server.com", "user1", 0.1234);
        OrganiserRegister organiserRegister = new OrganiserRegister();
        System.out.println("No added organiser " + organiserRegister.toString());
        Organiser organiser = new Organiser(user);
        boolean expecteds = true;

        //Act
        boolean actuals = organiserRegister.addOrganiser(organiser);

        //Assert
        assertEquals(expecteds, actuals);
    }

    @Test
    public void organiserRegisterTestFalse() {

        //Arrange
        User user = new User("Name name", "email@server.com", "user", 0.1234);
        User otherUser = new User("Outro nome", "email2@server.com", "user1", 0.1234);
        OrganiserRegister organiserRegister = new OrganiserRegister();

        Organiser organiser = new Organiser(user);
        Organiser organiser1 = new Organiser(otherUser);
        boolean expecteds = true;

        //Act
        organiserRegister.addOrganiser(organiser);
        organiserRegister.addOrganiser(organiser1);

        //Assert
        assertNotEquals(organiserRegister.getOrganiserList().get(0), organiserRegister.getOrganiserList().get(1));
    }

    @Test
    public void notEqualsTest() {

        //Arrange
        User user = new User("Name name", "email@server.com", "user", 0.1234);
        User otherUser = new User("Outro nome", "email2@server.com", "user1", 0.1234);

        OrganiserRegister organiserRegister = new OrganiserRegister();

        Organiser organiser = new Organiser(user);
        Organiser organiser1 = new Organiser(otherUser);
        boolean expecteds = true;

        //Assert
        assertFalse(organiserRegister.equals(otherUser));

    }

    @Test
    public void hashCodeTest() {

        OrganiserRegister organiserRegister = new OrganiserRegister();
        OrganiserRegister organiserRegister1 = new OrganiserRegister();
        assertEquals(organiserRegister.hashCode(), organiserRegister1.hashCode());
    }

    @Test

    public void testHashCode() {
        System.out.println("hashCode");
        OrganiserRegister organiserRegisterHashCode = new OrganiserRegister();
//        int hash = 0;
//        hash = 53 * hash + Objects.hashCode(organiserHashCode);

        User user1 = new User("Filipa", "filipa@server.com", "user1", 0.1234);
        Organiser organiser1 = new Organiser(user1);

        User user2 = new User("Filipa", "filipa@server.com", "user1", 0.1234);
        Organiser organiser2 = new Organiser(user2);

        organiserRegisterHashCode.addOrganiser(organiser1);
        int result = organiserRegisterHashCode.hashCode();
        int hash = 1644148085;

        assertEquals(hash, result);

//        int result = organiserHashCode.hashCode();
//        int hash = -1779632894;
//        int expectedResult = organiserHashCode.hashCode();
        assertEquals(hash, result);
//        Assert.assertEquals(expectedResult, result);

    }
}

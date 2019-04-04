/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.model;

import java.text.ParseException;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 *
 * @author Altran
 */
public class ExhibitionCentreTest {
    
    EventRegister ev = new EventRegister();
    
    public ExhibitionCentreTest() throws ParseException {
        ExhibitionCentre centre = new ExhibitionCentre(ev);
        
    }
    
    @Test
    public void exRegtoStringTest() {
        ExhibitionCentre ec = new ExhibitionCentre();
        System.out.println("Exhibiotion Centre test : " + ec.toString());
        ec.getUserOnline();
        
        assertNotNull(ec.toString());
        
    }
    
    @Test
    public void getUserOnLineTest() {
        ExhibitionCentre ec = new ExhibitionCentre();
        System.out.println("Exhibiotion Centre test : " + ec.toString());
        User userOnLine = new User("manuel", "mjdg111@hotmail.com", "garnel", 123, Role.ATENDEE);
        ec.setUserOnline(userOnLine);
        ec.getUserOnline();
        
        assertNotNull(ec.getUserOnline());
        
    }
    
    @Test
    public void getEventRegisterTest() {
        ExhibitionCentre ec = new ExhibitionCentre();
        EventRegister ev = new EventRegister();
        ec.setEventRegister(ev);
        ec.getEventRegister();
        
        assertNotNull(ec.getEventRegister());
        
    }
    
    @Test
    public void getUsertRegisterTest() {
        ExhibitionCentre ec = new ExhibitionCentre();
        UserRegister ev = new UserRegister();
        ec.setUserRegister(ev);
        ec.getUserRegister();
        
        assertNotNull(ec.getUserRegister());
        
    }
}

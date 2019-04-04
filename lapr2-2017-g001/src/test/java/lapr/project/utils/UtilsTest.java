/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import lapr.project.model.Role;
import lapr.project.model.User;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Manuel
 */
public class UtilsTest {
        
    @Test
    public void testChangeFormat(){
        System.out.println("checkFormat");
        Date startDate = new Date();        
        String startDateString = "2018-07-07";
        Date expResult= new Date();

        Calendar calendar = Calendar.getInstance();

        calendar.set( Calendar.HOUR_OF_DAY, 0 );
        calendar.set( Calendar.MINUTE, 0 );
        calendar.set( Calendar.SECOND, 0 );
        calendar.set( Calendar.MILLISECOND, 0 );

        calendar.set( Calendar.DAY_OF_MONTH, 7 );
        calendar.set( Calendar.YEAR, 2018 );
        //6 beacuse it starts at zero
        calendar.set( Calendar.MONTH, 6 );
        expResult=calendar.getTime();
        
        Date result = Utils.changeFormat(startDate, startDateString);
        assertEquals(result, expResult);
    }
    
    @Test
    public void testChangeFormatNull(){
        System.out.println("checkFormatNull");
        Date startDate = new Date();        
        String startDateString = "2070/23/43";
        Date expResult= new Date();

        expResult=null;
        
        Date result = Utils.changeFormat(startDate, startDateString);
        assertEquals(result, expResult);
    }
    
    /**
     * Test of writeLog method, of class Utils.
     */
    @Test
    public void testWriteLogNull() {
        System.out.println("writeLogNull");
        String log = null;
        boolean result = Utils.writeLog(log, "logs_test");
        assertTrue(result);
    }

    /**
     * Test of getCopia method, of class Utils.
     */
    @Test
    public void testGetCopia() {
        System.out.println("getCopia");
        
        User user1 = new User("manuel", "mjdg111@hotmail.com", "garnel", 123, Role.ATENDEE);
        User user2 = new User("jose", "mail2@hotmail.com", "jo", 123 , Role.ATENDEE);
        
        List<User> userList = new ArrayList<>();
        List<User> expResult = new ArrayList<>();
        
        userList.add(user1);
        userList.add(user2);
        
        expResult.add(user1);
        expResult.add(user2);
        
        List<User> result = Utils.getCopia(userList);
        assertEquals(expResult, result);
    }
}

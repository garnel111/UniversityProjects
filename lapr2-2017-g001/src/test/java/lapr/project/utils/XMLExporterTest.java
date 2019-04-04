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
import lapr.project.model.Application;
import lapr.project.model.ApplicationRegister;
import lapr.project.model.ApplicationState;
import lapr.project.model.Decision;
import lapr.project.model.Distance;
import lapr.project.model.Event;
import lapr.project.model.EventRegister;
import lapr.project.model.EventState;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Keyword;
import lapr.project.model.Organiser;
import lapr.project.model.OrganiserRegister;
import lapr.project.model.Review;
import lapr.project.model.Role;
import lapr.project.model.StaffMember;
import lapr.project.model.StaffRegister;
import lapr.project.model.Stand;
import lapr.project.model.StandRegister;
import lapr.project.model.User;
import lapr.project.model.UserRegister;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
 * @author MariaJoão
 */
public class XMLExporterTest {
    
    public XMLExporterTest() {
    }
    
    /**
     * Test of isEmpty method, of class XMLExporter.
     */
    public void testIsEmpty() {
        System.out.println("isEmpty");
     }

    /**
     * Test of exportAllDataToFile method, of class XMLExporter.
     */
    @Test
    public void testExportAllDataToFile() throws Exception {
        System.out.println("exportAllDataToFile");
        
        ExhibitionCentre exCentre= new ExhibitionCentre();
        EventRegister er= new EventRegister();
        UserRegister ur= new UserRegister();
        Event event= new Event();
        event.setTitle("event1");
        
        StandRegister sr= new StandRegister();
        Stand s= new Stand();
        s.setArea(100);
        s.setDescription("stand1");
        Distance d= new Distance();
        d.setDescription("distance1");
        d.setValue(0.1);
        List<Distance> distanceList= new ArrayList<>();
        distanceList.add(d);
        s.setDistanceList(distanceList);
        sr.addStand(s);
        event.setStandRegister(sr);
        event.setRooms(5);
        event.setPlace("place1");
        Date date1= new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        calendar.set( Calendar.HOUR_OF_DAY, 0 );
        calendar.set( Calendar.MINUTE, 0 );
        calendar.set( Calendar.SECOND, 0 );
        calendar.set( Calendar.MILLISECOND, 0 );
        date1= calendar.getTime();
        event.setStartDate(date1);
        event.setEndDate(date1);      
        User u1= new User();
        u1.setEmail("email@gmail.com");
        u1.setName("name");
        u1.setRole(Role.EMPLOYEE);
        u1.setUsername("user1");
        u1.setPassword(PasswordEncryption.encryptPassword("01230123"));
                
        StaffRegister str= new StaffRegister();
        StaffMember sm= new StaffMember();
        sm.setUser(u1);
        str.addStaffMember(sm);        
        event.setStaffRegister(str);

        OrganiserRegister or= new OrganiserRegister();
        Organiser o= new Organiser();
        o.setOrganiser(u1);
        or.getOrganiserList().add(o);        
        event.setOrganisersRegister(or);
        
        ApplicationRegister ar= new ApplicationRegister();
        Application app= new Application();
        app.setNameOfCompany("Company1");
        app.setNumberInvites(3);
        app.setPhoneNumber(911911911);
        app.setVatNumber(123456789);
        app.setBoothArea(0.01);
        app.setDescription("app1");
        app.setState(ApplicationState.ACCEPTED);
        app.setNumberInvites(3);
        Keyword k= new Keyword();
        k.setValue("k1");
        app.addKeyword(k);
        List<Review> revList= new ArrayList<>();
        Review r= new Review();
        r.setEventAdequacy(0);
        r.setInviteAdequacy(1);
        r.setRecommendation(2);
        r.setStaffTopicKnowledge(0);
        r.setText("review 1");
        r.setAssignedStaffMember(sm);
        r.setDecision(Decision.ACCEPTED);
        revList.add(r);
        app.setListReview(revList);
        ar.addApplication(app);
        event.setApplicationRegister(ar);
        event.setEventState(EventState.CREATED);
        
        er.addEvent(event);
        ur.addUser(u1);
        exCentre.setEventRegister(er);
        exCentre.setUserRegister(ur);
        
        XMLExporter.exportAllDataToFile(exCentre, "./src/main/resources/exhibition1_test.xml");
        ExhibitionCentre centre2 = XMLDecoder.readExhibitionCentreFromFile("./src/main/resources/exhibition1_test.xml", new ExhibitionCentre());

        
        assertEquals(exCentre, centre2);
        assertEquals(exCentre.getEventRegister().getEvent(0).getTitle(), centre2.getEventRegister().getEvent(0).getTitle());
    }
    
}

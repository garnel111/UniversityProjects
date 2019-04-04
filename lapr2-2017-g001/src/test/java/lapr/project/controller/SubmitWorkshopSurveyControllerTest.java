/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Application;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Workshop;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


/**
 *
 * @author MariaJoão
 */
public class SubmitWorkshopSurveyControllerTest {
    
    public SubmitWorkshopSurveyControllerTest() {
    }
    

    /**
     * Test of getEvents method, of class SubmitWorkshopSurveyController.
     */
    @Test
    public void testGetEvents() {
        System.out.println("getEvents");
        ExhibitionCentre c= new ExhibitionCentre();
        SubmitWorkshopSurveyController instance = new SubmitWorkshopSurveyController(c);

        Event e= new Event();
        e.setTitle("event");
        Event e2= new Event();
        e2.setTitle("event2");
        
        c.getEventRegister().addEvent(e);
        c.getEventRegister().addEvent(e2);

        List<Event> result= instance.getEvents();
        List<Event>expResult= c.getEventRegister().getEventList();
        
        assertEquals(result, expResult);
    }

    /**
     * Test of setEvent method, of class SubmitWorkshopSurveyController.
     */
    @Test
    public void testSetEvent() {
        System.out.println("setEvent");
        ExhibitionCentre c= new ExhibitionCentre();
        SubmitWorkshopSurveyController instance = new SubmitWorkshopSurveyController(c);
        Event expResult = new Event();
        expResult.setTitle("exp");
        instance.setEvent(expResult);
        Event result = instance.getEvent();
        assertEquals(expResult, result);
    }

    /**
     * Test of listaWorkshopsOfAcceptedApplications method, of class SubmitWorkshopSurveyController.
     */
    @Test
    public void testListaWorkshopsOfAcceptedApplications() {
        System.out.println("listaWorkshopsOfAcceptedApplications");
        ExhibitionCentre c= new ExhibitionCentre();
        SubmitWorkshopSurveyController instance = new SubmitWorkshopSurveyController(c);

        Event e= new Event();
        Application a= new Application();
        e.setTitle("event");
        a.setDescription("app 1");
        
        Workshop w1= new Workshop();
        w1.setDescription("w1");
        Workshop w2= new Workshop();
        w2.setDescription("w2");
        
        
        List<Workshop> expResult = new ArrayList<>();
        expResult.add(w1);
        expResult.add(w2);
        a.setWorkshopList(expResult);
        
        e.getApplicationRegister().addApplication(a);
        instance.setEvent(e);
        
        List<Workshop> result = instance.listaWorkshopsOfAcceptedApplications();
        assertEquals(expResult, result);

    }

    /**
     * Test of registerAnswers method, of class SubmitWorkshopSurveyController.
     */
    @Test
    public void testRegisterAnswers() {
        ExhibitionCentre c= new ExhibitionCentre();
        SubmitWorkshopSurveyController instance = new SubmitWorkshopSurveyController(c);

        Event e= new Event();
        Application a= new Application();
        e.setTitle("event");
        a.setDescription("app 1");
        
        Workshop w1= new Workshop();
        w1.setDescription("w1");
        Workshop w2= new Workshop();
        w2.setDescription("w2");
               
        List<Boolean> answers= new ArrayList<>();
        answers.add(Boolean.TRUE);
        answers.add(Boolean.FALSE);

        List<Boolean> answers_w1= new ArrayList<>();
        answers_w1.add(Boolean.TRUE);

        List<Boolean> answers_w2= new ArrayList<>();
        answers_w2.add(Boolean.FALSE);
        
        List<Workshop> expResult = new ArrayList<>();
        expResult.add(w1);
        expResult.add(w2);
        a.setWorkshopList(expResult);
        
        e.getApplicationRegister().addApplication(a);
        instance.setEvent(e);
        instance.registerAnswers(answers);
        
        assertEquals(answers_w1, w1.getWantToAttend());
        assertEquals(answers_w2, w2.getWantToAttend());
    }

    /**
     * Test of registerLog method, of class SubmitWorkshopSurveyController.
     */
    @Test
    public void testRegisterLog() {
        System.out.println("registerLog");
        ExhibitionCentre c= new ExhibitionCentre();
        SubmitWorkshopSurveyController instance = new SubmitWorkshopSurveyController(c);
        assertTrue(instance.registerLog());

    }
    
}

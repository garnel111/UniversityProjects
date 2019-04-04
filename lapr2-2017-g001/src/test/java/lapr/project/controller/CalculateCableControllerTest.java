/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lapr.project.model.Distance;
import lapr.project.model.Event;
import lapr.project.model.EventRegister;
import lapr.project.model.StandConnection;

import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Stand;
import lapr.project.model.StandRegister;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 *
 * @author JM
 */
public class CalculateCableControllerTest {

    /**
     * Test of getEventList method, of class CalculateCableController.
     */
    @Test
    public void testGetEventList() {
        System.out.println("getEventList");
        ExhibitionCentre centre = new ExhibitionCentre();
        Event evento1 = new Event();
        Event evento2 = new Event();
        EventRegister registo = new EventRegister();
        registo.addEvent(evento1);
        registo.addEvent(evento2);
        centre.setEventRegister(registo);
        CalculateCableController instance = new CalculateCableController(centre);
        List<Event> expResult = new ArrayList<>();
        expResult.add(evento1);
        expResult.add(evento2);
        List<Event> result = instance.getEventList();
        assertEquals(expResult, result);
    }
    

    /**
     * Test of eventExists method, of class CalculateCableController.
     */
    @Test
    public void testEventExists() {
        System.out.println("eventExists");
        ExhibitionCentre centre = new ExhibitionCentre();
        Event evento1 = new Event();
        evento1.setTitle("Evento de teste");
        EventRegister registo = new EventRegister();
        registo.addEvent(evento1);
        centre.setEventRegister(registo);
        String eventTitle = "Evento de teste";
        CalculateCableController instance = new CalculateCableController(centre);
        boolean expResult = true;
        boolean result = instance.eventExists(eventTitle);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of eventExists method, of class CalculateCableController.
     */
    @Test
    public void testEventExistsNot() {
        System.out.println("eventExists");
        ExhibitionCentre centre = new ExhibitionCentre();
        Event evento1 = new Event();
        evento1.setTitle("Evento de teste");
        EventRegister registo = new EventRegister();
        registo.addEvent(evento1);
        centre.setEventRegister(registo);
        String eventTitle = "Evento que não existe";
        CalculateCableController instance = new CalculateCableController(centre);
        boolean expResult = false;
        boolean result = instance.eventExists(eventTitle);
        assertEquals(expResult, result);
    }

    /**
     * Test of calcPath method, of class CalculateCableController.
     */
    @Test
    public void testCalcPath() {
        System.out.println("calcPath");
        //Arrange
        Event evento = new Event();
        evento.setTitle("evento");
        Stand s1 = new Stand("s1");
        List<Distance> distanceList = new ArrayList<>();
        Distance d1 = new Distance("s2", 13.3);
        Distance d2 = new Distance("s3", 3.3);
        distanceList.add(d1);
        distanceList.add(d2);
        s1.setDistanceList(distanceList);
        Stand s2 = new Stand("s2");
        List<Distance> distanceList2 = new ArrayList<>();
        Distance d3 = new Distance("s3", 5.5);
        distanceList2.add(d3);
        s2.setDistanceList(distanceList2);
        Stand s3 = new Stand("s3");
        List<Stand> stands = new ArrayList<>();
        stands.add(s1);
        stands.add(s2);
        stands.add(s3);
        StandRegister standRegister = new StandRegister(stands);
        evento.setStandRegister(standRegister);
        ExhibitionCentre centre = new ExhibitionCentre();
        EventRegister registo = new EventRegister();
        registo.addEvent(evento);
        centre.setEventRegister(registo);
        String eventTitle = "evento";
        CalculateCableController instance = new CalculateCableController(centre);
        ArrayList<StandConnection> expResult = new ArrayList<>();
        StandConnection c1 = new StandConnection("s1", "s3", 3.3);
        StandConnection c2 = new StandConnection("s2", "s3", 5.5);
        expResult.add(c1);
        expResult.add(c2);
        //Act
        List<StandConnection> result = instance.calcPath(eventTitle);
        //Assert
        assertEquals(expResult, result);
    }
    
    /**
     * Test of calcPath method, of class CalculateCableController.
     */
    @Test
    public void testCalcPathNoStands() {
        System.out.println("calcPath");
        Event evento = new Event();
        evento.setTitle("evento");
        ExhibitionCentre centre = new ExhibitionCentre();
        EventRegister registo = new EventRegister();
        registo.addEvent(evento);
        centre.setEventRegister(registo);
        String eventTitle = "evento";
        CalculateCableController instance = new CalculateCableController(centre);
        List<StandConnection> expResult = Collections.emptyList();
        List<StandConnection> result = instance.calcPath(eventTitle);
        assertEquals(expResult, result);
    }

    /**
     * Test of calcLength method, of class CalculateCableController.
     */
    @Test
    public void testCalcLengthNoStands() {
        System.out.println("calcLength");
        Event evento = new Event();
        evento.setTitle("evento");
        ExhibitionCentre centre = new ExhibitionCentre();
        EventRegister registo = new EventRegister();
        registo.addEvent(evento);
        centre.setEventRegister(registo);
        String eventTitle = "evento";
        CalculateCableController instance = new CalculateCableController(centre);
        double expResult = 0.0;
        double result = instance.calcLength(eventTitle);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of calcLength method, of class CalculateCableController.
     */
    @Test
    public void testCalcLength() {
        System.out.println("calcLength");
        //Arrange
        Event evento = new Event();
        evento.setTitle("evento");
        Stand s1 = new Stand("s1");
        List<Distance> distanceList = new ArrayList<>();
        Distance d1 = new Distance("s2", 13.3);
        Distance d2 = new Distance("s3", 3.3);
        distanceList.add(d1);
        distanceList.add(d2);
        s1.setDistanceList(distanceList);
        Stand s2 = new Stand("s2");
        List<Distance> distanceList2 = new ArrayList<>();
        Distance d3 = new Distance("s3", 5.5);
        distanceList2.add(d3);
        s2.setDistanceList(distanceList2);
        Stand s3 = new Stand("s3");
        List<Stand> stands = new ArrayList<>();
        stands.add(s1);
        stands.add(s2);
        stands.add(s3);
        StandRegister standRegister = new StandRegister(stands);
        evento.setStandRegister(standRegister);
        ExhibitionCentre centre = new ExhibitionCentre();
        EventRegister registo = new EventRegister();
        registo.addEvent(evento);
        centre.setEventRegister(registo);
        String eventTitle = "evento";
        CalculateCableController instance = new CalculateCableController(centre);
        //Act
        double expResult = 8.8;
        double result = instance.calcLength(eventTitle);

        assertEquals(expResult, result);
    }

    /**
     * Test of findEvent method, of class CalculateCableController.
     */
    @Test
    public void testFindEvent() {
        System.out.println("findEvent");
        Event evento1 = new Event();
        evento1.setTitle("evento 1");
        String eventTitle = "evento 1";
        ExhibitionCentre centre = new ExhibitionCentre();
        EventRegister registo = new EventRegister();
        registo.addEvent(evento1);
        CalculateCableController instance = new CalculateCableController(centre);
        centre.setEventRegister(registo);
        Event expResult = evento1;
        Event result = instance.findEvent(eventTitle);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of findEvent method, of class CalculateCableController.
     */
    @Test
    public void testFindEventNotEqual() {
        System.out.println("findEvent");
        Event evento1 = new Event();
        Event evento0 = new Event();
        evento1.setTitle("evento 1");
        String eventTitle = "evento 1";
        ExhibitionCentre centre = new ExhibitionCentre();
        EventRegister registo = new EventRegister();
        CalculateCableController instance = new CalculateCableController(centre);
        centre.setEventRegister(registo);
        Event expResult = null;//evento0;
        Event result = instance.findEvent(eventTitle);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasStands method, of class CalculateCableController.
     */
    @Test
    public void testHasStands() {
        System.out.println("hasStands");
        Event event = new Event();
        Stand stand1 = new Stand("s1", 10.7);
        StandRegister standRegister = new StandRegister();
        standRegister.addStand(stand1);
        event.setStandRegister(standRegister);
        ExhibitionCentre centre = new ExhibitionCentre();
        CalculateCableController instance = new CalculateCableController(centre);
        EventRegister registo = new EventRegister();
        registo.addEvent(event);
        centre.setEventRegister(registo);
        boolean expResult = true;
        boolean result = instance.hasStands(event);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of hasStands method, of class CalculateCableController.
     */
    @Test
    public void testHasStandsNull() {
        System.out.println("hasStands");
        Event event = new Event();
        ExhibitionCentre centre = new ExhibitionCentre();
        CalculateCableController instance = new CalculateCableController(centre);
        EventRegister registo = new EventRegister();
        registo.addEvent(event);
        centre.setEventRegister(registo);
        boolean expResult = false;
        boolean result = instance.hasStands(event);
        assertEquals(expResult, result);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.Event;
import lapr.project.model.EventState;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Organiser;
import lapr.project.model.OrganiserRegister;
import lapr.project.model.Role;
import lapr.project.model.User;
import lapr.project.ui.MainMenu;
import lapr.project.ui.UtilsUI;
import lapr.project.utils.Utils;
import lapr.project.utils.XMLDecoder;
import org.xml.sax.SAXException;

/**
 *
 * @author MariaJoão
 */
public class CreateEventController {

    private final ExhibitionCentre exhibitionCentre;
    private Event event;
    private OrganiserRegister or;
    
    public CreateEventController(ExhibitionCentre exhibitionCentre) {
        this.exhibitionCentre=exhibitionCentre;
        this.or= new OrganiserRegister();
    }
        
    public List<User> getUsersAvailable(){
        List<User> ret= new ArrayList<>();
        for (User u : this.exhibitionCentre.getUserRegister().getUserList()) {
            if(u.getRole().equals(Role.EMPLOYEE)){
                ret.add(u);
                
            }
        }
        return ret;
    }
    

    public boolean compareDates(Date date1, Date date2) {

        int hours = 0, minutes=0, seconds=0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        calendar.set( Calendar.HOUR_OF_DAY, hours );
        calendar.set( Calendar.MINUTE, minutes );
        calendar.set( Calendar.SECOND, seconds );
        date1= calendar.getTime();
        if(date1.after(date2)){
            return false;
        }
        return true;   
    }

    public Organiser createOrganiser(List<User> usersAvailable, int userPos) {
        Organiser o= new Organiser();
        User u= usersAvailable.get(userPos-1);
        o.setOrganiser(u);
        return o;
    }

    public boolean addOrganiser(Organiser o) {
        return this.or.addOrganiser(o);
    }

    public void setData(String title, String description, Date startDate, Date endDate, String place) {
        Event e= new Event();
        e.setDescription(description);
        e.setTitle(title);
        e.setEndDate(endDate);
        e.setStartDate(startDate);
        e.setOrganisersRegister(this.or);
        e.setPlace(place);
        e.setEventState(EventState.CREATED);
        this.event=e;
    }

    public void registerEvent() {
        this.exhibitionCentre.getEventRegister().registerEvent(this.event);
    }

    /**
     * @return the event
     */
    public Event getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(Event event) {
        this.event = event;
    }

    /**
     * @return the or
     */
    public OrganiserRegister getOr() {
        return or;
    }

    /**
     * @param or the or to set
     */
    public void setOr(OrganiserRegister or) {
        this.or = or;
    }
 
    public boolean getEventFromFile(String filepath){
        try{
            System.out.println(filepath);    
            if(XMLDecoder.readEventFromFile(filepath, this.exhibitionCentre,0, null)==null){
                return false;
               
            }
           } catch (ParserConfigurationException | IOException | SAXException e) {
            UtilsUI.printError("FAILED TO LOAD FILE : "+e.getMessage());
            return false;

           }
        return true;
        
    }

    public void registerLog() {
        Utils.writeLog(this.exhibitionCentre.getUserOnline().getUsername()+" created a new event called '"+event.getTitle()+"';","logs");
    }
    
}

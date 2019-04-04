/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.User;
import lapr.project.utils.StaffRating;

/**
 *
 * @author JM
 */
public class MeanDeviationController {
    
    private ExhibitionCentre exhibitionCentre;
    private StaffRating rating;
    
    public MeanDeviationController(ExhibitionCentre exhibitionCentre) {
        this.exhibitionCentre = exhibitionCentre;
        this.rating = new StaffRating(exhibitionCentre);
    }
    
    /**
     * Method to get the staffList
     * @return Return the staffList
     */
    public List<User> getStaffList() {
        return exhibitionCentre.getAllStaffMembers();
    }
    
    /**
     * Method to calculate the mean rating
     * @param username Username of the StaffMember
     * @return mean rating double
     */
    public double calcMeanRating(String username) {
        User user = findUser(username);
        
        return user != null ? rating.meanRating(user) : 0;
    }
    
    /**
     * Method to calc the mean deviation
     * @param username Username of StaffMember
     * @param eventTitle Title of the Event
     * @return returns mean deviation double
     */
    public double calcMeanDev(String username, String eventTitle) {
        User user = findUser(username);
        Event event = findEvent(eventTitle);
        
        return rating.meanDeviation(user, event);
    }
    
    /**
     * Method to find an Event by title
     * @param title Title of the Event
     * @return Return the Event object
     */
    public Event findEvent(String title) {
        for (Event e : exhibitionCentre.getEventRegister().getEventList()) {
            if (e.getTitle().equals(title)) {
                return e;
            }
        }
        return null;
    }
    
    /**
     * Method to find an User
     * @param username Username of User
     * @return return the User object
     */
    public User findUser(String username) {
        for (User u : exhibitionCentre.getUserRegister().getUserList()) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }
    
    
    /**
     * Method to check if the StaffMember exists
     * @param username Username of the StaffMember
     * @return boolean value
     */
    public boolean staffExists(String username) {
        if (getStaffList().stream().anyMatch((u) -> (u.getUsername().equals(username)))) {
            return true;
        }
        return false;
    }
    
    /**
     * Method to check if the event exists, by username of StaffMember
     * @param title Title of the event
     * @param username Username of the StaffMember
     * @return 
     */
    public boolean eventExists(String title, String username) {
        if (getEvents(username).stream().anyMatch((u) -> (u.getTitle().equals(title)))) {
            return true;
        }
        return false;
    }

    /**
     * Method to get the Events by StaffMember username
     * @param username Username of the StaffMember
     * @return List with the filtered events
     */
    public List<Event> getEvents(String username) {
        User user = findUser(username);
        List<Event> original = exhibitionCentre.getEventRegister().getEventList();
        List<Event> filtered = new ArrayList<>();
        
        for (Event ev : original) {
            if (ev.getStaffRegister().getStaffList().stream().anyMatch((e) -> (e.getStaff().equals(user)))){
                filtered.add(ev);
            }
        }
        return filtered;
    }
}

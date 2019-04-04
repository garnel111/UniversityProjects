/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Application;
import lapr.project.model.ApplicationRegister;
import lapr.project.model.ApplicationState;
import lapr.project.model.Event;
import lapr.project.model.EventRegister;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Organiser;
import lapr.project.model.Stand;
import lapr.project.model.User;

/**
 *
 * @author Manuel Garnel
 */
public class AssignStandToApplicationController {
    
   
    private Event event;
    private Stand stand;
    private Application application;
    private ExhibitionCentre exhibitionCentre;
    private EventRegister eventRegister;
    private Organiser organiser;
    private User user;
    
    String accepted = "ACCEPTED";
    
    ApplicationRegister appRegister = new ApplicationRegister();
    
    public AssignStandToApplicationController(Event event, ExhibitionCentre exhibitionCentre) {
        this.event = event;
        this.exhibitionCentre = exhibitionCentre;
        this.user = exhibitionCentre.getUserOnline();
        
    }
    
    public AssignStandToApplicationController(Event event) {
        this.event = event;
    }
    
    public AssignStandToApplicationController() {
        
    }
    
    public void matchsApplicationOnEventListByOrganiserWithStandList() {
        
        eventRegister = exhibitionCentre.getEventRegister();
        List<Event> eventList = eventRegister.getEventListByOrganiser(this.user);
        filteringList(eventList, user);
        
    }
    
    private List<Application> filteringList(List<Event> event, User organiser) {
        List<Application> applicationsAccepted = new ArrayList<>();
        int i = 0;
        for (Event eventItem : event) {
            for (Application application1 : eventItem.getApplicationRegister().getApplicationList()) {
                if (application1.getState().equals(ApplicationState.ACCEPTED) && i < eventItem.getStandRegister().getStandList().size()) {
                    application1.setAssignedStand(eventItem.getStandRegister().getStandList().get(i));
                    i++;
                }
            }
            
        }
        return applicationsAccepted;
    }
    
}

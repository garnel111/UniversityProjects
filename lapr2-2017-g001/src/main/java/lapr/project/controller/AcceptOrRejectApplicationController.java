/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Application;
import lapr.project.model.ApplicationState;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Role;

/**
 *
 * @author MariaJoão
 */
public class AcceptOrRejectApplicationController {
    ExhibitionCentre centre;
    Event event;
    private Application application;
    public AcceptOrRejectApplicationController(ExhibitionCentre centre) {
        this.centre=centre;
    }

    public List<Event> getEventsFromUser() {
        if(this.centre.getUserOnline().getRole().equals(Role.EVENT_MANAGER)){
            return this.centre.getEventRegister().getEventList();
        }else{
            return this.centre.getEventRegister().getEventListByOrganiser(this.centre.getUserOnline());
        }
        
    }
    public void setEvent(int index){
        this.event=getEventsFromUser().get(index);
    }
    public void setApplication(int index){
        this.application=getApplicationsFromEvent().get(index);
    }
    /**
     * @return the event
     */
    public Event getEvent() {
        return event;
    }

    public List<Application> getApplicationsFromEvent() {
        List<Application> ret= new ArrayList<>();
        event.getApplicationRegister().getApplicationList().stream().filter((a) -> (a.getState().equals(ApplicationState.IN_EVALUALTION))).forEachOrdered((a) -> {
            ret.add(a);
        });
        return ret;
    }

    public boolean registerDecision(String decision) {
        switch(decision){
            case "ACCEPTED":
                for (Event e : this.centre.getEventRegister().getEventList()) {
                    for (Application a : e.getApplicationRegister().getApplicationList()) {
                        if(a.equals(this.getApplication())){
                            a.setState(ApplicationState.ACCEPTED);
                            return true; 
                        }
                    }
                }
  
             break;
            case "REJECTED":
                for (Event e : this.centre.getEventRegister().getEventList()) {
                    for (Application a : e.getApplicationRegister().getApplicationList()) {
                        if(a.equals(this.getApplication())){
                            a.setState(ApplicationState.REJECTED);
                            return true;
                        }
                    }
                }
            break;
        }
        
        return false;
    }

    /**
     * @return the application
     */
    public Application getApplication() {
        return application;
    }
    
}

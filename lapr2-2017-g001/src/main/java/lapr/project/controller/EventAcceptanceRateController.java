/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.Application;
import lapr.project.model.ApplicationState;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.utils.Utils;

/**
 *
 * @author MariaJoão
 */
public class EventAcceptanceRateController {
    ExhibitionCentre centre;
    private Event event;
    public EventAcceptanceRateController(ExhibitionCentre centre) {
        this.centre= centre;
        
    }

    public List<Event> getEvents() {
        return this.centre.getEventRegister().getEventList();
    }

    public void setEvent(int i) {
        this.event= getEvents().get(i);

    }
    public double acceptanceRate(){
        int aceites=0;
        int totais=0;
        for (Application a : getEvent().getApplicationRegister().getApplicationList()) {
            if (a.getState().equals(ApplicationState.ACCEPTED)) {
                aceites++;
            }
            totais++;
        }
        return totais !=0 ? ((double)aceites/totais)*100 : 0;
    }

    /**
     * @return the event
     */
    public Event getEvent() {
        return event;
    }

    public void registerLog() {
        Utils.writeLog(this.centre.getUserOnline().getUsername()+" calculated event's '"+event.getTitle()+"' aceptance rate","logs");
    }
    
    
}

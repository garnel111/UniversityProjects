/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import lapr.project.model.Event;
import lapr.project.model.EventState;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Organiser;
import lapr.project.model.User;
import lapr.project.utils.Utils;

/**
 *
 * @author André Silva
 */
public class StartSubmissionPeriodController {
    
    private ExhibitionCentre exhibitionCentre;
    private List<Event> listEvent;
    private Event e;
    
    public StartSubmissionPeriodController(ExhibitionCentre exhibitionCentre) {
        this.exhibitionCentre = exhibitionCentre;
        this.listEvent = new ArrayList<>();
        this.e = new Event();
    }
    
    /**
     *
     * @param user
     * @return List<Event>
     */
    public List<Event> findEventByOrganiserAndState(User user) {
        changeEventStateCreated();
        for (Event e : this.exhibitionCentre.getEventRegister().getEventList()) {
            for (Organiser o : e.getOrganiserRegister().getOrganiserList()) {
                if (o.getOrganiser().getUsername().equals(user.getUsername()) && e.getEventState().equals(EventState.READY_FOR_APPLICATION)) {
                    listEvent.add(e);
                }
            }
        }
        return listEvent;
    }
    
    /**
     *
     * @param indice
     * @return boolean
     */
    public boolean changeStateEventToSubmission(int indice) {
        Event event = listEvent.get(indice);
        event.setEventState(EventState.OPEN_APPLICATION);
        e.setTitle(event.getTitle());
        Date dateEndApplications = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateEndApplications);
        calendar.add(Calendar.DATE, event.getDaysApplication());
        dateEndApplications = calendar.getTime();
        event.setDateEndApplications(dateEndApplications);
        return event.isOpenApplication();
    }
    
    /**
     *
     */
    public void changeEventStateCreated() {
        for (Event e : exhibitionCentre.getEventRegister().getEventList()) {
            if (e.isCreated()) {
                e.changeToReadyForApplication();
            }
        }
    }
    
    /**
     *
     */
    public void registerLog() {
        Utils.writeLog(this.exhibitionCentre.getUserOnline().getUsername() + " Started Submission Application Period '" + e.getTitle() + "';", "logs");
    }
    
}

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
import lapr.project.utils.Utils;

/**
 *
 * @author MariaJoão
 */
public class SubmitWorkshopSurveyController {
    private final ExhibitionCentre centre;
    private Event event;
    private final List<Application> appsOfWorkshops;
    
    public SubmitWorkshopSurveyController(ExhibitionCentre centre) {
        this.centre= centre;
        this.appsOfWorkshops= new ArrayList<>();
    }

    public List<Event> getEvents() {
        return centre.getEventRegister().getEventList();
    }

    /**
     * @return the event
     */
    public Event getEvent() {
        return event;
    }

    /**
     * @param index
     */
    public void setEvent(int index) {
        this.setEvent(getEvents().get(index));
    }

    public List<Workshop> listaWorkshopsOfAcceptedApplications() {
        List<Workshop> list= new ArrayList<>();
        this.event.getApplicationRegister().getApplicationList().forEach((a) -> {
            a.getWorkshopList().stream().map((w) -> {
                //if(a.getState().equals(ApplicationState.ACCEPTED)){
                list.add(w);
                return w;
            }).forEachOrdered((_item) -> {
                this.appsOfWorkshops.add(a);
                //}
            });
        });
        return list;
    }

    public void registerAnswers(List<Boolean> answers) {
            int i=0;
            for (Application a : this.event.getApplicationRegister().getApplicationList()) {
                for (Workshop w : a.getWorkshopList()) {
                   //if(a.getState().equals(ApplicationState.ACCEPTED)){
                       w.addAtendeeDecision(answers.get(i));
                       i++;
                   //}
               }
            }
    }

    public boolean registerLog() {

        return Utils.writeLog("An anonymous user took a survey about workshops", "logs");
    
    }   

    /**
     * @param event the event to set
     */
    public void setEvent(Event event) {
        this.event = event;
    }
}

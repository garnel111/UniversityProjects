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
import lapr.project.model.EventState;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Keyword;
import lapr.project.model.Workshop;
import lapr.project.utils.Utils;

/**
 *
 * @author MariaJoão
 */
public class SubmitApplicationToEventController {
    
    private final Application application;
    private final ExhibitionCentre centre;
    private Event event;
    
    public SubmitApplicationToEventController(ExhibitionCentre centre) {
        this.application = new Application();
        this.centre = centre;
    }
    
    public List<Event> getEventsReadyForApplications() {
        List<Event> list = new ArrayList<>();
        for (Event e : centre.getEventRegister().getEventList()) {
            if(e.getEventState().equals(EventState.OPEN_APPLICATION)){
            list.add(e);
            }
        }
        return list;
    }
    
    public void registerApplication() {
        this.getEvent().getApplicationRegister().addApplication(this.application);
    }
    
    public void setEvent(int n) {
        this.event = getEventsReadyForApplications().get(n);
    }
    
    public void registerLog() {
        Utils.writeLog(this.centre.getUserOnline().getUsername() + " submited application '" + this.application.getDescription() + "' to event '" + this.getEvent().getTitle() + "';", "logs");
    }
    
    public boolean validatePhoneNumber(int phoneNumber) {
        int length = (int) (Math.log10(phoneNumber) + 1);
        if (length != 9) {
            return false;
        }
        return true;
    }
    
    /**
     * @return the event
     */
    public Event getEvent() {
        return event;
    }
    
    public void setData(String description, int nInvites, List<String> keywords, double area, String companyName, int phoneNumber, int vatNumber, List<Workshop> workshop_list) {
        List<Keyword> list = new ArrayList<>();
        this.application.setDescription(description);
        this.application.setNumberInvites(nInvites);
        keywords.stream().map((keyword) -> {
            Keyword k = new Keyword();
            k.setValue(keyword);
            return k;
        }).forEachOrdered((k) -> {
            list.add(k);
        });
        this.application.setKeywordList(list);
        this.application.setNameOfCompany(companyName);
        this.application.setPhoneNumber(phoneNumber);
        this.application.setVatNumber(vatNumber);
        this.application.setBoothArea(area);
        this.application.setWorkshopList(workshop_list);
        this.application.setState(ApplicationState.CREATED);
        this.application.setUserThatSubmited(this.centre.getUserOnline());
        
    }
    
}

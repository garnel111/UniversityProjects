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
import lapr.project.model.StaffMember;
import lapr.project.utils.Utils;

/**
 *
 * @author MariaJoão
 */
public class AssignStaffMemberToReviewController {
    
    private ExhibitionCentre centre;
    private Event event;
    private Application application;
    private StaffMember staff;
    
    public AssignStaffMemberToReviewController(ExhibitionCentre centre) {
        this.centre=centre;
    }

    public List<Event> getEventsFromOrganiser() {

        return this.centre.getEventRegister().getEventListByOrganiser(this.centre.getUserOnline());
    
    }

    /**
     * @return the event
     */
    public Event getEvent() {
        return event;
    }


    public void setEvent(int index) {
        this.event= getEventsFromOrganiser().get(index);
    }

    /**
     * @return the application
     */
    public Application getApplication() {
        return application;
    }

    public void setApplication(int index) {
        this.application =  getApplicationsFromEvent().get(index);
    }

    public List<Application> getApplicationsFromEvent() {
        List<Application> ret= new ArrayList<>();
        this.event.getApplicationRegister().getApplicationList().stream().filter((application1) -> (application1.getState().equals(ApplicationState.CREATED))).forEachOrdered((application1) -> {
            ret.add(application1);
        });
        return ret;
    }

    public List<StaffMember> getStaffMembersFromEvent() {
        return this.event.getStaffRegister().getStaffList();
    }

    /**
     * @return the staff
     */
    public StaffMember getStaff() {
        return staff;
    }

    public void setStaff(int index) {
        this.staff = getStaffMembersFromEvent().get(index);
    }

    public void assignMember() {

        this.centre.getEventRegister().getEventList().forEach((Event e) -> {
            e.getStaffRegister().getStaffList().stream().filter((sm) -> (sm.equals(AssignStaffMemberToReviewController.this.staff))).forEachOrdered((sm) -> {
                sm.getReviewsAssigned().add(AssignStaffMemberToReviewController.this.application.getDescription());
            });
        });
        for (Event event1 : this.centre.getEventRegister().getEventList()) {
            for (Application a : event1.getApplicationRegister().getApplicationList()) {
                if(a.equals(this.application)){
                    a.setState(ApplicationState.IN_EVALUALTION);
                }
            }
        }
    
    }

    public void registerLog() {

        Utils.writeLog("Organiser "+this.centre.getUserOnline().getUsername()+" assigned staff '"+this.staff.getStaff().getUsername()+" to review application "+this.application.getDescription(), "logs");
    }

    
}

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.controller;

import java.util.List;
import lapr.project.model.Event;
import lapr.project.model.EventRegister;
import lapr.project.model.ExhibitionCentre;

import lapr.project.model.StaffMember;
import lapr.project.model.StaffRegister;
import lapr.project.model.User;
import lapr.project.model.UserRegister;
import lapr.project.utils.Utils;

/**
 *
 * @author Manuel Garnel
 */
public class AssignStaffMemberController {
    
    private final ExhibitionCentre exhibitionCentre;
    private EventRegister evReg;
    
    private StaffRegister staffRegister;
    private UserRegister usersRegister;
    private Event event;
    
    public AssignStaffMemberController(ExhibitionCentre centre) {
        this.exhibitionCentre = centre;
        
    }
    
    public List<Event> getEventsListByOrganiser() {
        
        User organiserValidated = exhibitionCentre.getUserOnline();
        evReg = exhibitionCentre.getEventRegister();
        return evReg.getEventListByOrganiser(organiserValidated);
        
    }
    
    public void selectEvent(Event eventSelected) {
        this.event = eventSelected;
        this.staffRegister = this.event.createStaffMemberRegister();
    }
    
    public List<User> filterUserRegisterByNoOrganiserEventSelected() {
        
        usersRegister = exhibitionCentre.getUserRegister();
        return usersRegister.getAvailableUsersWithoutOrganisers(event.getOrganisersRegister().getOrganiserList());
        
    }
    
    public List<User> getAvailableUsers() {
        
        List<User> filterUserRegisterByNoOrganiserEventSelectedCopy = Utils.getCopia(filterUserRegisterByNoOrganiserEventSelected());
        
        return usersRegister.getAvailableUsersWithoutStaffMember(event.getStaffRegister().getStaffList(), filterUserRegisterByNoOrganiserEventSelectedCopy);
        
    }
    
    public StaffMember assignUser(List<User> availableUserToAssignToEvent, int userPos) {
        
        StaffMember staffMember = staffRegister.createStaffMember();
        User user = availableUserToAssignToEvent.get(userPos - 1);
        staffMember.setUser(user);
        return staffMember;
    }
    
    public boolean addStaffMemberToEvent(StaffMember staffMember) {
        
        return staffRegister.addStaffMember(staffMember);
        
    }
    
    public List<StaffMember> getStaffMemberList() {
        return staffRegister.getStaffList();
    }
    
    public void saveStaffMemberList() {
        for (Event e : this.exhibitionCentre.getEventRegister().getEventList()) {
            if(e.equals(this.event)){
                e.saveStaffRegister(staffRegister);
                
            }
        }
    }
    
    public void registerLog() {
        Utils.writeLog(this.exhibitionCentre.getUserOnline().getUsername() + " assigned staff members to event '" + event.getTitle() + "';", "logs");
    }
    
}

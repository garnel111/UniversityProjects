/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author MariaJoão
 */
public class Event implements Comparable<Event>, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private static final int CORDAYS_APPLICATION_OMISSION = 0;
    
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private String place;
    private OrganiserRegister organiserRegister;
    private StaffRegister staffRegister;
    private EventState eventState;
    private EventManager eventManager;
    private StandRegister standRegister;
    private ApplicationRegister applicationRegister;
    private Date dateEndApplications;
    private int rooms;
    private int daysApplication = CORDAYS_APPLICATION_OMISSION;
    
    public Event(String title, String description, Date startDate, Date endDate, String place, OrganiserRegister organiserRegister) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.place = place;
        this.organiserRegister = organiserRegister;
        this.eventState = EventState.CREATED;
    }
    
    public Event(OrganiserRegister organiserRegister) {
        this.organiserRegister = new OrganiserRegister();
        
    }
    
    public Event() {
        this.organiserRegister = new OrganiserRegister();
        this.staffRegister = new StaffRegister();
        this.applicationRegister= new ApplicationRegister();
        this.standRegister= new StandRegister();
    }
    
    public void changeToReadyForApplication() {
        if ((!this.staffRegister.isEmpty()) && (!this.organiserRegister.isEmpty()) && this.daysApplication != 0)
            this.eventState = EventState.READY_FOR_APPLICATION;
    }
    
    public boolean isCreated() {
        return this.eventState == EventState.CREATED;
    }
    
    public boolean isReadyForApplication() {
        return this.eventState == EventState.READY_FOR_APPLICATION;
    }
    
    public boolean isOpenApplication() {
        return this.eventState == EventState.OPEN_APPLICATION;
    }
    
    public boolean isInEvaluations() {
        return this.eventState == EventState.IN_EVALUATIONS;
    }
    
    public boolean isReadyForOpening() {
        return this.eventState == EventState.READY_FOR_OPENING;
    }
    
    public boolean isOpen() {
        return this.eventState == EventState.OPEN;
    }
    
    public boolean isClose() {
        return this.eventState == EventState.CLOSE;
    }
    
    /**
     * @return the Title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * @param Title the Title to set
     */
    public void setTitle(String Title) {
        this.title = Title;
    }
    
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }
    
    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }
    
    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    /**
     * @return the place
     */
    public String getPlace() {
        return place;
    }
    
    /**
     * @param place the place to set
     */
    public void setPlace(String place) {
        this.place = place;
    }
    
    /**
     * @return the organisersList
     */
    public OrganiserRegister getOrganisersRegister() {
        return organiserRegister;
    }
    
    /**
     * @param organisersList the organisersList to set
     */
    public void setOrganisersRegister(OrganiserRegister organisersList) {
        this.organiserRegister = organisersList;
    }
    
    public OrganiserRegister getOrganiserRegister() {
        return this.getOrganisersRegister();
    }
    
    public void addOrganiserRegister(OrganiserRegister organiserRegister) {
        this.organiserRegister = organiserRegister;
        
    }
    
    public void setEventState(EventState eventState) {
        this.eventState = eventState;
    }
    
    /**
     * @return the eventManager
     */
    public EventManager getEventManager() {
        return eventManager;
    }
    
    /**
     * @param eventManager the eventManager to set
     */
    public void setEventManager(EventManager eventManager) {
        this.eventManager = eventManager;
    }
    
    /**
     * @return the staffRegister
     */
    public StaffRegister getStaffRegister() {
        return staffRegister;
    }
    
    public void setStaffRegister(StaffRegister staffRegister) {
        this.staffRegister = staffRegister;
    }
    
    public EventState getEventState() {
        return eventState;
    }
    
    public int getDaysApplication() {
        return daysApplication;
    }
    
    public void setDaysApplication(int daysApplication) {
        this.daysApplication = daysApplication;
    }

    @Override
    public String toString() {
        return "Event{" + "title=" + title + ", description=" + description + ", startDate=" + startDate + ", endDate=" + endDate + ", place=" + place + ", organiserRegister=" + organiserRegister + ", staffRegister=" + staffRegister + ", eventState=" + eventState + ", eventManager=" + eventManager + ", standRegister=" + standRegister + ", applicationRegister=" + applicationRegister + ", dateEndApplications=" + dateEndApplications + ", rooms=" + rooms + ", daysApplication=" + daysApplication + '}';
    }
    
    /**
     *
     * @return String
     */
    public String toString2() {
        return String.format("Titulo: %s", this.title);
    }
    
    @Override
    public int compareTo(Event o) {
        return this.startDate.compareTo(o.startDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Event other = (Event) obj;
        if (this.rooms != other.rooms) {
            return false;
        }
        if (this.daysApplication != other.daysApplication) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.place, other.place)) {
            return false;
        }
        if (!Objects.equals(this.startDate, other.startDate)) {
            return false;
        }
        if (!Objects.equals(this.endDate, other.endDate)) {
            return false;
        }
        if (!Objects.equals(this.organiserRegister, other.organiserRegister)) {
            return false;
        }
        if (!Objects.equals(this.staffRegister, other.staffRegister)) {
            return false;
        }
        if (this.eventState != other.eventState) {
            return false;
        }
        if (!Objects.equals(this.eventManager, other.eventManager)) {
            return false;
        }
        if (!Objects.equals(this.standRegister, other.standRegister)) {
            return false;
        }
        if (!Objects.equals(this.applicationRegister, other.applicationRegister)) {
            return false;
        }
        return Objects.equals(this.dateEndApplications, other.dateEndApplications);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.title);
        hash = 53 * hash + Objects.hashCode(this.description);
        hash = 53 * hash + Objects.hashCode(this.startDate);
        hash = 53 * hash + Objects.hashCode(this.endDate);
        hash = 53 * hash + Objects.hashCode(this.place);
        hash = 53 * hash + Objects.hashCode(this.organiserRegister);
        hash = 53 * hash + Objects.hashCode(this.staffRegister);
        hash = 53 * hash + Objects.hashCode(this.eventState);
        hash = 53 * hash + Objects.hashCode(this.eventManager);
        hash = 53 * hash + Objects.hashCode(this.standRegister);
        hash = 53 * hash + Objects.hashCode(this.applicationRegister);
        hash = 53 * hash + Objects.hashCode(this.dateEndApplications);
        hash = 53 * hash + this.rooms;
        hash = 53 * hash + this.daysApplication;
        return hash;
    }
    
    /**
     * @return the standRegister
     */
    public StandRegister getStandRegister() {
        return standRegister;
    }
    
    /**
     * @param standRegister the standRegister to set
     */
    public void setStandRegister(StandRegister standRegister) {
        this.standRegister = standRegister;
    }
    
    /**
     * @return the applicationRegister
     */
    public ApplicationRegister getApplicationRegister() {
        return applicationRegister;
    }
    
    /**
     * @param applicationRegister the applicationRegister to set
     */
    public void setApplicationRegister(ApplicationRegister applicationRegister) {
        this.applicationRegister = applicationRegister;
    }
    
    public StaffRegister createStaffMemberRegister() {
        return new StaffRegister();
    }
    
    public void saveStaffRegister(StaffRegister staffRegister) {
        this.staffRegister.getStaffList().addAll(staffRegister.getStaffList());
    }
    
    /**
     * @return the dateEndApplications
     */
    public Date getDateEndApplications() {
        return dateEndApplications;
    }
    
    /**
     * @param dateEndApplications the dateEndApplications to set
     */
    public void setDateEndApplications(Date dateEndApplications) {
        this.dateEndApplications = dateEndApplications;
    }
    
    /**
     *
     * @param accepted Application State
     * @return List<Application>
     */
    public List<Application> getEventApplicationByState(ApplicationState accepted) {
        List<Application> acceptedApplicationList = new ArrayList<>();
        
        for (Application application : applicationRegister.getApplicationList()) {
            if (application.getState().equals(accepted)) {
                acceptedApplicationList.add(application);
            }
            
        }
        return acceptedApplicationList;
    }

    /**
     *
     * @return List<Application>
     */
    public List<Application> getEventApplicationByAcception() {
        List<Application> acceptedApplicationList = new ArrayList<>();
        
        for (Application application : applicationRegister.getApplicationList()) {
            if (application.getState().equals(ApplicationState.ACCEPTED)) {
                acceptedApplicationList.add(application);
                System.out.println("EnventApplicationBy State -event class"+application );
            }
            
        }
        return acceptedApplicationList;
    }

    /**
     * @return the rooms
     */
    public int getRooms() {
        return rooms;
    }

    /**
     * @param rooms the rooms to set
     */
    public void setRooms(int rooms) {
        this.rooms = rooms;
    }
    
}

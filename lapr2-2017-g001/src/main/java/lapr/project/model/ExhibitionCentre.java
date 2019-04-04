/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author MariaJoão
 */
public class ExhibitionCentre {
    
    private EventRegister eventRegister;
    private UserRegister userRegister;
    private User userOnline;

    
    public ExhibitionCentre(){
        this.eventRegister=new EventRegister();
        this.userRegister= new UserRegister(); 
        this.userOnline = new User();
        
    }
    
    public ExhibitionCentre(EventRegister eventRegister){
        this.eventRegister = eventRegister;
    }
            
    
    public ExhibitionCentre(EventRegister eventRegister, UserRegister userRegister){
        this.eventRegister=eventRegister;
        this.userRegister= userRegister; 
    }    
    /**
     * @return the eventRegister
     */
    public EventRegister getEventRegister() {
        return eventRegister;
    }

    /**
     * @param eventRegister the eventRegister to set
     */
    public void setEventRegister(EventRegister eventRegister) {
        this.eventRegister = eventRegister;
    }

    /**
     * @return the userRegister
     */
    public UserRegister getUserRegister() {
        return userRegister;
    }

    /**
     * @param userRegister the userRegister to set
     */
    public void setUserRegister(UserRegister userRegister) {
        this.userRegister = userRegister;
    }

 
    /**
     * @return the userOnline
     */
    public User getUserOnline() {
        return userOnline;
    }

    /**
     * @param userOnline the userOnline to set
     */
    public void setUserOnline(User userOnline) {
        this.userOnline = userOnline;
    }
    
     /**
     * Method to get all StaffMembers
     *
     * @return List with all the StaffMembers
     */
    public List<User> getAllStaffMembers() {
        List<User> staffList = new ArrayList<>();
        for (Event ev : this.eventRegister.getEventList()) {
            for (StaffMember st : ev.getStaffRegister().getStaffList()) {
                if (!staffList.contains(st.getStaff())) {
                    staffList.add(st.getStaff());
                }
            }
        }
        
        return staffList;
    }


    
    @Override
    public String toString() {
        return "ExhibitionCentre{" + "eventRegister=" + eventRegister + ", userRegister=" + userRegister + '}';

    }   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.eventRegister);
        hash = 67 * hash + Objects.hashCode(this.userRegister);
        return hash;
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
        final ExhibitionCentre other = (ExhibitionCentre) obj;
        if (!Objects.equals(this.eventRegister, other.eventRegister)) {
            return false;
        }
        return Objects.equals(this.userRegister, other.userRegister);
    }
 
    
}

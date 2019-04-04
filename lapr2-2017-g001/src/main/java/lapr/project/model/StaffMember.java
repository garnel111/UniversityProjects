 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author André Silva
 */
public class StaffMember implements Comparable<StaffMember>, Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private User staff;    
    private List<String> reviewsAssigned;
    /**
     *
     * @return User
     */
    public User getStaff() {
        return staff;
    }

    /**
     * Construtor Vazio
     */
    public StaffMember() {
        this.staff = new User();
        this.reviewsAssigned= new ArrayList<>();
    }
    
    /**
     *
     * @param staff type User 
     */
    public StaffMember(User staff) {
        this.staff = staff;
        this.reviewsAssigned= new ArrayList<>();
    }

    /**
     * @param staff the staff to set
     */
    public void setUser(User staff) {
        this.staff = staff;
    }
    
//    @Override
//    public String toString() {
//        return String.format("UserName:%s Nome:%s", staff.getUsername(), staff.getName());
//    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.staff);
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
        final StaffMember other = (StaffMember) obj;
        if (!Objects.equals(this.staff, other.staff)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(StaffMember otherStaff) {
        return this.staff.getUsername().compareTo(otherStaff.staff.getUsername());
    }

    /**
     * @return the reviewsAssigned
     */
    public List<String> getReviewsAssigned() {
        return reviewsAssigned;
    }

    /**
     * @param reviewsAssigned the reviewsAssigned to set
     */
    public void setReviewsAssigned(List<String> reviewsAssigned) {
        this.reviewsAssigned = reviewsAssigned;
    }

    
}

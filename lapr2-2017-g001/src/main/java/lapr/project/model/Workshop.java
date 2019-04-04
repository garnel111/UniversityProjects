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
public class Workshop {

    /**
     * @return the necessaryEquipment
     */
    public List<String> getNecessaryEquipment() {
        return necessaryEquipment;
    }
    
    private String description;
    private int durationInHours;
    private List<Boolean> wantToAttend;
    private List<String> necessaryEquipment;

    public Workshop(String description, int durationInHours, List<String> necessaryEquipment) {
        this.description = description;
        this.durationInHours = durationInHours;
        this.necessaryEquipment = necessaryEquipment;
    }

    public Workshop() {
        this.necessaryEquipment= new ArrayList<>();
        this.wantToAttend= new ArrayList<>();
    }
    
    /**
     * @return the wantToAttend
     */
    public List<Boolean> getWantToAttend() {
        return wantToAttend;
    }

    public void setWantToAttend(List<Boolean> wantToAttend) {
        this.wantToAttend = wantToAttend;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param durationInHours the durationInHours to set
     */
    public void setDurationInHours(int durationInHours) {
        this.durationInHours = durationInHours;
    }

    /**
     * @param necessaryEquipment the necessaryEquipment to set
     */
    public void setNecessaryEquipment(List<String> necessaryEquipment) {
        this.necessaryEquipment = necessaryEquipment;
    }
    
   
    public void addAtendeeDecision(Boolean d){
        this.getWantToAttend().add(d);
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the durationInHours
     */
    public int getDurationInHours() {
        return durationInHours;
    }
    
    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        Workshop otherWorkshop = (Workshop) otherObject;
        if(!this.description.equals(otherWorkshop.description)){
            return false;
        }
        if(this.durationInHours!=otherWorkshop.durationInHours){
            return false;
            
        }
        if(!this.wantToAttend.equals(otherWorkshop.wantToAttend)){
            return false;
        }
        return this.getNecessaryEquipment().equals(otherWorkshop.getNecessaryEquipment());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.description);
        hash = 29 * hash + this.durationInHours;
        hash = 29 * hash + Objects.hashCode(this.wantToAttend);
        hash = 29 * hash + Objects.hashCode(this.getNecessaryEquipment());
        return hash;
    }
    
}

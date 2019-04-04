/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author MariaJoão
 */
public class Distance implements Comparable<Distance>, Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String description;
    private Double value;

    public Distance() {
    }

    public Distance(String description, Double value) {
        this.description = description;
        this.value = value;
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
     * @return the value
     */
    public Double getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.description);
        hash = 61 * hash + Objects.hashCode(this.value);
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
        final Distance other = (Distance) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return Objects.equals(this.value, other.value);
    }
    
    @Override
    public String toString() {
        return "description= " + description + ", value= " + value + "\n";
    }    

    @Override
    public int compareTo(Distance o) {
        if(o!=null){
        int cmp = value > o.value ? +1 : value < o.value ? -1 : 0;
      
        return cmp;
        }
        return 0;   
    }
    
}

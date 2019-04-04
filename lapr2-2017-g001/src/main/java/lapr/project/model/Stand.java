/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author MariaJoão
 */
public class Stand implements Comparable<Stand>, Serializable{
    
    private static final long serialVersionUID = 1L;
   
    private String description;
    private double area;
    private List<Distance> distanceList;
    
    public Stand() {
        this.distanceList = new ArrayList<>();
    }

    public Stand(String description, double area) {
        this.description = description;
        this.area = area;
        this.distanceList = new ArrayList<>();
    }
    
public Stand(String description) {
    this.description = description;
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
     * @return the area
     */
    public double getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * @return the distanceList
     */
    public List<Distance> getDistanceList() {
        return distanceList;
    }

    /**
     * @param distanceList the distanceList to set
     */
    public void setDistanceList(List<Distance> distanceList) {
        this.distanceList = distanceList;
    }
    
    /**
     *
     * @param stand String
     * @param distance Distance
     * @return true or false
     */
    public boolean addPairDistance(String stand, Double distance){
        return this.distanceList.add(new Distance (stand,distance));
    }
    
    /**
     *
     * @param d Distance
     * @return true or false 
     */
    public boolean addDistance(Distance d){
        return this.distanceList.add(d);
    }

    @Override
    public int compareTo(Stand s) {
        int cmp = area > s.area ? +1 : area < s.area ? -1 : 0;
        return cmp;      
    }
    
     /**
     *
     * @return boolean verifica se a lista está vazia
     */
    public boolean isEmptyDistancelist() {
        return distanceList.isEmpty();
    }

    @Override
    public String toString() {
        return "Stand{" + "description=" + description + ", area=" + area + ", distanceList=" + printListDistance() + '}'+"\n";
    }
    
    private String printListDistance(){
        List<Distance> copy = new ArrayList<>(distanceList);
        Collections.sort(copy);
        int i = 0;
        
        StringBuilder s = new StringBuilder();
        for (Distance d : distanceList) {
            s.append("Indice ");
            s.append(i);
            s.append(d.toString());
            s.append("\n");
            i++;
        }
        
        return s.toString().trim();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.description);
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.area) ^ (Double.doubleToLongBits(this.area) >>> 32));
        hash = 61 * hash + Objects.hashCode(this.distanceList);
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
        final Stand other = (Stand) obj;
        if (Double.doubleToLongBits(this.area) != Double.doubleToLongBits(other.area)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        
        List<Distance> copyThis = new ArrayList<>(this.distanceList);
        List<Distance> copyOther = new ArrayList<>(other.distanceList);
        Collections.sort(copyThis);
        Collections.sort(copyOther);
        
        return copyThis.equals(copyOther);
        
    }
  
    
}

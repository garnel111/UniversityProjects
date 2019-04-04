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
 * @author MariaJoão
 */
public class StandRegister implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private List<Stand> standList;

    public StandRegister(List<Stand> organiserList) {
        this.standList = organiserList;
    }

    public StandRegister() {
        this.standList= new ArrayList<>();
    }

    /**
     * @return the standList
     */
    public List<Stand> getStandList() {
        return standList;
    }

    /**
     * @param standList the standList to set
     */
    public void setStandList(List<Stand> standList) {
        this.standList = standList;
    }
    
    /**
     *
     * @param s
     * @return
     */
    public boolean addStand(Stand s){
        return this.standList.add(s);
    }
    
    /**
     *
     * @return boolean verifica se a lista está vazia
     */
    public boolean isEmptyStandList() {
        return standList.isEmpty();
    }
    
    /**
     *
     * @param s
     * @return
     */
    public Stand getStandByDescriptionStand(Stand s){
        for(Stand stand : standList){
            if(stand.getDescription().equals(s.getDescription()))
                return stand;
        }
        return null;
    }
    
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        StandRegister otherStandRegister = ( StandRegister) otherObject;
        
        List<Stand> copyThis = new ArrayList<>(this.standList);
        List<Stand> copyOther = new ArrayList<>(otherStandRegister.standList);
        
        return copyThis.equals(copyOther);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.standList);
        return hash;
    }
}

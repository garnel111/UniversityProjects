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
public class OrganiserRegister implements  Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private List<Organiser> organiserList;


    public OrganiserRegister(List<Organiser> organiserList) {
        this.organiserList = organiserList;
    }

    public OrganiserRegister() {
        
        this.organiserList= new ArrayList<>();
    }
    
    public boolean addOrganiser(Organiser o){
        for (Organiser organiser : organiserList) {
            if(organiser.getOrganiser().getUsername().equals(o.getOrganiser().getUsername())){
                return false;
            }
        }       
        return organiserList.add(o);
    }
    /**
     * @return the organiserList
     */
    public List<Organiser> getOrganiserList() {
        return organiserList;
    }

    /**
     * @param organiserList the organiserList to set
     */
    public void setOrganiserList(List<Organiser> organiserList) {
        this.organiserList = organiserList;
    }
    
    public boolean registerOrganiser(User user){
        if(!isExist(user)){               
            organiserList.add(new Organiser(user));
            return true;
        } else
            return false;
        
    }
    
    public boolean isExist(User user){
        boolean valida = false;
        for(Organiser o : organiserList){
            if(o.getOrganiser().getUsername().equals(user.getUsername()))
                valida = true;
        }
        return  valida;
    }
    
    public boolean isEmpty() {
        return organiserList.isEmpty();
    }
    
     public int sizeOrganiserList() {
        return organiserList.size();
    }

  

    @Override
    public String toString() {
        List<Organiser> copy = new ArrayList<>(organiserList);
        Collections.sort(copy);

        StringBuilder s = new StringBuilder();
        for (Organiser o: copy) {
            s.append(o);
            s.append("\n");
        }
        
        return s.toString().trim();
    }
    
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        OrganiserRegister otherOrganiserRegister = (OrganiserRegister) otherObject;

        List<Organiser> copyThis = new ArrayList<>(organiserList);
        List<Organiser> copyOther = new ArrayList<>( otherOrganiserRegister.organiserList);

        return copyThis.equals(copyOther);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.organiserList);
        return hash;
    }

}

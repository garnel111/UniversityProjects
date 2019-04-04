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
 * @author André Silva
 */
public class StaffRegister implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private List<StaffMember> staffList;
    
    public void setStaffList(List<StaffMember> staffList) {
        this.staffList = staffList;
    }
    
    public StaffRegister() {
        this.staffList = new ArrayList<>();
    }
    

    public StaffRegister(List<StaffMember> staffList) {
        this.staffList = staffList;
    }
    
    public boolean addStaffMember(StaffMember sm) {
        for (StaffMember staffMember : staffList) {
            if (staffMember.getStaff().equals(sm.getStaff())) {
                return false;
            }
            
        }
        return this.staffList.add(sm);
    }
    
    /**
     *
     * @param user
     * @return boolean verifica se já existe um utilizador igual na lista
     */
    public boolean isExist(User user) {
        boolean valida = false;
        for (StaffMember staff : staffList) {
            if (staff.getStaff().getUsername().equals(user.getUsername())) {
                valida = true;
            }
        }
        return valida;
    }
    
    public StaffMember getStaffMemberByUsername(String username) {
        for (StaffMember staffMember : staffList) {
            if (staffMember.getStaff().getUsername().equals(username)) {
                return staffMember;
            }
        }
        return null;
    }
    
    /**
     *
     * @return boolean verifica se a lista está vazia
     */
    public boolean isEmpty() {
        return staffList.isEmpty();
    }
    
    /**
     *
     * @return int devolve a tamanho da lista
     */
    public int sizeStaffList() {
        return staffList.size();
    }
    
    @Override
    public String toString() {
        List<StaffMember> copy = new ArrayList<>(staffList);
        Collections.sort(copy);
        int i = 0;
        
        StringBuilder s = new StringBuilder();
        for (StaffMember staff : copy) {
            s.append("Indice ");
            s.append(i);
            s.append(staff.toString());
            s.append("\n");
            i++;
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
        StaffRegister otherStaffRegister = (StaffRegister) otherObject;
        
        List<StaffMember> copyThis = new ArrayList<>(staffList);
        List<StaffMember> copyOther = new ArrayList<>(otherStaffRegister.staffList);
        
        return copyThis.equals(copyOther);
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.staffList);
        return hash;
    }
    
    public void add(List<StaffMember> staffMemberListEvent1) {
        this.staffList = staffMemberListEvent1;
    }
    
    public List<StaffMember> getStaffList() {
        return this.staffList;
    }
    
    public StaffMember createStaffMember() {
        return new StaffMember();
    }
    
}

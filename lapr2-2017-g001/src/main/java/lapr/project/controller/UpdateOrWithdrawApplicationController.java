/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Application;
import lapr.project.model.ApplicationState;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Keyword;
import lapr.project.model.Workshop;
import lapr.project.utils.Utils;

/**
 *
 * @author MariaJoão
 */
public class UpdateOrWithdrawApplicationController {
    
    private ExhibitionCentre centre;
    private Application a;
    private Application newApp;
    
    public UpdateOrWithdrawApplicationController(ExhibitionCentre centre) {
        this.centre = centre;
        
    }
    
    public List<Application> getUserApplications() {
        List<Application> ret = new ArrayList<>();
        for (Event e : this.centre.getEventRegister().getEventList()) {
            for (Application a : e.getApplicationRegister().getApplicationList()) {
                if (a.getUserThatSubmited().equals(this.centre.getUserOnline())) {
                    ret.add(a);
                }
            }
        }
        return ret;
    }
    
    /**
     * @return the a
     */
    public Application getA() {
        return a;
    }
    
    /**
     * @param a the a to set
     */
    public void setA(int index) {
        this.a = getUserApplications().get(index);
    }
    
    public boolean withdrawApplication() {
        for (Event e : this.centre.getEventRegister().getEventList()) {
            for (Application a : e.getApplicationRegister().getApplicationList()) {
                if (this.a.equals(a)) {
                    e.getApplicationRegister().getApplicationList().remove(a);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean updateApplication() {
        for (Event e : this.centre.getEventRegister().getEventList()) {
            for (Application a1 : e.getApplicationRegister().getApplicationList()) {
                if (this.a.equals(a1)) {
                    Application a2 = new Application();
                    a2.setDescription(newApp.getDescription());
                    a2.setBoothArea(newApp.getBoothArea());
                    a2.setKeywordList(newApp.getKeywordList());
                    a2.setListReview(newApp.getListReview());
                    a2.setNameOfCompany(newApp.getNameOfCompany());
                    a2.setPhoneNumber(newApp.getPhoneNumber());
                    a2.setNumberInvites(newApp.getNumberInvites());
                    a2.setVatNumber(newApp.getVatNumber());
                    a2.setWorkshopList(newApp.getWorkshopList());
                    a2.setUserThatSubmited(a1.getUserThatSubmited());
                    a2.setState(ApplicationState.CREATED);
                    e.getApplicationRegister().getApplicationList().remove(a1);
                    e.getApplicationRegister().getApplicationList().add(a2);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean validatePhoneNumber(int phoneNumber) {
        int length = (int) (Math.log10(phoneNumber) + 1);
        if (length != 9) {
            return false;
        }
        return true;
    }
    
    public void setData(String description, int nInvites, List<Keyword> keywords, double area, String companyName, int phoneNumber, int vatNumber, List<Workshop> worshopList) {
        
        newApp = new Application();
        newApp.setDescription(description);
        newApp.setNumberInvites(nInvites);
        newApp.setKeywordList(keywords);
        newApp.setBoothArea(area);
        newApp.setNameOfCompany(companyName);
        newApp.setPhoneNumber(phoneNumber);
        newApp.setVatNumber(vatNumber);
        newApp.setWorkshopList(worshopList);
        
    }
    
    public Event getEvent() {
        for (Event e : this.centre.getEventRegister().getEventList()) {
            for (Application a : e.getApplicationRegister().getApplicationList()) {
                if (this.a.equals(a)) {
                    e.getApplicationRegister().getApplicationList().remove(a);
                    return e;
                }
            }
        }
        return null;
    }
    public void registerLog(String action) {
        Utils.writeLog(this.centre.getUserOnline().getUsername() +" "+action+" application '"+this.a.getDescription()+"' ;", "logs");
    }
}

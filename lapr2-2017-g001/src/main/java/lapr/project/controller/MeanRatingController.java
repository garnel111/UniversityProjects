/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.controller;

import java.util.List;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.User;
import lapr.project.utils.StaffRating;

/**
 *
 * @author JM
 */
public class MeanRatingController {
    
    private ExhibitionCentre exhibitionCentre;
    private StaffRating rating;
    
    public MeanRatingController(ExhibitionCentre exhibitionCentre) {
        this.exhibitionCentre = exhibitionCentre;
        this.rating = new StaffRating(exhibitionCentre);
    }
    
    public List<User> getStaffList() {
        return exhibitionCentre.getAllStaffMembers();
    }
    
    public double calcMeanRating(String username) {
        User user = findUser(username);
        
        return user != null ? rating.meanRating(user) : 0;
    }
    
    public User findUser(String username) {
        for (User u : exhibitionCentre.getUserRegister().getUserList()) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }
    public String getUsername(int index){
        return getStaffList().get(index).getUsername();
    }
    public void staffPosition(int index){
        String username= getUsername(index);
        staffExists(username);
    }
    public boolean staffExists(String username) 
    {
        if (getStaffList().stream().anyMatch((u) -> (u.getUsername().equals(username)))) {
            return true;
        }
        return false;
    }
    
}

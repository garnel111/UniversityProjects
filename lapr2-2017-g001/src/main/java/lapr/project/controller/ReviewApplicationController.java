/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Application;
import lapr.project.model.Decision;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Review;
import lapr.project.model.StaffMember;
import lapr.project.utils.Utils;

/**
 *
 * @author MariaJoão
 */
public class ReviewApplicationController {

    ExhibitionCentre centre;
    Event event;
    Application app;
    StaffMember member;
    Review r;
    public ReviewApplicationController(ExhibitionCentre centre) {

        this.centre= centre;
    }

    public List<Application> getStaffApplications() {
        List<Application> applist=new ArrayList<>();
        member.getReviewsAssigned().forEach((st) -> {
            event.getApplicationRegister().getApplicationList().stream().filter((a) -> (a.getDescription().equals(st))).forEachOrdered((a) -> {
                applist.add(a);
            });
        });
        return applist;

    }

    public List<Event> getEvents() {
        List<Event> ret= new ArrayList<>();
        this.centre.getEventRegister().getEventList().forEach((e) -> {
            e.getStaffRegister().getStaffList().stream().filter((sm) -> (sm.getStaff().equals(this.centre.getUserOnline()))).forEachOrdered((sm) -> {
                ret.add(e);
                this.member=sm;
            });
        });
        return ret;
    }

    public void setEvent(int i) {
        this.event= getEvents().get(i);
    }

    public void setApplication(int i) {
        this.app= getStaffApplications().get(i);
    }

    public void setData(int staffTopicKnowledge, int eventAdequacy, int inviteAdequacy, int areaAdequacy, int recommendation, boolean decision) {
        r= new Review();
        r.setEventAdequacy(eventAdequacy);
        r.setAreaAdequacy(areaAdequacy);
        r.setInviteAdequacy(inviteAdequacy);
        r.setStaffTopicKnowledge(staffTopicKnowledge);
        r.setRecommendation(recommendation);
        if(decision){
            r.setDecision(Decision.ACCEPTED);
        }else{
            r.setDecision(Decision.DECLINED);
        }
        r.setAssignedStaffMember(member);
        
    }

    public void submitReview() {

        this.centre.getEventRegister().getEventList().forEach((e) -> {
            e.getApplicationRegister().getApplicationList().stream().filter((a) -> (a.equals(app))).forEachOrdered((a) -> {
                a.getListReview().add(r);
            });
        });
    }
    public void registerLog() {
        Utils.writeLog(this.centre.getUserOnline().getUsername() + " reviewed application '" +app.getDescription()+ "';", "logs");
    }
    
}

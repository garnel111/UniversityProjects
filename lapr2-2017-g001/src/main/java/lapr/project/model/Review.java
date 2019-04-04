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
public class Review implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String text;
    private int staffTopicKnowledge;
    private int eventAdequacy;
    private int inviteAdequacy;
    private int areaAdequacy;
    private int recommendation;
    private Decision decision;
    private StaffMember assignedStaffMember;
    
    public Review(String text, int staffTopicKnowledge, int eventAdequacy, int inviteAdequacy, int recommendation, Decision decision, StaffMember assignedStaffMember) {
        this.text = text;
        this.staffTopicKnowledge = staffTopicKnowledge;
        this.eventAdequacy = eventAdequacy;
        this.inviteAdequacy = inviteAdequacy;
        this.recommendation = recommendation;
        this.decision = decision;
        this.assignedStaffMember = assignedStaffMember;
    }

    public Review() {
        this.assignedStaffMember= new StaffMember();
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the staffTopicKnowledge
     */
    public int getStaffTopicKnowledge() {
        return staffTopicKnowledge;
    }

    /**
     * @param staffTopicKnowledge the staffTopicKnowledge to set
     */
    public void setStaffTopicKnowledge(int staffTopicKnowledge) {
        this.staffTopicKnowledge = staffTopicKnowledge;
    }

    /**
     * @return the eventAdequacy
     */
    public int getEventAdequacy() {
        return eventAdequacy;
    }

    /**
     * @param eventAdequacy the eventAdequacy to set
     */
    public void setEventAdequacy(int eventAdequacy) {
        this.eventAdequacy = eventAdequacy;
    }

    /**
     * @return the inviteAdequacy
     */
    public int getInviteAdequacy() {
        return inviteAdequacy;
    }

    /**
     * @param inviteAdequacy the inviteAdequacy to set
     */
    public void setInviteAdequacy(int inviteAdequacy) {
        this.inviteAdequacy = inviteAdequacy;
    }
    
    /**
     * @return the areaAdequacy
     */
    public int getAreaAdequacy() {
        return areaAdequacy;
    }

    /**
     * @param areaAdequacy the areaAdequacy to set
     */
    public void setAreaAdequacy(int areaAdequacy) {
        this.areaAdequacy = areaAdequacy;
    }

    /**
     * @return the recommendation
     */
    public int getRecommendation() {
        return recommendation;
    }

    /**
     * @param recommendation the recommendation to set
     */
    public void setRecommendation(int recommendation) {
        this.recommendation = recommendation;
    }

    /**
     * @return the decision
     */
    public Decision getDecision() {
        return decision;
    }

    /**
     * @param decision the decision to set
     */
    public void setDecision(Decision decision) {
        this.decision = decision;
    }

    /**
     * @return the assignedStaffMember
     */
    public StaffMember getAssignedStaffMember() {
        return assignedStaffMember;
    }

    /**
     * @param assignedStaffMember the assignedStaffMember to set
     */
    public void setAssignedStaffMember(StaffMember assignedStaffMember) {
        this.assignedStaffMember = assignedStaffMember;
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
        final Review other = (Review) obj;
        if (this.staffTopicKnowledge != other.staffTopicKnowledge) {
            return false;
        }
        if (this.eventAdequacy != other.eventAdequacy) {
            return false;
        }
        if (this.inviteAdequacy != other.inviteAdequacy) {
            return false;
        }
        if (this.recommendation != other.recommendation) {
            return false;
        }
        if (!Objects.equals(this.text, other.text)) {
            return false;
        }
        if (this.decision != other.decision) {
            return false;
        }
        return Objects.equals(this.assignedStaffMember, other.assignedStaffMember);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.text);
        hash = 71 * hash + this.staffTopicKnowledge;
        hash = 71 * hash + this.eventAdequacy;
        hash = 71 * hash + this.inviteAdequacy;
        hash = 71 * hash + this.recommendation;
        hash = 71 * hash + Objects.hashCode(this.decision);
        hash = 71 * hash + Objects.hashCode(this.assignedStaffMember);
        return hash;
    }
   
}

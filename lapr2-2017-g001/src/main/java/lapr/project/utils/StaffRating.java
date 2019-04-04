/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Application;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Review;
import lapr.project.model.User;

/**
 *
 * @author JM
 */
public class StaffRating {

    private ExhibitionCentre centre;

    public StaffRating(ExhibitionCentre centre) {
        this.centre = centre;
    }

    /**
     * Method to calculate the mean rating of an User (StaffMember)
     *
     * @param user User to select the ratings
     * @return Mean of the ratings for the user (StaffMember)
     */
    public double meanRating(User user) {
        double rsum = 0.0;
        int rcount = 0;

        for (Event ev : centre.getEventRegister().getEventList()) {
            for (Application app : ev.getApplicationRegister().getApplicationList()) {
                List<Review> reviews = getReviews(user, app);
                rsum += calculateRMean(reviews);
                rcount += reviews.size();
            }
        }
        return rcount != 0 ? rsum / rcount : 0;
    }

    /**
     * Method to get the reviews made by the user
     *
     * @param user User who made the reviews
     * @param app Application with the reviews
     * @return List with the reviews made by the user
     */
    private List<Review> getReviews(User user, Application app) {
        List<Review> reviews = new ArrayList<>();
        for (Review rev : app.getListReview()) {
            if (rev.getAssignedStaffMember().getStaff().equals(user)) {
                reviews.add(rev);
            }
        }
        return reviews;
    }

    /**
     * Method to calculate the mean of the reviews
     *
     * @param reviews List with the reviews
     * @return Returns the sum of the means of the reviews
     */
    private double calculateRMean(List<Review> reviews) {
        double rmean;
        double rsum = 0;
        for (Review rev : reviews) {
            rmean = (rev.getStaffTopicKnowledge() + rev.getEventAdequacy() + rev.getInviteAdequacy() + rev.getAreaAdequacy() + rev.getRecommendation());
            rmean /= 5.0;
            rsum += rmean;
        }
        return rsum;
    }

    /**
     * Method to calculate the mean deviation of an user ratings and an event
     *
     * @param user User to consider the mean ratings
     * @param event Event to use the mean rating
     * @return Mean deviation
     */
    public double meanDeviation(User user, Event event) {
        double devSum = 0;
        int devCount = 0;
        double eventMean = eventMean(event);

        for (Event ev : centre.getEventRegister().getEventList()) {
            for (Application app : ev.getApplicationRegister().getApplicationList()) {
                List<Review> reviews = getReviews(user, app);
                devSum += calculateRdev(reviews, eventMean);
                devCount += reviews.size();
            }
        }
        return devCount != 0 ? devSum / devCount : 0;
    }

    /**
     * Method to calculate the mean deviation of the reviews
     *
     * @param reviews List with the reviews
     * @param eventMean mean of the selected event
     * @return Returns the sum of the mean deviation of the reviews
     */
    private double calculateRdev(List<Review> reviews, double eventMean) {
        double rmean;
        double devSum = 0;
        for (Review rev : reviews) {
            rmean = (rev.getStaffTopicKnowledge() + rev.getEventAdequacy() + rev.getInviteAdequacy() + rev.getAreaAdequacy() + rev.getRecommendation());
            rmean /= 5.0;
            devSum += Math.abs(rmean - eventMean);
        }
        return devSum;
    }

    /**
     * Method to return the mean rating of an event
     *
     * @param event Event to calculate the mean
     * @return mean rating
     */
    public double eventMean(Event event) {
        double rsum = 0;
        int rcount = 0;

        for (Application app : event.getApplicationRegister().getApplicationList()) {
            for (Review rev : app.getListReview()) {
                double rmean = (double) rev.getStaffTopicKnowledge() + rev.getEventAdequacy() + rev.getInviteAdequacy() + rev.getAreaAdequacy() + rev.getRecommendation();
                rmean = rmean / 5;
                rsum += rmean;
                rcount++;
            }
        }
        return rcount != 0 ? rsum / rcount : 0;
    }

}

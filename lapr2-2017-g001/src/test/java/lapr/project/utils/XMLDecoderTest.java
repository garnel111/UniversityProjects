/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import lapr.project.model.Application;
import lapr.project.model.ApplicationRegister;
import lapr.project.model.ApplicationState;
import lapr.project.model.Decision;
import lapr.project.model.Distance;
import lapr.project.model.Event;
import lapr.project.model.EventState;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Keyword;
import lapr.project.model.Organiser;
import lapr.project.model.OrganiserRegister;
import lapr.project.model.Review;
import lapr.project.model.Role;
import lapr.project.model.StaffMember;
import lapr.project.model.StaffRegister;
import lapr.project.model.Stand;
import lapr.project.model.StandRegister;
import lapr.project.model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author MariaJoão
 */
public class XMLDecoderTest {
    
    /**
     * Test of readExhibitionCentreFromFile method, of class XMLDecoder.
     */
    public void testReadExhibitionCentreFromFile() throws Exception {
        System.out.println("readExhibitionCentreFromFile");
    }

    /**
     * Test of readEventFromFile method, of class XMLDecoder.
     */
    @Test
    public void testReadEventFromFile() throws Exception {
        System.out.println("readEventFromFile");
        Event event= new Event();
        event.setTitle("event1");
        
        StandRegister sr= new StandRegister();
        Stand s= new Stand();
        s.setArea(100);
        s.setDescription("stand1");
        Distance d= new Distance();
        d.setDescription("distance1");
        d.setValue(0.1);
        List<Distance> distanceList= new ArrayList<>();
        distanceList.add(d);
        s.setDistanceList(distanceList);
        sr.addStand(s);
        event.setStandRegister(sr);

        User u1= new User();
        u1.setEmail("email@gmail.com");
        u1.setName("name");
        u1.setRole(Role.EMPLOYEE);
        u1.setUsername("user1");
        u1.setPassword(PasswordEncryption.encryptPassword("01230123"));

                
        StaffRegister str= new StaffRegister();
        StaffMember sm= new StaffMember();
        sm.setUser(u1);
        str.addStaffMember(sm);        
        event.setStaffRegister(str);

        OrganiserRegister or= new OrganiserRegister();
        Organiser o= new Organiser();
        o.setOrganiser(u1);
        or.getOrganiserList().add(o);        
        event.setOrganisersRegister(or);
        
        ApplicationRegister ar= new ApplicationRegister();
        Application app= new Application();
        app.setBoothArea(0.01);
        app.setDescription("app1");
        app.setState(ApplicationState.ACCEPTED);
        app.setNumberInvites(3);
        Keyword k= new Keyword();
        k.setValue("k1");
        app.addKeyword(k);
        List<Review> revList= new ArrayList<>();
        Review r= new Review();
        r.setEventAdequacy(0);
        r.setInviteAdequacy(1);
        r.setRecommendation(2);
        r.setStaffTopicKnowledge(0);
        r.setText("review 1");
        r.setAssignedStaffMember(sm);
        r.setDecision(Decision.ACCEPTED);
        revList.add(r);
        app.setListReview(revList);
        ar.addApplication(app);
        event.setApplicationRegister(ar);
        event.setEventState(EventState.CREATED);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element exhibitionEl = document.createElement("event");
        Element titleEl = document.createElement("title");
        titleEl.setTextContent("event1");
        Element standsEl = document.createElement("stands");
        Element standEl = document.createElement("stand");
        Element descriptionEl = document.createElement("description");
        descriptionEl.setTextContent("stand1");
        Element areaEl = document.createElement("area");
        areaEl.setTextContent("100");
        Element relativeDistanceSetEl = document.createElement("relativeDistanceSet");
        Element distanceEl = document.createElement("distance");
        Element distanceDescriptionEl = document.createElement("description");
        distanceDescriptionEl.setTextContent("distance1");
        Element distanceValueEl = document.createElement("value");
        distanceValueEl.setTextContent("0.1");
        relativeDistanceSetEl.appendChild(distanceEl);
        distanceEl.appendChild(distanceDescriptionEl);
        distanceEl.appendChild(distanceValueEl);
        standEl.appendChild(descriptionEl);
        standEl.appendChild(areaEl);
        standEl.appendChild(relativeDistanceSetEl);
        standsEl.appendChild(standEl);

        Element StaffsEl = document.createElement("StaffSet");
        Element staffEl = document.createElement("staff");
        Element userEl = document.createElement("user");
        Element staffNameEl = document.createElement("name");
        staffNameEl.setTextContent("name");
        Element usernameEl = document.createElement("username");
        usernameEl.setTextContent("user1");
        Element emailEl = document.createElement("email");
        emailEl.setTextContent("email@gmail.com");
        Element passwordEl = document.createElement("password");
        passwordEl.setTextContent("01230123");
        userEl.appendChild(staffNameEl);
        userEl.appendChild(usernameEl);
        userEl.appendChild(emailEl);
        userEl.appendChild(passwordEl);
        staffEl.appendChild(userEl);
        StaffsEl.appendChild(staffEl);
        
        Element organisersEl = document.createElement("organiserSet");
        Element organiserEl = document.createElement("organiser");
        Element user2El = document.createElement("user");
        Element organiserNameEl = document.createElement("name");
        organiserNameEl.setTextContent("name");
        Element username2El = document.createElement("username");
        username2El.setTextContent("user1");
        Element email2El = document.createElement("email");
        email2El.setTextContent("email@gmail.com");
        Element password2El = document.createElement("password");
        password2El.setTextContent("01230123");
        user2El.appendChild(organiserNameEl);
        user2El.appendChild(username2El);
        user2El.appendChild(email2El);
        user2El.appendChild(password2El);
        organiserEl.appendChild(user2El);
        organisersEl.appendChild(organiserEl);

        Element applicationSetEl = document.createElement("applicationSet");
        Element applicationEl = document.createElement("application");
        Element appDescriptionEl = document.createElement("description");
        appDescriptionEl.setTextContent("app1");
        Element boothAreaEl = document.createElement("boothArea");
        boothAreaEl.setTextContent("0.01");
        Element aceptedEl = document.createElement("accepted");
        aceptedEl.setTextContent("true");
        Element invitesEl = document.createElement("invitesQuantity");
        invitesEl.setTextContent("3");
        Element topicsEl = document.createElement("topics");
        Element topicEl = document.createElement("topic");
        topicEl.setTextContent("k1");
        topicsEl.appendChild(topicEl);


        Element elementReviews = document.createElement("reviews");
        Element elementReview = document.createElement("review");
        Element elementReviewText = document.createElement("text");
        elementReviewText.setTextContent("review 1");
        Element elementReviewStaffTopicKnowledge = document.createElement("staffTopicKnowledge");
        elementReviewStaffTopicKnowledge.setTextContent("0");
        Element elementReviewEventAdequacy = document.createElement("eventAdequacy");
        elementReviewEventAdequacy.setTextContent("0");
        Element elementReviewInviteAdequacy = document.createElement("inviteAdequacy");
        elementReviewInviteAdequacy.setTextContent("1");
        Element elementReviewRecommendation = document.createElement("recommendation");
        elementReviewRecommendation.setTextContent("2");
        Element elementReviewDecision = document.createElement("decision");
        elementReviewDecision.setTextContent("accepted");
        Element elementReviewAssignment = document.createElement("assignment");
        Element elementReviewStaff = document.createElement("staff");
        Element elementReviewUser = document.createElement("user");
        Element elementReviewUserName = document.createElement("name");
        elementReviewUserName.setTextContent("name");
        Element elementReviewUserEmail = document.createElement("email");
        elementReviewUserEmail.setTextContent("email@gmail.com");
        Element elementReviewUserUname = document.createElement("username");
        elementReviewUserUname.setTextContent("user1");
        Element elementReviewUserPwd = document.createElement("password");
        elementReviewUserPwd.setTextContent("01230123");

        elementReviews.appendChild(elementReview);
        elementReview.appendChild(elementReviewText);
        elementReview.appendChild(elementReviewStaffTopicKnowledge);
        elementReview.appendChild(elementReviewEventAdequacy);
        elementReview.appendChild(elementReviewInviteAdequacy);
        elementReview.appendChild(elementReviewRecommendation);
        elementReview.appendChild(elementReviewDecision);
        elementReview.appendChild(elementReviewAssignment);

        elementReviewUser.appendChild(elementReviewUserName);
        elementReviewUser.appendChild(elementReviewUserEmail);
        elementReviewUser.appendChild(elementReviewUserUname);
        elementReviewUser.appendChild(elementReviewUserPwd);
        elementReviewStaff.appendChild(elementReviewUser);
        elementReviewAssignment.appendChild(elementReviewStaff);

        applicationEl.appendChild(appDescriptionEl);
        applicationEl.appendChild(boothAreaEl);
        applicationEl.appendChild(invitesEl);
        applicationEl.appendChild(topicsEl);
        applicationEl.appendChild(elementReviews);
        applicationEl.appendChild(aceptedEl);
        applicationSetEl.appendChild(applicationEl);

        //Add sub-element to root element
        exhibitionEl.appendChild(titleEl);
        exhibitionEl.appendChild(standsEl);
        exhibitionEl.appendChild(StaffsEl);
        exhibitionEl.appendChild(applicationSetEl);
        exhibitionEl.appendChild(organisersEl);
        //Add root element to document
        document.appendChild(exhibitionEl);
        ExhibitionCentre centre= new ExhibitionCentre();
        Event result = XMLDecoder.readEventFromFile("", centre, 0,  exhibitionEl);

        assertEquals(event, result);        
        
        
    }
    
}
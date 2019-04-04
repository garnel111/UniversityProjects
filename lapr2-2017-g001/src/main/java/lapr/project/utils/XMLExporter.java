/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.function.Function;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import lapr.project.model.Application;
import lapr.project.model.ApplicationState;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.StaffMember;
import lapr.project.model.Stand;
import lapr.project.model.Workshop;
import lapr.project.ui.UtilsUI;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author MariaJoão
 */
public class XMLExporter {
    
    XMLExporter(ExhibitionCentre centre) throws ParserConfigurationException, SAXException, IOException{
                       
       
    }
    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }
    public static void exportAllDataToFile(ExhibitionCentre centre, String filePath) throws ParserConfigurationException, SAXException, IOException{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document;

        File  file= new File(filePath);
    
        if(!file.delete()){
            UtilsUI.printWarning("EXPORTING");
        };
        document=builder.newDocument();

        Element exhibitionCentreEl = document.createElement("exhibitionCentre");
        String description_label="description",
        username_label="username",
        email_label="email",
        password_label="password",
        name_label="name",
        user_label="user";
        Element userSetEl = document.createElement("userSet");
        centre.getUserRegister().getUserList().stream().map((u) -> {
            Element userEl = document.createElement("user");
            Element nameEl = document.createElement(name_label);
            nameEl.setTextContent(u.getName());
            Element usernameEl = document.createElement(username_label);
            usernameEl.setTextContent(u.getUsername());
            Element emailEl = document.createElement(email_label);
            emailEl.setTextContent(u.getEmail());
            Element passwordEl = document.createElement(password_label);
            passwordEl.setTextContent(String.valueOf(u.getPassword()));
            Element roleEl = document.createElement("role");
            roleEl.setTextContent(u.getRole().toString());
            userEl.appendChild(nameEl);
            userEl.appendChild(usernameEl);
            userEl.appendChild(emailEl);
            userEl.appendChild(passwordEl);  
            userEl.appendChild(roleEl);
            return userEl;
        }).forEachOrdered((userEl) -> 
            userSetEl.appendChild(userEl)
        );
        
        
        Element eventSetEl = document.createElement("eventSet");
        
        for (Event e : centre.getEventRegister().getEventList()) {
          
        
        Element exhibitionEl = document.createElement("event");
            Element titleEl = document.createElement("title");
            titleEl.setTextContent(e.getTitle());
            Element stateEl = document.createElement("state");
            stateEl.setTextContent(e.getEventState().name());
            Element nrRoomsEl = document.createElement("numberRooms");
            nrRoomsEl.setTextContent(String.valueOf(e.getRooms()));
            if(!isEmpty(e.getPlace())){
                Element placeEl = document.createElement("place");
                placeEl.setTextContent(e.getPlace());
                exhibitionEl.appendChild(placeEl);

            }
            exhibitionEl.appendChild(stateEl);
            Element standsEl = document.createElement("stands");
            e.getStandRegister().getStandList().stream().map((Stand s) -> {
                Element standEl = document.createElement("stand");
                Element descriptionEl = document.createElement(description_label);
                descriptionEl.setTextContent(s.getDescription());
                Element areaEl = document.createElement("area");
                areaEl.setTextContent(String.valueOf(s.getArea()));
                Element relativeDistanceSetEl = document.createElement("relativeDistanceSet");
                s.getDistanceList().forEach((d) -> {
                    Element distanceEl = document.createElement("distance");
                    Element distanceDescriptionEl = document.createElement(description_label);
                    distanceDescriptionEl.setTextContent(d.getDescription());
                    Element distanceValueEl = document.createElement("value");
                    distanceValueEl.setTextContent(String.valueOf(d.getValue()));
                    relativeDistanceSetEl.appendChild(distanceEl);
                    distanceEl.appendChild(distanceDescriptionEl);
                    distanceEl.appendChild(distanceValueEl);
                });
                standEl.appendChild(descriptionEl);
                standEl.appendChild(areaEl);
                standEl.appendChild(relativeDistanceSetEl);
                return standEl;
            }).forEachOrdered(standEl -> 
                standsEl.appendChild(standEl)
            );
            Element staffsEl = document.createElement("StaffSet");
            for (StaffMember s : e.getStaffRegister().getStaffList()) {
                Element staffEl = document.createElement("staff");
                Element userEl = document.createElement(user_label);
                Element staffNameEl = document.createElement(name_label);
                staffNameEl.setTextContent(s.getStaff().getName());
                Element usernameEl = document.createElement(username_label);
                usernameEl.setTextContent(s.getStaff().getUsername());
                Element emailEl = document.createElement(email_label);
                emailEl.setTextContent(s.getStaff().getEmail());
                Element passwordEl = document.createElement(password_label);
                passwordEl.setTextContent(String.valueOf(s.getStaff().getPassword()));
                Element toReviewEl = document.createElement("ApplicationsToReview");
                for (String sReview : s.getReviewsAssigned()) {
                    Element descEl = document.createElement("applicationDesc");
                    descEl.setTextContent(sReview);                    
                    toReviewEl.appendChild(descEl);

                }
                    userEl.appendChild(staffNameEl);
                    userEl.appendChild(usernameEl);
                    userEl.appendChild(emailEl);
                    userEl.appendChild(passwordEl);
                    staffEl.appendChild(userEl);
                    if(s.getReviewsAssigned().size()>0){
                    staffEl.appendChild(toReviewEl);
                    }
               staffsEl.appendChild(staffEl);
    
                }
            
            Element organisersEl = document.createElement("organiserSet");
            e.getOrganiserRegister().getOrganiserList().stream().map((o) -> {
                Element organiserEl = document.createElement("organiser");
                Element user2El = document.createElement(user_label);
                Element organiserNameEl = document.createElement(name_label);
                organiserNameEl.setTextContent(o.getOrganiser().getName());
                Element username2El = document.createElement(username_label);
                username2El.setTextContent(o.getOrganiser().getUsername());
                Element email2El = document.createElement(email_label);
                email2El.setTextContent(o.getOrganiser().getEmail());
                Element password2El = document.createElement(password_label);
                password2El.setTextContent(String.valueOf(o.getOrganiser().getPassword()));
                user2El.appendChild(organiserNameEl);
                user2El.appendChild(username2El);
                user2El.appendChild(email2El);
                user2El.appendChild(password2El);
                organiserEl.appendChild(user2El);
                return organiserEl;
            }).forEachOrdered((organiserEl) -> {
                organisersEl.appendChild(organiserEl);
            });
            Element applicationSetEl = document.createElement("applicationSet");
            for (Application a : e.getApplicationRegister().getApplicationList()) {
                Element applicationEl = document.createElement("application");
                Element appDescriptionEl = document.createElement(description_label);
                appDescriptionEl.setTextContent(a.getDescription());
                Element appCompanyEl = document.createElement("companyName");
                
                if(isEmpty(a.getNameOfCompany())){
                    appCompanyEl.setTextContent(a.getNameOfCompany());
                }
                Element appPhoneNumberEl = document.createElement("phoneNumber");
                if(a.getPhoneNumber()!=0){
                    appPhoneNumberEl.setTextContent(String.valueOf(a.getPhoneNumber()));
                }
                Element appVatNumberEl = document.createElement("vatNumber");
                if(a.getVatNumber()!=0){
                    appVatNumberEl.setTextContent(String.valueOf(a.getPhoneNumber()));
                }
                Element boothAreaEl = document.createElement("boothArea");
                boothAreaEl.setTextContent(String.valueOf(a.getBoothArea()));
                if(a.getUserThatSubmited()!=null){
                    Element userthatEl = document.createElement("userSubmited");
                    userthatEl.setTextContent(a.getUserThatSubmited().getUsername());
                    applicationEl.appendChild(userthatEl);

                } 
                Element workshopSetEl = document.createElement("workshopSet");
                for (Workshop w : a.getWorkshopList()) {
                    Element workshopEl = document.createElement("workshop");
                    Element workshopDescEl = document.createElement("description");                   
                    workshopDescEl.setTextContent(w.getDescription());
                    workshopEl.appendChild(workshopDescEl);
                    Element workshopDurEl = document.createElement("duration");    
                    workshopEl.appendChild(workshopDurEl);                    
                    workshopDurEl.setTextContent(String.valueOf(w.getDurationInHours()));
                    for (String eq : w.getNecessaryEquipment()) {
                        Element workshopEqEl = document.createElement("equipment");                   
                        workshopEqEl.setTextContent(eq);
                        workshopEl.appendChild(workshopEqEl);
                    }
                    workshopSetEl.appendChild(workshopEl);
                }
                
                Element aceptedEl = document.createElement("accepted");
                if(a.getState().equals(ApplicationState.ACCEPTED)){
                    aceptedEl.setTextContent("true");
                }else if(a.getState().equals(ApplicationState.REJECTED)){
                    aceptedEl.setTextContent("false");
                }
                Element stateaceptEl = document.createElement("state");
                stateaceptEl.setTextContent(a.getState().name());
                Element invitesEl = document.createElement("invitesQuantity");
                invitesEl.setTextContent(String.valueOf(a.getNumberInvites()));
                Element topicsEl = document.createElement("topics");
                
                a.getKeywordList().stream().map(k -> {
                    Element topicEl = document.createElement("topic");
                    topicEl.setTextContent(k.getValue());
                    return topicEl;
                }).forEachOrdered((topicEl) -> {
                    topicsEl.appendChild(topicEl);
                });
                
                Element elementReviews = document.createElement("reviews");
                a.getListReview().forEach(r -> {
                    Element elementReview = document.createElement("review");
                    Element elementReviewText = document.createElement("text");
                    elementReviewText.setTextContent(r.getText());
                    Element elementReviewStaffTopicKnowledge = document.createElement("staffTopicKnowledge");
                    elementReviewStaffTopicKnowledge.setTextContent(String.valueOf(r.getStaffTopicKnowledge()));
                    Element elementReviewEventAdequacy = document.createElement("eventAdequacy");
                    elementReviewEventAdequacy.setTextContent(String.valueOf(r.getEventAdequacy()));
                    Element elementReviewInviteAdequacy = document.createElement("inviteAdequacy");
                    elementReviewInviteAdequacy.setTextContent(String.valueOf(r.getInviteAdequacy()));
                    Element elementReviewRecommendation = document.createElement("recommendation");
                    elementReviewRecommendation.setTextContent(String.valueOf(r.getRecommendation()));
                    Element elementReviewDecision = document.createElement("decision");
                    elementReviewDecision.setTextContent(r.getDecision().name().toLowerCase());
                    Element elementReviewAssignment = document.createElement("assignment");
                    Element elementReviewStaff = document.createElement("staff");
                    Element elementReviewUser = document.createElement(user_label);
                    Element elementReviewUserName = document.createElement(name_label);
                    elementReviewUserName.setTextContent(r.getAssignedStaffMember().getStaff().getName());
                    Element elementReviewUserEmail = document.createElement(email_label);
                    elementReviewUserEmail.setTextContent(r.getAssignedStaffMember().getStaff().getEmail());
                    Element elementReviewUserUname = document.createElement(username_label);
                    elementReviewUserUname.setTextContent(r.getAssignedStaffMember().getStaff().getUsername());
                    Element elementReviewUserPwd = document.createElement(password_label);
                    elementReviewUserPwd.setTextContent(String.valueOf(r.getAssignedStaffMember().getStaff().getPassword()));
                    
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
                });
                
                
                applicationEl.appendChild(appDescriptionEl);
                applicationEl.appendChild(boothAreaEl);
                applicationEl.appendChild(invitesEl);
                applicationEl.appendChild(appVatNumberEl);
                applicationEl.appendChild(appPhoneNumberEl);
                applicationEl.appendChild(appCompanyEl);
                applicationEl.appendChild(topicsEl);
                applicationEl.appendChild(workshopSetEl);
                applicationEl.appendChild(elementReviews);
                applicationEl.appendChild(aceptedEl);
                applicationEl.appendChild(stateaceptEl);
                applicationSetEl.appendChild(applicationEl);
            }
            if(e.getStartDate()!=null){
                Element startDateEl = document.createElement("startDate");
                startDateEl.setTextContent(new SimpleDateFormat("yyyy-MM-dd").format(e.getStartDate()));
                exhibitionEl.appendChild(startDateEl);

            }
            if(e.getEndDate()!=null){
                Element endDateEl = document.createElement("endDate");
                endDateEl.setTextContent(new SimpleDateFormat("yyyy-MM-dd").format(e.getEndDate()));
                exhibitionEl.appendChild(endDateEl);

            }
            //Add sub-element to root element
            exhibitionEl.appendChild(titleEl);
            exhibitionEl.appendChild(nrRoomsEl);
            exhibitionEl.appendChild(standsEl);
            exhibitionEl.appendChild(staffsEl);
            exhibitionEl.appendChild(organisersEl);
            exhibitionEl.appendChild(applicationSetEl);
            eventSetEl.appendChild(exhibitionEl);

        }
            //Add root element to document
                exhibitionCentreEl.appendChild(userSetEl);
                exhibitionCentreEl.appendChild(eventSetEl);
                document.appendChild(exhibitionCentreEl);


                
try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.setOutputProperty(OutputKeys.METHOD, "xml");
            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            // send DOM to file
            tr.transform(new DOMSource(document), 
                                 new StreamResult(new FileOutputStream(filePath)));

        } catch (TransformerException | IOException te) {
            System.out.println(te.getMessage());
        }
        
    }
    
}

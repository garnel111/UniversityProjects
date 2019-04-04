/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
import lapr.project.model.UserRegister;
import lapr.project.model.Workshop;
import lapr.project.ui.UtilsUI;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author MariaJoão
 */
public class XMLDecoder {
    private static final String USER_TAG = "user";
    private static final String EVENT_TAG = "event";
    
    public static ExhibitionCentre readExhibitionCentreFromFile(String filePath, ExhibitionCentre centre) throws ParserConfigurationException, SAXException, IOException{
            
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbf.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(filePath));
            Element docElement = doc.getDocumentElement();
            UserRegister ur= new UserRegister();
            
            Node list_users_node = docElement.getElementsByTagName("userSet").item(0);
            Element el_users= (Element)list_users_node;
            NodeList list_users = el_users.getElementsByTagName("user");
            
            for (int i = 0; i < list_users.getLength(); i++) {
                Node node_user= list_users.item(i);
                Element user_element= (Element) node_user;
                User u = new User();
                String name = user_element.getElementsByTagName("name").item(0).getTextContent();
                String email = user_element.getElementsByTagName("email").item(0).getTextContent();
                String username = user_element.getElementsByTagName("username").item(0).getTextContent();
                String password = user_element.getElementsByTagName("password").item(0).getTextContent();
                String role = user_element.getElementsByTagName("role").item(0).getTextContent();

                u.setEmail(email);
                u.setName(name);
                try{
                    int p = Integer.parseInt(password);
                    u.setPassword(PasswordEncryption.encryptPassword(password));
                
                }catch(NumberFormatException e){
                    u.setPassword(Double.parseDouble(password));
                }
                u.setUsername(username);
                switch(role){
                    case "PARTICIPANT":
                        u.setRole(Role.PARTICIPANT);
                        break;
                    case "EMPLOYEE":
                        u.setRole(Role.EMPLOYEE);
                        break;
                    case "EVENT_MANAGER":
                        u.setRole(Role.EVENT_MANAGER);
                        break;
                    case "ATENDEE":
                        u.setRole(Role.ATENDEE);
                        break;
                }   
                ur.addUser(u);          
           
            }
            
            centre.setUserRegister(ur);
            Node list_events_node = docElement.getElementsByTagName("eventSet").item(0);
            Element el_events= (Element)list_events_node;
            NodeList list_events = el_events.getElementsByTagName("event");

            for (int i = 0; i < list_events.getLength(); i++) {
                Node s2 = list_events.item(i);
                Element elem_event=(Element)s2;    
                Event e=readEventFromFile("", centre, i, elem_event);
                centre.getEventRegister().addEvent(e);
            
            }
            return centre;
    }
    
    public static Event readEventFromFile(String filePath, ExhibitionCentre centre, int cont, Element elem_event) throws ParserConfigurationException, SAXException, IOException {

        try {
            Event e = new Event();  
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbf.newDocumentBuilder();
            Document doc;
            if(!filePath.equals("")){
                doc = docBuilder.parse(new File(filePath)); 
                elem_event = doc.getDocumentElement();

            }else{
                doc=docBuilder.newDocument();


            }
            String title = elem_event.getElementsByTagName("title").item(0).getTextContent();
            int nrRooms=0;
            Date sd= new Date();
            Date ed= new Date();
            String place="";
            String startDate="";
            String endDate="";
            if(elem_event.getElementsByTagName("numberRooms").getLength()>0){
                 nrRooms = Integer.parseInt(elem_event.getElementsByTagName("numberRooms").item(0).getTextContent());
            }
            if(elem_event.getElementsByTagName("startDate").getLength()>0){
                 startDate = elem_event.getElementsByTagName("startDate").item(0).getTextContent();
                 e.setStartDate(Utils.changeFormat(sd, startDate));

            }
            if(elem_event.getElementsByTagName("endDate").getLength()>0){
                 endDate = elem_event.getElementsByTagName("endDate").item(0).getTextContent();
                 e.setEndDate(Utils.changeFormat(ed, endDate));

            }
            if(elem_event.getElementsByTagName("place").getLength()>0){
                 place = elem_event.getElementsByTagName("place").item(0).getTextContent();
                e.setPlace(place);

            }                        
            e.setRooms(nrRooms);
            e.setTitle(title);
            NodeList state = elem_event.getElementsByTagName("state");
            Node s1 = state.item(0);
            Element el = (Element) s1;
            if(el!=null){
               String st =  elem_event.getElementsByTagName("state").item(0).getTextContent();
               switch(st){
                   case "CREATED":
                       e.setEventState(EventState.CREATED);
                       break;
                   case "READY_FOR_APPLICATION":   
                    e.setEventState(EventState.READY_FOR_APPLICATION);
                    break;
                   case "OPEN_APPLICATION":
                    e.setEventState(EventState.OPEN_APPLICATION);
                    break;
                   default:
                       e.setEventState(EventState.READY_FOR_APPLICATION);
                    break;   
                       
               }
            }else{
                e.setEventState(EventState.CREATED);
            }
            StandRegister sr= buildStandRegister(elem_event);
            OrganiserRegister or= buildOrganiserRegister(elem_event, centre);
            e.setOrganisersRegister(or);
            e.setStandRegister(sr);
            StaffRegister stffr= buildStaffRegister(elem_event, centre);
            e.setStaffRegister(stffr);
            ApplicationRegister  ar= buildApplicationRegister(elem_event, e, centre);
            e.setApplicationRegister(ar);

            return e;
            
        } catch (ParserConfigurationException | IOException | SAXException e) {
                UtilsUI.printError("FAILED TO LOAD FILE : "+e.getMessage());
            return null;
                
        }
    }

    private static StandRegister buildStandRegister(Element docElement) {
        NodeList s2 = docElement.getElementsByTagName("stands");
        Node s1 = s2.item(0);
        Element el = (Element) s1; 
        StandRegister sr= new StandRegister();
        NodeList stands = el.getElementsByTagName("stand");
        for (int i = 0; i < stands.getLength(); i++) {
            Stand stand_obj= new Stand();
            Node stand = stands.item(i);
            Element stand_element = (Element) stand;
            String description = stand_element.getElementsByTagName("description").item(0).getTextContent();
            String area = stand_element.getElementsByTagName("area").item(0).getTextContent();
            stand_obj.setDescription(description);
            stand_obj.setArea(Double.parseDouble(area));           
            NodeList distances= stand_element.getElementsByTagName("distance");

            if(distances.getLength()>0){
            for (int j = 0; j < distances.getLength(); j++) {
                Distance distance_obj= new Distance();
                Node distance = distances.item(j);
                Element distance_element = (Element) distance;
                String description_d = distance_element.getElementsByTagName("description").item(0).getTextContent();
                String value_d = distance_element.getElementsByTagName("value").item(0).getTextContent();            
                distance_obj.setDescription(description_d);
                distance_obj.setValue(Double.parseDouble(value_d));
                stand_obj.addDistance(distance_obj);
            }
            }
            sr.addStand(stand_obj);
            
        }
        return sr;
    }
    private static OrganiserRegister buildOrganiserRegister(Element docElement, ExhibitionCentre centre) {
        
        OrganiserRegister or= new OrganiserRegister();
        
        NodeList s2 = docElement.getElementsByTagName("organiserSet");
        Node s1 = s2.item(0);
        Element el = (Element) s1; 
        if(el!=null){
        NodeList organisers = el.getElementsByTagName("organiser");
        UserRegister ur= centre.getUserRegister();
        
        for (int i = 0; i < organisers.getLength(); i++) {
            User u= new User();
            Organiser o= new Organiser();
            Node staff_node = organisers.item(i);
            Element staff_element = (Element) staff_node;
            String name = staff_element.getElementsByTagName("name").item(0).getTextContent();
            String email = staff_element.getElementsByTagName("email").item(0).getTextContent();
            String username = staff_element.getElementsByTagName("username").item(0).getTextContent();
            String password = staff_element.getElementsByTagName("password").item(0).getTextContent();
            u.setEmail(email);
            u.setName(name);
                try{
                    int p = Integer.parseInt(password);
                    u.setPassword(PasswordEncryption.encryptPassword(password));
                
                }catch(NumberFormatException e){
                    u.setPassword(Double.parseDouble(password));
                }            u.setUsername(username);
            u.setRole(Role.EMPLOYEE);
            o.setOrganiser(u);
            ur.addUser(u);
            or.addOrganiser(o);
        }
        centre.setUserRegister(ur);
        }
        return or;
        
    }
    private static StaffRegister buildStaffRegister(Element docElement, ExhibitionCentre centre) {
        
        StaffRegister sr= new StaffRegister();
        
        NodeList s2 = docElement.getElementsByTagName("StaffSet");
        Node s1 = s2.item(0);
        Element el = (Element) s1; 
        NodeList staffs = el.getElementsByTagName("staff");
        UserRegister ur= centre.getUserRegister();
        
        for (int i = 0; i < staffs.getLength(); i++) {
            User u= new User();
            StaffMember sm= new StaffMember();
            Node staff_node = staffs.item(i);            
            Element staff_element = (Element) staff_node;
            String name = staff_element.getElementsByTagName("name").item(0).getTextContent();
            String email = staff_element.getElementsByTagName("email").item(0).getTextContent();
            String username = staff_element.getElementsByTagName("username").item(0).getTextContent();
            String password = staff_element.getElementsByTagName("password").item(0).getTextContent();
            NodeList toReview_nodes = staff_element.getElementsByTagName("ApplicationsToReview");
            Node toReview_node = toReview_nodes.item(0);  
            Element toReviewElement= (Element) toReview_node;
            if(toReviewElement!=null){
                NodeList aplications= toReviewElement.getElementsByTagName("applicationDesc");
                for (int j = 0; j < aplications.getLength(); j++) {
                    Node one_app_node = aplications.item(j);            
                    Element one_app_el = (Element) one_app_node;
                    String descApp = one_app_el.getTextContent();
                    sm.getReviewsAssigned().add(descApp);
                }
            }
            u.setEmail(email);
            u.setName(name);
                try{
                    int p = Integer.parseInt(password);
                    u.setPassword(PasswordEncryption.encryptPassword(password));
                
                }catch(NumberFormatException e){
                    u.setPassword(Double.parseDouble(password));
                }
            u.setUsername(username);
            u.setRole(Role.EMPLOYEE);
            sm.setUser(u);
            ur.addUser(u);
            sr.addStaffMember(sm);
        }
        centre.setUserRegister(ur);
        return sr;
    }

    private static ApplicationRegister buildApplicationRegister(Element docElement, Event event, ExhibitionCentre centre) {
        
        ApplicationRegister ar= new ApplicationRegister();
        
        NodeList s2 = docElement.getElementsByTagName("applicationSet");
        Node s1 = s2.item(0);
        Element el = (Element) s1; 
        NodeList applications = el.getElementsByTagName("application");
        for (int i = 0; i < applications.getLength(); i++) {
            Application a= new Application();
            Node application_node = applications.item(i);
            Element application_element = (Element) application_node;
            String accepted = application_element.getElementsByTagName("accepted").item(0).getTextContent();
            String boothArea = application_element.getElementsByTagName("boothArea").item(0).getTextContent();
            String invitesQuantity = application_element.getElementsByTagName("invitesQuantity").item(0).getTextContent();
            String description = application_element.getElementsByTagName("description").item(0).getTextContent();
            NodeList state = application_element.getElementsByTagName("state");
            Node st1 = state.item(0);
            Element elstate = (Element) st1;
            if(elstate!=null){
               String st =  application_element.getElementsByTagName("state").item(0).getTextContent();
               switch(st){
                   case "CREATED":
                        a.setState(ApplicationState.CREATED);
                   break;
                   case "IN_EVALUALTION":   
                       a.setState(ApplicationState.IN_EVALUALTION);
                   break;
                   case "ACCEPTED":
                        a.setState(ApplicationState.ACCEPTED);
                       break;
                   case "REJECTED":
                        a.setState(ApplicationState.REJECTED);
                       break;
                   default:
                        a.setState(ApplicationState.CREATED);
                       break;  
                       
               }
            }else{
                a.setState(ApplicationState.CREATED);
                
            }
            NodeList user_that_submited = docElement.getElementsByTagName("userSubmited");
            Node user_that_submited_n = user_that_submited.item(0);
            Element eluser_sub = (Element) user_that_submited_n;
            if(eluser_sub!=null){
                String user_name=application_element.getElementsByTagName("userSubmited").item(0).getTextContent();
                centre.getUserRegister().getUserList().stream().filter((u) -> (u.getUsername().equals(user_name))).forEachOrdered((u) -> {
                    a.setUserThatSubmited(u);
                });
            }
            
            
            NodeList reviews= application_element.getElementsByTagName("reviews");
            Node sr = reviews.item(0);
            Element elr = (Element) sr; 
            NodeList reviews_list = elr.getElementsByTagName("review");
            
            List<Review> list_reviews= new ArrayList<>();
            NodeList keywords= application_element.getElementsByTagName("topic");
            List<Keyword> list_keywords= new ArrayList<>();
            
            NodeList workshops= application_element.getElementsByTagName("workshopSet");
            Node wnode = workshops.item(0);
            Element welem = (Element) wnode; 
            List<Workshop> list_workshops= new ArrayList<>();
            if(welem!=null){
            NodeList workshops_list = welem.getElementsByTagName("workshop");

                for (int j = 0; j <workshops_list.getLength(); j++) {
                Workshop w= new Workshop();
                List<String> equipment= new ArrayList<>();
                Node workshop_node = workshops_list.item(j);
                Element workshop_element = (Element) workshop_node;
                String description_w = workshop_element.getElementsByTagName("description").item(0).getTextContent();
                String hours=   workshop_element.getElementsByTagName("duration").item(0).getTextContent();
                NodeList eq_list = workshop_element.getElementsByTagName("equipment");
                for (int k = 0; k < eq_list.getLength(); k++) {
                    Node eq_node = eq_list.item(j);
                    Element eq_element = (Element) eq_node;
                    equipment.add(eq_element.getTextContent());                    
                }
                w.setDescription(description_w);
                w.setDurationInHours(Integer.parseInt(hours));
                w.setNecessaryEquipment(equipment);
                list_workshops.add(w);
            }
            }
            for (int j = 0; j < keywords.getLength(); j++) {
                Keyword k= new Keyword();
                Node keyword_node = keywords.item(j);
                Element keyord_element = (Element) keyword_node;
                String value = keyord_element.getTextContent();
                k.setValue(value);
                list_keywords.add(k);
            }
            for (int j = 0; j < reviews_list.getLength(); j++) {
                Review r= new Review();
                Node review_node = reviews_list.item(j);
                Element review_element = (Element) review_node;
                String text = review_element.getElementsByTagName("text").item(0).getTextContent();
                String staffTopicKnowledge = review_element.getElementsByTagName("staffTopicKnowledge").item(0).getTextContent();
                String eventAdequacy = review_element.getElementsByTagName("eventAdequacy").item(0).getTextContent();
                String inviteAdequacy = review_element.getElementsByTagName("inviteAdequacy").item(0).getTextContent();
                String recommendation = review_element.getElementsByTagName("recommendation").item(0).getTextContent();
                String decision = review_element.getElementsByTagName("decision").item(0).getTextContent();
                String username = review_element.getElementsByTagName("username").item(0).getTextContent();
                if("accepted".equalsIgnoreCase(decision)){
                    r.setDecision(Decision.ACCEPTED);
                }else{
                    r.setDecision(Decision.DECLINED);
                }
                r.setText(text);
                r.setEventAdequacy(Integer.parseInt(eventAdequacy));
                r.setStaffTopicKnowledge(Integer.parseInt(staffTopicKnowledge));
                r.setInviteAdequacy(Integer.parseInt(inviteAdequacy));
                r.setRecommendation(Integer.parseInt(recommendation));
                r.setAssignedStaffMember(event.getStaffRegister().getStaffMemberByUsername(username));
                list_reviews.add(r);
            }
            if("true".equalsIgnoreCase(accepted)){
                a.setState(ApplicationState.ACCEPTED);
            }else if("false".equalsIgnoreCase(accepted)){
                a.setState(ApplicationState.REJECTED);
            }
            a.setBoothArea(Double.parseDouble(boothArea));
            a.setNumberInvites(Integer.parseInt(invitesQuantity));
            a.setDescription(description);
            a.setKeywordList(list_keywords);
            a.setWorkshopList(list_workshops);
            a.setListReview(list_reviews);
            ar.addApplication(a);
        }
        return ar;
    }
    
    
}
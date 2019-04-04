/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.io.IOException;
import java.io.Serializable;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Role;
import lapr.project.utils.Utils;
import org.xml.sax.SAXException;


/**
 *
 * @author MariaJoão
 */
public class MainMenu implements Serializable{
    private ExhibitionCentre centre;
     private static final long serialVersionUID = 1L;
     
    public MainMenu(ExhibitionCentre centre) {
        String lines="~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
     
        String opt;
        this.centre=centre;
        UtilsUI.printLine(lines);
        UtilsUI.printLine("                              MAIN MENU                                 ");
        UtilsUI.printLine(lines);
        
        /*
        * Não apagar, comentado temporariamente
        */
        
        if(centre.getEventRegister().userIsStaffMember(centre.getUserOnline())){
            UtilsUI.printLine("                       1.SUBMIT APPLICATION REVIEW           ");
            UtilsUI.printLine("                  2.CALCULATE MINIMUM ELECTRICAL CABLE       ");
            UtilsUI.printLine("                              3.LOGOUT                       ");
            UtilsUI.printLine("                               4.EXIT                        ");
            
            UtilsUI.printLine(lines);
            opt = UtilsUI.readLineFromConsole("INSERT OPTION: ");
            switch(UtilsUI.isNumber(opt)){         
                case 1:
                    new ReviewApplicationUI(centre);
                    break;
                case 2:
                    new CalculateCableUI(centre);
                    break;

                case 3:
                    try{
                        Utils.export(centre);
                    }catch(ParserConfigurationException |SAXException| IOException e){
                        UtilsUI.printLine(e.toString());
                    }
                    new InitialMenuUI(centre);
                    break;
                case 4:
                    try{
                        Utils.export(centre);
                    }catch(ParserConfigurationException |SAXException| IOException e){
                        UtilsUI.printLine(e.toString());
                    }
                    break;
                default:
                    new MainMenu(centre);
                    break;
            }
        }
        else if(centre.getEventRegister().userIsOrganiser(centre.getUserOnline())){
            
            UtilsUI.printLine("                   1.ASSIGN STAFF MEMBER TO EVENT            ");
            UtilsUI.printLine("           2.START EVENT'S APPLICATION SUBMISSION PERIOD     ");
            UtilsUI.printLine("                    3.ACCEPT OR REJECT APPLICATION          ");
            UtilsUI.printLine("                  4.ASSIGN STAFF MEMBER TO REVIEW            ");
            UtilsUI.printLine("               5.LIST AN EVENT'S SUBMITTED APPLICATIONS      ");
            UtilsUI.printLine("           6.LIST AN EVENT'S REVIEW-PENDING APPLICATIONS     ");
            UtilsUI.printLine("              7.LIST AN EVENT'S ACCEPTED APPLICATIONS        ");
            UtilsUI.printLine("              8.LIST AN EVENT'S REJECTED APPLICATIONS        ");
            UtilsUI.printLine("                             9.LOGOUT                        ");
            UtilsUI.printLine("                             10.EXIT                         ");/*frequencias*/

            System.out.println(lines);

            opt = UtilsUI.readLineFromConsole("INSERT OPTION: ");
            switch(UtilsUI.isNumber(opt)){         
                case 1:
                    new AssignStaffMemberUI(centre); 
                    
                break; 
                
                case 2:
                    new StartSubmissionPeriodUI(centre);    
                break;
                case 3:
                    new AcceptOrRejectApplicationUI(centre);
                break;
                
                case 4:
                    new AssignStaffMemberToReviewUI(centre);
                    break;
                case 5:
                    new ListEventsUI(centre, "SUBMITTED");                    
                break;
                case 6:
                    new ListEventsUI(centre, "REVIEW-PENDING");                    
                break;   
                case 7:
                   new ListEventsUI(centre, "ACCEPTED");                    
                break;
                case 8:
                   new ListEventsUI(centre, "REJECTED");                    
                break;    
                case 9:
                    try{
                        Utils.export(centre);
                    }catch(ParserConfigurationException |SAXException| IOException e){
                        UtilsUI.printLine(e.toString());
                    }
                    new InitialMenuUI(centre);
                break;
                case 10:
                    try{
                        Utils.export(centre);
                    }catch(ParserConfigurationException |SAXException| IOException e){
                        UtilsUI.printLine(e.toString());
                    }
                break;  
                default:
                    new MainMenu(centre);
                break;
            }
        }
        else if(centre.getEventRegister().userIsEventManager(centre.getUserOnline())){
       UtilsUI.printLine("                           1.CREATE EVENT                      ");
       UtilsUI.printLine("                     2.SHOW EVENT'S ACCEPTANCE RATE            ");
       UtilsUI.printLine("                     3.ACCEPT OR REJECT APPLICATION          ");     
       UtilsUI.printLine("                     4.SHOW STAFF MEMBER MEAN RATING            ");
       UtilsUI.printLine(" 5.SHOW MEAN DEVIATION BETWEEN STAFF MEMBER'S AVERAGE RATING AND EVENT'S MEAN RATING");
       UtilsUI.printLine("                              6.LOGOUT                         ");/*frequencias*/
       UtilsUI.printLine("                               7.EXIT                          ");/*frequencias*/

       UtilsUI.printLine(lines);
            opt = UtilsUI.readLineFromConsole("INSERT OPTION: ");
            switch(UtilsUI.isNumber(opt)){         
                case 1:
                    new CreateEventUI(centre);    
                break; 
                case 2:
                    new EventAcceptanceRateUI(centre);
                break; 
                case 3:
                    new AcceptOrRejectApplicationUI(centre);
                    break;                 
                case 4:
                    new MeanRatingUI(centre);
                break; 
                case 5:
                    new MeanDeviationUI(centre);
                break; 

                case 6:
                   try{
                        Utils.export(centre);
                    }catch(ParserConfigurationException |SAXException| IOException e){
                        UtilsUI.printLine(e.toString());
                    }
                    new InitialMenuUI(centre);
                break;    
                case 7:
                    try{
                        Utils.export(centre);
                    }catch(ParserConfigurationException |SAXException| IOException e){
                        UtilsUI.printLine(e.toString());
                    }
                break;               
                default:
                    new MainMenu(centre);
                break;    
            }         
        }else if(centre.getUserOnline().getRole().equals(Role.PARTICIPANT)){
        UtilsUI.printLine("                     1.SUBMIT APPLICATION TO EVENT            ");       
        UtilsUI.printLine("                    2.UPDATE OR WITHDRAW APPLICATION          ");       
        UtilsUI.printLine("                              3.LOGOUT                        ");/*frequencias*/
        UtilsUI.printLine("                               4.EXIT                        ");/*frequencias*/
        UtilsUI.printLine(lines);
        opt = UtilsUI.readLineFromConsole("INSERT OPTION: ");
            switch(UtilsUI.isNumber(opt)){         
                case 1:
                    new SubmitApplicationToEventUI(centre);  
                break;
                case 2:
                    new UpdateOrWithdrawApplicationUI(centre);
                break; 
                case 3:
                    try{
                        Utils.export(centre);
                    }catch(ParserConfigurationException |SAXException| IOException e){
                        UtilsUI.printLine(e.toString());
                    }
                    new InitialMenuUI(centre);

                    break;
                case 4:
                  try{
                        Utils.export(centre);
                    }catch(ParserConfigurationException |SAXException| IOException e){
                        UtilsUI.printLine(e.toString());
                    }
                  break;
                default:
                    new MainMenu(centre);
                break;
            } 
        }else if(centre.getUserOnline().getRole().equals(Role.ATENDEE)){
            
        UtilsUI.printLine("                       1.SUBMIT WORKSHOP SURVEY            ");
        UtilsUI.printLine("                             2.LOGOUT                    ");/*frequencias*/
        UtilsUI.printLine("                              3.EXIT                     ");/*frequencias*/
      
        UtilsUI.printLine(lines);
        opt = UtilsUI.readLineFromConsole("INSERT OPTION: ");
            switch(UtilsUI.isNumber(opt)){         
                case 1:
                    new SubmitWorkshopSurveyUI(centre);
                break; 
                case 2:
                    try{
                        Utils.export(centre);
                    }catch(ParserConfigurationException |SAXException| IOException e){
                        UtilsUI.printLine(e.toString());
                    }
                    new InitialMenuUI(centre);
                break;
                case 3:
                    try{
                        Utils.export(centre);
                    }catch(ParserConfigurationException |SAXException| IOException e){
                        UtilsUI.printLine(e.toString());
                    }
                break;
                default:
                    new MainMenu(centre);
                break;    
            }     
        }
                
    }
    
}


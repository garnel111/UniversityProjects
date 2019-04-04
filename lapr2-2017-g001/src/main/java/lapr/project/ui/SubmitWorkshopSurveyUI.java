/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.util.ArrayList;
import java.util.List;
import lapr.project.controller.SubmitWorkshopSurveyController;
import lapr.project.model.Event;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.Workshop;

/**
 *
 * @author MariaJoão
 */
public class SubmitWorkshopSurveyUI {
    
  private   SubmitWorkshopSurveyController controller;
  
    public SubmitWorkshopSurveyUI(ExhibitionCentre centre){
        String lines = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
        String lines2 = "--------------------------";
        this.controller= new SubmitWorkshopSurveyController(centre);
        UtilsUI.printLine("");        
        UtilsUI.printLine(lines);  
        UtilsUI.printLine("           SUBMIT WORKSHOP SURVEY           ");
        UtilsUI.printLine(lines);  
        int event_number=-1, n=1;
        UtilsUI.printLine("***NOTE: THIS SURVEY IS TOTTALY ANONYMOUS***");

        while(event_number==-1){
                UtilsUI.printLine(lines2);
                UtilsUI.printLine("          EVENTS          ");
                UtilsUI.printLine(lines2);

                for (Event e : controller.getEvents()) {
                        UtilsUI.printLine(n+" - "+e.getTitle());
                        n++;
                    }
                UtilsUI.printLine(lines2);

                try{
                        event_number = Integer.parseInt(UtilsUI.readLineFromConsole("PICK EVENT YOU WOULD LIKE TO ATTEND: "));
                        controller.setEvent(n-2);
                        if(event_number <1 || event_number>n){
                            UtilsUI.printError("NUMBER INSERTED NOT VALID. INSERT NUMBER INSIDE LIMITS. PLEASE TRY AGAIN.");
                            event_number=-1;                            
                        }    
                        }catch(NumberFormatException e){

                        UtilsUI.printError("CHARACTER INSERTED NOT VALID. PLEASE TRY AGAIN.");
                        event_number=-1;                            

                    }           
        }
        List<Workshop> lista_workshops= controller.listaWorkshopsOfAcceptedApplications();
        List<Boolean> answers= new ArrayList<>();
        String resposta_workshops;
        for (int i=0; i<lista_workshops.size();i++) {

                resposta_workshops=UtilsUI.readLineFromConsole("WORKSHOP "+lista_workshops.get(i).getDescription()+" LASTING "+lista_workshops.get(i).getDurationInHours()+" HOURS (WRITE 'Y' IF YES OR 'N' IF NO): ");
                if(!resposta_workshops.equalsIgnoreCase("y") && !resposta_workshops.equalsIgnoreCase("n")){
                    UtilsUI.printError("INVALID CHARACTER. PLEASE ANSWER AGAIN.");
                    i--;
                }else if(resposta_workshops.equalsIgnoreCase("y")){
                    answers.add(Boolean.TRUE);
                }else if(resposta_workshops.equalsIgnoreCase("n")){
                    answers.add(Boolean.FALSE);
                }                
      }
        controller.registerAnswers(answers);
        UtilsUI.printConfirmation("ANSWERS SUCCESSFULY SAVED");
        controller.registerLog();
        new MainMenu(centre);

        
    } 
    
}

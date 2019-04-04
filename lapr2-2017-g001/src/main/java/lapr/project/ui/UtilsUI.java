/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import lapr.project.model.ExhibitionCentre;
import lapr.project.model.User;
import lapr.project.model.UserRegister;

/**
 *
 * @author MariaJoão
 */
public class UtilsUI {
    public static void printError(String message){
        
        System.out.println("[\n-----------------------ERROR-----------------------");
        System.out.println(message);
        System.out.println("---------------------------------------------------\n");
    } 
    
    public static void printWarning(String message){
        
        System.out.println("\n----------------------WARNING----------------------");
        System.out.println(message);
        System.out.println("---------------------------------------------------\n");
    } 
    
     public static void printConfirmation(String message){
        
        System.out.println("\n----------------------SUCCESS----------------------");
        System.out.println(message);
        System.out.println("---------------------------------------------------\n");
    }     

     public static void printLine(String message){
         System.out.println(message);
    }      
     public static int isNumber(String num){
         int ret=0;
         try{
         ret= Integer.parseInt(num);
         }catch(NumberFormatException e){
             printError("INVALID CHARACTER. PLEASE TRY AGAIN.");
             
         }
         return ret;
     }  
     
    public static void showUsersExhibitionCentre(ExhibitionCentre exhibitionCentre) {
       List<User> users = new ArrayList<>();
        UserRegister userRegisterCentre = exhibitionCentre.getUserRegister();
       users = userRegisterCentre.getUserList();
        for (User item : users) {
            System.out.println("\n User do centro de exibiçoes: "+ item );
        }
    }

    static public String readLineFromConsole(String strPrompt)
      {
          try
          {
              System.out.print(strPrompt);

              InputStreamReader converter = new InputStreamReader(System.in);
              BufferedReader in = new BufferedReader(converter);

              return in.readLine();
          } catch (IOException e)
          {
              return null;
          }
      }    
}

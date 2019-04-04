/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.util.Arrays;

/**
 *
 * @author JM
 */
public class PasswordEncryption {
    
    private PasswordEncryption(){
        
    }

    /**
     * Method to encrypt a String password (Arithmetic coding)
     *
     * @param password String with the password to be encrypted
     * @return Double with the encrypted password
     */
    public static double encryptPassword(String password) {
        double encrypted;
        int[] numCount = new int[10];
        Arrays.fill(numCount, 0);

        //conta as repetições de cada algarismo
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            int digit = Character.getNumericValue(c);
            numCount[digit]++;
        }

        //Calcula as probabilidades
        double[] probArray = new double[10];

        probArray[0] = ((double) numCount[0] / password.length());
        for (int i = 1; i < probArray.length; i++) {
            probArray[i] = ((double) numCount[i] / password.length()) + probArray[i - 1];
        }

        double I = 0.0;
        double F = 1.0;
        double x;
        double y;

        //Codifica
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            int digit = Character.getNumericValue(c);

            x = (digit == 0) ? I : I + ((F - I) * probArray[digit - 1]);
            y = I + ((F - I) * probArray[digit]);

            I = x;
            F = y;
        }
        encrypted = I;
        return encrypted;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.IOException;
import java.text.ParseException;

import models.Empresa;

/**
 *
 * @author Manuel GArnel e Arcenio Uate
 * 
 */
public class MainApp {
 
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws IOException, ParseException, ClassNotFoundException {
        // launch(args);
        Empresa empresa = new Empresa();
        
        MenuUI uiMenu = new MenuUI(empresa);

        uiMenu.run();
    }
}

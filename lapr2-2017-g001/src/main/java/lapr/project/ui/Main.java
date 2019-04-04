package lapr.project.ui;

import java.io.Console;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.CalculatorExample;
import lapr.project.model.ExhibitionCentre;
import lapr.project.utils.XMLDecoder;
import lapr.project.utils.XMLExporter;
import org.xml.sax.SAXException;

/**
 * @author Nuno Bettencourt <nmb@isep.ipp.pt> on 24/05/16.
 */
class Main {
    
    /**
     * Private constructor to hide implicit public one.
     */
    private Main() {
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        CalculatorExample calculatorExample = new CalculatorExample();
        InitialMenuUI initialMenuUI;
        
        ExhibitionCentre centre = new ExhibitionCentre();
        
        Console c = System.console();
        if (c == null) {
            XMLDecoder.readExhibitionCentreFromFile("./exhibition_centre.xml", centre);
            //XMLExporter.exportAllDataToFile(centre);
        } else {
            XMLDecoder.readExhibitionCentreFromFile("./exhibition_centre.xml", centre);
            
        }
        
        initialMenuUI = new InitialMenuUI(centre);
        
    }
    
}

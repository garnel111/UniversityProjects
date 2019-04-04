package lapr.project.ui;

import javafx.util.Pair;
import lapr.project.assessment.Facade;
import lapr.project.controller.*;
import lapr.project.model.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Logger;

/**
 * @author Nuno Bettencourt <nmb@isep.ipp.pt> on 24/05/16.
 */
final class Main {


    /**
     * Private constructor to hide implicit public one.
     */
    private Main() {

    }

    /**
     * Application main method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

//PROPRIEDADES DA BASE DE DADOS (NÃO COMENTAR!)
        //load database properties
        try {
            Properties properties
                    = new Properties(System.getProperties());
            InputStream input = new FileInputStream("target/classes/application.properties");
            properties.load(input);
            input.close();
            System.setProperties(properties);

        } catch (IOException e) {
            e.printStackTrace();
        }
//FIM DAS PROPRIEDADES DA BASE DE DADOS


        //Testes da Façade
        Facade f = new Facade();
        String s = "getNearestParks.txt";
        f.getNearestParks(41.158087, -8.629120, s);

        //distanceTo
        System.out.println("distanceTo: " + f.distanceTo(41.158087, -8.629120, 41.15288, -8.63659) + "m");

        //ShortestRouteBetweenTwoParks




        /*
         *Login Controller
         */

        String passManuel = "qwertyManuel";
        String eMail = "1131325@isep.ipp.pt";
        LoginController lCtrl = new LoginController(passManuel, eMail);
        User user = lCtrl.getUSerByMailAndPass(passManuel, eMail);
        System.out.println("user logged:\t" + lCtrl.getUSerByMailAndPass(passManuel, eMail));

        /*
         * Trip controller
         */
        TripController tripControllerExample = new TripController();
        Trip trip = new Trip();
        trip.setTripId(600000);
        long trip_Id = trip.getTripId();
        double mass = tripControllerExample.getUserMass(user);
        TripController trpContrl = new TripController();


        /*
         * Trip controller A funcionar
         */
        System.out.println("Teste bike  Electric on Park1");
        BicycleController bicycleController = new BicycleController();
        TripController tripController = new TripController();
        Bicycle b = new Bicycle();
        b.setType("Road");
        b.setIdBicycle(7);
        b.setKm(300);
        b.setBicycleMass(12);
        Park parkA = new Park();
        parkA.setName("FCUP_PARK");
        parkA.setAdmin_Id(30);
        parkA.setId(1);
        parkA.setLatitude((float) 41.152881);
        parkA.setLongitude((float) -8.63659);
        parkA.setMaxCapacityNonElectric(250);
        parkA.setMaxCapacityElectric(100);

        System.out.println("Update bicycle 7");
        tripController.updateParkAvailability(b, trip, parkA);

        System.out.println("Teste bike  Mountain or Road on Park 2");

        Bicycle b1 = new Bicycle();
        b1.setType("Road");
        b1.setIdBicycle(6);
        b1.setKm(300);
        b1.setBicycleMass(12);
        Park parkB = new Park();
        parkB.setName("FCUP_PARK");
        parkB.setAdmin_Id(31);
        parkB.setId(2); //FCUP Park
        parkB.setLatitude((float) 41.152881);
        parkB.setLongitude((float) -8.63659);
        parkB.setMaxCapacityNonElectric(250);
        parkB.setMaxCapacityElectric(100);
        tripController.updateParkAvailability(b1, trip, parkB);

        ArrayList<String> pointsList = new ArrayList<String>();
        pointsList.add("POI1");
        pointsList.add("POI2");
        pointsList.add("POI3");
        pointsList.add("POI5");
        pointsList.add("Casa");

        AdministratorController admnistratorController = new AdministratorController();
        /*
         * Energia consumida entre origrm e destino com POI
         */


        System.out.println("Lista de pontos conectados a partir da base de dados");
        Map<Pair<String, String>, Pair<Pair<Long, Long>, Long>> poiWithValuesListFromDataBase = admnistratorController.poiListFromDataBase(pointsList);
        Organization organization = new Organization();
        Pair<Long, Long> powerAndEnergy = organization.getAmountOfEnergyConsumed(poiWithValuesListFromDataBase);
        System.out.println("Potencia " + powerAndEnergy.getKey() + " W \n" +
                "Energia gasta " + powerAndEnergy.getValue() + " kcal");

    }
}

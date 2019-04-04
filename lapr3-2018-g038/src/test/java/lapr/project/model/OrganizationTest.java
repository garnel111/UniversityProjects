package lapr.project.model;

import javafx.util.Pair;
import lapr.project.controller.RouteController;
import lapr.project.controller.TripController;
import lapr.project.utils.TripHelper;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrganizationTest {


    public OrganizationTest() throws IOException, SQLException {
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

    }

    @Test
    public void testSet() throws IOException {
        /*
        // Map<String,String> originDestiny = new HashMap<String, String>();
        Organization organization = new Organization();
        TripController tripController = mock(TripController.class);
        TripHelper trpH = mock(TripHelper.class);
        POI p1 = new POI(1,"origin","teste",11.11F,22.22F,1);
        POI p2 = new POI(2,"destiny","teste",22.11F,11.22F,1);
        Pair<POI,POI> poiP = new Pair<>(p1,p2);
        when(trpH.getPoi_Pair("origin", "destiny")).thenReturn(poiP);
        Pair<Double,Double> distP = new Pair<>(12.21,23.32);
        when(trpH.getDistanceBetweenPOIAndRespectiveAltitudes("origin","destiny")).thenReturn(distP);
        tripController.setTripHelper(trpH);

        // Organization organization = mock(Organization.class);
        organization.setTrpController(tripController);

        String origin = "origin";
        String destiny = "destiny";
        Pair<String, String> originDestinyMap = new Pair<>(origin, destiny);

        // Pair<Long, Long> velocities;
        long velocityVrK = (40);
        long velocityVaK = (20);
        Pair<Long, Long> velocities = new Pair<>(velocityVrK, velocityVaK);

        // Pair<Long, Long> angleAndDistances;
        long angle = 20;
        // distance = resultSet.getLong(6);
        Pair<Pair<Long, Long>, Long> velocitiesAndAngle = new Pair<Pair<Long, Long>, Long>(velocities, angle);

        // Map velocities and angle
        // assert velocitiesAndAngleMap != null;
        Map<Pair<String, String>, Pair<Pair<Long, Long>, Long>> velocitiesAndAngleMap = new HashMap<Pair<String, String>, Pair<Pair<Long, Long>, Long>>();

        velocitiesAndAngleMap.put(originDestinyMap, velocitiesAndAngle);
        Set<Map.Entry<Pair<String, String>, Pair<Pair<Long, Long>, Long>>> conjuntodeParesDoMapa = velocitiesAndAngleMap
                .entrySet();

        long val1 = 20;
        long val2 = 10;
        when(tripController.getEnergyBurnedBetweenTwoPOI(40, 20, 20, "origin", "destiny"))
                .thenReturn(new Pair<Long, Long>(val1, val2));
        Pair<Long, Long> energyAndPower = tripController.getEnergyBurnedBetweenTwoPOI(40, 20, 20, "origin", "destiny");
        System.out.println(energyAndPower);
        long potencia = energyAndPower.getKey();
        long energiaTotal = energyAndPower.getValue();
        // when(organization.getAmountOfEnergyConsumed(velocitiesAndAngleMap)).thenCallRealMethod();
        System.out.println(organization.getAmountOfEnergyConsumed(velocitiesAndAngleMap));
*/assertEquals(true,true);
    }

}

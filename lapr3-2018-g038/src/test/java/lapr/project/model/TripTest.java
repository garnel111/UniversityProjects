package lapr.project.model;

import javafx.util.Pair;
import lapr.project.data.TripDb;
import lapr.project.utils.TripHelper;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TripTest {

    public TripTest() {
    }

    @Test
    public void testGetOriginAndDestinyParksById() {


        System.out.println("Test get Origin And Destiny Parks By Id");


        long trip_Id = 600000;
        TripDb tripDb = mock(TripDb.class);
        Trip trip = new Trip();
        trip.setTripDB(tripDb);
        long parkOr = 200;
        long parkDest = 300;
        Pair<Long, Long> originAndDestinyIDs = null;
        when(tripDb.getOriginAndDestinyParksIdByTripId(trip_Id)).thenReturn(new Pair<Long, Long>(parkOr, parkDest));

        originAndDestinyIDs = tripDb.getOriginAndDestinyParksIdByTripId(600000);

        tripDb.getOriginAndDestinyParksIdByTripId(600000);
        assertEquals(200, originAndDestinyIDs.getKey().longValue());
        assertEquals(300, originAndDestinyIDs.getValue().longValue());
        Pair<Long, Long> expectedResult = trip.getOriginAndDestinyParksById(600000);
    }


    @Test
    public void testGetOriginAndDestinyParksByIdWithNullValues() {

        System.out.println("Test get Origin And Destiny Parks By Id With Null Values");
        long trip_Id = 600000;
        TripDb tripDb = mock(TripDb.class);
        Trip trip = new Trip();
        trip.setTripDB(tripDb);
        trip.setTripId(600000);
        long trip_ID = trip.getTripId();
        long parkOr = (long) 0.000000;
        long parkDest = (long) 0.000000;
        Pair<Long, Long> originAndDestinyIDs = null;
        when(tripDb.getOriginAndDestinyParksIdByTripId(trip_Id)).thenReturn(new Pair<Long, Long>(parkOr, parkDest));

        originAndDestinyIDs = tripDb.getOriginAndDestinyParksIdByTripId(trip_Id);

        tripDb.getOriginAndDestinyParksIdByTripId(trip_Id);
        assertEquals(0.000000, originAndDestinyIDs.getKey().longValue());
        assertEquals(0.000000, originAndDestinyIDs.getValue().longValue());
        Pair<Long, Long> expectedResult = trip.getOriginAndDestinyParksById(600000);
        assertEquals(0, expectedResult.getKey().longValue());
        assertEquals(0, expectedResult.getValue().longValue());
    }

    @Test
    public void testGetTripID() {

        System.out.println("Test get Origin And Destiny Parks By Id With Null Values");
        long trip_Id = -99999999;
        TripDb tripDb = mock(TripDb.class);
        Trip trip = new Trip();
        trip.setTripDB(tripDb);
        trip.setTripId(-99999999);
        long result = trip.getTripId();
        long expectedResult = -99999999;
        assertEquals(result, expectedResult);

    }
}

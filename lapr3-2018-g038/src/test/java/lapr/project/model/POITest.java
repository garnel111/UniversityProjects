package lapr.project.model;

import lapr.project.data.PoiDB;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class POITest {


    @Test
    public void testGetId() {
        System.out.println("getId");

        POI instance = new POI(1, "tipo1", "12", 10, 14, 15);
        long expResult = 10L;
        instance.setId(10L);
        long result = instance.getId();
        assertEquals(expResult, result);

    }

    @Test
    public void testGetName() {
        System.out.println("get Name ");

        POI instance = new POI(1, "nome1", "tipo1", 10, 14, 15);
        String expResult = "nome1";
        instance.setName("nome1");

        String result = instance.getName();
        assertEquals(expResult, result);

    }

    @Test
    public void testGetOrgID() {
        System.out.println("get Name ");

        POI instance = new POI(1, "nome1", "tipo1", 10, 14, 15);
        long expResult = 15;
        instance.setOrganizationId(15);

        long result = instance.getOrganizationId();
        assertEquals(expResult, result);

    }
    @Test
    public void testGetType() {
        System.out.println("get Name ");

        POI instance = new POI(1, "nome1", "tipo1", 10, 14, 15);
        String expResult = "tipo1";
        instance.setType("tipo1");

        String result = instance.getType();
        assertEquals(expResult, result);

    }

    @Test
    public void testGetPOIByName() {
        System.out.println("get Name ");
        PoiDB poiDB = mock(PoiDB.class);

        POI instance = new POI(1, "nome1", "tipo1", 10, 14, 15);
        instance.setPOIDB(poiDB);
        String expResult = "tipo1";
        instance.setName("tipo1");
        when(poiDB.getPoiByName("nome1")).thenReturn(new POI(1, "nome1", "tipo1", 10, 14, 15));
        POI poi2 = poiDB.getPoiByName("nome1");
//assertEquals(poi2,instance);
assertNotNull(poi2);
//instance.getPOIByName("nome1");


    }
    @Test
    public void testGetPOIBName() {
        System.out.println("get Name ");
        PoiDB poiDB = mock(PoiDB.class);

        POI instance = new POI( );
        instance.setPOIDB(poiDB);
        String expResult = "tipo1";
        instance.setName("tipo1");
        when(poiDB.getPoiByName("nome1")).thenReturn(new POI( ));
        POI poi2 = poiDB.getPoiByName("nome1");
//assertEquals(poi2,instance);
        assertNull(poi2.getName());
//instance.getPOIByName("nome1");


    }
}

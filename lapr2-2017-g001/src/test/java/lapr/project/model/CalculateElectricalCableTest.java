/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author JM
 */
public class CalculateElectricalCableTest {

    /**
     * Test of cablePath method, of class CalculateElectricalCable.
     */
    @Test
    public void testCablePath() {
        System.out.println("cablePath");
        //Arrange
        Stand s1 = new Stand("s1");
        List<Distance> distanceList = new ArrayList<>();
        Distance d1 = new Distance("s2", 13.3);
        Distance d2 = new Distance("s3", 3.3);
        distanceList.add(d1);
        distanceList.add(d2);
        s1.setDistanceList(distanceList);

        Stand s2 = new Stand("s2");
        List<Distance> distanceList2 = new ArrayList<>();
        Distance d3 = new Distance("s3", 5.5);
        distanceList2.add(d3);
        s2.setDistanceList(distanceList2);

        Stand s3 = new Stand("s3");

        List<Stand> stands = new ArrayList<>();
        stands.add(s1);
        stands.add(s2);
        stands.add(s3);

        ArrayList<StandConnection> expResult = new ArrayList<>();
        StandConnection c1 = new StandConnection("s1", "s3", 3.3);
        StandConnection c2 = new StandConnection("s2", "s3", 5.5);

        expResult.add(c1);
        expResult.add(c2);
        //Act
        List<StandConnection> result = CalculateElectricalCable.cablePath(stands);

        //Assert
        int i = 0;
        for (StandConnection e : expResult) {
            assertEquals(e.getA(), result.get(i).getA());
            assertEquals(e.getDist(), result.get(i).getDist());
            i++;
        }
    }
    
    /**
     * Test of cablePath method, of class CalculateElectricalCable.
     */
    @Test
    public void testCablePathSort() {
        System.out.println("cablePath");
        //Arrange
        Stand s1 = new Stand("stand 1");
        List<Distance> distanceList = new ArrayList<>();
        Distance d1 = new Distance("stand 2", 9.0);
        Distance d2 = new Distance("stand 3", 7.0);
        Distance d3 = new Distance("stand 4", 12.0);
        distanceList.add(d1);
        distanceList.add(d2);
        distanceList.add(d3);
        s1.setDistanceList(distanceList);

        Stand s2 = new Stand("stand 2");
        List<Distance> distanceList2 = new ArrayList<>();
        Distance d4 = new Distance("stand 7", 18.0);
        Distance d5 = new Distance("stand 5", 10.0);
        Distance d6 = new Distance("stand 3", 5.0);
        distanceList2.add(d4);
        distanceList2.add(d5);
        distanceList2.add(d6);
        s2.setDistanceList(distanceList2);

        Stand s3 = new Stand("stand 3");
        List<Distance> distanceList3 = new ArrayList<>();
        Distance d7 = new Distance("stand 4", 7.0);
        Distance d8 = new Distance("stand 5", 9.0);
        Distance d9 = new Distance("stand 6", 13.0);
        distanceList3.add(d7);
        distanceList3.add(d8);
        distanceList3.add(d9);
        s3.setDistanceList(distanceList3);
        
        Stand s4 = new Stand("stand 4");
        List<Distance> distanceList4 = new ArrayList<>();
        Distance d11 = new Distance("stand 8", 20.0);
        distanceList4.add(d11);
        s4.setDistanceList(distanceList4);
        
        Stand s5 = new Stand("stand 5");
        List<Distance> distanceList5 = new ArrayList<>();
        Distance d12 = new Distance("stand 6", 12.0);
        Distance d13 = new Distance("stand 7", 6.0);
        Distance d14 = new Distance("stand 9", 18.0);
        distanceList5.add(d12);
        distanceList5.add(d13);
        distanceList5.add(d14);
        s5.setDistanceList(distanceList5);
        
        Stand s6 = new Stand("stand 6");
        List<Distance> distanceList6 = new ArrayList<>();
        Distance d15 = new Distance("stand 8", 8.0);
        Distance d16 = new Distance("stand 9", 20.0);
        Distance d10 = new Distance("stand 4", 10.0);
        distanceList6.add(d15);
        distanceList6.add(d16);
        distanceList6.add(d10);
        s6.setDistanceList(distanceList6);
        
        Stand s7 = new Stand("stand 7");
        List<Distance> distanceList7 = new ArrayList<>();
        Distance d17 = new Distance("stand 8", 16.0);
        Distance d18 = new Distance("stand 9", 17.0);
        distanceList7.add(d17);
        distanceList7.add(d18);
        s7.setDistanceList(distanceList7);
        
        Stand s8 = new Stand("stand 8");
        List<Distance> distanceList8 = new ArrayList<>();
        Distance d19 = new Distance("stand 9", 15.0);
        distanceList8.add(d19);
        s8.setDistanceList(distanceList8);

        List<Stand> stands = new ArrayList<>();
        stands.add(s1);
        stands.add(s2);
        stands.add(s3);
        stands.add(s4);
        stands.add(s5);
        stands.add(s6);
        stands.add(s7);
        stands.add(s8);

        ArrayList<StandConnection> expResult = new ArrayList<>();
        StandConnection c1 = new StandConnection("stand 2", "stand 3", 5.0);
        StandConnection c2 = new StandConnection("stand 5", "stand 7", 6.0);
        StandConnection c3 = new StandConnection("stand 1", "stand 3", 7.0);
        StandConnection c4 = new StandConnection("stand 3", "stand 4", 7.0);
        StandConnection c5 = new StandConnection("stand 6", "stand 8", 8.0);
        StandConnection c6 = new StandConnection("stand 3", "stand 5", 9.0);
        StandConnection c7 = new StandConnection("stand 6", "stand 4", 10.0);
        StandConnection c8 = new StandConnection("stand 8", "stand 9", 15.0);

        expResult.add(c1);
        expResult.add(c2);
        expResult.add(c3);
        expResult.add(c4);
        expResult.add(c5);
        expResult.add(c6);
        expResult.add(c7);
        expResult.add(c8);
        
        //Act
        List<StandConnection> result = CalculateElectricalCable.cablePath(stands);

        //Assert
        int i = 0;
        for (StandConnection e : expResult) {
            assertEquals(e.getA(), result.get(i).getA());
            assertEquals(e.getB(), result.get(i).getB());
            assertEquals(e.getDist(), result.get(i).getDist());
            i++;
        }
    }

    /**
     * Test of cableLength method, of class CalculateElectricalCable.
     */
    @Test
    public void testCableLength() {
        System.out.println("cableLength");
        //Arrange
        ArrayList<StandConnection> tree = new ArrayList<>();
        StandConnection c1 = new StandConnection("a", "b", 5.24);
        StandConnection c2 = new StandConnection("a", "b", 5.24);
        tree.add(c1);
        tree.add(c2);
        double expResult = 10.48;
        //Act
        double result = CalculateElectricalCable.cableLength(tree);
        //Assert
        assertEquals(expResult, result);
    }

}

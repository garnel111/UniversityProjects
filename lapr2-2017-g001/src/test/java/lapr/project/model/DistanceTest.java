/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package lapr.project.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Altran
 */
public class DistanceTest {
    
    @Test
    public void equalsValueTest() {
        Distance distance = new Distance();
        Distance distance1 = new Distance();
        distance.setValue(22.5);
        distance1.setValue(22.5);
        
        assertEquals(distance1.getValue(), distance.getValue());
        
    }
    
    @Test
    public void notEqualsValueTest() {
        Distance distance = new Distance();
        Distance distance1 = new Distance();
        distance.setValue(22.5);
        distance1.setValue(21.5);
        
        assertNotEquals(distance1.getValue(), distance.getValue());
        
    }
    
    @Test
    public void equalsDescriptionTest() {
        Distance distance = new Distance();
        Distance distance1 = new Distance();
        distance.setDescription("descricao");
        distance1.setDescription("descricao");
        
        assertEquals(distance1.getDescription(), distance.getDescription());
        
    }
    
    @Test
    public void notEqualsDescriptionTest() {
        Distance distance = new Distance();
        Distance distance1 = new Distance();
        distance.setDescription("descricao");
        distance1.setDescription("descricao1");
        
        assertNotEquals(distance1.getDescription(), distance.getDescription());
        
    }
    
    @Test
    public void hashCodeTest() {
        
        Distance distance = new Distance();
        Distance distance1 = new Distance();
        assertEquals(distance.hashCode(), distance1.hashCode());
    }
    
    @Test
    public void testEqualsDistanceObjects() {
        Distance distance = new Distance();
        Distance distance1 = new Distance();
        
        distance.setDescription("descricao");
        distance1.setDescription("descricao");
        distance.setValue(22.5);
        distance1.setValue(22.5);
        
        assertTrue(distance.equals(distance1));
    }
    
    @Test
    public void testDiferentDistanceObjects() {
        Distance distance = new Distance();
        Distance distance1 = new Distance();
        
        distance.setDescription("descricao");
        distance1.setDescription("descricao");
        distance.setValue(21.5);
        distance1.setValue(22.5);
        
        assertFalse(distance.equals(distance1));
    }
    
    @Test
    public void testFalseDescritionObjects() {
        Distance distance = new Distance();
        Distance distance1 = new Distance();
        
        distance.setDescription("descricao1");
        distance1.setDescription("descricao");
        
        assertFalse(distance.equals(distance1));
    }
    
    @Test
    public void testFalseClassObjects() {
        Distance distance = new Distance();
        Distance distance1 = new Distance();
        Organiser org = new Organiser();
        distance.setDescription("descricao1");
        distance1.setDescription("descricao");
        
        assertFalse(distance.equals(org));
    }
    
    @Test
    public void testEqualsObjects() {
        
        Distance distance1 = new Distance();
        
        distance1.setDescription("descricao");
        
        distance1.setValue(22.5);
        
        assertTrue(distance1.equals(distance1));
    }
    
    @Test
    public void testToString() {
        Distance distance = new Distance();
        distance.setDescription("descricao1");
        distance.setValue(21.5);
        String expecteds = "description= descricao1, value= 21.5\n";//distance.toString();
        distance.getValue().toString();
        //Arrange
        String result = distance.toString();
        
        //Act
        assertEquals(expecteds, result);
    }
    
    @Test
    public void testCompareTo() {
        Distance distance = new Distance();
        Distance distance1 = new Distance();
        distance.setDescription("descricao");
        distance1.setDescription("descricao");
        distance.setValue(22.6);
        distance1.setValue(222222.55);
        distance.compareTo(distance1);
        assertTrue((distance.getValue() < distance1.getValue()));
        
    }
    
    @Test
    public void testFalseObjects() {
        
        Distance distance1 = new Distance();
        Distance distance2 = null;
        distance1.setDescription("descricao");
        
        distance1.setValue(22.5);
        
        assertFalse(distance1.equals(distance2));
    }
    
    @Test
    public void testHashCode() {
        
        Distance distance = new Distance();
        distance.setValue(21.5);
        distance.setDescription("descriction");
        int dis = distance.hashCode();
        assertEquals(-1773172174, dis);
        
    }
    
    @Test
    public void testHashCode2() {
        Distance distance = new Distance();
        distance.setValue(21.5);
        distance.setDescription("descriction");
        int dis = distance.getDescription().hashCode();
        assertEquals(-1736551825, dis);
        
    }
    
    @Test
    public void testCompareTo2() {
        Distance distance = new Distance();
        Distance distance1 = new Distance();
        distance.setDescription("descricao");
        distance1.setDescription("descricao");
        distance.setValue(0.000);
        distance1.setValue(1.0);
        distance.compareTo(distance1);
        
        assertTrue((distance.getValue() < distance1.getValue()));
        
    }
    
    @Test
    public void testCompareToNull() {
        Distance distance = new Distance();
        Distance distance1 = null;
        distance.setDescription(null);
        distance.setValue(0.000);
        distance.compareTo(distance1);
        
        assertTrue(distance.compareTo(distance1) == 0);
        
    }
    
    @Test
    public void testCompareToAslmostEquals() {
        Distance distance1 = new Distance();
        Distance distance2 = new Distance();
        distance1.setDescription("descricao");
        distance2.setDescription("descricao");
        distance1.setValue(0.0001);
        distance2.setValue(0.0002);
        assertTrue((Math.abs(distance1.getValue() - distance2.getValue()) > 0.00001));
        
    }
    
    @Test
    public void testCompareToInferior() {
        Distance distance1 = new Distance();
        Distance distance2 = new Distance();
        distance1.setDescription("descricao");
        distance2.setDescription("descricao");
        distance1.setValue(0.0000);
        distance2.setValue(0.23231234);
        assertTrue(distance1.compareTo(distance2) < 0);
        
    }
    
    @Test
    public void testCompareToSuperior() {
        Distance distance1 = new Distance();
        Distance distance2 = new Distance();
        distance1.setDescription("descricao");
        distance2.setDescription("descricao");
        distance1.setValue(0.0000);
        distance2.setValue(0.23231234);
        assertTrue(distance2.compareTo(distance1) > 0);
        
    }
    
    @Test
    public void testCompareToEqual() {
        Distance distance1 = new Distance();
        Distance distance2 = new Distance();
        distance1.setDescription("descricao");
        distance2.setDescription("descricao");
        distance1.setValue(0.0000);
        distance2.setValue(0.00000);
        assertTrue(distance2.compareTo(distance1) == 0);
        
    }
}

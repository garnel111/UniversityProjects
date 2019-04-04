/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author josemagalhaes
 */
public class SlotTest {

    public SlotTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Slot.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Slot instance = new Slot();
        instance.setId(10);
        instance.getId();
        int expResult = 10;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetBikeId() {
        System.out.println("get Bike and Park Id");

        Bicycle bike = new Bicycle();
        Park park = new Park();
        Slot slot = new Slot();

        slot.setParkId(12);
        slot.setBikeId(15);
        assertNotNull(slot.getBikeId());
        assertNotNull(slot.getParkId());

    }

    @Test
    public void testGetIdBig() {
        System.out.println("getId");
        Slot instance = new Slot();
        instance.setId(999999999);
        instance.getId();
        int expResult = 999999999;
        int result = instance.getId();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetIdBigNegative() {
        System.out.println("getId");
        Slot instance = new Slot();
        instance.setId(-999999999);
        instance.getId();
        int expResult = -999999999;
        int result = instance.getId();
        assertEquals(expResult, result);
    }
}

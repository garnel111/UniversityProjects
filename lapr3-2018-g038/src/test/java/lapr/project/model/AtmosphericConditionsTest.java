package lapr.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AtmosphericConditionsTest {

    @Test
    void getOrganization_Id() {
        AtmosphericConditions at = new AtmosphericConditions(1,2,3,4);
        assertEquals(1,at.getOrganization_Id());
    }

    @Test
    void setOrganization_Id() {
        AtmosphericConditions at = new AtmosphericConditions(1,2,3,4);
        at.setOrganization_Id(10);
        assertEquals(10,at.getOrganization_Id());
    }

    @Test
    void getOriginPark_Id() {
        AtmosphericConditions at = new AtmosphericConditions(1,2,3,4);
        assertEquals(2,at.getOriginPark_Id());
    }

    @Test
    void setOriginPark_Id() {
        AtmosphericConditions at = new AtmosphericConditions(1,2,3,4);
        at.setOriginPark_Id(100);
        assertEquals(100,at.getOriginPark_Id());
    }

    @Test
    void getDestinyPArk_Id() {
        AtmosphericConditions at = new AtmosphericConditions(1,2,3,4);
        assertEquals(3,at.getDestinyPArk_Id());
    }

    @Test
    void setDestinyPArk_Id() {
        AtmosphericConditions at = new AtmosphericConditions(1,2,3,4);
        at.setDestinyPArk_Id(1000);
        assertEquals(1000,at.getDestinyPArk_Id());
    }

    @Test
    void getWayDirection() {
        AtmosphericConditions at = new AtmosphericConditions(1,2,3,4);
        assertEquals(4,at.getWayDirection());
    }

    @Test
    void setWayDirection() {
        AtmosphericConditions at = new AtmosphericConditions(1,2,3,4);
        at.setWayDirection(40);
        assertEquals(40,at.getWayDirection());
    }
}
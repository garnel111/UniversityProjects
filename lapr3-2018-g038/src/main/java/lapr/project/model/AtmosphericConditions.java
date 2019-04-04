package lapr.project.model;

public class AtmosphericConditions {

    private long organization_Id;
    private long originPark_Id;
    private long  destinyPArk_Id;
    private long wayDirection;


    public AtmosphericConditions(long organization_Id, long originPark_Id, long destinyPArk_Id, long wayDirection) {
        this.organization_Id = organization_Id;
        this.originPark_Id = originPark_Id;
        this.destinyPArk_Id = destinyPArk_Id;
        this.wayDirection = wayDirection;
    }


    public long getOrganization_Id() {
        return organization_Id;
    }

    public void setOrganization_Id(long organization_Id) {
        this.organization_Id = organization_Id;
    }

    public long getOriginPark_Id() {
        return originPark_Id;
    }

    public void setOriginPark_Id(long originPark_Id) {
        this.originPark_Id = originPark_Id;
    }

    public long getDestinyPArk_Id() {
        return destinyPArk_Id;
    }

    public void setDestinyPArk_Id(long destinyPArk_Id) {
        this.destinyPArk_Id = destinyPArk_Id;
    }

    public long getWayDirection() {
        return wayDirection;
    }

    public void setWayDirection(long wayDirection) {
        this.wayDirection = wayDirection;
    }
}


package lapr.project.model;

import lapr.project.data.PoiDB;

/**
 * @author josemagalhaes
 */
public class POI {

    private long id;
    private String name;
    private String type;
    private float latitude;
    private float longitude;
    private long organizationId;
    private PoiDB poiDb;


    public POI() {
    }

    public POI(long id, String name, String type, float latitude, float longitude, long organizationId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
        this.organizationId = organizationId;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(long organizationId) {
        this.organizationId = organizationId;
    }

    /*
     *Acrescentado depois
     */

    public POI getPOIByName(String poiOrigin) {
        PoiDB poiDB = new PoiDB();

        return poiDB.getPoiByName(poiOrigin);
    }

    public void setPOIDB(PoiDB poiDB) {
        this.poiDb = poiDB;
    }
}


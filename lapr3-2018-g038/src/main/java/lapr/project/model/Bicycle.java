package lapr.project.model;

public class Bicycle {

    private long idBicycle;
    private float bicycleMass;
    private float km;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description = null;
    private String type;

    /**
     * Constructor bicycle with mass, km and type
     *
     * @param bicycleMass mass
     * @param km          km bicycle
     * @param type        type of bicycle
     */
    public Bicycle(float bicycleMass, float km, String type) {
        this.bicycleMass = bicycleMass;
        this.km = km;
        this.type = type;
    }

    /**
     * Empty constructor
     */
    public Bicycle() {
    }

    /**
     * Get id bicycle
     *
     * @return id bicycle
     */
    public long getIdBicycle() {
        return idBicycle;
    }

    /**
     * Set new id bicycle
     *
     * @param idBicycle new id bicycle
     */
    public void setIdBicycle(long idBicycle) {
        this.idBicycle = idBicycle;
    }

    /**
     * Get bicycle mass
     *
     * @return bicycle mass
     */
    public float getBicycleMass() {
        return bicycleMass;
    }

    /**
     * Set bicycle mass
     *
     * @param bicycleMass new bicycle mass
     */
    public void setBicycleMass(float bicycleMass) {
        this.bicycleMass = bicycleMass;
    }

    /**
     * Get bicycle km
     *
     * @return bicycle km
     */
    public float getKm() {
        return km;
    }

    /**
     * Set bicycle km
     *
     * @param km km of bicycle
     */
    public void setKm(float km) {
        this.km = km;
    }

    /**
     * Get type of bicycle
     *
     * @return type of bicycle
     */
    public String getType() {
        return type;
    }

    /**
     * Set type of bicycle
     *
     * @param type type of bicycle
     */
    public void setType(String type) {
        this.type = type;
    }

}

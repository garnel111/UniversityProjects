package lapr.project.model;

public class ElectricBike extends Bicycle {

    private float charge;
    private float maxBatteryValue;
    private float currentyBatteryLevel;
    private String ELECTRIC ="Electric";

    public ElectricBike(float bicycleMass, float km, String type) {
        super(bicycleMass, km, type);
    }

    public ElectricBike() {
    }

    public float getCharge() {
        return charge;
    }

    public void setCharge(float charge) {
        this.charge = charge;
    }

    public float getMaxBatteryValue() {
        return maxBatteryValue;
    }

    public void setMaxBatteryValue(float maxBatteryValue) {
        this.maxBatteryValue = maxBatteryValue;
    }

    public float getCurrentyBatteryLevel() {
        return currentyBatteryLevel;
    }

    public void setCurrentyBatteryLevel(float currentyBatteryLevel) {
        this.currentyBatteryLevel = currentyBatteryLevel;
    }

    public void setCharge(String type, float chargeValue) {
        if (type.equals(ELECTRIC)) {
            this.charge = chargeValue;
        }
    }

    public void setMaxBattery(float maxValue) {
        this.maxBatteryValue = maxValue;
    }

    public void setCurrentyBattery(float currentBatteryValue) {
        this.currentyBatteryLevel =  currentBatteryValue;
    }
}

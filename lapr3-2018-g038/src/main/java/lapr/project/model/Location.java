package lapr.project.model;

public class Location {

    Park parque;
    POI poi;



    public Location(){
        this.parque = null;
        this.poi = null;
    }

    public Location(Park p){
        this.parque = p;
        this.poi = null;
    }

    public Location(POI ponto){
        this.poi = ponto;
        this.parque = null;
    }

    public <V> Location(V vOrig) {
        this.parque = vOrig instanceof Park ? (Park)vOrig : null;
        this.poi = vOrig instanceof POI ? (POI)vOrig : null;
    }


    public Object getLocation(){
        return parque != null ? parque : poi;
    }

    public boolean setLocation(Object loc){
        if (loc instanceof Park){
            this.parque = (Park)loc;
            return true;
        } else if(loc instanceof POI){
            this.poi = (POI)loc;
            return true;
        } else{
            return false;
        }
    }



    public long getId(){
        return parque != null ? parque.getId() : poi.getId();
    }

    public String getName(){
        return parque != null ? parque.getName() : poi!=null? poi.getName():null;
    }

    public float getLatitude(){
        return parque != null ? parque.getLatitude() : poi.getLatitude();
    }

    public float getLongitude(){
        return parque != null ? parque.getLongitude() : poi.getLongitude();
    }




    public Park getParque() {
        return parque;
    }

    public void setParque(Park parque) {
        this.parque = parque;
    }

    public POI getPoi() {
        return poi;
    }

    public void setPoi(POI poi) {
        this.poi = poi;
    }
}

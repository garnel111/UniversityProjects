/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.Objects;

/**
 *
 * @author JM
 */
public class StandConnection implements Comparable<StandConnection> {

    private String a;
    private String b;
    private double dist;

    /**
     * Constructor
     * @param a First Stand description of the connection
     * @param b Second Stand description
     * @param dist Distance betweenStands
     */
    public StandConnection(String a, String b, double dist) {
        this.a = a;
        this.b = b;
        this.dist = dist;
    }

    /**
     * @return the a
     */
    public String getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(String a) {
        this.a = a;
    }

    /**
     * @return the b
     */
    public String getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(String b) {
        this.b = b;
    }

    /**
     * @return the dist
     */
    public double getDist() {
        return dist;
    }

    /**
     * @param dist the dist to set
     */
    public void setDist(double dist) {
        this.dist = dist;
    }


    @Override
    public int compareTo(StandConnection o) {
        if (this.getDist() < o.getDist()) {
            return -1;
        }
        if (this.getDist() > o.getDist()) {
            return 1;
        }
        
        return 0;
    }

    @Override
    public String toString() {
        return getA() + " --> " + getB() + "  (" + getDist() + " meters)";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return false;
        }
        if(this.getClass()!=obj.getClass()){
            return false;
        }
        return (this.getA().equals(((StandConnection) obj).getA())) && (this.getB().equals(((StandConnection) obj).getB()))
                && (Double.compare(this.getDist(), ((StandConnection) obj).getDist()) == 0);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.getA());
        hash = 43 * hash + Objects.hashCode(this.getB());
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.getDist()) ^ (Double.doubleToLongBits(this.getDist()) >>> 32));
        return hash;
    }
}

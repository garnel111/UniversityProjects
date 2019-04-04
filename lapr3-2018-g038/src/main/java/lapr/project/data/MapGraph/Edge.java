/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.data.mapGraph;

import java.lang.reflect.Array;
import java.util.Objects;

/**
 *
 * @author mjdg1
 */
public class Edge<V, E> implements Comparable<Edge<V, E>>{
        private E element;           // Edge information
    private double weight;       // Edge weight
    private Vertex<V, E> vOrig;  // vertex origin
    private Vertex<V, E> vDest;  // vertex destination

    public Edge() {
        element = null;
        weight = 0.0;
        vOrig = null;
        vDest = null;
    }

    public Edge(E eInf, double ew, Vertex<V, E> vo, Vertex<V, E> vd) {
        element = eInf;
        weight = ew;
        vOrig = vo;
        vDest = vd;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E eInf) {
        element = eInf;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double ew) {
        weight = ew;
    }

    public V getVOrig() {
        return vOrig.getElement();
    }

    public void setVOrig(Vertex<V, E> vo) {
        vOrig = vo;
    }

    public V getVDest() {
        return vDest.getElement();
    }

    public void setVDest(Vertex<V, E> vd) {
        vDest = vd;
    }

    public V[] getEndpoints() {

        V oElem = vOrig.getElement();
        V dElem = vDest.getElement(); // To get type

        @SuppressWarnings("unchecked")
        V[] endverts = (V[]) Array.newInstance(oElem.getClass(), 2);

        endverts[0] = oElem;
        endverts[1] = dElem;

        return endverts;
    }

    @Override
    public boolean equals(Object otherObj) {

        if (this == otherObj) {
            return true;
        }

        if (otherObj == null || this.getClass() != otherObj.getClass()) {
            return false;
        }

        @SuppressWarnings("unchecked")
        Edge<V, E> otherEdge = (Edge<V, E>) otherObj;

        // if endpoints vertices are not equal
        if (!this.vOrig.equals(otherEdge.vOrig) || !this.vDest.equals(otherEdge.vDest)) {
            return false;
        }

        if (this.weight != otherEdge.weight) {
            return false;
        }

        if (this.element != null && otherEdge.element != null) {
            return this.element.equals(otherEdge.element);
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(element, weight, vOrig, vDest);
    }

    @Override
    public int compareTo(Edge<V, E> otherObject) {

        Edge<V, E> other = otherObject;
        if (this.weight < other.weight) {
            return -1;
        }
        if (this.weight == other.weight) {
            return 0;
        }
        return 1;
    }

    @Override
    public Edge<V, E> clone() {

        Edge<V, E> newEdge = new Edge<>();

        newEdge.element = element;
        newEdge.weight = weight;
        newEdge.vOrig = vOrig;
        newEdge.vDest = vDest;

        return newEdge;
    }

    @Override
    public String toString() {
        String st = "";
        if (element != null) {
            st = "      (" + element + ") - ";
        } else {
            st = "\t ";
        }

        if (weight != 0) {
            st += weight + " - " + vDest.getElement() + "\n";
        } else {
            st += vDest.getElement() + "\n";
        }

        return st;
    }
}

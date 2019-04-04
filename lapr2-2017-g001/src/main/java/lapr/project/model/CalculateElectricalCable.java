/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author JM
 */
public class CalculateElectricalCable {

    /**
     * Constructor
     */
    private CalculateElectricalCable() {

    }

    /**
     * Method to calculate the minimum cable path
     *
     * @param stands List of existing stands
     * @return List of the minimum path tree
     */
    public static List<StandConnection> cablePath(List<Stand> stands) {

        //Gerar as ligações existentes em formato StandConnection
        List<StandConnection> connections = generateConnections(stands);

        //Sort connections por distância, crescente
        Collections.sort(connections);

        ArrayList<ArrayList<StandConnection>> tree = new ArrayList<>();

        int indexA = 0;
        int indexB = 0;

        for (StandConnection c : connections) {
            boolean foundA = false;
            boolean foundB = false;
            for (int i = 0; i < tree.size(); i++) {
                for (StandConnection sc : tree.get(i)) {
                    if (c.getA().equals(sc.getA()) || c.getA().equals(sc.getB())) {
                        indexA = i;
                        foundA = true;
                    }
                    if (c.getB().equals(sc.getB()) || c.getB().equals(sc.getA())) {
                        indexB = i;
                        foundB = true;
                    }
                }
            }
            //Se não existir
            if (!foundA && !foundB) {
                ArrayList<StandConnection> novo = new ArrayList<>();
                novo.add(c);
                tree.add(novo);
            }
            //Se existir
            if (foundA && !foundB) {
                tree.get(indexA).add(c);
            }
            if (!foundA && foundB) {
                tree.get(indexB).add(c);
            }
            if ((foundA && foundB) && (indexA != indexB)) {
                tree.get(indexA).add(c);
                if (indexB < indexA) {
                    int index = indexA;
                    indexA = indexB;
                    indexB = index;
                }
                for (StandConnection s : tree.get(indexB)) {
                    tree.get(indexA).add(s);
                }
                tree.remove(indexB);
            }
        }

        //Ordena a final
        Collections.sort(tree.get(0));

        return tree.get(0);
    }

    /**
     * Method to calculate the minimum amount of cable length
     *
     * @param tree Minimum path tree previously generated
     * @return Return the length
     */
    public static double cableLength(List<StandConnection> tree) {
        double length = 0.0;

        for (StandConnection list : tree) {
            length += list.getDist();
        }
        return length;
    }

    /**
     * Generates StandConnection connections based on the Stand list
     *
     * @param stands Stand list of the existing stands
     * @return List of StandConnection with the existing connections
     */
    public static List<StandConnection> generateConnections(List<Stand> stands) {
        ArrayList<StandConnection> connections = new ArrayList<>();

        for (Stand temp : stands) {
            if (temp.getDistanceList() != null) {
                List<Distance> distancias = temp.getDistanceList();

                for (Distance temp2 : distancias) {
                    StandConnection c = new StandConnection(temp.getDescription(), temp2.getDescription(), temp2.getValue());
                    connections.add(c);
                }
            }
        }
        return connections;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.data.mapGraph;

import lapr.project.model.Location;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author mjdg1
 */
public class GraphAlgorithms {

    private GraphAlgorithms(){

    }
    /**
     * Parte da resolução da alinea 2
     * Performs breadth-first search of a Graph starting in a Vertex
     *
     * @param g Graph instance
     * @return qbfs a queue with the vertices of breadth-first search
     */
    public static <V, E> LinkedList<V> a2_1_BreadthFirstSearch(Graph<V, E> g, V vert) {
        if (!g.validVertex(vert)) {
            return null;
        }

        LinkedList<V> qbfs = new LinkedList<>();
        LinkedList<V> qaux = new LinkedList<>();
        boolean[] visited = new boolean[g.numVertices()];  //default initializ.: false

        qbfs.add(vert);
        qaux.add(vert);
        int vKey = g.getKey(vert);
        visited[vKey] = true;

        while (!qaux.isEmpty()) {
            vert = qaux.remove();
            for (Edge<V, E> edge : g.outgoingEdges(vert)) {
                V vAdj = g.opposite(vert, edge);
                vKey = g.getKey(vAdj);
                if (!visited[vKey]) {
                    qbfs.add(vAdj);
                    qaux.add(vAdj);
                    visited[vKey] = true;
                }
            }
        }
        return qbfs;
    }

    /**
     * Performs depth-first search starting in a Vertex
     *
     * @param g Graph instance
     * @param vOrig Vertex of graph g that will be the source of the search
     * @param visited set of discovered vertices
     * @param qdfs queue with vertices of depth-first search
     */
    private static <V, E> void DepthFirstSearch(Graph<V, E> g, V vOrig, boolean[] visited, LinkedList<V> qdfs) {
        qdfs.add(vOrig);
        int vKey = g.getKey(vOrig);
        visited[vKey] = true;

        for (Edge<V, E> edge : g.outgoingEdges(vOrig)) {
            V vAdj = g.opposite(vOrig, edge);
            vKey = g.getKey(vAdj);

            if (!visited[vKey]) {
                DepthFirstSearch(g, vAdj, visited, qdfs);
            }
        }
    }

    /**
     * @param g Graph instance
     * @return qdfs a queue with the vertices of depth-first search
     */
    public static <V, E> LinkedList<V> DepthFirstSearch(Graph<V, E> g, V vert) {
        if (!g.validVertex(vert)) {
            return null;
        }

        LinkedList<V> qdfs = new LinkedList<>();
        boolean[] visited = new boolean[g.numVertices()];
        DepthFirstSearch(g, vert, visited, qdfs);

        return qdfs;
    }

    /**
     * Returns all paths from vOrig to vDest
     *
     * @param g Graph instance
     * @param vOrig Vertex that will be the source of the path
     * @param vDest Vertex that will be the end of the path
     * @param visited set of discovered vertices
     * @param path stack with vertices of the current path (the path is in
     * reverse order)
     * @param paths ArrayList with all the paths (in correct order)
     */
    private static <V, E> void allPaths(Graph<V, E> g, V vOrig, V vDest, boolean[] visited, LinkedList<V> path, ArrayList<LinkedList<V>> paths) {
        path.push(vOrig);
        int vKey = g.getKey(vOrig);
        visited[vKey] = true;

        for (Edge<V, E> edge : g.outgoingEdges(vOrig)) {
            V vAdj = g.opposite(vOrig, edge);
            if (vAdj == vDest) {
                path.push(vAdj);
                LinkedList<V> revpath = revPath(path);
                paths.add(new LinkedList<>(revpath));  //save clone of reverse path
                path.pop();
            } else {
                vKey = g.getKey(vAdj);
                if (!visited[vKey]) {
                    allPaths(g, vAdj, vDest, visited, path, paths);
                }
            }
        }

        visited[vKey] = false;
        path.pop();
    }

    /**
     * @param g Graph instance
     * @return paths ArrayList with all paths from voInf to vdInf
     */
    public static <V, E> ArrayList<LinkedList<V>> allPaths(Graph<V, E> g, V vOrig, V vDest) {
        LinkedList<V> path = new LinkedList<>();
        ArrayList<LinkedList<V>> paths = new ArrayList<>();
        boolean[] visited = new boolean[g.numVertices()];

        if (g.validVertex(vOrig) && g.validVertex(vDest)) {
            allPaths(g, vOrig, vDest, visited, path, paths);

        }

        return paths;
    }

    /**
     * Computes shortest-path distance from a source vertex to all reachable
     * vertices of a graph g with nonnegative edge weights This implementation
     * uses Dijkstra's algorithm
     *
     * @param g Graph instance
     * @param vOrig Vertex that will be the source of the path
     * @param visited set of discovered vertices
     * @param dist minimum distances
     */
    private static <V, E> void shortestPathLength(Graph<V, E> g, V vOrig, V[] vertices, boolean[] visited, int[] pathKeys, double[] dist) {
        int vkey = g.getKey(vOrig);
        dist[vkey] = 0;

        while (vkey != -1) {
            vOrig = vertices[vkey];
            visited[vkey] = true;

            for (Edge<V, E> edge : g.outgoingEdges(vOrig)) {
                V vAdj = g.opposite(vOrig, edge);
                int vkeyAdj = g.getKey(vAdj);

                if (!visited[vkeyAdj] && dist[vkeyAdj] > dist[vkey] + edge.getWeight()) {
                    dist[vkeyAdj] = dist[vkey] + edge.getWeight();
                    pathKeys[vkeyAdj] = vkey;

                }
            }

            double minDist = Double.MAX_VALUE;
            vkey = -1;

            for (int i = 0; i < g.numVertices(); i++) {

                if (!visited[i] && dist[i] < minDist) {
                    minDist = dist[i];
                    vkey = i;
                }

            }
        }
    }

    /**
     * Extracts from pathKeys the minimum path between voInf and vdInf The path
     * is constructed from the end to the beginning
     *
     * @param g Graph instance
     * @param path stack with the minimum path (correct order)
     */
    private static <V, E> void getPath(Graph<V, E> g, V vOrig, V vDest, V[] verts, int[] pathKeys, LinkedList<V> path) {
        if (!(((Location)vOrig).getName().equals(((Location)vDest).getName()))) {
            path.push(vDest);
            int vKey = g.getKey(vDest);
            int prevVKey = pathKeys[vKey];
            vDest = verts[prevVKey];
            getPath(g, vOrig, vDest, verts, pathKeys, path);
        } else {
            path.push(vOrig);
        }
    }

    //shortest-path between voInf and vdInf
    public static <V, E> double shortestPath(Graph<V, E> g, V vOrig, V vDest, LinkedList<V> shortPath) {
        if (!g.validLocation((Location)vOrig) || !g.validLocation((Location)vDest)) {
            return 0;
        }

        int nverts = g.numVertices();
        boolean[] visited = new boolean[nverts]; //default value: false
        int[] pathKeys = new int[nverts];
        double[] dist = new double[nverts];
        V[] vertices = g.allkeyVerts();

        for (int i = 0; i < nverts; i++) {
            dist[i] = Double.MAX_VALUE;
            pathKeys[i] = -1;
        }

        shortestPathLength(g, vOrig, vertices, visited, pathKeys, dist);
        double lengthPath = dist[g.getKey(vDest)];

        if (lengthPath != Double.MAX_VALUE) {
            getPath(g, vOrig, vDest, vertices, pathKeys, shortPath);
            return lengthPath;
        }

        return 0;
    }

    /**
     * Reverses the path
     *
     * @param path stack with path
     */
    private static <V, E> LinkedList<V> revPath(LinkedList<V> path) {
        LinkedList<V> pathcopy = new LinkedList<>(path);
        LinkedList<V> pathrev = new LinkedList<>();

        while (!pathcopy.isEmpty()) {
            pathrev.push(pathcopy.pop());
        }

        return pathrev;
    }

}

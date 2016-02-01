/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author stoilov
 */
public class DirectedGraph extends WeightedGraph {

    private Double[][] edges;

    public DirectedGraph(int size) {
        edges = new Double[size][size];
    }

    @Override
    public void addEdge(int i, int j, double weight) {
        edges[i][j] = weight;
    }

    @Override
    public boolean hasEdge(int i, int j) {
        return edges[i][j] != null;
    }

    @Override
    public ArrayList<Integer> neighbours(int i) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int j = 0; j < size(); j++) {
            if (hasEdge(i, j)) {
                result.add(j);
            }
        }

        return result;
    }

    @Override
    public int size() {
        return edges.length;
    }

    public double cost(int i, int j) {
        if (i == j) {
            return 0;
        }

        if (edges[i][j] == null) {
            return Double.POSITIVE_INFINITY;
        }

        return edges[i][j];
    }

    private int cheapest(double[] distances, boolean[] visited) {
        int best = -1;

        for (int i = 0; i < distances.length; i++) {
            if (!visited[i] && (best < 0 || distances[i] < distances[best])) {
                best = i;
            }
        }

        return best;
    }

    public double[] distancesFrom(int vertex) {
        double[] result = new double[size()];
        Arrays.fill(result, Double.POSITIVE_INFINITY);
        result[vertex] = 0;
        boolean[] visited = new boolean[size()];

        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges.length; j++) {
                result[j] = Math.min(result[j], result[vertex] + cost(vertex, j));
            }

            visited[vertex] = true;
            vertex = cheapest(result, visited);
        }

        return result;
    }

    public double[][] floyd() {
        double[][] result = new double[size()][size()];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                result[i][j] = cost(i, j);
            }
        }

        double midpath;
        for (int middle = 0; middle < result.length; middle++) {
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    midpath = result[i][middle] + result[middle][j];
                    if (result[i][j] > midpath) {
                        result[i][j] = midpath;
                    }
                }
            }
        }

        return result;
    }

}

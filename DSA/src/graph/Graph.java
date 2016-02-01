/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;
import linearStructures.Queue;

/**
 *
 * @author stoilov
 */
public abstract class Graph {

    abstract ArrayList<Integer> neighbours(int i);

    abstract int size();

    abstract boolean hasEdge(int i, int j);

    public ArrayList<Integer> depthFirstTraverse(int initial) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[size()];

        depthFirstTraverse(initial, result, visited);

        return result;
    }

    private void depthFirstTraverse(int vertex, ArrayList<Integer> result, boolean[] visited) {
        visited[vertex] = true;
        result.add(vertex);

        ArrayList<Integer> neighbours = neighbours(vertex);

        neighbours.stream()
                .filter((neighbour) -> (!visited[neighbour]))
                .forEach((neighbour) -> depthFirstTraverse(neighbour, result, visited));
    }

    public ArrayList<Integer> breadthFirstSearch(int initial) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[size()];
        Queue<Integer> queue = new Queue<>();

        visited[initial] = true;
        queue.enqueue(initial);

        while (!queue.isEmpty()) {
            int current = queue.dequeue();
            result.add(current);
            ArrayList<Integer> neighbours = neighbours(current);

            for (Integer neighbour : neighbours) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.enqueue(neighbour);
                }
            }
        }

        return result;
    }

}

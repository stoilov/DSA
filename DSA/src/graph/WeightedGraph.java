/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author stoilov
 */
public abstract class WeightedGraph extends Graph {

    abstract void addEdge(int i, int j, double weight);

}

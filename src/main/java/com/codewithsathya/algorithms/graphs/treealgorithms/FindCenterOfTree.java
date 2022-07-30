package com.codewithsathya.algorithms.graphs.treealgorithms;

import java.util.*;
import com.codewithsathya.algorithms.graphs.generators.UndirectedUnweighted;

public class FindCenterOfTree {
    public static <E> List<E> findCentersOfTree(E[][] edges){
        Map<E, List<E>> graph = UndirectedUnweighted.getAdjacencyList(edges);
        Map<E, Integer> degree = new HashMap<>();
        List<E> leaves = new ArrayList<>();
        for(E node: graph.keySet()){
            int noOfNeighbours = graph.get(node).size();
            degree.put(node, noOfNeighbours);
            if(degree.get(node) == 0 || degree.get(node) == 1){
                leaves.add(node);
                degree.put(node, 0);
            }
        }
        int count = leaves.size();
        while(count < graph.size()){
            List<E> newLeaves = new ArrayList<>();
            for(E node: leaves){
                for(E neighbour: graph.get(node)){
                    degree.put(neighbour, degree.get(neighbour) - 1);
                    if(degree.get(neighbour) == 1){
                        newLeaves.add(neighbour);
                    }
                }
                degree.put(node, 0);
            }
            count += newLeaves.size();
            leaves = newLeaves;
        }
        return leaves;
    }

    public static void main(String[] args) {
        Integer[][] edges = {{6, 9}, {6, 3}, {3, 7}, {2, 3}, {1, 3}, {1, 4}, {4, 8}, {4, 5}, {0, 1}};
        List<Integer> centers = findCentersOfTree(edges);
        System.out.println(centers);
    }
}

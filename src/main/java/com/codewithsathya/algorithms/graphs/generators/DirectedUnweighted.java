package com.codewithsathya.algorithms.graphs.generators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectedUnweighted {
    public static class ToNode<E>{
        E to;
        double weight;

        public ToNode(E to, double weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static class Edge<E>{
        E from, to;
        double weight;

        public Edge(E from, E to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static <E> Map<E, List<ToNode<E>>> getAdjacencyList(Edge<E>[] edges){
        Map<E, List<ToNode<E>>> adjacencyList = new HashMap<>();
        for(Edge<E> edge: edges){
            if(!adjacencyList.containsKey(edge.from)){
                adjacencyList.put(edge.from, new ArrayList<>());
            }
            if(!adjacencyList.containsKey(edge.to)){
                adjacencyList.put(edge.to, new ArrayList<>());
            }
            adjacencyList.get(edge.from).add(new ToNode<>(edge.to, edge.weight));
        }
        return adjacencyList;
    }
}

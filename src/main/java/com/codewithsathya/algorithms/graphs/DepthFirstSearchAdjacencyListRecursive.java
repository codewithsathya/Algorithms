package com.codewithsathya.algorithms.graphs;

import java.util.*;

public class DepthFirstSearchAdjacencyListRecursive {
    public static class Edge{
        int from, to;
        double cost;

        public Edge(int from, int to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    private static void dfs(Map<Integer, List<Edge>> graph, int source, Set<Integer> visited){
        if(visited.contains(source) || !graph.containsKey(source)) return;
        visited.add(source);
        System.out.println(source);
        for(Edge neighbour: graph.get(source)){
            dfs(graph, neighbour.to, visited);
        }
    }
    public static void dfs(Map<Integer, List<Edge>> graph, int source){
        dfs(graph, source, new HashSet<>());
    }

    public static void main(String[] args) {
        int numNodes = 5;
        Map<Integer, List<Edge>> graph = new HashMap<>();
        addDirectedEdge(graph, 0, 1, 4);
        addDirectedEdge(graph, 0, 2, 5);
        addDirectedEdge(graph, 1, 3, 6);
        addDirectedEdge(graph, 1, 2, -2);
        addDirectedEdge(graph, 2, 3, 1);
        addDirectedEdge(graph, 2, 2, 10);
        dfs(graph, 0);
    }

    private static void addDirectedEdge(Map<Integer, List<Edge>> graph, int from, int to, double cost){
        if(graph == null){
            graph = new HashMap<>();
        }
        if(!graph.containsKey(from)) graph.put(from, new ArrayList<>());
        if(!graph.containsKey(to)) graph.put(to, new ArrayList<>());
        graph.get(from).add(new Edge(from, to, cost));
    }
}

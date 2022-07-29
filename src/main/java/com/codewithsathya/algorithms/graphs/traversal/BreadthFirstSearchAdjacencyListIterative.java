package com.codewithsathya.algorithms.graphs.traversal;

import java.util.*;

public class BreadthFirstSearchAdjacencyListIterative {
    public static class Edge{
        int from;
        int to;
        double cost;

        public Edge(int from, int to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void bfs(Map<Integer, List<Edge>> graph, int source){
        if(!graph.containsKey(source)) return;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(source);
        visited.add(source);
        while(!queue.isEmpty()){
            int node = queue.poll();
            System.out.println(node);
            for(Edge neighbour: graph.get(node)){
                if(!visited.contains(neighbour.to)){
                    queue.add(neighbour.to);
                    visited.add(neighbour.to);
                }
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        addDirectedEdge(graph, 0, 1, 4);
        addDirectedEdge(graph, 0, 2, 5);
        addDirectedEdge(graph, 1, 2, -2);
        addDirectedEdge(graph, 1, 3, 6);
        addDirectedEdge(graph, 2, 3, 1);
        addDirectedEdge(graph, 2, 2, 10);
        bfs(graph, 0);
    }

    public static void addDirectedEdge(Map<Integer, List<Edge>> graph, int from, int to, double cost){
        if(graph == null){
            graph = new HashMap<>();
        }
        if(!graph.containsKey(from)) graph.put(from, new ArrayList<>());
        if(!graph.containsKey(to)) graph.put(to, new ArrayList<>());
        graph.get(from).add(new Edge(from, to, cost));
    }
}

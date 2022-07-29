package com.codewithsathya.algorithms.graphs.traversal;

import java.util.*;

public class BreadthFirstSearchAdjacencyListRecursive {
    public static class Edge{
        int from, to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    private static final int DEPTH_TOKEN = -1;

    private static void bfs(Map<Integer, List<Edge>> graph, Set<Integer> visited, Queue<Integer> queue){
        if(queue.isEmpty()) return;
        int node = queue.poll();
        if(node == DEPTH_TOKEN){
            queue.add(DEPTH_TOKEN);
            return;
        }
        if(visited.contains(node)){
            return;
        }
        visited.add(node);
        System.out.println(node);

        for(Edge neighbour: graph.get(node)){
            if(!visited.contains(neighbour.to)){
                queue.add(neighbour.to);
            }
        }
        while(queue.size() != 1 || queue.peek() != DEPTH_TOKEN){
            bfs(graph, visited, queue);
        }
    }

    public static void bfs(Map<Integer, List<Edge>> graph, int source){
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(source);
        queue.add(DEPTH_TOKEN);
        bfs(graph, visited, queue);
    }

    public static void main(String[] args) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        addUndirectedEdge(graph, 0, 1);
        addUndirectedEdge(graph, 0, 2);
        addUndirectedEdge(graph, 0, 3);
        addUndirectedEdge(graph, 2, 9);
        addUndirectedEdge(graph, 8, 2);
        addUndirectedEdge(graph, 3, 4);
        addUndirectedEdge(graph, 10, 11);
        addUndirectedEdge(graph, 12, 13);
        addUndirectedEdge(graph, 3, 5);
        addUndirectedEdge(graph, 5, 7);
        addUndirectedEdge(graph, 5, 6);
        addUndirectedEdge(graph, 0, 10);
        addUndirectedEdge(graph, 11, 12);
        bfs(graph, 0);
    }

    public static void addUndirectedEdge(Map<Integer, List<Edge>> graph, int from, int to){
        if(graph == null){
            graph = new HashMap<>();
        }
        if(!graph.containsKey(from)) graph.put(from, new ArrayList<>());
        if(!graph.containsKey(to)) graph.put(to, new ArrayList<>());
        graph.get(from).add(new Edge(from, to));
    }
}

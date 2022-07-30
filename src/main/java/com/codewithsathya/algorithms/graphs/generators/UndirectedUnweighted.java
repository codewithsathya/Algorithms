package com.codewithsathya.algorithms.graphs.generators;

import java.util.*;

public class UndirectedUnweighted {
    public static <E> Map<E, List<E>> getAdjacencyList(E[][] edges){
        Map<E, List<E>> adjacencyList = new HashMap<>();
        for(E[] edge: edges){
            if(!adjacencyList.containsKey(edge[0])){
                adjacencyList.put(edge[0], new ArrayList<>());
            }
            if(!adjacencyList.containsKey(edge[1])){
                adjacencyList.put(edge[1], new ArrayList<>());
            }
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        return adjacencyList;
    }

    /**
     * this only works for integers as nodes
     * @param edges
     * @return
     */
    public static int[][] getAdjacencyMatrix(int[][] edges){
        int max = 0;
        for(int[] edge: edges){
            if(max < edge[0]){
                max = edge[0];
            }
            if(max < edge[1]){
                max = edge[1];
            }
        }
        int[][] adjacencyMatrix = new int[max][max];
        for(int[] row: adjacencyMatrix){
            Arrays.fill(row, 0);
        }
        for(int[] edge: edges){
            adjacencyMatrix[edge[0]][edge[1]] = 1;
            adjacencyMatrix[edge[1]][edge[0]] = 1;
        }
        return adjacencyMatrix;
    }
}

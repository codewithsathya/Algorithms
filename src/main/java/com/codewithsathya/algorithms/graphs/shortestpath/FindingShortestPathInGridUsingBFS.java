package com.codewithsathya.algorithms.graphs.shortestpath;

import java.util.*;

public class FindingShortestPathInGridUsingBFS {
    private static int combine(int num1, int num2, int max){
        return num1 * max + num2;
    }

    private static int[] divide(int combined, int max){
        int num1 = combined / max;
        int num2 = combined % max;
        return new int[]{num1, num2};
    }
    public static List<Integer[]> findShortestPath(int[][] grid, int[] start, int[] end){
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        if(grid.length == 0) return null;
        int maxDim = Math.max(grid.length, grid[0].length);
        int combined = combine(start[0], start[1], maxDim);
        visited.add(combined);
        queue.add(combined);
        Map<Integer, Integer> prev = new HashMap<>();
        int startIndex = combine(start[0], start[1], maxDim);
        int endIndex = combine(end[0], end[1], maxDim);
        boolean solved = false;
        while(!queue.isEmpty() && !solved){
            int combinedNode = queue.poll();
            int[] dividedNode = divide(combinedNode, maxDim);
            int row = dividedNode[0];
            int col = dividedNode[1];
            if(row == end[0] && col == end[1]){
                break;
            }
            for(int i = 0; i < 4; i++){
                int nRow = row + y[i];
                int nCol = col + x[i];
                if(nRow < 0 || nRow >= grid.length || nCol < 0 || nCol >= grid[0].length || grid[nRow][nCol] == 1){
                    continue;
                }
                int nCombined = combine(nRow, nCol, maxDim);
                if(!visited.contains(nCombined)){
                    visited.add(nCombined);
                    queue.add(nCombined);
                    prev.put(nCombined, combinedNode);
                    if(nCombined == endIndex){
                        solved = true;
                        break;
                    }
                }
            }
        }
        List<Integer[]> path = new ArrayList<>();

        int current = endIndex;
        if(!prev.containsKey(endIndex)) return path;
        while(current != startIndex){
            int[] divided = divide(current, maxDim);
            path.add(new Integer[]{divided[0], divided[1]});
            current = prev.get(current);
        }
        path.add(new Integer[]{start[0], start[1]});
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 0},
        };
        int[] start = {0, 0};
        int[] end = {4, 3};
        List<Integer[]> result = findShortestPath(grid, start, end);
        assert result != null;
        for(Integer[] node: result){
            System.out.println(node[0] + " " + node[1]);
        }
    }
}

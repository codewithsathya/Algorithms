package com.codewithsathya.algorithms.graphs.treealgorithms;

import java.util.*;

public class RootingTree {
    public static class Node<E>{
        E value;
        Node<E> parent;
        List<Node<E>> children;

        public Node(E value, Node<E> parent, List<Node<E>> children) {
            this.value = value;
            this.parent = parent;
            this.children = children;
        }
    }

    static <E> Node<E> rootTree(Map<E, List<E>> graph, E source){
        Node<E> result = new Node<>(source, null, new ArrayList<>());
        Queue<Node<E>> queue = new ArrayDeque<>();
        Set<E> visited = new HashSet<>();
        queue.add(result);
        visited.add(result.value);
        while(!queue.isEmpty()){
            Node<E> current = queue.poll();
            for(E neighbour: graph.get(current.value)){
                if(!visited.contains(neighbour)){
                    Node<E> neighbourNode = new Node<>(neighbour, current, new ArrayList<>());
                    current.children.add(neighbourNode);
                    visited.add(neighbour);
                    queue.add(neighbourNode);
                }
            }
        }
        return result;
    }
}

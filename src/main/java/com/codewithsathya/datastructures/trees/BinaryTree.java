package com.codewithsathya.datastructures.trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTree {
    public static class Node<E>{
        E value;
        Node<E> left;
        Node<E> right;
        Node(E value){
            this.value = value;
        }

        @Override
        public String toString(){
            return value.toString();
        }
    }

    public static <E> Node<E> constructTree(E[] arr){
        if(arr.length == 0) return null;
        Node<E> root = new Node<>(arr[0]);
        Queue<Node<E>> queue = new ArrayDeque<>();
        queue.add(root);
        int index = 1;
        while(!queue.isEmpty() && index < arr.length){
            Node<E> current = queue.poll();
            current.left = arr[index] == null ? null : new Node<>(arr[index]);
            index++;
            if(index >= arr.length) break;
            current.right = arr[index] == null ? null : new Node<>(arr[index]);
            index++;
            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);
        }
        return root;
    }

    public static <E> void inOrderTraversal(Node<E> root){
        if(root == null) return;
        inOrderTraversal(root.left);
        System.out.println(root);
        inOrderTraversal(root.right);
    }

    public static <E> void preOrderTraversal(Node<E> root){
        if(root == null) return;
        System.out.println(root);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static <E> void postOrderTraversal(Node<E> root){
        if(root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root);
    }

    public static <E> void breadthFirstTraversal(Node<E> root){
        if(root == null) return;
        Queue<Node<E>> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node<E> node = queue.poll();
            System.out.println(node);
            if(node.left != null)  queue.add(node.left);
            if(node.right != null)  queue.add(node.right);
        }
    }
}

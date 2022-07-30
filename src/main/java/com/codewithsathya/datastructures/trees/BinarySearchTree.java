package com.codewithsathya.datastructures.trees;

import static com.codewithsathya.datastructures.trees.BinaryTree.Node;

public class BinarySearchTree{
    public static <E extends Comparable<E>> Node<E> constructTree(E[] arr){
        if(arr.length == 0) return null;
        Node<E> root = new Node<>(arr[0]);
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == null) continue;
            addNode(arr[i], root);
        }
        return root;
    }

    private static <E extends Comparable<E>> void addNode(E value, Node<E> root){
        if(value.compareTo(root.value) < 0){
            if(root.left == null){
                root.left = new Node<>(value);
            }else{
                addNode(value, root.left);
            }
        }else{
            if(root.right == null){
                root.right = new Node<>(value);
            }else{
                addNode(value, root.right);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 3, 7, 4, 1, 2, 9, 8, 6};
        Node<Integer> root = constructTree(arr);
        BinaryTree.inOrderTraversal(root);
    }
}

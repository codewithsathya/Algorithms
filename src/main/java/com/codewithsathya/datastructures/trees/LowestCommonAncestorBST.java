package com.codewithsathya.datastructures.trees;

import static com.codewithsathya.datastructures.trees.BinaryTree.Node;

public class LowestCommonAncestorBST {
    public static <E extends Comparable<E>> Node<E> findLowestCommonAncestor(Node<E> root, E value1, E value2){
        while(root != null){
            if(value1.compareTo(root.value) < 0 && value2.compareTo(root.value) < 0){
                root = root.left;
            }else if(value1.compareTo(root.value) > 0 && value2.compareTo(root.value) > 0){
                root = root.right;
            }else{
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 5, 1, 6, 2, 0, 8, 7, 4};
        Node<Integer> root = BinarySearchTree.constructTree(arr);
        Node<Integer> lcaNode = findLowestCommonAncestor(root, 6, 4);
        System.out.println(lcaNode);
    }
}

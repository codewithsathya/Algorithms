package com.codewithsathya.datastructures.trees;

import static com.codewithsathya.datastructures.trees.BinaryTree.Node;

public class LowestCommonAncestor {
    static Node<Integer> lcaNode = null;
    public static Node<Integer> findLowestCommonAncestor(Node<Integer> root, int num1, int num2){
        contains(root, num1, num2);
        return lcaNode;
    }

    public static boolean contains(Node<Integer> root, int num1, int num2){
        if(root == null){
            return false;
        }
        int count = 0;
        if(root.value == num1 || root.value == num2){
            count++;
        }
        if(contains(root.left, num1, num2)) count++;
        if(contains(root.right, num1, num2)) count++;
        if(count == 2){
            lcaNode = root;
        }
        return count > 0;
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        Node<Integer> root = BinaryTree.constructTree(arr);
        Node<Integer> lcaNode = findLowestCommonAncestor(root, 6, 4);
        System.out.println(lcaNode);
    }
}

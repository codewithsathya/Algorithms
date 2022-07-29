package com.codewithsathya.datastructures.trees;

import static com.codewithsathya.datastructures.trees.BinaryTree.Node;

public class LeafSum {
    public static int getLeafSum(Node<Integer> root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.value;
        return getLeafSum(root.left) + getLeafSum(root.right);
    }

    public static void main(String[] args) {
        Integer[] arr = {6, 3, 5, 2, null, 1, 4, null, 8, null, 5, 0, null};
        Node<Integer> root = BinaryTree.constructTree(arr);
        System.out.println(getLeafSum(root));
    }
}

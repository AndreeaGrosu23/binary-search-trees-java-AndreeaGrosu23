package com.codecool.javabst;

import java.util.List;

// Skeleton for the Binary search tree. Feel free to modify this class.
public class BinarySearchTree {

    // A binary tree node
    class Node {

        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }

        public String toString() {
            return "node data: " + data;
        }
    }

    // Root of BST
    static Node root;

    // Constructor
    BinarySearchTree()
    {
        root = null;
    }

    /* A function that constructs Balanced Binary Search Tree
     from a sorted array */
    Node sortedArrayToBST(List<Integer> elements, int start, int end) {

        /* Base Case */
        if (start > end) {
            return null;
        }

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        Node node = new Node(elements.get(mid));

        /* Recursively construct the left subtree and make it
         left child of root */
        node.left = sortedArrayToBST(elements, start, mid - 1);

        /* Recursively construct the right subtree and make it
         right child of root */
        node.right = sortedArrayToBST(elements, mid + 1, end);
        System.out.print(mid);
        System.out.println(node.toString());
        return node;
    }

    /* A utility function to print preorder traversal of BST */
    void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static BinarySearchTree build(List<Integer> elements) {
        // TODO construct a binary search tree here
        BinarySearchTree tree = new BinarySearchTree();
        int n = elements.size();
        root = tree.sortedArrayToBST(elements, 0, n-1);
        tree.preOrder(root);
        return tree;
    }

    public boolean search(Integer toFind) {
        // TODO return true if the element has been found, false if its not in the tree.
        Node node = searchRecursive(root, toFind);
        if (node!=null) {
            return true;
        } else {
            return false;
        }
    }

    public Node searchRecursive(Node root, int toFind)  {
        // Base Cases: root is null or key is present at root
        if (root==null || root.data==toFind) {
            return root;
        }
        // val is greater than root's key
        if (root.data > toFind)
            return searchRecursive(root.left, toFind);
        // val is less than root's key
        return searchRecursive(root.right, toFind);
    }


    public void add(Integer toAdd) {
        // TODO adds an element. Throws an error if it exist.
        if(search(toAdd)) {
            throw new Error("Already exists");
        }
        root = insertRec(root, toAdd);
    }

    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, int key) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    public void remove(Integer toRemove) {
    // TODO removes an element. Throws an error if its not on the tree.
        root = deleteRecursive(root, toRemove);
    }

    /* A recursive function to insert a new key in BST */
    Node deleteRecursive(Node root, int key)
    {
        /* Base Case: If the tree is empty */
        if (root == null)  return root;

        /* Otherwise, recur down the tree */
        if (key < root.data)
            root.left = deleteRecursive(root.left, key);
        else if (key > root.data)
            root.right = deleteRecursive(root.right, key);

            // if key is same as root's key, then This is the node
            // to be deleted
        else
        {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRecursive(root.right, root.data);
        }

        return root;
    }

    int minValue(Node root)
    {
        int minv = root.data;
        while (root.left != null)
        {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

}

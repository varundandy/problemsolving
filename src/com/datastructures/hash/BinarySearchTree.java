package com.datastructures.hash;

/**
 * Binary Search Tree can be balanced and unbalanced and has a time complexity of 0(log n)
 */

public class BinarySearchTree {

    public static void main(String args[]) {

        MyBinarySearchTree tree = new MyBinarySearchTree();
        tree.insert(5);
        tree.insert(6);
    }

    public static class MyBinarySearchTree {
        Node root;

        public MyBinarySearchTree() {
            this.root = null;
        }

        public MyBinarySearchTree insert(Integer value) {
            Node newNode = new Node(value);
            if (this.root == null) {
                this.root = newNode;
            } else {
                Node current = root;
                while (true) {
                    if (value < current.value) {
                        //go left
                        if (current.left == null) {
                            current.left = newNode;
                            return this;
                        } else {
                            current = current.left;
                        }
                    } else if (value > current.value) {
                        //go right
                        if (current.right == null) {
                            current.right = newNode;
                            return this;
                        } else {
                            current = current.left;
                        }
                    } else if (value == current.value) {
                        System.out.println("Value " + current.value + " already exists. Cannot be added again");
                        return this;
                    }
                }
            }
            return this;
        }

        public boolean lookup(Integer value) {

            if (this.root == null) {
                return false;

            }
            Node current = root;
            while (current != null) {
                if (value > current.value) {
                    // go right
                    if (current.right == null) {
                        return false;
                    } else {
                        current = current.right;
                    }
                } else if (value < current.value) {
                    // go left
                    if (current.left == null) {
                        return false;
                    } else {
                        current = current.left;
                    }
                } else if (value == current.value) {
                    return true;
                }

            }
            return false;
        }

        public void traverse(Node node) {
           //


        }

    }

    public static class Node {
        Integer value;
        Node left;
        Node right;

        public Node(Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

}

package com.datastructures.trees;

import java.lang.reflect.Array;
import java.util.*;

/**
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Example 2:
 *
 * Input: root = [1,null,2]
 * Output: 2
 *
 *
 * TODO: REMOVE and Lookup
 * */
public class DepthOfBinaryTree {


    public static void main(String args[]) {
        MyBinaryTree tree = new MyBinaryTree();
        tree.insert(7);
        tree.insert(3);
        tree.insert(9);
        tree.insert(11);
        tree.insert(6);
        tree.insert(1);
        tree.insert(8);
        tree.traverseTree(MyBinaryTree.TraversalType.PREORDER);
        tree.traverseTree(MyBinaryTree.TraversalType.INORDER);
        tree.traverseTree(MyBinaryTree.TraversalType.POSTORDER);
        tree.traverseTree(MyBinaryTree.TraversalType.BFSORDER);
        tree.traverseTree(MyBinaryTree.TraversalType.LEVELORDER);
        int depth = tree.getDepth();
        System.out.println("Depth of Tree: " + depth);
    }


    static class MyBinaryTree {
        Node root;

        public enum TraversalType {
            PREORDER, INORDER, POSTORDER, LEVELORDER, BFSORDER;
        }

        private void traverseTree(TraversalType inorder) {
            List nodeValues = new ArrayList<>();
            Node currentNode = this.root;
            switch (inorder) {
                case INORDER:
                    traverseInOrder(currentNode, nodeValues);
                    break;
                case PREORDER:
                    traversePreOrder(currentNode, nodeValues);
                    break;
                case POSTORDER:
                    traversePostOrder(currentNode, nodeValues);
                    break;
                case LEVELORDER:
                    traverseLevelOrder(currentNode, nodeValues);
                    break;
                case BFSORDER:
                    traverseBFSOrder(currentNode, nodeValues);
                    break;
            }
            System.out.println(inorder + " : " + Arrays.toString(nodeValues.toArray()));
        }

        private void traverseBFSOrder(Node currentNode, List<Integer> nodeValues) {

            List<Integer> result = nodeValues;
            Queue<Node> queue = new ArrayDeque<>();
            queue.add(currentNode);
            while(!queue.isEmpty())
            {
                Node nodeToAdd = queue.poll();
                result.add(nodeToAdd.value);
                if(Objects.nonNull(nodeToAdd.left)) {
                    queue.add(nodeToAdd.left);
                }
                if(Objects.nonNull(nodeToAdd.right)) {
                    queue.add(nodeToAdd.right);
                }
            }
            //System.out.println(Arrays.toString(result.toArray()));
        }

        private void traverseLevelOrder(Node currentNode, List<Integer> nodeValues) {

            List<List<Integer>> result = new ArrayList<>();
            int level = 1;
            int countOfNodes = 0;



        }


        private List<Integer> traverseInOrder(Node node, List nodeValues) {
            if (node == null) {
                return nodeValues;
            }
            if (node.left != null) {
                traverseInOrder(node.left, nodeValues);
            }
            nodeValues.add(node.value);
            if (node.right != null) {
                traverseInOrder(node.right, nodeValues);
            }
            return nodeValues;
        }

        private List<Integer> traversePreOrder(Node node, List nodeValues) {
            if (node == null) {
                return nodeValues;
            }
            nodeValues.add(node.value);
            traversePreOrder(node.left, nodeValues);
            traversePreOrder(node.right, nodeValues);
            return nodeValues;
        }

        private List<Integer> traversePostOrder(Node node, List nodeValues) {
            if (node == null) {
                return nodeValues;
            }
            traversePostOrder(node.left, nodeValues);
            traversePostOrder(node.right, nodeValues);
            nodeValues.add(node.value);
            return nodeValues;
        }

        public void insert(int value) {
            Node newNode = new Node(value);

            if (root == null) {
                root = newNode;
            } else {
                Node currentNode = root;
                while (true) {
                    if (value > currentNode.value) {
                        if (currentNode.right == null) {
                            currentNode.right = newNode;
                            break;
                        } else {
                            currentNode = currentNode.right;
                        }

                        // go right
                    } else if (value < currentNode.value) {
                        if (currentNode.left == null) {
                            currentNode.left = newNode;
                            break;
                        } else {
                            currentNode = currentNode.left;

                        }                    // go left
                    } else if (value == currentNode.value) {
                        System.out.println("Value " + currentNode.value + " already exists. Cannot be added again");
                        break;
                    }
                }
            }
        }

        private int getNodeCount(Node node, int count) {
            if (node == null) {
                return count;
            }
            count++;
           return Math.max(getNodeCount(node.left, count), getNodeCount(node.right, count));
        }

        public int getDepth() {
            int count = 0;
            return getNodeCount(this.root, count);
        }

        public static class Node {

            private Node left;
            private Node right;
            private Integer value;

            public Node(Node left, Node right, Integer value) {
                this.left = left;
                this.right = right;
                this.value = value;
            }

            public Node(Integer value) {
                this.left = null;
                this.right = null;
                this.value = value;
            }
        }

    }


}

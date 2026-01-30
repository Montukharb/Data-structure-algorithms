package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

// time complexity  = O(n);
public class BuildTreePreOrder {
    static final int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

    static class Node {
        int data;
        Node left;
        Node right;

        private Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    Node root = null;
    int index = -1;

    Node buildTree(int[] nodes) {
        index++;
        if (nodes[index] == -1) {
            return null;
        }
        //create root node // preorder means first Node 2nd left 3rd right node;
        Node newNode = new Node(nodes[index]);

        newNode.left = buildTree(nodes);  //left node / left child;
        newNode.right = buildTree(nodes); // right node / right child;
        return newNode; //return root node which is 1;
    }

    void displayPreorder(Node mainNode) {

        if (mainNode == null) { //base condition root null or leaves null;
            System.out.print(-1 + " ");  //optional;
            return;
        }

        System.out.print(mainNode.data + " ");
        displayPreorder(mainNode.left);
        displayPreorder(mainNode.right);
    }

    void displayInorder(Node mainNode) {
        if (mainNode == null) {
            System.out.print(-1 + " ");
            return;
        }
        displayInorder(mainNode.left);
        System.out.print(mainNode.data + " ");
        displayInorder(mainNode.right);
    }

    void displayPostorder(Node mainNode) {
        if (mainNode == null) {
            System.out.print(-1 + " ");
            return;
        }
        displayPostorder(mainNode.left);
        displayPostorder(mainNode.right);
        System.out.print(mainNode.data + " ");
    }

    void levelOrderTraversal(Node mainNode) {
        if (mainNode == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(mainNode); //root node;
        queue.add(null); //second node null for next line;

        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            if (currentNode == null) {
                System.out.println();  //next line
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null); //for next line;
                }
            } else {
                System.out.print(currentNode.data + " ");
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

        }
    }

    static void main(String[] args) {
        System.out.println("Build tree pre order");

        BuildTreePreOrder obj = new BuildTreePreOrder();
        Node rootNode = obj.buildTree(nodes);
        System.out.println("Root node of tree =  " + rootNode.data);

        System.out.println("\nPreorder Traversal");
        obj.displayPreorder(rootNode);
        System.out.println("\nInorder Traversal");
        obj.displayInorder(rootNode);
        System.out.println("\nPostorder Traversal");
        obj.displayPostorder(rootNode);
        System.out.println("\nLevel order Traversal using queue");
        obj.levelOrderTraversal(rootNode);
    }
}

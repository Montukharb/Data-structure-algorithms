package binaryTrees;

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

    void display(Node mainNode) {

        if (mainNode == null) { //base condition root null or leaves null;
            System.out.print(-1 + " ");  //optional;
            return;
        }

        System.out.print(mainNode.data + " ");
        display(mainNode.left);
        display(mainNode.right);
    }

    static void main(String[] args) {
        System.out.println("Build tree pre order");

        BuildTreePreOrder obj = new BuildTreePreOrder();
        Node rootNode = obj.buildTree(nodes);
        System.out.println("Root node of tree =  " + rootNode.data);

        obj.display(rootNode);
    }
}

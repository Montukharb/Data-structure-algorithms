package binaryTrees;


public class BinarySearchTree {

    static class Node {
        int data;
        Node right;
        Node left;

        public Node(int data) {
            this.data = data;
            right = null;
            left = null;
        }
    }

    Node buildBST(Node root, int value) {

        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.data) {
            root.left = buildBST(root.left, value);

        } else if (value > root.data) {
            root.right = buildBST(root.right, value);

        }
        return root;
    }

    void displayInorder(Node mainNode) {
        if (mainNode == null) {
            return;
        }
        displayInorder(mainNode.left);
        System.out.print(mainNode.data + " ");
        displayInorder(mainNode.right);
    }

    int searchNode(Node root, int key) {
        if (root == null) {
            return -1;
        }
        if (root.data == key) {
            return root.data;
        }

        if (key > root.data) {
            return searchNode(root.right, key);
        } else {
            return searchNode(root.left, key);
        }

    }

    void deleteNode(Node root ,int data)
    {
       int res =  searchNode(root,data);
       if(res!= -1) //key found
       {

       }
    }

    static void main(String[] args) {
        int[] val = {6, 4, 5, 2, 3, 1, 8, 7, 9};
        Node root = null; //by default set null;
        BinarySearchTree obj = new BinarySearchTree();
        for (int j : val) {
            root = obj.buildBST(root, j);
        }
        obj.displayInorder(root);
        System.out.println();
        int res = obj.searchNode(root, 40);
        if (res != -1) {
            System.out.println("Key found and value is = " + res);
        } else {
            System.out.println("Key notFound");
        }
    }
}

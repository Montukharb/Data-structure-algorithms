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

    Node deleteNode(Node root, int data) {
        if (data < root.data) {
            root.left = deleteNode(root.left, data);
        } else if (data > root.data) {
            root.right = deleteNode(root.right, data);
        } else {
            //key match;
            //case 1 delete leaf nodes;
            if (root.left == null && root.right == null) {
                return null; //leaf node return null delete node automatically.
            }
//           case 2: only one child right side or left side;
            if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            }
            /* case 3 delete subtree node which
              find the inorder successor of subtree root node
              replace the data and delete the node;
              iSD = Inorder successor data;
            * */
            Node iSD = inorderSuccessor(root.right);
            root.data = iSD.data;
            root.right = deleteNode(root.right, iSD.data);
        }
        return root;
    }

    Node inorderSuccessor(Node root) {
        //left most node in right subtree search till end and return last node;
        while (root.left != null) {
            root = root.left;
        }
        return root;
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

        System.out.println("After deletion inorder data");
        root = obj.deleteNode(root, 4);

        obj.displayInorder(root);
    }
}

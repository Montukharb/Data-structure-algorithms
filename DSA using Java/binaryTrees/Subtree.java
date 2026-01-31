package binaryTrees;

public class Subtree {
    static final int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

    static class Node {
        int data;
        Node right;
        Node left;

        private Node(int data) {
            this.data = data;
            right = null;
            left = null;
        }
    }

    int index = -1;

    Node buildTree(int[] nodes) {
        index++;
        if (nodes[index] == -1) {
            return null;
        }
        Node newNode = new Node(nodes[index]);

        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }

    void display(Node node) {
        if (node == null) {
//            System.out.print(-1 + " ");
            return; //base case;

        }
        //preorder print;
        System.out.print(node.data + " ");
        display(node.left);
        display(node.right);
    }

    boolean isIdentical(Node treeRoot, Node subtreeRoot) {
        if (treeRoot == null && subtreeRoot == null) {
            return true;
        } else if (treeRoot == null || subtreeRoot == null || treeRoot.data != subtreeRoot.data) {
            return false;
        }

        if (!isIdentical(treeRoot.left, subtreeRoot.left)) {
            return false;
        }
        if (!isIdentical(treeRoot.right, subtreeRoot.right)) {
            return false;
        }

        return true;

    }

    boolean isSubtree(Node treeRoot, Node subtreeRoot) {
        if (treeRoot == null) {
            return false;
        }
        if (treeRoot.data == subtreeRoot.data) {
            if (isIdentical(treeRoot, subtreeRoot)) {
                return true;
            }
        }
        boolean leftTree = isSubtree(treeRoot.left, subtreeRoot);
        boolean rightTree = isSubtree(treeRoot.right, subtreeRoot);

        return leftTree || rightTree;
    }

    static void main(String[] args) {
        Subtree obj = new Subtree();
        Node root = obj.buildTree(nodes);
        System.out.println("Root node = " + root.data);
        obj.display(root);

        Node subtree = new Node(2);
        subtree.left = new Node(4);
        subtree.right = new Node(5);

        System.out.println("\nSubtree are equal to tree = " + obj.isSubtree(root, subtree));

    }
}

package binaryTrees;


import java.util.ArrayList;

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

    void displayPreorder(Node mainNode) {
        if (mainNode == null) {
            return;
        }
        System.out.print(mainNode.data + " ");
        displayInorder(mainNode.left);
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
        if (root == null) {
            return null;
        }
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

    void printInRange(Node root, int l_point, int r_point) {
        if (root == null) {
            return;
        }
        if (root.data >= l_point && root.data <= r_point) {

            printInRange(root.left, l_point, r_point);
            System.out.print(root.data + " ");
            printInRange(root.right, l_point, r_point);

        } else if (root.data > l_point) {
            printInRange(root.left, l_point, r_point);

        } else if (root.data < r_point) {
            printInRange(root.right, l_point, r_point);

        }
    }

    ArrayList<Integer> path = new ArrayList<>();

    void rootToLeafPath(Node root) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            printPath();
            System.out.println();
        }
        rootToLeafPath(root.left);
        rootToLeafPath(root.right);
        path.removeLast();

    }

    void printPath() {
        for (var x : path) {
            System.out.print(x + " ");
        }
    }

    boolean isValidBst(Node root, Node min, Node max) {
        if (root == null) {
            return true; //empty tree already valid bst;
        }
        if (min != null && root.data <= min.data) {
            return false;
        } else if (max != null && root.data >= max.data) {
            return false;
        }
        //left subtree call and right subtree call
        return isValidBst(root.left, min, root) && isValidBst(root.right, root, max);
    }

    Node mirrorBst(Node root) {
        if (root == null) {
            return null;
        }
        Node temp = root.right;
        root.right = root.left;
        root.left = temp;
        mirrorBst(root.left);
        mirrorBst(root.right);

        return root;
    }

    ArrayList<Integer> sortedTree = new ArrayList<>();

    Node balancedBst(int start, int end) {
        int mid = start + (end - start) / 2;
        if (start > end) {
            return null;
        }
        Node root = new Node(sortedTree.get(mid));
        root.left = balancedBst(start, mid - 1);
        root.right = balancedBst(mid + 1, end);

        return root;
    }

    ArrayList<Integer> inorderSequence = new ArrayList<>();

    void inorderSeq(Node root) {
        if (root == null) {
            return;
        }
        inorderSeq(root.left);
        inorderSequence.add(root.data);
        inorderSeq(root.right);
    }

    Node bst_To_Balanced_Bst(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        Node root = new Node(inorderSequence.get(mid));
        root.left = bst_To_Balanced_Bst(start, mid - 1);
        root.right = bst_To_Balanced_Bst(mid + 1, end);
        return root;
    }

    static void main(String[] args) {
//        int[] val = {6, 4, 5, 2, 3, 1, 8, 7, 9};
        int[] val = {8, 5, 10, 3, 6, 11};

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
        System.out.println("print in range 3 to 9");
        obj.printInRange(root, 5, 9);

        System.out.println("root to leaf all paths");
        obj.rootToLeafPath(root);

        if (obj.isValidBst(root, null, null)) {
            System.out.println("valid bst");
        } else {
            System.out.println("not valid bst");
        }

        root = obj.mirrorBst(root);
        obj.displayInorder(root);

        int[] arr = {3, 5, 6, 8, 10, 11, 12};
        for (var a : arr) {
            obj.sortedTree.add(a);
        }
        root = obj.balancedBst(0, arr.length - 1);

        System.out.println("\nbalanced binary tree");
        obj.displayInorder(root);
        obj.inorderSeq(root);

        root = obj.bst_To_Balanced_Bst(0, obj.inorderSequence.size() - 1);

        System.out.println("\nAfter converted bst to balanced bst");
        obj.displayPreorder(root);
    }
}

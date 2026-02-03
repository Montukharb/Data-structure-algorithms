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

         Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    int index = -1;

    //tree create;
    Node buildTree(int[] nodes) {
        index++;
        if (nodes[index] == -1) {
            return null; //base case;
        }
        //create root node // preorder means first Node 2nd left 3rd right node;
        Node newNode = new Node(nodes[index]);

        newNode.left = buildTree(nodes);  //left node / left child;
        newNode.right = buildTree(nodes); // right node / right child;
        return newNode; //return root node which is 1;
    }

    //display tree in preorder;

    void displayPreorder(Node mainNode) {

        if (mainNode == null) { //base condition root null or leaves null;
            System.out.print(-1 + " ");  //optional;
            return;
        }

        System.out.print(mainNode.data + " ");
        displayPreorder(mainNode.left);
        displayPreorder(mainNode.right);
    }
//    display tree in Inorder traversal;

    void displayInorder(Node mainNode) {
        if (mainNode == null) {
            System.out.print(-1 + " ");
            return; //base case;
        }
        displayInorder(mainNode.left);
        System.out.print(mainNode.data + " ");
        displayInorder(mainNode.right);
    }
//    display tree in postorder;

    void displayPostorder(Node mainNode) {
        if (mainNode == null) {
            System.out.print(-1 + " ");
            return; //base case;
        }
        displayPostorder(mainNode.left);
        displayPostorder(mainNode.right);
        System.out.print(mainNode.data + " ");
    }

//    display tree in breadth first search / level order traversal using queue;

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
//    calculate height of tree according to node;

    int treeHeight(Node mainNode) {
        if (mainNode == null) {
            return 0;
        }
        int left = treeHeight(mainNode.left);
        int right = treeHeight(mainNode.right);
        return Math.max(left, right) + 1;
    }

    //        calculate total node of tree;
//         time complexity = O(n);
    int countNodesOfTree(Node mainNode) {
        if (mainNode == null) {
            return 0; //base case;
        }
        int left = countNodesOfTree(mainNode.left);
        int right = countNodesOfTree(mainNode.right);

        return left + right + 1;

    }

/*    Sum of nodes;
    time complexity = O(n);
*/

//    int nodeSum = 0;

    int sumOfNode(Node mainNode) {
        if (mainNode == null) {
            return 0; //base case;
        }
//        nodeSum += mainNode.data; //calculate before next call;
        int left = sumOfNode(mainNode.left);
        int right = sumOfNode(mainNode.right);


        return left + right + mainNode.data;

    }

    //    diameter of tree using recursion TC = O(n^2);
    int treeDiameter(Node mainNode) {
        if (mainNode == null) {
            return 0; //base case;
        }

        int leftDiameter = treeHeight(mainNode.left);
        int rightDiameter = treeHeight(mainNode.right);
        int leftHeight = treeHeight(mainNode.left); //call height method return each node height;
        int rightHeight = treeHeight(mainNode.right); //call height method pass argument right node return right node height;
        int selfDiameter = leftHeight + rightHeight + 1;

        return Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter)); //return maximum diameter of tree;

    }


    // Count diameter of tree with bundle of data O(n);
    static class Info {
        int diameter;
        int height;

        private Info(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    Info efficientDiameter(Node mainNode) {
        if (mainNode == null) {
            return new Info(0, 0); //base case;
        }
        Info leftInfo = efficientDiameter(mainNode.left);
        Info rightInfo = efficientDiameter(mainNode.right);

        int selfDiameter = Math.max(leftInfo.diameter, rightInfo.diameter); //left and right diameter calculate;
        selfDiameter = Math.max(selfDiameter, leftInfo.height + rightInfo.height + 1); //self diameter calculate;

        int height = Math.max(leftInfo.height, rightInfo.height) + 1; //height calculate;

        return new Info(selfDiameter, height);
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
        System.out.println("\n Height of tree = " + obj.treeHeight(rootNode));
        System.out.println(" Count of total nodes in tree = " + obj.countNodesOfTree(rootNode));
        System.out.println(" Sum of nodes in tree = " + obj.sumOfNode(rootNode));
        System.out.println(" Diameter of tree = " + obj.treeDiameter(rootNode));

        Info res = obj.efficientDiameter(rootNode);
        System.out.println("\nDiameter of Tree using bundle of information in one time = " + res.diameter);
        System.out.println("Height of Tree using bundle of information in one time = " + res.height);
    }
}

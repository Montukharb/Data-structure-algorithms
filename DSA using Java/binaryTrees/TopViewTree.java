package binaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopViewTree {
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

    void displayPreorder(Node mainNode) {
        if (mainNode == null) {
            return;
        }
        System.out.print(mainNode.data + " ");
        displayPreorder(mainNode.left);
        displayPreorder(mainNode.right);
    }

    static class Info {
        Node node;
        int hidx;

        private Info(Node node, int hidx) {
            this.node = node;
            this.hidx = hidx;
        }

    }

    void topViewTree(Node rootNode) {
        if (rootNode == null) {
            return;
        }
        Queue<Info> queue = new LinkedList<>();
        int min = 0;
        int max = 0;
        HashMap<Integer, Node> map = new HashMap<>();
        queue.add(new Info(rootNode, 0));
        queue.add(null);

        while (!queue.isEmpty()) {
            Info current = queue.remove();
            if (current == null) {
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                }
            } else {
                if (!map.containsKey(current.hidx)) {
                    map.put(current.hidx, current.node);
                }
                if (current.node.left != null) {
                    queue.add(new Info(current.node.left, current.hidx - 1));
                    min = Math.min(min, current.hidx - 1);
                }
                if (current.node.right != null) {
                    queue.add(new Info(current.node.right, current.hidx + 1));
                    max = Math.max(max, current.hidx + 1);
                }
            }
        }
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
    }

    //using recursion find kth level tree node;
    void kthLevelTreePrint(Node mainNode, int level, int kth) {
        if (mainNode == null) {
            return;
        }
        if (kth == level) {
            System.out.print(mainNode.data + " ");
        }
        kthLevelTreePrint(mainNode.left, level + 1, kth);
        kthLevelTreePrint(mainNode.right, level + 1, kth);

    }

    //find kth level tree node using level by iteration;

    void kthLevelIteration(Node mainNode, int kth) {
        if (mainNode == null) {
            return;
        }
        int level = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(mainNode);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            if (current == null) {
//                System.out.println();  //enable mandatory when traversing display data level by level;
                level++;
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                }
            } else {
//                System.out.print(current.data + " ");
                if (level == kth) {
                    System.out.print(current.data + " ");
                }

                if (current.left != null) {
                    queue.add(current.left);

                }
                if (current.right != null) {
                    queue.add(current.right);

                }
            }
        }

    }

    //path for lowest common ancestor
    boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }

        path.add(root); //first node add by default;

        //check our n is root or not
        if (root.data == n) {
            return true; //ancestor match;
        }

        //check left child path possible or not;
        boolean leftRes = getPath(root.left, n, path);

        //check right child path possible or not;
        boolean rightRes = getPath(root.right, n, path);

        if (leftRes || rightRes) {
            return true;
        }
        //else not anywhere remove parent node;
//        path.remove(path.size() - 1);
        path.removeLast();
        return false; //not found anywhere;
    }

    void lastCommonAncestor(Node root, int n1, int n2) {
        ArrayList<Node> list1 = new ArrayList<>();
        ArrayList<Node> list2 = new ArrayList<>();

        getPath(root, n1, list1);
        getPath(root, n2, list2);

        //match last common ancestor;
        int i = 0;
        for (; i < list1.size() && i < list2.size(); i++) {
            if (list1.get(i).data != list2.get(i).data) {
                break;
            }
        }
        System.out.println("Last common ancestor = " + list1.get(i - 1).data);
    }

    //lowest common ancestor find out without extra space;
    Node lca2(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }
        if (root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLca = lca2(root.left, n1, n2);

        Node rightLca = lca2(root.right, n1, n2);

        if (leftLca == null) {
            return rightLca;
        }
        if (rightLca == null) {
            return leftLca;
        }

        return root;
    }

    int minDistanceNodes(Node root, int n) {
        if (root == null) {
            return -1; //base case;
        }
        if (root.data == n) {
            return 0;
        }
        int leftDistance = minDistanceNodes(root.left, n);

        int rightDistance = minDistanceNodes(root.right, n);

        if (leftDistance != -1) {
            return leftDistance + 1;
        }
        if (rightDistance != -1) {
            return rightDistance + 1;
        }

        return -1;
    }

    int minDist(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);
        int left = minDistanceNodes(lca, n1);
        int right = minDistanceNodes(lca, n2);
        return left + right;
    }

    int kthAncestorNode(Node root, int kth, int searchNode) {
        if (root == null) {
            return -1; //base case;
        }
        if (root.data == searchNode) {
            return 0;
        }
        int left = kthAncestorNode(root.left, kth, searchNode);

        int right = kthAncestorNode(root.right, kth, searchNode);

        if (left == -1 && right == -1) {
            return -1;
        }

        int dist = Math.max(left, right) + 1;

        if (dist == kth) {
            System.out.println("kth ancestor value = " + root.data);
        }
        return dist;
    }

    //transform a tree to sum tree;
    int transform(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            int oldValue = root.data;
            root.data = 0;
            return oldValue;
        }
        int left = transform(root.left);
        int right = transform(root.right);

        int oldValue = root.data;
        root.data = left + right;

        return root.data + oldValue;
    }


    static void main(String[] args) {
        TopViewTree obj = new TopViewTree();
        Node rootNode = obj.buildTree(nodes);
        obj.displayPreorder(rootNode);
        System.out.println("\nTop view tree");
        obj.topViewTree(rootNode);
        System.out.println("\nkth level nodes = ");
        obj.kthLevelTreePrint(rootNode, 1, 3);
        System.out.println("\nKth level find using level iteration");
        int kth = 3;
        obj.kthLevelIteration(rootNode, kth);
        obj.lastCommonAncestor(rootNode, 6, 5);

        System.out.println("\nlca2 = " + obj.lca2(rootNode, 4, 3).data);
        System.out.println("minimum distance = " + obj.minDist(rootNode, 2, 6));
        obj.kthAncestorNode(rootNode, 2, 5);

        obj.transform(rootNode);
        obj.displayPreorder(rootNode);

    }
}

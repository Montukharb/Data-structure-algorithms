package binaryTrees;

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

    static void main(String[] args) {
        TopViewTree obj = new TopViewTree();
        Node rootNode = obj.buildTree(nodes);
        obj.displayPreorder(rootNode);
        System.out.println("\nTop view tree");
        obj.topViewTree(rootNode);
    }
}

package xyz.ogudino.algorithms.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {

    public static class Node<T> {
        T data;
        Node<T> parent;
        Node<T> left;
        Node<T> right;

        public Node(T data, Node<T> parent) {
            this.data = data;
            this.parent = parent;
        }
    }

    Node<T> root;

    public void insert(T data) {
        root = insert(root, data, null);
    }

    private Node<T> insert(Node<T> node, T data, Node<T> parent) {
        if (node == null) {
            return new Node<>(data, parent);
        }

        if (data.compareTo(node.data) < 0) {
            node.left = insert(node.left, data, node);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insert(node.right, data, node);
        }
        return node;
    }

    public Node<T> search(T data) {
        return search(root, data);
    }

    private Node<T> search(Node<T> node, T data) {
        if (node == null) {
            return null;
        } else if (node.data.equals(data)) {
            return node;
        } else if (data.compareTo(node.data) < 0) {
            return search(node.left, data);
        } else {
            return search(node.right, data);
        }
    }

    public Node<T> min() {
        Node<T> min = root;

        while (min != null && min.left != null) {
            min = min.left;
        }

        return min;
    }

    public Node<T> max() {
        Node<T> max = root;

        while (max != null && max.right != null) {
            max = max.right;
        }

        return max;
    }

    public List<T> levelOrderTransversal() {
        List<T> list = new ArrayList<>();

        Queue<Node<T>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            list.add(node.data);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return list;
    }

    public List<T> inOrderTransversal() {
        List<T> list = new ArrayList<>();

        list = inOrderTransversal(root, list);

        return list;
    }

    private List<T> inOrderTransversal(Node<T> node, List<T> list) {
        if (node != null) {
            inOrderTransversal(node.left, list);
            list.add(node.data);
            inOrderTransversal(node.right, list);
        }
        return list;
    }

}

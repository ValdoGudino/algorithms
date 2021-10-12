package xyz.ogudino.algorithms.bst;

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
            insert(node.left, data, node);
        } else {
            insert(node.right, data, node);
        }
        return node;
    }

}

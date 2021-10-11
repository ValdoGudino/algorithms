package xyz.ogudino.algorithms.list;

import java.util.StringJoiner;

public class LinkedList<T> {

    public static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public Node<T> head;

    public int size;

    public LinkedList(T data) {
        head = new Node<>(data);
        size = 1;
    }

    public void insert(T data) {
        Node<T> node = new Node<>(data);
        node.next = head;
        head = node;
        size++;
    }

    private Node<T> search(Node<T> node, T data) {
        if (node == null) {
            return null;
        }

        if (node.data == data) {
            return node;
        } else {
            return search(node.next, data);
        }
    }

    public Node<T> search(T data) {
        return search(head, data);
    }

    private Node<T> predecessorNode(Node<T> node, T data) {
        if (node == null || node.next == null) {
            System.err.println("Error: predecessor sought on null list.");
            return null;
        }

        if (node.next.data.equals(data)) {
            return node;
        } else {
            return predecessorNode(node.next, data);
        }
    }

    public void delete(T data) {
        Node<T> toDelete = search(data);

        if (toDelete != null) {
            Node<T> pred = predecessorNode(head, data);

            // Guard against a "fake" predecessor node
            if (toDelete.equals(pred)) {
                pred = predecessorNode(head.next, data);
            }

            if (pred == null) {
                head = head.next;
            } else {
                pred.next = toDelete.next;
            }
            size--;
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(",");
        Node<T> node = head;
        while (node != null) {
            joiner.add(String.valueOf(node.data));
            node = node.next;
        }
        return joiner.toString();
    }

}

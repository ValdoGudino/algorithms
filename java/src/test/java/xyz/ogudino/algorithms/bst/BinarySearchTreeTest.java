package xyz.ogudino.algorithms.bst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTreeTest {

    @Test
    void insert() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(0);
        assertEquals(0, tree.root.data);
        tree.insert(-1);
        assertEquals(-1, tree.root.left.data);
        tree.insert(1);
        assertEquals(1, tree.root.right.data);
    }
}
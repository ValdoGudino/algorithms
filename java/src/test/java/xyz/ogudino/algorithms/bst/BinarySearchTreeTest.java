package xyz.ogudino.algorithms.bst;

import org.junit.jupiter.api.Test;
import xyz.ogudino.algorithms.bst.BinarySearchTree.Node;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BinarySearchTreeTest {

    @Test
    public void insert() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(0);
        assertEquals(0, tree.root.data);

        tree.insert(-1);
        assertEquals(-1, tree.root.left.data);

        tree.insert(1);
        assertEquals(1, tree.root.right.data);
    }

    @Test
    public void search() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(0);
        tree.insert(-1);
        tree.insert(1);

        Node<Integer> node = tree.search(-1);
        assertEquals(-1, node.data);

        node = tree.search(Integer.MAX_VALUE);
        assertNull(node);
    }

    @Test
    public void min() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        assertNull(tree.min());

        tree.insert(-1);
        assertEquals(-1, tree.min().data);

        tree.insert(1);
        assertEquals(-1, tree.min().data);

        tree.insert(-1000);
        tree.insert(-100);
        tree.insert(-100);
        tree.insert(-10);

        assertEquals(-1000, tree.min().data);
    }

    @Test
    public void max() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        assertNull(tree.max());

        tree.insert(-1);
        assertEquals(-1, tree.max().data);

        tree.insert(1);
        assertEquals(1, tree.max().data);

        tree.insert(-1000);
        tree.insert(-100);
        tree.insert(-100);
        tree.insert(-10);

        assertEquals(1, tree.max().data);
    }

    @Test
    public void levelOrderTransversal() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(0);
        tree.insert(-1);
        tree.insert(1);

        List<Integer> expected = new ArrayList<>();

        expected.add(0);
        expected.add(-1);
        expected.add(1);

        assertEquals(expected, tree.levelOrderTransversal());
    }

    @Test
    public void inOrderTransversal() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(-1);
        tree.insert(0);
        tree.insert(1);

        List<Integer> list = new ArrayList<>();

        list.add(-1);
        list.add(0);
        list.add(1);

        assertEquals(list, tree.inOrderTransversal());
    }
}

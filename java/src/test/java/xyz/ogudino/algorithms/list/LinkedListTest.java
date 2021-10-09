package xyz.ogudino.algorithms.list;

import org.junit.jupiter.api.Test;
import xyz.ogudino.algorithms.list.LinkedList.Node;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    public void init() {
        int data = 5;
        LinkedList<Integer> list = new LinkedList<>(data);
        assertEquals(1, list.size);
        assertEquals(data, list.head.data);
    }

    @Test
    public void simpleSearchFound() {
        int data = 5;
        LinkedList<Integer> list = new LinkedList<>(data);
        Node<Integer> node = list.searchList(list.head, data);
        assertNotNull(node);
        assertEquals(data, node.data);
    }

    @Test
    public void simpleSearchNotFound() {
        int data = 5;
        LinkedList<Integer> list = new LinkedList<>(data);
        Node<Integer> node = list.searchList(list.head, data - 1);
        assertNull(node);
    }

}
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
        Node<Integer> node = list.search(data);
        assertNotNull(node);
        assertEquals(data, node.data);
    }

    @Test
    public void simpleSearchNotFound() {
        int data = 5;
        LinkedList<Integer> list = new LinkedList<>(data);
        Node<Integer> node = list.search(data - 1);
        assertNull(node);
    }

    @Test
    public void insert() {
        int first = 5;
        int second = 6;
        LinkedList<Integer> list = new LinkedList<>(first);
        assertEquals(1, list.size);
        list.insert(second);
        assertEquals(2, list.size);
    }

    @Test
    public void delete() {
        int first = 5;
        int second = 6;

        LinkedList<Integer> list = new LinkedList<>(first);
        list.insert(second);
        assertEquals(2, list.size);

        list.delete(second);
        assertEquals(1, list.size);

        list.delete(first);
        assertEquals(0, list.size);

        list.insert(first);
        list.insert(second);
        assertEquals(2, list.size);

        list.delete(first);
        assertEquals(1, list.size);

        list.delete(second);
        assertEquals(0, list.size);

        int third = 9;
        list.insert(first);
        list.insert(second);
        list.insert(third);
        assertEquals(3, list.size);

        list.delete(second);
        assertEquals(2, list.size);

        list.delete(first);
        assertEquals(1, list.size);

        list.delete(third);
        assertEquals(0, list.size);
    }

    @Test
    public void string() {
        int data = 5;
        LinkedList<Integer> list = new LinkedList<>(data);
        assertEquals("5", list.toString());
        list.insert(data);
        assertEquals("5,5", list.toString());

        list.delete(data);
        list.delete(data);
        assertEquals("", list.toString());
    }

}

package xyz.ogudino.alorithms.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    public void init() {
        int data = 5;
        LinkedList<Integer> list = new LinkedList<>(data);
        assertEquals(1, list.size);
        assertEquals(data, list.head.data);
    }

}
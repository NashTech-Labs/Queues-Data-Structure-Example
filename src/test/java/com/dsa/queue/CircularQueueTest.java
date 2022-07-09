package com.dsa.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

public class CircularQueueTest {
    /**
     * Method under test: {@link CircularQueue#CircularQueue(int)}
     */
    @Test
    public void testConstructor() {
        CircularQueue actualCircularQueue = new CircularQueue(3);
        assertTrue(actualCircularQueue.isEmpty());
        assertEquals(-1, actualCircularQueue.topOfQueue);
        assertEquals(3, actualCircularQueue.size);
        assertEquals(3, actualCircularQueue.arr.length);
    }

    /**
     * Method under test: {@link CircularQueue#CircularQueue(int)}
     */
    @Test
    public void testConstructor2() {
        assertThrows(NegativeArraySizeException.class, () -> new CircularQueue(-1));
    }

    /**
     * Method under test: {@link CircularQueue#isEmpty()}
     */
    @Test
    public void testIsEmpty() {
        assertTrue((new CircularQueue(3)).isEmpty());
    }

    /**
     * Method under test: {@link CircularQueue#isFull()}
     */
    @Test
    public void testIsFull() {
        assertFalse((new CircularQueue(3)).isFull());
        assertFalse((new CircularQueue(0)).isFull());
    }

    /**
     * Method under test: {@link CircularQueue#enQueue(int)}
     */
    @Test
    public void testEnQueue() {
        CircularQueue circularQueue = new CircularQueue(3);
        circularQueue.enQueue(42);
        assertFalse(circularQueue.isEmpty());
        assertEquals(0, circularQueue.topOfQueue);
        assertEquals(42, circularQueue.peek());
    }

    /**
     * Method under test: {@link CircularQueue#enQueue(int)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testEnQueue2() {
        // TODO: Complete this test.

        (new CircularQueue(0)).enQueue(42);
    }

    /**
     * Method under test: {@link CircularQueue#deQueue()}
     */
    @Test
    public void testDeQueue() {
        assertEquals(-1, (new CircularQueue(3)).deQueue());
    }

    /**
     * Method under test: {@link CircularQueue#peek()}
     */
    @Test
    public void testPeek() {
        assertEquals(-1, (new CircularQueue(3)).peek());
    }

    /**
     * Method under test: {@link CircularQueue#deleteQueue()}
     */
    @Test
    public void testDeleteQueue() {
        CircularQueue circularQueue = new CircularQueue(3);
        circularQueue.deleteQueue();
        assertNull(circularQueue.arr);
    }
}


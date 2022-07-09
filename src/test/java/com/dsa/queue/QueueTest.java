package com.dsa.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

public class QueueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Queue#Queue()}
     *   <li>{@link Queue#getSize()}
     * </ul>
     */
    @Test
    public void testConstructor() {
        assertEquals(0, (new Queue()).getSize());
        assertThrows(NegativeArraySizeException.class, () -> new Queue(-1));
    }

    /**
     * Method under test: {@link Queue#Queue()}
     */
    @Test
    public void testConstructor2() {
        Queue actualQueue = new Queue();
        assertEquals(0, actualQueue.getSize());
        assertFalse(actualQueue.isFull());
    }

    /**
     * Method under test: {@link Queue#Queue(int)}
     */
    @Test
    public void testConstructor3() {
        Queue actualQueue = new Queue(3);
        assertEquals(0, actualQueue.getSize());
        assertFalse(actualQueue.isFull());
    }

    /**
     * Method under test: {@link Queue#insert(int)}
     */
    @Test
    public void testInsert() {
        Queue queue = new Queue();
        assertTrue(queue.insert(2));
        assertEquals(1, queue.getSize());
    }

    /**
     * Method under test: {@link Queue#insert(int)}
     */
    @Test
    public void testInsert2() {
        assertFalse((new Queue(0)).insert(2));
    }

    /**
     * Method under test: {@link Queue#remove()}
     */
    @Test
    public void testRemove() {
        assertEquals(-1, (new Queue()).remove());
    }

    /**
     * Method under test: {@link Queue#remove()}
     */
    @Test
    public void testRemove2() {
        Queue queue = new Queue();
        queue.insert(2);
        assertEquals(2, queue.remove());
        assertEquals(0, queue.getSize());
    }

    /**
     * Method under test: {@link Queue#peekFront()}
     */
    @Test
    public void testPeekFront() {
        assertEquals(0, (new Queue()).peekFront());
    }

    /**
     * Method under test: {@link Queue#peekFront()}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testPeekFront2() {
        // TODO: Complete this test.

        (new Queue(0)).peekFront();
    }

    /**
     * Method under test: {@link Queue#peekRear()}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testPeekRear() {

        // TODO: Complete this test.

        (new Queue()).peekRear();
    }

    /**
     * Method under test: {@link Queue#peekRear()}
     */
    @Test
    public void testPeekRear2() {
        Queue queue = new Queue();
        queue.insert(2);
        assertEquals(2, queue.peekRear());
    }

    /**
     * Method under test: {@link Queue#isEmpty()}
     */
    @Test
    public void testIsEmpty() {
        assertTrue((new Queue()).isEmpty());
    }

    /**
     * Method under test: {@link Queue#isEmpty()}
     */
    @Test
    public void testIsEmpty2() {
        Queue queue = new Queue();
        queue.insert(2);
        assertFalse(queue.isEmpty());
    }

    /**
     * Method under test: {@link Queue#isFull()}
     */
    @Test
    public void testIsFull() {
        assertFalse((new Queue()).isFull());
        assertTrue((new Queue(0)).isFull());
    }

    /**
     * Method under test: {@link Queue#toString()}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testToString() {

        // TODO: Complete this test.
        // Arrange
        // TODO: Populate arranged inputs
        Queue queue = null;

        // Act
        assert false;
        String actualToStringResult = queue.toString();
    }
}


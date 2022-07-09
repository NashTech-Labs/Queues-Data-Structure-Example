package com.dsa.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

public class DeQueueTest {
    /**
     * Method under test: {@link DeQueue#addFirst(Object)}
     */
    @Test
    public void testAddFirst() {
        DeQueue<Object> deQueue = new DeQueue<>();
        deQueue.addFirst("Val");
        assertFalse(deQueue.isEmpty());
        assertEquals(1, deQueue.size());
        DeQueue.DequeNode<Object> dequeNode = deQueue.tail;
        assertNull(dequeNode.prev);
        assertNull(dequeNode.next);
        assertEquals("Val", dequeNode.val);
    }

    /**
     * Method under test: {@link DeQueue#addFirst(Object)}
     */
    @Test
    public void testAddFirst2() {
        DeQueue<Object> deQueue = new DeQueue<>();
        deQueue.addFirst("Val");
        deQueue.addFirst("Val");
        assertFalse(deQueue.isEmpty());
        assertEquals(2, deQueue.size());
        DeQueue.DequeNode<Object> dequeNode = deQueue.head;
        assertEquals("Val", dequeNode.val);
        assertNull(dequeNode.prev);
        DeQueue.DequeNode<Object> dequeNode1 = deQueue.tail;
        assertSame(dequeNode1, dequeNode.next);
        assertSame(dequeNode, dequeNode1.prev);
    }

    /**
     * Method under test: {@link DeQueue#addLast(Object)}
     */
    @Test
    public void testAddLast() {
        DeQueue<Object> deQueue = new DeQueue<>();
        deQueue.addLast("Val");
        assertFalse(deQueue.isEmpty());
        assertEquals(1, deQueue.size());
        DeQueue.DequeNode<Object> dequeNode = deQueue.tail;
        assertNull(dequeNode.prev);
        assertNull(dequeNode.next);
        assertEquals("Val", dequeNode.val);
    }

    /**
     * Method under test: {@link DeQueue#addLast(Object)}
     */
    @Test
    public void testAddLast2() {
        DeQueue<Object> deQueue = new DeQueue<>();
        deQueue.addFirst("Val");
        deQueue.addLast("Val");
        assertEquals(2, deQueue.size());
        DeQueue.DequeNode<Object> dequeNode = deQueue.tail;
        DeQueue.DequeNode<Object> dequeNode1 = deQueue.head;
        assertSame(dequeNode, dequeNode1.next);
        assertSame(dequeNode1, dequeNode.prev);
        assertNull(dequeNode.next);
        assertSame(dequeNode1.val, dequeNode.val);
    }

    /**
     * Method under test: {@link DeQueue#pollFirst()}
     */
    @Test
    public void testPollFirst() {
        assertNull((new DeQueue<>()).pollFirst());
    }

    /**
     * Method under test: {@link DeQueue#pollFirst()}
     */
    @Test
    public void testPollFirst2() {
        DeQueue<Object> deQueue = new DeQueue<>();
        deQueue.addFirst("Val");
        assertEquals("Val", deQueue.pollFirst());
        assertTrue(deQueue.isEmpty());
        assertNull(deQueue.tail);
        assertEquals(0, deQueue.size());
    }

    /**
     * Method under test: {@link DeQueue#pollFirst()}
     */
    @Test
    public void testPollFirst3() {
        DeQueue<Object> deQueue = new DeQueue<>();
        deQueue.addFirst("Val");
        deQueue.addFirst("Val");
        assertEquals("Val", deQueue.pollFirst());
        assertFalse(deQueue.isEmpty());
        assertEquals(1, deQueue.size());
        assertNull(deQueue.tail.prev);
    }

    /**
     * Method under test: {@link DeQueue#pollLast()}
     */
    @Test
    public void testPollLast() {
        assertNull((new DeQueue<>()).pollLast());
    }

    /**
     * Method under test: {@link DeQueue#pollLast()}
     */
    @Test
    public void testPollLast2() {
        DeQueue<Object> deQueue = new DeQueue<>();
        deQueue.addFirst("Val");
        assertEquals("Val", deQueue.pollLast());
        assertTrue(deQueue.isEmpty());
        assertNull(deQueue.tail);
        assertEquals(0, deQueue.size());
    }

    /**
     * Method under test: {@link DeQueue#pollLast()}
     */
    @Test
    public void testPollLast3() {
        DeQueue<Object> deQueue = new DeQueue<>();
        deQueue.addFirst("Val");
        deQueue.addFirst("Val");
        assertEquals("Val", deQueue.pollLast());
        assertEquals(1, deQueue.size());
        DeQueue.DequeNode<Object> dequeNode = deQueue.tail;
        assertNull(dequeNode.prev);
        assertNull(dequeNode.next);
    }

    /**
     * Method under test: {@link DeQueue#peekFirst()}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testPeekFirst() {

        // TODO: Complete this test.

        (new DeQueue<>()).peekFirst();
    }

    /**
     * Method under test: {@link DeQueue#peekFirst()}
     */
    @Test
    public void testPeekFirst2() {
        DeQueue<Object> deQueue = new DeQueue<>();
        deQueue.addFirst("Val");
        assertEquals("Val", deQueue.peekFirst());
    }

    /**
     * Method under test: {@link DeQueue#peekLast()}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testPeekLast() {

        // TODO: Complete this test.

        (new DeQueue<>()).peekLast();
    }

    /**
     * Method under test: {@link DeQueue#peekLast()}
     */
    @Test
    public void testPeekLast2() {
        DeQueue<Object> deQueue = new DeQueue<>();
        deQueue.addLast("Val");
        assertEquals("Val", deQueue.peekLast());
    }

    /**
     * Method under test: {@link DeQueue#isEmpty()}
     */
    @Test
    public void testIsEmpty() {
        assertTrue((new DeQueue<>()).isEmpty());
    }

    /**
     * Method under test: {@link DeQueue#isEmpty()}
     */
    @Test
    public void testIsEmpty2() {
        DeQueue<Object> deQueue = new DeQueue<>();
        deQueue.addFirst("Val");
        assertFalse(deQueue.isEmpty());
    }

    /**
     * Method under test: {@link DeQueue#toString()}
     */
    @Test
    public void testToString() {
        assertEquals("Head ->  <- Tail", (new DeQueue<>()).toString());
    }

    /**
     * Method under test: {@link DeQueue#toString()}
     */
    @Test
    public void testToString2() {
        DeQueue<Object> deQueue = new DeQueue<>();
        deQueue.addFirst("Val");
        assertEquals("Head -> Val <- Tail", deQueue.toString());
    }

    /**
     * Method under test: {@link DeQueue#toString()}
     */
    @Test
    public void testToString3() {
        DeQueue<Object> deQueue = new DeQueue<>();
        deQueue.addFirst("Val");
        deQueue.addFirst("Val");
        assertEquals("Head -> Val <-> Val <- Tail", deQueue.toString());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link DeQueue}
     *   <li>{@link DeQueue#size()}
     * </ul>
     */
    @Test
    public void testConstructor() {
        assertEquals(0, (new DeQueue<>()).size());
    }
}


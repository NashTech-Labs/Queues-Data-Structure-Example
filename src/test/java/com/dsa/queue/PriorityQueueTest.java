package com.dsa.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

public class PriorityQueueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link PriorityQueue#PriorityQueue(int)}
     *   <li>{@link PriorityQueue#getSize()}
     * </ul>
     */
    @Test
    public void testConstructor() {
        assertEquals(0, (new PriorityQueue(3)).getSize());
        assertThrows(NegativeArraySizeException.class, () -> new PriorityQueue(-1));
    }

    /**
     * Method under test: {@link PriorityQueue#PriorityQueue(int)}
     */
    @Test
    public void testConstructor2() {
        PriorityQueue actualPriorityQueue = new PriorityQueue(3);
        assertEquals(0, actualPriorityQueue.getSize());
        assertFalse(actualPriorityQueue.isFull());
    }

    /**
     * Method under test: {@link PriorityQueue#insert(int)}
     */
    @Test
    public void testInsert() {
        PriorityQueue priorityQueue = new PriorityQueue(3);
        priorityQueue.insert(42);
        assertEquals(1, priorityQueue.getSize());
        assertEquals(42, priorityQueue.peek());
    }

    /**
     * Method under test: {@link PriorityQueue#insert(int)}
     */
    @Test
    public void testInsert2() {
        assertThrows(RuntimeException.class, () -> (new PriorityQueue(0)).insert(42));
    }

    /**
     * Method under test: {@link PriorityQueue#insert(int)}
     */
    @Test
    public void testInsert3() {
        PriorityQueue priorityQueue = new PriorityQueue(3);
        priorityQueue.insert(42);
        priorityQueue.insert(42);
        assertEquals(2, priorityQueue.getSize());
        assertEquals(42, priorityQueue.peek());
    }

    /**
     * Method under test: {@link PriorityQueue#insert(int)}
     */
    @Test
    public void testInsert4() {
        PriorityQueue priorityQueue = new PriorityQueue(3);
        priorityQueue.insert(42);
        priorityQueue.insert(3);
        assertEquals(2, priorityQueue.getSize());
        assertEquals(42, priorityQueue.peek());
    }

    /**
     * Method under test: {@link PriorityQueue#peek()}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testPeek() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 3
        //       at com.dsa.queue.PriorityQueue.peek(PriorityQueue.java:72)
        //   In order to prevent peek()
        //   from throwing ArrayIndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   peek().
        //   See https://diff.blue/R013 to resolve this issue.

        (new PriorityQueue(3)).peek();
    }

    /**
     * Method under test: {@link PriorityQueue#peek()}
     */
    @Test
    public void testPeek2() {
        PriorityQueue priorityQueue = new PriorityQueue(3);
        priorityQueue.insert(42);
        assertEquals(42, priorityQueue.peek());
    }

    /**
     * Method under test: {@link PriorityQueue#isEmpty()}
     */
    @Test
    public void testIsEmpty() {
        assertTrue((new PriorityQueue(3)).isEmpty());
    }

    /**
     * Method under test: {@link PriorityQueue#isEmpty()}
     */
    @Test
    public void testIsEmpty2() {
        PriorityQueue priorityQueue = new PriorityQueue(3);
        priorityQueue.insert(42);
        assertFalse(priorityQueue.isEmpty());
    }

    /**
     * Method under test: {@link PriorityQueue#isFull()}
     */
    @Test
    public void testIsFull() {
        assertFalse((new PriorityQueue(3)).isFull());
        assertTrue((new PriorityQueue(0)).isFull());
    }
}


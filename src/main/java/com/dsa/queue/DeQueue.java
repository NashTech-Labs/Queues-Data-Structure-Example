package com.dsa.queue;

/**
 * double ended queue pronounced "deck" and sometimes referred to as a head-tail
 * linked list. A dequeue is a data structure based on a doubly linked list, but
 * only supports adding and removal of nodes from the beginning and the end of
 * the list.
 *
 * @author shashikant
 */
public class DeQueue<T> {

    /**
     * Node for the dequeue
     */
    static class DequeNode<S> {

        /**
         * Value of the node
         */
        S val;

        /**
         * Next node in the dequeue from this node
         */
        DequeNode<S> next = null;

        /**
         * Previous node in the dequeue from this node
         */
        DequeNode<S> prev = null;

        /**
         * Constructor
         */
        DequeNode(S val) {
            this.val = val;
        }
    }

    /**
     * Head of the dequeue
     */
    DequeNode<T> head = null;

    /**
     * Tail of the deque
     */
    DequeNode<T> tail = null;

    /**
     * Size of the DeQueue
     */
    int size = 0;

    /**
     * Adds the specified value to the head of the dequeue
     *
     * @param val Value to add to the dequeue
     */
    public void addFirst(T val) {
        // Create a new node with the given value
        DequeNode<T> newNode = new DequeNode<T>(val);

        // Add the node
        if (head == null) {
            // If the deque is empty, add the node as the head and tail
            head = newNode;
            tail = newNode;
        } else {
            // If the deque is not empty, insert the node as the new head
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    /**
     * Adds the specified value to the tail of the dequeue
     *
     * @param val Value to add to the dequeue
     */
    public void addLast(T val) {
        // Create a new node with the given value
        DequeNode<T> newNode = new DequeNode<T>(val);

        // Add the node
        if (tail == null) {
            // If the deque is empty, add the node as the head and tail
            head = newNode;
            tail = newNode;
        } else {
            // If the deque is not empty, insert the node as the new tail
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    /**
     * Removes and returns the first (head) value in the dequeue
     *
     * @return the value of the head of the dequeue
     */
    public T pollFirst() {
        // If the head is null, return null
        if (head == null) {
            return null;
        }

        // First, let's get the value of the old head
        T oldHeadVal = head.val;

        // Now, let's remove the head
        if (head == tail) {
            // If there is only one node, remove it
            head = null;
            tail = null;
        } else {
            // If there is more than one node, fix the references
            head.next.prev = null;
            DequeNode<T> oldHead = head;
            head = head.next;

            // Can be considered unnecessary...
            // Unlinking the old head to make sure there are no random
            // references possibly affecting garbage collection
            oldHead.next = null;
        }

        size--;
        return oldHeadVal;
    }

    /**
     * Removes and returns the last (tail) value in the dequeue
     *
     * @return the value of the tail of the dequeue
     */
    public T pollLast() {
        // If the tail is null, return null
        if (tail == null) {
            return null;
        }

        // Let's get the value of the old tail
        T oldTailVal = tail.val;

        // Now, remove the tail
        if (head == tail) {
            // If there is only one node, remove it
            head = null;
            tail = null;
        } else {
            // If there is more than one node, fix the references
            tail.prev.next = null;
            DequeNode<T> oldTail = tail;
            tail = tail.prev;

            // Similarly to above, can be considered unnecessary
            // See `pollFirst()` for explanation
            oldTail.prev = null;
        }

        size--;
        return oldTailVal;
    }

    /**
     * Returns the first (head) value of the dequeue WITHOUT removing
     *
     * @return the value of the head of the dequeue
     */
    public T peekFirst() {
        return head.val;
    }

    /**
     * Returns the last (tail) value of the dequeue WITHOUT removing
     *
     * @return the value of the tail of the dequeue
     */
    public T peekLast() {
        return tail.val;
    }

    /**
     * Returns the size of the deque
     *
     * @return the size of the deque
     */
    public int size() {
        return size;
    }

    /**
     * Returns whether the dequeue is empty
     *
     * @return whether the dequeue is empty
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Returns a stringifies deque in a pretty form:
     *
     * <p>
     * Head -> 1 <-> 2 <-> 3 <- Tail
     *
     * @return the stringifies dequeue
     */
    @Override
    public String toString() {
        StringBuilder dequeString = new StringBuilder("Head -> ");
        DequeNode<T> currNode = head;
        while (currNode != null) {
            dequeString.append(currNode.val);

            if (currNode.next != null) {
                dequeString.append(" <-> ");
            }

            currNode = currNode.next;
        }

        dequeString.append(" <- Tail");

        return dequeString.toString();
    }

    public static void main(String[] args) {
        DeQueue<Integer> myDeque = new DeQueue<Integer>();
        for (int i = 0; i < 42; i++) {
            if (i / 42.0 < 0.5) {
                myDeque.addFirst(i);
            } else {
                myDeque.addLast(i);
            }
        }

        System.out.println(myDeque);
        System.out.println("Size: " + myDeque.size());
        System.out.println();

        myDeque.pollFirst();
        myDeque.pollFirst();
        myDeque.pollLast();
        System.out.println(myDeque);
        System.out.println("Size: " + myDeque.size());
        System.out.println();

        int dequeSize = myDeque.size();
        for (int i = 0; i < dequeSize; i++) {
            int removing = -1;
            if (i / 39.0 < 0.5) {
                removing = myDeque.pollFirst();
            } else {
                removing = myDeque.pollLast();
            }

            System.out.println("Removing: " + removing);
        }

        System.out.println(myDeque);
        System.out.println(myDeque.size());
    }
}

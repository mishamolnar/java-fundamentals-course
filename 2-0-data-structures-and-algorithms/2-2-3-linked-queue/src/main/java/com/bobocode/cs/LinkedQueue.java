package com.bobocode.cs;

import com.bobocode.util.ExerciseNotCompletedException;

/**
 * {@link LinkedQueue} implements FIFO {@link Queue}, using singly linked nodes. Nodes are stores in instances of nested
 * class Node. In order to perform operations {@link LinkedQueue#add(Object)} and {@link LinkedQueue#poll()}
 * in a constant time, it keeps to references to the head and tail of the queue.
 *
 * @param <T> a generic parameter
 */
public class LinkedQueue<T> implements Queue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    /**
     * Adds an element to the end of the queue.
     *
     * @param element the element to add
     */
    public void add(T element) {
        if (tail == null) {
            tail = new Node<>(element);
            head = tail;
        } else {
            tail.next = new Node<>(element);
            tail = tail.next;
        }
        size++;
    }

    /**
     * Retrieves and removes queue head.
     *
     * @return an element that was retrieved from the head or null if queue is empty
     */
    public T poll() {
        if (head == null) return null;
        T toReturn = head.value;
        size--;
        head = head.next;
        if (head == null) tail = null;
        return toReturn;
    }

    /**
     * Returns a size of the queue.
     *
     * @return an integer value that is a size of queue
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return {@code true} if the queue is empty, returns {@code false} if it's not
     */
    public boolean isEmpty() {
        return head == null;
    }

    private static class Node<T> {

        T value;
        Node<T> next;

        public Node(T val) {
            this.value = val;
        }

        public Node(T val, Node<T> next) {
            this.value = val;
            this.next = next;
        }
    }
}

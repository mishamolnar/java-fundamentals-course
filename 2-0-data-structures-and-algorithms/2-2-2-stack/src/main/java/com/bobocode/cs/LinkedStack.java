package com.bobocode.cs;

import com.bobocode.cs.exception.EmptyStackException;
import com.bobocode.util.ExerciseNotCompletedException;

/**
 * {@link LinkedStack} is a stack implementation that is based on singly linked generic nodes.
 * A node is implemented as inner static class {@link Node<T>}.
 *
 * @param <T> generic type parameter
 */
public class LinkedStack<T> implements Stack<T> {
    Node<T> head;
    int size;

    public LinkedStack(Node<T> head, int size) {
        this.head = head;
        this.size = size;
    }

    public LinkedStack() {
        this.size = 0;
    }

    /**
     * This method creates a stack of provided elements
     *
     * @param elements elements to add
     * @param <T>      generic type
     * @return a new stack of elements that were passed as method parameters
     */
    public static <T> LinkedStack<T> of(T... elements) {
        Node<T> top = null;
        for (T element : elements) {
            if (top == null) top = new Node<>(element);
            else top = new Node<>(element, top);
        }
        return new LinkedStack<>(top, elements.length);
    }

    /**
     * The method pushes an element onto the top of this stack. This has exactly the same effect as:
     * addElement(item)
     *
     * @param element elements to add
     */
    @Override
    public void push(T element) {
        if (element == null) throw new NullPointerException();
        size++;
        head = new Node<>(element, head);
    }

    /**
     * This method removes the object at the top of this stack
     * and returns that object as the value of this function.
     *
     * @return The object at the top of this stack
     * @throws EmptyStackException - if this stack is empty
     */
    @Override
    public T pop() {
        if (head == null) throw new EmptyStackException();
        T toReturn = head.value;
        size--;
        if (head.next == null)  head = null;
        else head = head.next;
        return toReturn;
    }

    /**
     * Returns the number of elements in the stack
     *
     * @return number of elements
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if a stack is empty
     *
     * @return {@code true} if a stack is empty, {@code false} otherwise
     */
    @Override
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

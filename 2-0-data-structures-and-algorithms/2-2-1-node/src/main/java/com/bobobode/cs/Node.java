package com.bobobode.cs;

/**
 * Class {@link Node} is a very simple data structure that consists of an element itself and the reference to the next
 * node. An element can have any value since it's a generic. A reference to the next node allows to link {@link Node}
 * objects and build more comprehensive data structures on top of those liked nodes.
 *
 * @param <T> a generic type T
 */
public class Node<T> {
    T val;
    Node<T> next;

    public Node(T val) {
        this.val = val;
    }

    public Node(T val, Node<T> next) {
        this.val = val;
        this.next = next;
    }

    // todo:
}

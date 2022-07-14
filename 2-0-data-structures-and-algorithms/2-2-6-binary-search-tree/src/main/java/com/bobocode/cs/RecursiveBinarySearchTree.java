package com.bobocode.cs;

import com.bobocode.util.ExerciseNotCompletedException;

import java.util.Stack;
import java.util.function.Consumer;

public class RecursiveBinarySearchTree<T extends Comparable<T>> implements BinarySearchTree<T> {
    private Node<T> root;
    private int size;

    public static <T extends Comparable<T>> RecursiveBinarySearchTree<T> of(T... elements) {
        RecursiveBinarySearchTree<T> recursiveBinarySearchTree = new RecursiveBinarySearchTree<>();
        for (T element : elements) {
            recursiveBinarySearchTree.insert(element);
        }
        return recursiveBinarySearchTree;
    }

    @Override
    public boolean insert(T element) {
        Node<T> iterator = root;
        if (root == null) {
            root = new Node<>(element);
            size++;
            return true;
        }
        while (iterator != null) {
            if (iterator.value.equals(element)) return false;
            else if (iterator.value.compareTo(element) > 0) {
                if (iterator.left == null) {
                    iterator.left = new Node<>(element);
                    size++;
                    return true;
                }
                iterator = iterator.left;
            } else {
                if (iterator.right == null) {
                    iterator.right = new Node<>(element);
                    size++;
                    return true;
                }
                iterator = iterator.right;
            }
        }
        return false;
    }

    @Override
    public boolean contains(T element) {
        if (element == null) throw new NullPointerException();
        Node<T> iterator = root;
        while (iterator != null) {
            if (iterator.value.equals(element)) return true;
            else if (iterator.value.compareTo(element) > 0) iterator = iterator.left;
            else iterator = iterator.right;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int depth() {
        if (root == null) return 0;
        return helper(root, 0);
    }

    private int helper(Node<T> node, int level) {
        if (node == null) return level - 1;
        return Math.max(helper(node.left, level + 1), helper(node.right, level + 1));
    }

    @Override
    public void inOrderTraversal(Consumer<T> consumer) {
        Stack<Node<T>> stack = new Stack<>();
        addAllLeftToStack(stack, root);
        while (!stack.isEmpty()) {
            Node<T> curr = stack.pop();
            consumer.accept(curr.value);
            if (curr.right != null) addAllLeftToStack(stack, curr.right);
        }
    }

    private void addAllLeftToStack(Stack<Node<T>> stack, Node<T> node) {
        while (node != null) {
            stack.add(node);
            node = node.left;
        }
    }

    private void iterate(Node<T> node, Consumer<T> consumer) {
        if (node == null) return;
        iterate(node.left, consumer);
        consumer.accept(node.value);
        iterate(node.right, consumer);
    }


    private static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        public Node(T element) {
            this.value = element;
        }
    }
}

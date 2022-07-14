package com.bobocode.cs;

import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Reflection {
    private static final Integer[] someElements = {10, 9, 11, 8, 12, 7};

    @SneakyThrows
    public static void main(String[] args) {
        var methods = RecursiveBinarySearchTree.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.toString());
        }
        System.out.println(BinarySearchTree.class.getProtectionDomain());

        var method = methods[4];
        System.out.println(method.toString());
        System.out.println(Arrays.toString(method.getParameterTypes()));

        BinarySearchTree<Integer> bst = (BinarySearchTree<Integer>) method.invoke(
                                    RecursiveBinarySearchTree.class.getDeclaredConstructor().newInstance(),
                                    (Object) someElements);
    }
}

package com.bobocode.cs;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class SayHelloReflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        var helloInterface = Class.forName("com.bobocode.cs.SayHello");
        var classLoader = helloInterface.getClassLoader();
        var toImplement = new Class<?>[]{helloInterface};

        InvocationHandler handler = (proxy, method, args1) -> {
            if (method.getName().equals("sayHello")) {
                System.out.println("hello");
                return 0;
            }
            else throw new RuntimeException();
        };

        var sayHelloInterfaceInstance = Proxy.newProxyInstance(classLoader, toImplement, handler);
        var method = sayHelloInterfaceInstance.getClass().getMethod("sayHello");
        method.invoke(sayHelloInterfaceInstance);
    }
}

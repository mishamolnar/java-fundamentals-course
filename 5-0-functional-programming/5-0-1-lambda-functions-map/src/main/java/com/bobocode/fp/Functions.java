package com.bobocode.fp;

import java.util.function.Function;
import java.util.function.Supplier;

public class Functions {
    /**
     * A static factory method that creates an integer function map with basic functions:
     * - abs (absolute value)
     * - sgn (signum function)
     * - increment
     * - decrement
     * - square
     *
     * @return an instance of {@link FunctionMap} that contains all listed functions
     */
    public static FunctionMap<Integer, Integer> intFunctionMap() {
        FunctionMap<Integer, Integer> intFunctionMap = new FunctionMap<>();
        intFunctionMap.addFunction("abs", Math::abs);
        intFunctionMap.addFunction("sgn", a -> a == 0 ? 0 : a / Math.abs(a));
        intFunctionMap.addFunction("increment", a -> a + 1);
        intFunctionMap.addFunction("decrement", a -> a - 1);
        intFunctionMap.addFunction("square", a -> a * a);


        // todo: add simple functions to the function map (abs, sgn, increment, decrement, square)

        return intFunctionMap;
    }
}

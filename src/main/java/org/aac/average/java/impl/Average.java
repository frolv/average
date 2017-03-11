package org.aac.average.java.impl;

import org.aac.average.java.impl.function.Function;
import org.aac.average.java.impl.function.FunctionParameter;

public class Average {
    public static void main() {
        Function<Integer> average;

        average = new Function<>().addParameter(new FunctionParameter<Integer>("a"))
                                  .addParameter(new FunctionParameter<Integer>("b"));
    }
}

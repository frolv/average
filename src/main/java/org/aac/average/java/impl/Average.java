package org.aac.average.java.impl;

import org.aac.average.java.impl.function.Function;
import org.aac.average.java.impl.function.FunctionParameter;
import org.aac.average.java.impl.datatypes.ConcreteInteger;

public class Average {
    public static void main(String[] args) {
        Function<Integer> average;

        average = new Function<>().addParameter(new FunctionParameter<Integer>("a"))
                                  .addParameter(new FunctionParameter<Integer>("b"));

        ConcreteInteger firstNumber = new ConcreteInteger.Builder()
                                                         .addDigit(ConcreteInteger.Digit.TWO)
                                                         .build();
        ConcreteInteger secondNumber = new ConcreteInteger.Builder()
                                                          .addDigit(ConcreteInteger.Digit.ONE)
                                                          .addDigit(ConcreteInteger.Digit.EIGHT)
                                                          .build();
    }
}

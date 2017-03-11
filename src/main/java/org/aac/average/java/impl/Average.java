package org.aac.average.java.impl;

import org.aac.average.java.impl.function.Function;
import org.aac.average.java.impl.function.FunctionParameter;
import org.aac.average.java.impl.datatypes.ConcreteInteger;

public class Average {
    public static void main(String[] args) {
        Function<ConcreteInteger> averageTwoIntegers;

        averageTwoIntegers = new Function<>().addParameter(new FunctionParameter<ConcreteInteger>("a"))
                                             .addParameter(new FunctionParameter<ConcreteInteger>("b"));

        ConcreteInteger firstNumber = new ConcreteInteger.DecimalBuilder()
                                                         .addDigit(ConcreteInteger.DecimalDigit.TWO)
                                                         .build();
        ConcreteInteger secondNumber = new ConcreteInteger.DecimalBuilder()
                                                          .addDigit(ConcreteInteger.DecimalDigit.ONE)
                                                          .addDigit(ConcreteInteger.DecimalDigit.EIGHT)
                                                          .build();
    }
}

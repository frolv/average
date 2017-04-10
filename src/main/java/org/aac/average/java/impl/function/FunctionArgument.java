package org.aac.average.java.impl.function;

public class FunctionArgument<T> {
    private T value;

    public FunctionArgument(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

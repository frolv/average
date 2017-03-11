package org.aac.average.java.impl.function;

import java.util.HashMap;
import org.aac.average.java.interfaces.Callable;

public class Function<T> implements Callable {
    private HashMap<String, FunctionParameter> parameters;
    private T returnValue;

    public Function() {
        parameters = new HashMap<>();
    }

    public Function addParameter(FunctionParameter param) {
        parameters.put(param.getName(), param);
        return this;
    }

    public T getReturnValue() {
        return returnValue;
    }

    public void call() {
    }
}

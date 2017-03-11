package org.aac.average.java.impl.datatypes;

public class ConcreteInteger implements Comparable<ConcreteInteger> {
    private Integer integer;

    public static enum Digit {
        ZERO  (0),
        ONE   (1),
        TWO   (2),
        THREE (3),
        FOUR  (4),
        FIVE  (5),
        SIX   (6),
        SEVEN (7),
        EIGHT (8),
        NINE  (9);

        private int value;

        Digit(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static class Builder {
        private int value = 0;

        public Builder addDigit(Digit digit) {
            value = value * 10 + digit.getValue();
            return this;
        }

        public ConcreteInteger build() {
            return new ConcreteInteger(this);
        }
    }

    private ConcreteInteger(Builder builder) {
        this.integer = new Integer(builder.value);
    }

    protected ConcreteInteger(int value) {
        this.integer = new Integer(value);
    }

    public int getValue() {
        return integer.intValue();
    }

    public ConcreteInteger add(ConcreteInteger other) {
        return new ConcreteInteger(this.getValue() + other.getValue());
    }

    public ConcreteInteger subtract(ConcreteInteger other) {
        return new ConcreteInteger(this.getValue() - other.getValue());
    }

    public int compareTo(ConcreteInteger other) {
        return this.subtract(other).getValue();
    }
}

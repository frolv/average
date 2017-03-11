package org.aac.average.java.impl.datatypes;

public class ConcreteInteger implements Comparable<ConcreteInteger> {
    private Integer integer;

    public static enum DecimalDigit {
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

        DecimalDigit(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static enum BinaryDigit {
        ZERO  (0),
        ONE   (1);

        private int value;

        BinaryDigit(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    private abstract static class Builder {
        protected int value = 0;

        public ConcreteInteger build() {
            return new ConcreteInteger(this);
        }
    }

    public static class DecimalBuilder extends Builder {
        public DecimalBuilder addDigit(DecimalDigit digit) {
            value = value * 10 + digit.getValue();
            return this;
        }
    }

    public static class BinaryBuilder extends Builder {
        public BinaryBuilder addDigit(BinaryDigit digit) {
            value = (value << 1) | digit.getValue();
            return this;
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

    /**
     * Create a new ConcreteInteger whose value is the sum of this and other.
     *
     * @param other the ConcreteInteger to add to this one.
     * @return a new ConcreteInteger whose value is the sum.
     */
    public ConcreteInteger add(ConcreteInteger other) {
        return new ConcreteInteger(this.getValue() + other.getValue());
    }

    /**
     * Create a new ConcreteInteger whose value is the difference between
     * this and other.
     *
     * @param other the ConcreteInteger to subtract from this one.
     * @return a new ConcreteInteger whose value is the difference.
     */
    public ConcreteInteger subtract(ConcreteInteger other) {
        return new ConcreteInteger(this.getValue() - other.getValue());
    }

    public int compareTo(ConcreteInteger other) {
        return this.subtract(other).getValue();
    }
}

package org.aac.average.java.datatypes;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.aac.average.java.impl.datatypes.ConcreteInteger;

public class TestConcreteInteger {
    @Test
    public void testDecimalBuilderEmpty() {
        ConcreteInteger c = new ConcreteInteger.DecimalBuilder().build();
        assertEquals(0, c.getValue());
    }

    @Test
    public void testDecimalBuilderArgs() {
        ConcreteInteger c = new ConcreteInteger.DecimalBuilder()
                                               .addDigit(ConcreteInteger.DecimalDigit.ONE)
                                               .build();
        assertEquals(1, c.getValue());

        c = new ConcreteInteger.DecimalBuilder()
                               .addDigit(ConcreteInteger.DecimalDigit.ONE)
                               .addDigit(ConcreteInteger.DecimalDigit.SEVEN)
                               .build();
        assertEquals(17, c.getValue());

        c = new ConcreteInteger.DecimalBuilder()
                               .addDigit(ConcreteInteger.DecimalDigit.ONE)
                               .addDigit(ConcreteInteger.DecimalDigit.SEVEN)
                               .addDigit(ConcreteInteger.DecimalDigit.THREE)
                               .addDigit(ConcreteInteger.DecimalDigit.EIGHT)
                               .build();
        assertEquals(1738, c.getValue());

        c = new ConcreteInteger.DecimalBuilder()
                               .addDigit(ConcreteInteger.DecimalDigit.ZERO)
                               .addDigit(ConcreteInteger.DecimalDigit.NINE)
                               .build();
        assertEquals(9, c.getValue());

        c = new ConcreteInteger.DecimalBuilder()
                               .addDigit(ConcreteInteger.DecimalDigit.TWO)
                               .addDigit(ConcreteInteger.DecimalDigit.THREE)
                               .buildNegative();
        assertEquals(-23, c.getValue());
    }

    @Test
    public void testBinaryBuilderEmpty() {
        ConcreteInteger c = new ConcreteInteger.BinaryBuilder().build();
        assertEquals(0, c.getValue());
    }

    @Test
    public void testBinaryBuilderArgs() {
        ConcreteInteger c = new ConcreteInteger.BinaryBuilder()
                                               .addDigit(ConcreteInteger.BinaryDigit.ONE)
                                               .build();
        assertEquals(1, c.getValue());

        c = new ConcreteInteger.BinaryBuilder()
                               .addDigit(ConcreteInteger.BinaryDigit.ONE)
                               .addDigit(ConcreteInteger.BinaryDigit.ZERO)
                               .build();
        assertEquals(2, c.getValue());

        c = new ConcreteInteger.BinaryBuilder()
                               .addDigit(ConcreteInteger.BinaryDigit.ONE)
                               .addDigit(ConcreteInteger.BinaryDigit.ZERO)
                               .addDigit(ConcreteInteger.BinaryDigit.ZERO)
                               .addDigit(ConcreteInteger.BinaryDigit.ONE)
                               .build();
        assertEquals(9, c.getValue());

        c = new ConcreteInteger.BinaryBuilder()
                               .addDigit(ConcreteInteger.BinaryDigit.ZERO)
                               .addDigit(ConcreteInteger.BinaryDigit.ONE)
                               .addDigit(ConcreteInteger.BinaryDigit.ONE)
                               .build();
        assertEquals(3, c.getValue());
    }

    @Test
    public void testAdd() {
        ConcreteInteger a, b, c;

        a = new ConcreteInteger.DecimalBuilder()
                               .addDigit(ConcreteInteger.DecimalDigit.ONE)
                               .build();
        b = new ConcreteInteger.DecimalBuilder()
                               .addDigit(ConcreteInteger.DecimalDigit.FOUR)
                               .build();
        c = a.add(b);
        assertEquals(5, c.getValue());
        a = c.add(b);
        assertEquals(9, a.getValue());
        a = a.add(new ConcreteInteger.DecimalBuilder().build());
        assertEquals(9, a.getValue());
    }

    @Test
    public void testSubtract() {
        ConcreteInteger a, b, c;

        a = new ConcreteInteger.DecimalBuilder()
                               .addDigit(ConcreteInteger.DecimalDigit.ONE)
                               .build();
        b = new ConcreteInteger.DecimalBuilder()
                               .addDigit(ConcreteInteger.DecimalDigit.FOUR)
                               .build();
        c = b.subtract(a);
        assertEquals(3, c.getValue());
        c = c.subtract(a);
        assertEquals(2, c.getValue());
        c = c.subtract(b);
        assertEquals(-2, c.getValue());
    }

    @Test
    public void testMultiply() {
        ConcreteInteger a, b, c;

        a = new ConcreteInteger.DecimalBuilder()
                               .addDigit(ConcreteInteger.DecimalDigit.SEVEN)
                               .build();
        b = new ConcreteInteger.DecimalBuilder()
                               .addDigit(ConcreteInteger.DecimalDigit.NINE)
                               .buildNegative();
        c = a.multiply(b);
        assertEquals(-63, c.getValue());
        c = a.multiply(a);
        assertEquals(49, c.getValue());
        c = c.multiply(new ConcreteInteger.DecimalBuilder().build());
        assertEquals(0, c.getValue());
    }

    @Test
    public void testDivide() {
        ConcreteInteger a, b, c;

        a = new ConcreteInteger.DecimalBuilder()
                               .addDigit(ConcreteInteger.DecimalDigit.NINE)
                               .build();
        b = new ConcreteInteger.DecimalBuilder()
                               .addDigit(ConcreteInteger.DecimalDigit.THREE)
                               .buildNegative();
        c = a.divide(b);
        assertEquals(-3, c.getValue());
        c = c.divide(b);
        assertEquals(1, c.getValue());
        c = c.divide(a);
        assertEquals(0, c.getValue());
        try {
            c = a.divide(c);
            fail("Divison by zero: IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {}
    }
}

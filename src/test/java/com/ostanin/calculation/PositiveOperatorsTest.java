package com.ostanin.calculation;

import com.ostanin.calculation.Operators;
import com.ostanin.exception.DivisionByZeroException;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@Tag("Positive")
public class PositiveOperatorsTest {

    @Test
    void getValueMultiply() {
        assertEquals("*", Operators.getEnum("*").getValue());
    }

    @Test
    void getValuePlus() {
        assertEquals("+", Operators.getEnum("+").getValue());
    }

    @Test
    void getValueMinus() {
        assertEquals("-", Operators.getEnum("-").getValue());
    }

    @Test
    void getValueDivide() {
        assertEquals("/", Operators.getEnum("/").getValue());
    }

    @Test
    void operationPlus() {
        assertEquals(BigDecimal.valueOf(15), Operators.PLUS.apply(BigDecimal.valueOf(5), BigDecimal.valueOf(10)));
    }

    @Test
    void operationMinus() {
        assertEquals(BigDecimal.valueOf(5), Operators.MINUS.apply(BigDecimal.valueOf(15), BigDecimal.valueOf(10)));
    }

    @Test
    void operationMultiply() {
        assertEquals(BigDecimal.valueOf(400), Operators.MULTIPLY.apply(BigDecimal.valueOf(40), BigDecimal.valueOf(10)));
    }

    @Test
    void operationDivide() {
        assertEquals(BigDecimal.valueOf(4), Operators.DIVIDE.apply(BigDecimal.valueOf(40), BigDecimal.valueOf(10)));
    }

    @Test
    void operationDivideByZero() {
        assertThrows(DivisionByZeroException.class, () -> {
            Operators.DIVIDE.apply(BigDecimal.valueOf(40), BigDecimal.valueOf(0));
        });
    }

    @Test
    void getIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Operators.getEnum("%");
        });
    }
}

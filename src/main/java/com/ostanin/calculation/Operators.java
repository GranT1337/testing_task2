package com.ostanin.calculation;


import com.ostanin.exception.DivisionByZeroException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum Operators {
    PLUS("+") {
        @Override
        BigDecimal apply(BigDecimal x, BigDecimal y) {
            return x.add(y);
        }
    },
    MINUS("-") {
        @Override
        BigDecimal apply(BigDecimal x, BigDecimal y) {
            return x.subtract(y);
        }
    },
    MULTIPLY("*") {
        @Override
        BigDecimal apply(BigDecimal x, BigDecimal y) {
            return x.multiply(y);
        }
    },
    DIVIDE("/") {
        @Override
        BigDecimal apply(BigDecimal x, BigDecimal y) {
            if (y.equals(new BigDecimal(0))) {
                throw new DivisionByZeroException("Деление на ноль запрещено");
            }
            return x.divide(y, 20, RoundingMode.HALF_UP).stripTrailingZeros();
        }
    };


    private String value;

    Operators(String value) {
        this.value = value;
    }

    public static Operators getEnum(String value) {
        for (Operators operator : values()) {
            if (operator.getValue().equals(value)) {
                return operator;
            }
        }
        throw new IllegalArgumentException();
    }

    abstract BigDecimal apply(BigDecimal x, BigDecimal y);

    public String getValue() {
        return value;
    }
}

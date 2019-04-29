package com.ostanin;

import com.ostanin.converting.MethodsToCheck;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("Negative")
public class NegativeMethodsToCheckTest {

    MethodsToCheck methodsToCheck;

    @BeforeEach
    void setUp() {
        methodsToCheck = new MethodsToCheck();
    }

    @AfterEach
    void tearDown() {
        methodsToCheck = null;
    }

    @Test
    void isNumberNegative() {
        assertFalse(methodsToCheck.isNumber("*"));
    }

    @Test
    void isOperator() {
        assertFalse(methodsToCheck.isOperator("5"));
    }

    @Test
    void isCloseBracket() {
        assertFalse(methodsToCheck.isCloseBracket("("));
    }

    @Test
    void isOpenBracket() {
        assertFalse(methodsToCheck.isOpenBracket(")"));
    }

}

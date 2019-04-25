package com.ostanin;

import com.ostanin.converting.MethodsToCheck;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@Tag("Positive")
public class PositiveMethodsToCheckTest {
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
    void isNumber() {
        assertTrue(methodsToCheck.isNumber("5"));
    }

    @Test
    void isOperator() {
        assertTrue(methodsToCheck.isOperator("*"));
    }

    @Test
    void isCloseBracket() {
        assertTrue(methodsToCheck.isCloseBracket(")"));
    }

    @Test
    void isOpenBracket() {
        assertTrue(methodsToCheck.isOpenBracket("("));
    }


    @Test
    void priorityOperatorPlusMinus() {
        assertEquals(1, methodsToCheck.priorityOperator("+"));
    }

    @Test
    void priorityOperatorMultiplyDiv() {
        assertEquals(2, methodsToCheck.priorityOperator("*"));
    }

}

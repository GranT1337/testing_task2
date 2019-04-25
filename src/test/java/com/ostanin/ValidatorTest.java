package com.ostanin;

import com.ostanin.parsingandvalidate.Validator;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

@Tag("Test")
public class ValidatorTest {

    Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @AfterEach
    void tearDown() {
        validator = null;
    }

    @Test
    @DisplayName("Negative Validator. Check expression with letter")
    void checkExpressionWithLetter() {
        assertFalse(validator.validate("5+5A"));
    }

    @Test
    @DisplayName("Negative Validator. Check expression with Repeat Operators")
    void checkExpressionWithRepeatOperators() {
        assertFalse(validator.validate("5+*5"));
    }

    @Test
    @DisplayName("Negative Validator. Check expression Brackets With Operator ")
    void checkExpressionBracketsWithOperator() {
        assertFalse(validator.validate("5+(*(5+5))"));
    }

    @Test
    @DisplayName("Negative Validator. Check expression with Separator Near Brackets ")
    void checkExpressionWithSeparatorNearBrackets() {
        assertFalse(validator.validate("5+5.(5+5)"));
    }


    @Test
    @DisplayName("Positive Validator")
    void checkExpression() {
        assertTrue(validator.validate("5+5"));
    }
}

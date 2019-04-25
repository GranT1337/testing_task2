package com.ostanin;

import com.ostanin.calculation.CalculationRPN;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Tag("Test")
public class CalculationRPNTest {
    CalculationRPN calculationRPN;

    @BeforeEach
    void setUp() {
        calculationRPN = new CalculationRPN();
    }

    @AfterEach
    void tearDown() {
        calculationRPN = null;
    }

    @Test
    void trueCalculationRPN() {
        List<String> list = Arrays.asList("6", "5", "*", "4", "3", "+", "*", "10", "-");
        assertEquals(BigDecimal.valueOf(200), calculationRPN.calculations(list));
    }

    @Test
    void falseCalculationRPN() {
        List<String> list = Arrays.asList("6", "5", "*", "4", "3", "+", "*", "10", "-");
        assertNotEquals(BigDecimal.valueOf(201), calculationRPN.calculations(list));
    }
}

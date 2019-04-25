package com.ostanin;

import com.ostanin.processes.Result;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@Tag("Test")
public class ResultTest {
    Result result;

    @BeforeEach
    void setUp() {
        result = new Result();
    }

    @AfterEach
    void tearDown() {
        result = null;
    }

    @Test
    void trueResult() {
        assertEquals(BigDecimal.valueOf(35), result.getResult("5+5+5*5"));
    }

    @Test
    void falseResult() {
        assertNull(result.getResult("5+5+5*5(*("));
    }

}

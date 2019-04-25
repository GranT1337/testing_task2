package com.ostanin;

import com.ostanin.converting.ConvertingToRPN;
import com.ostanin.converting.MethodsToCheck;
import com.ostanin.exception.BracketException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Tag("Test")
public class ConvertingToRPNTest {
    ConvertingToRPN convertingToRPN;

    @BeforeEach
    void setUp() {
        convertingToRPN = new ConvertingToRPN();
    }

    @AfterEach
    void tearDown() {
        convertingToRPN = null;
    }

    @Test
    void trueConvertingToRPN() {
        List<String> list = Arrays.asList("6", "5", "*", "4", "3", "+", "/", "10", "-");
        assertEquals(list, convertingToRPN.parse("6*5/(4+3)-10"));
    }

    @Test
    void falseConvertingToRPN() {
        List<String> list = Arrays.asList("6", "*", "5", "4", "3", "+", "/", "10", "-");
        assertNotEquals(list, convertingToRPN.parse("6*5/(4+3)-10"));
    }

    @Test
    void wrongOpenBrackets() {
        assertThrows(BracketException.class,
                ()-> convertingToRPN.parse("6*5/((4+3)-10"));
    }

    @Test
    void wrongCloseBrackets() {
        assertThrows(BracketException.class,
                ()-> convertingToRPN.parse("6*5/(4+3))-10"));
    }



}

package com.ostanin;

import com.ostanin.parsingandvalidate.ParsToNormalView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("Negative")
public class ParsingToNormalViewTest {

    ParsToNormalView parsToNormalView;

    @BeforeEach
    void setUp() {
        parsToNormalView = new ParsToNormalView();
    }

    @AfterEach
    void tearDown() {
        parsToNormalView = null;
    }

    @Test
    void checkOnReplaceExpressionToNormalView() {
        String normalExpression = parsToNormalView.parsingToNormalView("5+ 5+(+5+5,2)-(-5)");
        assertEquals("5+5+(0+5+5.2)-(0-5)", normalExpression);
    }

    @Test
    void checkReplaceMinusAtTheBeginningOfAnExpression() {
        String normalExpression = parsToNormalView.parsingToNormalView("-5+5");
        assertEquals("0-5+5", normalExpression);
    }


}

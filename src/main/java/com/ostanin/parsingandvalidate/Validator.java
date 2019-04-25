package com.ostanin.parsingandvalidate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Validator {

    public boolean validate(String string) {

        boolean findBadSymbols1 = isContainsNotNumber(string);
        boolean findBadSymbols2 = isContainsRepeatOperators(string);
        boolean findBadSymbols3 = isContainsBracketsWithOperator(string);
        boolean findBadSymbols4 = isContainsSeparatorNearBrackets(string);

        return !(findBadSymbols1 | findBadSymbols2 | findBadSymbols3 | findBadSymbols4);
    }

    private boolean isContainsNotNumber(String expression) {
        String regexForNotNumbers = "[^(.)/*\\-+0-9]";
        Matcher matcherForNotNumbers = Pattern.compile(regexForNotNumbers).matcher(expression);
        return matcherForNotNumbers.find();
    }

    private boolean isContainsRepeatOperators(String expression) {
        String regexForRepeatOps = "[./*\\-+]{2,}";
        Matcher matcherForRepeatOps = Pattern.compile(regexForRepeatOps).matcher(expression);
        return matcherForRepeatOps.find();
    }

    private boolean isContainsBracketsWithOperator(String expression) {
        String regexForBracketsOperators = "[(][/*][(]|[)][/*][)]";
        Matcher matcherForBrackets = Pattern.compile(regexForBracketsOperators).matcher(expression);
        return matcherForBrackets.find();
    }

    private boolean isContainsSeparatorNearBrackets(String expression) {
        String regexForSeparatorNearBrackets = "[\\d?.]+[(]|[)][\\d?.]+";
        Matcher matcherForNumNearBrackets = Pattern.compile(regexForSeparatorNearBrackets).matcher(expression);
        return matcherForNumNearBrackets.find();
    }
}

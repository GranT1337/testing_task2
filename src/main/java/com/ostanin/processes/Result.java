package com.ostanin.processes;



import com.ostanin.calculation.CalculationRPN;
import com.ostanin.converting.ConvertingToRPN;
import com.ostanin.exception.BracketException;
import com.ostanin.parsingandvalidate.ParsToNormalView;
import com.ostanin.parsingandvalidate.Validator;

import java.math.BigDecimal;
import java.util.List;

public class Result {
    private CalculationRPN calculationRPN = new CalculationRPN();
    private ConvertingToRPN convertingToRPN = new ConvertingToRPN();
    private ParsToNormalView parsingToNormalView = new ParsToNormalView();


    public BigDecimal getResult(String calculated) {

        Validator validator = new Validator();

        calculated = parsingToNormalView.parsingToNormalView(calculated);
        if (validator.validate(calculated)) {
            List<String> tmpListRPN = convertingToRPN.parse(calculated);
            return calculationRPN.calculations(tmpListRPN);
        } else {
            System.out.println("Некорректная строка");
            return null;
        }
    }
}

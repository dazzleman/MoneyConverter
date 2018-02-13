package com.example.admin.moneyconverter.utils;

import com.example.admin.moneyconverter.model.Valute;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author Nikolay Vlaskin on 12.02.2018.
 */

public class CalculateUtils {

    public static String calculate(String value, Valute inputValute, Valute outputValute) {
        try {
            double result =
                    calcInputValue(value, inputValute) /
                            calcOutputValue(outputValute);
            NumberFormat formatter = new DecimalFormat("#0.00");
            return formatter.format(result);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static double calcInputValue(String value, Valute valute) throws NumberFormatException {
        return (valute.getValue() / (double) valute.getNominal())
                * Double.parseDouble(value.replace(",", "."));
    }

    public static double calcOutputValue(Valute valute) throws NumberFormatException {
        return valute.getValue() / (double) valute.getNominal();
    }
}

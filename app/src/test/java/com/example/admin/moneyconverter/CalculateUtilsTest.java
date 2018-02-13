package com.example.admin.moneyconverter;

import com.example.admin.moneyconverter.model.Valute;
import com.example.admin.moneyconverter.utils.CalculateUtils;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Nikolay Vlaskin on 13.02.2018.
 */

public class CalculateUtilsTest {

    private Valute inputValute;
    private Valute outputValute;
    private String value;

    @Before
    public void setUp() throws Exception {
        inputValute = new Valute();
        inputValute.setNominal(1);
        inputValute.setValue(45.3520);

        outputValute = new Valute();
        outputValute.setNominal(1);
        outputValute.setValue(34.0776);

        value = "10";
    }

    @Test
    public void calculate() throws Exception {
        assertEquals("13,31", CalculateUtils.calculate(value, inputValute, outputValute));
    }
}

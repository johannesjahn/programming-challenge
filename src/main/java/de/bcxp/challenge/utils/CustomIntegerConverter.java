package de.bcxp.challenge.utils;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class CustomIntegerConverter extends AbstractBeanField<Long, Integer> {

    @Override
    protected Object convert(String s) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        var doubleResult = Double.parseDouble(s.replace(".", "").replace(",", "."));
        return (long) doubleResult;
    }
}

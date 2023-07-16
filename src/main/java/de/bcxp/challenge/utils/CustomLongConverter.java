package de.bcxp.challenge.utils;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

/**
 * This class is used to convert a string to a Long for the case if an integer
 * comes with a decimal point and uses a comma.
 */
public class CustomLongConverter extends AbstractBeanField<Long, Integer> {

    @Override
    protected Object convert(String s) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        var doubleResult = Double.parseDouble(s.replace(".", "").replace(",", "."));
        return (long) doubleResult;
    }
}

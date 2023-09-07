/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.ui.oferta;

import com.vaadin.data.util.PropertyFormatter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import org.apache.commons.beanutils.ConversionException;

/**
 *
 * @author lsierra
 */
public class NumberPropertyFormatterInt extends PropertyFormatter {

	/**
	 * 
	 */
    private BigDecimal value;
	private static final long serialVersionUID = 5993664835033712194L;

    private final DecimalFormat df = new DecimalFormat("#,##0");
    {
        df.setParseBigDecimal(true);
        // df.setRoundingMode(RoundingMode.HALF_UP);
    }

    @Override
    public String format(Object value) {

        final String retVal;
        if (value == null) {
            retVal = "";
        } else {
            retVal = df.format(value);
        }
        return retVal;
    }

    @Override
    public Object parse(String formattedValue) throws Exception {
        if (formattedValue != null
                && formattedValue.trim().length() != 0) {
            BigDecimal value = (BigDecimal) df.parse(formattedValue);
            value = value.setScale(0, BigDecimal.ROUND_HALF_UP);
            return value;
        }
        return null;
    }
    
    public void setValue(Object newValue) throws ReadOnlyException,
            ConversionException {
        if (newValue == null) {
            value = null;
        } else if (newValue instanceof BigDecimal) {
            value = (BigDecimal) newValue;
        } else {
            throw new ConversionException("Error en conversion de datos");
        }
    }    
}
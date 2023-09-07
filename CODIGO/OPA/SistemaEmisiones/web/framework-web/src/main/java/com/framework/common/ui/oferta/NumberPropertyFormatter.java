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
 * @author rcasallas
 */
public class NumberPropertyFormatter extends PropertyFormatter {

	private static final long serialVersionUID = 5993664835033712194L;
        int decimales=0;
        private BigDecimal value;
        
    public void setDecimales(int decimales){
        this.decimales=decimales;
    }
    public int getDecimales() {
        return this.decimales;
    }
    private DecimalFormat df = new DecimalFormat("#,##0.00");
    {
        df.setParseBigDecimal(true);
    }
    public void setDecimalFormat(String format) {
        df = new DecimalFormat(format);
        df.setParseBigDecimal(true);
    } 
            
    public void setDecimalFormat() {
        df = new DecimalFormat(construirFormato(this.decimales));
        df.setParseBigDecimal(true);
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
            value = value.setScale(2, BigDecimal.ROUND_HALF_UP);
            return value;
        }
        return null;
    }
    
    public String construirFormato(int decimales) {
        String format="#,##0";
        for (int i=0;i<decimales;i++) {
            if (i==0) {
                format=format+".";
            }
            format=format+"0";
        }
        return format;
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
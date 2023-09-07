/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.ui.oferta;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ReadOnlyException;
import java.math.BigDecimal;
import org.apache.commons.beanutils.ConversionException;

/**
 *
 * @author rcasallas
 */

public class NumberProperty implements Property {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5833889120955239873L;
	private BigDecimal value;

    public Object getValue() {
        return value;
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

    public Class<?> getType() {
        return BigDecimal.class;
    }

    public boolean isReadOnly() {
        return false;
    }

    public void setReadOnly(boolean newStatus) {
        // ignore
    }

}
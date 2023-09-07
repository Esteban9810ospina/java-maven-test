/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.ui.field.validator;

import com.vaadin.data.validator.AbstractStringValidator;

/**
 * String validator for integers. See
 * {@link com.vaadin.data.validator.AbstractStringValidator} for more
 * information.
 *
 * @author Vaadin Ltd.
 * @version
 * 6.8.4
 * @since 5.4
 */
public class CustomLongValidator extends AbstractStringValidator {

    /**
     * Creates a validator for checking that a string can be parsed as an
     * integer.
     *
     * @param errorMessage
     *            the message to display in case the value does not validate.
     */
    public CustomLongValidator(String errorMessage) {
        super(errorMessage);

    }

    @Override
    protected boolean isValidValue(String value) {
       try {
            Long.parseLong(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}

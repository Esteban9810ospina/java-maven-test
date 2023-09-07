package com.framework.common.ui.field.validator;

import com.vaadin.data.validator.DoubleValidator;

/**
 *
 * @author Roger Padilla C.
 */
public class CustomDoubleValidator extends DoubleValidator {

  private int maxIntegerDigits;
  private int maxFractionalDigits;
  private char thousandsSeparator;

  public CustomDoubleValidator(String fieldTitle,
          int maxIntegerDigits, int maxFractionalDigits) {

    this(fieldTitle, maxIntegerDigits, maxFractionalDigits, '.');

    this.maxIntegerDigits = maxIntegerDigits;
    this.maxFractionalDigits = maxFractionalDigits;
    this.thousandsSeparator = '.';
  }

  public CustomDoubleValidator(String fieldTitle, int maxIntegerDigits,
          int maxFractionalDigits, char thousandsSeparator) {

    super("'" + fieldTitle + "' puede tener maximo " + maxIntegerDigits
            + " enteros y " + maxFractionalDigits + " decimales");

    this.maxIntegerDigits = maxIntegerDigits;
    this.maxFractionalDigits = maxFractionalDigits;
    this.thousandsSeparator = thousandsSeparator;
  }

  public boolean isValidString(String val) {

    boolean valid = isValidString(val);

    // if the is an invalid double then just return false
    if (!valid) {
      return false;
    }

    int sepIdx = val.indexOf(thousandsSeparator);

    // if has not the dot, then ensure the length is not greater than the
    // max number of integers (because all digits are integers if so)
    if (sepIdx < 0) {
      return val.length() <= maxIntegerDigits;
    }

    String parteEntera = val.substring(0, sepIdx);
    String parteFraccionaria = val.substring(sepIdx + 1);

    if (parteEntera.length() > maxIntegerDigits
            || parteFraccionaria.length() > maxFractionalDigits) {
      return false;
    }

    return true;
  }

  public int getMaxIntegerDigits() {
    return maxIntegerDigits;
  }

  public void setMaxIntegerDigits(int maxIntegerDigits) {
    this.maxIntegerDigits = maxIntegerDigits;
  }

  public int getMaxFractionalDigits() {
    return maxFractionalDigits;
  }

  public void setMaxFractionalDigits(int maxFractionalDigits) {
    this.maxFractionalDigits = maxFractionalDigits;
  }

  @Override
  public String toString() {
    return "CustomDoubleValidator{" + "maxIntegerDigits=" + maxIntegerDigits + ", maxFractionalDigits=" + maxFractionalDigits + '}';
  }

}

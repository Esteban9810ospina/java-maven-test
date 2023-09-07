/*
 * Informacion de Valoracion framework, Bolsa de Valores de Colombia BVC
 * Copyright (C) 2012 Quasar Software Ltda.
 */
package com.framework.reportEngine.formatter;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

/**
 *
 * @author Alejandro Riveros Cruz
 * @author Roger Padilla Camacho
 */
public class DecimalFormatter implements CampoFormatter {

  private DecimalFormat decimalFormat;

  public DecimalFormatter(String pattern) {
    NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
    decimalFormat = (DecimalFormat) numberFormat;
    decimalFormat.applyPattern(pattern);
  }

  @Override
  public String format(String campo, Map<String, Object> row) {
    return decimalFormat.format(Double.parseDouble(String.valueOf(row.get(campo))));
  }
  
  public String format(String campo) {
    return decimalFormat.format(Double.parseDouble(campo));
  }
  
}

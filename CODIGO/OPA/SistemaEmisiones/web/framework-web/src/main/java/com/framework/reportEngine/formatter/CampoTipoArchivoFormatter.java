/*
 * Informacion de Valoracion INFOVALMER, Bolsa de Valores de Colombia BVC
 * Copyright (C) 2012 Quasar Software Ltda.
 */
package com.framework.reportEngine.formatter;

import com.framework.reportEngine.formatter.CampoFormatter;
import java.util.Map;

/**
 * @author Carlos Uribe [curibe@quasarbi.com]
 */
public class CampoTipoArchivoFormatter implements CampoFormatter {

  @Override
  public String format(String campo, Map<String, Object> row) {


    return "Archivo ";
  }
}

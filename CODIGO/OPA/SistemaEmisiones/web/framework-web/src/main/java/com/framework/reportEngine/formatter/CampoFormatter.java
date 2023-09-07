/*
 * Informacion de Valoracion framework, Bolsa de Valores de Colombia BVC
 * Copyright (C) 2012 Quasar Software Ltda.
 */
package com.framework.reportEngine.formatter;

import java.util.Map;

/**
 *
 * @author Alejandro Riveros Cruz
 * @author Roger Padilla Camacho
 */
public interface CampoFormatter {

  String format(String campo, Map<String, Object> row);
}

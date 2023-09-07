/*
 * Informacion de Valoracion framework, Bolsa de Valores de Colombia BVC
 * Copyright (C) 2012 Quasar Software Ltda.
 */
package com.quasar.frameq.exception;

/**
 * Excepci&oacute;n de negocio del sistema Framework. Esta excepci&oacute;n es propagada cuando existe
 * un flujo alternativo de negocio en el sistema Framework.
 */
public class FrameworkNegocioException extends RuntimeException {

  private static final long serialVersionUID = -26291734694601184L;

  public FrameworkNegocioException(String message) {
    super(message);
  }

  public FrameworkNegocioException(String message, Throwable cause) {
    super(message, cause);
  }
}

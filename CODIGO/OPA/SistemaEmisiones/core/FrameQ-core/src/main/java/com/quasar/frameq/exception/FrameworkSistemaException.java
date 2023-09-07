/*
 * Informacion de Valoracion framework, Bolsa de Valores de Colombia BVC
 * Copyright (C) 2012 Quasar Software Ltda.
 */
package com.quasar.frameq.exception;

/**
 * Excepci&oacute;n t&eacute;cnica del sistema Framework. Esta excepci&oacute;n es propagada cuando existe un problema asociado
 * al flujo de ejecuci&oacute;n del sistema Framework.
 */
public class FrameworkSistemaException extends RuntimeException {

  private static final long serialVersionUID = -39218462767344609L;

  public FrameworkSistemaException(String message) {
    super(message);
  }

  public FrameworkSistemaException(String message, Throwable cause) {
    super(message, cause);
  }
}

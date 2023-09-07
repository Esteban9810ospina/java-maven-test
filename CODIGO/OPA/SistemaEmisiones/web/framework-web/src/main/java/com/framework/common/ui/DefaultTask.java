/*
 * Informacion de Valoracion framework, Bolsa de Valores de Colombia BVC
 * Copyright (C) 2012 Quasar Software Ltda.
 */
package com.framework.common.ui;

/**
 * @author Roger Padilla C.
 */
public abstract class DefaultTask implements Task {

  @Override
  public void beforeStart() {
    // Defaults to nothing
  }

  @Override
  public void complete() {
    // Defaults to nothing
  }
}

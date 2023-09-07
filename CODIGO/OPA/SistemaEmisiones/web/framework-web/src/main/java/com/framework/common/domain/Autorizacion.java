/*
 * Información de Valoración framework, Bolsa de Valores de Colombia BVC
 * Copyright (C) 2012 Quasar Software Ltda.
 */
package com.framework.common.domain;

/**
 * @author Robert Martínez[rmartinez@quasarbi.com]
 * @author Alejandro Riveros [lriveros@quasarbi.com]
 */
public class Autorizacion {

  private int procesoId;
  private int secuencia;
  private String username;
  private String message;
  private String date;

  public Autorizacion(int procesoId, int secuencia, String username, String message, String date) {
    this.procesoId = procesoId;
    this.secuencia = secuencia;
    this.username = username;
    this.message = message;
    this.date = date;
  }

  public int getProcesoId() {
    return procesoId;
  }

  public int getSecuencia() {
    return secuencia;
  }

  public String getUsername() {
    return username;
  }

  public String getMessage() {
    return message;
  }

  public String getDate() {
    return date;
  }

  public boolean isAuthorized() {
    return (secuencia >= 0);
  }
}

/*
 * Informacion de Valoracion framework, Bolsa de Valores de Colombia BVC
 * Copyright (C) 2012 Quasar Software Ltda.
 */
package com.framework.reportEngine;

import com.vaadin.ui.Component;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Alejandro Riveros Cruz
 */
public class QueryContainer extends VerticalLayout {

  private Table table;
  private int numRegistros;

  @Override
  public void addComponent(Component c) {
    super.addComponent(c);
  }

  public Table getTable() {
    return table;
  }

  public int getNumRegistros() {
    return numRegistros;
  }

  public void setNumRegistros(int numRegistros) {
    this.numRegistros = numRegistros;
  }

  public void setTable(Table table) {
    this.table = table;
  }
}
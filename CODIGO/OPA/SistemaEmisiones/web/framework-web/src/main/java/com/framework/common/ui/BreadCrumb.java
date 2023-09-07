/*
 * Información de Valoración framework, Bolsa de Valores de Colombia BVC
 * Copyright (C) 2012 Quasar Software Ltda.
 */

package com.framework.common.ui;

import com.framework.common.domain.OpcionModulo;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

/**
 * Clase que representa la miga de pan (BreadCrumb) que muestra la navegabilidad del usuario en Framework.
 *
 * @author Robert Martínez[rmartinez@quasarbi.com]
 */
public class BreadCrumb extends HorizontalLayout{

  /**
   * Atributos de BreadCrumb.
   */
  Logger logger = LoggerFactory.getLogger(getClass());
  @Resource
  protected MessageSource messageSource;

  /**
   * Constructor del BreadCrumb.
   */
  public BreadCrumb(){
    addComponent(new Button("Inicio"));
  }

  /**
   * Método que actualiza la miga de pan a la ubicación donde se encuentra el usuario actualmente.
   * @param path
   */
  public void refreshPath(List<OpcionModulo> path){
    removeAllComponents();
    addComponent(new Button("Inicio"));
    if (path != null) {
      if (path.size() > 0) {
        for (int i = path.size()-1; i > -1; i--) {
          Button nuevo = new Button(path.get(i).getNombre());
          nuevo.setData(path.get(i));
          Label lbl = new Label(" / ");
          lbl.setStyleName("lblfloat");
          addComponent(lbl);
          addComponent(nuevo);
        }
      }
    }
  }

  /**
   * Método que retorna los componentes (botones) que representan la ubicación donde se encuentra el usuario.
   * @return Componentes (botones) que tiene la miga de pan.
   */
  public LinkedList<Component> getComponents() {
    return components;
  }
}
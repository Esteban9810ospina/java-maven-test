/*
 * Informacion de Valoracion framework, Bolsa de Valores de Colombia BVC
 * Copyright (C) 2012 Quasar Software Ltda.
 */
package com.framework.common.ui.content.util;

import com.framework.reportEngine.config.Constantes;
import com.vaadin.server.*;
import com.vaadin.ui.*;

/**
 * @author Carlos Uribe [curibe@quasarbi.com]
 */
public class ConfirmDialog extends CustomComponent {

  private Window window;
  private Window subwindow;

  public static final String BUTTON_OK_CAPTION = "Aceptar";
  public static final String BUTTON_CANCEL_CAPTION = "Cancelar";

  public Window getSubwindow() {
    return subwindow;
  }

  public ConfirmDialog(final Window window, String title, String message, Button.ClickListener listener) {
    this.window = window;
    subwindow = new Window(title);
    subwindow.setModal(true);
    subwindow.setResizable(false);
    subwindow.setWidth("260px");

    VerticalLayout content = (VerticalLayout) subwindow.getContent();
    content.setMargin(true);
    content.setSpacing(true);

    Label msg = new Label("<center>" + message + "</center>", Label.CONTENT_XHTML);
    subwindow.setContent(msg);

    HorizontalLayout buttons = new HorizontalLayout();
    buttons.setSpacing(true);

    Button okButton = new Button(BUTTON_OK_CAPTION);
    Button cancelButton = new Button(BUTTON_CANCEL_CAPTION);
    okButton.setIcon(Constantes.ICONO_OK);
    cancelButton.setIcon(Constantes.ICONO_CANCELAR);
    okButton.addListener(listener);
    cancelButton.addListener(listener);

    buttons.addComponent(okButton);
    buttons.addComponent(cancelButton);
    content.addComponent(buttons);
    content.setComponentAlignment(msg, Alignment.MIDDLE_CENTER);
    content.setComponentAlignment(buttons, Alignment.MIDDLE_CENTER);
  }

  public void show() {
    window.setContent(subwindow);
  }

  public void hide() {
    window.setContent(subwindow);
  }
}

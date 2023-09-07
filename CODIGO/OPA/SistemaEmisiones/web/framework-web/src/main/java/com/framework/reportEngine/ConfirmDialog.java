/*
 * Informacion de Valoracion framework, Bolsa de Valores de Colombia BVC
 * Copyright (C) 2012 Quasar Software Ltda.
 */
package com.framework.reportEngine;

import com.framework.reportEngine.config.Constantes;
import com.vaadin.ui.*;

/**
 * @author Carlos Uribe [curibe@quasarbi.com]
 */
public class ConfirmDialog extends CustomComponent {

  private Window window;
  private Window subwindow;

  public static final String BUTTON_OK_CAPTION = "Aceptar";
  public static final String BUTTON_CANCEL_CAPTION = "Cancelar";

    public ConfirmDialog(String eliminar, String MSGCONFIRMA_TITULO, String MSGELIMINAR_PREGUNTA, Button.ClickListener clickListener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
    //subwindow.addComponent(msg);
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
    //window.addWindow(subwindow);
    window.setContent(subwindow);
  }

  public void hide() {
     // window.
    //window.removeWindow(subwindow);
  }
}

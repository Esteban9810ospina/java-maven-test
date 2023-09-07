/*
 * Informacion de Valoracion framework, Bolsa de Valores de Colombia BVC
 * Copyright (C) 2012 Quasar Software Ltda.
 */
package com.framework.common.ui;

import com.framework.common.domain.Perfil;
import com.framework.common.service.security.MyUserDetailsService;

import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * Construye los tabs a partir de los roles de usuario.
 *
 * @author Carlos Uribe [curibe@quasarbi.com]
 */
@Configurable(preConstruction = true)
public class TabBuilder extends VerticalLayout {

  @Autowired
  private MyUserDetailsService myUserDetailsService;

  private Window window;
  private Main main;

  public TabBuilder(Window window, Main main) {
    this.window = window;
    this.main = main;
    buildTabs();
  }

  private void buildTabs() {
    Collection<Perfil> perfiles = myUserDetailsService.findPerfilesOpcionesModuloUsuarioAutenticado();

    for (Perfil perfil : perfiles) {
      GenericTab genericTab = new GenericTab(main,perfil);
      addComponent(genericTab);

      /*if (getComponentCount() == 1) {
        myUserDetailsService.logAccess(genericTab.getCaption());
       
      }*/
    }
    //addListener(this);
  }

  /*@Override
  public void selectedTabChange(TabSheet.SelectedTabChangeEvent event) {
    TabSheet tabsheet = event.getTabSheet();
    TabSheet.Tab tab = tabsheet.getTab(tabsheet.getSelectedTab());

    if (tab != null) {
      myUserDetailsService.logAccess(tab.getCaption());

      main.setLastIdOpcionModulo(((GenericTab)tab.getComponent()).getLastIdOpcionModulo());
    }
  }*/
}

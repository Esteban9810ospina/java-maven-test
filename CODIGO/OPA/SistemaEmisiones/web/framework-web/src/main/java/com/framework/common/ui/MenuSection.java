/*
 * Información de Valoración framework, Bolsa de Valores de Colombia BVC
 * Copyright (C) 2012 Quasar Software Ltda.
 */

package com.framework.common.ui;

import com.framework.common.domain.OpcionModulo;
import com.framework.common.domain.Perfil;
import com.vaadin.data.Item;
import com.vaadin.ui.Component;
import com.vaadin.ui.Tree;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.MessageSource;

/**
 * Clase que se encarga de construir el menú de cada perfil.
 *
 * @author Robert Martínez[rmartinez@quasarbi.com]
 */
@Configurable(preConstruction = true)
public final class MenuSection extends Tree {

  /**
   * Atributos de MenuSection.
   */
  Logger logger = LoggerFactory.getLogger(getClass());
  @Resource
  protected MessageSource messageSource;
  public static final Object MENU_PROPERTY_NAME = "name";
  private Perfil perfil;
  private ArrayList<OpcionModulo> padres;
  private List<OpcionModulo> opcionesModuloMenu;

  /**
   * Constructor del menú de un perfil dado como parámetro.
   * @param perfil
   */
  public MenuSection(Perfil perfil) {
    this.perfil = perfil;
    init();
  }

  /**
   * Método que llama al constructor del menú y establece propiedades del contenedor.
   */
  public void init() {
    mainMenu();
    setItemCaptionPropertyId(MENU_PROPERTY_NAME);
    setSelectable(false);
    setNullSelectionAllowed(false);
    /*setItemDescriptionGenerator(new ItemDescriptionGenerator() {
      @Override
      public String generateDescription(Component source, Object itemId, Object propertyId) {
          OpcionModulo toolTip = (OpcionModulo) itemId;
          //Sólo se muestran tooltips para nombres de opciones modulo muy largos, mayores a 25 carácteres
          if (toolTip.getNombre().length()>25) {
            return toolTip.getNombre();
          }
          return null;
      }
    });*/
  }

  /**
   * Método que construye el menú principal.
   */
  public void mainMenu() {
    Item item = null;
    padres = new ArrayList<OpcionModulo>();
    addContainerProperty(MENU_PROPERTY_NAME, String.class, null);
    opcionesModuloMenu = perfil.getOpcionesModulo();
    OpcionModulo cerrar = new OpcionModulo();
    cerrar.setId(9999);
    cerrar.setNombre("Cerrar Sesión");
    cerrar.setOpcionDepende(null);
    opcionesModuloMenu.add(cerrar);
//    logger.info("OPA - " + "MenuSection| Perfil a cargar menu: {}", perfil.getAuthority());
    for (OpcionModulo opcionModulo : opcionesModuloMenu) {
      //Se verifica que no se repita un padre o hijo que ya esté en el menu, con la funcion containsId
      if (opcionModulo.getOpcionDepende() == null && !containsId(opcionModulo)) {
        item = addItem(opcionModulo);
        item.getItemProperty(MENU_PROPERTY_NAME).setValue(opcionModulo.getNombre());
        padres.add(opcionModulo);
        if (!isParent(opcionModulo)) {
//          logger.info("OPA - " + "MenuSection| -- Item padre sin hijos: {}", opcionModulo.getNombre());
          setChildrenAllowed(opcionModulo, false);
        } else {
//          logger.info("OPA - " + "MenuSection| Item raiz: {}", opcionModulo.getNombre());
          addChilds(opcionModulo);
        }
      }
    }
  }

  /**
   * Agrega los hijos que tiene un ítem padre.
   * @param opcionPadre
   */
  public void addChilds(OpcionModulo opcionPadre) {
    for (OpcionModulo opcionHijo : opcionesModuloMenu) {
      if (opcionHijo.getOpcionDepende()!= null && opcionHijo.getOpcionDepende().equals(opcionPadre.getId()) && !containsId(opcionHijo)) {
        Item hijo = addItem(opcionHijo);
        hijo.getItemProperty(MENU_PROPERTY_NAME).setValue(opcionHijo.getNombre());
        setParent(opcionHijo, opcionPadre);
        if (!isParent(opcionHijo)) {
//          logger.info("OPA - " + "MenuSection| ------ Item hijo: {}", opcionHijo.getNombre());
          setChildrenAllowed(opcionHijo, false);
        } else {
//          logger.info("OPA - " + "MenuSection| ---- Item padre : {}, e hijo de: {}" ,opcionHijo.getNombre(), opcionPadre.getNombre());
          addChilds(opcionHijo);
        }
      }
    }
  }

  /**
   * Indica si el ítem es padre.
   * @param opcionPadre
   * @return true si el ítem tiene hijos, false en caso contrario.
   */
  public boolean isParent(OpcionModulo opcionPadre) {
    for (OpcionModulo opciones : opcionesModuloMenu) {
      if (opcionPadre.getId().equals(opciones.getOpcionDepende())) {
        return true;
      }
    }
    return false;
  }

  /**
   * Indica si el ítem es hijo.
   * @param opcionHijo
   * @return true si el ítem es hijo, false en caso contrario.
   */
  public boolean isChild(OpcionModulo opcionHijo) {
    if (opcionHijo.getOpcionDepende() != null) {
      return true;
    }
    return false;
  }

  /**
   * Método que colapsa todos los ítems raices del menú.
   */
  public void collapseItems(){
    for (OpcionModulo opcionModulo : opcionesModuloMenu) {
      if (opcionModulo.getOpcionDepende() == null) {
        collapseItemsRecursively(opcionModulo);
      }
    }
  }

  /**
   * Método que expande los ítems del árbol dado el id de un ítem final (sin hijos).
   * @param idOpcionModulo
   * @return Lista de ítems desde el padre principal hasta el ítem final dado como parámetro.
   */
  public List<OpcionModulo> expandItems(Integer idOpcionModulo) {
    OpcionModulo opcionHijo = obtainOpcionModulo(idOpcionModulo);
    List<OpcionModulo> padresItem = obtainParents(opcionHijo);
    collapseItems();
    for (int i = padresItem.size() - 1; i > -1; i--) {
      expandItem(padresItem.get(i));
    }
    return padresItem;
  }

  /**
   * Obtiene los ítems padres (desde el raíz) de un ítem hijo.
   * @param hijo
   * @return Lista de todos los padres del ítem, ordenados desde el ítem hijo hasta el ítem raíz.
   */
  public List<OpcionModulo> obtainParents(OpcionModulo hijo) {
    ArrayList<OpcionModulo> padresDesdeHijos = new ArrayList<OpcionModulo>();
    padresDesdeHijos.add(hijo);
    while (isChild(hijo)) {
      hijo = obtainOpcionModulo(hijo.getOpcionDepende());
      padresDesdeHijos.add(hijo);
    }
    return padresDesdeHijos;
  }

  /**
   * Obtiene un ítem del menú dado su id.
   * @param id
   * @return Ítem del menú (un opcionModulo).
   */
  public OpcionModulo obtainOpcionModulo(Integer id) {
    for (OpcionModulo opcionModulo : opcionesModuloMenu) {
      if (opcionModulo.getId().equals(id)) {
        return opcionModulo;
      }
    }
    return null;
  }
}
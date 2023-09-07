/*
 * Información de Valoración framework, Bolsa de Valores de Colombia BVC
 * Copyright (C) 2012 Quasar Software Ltda.
 */
package com.framework.common.ui;

import com.framework.common.domain.OpcionModulo;
import com.framework.common.domain.Perfil;
import com.framework.common.service.Auditoria;
import com.framework.common.service.security.MyUserDetailsService;
import com.framework.common.ui.GenericContent;
import com.framework.common.ui.util.VaadinComponentFactory;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
//import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Tab generico contenedor de elementos de UI y controladores de eventos.
 *
 * @author Carlos Uribe [curibe@quasarbi.com]
 * @author Robert Martínez[rmartinez@quasarbi.com]
 * @author Alejandro Riveros [lriveros@quasarbi.com]
 */
@Configurable
public class GenericTab extends VerticalLayout  {

    private static final long serialVersionUID = -593479948706915L;

    //private final Logger logger = LoggerFactory.getLogger(getClass());
    private static final Logger logger = Logger.getLogger(GenericTab.class.getName());

    private Perfil perfil;

    private CustomLayout customLayout;
    private VerticalLayout bodyContent;

    private BreadCrumb breadCrumb;
    private MenuSection menuSection;

    private int lastIdOpcionModulo = 0;

    @Autowired
    protected VaadinComponentFactory vaadinComponentFactory;

    @Autowired
    private MyUserDetailsService myUserDetailsService;
    private Main main;

    public GenericTab(Main main, Perfil perfil) {
        this.perfil = perfil;
        //setCaption(perfil.getAuthority());
        addComponents();
        addListeners();
        this.main = main;

    }

    private void addComponents() {
        customLayout = new CustomLayout("tabsheet");
        menuSection = new MenuSection(perfil);
        bodyContent = new VerticalLayout();
        breadCrumb = new BreadCrumb();

        refreshListenersButtonsBreadCrumb();

        customLayout.addComponent(breadCrumb, "breadcrumb");
        customLayout.addComponent(menuSection, "menusection");
        customLayout.addComponent(bodyContent, "contentpage");
        addComponent(customLayout);
        //  setBodyContent(new BienvenidaContent(this));
    }

    private void addListeners() {

        menuSection.addListener(new ItemClickEvent.ItemClickListener() {

            @Override
            public void itemClick(ItemClickEvent event) {
                clickMenuSection(event);
            }
        });
    }

    private void clickMenuSection(ItemClickEvent event) {
        App.setDefaultLocale();
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");    
        if (event.getButton() == ItemClickEvent.BUTTON_LEFT) {
            OpcionModulo opcion = (OpcionModulo) event.getItemId();
            logger.debug("{}" +  opcion);
            // Código compartido con refreshListenersButtonsBreadCrumb
            if (opcion.getId() == 9999) {
                
                ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                HttpServletRequest req = attr.getRequest();
                HttpSession session = req.getSession();
                Auditoria au = new Auditoria();
                au.setid();
                au.setEvento("Fin de sesión usuario");
                au.setResultado("Exitoso");
                au.inserta();
                Page.getCurrent().setLocation("/opa/start/login?error=closeSession");
                //session.invalidate();
            
                session.setAttribute("entro",0);
                VaadinSession.getCurrent().close();
              
                return;
            }
            sharedCode(opcion);

            if (menuSection.isExpanded(opcion)) {
                List<OpcionModulo> path = menuSection.expandItems(opcion.getId());
                breadCrumb.refreshPath(path);
                menuSection.collapseItem(opcion);
                refreshListenersButtonsBreadCrumb();
            } else {
                menuSection.expandItem(opcion);
                List<OpcionModulo> path = menuSection.expandItems(opcion.getId());
                breadCrumb.refreshPath(path);
                refreshListenersButtonsBreadCrumb();
            }
            menuSection.select(opcion);
            //Se hace la auditoría del click en el menú
            myUserDetailsService.logAccess(opcion);

            main.setLastIdOpcionModulo(opcion.getId());
            this.lastIdOpcionModulo = opcion.getId();
        }
    }

    private void refreshListenersButtonsBreadCrumb() {
        LinkedList<Component> botonesBreadCrumb = breadCrumb.getComponents();
        for (Component component : botonesBreadCrumb) {
            if (component.getClass().getName().equals("com.vaadin.ui.Button")) {
                final Button nuevo = (Button) component;
                nuevo.setStyleName("v-buttonbread");
                nuevo.addListener(new Button.ClickListener() {
                    private List<OpcionModulo> path;
                    @Override
                    public void buttonClick(ClickEvent event) {
                        if (nuevo.getCaption().equals("Inicio")) {
                            menuSection.collapseItems();
                            GenericTab.this.setBodyContent(new BienvenidaContent(GenericTab.this));
                        } else {
                            OpcionModulo opcion = (OpcionModulo) nuevo.getData();
                            //Código compartido con clickMenuSection
                            sharedCode(opcion);
                            path = menuSection.expandItems(opcion.getId());
                            menuSection.select(opcion);
                            //Se hace la auditoría del click en el menú
                            myUserDetailsService.logAccess(opcion);
                        }
                        breadCrumb.refreshPath(path);
                        refreshListenersButtonsBreadCrumb();
                    }
                });
            }
        }
    }

    /**
    * Método que ejecuta un bloque de código compartido en clickMenuSection y
    * refreshListenersButtonsBreadCrumb
    *
    * @param opcion
    */
    public void sharedCode(OpcionModulo opcion) {
        /**
         * Se añadieron excepciones para los casos donde nodos padre tienen
         * contenido Opcion: Volatilidades y deltas, ID: 2069 Opcion: Generación
         * de Archivos - Derivados, ID: 2075 Opcion: Generación de Archivos -
         * Derivex, ID: 4000
         */
        if (!menuSection.isParent(opcion) || opcion.getId() == 2069 || opcion.getId() == 2075 || opcion.getId() == 4000) {
            GenericContent genericContent = vaadinComponentFactory.getVaadinComponent(opcion, this);
            setBodyContent(genericContent);
        } else {
            //  setBodyContent(new BienvenidaContent(this));
        }
    }

    public void setBodyContent(ComponentContainer componentContainer) {
        bodyContent.removeAllComponents();
        bodyContent.addComponent(componentContainer);
    }

    public void setVaadinComponentFactory(VaadinComponentFactory vaadinComponentFactory) {
        this.vaadinComponentFactory = vaadinComponentFactory;
    }

    public MenuSection getMenuSection() {
        return menuSection;
    }

    public void goHome() {
//    setBodyContent(new BienvenidaContent(this));
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public int getLastIdOpcionModulo() {
        return lastIdOpcionModulo;
    }
}

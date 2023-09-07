/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.ui.contents;

import com.framework.common.ui.GenericContent;
import com.framework.common.ui.GenericTab;
import com.quasar.frameq.db.Facade;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.FileDownloader;
import com.vaadin.server.FileResource;
import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import java.io.File;
import java.text.SimpleDateFormat;
import com.framework.common.ui.contents.PagedTableCustomscb;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.io.comparator.LastModifiedFileComparator;

/**
 *
 * @author jam
 */
public class DescargarAdjudicacion extends GenericContent {

    IndexedContainer ic;
    PagedTableCustomscb tabla;
    IndexedContainer ic2;
    PagedTableCustomscb tabla2;
    IndexedContainer ic3;
    PagedTableCustomscb tabla3;
    Facade fachada = new Facade();
    String rutaCargueidr = fachada.rutaIDRD();
    String rutaCargueAdj = fachada.rutaAdjudicacion();
    String rutaCargueI20 = fachada.rutaI20();//cambio
    
    //Para OPI
    HorizontalLayout horizoOPI;
    Label lbltitulo3; 
    List<String> parametros = null;
    Facade facade = new Facade();

    public DescargarAdjudicacion(GenericTab parentTab) {
        super(parentTab);
    }

    @Override
    public void initForm() {
        
        int hayParametrizacion = facade.validaHayParametros();
        if (hayParametrizacion == 1) {
            parametros = facade.RetornaParametros();
        }

        final Panel panelTabla1 = new Panel();
        final Panel panelTabla2 = new Panel();
        final Panel panelTabla3 = new Panel();

        final Panel panelPaginacion1 = new Panel();

        final Panel panelPaginacion2 = new Panel();
        final Panel panelPaginacion3 = new Panel();

        GridLayout grid = new GridLayout(2, 9);
        grid.setSpacing(true);
        grid.setSizeFull();
        grid.setWidth(100, Sizeable.Unit.PERCENTAGE);
        grid.setHeight(100, Sizeable.Unit.PERCENTAGE);

        HorizontalLayout horizo = new HorizontalLayout();
        grid.setSizeFull();
        horizo.setWidth(100, Sizeable.Unit.PERCENTAGE);
        horizo.setHeight(100, Sizeable.Unit.PERCENTAGE);

        VerticalLayout vlPadre = new VerticalLayout();

        /*DESCARGAR REPORTES DE ADJUDICACIÓN*/
        //horizo.setWidth("100%");
        Label lbltitulo = new Label("DESCARGAR REPORTES DE ADJUDICACIÓN");
        lbltitulo.setWidthUndefined();
        lbltitulo.setStyleName("tituloInversionistatit");
        lbltitulo.setHeight("35px");
        horizo.addStyleName("tituloAdjudicacion");
        horizo.addComponents(lbltitulo);
        horizo.setComponentAlignment(lbltitulo, Alignment.MIDDLE_RIGHT);
        grid.addComponent(horizo, 0, 0, 1, 0);

        /*TABLA DE REPORTES DE ADJUDICACIÓN*/
        ic = new IndexedContainer();
        ic.addContainerProperty("Fecha de creación", String.class, null);
        ic.addContainerProperty("Hora de creación", String.class, null);
        ic.addContainerProperty("Nombre del archivo", Button.class, null);
        ic.addContainerProperty("Tamaño del archivo", String.class, null);

        tabla = new PagedTableCustomscb("");
        traerArchivosAdjudicacion();

        tabla.setContainerDataSource(ic);
        //tabla.setHeight("250px");

        panelTabla1.setContent(tabla);
        grid.addComponent(panelTabla1, 0, 1, 1, 1);
        //panelTabla1.setHeight("250px");

        /*Paginacion*/
        panelPaginacion1.setContent(tabla.createControls());
        grid.addComponent(panelPaginacion1, 0, 2, 1, 2);

        /*DESCARGAR INTERFACE DE BACKOFIICE*/
        horizo = new HorizontalLayout();
        //horizo.setWidth("100%");
        Label lbltitulo2 = new Label("DESCARGAR INTERFACES DE BACKOFFICE");
        lbltitulo2.setWidthUndefined();
        lbltitulo2.setStyleName("tituloInversionistatit");
        lbltitulo2.setHeight("35px");
        horizo.addStyleName("tituloAdjudicacion");
        horizo.addComponents(lbltitulo2);
        horizo.setComponentAlignment(lbltitulo2, Alignment.MIDDLE_RIGHT);
        grid.addComponent(horizo, 0, 3, 1, 3);

        /*TABLA DE BACKOFIICE*/
        ic2 = new IndexedContainer();
        ic2.addContainerProperty("Fecha de creación", String.class, null);
        ic2.addContainerProperty("Hora de creación", String.class, null);
        ic2.addContainerProperty("Nombre del archivo", Button.class, null);
        ic2.addContainerProperty("Tamaño del archivo", String.class, null);

        tabla2 = new PagedTableCustomscb("");
        traerArchivosIDR();

        tabla2.setContainerDataSource(ic2);
        tabla2.setSizeFull();
        //tabla2.setHeight("250px");
        tabla2.setImmediate(true);
        tabla2.setSelectable(false);
        tabla2.setColumnReorderingAllowed(false);
        panelTabla2.setContent(tabla2);
        grid.addComponent(panelTabla2, 0, 4, 1, 4);

        /*Paginacion*/
        panelPaginacion2.setContent(tabla2.createControls());
        grid.addComponent(panelPaginacion2, 0, 5, 1, 5);

        //Aplica solo para OPI start
        if(parametros.get(41).equals("OPI")){
        
        /*DESCARGAR I20*/
        horizoOPI = new HorizontalLayout();
        //horizo.setWidth("100%");
        lbltitulo3 = new Label("DESCARGAR INTERFAZ 20");
        lbltitulo3.setWidthUndefined();
        lbltitulo3.setStyleName("tituloInversionistatit");
        lbltitulo3.setHeight("35px");
        horizoOPI.addStyleName("tituloAdjudicacion");
        horizoOPI.addComponents(lbltitulo3);
        horizoOPI.setComponentAlignment(lbltitulo3, Alignment.MIDDLE_RIGHT);
        grid.addComponent(horizoOPI, 0, 6, 1, 6);

        /*TABLA DE I20*/
        ic3 = new IndexedContainer();
        ic3.addContainerProperty("Fecha de creación", String.class, null);
        ic3.addContainerProperty("Hora de creación", String.class, null);
        ic3.addContainerProperty("Nombre del archivo", Button.class, null);
        ic3.addContainerProperty("Tamaño del archivo", String.class, null);

        tabla3 = new PagedTableCustomscb("");
        traerArchivosInterfaz20();

        tabla3.setContainerDataSource(ic3);
        //tabla.setHeight("250px");

        panelTabla3.setContent(tabla3);
        grid.addComponent(panelTabla3, 0, 7, 1, 7);
        //panelTabla1.setHeight("250px");

        /*Paginacion*/
        panelPaginacion3.setContent(tabla3.createControls());
        grid.addComponent(panelPaginacion3, 0, 8, 1, 8);

        // Aplica solo para OPI ends
        }
        
        /*COMPONENTES DE LOS OBJETOS*/
        vlPadre.addComponent(grid);
        setContent(vlPadre);

    }

    public void traerArchivosIDR() {
        File[] archivos = null;
        SimpleDateFormat hora = null;
        SimpleDateFormat fecha = null;
        try {
            tabla2.getContainerDataSource().removeAllItems();
            File pathArchivos = new File(rutaCargueidr);
            archivos = pathArchivos.listFiles();
            hora = new SimpleDateFormat("HH:mm:ss");
            fecha = new SimpleDateFormat("yyyy-MM-dd");
            Arrays.sort(archivos, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
        } catch (Exception ex) {
            //Notification.show("    La ruta IDR no esta parametrizada    ", Notification.Type.HUMANIZED_MESSAGE);
            logger.error("error: " + ex);
            Notification.show("Las rutas de los archivos IDR y/o Adjudicación no están correctamente parametrizadas.", Notification.Type.HUMANIZED_MESSAGE);
        }
        if (archivos != null) {
            for (int i = 0; i < archivos.length; i++) {
                File archivo = archivos[i];
                Item item = ic2.addItem(i);
                item.getItemProperty("Fecha de creación").setValue(fecha.format(archivo.lastModified()));
                item.getItemProperty("Hora de creación").setValue(hora.format(archivo.lastModified()));
                Button detailsField = new Button(archivo.getName());
                detailsField.setData(i);
                item.getItemProperty("Nombre del archivo").setValue(detailsField);
                item.getItemProperty("Tamaño del archivo").setValue(String.valueOf(archivo.length() / 1024) + " KB");

                detailsField.addClickListener(new Button.ClickListener() {
                    public void buttonClick(ClickEvent event) {

                    }
                });
                detailsField.addStyleName("linkDescarga");

                try {
                    Resource res = new FileResource(new File(rutaCargueidr, "//" + archivo.getName()));
                    FileDownloader ejemplo = new FileDownloader(res);
                    ejemplo.extend(detailsField);
                } catch (Exception ex) {
                    Notification.show("No se encuentra el archivo de Ejemplo", Notification.Type.ERROR_MESSAGE);
                }

            }
        }
    }

    public void traerArchivosAdjudicacion() {
        tabla.getContainerDataSource().removeAllItems();
        File pathArchivos = null;
        File[] archivos = null;
        SimpleDateFormat hora = null;
        SimpleDateFormat fecha = null;
        try {
            pathArchivos = new File(rutaCargueAdj);
            archivos = pathArchivos.listFiles();
            hora = new SimpleDateFormat("HH:mm:ss");
            fecha = new SimpleDateFormat("yyyy-MM-dd");
            Arrays.sort(archivos, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
        } catch (Exception ex) {
            logger.error("error: " + ex);
            Notification.show("Las rutas de los archivos IDR y/o Adjudicación no están correctamente parametrizadas.", Notification.Type.HUMANIZED_MESSAGE);
        }
        if (archivos != null) {
            for (int i = 0; i < archivos.length; i++) {
                File archivo = archivos[i];
                Item item = ic.addItem(i);
                item.getItemProperty("Fecha de creación").setValue(fecha.format(archivo.lastModified()));
                item.getItemProperty("Hora de creación").setValue(hora.format(archivo.lastModified()));
                Button detailsField = new Button(archivo.getName());
                detailsField.setData(i);
                item.getItemProperty("Nombre del archivo").setValue(detailsField);
                item.getItemProperty("Tamaño del archivo").setValue(String.valueOf(archivo.length() / 1024) + " KB");

                detailsField.addClickListener(new Button.ClickListener() {
                    public void buttonClick(ClickEvent event) {

                    }
                });
                detailsField.addStyleName("linkDescarga");

                try {
                    Resource res = new FileResource(new File(rutaCargueAdj, "//" + archivo.getName()));
                    FileDownloader ejemplo = new FileDownloader(res);
                    ejemplo.extend(detailsField);
                } catch (Exception ex) {
                    Notification.show("No se encuentra el archivo de Ejemplo", Notification.Type.ERROR_MESSAGE);
                }

            }
        }
    }

//Aplica solo para OPI
    public void traerArchivosInterfaz20() {
        tabla3.getContainerDataSource().removeAllItems();
        File pathArchivos = null;
        File[] archivos = null;
        SimpleDateFormat hora = null;
        SimpleDateFormat fecha = null;
        try {
            pathArchivos = new File(rutaCargueI20);
            archivos = pathArchivos.listFiles();
            hora = new SimpleDateFormat("HH:mm:ss");
            fecha = new SimpleDateFormat("yyyy-MM-dd");
            Arrays.sort(archivos, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
        } catch (Exception ex) {
            logger.error("error: " + ex);
            Notification.show("Las rutas de los archivos I20 no están correctamente parametrizadas.", Notification.Type.HUMANIZED_MESSAGE);
        }
        if (archivos != null) {
            for (int i = 0; i < archivos.length; i++) {
                File archivo = archivos[i];
                Item item = ic3.addItem(i);
                item.getItemProperty("Fecha de creación").setValue(fecha.format(archivo.lastModified()));
                item.getItemProperty("Hora de creación").setValue(hora.format(archivo.lastModified()));
                Button detailsField = new Button(archivo.getName());
                detailsField.setData(i);
                item.getItemProperty("Nombre del archivo").setValue(detailsField);
                item.getItemProperty("Tamaño del archivo").setValue(String.valueOf(archivo.length() / 1024) + " KB");

                detailsField.addClickListener(new Button.ClickListener() {
                    public void buttonClick(ClickEvent event) {

                    }
                });
                detailsField.addStyleName("linkDescarga");

                try {
                    Resource res = new FileResource(new File(rutaCargueI20, "//" + archivo.getName()));
                    FileDownloader ejemplo = new FileDownloader(res);
                    ejemplo.extend(detailsField);
                } catch (Exception ex) {
                    Notification.show("No se encuentra el archivo de Ejemplo", Notification.Type.ERROR_MESSAGE);
                }

            }
        }
    }
    // aplica solo para OPI
    
    public void ocultarCamposOPI(){
        horizoOPI.setVisible(Boolean.TRUE);
        lbltitulo3.setVisible(Boolean.TRUE);
        tabla3.setVisible(Boolean.TRUE);
    }
    
}

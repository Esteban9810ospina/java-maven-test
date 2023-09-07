/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.ui;

import com.vaadin.server.Sizeable;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author David_Puerta
 */
public class CamposCrearAceptacion {
    
    private final Embedded image = new Embedded(null, new ThemeResource("img/Inver.png"));
    
    private VerticalLayout verticalLayout;
    private HorizontalLayout hLayout;
    private HorizontalLayout hLayoutOPI;
    private GridLayout gridLayout;
    
    private Label lbTituloCabecera;
    private Label lbTituloVendedor;
    
    private TextArea texto1;
    
    
    
    
    public void init(int columnas, int filas){
        this.verticalLayout = new VerticalLayout();
        this.hLayout = new HorizontalLayout();
        this.hLayoutOPI = new HorizontalLayout();
        this.gridLayout = new GridLayout(columnas, filas);
        this.texto1 = new TextArea();
        this.lbTituloCabecera = new Label("TÉRMINOS DE LA ACEPTACIÓN");
        this.lbTituloVendedor = new Label("DATOS DEL VENDEDOR");
    }
    
    public void crearCabecera(){
        gridLayout.setSizeFull();
        gridLayout.setWidth(100, Sizeable.Unit.PERCENTAGE);
        gridLayout.setHeight(100, Sizeable.Unit.PERCENTAGE);

        //Cabecera
        texto1.setWidth("100%");
        gridLayout.addComponent(texto1, 0, 0, 6, 0);
        texto1.setEnabled(false);

        gridLayout.setSizeFull();
        hLayout.setWidth(100, Sizeable.Unit.PERCENTAGE);
        hLayout.setHeight(100, Sizeable.Unit.PERCENTAGE);

        hLayout.setWidth("100%");
        lbTituloCabecera.setWidthUndefined();
        lbTituloCabecera.setStyleName("tituloInversionistatit");
        
        image.setHeight("35px");
        image.setStyleName("InverImg");
        hLayout.addStyleName("tituloInversionista");
        hLayout.addComponents(image, lbTituloCabecera);
        hLayout.setComponentAlignment(lbTituloCabecera, Alignment.MIDDLE_CENTER);
        gridLayout.addComponent(hLayout, 0, 1, 6, 1);
    }
    
    public void generarDatosVendedorOPI(){
        hLayoutOPI = new HorizontalLayout();
        hLayoutOPI.setWidth("100%");

        lbTituloVendedor.setStyleName("tituloInversionistatit");
        
        image.setStyleName("InverImg");
        image.setHeight("35px");
        hLayoutOPI.addStyleName("tituloInversionista");
        hLayoutOPI.addComponent(image);
        hLayoutOPI.addComponent(lbTituloVendedor);
        hLayoutOPI.setComponentAlignment(lbTituloVendedor, Alignment.MIDDLE_CENTER);
        gridLayout.addComponent(hLayoutOPI, 0, 18, 6, 18);
    }

    public void generarLabel(String textoLabel, int enColumna, int enFila, int width){
        Label label = new Label(textoLabel);
        gridLayout.setSpacing(true);
        gridLayout.addComponent(label, enColumna, enFila);
        gridLayout.setComponentAlignment(label, Alignment.MIDDLE_LEFT);
        label.setWidth(width, Sizeable.Unit.EM);
    }
    
    public void mostrarDatoCampo(String dato, int enColumna, int enFila, int width){
        Label label = new Label(dato);
        label.setReadOnly(true);
        getGridLayout().addComponent(label, enColumna, enFila);
        getGridLayout().setComponentAlignment(label, Alignment.MIDDLE_LEFT);
        label.setWidth(width, Sizeable.Unit.EM);
    }
    
    public void generarCampoCompleto(String titulo, String dato, 
        int cTiulo, int fTitulo, int cDato, int fDato, int wTitulo, int wDato, boolean obligatorio){
        generarLabel(titulo, cTiulo, fTitulo,wTitulo);
        if(obligatorio)
            generarNuevoAsterisco();
        getGridLayout().setSpacing(true);
        mostrarDatoCampo(dato,cDato,fDato,wDato);
    }
    
    public Label generarNuevoAsterisco(){
        Label lbAsterisco = new Label("*");
        lbAsterisco.setStyleName("asterix");
        return lbAsterisco;
    }
    
    
    /*GETTERS y SETTERS*/

    public GridLayout getGridLayout() {
        return gridLayout;
    }

    public void setGridLayout(GridLayout gridLayout) {
        this.gridLayout = gridLayout;
    }

    public VerticalLayout getVerticalLayout() {
        return verticalLayout;
    }

    public void setVerticalLayout(VerticalLayout verticalLayoutPadre) {
        this.verticalLayout = verticalLayoutPadre;
    }

    public Label getLbTituloCabecera() {
        return lbTituloCabecera;
    }

    public TextArea getTexto1() {
        return texto1;
    }

    public HorizontalLayout gethLayout() {
        return hLayout;
    }

    public HorizontalLayout gethLayoutOPI() {
        return hLayoutOPI;
    }
    
}

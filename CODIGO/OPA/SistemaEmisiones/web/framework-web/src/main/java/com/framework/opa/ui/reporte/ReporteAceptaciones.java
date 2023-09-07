/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.opa.ui.reporte;


import com.framework.common.ui.GenericTab;
import com.framework.common.ui.GenericContent;
import com.framework.reportEngine.QueryContainer;
import com.framework.opa.reporte.service.ReporteServiceGeneral;

import com.vaadin.data.Property;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.Sizeable;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import java.sql.SQLException;



import java.util.logging.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author jam
 */
@Configurable(preConstruction = true)
public class ReporteAceptaciones extends GenericContent {
    @Autowired
    private static final Logger logger = Logger.getLogger(ReporteAceptaciones.class.getName());
    protected ReporteServiceGeneral reporteService;
    private QueryContainer qC;
    private final VerticalLayout verticallayouttabla = new VerticalLayout();
    private final Panel panel = new Panel("Calculo de Precios");
    private final GridLayout gridPanel = new GridLayout(3, 4);
    private final GridLayout gridButton = new GridLayout(2, 1);
    private final VerticalLayout verticalLayout = new VerticalLayout();
    private final VerticalLayout verticalLayoutButton = new VerticalLayout();
    private String titulo = "";
    private ComboBox cbxVuelta = new ComboBox();
    private ComboBox cbxMartillo = new ComboBox();
    private ComboBox cbxLote = new ComboBox();
    private ComboBox comOfertante;
    private TextField texVuelta;
    private Button btnCalcular = new Button();
    private Button btnLimpiar = new Button();
    private IndexedContainer itemsmartillo;
    private IndexedContainer itemsNumeroVueltas;
    private IndexedContainer itemslote;
    private Label labMartillo;
    private Label labVuelta;
    private String strMartilloData = new String();
    private String strMartilloView = new String();
    private String strVueltaData;
    private String strVueltaView;
    private String strMartillo = "";
    private int strVuelta = 0;
    private String strIdLote = "";
    private String strPostorData = new String();
    private String strPostorView = new String();
    private String strIdMartillo = "";
    private final VerticalLayout verticalLayoutTable = new VerticalLayout();

    public ReporteAceptaciones(GenericTab parentTab) {
        super(parentTab);
    }

    @Override
    public void initForm() {

        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        panel.setWidth("500px");
        panel.setHeight("200px");

        gridPanel.setWidth(400, Sizeable.Unit.PIXELS);
        gridPanel.setHeight(100, Sizeable.Unit.PIXELS);

        gridButton.setWidth(250, Sizeable.Unit.PIXELS);
        gridButton.setHeight(80, Sizeable.Unit.PIXELS);
        gridButton.setMargin(true);


        try {
            inicializaBasicos();
        } catch (SQLException ex) {
            logger.error("OPA - " + ReporteAceptaciones.class.getName(), ex);	
        }


        verticalLayout.addComponent(gridPanel);
        verticalLayout.setComponentAlignment(gridPanel, Alignment.TOP_LEFT);

        verticalLayoutButton.addComponent(gridButton);
        verticalLayoutButton.setComponentAlignment(gridButton, Alignment.TOP_LEFT);

        panel.setContent(verticalLayout);
        addComponent(panel);
        addComponent(verticalLayoutButton);

    }

    private void inicializaBasicos() throws SQLException {

        labMartillo = new Label("Martillo");
        gridPanel.addComponent(labMartillo, 1, 0);
        cbxMartillo = new ComboBox();
        cbxMartillo.setRequired(true);
        cbxMartillo.setImmediate(true);
        cbxMartillo.setRequiredError("Seleccione un Martillo.");
        gridPanel.addComponent(cbxMartillo, 2, 0);
        cbxMartillo.addListener(new Property.ValueChangeListener() {
            //private static final long serialVersionUID = -7887302901429982273L;
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                gridPanel.removeComponent(2, 1);
                gridPanel.addComponent(texVuelta, 2, 1);
                gridPanel.setComponentAlignment(texVuelta, Alignment.MIDDLE_LEFT);

            }
        });
//Vuelta

        labVuelta = new Label("Vuelta");
        gridPanel.addComponent(labVuelta, 1, 1);
        texVuelta = new TextField();
        texVuelta.setRequired(true);
        texVuelta.setRequiredError("Seleccione un lote.");
        texVuelta.setEnabled(false);
        gridPanel.addComponent(texVuelta, 2, 1);
        texVuelta.addListener(new Property.ValueChangeListener() {
            private static final long serialVersionUID = -382717228031608542L;

            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                strIdLote = (String) event.getProperty().getValue();
            }
        });



        //**********************************************
        //BOTON CALCULAR 
        //**********************************************
        Button btnCalcular;
        btnCalcular = new Button("Calcular", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                verticalLayoutTable.removeAllComponents();
                if (cbxMartillo.isValid() && texVuelta.isValid()) {
                    strMartillo = cbxMartillo.getValue().toString();
                } else {
                    strMartillo = "";
                }
                if (!strMartillo.equalsIgnoreCase("")) {

                    if (qC.getNumRegistros() > 0) {
                        verticalLayoutTable.addComponent(qC);
                        addComponent(verticalLayoutTable);
                    } else {
                        qC.addComponent(new Label("No existen registros para " + titulo, Label.CONTENT_XHTML));
                    }

                } else {
                    qC.addComponent(new Label("No existen registros para " + titulo, Label.CONTENT_XHTML));
                }
            }
        });
        gridButton.addComponent(btnCalcular, 0, 0);
        gridButton.setComponentAlignment(btnCalcular, Alignment.MIDDLE_CENTER);


        //**********************************************
        //BOTON LIMPIAR
        //**********************************************
        Button btnLimpiar = new Button("Limpiar", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                limpiar();
            }
        });
        gridButton.addComponent(btnLimpiar, 1, 0);
        gridButton.setComponentAlignment(btnLimpiar, Alignment.MIDDLE_CENTER);

    }

    public void limpiar() {
        cbxMartillo.setValue("");
        cbxLote.setValue("");
        texVuelta.setValue("");
        texVuelta.setEnabled(true);

    }
    
    
}

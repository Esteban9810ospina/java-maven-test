/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.ui.contents;

import com.framework.common.ui.GenericContent;
import com.framework.common.ui.GenericTab;
import com.framework.common.ui.util.ValidarCampos;
import com.quasar.frameq.data.OrigenMILA;
import com.quasar.frameq.data.TipoDocumento;
import com.quasar.frameq.db.Facade;
import com.quasar.frameq.fachadas.FacadeOrigenMILA;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.FieldEvents;
import com.vaadin.server.Sizeable;
import com.vaadin.server.UserError;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.vaadin.dialogs.ConfirmDialog;

/**
 *
 * @author Catherine_Ovalle
 */
public class MantenedorMila extends GenericContent {

    VerticalLayout vertical = new VerticalLayout();
    VerticalLayout verticalFiltros = new VerticalLayout();
    GridLayout gridFiltros = new GridLayout(6, 3);

    List<OrigenMILA> listMila = new ArrayList<OrigenMILA>();
    PagedTableCustomMila tabla;
    IndexedContainer ic;

    String regexLetras = "^[a-zA-Z\\s]*$";
    String regexNumeric = "^[0-9]*$";
    String regexLetrasTildes = "^[a-zA-Z\\s \\.]*$";

    FacadeOrigenMILA mila = new FacadeOrigenMILA();
    Facade facade = new Facade();
    ValidarCampos validacion = new ValidarCampos();

    private Button btnuevo = new Button();
    private Button btmodificar = new Button();
    private Button btnFiltrar = new Button();
    private Button btnLimpiar = new Button();
    private Button btexportar = new Button();
    Button btnGuardar;

    Window subWindow;

    TextField txtCodigoPais;
    TextField txtPais;
    TextField txtnumeroDoc;
    TextField txtDigitoverificacion;
    TextField txtCuenta;

    TextField txtCodigoPaisFiltros;
    TextField txtPaisFiltros;

    ComboBox cbxEstado;
    ComboBox cbxtipDocumento;
    ComboBox cbxEstadoFiltro;

    int select = 0;
    int valorCombo = 0;
    int combo = 0;
    int comboaEstado = 0;

    String idOrigenMila = "";
    String codigoPais = "";
    String pais = "";
    String tipDocumento = "";
    String numDocumento = "";
    String digVerificacion = "";
    String cuenta = "";
    String estado = "";

    boolean existeCodigoPais = false;

    Label error = new Label("");
    Label lberror2;
    Label lberror3;
    Label lberror4;
    Label lberror6;
    Label lberror7;
    Label lberror8;
    Label lberror12;
    private final int tipoDocumentoMila = 4;

    public MantenedorMila(GenericTab parentTab) {
        super(parentTab);
    }

    @Override
    public void initForm() {

        Panel panelFiltros = new Panel("");
        Panel panelTabla = new Panel("");
        Panel panelPaginacion = new Panel("");

        panelTabla.setSizeFull();
        panelTabla.setWidth(100, Sizeable.Unit.PERCENTAGE);

        HorizontalLayout horizontal = new HorizontalLayout();
        HorizontalLayout HL = new HorizontalLayout();
        HorizontalLayout hrz = new HorizontalLayout();
        HL.setSpacing(true);
        hrz.setSpacing(true);

        GridLayout grid = new GridLayout(3, 1);
        grid.setSpacing(true);
        gridFiltros.setSpacing(true);

        /*Tabla Mantenedor Mila*/
        ic = new IndexedContainer();
        ic.addContainerProperty("Código Pais", String.class, null);
        ic.addContainerProperty("Pais", String.class, null);
        ic.addContainerProperty("Tipo Documento", String.class, null);
        ic.addContainerProperty("Número de Documento", String.class, null);
        ic.addContainerProperty("Dígito de Verificación", String.class, null);
        ic.addContainerProperty("Cuenta", String.class, null);
        ic.addContainerProperty("Estado", String.class, null);

        VerticalLayout vl = new VerticalLayout();
        btnuevo = new Button("Nuevo");
        btmodificar = new Button("Modificar");

        HL.addComponents(btnuevo, btmodificar);

        /**
         * ***************************************************
         */
        /**
         * ************FILTROS********************************
         */
        /**
         * **************************************************
         */
        /**
         * *****Código Pais*******************************
         */
        Label lbCodigoPaisFiltros = new Label("Código Pais");
        gridFiltros.addComponent(lbCodigoPaisFiltros, 0, 0);

        txtCodigoPaisFiltros = new TextField();
        gridFiltros.addComponent(txtCodigoPaisFiltros, 1, 0);
        txtCodigoPaisFiltros.setWidth(15, Sizeable.Unit.EM);
        txtCodigoPaisFiltros.setHeight(2, Sizeable.Unit.EM);

        /**
         * **********************Pais*******
         */
        Label lbPaisFiltros = new Label("Pais");
        gridFiltros.addComponent(lbPaisFiltros, 2, 0);

        txtPaisFiltros = new TextField();
        gridFiltros.addComponent(txtPaisFiltros, 3, 0);
        txtPaisFiltros.setWidth(15, Sizeable.Unit.EM);
        txtPaisFiltros.setHeight(2, Sizeable.Unit.EM);

        /**
         * **********************Estado*******
         */
        Label lbEstado = new Label("Estado");
        gridFiltros.addComponent(lbEstado, 4, 0);

        cbxEstadoFiltro = new ComboBox();
        gridFiltros.addComponent(cbxEstadoFiltro, 5, 0);
        cbxEstadoFiltro.setTextInputAllowed(false);
        cbxEstadoFiltro.setNullSelectionAllowed(false);
        cbxEstadoFiltro.addItem("");
        cbxEstadoFiltro.setItemCaption("", "Seleccione");
        cbxEstadoFiltro.addItem(1);
        cbxEstadoFiltro.setItemCaption(1, "Activo");
        cbxEstadoFiltro.addItem(2);
        cbxEstadoFiltro.setItemCaption(2, "Inactivo");
        cbxEstadoFiltro.select("");
        cbxEstadoFiltro.setWidth(15, Sizeable.Unit.EM);
        cbxEstadoFiltro.setHeight(2, Sizeable.Unit.EM);

        VerticalLayout v2 = new VerticalLayout();
        btnFiltrar = new Button("Filtrar");
        btnLimpiar = new Button("Limpiar");
        btexportar = new Button("Exportar");

        hrz.addComponents(btnFiltrar, btnLimpiar, btexportar);

        tabla = new PagedTableCustomMila("");
        cargarTablaMantenedor();
        tabla.setContainerDataSource(ic);
        tabla.setImmediate(true);
        tabla.setSelectable(true);
        tabla.setColumnReorderingAllowed(false);
        tabla.setPageLength(10);

        verticalFiltros.addComponent(gridFiltros);
        verticalFiltros.setComponentAlignment(gridFiltros, Alignment.TOP_CENTER);

        panelFiltros.setContent(verticalFiltros);
        panelTabla.setContent(tabla);
        panelPaginacion.setContent(tabla.createControls());
        vl.addComponents(HL);
        HL.addStyleName("horizontal1");
        v2.addComponents(hrz);
        hrz.addStyleName("horizontal1");
        vertical.setSpacing(true);
        vertical.addComponent(panelFiltros);
        vertical.addComponent(hrz);
        vertical.addComponent(panelTabla);
        vertical.addComponent(HL);
        vertical.addComponent(panelPaginacion);
        horizontal.addComponents(grid);
        vertical.addComponents(horizontal, grid);
        addComponent(vertical);

        /**
         * **************************************************
         */
        /**
         * *************CREAR SCB***************************
         */
        /**
         * *************************************************
         */
        btnuevo.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(final Button.ClickEvent event) {
                crearOrigenMILA();
            }
        });

        /**
         * **************************************************
         */
        /**
         * *************MODIFICAR SCB************************
         */
        /**
         * *************************************************
         */
        btmodificar.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(final Button.ClickEvent event) {
                if (select == 0) {
                    Notification.show("Por favor seleccione un registro", Notification.Type.ERROR_MESSAGE);
                } else {
                    modificarMila();
                }
            }

        });

        /**
         * ****************************************************
         */
        /**
         * *******************EXPORTAR************************
         */
        btexportar.addClickListener(new Button.ClickListener() {
            private static final long serialVersionUID = -73954695086117200L;
            private ExcelExport excelExport;

            @Override
            public void buttonClick(final Button.ClickEvent event) {
                excelExport = new ExcelExport(tabla);
                excelExport.excludeCollapsedColumns();
                excelExport.setReportTitle("Reporte de Mantenedor MILA");
                excelExport.setDisplayTotals(false);
                excelExport.convertTable();
                excelExport.sendConverted();

            }

        });

        /**
         * ************************************************************
         */
        /**
         * *********************FILTRAR*******************************
         */
        btnFiltrar.addClickListener(new Button.ClickListener() {
            private static final long serialVersionUID = 1L;

            @Override
            public void buttonClick(Button.ClickEvent event) {
                filtrarTabla();
            }
        });

        /**
         * **************************************************
         */
        /**
         * *************LIMPIAR FILTROS***************************
         */
        /**
         * *************************************************
         */
        btnLimpiar.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(final Button.ClickEvent event) {
                limpiarCampos();
                cargarTablaMantenedor();
            }
        });
    }

    private void limpiarCampos() {
        txtCodigoPaisFiltros.setValue("");
        txtPaisFiltros.setValue("");
        cbxEstadoFiltro.select("");
    }

    private void cargarTablaMantenedor() {
        
        listMila = mila.RetornarOrigenMILA();

        tabla.getContainerDataSource().removeAllItems();
        Collections.sort(listMila);
        if (!listMila.isEmpty()) {
            for (int i = 0; i < listMila.size(); i++) {

                Item item = ic.addItem(i);
                item.getItemProperty("Código Pais").setValue(listMila.get(i).getCodigoPais().toString());
                item.getItemProperty("Pais").setValue(listMila.get(i).getPais());
                item.getItemProperty("Tipo Documento").setValue(listMila.get(i).getNombreTipoDocumento());
                item.getItemProperty("Número de Documento").setValue(listMila.get(i).getNumeroDocumento());
                item.getItemProperty("Dígito de Verificación").setValue(listMila.get(i).getNumVerificacion());
                item.getItemProperty("Cuenta").setValue(listMila.get(i).getCuenta());
                item.getItemProperty("Estado").setValue(listMila.get(i).getEstado().toString().equals("1") ? "ACTIVO" : "INACTIVO");
            }
        }
        
        editarTabla();
        tabla.setContainerDataSource(ic);
        tabla.setImmediate(true);
    }

    private void crearOrigenMILA() {

        error.setValue("");

        subWindow = new Window("Mantenedor Origen MILA");
        subWindow.setHeight("520px");
        subWindow.setWidth("1010px");
        subWindow.setModal(true);
        subWindow.setClosable(true);
        subWindow.setResizable(false);

        VerticalLayout subContent = new VerticalLayout();
        HorizontalLayout HL = new HorizontalLayout();
        HL.setSpacing(true);
        GridLayout grid = new GridLayout(8, 18);
        grid.setSpacing(true);

        /**
         * **********************************************
         */
        /*Código Pais*/
        /**
         * **********************************************
         */
        Label lbCodigoPais = new Label("Código Pais");
        grid.addComponent(lbCodigoPais, 0, 0);
        grid.setComponentAlignment(lbCodigoPais, Alignment.MIDDLE_CENTER);
        lbCodigoPais.setWidth(11, Sizeable.Unit.EM);
        lbCodigoPais.setHeight(2, Sizeable.Unit.EM);

        Label lbasteris2 = new Label("*");
        lbasteris2.setStyleName("asterix");
        grid.addComponent(lbasteris2, 1, 0);
        grid.setComponentAlignment(lbasteris2, Alignment.MIDDLE_CENTER);
        lbasteris2.setWidth(5, Sizeable.Unit.EM);
        lbasteris2.setHeight(2, Sizeable.Unit.EM);

        txtCodigoPais = new TextField();
        grid.addComponent(txtCodigoPais, 2, 0);
        grid.setComponentAlignment(txtCodigoPais, Alignment.MIDDLE_CENTER);
        txtCodigoPais.setWidth(15, Sizeable.Unit.EM);
        txtCodigoPais.setHeight(2, Sizeable.Unit.EM);
        txtCodigoPais.setMaxLength(3);

        lberror2 = new Label();
        lberror2.setStyleName("lblerrorestop");
        grid.addComponent(lberror2, 2, 1);
        grid.setComponentAlignment(lberror2, Alignment.BOTTOM_CENTER);
        lberror2.setWidth(18, Sizeable.Unit.EM);
        lberror2.setHeight(2, Sizeable.Unit.EM);

        txtCodigoPais.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (txtCodigoPais.getValue().equals("")) {
                    txtCodigoPais.setComponentError(new UserError(""));
                    lberror2.setValue("Este campo es requerido");
                } else if (!txtCodigoPais.getValue().matches(regexNumeric)) {
                    txtCodigoPais.setComponentError(new UserError(""));
                    lberror2.setValue("Este campo contiene caracteres no válidos");
                } else {
                    existeCodigoPais = mila.ValidarCodigoPais(txtCodigoPais.getValue());
                    
                    if(existeCodigoPais){
                        txtCodigoPais.setComponentError(new UserError(""));
                        lberror2.setValue("Código Pais ya existe");
                    } else {
                        txtCodigoPais.setComponentError(null);
                        lberror2.setValue("");
                    }
                } 
                ValidarError();
            }
        });

        /**
         * **********************************************
         */
        /*Pais*/
        /**
         * **********************************************
         */
        Label lbPais = new Label("Pais");
        grid.addComponent(lbPais, 4, 0);
        grid.setComponentAlignment(lbPais, Alignment.MIDDLE_RIGHT);
        lbPais.setWidth(11, Sizeable.Unit.EM);
        lbPais.setHeight(2, Sizeable.Unit.EM);

        Label lbasteris6 = new Label("*");
        lbasteris6.setStyleName("asterix");
        grid.addComponent(lbasteris6, 5, 0);
        grid.setComponentAlignment(lbasteris6, Alignment.MIDDLE_CENTER);
        lbasteris6.setWidth(5, Sizeable.Unit.EM);
        lbasteris6.setHeight(2, Sizeable.Unit.EM);

        txtPais = new TextField();
        grid.addComponent(txtPais, 6, 0);
        grid.setComponentAlignment(txtPais, Alignment.MIDDLE_CENTER);
        txtPais.setWidth(15, Sizeable.Unit.EM);
        txtPais.setHeight(2, Sizeable.Unit.EM);
        txtPais.setMaxLength(15);

        lberror7 = new Label();
        lberror7.setStyleName("lblerrorestop");
        grid.addComponent(lberror7, 6, 1);
        grid.setComponentAlignment(lberror7, Alignment.BOTTOM_CENTER);
        lberror7.setWidth(18, Sizeable.Unit.EM);
        lberror7.setHeight(2, Sizeable.Unit.EM);

        txtPais.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (txtPais.getValue().equals("")) {
                    txtPais.setComponentError(new UserError(""));
                    lberror7.setValue("Este campo es requerido");
                } else if (!txtPais.getValue().matches(regexLetrasTildes)) {
                    txtPais.setComponentError(new UserError(""));
                    lberror7.setValue("Este campo contiene caracteres no válidos");
                } else {
                    txtPais.setComponentError(null);
                    lberror7.setValue("");
                }
                ValidarError();
            }
        });

        /**
         * **********************************************
         */
        /*Tipo de Documento*/
        /**
         * **********************************************
         */
        Label lbtipDocumento = new Label("Tipo de Documento");
        grid.addComponent(lbtipDocumento, 0, 2);
        grid.setComponentAlignment(lbtipDocumento, Alignment.MIDDLE_CENTER);
        lbtipDocumento.setWidth(11, Sizeable.Unit.EM);
        lbtipDocumento.setHeight(2, Sizeable.Unit.EM);

        Label lbasteris3 = new Label("*");
        lbasteris3.setStyleName("asterix");
        grid.addComponent(lbasteris3, 1, 2);
        grid.setComponentAlignment(lbasteris3, Alignment.MIDDLE_CENTER);
        lbasteris3.setWidth(5, Sizeable.Unit.EM);
        lbasteris3.setHeight(2, Sizeable.Unit.EM);

        cbxtipDocumento = new ComboBox();

        cbxtipDocumento = LlenarTipoDocumento();
        cbxtipDocumento.setValue(4);
        
        

        cbxtipDocumento.setEnabled(false);

        grid.addComponent(cbxtipDocumento, 2, 2);
        grid.setComponentAlignment(cbxtipDocumento, Alignment.MIDDLE_CENTER);
        cbxtipDocumento.setWidth(15, Sizeable.Unit.EM);
        cbxtipDocumento.setHeight(3, Sizeable.Unit.EM);

        lberror3 = new Label();
        lberror3.setStyleName("lblerrorestop");
        grid.addComponent(lberror3, 2, 3);
        grid.setComponentAlignment(lberror3, Alignment.BOTTOM_CENTER);
        lberror3.setWidth(18, Sizeable.Unit.EM);
        lberror3.setHeight(2, Sizeable.Unit.EM);

        cbxtipDocumento.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (cbxtipDocumento.getValue() == null || cbxtipDocumento.getValue().equals("")) {
                    cbxtipDocumento.setComponentError(new UserError(""));
                    lberror3.setValue("Este campo es requerido");
                } else {
                    cbxtipDocumento.setComponentError(null);
                    lberror3.setValue("");

                }
                ValidarError();
            }
        });

        cbxtipDocumento.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {

                try {
                    valorCombo = (Integer) cbxtipDocumento.getValue();
                } catch (NullPointerException e) {
                    valorCombo = 4;
                } catch (ClassCastException ex) {
                    valorCombo = 4;
                }

                ValidarError();
            }
        });

        /**
         * **********************************************
         */
        /*Número de Documento*/
        /**
         * **********************************************
         */
        Label lbnumeroDoc = new Label("Número de Documento");
        grid.addComponent(lbnumeroDoc, 4, 2);
        grid.setComponentAlignment(lbnumeroDoc, Alignment.MIDDLE_RIGHT);
        lbnumeroDoc.setWidth(11, Sizeable.Unit.EM);
        lbnumeroDoc.setHeight(2, Sizeable.Unit.EM);

        Label lbasteris7 = new Label("*");
        lbasteris7.setStyleName("asterix");
        grid.addComponent(lbasteris7, 5, 2);
        grid.setComponentAlignment(lbasteris7, Alignment.MIDDLE_CENTER);
        lbasteris7.setWidth(5, Sizeable.Unit.EM);
        lbasteris7.setHeight(2, Sizeable.Unit.EM);

        txtnumeroDoc = new TextField();
        grid.addComponent(txtnumeroDoc, 6, 2);
        grid.setComponentAlignment(txtnumeroDoc, Alignment.MIDDLE_CENTER);
        txtnumeroDoc.setWidth(15, Sizeable.Unit.EM);
        txtnumeroDoc.setHeight(2, Sizeable.Unit.EM);
        txtnumeroDoc.setMaxLength(15);

        lberror8 = new Label();
        lberror8.setStyleName("lblerrorestop");
        grid.addComponent(lberror8, 6, 3);
        grid.setComponentAlignment(lberror8, Alignment.BOTTOM_CENTER);
        lberror8.setWidth(18, Sizeable.Unit.EM);
        lberror8.setHeight(2, Sizeable.Unit.EM);

        txtnumeroDoc.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                txtnumeroDoc.setComponentError(null);
                lberror8.setValue("");
                if (!txtnumeroDoc.getValue().equals("")) {
                    if (!txtnumeroDoc.getValue().matches(regexNumeric)) {
                        txtnumeroDoc.setComponentError(new UserError(""));
                        lberror8.setValue("Este campo contiene caracteres no válidos");
                    }
                } else {
                    txtnumeroDoc.setComponentError(new UserError(""));
                    lberror8.setValue("Este campo es requerido");
                }
                ValidarError();
            }
        });

        /**
         * **********************************************
         */
        /*Digito de verificación*/
        /**
         * **********************************************
         */
        txtDigitoverificacion = new TextField();
        grid.addComponent(txtDigitoverificacion, 7, 2);
        grid.setComponentAlignment(txtDigitoverificacion, Alignment.MIDDLE_CENTER);
        txtDigitoverificacion.setWidth(2, Sizeable.Unit.EM);
        txtDigitoverificacion.setHeight(2, Sizeable.Unit.EM);
        txtDigitoverificacion.setMaxLength(1);

        lberror12 = new Label();
        lberror12.setStyleName("lblerrorestop");
        grid.addComponent(lberror12, 7, 3);
        grid.setComponentAlignment(lberror12, Alignment.BOTTOM_CENTER);
        lberror12.setWidth(6, Sizeable.Unit.EM);
        lberror12.setHeight(2, Sizeable.Unit.EM);

        txtDigitoverificacion.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {
                txtDigitoverificacion.setValue(txtDigitoverificacion.getValue().toUpperCase());
                txtDigitoverificacion.setComponentError(null);
                lberror12.setValue("");

                if (!txtDigitoverificacion.getValue().equals("")) {
                    if (!txtDigitoverificacion.getValue().matches(regexNumeric)) {
                        txtDigitoverificacion.setComponentError(new UserError(""));
                        lberror12.setValue("Este campo contiene caracteres no válidos");
                    } else if (!txtnumeroDoc.getValue().equals("")) {
                        if (validacion.validarRut(txtnumeroDoc.getValue()) != Integer.parseInt(txtDigitoverificacion.getValue())) {
                            txtDigitoverificacion.setComponentError(new UserError(""));
                            lberror12.setValue("El dígito de verificación ingresado no corresponde al NIT.");
                        } else {
                            txtDigitoverificacion.setComponentError(null);
                            lberror12.setValue("");
                        }
                    }
                } else {
                    txtDigitoverificacion.setComponentError(new UserError(""));
                    lberror12.setValue("Este campo es requerido");
                }
                ValidarError();
            }
        });

        /**
         * **********************************************
         */
        /*Cuenta*/
        /**
         * **********************************************
         */
        Label lbCuenta = new Label("Cuenta");
        grid.addComponent(lbCuenta, 0, 4);
        grid.setComponentAlignment(lbCuenta, Alignment.MIDDLE_CENTER);
        lbCuenta.setWidth(11, Sizeable.Unit.EM);
        lbCuenta.setHeight(2, Sizeable.Unit.EM);

        Label lbasteris8 = new Label("*");
        lbasteris8.setStyleName("asterix");
        grid.addComponent(lbasteris8, 1, 4);
        grid.setComponentAlignment(lbasteris8, Alignment.MIDDLE_CENTER);
        lbasteris8.setWidth(5, Sizeable.Unit.EM);
        lbasteris8.setHeight(2, Sizeable.Unit.EM);

        txtCuenta = new TextField();
        grid.addComponent(txtCuenta, 2, 4);
        grid.setComponentAlignment(txtCuenta, Alignment.MIDDLE_CENTER);
        txtCuenta.setWidth(15, Sizeable.Unit.EM);
        txtCuenta.setHeight(2, Sizeable.Unit.EM);
        txtCuenta.setMaxLength(8);

        lberror4 = new Label();
        lberror4.setStyleName("lblerrorestop");
        grid.addComponent(lberror4, 2, 5);
        grid.setComponentAlignment(lberror4, Alignment.BOTTOM_CENTER);
        lberror4.setWidth(18, Sizeable.Unit.EM);
        lberror4.setHeight(2, Sizeable.Unit.EM);

        txtCuenta.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!txtCuenta.getValue().equals("")) {
                    if (!txtCuenta.getValue().matches(regexNumeric)) {
                        txtCuenta.setComponentError(new UserError(""));
                        lberror4.setValue("Este campo contiene caracteres no válidos");
                    } else if(Integer.parseInt(txtCuenta.getValue()) <= 0 ){
                        txtCuenta.setComponentError(new UserError(""));
                        lberror4.setValue("Cuenta inversionista inválida");
                    } else{
                        txtCuenta.setComponentError(null);
                        lberror4.setValue("");
                    }
                } else {
                    txtCuenta.setComponentError(new UserError(""));
                    lberror4.setValue("Este campo es requerido");
                }
                ValidarError();
            }
        });

        /**
         * **********************************************
         */
        /*Estado*/
        /**
         * **********************************************
         */
        Label lbEstado = new Label("Estado");
        grid.addComponent(lbEstado, 4, 4);
        grid.setComponentAlignment(lbEstado, Alignment.MIDDLE_RIGHT);
        lbEstado.setWidth(11, Sizeable.Unit.EM);
        lbEstado.setHeight(2, Sizeable.Unit.EM);

        Label lbasteris10 = new Label("*");
        lbasteris10.setStyleName("asterix");
        grid.addComponent(lbasteris10, 5, 4);
        grid.setComponentAlignment(lbasteris10, Alignment.MIDDLE_CENTER);
        lbasteris10.setWidth(5, Sizeable.Unit.EM);
        lbasteris10.setHeight(2, Sizeable.Unit.EM);

        cbxEstado = new ComboBox();
        cbxEstado.setTextInputAllowed(false);
        cbxEstado.setNullSelectionAllowed(false);
        cbxEstado.addItem("");
        cbxEstado.setItemCaption("", "Seleccione");
        cbxEstado.addItem(1);
        cbxEstado.setItemCaption(1, "Activo");
        cbxEstado.addItem(2);
        cbxEstado.setItemCaption(2, "Inactivo");
        cbxEstado.select("");
        grid.addComponent(cbxEstado, 6, 4);
        grid.setComponentAlignment(cbxEstado, Alignment.MIDDLE_CENTER);
        cbxEstado.setWidth(15, Sizeable.Unit.EM);
        cbxEstado.setHeight(2, Sizeable.Unit.EM);

        lberror6 = new Label();
        lberror6.setStyleName("lblerrorcomboBox");
        grid.addComponent(lberror6, 6, 5);
        grid.setComponentAlignment(lberror6, Alignment.BOTTOM_CENTER);
        lberror6.setWidth(18, Sizeable.Unit.EM);
        lberror6.setHeight(2, Sizeable.Unit.EM);

        cbxEstado.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                if (cbxEstado.getValue() == null || cbxEstado.getValue().equals("")) {
                    cbxEstado.setComponentError(new UserError(""));
                    lberror6.setValue("Este campo es requerido");
                } else {
                    cbxEstado.setComponentError(null);
                    lberror6.setValue("");
                }
                ValidarError();
            }
        });

        VerticalLayout vl = new VerticalLayout();
        Button btnCancelar = new Button("Cancelar");
        btnGuardar = new Button("Guardar");
        HL.addComponents(btnGuardar, btnCancelar);
        error.setStyleName("lblErrorVer");
        HL.addComponent(error);
        vl.addComponents(HL);
        subContent.setMargin(true);
        HL.addStyleName("horizontal1");
        subContent.addComponents(grid, HL);

        subWindow.setContent(subContent);
        UI.getCurrent().addWindow(subWindow);

        btnCancelar.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(final Button.ClickEvent event) {
                UI.getCurrent().removeWindow(subWindow);
                error.setValue("");
            }
        });

        btnGuardar.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(final Button.ClickEvent event) {
                if (txtCodigoPais.getValue().equals("")) {
                    txtCodigoPais.setComponentError(new UserError(""));
                    lberror2.setValue("Este campo es requerido");
                }

                if (txtPais.getValue().equals("")) {
                    txtPais.setComponentError(new UserError(""));
                    lberror7.setValue("Este campo es requerido");
                }

                if (cbxtipDocumento.getValue() == null || cbxtipDocumento.getValue().equals("")) {
                    cbxtipDocumento.setComponentError(new UserError(""));
                    lberror3.setValue("Este campo es requerido");
                }

                if (txtnumeroDoc.getValue().equals("")) {
                    txtnumeroDoc.setComponentError(new UserError(""));
                    lberror8.setValue("Este campo es requerido");
                } else if (valorCombo == 4) {
                    if (txtDigitoverificacion.getValue().equals("")) {
                        txtDigitoverificacion.setComponentError(new UserError(""));
                        lberror12.setValue("Este campo es requerido");
                    } else if (validacion.validarRut(txtnumeroDoc.getValue()) != Integer.parseInt(txtDigitoverificacion.getValue())) {
                        txtDigitoverificacion.setComponentError(new UserError(""));
                        lberror12.setValue("El dígito de verificación ingresado no corresponde al NIT.");
                    }
                }

                if (txtCuenta.getValue().equals("")) {
                    txtCuenta.setComponentError(new UserError(""));
                    lberror4.setValue("Este campo es requerido");
                }

                try {
                    comboaEstado = (Integer) cbxEstado.getValue();
                } catch (NullPointerException e) {
                    comboaEstado = 0;
                } catch (ClassCastException ex) {
                    comboaEstado = 0;
                }
                if (comboaEstado == 0) {
                    cbxEstado.setComponentError(new UserError(""));
                    lberror6.setValue("Este campo es requerido");
                }

                ValidarError();
                if (!ValidaComponentError()) {
                    ConfirmDialog.show(getUI(), "Confirmación", "¿Está seguro que desea incluir el Origen MILA?", "ACEPTAR",
                            "CANCELAR", new ConfirmDialog.Listener() {
                        @Override
                        public void onClose(ConfirmDialog dialog) {
                            if (dialog.isConfirmed()) {

                                /*Guardar sociedad comisionista de bolsa*/
                                String resultado = mila.IngresarOrigenMILA(new OrigenMILA(
                                            0,
                                            Integer.parseInt(txtCodigoPais.getValue()),
                                            txtPais.getValue(),
                                            tipoDocumentoMila,
                                            txtnumeroDoc.getValue(),
                                            txtDigitoverificacion.getValue(),
                                            txtCuenta.getValue(),
                                            comboaEstado));

                                UI.getCurrent().removeWindow(subWindow);
                                cargarTablaMantenedor();

                                UI.getCurrent().removeWindow(subWindow);
                                ConfirmDialog cd = ConfirmDialog.getFactory().create("Confirmación", "", "ACEPTAR", "", "");
                                cd.setWidth("380px");
                                cd.setHeight("140px");
                                HorizontalLayout texto = new HorizontalLayout();
                                HorizontalLayout buttons = new HorizontalLayout();
                                buttons.setStyleName("btnAceptar");
                                Label lblmensaje = new Label("El Origen MILA ha sido ingresada", ContentMode.HTML);
                                texto.addComponent(lblmensaje);
                                buttons.addComponent(cd.getOkButton());
                                VerticalLayout content = new VerticalLayout(lblmensaje, buttons);
                                content.setStyleName("verticalDialog");
                                content.setSizeFull();
                                content.setSpacing(true);
                                cd.setContent(content);
                                cd.show(getUI(), new ConfirmDialog.Listener() {
                                    @Override
                                    public void onClose(ConfirmDialog cd) {

                                    }
                                }, true);
                            }
                            btnGuardar.setEnabled(true);
                        }
                    });

                }
            }
        });

    }

    public void filtrarTabla() {

        String codigoPais = "";
        String pais = "";
        int comboEst = 0;

        List<OrigenMILA> listMILA;

        try {
            codigoPais = txtCodigoPaisFiltros.getValue() != null ? txtCodigoPaisFiltros.getValue() : "";

        } catch (Exception e) {
            codigoPais = "";

        }
        try {
            pais = txtPaisFiltros.getValue() != null ? txtPaisFiltros.getValue() : "";

        } catch (Exception e) {
            pais = "";

        }

        try {
            comboEst = (Integer) cbxEstadoFiltro.getValue();
        } catch (NullPointerException e) {
            comboEst = 3;
        } catch (ClassCastException ex) {
            comboEst = 3;
        }

        listMILA = mila.ListarMilaFiltros(codigoPais, pais, comboEst);
        Collections.sort(listMILA);
        tabla.getContainerDataSource().removeAllItems();
        if (!listMILA.isEmpty()) {
            for (int i = 0; i < listMILA.size(); i++) {

                Item item = ic.addItem(i);
                item.getItemProperty("Código Pais").setValue(listMILA.get(i).getCodigoPais().toString());
                item.getItemProperty("Pais").setValue(listMILA.get(i).getPais());
                item.getItemProperty("Tipo Documento").setValue(listMILA.get(i).getNombreTipoDocumento().toString());
                item.getItemProperty("Número de Documento").setValue(listMILA.get(i).getNumeroDocumento());
                item.getItemProperty("Dígito de Verificación").setValue(listMILA.get(i).getNumVerificacion());
                item.getItemProperty("Cuenta").setValue(listMILA.get(i).getCuenta());
                item.getItemProperty("Estado").setValue(listMILA.get(i).getEstado().toString().equals("1") ? "ACTIVO" : "INACTIVO");

            }
        } else {
            Notification.show("No existen registros", Notification.Type.ERROR_MESSAGE);
        }

        // editarTabla();
        tabla.setContainerDataSource(ic);
        tabla.setImmediate(true);
        tabla.setColumnReorderingAllowed(true);
        tabla.setSortAscending(true);
        tabla.setSizeFull();
        tabla.setImmediate(true);

    }

    public void editarTabla() {
        tabla.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                Integer itemId = (Integer) tabla.getValue();
                
                try {
                    select = 1;
                    idOrigenMila = listMila.get(itemId).getIdMila().toString();
                    codigoPais = ic.getContainerProperty((itemId), "Código Pais").getValue().toString();
                    pais = ic.getContainerProperty((itemId), "Pais").getValue().toString();
                    tipDocumento = ic.getContainerProperty((itemId), "Tipo Documento").getValue().toString();
                    numDocumento = ic.getContainerProperty((itemId), "Número de Documento").getValue().toString();
                    digVerificacion = ic.getContainerProperty((itemId), "Dígito de Verificación").getValue().toString();
                    cuenta = ic.getContainerProperty((itemId), "Cuenta").getValue().toString();
                    estado = ic.getContainerProperty((itemId), "Estado").getValue().toString();

                } catch (NullPointerException ex) {
                    idOrigenMila = "";
                    codigoPais = "";
                    pais = "";
                    tipDocumento = "";
                    numDocumento = "";
                    digVerificacion = "";
                    cuenta = "";
                    estado = "";
                }
            }
        });
    }

    public void ValidarError() {
        if (ValidaComponentError()) {
            error.setValue("Verificar campos en rojo");
        } else {
            error.setValue("");
        }
    }

    public Boolean ValidaComponentError() {
        Boolean errores = false;
        if (txtCodigoPais.getComponentError() != null) {
            return true;
        }
        if (txtPais.getComponentError() != null) {
            return true;
        }
        if (cbxtipDocumento.getComponentError() != null) {
            return true;
        }

        if (cbxEstado.getComponentError() != null) {
            return true;
        }

        if (txtnumeroDoc.getComponentError() != null || txtDigitoverificacion.getComponentError() != null) {
            return true;
        }

        if (txtCuenta.getComponentError() != null) {
            return true;
        }

        return errores;
    }

    public ComboBox LlenarTipoDocumento() {
        Iterator<TipoDocumento> LTipo = null;
        LTipo = facade.RetornarDocumentos().iterator();
        TipoDocumento TP = null;
        cbxtipDocumento.setNullSelectionAllowed(false);
        cbxtipDocumento.setTextInputAllowed(false);
        cbxtipDocumento.addItem("");
        cbxtipDocumento.setItemCaption("", "Seleccione");
        cbxtipDocumento.select("");
        while (LTipo.hasNext()) {
            TP = LTipo.next();
            cbxtipDocumento.addItem(TP.getTipodocumento());
            cbxtipDocumento.setItemCaption(TP.getTipodocumento(), TP.getNombredoc());
        }
        return cbxtipDocumento;
    }

    private void modificarMila() {

        error.setValue("");
        if (codigoPais.equals("")) {
            Notification.show("Por favor Seleccione un Registro", Notification.Type.ERROR_MESSAGE);
        } else {

            subWindow = new Window("Mantenedor Origen MILA");
            subWindow.setHeight("520px");
            subWindow.setWidth("1010px");
            subWindow.setModal(true);
            subWindow.setClosable(true);
            subWindow.setResizable(false);

            VerticalLayout subContent = new VerticalLayout();
            HorizontalLayout HL = new HorizontalLayout();
            HL.setSpacing(true);
            GridLayout grid = new GridLayout(8, 18);
            grid.setSpacing(true);

            /**
             * **********************************************
             */
            /*Código Pais*/
            /**
             * **********************************************
             */
            Label lbCodigoPais = new Label("Código Pais");
            grid.addComponent(lbCodigoPais, 0, 0);
            grid.setComponentAlignment(lbCodigoPais, Alignment.MIDDLE_CENTER);
            lbCodigoPais.setWidth(11, Sizeable.Unit.EM);
            lbCodigoPais.setHeight(2, Sizeable.Unit.EM);

            Label lbasteris2 = new Label("*");
            lbasteris2.setStyleName("asterix");
            grid.addComponent(lbasteris2, 1, 0);
            grid.setComponentAlignment(lbasteris2, Alignment.MIDDLE_CENTER);
            lbasteris2.setWidth(5, Sizeable.Unit.EM);
            lbasteris2.setHeight(2, Sizeable.Unit.EM);

            txtCodigoPais = new TextField();
            txtCodigoPais.setValue(codigoPais);
            grid.addComponent(txtCodigoPais, 2, 0);
            grid.setComponentAlignment(txtCodigoPais, Alignment.MIDDLE_CENTER);
            txtCodigoPais.setWidth(15, Sizeable.Unit.EM);
            txtCodigoPais.setHeight(2, Sizeable.Unit.EM);
            txtCodigoPais.setMaxLength(3);

            lberror2 = new Label();
            lberror2.setStyleName("lblerrorestop");
            grid.addComponent(lberror2, 2, 1);
            grid.setComponentAlignment(lberror2, Alignment.BOTTOM_CENTER);
            lberror2.setWidth(18, Sizeable.Unit.EM);
            lberror2.setHeight(2, Sizeable.Unit.EM);

            txtCodigoPais.addBlurListener(new FieldEvents.BlurListener() {

                @Override
                public void blur(FieldEvents.BlurEvent event) {
                    
                    if (txtCodigoPais.getValue().equals("")) {
                        txtCodigoPais.setComponentError(new UserError(""));
                        lberror2.setValue("Este campo es requerido");
                    } else if (!txtCodigoPais.getValue().matches(regexNumeric)) {
                        txtCodigoPais.setComponentError(new UserError(""));
                        lberror2.setValue("Este campo contiene caracteres no válidos");
                    } else {
                        existeCodigoPais = mila.ValidarCodigoPais(txtCodigoPais.getValue());
                        boolean usaCodigoActual =  Integer.parseInt(codigoPais) == Integer.parseInt(txtCodigoPais.getValue());
                        if(existeCodigoPais && !usaCodigoActual){
                            txtCodigoPais.setComponentError(new UserError(""));
                            lberror2.setValue("Código Pais ya existe");
                        } else {
                            txtCodigoPais.setComponentError(null);
                            lberror2.setValue("");
                        }
                    } 
                    ValidarError();
                }
            });

            /**
             * **********************************************
             */
            /*Pais*/
            /**
             * **********************************************
             */
            Label lbPais = new Label("Pais");
            grid.addComponent(lbPais, 4, 0);
            grid.setComponentAlignment(lbPais, Alignment.MIDDLE_RIGHT);
            lbPais.setWidth(11, Sizeable.Unit.EM);
            lbPais.setHeight(2, Sizeable.Unit.EM);

            Label lbasteris6 = new Label("*");
            lbasteris6.setStyleName("asterix");
            grid.addComponent(lbasteris6, 5, 0);
            grid.setComponentAlignment(lbasteris6, Alignment.MIDDLE_CENTER);
            lbasteris6.setWidth(5, Sizeable.Unit.EM);
            lbasteris6.setHeight(2, Sizeable.Unit.EM);

            txtPais = new TextField();
            txtPais.setValue(pais);
            grid.addComponent(txtPais, 6, 0);
            grid.setComponentAlignment(txtPais, Alignment.MIDDLE_CENTER);
            txtPais.setWidth(15, Sizeable.Unit.EM);
            txtPais.setHeight(2, Sizeable.Unit.EM);
            txtPais.setMaxLength(15);

            lberror7 = new Label();
            lberror7.setStyleName("lblerrorestop");
            grid.addComponent(lberror7, 6, 1);
            grid.setComponentAlignment(lberror7, Alignment.BOTTOM_CENTER);
            lberror7.setWidth(18, Sizeable.Unit.EM);
            lberror7.setHeight(2, Sizeable.Unit.EM);

            txtPais.addBlurListener(new FieldEvents.BlurListener() {

                @Override
                public void blur(FieldEvents.BlurEvent event) {

                    if (txtPais.getValue().equals("")) {
                        txtPais.setComponentError(new UserError(""));
                        lberror7.setValue("Este campo es requerido");
                    } else if (!txtPais.getValue().matches(regexLetrasTildes)) {
                        txtPais.setComponentError(new UserError(""));
                        lberror7.setValue("Este campo contiene caracteres no válidos");
                    } else {
                        txtPais.setComponentError(null);
                        lberror7.setValue("");
                    }
                    ValidarError();
                }
            });

            /**
             * **********************************************
             */
            /*Tipo de Documento*/
            /**
             * **********************************************
             */
            Label lbtipDocumento = new Label("Tipo de Documento");
            grid.addComponent(lbtipDocumento, 0, 2);
            grid.setComponentAlignment(lbtipDocumento, Alignment.MIDDLE_CENTER);
            lbtipDocumento.setWidth(11, Sizeable.Unit.EM);
            lbtipDocumento.setHeight(2, Sizeable.Unit.EM);

            Label lbasteris3 = new Label("*");
            lbasteris3.setStyleName("asterix");
            grid.addComponent(lbasteris3, 1, 2);
            grid.setComponentAlignment(lbasteris3, Alignment.MIDDLE_CENTER);
            lbasteris3.setWidth(5, Sizeable.Unit.EM);
            lbasteris3.setHeight(2, Sizeable.Unit.EM);

            cbxtipDocumento = new ComboBox();
            cbxtipDocumento = LlenarTipoDocumento();
            cbxtipDocumento.setValue(tipoDocumentoMila);

            cbxtipDocumento.setEnabled(false);

            grid.addComponent(cbxtipDocumento, 2, 2);
            grid.setComponentAlignment(cbxtipDocumento, Alignment.MIDDLE_CENTER);
            cbxtipDocumento.setWidth(15, Sizeable.Unit.EM);
            cbxtipDocumento.setHeight(3, Sizeable.Unit.EM);

            lberror3 = new Label();
            lberror3.setStyleName("lblerrorestop");
            grid.addComponent(lberror3, 2, 3);
            grid.setComponentAlignment(lberror3, Alignment.BOTTOM_CENTER);
            lberror3.setWidth(18, Sizeable.Unit.EM);
            lberror3.setHeight(2, Sizeable.Unit.EM);

            cbxtipDocumento.addBlurListener(new FieldEvents.BlurListener() {
                @Override
                public void blur(FieldEvents.BlurEvent event) {
                    if (cbxtipDocumento.getValue() == null || cbxtipDocumento.getValue().equals("")) {
                        cbxtipDocumento.setComponentError(new UserError(""));
                        lberror3.setValue("Este campo es requerido");
                    } else {
                        cbxtipDocumento.setComponentError(null);
                        lberror3.setValue("");

                    }
                    ValidarError();
                }
            });

            cbxtipDocumento.addValueChangeListener(new Property.ValueChangeListener() {
                @Override
                public void valueChange(Property.ValueChangeEvent event) {

                    try {
                        valorCombo = (Integer) cbxtipDocumento.getValue();
                    } catch (NullPointerException e) {
                        valorCombo = 4;
                    } catch (ClassCastException ex) {
                        valorCombo = 4;
                    }

                    ValidarError();
                }
            });

            /**
             * **********************************************
             */
            /*Número de Documento*/
            /**
             * **********************************************
             */
            Label lbnumeroDoc = new Label("Número de Documento");
            grid.addComponent(lbnumeroDoc, 4, 2);
            grid.setComponentAlignment(lbnumeroDoc, Alignment.MIDDLE_RIGHT);
            lbnumeroDoc.setWidth(11, Sizeable.Unit.EM);
            lbnumeroDoc.setHeight(2, Sizeable.Unit.EM);

            Label lbasteris7 = new Label("*");
            lbasteris7.setStyleName("asterix");
            grid.addComponent(lbasteris7, 5, 2);
            grid.setComponentAlignment(lbasteris7, Alignment.MIDDLE_CENTER);
            lbasteris7.setWidth(5, Sizeable.Unit.EM);
            lbasteris7.setHeight(2, Sizeable.Unit.EM);

            txtnumeroDoc = new TextField();
            grid.addComponent(txtnumeroDoc, 6, 2);
            grid.setComponentAlignment(txtnumeroDoc, Alignment.MIDDLE_CENTER);
            txtnumeroDoc.setWidth(15, Sizeable.Unit.EM);
            txtnumeroDoc.setHeight(2, Sizeable.Unit.EM);
            txtnumeroDoc.setMaxLength(15);
            txtnumeroDoc.setValue(numDocumento);

            lberror8 = new Label();
            lberror8.setStyleName("lblerrorestop");
            grid.addComponent(lberror8, 6, 3);
            grid.setComponentAlignment(lberror8, Alignment.BOTTOM_CENTER);
            lberror8.setWidth(18, Sizeable.Unit.EM);
            lberror8.setHeight(2, Sizeable.Unit.EM);

            txtnumeroDoc.addBlurListener(new FieldEvents.BlurListener() {

                @Override
                public void blur(FieldEvents.BlurEvent event) {

                        try {
                            valorCombo = (Integer) cbxtipDocumento.getValue();
                        } catch (NullPointerException ex) {
                            valorCombo = 0;
                        } catch (ClassCastException e) {
                            valorCombo = 0;
                        }
                    txtnumeroDoc.setComponentError(null);
                    lberror8.setValue("");
                    if (!txtnumeroDoc.getValue().equals("")) {
                        if (!txtnumeroDoc.getValue().matches(regexNumeric)) {
                            txtnumeroDoc.setComponentError(new UserError(""));
                            lberror8.setValue("Este campo contiene caracteres no válidos");
                        }
                    } else {
                        txtnumeroDoc.setComponentError(new UserError(""));
                        lberror8.setValue("Este campo es requerido");
                    }
                    ValidarError();
                }
            });

            /**
             * **********************************************
             */
            /*Digito de verificación*/
            /**
             * **********************************************
             */
            txtDigitoverificacion = new TextField();
            grid.addComponent(txtDigitoverificacion, 7, 2);
            grid.setComponentAlignment(txtDigitoverificacion, Alignment.MIDDLE_CENTER);
            txtDigitoverificacion.setWidth(2, Sizeable.Unit.EM);
            txtDigitoverificacion.setHeight(2, Sizeable.Unit.EM);
            txtDigitoverificacion.setMaxLength(1);
            txtDigitoverificacion.setValue(digVerificacion);

            lberror12 = new Label();
            lberror12.setStyleName("lblerrorestop");
            grid.addComponent(lberror12, 7, 3);
            grid.setComponentAlignment(lberror12, Alignment.BOTTOM_CENTER);
            lberror12.setWidth(6, Sizeable.Unit.EM);
            lberror12.setHeight(2, Sizeable.Unit.EM);

            txtDigitoverificacion.addBlurListener(new FieldEvents.BlurListener() {

                @Override
                public void blur(FieldEvents.BlurEvent event) {
                    txtDigitoverificacion.setValue(txtDigitoverificacion.getValue().toUpperCase());
                    txtDigitoverificacion.setComponentError(null);
                    lberror12.setValue("");

                    if (!txtDigitoverificacion.getValue().equals("")) {
                        if (!txtDigitoverificacion.getValue().matches(regexNumeric)) {
                            txtDigitoverificacion.setComponentError(new UserError(""));
                            lberror12.setValue("Este campo contiene caracteres no válidos");
                        } else if (!txtnumeroDoc.getValue().equals("")) {
                            if (validacion.validarRut(txtnumeroDoc.getValue()) != Integer.parseInt(txtDigitoverificacion.getValue())) {
                                txtDigitoverificacion.setComponentError(new UserError(""));
                                lberror12.setValue("El dígito de verificación ingresado no corresponde al NIT.");
                            } else {
                                txtDigitoverificacion.setComponentError(null);
                                lberror12.setValue("");
                            }
                        }
                    } else {
                        txtDigitoverificacion.setComponentError(new UserError(""));
                        lberror12.setValue("Este campo es requerido");
                    }
                    ValidarError();
                }
            });

            /**
             * **********************************************
             */
            /*Cuenta*/
            /**
             * **********************************************
             */
            Label lbCuenta = new Label("Cuenta");
            grid.addComponent(lbCuenta, 0, 4);
            grid.setComponentAlignment(lbCuenta, Alignment.MIDDLE_CENTER);
            lbCuenta.setWidth(11, Sizeable.Unit.EM);
            lbCuenta.setHeight(2, Sizeable.Unit.EM);

            Label lbasteris8 = new Label("*");
            lbasteris8.setStyleName("asterix");
            grid.addComponent(lbasteris8, 1, 4);
            grid.setComponentAlignment(lbasteris8, Alignment.MIDDLE_CENTER);
            lbasteris8.setWidth(5, Sizeable.Unit.EM);
            lbasteris8.setHeight(2, Sizeable.Unit.EM);

            txtCuenta = new TextField();
            grid.addComponent(txtCuenta, 2, 4);
            grid.setComponentAlignment(txtCuenta, Alignment.MIDDLE_CENTER);
            txtCuenta.setWidth(15, Sizeable.Unit.EM);
            txtCuenta.setHeight(2, Sizeable.Unit.EM);
            txtCuenta.setMaxLength(8);
            txtCuenta.setValue(cuenta);

            lberror4 = new Label();
            lberror4.setStyleName("lblerrorestop");
            grid.addComponent(lberror4, 2, 5);
            grid.setComponentAlignment(lberror4, Alignment.BOTTOM_CENTER);
            lberror4.setWidth(18, Sizeable.Unit.EM);
            lberror4.setHeight(2, Sizeable.Unit.EM);

            txtCuenta.addBlurListener(new FieldEvents.BlurListener() {

                @Override
                public void blur(FieldEvents.BlurEvent event) {
                    if (!txtCuenta.getValue().equals("")) {
                        if (!txtCuenta.getValue().matches(regexNumeric)) {
                            txtCuenta.setComponentError(new UserError(""));
                            lberror4.setValue("Este campo contiene caracteres no válidos");
                        }else if(Integer.parseInt(txtCuenta.getValue()) <= 0 ){
                            txtCuenta.setComponentError(new UserError(""));
                            lberror4.setValue("Cuenta inversionista inválida");
                        } else {
                            txtCuenta.setComponentError(null);
                            lberror4.setValue("");
                        }
                    } else {
                        txtCuenta.setComponentError(new UserError(""));
                        lberror4.setValue("Este campo es requerido");
                    }
                    ValidarError();
                }
            });

            /**
             * **********************************************
             */
            /*Estado*/
            /**
             * **********************************************
             */
            Label lbEstado = new Label("Estado");
            grid.addComponent(lbEstado, 4, 4);
            grid.setComponentAlignment(lbEstado, Alignment.MIDDLE_RIGHT);
            lbEstado.setWidth(11, Sizeable.Unit.EM);
            lbEstado.setHeight(2, Sizeable.Unit.EM);

            Label lbasteris10 = new Label("*");
            lbasteris10.setStyleName("asterix");
            grid.addComponent(lbasteris10, 5, 4);
            grid.setComponentAlignment(lbasteris10, Alignment.MIDDLE_CENTER);
            lbasteris10.setWidth(5, Sizeable.Unit.EM);
            lbasteris10.setHeight(2, Sizeable.Unit.EM);

            cbxEstado = new ComboBox();
            cbxEstado.setTextInputAllowed(false);
            cbxEstado.setNullSelectionAllowed(false);
            cbxEstado.addItem("");
            cbxEstado.setItemCaption("", "Seleccione");
            cbxEstado.addItem(1);
            cbxEstado.setItemCaption(1, "Activo");
            cbxEstado.addItem(2);
            cbxEstado.setItemCaption(2, "Inactivo");
            cbxEstado.select("");
            grid.addComponent(cbxEstado, 6, 4);
            grid.setComponentAlignment(cbxEstado, Alignment.MIDDLE_CENTER);
            cbxEstado.setWidth(15, Sizeable.Unit.EM);
            cbxEstado.setHeight(2, Sizeable.Unit.EM);
            
            if (estado.equals("ACTIVO")) {
                cbxEstado.select(1);
            } else if (estado.equals("INACTIVO")) {
                cbxEstado.select(2);
            }

            lberror6 = new Label();
            lberror6.setStyleName("lblerrorcomboBox");
            grid.addComponent(lberror6, 6, 5);
            grid.setComponentAlignment(lberror6, Alignment.BOTTOM_CENTER);
            lberror6.setWidth(18, Sizeable.Unit.EM);
            lberror6.setHeight(2, Sizeable.Unit.EM);

            cbxEstado.addValueChangeListener(new Property.ValueChangeListener() {
                @Override
                public void valueChange(Property.ValueChangeEvent event) {
                    if (cbxEstado.getValue() == null || cbxEstado.getValue().equals("")) {
                        cbxEstado.setComponentError(new UserError(""));
                        lberror6.setValue("Este campo es requerido");
                    } else {
                        cbxEstado.setComponentError(null);
                        lberror6.setValue("");
                    }
                    ValidarError();
                }
            });

            VerticalLayout vl = new VerticalLayout();
            Button btnCancelar = new Button("Cancelar");
            btnGuardar = new Button("Guardar");
            HL.addComponents(btnGuardar, btnCancelar);
            error.setStyleName("lblErrorVer");
            HL.addComponent(error);
            vl.addComponents(HL);
            subContent.setMargin(true);
            HL.addStyleName("horizontal1");
            subContent.addComponents(grid, HL);

            subWindow.setContent(subContent);
            UI.getCurrent().addWindow(subWindow);

            btnCancelar.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(final Button.ClickEvent event) {
                    UI.getCurrent().removeWindow(subWindow);
                    error.setValue("");
                }
            });

            btnGuardar.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(final Button.ClickEvent event) {
                    if (txtCodigoPais.getValue().equals("")) {
                        txtCodigoPais.setComponentError(new UserError(""));
                        lberror2.setValue("Este campo es requerido");
                    }

                    if (txtPais.getValue().equals("")) {
                        txtPais.setComponentError(new UserError(""));
                        lberror7.setValue("Este campo es requerido");
                    }

                    if (cbxtipDocumento.getValue() == null || cbxtipDocumento.getValue().equals("")) {
                        cbxtipDocumento.setComponentError(new UserError(""));
                        lberror3.setValue("Este campo es requerido");
                    }

                    if (txtnumeroDoc.getValue().equals("")) {
                        txtnumeroDoc.setComponentError(new UserError(""));
                        lberror8.setValue("Este campo es requerido");
                    } else if (valorCombo == 4) {
                        if (txtDigitoverificacion.getValue().equals("")) {
                            txtDigitoverificacion.setComponentError(new UserError(""));
                            lberror12.setValue("Este campo es requerido");
                        } else if (validacion.validarRut(txtnumeroDoc.getValue()) != Integer.parseInt(txtDigitoverificacion.getValue())) {
                            txtDigitoverificacion.setComponentError(new UserError(""));
                            lberror12.setValue("El dígito de verificación ingresado no corresponde al NIT.");
                        }
                    }

                    if (txtCuenta.getValue().equals("")) {
                        txtCuenta.setComponentError(new UserError(""));
                        lberror4.setValue("Este campo es requerido");
                    }

                    try {
                        comboaEstado = (Integer) cbxEstado.getValue();
                    } catch (NullPointerException e) {
                        comboaEstado = 0;
                    } catch (ClassCastException ex) {
                        comboaEstado = 0;
                    }

                    ValidarError();
                    if (!ValidaComponentError()) {
                        ConfirmDialog.show(getUI(), "Confirmación", "¿Está seguro que desea modificar el registro?", "ACEPTAR",
                                "CANCELAR", new ConfirmDialog.Listener() {
                            @Override
                            public void onClose(ConfirmDialog dialog) {
                                if (dialog.isConfirmed()) {

                                    /*Guardar sociedad comisionista de bolsa*/
                                    String resultado = mila.ModificarOrigenMILA(new OrigenMILA(
                                            Integer.parseInt(idOrigenMila),
                                            Integer.parseInt(txtCodigoPais.getValue()),
                                            txtPais.getValue(),
                                            tipoDocumentoMila,
                                            txtnumeroDoc.getValue(),
                                            txtDigitoverificacion.getValue(),
                                            txtCuenta.getValue(),
                                            comboaEstado));

                                    UI.getCurrent().removeWindow(subWindow);
                                    cargarTablaMantenedor();

                                    UI.getCurrent().removeWindow(subWindow);
                                    ConfirmDialog cd = ConfirmDialog.getFactory().create("Confirmación", "", "ACEPTAR", "", "");
                                    cd.setWidth("380px");
                                    cd.setHeight("140px");
                                    HorizontalLayout texto = new HorizontalLayout();
                                    HorizontalLayout buttons = new HorizontalLayout();
                                    buttons.setStyleName("btnAceptar");
                                    Label lblmensaje = new Label("El registro ha sido modificado", ContentMode.HTML);
                                    texto.addComponent(lblmensaje);
                                    buttons.addComponent(cd.getOkButton());
                                    VerticalLayout content = new VerticalLayout(lblmensaje, buttons);
                                    content.setStyleName("verticalDialog");
                                    content.setSizeFull();
                                    content.setSpacing(true);
                                    cd.setContent(content);
                                    cd.show(getUI(), new ConfirmDialog.Listener() {
                                        @Override
                                        public void onClose(ConfirmDialog cd) {

                                        }
                                    }, true);
                                }
                                btnGuardar.setEnabled(true);
                            }
                        });

                    }
                }
            });

        }

    }
}

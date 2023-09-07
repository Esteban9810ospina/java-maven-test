/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.ui.contents;

import com.framework.common.ui.GenericContent;
import com.framework.common.ui.GenericTab;
import com.quasar.frameq.fachadas.FacadeSCB;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import java.util.List;
import com.quasar.frameq.data.TipoDocumento;
import com.framework.common.ui.util.ValidarCampos;
import com.quasar.frameq.db.Facade;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.event.FieldEvents;
import com.vaadin.server.UserError;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Notification;
import java.util.Iterator;
import org.vaadin.dialogs.ConfirmDialog;

/**
 *
 * @author jam
 */
public class MantenedorScb extends GenericContent {

    VerticalLayout vertical = new VerticalLayout();
    VerticalLayout verticalFiltros = new VerticalLayout();
    GridLayout gridFiltros = new GridLayout(6, 3);

    PagedTableCustomscb tabla;
    IndexedContainer ic;

    String regexLetras = "^[a-zA-Z\\s]*$";
    String regexNumeric = "^[0-9]*$";
    String regexAlpha = "^[a-zA-Z0-9- \\s . ñ á Á é É í Í ó Ó ú Ú ñ  Ñ]*$";
    String regexAlphaNum = "^[a-zA-Z0-9- _\\s #]*$";
    String regexAlphaParen = "^[a-zA-Z0-9()]*$";
    String regexLetrasTildes = "^[a-zA-Z\\s ñ á Á é É í Í ó Ó ú Ú ñ  Ñ]*$";
    String regexAlphaParen2 = "^[a-zA-Z0-9]*$";

    FacadeSCB scb = new FacadeSCB();
    Facade facade = new Facade();
    ValidarCampos validacion = new ValidarCampos();

    private Button btnuevo = new Button();
    private Button btmodificar = new Button();
//    private Button btexportar = new Button();

    private Button btnFiltrar = new Button();
    private Button btnLimpiar = new Button();
    private Button btexportar = new Button();

    Button btnGuardar;

    Window subWindow;

    TextField txtCodigoScb;
    TextField txtDireccion;
    TextField txtRepresentanteLeg1;
    TextField txtRepresentanteLeg2;
    TextField txtRepresentanteLeg3;
    TextField txtscbEntidad;
    TextField txtDigitoverificacion;
    TextField txtTelefono;
    TextField txtnumeroDoc;
    TextField txtnumeroDocR1 = new TextField();// texto numero de documento representante 1
    TextField txtnumeroDocR2 = new TextField();// texto numero de documento representante 2
    TextField txtnumeroDocR3 = new TextField();// texto numero de documento representante 3

    TextField txtCodigoScbFiltros;
    TextField txtScbEntidadFiltros;

    ComboBox cbxEstado;
    ComboBox cbxtipDocumento;
    ComboBox cbxEstadoFiltro;
    ComboBox cbxtipDocumentoR1 = new ComboBox(); // Combo tipo documento representante 1
    ComboBox cbxtipDocumentoR2 = new ComboBox(); // Combo tipo documento representante 2
    ComboBox cbxtipDocumentoR3 = new ComboBox(); // Combo tipo documento representante 3

    String codigoScb = "";
    String scbEntidad = "";
    String tipDocumento = "";
    String numDocumento = "";
    String digVerificacion = "";
    String direccion = "";
    String telefono = "";
    String repre1 = "";
    String repre2 = "";
    String repre3 = "";
    String estado = "";
    String direccion1 = "";
    String representaLe2 = "";
    String representaLe3 = "";
    String digVerificacion1 = "";
    String numtipodocr2= "";
    String numtipodocr3= "";
    
    String tipodoc ="";
    String tipodocnum ="";
    String tipodoc2 ="";
    String tipodocnum2 ="";
    String tipodoc3 ="";
    String tipodocnum3 ="";
    
    
    int combo = 0;
    int comb1 = 0;
    int comb2 = 0;
    int comb3 = 0;
    int comboaEstado = 0;
    int select = 0;
    int valorCombo = 0;
    int valorComb1 = 0;
    int valorComb2 = 0;
    int valorComb3 = 0;
    boolean codigoSCB;

    Label lberror2;
    Label lberror3;
    Label lberror4;
    Label lberror6;
    Label lberror7;
    Label lberror8;
    Label lberror10;
    Label lberror12;
    Label lberror9;
    Label lberror5;
    Label lberror11;
    Label lberrorcmbR1 = new Label(); //Label Error Combo tipo documento representante 1
    Label lberrorcmbR2 = new Label(); //Label Error Combo tipo documento representante 2
    Label lberrorcmbR3 = new Label(); //Label Error Combo tipo documento representante 3
    Label lberrortxtR1 = new Label();// Label Error Combo numero documento representante 1
    Label lberrortxtR2 = new Label();// Label Error Combo numero documento representante 2
    Label lberrortxtR3 = new Label();// Label Error Combo numero documento representante 3

    Label lbl_asteriscotipodocr1 = new Label("*"); //Label asterisco tipo documento representante 1
    Label lbl_asterisconumdocr1 = new Label("*"); //Label asterisco numero documento representante 1
    Label lbl_asteriscotipodocr2 = new Label("*"); //Label asterisco tipo documento representante legal 2
    Label lbl_asterisconumdocr2 = new Label("*"); //Label asterisco numero documento representante 2
    Label lbl_asteriscotipodocr3 = new Label("*"); //Label asterisco tipo documento representante legal 3
    Label lbl_asterisconumdocr3 = new Label("*"); //Label asterisco numero documento representante 3

    Label error = new Label("");

    public MantenedorScb(GenericTab parentTab) {
        super(parentTab);
    }

    @Override
    public void initForm() {

        Panel panelFiltros = new Panel("");
        Panel panelTabla = new Panel("");
        Panel panelPaginacion = new Panel("");

        panelTabla.setSizeFull();
        panelTabla.setWidth(100, Sizeable.Unit.PERCENTAGE);

//        panelFiltros.setWidth("98px");
//        panelFiltros.setHeight("75px");
        HorizontalLayout horizontal = new HorizontalLayout();
        HorizontalLayout HL = new HorizontalLayout();
        HorizontalLayout hrz = new HorizontalLayout();
        HL.setSpacing(true);
        hrz.setSpacing(true);

        GridLayout grid = new GridLayout(3, 1);
        grid.setSpacing(true);
        gridFiltros.setSpacing(true);


        /*Tabla Mantenedor Scb*/
        ic = new IndexedContainer();
        ic.addContainerProperty("Código SCB/Entidad", String.class, null);
        ic.addContainerProperty("SCB/Entidad", String.class, null);
        ic.addContainerProperty("Tipo Documento", String.class, null);
        ic.addContainerProperty("Número de Documento", String.class, null);
        ic.addContainerProperty("Dígito de Verificación", String.class, null);
        ic.addContainerProperty("Dirección", String.class, null);
        ic.addContainerProperty("Teléfono", String.class, null);
        ic.addContainerProperty("Representante Legal 1", String.class, null);
        ic.addContainerProperty("Tipo Documento 1", String.class, null);
        ic.addContainerProperty("Número de Documento 1", String.class, null);
        ic.addContainerProperty("Representante Legal 2", String.class, null);
        ic.addContainerProperty("Tipo Documento 2", String.class, null);
        ic.addContainerProperty("Número de Documento 2", String.class, null);
        ic.addContainerProperty("Representante Legal 3", String.class, null);
        ic.addContainerProperty("Tipo Documento 3", String.class, null);
        ic.addContainerProperty("Número de Documento 3", String.class, null);
        ic.addContainerProperty("Estado", String.class, null);

        VerticalLayout vl = new VerticalLayout();
        btnuevo = new Button("Nuevo");
        btmodificar = new Button("Modificar");
//        btexportar = new Button("Exportar");        

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
         * *****Código SCB/Entidad*******************************
         */
        Label lbCodigoScbFiltros = new Label("Código SCB/Entidad");
        gridFiltros.addComponent(lbCodigoScbFiltros, 0, 0);
        //gridFiltros.setComponentAlignment(lbfechFinOperacion, Alignment.MIDDLE_CENTER); 

        txtCodigoScbFiltros = new TextField();
        gridFiltros.addComponent(txtCodigoScbFiltros, 1, 0);
        //gridFiltros.setComponentAlignment(txtCodigoScbFiltros, Alignment.MIDDLE_CENTER);
        txtCodigoScbFiltros.setWidth(15, Sizeable.Unit.EM);
        txtCodigoScbFiltros.setHeight(2, Sizeable.Unit.EM);

        /**
         * **********************SCB/Entidad*******
         */
        Label lbScbEntidadFiltros = new Label("SCB/Entidad");
        gridFiltros.addComponent(lbScbEntidadFiltros, 2, 0);
        //gridFiltros.setComponentAlignment(lbfechFinOperacion, Alignment.MIDDLE_CENTER); 

        txtScbEntidadFiltros = new TextField();
        gridFiltros.addComponent(txtScbEntidadFiltros, 3, 0);
        //gridFiltros.setComponentAlignment(txtCodigoScbFiltros, Alignment.MIDDLE_CENTER);
        txtScbEntidadFiltros.setWidth(15, Sizeable.Unit.EM);
        txtScbEntidadFiltros.setHeight(2, Sizeable.Unit.EM);

        /**
         * **********************Estado*******
         */
        Label lbEstado = new Label("Estado");
        gridFiltros.addComponent(lbEstado, 4, 0);
        //gridFiltros.setComponentAlignment(lbfechFinOperacion, Alignment.MIDDLE_CENTER); 

        cbxEstadoFiltro = new ComboBox();
        gridFiltros.addComponent(cbxEstadoFiltro, 5, 0);
        //gridFiltros.setComponentAlignment(txtCodigoScbFiltros, Alignment.MIDDLE_CENTER);
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

        tabla = new PagedTableCustomscb("");
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
                crearSCB();
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
                    modificarSCB();
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
                excelExport.setReportTitle("Reporte de Mantenedor SCB");
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

    private void cargarTablaMantenedor() {
        List<List<String>> listSCB;
        listSCB = scb.Listarscb();
        int i;

        tabla.getContainerDataSource().removeAllItems();
        if (listSCB.get(0).size() != 0) {
            for (i = 0; i < listSCB.get(0).size(); i++) {

                String estado = "";
                if (listSCB.get(16).get(i).equals("1")) {
                    estado = "Activo";
                } else if (listSCB.get(16).get(i).equals("2")) {
                    estado = "Inactivo";
                }
                String codigo = "";

                
                
                codigo = (listSCB.get(17).get(i));
                if (codigo.length() == 2) {
                    String cerouno = "0";
                    codigo = cerouno.concat(codigo);
                } else if (codigo.length() == 1) {
                    String cerodos = "00";
                    codigo = cerodos.concat(codigo);
                }

                
                
                Item item = ic.addItem(i);
                item.getItemProperty("Código SCB/Entidad").setValue(codigo);
                item.getItemProperty("SCB/Entidad").setValue(listSCB.get(3).get(i));
                item.getItemProperty("Tipo Documento").setValue(listSCB.get(2).get(i));
                item.getItemProperty("Número de Documento").setValue(listSCB.get(1).get(i));
                item.getItemProperty("Dígito de Verificación").setValue(listSCB.get(15).get(i));
                item.getItemProperty("Dirección").setValue(listSCB.get(6).get(i));
                item.getItemProperty("Teléfono").setValue(listSCB.get(7).get(i));
                item.getItemProperty("Representante Legal 1").setValue(listSCB.get(5).get(i));
                item.getItemProperty("Representante Legal 2").setValue(listSCB.get(13).get(i));
                item.getItemProperty("Representante Legal 3").setValue(listSCB.get(14).get(i));
                item.getItemProperty("Estado").setValue(estado);
                item.getItemProperty("Tipo Documento 1").setValue(listSCB.get(18).get(i));
                item.getItemProperty("Número de Documento 1").setValue(listSCB.get(19).get(i));
                item.getItemProperty("Tipo Documento 2").setValue(listSCB.get(20).get(i));
                item.getItemProperty("Número de Documento 2").setValue(listSCB.get(21).get(i));
                item.getItemProperty("Tipo Documento 3").setValue(listSCB.get(22).get(i));
                item.getItemProperty("Número de Documento 3").setValue(listSCB.get(23).get(i));
                
            }
        }
        editarTabla();
        tabla.setContainerDataSource(ic);
        tabla.setImmediate(true);
    }

    private void limpiarCampos() {
        txtCodigoScbFiltros.setValue("");
        txtScbEntidadFiltros.setValue("");
        cbxEstadoFiltro.select("");
    }

    private void crearSCB() {

        error.setValue("");

        subWindow = new Window("Mantenedor SCB/Entidad");
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
        /*Código SCB/Entidad*/
        /**
         * **********************************************
         */
        Label lbCodigoScb = new Label("Código SCB/Entidad");
        grid.addComponent(lbCodigoScb, 0, 0);
        grid.setComponentAlignment(lbCodigoScb, Alignment.MIDDLE_CENTER);
        lbCodigoScb.setWidth(11, Sizeable.Unit.EM);
        lbCodigoScb.setHeight(2, Sizeable.Unit.EM);

        Label lbasteris2 = new Label("*");
        lbasteris2.setStyleName("asterix");
        grid.addComponent(lbasteris2, 1, 0);
        grid.setComponentAlignment(lbasteris2, Alignment.MIDDLE_CENTER);
        lbasteris2.setWidth(5, Sizeable.Unit.EM);
        lbasteris2.setHeight(2, Sizeable.Unit.EM);

        txtCodigoScb = new TextField();
        grid.addComponent(txtCodigoScb, 2, 0);
        grid.setComponentAlignment(txtCodigoScb, Alignment.MIDDLE_CENTER);
        txtCodigoScb.setWidth(15, Sizeable.Unit.EM);
        txtCodigoScb.setHeight(2, Sizeable.Unit.EM);
        txtCodigoScb.setMaxLength(3);

        lberror2 = new Label();
        lberror2.setStyleName("lblerrorestop");
        grid.addComponent(lberror2, 2, 1);
        grid.setComponentAlignment(lberror2, Alignment.BOTTOM_CENTER);
        lberror2.setWidth(18, Sizeable.Unit.EM);
        lberror2.setHeight(2, Sizeable.Unit.EM);

        txtCodigoScb.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {
                codigoSCB = scb.ValidarCodigoSCB(txtCodigoScb.getValue());
                if (txtCodigoScb.getValue().equals("")) {
                    txtCodigoScb.setComponentError(new UserError(""));
                    lberror2.setValue("Este campo es requerido");
                } else if (!txtCodigoScb.getValue().matches(regexNumeric)) {
                    txtCodigoScb.setComponentError(new UserError(""));
                    lberror2.setValue("Este campo contiene caracteres no válidos");
                } else if (txtCodigoScb.getValue().length() < 3) {
                    txtCodigoScb.setComponentError(new UserError(""));
                    lberror2.setValue("Información faltante");
                } else if (codigoSCB) {
                    txtCodigoScb.setComponentError(new UserError(""));
                    lberror2.setValue("Código SCB/Entidad ya existe");
                } else {
                    txtCodigoScb.setComponentError(null);
                    lberror2.setValue("");
                }
                ValidarError();
            }
        });

        /**
         * **********************************************
         */
        /*SCB/Entidad*/
        /**
         * **********************************************
         */
        Label lbscbEntidad = new Label("SCB/Entidad");
        grid.addComponent(lbscbEntidad, 4, 0);
        grid.setComponentAlignment(lbscbEntidad, Alignment.MIDDLE_RIGHT);
        lbscbEntidad.setWidth(11, Sizeable.Unit.EM);
        lbscbEntidad.setHeight(2, Sizeable.Unit.EM);

        Label lbasteris6 = new Label("*");
        lbasteris6.setStyleName("asterix");
        grid.addComponent(lbasteris6, 5, 0);
        grid.setComponentAlignment(lbasteris6, Alignment.MIDDLE_CENTER);
        lbasteris6.setWidth(5, Sizeable.Unit.EM);
        lbasteris6.setHeight(2, Sizeable.Unit.EM);

        txtscbEntidad = new TextField();
        grid.addComponent(txtscbEntidad, 6, 0);
        grid.setComponentAlignment(txtscbEntidad, Alignment.MIDDLE_CENTER);
        txtscbEntidad.setWidth(15, Sizeable.Unit.EM);
        txtscbEntidad.setHeight(2, Sizeable.Unit.EM);
        txtscbEntidad.setMaxLength(50);

        lberror7 = new Label();
        lberror7.setStyleName("lblerrorestop");
        grid.addComponent(lberror7, 6, 1);
        grid.setComponentAlignment(lberror7, Alignment.BOTTOM_CENTER);
        lberror7.setWidth(18, Sizeable.Unit.EM);
        lberror7.setHeight(2, Sizeable.Unit.EM);

        txtscbEntidad.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (txtscbEntidad.getValue().equals("")) {
                    txtscbEntidad.setComponentError(new UserError(""));
                    lberror7.setValue("Este campo es requerido");
                } else if (!txtscbEntidad.getValue().matches(regexAlpha)) {
                    txtscbEntidad.setComponentError(new UserError(""));
                    lberror7.setValue("Este campo contiene caracteres no válidos");
                } else {
                    txtscbEntidad.setComponentError(null);
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
        cbxtipDocumento = LlenarTipoDocumentos();
        if (tipDocumento.equals("Cédula de Ciudadanía")) {
            cbxtipDocumento.select(1);
        } else if (tipDocumento.equals("Cédula de Extranjería")) {
            cbxtipDocumento.select(2);
        } else if (tipDocumento.equals("Pasaporte")) {
            cbxtipDocumento.select(3);
        } else if (tipDocumento.equals("NIT")) {
            cbxtipDocumento.select(4);
        } else if (tipDocumento.equals("NIP o NUIP")) {
            cbxtipDocumento.select(5);
        } else if (tipDocumento.equals("Tarjeta de Identidad")) {
            cbxtipDocumento.select(6);
        }

        cbxtipDocumento = LlenarTipoDocumento();
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
                    valorCombo = 0;
                } catch (ClassCastException ex) {
                    valorCombo = 0;
                }
                txtDigitoverificacion.setVisible(false);
                txtDigitoverificacion.setComponentError(null);
                txtDigitoverificacion.setValue("");
                lberror12.setValue("");
                txtnumeroDoc.setComponentError(null);
                lberror8.setValue("");

                if (valorCombo == 4) {
                    txtDigitoverificacion.setVisible(true);
                    txtDigitoverificacion.setEnabled(true);
                } else {
                    txtDigitoverificacion.setVisible(false);
                    txtDigitoverificacion.setComponentError(null);
                    txtDigitoverificacion.setValue("");
                    lberror12.setValue("");
                }
                if (cbxtipDocumento.getValue() == null || cbxtipDocumento.getValue().equals("")) {
                    cbxtipDocumento.setComponentError(new UserError(""));
                    lberror3.setValue("Este campo es requerido");
                }

                if (valorCombo == 2 || valorCombo == 3 || valorCombo == 5) {
                    if (!txtnumeroDoc.getValue().matches(regexAlphaParen2)) {
                        txtnumeroDoc.setComponentError(new UserError(""));
                        lberror8.setValue("Este campo contiene caracteres no válidos");
                    }
                } else if (!txtnumeroDoc.getValue().matches(regexNumeric)) {
                    txtnumeroDoc.setComponentError(new UserError(""));
                    lberror8.setValue("Este campo contiene caracteres no válidos");
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

                try {
                    valorCombo = (Integer) cbxtipDocumento.getValue();
                } catch (NullPointerException ex) {
                    valorCombo = 0;
                } catch (ClassCastException e) {
                    valorCombo = 0;
                }
                txtnumeroDoc.setComponentError(null);
                lberror8.setValue("");
                if (txtnumeroDoc.getValue().equals("")) {
                    txtnumeroDoc.setComponentError(new UserError(""));
                    lberror8.setValue("Este campo es requerido");
                }

                if (valorCombo == 2 || valorCombo == 3 || valorCombo == 5) {
                    if (!txtnumeroDoc.getValue().matches(regexAlphaParen2)) {
                        txtnumeroDoc.setComponentError(new UserError(""));
                        lberror8.setValue("Este campo contiene caracteres no válidos");
                    }
                } else if (!txtnumeroDoc.getValue().matches(regexNumeric)) {
                    txtnumeroDoc.setComponentError(new UserError(""));
                    lberror8.setValue("Este campo contiene caracteres no válidos");
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
        txtDigitoverificacion.setVisible(false);
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
                valorCombo = Integer.parseInt(cbxtipDocumento.getValue().toString());

                if (!txtDigitoverificacion.getValue().equals("")) {
                    if (valorCombo == 2 || valorCombo == 3 || valorCombo == 5) {
                        if (!txtDigitoverificacion.getValue().matches(regexAlphaParen2)) {
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
                    } else if (!txtDigitoverificacion.getValue().matches(regexNumeric)) {
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
        /*Direccion*/
        /**
         * **********************************************
         */
        Label lbDireccion = new Label("Dirección");
        grid.addComponent(lbDireccion, 0, 4);
        grid.setComponentAlignment(lbDireccion, Alignment.MIDDLE_CENTER);
        lbDireccion.setWidth(11, Sizeable.Unit.EM);
        lbDireccion.setHeight(2, Sizeable.Unit.EM);

        txtDireccion = new TextField();
        grid.addComponent(txtDireccion, 2, 4);
        grid.setComponentAlignment(txtDireccion, Alignment.MIDDLE_CENTER);
        txtDireccion.setWidth(15, Sizeable.Unit.EM);
        txtDireccion.setHeight(2, Sizeable.Unit.EM);
        txtDireccion.setMaxLength(50);

        lberror4 = new Label();
        lberror4.setStyleName("lblerrorestop");
        grid.addComponent(lberror4, 2, 5);
        grid.setComponentAlignment(lberror4, Alignment.BOTTOM_CENTER);
        lberror4.setWidth(18, Sizeable.Unit.EM);
        lberror4.setHeight(2, Sizeable.Unit.EM);

        txtDireccion.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!txtDireccion.getValue().matches(regexAlphaNum)) {
                    txtDireccion.setComponentError(new UserError(""));
                    lberror4.setValue("Este campo contiene caracteres no válidos");
                } else {
                    txtDireccion.setComponentError(null);
                    lberror4.setValue("");
                }
                ValidarError();
            }
        });

        /**
         * **********************************************
         */
        /*Telefono*/
        /**
         * **********************************************
         */
        Label lbTelefono = new Label("Teléfono");
        grid.addComponent(lbTelefono, 4, 4);
        grid.setComponentAlignment(lbTelefono, Alignment.MIDDLE_RIGHT);
        lbTelefono.setWidth(11, Sizeable.Unit.EM);
        lbTelefono.setHeight(2, Sizeable.Unit.EM);

        Label lbasteris8 = new Label("*");
        lbasteris8.setStyleName("asterix");
        grid.addComponent(lbasteris8, 5, 4);
        grid.setComponentAlignment(lbasteris8, Alignment.MIDDLE_CENTER);
        lbasteris8.setWidth(5, Sizeable.Unit.EM);
        lbasteris8.setHeight(2, Sizeable.Unit.EM);

        txtTelefono = new TextField();
        grid.addComponent(txtTelefono, 6, 4);
        grid.setComponentAlignment(txtTelefono, Alignment.MIDDLE_CENTER);
        txtTelefono.setWidth(15, Sizeable.Unit.EM);
        txtTelefono.setHeight(2, Sizeable.Unit.EM);
        txtTelefono.setMaxLength(10);

        lberror9 = new Label();
        lberror9.setStyleName("lblerrorestop");
        grid.addComponent(lberror9, 6, 5);
        grid.setComponentAlignment(lberror9, Alignment.BOTTOM_CENTER);
        lberror9.setWidth(18, Sizeable.Unit.EM);
        lberror9.setHeight(2, Sizeable.Unit.EM);

        txtTelefono.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (txtTelefono.getValue().equals("")) {
                    txtTelefono.setComponentError(new UserError(""));
                    lberror9.setValue("Este campo es requerido");
                } else if (!txtTelefono.getValue().matches(regexAlphaParen)) {
                    txtTelefono.setComponentError(new UserError(""));
                    lberror9.setValue("Este campo contiene caracteres no válidos");
                } else if (txtTelefono.getValue().length() < 7) {
                    txtTelefono.setComponentError(new UserError(""));
                    lberror9.setValue("Longitud no válida");
                } else {
                    txtTelefono.setComponentError(null);
                    lberror9.setValue("");
                }
                ValidarError();
            }
        });

        /**
         * **********************************************
         */
        /*Representante Legal 1*/
        /**
         * **********************************************
         */
        Label lbRepresentanteLeg1 = new Label("Representante Legal 1");
        grid.addComponent(lbRepresentanteLeg1, 0, 6);
        grid.setComponentAlignment(lbRepresentanteLeg1, Alignment.MIDDLE_CENTER);
        lbRepresentanteLeg1.setWidth(11, Sizeable.Unit.EM);
        lbRepresentanteLeg1.setHeight(2, Sizeable.Unit.EM);

        Label lbasteris5 = new Label("*");
        lbasteris5.setStyleName("asterix");
        grid.addComponent(lbasteris5, 1, 6);
        grid.setComponentAlignment(lbasteris5, Alignment.MIDDLE_CENTER);
        lbasteris5.setWidth(5, Sizeable.Unit.EM);
        lbasteris5.setHeight(2, Sizeable.Unit.EM);

        txtRepresentanteLeg1 = new TextField();
        grid.addComponent(txtRepresentanteLeg1, 2, 6);
        grid.setComponentAlignment(txtRepresentanteLeg1, Alignment.MIDDLE_CENTER);
        txtRepresentanteLeg1.setWidth(15, Sizeable.Unit.EM);
        txtRepresentanteLeg1.setHeight(2, Sizeable.Unit.EM);
        txtRepresentanteLeg1.setMaxLength(50);

        lberror5 = new Label();
        lberror5.setStyleName("lblerrorestop");
        grid.addComponent(lberror5, 2, 7);
        grid.setComponentAlignment(lberror5, Alignment.BOTTOM_CENTER);
        lberror5.setWidth(18, Sizeable.Unit.EM);
        lberror5.setHeight(2, Sizeable.Unit.EM);

        txtRepresentanteLeg1.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (txtRepresentanteLeg1.getValue().equals("")) {
                    txtRepresentanteLeg1.setComponentError(new UserError(""));
                    lberror5.setValue("Este campo es requerido");
                } else if (!txtRepresentanteLeg1.getValue().matches(regexLetrasTildes)) {
                    txtRepresentanteLeg1.setComponentError(new UserError(""));
                    lberror5.setValue("Este campo contiene caracteres no válidos");
                } else {
                    txtRepresentanteLeg1.setComponentError(null);
                    lberror5.setValue("");
                }
                ValidarError();
            }
        });

        /**
         * **********************************************
         */
        /*Tipo de Documento representante 1*/
        /**
         * **********************************************
         */
        Label lbtipDocumentor1 = new Label("Tipo Documento");
        grid.addComponent(lbtipDocumentor1, 4, 6);
        grid.setComponentAlignment(lbtipDocumentor1, Alignment.MIDDLE_CENTER);
        lbtipDocumentor1.setWidth(11, Sizeable.Unit.EM);
        lbtipDocumentor1.setHeight(2, Sizeable.Unit.EM);

        lbl_asteriscotipodocr1.setStyleName("asterix");
        grid.addComponent(lbl_asteriscotipodocr1, 5, 6);
        grid.setComponentAlignment(lbl_asteriscotipodocr1, Alignment.MIDDLE_LEFT);
        lbl_asteriscotipodocr1.setWidth(5, Sizeable.Unit.EM);
        lbl_asteriscotipodocr1.setHeight(2, Sizeable.Unit.EM);

        cbxtipDocumentoR1 = LlenarTipoDocr1();
        grid.addComponent(cbxtipDocumentoR1, 6, 6);
        grid.setComponentAlignment(cbxtipDocumentoR1, Alignment.MIDDLE_CENTER);
        cbxtipDocumentoR1.setWidth(15, Sizeable.Unit.EM);
        cbxtipDocumentoR1.setHeight(3, Sizeable.Unit.EM);

        lberrorcmbR1.setStyleName("lblerrorestop");
        grid.addComponent(lberrorcmbR1, 6, 7);
        grid.setComponentAlignment(lberrorcmbR1, Alignment.BOTTOM_CENTER);
        lberrorcmbR1.setWidth(18, Sizeable.Unit.EM);
        lberrorcmbR1.setHeight(2, Sizeable.Unit.EM);

        cbxtipDocumentoR1.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (cbxtipDocumentoR1.getValue() == null || cbxtipDocumentoR1.getValue().equals("")) {
                    cbxtipDocumentoR1.setComponentError(new UserError(""));
                    lberrorcmbR1.setValue("Este campo es requerido");
                } else {
                    cbxtipDocumentoR1.setComponentError(null);
                    lberrorcmbR1.setValue("");
                }
                ValidarError();
            }
        });

        cbxtipDocumentoR1.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {

                try {
                    valorComb1 = (Integer) cbxtipDocumentoR1.getValue();
                } catch (NullPointerException e) {
                    valorComb1 = 0;
                } catch (ClassCastException ex) {
                    valorComb1 = 0;
                }
                txtnumeroDocR1.setComponentError(null);
                lberrortxtR1.setValue("");


                if (valorComb1 == 2 || valorComb1 == 3 || valorComb1 == 5) {
                    if (!txtnumeroDocR1.getValue().matches(regexAlphaParen2)) {
                        txtnumeroDocR1.setComponentError(new UserError(""));
                        lberrortxtR1.setValue("Este campo contiene caracteres no válidos");
                    }
                } else if (!txtnumeroDocR1.getValue().matches(regexNumeric)) {
                    txtnumeroDocR1.setComponentError(new UserError(""));
                    lberrortxtR1.setValue("Este campo contiene caracteres no válidos");
                }
                ValidarError();
            }
        });

        /**
         * **********************************************
         */
        /*Número documento Representante Legal 1*/
        /**
         * **********************************************
         */
        Label lbnumeroDocr1 = new Label("Número de Documento");
        grid.addComponent(lbnumeroDocr1, 0, 8);
        grid.setComponentAlignment(lbnumeroDocr1, Alignment.MIDDLE_RIGHT);
        lbnumeroDocr1.setWidth(11, Sizeable.Unit.EM);
        lbnumeroDocr1.setHeight(2, Sizeable.Unit.EM);

        lbl_asterisconumdocr1.setStyleName("asterix");
        grid.addComponent(lbl_asterisconumdocr1, 1, 8);
        grid.setComponentAlignment(lbl_asterisconumdocr1, Alignment.MIDDLE_CENTER);
        lbl_asterisconumdocr1.setWidth(5, Sizeable.Unit.EM);
        lbl_asterisconumdocr1.setHeight(2, Sizeable.Unit.EM);

        txtnumeroDocR1 = new TextField();
        grid.addComponent(txtnumeroDocR1, 2, 8);
        grid.setComponentAlignment(txtnumeroDocR1, Alignment.MIDDLE_CENTER);
        txtnumeroDocR1.setWidth(15, Sizeable.Unit.EM);
        txtnumeroDocR1.setHeight(2, Sizeable.Unit.EM);
        txtnumeroDocR1.setMaxLength(15);

        lberrortxtR1.setStyleName("lblerrorestop");
        grid.addComponent(lberrortxtR1, 2, 9);
        grid.setComponentAlignment(lberrortxtR1, Alignment.BOTTOM_CENTER);
        lberrortxtR1.setWidth(18, Sizeable.Unit.EM);
        lberrortxtR1.setHeight(2, Sizeable.Unit.EM);

        txtnumeroDocR1.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                try {
                    valorComb1 = (Integer) cbxtipDocumentoR1.getValue();
                } catch (NullPointerException ex) {
                    valorComb1 = 0;
                } catch (ClassCastException e) {
                    valorComb1 = 0;
                }
                txtnumeroDocR1.setComponentError(null);
                lberrortxtR1.setValue("");
                if (txtnumeroDocR1.getValue().equals("")) {
                    txtnumeroDocR1.setComponentError(new UserError(""));
                    lberrortxtR1.setValue("Este campo es requerido");
                }

                if (valorComb1 == 2 || valorComb1 == 3 || valorComb1 == 5) {
                    if (!txtnumeroDocR1.getValue().matches(regexAlphaParen2)) {
                        txtnumeroDocR1.setComponentError(new UserError(""));
                        lberrortxtR1.setValue("Este campo contiene caracteres no válidos");
                    }
                } else if (!txtnumeroDocR1.getValue().matches(regexNumeric)) {
                    txtnumeroDocR1.setComponentError(new UserError(""));
                    lberrortxtR1.setValue("Este campo contiene caracteres no válidos");
                }

                ValidarError();

            }
        });

        /**
         * **********************************************
         */
        /*Representante Legal 2                        */
        /**
         * **********************************************
         */
        Label lbRepresentanteLeg2 = new Label("Representante Legal 2");
        grid.addComponent(lbRepresentanteLeg2, 0, 10);
        grid.setComponentAlignment(lbRepresentanteLeg2, Alignment.MIDDLE_RIGHT);
        lbRepresentanteLeg2.setWidth(11, Sizeable.Unit.EM);
        lbRepresentanteLeg2.setHeight(2, Sizeable.Unit.EM);

        txtRepresentanteLeg2 = new TextField();
        grid.addComponent(txtRepresentanteLeg2, 2, 10);
        grid.setComponentAlignment(txtRepresentanteLeg2, Alignment.MIDDLE_CENTER);
        txtRepresentanteLeg2.setWidth(15, Sizeable.Unit.EM);
        txtRepresentanteLeg2.setHeight(2, Sizeable.Unit.EM);
        txtRepresentanteLeg2.setMaxLength(50);

        lberror10 = new Label();
        lberror10.setStyleName("lblerrorestop");
        grid.addComponent(lberror10, 2, 11);
        grid.setComponentAlignment(lberror10, Alignment.BOTTOM_CENTER);
        lberror10.setWidth(18, Sizeable.Unit.EM);
        lberror10.setHeight(2, Sizeable.Unit.EM);

        txtRepresentanteLeg2.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!txtRepresentanteLeg2.getValue().matches(regexLetrasTildes)) {
                    txtRepresentanteLeg2.setComponentError(new UserError(""));
                    lberror10.setValue("Este campo contiene caracteres no válidos");
                } else {
                    if (txtRepresentanteLeg2.isEmpty()){
                        txtRepresentanteLeg2.setComponentError(null);
                        lberror10.setValue("");  
                        txtnumeroDocR2.setComponentError(null);
                        lberrortxtR2.setValue("");
                        cbxtipDocumentoR2.setComponentError(null);
                        lberrorcmbR2.setValue(""); 
                        cbxtipDocumentoR2.setItemCaption("", "Seleccione");
                        cbxtipDocumentoR2.select("");
                        txtnumeroDocR2.setValue("");
                    }else{
                        txtRepresentanteLeg2.setComponentError(null);
                        lberror10.setValue("");  
                    }
                }
                ValidarError();
            }
        });

        /**
         * **********************************************
         */
        /*Tipo de Documento representante 2            */
        /**
         * **********************************************
         */
        Label lbtipDocumentor2 = new Label("Tipo Documento");
        grid.addComponent(lbtipDocumentor2, 4, 10);
        grid.setComponentAlignment(lbtipDocumentor2, Alignment.MIDDLE_CENTER);
        lbtipDocumentor2.setWidth(11, Sizeable.Unit.EM);
        lbtipDocumentor2.setHeight(2, Sizeable.Unit.EM);

        cbxtipDocumentoR2 = LlenarTipoDocr2();
        grid.addComponent(cbxtipDocumentoR2, 6, 10);
        grid.setComponentAlignment(cbxtipDocumentoR2, Alignment.MIDDLE_CENTER);
        cbxtipDocumentoR2.setWidth(15, Sizeable.Unit.EM);
        cbxtipDocumentoR2.setHeight(3, Sizeable.Unit.EM);

        lberrorcmbR2.setStyleName("lblerrorestop");
        grid.addComponent(lberrorcmbR2, 6, 11);
        grid.setComponentAlignment(lberrorcmbR2, Alignment.BOTTOM_CENTER);
        lberrorcmbR2.setWidth(18, Sizeable.Unit.EM);
        lberrorcmbR2.setHeight(2, Sizeable.Unit.EM);

        cbxtipDocumentoR2.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!txtRepresentanteLeg2.getValue().isEmpty()) {

                    if (cbxtipDocumentoR2.getValue() == null || cbxtipDocumentoR2.getValue().equals("")) {
                        cbxtipDocumentoR2.setComponentError(new UserError(""));
                        lberrorcmbR2.setValue("Este campo es requerido");
                    } else {
                        if (txtRepresentanteLeg2.isEmpty()){
                            txtRepresentanteLeg2.setComponentError(null);
                            lberror10.setValue("");  
                            txtnumeroDocR2.setComponentError(null);
                            lberrortxtR2.setValue("");
                            cbxtipDocumentoR2.setComponentError(null);
                            lberrorcmbR2.setValue(""); 
                            cbxtipDocumentoR2.setItemCaption("", "Seleccione");
                            cbxtipDocumentoR2.select("");
                            txtnumeroDocR2.setValue("");
                        }else{
                            cbxtipDocumentoR2.setComponentError(null);
                            lberrorcmbR2.setValue("");  
                        }                                                                                               
                    }  
                }
                     ValidarError();
            }
        });

        cbxtipDocumentoR2.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {

                if (!txtRepresentanteLeg2.getValue().isEmpty()) {
                    try {
                        valorComb2 = (Integer) cbxtipDocumentoR2.getValue();
                    } catch (NullPointerException e) {
                        valorComb2 = 0;
                    } catch (ClassCastException ex) {
                        valorComb2 = 0;
                    }
                    txtnumeroDocR2.setComponentError(null);
                    lberrortxtR2.setValue("");
                    
                    cbxtipDocumentoR2.setComponentError(null);
                    lberrorcmbR2.setValue("");

                    if (cbxtipDocumentoR2.getValue() == null || cbxtipDocumentoR2.getValue().equals("")) {
                        cbxtipDocumentoR2.setComponentError(new UserError(""));
                        lberrorcmbR2.setValue("Este campo es requerido");
                    }

                    if (valorComb2 == 2 || valorComb2 == 3 || valorComb2 == 5) {
                        if (!txtnumeroDocR2.getValue().matches(regexAlphaParen2)) {
                            txtnumeroDocR2.setComponentError(new UserError(""));
                            lberrortxtR2.setValue("Este campo contiene caracteres no válidos");
                        }
                    } else if (!txtnumeroDocR2.getValue().matches(regexNumeric)) {
                        txtnumeroDocR2.setComponentError(new UserError(""));
                        lberrortxtR2.setValue("Este campo contiene caracteres no válidos");
                    }
                
                }else{
                        txtRepresentanteLeg2.setComponentError(null);
                        lberror10.setValue("");  
                        txtnumeroDocR2.setComponentError(null);
                        lberrortxtR2.setValue("");
                        cbxtipDocumentoR2.setComponentError(null);
                        lberrorcmbR2.setValue(""); 
                        cbxtipDocumentoR2.setItemCaption("", "Seleccione");
                        cbxtipDocumentoR2.select("");
                        txtnumeroDocR2.setValue("");
                }
                ValidarError();

            }
        });

        /**
         * **********************************************
         */
        /*Número documento Representante Legal 2       */
        /**
         * **********************************************
         */
        Label lbnumeroDocr2 = new Label("Número de Documento");
        grid.addComponent(lbnumeroDocr2, 0, 12);
        grid.setComponentAlignment(lbnumeroDocr2, Alignment.MIDDLE_RIGHT);
        lbnumeroDocr2.setWidth(11, Sizeable.Unit.EM);
        lbnumeroDocr2.setHeight(2, Sizeable.Unit.EM);

        txtnumeroDocR2 = new TextField();
        grid.addComponent(txtnumeroDocR2, 2, 12);
        grid.setComponentAlignment(txtnumeroDocR2, Alignment.MIDDLE_CENTER);
        txtnumeroDocR2.setWidth(15, Sizeable.Unit.EM);
        txtnumeroDocR2.setHeight(2, Sizeable.Unit.EM);
        txtnumeroDocR2.setMaxLength(15);

        lberrortxtR2.setStyleName("lblerrorestop");
        grid.addComponent(lberrortxtR2, 2, 13);
        grid.setComponentAlignment(lberrortxtR2, Alignment.BOTTOM_CENTER);
        lberrortxtR2.setWidth(18, Sizeable.Unit.EM);
        lberrortxtR2.setHeight(2, Sizeable.Unit.EM);

        txtnumeroDocR2.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!txtRepresentanteLeg2.getValue().isEmpty()) {
                    try {
                        valorComb2 = (Integer) cbxtipDocumentoR2.getValue();
                    } catch (NullPointerException ex) {
                        valorComb2 = 0;
                    } catch (ClassCastException e) {
                        valorComb2 = 0;
                    }
                    txtnumeroDocR2.setComponentError(null);
                    lberrortxtR2.setValue("");
                    if (txtnumeroDocR2.getValue().equals("")) {
                        txtnumeroDocR2.setComponentError(new UserError(""));
                        lberrortxtR2.setValue("Este campo es requerido");
                    }

                    if (valorComb2 == 2 || valorComb2 == 3 || valorComb2 == 5) {
                        if (!txtnumeroDocR2.getValue().matches(regexAlphaParen2)) {
                            txtnumeroDocR2.setComponentError(new UserError(""));
                            lberrortxtR2.setValue("Este campo  contiene caracteres no válidos");
                        }
                    } else if (!txtnumeroDocR2.getValue().matches(regexNumeric)) {
                        txtnumeroDocR2.setComponentError(new UserError(""));
                        lberrortxtR2.setValue("Este campo contiene caracteres no válidos");
                    }

                }else{                  
                        cbxtipDocumentoR2.setValue(0);
                        txtnumeroDocR2.setValue("");
                    }ValidarError();
            }
        });
        /**
         * **********************************************
         */
        /*Representante Legal 3*/
        /**
         * **********************************************
         */
        Label lbRepresentanteLeg3 = new Label("Representante Legal 3");
        grid.addComponent(lbRepresentanteLeg3, 0, 14);
        grid.setComponentAlignment(lbRepresentanteLeg3, Alignment.MIDDLE_CENTER);
        lbRepresentanteLeg3.setWidth(11, Sizeable.Unit.EM);
        lbRepresentanteLeg3.setHeight(2, Sizeable.Unit.EM);

        txtRepresentanteLeg3 = new TextField();
        grid.addComponent(txtRepresentanteLeg3, 2, 14);
        grid.setComponentAlignment(txtRepresentanteLeg3, Alignment.MIDDLE_CENTER);
        txtRepresentanteLeg3.setWidth(15, Sizeable.Unit.EM);
        txtRepresentanteLeg3.setHeight(2, Sizeable.Unit.EM);
        txtRepresentanteLeg3.setMaxLength(50);

        lberror6 = new Label();
        lberror6.setStyleName("lblerrorestop");
        grid.addComponent(lberror6, 2, 15);
        grid.setComponentAlignment(lberror6, Alignment.BOTTOM_CENTER);
        lberror6.setWidth(18, Sizeable.Unit.EM);
        lberror6.setHeight(2, Sizeable.Unit.EM);

        txtRepresentanteLeg3.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!txtRepresentanteLeg3.getValue().matches(regexLetrasTildes)) {
                    txtRepresentanteLeg3.setComponentError(new UserError(""));
                    lberror6.setValue("Este campo contiene caracteres no válidos");
                } else {
                    if (txtRepresentanteLeg3.isEmpty()) {                    
                        txtRepresentanteLeg3.setComponentError(null);
                        lberror6.setValue("");  
                        txtnumeroDocR3.setComponentError(null);
                        lberrortxtR3.setValue("");
                        cbxtipDocumentoR3.setComponentError(null);
                        lberrorcmbR3.setValue(""); 
                        cbxtipDocumentoR3.setItemCaption("", "Seleccione");
                        cbxtipDocumentoR3.select("");
                        txtnumeroDocR3.setValue("");
                } else {
                    txtRepresentanteLeg3.setComponentError(null);
                    lberror6.setValue("");
                }
                }
                ValidarError();
            }
        });

        /**
         * **********************************************
         */
        /*Tipo de Documento representante 3            */
        /**
         * **********************************************
         */
        Label lbtipDocumentor3 = new Label("Tipo Documento");
        grid.addComponent(lbtipDocumentor3, 4, 14);
        grid.setComponentAlignment(lbtipDocumentor3, Alignment.MIDDLE_CENTER);
        lbtipDocumentor3.setWidth(11, Sizeable.Unit.EM);
        lbtipDocumentor3.setHeight(2, Sizeable.Unit.EM);
        
        cbxtipDocumentoR3 = LlenarTipoDocr3();
        grid.addComponent(cbxtipDocumentoR3, 6, 14);
        grid.setComponentAlignment(cbxtipDocumentoR3, Alignment.MIDDLE_CENTER);
        cbxtipDocumentoR3.setWidth(15, Sizeable.Unit.EM);
        cbxtipDocumentoR3.setHeight(3, Sizeable.Unit.EM);

        lberrorcmbR3.setStyleName("lblerrorestop");
        grid.addComponent(lberrorcmbR3, 6, 15);
        grid.setComponentAlignment(lberrorcmbR3, Alignment.BOTTOM_CENTER);
        lberrorcmbR3.setWidth(18, Sizeable.Unit.EM);
        lberrorcmbR3.setHeight(2, Sizeable.Unit.EM);

        cbxtipDocumentoR3.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!txtRepresentanteLeg3.getValue().isEmpty()) {

                    if (cbxtipDocumentoR3.getValue() == null || cbxtipDocumentoR3.getValue().equals("")) {
                        cbxtipDocumentoR3.setComponentError(new UserError(""));
                        lberrorcmbR3.setValue("Este campo es requerido");
                    } else {
                        if (txtRepresentanteLeg3.isEmpty()){
                            txtRepresentanteLeg3.setComponentError(null);
                            lberror6.setValue("");  
                            txtnumeroDocR3.setComponentError(null);
                            lberrortxtR3.setValue("");
                            cbxtipDocumentoR3.setComponentError(null);
                            lberrorcmbR3.setValue(""); 
                            cbxtipDocumentoR3.setItemCaption("", "Seleccione");
                            cbxtipDocumentoR3.select("");
                            txtnumeroDocR3.setValue("");
                        }else{
                            cbxtipDocumentoR3.setComponentError(null);
                            lberrorcmbR3.setValue("");  
                        }

                    }
                    ValidarError();
                }
            }
        });

        cbxtipDocumentoR3.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {

                if (!txtRepresentanteLeg3.getValue().isEmpty()) {
                    try {
                        valorComb3 = (Integer) cbxtipDocumentoR3.getValue();
                    } catch (NullPointerException e) {
                        valorComb3 = 0;
                    } catch (ClassCastException ex) {
                        valorComb3 = 0;
                    }
                    txtnumeroDocR3.setComponentError(null);
                    lberrortxtR3.setValue("");
                    cbxtipDocumentoR3.setComponentError(null);
                    lberrorcmbR3.setValue("");
                    
                    if (cbxtipDocumentoR3.getValue() == null || cbxtipDocumentoR3.getValue().equals("")) {
                        cbxtipDocumentoR3.setComponentError(new UserError(""));
                        lberrorcmbR3.setValue("Este campo es requerido");
                    }

                    if (valorComb3 == 2 || valorComb3 == 3 || valorComb3 == 5) {
                        if (!txtnumeroDocR3.getValue().matches(regexAlphaParen2)) {
                            txtnumeroDocR3.setComponentError(new UserError(""));
                            lberrortxtR3.setValue("Este campo contiene caracteres no válidos");
                        }
                    } else if (!txtnumeroDocR3.getValue().matches(regexNumeric)) {
                        txtnumeroDocR3.setComponentError(new UserError(""));
                        lberrortxtR3.setValue("Este campo contiene caracteres no válidos");
                    }
                    
                }else{
                        txtRepresentanteLeg3.setComponentError(null);
                        lberror6.setValue("");  
                        txtnumeroDocR3.setComponentError(null);
                        lberrortxtR3.setValue("");
                        cbxtipDocumentoR3.setComponentError(null);
                        lberrorcmbR3.setValue(""); 
                        cbxtipDocumentoR3.setItemCaption("", "Seleccione");
                        cbxtipDocumentoR3.select("");
                        txtnumeroDocR3.setValue("");
                    
                }ValidarError();
            }
        });

        /**
         * **********************************************
         */
        /*Número documento Representante Legal 3       */
        /**
         * **********************************************
         */
        Label lbnumeroDocr3 = new Label("Número de Documento");
        grid.addComponent(lbnumeroDocr3, 0, 16);
        grid.setComponentAlignment(lbnumeroDocr3, Alignment.MIDDLE_RIGHT);
        lbnumeroDocr3.setWidth(11, Sizeable.Unit.EM);
        lbnumeroDocr3.setHeight(2, Sizeable.Unit.EM);

        txtnumeroDocR3 = new TextField();
        grid.addComponent(txtnumeroDocR3, 2, 16);
        grid.setComponentAlignment(txtnumeroDocR3, Alignment.MIDDLE_CENTER);
        txtnumeroDocR3.setWidth(15, Sizeable.Unit.EM);
        txtnumeroDocR3.setHeight(2, Sizeable.Unit.EM);
        txtnumeroDocR3.setMaxLength(15);

        lberrortxtR3.setStyleName("lblerrorestop");
        grid.addComponent(lberrortxtR3, 2, 17);
        grid.setComponentAlignment(lberrortxtR3, Alignment.BOTTOM_CENTER);
        lberrortxtR3.setWidth(18, Sizeable.Unit.EM);
        lberrortxtR3.setHeight(2, Sizeable.Unit.EM);

        txtnumeroDocR3.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!txtRepresentanteLeg3.getValue().isEmpty()) {
                    try {
                        valorComb3 = (Integer) cbxtipDocumentoR3.getValue();
                    } catch (NullPointerException ex) {
                        valorComb3 = 0;
                    } catch (ClassCastException e) {
                        valorComb3 = 0;
                    }
                    txtnumeroDocR3.setComponentError(null);
                    lberrortxtR3.setValue("");
                    if (txtnumeroDocR3.getValue().equals("")) {
                        txtnumeroDocR3.setComponentError(new UserError(""));
                        lberrortxtR3.setValue("Este campo es requerido");
                    }

                    if (valorComb3 == 2 || valorComb3 == 3 || valorComb3 == 5) {
                        if (!txtnumeroDocR3.getValue().matches(regexAlphaParen2)) {
                            txtnumeroDocR3.setComponentError(new UserError(""));
                            lberrortxtR3.setValue("Este campo  contiene caracteres no válidos");
                        }
                    } else if (!txtnumeroDocR3.getValue().matches(regexNumeric)) {
                        txtnumeroDocR3.setComponentError(new UserError(""));
                        lberrortxtR3.setValue("Este campo contiene caracteres no válidos");
                    }
                }else{                  
                        cbxtipDocumentoR3.setValue(0);
                        txtnumeroDocR3.setValue("");
                    }ValidarError();        
     
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
        grid.addComponent(lbEstado, 4, 16);
        grid.setComponentAlignment(lbEstado, Alignment.MIDDLE_RIGHT);
        lbEstado.setWidth(11, Sizeable.Unit.EM);
        lbEstado.setHeight(2, Sizeable.Unit.EM);

        Label lbasteris10 = new Label("*");
        lbasteris10.setStyleName("asterix");
        grid.addComponent(lbasteris10, 5, 16);
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
        grid.addComponent(cbxEstado, 6, 16);
        grid.setComponentAlignment(cbxEstado, Alignment.MIDDLE_CENTER);
        cbxEstado.setWidth(15, Sizeable.Unit.EM);
        cbxEstado.setHeight(2, Sizeable.Unit.EM);

        lberror11 = new Label();
        lberror11.setStyleName("lblerrorcomboBox");
        grid.addComponent(lberror11, 6, 17);
        grid.setComponentAlignment(lberror11, Alignment.BOTTOM_CENTER);
        lberror11.setWidth(18, Sizeable.Unit.EM);
        lberror11.setHeight(2, Sizeable.Unit.EM);

        cbxEstado.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                if (cbxEstado.getValue() == null || cbxEstado.getValue().equals("")) {
                    cbxEstado.setComponentError(new UserError(""));
                    lberror11.setValue("Este campo es requerido");
                } else {
                    cbxEstado.setComponentError(null);
                    lberror11.setValue("");
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
                //btnGuardar.setEnabled(false);
                if (txtCodigoScb.getValue().equals("")) {
                    txtCodigoScb.setComponentError(new UserError(""));
                    lberror2.setValue("Este campo es requerido");
                }

                if (txtscbEntidad.getValue().equals("")) {
                    txtscbEntidad.setComponentError(new UserError(""));
                    lberror7.setValue("Este campo es requerido");
                }

                try {
                    combo = (Integer) cbxtipDocumento.getValue();
                } catch (NullPointerException e) {
                    combo = 0;
                } catch (ClassCastException ex) {
                    combo = 0;
                }

                if (combo == 0) {
                    cbxtipDocumento.setComponentError(new UserError(""));
                    lberror3.setValue("Este campo es requerido");
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
                    lberror11.setValue("Este campo es requerido");
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

                if (txtTelefono.getValue().equals("")) {
                    txtTelefono.setComponentError(new UserError(""));
                    lberror9.setValue("Este campo es requerido");
                } else if (txtTelefono.getValue().length() < 7) {
                    txtTelefono.setComponentError(new UserError(""));
                    lberror9.setValue("Longitud no válida");
                }

                //representante legal 1
                if (txtRepresentanteLeg1.getValue().equals("")) {
                    txtRepresentanteLeg1.setComponentError(new UserError(""));
                    lberror5.setValue("Este campo es requerido");
                }

                try {
                    comb1 = (Integer) cbxtipDocumentoR1.getValue();
                } catch (NullPointerException e) {
                    comb1 = 0;
                } catch (ClassCastException ex) {
                    comb1 = 0;
                }

                if (comb1 == 0) {
                    cbxtipDocumentoR1.setComponentError(new UserError(""));
                    lberrorcmbR1.setValue("Este campo es requerido");
                }
                if (txtnumeroDocR1.getValue().equals("")) {
                    txtnumeroDocR1.setComponentError(new UserError(""));
                    lberrortxtR1.setValue("Este campo es requerido");
                }
                // 

                try {
                    direccion1 = txtDireccion.getValue();
                } catch (Exception ex) {
                    direccion1 = "";
                }

                // representante legal 2 
                try {
                    numtipodocr2 = txtnumeroDocR2.getValue().trim();
                } catch (Exception ex) {
                    numtipodocr2 = "";
                }
                
                try {
                    representaLe2 =  txtRepresentanteLeg2.getValue().trim();
                } catch (Exception ex) {
                    representaLe2 = "";
                }

                try {
                    comb2 = (Integer) cbxtipDocumentoR2.getValue();
                } catch (NullPointerException e) {
                    comb2 = 0;
                } catch (ClassCastException ex) {
                    comb2 = 0;
                }
                
                if (!representaLe2.equals("")) {


                    if (comb2 == 0) {
                        cbxtipDocumentoR2.setComponentError(new UserError(""));
                        lberrorcmbR2.setValue("Este campo es requerido");
                    }
                    if (txtnumeroDocR2.getValue().equals("")) {

                        txtnumeroDocR2.setComponentError(new UserError(""));
                        lberrortxtR2.setValue("Este campo es requerido");
                    }
                }
                //
                
                    //representante legal 3
                    
                    try {
                        representaLe3 = txtRepresentanteLeg3.getValue().trim();
                    } catch (Exception ex) {
                        representaLe3 = "";
                    }
                    
                    try {
                        numtipodocr3 = txtnumeroDocR3.getValue().trim();
                    } catch (Exception ex) {
                        numtipodocr3 = "";
                    }
                    
                    try {
                        comb3 = (Integer) cbxtipDocumentoR3.getValue();
                    } catch (NullPointerException e) {
                        comb3 = 0;
                    } catch (ClassCastException ex) {
                        comb3 = 0;
                    }
                    
                    if (!representaLe3.equals("")) {


                        if (comb3 == 0) {
                            cbxtipDocumentoR3.setComponentError(new UserError(""));
                            lberrorcmbR3.setValue("Este campo es requerido");
                        }
                        if (txtnumeroDocR3.getValue().equals("")) {
                            txtnumeroDocR3.setComponentError(new UserError(""));
                            lberrortxtR3.setValue("Este campo es requerido");
                        }
                    }

                try {
                    digVerificacion1 = txtDigitoverificacion.getValue();
                } catch (Exception ex) {
                    digVerificacion1 = "";
                }

                ValidarError();
                if (!ValidaComponentError()) {
                    ConfirmDialog.show(getUI(), "Confirmación", "¿Está seguro que desea incluir la SCB/Entidad?", "ACEPTAR",
                            "CANCELAR", new ConfirmDialog.Listener() {
                        @Override
                        public void onClose(ConfirmDialog dialog) {
                            if (dialog.isConfirmed()) {

                                /*Guardar sociedad comisionista de bolsa*/
                                    String resultado = scb.IngresarSCB(txtCodigoScb.getValue(), txtscbEntidad.getValue(), Integer.parseInt(cbxtipDocumento.getValue().toString()), txtnumeroDoc.getValue(), digVerificacion1, txtDireccion.getValue(), txtTelefono.getValue(), txtRepresentanteLeg1.getValue(), representaLe2, representaLe3, Integer.parseInt(cbxEstado.getValue().toString()),Integer.parseInt(cbxtipDocumentoR1.getValue().toString()),txtnumeroDocR1.getValue(), comb2,numtipodocr2,comb3,numtipodocr3);
                                                                      
                                    UI.getCurrent().removeWindow(subWindow);
                                    cargarTablaMantenedor();

                                UI.getCurrent().removeWindow(subWindow);
                                ConfirmDialog cd = ConfirmDialog.getFactory().create("Confirmación", "", "ACEPTAR", "", "");
                                cd.setWidth("380px");
                                cd.setHeight("140px");
                                HorizontalLayout texto = new HorizontalLayout();
                                HorizontalLayout buttons = new HorizontalLayout();
                                buttons.setStyleName("btnAceptar");
                                Label lblmensaje = new Label("La SCB/Entidad ha sido ingresada", ContentMode.HTML);
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

    private void modificarSCB() {
        error.setValue("");
      
        if (codigoScb.equals("")) {
            Notification.show("Por favor Seleccione un Registro", Notification.Type.ERROR_MESSAGE);
          
        } else {

            subWindow = new Window("Mantenedor SCB/Entidad");
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
            /*Código SCB/Entidad*/
            /**
             * **********************************************
             */
            Label lbCodigoScb = new Label("Código SCB/Entidad");
            grid.addComponent(lbCodigoScb, 0, 0);
            grid.setComponentAlignment(lbCodigoScb, Alignment.MIDDLE_CENTER);
            lbCodigoScb.setWidth(11, Sizeable.Unit.EM);
            lbCodigoScb.setHeight(2, Sizeable.Unit.EM);

            Label lbasteris2 = new Label("*");
            lbasteris2.setStyleName("asterix");
            grid.addComponent(lbasteris2, 1, 0);
            grid.setComponentAlignment(lbasteris2, Alignment.MIDDLE_CENTER);
            lbasteris2.setWidth(5, Sizeable.Unit.EM);
            lbasteris2.setHeight(2, Sizeable.Unit.EM);

            txtCodigoScb = new TextField();
            txtCodigoScb.setValue(codigoScb);
            grid.addComponent(txtCodigoScb, 2, 0);
            grid.setComponentAlignment(txtCodigoScb, Alignment.MIDDLE_CENTER);
            txtCodigoScb.setWidth(15, Sizeable.Unit.EM);
            txtCodigoScb.setHeight(2, Sizeable.Unit.EM);
            txtCodigoScb.setEnabled(false);
            
                        /**
             * **********************************************
             */
            /*SCB/Entidad*/
            /**
             * **********************************************
             */
            Label lbscbEntidad = new Label("SCB/Entidad");
            grid.addComponent(lbscbEntidad, 4, 0);
            grid.setComponentAlignment(lbscbEntidad, Alignment.MIDDLE_RIGHT);
            lbscbEntidad.setWidth(11, Sizeable.Unit.EM);
            lbscbEntidad.setHeight(2, Sizeable.Unit.EM);

            Label lbasteris6 = new Label("*");
            lbasteris6.setStyleName("asterix");
            grid.addComponent(lbasteris6, 5, 0);
            grid.setComponentAlignment(lbasteris6, Alignment.MIDDLE_CENTER);
            lbasteris6.setWidth(5, Sizeable.Unit.EM);
            lbasteris6.setHeight(2, Sizeable.Unit.EM);

            txtscbEntidad = new TextField();
            txtscbEntidad.setValue(scbEntidad);
            grid.addComponent(txtscbEntidad, 6, 0);
            grid.setComponentAlignment(txtscbEntidad, Alignment.MIDDLE_CENTER);
            txtscbEntidad.setWidth(15, Sizeable.Unit.EM);
            txtscbEntidad.setHeight(2, Sizeable.Unit.EM);
            txtscbEntidad.setMaxLength(50);

            lberror7 = new Label();
            lberror7.setStyleName("lblerrorestop");
            grid.addComponent(lberror7, 6, 1);
            grid.setComponentAlignment(lberror7, Alignment.BOTTOM_CENTER);
            lberror7.setWidth(18, Sizeable.Unit.EM);
            lberror7.setHeight(2, Sizeable.Unit.EM);

            txtscbEntidad.addBlurListener(new FieldEvents.BlurListener() {

                @Override
                public void blur(FieldEvents.BlurEvent event) {
                    if (txtscbEntidad.getValue().equals("")) {
                        txtscbEntidad.setComponentError(new UserError(""));
                        lberror7.setValue("Este campo es requerido");
                    } else if (!txtscbEntidad.getValue().matches(regexAlpha)) {
                        txtscbEntidad.setComponentError(new UserError(""));
                        lberror7.setValue("Este campo contiene caracteres no válidos");
                    } else {
                        txtscbEntidad.setComponentError(null);
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
            cbxtipDocumento = LlenarTipoDocumentos();
            if (tipDocumento.equals("Cédula de Ciudadanía")) {
                cbxtipDocumento.select(1);
            } else if (tipDocumento.equals("Cédula de Extranjería")) {
                cbxtipDocumento.select(2);
            } else if (tipDocumento.equals("Pasaporte")) {
                cbxtipDocumento.select(3);
            } else if (tipDocumento.equals("NIT")) {
                cbxtipDocumento.select(4);
            } else if (tipDocumento.equals("NIP o NUIP")) {
                cbxtipDocumento.select(5);
            } else if (tipDocumento.equals("Tarjeta de Identidad")) {
                cbxtipDocumento.select(6);
            }
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
                    valorCombo = 0;
                } catch (ClassCastException ex) {
                    valorCombo = 0;
                }
                txtDigitoverificacion.setVisible(false);
                txtDigitoverificacion.setComponentError(null);
                txtDigitoverificacion.setValue("");
                lberror12.setValue("");
                txtnumeroDoc.setComponentError(null);
                lberror8.setValue("");

                if (valorCombo == 4) {
                    txtDigitoverificacion.setVisible(true);
                    txtDigitoverificacion.setEnabled(true);
                } else {
                    txtDigitoverificacion.setVisible(false);
                    txtDigitoverificacion.setComponentError(null);
                    txtDigitoverificacion.setValue("");
                    lberror12.setValue("");
                }
                if (cbxtipDocumento.getValue() == null || cbxtipDocumento.getValue().equals("")) {
                    cbxtipDocumento.setComponentError(new UserError(""));
                    lberror3.setValue("Este campo es requerido");
                }

                if (valorCombo == 2 || valorCombo == 3 || valorCombo == 5) {
                    if (!txtnumeroDoc.getValue().matches(regexAlphaParen2)) {
                        txtnumeroDoc.setComponentError(new UserError(""));
                        lberror8.setValue("Este campo contiene caracteres no válidos");
                    }
                } else if (!txtnumeroDoc.getValue().matches(regexNumeric)) {
                    txtnumeroDoc.setComponentError(new UserError(""));
                    lberror8.setValue("Este campo contiene caracteres no válidos");
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
            txtnumeroDoc.setValue(numDocumento);
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

                    try {
                        valorCombo = (Integer) cbxtipDocumento.getValue();
                    } catch (NullPointerException ex) {
                        valorCombo = 0;
                    } catch (ClassCastException e) {
                        valorCombo = 0;
                    }
                    txtnumeroDoc.setComponentError(null);
                    lberror8.setValue("");
                    if (txtnumeroDoc.getValue().equals("")) {
                        txtnumeroDoc.setComponentError(new UserError(""));
                        lberror8.setValue("Este campo es requerido");
                    }
                    if (valorCombo == 2 || valorCombo == 3 || valorCombo == 5) {
                        if (!txtnumeroDoc.getValue().matches(regexAlphaParen2)) {
                            txtnumeroDoc.setComponentError(new UserError(""));
                            lberror8.setValue("Este campo contiene caracteres no válidos");
                        }
                    } else if (!txtnumeroDoc.getValue().matches(regexNumeric)) {
                        txtnumeroDoc.setComponentError(new UserError(""));
                        lberror8.setValue("Este campo contiene caracteres no válidos");
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
            txtDigitoverificacion.setValue(digVerificacion);
            grid.addComponent(txtDigitoverificacion, 7, 2);
            grid.setComponentAlignment(txtDigitoverificacion, Alignment.MIDDLE_CENTER);
            txtDigitoverificacion.setWidth(2, Sizeable.Unit.EM);
            txtDigitoverificacion.setHeight(2, Sizeable.Unit.EM);
            txtDigitoverificacion.setMaxLength(1);

            valorCombo = Integer.parseInt(cbxtipDocumento.getValue().toString());
            if (valorCombo == 4) {
                txtDigitoverificacion.setVisible(true);
                txtDigitoverificacion.setEnabled(true);
            } else {

                txtDigitoverificacion.setVisible(false);
                txtDigitoverificacion.setEnabled(false);
            }
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
                    valorCombo = Integer.parseInt(cbxtipDocumento.getValue().toString());

                    if (!txtDigitoverificacion.getValue().equals("")) {
                        if (valorCombo == 2 || valorCombo == 3 || valorCombo == 5) {
                            if (!txtDigitoverificacion.getValue().matches(regexAlphaParen2)) {
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
                        } else if (!txtDigitoverificacion.getValue().matches(regexNumeric)) {
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
            /*Direccion*/
            /**
             * **********************************************
             */
            Label lbDireccion = new Label("Dirección");
            grid.addComponent(lbDireccion, 0, 4);
            grid.setComponentAlignment(lbDireccion, Alignment.MIDDLE_CENTER);
            lbDireccion.setWidth(11, Sizeable.Unit.EM);
            lbDireccion.setHeight(2, Sizeable.Unit.EM);

            txtDireccion = new TextField();
            txtDireccion.setValue(direccion);
            grid.addComponent(txtDireccion, 2, 4);
            grid.setComponentAlignment(txtDireccion, Alignment.MIDDLE_CENTER);
            txtDireccion.setWidth(15, Sizeable.Unit.EM);
            txtDireccion.setHeight(2, Sizeable.Unit.EM);
            txtDireccion.setMaxLength(50);

            lberror4 = new Label();
            lberror4.setStyleName("lblerrorestop");
            grid.addComponent(lberror4, 2, 5);
            grid.setComponentAlignment(lberror4, Alignment.BOTTOM_CENTER);
            lberror4.setWidth(18, Sizeable.Unit.EM);
            lberror4.setHeight(2, Sizeable.Unit.EM);

            txtDireccion.addBlurListener(new FieldEvents.BlurListener() {

                @Override
                public void blur(FieldEvents.BlurEvent event) {
                    if (!txtDireccion.getValue().matches(regexAlphaNum)) {
                        txtDireccion.setComponentError(new UserError(""));
                        lberror4.setValue("Este campo contiene caracteres no válidos");
                    } else {
                        txtDireccion.setComponentError(null);
                        lberror4.setValue("");
                    }
                    ValidarError();
                }
            });
            
            /**
             * **********************************************
             */
            /*Telefono*/
            /**
             * **********************************************
             */
            Label lbTelefono = new Label("Teléfono");
            grid.addComponent(lbTelefono, 4, 4);
            grid.setComponentAlignment(lbTelefono, Alignment.MIDDLE_RIGHT);
            lbTelefono.setWidth(11, Sizeable.Unit.EM);
            lbTelefono.setHeight(2, Sizeable.Unit.EM);

            Label lbasteris8 = new Label("*");
            lbasteris8.setStyleName("asterix");
            grid.addComponent(lbasteris8, 5, 4);
            grid.setComponentAlignment(lbasteris8, Alignment.MIDDLE_CENTER);
            lbasteris8.setWidth(5, Sizeable.Unit.EM);
            lbasteris8.setHeight(2, Sizeable.Unit.EM);

            txtTelefono = new TextField();
            txtTelefono.setValue(telefono);
            grid.addComponent(txtTelefono, 6, 4);
            grid.setComponentAlignment(txtTelefono, Alignment.MIDDLE_CENTER);
            txtTelefono.setWidth(15, Sizeable.Unit.EM);
            txtTelefono.setHeight(2, Sizeable.Unit.EM);
            txtTelefono.setMaxLength(10);

            lberror9 = new Label();
            lberror9.setStyleName("lblerrorestop");
            grid.addComponent(lberror9, 6, 5);
            grid.setComponentAlignment(lberror9, Alignment.BOTTOM_CENTER);
            lberror9.setWidth(18, Sizeable.Unit.EM);
            lberror9.setHeight(2, Sizeable.Unit.EM);

            txtTelefono.addBlurListener(new FieldEvents.BlurListener() {

                @Override
                public void blur(FieldEvents.BlurEvent event) {
                    if (txtTelefono.getValue().equals("")) {
                        txtTelefono.setComponentError(new UserError(""));
                        lberror9.setValue("Este campo es requerido");
                    } else if (!txtTelefono.getValue().matches(regexAlphaParen)) {
                        txtTelefono.setComponentError(new UserError(""));
                        lberror9.setValue("Este campo contiene caracteres no válidos");
                    } else if (txtTelefono.getValue().length() < 7) {
                        txtTelefono.setComponentError(new UserError(""));
                        lberror9.setValue("Longitud no válida");
                    } else {
                        txtTelefono.setComponentError(null);
                        lberror9.setValue("");
                    }
                    ValidarError();
                }
            });

            /**
             * **********************************************
             */
            /*Representante Legal 1*/
            /**
             * **********************************************
             */
            Label lbRepresentanteLeg1 = new Label("Representante Legal 1");
            grid.addComponent(lbRepresentanteLeg1, 0, 6);
            grid.setComponentAlignment(lbRepresentanteLeg1, Alignment.MIDDLE_CENTER);
            lbRepresentanteLeg1.setWidth(11, Sizeable.Unit.EM);
            lbRepresentanteLeg1.setHeight(2, Sizeable.Unit.EM);

            Label lbasteris5 = new Label("*");
            lbasteris5.setStyleName("asterix");
            grid.addComponent(lbasteris5, 1, 6);
            grid.setComponentAlignment(lbasteris5, Alignment.MIDDLE_CENTER);
            lbasteris5.setWidth(5, Sizeable.Unit.EM);
            lbasteris5.setHeight(2, Sizeable.Unit.EM);

            txtRepresentanteLeg1 = new TextField();
            txtRepresentanteLeg1.setValue(repre1.trim());
            grid.addComponent(txtRepresentanteLeg1, 2, 6);
            grid.setComponentAlignment(txtRepresentanteLeg1, Alignment.MIDDLE_CENTER);
            txtRepresentanteLeg1.setWidth(15, Sizeable.Unit.EM);
            txtRepresentanteLeg1.setHeight(2, Sizeable.Unit.EM);
            txtRepresentanteLeg1.setMaxLength(50);

            lberror5 = new Label();
            lberror5.setStyleName("lblerrorestop");
            grid.addComponent(lberror5, 2, 7);
            grid.setComponentAlignment(lberror5, Alignment.BOTTOM_CENTER);
            lberror5.setWidth(18, Sizeable.Unit.EM);
            lberror5.setHeight(2, Sizeable.Unit.EM);

            txtRepresentanteLeg1.addBlurListener(new FieldEvents.BlurListener() {

                @Override
                public void blur(FieldEvents.BlurEvent event) {
                    if (txtRepresentanteLeg1.getValue().equals("")) {
                        txtRepresentanteLeg1.setComponentError(new UserError(""));
                        lberror5.setValue("Este campo es requerido");
                    } else if (!txtRepresentanteLeg1.getValue().matches(regexLetrasTildes)) {
                        txtRepresentanteLeg1.setComponentError(new UserError(""));
                        lberror5.setValue("Este campo contiene caracteres no válidos");
                    } else {
                        txtRepresentanteLeg1.setComponentError(null);
                        lberror5.setValue("");
                    }
                    ValidarError();
                }
            });

        /**
         * **********************************************
         */
        /*Tipo de Documento representante 1*/
        /**
         * **********************************************
         */
        Label lbtipDocumentor1 = new Label("Tipo Documento");
        grid.addComponent(lbtipDocumentor1, 4, 6);
        grid.setComponentAlignment(lbtipDocumentor1, Alignment.MIDDLE_CENTER);
        lbtipDocumentor1.setWidth(11, Sizeable.Unit.EM);
        lbtipDocumentor1.setHeight(2, Sizeable.Unit.EM);

        lbl_asteriscotipodocr1.setStyleName("asterix");
        grid.addComponent(lbl_asteriscotipodocr1, 5, 6);
        grid.setComponentAlignment(lbl_asteriscotipodocr1, Alignment.MIDDLE_LEFT);
        lbl_asteriscotipodocr1.setWidth(5, Sizeable.Unit.EM);
        lbl_asteriscotipodocr1.setHeight(2, Sizeable.Unit.EM);

        cbxtipDocumentoR1 = new ComboBox();
        cbxtipDocumentoR1 = LlenarTipoDocr1();
         if (tipodoc.equals("Cédula de Ciudadanía")) {
            cbxtipDocumentoR1.select(1);
        } else if (tipodoc.equals("Cédula de Extranjería")) {
            cbxtipDocumentoR1.select(2);
        } else if (tipodoc.equals("Pasaporte")) {
            cbxtipDocumentoR1.select(3);
        } else if (tipodoc.equals("NIP o NUIP")) {
            cbxtipDocumentoR1.select(5);
        } else if (tipodoc.equals("Seleccione")) {           
            cbxtipDocumentoR1.select("");            
        }
         
   
        grid.addComponent(cbxtipDocumentoR1, 6, 6);
        grid.setComponentAlignment(cbxtipDocumentoR1, Alignment.MIDDLE_CENTER);
        cbxtipDocumentoR1.setWidth(15, Sizeable.Unit.EM);
        cbxtipDocumentoR1.setHeight(3, Sizeable.Unit.EM);

        lberrorcmbR1.setStyleName("lblerrorestop");
        grid.addComponent(lberrorcmbR1, 6, 7);
        grid.setComponentAlignment(lberrorcmbR1, Alignment.BOTTOM_CENTER);
        lberrorcmbR1.setWidth(18, Sizeable.Unit.EM);
        lberrorcmbR1.setHeight(2, Sizeable.Unit.EM);

        cbxtipDocumentoR1.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (cbxtipDocumentoR1.getValue() == null || cbxtipDocumentoR1.getValue().equals("")) {
                    cbxtipDocumentoR1.setComponentError(new UserError(""));
                    lberrorcmbR1.setValue("Este campo es requerido");
                } else {
                    cbxtipDocumentoR1.setComponentError(null);
                    lberrorcmbR1.setValue("");
                }
                ValidarError();
            }
        });

        cbxtipDocumentoR1.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {

                try {
                    valorComb1 = (Integer) cbxtipDocumentoR1.getValue();
                } catch (NullPointerException e) {
                    valorComb1 = 0;
                } catch (ClassCastException ex) {
                    valorComb1 = 0;
                }
                txtnumeroDocR1.setComponentError(null);
                lberrortxtR1.setValue("");


                if (valorComb1 == 2 || valorComb1 == 3 || valorComb1 == 5) {
                    if (!txtnumeroDocR1.getValue().matches(regexAlphaParen2)) {
                        txtnumeroDocR1.setComponentError(new UserError(""));
                        lberrortxtR1.setValue("Este campo contiene caracteres no válidos");
                    }
                } else if (!txtnumeroDocR1.getValue().matches(regexNumeric)) {
                    txtnumeroDocR1.setComponentError(new UserError(""));
                    lberrortxtR1.setValue("Este campo contiene caracteres no válidos");
                }
                ValidarError();
            }
        });

        /**
         * **********************************************
         */
        /*Número documento Representante Legal 1*/
        /**
         * **********************************************
         */
        Label lbnumeroDocr1 = new Label("Número de Documento");
        grid.addComponent(lbnumeroDocr1, 0, 8);
        grid.setComponentAlignment(lbnumeroDocr1, Alignment.MIDDLE_RIGHT);
        lbnumeroDocr1.setWidth(11, Sizeable.Unit.EM);
        lbnumeroDocr1.setHeight(2, Sizeable.Unit.EM);

        lbl_asterisconumdocr1.setStyleName("asterix");
        grid.addComponent(lbl_asterisconumdocr1, 1, 8);
        grid.setComponentAlignment(lbl_asterisconumdocr1, Alignment.MIDDLE_CENTER);
        lbl_asterisconumdocr1.setWidth(5, Sizeable.Unit.EM);
        lbl_asterisconumdocr1.setHeight(2, Sizeable.Unit.EM);

        txtnumeroDocR1 = new TextField();
        txtnumeroDocR1.setValue(tipodocnum);
        grid.addComponent(txtnumeroDocR1, 2, 8);
        grid.setComponentAlignment(txtnumeroDocR1, Alignment.MIDDLE_CENTER);
        txtnumeroDocR1.setWidth(15, Sizeable.Unit.EM);
        txtnumeroDocR1.setHeight(2, Sizeable.Unit.EM);
        txtnumeroDocR1.setMaxLength(15);

        lberrortxtR1.setStyleName("lblerrorestop");
        grid.addComponent(lberrortxtR1, 2, 9);
        grid.setComponentAlignment(lberrortxtR1, Alignment.BOTTOM_CENTER);
        lberrortxtR1.setWidth(18, Sizeable.Unit.EM);
        lberrortxtR1.setHeight(2, Sizeable.Unit.EM);

        txtnumeroDocR1.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                try {
                    valorComb1 = (Integer) cbxtipDocumentoR1.getValue();
                } catch (NullPointerException ex) {
                    valorComb1 = 0;
                } catch (ClassCastException e) {
                    valorComb1 = 0;
                }
                txtnumeroDocR1.setComponentError(null);
                lberrortxtR1.setValue("");
                if (txtnumeroDocR1.getValue().equals("")) {
                    txtnumeroDocR1.setComponentError(new UserError(""));
                    lberrortxtR1.setValue("Este campo es requerido");
                }

                if (valorComb1 == 2 || valorComb1 == 3 || valorComb1 == 5) {
                    if (!txtnumeroDocR1.getValue().matches(regexAlphaParen2)) {
                        txtnumeroDocR1.setComponentError(new UserError(""));
                        lberrortxtR1.setValue("Este campo contiene caracteres no válidos");
                    }
                } else if (!txtnumeroDocR1.getValue().matches(regexNumeric)) {
                    txtnumeroDocR1.setComponentError(new UserError(""));
                    lberrortxtR1.setValue("Este campo contiene caracteres no válidos");
                }

                ValidarError();

            }
        });

        /**
         * **********************************************
         */
        /*Representante Legal 2                        */
        /**
         * **********************************************
         */
        Label lbRepresentanteLeg2 = new Label("Representante Legal 2");
        grid.addComponent(lbRepresentanteLeg2, 0, 10);
        grid.setComponentAlignment(lbRepresentanteLeg2, Alignment.MIDDLE_RIGHT);
        lbRepresentanteLeg2.setWidth(11, Sizeable.Unit.EM);
        lbRepresentanteLeg2.setHeight(2, Sizeable.Unit.EM);

            txtRepresentanteLeg2 = new TextField();
            txtRepresentanteLeg2.setValue(repre2.trim());
            grid.addComponent(txtRepresentanteLeg2, 2, 10);
            grid.setComponentAlignment(txtRepresentanteLeg2, Alignment.MIDDLE_CENTER);
            txtRepresentanteLeg2.setWidth(15, Sizeable.Unit.EM);
            txtRepresentanteLeg2.setHeight(2, Sizeable.Unit.EM);
            txtRepresentanteLeg2.setMaxLength(50);

            lberror10 = new Label();
            lberror10.setStyleName("lblerrorestop");
            grid.addComponent(lberror10, 2, 11);
            grid.setComponentAlignment(lberror10, Alignment.BOTTOM_CENTER);
            lberror10.setWidth(18, Sizeable.Unit.EM);
            lberror10.setHeight(2, Sizeable.Unit.EM);

            txtRepresentanteLeg2.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!txtRepresentanteLeg2.getValue().trim().matches(regexLetrasTildes)) {
                    txtRepresentanteLeg2.setComponentError(new UserError(""));
                    lberror10.setValue("Este campo contiene caracteres no válidos");
                } else {
                    if (txtRepresentanteLeg2.isEmpty()){
                        txtRepresentanteLeg2.setComponentError(null);
                        lberror10.setValue("");  
                        txtnumeroDocR2.setComponentError(null);
                        lberrortxtR2.setValue("");
                        cbxtipDocumentoR2.setComponentError(null);
                        lberrorcmbR2.setValue(""); 
                        cbxtipDocumentoR2.setItemCaption("", "Seleccione");
                        cbxtipDocumentoR2.select("");
                        txtnumeroDocR2.setValue("");
                    }else{
                        txtRepresentanteLeg2.setComponentError(null);
                        lberror10.setValue("");  
                    }
                }
                ValidarError();
            }
        });

        /**
         * **********************************************
         */
        /*Tipo de Documento representante 2            */
        /**
         * **********************************************
         */
        Label lbtipDocumentor2 = new Label("Tipo Documento");
        grid.addComponent(lbtipDocumentor2, 4, 10);
        grid.setComponentAlignment(lbtipDocumentor2, Alignment.MIDDLE_CENTER);
        lbtipDocumentor2.setWidth(11, Sizeable.Unit.EM);
        lbtipDocumentor2.setHeight(2, Sizeable.Unit.EM);

        cbxtipDocumentoR2 = LlenarTipoDocr2();   
         if (tipodoc2.equals("Cédula de Ciudadanía")) {
            cbxtipDocumentoR2.select(1);
        } else if (tipodoc2.equals("Cédula de Extranjería")) {
            cbxtipDocumentoR2.select(2);
        } else if (tipodoc2.equals("Pasaporte")) {
            cbxtipDocumentoR2.select(3);
        } else if (tipodoc2.equals("NIP o NUIP")) {
            cbxtipDocumentoR2.select(5);
        } else if (tipodoc2.equals("Seleccione")) {           
            cbxtipDocumentoR2.select("");            
        }
                
        grid.addComponent(cbxtipDocumentoR2, 6, 10);
        grid.setComponentAlignment(cbxtipDocumentoR2, Alignment.MIDDLE_CENTER);
        cbxtipDocumentoR2.setWidth(15, Sizeable.Unit.EM);
        cbxtipDocumentoR2.setHeight(3, Sizeable.Unit.EM);

        lberrorcmbR2.setStyleName("lblerrorestop");
        grid.addComponent(lberrorcmbR2, 6, 11);
        grid.setComponentAlignment(lberrorcmbR2, Alignment.BOTTOM_CENTER);
        lberrorcmbR2.setWidth(18, Sizeable.Unit.EM);
        lberrorcmbR2.setHeight(2, Sizeable.Unit.EM);

        cbxtipDocumentoR2.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                
                
                if (!txtRepresentanteLeg2.getValue().trim().isEmpty()) {

                    if (cbxtipDocumentoR2.getValue() == null || cbxtipDocumentoR2.getValue().equals("")) {
                        cbxtipDocumentoR2.setComponentError(new UserError(""));
                        lberrorcmbR2.setValue("Este campo es requerido");
                    } else {
                        if (txtRepresentanteLeg2.isEmpty()){
                            txtRepresentanteLeg2.setComponentError(null);
                            lberror10.setValue("");  
                            txtnumeroDocR2.setComponentError(null);
                            lberrortxtR2.setValue("");
                            cbxtipDocumentoR2.setComponentError(null);
                            lberrorcmbR2.setValue(""); 
                            cbxtipDocumentoR2.setItemCaption("", "Seleccione");
                            cbxtipDocumentoR2.select("");
                            txtnumeroDocR2.setValue("");
                        }else{
                            cbxtipDocumentoR2.setComponentError(null);
                            lberrorcmbR2.setValue("");  
                        }                                                                                               

                    }  
                }else{
                        txtRepresentanteLeg2.setComponentError(null);
                        lberror10.setValue("");  
                        txtnumeroDocR2.setComponentError(null);
                        lberrortxtR2.setValue("");
                        cbxtipDocumentoR2.setComponentError(null);
                        lberrorcmbR2.setValue(""); 
                        cbxtipDocumentoR2.setItemCaption("", "Seleccione");
                        cbxtipDocumentoR2.select("");
                        txtnumeroDocR2.setValue("");
                    
                }ValidarError();
                     
            }
        });

        cbxtipDocumentoR2.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
               
                if (!txtRepresentanteLeg2.getValue().trim().isEmpty()) {
                    try {
                        valorComb2 = (Integer) cbxtipDocumentoR2.getValue();
                    } catch (NullPointerException e) {
                        valorComb2 = 0;
                    } catch (ClassCastException ex) {
                        valorComb2 = 0;
                    }
                    txtnumeroDocR2.setComponentError(null);
                    lberrortxtR2.setValue("");
                    cbxtipDocumentoR2.setComponentError(null);
                    lberrorcmbR2.setValue("");

                    if (cbxtipDocumentoR2.getValue() == null || cbxtipDocumentoR2.getValue().equals("")) {
                        cbxtipDocumentoR2.setComponentError(new UserError(""));
                        lberrorcmbR2.setValue("Este campo es requerido");
                    }

                    if (valorComb2 == 2 || valorComb2 == 3 || valorComb2 == 5) {
                        if (!txtnumeroDocR2.getValue().matches(regexAlphaParen2)) {
                            txtnumeroDocR2.setComponentError(new UserError(""));
                            lberrortxtR2.setValue("Este campo contiene caracteres no válidos");
                        }
                    } else if (!txtnumeroDocR2.getValue().matches(regexNumeric)) {
                        txtnumeroDocR2.setComponentError(new UserError(""));
                        lberrortxtR2.setValue("Este campo contiene caracteres no válidos");
                    }
                
                }else{
                        txtRepresentanteLeg2.setComponentError(null);
                        lberror10.setValue("");  
                        txtnumeroDocR2.setComponentError(null);
                        lberrortxtR2.setValue("");
                        cbxtipDocumentoR2.setComponentError(null);
                        lberrorcmbR2.setValue(""); 
                        cbxtipDocumentoR2.setItemCaption("", "Seleccione");
                        cbxtipDocumentoR2.select("");
                        txtnumeroDocR2.setValue("");
                }
                ValidarError();

            }
        });

        /**
         * **********************************************
         */
        /*Número documento Representante Legal 2       */
        /**
         * **********************************************
         */
        Label lbnumeroDocr2 = new Label("Número de Documento");
        grid.addComponent(lbnumeroDocr2, 0, 12);
        grid.setComponentAlignment(lbnumeroDocr2, Alignment.MIDDLE_RIGHT);
        lbnumeroDocr2.setWidth(11, Sizeable.Unit.EM);
        lbnumeroDocr2.setHeight(2, Sizeable.Unit.EM);

        txtnumeroDocR2 = new TextField();
        txtnumeroDocR2.setValue(tipodocnum2);
        grid.addComponent(txtnumeroDocR2, 2, 12);
        grid.setComponentAlignment(txtnumeroDocR2, Alignment.MIDDLE_CENTER);
        txtnumeroDocR2.setWidth(15, Sizeable.Unit.EM);
        txtnumeroDocR2.setHeight(2, Sizeable.Unit.EM);
        txtnumeroDocR2.setMaxLength(15);

        lberrortxtR2.setStyleName("lblerrorestop");
        grid.addComponent(lberrortxtR2, 2, 13);
        grid.setComponentAlignment(lberrortxtR2, Alignment.BOTTOM_CENTER);
        lberrortxtR2.setWidth(18, Sizeable.Unit.EM);
        lberrortxtR2.setHeight(2, Sizeable.Unit.EM);

        txtnumeroDocR2.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!txtRepresentanteLeg2.getValue().trim().isEmpty()) {
                    try {
                        valorComb2 = (Integer) cbxtipDocumentoR2.getValue();
                    } catch (NullPointerException ex) {
                        valorComb2 = 0;
                    } catch (ClassCastException e) {
                        valorComb2 = 0;
                    }
                    txtnumeroDocR2.setComponentError(null);
                    lberrortxtR2.setValue("");
                    if (txtnumeroDocR2.getValue().equals("")) {
                        txtnumeroDocR2.setComponentError(new UserError(""));
                        lberrortxtR2.setValue("Este campo es requerido");
                    }

                    if (valorComb2 == 2 || valorComb2 == 3 || valorComb2 == 5) {
                        if (!txtnumeroDocR2.getValue().matches(regexAlphaParen2)) {
                            txtnumeroDocR2.setComponentError(new UserError(""));
                            lberrortxtR2.setValue("Este campo  contiene caracteres no válidos");
                        }
                    } else if (!txtnumeroDocR2.getValue().matches(regexNumeric)) {
                        txtnumeroDocR2.setComponentError(new UserError(""));
                        lberrortxtR2.setValue("Este campo contiene caracteres no válidos");
                    }       
                }else{                  
                        cbxtipDocumentoR2.setValue(0);
                        txtnumeroDocR2.setValue("");
                    }ValidarError();
            }
        });
        /**
         * **********************************************
         */
        /*Representante Legal 3*/
        /**
         * **********************************************
         */
        Label lbRepresentanteLeg3 = new Label("Representante Legal 3");
        grid.addComponent(lbRepresentanteLeg3, 0, 14);
        grid.setComponentAlignment(lbRepresentanteLeg3, Alignment.MIDDLE_CENTER);
        lbRepresentanteLeg3.setWidth(11, Sizeable.Unit.EM);
        lbRepresentanteLeg3.setHeight(2, Sizeable.Unit.EM);

        txtRepresentanteLeg3 = new TextField();
        txtRepresentanteLeg3.setValue(repre3.trim());
        grid.addComponent(txtRepresentanteLeg3, 2, 14);
        grid.setComponentAlignment(txtRepresentanteLeg3, Alignment.MIDDLE_CENTER);
        txtRepresentanteLeg3.setWidth(15, Sizeable.Unit.EM);
        txtRepresentanteLeg3.setHeight(2, Sizeable.Unit.EM);
        txtRepresentanteLeg3.setMaxLength(50);

        lberror6 = new Label();
        lberror6.setStyleName("lblerrorestop");
        grid.addComponent(lberror6, 2, 15);
        grid.setComponentAlignment(lberror6, Alignment.BOTTOM_CENTER);
        lberror6.setWidth(18, Sizeable.Unit.EM);
        lberror6.setHeight(2, Sizeable.Unit.EM);

        txtRepresentanteLeg3.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!txtRepresentanteLeg3.getValue().matches(regexLetrasTildes)) {
                    txtRepresentanteLeg3.setComponentError(new UserError(""));
                    lberror6.setValue("Este campo contiene caracteres no válidos");
                } else {
                    if (txtRepresentanteLeg3.isEmpty()) {                    
                        txtRepresentanteLeg3.setComponentError(null);
                        lberror6.setValue("");  
                        txtnumeroDocR3.setComponentError(null);
                        lberrortxtR3.setValue("");
                        cbxtipDocumentoR3.setComponentError(null);
                        lberrorcmbR3.setValue(""); 
                        cbxtipDocumentoR3.setItemCaption("", "Seleccione");
                        cbxtipDocumentoR3.select("");
                        txtnumeroDocR3.setValue("");
                    } else {
                        txtRepresentanteLeg3.setComponentError(null);
                        lberror6.setValue("");
                    }
                }
                ValidarError();
            }
        });

        /**
         * **********************************************
         */
        /*Tipo de Documento representante 3            */
        /**
         * **********************************************
         */
        Label lbtipDocumentor3 = new Label("Tipo Documento");
        grid.addComponent(lbtipDocumentor3, 4, 14);
        grid.setComponentAlignment(lbtipDocumentor3, Alignment.MIDDLE_CENTER);
        lbtipDocumentor3.setWidth(11, Sizeable.Unit.EM);
        lbtipDocumentor3.setHeight(2, Sizeable.Unit.EM);

        cbxtipDocumentoR3 = LlenarTipoDocr3();
         if (tipodoc3.equals("Cédula de Ciudadanía")) {
            cbxtipDocumentoR3.select(1);
        } else if (tipodoc3.equals("Cédula de Extranjería")) {
            cbxtipDocumentoR3.select(2);
        } else if (tipodoc3.equals("Pasaporte")) {
            cbxtipDocumentoR3.select(3);
        } else if (tipodoc3.equals("NIP o NUIP")) {
            cbxtipDocumentoR3.select(5);
        } else if (tipodoc3.equals("Seleccione")) {           
            cbxtipDocumentoR3.select("");            
        }

        grid.addComponent(cbxtipDocumentoR3, 6, 14);
        grid.setComponentAlignment(cbxtipDocumentoR3, Alignment.MIDDLE_CENTER);
        cbxtipDocumentoR3.setWidth(15, Sizeable.Unit.EM);
        cbxtipDocumentoR3.setHeight(3, Sizeable.Unit.EM);

        lberrorcmbR3.setStyleName("lblerrorestop");
        grid.addComponent(lberrorcmbR3, 6, 15);
        grid.setComponentAlignment(lberrorcmbR3, Alignment.BOTTOM_CENTER);
        lberrorcmbR3.setWidth(18, Sizeable.Unit.EM);
        lberrorcmbR3.setHeight(2, Sizeable.Unit.EM);

        cbxtipDocumentoR3.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!txtRepresentanteLeg3.getValue().trim().isEmpty()) {

                    if (cbxtipDocumentoR3.getValue() == null || cbxtipDocumentoR3.getValue().equals("")) {
                        cbxtipDocumentoR3.setComponentError(new UserError(""));
                        lberrorcmbR3.setValue("Este campo es requerido");
                    } else {
                        if (txtRepresentanteLeg3.isEmpty()){
                            txtRepresentanteLeg3.setComponentError(null);
                            lberror6.setValue("");  
                            txtnumeroDocR3.setComponentError(null);
                            lberrortxtR3.setValue("");
                            cbxtipDocumentoR3.setComponentError(null);
                            lberrorcmbR3.setValue(""); 
                            cbxtipDocumentoR3.setItemCaption("", "Seleccione");
                            cbxtipDocumentoR3.select("");
                            txtnumeroDocR3.setValue("");
                        }else{
                            cbxtipDocumentoR3.setComponentError(null);
                            lberrorcmbR3.setValue("");  
                        }

                    }
                    ValidarError();
                }
            }
        });

        cbxtipDocumentoR3.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {

                if (!txtRepresentanteLeg3.getValue().trim().isEmpty()) {
                    try {
                        valorComb3 = (Integer) cbxtipDocumentoR3.getValue();
                    } catch (NullPointerException e) {
                        valorComb3 = 0;
                    } catch (ClassCastException ex) {
                        valorComb3 = 0;
                    }
                    txtnumeroDocR3.setComponentError(null);
                    lberrortxtR3.setValue("");
                    cbxtipDocumentoR3.setComponentError(null);
                    lberrorcmbR3.setValue("");


                    if (cbxtipDocumentoR3.getValue() == null || cbxtipDocumentoR3.getValue().equals("")) {
                        cbxtipDocumentoR3.setComponentError(new UserError(""));
                        lberrorcmbR3.setValue("Este campo es requerido");
                    }

                    if (valorComb3 == 2 || valorComb3 == 3 || valorComb3 == 5) {
                        if (!txtnumeroDocR3.getValue().matches(regexAlphaParen2)) {
                            txtnumeroDocR3.setComponentError(new UserError(""));
                            lberrortxtR3.setValue("Este campo contiene caracteres no válidos");
                        }
                    } else if (!txtnumeroDocR3.getValue().matches(regexNumeric)) {
                        txtnumeroDocR3.setComponentError(new UserError(""));
                        lberrortxtR3.setValue("Este campo contiene caracteres no válidos");
                    }
                    
                }else{
                        txtRepresentanteLeg3.setComponentError(null);
                        lberror6.setValue("");  
                        txtnumeroDocR3.setComponentError(null);
                        lberrortxtR3.setValue("");
                        cbxtipDocumentoR3.setComponentError(null);
                        lberrorcmbR3.setValue(""); 
                        cbxtipDocumentoR3.setItemCaption("", "Seleccione");
                        cbxtipDocumentoR3.select("");
                        txtnumeroDocR3.setValue("");
                    
                }ValidarError();
            }
        });

        /**
         * **********************************************
         */
        /*Número documento Representante Legal 3       */
        /**
         * **********************************************
         */
        Label lbnumeroDocr3 = new Label("Número de Documento");
        grid.addComponent(lbnumeroDocr3, 0, 16);
        grid.setComponentAlignment(lbnumeroDocr3, Alignment.MIDDLE_RIGHT);
        lbnumeroDocr3.setWidth(11, Sizeable.Unit.EM);
        lbnumeroDocr3.setHeight(2, Sizeable.Unit.EM);

        txtnumeroDocR3 = new TextField();
        txtnumeroDocR3.setValue(tipodocnum3);
        grid.addComponent(txtnumeroDocR3, 2, 16);
        grid.setComponentAlignment(txtnumeroDocR3, Alignment.MIDDLE_CENTER);
        txtnumeroDocR3.setWidth(15, Sizeable.Unit.EM);
        txtnumeroDocR3.setHeight(2, Sizeable.Unit.EM);
        txtnumeroDocR3.setMaxLength(15);

        lberrortxtR3.setStyleName("lblerrorestop");
        grid.addComponent(lberrortxtR3, 2, 17);
        grid.setComponentAlignment(lberrortxtR3, Alignment.BOTTOM_CENTER);
        lberrortxtR3.setWidth(18, Sizeable.Unit.EM);
        lberrortxtR3.setHeight(2, Sizeable.Unit.EM);

        txtnumeroDocR3.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!txtRepresentanteLeg3.getValue().trim().isEmpty()) {
                    try {
                        valorComb3 = (Integer) cbxtipDocumentoR3.getValue();
                    } catch (NullPointerException ex) {
                        valorComb3 = 0;
                    } catch (ClassCastException e) {
                        valorComb3 = 0;
                    }
                    txtnumeroDocR3.setComponentError(null);
                    lberrortxtR3.setValue("");
                    if (txtnumeroDocR3.getValue().equals("")) {
                        txtnumeroDocR3.setComponentError(new UserError(""));
                        lberrortxtR3.setValue("Este campo es requerido");
                    }

                    if (valorComb3 == 2 || valorComb3 == 3 || valorComb3 == 5) {
                        if (!txtnumeroDocR3.getValue().matches(regexAlphaParen2)) {
                            txtnumeroDocR3.setComponentError(new UserError(""));
                            lberrortxtR3.setValue("Este campo  contiene caracteres no válidos");
                        }
                    } else if (!txtnumeroDocR3.getValue().matches(regexNumeric)) {
                        txtnumeroDocR3.setComponentError(new UserError(""));
                        lberrortxtR3.setValue("Este campo contiene caracteres no válidos");
                    }
                }else{                  
                        cbxtipDocumentoR3.setValue(0);
                        txtnumeroDocR3.setValue("");
                }ValidarError();   
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
            grid.addComponent(lbEstado, 4, 16);
            grid.setComponentAlignment(lbEstado, Alignment.MIDDLE_RIGHT);
            lbEstado.setWidth(11, Sizeable.Unit.EM);
            lbEstado.setHeight(2, Sizeable.Unit.EM);

            Label lbasteris10 = new Label("*");
            lbasteris10.setStyleName("asterix");
            grid.addComponent(lbasteris10, 5, 16);
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

            if (estado.equals("Activo")) {
                cbxEstado.select(1);
            } else if (estado.equals("Inactivo")) {
                cbxEstado.select(2);
            }

            grid.addComponent(cbxEstado, 6, 16);
            grid.setComponentAlignment(cbxEstado, Alignment.MIDDLE_CENTER);
            cbxEstado.setWidth(15, Sizeable.Unit.EM);
            cbxEstado.setHeight(2, Sizeable.Unit.EM);

            lberror11 = new Label();
            lberror11.setStyleName("lblerrorcomboBox");
            grid.addComponent(lberror11, 6, 17);
            grid.setComponentAlignment(lberror11, Alignment.BOTTOM_CENTER);
            lberror11.setWidth(18, Sizeable.Unit.EM);
            lberror11.setHeight(2, Sizeable.Unit.EM);

            cbxEstado.addValueChangeListener(new Property.ValueChangeListener() {
                @Override
                public void valueChange(Property.ValueChangeEvent event) {
                    if (cbxEstado.getValue() == null || cbxEstado.getValue().equals("")) {
                        cbxEstado.setComponentError(new UserError(""));
                        lberror11.setValue("Este campo es requerido");
                    } else {
                        cbxEstado.setComponentError(null);
                        lberror11.setValue("");
                    }
                    ValidarError();
                }
            });
            
            VerticalLayout vl = new VerticalLayout();
            Button btnCancelar = new Button("Cancelar");
            Button btnGuardarMod = new Button("Guardar");
            HL.addComponents(btnGuardarMod, btnCancelar);
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

            btnGuardarMod.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(final Button.ClickEvent event) {

                    if (txtCodigoScb.getValue().equals("")) {
                        txtCodigoScb.setComponentError(new UserError(""));
                        lberror2.setValue("Este campo es requerido");
                    }
                    try {
                        combo = (Integer) cbxtipDocumento.getValue();
                    } catch (NullPointerException e) {
                        combo = 0;
                    } catch (ClassCastException ex) {
                        combo = 0;
                    }

                    if (combo == 0) {
                        cbxtipDocumento.setComponentError(new UserError(""));
                        lberror3.setValue("Este campo es requerido");
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
                        lberror11.setValue("Este campo es requerido");
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

                    if (txtTelefono.getValue().equals("")) {
                        txtTelefono.setComponentError(new UserError(""));
                        lberror9.setValue("Este campo es requerido");
                    } else if (txtTelefono.getValue().length() < 7) {
                        txtTelefono.setComponentError(new UserError(""));
                        lberror9.setValue("Longitud no válida");
                    }

                    try {
                        direccion1 = txtDireccion.getValue();
                    } catch (Exception ex) {
                        direccion1 = "";
                    }
                    
                    //representante legal 1
                    if (txtRepresentanteLeg1.getValue().equals("")) {
                        txtRepresentanteLeg1.setComponentError(new UserError(""));
                        lberror5.setValue("Este campo es requerido");
                    }

                    try {
                        comb1 = (Integer) cbxtipDocumentoR1.getValue();
                    } catch (NullPointerException e) {
                        comb1 = 0;
                    } catch (ClassCastException ex) {
                        comb1 = 0;
                    }

                    if (comb1 == 0) {
                        cbxtipDocumentoR1.setComponentError(new UserError(""));
                        lberrorcmbR1.setValue("Este campo es requerido");
                    }
                    if (txtnumeroDocR1.getValue().equals("")) {
                        txtnumeroDocR1.setComponentError(new UserError(""));
                        lberrortxtR1.setValue("Este campo es requerido");
                    }
                    // 

                    // representante legal 2 
                    try {
                        numtipodocr2 = txtnumeroDocR2.getValue().trim();
                    } catch (Exception ex) {
                        numtipodocr2 = "";
                    }

                    try {
                        representaLe2 =  txtRepresentanteLeg2.getValue().trim();
                    } catch (Exception ex) {
                        representaLe2 = "";
                    }

                    try {
                        comb2 = (Integer) cbxtipDocumentoR2.getValue();
                    } catch (NullPointerException e) {
                        comb2 = 0;
                    } catch (ClassCastException ex) {
                        comb2 = 0;
                    }

                    if (!representaLe2.equals("")) {


                        if (comb2 == 0) {
                            cbxtipDocumentoR2.setComponentError(new UserError(""));
                            lberrorcmbR2.setValue("Este campo es requerido");
                        }
                        if (txtnumeroDocR2.getValue().equals("")) {
                            txtnumeroDocR2.setComponentError(new UserError(""));
                            lberrortxtR2.setValue("Este campo es requerido");
                        }
                    }
                    //

                    //representante legal 3
                    
                    try {
                        representaLe3 = txtRepresentanteLeg3.getValue().trim();
                    } catch (Exception ex) {
                        representaLe3 = "";
                    }
                    
                    try {
                        numtipodocr3 = txtnumeroDocR3.getValue().trim();
                    } catch (Exception ex) {
                        numtipodocr3 = "";
                    }
                    
                    try {
                        comb3 = (Integer) cbxtipDocumentoR3.getValue();
                    } catch (NullPointerException e) {
                        comb3 = 0;
                    } catch (ClassCastException ex) {
                        comb3 = 0;
                    }
                    
                    if (!representaLe3.equals("")) {

                        if (comb3 == 0) {
                            cbxtipDocumentoR3.setComponentError(new UserError(""));
                            lberrorcmbR3.setValue("Este campo es requerido");
                        }
                        if (txtnumeroDocR3.getValue().equals("")) {
                            txtnumeroDocR3.setComponentError(new UserError(""));
                            lberrortxtR3.setValue("Este campo es requerido");
                        }
                    }
                    // 

                    try {
                        digVerificacion1 = txtDigitoverificacion.getValue();
                    } catch (Exception ex) {
                        digVerificacion1 = "";
                    }

                    List<List<String>> listestadoUsu;
                    listestadoUsu = scb.UsuariosActivosScb(codigoScb);

                    int estadoId = Integer.parseInt(cbxEstado.getValue().toString());

                    if (estadoId == 2 && listestadoUsu.get(0).size() != 0) {
                        Notification.show("No se puede cambiar de estado por que posee usuarios en estado Activo/Bloqueado", Notification.Type.ERROR_MESSAGE);
                    } else {
                        ValidarError();
                        if (!ValidaComponentError()) {
                            ConfirmDialog.show(getUI(), "Confirmación", "¿Está seguro que desea realizar los cambios?", "ACEPTAR",
                                    "CANCELAR", new ConfirmDialog.Listener() {
                                @Override
                                public void onClose(ConfirmDialog dialog) {
                                    if (dialog.isConfirmed()) {

                                        /*Guardar sociedad comisionista de bolsa*/
                                        String resultado = scb.ModificarSCB(txtCodigoScb.getValue(), txtscbEntidad.getValue(), Integer.parseInt(cbxtipDocumento.getValue().toString()), txtnumeroDoc.getValue(), digVerificacion1, direccion1, txtTelefono.getValue(), txtRepresentanteLeg1.getValue(), representaLe2, representaLe3, Integer.parseInt(cbxEstado.getValue().toString()),Integer.parseInt(cbxtipDocumentoR1.getValue().toString()),txtnumeroDocR1.getValue(), comb2,numtipodocr2,comb3,numtipodocr3);
                                        UI.getCurrent().removeWindow(subWindow);
                                        ConfirmDialog cd = ConfirmDialog.getFactory().create("Confirmación", "", "ACEPTAR", "", "");
                                        cd.setWidth("380px");
                                        cd.setHeight("140px");
                                        HorizontalLayout texto = new HorizontalLayout();
                                        HorizontalLayout buttons = new HorizontalLayout();
                                        buttons.setStyleName("btnAceptar");
                                        Label lblmensaje = new Label("Los cambios fueron realizados con éxito", ContentMode.HTML);
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
                                    select = 0;
                                    List<List<String>> listSCB;
                                    listSCB = scb.Listarscb();
                                    int i;

                                    tabla.getContainerDataSource().removeAllItems();
                                    //if (listSCB.get(0).size() != 0) {
                                    if (listSCB.get(0).size() != 0) {

                                        for (i = 0; i < listSCB.get(0).size(); i++) {

                                            String estado = "";
                                            if (listSCB.get(16).get(i).equals("1")) {
                                                estado = "Activo";
                                            } else if (listSCB.get(16).get(i).equals("2")) {
                                                estado = "Inactivo";
                                            }
                                            
                                            String codigo = (listSCB.get(17).get(i));

                                            if (codigo.length() == 2) {
                                                String cerouno = "0";
                                                codigo = cerouno.concat(codigo);
                                            } else if (codigo.length() == 1) {
                                                String cerodos = "00";
                                                codigo = cerodos.concat(codigo);
                                            }
                                            
                                            Item item = ic.addItem(i);
                                            item.getItemProperty("Código SCB/Entidad").setValue(codigo);
                                            item.getItemProperty("SCB/Entidad").setValue(listSCB.get(3).get(i));
                                            item.getItemProperty("Tipo Documento").setValue(listSCB.get(2).get(i));
                                            item.getItemProperty("Número de Documento").setValue(listSCB.get(1).get(i));
                                            item.getItemProperty("Dígito de Verificación").setValue(listSCB.get(15).get(i));
                                            item.getItemProperty("Dirección").setValue(listSCB.get(6).get(i));
                                            item.getItemProperty("Teléfono").setValue(listSCB.get(7).get(i));
                                            item.getItemProperty("Representante Legal 1").setValue(listSCB.get(5).get(i));
                                            item.getItemProperty("Tipo Documento 1").setValue(listSCB.get(18).get(i));
                                            item.getItemProperty("Número de Documento 1").setValue(listSCB.get(19).get(i));                                            
                                            item.getItemProperty("Representante Legal 2").setValue(listSCB.get(13).get(i));                                            
                                            item.getItemProperty("Tipo Documento 2").setValue(listSCB.get(20).get(i).replace("Seleccione",""));
                                            item.getItemProperty("Número de Documento 2").setValue(listSCB.get(21).get(i));
                                            item.getItemProperty("Representante Legal 3").setValue(listSCB.get(14).get(i));
                                            item.getItemProperty("Tipo Documento 3").setValue(listSCB.get(22).get(i).replace("Seleccione",""));
                                            item.getItemProperty("Número de Documento 3").setValue(listSCB.get(23).get(i));
                                            item.getItemProperty("Estado").setValue(estado);
                                        }
                                    }
                                    tabla.setContainerDataSource(ic);
                                    tabla.setImmediate(true);
                                    vertical.setImmediate(true);
                                }
                            });
                        }
                    }
                }
            });

        }
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

    public ComboBox LlenarTipoDocr1() {
        Iterator<TipoDocumento> LTipo = null;
        LTipo = facade.RetornarDocumentoRepresentanteL().iterator();
        TipoDocumento TP = null;
        cbxtipDocumentoR1.setNullSelectionAllowed(false);
        cbxtipDocumentoR1.setTextInputAllowed(false);
        cbxtipDocumentoR1.addItem("");
        cbxtipDocumentoR1.setItemCaption("", "Seleccione");
        cbxtipDocumentoR1.select("");
        while (LTipo.hasNext()) {
            TP = LTipo.next();
            cbxtipDocumentoR1.addItem(TP.getTipodocumento());
            cbxtipDocumentoR1.setItemCaption(TP.getTipodocumento(), TP.getNombredoc());
        }

        return cbxtipDocumentoR1;
    }

    public ComboBox LlenarTipoDocr2() {
        Iterator<TipoDocumento> LTipo = null;
        LTipo = facade.RetornarDocumentoRepresentanteL().iterator();
        TipoDocumento TP = null;
        cbxtipDocumentoR2.setNullSelectionAllowed(false);
        cbxtipDocumentoR2.setTextInputAllowed(false);
        cbxtipDocumentoR2.addItem("");
        cbxtipDocumentoR2.setItemCaption("", "Seleccione");
        cbxtipDocumentoR2.select("");
        while (LTipo.hasNext()) {
            TP = LTipo.next();
            cbxtipDocumentoR2.addItem(TP.getTipodocumento());
            cbxtipDocumentoR2.setItemCaption(TP.getTipodocumento(), TP.getNombredoc());
        }

        return cbxtipDocumentoR2;
    }

    public ComboBox LlenarTipoDocr3() {
        Iterator<TipoDocumento> LTipo = null;
        LTipo = facade.RetornarDocumentoRepresentanteL().iterator();
        TipoDocumento TP = null;
        cbxtipDocumentoR3.setNullSelectionAllowed(false);
        cbxtipDocumentoR3.setTextInputAllowed(false);
        cbxtipDocumentoR3.addItem("");
        cbxtipDocumentoR3.setItemCaption("", "Seleccione");
        cbxtipDocumentoR3.select("");
        while (LTipo.hasNext()) {
            TP = LTipo.next();
            cbxtipDocumentoR3.addItem(TP.getTipodocumento());
            cbxtipDocumentoR3.setItemCaption(TP.getTipodocumento(), TP.getNombredoc());
        }

        return cbxtipDocumentoR3;
    }

    public ComboBox LlenarTipoDocumentos() {
        Iterator<TipoDocumento> LTipo = null;
        LTipo = facade.RetornarDocumentos().iterator();
        TipoDocumento TP = null;
        ComboBox combo = new ComboBox();
        combo.setTextInputAllowed(false);
        combo.setNullSelectionAllowed(false);
        combo.addItem("");
        combo.setItemCaption("", "Seleccione");
        while (LTipo.hasNext()) {
            TP = LTipo.next();
            if (TP.getTipodocumento() == 1 || TP.getTipodocumento() == 2 || TP.getTipodocumento() == 3 || TP.getTipodocumento() == 4 || TP.getTipodocumento() == 5 || TP.getTipodocumento() == 6) {
                combo.addItem(TP.getTipodocumento());
                combo.setItemCaption(TP.getTipodocumento(), TP.getNombredoc());
            }
        }
        return combo;
    }
    
   

    public void editarTabla() {
        tabla.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(ValueChangeEvent event) {
                Integer itemId = (Integer) tabla.getValue();
                int icIndex = (Integer) ic.indexOfId(itemId);
                try {
                    select = 1;
                    codigoScb = ic.getContainerProperty((itemId), "Código SCB/Entidad").getValue().toString();
                    scbEntidad = ic.getContainerProperty((itemId), "SCB/Entidad").getValue().toString();
                    tipDocumento = ic.getContainerProperty((itemId), "Tipo Documento").getValue().toString();
                    numDocumento = ic.getContainerProperty((itemId), "Número de Documento").getValue().toString();
                    digVerificacion = ic.getContainerProperty((itemId), "Dígito de Verificación").getValue().toString();
                    direccion = ic.getContainerProperty((itemId), "Dirección").getValue().toString();
                    telefono = ic.getContainerProperty((itemId), "Teléfono").getValue().toString();
                    repre1 = ic.getContainerProperty((itemId), "Representante Legal 1").getValue().toString();
                    tipodoc = ic.getContainerProperty((itemId), "Tipo Documento 1").getValue().toString();                    
                    tipodocnum = ic.getContainerProperty((itemId), "Número de Documento 1").getValue().toString();                    
                    repre2 = ic.getContainerProperty((itemId), "Representante Legal 2").getValue().toString();
                    tipodoc2 = ic.getContainerProperty((itemId), "Tipo Documento 2").getValue().toString();                    
                    tipodocnum2 = ic.getContainerProperty((itemId), "Número de Documento 2").getValue().toString(); 
                    repre3 = ic.getContainerProperty((itemId), "Representante Legal 3").getValue().toString();
                    tipodoc3 = ic.getContainerProperty((itemId), "Tipo Documento 3").getValue().toString();                    
                    tipodocnum3 = ic.getContainerProperty((itemId), "Número de Documento 3").getValue().toString(); 
                    estado = ic.getContainerProperty((itemId), "Estado").getValue().toString();
                    

                } catch (NullPointerException ex) {
                    codigoScb = "";
                    scbEntidad = "";
                    tipDocumento = "";
                    numDocumento = "";
                    digVerificacion = "";
                    direccion = "";
                    telefono = "";
                    repre1 = "";
                    repre2 = "";
                    repre3 = "";
                    estado = "";
                    tipodoc ="";
                    tipodocnum ="";
                    tipodoc2 ="";
                    tipodocnum2 ="";
                    tipodoc3 ="";
                    tipodocnum3 ="";


                }

            }
        });

    }

    public void filtrarTabla() {

        String codigoscb = "";
        String entidad = "";
        int comboEst = 0;

        List<List<String>> listSCB;

        try {
            codigoscb = txtCodigoScbFiltros.getValue();

        } catch (Exception e) {
            codigoscb = "";

        }

        try {
            entidad = txtScbEntidadFiltros.getValue();

        } catch (Exception e) {
            entidad = "";

        }

        try {
            comboEst = (Integer) cbxEstadoFiltro.getValue();
        } catch (NullPointerException e) {
            comboEst = 3;
        } catch (ClassCastException ex) {
            comboEst = 3;
        }

        listSCB = scb.ListarscbFiltros(codigoscb, entidad, comboEst);
        int i;

        tabla.getContainerDataSource().removeAllItems();
        if (listSCB.get(0).size() != 0) {
            for (i = 0; i < listSCB.get(0).size(); i++) {

                String estado = "";
                if (listSCB.get(16).get(i).equals("1")) {
                    estado = "Activo";
                } else if (listSCB.get(16).get(i).equals("2")) {
                    estado = "Inactivo";
                }
                String codigo = "";

                codigo = (listSCB.get(17).get(i));
                if (codigo.length() == 2) {
                    String cerouno = "0";
                    codigo = cerouno.concat(codigo);
                } else if (codigo.length() == 1) {
                    String cerodos = "00";
                    codigo = cerodos.concat(codigo);
                }

                Item item = ic.addItem(i);
                item.getItemProperty("Código SCB/Entidad").setValue(codigo);
                item.getItemProperty("SCB/Entidad").setValue(listSCB.get(3).get(i));
                item.getItemProperty("Tipo Documento").setValue(listSCB.get(2).get(i));
                item.getItemProperty("Número de Documento").setValue(listSCB.get(1).get(i));
                item.getItemProperty("Dígito de Verificación").setValue(listSCB.get(15).get(i));
                item.getItemProperty("Dirección").setValue(listSCB.get(6).get(i));
                item.getItemProperty("Teléfono").setValue(listSCB.get(7).get(i));
                item.getItemProperty("Representante Legal 1").setValue(listSCB.get(5).get(i));
                item.getItemProperty("Tipo Documento 1").setValue(listSCB.get(18).get(i));
                item.getItemProperty("Número de Documento 1").setValue(listSCB.get(19).get(i));                
                item.getItemProperty("Representante Legal 2").setValue(listSCB.get(13).get(i));
                item.getItemProperty("Tipo Documento 2").setValue(listSCB.get(20).get(i));
                item.getItemProperty("Número de Documento 2").setValue(listSCB.get(21).get(i));     
                item.getItemProperty("Representante Legal 3").setValue(listSCB.get(14).get(i));
                item.getItemProperty("Tipo Documento 3").setValue(listSCB.get(22).get(i));
                item.getItemProperty("Número de Documento 3").setValue(listSCB.get(23).get(i));     
                item.getItemProperty("Estado").setValue(estado);

            }
        } else {
            Notification.show("No existen registros", Notification.Type.ERROR_MESSAGE);
        }

        editarTabla();
        tabla.setContainerDataSource(ic);
        tabla.setImmediate(true);
        tabla.setColumnReorderingAllowed(true);
        tabla.setSortAscending(true);
        tabla.setSizeFull();
        tabla.setImmediate(true);

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
        if (txtCodigoScb.getComponentError() != null) {
            return true;
        }
        if (txtscbEntidad.getComponentError() != null) {
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

        if (txtTelefono.getComponentError() != null) {
            return true;
        }

        if (txtRepresentanteLeg1.getComponentError() != null) {
            return true;
        }
        if (cbxtipDocumentoR1.getComponentError() != null) {
            return true;
        }
        if (txtnumeroDocR1.getComponentError() != null) {
            return true;
        }

        if (!txtRepresentanteLeg2.getValue().isEmpty()) {
            if (txtRepresentanteLeg2.getComponentError() != null) {
                return true;
            }
            if (cbxtipDocumentoR2.getComponentError() != null) {
                return true;
            }
            if (txtnumeroDocR2.getComponentError() != null) {
                return true;
            }
        }

        if (!txtRepresentanteLeg3.getValue().isEmpty()) {
            if (txtRepresentanteLeg3.getComponentError() != null) {
                return true;
            }
            if (cbxtipDocumentoR3.getComponentError() != null) {
                return true;
            }
            if (txtnumeroDocR3.getComponentError() != null) {
                return true;
            }
        }

        return errores;
    }

    public boolean validalfaNum(String cadena) {

        boolean alfanumerico = true;

        if (cadena.matches(regexLetras)) {
            alfanumerico = false;
        } else if (cadena.matches(regexNumeric)) {
            alfanumerico = false;
        }

        return alfanumerico;
    }

}

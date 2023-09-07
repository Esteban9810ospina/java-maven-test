/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.ui.contents;

import com.framework.common.service.security.MyUserDetailsService;
import com.framework.common.ui.GenericContent;
import com.framework.common.ui.GenericTab;
import com.framework.common.ui.util.AppConstants;
import com.quasar.frameq.data.TipoDocumento;
import com.quasar.frameq.db.Facade;
import com.framework.common.ui.util.ValidarCampos;
import com.quasar.frameq.data.OrigenMILA;
import com.quasar.frameq.data.Parametrizacion;
import com.quasar.frameq.data.SCB;
import com.vaadin.data.Property;
import com.vaadin.data.Validator;
import com.vaadin.event.FieldEvents;
import com.vaadin.server.Sizeable;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.UserError;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.dialogs.ConfirmDialog;

/**
 * @author Administrador
 */
public class CrearAceptaciones extends GenericContent {

    private static final Logger logger = Logger.getLogger(CrearAceptaciones.class.getName());
    @Autowired
    private MyUserDetailsService userDetailsService;

    String regexNumeric = "^[0-9]*$";
    String regexNumericPuntComa = "^[0-9,]*$";
    String regexNumericPuntComamonto = "^[0-9.,]*$";
    String regexTresDecimales = "\\d+(\\,\\d{1,3}|,{1})?";
    String regexNumericFormat = "^[0-9\\.]*$";
    String regexAlphaSpace = "^[ a-zA-Z0-9\\s]*$";
    String regexAlpha = "^[a-zA-Z0-9]*$";
    String regexLetras = "^[a-zA-Z]*$";
    String regexTextTildes = "^[a-zA-ZñáéíóúÑÁÉÍÓÚ\\s]*$";
    String regexTextTildesNumeros = "^[a-zA-Z0-9ñáéíóúÑÁÉÍÓÚ\\s]*$";
    
    
    
    ValidarCampos validacion = new ValidarCampos();
    Facade facade = new Facade();

    
    Label lbGeneral;
    Label lbNombres;
    Label lbEspecialFid;
    Label lbNombrereLegal;
    Label lbPorcentajeComision;
    Label lbPorcentajeSimbolo = new Label("");
    Label lbPorcentaje;
    Label lbError = new Label("");
    Label lbFecha = new Label();
    Label lbClaseAcciones = new Label();
    
    
    Label lbNombreSCB = new Label();
    Label lbCodigoSCB = new Label();
    ComboBox comboTodoNada = new ComboBox();
    Label lbErrorTodoNada = new Label();
    ComboBox comboExistePreacuerdo = new ComboBox();
    Label lbErrorExistePreacuerdo = new Label();
    TextField numeroAccionesven = new TextField();
    Label erracciones = new Label();
    
    ComboBox cmbTipoDoc = new ComboBox();
    Label errTipoDocumento = new Label();
    TextField numDocumento = new TextField();
    Label errDocumento = new Label();
    TextField txtIden = new TextField();
    Label errIden1 = new Label();
    TextField txtEspFIDU = new TextField();
    Label errEspFIDU = new Label();
    Label lbltitulo2 = new Label();
    ComboBox cmbOrigenMila = new ComboBox();
    Label errOrigenMila = new Label();

    Label lbErrortConsecutivoOferta = new Label();
    TextField textConsecutivoOferta = new TextField();
    TextField porcentajeComision = new TextField();
    Label errporcentajeComision = new Label();

    TextField txtCuentainv = new TextField();
    Label errCuentaInversionista = new Label();

    ComboBox txtrepresentante = new ComboBox();
    Label errNombreRepresentante = new Label();

    TextArea texto1 = new TextArea();
    TextArea texto2 = new TextArea();
    Button btnGuardar = new Button();

    //***************Nuevos campos para OPI********************:
    //Label
    Label lbl_montoTotalAccionesVender = new Label("Monto Total de las Acciones que acepto vender");
    Label lbl_porcentajePagoEfectivo = new Label("Porcentaje para pago en efectivo");
    Label lbl_porcentajePagoEfectivoList = new Label("Forma de Pago");
    Label lbl_direccion = new Label("Dirección");

    //Lbl campos oblgatorios (asteriscos)
    Label lbl_asteriscoMontoTotalAccionesVender = new Label("*");
    Label lbl_asteriscoPorcentajePagoEfectivo = new Label("*");
    Label lbl_asteriscoPorcentajePagoEfectivoList = new Label("*");
    Label lbl_asteriscoNombre = new Label("*");

    //Lbl de campos con error
    Label lbl_errMontoTotalAccionesVender = new Label();
    Label lbl_errPorcentajePagoEfectivo = new Label();
    Label lbl_errPorcentajePagoEfectivoList = new Label();
    Label lbl_errTerminosCondicion1 = new Label(); //Label Error número de la aceptación Lwph
    Label lbl_errTerminosCondicion2 = new Label(); //Label Error número de la aceptación Lwph
    Label lbl_errNombres = new Label();
    //Label lbl_errDireccion = new Label();

    //Campos nuevos para OPI
    TextField txtf_montoTotalAccionesVender = new TextField();
    TextField txtf_porcentajePagoEfectivo = new TextField();
    ComboBox cbox_porcentajePagoEfectivoList = new ComboBox();
    TextArea texto3 = new TextArea();
    TextArea texto4 = new TextArea();
    CheckBox txtf_TerminosCondicion1 = new CheckBox("Aceptar"); //TextField Términos y condiciones 1 Lwph
    CheckBox txtf_TerminosCondicion2 = new CheckBox("Aceptar"); //TextField Términos y condiciones 2  Lwph
    TextField nombres = new TextField();
    TextField txtf_direccion = new TextField();

    String condicion1 = "";
    String condicion2 = "";

    int msnError = 0;
    int valorCombo = 0;
    int comboMILA = 0;
    Integer comboTN = 0;
    int comboPre = 0;
    int valorComboTipoDocumento = 0;
    int controlPreacuerdo = 0;
    boolean controlTN = false;
    String NID;
    // String PerfilActual = "";
    String listPar = "";
    //String[] resultadoLista = null;
    Parametrizacion parametrizacion = null;
    String codBolsa = "";

    String txtrepresentante1 = "";

    String pattern = "###,###,###,###,###,###";
    DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
    DecimalFormat moneyFormatter = new DecimalFormat(pattern);
    final DecimalFormat form2 = new DecimalFormat("##0.000");
    //String horario = validacion.fechaIngreso();

    final DecimalFormat form3 = new DecimalFormat("###,###.00");

    /*  Esta variable de instancia será consultada 
        por la lógica  este formulario de Oferta pública integrada.
     */
    List<String> parametros = null;
    HorizontalLayout vlCabEncabezadoCondicionesEmision = new HorizontalLayout();
    ;
    int porcentajeEfectivoParametrizado = 0;
    int comboPorcentajeLis = 0;

    public CrearAceptaciones(GenericTab parentTab) {
        super(parentTab);
    }

    @Override
    public void initForm() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");

        txtf_TerminosCondicion1.setValue(false);
        txtf_TerminosCondicion2.setValue(false);

        String horario = validacion.fechaIngreso();

        decimalFormatSymbols.setDecimalSeparator(',');
        decimalFormatSymbols.setGroupingSeparator('.');
        moneyFormatter.setDecimalFormatSymbols(decimalFormatSymbols);

        int hayParametrizacion = facade.validaHayParametros();
        if (hayParametrizacion == 1) {
            parametros = facade.RetornaParametros();
        }

        if (!horario.equals("")) {
            ConfirmDialog cd = ConfirmDialog.getFactory().create("Confirmación", "", "ACEPTAR", "", "");
            cd.setWidth("400px");
            cd.setHeight("160px");
            HorizontalLayout texto = new HorizontalLayout();
            HorizontalLayout buttons = new HorizontalLayout();
            buttons.setStyleName("btnAceptar");
            Label lblmensaje = new Label(horario, ContentMode.HTML);
            texto.addComponent(lblmensaje);
            buttons.addComponent(cd.getOkButton());
            VerticalLayout content = new VerticalLayout(lblmensaje, buttons);
            content.setStyleName("verticalDialog");
            content.setSizeFull();
            content.setSpacing(true);
            cd.setContent(content);
            cd.show(UI.getCurrent(), new ConfirmDialog.Listener() {
                @Override
                public void onClose(ConfirmDialog cd) {

                }
            }, true);
        } else {
            txtEspFIDU.setEnabled(false);

            String cadena = "";
            String Nombrescb = "";
            String codigo = "";

            cadena = facade.RetornarSCBusu(userDetailsService.getUsuarioAutenticado().getId());

            String[] result = cadena.split(";");
            //nomSocComBol.setValue(result[1]);
            codigo = result[0];
            Nombrescb = result[1];
            codBolsa = result[2];

            lbCodigoSCB.setValue(codigo);
            lbNombreSCB.setValue(Nombrescb);

            String fechaAcep = facade.fechaAcepta(userDetailsService.getUsuarioAutenticado().getId());

            Calendar fechahoy = new GregorianCalendar();

            int año = fechahoy.get(Calendar.YEAR);
            int mes = fechahoy.get(Calendar.MONTH);
            int dia = fechahoy.get(Calendar.DAY_OF_MONTH);

            String diaLetras = facade.retornarDia(dia);

            String mesLetras = traermes(mes);

            String FechaActual = diaLetras + " (" + dia + ")" + " de " + mesLetras + " del " + año;

            //resultadoLista = facade.RetornarDatosPara();
            parametrizacion = facade.retornarParametrizacionParcial();
            decimalFormatSymbols.setDecimalSeparator(',');
            decimalFormatSymbols.setGroupingSeparator('.');
            moneyFormatter.setDecimalFormatSymbols(decimalFormatSymbols);
            moneyFormatter.setRoundingMode(RoundingMode.DOWN);

            texto1.setValue(parametrizacion.getTextoUno());

            VerticalLayout vlPadre = new VerticalLayout();
            GridLayout vlInv = new GridLayout(8, 33);
            vlInv.setSizeFull();
            vlInv.setWidth(100, Sizeable.Unit.PERCENTAGE);
            vlInv.setHeight(100, Sizeable.Unit.PERCENTAGE);

            //Cabecera
            texto1.setWidth("100%");
            vlInv.addComponent(texto1, 0, 0, 6, 0);
            texto1.setEnabled(false);

            HorizontalLayout vlCab = new HorizontalLayout();
            vlInv.setSizeFull();
            vlCab.setWidth(100, Sizeable.Unit.PERCENTAGE);
            vlCab.setHeight(100, Sizeable.Unit.PERCENTAGE);

            vlCab.setWidth("100%");
            Label lbltitulo = new Label("TÉRMINOS DE LA ACEPTACIÓN");
            lbltitulo.setWidthUndefined();
            lbltitulo.setStyleName("tituloInversionistatit");
            Embedded image = new Embedded(null, new ThemeResource("img/Inver.png"));
            image.setHeight("35px");
            image.setStyleName("InverImg");
            vlCab.addStyleName("tituloInversionista");
            vlCab.addComponents(image, lbltitulo);
            vlCab.setComponentAlignment(lbltitulo, Alignment.MIDDLE_CENTER);
            vlInv.addComponent(vlCab, 0, 1, 6, 1);

            //Menú Inversionista
            lbGeneral = new Label("Fecha de Aceptación");
            vlInv.setSpacing(true);
            vlInv.addComponent(lbGeneral, 0, 2);
            vlInv.setComponentAlignment(lbGeneral, Alignment.MIDDLE_LEFT);
            lbGeneral.setWidth(10, Sizeable.Unit.EM);
            Label asteriscos = new Label("*");
            asteriscos.setStyleName("asterix");

            vlInv.setSpacing(true);

            lbFecha.setValue(FechaActual);
            lbFecha.setReadOnly(true);
            vlInv.addComponent(lbFecha, 2, 2);
            vlInv.setComponentAlignment(lbFecha, Alignment.MIDDLE_LEFT);
            lbFecha.setWidth(12, Sizeable.Unit.EM);

            lbGeneral = new Label("Clase de Acciones");
            vlInv.addComponent(lbGeneral, 4, 2);
            vlInv.setComponentAlignment(lbGeneral, Alignment.MIDDLE_LEFT);
            lbGeneral.setWidth(9, Sizeable.Unit.EM);
            //vlInv.setSpacing(true);

            lbClaseAcciones.setValue(parametrizacion.getClaseAcciones());/////////////////////////viene de consulta
            vlInv.addComponent(lbClaseAcciones, 6, 2);
            vlInv.setComponentAlignment(lbClaseAcciones, Alignment.MIDDLE_LEFT);
            lbClaseAcciones.setWidth(11, Sizeable.Unit.EM);

            lbGeneral = new Label("Nombre y código de la SCB");
            vlInv.addComponent(lbGeneral, 0, 3);
            vlInv.setComponentAlignment(lbGeneral, Alignment.MIDDLE_LEFT);
            lbGeneral.setWidth(14, Sizeable.Unit.EM);
            asteriscos = new Label("*");
            asteriscos.setStyleName("asterix");

            vlInv.addComponent(lbNombreSCB, 2, 3);
            vlInv.setComponentAlignment(lbNombreSCB, Alignment.MIDDLE_LEFT);
            lbNombreSCB.setWidth(13, Sizeable.Unit.EM);
            lbCodigoSCB.setId("codSocComBol1style");
            vlInv.addComponent(lbCodigoSCB, 3, 3);
            vlInv.setComponentAlignment(lbCodigoSCB, Alignment.MIDDLE_RIGHT);
            lbCodigoSCB.setWidth(5, Sizeable.Unit.EM);

            lbGeneral = new Label("Consecutivo Oferta de Venta");
            vlInv.addComponent(lbGeneral, 4, 3);
            vlInv.setComponentAlignment(lbGeneral, Alignment.MIDDLE_LEFT);
            lbGeneral.setWidth(10, Sizeable.Unit.EM);
            //vlInv.setSpacing(true);

            asteriscos = new Label("*");
            asteriscos.setStyleName("asterix");
            vlInv.addComponent(asteriscos, 5, 3);
            vlInv.setComponentAlignment(asteriscos, Alignment.MIDDLE_RIGHT);
            asteriscos.setWidth(2, Sizeable.Unit.EM);

            textConsecutivoOferta.setMaxLength(8);
            vlInv.addComponent(textConsecutivoOferta, 6, 3);
            vlInv.setComponentAlignment(textConsecutivoOferta, Alignment.MIDDLE_LEFT);
            textConsecutivoOferta.setWidth(10, Sizeable.Unit.EM);

            lbErrortConsecutivoOferta.setStyleName("lblerrorestop");
            vlInv.addComponent(lbErrortConsecutivoOferta, 6, 4);
            textConsecutivoOferta.addBlurListener(new FieldEvents.BlurListener() {

                @Override
                public void blur(FieldEvents.BlurEvent event) {

                    if (textConsecutivoOferta.getValue().equals("")) {
                        textConsecutivoOferta.setComponentError(new UserError(""));
                        lbErrortConsecutivoOferta.setValue("Este campo es requerido");
                    } else {
                        if (!textConsecutivoOferta.getValue().equals("")) {
                            if (textConsecutivoOferta.getValue().matches(regexAlpha)) {
                                textConsecutivoOferta.setComponentError(null);
                                lbErrortConsecutivoOferta.setValue("");
                            } else {
                                textConsecutivoOferta.setComponentError(new UserError(""));
                                lbErrortConsecutivoOferta.setValue("Este campo contiene caracteres no válidos");
                            }
                        } else {
                            textConsecutivoOferta.setComponentError(null);
                            lbErrortConsecutivoOferta.setValue("");
                        }

                    }

                    ValidarError();
                }
            });

            //vlInv.setSpacing(true);
            //Aqui colocar condicional de mostrar
            lbGeneral = new Label("Se vende con condición Todo o Nada");
            lbGeneral.setWidth(13, Sizeable.Unit.EM);
            asteriscos = new Label("*");
            asteriscos.setStyleName("asterix");
            asteriscos.setWidth(2, Sizeable.Unit.EM);
            comboTodoNada.setTextInputAllowed(false);
            comboTodoNada.setNullSelectionAllowed(false);
            comboTodoNada.addItem("");
            comboTodoNada.setItemCaption("", "Seleccione");
            comboTodoNada.addItem(1);
            comboTodoNada.setItemCaption(1, "Si");
            comboTodoNada.addItem(2);
            comboTodoNada.setItemCaption(2, "No");
            comboTodoNada.setWidth(10, Sizeable.Unit.EM);

            cbox_porcentajePagoEfectivoList.setTextInputAllowed(false);
            cbox_porcentajePagoEfectivoList.setNullSelectionAllowed(false);
            cbox_porcentajePagoEfectivoList.addItem(0);
            cbox_porcentajePagoEfectivoList.setItemCaption(0, "Seleccione");
            cbox_porcentajePagoEfectivoList.addItem(1);
            cbox_porcentajePagoEfectivoList.setItemCaption(1, "Efectivo");
            cbox_porcentajePagoEfectivoList.addItem(2);
            cbox_porcentajePagoEfectivoList.setItemCaption(2, "Valores");

            comboTodoNada.select("");

            if (facade.isTNShow()) {
                controlTN = true;
                vlInv.addComponent(lbGeneral, 0, 5);
                vlInv.setComponentAlignment(lbGeneral, Alignment.MIDDLE_LEFT);
                vlInv.addComponent(asteriscos, 1, 5);
                vlInv.setComponentAlignment(asteriscos, Alignment.MIDDLE_RIGHT);
                vlInv.addComponent(comboTodoNada, 2, 5);
                vlInv.setComponentAlignment(comboTodoNada, Alignment.MIDDLE_LEFT);
                comboTodoNada.addBlurListener(new FieldEvents.BlurListener() {
                    @Override
                    public void blur(FieldEvents.BlurEvent event) {
                        if (comboTodoNada.getValue() == null || comboTodoNada.getValue().equals("")) {
                            comboTodoNada.setComponentError(new UserError(""));
                            lbErrorTodoNada.setValue("Este campo es requerido");
                        } else {
                            comboTodoNada.setComponentError(null);
                            lbErrorTodoNada.setValue("");
                        }
                        ValidarError();
                    }
                });
                comboTodoNada.setVisible(true);
                lbGeneral.setVisible(true);

            } else {
                controlTN = false;
                comboTodoNada.setVisible(false);
                lbGeneral.setVisible(false);
                comboTodoNada.setComponentError(null);
                lbErrorTodoNada.setValue("");
            }

            lbErrorTodoNada.setStyleName("lblerrores");
            vlInv.addComponent(lbErrorTodoNada, 2, 6);

            if (parametrizacion.getExistePreacuerdo().equals("1")) {      ///////////////////consulta
                //vlInv.setSpacing(true);
                lbGeneral = new Label("Existe Preacuerdo");
                vlInv.addComponent(lbGeneral, 4, 5);
                vlInv.setComponentAlignment(lbGeneral, Alignment.MIDDLE_LEFT);
                lbGeneral.setWidth(9, Sizeable.Unit.EM);
                asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 5, 5);
                vlInv.setComponentAlignment(asteriscos, Alignment.MIDDLE_RIGHT);
                asteriscos.setWidth(9, Sizeable.Unit.EM);

                comboExistePreacuerdo.setTextInputAllowed(false);
                comboExistePreacuerdo.setNullSelectionAllowed(false);
                comboExistePreacuerdo.addItem("");
                comboExistePreacuerdo.setItemCaption("", "Seleccione");
                comboExistePreacuerdo.addItem(1);
                comboExistePreacuerdo.setItemCaption(1, "Si");
                comboExistePreacuerdo.addItem(2);
                comboExistePreacuerdo.setItemCaption(2, "No");

                comboExistePreacuerdo.select("");

                vlInv.addComponent(comboExistePreacuerdo, 6, 5);
                vlInv.setComponentAlignment(comboExistePreacuerdo, Alignment.MIDDLE_LEFT);
                comboExistePreacuerdo.setWidth(10, Sizeable.Unit.EM);

                comboExistePreacuerdo.addBlurListener(new FieldEvents.BlurListener() {
                    @Override
                    public void blur(FieldEvents.BlurEvent event) {
                        if (comboExistePreacuerdo.getValue() == null || comboExistePreacuerdo.getValue().equals("")) {
                            comboExistePreacuerdo.setComponentError(new UserError(""));
                            lbErrorExistePreacuerdo.setValue("Este campo es requerido");
                        } else {
                            comboExistePreacuerdo.setComponentError(null);
                            lbErrorExistePreacuerdo.setValue("");
                        }
                        ValidarError();
                    }
                });

                lbErrorExistePreacuerdo.setStyleName("lblerrores");
                vlInv.addComponent(lbErrorExistePreacuerdo, 6, 6);
                vlInv.setComponentAlignment(lbErrorExistePreacuerdo, Alignment.TOP_CENTER);
            } else {
                comboExistePreacuerdo.setComponentError(null);
                lbErrorExistePreacuerdo.setValue("");
                controlPreacuerdo = 1;
            }

            // vlInv.setSpacing(true);
            lbGeneral = new Label("No. de Acciones que acepto vender (cantidad en números)");
            vlInv.addComponent(lbGeneral, 0, 7);
            vlInv.setComponentAlignment(lbGeneral, Alignment.MIDDLE_LEFT);
            lbGeneral.setWidth(13, Sizeable.Unit.EM);
            asteriscos = new Label("*");
            asteriscos.setStyleName("asterix1");
            vlInv.addComponent(asteriscos, 1, 7);
            vlInv.setComponentAlignment(asteriscos, Alignment.MIDDLE_RIGHT);
            asteriscos.setWidth(2, Sizeable.Unit.EM);

            numeroAccionesven.setMaxLength(11);
            numeroAccionesven.addBlurListener(new FieldEvents.BlurListener() {

                @Override
                public void blur(FieldEvents.BlurEvent event) {
                    if (numeroAccionesven.getValue().equals("")) {
                        numeroAccionesven.setComponentError(new UserError(""));
                        erracciones.setValue("Este campo es requerido");
                    } else if (numeroAccionesven.getValue().matches(regexNumericFormat)) {
                        if (EsEntero(numeroAccionesven.getValue())) {

                            Double num = 0.0;
                            BigDecimal precioAcc = new BigDecimal(Double.valueOf(parametros.get(9)));
                            BigDecimal cantidadAcc = new BigDecimal(Double.valueOf(numeroAccionesven.getValue().replace(".", "").split("&")[0]));
                            BigDecimal tot = precioAcc.multiply(cantidadAcc);
                            num = tot.doubleValue();
                            txtf_montoTotalAccionesVender.setValue(form3.format(num));

                            try {

                                numeroAccionesven.setValue(moneyFormatter.format(Double.parseDouble(numeroAccionesven.getValue().replace(".", "").split("&")[0])));
                                if ((!numeroAccionesven.getValue().toString().equalsIgnoreCase("0"))) {

                                    numeroAccionesven.setComponentError(null);
                                    erracciones.setValue("");
                                } else {
                                    numeroAccionesven.setComponentError(new UserError(""));
                                    erracciones.setValue("Cantidad de Acciones Invalida");
                                }

                            } catch (Validator.InvalidValueException e) {
                                numeroAccionesven.setComponentError(new UserError(""));
                                erracciones.setValue(e.getMessage());
                            }
                        } else {
                            numeroAccionesven.setComponentError(new UserError(""));
                            erracciones.setValue("Cantidad de Acciones Invalida");

                        }
                    } else {
                        numeroAccionesven.setComponentError(new UserError(""));
                        erracciones.setValue("Este campo contiene caracteres no válidos");
                    }
                    ValidarError();
                }
            });

            vlInv.addComponent(numeroAccionesven, 2, 7);

            erracciones.setStyleName("lblerrores");
            vlInv.addComponent(erracciones, 2, 8);
            vlInv.setComponentAlignment(erracciones, Alignment.TOP_CENTER);

            //nuevos campos de OPI start
            vlInv.addComponent(lbl_montoTotalAccionesVender, 4, 7);
            vlInv.setComponentAlignment(lbl_montoTotalAccionesVender, Alignment.MIDDLE_LEFT);
            lbl_montoTotalAccionesVender.setWidth(11, Sizeable.Unit.EM);

            lbl_asteriscoMontoTotalAccionesVender = new Label("<p align=\"right\" style=\\\"font-size:16px;color:rgb(0,0,0);width:2px\\\">$</p>", Label.CONTENT_RAW);
            vlInv.addComponent(lbl_asteriscoMontoTotalAccionesVender, 5, 7);
            vlInv.setComponentAlignment(asteriscos, Alignment.MIDDLE_RIGHT);
            lbl_asteriscoMontoTotalAccionesVender.setWidth(1, Sizeable.Unit.EM);

            txtf_montoTotalAccionesVender.addBlurListener(new FieldEvents.BlurListener() {

                @Override
                public void blur(FieldEvents.BlurEvent event) {

                    if (!txtf_montoTotalAccionesVender.getValue().equals("")) {

                        if (txtf_montoTotalAccionesVender.getValue().matches(regexNumericPuntComamonto)) {
                            try {
                                Double num = 0.0;
                                Number valor = form3.parse(txtf_montoTotalAccionesVender.getValue());
                                num = valor.doubleValue();
                                txtf_montoTotalAccionesVender.setValue(form3.format(num));
                                txtf_montoTotalAccionesVender.setComponentError(null);
                                txtf_montoTotalAccionesVender.setValue("");
                            } catch (ParseException ex) {
                                logger.error("OPI - " + CrearAceptaciones.class.getName(), ex);
                            }
                        } else {
                            txtf_montoTotalAccionesVender.setComponentError(new UserError(""));
                            lbl_errMontoTotalAccionesVender.setValue("Este campo contiene caracteres no válidos");
                        }
                    } else {
                        txtf_montoTotalAccionesVender.setComponentError(new UserError(""));
                        lbl_errMontoTotalAccionesVender.setValue("Este campo es requerido");
                    }
                    ValidarError();
                }
            });
            txtf_montoTotalAccionesVender.setMaxLength(30);
            vlInv.addComponent(txtf_montoTotalAccionesVender, 6, 7);
            vlInv.setComponentAlignment(txtf_montoTotalAccionesVender, Alignment.MIDDLE_LEFT);
            txtf_montoTotalAccionesVender.setWidth(10, Sizeable.Unit.EM);
            txtf_montoTotalAccionesVender.setEnabled(false);

            lbl_errMontoTotalAccionesVender.setStyleName("lblerrores");
            vlInv.addComponent(lbl_errMontoTotalAccionesVender, 6, 8);
            vlInv.setComponentAlignment(lbl_errMontoTotalAccionesVender, Alignment.TOP_CENTER);

            //DBABATIVA NUEVOS CAMPOS QUE FUERON PARAMETRIZADOS
            // vlInv.setSpacing(true);
            vlInv.addComponent(lbl_porcentajePagoEfectivo, 0, 9);
            vlInv.setComponentAlignment(lbl_porcentajePagoEfectivo, Alignment.MIDDLE_LEFT);
            lbl_porcentajePagoEfectivo.setWidth(13, Sizeable.Unit.EM);

            lbl_asteriscoPorcentajePagoEfectivo.setStyleName("asterix1");
            vlInv.addComponent(lbl_asteriscoPorcentajePagoEfectivo, 1, 9);
            vlInv.setComponentAlignment(lbl_asteriscoPorcentajePagoEfectivo, Alignment.MIDDLE_RIGHT);
            lbl_asteriscoPorcentajePagoEfectivo.setWidth(1, Sizeable.Unit.EM);

            txtf_porcentajePagoEfectivo.setMaxLength(3);
            txtf_porcentajePagoEfectivo.setId("txtf_porcentajePagoEfectivo");

            vlInv.addComponent(txtf_porcentajePagoEfectivo, 2, 9);
            vlInv.setComponentAlignment(txtf_porcentajePagoEfectivo, Alignment.MIDDLE_LEFT);

            lbPorcentajeSimbolo = new Label("<p align=\"left\" style=\\\"font-size:16px;color:rgb(0,0,0);width:2px\\\">%</p>", Label.CONTENT_RAW);
            //lbPorcentaje = new Label("%");
            //lbPorcentaje.setStyleName("asterix3");
            lbl_porcentajePagoEfectivo.setId("lbPorcentaje");

            vlInv.addComponent(lbPorcentajeSimbolo, 3, 9);
            vlInv.setComponentAlignment(lbPorcentajeSimbolo, Alignment.MIDDLE_LEFT);

            lbl_errPorcentajePagoEfectivo.setStyleName("lblerrores");
            vlInv.addComponent(lbl_errPorcentajePagoEfectivo, 2, 10);

            txtf_porcentajePagoEfectivo.addBlurListener(new FieldEvents.BlurListener() {

                @Override
                public void blur(FieldEvents.BlurEvent event) {

                    if (txtf_porcentajePagoEfectivo.getValue().equals("")) {
                        txtf_porcentajePagoEfectivo.setComponentError(new UserError(""));
                        lbl_errPorcentajePagoEfectivo.setValue("Este campo es requerido");
                    } else {
                        if (!txtf_porcentajePagoEfectivo.getValue().equals("")) {
                            if (txtf_porcentajePagoEfectivo.getValue().matches(regexNumeric)) {
                                if (Integer.parseInt(txtf_porcentajePagoEfectivo.getValue()) <= 100) {
                                    txtf_porcentajePagoEfectivo.setComponentError(null);
                                    lbl_errPorcentajePagoEfectivo.setValue("");
                                } else {
                                    txtf_porcentajePagoEfectivo.setComponentError(new UserError(""));
                                    lbl_errPorcentajePagoEfectivo.setValue("Porcentaje no válido, debe ser entre 0% y 100%");
                                }
                            } else {
                                txtf_porcentajePagoEfectivo.setComponentError(new UserError(""));
                                lbl_errPorcentajePagoEfectivo.setValue("Este campo contiene caracteres no válidos");
                            }

                        } else {
                            txtf_porcentajePagoEfectivo.setComponentError(null);
                            lbl_errPorcentajePagoEfectivo.setValue("");
                        }

                    }

                    ValidarError();
                }
            });

            //porcentaje pago efectivo list
            vlInv.addComponent(lbl_porcentajePagoEfectivoList, 4, 9);
            vlInv.setComponentAlignment(lbl_porcentajePagoEfectivoList, Alignment.MIDDLE_LEFT);
            lbl_porcentajePagoEfectivoList.setWidth(11, Sizeable.Unit.EM);

            lbl_asteriscoPorcentajePagoEfectivoList.setStyleName("asterix");
            vlInv.addComponent(lbl_asteriscoPorcentajePagoEfectivoList, 5, 9);
            vlInv.setComponentAlignment(lbl_asteriscoPorcentajePagoEfectivoList, Alignment.MIDDLE_RIGHT);
            lbl_asteriscoPorcentajePagoEfectivoList.setWidth(1, Sizeable.Unit.EM);

            vlInv.addComponent(cbox_porcentajePagoEfectivoList, 6, 9);

            lbl_errPorcentajePagoEfectivoList.setStyleName("lblerrores");
            vlInv.addComponent(lbl_errPorcentajePagoEfectivoList, 6, 10);

            //Aqui van validaciones para el campo lista de selección de Manual o Predeterminada
            cbox_porcentajePagoEfectivoList.addBlurListener(new FieldEvents.BlurListener() {
                @Override
                public void blur(FieldEvents.BlurEvent event) {
                    if (cbox_porcentajePagoEfectivoList.getValue() == null || cbox_porcentajePagoEfectivoList.getValue().equals(0)) {
                        cbox_porcentajePagoEfectivoList.setComponentError(new UserError(""));
                        lbl_errPorcentajePagoEfectivoList.setValue("Este campo es requerido");
                    } else {
                        cbox_porcentajePagoEfectivoList.setComponentError(null);
                        lbl_errPorcentajePagoEfectivoList.setValue("");
                    }
                    ValidarError();
                }
            });

            //DBABATIVA NUEVOS CAMPOS QUE3 FUERON PARAMETRIZADOS END
            //nuevos campos OPI end
            texto2.setWidth("100%");
            texto2.setValue(parametrizacion.getTextoDos());
            vlInv.addComponent(texto2, 0, 11, 6, 11);
            texto2.setEnabled(false);

            /////////MODULO DOS - CONDICIONES DE ACEPTACIÓN DE LA EMISIÓN//////////////////////////////////////7
            vlCabEncabezadoCondicionesEmision = new HorizontalLayout();
            vlCabEncabezadoCondicionesEmision.setWidth("100%");
            lbltitulo2 = new Label("CONDICIONES DE ACEPTACIÓN DE LA EMISIÓN");
            lbltitulo2.setWidthUndefined();
            lbltitulo2.setStyleName("tituloInversionistatit");
            Embedded image2 = new Embedded(null, new ThemeResource("img/Inver.png"));
            image2.setHeight("35px");
            image2.setStyleName("InverImg");
            vlCabEncabezadoCondicionesEmision.addStyleName("tituloInversionista");
            vlCabEncabezadoCondicionesEmision.addComponents(image2, lbltitulo2);
            vlCabEncabezadoCondicionesEmision.setComponentAlignment(lbltitulo2, Alignment.MIDDLE_CENTER);
            vlInv.addComponent(vlCabEncabezadoCondicionesEmision, 0, 12, 6, 12);

            //Texto3        
            texto3.setWidth("100%");
            texto3.setValue(parametrizacion.getTextoTres());
            vlInv.addComponent(texto3, 0, 13, 4, 14);
            texto3.setEnabled(false);

            //Agrega el Checbok de las condiciones de aceptación
            vlInv.addComponent(txtf_TerminosCondicion1, 5, 13, 6, 13);
            vlInv.setComponentAlignment(txtf_TerminosCondicion1, Alignment.MIDDLE_CENTER);

            lbl_errTerminosCondicion1.setStyleName("lblerrores");
            vlInv.addComponent(lbl_errTerminosCondicion1, 6, 14);

            txtf_TerminosCondicion1.addValueChangeListener(new Property.ValueChangeListener() {
                @Override
                public void valueChange(Property.ValueChangeEvent event) {
                    boolean isSelected = txtf_TerminosCondicion1.getValue();

                    if (isSelected) {
                        txtf_TerminosCondicion1.setValue(true);
                        txtf_TerminosCondicion1.setComponentError(null);
                        lbl_errTerminosCondicion1.setValue("");
                        condicion1 = "S";
                    } else {
                        txtf_TerminosCondicion1.setValue(false);
                        txtf_TerminosCondicion1.setComponentError(new UserError(""));
                        lbl_errTerminosCondicion1.setValue("Debe aceptar condiciones");
                        condicion1 = "N";
                    }
//               System.out.println( txtf_TerminosCondicion1.getValue());

                    ValidarError();
                }

            });

            //Texto 4       
            texto4.setWidth("100%");
            texto4.setValue(parametrizacion.getTextoCuatro());
            vlInv.addComponent(texto4, 0, 15, 4, 16);
            texto4.setEnabled(false);

/////////////combobox
            vlInv.addComponent(txtf_TerminosCondicion2, 5, 15, 6, 15);
            vlInv.setComponentAlignment(txtf_TerminosCondicion2, Alignment.MIDDLE_CENTER);

            lbl_errTerminosCondicion2.setStyleName("lblerrores");
            vlInv.addComponent(lbl_errTerminosCondicion2, 6, 16);

            txtf_TerminosCondicion2.addValueChangeListener(new Property.ValueChangeListener() {
                @Override
                public void valueChange(Property.ValueChangeEvent event) {
                    boolean isSelected = txtf_TerminosCondicion2.getValue();
                    if (isSelected) {
                        txtf_TerminosCondicion2.setValue(true);
                        txtf_TerminosCondicion2.setComponentError(null);
                        lbl_errTerminosCondicion2.setValue("");
                        condicion2 = "S";
                    } else {
                        txtf_TerminosCondicion2.setValue(false);
                        txtf_TerminosCondicion2.setComponentError(new UserError(""));
                        lbl_errTerminosCondicion2.setValue("Debe aceptar condiciones");
                        condicion2 = "S";
                    }
//               System.out.println( txtf_TerminosCondicion2.getValue());
                    ValidarError();
                }
            });

            //Datos del Vendedor de OPI 
            vlCab = new HorizontalLayout();
            vlCab.setWidth("100%");
            lbltitulo = new Label("DATOS DEL VENDEDOR");
            lbltitulo.setStyleName("tituloInversionistatit");
            image = new Embedded(null, new ThemeResource("img/Inver.png"));
            image.setStyleName("InverImg");
            image.setHeight("35px");
            vlCab.addStyleName("tituloInversionista");
            vlCab.addComponent(image);
            vlCab.addComponent(lbltitulo);
            vlCab.setComponentAlignment(lbltitulo, Alignment.MIDDLE_CENTER);
            vlInv.addComponent(vlCab, 0, 18, 6, 18);

            //Menú Apoderado
            if (Integer.parseInt(parametros.get(44)) == 1) {
                lbGeneral = new Label("Origen Operación MILA");
                vlInv.addComponent(lbGeneral, 0, 19);
                vlInv.setComponentAlignment(lbGeneral, Alignment.MIDDLE_LEFT);
                lbGeneral.setWidth(13, Sizeable.Unit.EM);
                cmbOrigenMila = listarOrigenMILA();
                vlInv.addComponent(cmbOrigenMila, 2, 19);
                vlInv.setComponentAlignment(cmbOrigenMila, Alignment.MIDDLE_LEFT);
                cmbOrigenMila.setWidth(9, Sizeable.Unit.EM);
                cmbOrigenMila.addBlurListener(new FieldEvents.BlurListener() {
                    @Override
                    public void blur(FieldEvents.BlurEvent event) {
                        if (cmbOrigenMila.getValue() == null || cmbOrigenMila.getValue().equals("")) {
                            cmbTipoDoc.setValue("");
                            cmbTipoDoc.setEnabled(true);
                            nombres.setValue("");
                            nombres.setVisible(true);
                            lbNombres.setVisible(true);
                            numDocumento.setValue("");
                            numDocumento.setEnabled(true);
                            txtIden.setValue("");
                            txtIden.setEnabled(true);
                            txtCuentainv.setValue("");
                            txtCuentainv.setEnabled(true);
                            lbEspecialFid.setVisible(true);
                            txtEspFIDU.setVisible(true);                         
                            lbl_asteriscoNombre.setVisible(true);
                            lbl_errNombres.setVisible(true);
                            lbl_direccion.setVisible(true);
                            txtf_direccion.setVisible(true);
                        }
                    }
                });
                cmbOrigenMila.addValueChangeListener(new Property.ValueChangeListener() {
                    @Override
                    public void valueChange(Property.ValueChangeEvent event) {
                        try {
                            comboMILA = (Integer) cmbOrigenMila.getValue();
                            if (comboMILA > 0) {
                                OrigenMILA m = llenadoCampoMILA(comboMILA);
                                nombres.setVisible(true);
                                nombres.setValue(m.getPais());
                                nombres.setComponentError(null);
                                lbNombres.setVisible(true);
                                lbl_asteriscoNombre.setVisible(true);
                                lbl_errNombres.setVisible(true);
                                errTipoDocumento.setValue("");
                                errIden1.setValue("");
                                errCuentaInversionista.setValue("");
                                cmbTipoDoc.setValue(4);
                                cmbTipoDoc.setEnabled(false);
                                numDocumento.setValue(m.getNumeroDocumento());
                                numDocumento.setEnabled(false);
                                errDocumento.setValue("");
                                txtIden.setValue(m.getNumVerificacion());
                                txtIden.setEnabled(false);
                                txtCuentainv.setValue(m.getCuenta());
                                txtCuentainv.setEnabled(false);
                                lbEspecialFid.setVisible(false);
                                txtEspFIDU.setVisible(false);
                                lbl_direccion.setVisible(false);
                                txtf_direccion.setVisible(false);
                                cmbTipoDoc.setComponentError(null);
                                numDocumento.setComponentError(null);
                                txtIden.setComponentError(null);
                                txtCuentainv.setComponentError(null);
                            }
                            ValidarError();
                        } catch (NullPointerException e) {
                            comboMILA = 0;
                        } catch (ClassCastException ex) {
                            comboMILA = 0;
                        }
                    }
                });
                errOrigenMila.setStyleName("lblerrores");
                vlInv.addComponent(errOrigenMila, 2, 20);
                vlInv.setComponentAlignment(errOrigenMila, Alignment.TOP_CENTER);
            }
            lbNombres = new Label("Nombres y Apellidos / Razón Social");
            vlInv.addComponent(lbNombres, 0, 23);
            vlInv.setComponentAlignment(lbNombres, Alignment.MIDDLE_LEFT);
            lbNombres.setWidth(14, Sizeable.Unit.EM);
            lbl_asteriscoNombre = new Label("*");
            lbl_asteriscoNombre.setStyleName("asterix");
            vlInv.addComponent(lbl_asteriscoNombre, 1, 23);
            vlInv.setComponentAlignment(lbl_asteriscoNombre, Alignment.MIDDLE_RIGHT);
            lbl_asteriscoNombre.setWidth(2, Sizeable.Unit.EM);
            lbl_asteriscoNombre.setVisible(false);

            nombres.setMaxLength(60);
            vlInv.addComponent(nombres, 2, 23);
            vlInv.setComponentAlignment(nombres, Alignment.MIDDLE_LEFT);
            //nombres.setWidth(10, Sizeable.Unit.EM);

            nombres.addBlurListener(new FieldEvents.BlurListener() {
                @Override
                public void blur(FieldEvents.BlurEvent event) {
                    if (valorCombo != 0) {
                        if (!cmbTipoDoc.getValue().equals(4)) {
                            //!cmbTipoDoc.getValue().equals(4)||valorCombo!=0||
//                        System.out.println("combo__"+cmbTipoDoc.getValue().toString());
//                        System.out.println("valor__"+valorCombo);
                            if (nombres.getValue().equals("")) {
                                nombres.setComponentError(new UserError(""));
                                lbl_errNombres.setValue("Este campo es requerido");
                            } else {
                                if (nombres.getValue().matches(regexTextTildesNumeros)) {
                                    nombres.setComponentError(null);
                                    lbl_errNombres.setValue("");
                                } else {
                                    nombres.setComponentError(new UserError(""));
                                    lbl_errNombres.setValue("Este campo contiene caracteres no válidos");
                                }
                            }
                        } else {
                            if (nombres.getValue().equals("")) {
                                nombres.setComponentError(null);
                                lbl_errNombres.setValue("");
                            } else {
                                if (nombres.getValue().matches(regexTextTildesNumeros)) {
                                    nombres.setComponentError(null);
                                    lbl_errNombres.setValue("");
                                } else {
                                    nombres.setComponentError(new UserError(""));
                                    lbl_errNombres.setValue("Este campo contiene caracteres no válidos");
                                }
                            }
                        }
                    } else {
                        if (nombres.getValue().equals("")) {
                            nombres.setComponentError(null);
                            lbl_errNombres.setValue("");
                        } else {
                            if (nombres.getValue().matches(regexTextTildesNumeros)) {
                                nombres.setComponentError(null);
                                lbl_errNombres.setValue("");
                            } else {
                                nombres.setComponentError(new UserError(""));
                                lbl_errNombres.setValue("Este campo contiene caracteres no válidos");
                            }
                        }
                    }
                    ValidarError();
                }
            });

            lbl_errNombres.setStyleName("lblerrores");
            vlInv.addComponent(lbl_errNombres, 2, 24);
            vlInv.setComponentAlignment(lbl_errNombres, Alignment.TOP_CENTER);

            //Apellidos razon social
            /*tpID = new Label("Apellidos / Razón Social");
            vlInv.addComponent(tpID, 4, 23);
            vlInv.setComponentAlignment(tpID, Alignment.MIDDLE_LEFT);
            tpID.setWidth(10, Sizeable.Unit.EM);
            asteriscos = new Label("*");
            asteriscos.setStyleName("asterix");
            vlInv.addComponent(asteriscos, 5, 23);
            vlInv.setComponentAlignment(asteriscos, Alignment.MIDDLE_RIGHT);
            asteriscos.setWidth(2, Sizeable.Unit.EM);
            razonSocial.setMaxLength(30);
            vlInv.addComponent(razonSocial, 6, 23);
            vlInv.setComponentAlignment(razonSocial, Alignment.MIDDLE_LEFT);
            razonSocial.setWidth(10, Sizeable.Unit.EM);

            razonSocial.addBlurListener(new FieldEvents.BlurListener() {
                @Override
                public void blur(FieldEvents.BlurEvent event) {
                    if (razonSocial.getValue().equals("")) {
                        razonSocial.setComponentError(new UserError(""));
                        errRazonSocial.setValue("Este campo es requerido");
                    } else {
                        if (razonSocial.getValue().matches(regexTextTildesNumeros)) {
                            razonSocial.setComponentError(null);
                            errRazonSocial.setValue("");
                        } else {
                            razonSocial.setComponentError(new UserError(""));
                            errRazonSocial.setValue("Este campo contiene caracteres no válidos");
                        }
                    }
                    ValidarError();
                }
            });*/
            /*errRazonSocial.setStyleName("lblerrores");
            vlInv.addComponent(errRazonSocial, 6, 24);
            vlInv.setComponentAlignment(errRazonSocial, Alignment.TOP_CENTER);*/

            //Tipo Documento
            lbGeneral = new Label("Tipo de documento");
            vlInv.addComponent(lbGeneral, 0, 21);
            vlInv.setComponentAlignment(lbGeneral, Alignment.MIDDLE_LEFT);
            lbGeneral.setWidth(13, Sizeable.Unit.EM);
            asteriscos = new Label("*");
            asteriscos.setStyleName("asterix");
            vlInv.addComponent(asteriscos, 1, 21);
            vlInv.setComponentAlignment(asteriscos, Alignment.MIDDLE_RIGHT);
            asteriscos.setWidth(2, Sizeable.Unit.EM);
            cmbTipoDoc = LlenarTipoDocumento();
            vlInv.addComponent(cmbTipoDoc, 2, 21);
            vlInv.setComponentAlignment(cmbTipoDoc, Alignment.MIDDLE_LEFT);
            //cmbTipoDoc.setWidth(9, Sizeable.Unit.EM);

            cmbTipoDoc.addBlurListener(new FieldEvents.BlurListener() {
                @Override
                public void blur(FieldEvents.BlurEvent event) {
                    if (cmbTipoDoc.getValue() == null || cmbTipoDoc.getValue().equals("")) {
                        cmbTipoDoc.setComponentError(new UserError(""));
                        errTipoDocumento.setValue("Este campo es requerido");
                    } else {
                        cmbTipoDoc.setComponentError(null);
                        errTipoDocumento.setValue("");

                    }
                    ValidarError();
                }
            });

            cmbTipoDoc.addValueChangeListener(new Property.ValueChangeListener() {
                @Override
                public void valueChange(Property.ValueChangeEvent event) {

                    try {
                        //logger.info("valorCombo antes de volver entero - "+valorCombo);
                        //logger.info("cmbTipoDoc antes de volver entero - "+cmbTipoDoc.getValue());
                        valorCombo = (Integer) cmbTipoDoc.getValue();
                    } catch (NullPointerException e) {

                        valorCombo = 0;
                        //logger.error("OPI - "+CrearAceptaciones.class.getName(), e);
                    } catch (ClassCastException ex) {

                        valorCombo = 0;
                        //logger.error("OPI - "+CrearAceptaciones.class.getName(), ex);
                    }
                    if (valorCombo == 4) {
                        txtIden.setVisible(true);
                        txtEspFIDU.setEnabled(true);
                        txtEspFIDU.setValue("");
                        lbl_asteriscoNombre.setVisible(false);
                    } else {
                        if (valorCombo != 4) {
                            txtIden.setVisible(false);
                            txtIden.setValue("");
                            txtEspFIDU.setEnabled(false);
                            txtEspFIDU.setValue("");
                            txtIden.setComponentError(null);
                            errIden1.setValue("");
                            lbl_asteriscoNombre.setVisible(true);
                        }
                    }
                    if (valorCombo == 1 || valorCombo == 4 || valorCombo == 6) {
                        if (!numDocumento.getValue().matches(regexNumeric)) {
                            numDocumento.setComponentError(new UserError(""));
                            errDocumento.setValue("Este campo contiene caracteres no válidos");
                        }
                    } else {
                        errIden1.setValue("");
                        errIden1.setComponentError(null);
                        txtIden.setVisible(false);
                        txtIden.setValue("");
                        txtEspFIDU.setEnabled(false);
                        txtEspFIDU.setValue("");
                        txtIden.setComponentError(null);
                        txtEspFIDU.setComponentError(null);
                        errEspFIDU.setValue("");
                        numDocumento.setComponentError(null);
                        errDocumento.setValue("");
                        errDocumento.setComponentError(null);
                    }

                    //
                    if (valorCombo != 0) {
                        if (valorCombo != 4) {

                            if (nombres.getValue().equals("")) {
                                nombres.setComponentError(new UserError(""));
                                lbl_errNombres.setValue("Este campo es requerido");
//                                System.out.println("valor de valorcombo_"+valorCombo);
                            } else {
                                if (nombres.getValue().matches(regexTextTildesNumeros)) {
                                    nombres.setComponentError(null);
                                    lbl_errNombres.setValue("");
                                } else {
                                    nombres.setComponentError(new UserError(""));
                                    lbl_errNombres.setValue("Este campo contiene caracteres no válidos");
                                }
                            }
                        } else {
                            if (nombres.getValue().equals("")) {
                                nombres.setComponentError(null);
                                lbl_errNombres.setValue("");
                            } else {
                                if (nombres.getValue().matches(regexTextTildesNumeros)) {
                                    nombres.setComponentError(null);
                                    lbl_errNombres.setValue("");
                                } else {
                                    nombres.setComponentError(new UserError(""));
                                    lbl_errNombres.setValue("Este campo contiene caracteres no válidos");
                                }
                            }
                        }
                    } else {
                        nombres.setComponentError(null);
                        lbl_errNombres.setValue("");
                    }

                    ValidarError();
                }

            });

            errTipoDocumento.setStyleName("lblerrores");
            vlInv.addComponent(errTipoDocumento, 2, 22);
            vlInv.setComponentAlignment(errTipoDocumento, Alignment.TOP_CENTER);
            //vlInv.setSpacing(true);

            lbGeneral = new Label("Número de documento");
            vlInv.addComponent(lbGeneral, 4, 21);
            vlInv.setComponentAlignment(lbGeneral, Alignment.MIDDLE_LEFT);
            lbGeneral.setWidth(10, Sizeable.Unit.EM);
            asteriscos = new Label("*");
            asteriscos.setStyleName("asterix");
            vlInv.addComponent(asteriscos, 5, 21);
            vlInv.setComponentAlignment(asteriscos, Alignment.MIDDLE_RIGHT);
            asteriscos.setWidth(2, Sizeable.Unit.EM);
            numDocumento.setMaxLength(15);

            txtIden.setWidth("15px");
            txtIden.setId("txtIden");
            txtIden.setVisible(false);
            txtIden.setMaxLength(1);

            vlInv.addComponent(numDocumento, 6, 21);
            vlInv.setComponentAlignment(numDocumento, Alignment.MIDDLE_LEFT);
            numDocumento.setWidth(10, Sizeable.Unit.EM);

            numDocumento.addBlurListener(new FieldEvents.BlurListener() {

                @Override
                public void blur(FieldEvents.BlurEvent event) {
                    try {
                        valorCombo = (Integer) cmbTipoDoc.getValue();
                    } catch (NullPointerException ex) {
                        valorCombo = 0;
                        //logger.error("OPI - "+CrearAceptaciones.class.getName(), ex);
                    } catch (ClassCastException e) {
                        valorCombo = 0;
                        //logger.error("OPI - "+CrearAceptaciones.class.getName(), e);
                    }
                    numDocumento.setComponentError(null);
                    errDocumento.setValue("");
                    if (numDocumento.getValue().equals("")) {
                        numDocumento.setComponentError(new UserError(""));
                        errDocumento.setValue("Este campo es requerido");
                    }
                    if (valorCombo == 2 || valorCombo == 3 || valorCombo == 5) {
                        if (!numDocumento.getValue().matches(regexAlpha)) {
                            numDocumento.setComponentError(new UserError(""));
                            errDocumento.setValue("Este campo contiene caracteres no válidos");
                        }
                    } else {
                        if (!numDocumento.getValue().matches(regexNumeric)) {
                            numDocumento.setComponentError(new UserError(""));
                            errDocumento.setValue("Este campo contiene caracteres no válidos");
                        }
                    }

                    ValidarError();
                }
            });

            txtIden.addBlurListener(new FieldEvents.BlurListener() {

                @Override
                public void blur(FieldEvents.BlurEvent event) {
                    txtIden.setValue(txtIden.getValue().toUpperCase());
                    txtIden.setComponentError(null);
                    errIden1.setValue("");
                    if (!txtIden.getValue().equals("")) {
                        if (valorCombo == 2 || valorCombo == 3 || valorCombo == 5) {
                            if (!txtIden.getValue().matches(regexAlpha)) {
                                txtIden.setComponentError(new UserError(""));
                                errIden1.setValue("Este campo contiene caracteres no válidos");
                            } else if (!numDocumento.getValue().equals("")) {
                                if (validacion.validarRut(numDocumento.getValue()) != Integer.parseInt(txtIden.getValue())) {
                                    txtIden.setComponentError(new UserError(""));
                                    errIden1.setValue("El dígito de verificación ingresado no corresponde al NIT.");
                                } else {
                                    txtIden.setComponentError(null);
                                    errIden1.setValue("");
                                }
                            }
                        } else {
                            if (!txtIden.getValue().matches(regexNumeric)) {
                                txtIden.setComponentError(new UserError(""));
                                errIden1.setValue("Este campo contiene caracteres no válidos");
                            } else if (!numDocumento.getValue().equals("")) {
                                if (validacion.validarRut(numDocumento.getValue()) != Integer.parseInt(txtIden.getValue())) {
                                    txtIden.setComponentError(new UserError(""));
                                    errIden1.setValue("El dígito de verificación ingresado no corresponde al NIT.");
                                } else {
                                    txtIden.setComponentError(null);
                                    errIden1.setValue("");
                                }
                            }

                        }
                    } else {
                        txtIden.setComponentError(new UserError(""));
                        errIden1.setValue("Campo requerido");
                    }
                    ValidarError();
                }
            });
            txtIden.setId("txtIden");
            vlInv.addComponent(txtIden, 7, 21);
            vlInv.setComponentAlignment(txtIden, Alignment.MIDDLE_LEFT);
            txtIden.setWidth(2, Sizeable.Unit.EM);

            errDocumento.setStyleName("lblerrores");
            vlInv.addComponent(errDocumento, 6, 22);
            vlInv.setComponentAlignment(errDocumento, Alignment.TOP_CENTER);

            errIden1.setId("lblerrores1");
            vlInv.addComponent(errIden1, 7, 22);
            vlInv.setComponentAlignment(errIden1, Alignment.TOP_LEFT);
            lbGeneral.setWidth(8, Sizeable.Unit.EM);

            //Especial Fiduciario
            lbEspecialFid = new Label("Especial fiduciario");
            lbEspecialFid.setId("lblespecialFid");
            vlInv.addComponent(lbEspecialFid, 4, 27);
            vlInv.setComponentAlignment(lbEspecialFid, Alignment.MIDDLE_LEFT);
            lbEspecialFid.setWidth(8, Sizeable.Unit.EM);
            asteriscos = new Label("*");
            asteriscos.setStyleName("asterix");
            txtEspFIDU.setMaxLength(3);

            vlInv.addComponent(txtEspFIDU, 6, 27);
            vlInv.setComponentAlignment(txtEspFIDU, Alignment.MIDDLE_LEFT);
            txtEspFIDU.setWidth(10, Sizeable.Unit.EM);
            txtEspFIDU.addBlurListener(new FieldEvents.BlurListener() {

                @Override
                public void blur(FieldEvents.BlurEvent event) {
                    //txtEspFIDU.setValue(txtEspFIDU.getValue().toUpperCase());
                    txtEspFIDU.setValue(txtEspFIDU.getValue());
                    //if (!txtEspFIDU.getValue().equals("")) {
                    if (txtEspFIDU.getValue().matches(regexAlpha)) {
                        txtEspFIDU.setComponentError(null);
                        errEspFIDU.setValue("");
                    } else {
                        txtEspFIDU.setComponentError(new UserError(""));
                        errEspFIDU.setValue("Caracteres inválidos");
                    }
                    //} else {
                    //  txtEspFIDU.setComponentError(new UserError(""));
                    //  errEspFIDU.setValue("Este campo es requerido");
                    //}
                    ValidarError();
                }
            });

            errEspFIDU.setStyleName("lblerrores");
            vlInv.addComponent(errEspFIDU, 6, 28);
            vlInv.setComponentAlignment(errEspFIDU, Alignment.TOP_CENTER);

            //Cuenta inversionista
            lbGeneral = new Label("Cuenta Inversionista");
            vlInv.addComponent(lbGeneral, 0, 27);
            vlInv.setComponentAlignment(lbGeneral, Alignment.MIDDLE_LEFT);
            lbGeneral.setWidth(9, Sizeable.Unit.EM);
            asteriscos = new Label("*");
            asteriscos.setStyleName("asterix");
            vlInv.addComponent(asteriscos, 1, 27);
            vlInv.setComponentAlignment(asteriscos, Alignment.MIDDLE_RIGHT);
            asteriscos.setWidth(2, Sizeable.Unit.EM);

            txtCuentainv.setMaxLength(8);
            txtCuentainv.setId("/*txtNombreApo*/");
            vlInv.addComponent(txtCuentainv, 2, 27);

            vlInv.setComponentAlignment(txtCuentainv, Alignment.MIDDLE_LEFT);
            //txtCuentainv.setWidth(10, Sizeable.Unit.EM);
            txtCuentainv.addBlurListener(new FieldEvents.BlurListener() {

                @Override
                public void blur(FieldEvents.BlurEvent event) {

                    if (!txtCuentainv.getValue().equals("")) {
                        if (txtCuentainv.getValue().matches(regexNumeric)) {

                            if (Integer.parseInt(txtCuentainv.getValue()) > 0) {
                                txtCuentainv.setComponentError(null);
                                errCuentaInversionista.setValue("");
                            } else {
                                txtCuentainv.setComponentError(new UserError(""));
                                errCuentaInversionista.setValue("Cuenta Inversionista Inválida");
                            }

                        } else {
                            txtCuentainv.setComponentError(new UserError(""));
                            errCuentaInversionista.setValue("Este campo contiene caracteres no válidos");
                        }
                    } else {
                        txtCuentainv.setComponentError(new UserError(""));
                        errCuentaInversionista.setValue("Este campo es requerido");
                    }
                    ValidarError();
                }
            });

            lbNombrereLegal = new Label("Nombre del representante Legal de la SCB");
            lbNombrereLegal.setId("lblNombreRepLegal");
            vlInv.addComponent(lbNombrereLegal, 4, 29);
            vlInv.setComponentAlignment(lbNombrereLegal, Alignment.MIDDLE_LEFT);
            lbNombrereLegal.setWidth(8, Sizeable.Unit.EM);
            
            asteriscos = new Label("*");
            asteriscos.setStyleName("asterix");
            vlInv.addComponent(asteriscos, 5, 29);
            vlInv.setComponentAlignment(asteriscos, Alignment.MIDDLE_RIGHT);
            asteriscos.setWidth(2, Sizeable.Unit.EM);

            txtrepresentante = cargaRepresentante(codigo);

            vlInv.addComponent(txtrepresentante, 6, 29);
            vlInv.setComponentAlignment(txtrepresentante, Alignment.MIDDLE_LEFT);
            txtrepresentante.setWidth(10, Sizeable.Unit.EM);

            /////txtrepresentante1  = (String) txtrepresentante.getValue();
            txtrepresentante.addBlurListener(new FieldEvents.BlurListener() {

                @Override
                public void blur(FieldEvents.BlurEvent event) {

                    if (txtrepresentante.getValue() == null || txtrepresentante.getValue().equals("")) {
                        txtrepresentante.setComponentError(new UserError(""));
                        errNombreRepresentante.setValue("Este campo es requerido");
                    } else {
                        txtrepresentante.setComponentError(null);
                        errNombreRepresentante.setValue("");
                    }
                    ValidarError();
                }
            });

            //Fila para los controles de errores
            errCuentaInversionista.setStyleName("lblerrorestop");
            vlInv.addComponent(errCuentaInversionista, 2, 28);
            vlInv.setComponentAlignment(errCuentaInversionista, Alignment.TOP_CENTER);

            errNombreRepresentante.setStyleName("lblerrorestop");
            vlInv.addComponent(errNombreRepresentante, 6, 30);
            vlInv.setComponentAlignment(errNombreRepresentante, Alignment.TOP_CENTER);

            //Porcentaje de Comisión
            lbPorcentajeComision = new Label("Porcentaje de Comisión");
            lbPorcentajeComision.setId("lbPorcentajeComision");
            vlInv.addComponent(lbPorcentajeComision, 0, 29);
            vlInv.setComponentAlignment(lbPorcentajeComision, Alignment.MIDDLE_LEFT);

            porcentajeComision.setMaxLength(7);
            //porcentajeComision.setWidth(10, Sizeable.Unit.EM);
            porcentajeComision.setId("porcentajeComision");

            vlInv.addComponent(porcentajeComision, 2, 29);
            vlInv.setComponentAlignment(porcentajeComision, Alignment.MIDDLE_LEFT);

            lbPorcentaje = new Label("<p align=\"left\" style=\\\"font-size:16px;color:rgb(0,0,0);width:2px\\\">%</p>", Label.CONTENT_RAW);
            //lbPorcentaje.setStyleName("lbporcentaje");
            lbPorcentajeComision.setId("lbPorcentaje");

            vlInv.addComponent(lbPorcentaje, 3, 29);
            vlInv.setComponentAlignment(lbPorcentaje, Alignment.MIDDLE_LEFT);

            errporcentajeComision.setStyleName("lblerrores");
            vlInv.addComponent(errporcentajeComision, 2, 30);

            porcentajeComision.addBlurListener(new FieldEvents.BlurListener() {

                @Override
                public void blur(FieldEvents.BlurEvent event) {

                    if (!porcentajeComision.getValue().equals("")) {

                        if (porcentajeComision.getValue().matches(regexNumericPuntComa)) {
                            if (porcentajeComision.getValue().matches(regexTresDecimales)) {
                                try {
                                    Double num = 0.0;
                                    /*                        DecimalFormatSymbols simbolo2 = new DecimalFormatSymbols();
                            simbolo2.setDecimalSeparator(',');
                            simbolo2.setGroupingSeparator('.');*/
                                    //Double valor = Double.parseDouble(txtf_precioDeLaOferta.getValue().replace(".", "").split("&")[0]);
                                    Number valor = form2.parse(porcentajeComision.getValue());
                                    num = valor.doubleValue();
                                    if (num > 100) {
                                        porcentajeComision.setComponentError(new UserError(""));
                                        errporcentajeComision.setValue("Porcentaje no válido, debe ser entre 0% y 100%");

                                    }
                                    if (0 <= num && num <= 100) {
                                        porcentajeComision.setValue(form2.format(num));
                                        porcentajeComision.setComponentError(null);
                                        errporcentajeComision.setValue("");
                                    }
                                } catch (ParseException ex) {
                                    logger.error("OPI - " + CrearAceptaciones.class.getName(), ex);
                                }
                            } else {
                                porcentajeComision.setComponentError(new UserError(""));
                                errporcentajeComision.setValue("El valor supera el máximo de decimales permitidos");
                            }

                        } else {
                            porcentajeComision.setComponentError(new UserError(""));
                            errporcentajeComision.setValue("Este campo contiene caracteres no válidos");
                        }
                    } else {
                        porcentajeComision.setComponentError(null);
                        errporcentajeComision.setValue("");

                    }

                    ValidarError();
                }
            });

            //Campo de dirección
            if (Integer.parseInt(parametros.get(43)) == 1) {

                vlInv.addComponent(lbl_direccion, 0, 31);
                vlInv.setComponentAlignment(lbl_direccion, Alignment.MIDDLE_LEFT);
                lbl_direccion.setWidth(9, Sizeable.Unit.EM);

                //asteriscos = new Label("*");
                //asteriscos.setStyleName("asterix");
                //vlInv.addComponent(asteriscos, 1, 29);
                //vlInv.setComponentAlignment(asteriscos, Alignment.MIDDLE_RIGHT);
                //asteriscos.setWidth(2, Sizeable.Unit.EM);

                txtf_direccion.setMaxLength(50);
                vlInv.addComponent(txtf_direccion, 2, 31);
                //lbl_errDireccion.setStyleName("lblerrores");
                //vlInv.addComponent(lbl_errDireccion, 2, 30);

                txtf_direccion.addBlurListener(new FieldEvents.BlurListener() {

                    @Override
                    public void blur(FieldEvents.BlurEvent event) {

                        if (!txtf_direccion.getValue().equals("")) {
                            txtf_direccion.setComponentError(null);
                        }
                        ValidarError();
                    }
                });
            }

            vlPadre.addComponent(vlInv);

            VerticalLayout HL = new VerticalLayout();

            HL.setStyleName("noflex");
            btnGuardar.setStyleName("btn");
            lbError.setStyleName("lblError");
            HL.addComponent(btnGuardar);
            HL.addComponent(lbError);
            vlPadre.addComponent(HL);

            btnGuardar.addClickListener(new Button.ClickListener() {

                @Override
                public void buttonClick(Button.ClickEvent event) {

                    if (parametros.get(41).equals("OPI")) {
                        //Checkbox condiciones
                        if (txtf_TerminosCondicion1.getValue().equals(false) || txtf_TerminosCondicion1.getValue() == null) {
                            txtf_TerminosCondicion1.setComponentError(new UserError(""));
                            lbl_errTerminosCondicion1.setValue("Debe aceptar condiciones");

                        }
                        if (txtf_TerminosCondicion2.getValue().equals(false) || txtf_TerminosCondicion2.getValue() == null) {
                            txtf_TerminosCondicion2.setComponentError(new UserError(""));
                            lbl_errTerminosCondicion2.setValue("Debe aceptar condiciones");

                        }
                        /////   

                        //validar Nombre al guardar
                        if (!cmbTipoDoc.getValue().equals(4)) {
                            if (nombres.getValue().equals("")) {
                                nombres.setComponentError(new UserError(""));
                                lbl_errNombres.setValue("Este campo es requerido");
                            } else {
                                if (nombres.getValue().matches(regexTextTildesNumeros)) {
                                    nombres.setComponentError(null);
                                    lbl_errNombres.setValue("");
                                } else {
                                    nombres.setComponentError(new UserError(""));
                                    lbl_errNombres.setValue("Este campo contiene caracteres no válidos");
                                }
                            }
                        } else {
                            if (nombres.getValue().equals("")) {
                                nombres.setComponentError(null);
                                lbl_errNombres.setValue("");
                            } else {
                                if (nombres.getValue().matches(regexTextTildesNumeros)) {
                                    nombres.setComponentError(null);
                                    lbl_errNombres.setValue("");
                                } else {
                                    nombres.setComponentError(new UserError(""));
                                    lbl_errNombres.setValue("Este campo contiene caracteres no válidos");
                                }
                            }
                        }

                        //Validación de porcentaje pago Efectivo MANUAL SI y solo Si, fue este campo el parametrizado
                        if (porcentajeEfectivoParametrizado == 1) {

                            comboPorcentajeLis = 0;

                            if (!txtf_porcentajePagoEfectivo.getValue().equals("")) {

                                if (txtf_porcentajePagoEfectivo.getValue().matches(regexNumericPuntComa)) {
                                    if (txtf_porcentajePagoEfectivo.getValue().matches(regexTresDecimales)) {
                                        try {
                                            Double num = 0.0;
                                            Number valor = form2.parse(txtf_porcentajePagoEfectivo.getValue());
                                            num = valor.doubleValue();
                                            if (num < 0) {
                                                txtf_porcentajePagoEfectivo.setComponentError(new UserError(""));
                                                txtf_porcentajePagoEfectivo.setValue("Porcentaje no válido, debe ser entre 0% y 100%");

                                            }
                                            if (num > 100) {
                                                txtf_porcentajePagoEfectivo.setComponentError(new UserError(""));
                                                lbl_errPorcentajePagoEfectivo.setValue("Porcentaje no válido, debe ser entre 0% y 100%");

                                            }
                                            if (0 <= num && num <= 100) {
                                                txtf_porcentajePagoEfectivo.setValue(form2.format(num));
                                                txtf_porcentajePagoEfectivo.setComponentError(null);
                                                lbl_errPorcentajePagoEfectivo.setValue("");
                                            }
                                        } catch (ParseException ex) {
                                            logger.error("OPI - " + CrearParametros.class.getName(), ex);
                                        }
                                    } else {
                                        txtf_porcentajePagoEfectivo.setComponentError(new UserError(""));
                                        lbl_errPorcentajePagoEfectivo.setValue("El valor supera el máximo de decimales permitidos");
                                    }

                                } else {
                                    txtf_porcentajePagoEfectivo.setComponentError(new UserError(""));
                                    lbl_errPorcentajePagoEfectivo.setValue("Este campo contiene caracteres no válidos");
                                }
                            } else {
                                txtf_porcentajePagoEfectivo.setComponentError(new UserError(""));
                                lbl_errPorcentajePagoEfectivo.setValue("Este campo es requerido");

                            }
                            ValidarError();

                        } else {

                            //Validación de componente de porcentaje pago en Efectivo List (Acciones o Efectivo)
                            try {
                                comboPorcentajeLis = (Integer) cbox_porcentajePagoEfectivoList.getValue();
                            } catch (NullPointerException e) {
                                comboPorcentajeLis = 0;
                            } catch (ClassCastException ex) {
                                comboPorcentajeLis = 0;
                            }

                            if (comboPorcentajeLis == 0) {
                                cbox_porcentajePagoEfectivoList.setComponentError(new UserError(""));
                                lbl_errPorcentajePagoEfectivoList.setValue("Este campo es requerido");
                            } else if (comboPorcentajeLis == 1) {
                                //Si seleccionó Efectivo, el porcentaje de pago en Efectivo debe ser del 100%
                                txtf_porcentajePagoEfectivo.setValue("100");
                            }
                        }

                    }//Cierre validación si es OPI

                    try {
                        valorComboTipoDocumento = (Integer) cmbTipoDoc.getValue();
                    } catch (NullPointerException e) {
                        valorComboTipoDocumento = 0;
                    } catch (ClassCastException ex) {
                        valorComboTipoDocumento = 0;
                    }
                    if (valorComboTipoDocumento == 4) {
                        NID = numDocumento.getValue() + txtIden.getValue();
                        if (txtIden.getValue().equals("")) {
                            txtIden.setComponentError(new UserError(""));
                            errIden1.setStyleName("lblerrores");
                            errIden1.setValue("Este campo es requerido");
                        }
                    } else {
                        txtIden.setComponentError(null);
                        txtIden.setValue("");
                        errIden1.setValue("");
                    }
//Aqui ajustar condicion todo o nada
                    if (controlTN) {
                        try {
                            comboTN = (Integer) comboTodoNada.getValue();
                        } catch (NullPointerException e) {
                            comboTN = 0;
                        } catch (ClassCastException ex) {
                            comboTN = 0;
                        }
                    } else {
                        comboTN = null;
                    }

                    try {
                        comboPre = (Integer) comboExistePreacuerdo.getValue();
                    } catch (NullPointerException e) {
                        comboPre = 0;
                    } catch (ClassCastException ex) {
                        comboPre = 0;
                    }
                    

                    if (valorComboTipoDocumento == 0) {
                        cmbTipoDoc.setComponentError(new UserError(""));
                        errTipoDocumento.setValue("Este campo es requerido");
                    }
                    if (textConsecutivoOferta.getValue().equals("")) {
                        textConsecutivoOferta.setComponentError(new UserError(""));
                        lbErrortConsecutivoOferta.setValue("Este campo es requerido");
                    }

                    if (comboTN != null) {
                        if (comboTN == 0) {
                            //Aqui agregar condicion de presentación
                            comboTodoNada.setComponentError(new UserError(""));
                            lbErrorTodoNada.setValue("Este campo es requerido");
                        }
                    }

                    if (comboPre == 0) {
                        comboExistePreacuerdo.setComponentError(new UserError(""));
                        lbErrorExistePreacuerdo.setValue("Este campo es requerido");
                    }
                    if (controlPreacuerdo == 1) {
                        comboExistePreacuerdo.setComponentError(null);
                        lbErrorExistePreacuerdo.setValue("");
                    }
                    
                    if (numDocumento.getValue().equals("")) {
                        numDocumento.setComponentError(new UserError(""));
                        errDocumento.setValue("Este campo es requerido");
                    } else if (valorCombo == 4) {
                        int dig;
                        try {
                            dig = Integer.parseInt(txtIden.getValue());
                            if (validacion.validarRut(numDocumento.getValue()) != dig) {
                                txtIden.setComponentError(new UserError(""));
                                errIden1.setValue("El dígito de verificación ingresado no corresponde al NIT.");
                            }
                        } catch (NumberFormatException ex) {
                            dig = 0;
                        }
                    } else {
                        txtIden.setComponentError(null);
                        errIden1.setValue("");
                    }

                    if (txtCuentainv.getValue().equals("")) {
                        txtCuentainv.setComponentError(new UserError(""));
                        errCuentaInversionista.setValue("Este campo es requerido");
                    }
                    //Combo representante legal
                    if (txtrepresentante.getValue() == null || txtrepresentante.getValue().equals("")) {
                        txtrepresentante.setComponentError(new UserError(""));
                        errNombreRepresentante.setValue("Este campo es requerido");
                    }
                    try {
                        txtrepresentante1 = (String) txtrepresentante.getValue();
                    } catch (NullPointerException e) {
                        txtrepresentante1 = "";
                    } catch (ClassCastException ex) {
                        txtrepresentante1 = "";
                    }

                    if (numeroAccionesven.getValue().equals("")) {
                        numeroAccionesven.setComponentError(new UserError(""));
                        erracciones.setValue("Este campo es requerido");
                    } else if (EsEntero(numeroAccionesven.getValue())) {
                        if ((!numeroAccionesven.getValue().equalsIgnoreCase("0"))) {
                            //Double valor = Double.valueOf(numeroAccionesven.getValue());                                 
                            // numeroAccionesven.setValue(moneyFormatter.format(valor));
                            numeroAccionesven.setValue(moneyFormatter.format(Double.parseDouble(numeroAccionesven.getValue().replace(".", "").split("&")[0])));
                            numeroAccionesven.setComponentError(null);
                            erracciones.setValue("");
                        } else {
                            numeroAccionesven.setComponentError(new UserError(""));
                            erracciones.setValue("Cantidad de Acciones Invalida");
                        }
                    } else {
                        numeroAccionesven.setComponentError(new UserError(""));
                        erracciones.setValue("Cantidad de Acciones Invalida");
                    }

                    ValidarError();
                    if (!ValidaComponentError()) {
                        String horario = validacion.fechaIngreso();
                        if (!horario.equals("")) {
                            ConfirmDialog cd = ConfirmDialog.getFactory().create("Confirmación", "", "ACEPTAR", "", "");
                            cd.setWidth("400px");
                            cd.setHeight("160px");
                            HorizontalLayout texto = new HorizontalLayout();
                            HorizontalLayout buttons = new HorizontalLayout();
                            buttons.setStyleName("btnAceptar");
                            Label lblmensaje = new Label(horario, ContentMode.HTML);
                            texto.addComponent(lblmensaje);
                            buttons.addComponent(cd.getOkButton());
                            VerticalLayout content = new VerticalLayout(lblmensaje, buttons);
                            content.setStyleName("verticalDialog");
                            content.setSizeFull();
                            content.setSpacing(true);
                            cd.setContent(content);
                            cd.show(UI.getCurrent(), new ConfirmDialog.Listener() {
                                @Override
                                public void onClose(ConfirmDialog cd) {

                                }
                            }, true);
                        } else {

                            ConfirmDialog.show(getUI(), "Confirmación", " ¿Está seguro que desea incluir la Oferta?", "ACEPTAR",
                                    "CANCELAR", new ConfirmDialog.Listener() {
                                @Override
                                public void onClose(ConfirmDialog dialog) {
                                    if (dialog.isConfirmed()) {
                                        if (!ValidaComponentError()) {

                                            Date dNow = new Date();
                                            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                                            String fechacreacion = ft.format(dNow);
                                            String strError = "";
                                            String pre = null;
                                            try {
                                                pre = (comboExistePreacuerdo.getValue().toString());

                                            } catch (Exception e) {
                                                strError = "Preacuerdo null";
                                            }
                                            Integer todo = 0;
                                            //Aqui agregar condicion de presentación
                                            if (controlTN) {
                                                if (Integer.parseInt(comboTodoNada.getValue().toString()) == 2) {
                                                    todo = 0;
                                                } else {
                                                    todo = Integer.parseInt(comboTodoNada.getValue().toString());
                                                }
                                            } else {
                                                todo = null;
                                            }

                                            Double dig = null;

                                            try {
                                                dig = Double.valueOf(txtIden.getValue().toString());

                                            } catch (Exception e) {
                                                dig = null;
                                                strError = "";
                                            }

                                            if (!porcentajeComision.getValue().equals("")) {

                                                if (porcentajeComision.getValue().matches(regexNumericPuntComa)) {
                                                    if (porcentajeComision.getValue().matches(regexTresDecimales)) {
                                                        try {
                                                            Double num = 0.0;
                                                            Number valor = form2.parse(porcentajeComision.getValue());
                                                            num = valor.doubleValue();
                                                            if (num < 0) {
                                                                porcentajeComision.setComponentError(new UserError(""));
                                                                errporcentajeComision.setValue("El valor es inferior al porcentaje mínimo");

                                                            }
                                                            if (num > 100) {
                                                                porcentajeComision.setComponentError(new UserError(""));
                                                                errporcentajeComision.setValue("El valor supera el porcentaje máximo");

                                                            }
                                                            if (0 <= num && num <= 100) {
                                                                porcentajeComision.setValue(form2.format(num));
                                                                porcentajeComision.setComponentError(null);
                                                                errporcentajeComision.setValue("");
                                                            }
                                                        } catch (ParseException ex) {
                                                            logger.error("OPA - " + CrearAceptaciones.class.getName(), ex);
                                                        }
                                                    } else {
                                                        porcentajeComision.setComponentError(new UserError(""));
                                                        errporcentajeComision.setValue("El valor supera el máximo de decimales permitidos");
                                                    }

                                                } else {
                                                    porcentajeComision.setComponentError(new UserError(""));
                                                    errporcentajeComision.setValue("Este campo contiene caracteres no válidos");
                                                }
                                            } else {
                                                porcentajeComision.setComponentError(null);
                                                errporcentajeComision.setValue("");

                                            }
                                            ValidarError();
                                            ///////////////////////////////////// 

                                            String nomUsuario = userDetailsService.getUsuarioAutenticado().getUsername();
                                            Double numAcciones = Double.valueOf(numeroAccionesven.getValue().replace(".", ""));
                                            Double num = 0.0;
                                            Double num2 = 0.0;
                                            try {
                                                Number valor = form2.parse(porcentajeComision.getValue());
                                                num = valor.doubleValue();
                                            } catch (Exception ex) {
                                                num = 0.0;
                                            }

                                            String resultado = "";

                                            if (parametros.get(41).equals("OPA")) {

                                                logger.info("El valor de porcentaje comisión para OPA está en: " + num);

                                                resultado = facade.CrearAceptacion(lbClaseAcciones.getValue(), 
                                                        textConsecutivoOferta.getValue(), 
                                                        parametrizacion.getTextoUno().replace("'", "\'\'"),
                                                        parametrizacion.getTextoDos().replace("'", "\'\'"), 
                                                        pre, codBolsa, lbNombreSCB.getValue(), 
                                                        txtrepresentante1, nombres.getValue(),
                                                        numAcciones, todo, Integer.parseInt(cmbTipoDoc.getValue().toString()),
                                                        numDocumento.getValue(), dig, txtEspFIDU.getValue(), 
                                                        txtCuentainv.getValue(),
                                                        userDetailsService.getUsuarioAutenticado().getId(), 
                                                        fechacreacion, 
                                                        userDetailsService.getUsuarioAutenticado().getId(), 
                                                        ft.format(dNow).toString(), 
                                                        nomUsuario, num, Double.valueOf(parametros.get(9).toString()), 
                                                        txtf_direccion.getValue(), comboMILA);
                                            } else {

                                                try {
                                                    Number valor1 = form2.parse(txtf_porcentajePagoEfectivo.getValue());
                                                    num2 = valor1.doubleValue();
                                                } catch (Exception ex) {
                                                    num2 = 0.0;
                                                }
                                                

                                                resultado = facade.CrearAceptacion(lbClaseAcciones.getValue(), 
                                                        textConsecutivoOferta.getValue(), 
                                                        parametrizacion.getTextoUno(),
                                                        parametrizacion.getTextoDos(), 
                                                        pre, 
                                                        codBolsa, 
                                                        lbNombreSCB.getValue(), 
                                                        txtrepresentante1,
                                                        nombres.getValue(), 
                                                        numAcciones, 
                                                        todo, 
                                                        Integer.parseInt(cmbTipoDoc.getValue().toString()),
                                                        numDocumento.getValue(), 
                                                        dig, 
                                                        txtEspFIDU.getValue(), 
                                                        txtCuentainv.getValue(),
                                                        userDetailsService.getUsuarioAutenticado().getId(), 
                                                        fechacreacion, 
                                                        userDetailsService.getUsuarioAutenticado().getId(), 
                                                        ft.format(dNow).toString(), 
                                                        nomUsuario, 
                                                        num,
                                                        num2, 
                                                        comboPorcentajeLis, 
                                                        Double.valueOf(parametros.get(9).toString()), 
                                                        condicion1, 
                                                        condicion2, 
                                                        txtf_direccion.getValue(), 
                                                        comboMILA);
                                            }

                                            if (!resultado.equals("Error")) {
                                                ConfirmDialog cd = ConfirmDialog.getFactory().create("Confirmación", "", "ACEPTAR", "", "");
                                                cd.setWidth("448px");
                                                cd.setHeight("150px");
                                                HorizontalLayout texto = new HorizontalLayout();
                                                HorizontalLayout buttons = new HorizontalLayout();
                                                buttons.setStyleName("btnAceptar");
                                                Label lblmensaje = new Label(resultado, ContentMode.HTML);
                                                texto.addComponent(lblmensaje);
                                                buttons.addComponent(cd.getOkButton());
                                                VerticalLayout content = new VerticalLayout(lblmensaje, buttons);
                                                content.setStyleName("verticalDialog");
                                                content.setSizeFull();
                                                //content.setSpacing(true);
                                                cd.setContent(content);
                                                cd.show(getUI(), new ConfirmDialog.Listener() {
                                                    @Override
                                                    public void onClose(ConfirmDialog cd) {
                                                        Limpiar();

                                                    }
                                                }, true);
                                            } else {

                                                Notification.show("Hubo un Error Al Momento De Ingresar La Aceptacion", Notification.Type.ERROR_MESSAGE);

                                            }
                                            //   }
                                        }
                                    }
                                }
                            });
                        }

                    }

                }
            });
            setContent(vlPadre);
        }

        //Obtiene el parámetro 41 - tipo Oferta pública
        if (parametros.get(41).equals("OPA")) {
            ocultarCamposOPI();
        } else {
            ocultarPorcentajePagoEfectivo();
        }

    }

    public ComboBox LlenarTipoDocumento() {
        Iterator<TipoDocumento> LTipo = null;
        TipoDocumento TP = null;

        LTipo = facade.RetornarDocumentos().iterator();
        cmbTipoDoc.setNullSelectionAllowed(false);
        cmbTipoDoc.setTextInputAllowed(false);
        cmbTipoDoc.addItem("");
        cmbTipoDoc.setItemCaption("", "Seleccione");
        cmbTipoDoc.select("");
        while (LTipo.hasNext()) {
            TP = LTipo.next();
            cmbTipoDoc.addItem(TP.getTipodocumento());
            cmbTipoDoc.setItemCaption(TP.getTipodocumento(), TP.getNombredoc());
        }

        //TP.cerrarConexiones();
        return cmbTipoDoc;
    }

    public ComboBox listarOrigenMILA() {
        Iterator<OrigenMILA> LMila = null;
        OrigenMILA LM = null;
        LMila = facade.RetornarOrigenMILActivos().iterator();
        cmbOrigenMila.setNullSelectionAllowed(false);
        cmbOrigenMila.setTextInputAllowed(false);
        cmbOrigenMila.addItem("");
        cmbOrigenMila.setItemCaption("", "No Aplica");
        cmbOrigenMila.select("");
        while (LMila.hasNext()) {
            LM = LMila.next();
            cmbOrigenMila.addItem(LM.getIdMila());
            cmbOrigenMila.setItemCaption(LM.getIdMila(), LM.getPais());
        }
        return cmbOrigenMila;
    }
    
    public OrigenMILA llenadoCampoMILA(Integer id) {
        List<OrigenMILA> LMila = facade.RetornarOrigenMILActivos();
        OrigenMILA om = null;
        for (OrigenMILA lm : LMila) {
            if (id == lm.getIdMila()) {
                om = new OrigenMILA(id, lm.getCodigoPais(), lm.getPais(), lm.getTipoDocumento(), lm.getNumeroDocumento(), lm.getNumVerificacion(), lm.getCuenta(), lm.getEstado());
            }
        }
        return om;
    }
    
    public void Limpiar() {

        lbErrortConsecutivoOferta.setValue("");
        lbErrorTodoNada.setValue("");
        lbErrorExistePreacuerdo.setValue("");
        erracciones.setValue("");
        errEspFIDU.setValue("");
        errTipoDocumento.setValue("");
        errDocumento.setValue("");
        errIden1.setValue("");
        errEspFIDU.setValue("");
        errCuentaInversionista.setValue("");
        errNombreRepresentante.setValue("");
        lbl_errNombres.setValue("");
        lbl_errMontoTotalAccionesVender.setValue("");
        lbl_errPorcentajePagoEfectivo.setValue("");
        lbl_errPorcentajePagoEfectivoList.setValue("");
        //lbl_errDireccion.setValue("");

        txtf_TerminosCondicion1.setValue(Boolean.FALSE);
        txtf_TerminosCondicion2.setValue(Boolean.FALSE);
        lbl_errTerminosCondicion1.setValue("");
        lbl_errTerminosCondicion2.setValue("");
        txtf_TerminosCondicion1.setComponentError(null);
        txtf_TerminosCondicion2.setComponentError(null);

        textConsecutivoOferta.setValue("");
        textConsecutivoOferta.setComponentError(null);
        numeroAccionesven.setValue("");
        numeroAccionesven.setComponentError(null);
        txtf_montoTotalAccionesVender.setValue("");
        txtf_montoTotalAccionesVender.setComponentError(null);
        nombres.setValue("");
        nombres.setComponentError(null);
        numDocumento.setValue("");
        numDocumento.setComponentError(null);
        txtIden.setValue("");
        txtIden.setComponentError(null);
        txtEspFIDU.setValue("");
        txtEspFIDU.setComponentError(null);
        txtCuentainv.setValue("");
        txtCuentainv.setComponentError(null);
        txtrepresentante.setValue("");
        txtrepresentante.setComponentError(null);
//Aqui agregar condicion de presentación
        comboTodoNada.select("");
        comboTodoNada.setComponentError(null);
        comboExistePreacuerdo.select("");
        comboExistePreacuerdo.setComponentError(null);
        cmbTipoDoc.select("");
        cmbTipoDoc.setComponentError(null);
        porcentajeComision.setValue("");
        porcentajeComision.setComponentError(null);
        txtf_direccion.setValue("");
        txtf_direccion.setComponentError(null);
        txtf_porcentajePagoEfectivo.setValue("");
        txtf_porcentajePagoEfectivo.setComponentError(null);
        cbox_porcentajePagoEfectivoList.select(0);
        cbox_porcentajePagoEfectivoList.setComponentError(null);
        cmbOrigenMila.select("");
        cmbOrigenMila.setComponentError(null);
        cmbTipoDoc.setValue("");
        nombres.setValue("");
        numDocumento.setValue("");
        txtIden.setValue("");
        txtCuentainv.setValue("");
        cmbTipoDoc.setEnabled(true);
        numDocumento.setEnabled(true);
        txtIden.setEnabled(true);
        txtCuentainv.setEnabled(true);
        lbEspecialFid.setVisible(true);
        txtEspFIDU.setVisible(true);
        nombres.setVisible(true);
        lbNombres.setVisible(true);
        lbl_asteriscoNombre.setVisible(true);
        lbl_errNombres.setVisible(true);
        if (Integer.parseInt(parametros.get(43)) == 1) {
            lbl_direccion.setVisible(true);
            txtf_direccion.setVisible(true);
        }
    }

    public void ValidarError() {
        if (ValidaComponentError()) {
            lbError.setValue("Verificar campos en rojo");
        } else {
            lbError.setValue("");
        }
    }

    public Boolean ValidaComponentError() {
        Boolean errores = false;
        //Aqui agregar condicon de presentación
        if (textConsecutivoOferta.getComponentError() != null || comboTodoNada.getComponentError() != null) {
            return true;
        }
        if (comboExistePreacuerdo.getComponentError() != null || nombres.getComponentError() != null) {
            return true;
        }
        if (numeroAccionesven.getComponentError() != null /*|| razonSocial.getComponentError() != null*/) {
            return true;
        }
        if (cmbTipoDoc.getComponentError() != null || numDocumento.getComponentError() != null) {
            return true;
        }
        if (txtIden.getComponentError() != null || txtEspFIDU.getComponentError() != null) {
            return true;
        }
        if (txtCuentainv.getComponentError() != null || txtrepresentante.getComponentError() != null) {
            return true;
        }
        if (porcentajeComision.getComponentError() != null) {
            return true;
        }

        if (txtf_porcentajePagoEfectivo.getComponentError() != null) {
            return true;
        }
        if (txtf_TerminosCondicion1.getComponentError() != null || txtf_TerminosCondicion2.getComponentError() != null) {
            return true;
        }

        if (txtf_direccion.getComponentError() != null) {
            return true;
        }

        return errores;
    }

    public String RegExInteger(String number) {
        String unformat = number.replace(".", "");
        String regex = "^[0-9]{1,3}";
        int separadores = (int) Math.floor((unformat.length() - 1) / 3);
        for (int i = 0; i < separadores; i++) {
            regex += "[\\.][0-9]{3,3}";
        }
        regex += "$";
        logger.info("OPA - " + "Exspresion regular para el número" + regex);
        return regex;
    }

    public boolean EsEntero(String number) {
        boolean respuesta = false;
        if (!number.contains(",")) {
            if (number.matches(regexNumeric)) {
                respuesta = true;
            } else if (number.matches(RegExInteger(number))) {
                respuesta = true;
            }
        }
        return respuesta;
    }

    private String traermes(int id) {

        String result = "";

        try {

        } catch (Exception ex) {
        }
        switch (id) {
            case 0: {
                result = "Enero";
                break;
            }
            case 1: {
                result = "Febrero";
                break;
            }
            case 2: {
                result = "Marzo";
                break;
            }
            case 3: {
                result = "Abril";
                break;
            }
            case 4: {
                result = "Mayo";
                break;
            }
            case 5: {
                result = "Junio";
                break;
            }
            case 6: {
                result = "Julio";
                break;
            }
            case 7: {
                result = "Agosto";
                break;
            }
            case 8: {
                result = "Septiembre";
                break;
            }
            case 9: {
                result = "Octubre";
                break;
            }
            case 10: {
                result = "Noviembre";
                break;
            }
            case 11: {
                result = "Diciembre";
                break;
            }
            default: {
                result = "Error";
                break;
            }
        }
        return result;
    }

    public ComboBox cargaRepresentante(String usuario) {

        SCB lp = new SCB();
        lp.cerrarConexiones();

        lp = facade.cargarRepresentante(usuario);
        // lp.cerrarConexiones();
        txtrepresentante.setNullSelectionAllowed(false);
        txtrepresentante.setTextInputAllowed(false);
        txtrepresentante.addItem("");
        txtrepresentante.setItemCaption("", "Seleccione");
        txtrepresentante.select("");
        txtrepresentante.addItem(lp.getRepresentante().trim());
        txtrepresentante.addItem(lp.getRepresentante1().trim());
        txtrepresentante.addItem(lp.getRepresentante2().trim());

        return txtrepresentante;
    }

    /**
     * Oculta los campos de OPI del formulario para Oferta pública d
     * eIntercambio
     */
    public void ocultarCamposOPI() {

        /*Se oculta los campos de los términos de la Aceptación de la OPA */
        lbl_montoTotalAccionesVender.setVisible(Boolean.FALSE);
        lbl_asteriscoMontoTotalAccionesVender.setVisible(Boolean.FALSE);
        txtf_montoTotalAccionesVender.setVisible(Boolean.FALSE);
        lbl_errMontoTotalAccionesVender.setVisible(Boolean.FALSE);

        lbl_porcentajePagoEfectivo.setVisible(Boolean.FALSE);
        lbl_errPorcentajePagoEfectivo.setVisible(Boolean.FALSE);
        txtf_porcentajePagoEfectivo.setVisible(Boolean.FALSE);
        lbl_asteriscoPorcentajePagoEfectivo.setVisible(Boolean.FALSE);
        lbPorcentajeSimbolo.setVisible(Boolean.FALSE);

        lbl_porcentajePagoEfectivoList.setVisible(Boolean.FALSE);
        lbl_errPorcentajePagoEfectivoList.setVisible(Boolean.FALSE);
        cbox_porcentajePagoEfectivoList.setVisible(Boolean.FALSE);
        lbl_asteriscoPorcentajePagoEfectivoList.setVisible(Boolean.FALSE);

        /*Se ocultan los campos de Aceptación de la emisión*/
        vlCabEncabezadoCondicionesEmision.setVisible(Boolean.FALSE);
        lbltitulo2.setVisible(Boolean.FALSE);
        texto3.setVisible(Boolean.FALSE);
        txtf_TerminosCondicion1.setVisible(Boolean.FALSE);
        lbl_errTerminosCondicion1.setVisible(Boolean.FALSE);

        texto4.setVisible(Boolean.FALSE);
        txtf_TerminosCondicion2.setVisible(Boolean.FALSE);
        lbl_errTerminosCondicion2.setVisible(Boolean.FALSE);
    }

    /**
     * Contiene la lógica de este campo de acuerdo a la parametrización
     * realizada
     */
    public void ocultarPorcentajePagoEfectivo() {

        try {
            porcentajeEfectivoParametrizado = Integer.parseInt(parametros.get(42));
        } catch (NumberFormatException e) {
            logger.error("Hubo un error consultando el tipo de pago parametrizado para la operación (Manual o predeterminado) ", e);
        }

        /*Si el tipo de pago parametrizado es "Predeterminado" debe ocultarse 
            el campo de porcentaje de ingreso manual*/
        if (porcentajeEfectivoParametrizado == AppConstants.PORCENTAJE_PAGO_EFECTIVO_PARAM_PREDETERMINADO) {
            lbl_porcentajePagoEfectivo.setVisible(Boolean.FALSE);
            lbl_errPorcentajePagoEfectivo.setVisible(Boolean.FALSE);
            txtf_porcentajePagoEfectivo.setVisible(Boolean.FALSE);
            lbl_asteriscoPorcentajePagoEfectivo.setVisible(Boolean.FALSE);
            lbPorcentajeSimbolo.setVisible(Boolean.FALSE);
        } else {
            lbl_porcentajePagoEfectivoList.setVisible(Boolean.FALSE);
            lbl_errPorcentajePagoEfectivoList.setVisible(Boolean.FALSE);
            cbox_porcentajePagoEfectivoList.setVisible(Boolean.FALSE);
            lbl_asteriscoPorcentajePagoEfectivoList.setVisible(Boolean.FALSE);
        }
    }
}

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
import com.vaadin.data.Property;
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
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.dialogs.ConfirmDialog;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author Administrador
 */
public class ModificacionAceptaciones extends GenericContent {

    @Autowired
    private MyUserDetailsService userDetailsService;
    private static final Logger logger = Logger.getLogger(ModificacionAceptaciones.class.getName());

    String regexNumeric = "^[0-9]*$";
    String regexNumericPuntComa = "^[0-9,]*$";
    String regexTresDecimales = "\\d+(\\,\\d{1,3}|,{1})?";
    String regexNumericFormat = "^[0-9\\.]*$";
    String regexAlphaSpace = "^[ a-zA-Z0-9\\s]*$";
    String regexAlpha = "^[a-zA-Z0-9]*$";
    String regexAlpha2 = "^[ a-zA-Z0-9]*$";
    String regexLetras = "^[a-zA-Z]*$";
    String regexTextTildes = "^[a-zA-ZñáéíóúÑÁÉÍÓÚ\\s]*$";
    String regexTextTildesNumeros = "^[a-zA-Z0-9ñáéíóúÑÁÉÍÓÚ\\s]*$";
    Button btnGuardar = new Button("Modificar");
    Button btnCancelar = new Button("Cancelar");
    String nombresActuales = "";
    String razonSocialActual = "";
    int combo = 0;
    int controlPre = 0;
    boolean controlTN = false;
    ValidarCampos validacion = new ValidarCampos();
    Facade facade = new Facade();

    Label tpID;
    Label lbNombres = new Label("Nombres y Apellidos/Razón Social");
    Label lbespecialfid = new Label("Especial fiduciario");
    Label lbNombrereLegal;
    Label lbObservacion;
    Label lbPorcentajeComision;
    Label lbPorcentajePagoEfectivo;
    Label lbPorcentaje;
    Label lbPorcentajeSimboloComision;
    Label lbl_porcentajePagoEfectivoList;
    Label lbl_montoTotalAccionesVender;
    Label COPMontoTotal;
    Label lbl_direccion = new Label("Dirección");
    //Asteriscos

    Label error = new Label("");
    Label date = new Label();
    Label claseAcciones = new Label();
    TextField conseOferta = new TextField();
    Label errconse = new Label();
    Label nomSocComBol = new Label();
    Label codSocComBol1 = new Label();
    Label codSocComBol = new Label();
    ComboBox TN = new ComboBox();
    Label errCondicionTdNd = new Label();
    ComboBox preacuerdo = new ComboBox();
    Label errExistePreacuerdo = new Label();
    TextField numeroAccionesven = new TextField();
    Label erracciones = new Label();
    TextField montoTotalAccionesven = new TextField();
    Label errmonTotalAccionesven = new Label();
    TextField nombres = new TextField();
    Label errnombres = new Label();
    /*TextField razonSocial = new TextField();*/
    /*Label errRazonSocial = new Label();*/
    ComboBox cmbTipoDoc = new ComboBox();
    Label errTipoDocumento = new Label();
    TextField numDocumento = new TextField();
    Label errDocumento = new Label();
    TextField txtIden = new TextField();
    Label errIden = new Label();
    Label errIden1 = new Label();
    TextField txtEspFIDU = new TextField();
    Label errEspFIDU = new Label();
    TextField txtCuentainv = new TextField();
    Label errCuentaInversionista = new Label();
    TextField txtrepresentante = new TextField();
    TextArea txtObservacion = new TextArea();
    Label errObservacion = new Label();
    Label errNombreRepresentante = new Label();
    VerticalLayout vlPadre = new VerticalLayout();
    double precio = 1;
    Label lbPorcentajepagoEfectivo;
    Label lbPorcentajeefectivo;
    TextField PorcentajepagoEfectivo = new TextField();
    Label errPorcentajepagoEfectivo = new Label();
    TextField porcentajeComision = new TextField();
    Label errporcentajeComision = new Label();
    Label asteriscosnombre  = new Label();
    Label asteriscoDireccion  = new Label("*");
    Label lbl_errDireccion = new Label();
    TextField txtf_direccion = new TextField();
    ComboBox cmbOrigenMila = null;
    Label errOrigenMila = new Label();
    int comboMILA = 0;

    TextArea texto1 = new TextArea();
    TextArea texto2 = new TextArea();
    TextArea texto3 = new TextArea();
    TextArea texto4 = new TextArea();

    CheckBox txtf_TerminosCondicion1 = new CheckBox("Aceptar"); //TextField Términos y condiciones 1 Lwph
    CheckBox txtf_TerminosCondicion2 = new CheckBox("Aceptar"); //TextField Términos y condiciones 2  Lwph
    ComboBox cbox_porcentajePagoEfectivoList = new ComboBox();

    Boolean Condicion1 = null;
    Boolean Condicion2 = null;

    Label lbltitulo2;
    Label lbl_errTerminosCondicion1 = new Label(); //Label Error número de la aceptación Lwph
    Label lbl_errTerminosCondicion2 = new Label(); //Label Error número de la aceptación Lwph

    int msnError = 0;
    int valorCombo = 0;
    Integer comboTN = 0;
    int comboPre = 0;
    int Preacuerdoid = 0;
    String NID;
    //String PerfilActual = "";
    String listPar = "";
    String[] resultadoLista = null;
    String[] aceptacionActual = null;
    String codBolsa = "";
    String idAceptacion = "";

    int tipoPago = 0;
    int porcentajePagoEfectivoParametrizado = 0;

    String pattern = "###,###,###,###,###,###";
    DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
    DecimalFormat moneyFormatter = new DecimalFormat(pattern);
    final DecimalFormat form2 = new DecimalFormat("##0.000");

    DecimalFormatSymbols a = DecimalFormatSymbols.getInstance(Locale.getDefault());
    String pattern1 = "###,###,###,###,###,###,###";
    DecimalFormat moneyFormatter1 = new DecimalFormat(pattern1, a);
    final DecimalFormat form3 = new DecimalFormat("###,###.00");

    //Variable que alberga el tipo de Oferta pública consultada (OPA ú OPI)
    String tipoOfertaPublica = "";

    /*  Esta variable de instancia será consultada 
        por la lógica  este formulario de Oferta pública integrada.
     */
    List<String> parametros = null;

    //Encabezado que aplica para OPI
    HorizontalLayout vlCabEncabezadoCondicionesEmision;

    public ModificacionAceptaciones(GenericTab parentTab) {
        super(parentTab);
    }

    public void idAceptacion(String idAceptacion) {

        //Consulta si se trata de una OPA u OPI
        //Carga los parámetros de la operación
        int hayParametrizacion = facade.validaHayParametros();
        if (hayParametrizacion == 1) {
            parametros = facade.RetornaParametros();
            tipoOfertaPublica = parametros.get(41);
        } else {
            throw new RuntimeException("No hay parametrización");
        }

        if (tipoOfertaPublica.equals("OPI")) {
            aceptacionActual = facade.CargarAceptacionOPI(idAceptacion);
        } else {
            aceptacionActual = facade.CargarAceptacion(idAceptacion);
        }

    }

    public VerticalLayout all() {

        String consecutivoOfertaVenta = "";
        String ConTodoNada = "";
        String Existepreacuerdo = "";
        String NumAccionesvender = "";
        String Nombres = "";
        /*String apellidorazonSocial = "";*/
        String numDocumen = "";
        String EspFid = "";
        String cuentaInversionista = "";
        String nombreRepreLegal = "";
        String tipoDocumento = "";
        String NumVer = "";
        String observacion = "";
        String porComision = "";
        String MontoTotalAcciones = "";
        String PorcentajePagoEfectivo = "";
        String idMila = "0";
//        Boolean Condicion1=null;
//        Boolean Condicion2=null;
        //final DecimalFormat form2 = new DecimalFormat("##0.000");

        String[] Aceptaciones = aceptacionActual;
        consecutivoOfertaVenta = Aceptaciones[2];//ok
        ConTodoNada = Aceptaciones[3] != null ? Aceptaciones[3] : "";
        Existepreacuerdo = Aceptaciones[4] != null ? Aceptaciones[4] : "";
        NumAccionesvender = Aceptaciones[5];
        Nombres = Aceptaciones[15];
        tipoDocumento = Aceptaciones[6];
        numDocumen = Aceptaciones[7];
        EspFid = Aceptaciones[8];
        cuentaInversionista = Aceptaciones[9];
        nombreRepreLegal = Aceptaciones[10];
        idAceptacion = Aceptaciones[11];
        NumVer = Aceptaciones[12];
        
        if (Aceptaciones[14] != null && !Aceptaciones[14].equalsIgnoreCase("null")) {
            porComision = form2.format(Double.parseDouble(Aceptaciones[14]));
        } else {
            porComision = "";
        }

        //Condicion1=Aceptaciones[19];
        if (tipoOfertaPublica.equals("OPI")) {

            Nombres = Aceptaciones[15];
            /*apellidorazonSocial = Aceptaciones[6];*/
            MontoTotalAcciones = form3.format(Double.parseDouble(Aceptaciones[16]));
            PorcentajePagoEfectivo = Aceptaciones[17];

            if ((Aceptaciones[18]).equals("S")) {
                Condicion1 = true;
            } else {
                Condicion1 = false;
            }
            if ((Aceptaciones[19]).equals("S")) {
                Condicion2 = true;
            } else {
                Condicion2 = false;
            }

            //Recupera el tipo de pago seleccionado en la inserción si está parametrizado el modo PREDETERMINADO
            //desde la parametrización
            porcentajePagoEfectivoParametrizado = 0;

            try {
                porcentajePagoEfectivoParametrizado = Integer.parseInt(parametros.get(42));
            } catch (NumberFormatException e) {
                logger.error("Se ha presentado un errror parseando el tipo de pago seleccionado" + e.getMessage());
            }

            try {
                tipoPago = Integer.parseInt(Aceptaciones[20]);
            } catch (NumberFormatException e) {
                tipoPago = 0;
                logger.error("Se ha presentado un errror parseando el tipo de pago seleccionado" + e.getMessage());
            }
            
            txtf_direccion.setValue(Aceptaciones[21]);
            idMila = Aceptaciones[22];
        }else{
            txtf_direccion.setValue(Aceptaciones[17]);
            idMila = Aceptaciones[18];
        }

        //Observacion
        try {
            observacion = Aceptaciones[13];

        } catch (Exception e) {
            observacion = "";

        }
        cmbOrigenMila = new ComboBox();
        cmbOrigenMila = listarOrigenMILA();
        cmbOrigenMila.select(Integer.parseInt(idMila));
        if (Integer.parseInt(idMila) > 0 && Integer.parseInt(parametros.get(44)) == 1) {
            mostrarMila();
        }

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

        codSocComBol1.setValue(codigo);
        nomSocComBol.setValue(Nombrescb);

        String fechaAcep = facade.fechaAcepta(userDetailsService.getUsuarioAutenticado().getId());

        Calendar fechahoy = new GregorianCalendar();

        int año = fechahoy.get(Calendar.YEAR);
        int mes = fechahoy.get(Calendar.MONTH);
        int dia = fechahoy.get(Calendar.DAY_OF_MONTH);

        String diaLetras = facade.retornarDia(dia);

        String mesLetras = traermes(mes);
        String FechaActual = diaLetras + " (" + dia + ")" + " de " + mesLetras + " del " + año;

        resultadoLista = facade.RetornarDatosPara();

        decimalFormatSymbols.setDecimalSeparator(',');
        decimalFormatSymbols.setGroupingSeparator('.');
        moneyFormatter.setDecimalFormatSymbols(decimalFormatSymbols);
        moneyFormatter.setRoundingMode(RoundingMode.DOWN);

        texto1.setValue(resultadoLista[0]);

        GridLayout vlInv = new GridLayout(8, 37);
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

        //Asteriscos
        Label asteriscos = new Label("*");
        asteriscos.setStyleName("asterix");

        //Fecha de Aceptación        
        tpID = new Label("Fecha de Aceptación");
        vlInv.setSpacing(true);
        vlInv.addComponent(tpID, 0, 2);
        vlInv.setComponentAlignment(tpID, Alignment.MIDDLE_LEFT);
        tpID.setWidth(10, Sizeable.Unit.EM);
        vlInv.setSpacing(true);

        date.setValue(FechaActual);
        date.setReadOnly(true);
        vlInv.addComponent(date, 2, 2);
        vlInv.setComponentAlignment(date, Alignment.MIDDLE_LEFT);
        date.setWidth(12, Sizeable.Unit.EM);

        //Clase de Acciones
        tpID = new Label("Clase de Acciones");
        vlInv.addComponent(tpID, 4, 2);
        vlInv.setComponentAlignment(tpID, Alignment.MIDDLE_LEFT);
        tpID.setWidth(9, Sizeable.Unit.EM);

        claseAcciones.setValue(resultadoLista[2]);
        vlInv.addComponent(claseAcciones, 6, 2);
        vlInv.setComponentAlignment(claseAcciones, Alignment.MIDDLE_LEFT);
        claseAcciones.setWidth(11, Sizeable.Unit.EM);

        //Nombre y Código de la SCB
        tpID = new Label("Nombre y código de la SCB");
        vlInv.addComponent(tpID, 0, 3);
        vlInv.setComponentAlignment(tpID, Alignment.MIDDLE_LEFT);
        tpID.setWidth(14, Sizeable.Unit.EM);

        vlInv.addComponent(nomSocComBol, 2, 3);
        vlInv.setComponentAlignment(nomSocComBol, Alignment.MIDDLE_LEFT);
        nomSocComBol.setWidth(13, Sizeable.Unit.EM);
        codSocComBol1.setId("codSocComBol1style");
        vlInv.addComponent(codSocComBol1, 3, 3);
        vlInv.setComponentAlignment(codSocComBol1, Alignment.MIDDLE_RIGHT);
        codSocComBol1.setWidth(5, Sizeable.Unit.EM);

        //Consecutivo Oferta de Venta
        tpID = new Label("Consecutivo Oferta de Venta");
        vlInv.addComponent(tpID, 4, 3);
        vlInv.setComponentAlignment(tpID, Alignment.MIDDLE_LEFT);
        tpID.setWidth(10, Sizeable.Unit.EM);

        conseOferta.setMaxLength(8);
        vlInv.addComponent(conseOferta, 6, 3);
        vlInv.setComponentAlignment(conseOferta, Alignment.MIDDLE_LEFT);
        conseOferta.setWidth(10, Sizeable.Unit.EM);
        conseOferta.setValue(consecutivoOfertaVenta);
        conseOferta.setEnabled(false);

        //**Se vende con condición Todo o Nada**// 
        tpID = new Label("Se vende con condición Todo o Nada");
        vlInv.addComponent(tpID, 0, 5);
        vlInv.setComponentAlignment(tpID, Alignment.MIDDLE_LEFT);
        tpID.setWidth(13, Sizeable.Unit.EM);

        TN.setTextInputAllowed(false);
        TN.setNullSelectionAllowed(false);
        TN.addItem("");
        TN.setItemCaption("", "Seleccione");
        TN.addItem(1);
        TN.setItemCaption(1, "Si");
        TN.addItem(2);
        TN.setItemCaption(2, "No");

        if (ConTodoNada.equals("1")) {
            TN.select(1);
        } else if (ConTodoNada.equals("0")||ConTodoNada.equals("2")) {
            TN.select(2);
        }

        TN.setEnabled(false);
        vlInv.addComponent(TN, 2, 5);
        vlInv.setComponentAlignment(TN, Alignment.MIDDLE_LEFT);
        TN.setWidth(10, Sizeable.Unit.EM);

        //Existe Preacuerdo
        tpID = new Label("Existe Preacuerdo");
        vlInv.addComponent(tpID, 4, 5);
        vlInv.setComponentAlignment(tpID, Alignment.MIDDLE_LEFT);
        tpID.setWidth(9, Sizeable.Unit.EM);

        preacuerdo.setTextInputAllowed(false);
        preacuerdo.setNullSelectionAllowed(false);
        preacuerdo.addItem("");
        preacuerdo.setItemCaption("", "Seleccione");
        preacuerdo.addItem(1);
        preacuerdo.setItemCaption(1, "Si");
        preacuerdo.addItem(2);
        preacuerdo.setItemCaption(2, "No");

        if (Existepreacuerdo.equals("1")) {
            preacuerdo.select(1);
        } else if (Existepreacuerdo.equals("2")) {
            preacuerdo.select(2);
        }

        vlInv.addComponent(preacuerdo, 6, 5);
        vlInv.setComponentAlignment(preacuerdo, Alignment.MIDDLE_LEFT);
        preacuerdo.setWidth(10, Sizeable.Unit.EM);
        preacuerdo.setEnabled(false);

        //No. de Acciones que acepto vender (cantidad en números)
        tpID = new Label("No. de Acciones que acepto vender (cantidad en números)");
        vlInv.addComponent(tpID, 0, 7);
        vlInv.setComponentAlignment(tpID, Alignment.MIDDLE_LEFT);
        tpID.setWidth(13, Sizeable.Unit.EM);
        numeroAccionesven.setMaxLength(15);

        vlInv.addComponent(numeroAccionesven, 2, 7);
        vlInv.setComponentAlignment(numeroAccionesven, Alignment.MIDDLE_LEFT);
        numeroAccionesven.setValue(moneyFormatter.format(Double.parseDouble(NumAccionesvender.replace(".", "").split("&")[0])));
        numeroAccionesven.setValue(NumAccionesvender);
        numeroAccionesven.setEnabled(false);

        // Monto Total 
        lbl_montoTotalAccionesVender = new Label("Monto Total de las Acciones que acepto vender");
        vlInv.addComponent(lbl_montoTotalAccionesVender, 4, 7);
        vlInv.setComponentAlignment(lbl_montoTotalAccionesVender, Alignment.MIDDLE_LEFT);
        lbl_montoTotalAccionesVender.setWidth(11, Sizeable.Unit.EM);

        COPMontoTotal = new Label("<p align=\"right\" style=\\\"font-size:16px;color:rgb(0,0,0);width:2px\\\">$</p>", Label.CONTENT_RAW);
        vlInv.addComponent(COPMontoTotal, 5, 7);
        vlInv.setComponentAlignment(COPMontoTotal, Alignment.MIDDLE_RIGHT);
        COPMontoTotal.setWidth(2, Sizeable.Unit.EM);

        montoTotalAccionesven.setMaxLength(30);
        vlInv.addComponent(montoTotalAccionesven, 6, 7);
        vlInv.setComponentAlignment(montoTotalAccionesven, Alignment.MIDDLE_LEFT);
        montoTotalAccionesven.setValue(MontoTotalAcciones);
        montoTotalAccionesven.setEnabled(false);
        montoTotalAccionesven.setWidth(10, Sizeable.Unit.EM);

        //Porcentaje para pago en efectivo
        lbPorcentajePagoEfectivo = new Label("Porcentaje para pago en efectivo");
        lbPorcentajePagoEfectivo.setId("lbPorcentajePagoEfectivo");
        vlInv.addComponent(lbPorcentajePagoEfectivo, 0, 9);
        vlInv.setComponentAlignment(lbPorcentajePagoEfectivo, Alignment.MIDDLE_LEFT);
        lbPorcentajePagoEfectivo.setWidth(13, Sizeable.Unit.EM);
        PorcentajepagoEfectivo.setMaxLength(3);
        vlInv.addComponent(PorcentajepagoEfectivo, 2, 9);
        vlInv.setComponentAlignment(PorcentajepagoEfectivo, Alignment.MIDDLE_LEFT);
        lbPorcentaje = new Label("<p align=\"left\" style=\\\"font-size:16px;color:rgb(0,0,0);width:2px\\\">%</p>", Label.CONTENT_RAW);
        //lbPorcentaje.setStyleName("lbporcentaje");
        lbPorcentajePagoEfectivo.setId("lbPorcentaje");
        vlInv.addComponent(lbPorcentaje, 3, 9);
        vlInv.setComponentAlignment(lbPorcentaje, Alignment.MIDDLE_LEFT);
        PorcentajepagoEfectivo.setValue(PorcentajePagoEfectivo);
        PorcentajepagoEfectivo.setEnabled(false);
        //PorcentajepagoEfectivo.setWidth(10, Sizeable.Unit.EM);

        //Nuevo campo seleccionado en la parametrización: Porcentaje en efectivo Lista: Acciones ó Efectivo
        lbl_porcentajePagoEfectivoList = new Label("Forma de Pago");

        cbox_porcentajePagoEfectivoList.setTextInputAllowed(false);
        cbox_porcentajePagoEfectivoList.setNullSelectionAllowed(false);
        cbox_porcentajePagoEfectivoList.addItem(0);
        cbox_porcentajePagoEfectivoList.setItemCaption(0, "Seleccione");
        cbox_porcentajePagoEfectivoList.addItem(1);
        cbox_porcentajePagoEfectivoList.setItemCaption(1, "Efectivo");
        cbox_porcentajePagoEfectivoList.addItem(2);
        cbox_porcentajePagoEfectivoList.setItemCaption(2, "Valores");

        //porcentaje pago efectivo list
        vlInv.addComponent(lbl_porcentajePagoEfectivoList, 4, 9);
        vlInv.setComponentAlignment(lbl_porcentajePagoEfectivoList, Alignment.MIDDLE_LEFT);
        lbl_porcentajePagoEfectivoList.setWidth(11, Sizeable.Unit.EM);

        vlInv.addComponent(cbox_porcentajePagoEfectivoList, 6, 9);

        //Deja seleccionado el valor que viene de Base de Datos
        cbox_porcentajePagoEfectivoList.select(tipoPago);
        cbox_porcentajePagoEfectivoList.setEnabled(Boolean.FALSE);

        //Texto        
        texto2.setWidth("100%");
        texto2.setValue(resultadoLista[4]);
        vlInv.addComponent(texto2, 0, 11, 6, 11);
        texto2.setEnabled(false);

        //*************************************************************//
        //*******************CONDICIONES ACEPTACIÓN***********************//
        //*************************************************************// 
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
        texto3.setValue(resultadoLista[5]);
        vlInv.addComponent(texto3, 0, 13, 4, 14);
        texto3.setEnabled(false);
/////////////combobox1
        vlInv.addComponent(txtf_TerminosCondicion1, 5, 13, 6, 13);
        vlInv.setComponentAlignment(txtf_TerminosCondicion1, Alignment.MIDDLE_CENTER);
        txtf_TerminosCondicion1.setValue(Condicion1);
        txtf_TerminosCondicion1.setEnabled(false);

        lbl_errTerminosCondicion1.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errTerminosCondicion1, 6, 14);

//        txtf_TerminosCondicion1.addValueChangeListener(new Property.ValueChangeListener() {
//            @Override
//            public void valueChange(Property.ValueChangeEvent event) {
//                boolean isSelected = txtf_TerminosCondicion1.getValue().booleanValue();
//
//            if(isSelected ){
//                txtf_TerminosCondicion1.setValue(true);
//                txtf_TerminosCondicion1.setComponentError(null);
//                lbl_errTerminosCondicion1.setValue("");
//                condicion1="S";
//                } else {
//                txtf_TerminosCondicion1.setValue(false);
//                txtf_TerminosCondicion1.setComponentError(new UserError(""));
//                lbl_errTerminosCondicion1.setValue("Debe aceptar condiciones");
//                condicion1="N";
//                }
//               System.out.println( txtf_TerminosCondicion1.getValue());
//
//            ValidarError();
//            }
//
//        });			
        //Texto 4       
        texto4.setWidth("100%");
        texto4.setValue(resultadoLista[6]);
        vlInv.addComponent(texto4, 0, 15, 4, 16);
        texto4.setEnabled(false);

/////////////combobox
        vlInv.addComponent(txtf_TerminosCondicion2, 5, 15, 6, 15);
        vlInv.setComponentAlignment(txtf_TerminosCondicion2, Alignment.MIDDLE_CENTER);
        txtf_TerminosCondicion2.setValue(Condicion2);
        txtf_TerminosCondicion2.setEnabled(false);

        lbl_errTerminosCondicion2.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errTerminosCondicion2, 6, 16);

//        txtf_TerminosCondicion2.addValueChangeListener(new Property.ValueChangeListener() {
//            @Override
//            public void valueChange(Property.ValueChangeEvent event) {
//                boolean isSelected = txtf_TerminosCondicion2.getValue().booleanValue();
//                if(isSelected ){
//                txtf_TerminosCondicion2.setValue(true);
//                txtf_TerminosCondicion2.setComponentError(null);
//                lbl_errTerminosCondicion2.setValue("");
//                 condicion2="S";
//                } else {
//                txtf_TerminosCondicion2.setValue(false);
//                txtf_TerminosCondicion2.setComponentError(new UserError(""));
//                lbl_errTerminosCondicion2.setValue("Debe aceptar condiciones");
//                 condicion2="S";
//                }
//               System.out.println( txtf_TerminosCondicion2.getValue());
//                ValidarError();
//            }
//        });
        //*************************************************************//
        //*******************DATOS DEL VENDEDOR***********************//
        //*************************************************************//           
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
        vlInv.addComponent(vlCab, 0, 20, 6, 20);

        //Menú Apoderado
        if (Integer.parseInt(parametros.get(44)) == 1) {
            tpID = new Label("Origen Operación MILA");
            vlInv.addComponent(tpID, 0, 21);
            vlInv.setComponentAlignment(tpID, Alignment.MIDDLE_LEFT);
            tpID.setWidth(13, Sizeable.Unit.EM);
            vlInv.addComponent(cmbOrigenMila, 2, 21);
            vlInv.setComponentAlignment(cmbOrigenMila, Alignment.MIDDLE_LEFT);
            cmbOrigenMila.setWidth(9, Sizeable.Unit.EM);
            cmbOrigenMila.addBlurListener(new FieldEvents.BlurListener() {
                @Override
                public void blur(FieldEvents.BlurEvent event) {
                    if (cmbOrigenMila.getValue() == null || cmbOrigenMila.getValue().equals("")) {
                        cmbTipoDoc.setValue("");
                        nombres.setValue("");
                        numDocumento.setValue("");
                        txtIden.setValue("");
                        txtCuentainv.setValue("");
                        cmbTipoDoc.setEnabled(true);
                        numDocumento.setEnabled(true);
                        txtIden.setEnabled(true);
                        txtCuentainv.setEnabled(true);
                        lbespecialfid.setVisible(true);
                        txtEspFIDU.setVisible(true);
                        nombres.setEnabled(true);
                        nombres.setVisible(true);
                        lbNombres.setVisible(true);
                        asteriscosnombre.setVisible(true);
                        errnombres.setVisible(true);
                        lbl_direccion.setVisible(true);
                        txtf_direccion.setVisible(true);
                        lbl_errDireccion.setVisible(true);
                        asteriscoDireccion.setVisible(true);
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
                            nombres.setVisible(false);
                            nombres.setEnabled(false);
                            nombres.setValue(m.getPais());
                            nombres.setComponentError(null);
                            lbNombres.setVisible(false);
                            asteriscosnombre.setVisible(Boolean.TRUE);
                            numDocumento.setValue(m.getNumeroDocumento());
                            txtIden.setValue(m.getNumVerificacion());
                            txtCuentainv.setValue(m.getCuenta());
                            cmbTipoDoc.setValue(4);
                            txtf_direccion.setValue("");
                            mostrarMila();
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
            vlInv.addComponent(errOrigenMila, 2, 22);
            vlInv.setComponentAlignment(errOrigenMila, Alignment.TOP_CENTER);
        }
        //Tipo de documento
        tpID = new Label("Tipo de documento");
        vlInv.addComponent(tpID, 0, 23);
        vlInv.setComponentAlignment(tpID, Alignment.MIDDLE_LEFT);
        tpID.setWidth(9, Sizeable.Unit.EM);
        asteriscos = new Label("*");
        asteriscos.setStyleName("asterix");
        vlInv.addComponent(asteriscos, 1, 23);
        vlInv.setComponentAlignment(asteriscos, Alignment.MIDDLE_RIGHT);
        asteriscos.setWidth(2, Sizeable.Unit.EM);
        //cmbTipoDoc = new ComboBox();
        cmbTipoDoc = LlenarTipoDocumento();
        if (tipoDocumento.equals("1")) {
            cmbTipoDoc.select(1);
        } else if (tipoDocumento.equals("2")) {
            cmbTipoDoc.select(2);
        } else if (tipoDocumento.equals("3")) {
            cmbTipoDoc.select(3);
        } else if (tipoDocumento.equals("4")) {
            cmbTipoDoc.select(4);
        } else if (tipoDocumento.equals("5")) {
            cmbTipoDoc.select(5);
        } else if (tipoDocumento.equals("6")) {
            cmbTipoDoc.select(6);
        }

        //Nombres
        //lbNombres = new Label("Nombres");
        vlInv.addComponent(lbNombres, 0, 25);
        vlInv.setComponentAlignment(lbNombres, Alignment.MIDDLE_LEFT);
        lbNombres.setWidth(14, Sizeable.Unit.EM);
        asteriscosnombre = new Label("*");
        asteriscosnombre.setStyleName("asterix");
        vlInv.addComponent(asteriscosnombre, 1, 25);
        vlInv.setComponentAlignment(asteriscosnombre, Alignment.MIDDLE_RIGHT);
        asteriscosnombre.setWidth(2, Sizeable.Unit.EM);
        //asteriscosnombre.setVisible(false);
        nombres.setMaxLength(60);
        vlInv.addComponent(nombres, 2, 25);
        vlInv.setComponentAlignment(nombres, Alignment.MIDDLE_LEFT);
        //nombres.setWidth(10, Sizeable.Unit.EM);
        nombres.setValue(Nombres);
        //Validarnombreini();

        nombres.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
//                    if(valorCombo!=0){
                if (!cmbTipoDoc.getValue().equals(4)) {
                    //!cmbTipoDoc.getValue().equals(4)||valorCombo!=0||
//                        System.out.println("combo__"+cmbTipoDoc.getValue().toString());
//                        System.out.println("valor__"+valorCombo);
                    if (nombres.getValue().equals("")) {
                        nombres.setComponentError(new UserError(""));
                        errnombres.setValue("Este campo es requerido");
                    } else {
                        if (nombres.getValue().matches(regexTextTildesNumeros)) {
                            nombres.setComponentError(null);
                            errnombres.setValue("");
                        } else {
                            nombres.setComponentError(new UserError(""));
                            errnombres.setValue("Este campo contiene caracteres no válidos");
                        }
                    }
                } else {
                    if (nombres.getValue().equals("")) {
                        nombres.setComponentError(null);
                        errnombres.setValue("");
                    } else {
                        if (nombres.getValue().matches(regexTextTildesNumeros)) {
                            nombres.setComponentError(null);
                            errnombres.setValue("");
                        } else {
                            nombres.setComponentError(new UserError(""));
                            errnombres.setValue("Este campo contiene caracteres no válidos");
                        }
                    }
                }
//                    }
//                    else{
//                    if (nombres.getValue().equals("")) {
//                        nombres.setComponentError(null);
//                        errnombres.setValue("");
//                                 } else {
//                                        if (nombres.getValue().matches(regexTextTildesNumeros)) {
//                                            nombres.setComponentError(null);
//                                            errnombres.setValue("");
//                                        } else {
//                                            nombres.setComponentError(new UserError(""));
//                                            errnombres.setValue("Este campo contiene caracteres no válidos");
//                                            }
//                                    }
//                    }
                ValidarError();
            }
        });

        errnombres.setStyleName("lblerrores");
        vlInv.addComponent(errnombres, 2, 26);
        vlInv.setComponentAlignment(errnombres, Alignment.TOP_CENTER);

        //tipo de documento es NIT
        if (tipoDocumento.equals("4")) {
            txtIden.setVisible(true);
            txtIden.setValue(NumVer);
            txtEspFIDU.setEnabled(true);
            txtEspFIDU.setValue("");
            asteriscosnombre.setVisible(false);

            if (nombres.getValue().equals("")) {
                nombres.setComponentError(null);
                errnombres.setValue("");
            } else {
                if (nombres.getValue().matches(regexTextTildesNumeros)) {
                    nombres.setComponentError(null);
                    errnombres.setValue("");
                } else {
                    nombres.setComponentError(new UserError(""));
                    errnombres.setValue("Este campo contiene caracteres no válidos");
                }
            }
        } else {
            txtIden.setVisible(false);
            txtIden.setValue("");
            txtEspFIDU.setEnabled(false);
            txtEspFIDU.setValue("");
            txtIden.setComponentError(null);
            txtEspFIDU.setComponentError(null);
            errIden.setValue("");
            errEspFIDU.setValue("");
            txtIden.setComponentError(null);
            errIden1.setValue("");
            asteriscosnombre.setVisible(true);
            //!cmbTipoDoc.getValue().equals(4)||valorCombo!=0||
//                        System.out.println("combo__"+cmbTipoDoc.getValue().toString());
//                        System.out.println("valor__"+valorCombo);
            if (nombres.getValue().equals("")) {
                nombres.setComponentError(new UserError(""));
                errnombres.setValue("Este campo es requerido");
            } else {
                if (nombres.getValue().matches(regexTextTildesNumeros)) {
                    nombres.setComponentError(null);
                    errnombres.setValue("");
                } else {
                    nombres.setComponentError(new UserError(""));
                    errnombres.setValue("Este campo contiene caracteres no válidos");
                }
            }

        }

        vlInv.addComponent(cmbTipoDoc, 2, 23);
        vlInv.setComponentAlignment(cmbTipoDoc, Alignment.MIDDLE_LEFT);
        cmbTipoDoc.setWidth(9, Sizeable.Unit.EM);

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
                ValidarError();
                try {
                    valorCombo = (Integer) cmbTipoDoc.getValue();
                } catch (NullPointerException e) {
                    valorCombo = 0;
                } catch (ClassCastException ex) {
                    valorCombo = 0;
                }
                if (valorCombo == 4) {
                    txtIden.setVisible(true);
                    txtEspFIDU.setEnabled(true);
                    txtIden.setComponentError(null);
                    asteriscosnombre.setVisible(false);
                } else {
                    if (valorCombo != 4) {
                        txtIden.setVisible(false);
                        txtEspFIDU.setEnabled(false);
                        txtEspFIDU.setValue("");
                        txtIden.setValue("");
                        errIden1.setValue("");
                        txtIden.setComponentError(null);
                        asteriscosnombre.setVisible(true);
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
                    errIden.setValue("");
                    errEspFIDU.setValue("");
                    numDocumento.setComponentError(null);
                    errDocumento.setValue("");
                    errDocumento.setComponentError(null);
                }
                //
                if (valorCombo != 4) {
                    if (nombres.getValue().equals("")) {
                        nombres.setComponentError(new UserError(""));
                        errnombres.setValue("Este campo es requerido");
                    } else {
                        if (nombres.getValue().matches(regexTextTildesNumeros)) {
                            nombres.setComponentError(null);
                            errnombres.setValue("");
                        } else {
                            nombres.setComponentError(new UserError(""));
                            errnombres.setValue("Este campo contiene caracteres no válidos");
                        }
                    }
                } else {
                    if (nombres.getValue().equals("")) {
                        nombres.setComponentError(null);
                        errnombres.setValue("");
                    } else {
                        if (nombres.getValue().matches(regexTextTildesNumeros)) {
                            nombres.setComponentError(null);
                            errnombres.setValue("");
                        } else {
                            nombres.setComponentError(new UserError(""));
                            errnombres.setValue("Este campo contiene caracteres no válidos");
                        }
                    }
                }
                ValidarError();
            }
        });

        errTipoDocumento.setStyleName("lblerrores");
        vlInv.addComponent(errTipoDocumento, 2, 24);
        vlInv.setComponentAlignment(errTipoDocumento, Alignment.TOP_CENTER);

        //Número de documento
        tpID = new Label("Número de documento");
        vlInv.addComponent(tpID, 4, 23);
        vlInv.setComponentAlignment(tpID, Alignment.MIDDLE_LEFT);
        tpID.setWidth(10, Sizeable.Unit.EM);
        asteriscos = new Label("*");
        asteriscos.setStyleName("asterix");
        vlInv.addComponent(asteriscos, 5, 23);
        vlInv.setComponentAlignment(asteriscos, Alignment.MIDDLE_RIGHT);
        asteriscos.setWidth(2, Sizeable.Unit.EM);
        numDocumento.setMaxLength(15);

        txtIden.setWidth("15px");
        txtIden.setId("txtIden");
        txtIden.setMaxLength(1);

        /*NUMERO DE DOCUMENTO*/
        vlInv.addComponent(numDocumento, 6, 23);
        vlInv.setComponentAlignment(numDocumento, Alignment.MIDDLE_LEFT);
        numDocumento.setWidth(10, Sizeable.Unit.EM);
        numDocumento.setValue(numDocumen);

        numDocumento.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {
                try {
                    valorCombo = (Integer) cmbTipoDoc.getValue();
                } catch (NullPointerException ex) {
                    valorCombo = 0;
                } catch (ClassCastException e) {
                    valorCombo = 0;
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
                    try {
                        valorCombo = (Integer) cmbTipoDoc.getValue();
                    } catch (NullPointerException e) {
                        valorCombo = 0;
                    } catch (ClassCastException ex) {
                        valorCombo = 0;
                    }
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
                    errIden1.setValue("Este campo es requerido");
                }
                ValidarError();
            }
        });

        txtIden.setId("txtIden");
        vlInv.addComponent(txtIden, 7, 23);
        vlInv.setComponentAlignment(txtIden, Alignment.MIDDLE_LEFT);
        txtIden.setWidth(2, Sizeable.Unit.EM);

        errDocumento.setStyleName("lblerrores");
        vlInv.addComponent(errDocumento, 6, 24);
        vlInv.setComponentAlignment(errDocumento, Alignment.TOP_CENTER);

        errIden1.setId("lblerrores1");
        vlInv.addComponent(errIden1, 7, 24);
        vlInv.setComponentAlignment(errIden1, Alignment.MIDDLE_LEFT);
        tpID.setWidth(8, Sizeable.Unit.EM);


        //Especial Fiduciario
        //lbespecialfid = new Label("Especial fiduciario");
        lbespecialfid.setId("lblespecialFid");
        vlInv.addComponent(lbespecialfid, 4, 27);
        vlInv.setComponentAlignment(lbespecialfid, Alignment.MIDDLE_LEFT);
        lbespecialfid.setWidth(8, Sizeable.Unit.EM);
        asteriscos = new Label("*");
        asteriscos.setStyleName("asterix");
        txtEspFIDU.setMaxLength(3);
        txtEspFIDU.setValue(EspFid);

        vlInv.addComponent(txtEspFIDU, 6, 27);
        vlInv.setComponentAlignment(txtEspFIDU, Alignment.MIDDLE_LEFT);
        txtEspFIDU.setWidth(10, Sizeable.Unit.EM);
        txtEspFIDU.setValue(EspFid);
        txtEspFIDU.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (txtEspFIDU.getValue().matches(regexAlpha)) {
                    txtEspFIDU.setComponentError(null);
                    errEspFIDU.setValue("");
                } else {
                    txtEspFIDU.setComponentError(new UserError(""));
                    errEspFIDU.setValue("Este campo contiene caracteres no válidos");
                }
                ValidarError();
            }
        });

        errEspFIDU.setStyleName("lblerrores");
        vlInv.addComponent(errEspFIDU, 6, 28);
        vlInv.setComponentAlignment(errEspFIDU, Alignment.TOP_CENTER);

        //Cuenta Inversionista
        tpID = new Label("Cuenta Inversionista");
        vlInv.addComponent(tpID, 0, 27);
        vlInv.setComponentAlignment(tpID, Alignment.MIDDLE_LEFT);
        tpID.setWidth(9, Sizeable.Unit.EM);
        asteriscos = new Label("*");
        asteriscos.setStyleName("asterix");
        vlInv.addComponent(asteriscos, 1, 27);
        vlInv.setComponentAlignment(asteriscos, Alignment.MIDDLE_RIGHT);
        asteriscos.setWidth(2, Sizeable.Unit.EM);

        txtCuentainv.setMaxLength(8);
        txtCuentainv.setId("/*txtNombreApo*/");
        vlInv.addComponent(txtCuentainv, 2, 27);

        vlInv.setComponentAlignment(txtCuentainv, Alignment.MIDDLE_LEFT);
        txtCuentainv.setWidth(10, Sizeable.Unit.EM);
        txtCuentainv.setValue(cuentaInversionista);
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

        //Nombre del representante Legal de la SCB
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

        txtrepresentante.setMaxLength(50);
        txtrepresentante.setId("Nombre del representante legal");
        vlInv.addComponent(txtrepresentante, 6, 29);
        vlInv.setComponentAlignment(txtrepresentante, Alignment.MIDDLE_LEFT);
        txtrepresentante.setWidth(10, Sizeable.Unit.EM);
        txtrepresentante.setValue(nombreRepreLegal);
        txtrepresentante.setEnabled(false);
        txtrepresentante.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!txtrepresentante.getValue().equals("")) {
                    if (txtrepresentante.getValue().matches(regexTextTildes)) {
                        txtrepresentante.setComponentError(null);
                        errNombreRepresentante.setValue("");
                    } else {
                        txtrepresentante.setComponentError(new UserError(""));
                        errNombreRepresentante.setValue("Este campo contiene caracteres no válidos");
                    }
                } else {
                    txtrepresentante.setComponentError(new UserError(""));
                    errNombreRepresentante.setValue("Este campo es requerido");
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

        porcentajeComision.setValue(porComision);
        porcentajeComision.setMaxLength(7);
        //porcentajeComision.setWidth(10, Sizeable.Unit.EM);
        porcentajeComision.setId("porcentajeComision");

        vlInv.addComponent(porcentajeComision, 2, 29);
        vlInv.setComponentAlignment(porcentajeComision, Alignment.MIDDLE_LEFT);
        lbPorcentajeSimboloComision = new Label("<p align=\"left\" style=\\\"font-size:16px;color:rgb(0,0,0);width:2px\\\">%</p>", Label.CONTENT_RAW);
        //lbPorcentajeSimboloComision.setStyleName("lbporcentaje");
        lbPorcentajeComision.setId("lbPorcentaje");

        vlInv.addComponent(lbPorcentajeSimboloComision, 3, 29);
        vlInv.setComponentAlignment(lbPorcentajeSimboloComision, Alignment.MIDDLE_LEFT);

        errporcentajeComision.setStyleName("lblerrores");
        vlInv.addComponent(errporcentajeComision, 2, 30);

        porcentajeComision.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {
                PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
                if (!porcentajeComision.getValue().equals("") && porcentajeComision.getValue() != null) {

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

                                logger.error("OPA - " + ModificacionAceptaciones.class.getName(), ex);
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
                    porcentajeComision.setValue("0");
                    porcentajeComision.setComponentError(null);
                    errporcentajeComision.setValue("");

                }

                ValidarError();
            }
        });

        //Observacion
        lbObservacion = new Label("Observaciones");
        vlInv.addComponent(lbObservacion, 0, 31);
        vlInv.setComponentAlignment(lbObservacion, Alignment.MIDDLE_LEFT);
        lbObservacion.setWidth(8, Sizeable.Unit.EM);
        txtObservacion.setMaxLength(200);
        vlInv.addComponent(txtObservacion, 2, 31, 4, 31);
        vlInv.setComponentAlignment(txtObservacion, Alignment.MIDDLE_LEFT);
        txtObservacion.setWidth(23, Sizeable.Unit.EM);
        if (observacion != null && !observacion.equals("null") && !observacion.equals("")) {
            txtObservacion.setValue(observacion);
        }
        txtObservacion.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                txtObservacion.setComponentError(null);
                errObservacion.setValue("");

                ValidarError();

            }
        });

        errObservacion.setStyleName("lblerrores");
        vlInv.addComponent(errObservacion, 2, 32, 4, 32);
        vlInv.setComponentAlignment(errObservacion, Alignment.TOP_CENTER);
        
       //Campo de dirección
       if (Integer.parseInt(parametros.get(43)) == 1) {
           //Cuenta inversionista
            vlInv.addComponent(lbl_direccion, 0, 33);
           vlInv.setComponentAlignment(lbl_direccion, Alignment.MIDDLE_LEFT);
           lbl_direccion.setWidth(9, Sizeable.Unit.EM);

            //asteriscos = new Label("*");
            //asteriscoDireccion.setStyleName("asterix");
            //vlInv.addComponent(asteriscoDireccion, 1, 31);
            //vlInv.setComponentAlignment(asteriscoDireccion, Alignment.MIDDLE_RIGHT);
            //asteriscoDireccion.setWidth(2, Sizeable.Unit.EM);

           txtf_direccion.setMaxLength(50);
            vlInv.addComponent(txtf_direccion, 2, 33);
            lbl_errDireccion.setStyleName("lblerrores");
            vlInv.addComponent(lbl_errDireccion, 2, 34);

           txtf_direccion.addBlurListener(new FieldEvents.BlurListener() {

               @Override
               public void blur(FieldEvents.BlurEvent event) {

                   if (!txtf_direccion.getValue().equals("")) {
                       txtf_direccion.setComponentError(null);
                       //lbl_errDireccion.setValue("");
                   }
                   ValidarError();
               }
           });
       }

        //Se ocultan los campos de acuerdo a tipo de Oferta pública
        if (tipoOfertaPublica.equals("OPA")) {
            ocultarCamposOPI();
        } else {
            ocultarPorcentajePagoEfectivo();
        }
        
        //Botón Guardar
        vlInv.addComponent(btnGuardar, 1, 35, 2, 35);
        vlInv.setComponentAlignment(btnGuardar, Alignment.BOTTOM_CENTER);

        error.setStyleName("lblError");
        vlInv.addComponent(error, 1, 36, 2, 36);
        vlInv.setComponentAlignment(btnGuardar, Alignment.TOP_CENTER);

        vlPadre.addComponent(vlInv);

        btnGuardar.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {

                try {
                    combo = (Integer) cmbTipoDoc.getValue();
                } catch (NullPointerException e) {
                    combo = 0;
                } catch (ClassCastException ex) {
                    combo = 0;
                }
                if (combo == 4) {
                    NID = numDocumento.getValue() + txtIden.getValue();
                    if (txtIden.getValue().equals("")) {
                        txtIden.setComponentError(new UserError(""));
                        errIden1.setStyleName("lblerrores");
                        errIden1.setValue("Este campo es requerido");
                    }
                }
                //Aqui ajustar condicion todo o nada
                if (controlTN) {
                    try {
                        comboTN = (Integer) TN.getValue();
                    } catch (NullPointerException e) {
                        comboTN = 0;
                    } catch (ClassCastException ex) {
                        comboTN = 0;
                    }
                } else {
                    comboTN = null;
                }

                //Preacuerdo
                if (controlTN) {
                    try {
                        comboTN = (Integer) preacuerdo.getValue();
                    } catch (NullPointerException e) {
                        comboTN = 0;
                    } catch (ClassCastException ex) {
                        comboTN = 0;
                    }
                } else {
                    comboTN = null;
                }

                if (combo == 0) {
                    cmbTipoDoc.setComponentError(new UserError(""));
                    errTipoDocumento.setValue("Este campo es requerido");
                }
                if (conseOferta.getValue().equals("")) {
                    conseOferta.setComponentError(new UserError(""));
                    errconse.setValue("Este campo es requerido");
                }
                if (numeroAccionesven.getValue().equals("")) {
                    numeroAccionesven.setComponentError(new UserError(""));
                    erracciones.setValue("Este campo es requerido");
                }

                if (comboTN != null) {
                    if (comboTN == 0) {
                        //Aqui agregar condicion de presentación
                        TN.setComponentError(new UserError(""));
                        errCondicionTdNd.setValue("Este campo es requerido");
                    }
                }

                //Se agrega validación por OPI 
                //validar Nombre al guardar
                if (!cmbTipoDoc.getValue().equals(4)) {
                    if (nombres.getValue().equals("")) {
                        nombres.setComponentError(new UserError(""));
                        errnombres.setValue("Este campo es requerido");
                    } else {
                        if (nombres.getValue().matches(regexTextTildesNumeros)) {
                            nombres.setComponentError(null);
                            errnombres.setValue("");
                        } else {
                            nombres.setComponentError(new UserError(""));
                            errnombres.setValue("Este campo contiene caracteres no válidos");
                        }
                    }
                } else {
                    if (nombres.getValue().equals("")) {
                        nombres.setComponentError(null);
                        errnombres.setValue("");
                    } else {
                        if (nombres.getValue().matches(regexTextTildesNumeros)) {
                            nombres.setComponentError(null);
                            errnombres.setValue("");
                        } else {
                            nombres.setComponentError(new UserError(""));
                            errnombres.setValue("Este campo contiene caracteres no válidos");
                        }
                    }
                }
                //

                if (comboTN != null) {
                    if (comboTN == 0) {
                        //Aqui agregar condicion de presentación
                        preacuerdo.setComponentError(new UserError(""));
                        errExistePreacuerdo.setValue("Este campo es requerido");
                    }
                }

                /*if (razonSocial.getValue().equals("")) {
                    razonSocial.setComponentError(new UserError(""));
                    errRazonSocial.setValue("Este campo es requerido");
                }*/
                if (numDocumento.getValue().equals("")) {
                    numDocumento.setComponentError(new UserError(""));
                    errDocumento.setValue("Este campo es requerido");
                } else {
                    try {
                        valorCombo = (Integer) cmbTipoDoc.getValue();
                    } catch (NullPointerException e) {
                        valorCombo = 0;
                    } catch (ClassCastException ex) {
                        valorCombo = 0;
                    }
                }

                if (valorCombo == 4) {
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
                if (txtrepresentante.getValue().equals("")) {
                    txtrepresentante.setComponentError(new UserError(""));
                    errNombreRepresentante.setValue("Este campo es requerido");
                }

                if (!porcentajeComision.getValue().equals("")) {
                    PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
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

                                logger.error("OPA - " + ModificacionAceptaciones.class.getName(), ex);
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

                ValidarError();
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

                    if (!ValidaComponentError()) {

                        ConfirmDialog.show(UI.getCurrent(), "Confirmación", " ¿Está seguro que desea realizar los cambios?", "ACEPTAR",
                                "CANCELAR", new ConfirmDialog.Listener() {
                            @Override
                            public void onClose(ConfirmDialog dialog) {
                                if (dialog.isConfirmed()) {
                                    if (!ValidaComponentError()) {
                                        Date dNow = new Date();
                                        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                        ft.format(dNow);
                                        String strError = "";
                                        String pre = null;

                                        /*try {
                                            pre = (preacuerdo.getValue().toString());

                                        } catch (Exception e) {
                                            strError = "Preacuerdo null";
                                        } */
                                        Integer extPreacuerdo = 0;
                                        //Aqui agregar condicion de presentación
                                        if (controlTN) {
                                            if (Integer.parseInt(preacuerdo.getValue().toString()) == 2) {
                                                extPreacuerdo = 0;
                                            } else {
                                                extPreacuerdo = Integer.parseInt(preacuerdo.getValue().toString());
                                            }
                                        } else {
                                            extPreacuerdo = null;
                                        }

                                        Integer todo = 0;
                                        //Aqui agregar condicion de presentación
                                        if (controlTN) {
                                            if (Integer.parseInt(TN.getValue().toString()) == 2) {
                                                todo = 0;
                                            } else {
                                                todo = Integer.parseInt(TN.getValue().toString());
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
                                        Double num = 0.0;
                                        try {
                                            Number valor = form2.parse(porcentajeComision.getValue());
                                            num = valor.doubleValue();
                                        } catch (Exception ex) {
                                            num = null;
                                        }

                                        String texto2 = resultadoLista[4];
                                        String texto1 = resultadoLista[0];
                                        Double numAcciones = Double.valueOf(numeroAccionesven.getValue().replace(".", ""));
                                        String nomUsuario = userDetailsService.getUsuarioAutenticado().getUsername();

                                        String resultado = facade.ModificarAceptacion(claseAcciones.getValue(), conseOferta.getValue(), texto1,
                                                texto2, extPreacuerdo, codBolsa,
                                                nomSocComBol.getValue(), txtrepresentante.getValue(), nombres.getValue(),
                                                /*razonSocial.getValue(),*/ numAcciones, todo, Integer.parseInt(cmbTipoDoc.getValue().toString()),
                                                numDocumento.getValue(), dig, txtEspFIDU.getValue(), txtCuentainv.getValue(),
                                                userDetailsService.getUsuarioAutenticado().getId(), ft.format(dNow).toString(), userDetailsService.getUsuarioAutenticado().getId(), ft.format(dNow).toString(), txtObservacion.getValue().replace("'", "\'\'"), nomUsuario, idAceptacion, num, txtf_direccion.getValue(), comboMILA);

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
                                            cd.setContent(content);
                                            cd.show(UI.getCurrent(), new ConfirmDialog.Listener() {
                                                @Override
                                                public void onClose(ConfirmDialog cd) {
                                                    //  Limpiar();
                                                    ModificarAceptaciones mace = new ModificarAceptaciones(getParentTab());
                                                    vlPadre.removeAllComponents();
                                                    mace.setMuestraDireccion(parametros.get(43));
                                                    vlPadre.addComponent(mace.all());
                                                    vlPadre.setImmediate(true);
                                                    setImmediate(true);
                                                }
                                            }, true);
                                        } else {

                                            Notification.show("Hubo un Error Al Momento De Modificar La Aceptacion", Notification.Type.ERROR_MESSAGE);

                                        }

                                    }
                                }
                            }

                        });
                    }

                }

            }
        });

        //Boton Cancelar
        vlInv.addComponent(btnCancelar, 4, 35, 5, 35);
        vlInv.setComponentAlignment(btnCancelar, Alignment.BOTTOM_CENTER);
        btnCancelar.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                ModificarAceptaciones mace = new ModificarAceptaciones(getParentTab());
                vlPadre.removeAllComponents();
                mace.setMuestraDireccion(parametros.get(43));
                vlPadre.addComponent(mace.all());
                vlPadre.setImmediate(true);
                setImmediate(true);
            }
        });
        vlPadre.addComponent(vlInv);

        setContent(vlPadre);
        vlPadre.addComponent(vlInv);
        return vlPadre;
    }

    public void initForm() {

    }

    public ComboBox LlenarTipoDocumento() {
        Iterator<TipoDocumento> LTipo = null;
        LTipo = facade.RetornarDocumentos().iterator();
        TipoDocumento TP = null;
        //ComboBox combo = new ComboBox();
        cmbTipoDoc.setTextInputAllowed(false);
        cmbTipoDoc.setNullSelectionAllowed(false);
        cmbTipoDoc.addItem("");
        cmbTipoDoc.setItemCaption("", "Seleccione");
        while (LTipo.hasNext()) {
            TP = LTipo.next();
            if (TP.getTipodocumento() == 1 || TP.getTipodocumento() == 2 || TP.getTipodocumento() == 3 || TP.getTipodocumento() == 4 || TP.getTipodocumento() == 5 || TP.getTipodocumento() == 6) {
                cmbTipoDoc.addItem(TP.getTipodocumento());
                cmbTipoDoc.setItemCaption(TP.getTipodocumento(), TP.getNombredoc());
            }
        }
        return cmbTipoDoc;
    }

    public void Limpiar() {

        errconse.setValue("");
        errCondicionTdNd.setValue("");
        errExistePreacuerdo.setValue("");
        erracciones.setValue("");
        errEspFIDU.setValue("");
        /*errRazonSocial.setValue("");*/
        errIden.setValue("");
        errTipoDocumento.setValue("");
        errDocumento.setValue("");
        errIden.setValue("");
        errEspFIDU.setValue("");
        errCuentaInversionista.setValue("");
        errNombreRepresentante.setValue("");

        conseOferta.setValue("");
        conseOferta.setComponentError(null);
        numeroAccionesven.setValue("");
        numeroAccionesven.setComponentError(null);
        /*razonSocial.setValue("");
        razonSocial.setComponentError(null);*/
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

        TN.select("");
        TN.setComponentError(null);
        preacuerdo.select("");
        preacuerdo.setComponentError(null);
        cmbTipoDoc.select("");
        cmbTipoDoc.setComponentError(null);
        txtObservacion.setValue("");
        porcentajeComision.setValue("");
        porcentajeComision.setComponentError(null);

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
        if (conseOferta.getComponentError() != null || TN.getComponentError() != null) {

            return true;
        }
        if (preacuerdo.getComponentError() != null) {
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

        if (txtObservacion.getComponentError() != null) {
            return true;
        }
        if (porcentajeComision.getComponentError() != null) {
            return true;
        }

        return errores;
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

    /**
     * Oculta los campos de OPI del formulario para Oferta pública de
     * Intercambio
     */
    public void ocultarCamposOPI() {

        /*Se oculta los campos de los términos de la Aceptación de la OPA */
        lbl_montoTotalAccionesVender.setVisible(Boolean.FALSE);
        montoTotalAccionesven.setVisible(Boolean.FALSE);
        COPMontoTotal.setVisible(Boolean.FALSE);

        lbPorcentajePagoEfectivo.setVisible(Boolean.FALSE);
        PorcentajepagoEfectivo.setVisible(Boolean.FALSE);
        lbPorcentaje.setVisible(Boolean.FALSE);

        lbl_porcentajePagoEfectivoList.setVisible(Boolean.FALSE);
        cbox_porcentajePagoEfectivoList.setVisible(Boolean.FALSE);

        /*Se ocultan los campos de Aceptación de la emisión*/
        vlCabEncabezadoCondicionesEmision.setVisible(Boolean.FALSE);
        lbltitulo2.setVisible(Boolean.FALSE);
        texto3.setVisible(Boolean.FALSE);
        txtf_TerminosCondicion1.setVisible(Boolean.FALSE);
        lbl_errTerminosCondicion1.setVisible(Boolean.FALSE);

        texto4.setVisible(Boolean.FALSE);
        txtf_TerminosCondicion2.setVisible(Boolean.FALSE);
        lbl_errTerminosCondicion2.setVisible(Boolean.FALSE);
        lbl_errTerminosCondicion2.setVisible(Boolean.FALSE);
    }

    /**
     * Contiene la lógica de este campo de acuerdo a la parametrización
     * realizada
     */
    public void ocultarPorcentajePagoEfectivo() {

        /*Si el tipo de pago parametrizado es "Predeterminado" debe ocultarse 
            el campo de porcentaje de ingreso manual*/
        if (porcentajePagoEfectivoParametrizado == AppConstants.PORCENTAJE_PAGO_EFECTIVO_PARAM_PREDETERMINADO) {
            lbPorcentajePagoEfectivo.setVisible(Boolean.FALSE);
            PorcentajepagoEfectivo.setVisible(Boolean.FALSE);
            lbPorcentaje.setVisible(Boolean.FALSE);
        } else {
            lbl_porcentajePagoEfectivoList.setVisible(Boolean.FALSE);
            cbox_porcentajePagoEfectivoList.setVisible(Boolean.FALSE);
        }
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
    public void mostrarMila() {
        /*errRazonSocial.setValue("");*/
        errTipoDocumento.setValue("");
        errIden1.setValue("");
        errCuentaInversionista.setValue("");
        cmbTipoDoc.setEnabled(false);
        /*razonSocial.setEnabled(false);*/
        numDocumento.setEnabled(false);
        errDocumento.setValue("");
        txtIden.setEnabled(false);
        txtCuentainv.setEnabled(false);
        lbespecialfid.setVisible(false);
        txtEspFIDU.setVisible(false);
        lbl_direccion.setVisible(false);
        txtf_direccion.setVisible(false);
        lbl_errDireccion.setVisible(false);
        asteriscoDireccion.setVisible(false);
        nombres.setVisible(false);
        lbNombres.setVisible(false);
        asteriscosnombre.setVisible(false);
        errnombres.setVisible(false);
        cmbTipoDoc.setComponentError(null);
        numDocumento.setComponentError(null);
        nombres.setComponentError(null);
        /*razonSocial.setComponentError(null);*/
        txtIden.setComponentError(null);
        txtCuentainv.setComponentError(null);
    }
}
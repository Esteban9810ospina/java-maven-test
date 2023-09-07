/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.ui.contents;

import com.framework.common.service.security.MyUserDetailsService;
import com.framework.common.ui.GenericContent;
import com.framework.common.ui.GenericTab;
import com.quasar.frameq.db.Facade;
import com.framework.common.ui.util.ValidarCampos;
import com.vaadin.server.Sizeable;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.HorizontalLayout;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.dialogs.ConfirmDialog;
import com.quasar.frameq.Dao.AdjudicacionDao;
import com.framework.common.ui.util.GenerarArchivoInterfazBackOffice;
import com.framework.common.ui.util.GenerarArchivoReporteAdjudicacion;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.UI;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.GregorianCalendar;
import com.framework.common.ui.util.GenerarArchivoInterfaz20;
import com.quasar.frameq.interfaces.Interfaz20BO;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Administrador
 */
public class GenerarAdjudicacion extends GenericContent {

    private static final Logger logger = Logger.getLogger(GenerarAdjudicacion.class.getName());
    AdjudicacionDao parametrizacion = new AdjudicacionDao();
    ValidarCampos validacion = new ValidarCampos();
    Facade facade = new Facade();
    Interfaz20BO interfaz = new Interfaz20BO();

    TextField txt_maxaccionesOfert = new TextField();
    TextField txt_nemotecnico = new TextField();
    TextField txt_claseAcciones = new TextField();
    TextField txt_precio = new TextField();
    TextField txtf_precioDeLaOferta = new TextField();
    TextField txt_nomrazonsocial = new TextField();
    TextField txt_tipdocumento = new TextField();
    TextField txt_numdocumento = new TextField();
    TextField txt_digverificacion = new TextField();
    TextField txt_espfiduciario = new TextField();
    TextField txt_cuentaInversionista = new TextField();
    TextField txt_totalaceptaciones = new TextField();
    TextField txtf_DVOferente = new TextField();
    TextField txt_cantaccionestodonada = new TextField();
    TextField txt_conditodonada = new TextField();
    TextField txt_accionesofert = new TextField();
    TextField txt_cantaccionesacept = new TextField();

    ComboBox cbox_resConsecutivo = new ComboBox();

    TextArea txta_informacion = new TextArea();

    Button btn_Adjudicar = new Button();

    String minAccionesOb;
    String maxAccionesOb;
    String claseAcciones;
    String nemotecnico;
    String precioAceptaciones;
    String nombrerazonSocial;
    String numeroDocumento;
    String digVerificacion;
    String especialFiduciario;
    String nomCodSCB;
    String CodSCB;
    String cuentaInversionista;
    String tipDoc;
    String canTotalAcpetaciones;
    String canAccionesTodoNada;
    String totalAceptaciones;
    String totalAceptacionesTN;
    String fechanoApropiada;
    String horanoApropiada;
    String canAccionesSinTodoNada;
    String fechaAdjudicacion = validacion.fechaIngresoAdjudicacion();
    String horaAdjudicacion = validacion.horaIngresoAdjudicacion();
    String hayParametros = validacion.validaParametrovacio();
    String cantAccionestotales;
    String totalCantAceptaciones;
    String totalAccionesAdj;
    String totalMontoAdj;
    String SumAdjudicacion;
    String datos;
    String[] resultadoAdjudicacion;
    String[] llenarcampos;
    String[] listAccion;
    String[] lisAccionMenCant;
    String[] ListAccionesMasCant;
    String idAceptaci = "";
    String numAccionActu = "";
    String ActualizarAdjudicacion;
    String MaxAccionesObjOferta;
    String MinAccionesObjOferta;
    String umbral = (parametrizacion.umbral());
    String tipoOfertaPublica = "";
    // ********DATOS CONSOLIDACION****************
    int Umbral = Integer.parseInt(umbral);
    String precionaccionespago = (parametrizacion.precioaccionespago());
    Double Precionaccionespago = Double.parseDouble(precionaccionespago);
    String porcentajeefectivopago = (parametrizacion.porcentajeefectivopago());
    int Porcentajeefectivopago = Integer.parseInt(porcentajeefectivopago);
    double PorcentajeefectivopagoPara = Double.parseDouble(porcentajeefectivopago);
    boolean respuesta = false;
    Double canTotalAcciones = 0.0;
    Double minAccionesObjOferta = 0.0;
    Double maxAccionesObj;
    Double CantAccioneTN = 0.0;
    Double totalaceptaciones = 0.0;
    BigDecimal precioParametro = new BigDecimal("0.0");

    BigDecimal montotal;
    BigInteger totalaceptacion;
    BigDecimal sumPrecioAdju;
    BigDecimal maxAccionesOfert;
    BigDecimal minAccionesOfert;
    BigInteger cantAccionesSinTN;
    BigDecimal totalAcepta;
    BigInteger accionpendiente;
    BigInteger accionfaltante;
    BigInteger adicionarfaltante;
    BigDecimal monto;
    BigInteger totalaceptacioness;
    BigDecimal totalAdj;
    BigDecimal totalprecio;
    BigDecimal montAdj;
    BigInteger totalaccionesSobrantes;
    BigInteger uno;
    BigDecimal cantotal;
    BigDecimal totalsob;
    BigInteger resta;

    VerticalLayout layout;
    ProgressBar sample;
    Label porcentaje;
    Button startButton;
    Worker worker;

    int current = 0;
    int i = 0;

    final DecimalFormat form = new DecimalFormat("###,###");
    final DecimalFormat form1 = new DecimalFormat("#,##0.00");
    final DecimalFormat form3 = new DecimalFormat("###,###.00");
    final DecimalFormat form4 = new DecimalFormat("###,##");
    final DecimalFormat form5 = new DecimalFormat("###,##.0000");

    Calendar calendario = new GregorianCalendar();
    int hora, minutos, segundos;

    /*  Esta variable de instancia será consultada 
        por la lógica  este formulario de Oferta pública integrada.
     */
    List<String> parametros = null;

    Double canTotal = 0.0;
    Double midouble = 0.0;
    int j = 0;

    @Autowired
    private MyUserDetailsService userDetailsService;

    String nomUsuario = userDetailsService.getUsuarioAutenticado().getUsername();

    public GenerarAdjudicacion(GenericTab parentTab) {
        super(parentTab);
    }

    @Override
    public void initForm() {

        //Esto está muy mal hecho, debe cambiarse ! --TODO
        if (!hayParametros.equals("")) {
            ConfirmDialog cd = ConfirmDialog.getFactory().create("Confirmación", "", "ACEPTAR", "", "");
            cd.setWidth("400px");
            cd.setHeight("160px");
            HorizontalLayout texto = new HorizontalLayout();
            HorizontalLayout buttons = new HorizontalLayout();
            buttons.setStyleName("btnAceptar");
            Label lblmensaje = new Label(fechaAdjudicacion, ContentMode.HTML);
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

            parametros = facade.RetornaParametros();

            tipoOfertaPublica = parametros.get(41);

            hora = calendario.get(Calendar.HOUR_OF_DAY);
            minutos = calendario.get(Calendar.MINUTE);
            segundos = calendario.get(Calendar.SECOND);

            VerticalLayout vlPadre = new VerticalLayout();
            GridLayout vlInv = new GridLayout();
            vlInv.setColumns(7);
            vlInv.setRows(31);

            /*Llenar Campos*/
            datos = (parametrizacion.traerDatos());
            llenarcampos = datos.split(";");
            MinAccionesObjOferta = llenarcampos[0];
            MaxAccionesObjOferta = llenarcampos[1];
            String ClaseAcciones = llenarcampos[2];
            String Nanotecnico = llenarcampos[3];
            String PrecioAceptaciones = llenarcampos[4];
            String NombreRazonSocial = llenarcampos[5];
            String NumeroDocumentoOferente = llenarcampos[6];
            String DVOferente = llenarcampos[7];
            String EFOferente = llenarcampos[8];
            String CuentaDecevalOferente = llenarcampos[9];

            txta_informacion.setEnabled(false);

            /**
             * *****************************************************************
             */
            /**
             * ***********DATOS GENERALES DE LA ADJUDICACIÓN*******************
             */
            /**
             * ****************************************************************
             */
            HorizontalLayout vlCab = new HorizontalLayout();
            vlCab.setWidth(100, Sizeable.Unit.PERCENTAGE);
            Label lbl_adjudicacion = new Label("DATOS GENERALES DE LA ADJUDICACIÓN");
            lbl_adjudicacion.setWidth(100, Sizeable.Unit.PERCENTAGE);
            lbl_adjudicacion.setStyleName("tituloInversionistatit");
            Embedded imgEmb_datosGeneralesDeLaOferta = new Embedded(null, new ThemeResource("img/Inver.png"));
            imgEmb_datosGeneralesDeLaOferta.setHeight("35px");
            imgEmb_datosGeneralesDeLaOferta.setStyleName("InverImg");
            vlCab.addStyleName("tituloInversionista");
            vlCab.addComponents(imgEmb_datosGeneralesDeLaOferta, lbl_adjudicacion);
            vlCab.setComponentAlignment(lbl_adjudicacion, Alignment.MIDDLE_LEFT);
            vlInv.addComponent(vlCab, 0, 0, 6, 0);

            /**
             * ***************************************************************
             */
            Label lbl_accionesofert = new Label("Mínimo de acciones objeto oferta");
            lbl_accionesofert.setWidth(15, Sizeable.Unit.EM);
            vlInv.addComponent(lbl_accionesofert, 0, 1);
            vlInv.setComponentAlignment(lbl_accionesofert, Alignment.MIDDLE_LEFT);
            vlInv.addComponent(txt_accionesofert, 2, 1);
            vlInv.setComponentAlignment(txt_accionesofert, Alignment.MIDDLE_LEFT);
            txt_accionesofert.setValue(MinAccionesObjOferta);
            minAccionesObjOferta = Double.parseDouble(txt_accionesofert.getValue().replace(".", "").split("&")[0]);
            txt_accionesofert.setValue(form.format(minAccionesObjOferta));
            txt_accionesofert.setEnabled(false);

            Label lbl_maxaaccionesOfert = new Label("Máximo de Acciones objeto oferta");
            vlInv.addComponent(lbl_maxaaccionesOfert, 4, 1);
            vlInv.setComponentAlignment(lbl_maxaaccionesOfert, Alignment.MIDDLE_LEFT);
            lbl_maxaaccionesOfert.setWidth(15, Sizeable.Unit.EM);
            vlInv.addComponent(txt_maxaccionesOfert, 5, 1);
            vlInv.setComponentAlignment(txt_maxaccionesOfert, Alignment.MIDDLE_LEFT);
            txt_maxaccionesOfert.setValue(MaxAccionesObjOferta);
            maxAccionesObj = Double.parseDouble(txt_maxaccionesOfert.getValue().replace(".", "").split("&")[0]);
            txt_maxaccionesOfert.setValue(form.format(maxAccionesObj));
            txt_maxaccionesOfert.setEnabled(false);

            Label lbl_claseAcciones = new Label("Clase de Acciones");
            vlInv.addComponent(lbl_claseAcciones, 0, 3);
            vlInv.setComponentAlignment(lbl_claseAcciones, Alignment.MIDDLE_LEFT);
            vlInv.addComponent(txt_claseAcciones, 2, 3);
            vlInv.setComponentAlignment(txt_claseAcciones, Alignment.MIDDLE_LEFT);
            txt_claseAcciones.setValue(ClaseAcciones);
            txt_claseAcciones.setEnabled(false);

            Label lbl_nemotecnico = new Label("Nemotécnico");
            vlInv.addComponent(lbl_nemotecnico, 4, 3);
            vlInv.setComponentAlignment(lbl_nemotecnico, Alignment.MIDDLE_LEFT);
            vlInv.addComponent(txt_nemotecnico, 5, 3);
            vlInv.setComponentAlignment(txt_nemotecnico, Alignment.MIDDLE_LEFT);
            txt_nemotecnico.setValue(Nanotecnico);
            txt_nemotecnico.setEnabled(false);

            Label lbl_precio = new Label("Precio");
            vlInv.addComponent(lbl_precio, 0, 5);
            vlInv.setComponentAlignment(lbl_precio, Alignment.MIDDLE_LEFT);
            vlInv.addComponent(txt_precio, 2, 5);
            txt_precio.setValue(form3.format(Double.valueOf(PrecioAceptaciones)));
            txt_precio.setEnabled(false);
            //precioPara = Double.parseDouble(PrecioAceptaciones);
            precioParametro = new BigDecimal(PrecioAceptaciones).setScale(2, RoundingMode.DOWN);

            /**
             * *****************************************************************
             */
            /**
             * ***********DATOS DEL OFERENTE***********************************
             */
            /**
             * ****************************************************************
             */
            vlCab = new HorizontalLayout();
            vlCab.setWidth(100, Sizeable.Unit.PERCENTAGE);
            Label lbl_datosoferente = new Label("DATOS DEL OFERENTE");
            lbl_datosoferente.setWidthUndefined();
            lbl_datosoferente.setStyleName("tituloInversionistatit");
            Embedded imgEmb_datosGeneralesDeLFormulario = new Embedded(null, new ThemeResource("img/Inver.png"));
            imgEmb_datosGeneralesDeLFormulario.setStyleName("InverImg");
            imgEmb_datosGeneralesDeLFormulario.setHeight("35px");
            vlCab.addStyleName("tituloInversionista");
            vlCab.addComponent(imgEmb_datosGeneralesDeLFormulario);
            vlCab.addComponent(lbl_datosoferente);
            vlCab.setComponentAlignment(lbl_datosoferente, Alignment.MIDDLE_CENTER);
            vlInv.addComponent(vlCab, 0, 9, 6, 9);

            Label lbl_nomrazonsocial = new Label("Nombre/Razón Social");
            vlInv.addComponent(lbl_nomrazonsocial, 0, 10);
            vlInv.setComponentAlignment(lbl_nomrazonsocial, Alignment.MIDDLE_LEFT);
            vlInv.addComponent(txt_nomrazonsocial, 2, 10);
            vlInv.setComponentAlignment(txt_nomrazonsocial, Alignment.MIDDLE_LEFT);
            txt_nomrazonsocial.setValue(NombreRazonSocial);
            txt_nomrazonsocial.setEnabled(false);

            tipDoc = (parametrizacion.tipDocumento());
            Label lbl_tipodocumento = new Label("Tipo de documento");
            vlInv.addComponent(lbl_tipodocumento, 4, 10);
            vlInv.addComponent(txt_tipdocumento, 5, 10);
            vlInv.setComponentAlignment(txt_tipdocumento, Alignment.MIDDLE_LEFT);
            txt_tipdocumento.setValue(tipDoc);
            txt_tipdocumento.setEnabled(false);

            Label lbl_numdocumento = new Label("Número de documento");
            vlInv.addComponent(lbl_numdocumento, 0, 12);
            vlInv.addComponent(txt_numdocumento, 2, 12);
            txt_numdocumento.setValue(NumeroDocumentoOferente);
            txt_numdocumento.setEnabled(false);

            vlInv.addComponent(txt_digverificacion, 3, 12);
            vlInv.setComponentAlignment(txt_digverificacion, Alignment.MIDDLE_LEFT);
            txt_digverificacion.setWidth(3, Sizeable.Unit.EM);
            txt_digverificacion.setValue(DVOferente);
            txt_digverificacion.setEnabled(false);

            Label lbl_espfiduciario = new Label("Especial Fiduciario");
            vlInv.addComponent(lbl_espfiduciario, 4, 12);

            vlInv.addComponent(txt_espfiduciario, 5, 12);
            vlInv.setComponentAlignment(txt_espfiduciario, Alignment.MIDDLE_LEFT);
            txt_espfiduciario.setValue(EFOferente);
            txt_espfiduciario.setEnabled(false);

            Label lbl_cuentaInversionista = new Label("Cuenta Inversionista");
            vlInv.addComponent(lbl_cuentaInversionista, 0, 14);
            vlInv.setComponentAlignment(lbl_cuentaInversionista, Alignment.MIDDLE_LEFT);
            vlInv.addComponent(txt_cuentaInversionista, 2, 14);
            vlInv.setComponentAlignment(txt_cuentaInversionista, Alignment.MIDDLE_LEFT);
            txt_cuentaInversionista.setValue(CuentaDecevalOferente);
            txt_cuentaInversionista.setEnabled(false);

            nomCodSCB = (parametrizacion.nomCodSCB());
            CodSCB = (parametrizacion.CodSCB());
            Label lb_nomcodSCB = new Label("Nombre y código de la SCB");
            vlInv.addComponent(lb_nomcodSCB, 0, 16);
            vlInv.setComponentAlignment(lb_nomcodSCB, Alignment.MIDDLE_LEFT);
            Label lb_nomcodSCB2 = new Label("");
            vlInv.addComponent(lb_nomcodSCB2, 2, 16);
            vlInv.setComponentAlignment(lb_nomcodSCB2, Alignment.MIDDLE_LEFT);
            lb_nomcodSCB2.setValue(nomCodSCB);
            lb_nomcodSCB2.setEnabled(false);

            Label lbl_codigoSCB = new Label();
            vlInv.addComponent(lbl_codigoSCB, 3, 16);
            vlInv.setComponentAlignment(lbl_codigoSCB, Alignment.MIDDLE_LEFT);
            lbl_codigoSCB.setValue(CodSCB);
            lbl_codigoSCB.setEnabled(false);

            /**
             * *****************************************************************
             */
            /**
             * *******DATOS DE LAS
             * ACEPTACIONES*********************************
             */
            /**
             * ****************************************************************
             */
            Label lbl_datosGeneralesaceptaciones = new Label("DATOS DE LAS ACEPTACIONES");
            vlCab = new HorizontalLayout();
            vlCab.setWidth(100, Sizeable.Unit.PERCENTAGE);
            lbl_datosGeneralesaceptaciones.setWidthUndefined();
            lbl_datosGeneralesaceptaciones.setStyleName("tituloInversionistatit");
            Embedded imgEmb_datosGeneralesDeLOferente = new Embedded(null, new ThemeResource("img/Inver.png"));
            imgEmb_datosGeneralesDeLOferente.setStyleName("InverImg");
            imgEmb_datosGeneralesDeLOferente.setHeight("35px");
            vlCab.addStyleName("tituloInversionista");
            vlCab.addComponent(imgEmb_datosGeneralesDeLOferente);
            vlCab.addComponent(lbl_datosGeneralesaceptaciones);
            vlCab.setComponentAlignment(lbl_datosGeneralesaceptaciones, Alignment.MIDDLE_CENTER);
            vlInv.addComponent(vlCab, 0, 20, 6, 20);

            canTotalAcpetaciones = (parametrizacion.canTotalAcciones());
            Label lbl_cantaccionesacept = new Label("Cant. Total acciones aceptadas");
            vlInv.addComponent(lbl_cantaccionesacept, 0, 21, 1, 21);
            vlInv.setComponentAlignment(lbl_cantaccionesacept, Alignment.MIDDLE_LEFT);
            vlInv.addComponent(txt_cantaccionesacept, 2, 21);
            vlInv.setComponentAlignment(txt_cantaccionesacept, Alignment.MIDDLE_RIGHT);
            txt_cantaccionesacept.setValue(canTotalAcpetaciones);
            canTotalAcciones = Double.parseDouble(txt_cantaccionesacept.getValue().replace(".", "").split("&")[0]);
            txt_cantaccionesacept.setValue(form.format(canTotalAcciones));
            txt_cantaccionesacept.setEnabled(false);

            totalAceptaciones = (parametrizacion.totalAceptaciones());
            Label lbl_totalaceptaciones = new Label("Total de aceptaciones");
            vlInv.addComponent(lbl_totalaceptaciones, 4, 21);
            vlInv.setComponentAlignment(lbl_totalaceptaciones, Alignment.MIDDLE_RIGHT);
            vlInv.addComponent(txt_totalaceptaciones, 5, 21);
            vlInv.setComponentAlignment(txt_totalaceptaciones, Alignment.MIDDLE_RIGHT);
            totalaceptaciones = Double.parseDouble(totalAceptaciones);
            txt_totalaceptaciones.setValue(form.format((totalaceptaciones)));
            txt_totalaceptaciones.setEnabled(false);

            canAccionesTodoNada = (parametrizacion.canAccionesTodoNada());
            Label lbl_cantaccionestodonada = new Label("Cant. Acciones aceptadas  en condición Todo o Nada");
            vlInv.addComponent(lbl_cantaccionestodonada, 0, 23, 1, 23);
            lbl_cantaccionestodonada.setWidth(15, Sizeable.Unit.EM);

            vlInv.setComponentAlignment(lbl_cantaccionestodonada, Alignment.MIDDLE_LEFT);
            vlInv.addComponent(txt_cantaccionestodonada, 2, 23);
            vlInv.setComponentAlignment(txt_cantaccionestodonada, Alignment.MIDDLE_RIGHT);
            txt_cantaccionestodonada.setWidth(12, Sizeable.Unit.EM);
            txt_cantaccionestodonada.setValue(canAccionesTodoNada);
            CantAccioneTN = Double.parseDouble(txt_cantaccionestodonada.getValue().replace(".", "").split("&")[0]);
            txt_cantaccionestodonada.setValue(form.format(CantAccioneTN));
            txt_cantaccionestodonada.setEnabled(false);

            totalAceptacionesTN = (parametrizacion.totalAceptacionesTN());
            Label lbl_conditodonada = new Label("Total de aceptaciones en condición Todo o Nada");
            vlInv.addComponent(lbl_conditodonada, 4, 23);
            lbl_conditodonada.setWidth(15, Sizeable.Unit.EM);
            vlInv.setComponentAlignment(lbl_conditodonada, Alignment.MIDDLE_RIGHT);
            vlInv.addComponent(txt_conditodonada, 5, 23);
            vlInv.setComponentAlignment(txt_conditodonada, Alignment.MIDDLE_RIGHT);
            Double totalaceptacionesTN = Double.parseDouble(totalAceptacionesTN);
            txt_conditodonada.setValue(form.format((totalaceptacionesTN)));
            txt_conditodonada.setWidth(12, Sizeable.Unit.EM);
            txt_conditodonada.setEnabled(false);

            /**
             * ********************************
             */
            /**
             * ********TEXTAREA****************
             */
            /**
             * ********************************
             */
            vlCab = new HorizontalLayout();
            vlCab.setWidth(100, Sizeable.Unit.PERCENTAGE);
            txta_informacion.setWidth(100, Sizeable.Unit.PERCENTAGE);
            vlCab.setHeight(91, Sizeable.Unit.PERCENTAGE);
            txta_informacion.setHeight(91, Sizeable.Unit.PERCENTAGE);
            vlCab.addComponent(txta_informacion);
            vlCab.setComponentAlignment(txta_informacion, Alignment.MIDDLE_CENTER);
            vlInv.addComponent(vlCab, 0, 25, 5, 25);

            vlPadre.addComponent(vlInv);
            vlInv.setSpacing(true);

            vlInv.setColumnExpandRatio(0, 80);
            vlInv.setColumnExpandRatio(1, 20);
            vlInv.setColumnExpandRatio(2, 5);
            vlInv.setColumnExpandRatio(3, 80);
            vlInv.setColumnExpandRatio(4, 20);
            vlInv.setColumnExpandRatio(5, 5);

            //Barra de Proceso
            layout = new VerticalLayout();
            layout.setSpacing(true);
            layout.setSizeFull();

            VerticalLayout HL = new VerticalLayout();
            HL.setStyleName("noflex");
            btn_Adjudicar.setStyleName("btnAdjudicar");
            HL.addComponent(btn_Adjudicar);
            startButton = new Button();
            sample = new ProgressBar();
            porcentaje = new Label();
            //layout.setStyleName("noflex"); 
            porcentaje.setStyleName("lblporcentaje");
            layout.addComponents(porcentaje, sample);
            sample.setVisible(false);
            vlPadre.setSpacing(true);
            vlPadre.addComponents(HL, layout);
            HL.setComponentAlignment(btn_Adjudicar, Alignment.TOP_CENTER);
            layout.setComponentAlignment(porcentaje, Alignment.MIDDLE_CENTER);
            layout.setComponentAlignment(sample, Alignment.BOTTOM_CENTER);

            btn_Adjudicar.addListener(new Button.ClickListener() {
                public void buttonClick(ClickEvent event) {
                    mensajeDialogo();
                    txta_informacion.setValue("");
                }
            });

            startButton.addClickListener(new Button.ClickListener() {
                public void buttonClick(final ClickEvent event) {
                    btn_Adjudicar.setEnabled(false);
                    validarCampos();
                    worker = new Worker();
                    worker.start();
                    sample.setValue(0f);
                    sample.setVisible(true);
                    UI.getCurrent().setPollInterval(500);
                }
            });

            setContent(vlPadre);
        }
    }

    private void validarCampos() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");

        logger.info("OPA - Iniciando validacion campos Adjudicacion...");
        /*Validar Fecha y Hora*/
        if (!fechaAdjudicacion.equals("")) {
            fechanoApropiada = "Adjudicación no permitida: El periodo de ingreso de aceptaciones se encuentra abierto.";
        } else {
            fechanoApropiada = "";
        }
        if (!horaAdjudicacion.equals("")) {
            horanoApropiada = "Adjudicación no permitida: horario de ingreso de aceptaciones se encuentra abierto.";
        } else {
            horanoApropiada = "";
        }

        /**
         * ***VALIDAR CAMPOS EN BLANCO**
         */
        /*Mínimo de acciones objeto oferta*/
        if (txt_accionesofert.getValue().equals("0")) {
            txta_informacion.setValue("Error en adjudicación: parametrización incompleta.\n"
                    + "POR FAVOR DIRÍJASE AL MÓDULO DE PARAMETRIZACIÓN Y COMPLETE LA INFORMACIÓN, UNA VEZ REALIZADO EL CAMBIO REALICE DE NUEVO LA ADJUDICACIÓN.\n"
                    + "El campo Mínimo de Acciones objeto oferta debe ser diligenciado.\n" + fechanoApropiada + "\n" + horanoApropiada + "\n");
            return;
        }

        /*Máximo de Acciones objeto oferta*/
        if (txt_maxaccionesOfert.getValue().equals("0")) {
            txta_informacion.setValue("Error en adjudicación: parametrización incompleta.\n"
                    + "POR FAVOR DIRÍJASE AL MÓDULO DE PARAMETRIZACIÓN Y COMPLETE LA INFORMACIÓN, UNA VEZ REALIZADO EL CAMBIO REALICE DE NUEVO LA ADJUDICACIÓN.\n"
                    + "El campo Máximo de Acciones objeto oferta debe ser diligenciado.\n" + fechanoApropiada + "\n" + horanoApropiada + "\n");
            return;
        }

        /*Clase de Acciones*/
        if (txt_claseAcciones.getValue().equals("")) {
            txta_informacion.setValue("Error en adjudicación: parametrización incompleta.\n"
                    + "POR FAVOR DIRÍJASE AL MÓDULO DE PARAMETRIZACIÓN Y COMPLETE LA INFORMACIÓN, UNA VEZ REALIZADO EL CAMBIO REALICE DE NUEVO LA ADJUDICACIÓN.\n"
                    + "El campo Clase de Acciones debe ser diligenciado.\n" + fechanoApropiada + "\n" + horanoApropiada + "\n");
            return;
        }

        /*nemotecnico*/
        if (txt_nemotecnico.getValue().equals("")) {
            txta_informacion.setValue("Error en adjudicación: parametrización incompleta.\n"
                    + "POR FAVOR DIRÍJASE AL MÓDULO DE PARAMETRIZACIÓN Y COMPLETE LA INFORMACIÓN, UNA VEZ REALIZADO EL CAMBIO REALICE DE NUEVO LA ADJUDICACIÓN.\n"
                    + "El campo Nemotécnico debe ser diligenciado.\n" + fechanoApropiada + "\n" + horanoApropiada + "\n");
            return;
        }

        /*Precio*/
        if (txt_precio.getValue().equals("")) {
            txta_informacion.setValue("Error en adjudicación: parametrización incompleta.\n"
                    + "POR FAVOR DIRÍJASE AL MÓDULO DE PARAMETRIZACIÓN Y COMPLETE LA INFORMACIÓN, UNA VEZ REALIZADO EL CAMBIO REALICE DE NUEVO LA ADJUDICACIÓN.\n"
                    + "El campo Precio debe ser diligenciado.\n" + fechanoApropiada + "\n" + horanoApropiada + "\n");
            return;
        }

        /*Nombre/Razón Social*/
        if (txt_nomrazonsocial.getValue().equals("")) {
            txta_informacion.setValue("Error en adjudicación: parametrización incompleta.\n"
                    + "POR FAVOR DIRÍJASE AL MÓDULO DE PARAMETRIZACIÓN Y COMPLETE LA INFORMACIÓN, UNA VEZ REALIZADO EL CAMBIO REALICE DE NUEVO LA ADJUDICACIÓN.\n"
                    + "El campo Nombre/Razón Social debe ser diligenciado.\n" + fechanoApropiada + "\n" + horanoApropiada + "\n");
            return;
        }

        /*Tipo de documento*/
        if (txt_tipdocumento.getValue().equals("")) {
            txta_informacion.setValue("Error en adjudicación: parametrización incompleta.\n"
                    + "POR FAVOR DIRÍJASE AL MÓDULO DE PARAMETRIZACIÓN Y COMPLETE LA INFORMACIÓN, UNA VEZ REALIZADO EL CAMBIO REALICE DE NUEVO LA ADJUDICACIÓN.\n"
                    + "El campo Tipo de documento debe ser diligenciado.\n" + fechanoApropiada + "\n" + horanoApropiada + "\n");
            return;
        }

        /*Número de documento*/
        if (txt_numdocumento.getValue().equals("")) {
            txta_informacion.setValue("Error en adjudicación: parametrización incompleta.\n"
                    + "POR FAVOR DIRÍJASE AL MÓDULO DE PARAMETRIZACIÓN Y COMPLETE LA INFORMACIÓN, UNA VEZ REALIZADO EL CAMBIO REALICE DE NUEVO LA ADJUDICACIÓN.\n"
                    + "El campo Número de documento debe ser diligenciado.\n" + fechanoApropiada + "\n" + horanoApropiada + "\n");
            return;
        }

        /*Dígito de verificación*/
        if (txt_digverificacion.getValue().equals("") && txt_tipdocumento.getValue().equalsIgnoreCase("NIT")) {
            txta_informacion.setValue("Error en adjudicación: parametrización incompleta.\n"
                    + "POR FAVOR DIRÍJASE AL MÓDULO DE PARAMETRIZACIÓN Y COMPLETE LA INFORMACIÓN, UNA VEZ REALIZADO EL CAMBIO REALICE DE NUEVO LA ADJUDICACIÓN.\n"
                    + "El campo Dígito de verificación debe ser diligenciado.\n" + fechanoApropiada + "\n" + horanoApropiada + "\n");
            return;
        }
        /*Cuenta Inversionista*/
        if (txt_cuentaInversionista.getValue().equals("")) {
            txta_informacion.setValue("Error en adjudicación: parametrización incompleta.\n"
                    + "POR FAVOR DIRÍJASE AL MÓDULO DE PARAMETRIZACIÓN Y COMPLETE LA INFORMACIÓN, UNA VEZ REALIZADO EL CAMBIO REALICE DE NUEVO LA ADJUDICACIÓN.\n"
                    + "El campo Cuenta Inversionista debe ser diligenciado.\n" + fechanoApropiada + "\n" + horanoApropiada + "\n");
            return;
        }

        /*Nombre y código de la SCB*/
        if (nomCodSCB.equals("")) {
            txta_informacion.setValue("Error en adjudicación: parametrización incompleta.\n"
                    + "POR FAVOR DIRÍJASE AL MÓDULO DE PARAMETRIZACIÓN Y COMPLETE LA INFORMACIÓN, UNA VEZ REALIZADO EL CAMBIO REALICE DE NUEVO LA ADJUDICACIÓN.\n"
                    + "El campo Nombre y código de la SCB debe ser diligenciado.\n" + fechanoApropiada + "\n" + horanoApropiada + "\n");
            return;
        }

    }

    public class Worker extends Thread {

        @Override
        public void run() {
            PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
            UI.getCurrent().setPollInterval(500);
            montotal = new BigDecimal("0.0");
            totalaceptacion = new BigInteger("0");
            sumPrecioAdju = new BigDecimal("0.0");
            maxAccionesOfert = new BigDecimal("0.0");
            minAccionesOfert = new BigDecimal("0.0");
            cantAccionesSinTN = new BigInteger("0");
            totalAcepta = new BigDecimal("0.0");
            accionpendiente = new BigInteger("0");
            resta = new BigInteger("0");
            accionfaltante = new BigInteger("0");
            adicionarfaltante = new BigInteger("0");
            monto = new BigDecimal("0.0");
            totalaceptacioness = new BigInteger("0");
            totalAdj = new BigDecimal("0.0");
            totalprecio = new BigDecimal("0.0");
            montAdj = new BigDecimal("0.0");
            totalaccionesSobrantes = new BigInteger("0");
            uno = new BigInteger("1");
            cantotal = new BigDecimal("0.0");
            totalsob = new BigDecimal("0.0");
            String InsertarAdjudicacionDesierta = "";
            String InsertarFormaPago = "";
            String UpdateFormaPago = "";

            try {
                parametrizacion.deleteAccionesAdj();
                //Aplica solo para OPI starts
                if (tipoOfertaPublica.equals("OPI")) {
                    parametrizacion.deleteFormapago();
                }
                //aplica solo para OPI ends
                canAccionesSinTodoNada = (parametrizacion.canAccionesSinTodoNada());

                /*Validar si el sistema tiene aceptaciones ingresadas*/
//                if (canTotalAcciones != 0.0) {
                /*Calculando el Total de las Acciones Sin todo o nada*/
 /*Total de las aceptaciones*/
                totalaceptacioness = new BigInteger(totalAceptaciones);
                cantAccionesSinTN = new BigInteger(canAccionesSinTodoNada);
                maxAccionesOfert = new BigDecimal(MaxAccionesObjOferta);
                minAccionesOfert = new BigDecimal(MinAccionesObjOferta);

                cantotal = new BigDecimal(canTotalAcpetaciones);
                if (cantotal.compareTo(minAccionesOfert) < 0) {

                    List<List<String>> listAceptacionesDesiertas;
                    listAceptacionesDesiertas = facade.ListarDemandas();

                    for (i = 0; i < listAceptacionesDesiertas.get(0).size(); i++) {
                        String idAceptacion = "";
                        String estado = "Desierta";
                        String tipomod = "Ingreso Adjudicaión - Inserción";

                        BigDecimal accionesadj = new BigDecimal(0);
                        BigDecimal montoAdjudicado = new BigDecimal(0);
                        BigDecimal precioparametro = new BigDecimal(0);

                        idAceptacion = listAceptacionesDesiertas.get(0).get(i);

                        try {
                            current = listAceptacionesDesiertas.get(0).size();
                        } catch (Exception ex) {
                            current = 0;
                        }
                        synchronized (UI.getCurrent()) {
                            processed("Procesando Adjudicación: ");
                        }

                        InsertarAdjudicacionDesierta = (parametrizacion.insertAceptacionesDesiertas(idAceptacion, accionesadj, precioparametro, montoAdjudicado, estado, nomUsuario, tipomod));

                        if (tipoOfertaPublica.equals("OPI")) {
                            InsertarFormaPago = (parametrizacion.insertFormaPago(idAceptacion, accionesadj, precioParametro, montAdj, estado, nomUsuario, tipomod));
                        }

                    }
                    if (!InsertarAdjudicacionDesierta.equals("Error")) {
                        txta_informacion.setValue("Resultado de la adjudicación: Desierta.\n");
                    } else {
                        Notification.show("Hubo un Error Al Momento de insertar la Adjudicación Desierta", Notification.Type.ERROR_MESSAGE);
                    }
                    try {
                        GenerarArchivoReporteAdjudicacion generarExcel = new GenerarArchivoReporteAdjudicacion();
                        current = 100;
                        i = 75;
                        synchronized (UI.getCurrent()) {
                            processed("Procesando Archivo de Adjudicación.. ");
                        }

                        generarExcel.CrearArchivoExcel();
                        current = 100;
                        i = 100;
                        synchronized (UI.getCurrent()) {
                            processed("Procesando Archivo de Adjudicación.. ");
                        }
                        porcentaje.setValue("Proceso de Adjudicación terminado exitosamente. Revisar reportes.");
                    } catch (Exception ex) {
                        logger.error("Error generando archivo Excel", ex);
                    }

//                                } else {
//                                    txta_informacion.setValue("Se cancela la adjudicación por solicitud del usuario, por favor modifique el mínimo de acciones objeto de la oferta.\n");
//                                }
//                            }
//                        });
                } /*Validar que la cantidad total de acciones aceptadas es mayor o igual al valor minimo de acciones bajo la oferta y */ /* la cantidad total de acciones aceptadas es menor al maximo de acciones objeto oferta*/ else if (cantotal.compareTo(minAccionesOfert) >= 0 && cantotal.compareTo(maxAccionesOfert) <= 0) {

                    List<List<String>> listAceptaciones;
                    listAceptaciones = facade.ListarDemandas();
                    for (i = 0; i < listAceptaciones.get(0).size(); i++) {

                        String numAcciones = listAceptaciones.get(9).get(i);

                        /*CANTIDAD ADJUDICADA*/
                        BigDecimal accionesAdjudicada = new BigDecimal(numAcciones);

                        /*MONTO*/
                        logger.debug("Monto = " + accionesAdjudicada + " * " + precioParametro);
                        montAdj = accionesAdjudicada.multiply(precioParametro);
                        logger.debug("Monto = " + montAdj);

                        String idAceptacion = "";
                        String estado = "Adjudicado";
                        String tipomod = "Ingreso Adjudicaión - Inserción";

                        montotal = montotal.add(montAdj);

                        totalAdj = totalAdj.add(accionesAdjudicada);

                        idAceptacion = listAceptaciones.get(0).get(i);

                        try {
                            current = listAceptaciones.get(0).size();
                        } catch (Exception ex) {
                            current = 0;
                        }
                        synchronized (UI.getCurrent()) {
                            processed("Procesando Adjudicación: ");
                        }


                        InsertarAdjudicacionDesierta = (parametrizacion.insertAceptacionesDesiertas(idAceptacion, accionesAdjudicada, precioParametro, montAdj, estado, nomUsuario, tipomod));
                        if (tipoOfertaPublica.equals("OPI")) {
                            InsertarFormaPago = (parametrizacion.insertFormaPago(idAceptacion, accionesAdjudicada, precioParametro, montAdj, estado, nomUsuario, tipomod));
                        }
                    }

                    if (!InsertarAdjudicacionDesierta.equals("Error")) {
                        txta_informacion.setValue("Resultado de la adjudicación: \n"
                                + "Cantidad de aceptaciones participantes: " + (form.format(totalaceptacioness)) + " \n"
                                + "Cantidad de acciones adjudicadas:" + (form.format(totalAdj)) + "\n"
                                + "Monto total adjudicado:" + (form1.format(montotal)) + "\n");

                    } else {
                        Notification.show("Hubo un Error Al Momento De Modificar de insertar la Adjudicación Desierta", Notification.Type.ERROR_MESSAGE);
                    }

                    //Aplica únicamente para OPI start
                    if (tipoOfertaPublica.equals("OPI")) {
                        try {
                            //CONSOLIDACION
                            logger.debug("OPI - " + "CONSOLIDACION_1");

                            List<List<String>> consolidado;
                            consolidado = interfaz.Consolidacion();
                            
                            for (i = 0; i < consolidado.get(0).size(); i++) {

                                String numAccCons = consolidado.get(0).get(i);
                                String ctaInv = consolidado.get(1).get(i);
                                String porcentajeEfecIniCconsolidado = consolidado.get(2).get(i);
                                long NumAccCons = Long.parseLong(numAccCons);//cambio a Long de Integer
                                double PorcentajeEfecIniCconsolidado = Double.parseDouble(porcentajeEfecIniCconsolidado);

                                List<List<String>> listaceptaciones;// Lista de la tabla de Creación de aceptaciones
                                listaceptaciones = facade.ListarDemandasAdjudicacionconsolidado(ctaInv);

                                for (j = 0; j < listaceptaciones.get(0).size(); j++) {
                                    String porcentajepagoEfectivo = listaceptaciones.get(18).get(j);
                                    String idAceptaAdju = listaceptaciones.get(0).get(j);
                                    String montodjudicado = listaceptaciones.get(24).get(j);
                                    BigDecimal Montodjudicado = new BigDecimal(montodjudicado);
                                    Double num2 = 0.0;
                                    try {

                                        Number valor1 = Double.parseDouble(porcentajepagoEfectivo);
                                        num2 = valor1.doubleValue();

                                    } catch (Exception ex) {
                                        num2 = 0.0;
                                    }

                                    BigDecimal porcentajepagoEfectivoAsig = new BigDecimal(num2);
                                    BigDecimal porcentajepagoEfectivoAsig2 = new BigDecimal(PorcentajeefectivopagoPara);
                                    BigDecimal precionaccionespago = new BigDecimal(Precionaccionespago);

                                    /*si  numero de acciones consolidadas, No supera Umbral 
                    //                                                              se respeta porcentaje ingresado en  la aceptación  
                    //                                                           */
                                    if (NumAccCons <= Umbral) {

                                        UpdateFormaPago = (parametrizacion.updateFormapago(idAceptaAdju, num2, Montodjudicado.multiply(porcentajepagoEfectivoAsig), Montodjudicado, precionaccionespago));
                                    } else if (PorcentajeEfecIniCconsolidado <= Porcentajeefectivopago) {
                                        UpdateFormaPago = (parametrizacion.updateFormapago(idAceptaAdju, num2, Montodjudicado.multiply(porcentajepagoEfectivoAsig), Montodjudicado, precionaccionespago));
                                    } else {

                                        UpdateFormaPago = (parametrizacion.updateFormapago(idAceptaAdju, PorcentajeefectivopagoPara, Montodjudicado.multiply(porcentajepagoEfectivoAsig2), Montodjudicado, precionaccionespago));

                                    }
                                }
                            }
                        } catch (Exception ex) {
                            logger.error("OPI - " + "Error generando consolidación forma pago", ex);
                        }

                    }

                    //OPI ends
                    try {
                        synchronized (UI.getCurrent()) {
                            processed("Procesando Archivo IDR.. ");
                        }
                        current = 100;
                        i = 0;
                        synchronized (UI.getCurrent()) {
                            processed("Procesando Archivo IDR.. ");
                        }

                        GenerarArchivoInterfazBackOffice generar = new GenerarArchivoInterfazBackOffice();
                        current = 100;
                        i = 25;
                        synchronized (UI.getCurrent()) {
                            processed("Procesando Archivo IDR.. ");
                        }

                        generar.CrearArchivoIDR();
                        current = 100;
                        i = 50;
                        synchronized (UI.getCurrent()) {
                            processed("Procesando Archivo IDR.. ");
                        }

                    } catch (Exception ex) {
                        logger.error("Error generando archivo IDR", ex);

                    }
                    try {
                        GenerarArchivoReporteAdjudicacion generarExcel = new GenerarArchivoReporteAdjudicacion();
                        current = 100;
                        i = 75;
                        synchronized (UI.getCurrent()) {
                            processed("Procesando Archivo de Adjudicación.. ");
                        }

                        generarExcel.CrearArchivoExcel();
                        current = 100;
                        i = 100;
                        synchronized (UI.getCurrent()) {
                            processed("Procesando Archivo de Adjudicación.. ");
                        }
                        porcentaje.setValue("Proceso de Adjudicación terminado exitosamente. Revisar reportes.");
                    } catch (Exception ex) {
                        logger.error("Error generando archivo Excel", ex);
                    }

//                                } else {
//                                    txta_informacion.setValue("Adjudicación cancelada.\n");
//                                }
//                            }
//                        });
                    //Aplica para OPI starts:
                    if (tipoOfertaPublica.equals("OPI")) {
                        //INTERFAZ20
                        try {
                            synchronized (UI.getCurrent()) {
                                processed("Procesando Archivo I20.. ");
                            }
                            current = 100;
                            i = 50;
                            synchronized (UI.getCurrent()) {
                                processed("Procesando Archivo I20.. ");
                            }

                            GenerarArchivoInterfaz20 generarI = new GenerarArchivoInterfaz20();
                            current = 100;
                            i = 60;
                            synchronized (UI.getCurrent()) {
                                processed("Procesando Archivo I20.. ");
                            }

                            generarI.CrearArchivoI20();
                            current = 100;
                            i = 80;
                            synchronized (UI.getCurrent()) {
                                processed("Procesando Archivo I20.. ");
                            }
                            current = 100;
                            i = 100;
                            synchronized (UI.getCurrent()) {
                                processed("Procesando Archivo de I20.. ");
                            }
                            porcentaje.setValue("Proceso de Adjudicacion terminado exitosamente. Revisar reportes.");

                        } catch (Exception ex) {
                            logger.error("OPI - " + "Error generando archivo I20", ex);

                        }
                    }
                    //Aplica para OPI ends

                } else /**
                 * Validar si la cantidad total de acciones aceptadas es menor
                 * al Minimo de acciones objeto oferta
                 */
                {
                    if (cantotal.compareTo(maxAccionesOfert) > 0) {

                        if (cantAccionesSinTN.compareTo(maxAccionesOfert.toBigInteger()) > 0) {
                            /**
                             * Calculo del "factor de prorrateo" por cada
                             * aceptación
                             */
                            /**
                             * Factor de Prorrateo*
                             */
                            BigDecimal cantAccionesSiTN = new BigDecimal(cantAccionesSinTN);
                            BigDecimal resulProrrateo = maxAccionesOfert.divide(cantAccionesSiTN, 12, BigDecimal.ROUND_HALF_UP);

                            List<List<String>> listAceptacionesDesiertas;
                            listAceptacionesDesiertas = facade.ListarDemandasAdjudicacion();

                            for (i = 0; i < listAceptacionesDesiertas.get(0).size(); i++) {

                                String numAcciones = listAceptacionesDesiertas.get(9).get(i);
                                BigInteger ValorAceptacion = new BigInteger(numAcciones);

                                /*Cantidad Adjudicada*/
                                /**
                                 * ******************
                                 */
                                BigDecimal cantadjudicada = resulProrrateo.multiply(new BigDecimal(ValorAceptacion));

                                BigDecimal x = cantadjudicada.setScale(0, BigDecimal.ROUND_HALF_UP);

                                totalaceptacion = totalaceptacion.add(x.toBigInteger());

                                /*MONTO*/
                                BigDecimal montoadjudicado = x.multiply(precioParametro);

                                /*SUMA DEL PRECIO ADJUDICAD CON PRORRATEO*/
                                sumPrecioAdju = sumPrecioAdju.add(precioParametro);

                                /*SUMA DEL MONTO ADJUDICADO CON PRORRATEO*/
                                //montotal=montotal.add(x); Lsierra 2016-07-08 Mantis 2677
                                montotal = montotal.add(montoadjudicado);

                                String idAceptacion = "";
                                String estado = "Ingresado";
                                String tipomod = "Ingreso Adjudicaión - Inserción";

                                try {
                                    current = listAceptacionesDesiertas.get(0).size();
                                } catch (Exception ex) {
                                    current = 0;
                                }
                                synchronized (UI.getCurrent()) {
                                    processed("Procesando Adjudicación: ");
                                }

                                idAceptacion = listAceptacionesDesiertas.get(0).get(i);
                                InsertarAdjudicacionDesierta = (parametrizacion.insertAceptacionesDesiertas(idAceptacion, x, precioParametro, montoadjudicado, estado, nomUsuario, tipomod));
                                InsertarFormaPago = (parametrizacion.insertFormaPago(idAceptacion, x, precioParametro, montAdj, estado, nomUsuario, tipomod));

                                if (!InsertarAdjudicacionDesierta.equals("Error")) {
                                } else {
                                    Notification.show("Hubo un Error Al Momento de insertar la Adjudicación Desierta por prorrateo", Notification.Type.ERROR_MESSAGE);

                                }
                            }

                            /*Acción pendiente - COLAS*/
 /*Si el valor adjudicado es menor al monto se suma las acciones sobrantes al ofertante con menor numero de acciones*/
                            if (totalaceptacion.compareTo(maxAccionesOfert.toBigInteger()) < 0) {
                                /*FALTANTES*/
                                int maxAccionOf = maxAccionesOfert.toBigInteger().intValue();
                                int totalace = totalaceptacion.intValue();
                                current = maxAccionOf - totalace;
                                i = 0;
                                while (totalaceptacion.compareTo(maxAccionesOfert.toBigInteger()) < 0) {
                                    List<List<String>> lisAccionMenCant;
                                    lisAccionMenCant = (parametrizacion.ListAccionesMinAcciones());

                                    for (int h = 0; h < lisAccionMenCant.get(0).size(); h++) {

                                        numAccionActu = lisAccionMenCant.get(1).get(h);
                                        idAceptaci = lisAccionMenCant.get(2).get(h);

                                        BigDecimal numAccion = (parametrizacion.numAccionesAceptacion(idAceptaci));
                                        BigInteger numeroAccion = new BigInteger(numAccionActu);
                                        BigDecimal num = new BigDecimal(numeroAccion);

                                        accionpendiente = maxAccionesOfert.toBigInteger().subtract(totalaceptacion);

                                        accionfaltante = new BigInteger(numAccionActu);

                                        /*SUMA*/
                                        adicionarfaltante = accionfaltante.add(accionpendiente);
                                        BigDecimal num1 = new BigDecimal(adicionarfaltante);
                                        i += numAccion.intValue() / 100;
                                        synchronized (UI.getCurrent()) {
                                            processed("Calculando Adjudicación... ");
                                        }

                                        if (accionpendiente.compareTo(numAccion.toBigInteger().subtract(accionfaltante)) > 0) {
                                            //ActualizarAdjudicacion = (parametrizacion.updateAcciones(idAceptaci, numAccion.toBigInteger(), num.multiply(precioParametro))); Lsierra2016-07-08 Mantis 2703
                                            ActualizarAdjudicacion = (parametrizacion.updateAcciones(idAceptaci, numAccion.toBigInteger(), numAccion.multiply(precioParametro)));
                                            BigInteger suma = numAccion.toBigInteger().subtract(numeroAccion);
                                            totalaceptacion = totalaceptacion.add(suma);

                                        } else {
                                            ActualizarAdjudicacion = (parametrizacion.updateAcciones(idAceptaci, adicionarfaltante, num1.multiply(precioParametro)));
                                            totalaceptacion = totalaceptacion.add(accionpendiente);
                                            BigDecimal totalaceptac = new BigDecimal(totalaceptacion);
                                            monto = totalaceptac.multiply(precioParametro);
                                            break;
                                        }
                                    }
                                }
                                txta_informacion.setValue("Resultado de la adjudicación: \n"
                                        + "Cantidad de aceptaciones participantes: " + (form.format(totalaceptacioness)) + " \n"
                                        + "Cantidad de acciones adjudicadas:" + (form.format(totalaceptacion)) + "\n"
                                        + "Monto total adjudicado:" + (form1.format(monto)) + "\n");

                            } else /**
                             * SOBRANTES
                             */
                            {
                                if (totalaceptacion.compareTo(maxAccionesOfert.toBigInteger()) > 0) {
                                    int maxAccionOf = maxAccionesOfert.toBigInteger().intValue();
                                    int totalace = totalaceptacion.intValue();
                                    current = totalace - maxAccionOf;
                                    //current= maxAccionesOfert.toBigInteger().subtract(totalaceptacion).intValue();
                                    i = 0;
                                    while (totalaceptacion.compareTo(maxAccionesOfert.toBigInteger()) > 0) {
                                        List<List<String>> ListAccionesMasCant;
                                        ListAccionesMasCant = (parametrizacion.ListAccionesMasAcciones());

                                        for (int h = 0; h < ListAccionesMasCant.get(0).size(); h++) {

                                            numAccionActu = ListAccionesMasCant.get(1).get(h);
                                            idAceptaci = ListAccionesMasCant.get(2).get(h);

                                            accionfaltante = new BigInteger(numAccionActu);

                                            /*RESTA*/
                                            totalaccionesSobrantes = accionfaltante.subtract(uno);

                                            totalsob = new BigDecimal(totalaccionesSobrantes);
                                            i += uno.intValue() / 100;
                                            synchronized (UI.getCurrent()) {
                                                processed("Calculando Adjudicación... ");
                                            }

                                            ActualizarAdjudicacion = (parametrizacion.updateAcciones(idAceptaci, totalaccionesSobrantes, totalsob.multiply(precioParametro)));
                                            totalaceptacion = totalaceptacion.subtract(uno);

                                            // totalaceptacion=totalaceptacion.add(accionpendiente);
                                            BigDecimal totalaceptac = new BigDecimal(totalaceptacion);
                                            monto = totalaceptac.multiply(precioParametro);
                                            break;
                                        }
                                    }
                                    txta_informacion.setValue("Resultado de la adjudicación: \n"
                                            + "Cantidad de aceptaciones participantes: " + (form.format(totalaceptacioness)) + " \n"
                                            + "Cantidad de acciones adjudicadas:" + (form.format(totalaceptacion)) + "\n"
                                            + "Monto total adjudicado:" + (form1.format(monto)) + "\n");
                                } else {
                                    txta_informacion.setValue("Resultado de la adjudicación: \n"
                                            + "Cantidad de aceptaciones participantes: " + (form.format(totalaceptacioness)) + " \n"
                                            + "Cantidad de acciones adjudicadas:" + (form.format(totalaceptacion)) + "\n"
                                            + "Monto total adjudicado:" + (form1.format(montotal)) + "\n");
                                }
                            }

                            //Aplica solo para OPI starts
                            if (tipoOfertaPublica.equals("OPI")) {
                                try {
                                    //CONSOLIDACION
                                    logger.debug("OPI - " + "CONSOLIDACION_2");
                                    List<List<String>> consolidado;
                                    consolidado = interfaz.Consolidacion();

                                    for (i = 0; i < consolidado.get(0).size(); i++) {

                                        String numAccCons = consolidado.get(0).get(i);
                                        String ctaInv = consolidado.get(1).get(i);
                                        String porcentajeEfecIniCconsolidado = consolidado.get(2).get(i);
                                        long NumAccCons = Long.parseLong(numAccCons);//cambio de Integer a Long 
                                        double PorcentajeEfecIniCconsolidado = Double.parseDouble(porcentajeEfecIniCconsolidado);

                                        List<List<String>> listaceptaciones;// Lista de la tabla de Creación de aceptaciones
                                        listaceptaciones = facade.ListarDemandasAdjudicacionconsolidado(ctaInv);

                                        for (j = 0; j < listaceptaciones.get(0).size(); j++) {
                                            String porcentajepagoEfectivo = listaceptaciones.get(18).get(j);
                                            String idAceptaAdju = listaceptaciones.get(0).get(j);
                                            String montodjudicado = listaceptaciones.get(24).get(j);
                                            BigDecimal Montodjudicado = new BigDecimal(montodjudicado);
                                            Double num2 = 0.0;
                                            try {

                                                Number valor1 = Double.parseDouble(porcentajepagoEfectivo);
                                                num2 = valor1.doubleValue();

                                            } catch (Exception ex) {
                                                num2 = 0.0;
                                            }

                                            BigDecimal porcentajepagoEfectivoAsig = new BigDecimal(num2);
                                            BigDecimal porcentajepagoEfectivoAsig2 = new BigDecimal(PorcentajeefectivopagoPara);
                                            BigDecimal precionaccionespago = new BigDecimal(Precionaccionespago);

                                            /*si  numero de acciones consolidadas, No supera Umbral 
                //                                                              se respeta porcentaje ingresado en  la aceptación  
                //                                                           */
                                            if (NumAccCons <= Umbral) {

                                                UpdateFormaPago = (parametrizacion.updateFormapago(idAceptaAdju, num2, Montodjudicado.multiply(porcentajepagoEfectivoAsig), Montodjudicado, precionaccionespago));
                                            } else if (PorcentajeEfecIniCconsolidado <= Porcentajeefectivopago) {
                                                UpdateFormaPago = (parametrizacion.updateFormapago(idAceptaAdju, num2, Montodjudicado.multiply(porcentajepagoEfectivoAsig), Montodjudicado, precionaccionespago));
                                            } else {

                                                UpdateFormaPago = (parametrizacion.updateFormapago(idAceptaAdju, PorcentajeefectivopagoPara, Montodjudicado.multiply(porcentajepagoEfectivoAsig2), Montodjudicado, precionaccionespago));

                                            }
                                        }
                                    }
                                } catch (Exception ex) {
                                    logger.error("OPI - " + "Error generando consolidación forma pago", ex);
                                }
                            }

                            //Aplica solo para OPI ends
                            try {
                                synchronized (UI.getCurrent()) {
                                    processed("Procesando Archivo IDR.. ");
                                }
                                current = 100;
                                i = 0;
                                synchronized (UI.getCurrent()) {
                                    processed("Procesando Archivo IDR.. ");
                                }

                                GenerarArchivoInterfazBackOffice generar = new GenerarArchivoInterfazBackOffice();
                                current = 100;
                                i = 25;
                                synchronized (UI.getCurrent()) {
                                    processed("Procesando Archivo IDR.. ");
                                }

                                generar.CrearArchivoIDR();
                                current = 100;
                                i = 50;
                                synchronized (UI.getCurrent()) {
                                    processed("Procesando Archivo IDR.. ");
                                }

                            } catch (Exception ex) {
                                logger.error("Error generando archivo IDR", ex);

                            }
                            try {
                                GenerarArchivoReporteAdjudicacion generarExcel = new GenerarArchivoReporteAdjudicacion();
                                current = 100;
                                i = 75;
                                synchronized (UI.getCurrent()) {
                                    processed("Procesando Archivo de Adjudicación.. ");
                                }

                                generarExcel.CrearArchivoExcel();
                                current = 100;
                                i = 100;
                                synchronized (UI.getCurrent()) {
                                    processed("Procesando Archivo de Adjudicación.. ");
                                }
                                porcentaje.setValue("Proceso de Adjudicación terminado exitosamente. Revisar reportes.");
                            } catch (Exception ex) {
                                logger.error("Error generando archivo Excel", ex);
                            }

                            //Aplica solo para OPI - starts
                            if (tipoOfertaPublica.equals("OPI")) {
                                //INTERFAZ20
                                try {
                                    synchronized (UI.getCurrent()) {
                                        processed("Procesando Archivo I20.. ");
                                    }
                                    current = 100;
                                    i = 50;
                                    synchronized (UI.getCurrent()) {
                                        processed("Procesando Archivo I20.. ");
                                    }

                                    GenerarArchivoInterfaz20 generarI = new GenerarArchivoInterfaz20();
                                    current = 100;
                                    i = 60;
                                    synchronized (UI.getCurrent()) {
                                        processed("Procesando Archivo I20.. ");
                                    }

                                    generarI.CrearArchivoI20();
                                    current = 100;
                                    i = 80;
                                    synchronized (UI.getCurrent()) {
                                        processed("Procesando Archivo I20.. ");
                                    }
                                    current = 100;
                                    i = 100;
                                    synchronized (UI.getCurrent()) {
                                        processed("Procesando Archivo de I20.. ");
                                    }
                                    porcentaje.setValue("Proceso de Adjudicacion terminado exitosamente. Revisar reportes.");

                                } catch (Exception ex) {
                                    logger.error("OPI - " + "Error generando archivo I20", ex);

                                }
                            }
                            
                        } else if (cantAccionesSinTN.compareTo(maxAccionesOfert.toBigInteger()) <= 0 && 
                                cantAccionesSinTN.compareTo(minAccionesOfert.toBigInteger()) >= 0) {
                            /*Si el "total de acciones sin todo o nada" es menor al "Máximo de acciones bajo oferta" el factor de prorrateo será igual a uno (1).*/
                            /**
                             * Si el "total de acciones sin todo o nada" es
                             * menor al "Máximo de acciones bajo oferta" el
                             * factor de prorrateo será igual a uno (1).
                             */
                            /**
                             * Factor de Prorrateo*
                             */

                            BigDecimal resultprorrateo = new BigDecimal(1.0);

                            List<List<String>> listAceptacionesDesiertas;
                            
                            listAceptacionesDesiertas = facade.ListarDemandasAdjudicacion();

                            for (i = 0; i < listAceptacionesDesiertas.get(0).size(); i++) {

                                String numAcciones = listAceptacionesDesiertas.get(9).get(i);

                                BigDecimal accionesadj = new BigDecimal(numAcciones);

                                BigDecimal cantidadAdjudicada = resultprorrateo.multiply(accionesadj);

                                /*Cantidad Adjudicada en String*/
                                BigDecimal CantidadAdj = cantidadAdjudicada.setScale(0, RoundingMode.HALF_UP);;

                                /*MONTO*/
                                //montoAdjudicado = (CantidadAdj * precioPara);
                                montAdj = CantidadAdj.multiply(precioParametro);

                                /*SUMA DE LA CANTIDAD ADJUDICAD CON PRORRATEO*/
                                totalAdj = totalAdj.add(CantidadAdj);

                                /*SUMA DEL MONTO ADJUDICADO*/
                                monto = monto.add(montAdj);

                                /*SUMA DEL PRECIO DE LA ADJUDICACION*/
                                totalprecio = totalprecio.add(precioParametro);

                                String idAceptacion = "";
                                String estado = "Adjudicado";
                                String tipomod = "Ingreso Adjudicaión - Inserción";

                                idAceptacion = listAceptacionesDesiertas.get(0).get(i);

                                idAceptacion = listAceptacionesDesiertas.get(0).get(i);

                                try {
                                    current = listAceptacionesDesiertas.get(0).size();
                                } catch (Exception ex) {
                                    current = 0;
                                }
                                synchronized (UI.getCurrent()) {
                                    processed("Procesando Adjudicación: ");
                                }

                                InsertarAdjudicacionDesierta = (parametrizacion.insertAceptacionesDesiertas(idAceptacion, CantidadAdj, precioParametro, montAdj, estado, nomUsuario, tipomod));
                                //Aplica solo para OPi starts 
                                if (tipoOfertaPublica.equals("OPI")) {
                                    InsertarFormaPago = (parametrizacion.insertFormaPago(idAceptacion, CantidadAdj, precioParametro, montAdj, estado, nomUsuario, tipomod));
                                }
                                //Aplica solo para OPI ends
                            }

                            if (!InsertarAdjudicacionDesierta.equals("Error")) {
                                txta_informacion.setValue("Resultado de la adjudicación: \n"
                                        + "Cantidad de aceptaciones participantes: " + (form.format(totalaceptacioness)) + " \n"
                                        + "Cantidad de acciones adjudicadas:" + (form.format(totalAdj)) + "\n"
                                        + "Monto total adjudicado:" + (form1.format(monto)) + "\n");
                            } else {
                                Notification.show("Hubo un Error Al Momento de insertar la Adjudicación por Prorrateo igual a 1", Notification.Type.ERROR_MESSAGE);

                            }

                            //aplica solo para OPI start 
                            if (tipoOfertaPublica.equals("OPI")) {
                                try {
                                    //CONSOLIDACION
                                    logger.debug("OPI - " + "CONSOLIDACION_3");

                                    List<List<String>> consolidado;
                                    consolidado = interfaz.Consolidacion();

                                    for (i = 0; i < consolidado.get(0).size(); i++) {

                                        String numAccCons = consolidado.get(0).get(i);
                                        String ctaInv = consolidado.get(1).get(i);
                                        String porcentajeEfecIniCconsolidado = consolidado.get(2).get(i);
                                        long NumAccCons = Long.parseLong(numAccCons);//cambio de Integer a Long 
                                        double PorcentajeEfecIniCconsolidado = Double.parseDouble(porcentajeEfecIniCconsolidado);

                                        List<List<String>> listaceptaciones;// Lista de la tabla de Creación de aceptaciones
                                        listaceptaciones = facade.ListarDemandasAdjudicacionconsolidado(ctaInv);

                                        for (j = 0; j < listaceptaciones.get(0).size(); j++) {
                                            String porcentajepagoEfectivo = listaceptaciones.get(18).get(j);
                                            String idAceptaAdju = listaceptaciones.get(0).get(j);
                                            String montodjudicado = listaceptaciones.get(24).get(j);
                                            BigDecimal Montodjudicado = new BigDecimal(montodjudicado);
                                            Double num2 = 0.0;
                                            try {

                                                Number valor1 = Double.parseDouble(porcentajepagoEfectivo);
                                                num2 = valor1.doubleValue();

                                            } catch (Exception ex) {
                                                num2 = num2;
                                                logger.error("OPI - " + GenerarAdjudicacion.class.getName(), ex);
                                            }

                                            BigDecimal porcentajepagoEfectivoAsig = new BigDecimal(num2);
                                            BigDecimal porcentajepagoEfectivoAsig2 = new BigDecimal(PorcentajeefectivopagoPara);
                                            BigDecimal precionaccionespago = new BigDecimal(Precionaccionespago);

                                            /*si  numero de acciones consolidadas, No supera Umbral 
            //                                                              se respeta porcentaje ingresado en  la aceptación  
            //                                                           */
                                            if (NumAccCons <= Umbral) {

                                                UpdateFormaPago = (parametrizacion.updateFormapago(idAceptaAdju, num2, Montodjudicado.multiply(porcentajepagoEfectivoAsig), Montodjudicado, precionaccionespago));
                                            } else if (PorcentajeEfecIniCconsolidado <= Porcentajeefectivopago) {
                                                UpdateFormaPago = (parametrizacion.updateFormapago(idAceptaAdju, num2, Montodjudicado.multiply(porcentajepagoEfectivoAsig), Montodjudicado, precionaccionespago));
                                            } else {

                                                UpdateFormaPago = (parametrizacion.updateFormapago(idAceptaAdju, PorcentajeefectivopagoPara, Montodjudicado.multiply(porcentajepagoEfectivoAsig2), Montodjudicado, precionaccionespago));

                                            }
                                        }
                                    }
                                } catch (Exception ex) {
                                    logger.error("OPI - " + "Error generando consolidación forma pago", ex);
                                }
                            }
                            //Aplica solo para OPI ends

                            try {
                                synchronized (UI.getCurrent()) {
                                    processed("Procesando Archivo IDR.. ");
                                }
                                current = 100;
                                i = 0;
                                synchronized (UI.getCurrent()) {
                                    processed("Procesando Archivo IDR.. ");
                                }

                                GenerarArchivoInterfazBackOffice generar = new GenerarArchivoInterfazBackOffice();
                                current = 100;
                                i = 25;
                                synchronized (UI.getCurrent()) {
                                    processed("Procesando Archivo IDR.. ");
                                }

                                generar.CrearArchivoIDR();
                                current = 100;
                                i = 50;
                                synchronized (UI.getCurrent()) {
                                    processed("Procesando Archivo IDR.. ");
                                }

                            } catch (Exception ex) {
                                logger.error("Error generando archivo IDR", ex);

                            }
                            try {
                                GenerarArchivoReporteAdjudicacion generarExcel = new GenerarArchivoReporteAdjudicacion();
                                current = 100;
                                i = 75;
                                synchronized (UI.getCurrent()) {
                                    processed("Procesando Archivo de Adjudicación.. ");
                                }

                                generarExcel.CrearArchivoExcel();
                                current = 100;
                                i = 100;
                                synchronized (UI.getCurrent()) {
                                    processed("Procesando Archivo de Adjudicación.. ");
                                }
                                porcentaje.setValue("Proceso de Adjudicación terminado exitosamente. Revisar reportes.");
                            } catch (Exception ex) {
                                logger.error("Error generando archivo Excel", ex);
                            }

                            //Aplica solo para OPI starts: 
                            if (tipoOfertaPublica.equals("OPI")) {

                                //INTERFAZ20
                                try {
                                    synchronized (UI.getCurrent()) {
                                        processed("Procesando Archivo I20.. ");
                                    }
                                    current = 100;
                                    i = 50;
                                    synchronized (UI.getCurrent()) {
                                        processed("Procesando Archivo I20.. ");
                                    }

                                    GenerarArchivoInterfaz20 generarI = new GenerarArchivoInterfaz20();
                                    current = 100;
                                    i = 60;
                                    synchronized (UI.getCurrent()) {
                                        processed("Procesando Archivo I20.. ");
                                    }

                                    generarI.CrearArchivoI20();
                                    current = 100;
                                    i = 80;
                                    synchronized (UI.getCurrent()) {
                                        processed("Procesando Archivo I20.. ");
                                    }
                                    current = 100;
                                    i = 100;
                                    synchronized (UI.getCurrent()) {
                                        processed("Procesando Archivo de I20.. ");
                                    }
                                    porcentaje.setValue("Proceso de Adjudicacion terminado exitosamente. Revisar reportes.");

                                } catch (Exception ex) {
                                    logger.error("OPI - " + "Error generando archivo I20", ex);

                                }
                            }
                            //Aplica solo para OPI ends

                        } else {

                            List<List<String>> listAceptacionesDesiertas;
                            listAceptacionesDesiertas = facade.ListarDemandasAdjudicacion();
                            for (i = 0; i < listAceptacionesDesiertas.get(0).size(); i++) {
                                String idAceptacion = "";
                                BigDecimal accionesadj = new BigDecimal(0);
                                BigDecimal montoAdjudicado = new BigDecimal(0);
                                BigDecimal precioparametro = new BigDecimal(0);

                                String estado = "Desierta";
                                String tipomod = "Ingreso Adjudicaión - Inserción";

                                idAceptacion = listAceptacionesDesiertas.get(0).get(i);

                                try {
                                    current = listAceptacionesDesiertas.get(0).size();
                                } catch (Exception ex) {
                                    current = 0;
                                }
                                synchronized (UI.getCurrent()) {
                                    processed("Procesando Adjudicación: ");
                                }

                                InsertarAdjudicacionDesierta = (parametrizacion.insertAceptacionesDesiertas(idAceptacion, accionesadj, precioparametro, montoAdjudicado, estado, nomUsuario, tipomod));
                                //Aplica solo para OPI start
                                if (tipoOfertaPublica.equals("OPI")) {
                                    InsertarFormaPago = (parametrizacion.insertFormaPago(idAceptacion, accionesadj, precioParametro, montAdj, estado, nomUsuario, tipomod));
                                }

                                //Aplica solo para OPI ends
                            }

                            if (!InsertarAdjudicacionDesierta.equals("Error")) {
                                txta_informacion.setValue("Resultado de la adjudicación: Desierta.\n  La cantidad total de acciones de las aceptaciones no todo o nada es menor al mínimo de acciones objeto de la oferta. Por favor revisar mínimo o máximo de acciones bajo oferta");
                            } else {
                                Notification.show("Hubo un Error Al Momento de insertar la Adjudicación Desierta", Notification.Type.ERROR_MESSAGE);
                            }
                            try {
                                GenerarArchivoReporteAdjudicacion generarExcel = new GenerarArchivoReporteAdjudicacion();
                                current = 100;
                                i = 75;
                                synchronized (UI.getCurrent()) {
                                    processed("Procesando Archivo de Adjudicación.. ");
                                }

                                generarExcel.CrearArchivoExcel();
                                current = 100;
                                i = 100;
                                synchronized (UI.getCurrent()) {
                                    processed("Procesando Archivo de Adjudicación.. ");
                                }
                                porcentaje.setValue("Proceso de Adjudicación terminado exitosamente. Revisar reportes.");
                            } catch (Exception ex) {
                                logger.error("Error generando archivo Excel", ex);
                            }

                        }
//                                    } else {
//                                        txta_informacion.setValue("Adjudicación cancelada: el usuario puede modificar el máximo de acciones objeto de oferta en el módulo parametrización.\n");
//                                    }
//                                }
//                            });

                    }
                }

            } catch (Exception e) {

            }

        }

    }

    public void mensajeDialogo() {

        montotal = new BigDecimal("0.0");
        totalaceptacion = new BigInteger("0");
        sumPrecioAdju = new BigDecimal("0.0");
        maxAccionesOfert = new BigDecimal("0.0");
        minAccionesOfert = new BigDecimal("0.0");
        cantAccionesSinTN = new BigInteger("0");
        totalAcepta = new BigDecimal("0.0");
        accionpendiente = new BigInteger("0");
        accionfaltante = new BigInteger("0");
        adicionarfaltante = new BigInteger("0");
        monto = new BigDecimal("0.0");
        totalaceptacioness = new BigInteger("0");
        totalAdj = new BigDecimal("0.0");
        totalprecio = new BigDecimal("0.0");
        montAdj = new BigDecimal("0.0");
        totalaccionesSobrantes = new BigInteger("0");
        uno = new BigInteger("1");
        cantotal = new BigDecimal("0.0");
        totalsob = new BigDecimal("0.0");

        parametrizacion.deleteAccionesAdj();

        //Aplica solo para OPI start!!!
        if (tipoOfertaPublica.equals("OPI")) {
            parametrizacion.deleteFormapago();
        }
        //Aplica solo para OPi ends !!!

        canAccionesSinTodoNada = (parametrizacion.canAccionesSinTodoNada());

        /*Validar si el sistema tiene aceptaciones ingresadas*/
        if (canTotalAcciones != 0.0) {
            /*Calculando el Total de las Acciones Sin todo o nada*/

 /*Total de las aceptaciones*/
            totalaceptacioness = new BigInteger(totalAceptaciones);
            cantAccionesSinTN = new BigInteger(canAccionesSinTodoNada);
            maxAccionesOfert = new BigDecimal(MaxAccionesObjOferta);
            minAccionesOfert = new BigDecimal(MinAccionesObjOferta);
            cantotal = new BigDecimal(canTotalAcpetaciones);

            if (cantotal.compareTo(minAccionesOfert) < 0) {
                ConfirmDialog.show(getUI(), "Confirmación", "¿La cantidad total de acciones aceptadas es menor al mínimo de acciones objeto de la oferta, Desea dejar como desierta la adjudicación?.", "ACEPTAR",
                        "CANCELAR", new ConfirmDialog.Listener() {
                    @Override
                    public void onClose(ConfirmDialog dialog) {
                        if (dialog.isConfirmed()) {
                            respuesta = true;
                            startButton.click();

//                            }
                        } else {
                            txta_informacion.setValue("Adjudicación cancelada. El usuario puede modificar el mínimo de acciones objeto de la oferta en el modulo parametrización.\n");
                            dialog.close();
                        }
                    }

                });

            } else if (cantotal.compareTo(minAccionesOfert) >= 0 && cantotal.compareTo(maxAccionesOfert) <= 0) {

                ConfirmDialog.show(getUI(), "Confirmación", "¿Desea continuar con la adjudicación?", "ACEPTAR",
                        "CANCELAR", new ConfirmDialog.Listener() {
                    @Override
                    public void onClose(ConfirmDialog dialog) {
                        if (dialog.isConfirmed()) {
                            respuesta = true;
                            startButton.click();
//                            synchronized (UI.getCurrent()) {
//                            }
                        } else {
                            txta_informacion.setValue("Adjudicación cancelada.\n");
                            dialog.close();
                        }
                    }

                });

            } else {
                if (cantotal.compareTo(maxAccionesOfert) > 0) {

                    ConfirmDialog.show(getUI(), "Confirmación", "¿La cantidad total de acciones aceptadas es mayor al máximo de acciones objeto de la oferta. La adjudicación se realizará por prorrateo ¿Desea continuar con la adjudicación?.", "ACEPTAR",
                            "CANCELAR", new ConfirmDialog.Listener() {
                        @Override
                        public void onClose(ConfirmDialog dialog) {
                            if (dialog.isConfirmed()) {
                                respuesta = true;
                                startButton.click();
//                            synchronized (UI.getCurrent()) {
//                            }
                            } else {
                                txta_informacion.setValue("Adjudicación cancelada: el usuario puede modificar el máximo de acciones objeto de oferta en el módulo parametrización.\n");
                                dialog.close();
                            }
                        }

                    });

                }
            }

        } else {
            ConfirmDialog cd = ConfirmDialog.getFactory().create("Confirmación", "", "ACEPTAR", "", "");
            cd.setWidth("400px");
            cd.setHeight("160px");
            HorizontalLayout texto = new HorizontalLayout();
            HorizontalLayout buttons = new HorizontalLayout();
            buttons.setStyleName("btnAceptar");
            Label lblmensaje = new Label("No existen Aceptaciones para adjudicar.", ContentMode.HTML);
            texto.addComponent(lblmensaje);
            buttons.addComponent(cd.getOkButton());
            VerticalLayout content = new VerticalLayout(lblmensaje, buttons);
            content.setStyleName("verticalDialog");
            content.setSizeFull();
            content.setSpacing(true);
            cd.setContent(content);
            txta_informacion.setValue("");
            cd.show(UI.getCurrent(), new ConfirmDialog.Listener() {
                @Override
                public void onClose(ConfirmDialog cd) {

                }
            }, true);
        }
    }

    public final void processed(String LabelestadoAdju) {
        try {
            midouble = (Double.valueOf(i) / Double.valueOf(current));
            float b;
            j = (int) (midouble * 100);
            b = (float) j / 100;
            if (b == 1) {
                sample.setValue(b);
                btn_Adjudicar.setEnabled(true);
                porcentaje.setValue(LabelestadoAdju + j + " %");
                UI.getCurrent().setPollInterval(500);

            } else {
                sample.setValue(b);
                porcentaje.setValue(LabelestadoAdju + j + " %");
                layout.setImmediate(true);
            }

        } catch (Exception e) {
            processed(LabelestadoAdju);
        }
    }

}

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
import com.quasar.frameq.data.FqsParametrizacion;
import com.quasar.frameq.data.SCB;
import com.quasar.frameq.data.TipoDocumento;
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
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import javax.swing.text.MaskFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.dialogs.ConfirmDialog;

/**
 *
 * @author Administrador
 */
public class CrearParametros extends GenericContent {

    @SuppressWarnings("FieldNameHidesFieldInSuperclass")
    private static final Logger logger = Logger.getLogger(CrearParametros.class.getName());

    String regexNumeric = "^[0-9]*$";
    String regexNumericPunt = "^[0-9\\.]*$";
    String regexNumericPuntComa = "^[0-9.,]*$";
    String regexNumericComaComision = "^[0-9,]*$";
    String regexNumericPuntComa2 = "^[0-9\\.]+\\,[0-9]{2}$";
    String regexNumericPuntComa4 = "^[0-9\\.]+\\,[0-9]{4}$";
    String regexNumericPuntComa3 = "^[0-9\\.]+\\,[0-9]{3}$";
    String regexTresDecimales = "\\d+(\\,\\d{1,3}|,{1})?";


    String regexNumericComa = "^[0-9\\.]+(\\,[0-9]+)?$";
    String regexHora = "^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$";
    String regexAlphaSpace = "^[ a-zA-Z0-9\\s]*$";
    String regexAlphaSpaceCara = "^[ a-zA-Z0-9-.\\s]*$";
    String regexAlphaSpaceCara2 = "^[ a-zA-Z0-9,-.ñáéíóúÑÁÉÍÓÚ\\s]*$";
    String regexAlpha = "^[a-zA-Z0-9\\s]*$";
    String regexAlphaMay = "^[a-zA-Z0-9]*$";
    String regexEmailEstruct = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,3}$";
    String regexEmail = "^[-.@_a-zA-Z0-9]*$";
    Button btnGuardar = new Button();
    int combo = 0;
    int combocargaM = 0;
    int comboPre = 0;
    String tipoOfertaPublica = "OPA";
    int comboPorcentajeLis = 0;
    int comboDireccion = 0;
    int comboMILA = 0;

    int idApo = 0;
    String NID;
    String nidApo;
    ValidarCampos validacion = new ValidarCampos();
    DecimalFormatSymbols a = DecimalFormatSymbols.getInstance(Locale.getDefault());

    String pattern = "###,###,###,###,###,###";
    DecimalFormat moneyFormatter = new DecimalFormat(pattern, a);
    final DecimalFormat form2 = new DecimalFormat("###,###.00");
    final DecimalFormat format4Precio = new DecimalFormat("###,###.0000");
    final DecimalFormat format3Comision = new DecimalFormat("##0.000");

    String pattern1 = "###,###,###";
    DecimalFormat moneyFormatter1 = new DecimalFormat(pattern1, a);

    //String patternNum = "###,###.##";
    //DecimalFormat moneyFormatter1 = new DecimalFormat(patternNum);
    final DecimalFormat form = new DecimalFormat("###,###");

    Facade facade = new Facade();

    Date date_aux = new Date();
    Date date_fechaInicioParamtros = new Date();
    Date date_fechaFinalParamtros = new Date();
    Calendar calendar_fechaInicioParametros = Calendar.getInstance();
    Calendar calendar_fechaFinalParamtros = Calendar.getInstance();
    Calendar calendar_aux = Calendar.getInstance();
    SimpleDateFormat simpledatefortmat_aux = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat simpledatefortmat_fechaInicioParametros = new SimpleDateFormat("dd/mm/YYYY");
    SimpleDateFormat simpledatefortmat_fechaFinalParamtros = new SimpleDateFormat("dd/mm/YYYY");

    //Label para cabezeras
    Label lbl_datosGeneralesDeLaOferta = new Label("DATOS GENERALES DE LA OFERTA");
    Label lbl_datosGeneralesDeLFormulario = new Label("DATOS GENERALES DEL FORMULARIO");
    Label lbl_datosGeneralesDeLOferente = new Label("DATOS GENERALES DEL OFERENTE");
    Label lbl_datosGeneralesCargaMasiva = new Label("DATOS GENERALES CARGA MASIVA");
    Label lbl_datosGeneralesBoletinInfo = new Label("DATOS GENERALES BOLETÍN INFORMATIVO");
    Label lbl_datosGeneralesAceptacionOPA = new Label("DATOS DE LA ACEPTACIÓN DE LA EMISIÓN");
    //Label para información
    Label lbl_fechaInicioOperacion = new Label("Fecha Inicio de Operación"); //Label fecha de inicio de la operación Lwph
    Label lbl_fechaFinOperacion = new Label("Fecha Fin de Operación"); //Label fecha de fin de la operación Lwph
    Label lbl_horaInicioOperacion = new Label("Hora Inicio Operación"); //Label hora de inicio de la operación Lwph
    Label lbl_horaInicioOperacionCarga = new Label("Hora Inicio Operación Carga"); //Label hora de inicio de la operación Lwph
    Label lbl_horaFinOperacion = new Label("Hora Fin Operación"); //Label hora de fin de la operación Lwph
    Label lbl_horaFinOperacionCarga = new Label("Hora Fin Operación Carga"); //Label hora de fin de la operación Lwph
    Label lbl_minimoDeAcciones = new Label("Mínimo de acciones objeto oferta"); //Label minimo de acciones Lwph
    Label lbl_maximoDeAcciones = new Label("Máximo de acciones objeto oferta"); //Label maximo de acciones Lwph
    Label lbl_nombreDelOferente = new Label("Nombre/Razón Social del Oferente"); //Label nombre del oferente Lwph
    Label lbl_precioDeLaOferta = new Label("Precio"); //Label precio de la oferta Lwph
    Label lbl_comisionCompra = new Label("Comisión (%) por compra");

    //Datos OPI
    Label lbl_precioDeLaOfertaOPI = new Label("Precio Acciones a Vender"); //Label precio de la oferta Lwph
    Label lbl_umbral = new Label("Umbral"); //Label cantidad de acciones umbral
    Label lbl_precioaccionespago = new Label("Precio de Acciones para Pago"); //Label precio de acciones para pago 
    Label lbl_porcentajeefectivopago = new Label("Porcentaje Segunda Validación Umbral"); //Label porcentaje de pago en efectivo
    Label lbl_porcentaje = new Label();
    Label lbl_porcentajeList = new Label("Campo porcentaje para pago en efectivo ");

    Label lbl_clasesDeAcciones = new Label("Clases de Acciones"); //Label clase de acciones Lwph
    Label lbl_nanotectino = new Label("Nemotécnico"); //Label nanotécnico Lwph
    Label lbl_accionesEnCirculacion = new Label("Acciones en Circulación");
    Label lbl_numeroDeLaAceptacion = new Label("¿Desea reiniciar el consecutivo<br>" + " a 1 para el No. De Aceptación?", ContentMode.HTML); //Label número de la aceptación Lwph
    Label lbl_textoUno = new Label("Texto 1"); //Label Texto1 Lwph
    Label lbl_textoDos = new Label("Texto 2"); //Label Texto2 Lwph
    Label lbl_existePrecacuerdo = new Label("Existe Preacuerdo"); //Label existe recaudo Lwph
    Label lbl_vendeTN = new Label("Se vende con condición Todo o Nada"); //Label se vente con todo ó nada Lwph
    Label lbl_cantRpt = new Label("Cantidad de Reportes"); //Label cantidad de reportes Lwph
    Label lbl_cantUsOp = new Label("Cantidad de Usuarios Operadores SCB"); //Label cantidad de usuario operación Lwph
    Label lbl_habilitarDireccion = new Label("Habilitar Dirección"); //Label habiltiar dirección
    Label lbl_MILA = new Label("Habilitar MILA"); //Label habiltiar dirección
    Label lbl_resConecutivo = new Label("Reiniciar el consecutivo"); //Label Reinicia el consecutivo
    Label lbl_tipoDocumentoOferente = new Label("Tipo de documento del Oferente"); //Label Reinicia el consecutivo
    Label lbl_numeroDocumentoOferente = new Label("Número de documento del Oferente"); //Label Reinicia el consecutivo
    Label lbl_DVOferente = new Label("DV"); //Label Reinicia el consecutivo
    Label lbl_EFOferente = new Label("Especial Fiduciario del Oferente"); //Label Reinicia el consecutivo
    Label lbl_ReferenteComprador = new Label("Referencia Comprador");
    Label lbl_cuentaDecevalOferente = new Label("Cuenta Deceval del Oferente"); //Label Reinicia el consecutivo
    Label lbl_scbOferente = new Label("SCB/Entidad del Oferente"); //Label Reinicia el consecutivo
    Label lbl_ActivarCm = new Label("Activar/Inactivar Modulo Carga Masiva"); //Label se vente con todo ó nada Lwph
    Label lbl_AccionesNegociadas = new Label("Acciones negociadas"); //Label acciones negociadas Boletin Informativo
    Label lbl_TextoBoletinInfo = new Label("Texto Boletín informativo"); //Label texto Boletin Informativo
    Label lbl_TextBulletinInfo = new Label("Informative text bulletin"); //Label texto Boletin Informativo en ingles
    Label lbl_textoTres = new Label("Condición 1 para Ingreso de aceptaciones"); //Label Texto3 Lwph
    Label lbl_textoCuatro = new Label("Condición 2 para Ingreso de aceptaciones"); //Label Texto4 Lwph
    Label lbl_textoCinco = new Label("Texto informativo de aceptación de condiciones para reportes"); //Label Texto5 Lwph
    Label lbl_textoSeis = new Label("Condición 1 para carga masiva"); //Label Texto6 Lwph
    Label lbl_textoSiete = new Label("Condición 2 para carga masiva"); //Label Texto7 Lwph

    //Labes para campos obligatorios.
    Label lbl_asteriscoFechaInicioOperacion = new Label("*"); //Label fecha de inicio de la operación Lwph
    Label lbl_asteriscoFechaFinOperacion = new Label("*"); //Label fecha de fin de la operación Lwph
    Label lbl_asteriscoHoraInicioOperacion = new Label("*"); //Label hora de inicio de la operación Lwph
    Label lbl_asteriscoHoraInicioOperacionCarga = new Label("*"); //Label hora de inicio de la operación Lwph
    Label lbl_asteriscoHoraFinOperacion = new Label("*"); //Label hora de fin de la operación Lwph
    Label lbl_asteriscoHoraFinOperacionCarga = new Label("*"); //Label hora de fin de la operación Lwph
    Label lbl_asteriscoMinimoDeAcciones = new Label("*"); //Label minimo de acciones Lwph
    Label lbl_asteriscoMaximoDeAcciones = new Label("*"); //Label maximo de acciones Lwph
    Label lbl_asteriscoNombreDelOferente = new Label("*"); //Label nombre del oferente Lwph
    Label lbl_asteriscoPrecioDeLaOferta = new Label("*"); //Label precio de la oferta Lwph
    Label lbl_astericoumbral = new Label("*"); // Label asterisco umbral
    Label lbl_asteriscoprecioaccionespago = new Label("*");// Label asterisco precio acciones para pago
    Label lbl_astericoporcentajeefectivopago = new Label("*");// Label a
    Label lbl_astericoporcentajeefectivopagoList = new Label("*");// Label a
    Label lbl_asteriscoClasesDeAcciones = new Label("*"); //Label clase de acciones Lwph
    Label lbl_asteriscoNanotectino = new Label("*"); //Label nanotécnico Lwph
    Label lbl_asteriscoHabilitarDireccion = new Label("*"); //Label nanotécnico Lwph
    Label lbl_asteriscoMILA = new Label("*"); //Label nanotécnico Lwph

    Label lbl_asteriscoTextoUno = new Label("*"); //Label Texto1 Lwph
    Label lbl_asteriscoTextoDos = new Label("*"); //Label Texto2 Lwph
    Label lbl_asteriscoExistePreacuerdo = new Label("*"); //Label existe recaudo Lwph
    Label lbl_asteriscoVendeTN = new Label("*"); //Label Vende con todo o nada Lwph
    Label lbl_asteriscoCantRpt = new Label("*"); //Label cantidad de reportes Lwph
    Label lbl_asteriscoCantUsOp = new Label("*"); //Label cantidad de usuario operación Lwph
    Label lbl_asteriscoTipoDocumentoOferente = new Label("*"); //Label 
    Label lbl_asteriscoNumeroDocumentoOferente = new Label("*"); //Label 
    Label lbl_asteriscoDVOferente = new Label("*"); //Label 
    Label lbl_asteriscoEFOferente = new Label(""); //Label 
    Label lbl_asteriscoCuentaDecevalOferente = new Label("*"); //Label 
    Label lbl_asteriscoScbOferente = new Label("*"); //Label 
    Label lbl_asteriscoActivarCm = new Label("*"); //Label Vende con todo o nada Lwph
    Label lbl_asteriscoAccionesNegociadas = new Label("*"); // Label asterisco acciones negociadas Boletin Informativo
    Label lbl_asteriscoTextoBoletinInfo = new Label("*"); // Label asterisco texto Boletin Informativo
    Label lbl_asteriscoTextBulletinInfo = new Label("*"); // Label asterisco texto Boletin Informativo en ingles
    Label lbl_asteriscoTextoTres = new Label("*"); //Label Texto3 Lwph
    Label lbl_asteriscoTextoCuatro = new Label("*"); //Label Texto4 Lwph
    Label lbl_asteriscoTextoCinco = new Label("*"); //Label Texto5 Lwph
    Label lbl_asteriscoTextoSeis = new Label("*"); //Label Texto6 Lwph
    Label lbl_asteriscoTextoSiete = new Label("*"); //Label Texto7 Lwph
    Label lbl_asteriscoTextoCincuentaySiete = new Label("*"); //Label Texto57 Lwph
    Label lbl_asteriscoComisionCompra = new Label("*"); //Label Error comision compra Lwph
    //Labes para error.
    Label lbl_errFechaInicioOperacion = new Label(); //Label Error fecha de inicio de la operación Lwph
    Label lbl_errFechaFinOperacion = new Label(); //Label Error fecha de fin de la operación Lwph
    Label lbl_errHoraInicioOperacion = new Label(); //Label Error hora de inicio de la operación Lwph
    Label lbl_errHoraInicioOperacionCarga = new Label(); //Label Error hora de inicio de la carga masiva Lwph
    Label lbl_errHoraFinOperacion = new Label(); //Label Error hora de fin de la operación Lwph
    Label lbl_errHoraFinOperacionCarga = new Label(); //Label Error hora de fin de la carga masiva Lwph
    Label lbl_errMinimoDeAcciones = new Label(); //Label Error minimo de acciones Lwph
    Label lbl_errMaximoDeAcciones = new Label(); //Label Error maximo de acciones Lwph
    Label lbl_errNombreDelOferente = new Label(); //Label Error nombre del oferente Lwph
    Label lbl_errPrecioDeLaOferta = new Label(); //Label Error precio de la oferta Lwph
    Label lbl_errumbral = new Label(); //Label error umbral
    Label lbl_errprecioaccionespago = new Label(); //Label error precio acciones pago
    Label lbl_errporcentajeefectivopago = new Label(); // Label error porcentaje en efectivo
    Label lbl_errporcentajeefectivopagoList = new Label(); // Label error porcentaje en efectivo
    Label lbl_errClasesDeAcciones = new Label(); //Label Error clase de acciones Lwph
    Label lbl_errAccionesEnCirculacion = new Label(); //Label Error clase de acciones Lwph
    Label lbl_errNanotectino = new Label(); //Label Error nanotécnico Lwph
    Label lbl_errNumeroDeLaAceptacion = new Label(); //Label Error número de la aceptación Lwph
    Label lbl_errTextoUno = new Label(); //Label Error Texto1 Lwph
    Label lbl_errTextoDos = new Label(); //Label Error Texto2 Lwph
    Label lbl_errExistePreacuerdo = new Label(); //Label Error existe recaudo Lwph
    Label lbl_errTextBulletinInfo = new Label(); // Label error  texto Boletin Informativo
    Label lbl_errVendeTN = new Label(); //Label Error vende con todo o nada Lwph
    Label lbl_errCantRpt = new Label(); //Label Error cantidad reporte Lwph
    Label lbl_errCantUsOp = new Label(); //Label Error cantidad usuario operación Lwph
    Label lbl_errdireccion = new Label(); //Label Error cantidad usuario operación Lwph
    Label lbl_errMILA = new Label(); //Label Error cantidad usuario operación Lwph
    Label lbl_errresConsecutivo = new Label(); //Label Error reiniciar conseg operación Lwph
    Label lbl_errBtnGuardar = new Label(); //Label Error cantidad reporte Lwph
    Label lbl_errTipoDocumentoOferente = new Label(); //Label 
    Label lbl_errNumeroDocumentoOferente = new Label(); //Label 
    Label lbl_errDVOferente = new Label(); //Label 
    Label lbl_errEFOferente = new Label(); //Label 
    Label lbl_errReferenciaComprador = new Label(); //Label
    Label lbl_errCuentaDecevalOferente = new Label(); //Label 
    Label lbl_errScbOferente = new Label(); //Label 
    Label lbl_errActivarCm = new Label(); //Label Error vende con todo o nada Lwph
    Label lbl_errAccionesNegociadas = new Label(); //Label Error acciones negociadas Boletin Informativo
    Label lbl_errTextoBoletinInfo = new Label(); // Label error  texto Boletin Informativo
    Label lbl_errTextoTres = new Label(); //Label Error Texto3 Lwph
    Label lbl_errTextoCuatro = new Label(); //Label Error Texto4 Lwph
    Label lbl_errTextoCinco = new Label(); //Label Error Texto5 Lwph
    Label lbl_errTextoSeis = new Label(); //Label Error Texto6 Lwph
    Label lbl_errTextoSiete = new Label(); //Label Error Texto7 Lwph
    Label lbl_errSeleccionTipoOfertaPublica = new Label();
    Label lbl_errComisionCompra = new Label(); //Label Error comision compra Lwph

    //DateField para el formulario
    PopupDateField datef_fechaInicioOperacion = new PopupDateField(); // dateField  fecha inicio de la operación Lwph
    PopupDateField datef_fechaFinOperacion = new PopupDateField(); // dateField  fecha fin de la operación Lwph

    TextField txtf_horaInicioOperacion = new TextField(); // TextField  hora inicio de la operación Lwph
    TextField txtf_horaInicioOperacionCarga = new TextField(); // TextField  hora inicio de la carga masiva Lwph
    TextField txtf_horaFinOperacion = new TextField(); // TextField  hora fin de la operación Lwph
    TextField txtf_horaFinOperacionCarga = new TextField(); // TextField  hora fin de la carga masiva Lwph
    //Texfield para el formulario
    TextField txtf_minimoDeAcciones = new TextField(); //TextField minimo de acciones Lwph
    TextField txtf_maximoDeAcciones = new TextField(); //TextField maximo de acciones Lwph
    TextField txtf_nombreDelOferente = new TextField(); //TextField nombre del oferente Lwph
    TextField txtf_precioDeLaOferta = new TextField(); //TextField precio de la oferta Lwph
    TextField txtf_comisionCompra = new TextField(); //TextField comision de compra Lwph
    //OPI
    TextField txtf_umbral = new TextField(); //TextField umbral de acciones 
    TextField txtf_precioaccionespago = new TextField(); //TextFiel precio acciones para pago
    TextField txtf_porcentajeefectivopago = new TextField(); // TextField porcentaje efectivo para pago
    //Fin OPI
    TextField txtf_clasesDeAcciones = new TextField(); //TextField clase de acciones Lwph
    TextField txtf_nanotecnico = new TextField(); //TextField nanotécnico Lwph
    TextField txtf_accionesEnCirculacion = new TextField(); //TextField nanotécnico Lwph
    CheckBox txtf_numeroDeAceptacion = new CheckBox(); //TextField número de aceptacón Lwph
    TextField txtf_cantRpt = new TextField(); //TextField cantidad de reportes Lwph
    TextField txtf_cantUsOp = new TextField(); //TextField cantidad de Usuario Operación Lwph
    //Text Area para el formulario
    TextArea txta_textoUno = new TextArea(); //TextArea texto uno Lwph
    TextArea txta_textoDos = new TextArea(); //TextArea texto dos Lwph
    TextArea txta_textoTres = new TextArea(); //TextArea texto tres Lwph
    TextArea txta_textoCuatro = new TextArea(); //TextArea texto cuatro Lwph
    TextArea txta_textoCinco = new TextArea(); //TextArea texto cinco Lwph
    TextArea txta_textoSeis = new TextArea(); //TextArea texto seis Lwph
    TextArea txta_textoSiete = new TextArea(); //TextArea texto siete Lwph

    //Text Area boletín informativo
    TextField txta_AccionesNegociadas = new TextField(); // TextArea acciones negociadas
    TextArea txta_TextoBoletinInfo = new TextArea(); // TextArea acciones negociadas
    TextArea txta_TextBulletinInfo = new TextArea(); // TextArea texto idioma ingles
    //Combobox para el formulario
    ComboBox cbox_existePreacuerdo = new ComboBox(); //ComboBox existe recaudo Lwph
    ComboBox cbox_vendeTN = new ComboBox(); //ComboBox vende todo o nada Lwph
    ComboBox cbox_resConsecutivo = new ComboBox(); //ComboBox reiniciar el consecutivo Lwph
    ComboBox cbox_activarCm = new ComboBox(); //ComboBox reiniciar el consecutivo Lwph
    ComboBox cbox_tipoOferPublica = new ComboBox(); //ComboBox tipo oferta publica
    ComboBox cbox_porcentajeList = new ComboBox(); //ComboBox para pago en efectivo o acciones
    ComboBox cbox_direccion = new ComboBox(); //ComboBox habilitar Dirección en formulario de ingreso de Aceptaciones
    ComboBox cbox_MILA = new ComboBox(); //ComboBox habilitar MILA en la Operación

//Campos del oferente
    ComboBox cmb_TipoDocumentoOferente = new ComboBox();
    TextField txtf_numeroDocumentoOferente = new TextField();
    TextField txtf_DVOferente = new TextField();
    TextField txtf_EFOferente = new TextField();
    TextField txtf_cuentaDecevalOferente = new TextField();
    TextField txtf_ReferenciaComprador = new TextField();
    ComboBox cmb_scbOferente = new ComboBox();

    Label error = new Label("");
    Date fechaI = null;
    Date fechaF = null;
    //List<String> parametros = null;
    FqsParametrizacion fqsParametrizacion = null;
    MaskFormatter mskf_proyect = new MaskFormatter();
    HorizontalLayout vlCab;

    Integer valorCombo = null;
    Integer valorSCB = null;
    int hayParametrizacion = 0;
    
    //06-12-21
    Label label_recalculo = new Label("¿Desea recalcular los montos<br> con el precio incluido?", ContentMode.HTML);
    CheckBox check_recalculo = new CheckBox();
    Label label_err_recalculo = new Label(); //Label Error número de la aceptación Lwph
    
    @Autowired
    private MyUserDetailsService userDetailsService;

    public CrearParametros(GenericTab parentTab) {
        super(parentTab);
    }

    Window modal;

    @Override
    public void initForm() {

        VerticalLayout subContent = new VerticalLayout();
        GridLayout grid = new GridLayout(3, 6);

        /**
         * *********************************
         */
        Label lbl_seleccioneTipoOferta = new Label("Tipo Oferta ");
        grid.addComponent(lbl_seleccioneTipoOferta, 0, 0);
        grid.setComponentAlignment(lbl_seleccioneTipoOferta, Alignment.MIDDLE_CENTER);
        lbl_seleccioneTipoOferta.setWidth(11, Sizeable.Unit.EM);
        lbl_seleccioneTipoOferta.setHeight(2, Sizeable.Unit.EM);

        cbox_tipoOferPublica.setTextInputAllowed(false);
        cbox_tipoOferPublica.setNullSelectionAllowed(false);
        cbox_tipoOferPublica.addItem("");
        cbox_tipoOferPublica.setItemCaption("", "Seleccione");
        cbox_tipoOferPublica.addItem("OPA");
        cbox_tipoOferPublica.setItemCaption("OPA", "OPA");
        cbox_tipoOferPublica.addItem("OPI");
        cbox_tipoOferPublica.setItemCaption("OPI", "OPI");
        grid.addComponent(cbox_tipoOferPublica, 1, 0);
        
        lbl_errSeleccionTipoOfertaPublica.setStyleName("lblerrores");
        grid.addComponent(lbl_errSeleccionTipoOfertaPublica,1,2);
        

        cbox_vendeTN.setTextInputAllowed(false);
        cbox_vendeTN.setNullSelectionAllowed(false);
        cbox_vendeTN.addItem(0);
        cbox_vendeTN.setItemCaption(0, "Seleccione");
        cbox_vendeTN.addItem(1);
        cbox_vendeTN.setItemCaption(1, "Activar");
        cbox_vendeTN.addItem(2);
        cbox_vendeTN.setItemCaption(2, "Desactivar");

        cbox_direccion.setTextInputAllowed(false);
        cbox_direccion.setNullSelectionAllowed(false);
        cbox_direccion.addItem(0);
        cbox_direccion.setItemCaption(0, "Seleccione");
        cbox_direccion.addItem(1);
        cbox_direccion.setItemCaption(1, "Activar");
        cbox_direccion.addItem(2);
        cbox_direccion.setItemCaption(2, "Desactivar");

        cbox_MILA.setTextInputAllowed(false);
        cbox_MILA.setNullSelectionAllowed(false);
        cbox_MILA.addItem(0);
        cbox_MILA.setItemCaption(0, "Seleccione");
        cbox_MILA.addItem(1);
        cbox_MILA.setItemCaption(1, "Activar");
        cbox_MILA.addItem(2);
        cbox_MILA.setItemCaption(2, "Desactivar");

        cbox_activarCm.setTextInputAllowed(false);
        cbox_activarCm.setNullSelectionAllowed(false);
        cbox_activarCm.addItem(0);
        cbox_activarCm.setItemCaption(0, "Seleccione");
        cbox_activarCm.addItem(1);
        cbox_activarCm.setItemCaption(1, "Activar");
        cbox_activarCm.addItem(2);
        cbox_activarCm.setItemCaption(2, "Desactivar");

        cbox_existePreacuerdo.setTextInputAllowed(false);
        cbox_existePreacuerdo.setNullSelectionAllowed(false);
        cbox_existePreacuerdo.addItem(0);
        cbox_existePreacuerdo.setItemCaption(0, "Seleccione");
        cbox_existePreacuerdo.addItem(1);
        cbox_existePreacuerdo.setItemCaption(1, "Activar");
        cbox_existePreacuerdo.addItem(2);
        cbox_existePreacuerdo.setItemCaption(2, "Desactivar");

        cbox_porcentajeList.setTextInputAllowed(false);
        cbox_porcentajeList.setNullSelectionAllowed(false);
        cbox_porcentajeList.addItem(0);
        cbox_porcentajeList.setItemCaption(0, "Seleccione");
        cbox_porcentajeList.addItem(1);
        cbox_porcentajeList.setItemCaption(1, "Manual");
        cbox_porcentajeList.addItem(2);
        cbox_porcentajeList.setItemCaption(2, "Predeterminada");

        cmb_TipoDocumentoOferente = LlenarTipoDocumento();
        cmb_scbOferente = LlenarSCB();

        //Botón de confirmación en el modal de selección de tipo de la Oferta
        Button btn_confirmarSeleccioneTipoOferta = new Button("Aceptar");
        grid.addComponent(btn_confirmarSeleccioneTipoOferta, 0, 3);

        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        ////////////////////////////////////////////////////////////////////////////////   
        hayParametrizacion = facade.validaHayParametros();

        if (hayParametrizacion == 1) {

            try {
                fqsParametrizacion = facade.getFqsParametrizacion();
                tipoOfertaPublica = fqsParametrizacion.getTipoOfertaPublica();

                btn_confirmarSeleccioneTipoOferta.addClickListener(new Button.ClickListener() {

                    @Override
                    public void buttonClick(Button.ClickEvent event) {

                        /*
                        Validar si fue seleccionada el mismo tipo de Oferta pública.
                        Escenarios:

                        8.1. Seleccionan OP igual en Popup, no pasa nada.
                        8.2. Seleccionan OP distinta en Popup y existen Demandas, salir Dialog: 
                        "Por favor, elimine las Demandas de OPA que existen actualmente". No dejarlos pasar !.
                        8.3. Aplica Viceversa 
                         */
                        if (cbox_tipoOferPublica.getValue().equals(tipoOfertaPublica)) {
                            modal.close();
                        } else {
                            
                            if(cbox_tipoOferPublica.getValue().equals("")){
                                lbl_errSeleccionTipoOfertaPublica.setValue("Debe seleccionar una opción válida");
                            }else{
                            
                            //Pregunta si existen aceptaciones ingresadas 
                            if (facade.countAceptacionesExists() > 0) {

                                /* SIRVE CUANDO SE ADAPTE EL MENSAJE DE VALIDACIÓN */
                                ConfirmDialog.show(getUI(), "Confirmación", "Por favor, elimine las Aceptaciones que existen actualmente para poder cambiar el tipo de Oferta Pública", "ACEPTAR",
                                        "CANCELAR", new ConfirmDialog.Listener() {
                                    @Override
                                    public void onClose(ConfirmDialog dialog) {
                                        if (dialog.isConfirmed()) {
                                            getUI().getPage().setLocation("/opa");
                                        }
                                    }
                                });
                            } else {
                                tipoOfertaPublica = cbox_tipoOferPublica.getValue().toString();
                                modal.close();
                            }
                            
                            }
                            
                            
                        }

                    }
                });

                SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-mm-dd");
                String strFecha = fqsParametrizacion.getFechaIniOperacion();
                String strFecha2 = fqsParametrizacion.getFechaFinOperacion();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                // Convert from String to Date
                Date startDate = df.parse(strFecha);
                // Convert from String to Date
                Date endDate = df.parse(strFecha2);
                datef_fechaInicioOperacion.setValue(startDate);
                datef_fechaFinOperacion.setValue(endDate);
                txtf_horaInicioOperacionCarga.setValue(fqsParametrizacion.getHoraIniOperacionCarga());
                txtf_horaFinOperacionCarga.setValue(fqsParametrizacion.getHoraFinOperacionCarga());
                txtf_horaInicioOperacion.setValue(fqsParametrizacion.getHoraIniOperacion());
                txtf_horaFinOperacion.setValue(fqsParametrizacion.getHoraFinOperacion());
                txtf_minimoDeAcciones.setValue(moneyFormatter.format(Double.valueOf(fqsParametrizacion.getMinAccionesObjOferta())));
                txtf_maximoDeAcciones.setValue(moneyFormatter.format(Double.valueOf(fqsParametrizacion.getMaxAccionesObjOferta())));
                txtf_nombreDelOferente.setValue(fqsParametrizacion.getNombreRazonSocial());
                txtf_precioDeLaOferta.setValue(format4Precio.format(Double.valueOf(fqsParametrizacion.getPrecioAceptaciones())));
                txtf_comisionCompra.setValue(format3Comision.format(Double.valueOf(fqsParametrizacion.getComisionCompra())));
                txtf_clasesDeAcciones.setValue(fqsParametrizacion.getClaseAcciones());
                txtf_nanotecnico.setValue(fqsParametrizacion.getNanotecnico());
                txtf_cantRpt.setValue(fqsParametrizacion.getCantReporte());
                txta_textoUno.setValue(fqsParametrizacion.getTextoUno());
                txta_textoDos.setValue(fqsParametrizacion.getTextoDos());
                cbox_tipoOferPublica.select(fqsParametrizacion.getTipoOfertaPublica());
                try{
                    txtf_accionesEnCirculacion.setValue(moneyFormatter.format(Double.valueOf(fqsParametrizacion.getAccionesEnCirculacion())));
                }catch(Exception e){
                    txtf_accionesEnCirculacion.setValue("");
                    txtf_accionesEnCirculacion.setComponentError(new UserError(""));
                    lbl_errAccionesEnCirculacion.setValue("Este campo es requerido");
                }               
                if (tipoOfertaPublica.equals("OPI")) {
                    txtf_umbral.setValue(form.format(Double.valueOf(fqsParametrizacion.getUmbral())));
                    txtf_precioaccionespago.setValue(form2.format(Double.valueOf(fqsParametrizacion.getPrecioaccionespago())));
                    //txtf_precioaccionespago.setValue(moneyFormatter.format(Double.valueOf(parametros.get(34))));
                    txtf_porcentajeefectivopago.setValue(fqsParametrizacion.getPorcentajeefectivopago());
                    txta_textoTres.setValue(fqsParametrizacion.getTextoTres());
                    txta_textoCuatro.setValue(fqsParametrizacion.getTextoCuatro());
                    txta_textoCinco.setValue(fqsParametrizacion.getTextoCinco());
                    txta_textoSeis.setValue(fqsParametrizacion.getTextoSeis());
                    txta_textoSiete.setValue(fqsParametrizacion.getTextoSiete());
                    cbox_porcentajeList.select(Integer.parseInt(fqsParametrizacion.getTipoPago()));
                } else {
                    txtf_umbral.setValue(form.format(Double.valueOf(0)));
                    txtf_precioaccionespago.setValue(form2.format(Double.valueOf(0)));
                    //txtf_precioaccionespago.setValue(moneyFormatter.format(Double.valueOf(0)));
                    cbox_porcentajeList.select(0);
                }
                cbox_vendeTN.select(Integer.parseInt(fqsParametrizacion.getTodoONada()));
                cbox_direccion.select(Integer.parseInt(fqsParametrizacion.getDireccion()));
                cbox_MILA.select(Integer.parseInt(fqsParametrizacion.getMila()));
                cbox_activarCm.select(Integer.parseInt(fqsParametrizacion.getActivarCargaMasiva()));
                cbox_existePreacuerdo.select(Integer.parseInt(fqsParametrizacion.getExistePreacuerdo()));
                txtf_cantUsOp.setValue(fqsParametrizacion.getCantUsuariosOpe());
                cmb_TipoDocumentoOferente.select(Integer.parseInt(fqsParametrizacion.getTipoDocumentoOferente()));
                if (Integer.parseInt(fqsParametrizacion.getTipoDocumentoOferente()) == 4) {
                    txtf_DVOferente.setVisible(true);
                    txtf_EFOferente.setEnabled(true);
                } else {
                    txtf_DVOferente.setVisible(false);
                    txtf_EFOferente.setEnabled(false);
                }
                txtf_numeroDocumentoOferente.setValue(fqsParametrizacion.getNumeroDocumentoOferente());
                txtf_DVOferente.setValue(fqsParametrizacion.getdVOferente());
                if (fqsParametrizacion.getEFOferente() == null) {
                    txtf_EFOferente.setValue("");
                } else {
                    txtf_EFOferente.setValue(fqsParametrizacion.getEFOferente());
                }
                if (fqsParametrizacion.getReferenciaComprador() == null) {
                    txtf_ReferenciaComprador.setValue("");
                } else {
                    txtf_ReferenciaComprador.setValue(fqsParametrizacion.getReferenciaComprador());
                }
                txtf_cuentaDecevalOferente.setValue(fqsParametrizacion.getCuentaDecevalOferente());
                cmb_scbOferente.select(Integer.parseInt(fqsParametrizacion.getSCBOferente()));

                txta_AccionesNegociadas.setValue(fqsParametrizacion.getAccionesnegociadas());
                txta_TextoBoletinInfo.setValue(fqsParametrizacion.getTxtBoletinInformativo());
                txta_TextBulletinInfo.setValue(fqsParametrizacion.getTxtBulletinInformative());
            } catch (ParseException ex) {
                logger.error("OP - " + CrearParametros.class.getName(), ex);
            }

        } else {
            datef_fechaInicioOperacion.setValue(new Date());
            datef_fechaFinOperacion.setValue(new Date());
            cbox_existePreacuerdo.select(0);
            cbox_vendeTN.select(0);
            cbox_activarCm.select(0);
            cmb_TipoDocumentoOferente.select(0);
            cmb_scbOferente.select(0);
            cbox_direccion.select(0);
            cbox_MILA.select(0);
            txtf_comisionCompra.setValue("0,000");

            btn_confirmarSeleccioneTipoOferta.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent event) {
                    tipoOfertaPublica = cbox_tipoOferPublica.getValue().toString();
                    modal.close();
                }
            });
        }

        VerticalLayout vlPadre = new VerticalLayout();
        GridLayout vlInv = new GridLayout();
        vlInv.setColumns(7);
        vlInv.setRows(61);
        //Cabecera del primer grupo
        vlCab = new HorizontalLayout();
        vlCab.setWidth(97, Sizeable.Unit.PERCENTAGE);

        lbl_datosGeneralesDeLaOferta.setWidth(98, Sizeable.Unit.PERCENTAGE);
        lbl_datosGeneralesDeLaOferta.setStyleName("tituloInversionistatit");
        Embedded imgEmb_datosGeneralesDeLaOferta = new Embedded(null, new ThemeResource("img/Inver.png"));
        imgEmb_datosGeneralesDeLaOferta.setHeight("35px");
        imgEmb_datosGeneralesDeLaOferta.setStyleName("InverImg");
        vlCab.addStyleName("tituloInversionista");
        vlCab.addComponents(imgEmb_datosGeneralesDeLaOferta, lbl_datosGeneralesDeLaOferta);
        vlCab.setComponentAlignment(lbl_datosGeneralesDeLaOferta, Alignment.MIDDLE_LEFT);
        vlInv.addComponent(vlCab, 0, 0, 6, 0);

        //Menú Datos de la Oferta
        //Primera fila de controles
        vlInv.addComponent(lbl_fechaInicioOperacion, 0, 1);
        vlInv.setComponentAlignment(lbl_fechaInicioOperacion, Alignment.MIDDLE_LEFT);
        lbl_fechaInicioOperacion.setWidth(15, Sizeable.Unit.EM);

        lbl_asteriscoFechaInicioOperacion.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoFechaInicioOperacion, 1, 1);
        vlInv.setComponentAlignment(lbl_asteriscoFechaInicioOperacion, Alignment.MIDDLE_LEFT);
        lbl_asteriscoFechaInicioOperacion.setWidth(2, Sizeable.Unit.EM);

        vlInv.addComponent(datef_fechaInicioOperacion, 2, 1);
        vlInv.setComponentAlignment(datef_fechaInicioOperacion, Alignment.MIDDLE_LEFT);
        datef_fechaInicioOperacion.setWidth(12, Sizeable.Unit.EM);

        lbl_errFechaInicioOperacion.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errFechaInicioOperacion, 2, 2);
        vlInv.setComponentAlignment(lbl_errFechaInicioOperacion, Alignment.MIDDLE_LEFT);
        lbl_errFechaInicioOperacion.setWidth(15, Sizeable.Unit.EM);

        datef_fechaInicioOperacion.setDateFormat("dd/MM/yyyy");
        datef_fechaInicioOperacion.setTextFieldEnabled(false);

        datef_fechaInicioOperacion.addValueChangeListener(new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent event) {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = datef_fechaInicioOperacion.getValue();
                Date date2 = datef_fechaFinOperacion.getValue();

                String fecha = "";
                try {
                    fecha = String.valueOf(sdf.format(datef_fechaInicioOperacion.getValue()));
                } catch (NullPointerException ex) {

                    fecha = "";
                }

                boolean festivo = facade.Retornafestivo(fecha);
                if (!festivo) {

                    if (date2.before(date)) {
                        lbl_errFechaInicioOperacion.setValue("La Fecha inicial es mayor a la fecha final de operacion");
                    } else {
                        datef_fechaInicioOperacion.setComponentError(null);
                        lbl_errFechaInicioOperacion.setValue("");
                        datef_fechaFinOperacion.setComponentError(null);
                        lbl_errFechaFinOperacion.setValue("");
                    }

                } else {
                    datef_fechaInicioOperacion.setComponentError(new UserError(""));
                    lbl_errFechaInicioOperacion.setValue("Debe seleccionar solo días hábiles");
                }
                ValidarError();
            }
        });

        vlInv.addComponent(lbl_fechaFinOperacion, 3, 1);
        vlInv.setComponentAlignment(lbl_fechaFinOperacion, Alignment.MIDDLE_LEFT);
        lbl_fechaFinOperacion.setWidth(15, Sizeable.Unit.EM);

        lbl_asteriscoFechaFinOperacion.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoFechaFinOperacion, 4, 1);
        vlInv.setComponentAlignment(lbl_asteriscoFechaFinOperacion, Alignment.MIDDLE_LEFT);
        lbl_asteriscoFechaFinOperacion.setWidth(2, Sizeable.Unit.EM);

        vlInv.addComponent(datef_fechaFinOperacion, 5, 1);
        vlInv.setComponentAlignment(datef_fechaFinOperacion, Alignment.MIDDLE_LEFT);
        datef_fechaFinOperacion.setWidth(12, Sizeable.Unit.EM);

        lbl_errFechaFinOperacion.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errFechaFinOperacion, 5, 2);
        vlInv.setComponentAlignment(lbl_errFechaFinOperacion, Alignment.MIDDLE_LEFT);
        lbl_errFechaFinOperacion.setWidth(15, Sizeable.Unit.EM);

        datef_fechaFinOperacion.setDateFormat("dd/MM/yyyy");
        datef_fechaFinOperacion.setTextFieldEnabled(false);

        datef_fechaFinOperacion.addValueChangeListener(new Property.ValueChangeListener() {

            @Override
            public void valueChange(Property.ValueChangeEvent event) {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = datef_fechaInicioOperacion.getValue();
                Date date2 = datef_fechaFinOperacion.getValue();

                String fecha = "";
                try {
                    fecha = String.valueOf(sdf.format(datef_fechaFinOperacion.getValue()));
                } catch (NullPointerException ex) {

                    fecha = "";
                }

                boolean festivo = facade.Retornafestivo(fecha);
                if (!festivo) {

                    if (date2.before(date)) {
                        lbl_errFechaFinOperacion.setValue("La Fecha Final debe ser mayor a la fecha Inicial de operacion");
                    } else {
                        datef_fechaFinOperacion.setComponentError(null);
                        lbl_errFechaFinOperacion.setValue("");
                        datef_fechaInicioOperacion.setComponentError(null);
                        lbl_errFechaInicioOperacion.setValue("");

                    }

                } else {
                    datef_fechaFinOperacion.setComponentError(new UserError(""));
                    lbl_errFechaFinOperacion.setValue("Debe seleccionar solo días hábiles");
                }
                ValidarError();
            }
        });

////////////////////////////////////////////////////////////////////////////////
        //Segunda fila de controles
        vlInv.addComponent(lbl_horaInicioOperacion, 0, 3);
        lbl_asteriscoHoraInicioOperacion.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoHoraInicioOperacion, 1, 3);

        txtf_horaInicioOperacion.setMaxLength(8);
        vlInv.addComponent(txtf_horaInicioOperacion, 2, 3);

        txtf_horaInicioOperacion.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (txtf_horaInicioOperacion.getValue().equals("")) {
                    txtf_horaInicioOperacion.setComponentError(new UserError(""));
                    lbl_errHoraInicioOperacion.setValue("Este campo es requerido");
                } else {
                    if (txtf_horaInicioOperacion.getValue().matches(regexHora)) {
                        txtf_horaInicioOperacion.setComponentError(null);
                        lbl_errHoraInicioOperacion.setValue("");
                    } else {
                        txtf_horaInicioOperacion.setComponentError(new UserError(""));
                        lbl_errHoraInicioOperacion.setValue("El formato de la hora inicio no es válido");
                    }

                }
                ValidarError();
            }
        });
        lbl_errHoraInicioOperacion.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errHoraInicioOperacion, 2, 4);

        vlInv.addComponent(lbl_horaFinOperacion, 3, 3);
        lbl_asteriscoHoraFinOperacion.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoHoraFinOperacion, 4, 3);

        txtf_horaFinOperacion.setMaxLength(8);
        vlInv.addComponent(txtf_horaFinOperacion, 5, 3);

        txtf_horaFinOperacion.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (txtf_horaFinOperacion.getValue().equals("")) {
                    txtf_horaFinOperacion.setComponentError(new UserError(""));
                    lbl_errHoraFinOperacion.setValue("Este campo es requerido");
                } else {
                    if (txtf_horaFinOperacion.getValue().matches(regexHora)) {
                        txtf_horaFinOperacion.setComponentError(null);
                        lbl_errHoraFinOperacion.setValue("");
                    } else {
                        txtf_horaFinOperacion.setComponentError(new UserError(""));
                        lbl_errHoraFinOperacion.setValue("El formato de la hora fin no es válido");
                    }

                }
                ValidarError();
            }
        });

        lbl_errHoraFinOperacion.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errHoraFinOperacion, 5, 4);
////////////////////////////////////////////////////////////////////////////////
        //Tercera fila de controles

        vlInv.addComponent(lbl_minimoDeAcciones, 0, 5);
        lbl_asteriscoMinimoDeAcciones.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoMinimoDeAcciones, 1, 5);

        txtf_minimoDeAcciones.setMaxLength(11);
        vlInv.addComponent(txtf_minimoDeAcciones, 2, 5);

        lbl_errMinimoDeAcciones.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errMinimoDeAcciones, 2, 6);

        txtf_minimoDeAcciones.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!txtf_minimoDeAcciones.getValue().equals("")) {
                    if (txtf_minimoDeAcciones.getValue().matches(regexNumericPunt)) {
                        if (EsEntero(txtf_minimoDeAcciones.getValue())) {
                            try {
                                txtf_minimoDeAcciones.setValue(moneyFormatter1.format(Double.parseDouble(txtf_minimoDeAcciones.getValue().replace(".", "").split("&")[0])));
                                if ((!txtf_minimoDeAcciones.getValue().toString().equalsIgnoreCase("0"))) {
                                    txtf_minimoDeAcciones.setComponentError(null);
                                    lbl_errMinimoDeAcciones.setValue("");
                                } else {
                                    txtf_minimoDeAcciones.setComponentError(new UserError(""));
                                    lbl_errMinimoDeAcciones.setValue("Cantidad de Acciones Invalida");
                                }
                            } catch (Validator.InvalidValueException e) {
                                txtf_minimoDeAcciones.setComponentError(new UserError(""));
                                lbl_errMinimoDeAcciones.setValue("Este campo contiene caracteres no válidos");
                                logger.error("OPA - " + CrearParametros.class.getName(), e);
                            }

                        } else {
                            txtf_minimoDeAcciones.setComponentError(new UserError(""));
                            lbl_errMinimoDeAcciones.setValue("Cantidad de Acciones Invalida");
                        }
                    } else {
                        txtf_minimoDeAcciones.setComponentError(new UserError(""));
                        lbl_errMinimoDeAcciones.setValue("Este campo contiene caracteres no válidos");
                    }
                } else {
                    txtf_minimoDeAcciones.setComponentError(new UserError(""));
                    lbl_errMinimoDeAcciones.setValue("Este campo es requerido");
                }
                ValidarError();
            }
        });
        vlInv.addComponent(lbl_maximoDeAcciones, 3, 5);
        lbl_asteriscoMaximoDeAcciones.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoMaximoDeAcciones, 4, 5);
        txtf_maximoDeAcciones.setMaxLength(11);
        vlInv.addComponent(txtf_maximoDeAcciones, 5, 5);
        lbl_errMaximoDeAcciones.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errMaximoDeAcciones, 5, 6);
        txtf_maximoDeAcciones.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!txtf_maximoDeAcciones.getValue().equals("")) {
                    if (txtf_maximoDeAcciones.getValue().matches(regexNumericPunt)) {
                        if (EsEntero(txtf_maximoDeAcciones.getValue())) {
                            try {
                                txtf_maximoDeAcciones.setValue(moneyFormatter1.format(Double.parseDouble(txtf_maximoDeAcciones.getValue().replace(".", "").split("&")[0])));
                                if ((!txtf_maximoDeAcciones.getValue().toString().equalsIgnoreCase("0"))) {
                                    txtf_maximoDeAcciones.setComponentError(null);
                                    lbl_errMaximoDeAcciones.setValue("");
                                } else {
                                    txtf_maximoDeAcciones.setComponentError(new UserError(""));
                                    lbl_errMaximoDeAcciones.setValue("Cantidad de Acciones Invalida");
                                }
                            } catch (Validator.InvalidValueException e) {
                                txtf_maximoDeAcciones.setComponentError(new UserError(""));
                                lbl_errMaximoDeAcciones.setValue("Este campo contiene caracteres no válidos");
                                logger.error("OPA - " + CrearParametros.class.getName(), e);
                            }

                        } else {
                            txtf_maximoDeAcciones.setComponentError(new UserError(""));
                            lbl_errMaximoDeAcciones.setValue("Cantidad de Acciones Invalida");
                        }
                    } else {
                        txtf_maximoDeAcciones.setComponentError(new UserError(""));
                        lbl_errMaximoDeAcciones.setValue("Este campo contiene caracteres no válidos");
                    }
                } else {
                    txtf_maximoDeAcciones.setComponentError(new UserError(""));
                    lbl_errMaximoDeAcciones.setValue("Este campo es requerido");
                }
                ValidarError();
            }
        });
////////////////////////////////////////////////////////////////////////////////
        ///Cuarta fila de controles

        vlInv.addComponent(lbl_nombreDelOferente, 0, 7);
        lbl_asteriscoNombreDelOferente.setStyleName("asterix");

        vlInv.addComponent(lbl_asteriscoNombreDelOferente, 1, 7);
        vlInv.setComponentAlignment(lbl_nombreDelOferente, Alignment.MIDDLE_LEFT);
        // lbl_nombreDelOferente.setWidth(12,Sizeable.Unit.EM);

        txtf_nombreDelOferente.setMaxLength(50);
        vlInv.addComponent(txtf_nombreDelOferente, 2, 7);

        lbl_errNombreDelOferente.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errNombreDelOferente, 2, 8);
        txtf_nombreDelOferente.setMaxLength(50);

        txtf_nombreDelOferente.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!txtf_nombreDelOferente.getValue().equals("")) {
                    if (txtf_nombreDelOferente.getValue().matches(regexAlphaSpaceCara)) {
                        txtf_nombreDelOferente.setComponentError(null);
                        lbl_errNombreDelOferente.setValue("");
                    } else {
                        txtf_nombreDelOferente.setComponentError(new UserError(""));
                        lbl_errNombreDelOferente.setValue("Este campo contiene caracteres no válidos");
                    }
                } else {
                    txtf_nombreDelOferente.setComponentError(new UserError(""));
                    lbl_errNombreDelOferente.setValue("Este campo es requerido");
                }
                ValidarError();
            }
        });

        vlInv.addComponent(lbl_precioDeLaOferta, 3, 7);
        lbl_asteriscoPrecioDeLaOferta.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoPrecioDeLaOferta, 4, 7);

        txtf_precioDeLaOferta.setMaxLength(14);
        vlInv.addComponent(txtf_precioDeLaOferta, 5, 7);

        lbl_errPrecioDeLaOferta.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errPrecioDeLaOferta, 5, 8);

        txtf_precioDeLaOferta.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!txtf_precioDeLaOferta.getValue().equals("")) {
                    String precioDeLaOferta = txtf_precioDeLaOferta.getValue();
                    if (precioDeLaOferta.contains(",")) {
                        if (precioDeLaOferta.matches(regexNumericPuntComa4)) {
                            if (EsDecimal(precioDeLaOferta)) {
                                try {
                                    Double num = 0.0;
                                    Number valor = format4Precio.parse(txtf_precioDeLaOferta.getValue());
                                    num = valor.doubleValue();
                                    //form2.setRoundingMode(RoundingMode.FLOOR);
                                    txtf_precioDeLaOferta.setValue(format4Precio.format(num));
                                    txtf_precioDeLaOferta.setComponentError(null);
                                    lbl_errPrecioDeLaOferta.setValue("");
                                } catch (ParseException ex) {
                                    logger.error("OPA - " + CrearParametros.class.getName(), ex);
                                }
                            } else {
                                txtf_precioDeLaOferta.setComponentError(new UserError(""));
                                lbl_errPrecioDeLaOferta.setValue("Precio Inválido");
                            }
                        } else {
                            txtf_precioDeLaOferta.setComponentError(new UserError(""));
                            lbl_errPrecioDeLaOferta.setValue("Este campo requiere cuatro decimales");
                        }

                    } else {
                        if (EsDecimal(precioDeLaOferta)) {

                            try {
                                Double num = 0.0;
                                Number valor = format4Precio.parse(txtf_precioDeLaOferta.getValue());
                                num = valor.doubleValue();
                                //form2.setRoundingMode(RoundingMode.FLOOR);
                                txtf_precioDeLaOferta.setValue(format4Precio.format(num));
                                txtf_precioDeLaOferta.setComponentError(null);
                                lbl_errPrecioDeLaOferta.setValue("");
                            } catch (ParseException ex) {
                                logger.error("OPA - " + CrearParametros.class.getName(), ex);
                            }

                        } else {

                            txtf_precioDeLaOferta.setComponentError(new UserError(""));
                            lbl_errPrecioDeLaOferta.setValue("Precio Inválido");
                        }
                    }

                } else {
                    txtf_precioDeLaOferta.setComponentError(new UserError(""));
                    lbl_errPrecioDeLaOferta.setValue("Este campo es requerido");
                }
                ValidarError();
            }
        });

        ////////////////////////////////////////////////////////////////////////////////        
        //Quinta fila de controles
        vlInv.addComponent(lbl_clasesDeAcciones, 0, 9);
        lbl_asteriscoClasesDeAcciones.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoClasesDeAcciones, 1, 9);

        txtf_clasesDeAcciones.setMaxLength(20);
        vlInv.addComponent(txtf_clasesDeAcciones, 2, 9);

        lbl_errClasesDeAcciones.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errClasesDeAcciones, 2, 10);
        txtf_clasesDeAcciones.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!txtf_clasesDeAcciones.getValue().equals("")) {
                    if (txtf_clasesDeAcciones.getValue().matches(regexAlphaSpace)) {
                        txtf_clasesDeAcciones.setComponentError(null);
                        lbl_errClasesDeAcciones.setValue("");
                    } else {
                        txtf_clasesDeAcciones.setComponentError(new UserError(""));
                        lbl_errClasesDeAcciones.setValue("Este campo contiene caracteres no válidos");
                    }
                } else {
                    txtf_clasesDeAcciones.setComponentError(new UserError(""));
                    lbl_errClasesDeAcciones.setValue("Este campo es requerido");
                }
                ValidarError();
            }
        });

        vlInv.addComponent(lbl_nanotectino, 3, 9);
        lbl_asteriscoNanotectino.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoNanotectino, 4, 9);

        txtf_nanotecnico.setMaxLength(20);
        vlInv.addComponent(txtf_nanotecnico, 5, 9);

        lbl_errNanotectino.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errNanotectino, 5, 10);
        txtf_nanotecnico.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!txtf_nanotecnico.getValue().equals("")) {
                    if (txtf_nanotecnico.getValue().matches(regexAlphaSpace)) {
                        txtf_nanotecnico.setComponentError(null);
                        lbl_errNanotectino.setValue("");
                    } else {
                        txtf_nanotecnico.setComponentError(new UserError(""));
                        lbl_errNanotectino.setValue("Este campo contiene caracteres no válidos");
                    }
                } else {
                    txtf_nanotecnico.setComponentError(new UserError(""));
                    lbl_errNanotectino.setValue("Este campo es requerido");
                }
                ValidarError();
            }
        });
        
        vlInv.addComponent(lbl_comisionCompra, 3, 11);
        lbl_asteriscoComisionCompra.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoComisionCompra, 4, 11);

        txtf_comisionCompra.setMaxLength(7);
        vlInv.addComponent(txtf_comisionCompra, 5, 11);

        lbl_errComisionCompra.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errComisionCompra, 5, 12);

        txtf_comisionCompra.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                   if (!txtf_comisionCompra.getValue().equals("")) {

                        if (txtf_comisionCompra.getValue().matches(regexNumericComaComision)) {
                            if (txtf_comisionCompra.getValue().matches(regexTresDecimales)) {
                                try {
                                    Double num = 0.0;
                                     Number valor = format3Comision.parse(txtf_comisionCompra.getValue());
                                    num = valor.doubleValue();
                                    if (num > 100) {
                                        txtf_comisionCompra.setComponentError(new UserError(""));
                                        lbl_errComisionCompra.setValue("Porcentaje no válido, debe ser entre 0% y 100%");

                                    }
                                    if (0 <= num && num <= 100) {
                                        txtf_comisionCompra.setValue(format3Comision.format(num));
                                        txtf_comisionCompra.setComponentError(null);
                                        lbl_errComisionCompra.setValue("");
                                    }
                                } catch (ParseException ex) {
                                    logger.error("OPA - " + CrearParametros.class.getName(), ex);
                                }
                            } else {
                                txtf_comisionCompra.setComponentError(new UserError(""));
                                lbl_errComisionCompra.setValue("El valor supera el máximo de decimales permitidos");
                            }

                        } else {

                            txtf_comisionCompra.setComponentError(new UserError(""));
                            lbl_errComisionCompra.setValue("Este campo contiene caracteres no válidos");
                        }
                    } else {
                    txtf_comisionCompra.setComponentError(new UserError(""));
                    lbl_errComisionCompra.setValue("Este campo es requerido");
                }
                ValidarError();
            }
        });

        //OPI
        vlInv.addComponent(lbl_umbral, 3, 13);
        lbl_astericoumbral.setStyleName("asterix");
        vlInv.addComponent(lbl_astericoumbral, 4, 13);

        txtf_umbral.setMaxLength(15);
        vlInv.addComponent(txtf_umbral, 5, 13);

        lbl_errumbral.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errumbral, 5, 14);

        txtf_umbral.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!txtf_umbral.getValue().equals("")) {
                    if (txtf_umbral.getValue().matches(regexNumericPunt)) {
                        Double valor = Double.parseDouble(txtf_umbral.getValue().replace(".", "").split("&")[0]);
                        txtf_umbral.setValue(form.format(valor));
                        txtf_umbral.setComponentError(null);
                        lbl_errumbral.setValue("");
                    } else {
                        txtf_umbral.setComponentError(new UserError(""));
                        lbl_errumbral.setValue("Este campo contiene caracteres no válidos");
                    }
                } else {
                    txtf_umbral.setComponentError(new UserError(""));
                    lbl_errumbral.setValue("Este campo es requerido");
                }
                ValidarError();
            }
        });
        
        
        /*INICIO Acciones en Circulación*/
        vlInv.addComponent(lbl_accionesEnCirculacion, 0, 11);
        lbl_asteriscoTextoCincuentaySiete.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoTextoCincuentaySiete, 1, 11);
        txtf_accionesEnCirculacion.setMaxLength(11);
        vlInv.addComponent(txtf_accionesEnCirculacion, 2, 11);
        lbl_errAccionesEnCirculacion.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errAccionesEnCirculacion, 2, 12);

                txtf_accionesEnCirculacion.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!txtf_accionesEnCirculacion.getValue().equals("")) {
                    if (txtf_accionesEnCirculacion.getValue().matches(regexNumericPunt)) {
                        if (EsEntero(txtf_accionesEnCirculacion.getValue())) {
                            try {
                                txtf_accionesEnCirculacion.setValue(moneyFormatter1.format(Double.parseDouble(txtf_accionesEnCirculacion.getValue().replace(".", "").split("&")[0])));
                                if ((!txtf_accionesEnCirculacion.getValue().toString().equalsIgnoreCase("0"))) {
                                    txtf_accionesEnCirculacion.setComponentError(null);
                                    lbl_errAccionesEnCirculacion.setValue("");
                                } else {
                                    txtf_accionesEnCirculacion.setComponentError(new UserError(""));
                                    lbl_errAccionesEnCirculacion.setValue("Número de Acciones en Circulación Invalido");
                                }
                            } catch (Validator.InvalidValueException e) {
                                txtf_accionesEnCirculacion.setComponentError(new UserError(""));
                                lbl_errAccionesEnCirculacion.setValue("Este campo contiene caracteres no válidos");
                                logger.error("OPA - " + CrearParametros.class.getName(), e);
                            }

                        } else {
                            txtf_accionesEnCirculacion.setComponentError(new UserError(""));
                            lbl_errAccionesEnCirculacion.setValue("Número de Acciones en Circulación Invalido");
                        }
                    } else {
                        txtf_accionesEnCirculacion.setComponentError(new UserError(""));
                        lbl_errAccionesEnCirculacion.setValue("Este campo contiene caracteres no válidos");
                    }
                } else {
                    txtf_accionesEnCirculacion.setComponentError(new UserError(""));
                    lbl_errAccionesEnCirculacion.setValue("Este campo es requerido");
                }
                ValidarError();
            }
        });
                
        /*fIN Acciones en Circulación*/
        vlInv.addComponent(lbl_precioaccionespago, 0, 13);
        lbl_asteriscoprecioaccionespago.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoprecioaccionespago, 1, 13);

        txtf_precioaccionespago.setMaxLength(14);
        vlInv.addComponent(txtf_precioaccionespago, 2, 13);

        lbl_errprecioaccionespago.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errprecioaccionespago, 2, 14);

        txtf_precioaccionespago.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!txtf_precioaccionespago.getValue().equals("")) {
                    String precioaccionespago = txtf_precioaccionespago.getValue();
                    if (precioaccionespago.contains(",")) {
                        if (precioaccionespago.matches(regexNumericPuntComa2)) {
                            if (EsDecimal(precioaccionespago)) {
                                try {
                                    Double num1 = 0.0;
                                    Number valor1 = form2.parse(txtf_precioaccionespago.getValue());
                                    num1 = valor1.doubleValue();
                                    txtf_precioaccionespago.setValue(form2.format(num1));
                                    txtf_precioaccionespago.setComponentError(null);
                                    lbl_errprecioaccionespago.setValue("");
                                } catch (ParseException ex) {
                                    logger.error("OPA - " + CrearParametros.class.getName(), ex);
                                }
                            } else {
                                txtf_precioaccionespago.setComponentError(new UserError(""));
                                lbl_errprecioaccionespago.setValue("Precio Invalido");
                            }
                        } else {
                            txtf_precioaccionespago.setComponentError(new UserError(""));
                            lbl_errprecioaccionespago.setValue("Este campo requiere dos decimales");
                        }
                        } else {
                            if (EsDecimal(precioaccionespago)) {

                            try {
                                Double num1 = 0.0;
                                Number valor1 = form2.parse(txtf_precioaccionespago.getValue());
                                num1 = valor1.doubleValue();
                                txtf_precioaccionespago.setValue(form2.format(num1));
                                txtf_precioaccionespago.setComponentError(null);
                                lbl_errprecioaccionespago.setValue("");
                            } catch (ParseException ex) {
                                logger.error("OPA - " + CrearParametros.class.getName(), ex);
                            }

                        } else {

                            txtf_precioaccionespago.setComponentError(new UserError(""));
                            lbl_errprecioaccionespago.setValue("Precio Inválido");
                        }
                    }

                } else {
                    txtf_precioaccionespago.setComponentError(new UserError(""));
                    lbl_errprecioaccionespago.setValue("Este campo es requerido");
                }                 
                        
                ValidarError();
            }
        });
        
        vlInv.addComponent(lbl_porcentajeefectivopago, 3, 15);
        lbl_astericoporcentajeefectivopago.setStyleName("asterix");
        vlInv.addComponent(lbl_astericoporcentajeefectivopago, 4, 15);

        txtf_porcentajeefectivopago.setMaxLength(3);
        //txtf_porcentajeefectivopago.setWidth(4, Sizeable.Unit.EM);
        //txtf_porcentajeefectivopago.setWidthUndefined();
        vlInv.addComponent(txtf_porcentajeefectivopago, 5, 15);
        vlInv.setComponentAlignment(txtf_porcentajeefectivopago, Alignment.MIDDLE_LEFT);

        /*
        lbl_porcentaje = new Label("%");
        lbl_porcentaje.setStyleName("lbl_porcentaje");
        vlInv.addComponent(lbl_porcentaje, 3, 13);
        vlInv.setComponentAlignment(lbl_porcentaje, Alignment.MIDDLE_LEFT);
         */
        lbl_errporcentajeefectivopago.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errporcentajeefectivopago, 5, 16);

        txtf_porcentajeefectivopago.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!txtf_porcentajeefectivopago.getValue().equals("")) {
                    if (txtf_porcentajeefectivopago.getValue().matches(regexNumeric)) {
                        int num = 0;
                        Number valor = Integer.parseInt(txtf_porcentajeefectivopago.getValue());
                        num = valor.intValue();
                        if (num > 100) {
                            txtf_porcentajeefectivopago.setComponentError(new UserError(""));
                            lbl_errporcentajeefectivopago.setValue("Porcentaje no válido, debe ser entre 0% y 100%");
                        }
                        if (0 <= num && num <= 100) {
                            String num1 = String.valueOf(num);
                            txtf_porcentajeefectivopago.setValue(num1);
                            txtf_porcentajeefectivopago.setComponentError(null);
                            lbl_errporcentajeefectivopago.setValue("");
                        }

                    } else {
                        txtf_porcentajeefectivopago.setComponentError(new UserError(""));
                        lbl_errporcentajeefectivopago.setValue("Este campo contiene caracteres no válidos");
                    }
                } else {
                    txtf_porcentajeefectivopago.setComponentError(new UserError(""));
                    lbl_errporcentajeefectivopago.setValue("Este campo es requerido");
                }
                ValidarError();
            }
        });

        vlInv.addComponent(lbl_porcentajeList, 0, 15);
        lbl_astericoporcentajeefectivopagoList.setStyleName("asterix");
        vlInv.addComponent(lbl_astericoporcentajeefectivopagoList, 1, 15);

        vlInv.addComponent(cbox_porcentajeList, 2, 15);
        lbl_errporcentajeefectivopagoList.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errporcentajeefectivopagoList, 2, 16);

        //Aqui van validaciones para el campo lista de selección de Manual o Predeterminada
        cbox_porcentajeList.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (cbox_porcentajeList.getValue() == null || cbox_porcentajeList.getValue().equals(0)) {
                    cbox_porcentajeList.setComponentError(new UserError(""));
                    lbl_errporcentajeefectivopagoList.setValue("Este campo es requerido");
                } else {
                    cbox_porcentajeList.setComponentError(null);
                    lbl_errporcentajeefectivopagoList.setValue("");
                }
                ValidarError();
            }
        });
        
        if(facade.countAceptacionesExists()>0){
            cbox_porcentajeList.setEnabled(Boolean.FALSE);
        }

        //Fin OPI
////////////////////////////////////////////////////////////////////////////////
        //Cabezera del segundo grupo        
        vlCab = new HorizontalLayout();
        vlCab.setWidth(97, Sizeable.Unit.PERCENTAGE);
        lbl_datosGeneralesDeLFormulario.setWidthUndefined();
        lbl_datosGeneralesDeLFormulario.setStyleName("tituloInversionistatit");
        Embedded imgEmb_datosGeneralesDeLFormulario = new Embedded(null, new ThemeResource("img/Inver.png"));
        imgEmb_datosGeneralesDeLFormulario.setStyleName("InverImg");
        imgEmb_datosGeneralesDeLFormulario.setHeight("35px");
        vlCab.addStyleName("tituloInversionista");
        vlCab.addComponent(imgEmb_datosGeneralesDeLFormulario);
        vlCab.addComponent(lbl_datosGeneralesDeLFormulario);
        vlCab.setComponentAlignment(lbl_datosGeneralesDeLFormulario, Alignment.MIDDLE_CENTER);
        vlInv.addComponent(vlCab, 0, 17, 6, 17);
////////////////////////////////////////////////////////////////////////////////
        //Sexta fila de controles

        vlInv.addComponent(lbl_numeroDeLaAceptacion, 0, 18);

        vlInv.addComponent(txtf_numeroDeAceptacion, 2, 18);

        lbl_errNumeroDeLaAceptacion.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errNumeroDeLaAceptacion, 2, 19);

        txtf_numeroDeAceptacion.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {

                if (txtf_numeroDeAceptacion.getValue()) {
                    ConfirmDialog.show(getUI(), "Confirmación", "¿Desea reiniciar el consecutivo a 1 para el N° de aceptación?", "ACEPTAR",
                            "CANCELAR", new ConfirmDialog.Listener() {
                        @Override
                        public void onClose(ConfirmDialog dialog) {
                            if (dialog.isConfirmed()) {

                            } else {
                                txtf_numeroDeAceptacion.setValue(false);
                            }

                        }
                    });
                }
            }
        });

        vlInv.addComponent(lbl_cantRpt, 3, 18);
        lbl_asteriscoCantRpt.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoCantRpt, 4, 18);

        vlInv.addComponent(txtf_cantRpt, 5, 18);
        txtf_cantRpt.setMaxLength(2);

        lbl_errCantRpt.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errCantRpt, 5, 19);

        txtf_cantRpt.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!txtf_cantRpt.getValue().equals("")) {
                    if (txtf_cantRpt.getValue().matches(regexNumeric)) {
                        txtf_cantRpt.setComponentError(null);
                        lbl_errCantRpt.setValue("");
                    } else {
                        txtf_cantRpt.setComponentError(new UserError(""));
                        lbl_errCantRpt.setValue("Este campo contiene caracteres no válidos");
                    }
                } else {
                    txtf_cantRpt.setComponentError(new UserError(""));
                    lbl_errCantRpt.setValue("Este campo es requerido");
                }
                ValidarError();
            }
        });

////////////////////////////////////////////////////////////////////////////////
        //septima fila de controles  
        vlInv.addComponent(lbl_textoUno, 0, 20);
        lbl_asteriscoTextoUno.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoTextoUno, 1, 20);

        txta_textoUno.setMaxLength(600);
        txta_textoUno.setWidth(97, Sizeable.Unit.PERCENTAGE);

        vlInv.addComponent(txta_textoUno, 2, 20, 5, 20);

        lbl_errTextoUno.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errTextoUno, 2, 21);

        txta_textoUno.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!txta_textoUno.getValue().equals("")) {

                    txta_textoUno.setComponentError(null);
                    lbl_errTextoUno.setValue("");

                } else {
                    txta_textoUno.setComponentError(new UserError(""));
                    lbl_errTextoUno.setValue("Este campo es requerido");
                }
                ValidarError();
            }
        });
////////////////////////////////////////////////////////////////////////////////        
        //octava fila de controles

        vlInv.addComponent(lbl_textoDos, 0, 22);
        lbl_asteriscoTextoDos.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoTextoDos, 1, 22);

        txta_textoDos.setMaxLength(600);
        txta_textoDos.setWidth(97, Sizeable.Unit.PERCENTAGE);
        vlInv.addComponent(txta_textoDos, 2, 22, 5, 22);

        lbl_errTextoDos.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errTextoDos, 2, 23);

        txta_textoDos.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!txta_textoDos.getValue().equals("")) {
                    txta_textoDos.setComponentError(null);
                    lbl_errTextoDos.setValue("");
                } else {
                    txta_textoDos.setComponentError(new UserError(""));
                    lbl_errTextoDos.setValue("Este campo es requerido");
                }
                ValidarError();
            }
        });

////////////////////////////////////////////////////////////////////////////////
        //Novena fila de controles
        vlInv.addComponent(lbl_vendeTN, 0, 24);
        lbl_asteriscoVendeTN.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoVendeTN, 1, 24);

        vlInv.addComponent(cbox_vendeTN, 2, 24);

        lbl_errVendeTN.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errVendeTN, 2, 25);

        cbox_vendeTN.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (cbox_vendeTN.getValue() == null || cbox_vendeTN.getValue().equals(0)) {
                    cbox_vendeTN.setComponentError(new UserError(""));
                    lbl_errVendeTN.setValue("Este campo es requerido");
                } else {
                    cbox_vendeTN.setComponentError(null);
                    lbl_errVendeTN.setValue("");
                }
                ValidarError();
            }
        });

        cbox_vendeTN.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {

                if (!cbox_vendeTN.getValue().equals(0)) {
                    ConfirmDialog.show(getUI(), "Confirmación", "¿Desea activar/desactivar el campo para mostrarlo en el formulario?", "ACEPTAR",
                            "CANCELAR", new ConfirmDialog.Listener() {
                        @Override
                        public void onClose(ConfirmDialog dialog) {
                            if (dialog.isConfirmed()) {

                            } else {
                                cbox_vendeTN.select(0);
                            }

                        }
                    });
                }

            }
        });

        vlInv.addComponent(lbl_existePrecacuerdo, 3, 24);
        lbl_asteriscoExistePreacuerdo.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoExistePreacuerdo, 4, 24);

        vlInv.addComponent(cbox_existePreacuerdo, 5, 24);

        lbl_errExistePreacuerdo.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errExistePreacuerdo, 5, 25);

        cbox_existePreacuerdo.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {

                if (!cbox_existePreacuerdo.getValue().equals(0)) {
                    ConfirmDialog.show(getUI(), "Confirmación", "¿Desea activar/desactivar el campo para mostrarlo en el formulario?", "ACEPTAR",
                            "CANCELAR", new ConfirmDialog.Listener() {
                        @Override
                        public void onClose(ConfirmDialog dialog) {
                            if (dialog.isConfirmed()) {

                            } else {
                                cbox_existePreacuerdo.select(0);
                            }

                        }
                    });
                }

            }
        });

        cbox_existePreacuerdo.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (cbox_existePreacuerdo.getValue() == null || cbox_existePreacuerdo.getValue().equals(0)) {
                    cbox_existePreacuerdo.setComponentError(new UserError(""));
                    lbl_errExistePreacuerdo.setValue("Este campo es requerido");
                } else {
                    cbox_existePreacuerdo.setComponentError(null);
                    lbl_errExistePreacuerdo.setValue("");
                }
                ValidarError();
            }
        });

////////////////////////////////////////////////////////////////////////////////
        //Decima fila de controles
        vlInv.addComponent(lbl_cantUsOp, 0, 26);
        lbl_asteriscoCantUsOp.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoCantUsOp, 1, 26);

        txtf_cantUsOp.setMaxLength(3);
        vlInv.addComponent(txtf_cantUsOp, 2, 26);
        lbl_errCantUsOp.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errCantUsOp, 2, 27);

        txtf_cantUsOp.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!txtf_cantUsOp.getValue().equals("")) {
                    if (txtf_cantUsOp.getValue().matches(regexNumeric)) {
                        txtf_cantUsOp.setComponentError(null);
                        lbl_errCantUsOp.setValue("");
                    } else {
                        txtf_cantUsOp.setComponentError(new UserError(""));
                        lbl_errCantUsOp.setValue("Este campo contiene caracteres no válidos");
                    }
                } else {
                    txtf_cantUsOp.setComponentError(new UserError(""));
                    lbl_errCantUsOp.setValue("Este campo es requerido");
                }
                ValidarError();
            }
        });

        //Campos de Dirección
        vlInv.addComponent(lbl_habilitarDireccion, 3, 26);
        lbl_asteriscoHabilitarDireccion.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoHabilitarDireccion, 4, 26);

        vlInv.addComponent(cbox_direccion, 5, 26);
        lbl_errdireccion.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errdireccion, 5, 27);

        cbox_direccion.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (cbox_direccion.getValue() == null || cbox_direccion.getValue().equals(0)) {
                    cbox_direccion.setComponentError(new UserError(""));
                    lbl_errdireccion.setValue("Este campo es requerido");
                } else {
                    cbox_direccion.setComponentError(null);
                    lbl_errdireccion.setValue("");
                }
                ValidarError();
            }
        });

////////////////////////////////////////////////////////////////////////////////
        //Cabezera del tercer grupo        
        vlCab = new HorizontalLayout();
        vlCab.setWidth(97, Sizeable.Unit.PERCENTAGE);
        lbl_datosGeneralesDeLOferente.setWidthUndefined();
        lbl_datosGeneralesDeLOferente.setStyleName("tituloInversionistatit");
        Embedded imgEmb_datosGeneralesDeLOferente = new Embedded(null, new ThemeResource("img/Inver.png"));
        imgEmb_datosGeneralesDeLOferente.setStyleName("InverImg");
        imgEmb_datosGeneralesDeLOferente.setHeight("35px");
        vlCab.addStyleName("tituloInversionista");
        vlCab.addComponent(imgEmb_datosGeneralesDeLOferente);
        vlCab.addComponent(lbl_datosGeneralesDeLOferente);
        vlCab.setComponentAlignment(lbl_datosGeneralesDeLOferente, Alignment.MIDDLE_CENTER);
        vlInv.addComponent(vlCab, 0, 28, 6, 28);
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
        //Onceava fila de controles
        vlInv.addComponent(lbl_tipoDocumentoOferente, 0, 29);
        lbl_asteriscoTipoDocumentoOferente.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoTipoDocumentoOferente, 1, 29);
        vlInv.addComponent(cmb_TipoDocumentoOferente, 2, 29);
        lbl_errTipoDocumentoOferente.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errTipoDocumentoOferente, 2, 30);

        cmb_TipoDocumentoOferente.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {

                try {
                    valorCombo = (Integer) cmb_TipoDocumentoOferente.getValue();
                } catch (NullPointerException e) {
                    valorCombo = 0;
                } catch (ClassCastException ex) {
                    valorCombo = 0;
                }
                txtf_DVOferente.setVisible(false);
                if (valorCombo == 4) {
                    txtf_DVOferente.setVisible(true);
                    txtf_EFOferente.setEnabled(true);
                    txtf_DVOferente.setValue("");
                } else {
                    txtf_DVOferente.setVisible(false);
                    txtf_EFOferente.setEnabled(false);
                }
                if (cmb_TipoDocumentoOferente.getValue() == null || cmb_TipoDocumentoOferente.getValue().equals("")) {
                    cmb_TipoDocumentoOferente.setComponentError(new UserError(""));
                    lbl_errTipoDocumentoOferente.setValue("Este campo es requerido");
                } else {
                    cmb_TipoDocumentoOferente.setComponentError(null);
                    lbl_errTipoDocumentoOferente.setValue("");
                }
                if (valorCombo == 1 || valorCombo == 4 || valorCombo == 6) {
                    if (!txtf_numeroDocumentoOferente.getValue().matches(regexNumeric)) {
                        txtf_numeroDocumentoOferente.setComponentError(new UserError(""));
                        lbl_errNumeroDocumentoOferente.setValue("Este campo contiene caracteres no válidos");
                    }
                    if (valorCombo != 4) {
                        txtf_DVOferente.setVisible(false);
                        txtf_DVOferente.setValue("");
                        txtf_DVOferente.setComponentError(null);
                        lbl_errDVOferente.setValue("");

                        txtf_EFOferente.setEnabled(false);
                        txtf_EFOferente.setValue("");
                        txtf_EFOferente.setComponentError(null);
                        lbl_errEFOferente.setValue("");

                    }

                } else {
                    txtf_DVOferente.setVisible(false);
                    txtf_DVOferente.setValue("");
                    txtf_DVOferente.setComponentError(null);
                    lbl_errDVOferente.setValue("");
                    txtf_DVOferente.setComponentError(null);
                    txtf_numeroDocumentoOferente.setComponentError(null);
                    lbl_errNumeroDocumentoOferente.setValue("");
                    txtf_numeroDocumentoOferente.setComponentError(null);
                    txtf_EFOferente.setEnabled(false);
                    txtf_EFOferente.setValue("");
                    txtf_EFOferente.setComponentError(null);
                    lbl_errEFOferente.setValue("");

                }
                ValidarError();
            }
        });

        txtf_numeroDocumentoOferente.setMaxLength(15);
        vlInv.addComponent(lbl_numeroDocumentoOferente, 3, 29);
        lbl_asteriscoNumeroDocumentoOferente.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoNumeroDocumentoOferente, 4, 29);
        vlInv.addComponent(txtf_numeroDocumentoOferente, 5, 29);
        lbl_errNumeroDocumentoOferente.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errNumeroDocumentoOferente, 5, 30);

        txtf_numeroDocumentoOferente.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {
                try {
                    valorCombo = (Integer) cmb_TipoDocumentoOferente.getValue();
                } catch (NullPointerException ex) {
                    valorCombo = 0;
                } catch (ClassCastException e) {
                    valorCombo = 0;
                }
                txtf_numeroDocumentoOferente.setComponentError(null);
                lbl_errNumeroDocumentoOferente.setValue("");
                if (txtf_numeroDocumentoOferente.getValue().equals("")) {
                    txtf_numeroDocumentoOferente.setComponentError(new UserError(""));
                    lbl_errNumeroDocumentoOferente.setValue("Este campo es requerido");
                }
                if (valorCombo == 2 || valorCombo == 3 || valorCombo == 5) {
                    if (!txtf_numeroDocumentoOferente.getValue().matches(regexAlpha)) {
                        txtf_numeroDocumentoOferente.setComponentError(new UserError(""));
                        lbl_errNumeroDocumentoOferente.setValue("Este campo contiene caracteres no válidos");
                    }
                } else {
                    if (!txtf_numeroDocumentoOferente.getValue().matches(regexNumeric)) {
                        txtf_numeroDocumentoOferente.setComponentError(new UserError(""));
                        lbl_errNumeroDocumentoOferente.setValue("Este campo contiene caracteres no válidos");
                    }
                }
                if (valorCombo == 4) {
                    if (validacion.validarRut(txtf_numeroDocumentoOferente.getValue()) != Integer.parseInt(txtf_DVOferente.getValue().equals("") ? "0" : txtf_DVOferente.getValue())) {
                        txtf_DVOferente.setComponentError(new UserError(""));
                        lbl_errDVOferente.setValue("El dígito de verificación ingresado no corresponde al NIT.");
                    }
                } else {
                    txtf_DVOferente.setComponentError(null);
                    lbl_errDVOferente.setValue("");
                }
                ValidarError();
            }
        });

        txtf_DVOferente.setMaxLength(1);

        vlInv.addComponent(txtf_DVOferente, 6, 29);
        vlInv.setComponentAlignment(txtf_DVOferente, Alignment.TOP_LEFT);
        lbl_errDVOferente.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errDVOferente, 6, 30);

        txtf_DVOferente.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {
                txtf_DVOferente.setValue(txtf_DVOferente.getValue().trim());
                txtf_DVOferente.setComponentError(null);
                lbl_errDVOferente.setValue("");
                valorCombo = Integer.parseInt(cmb_TipoDocumentoOferente.getValue().toString());

                if (!txtf_DVOferente.getValue().equals("")) {
                    if (valorCombo == 2 || valorCombo == 3 || valorCombo == 5) {
                        if (!txtf_DVOferente.getValue().matches(regexAlpha)) {
                            txtf_DVOferente.setComponentError(new UserError(""));
                            lbl_errDVOferente.setValue("Este campo contiene caracteres no válidos");
                        } else if (!txtf_numeroDocumentoOferente.getValue().equals("")) {
                            if (validacion.validarRut(txtf_numeroDocumentoOferente.getValue()) != Integer.parseInt(txtf_DVOferente.getValue().equals("") ? "0" : txtf_DVOferente.getValue())) {
                                txtf_DVOferente.setComponentError(new UserError(""));
                                lbl_errDVOferente.setValue("El dígito de verificación ingresado no corresponde al NIT.");
                            } else {
                                txtf_DVOferente.setComponentError(null);
                                lbl_errDVOferente.setValue("");
                            }
                        }
                    } else {
                        if (!txtf_DVOferente.getValue().matches(regexNumeric)) {
                            txtf_DVOferente.setComponentError(new UserError(""));
                            lbl_errDVOferente.setValue("Este campo contiene caracteres no válidos");
                        } else if (!txtf_numeroDocumentoOferente.getValue().equals("")) {
                            if (validacion.validarRut(txtf_numeroDocumentoOferente.getValue()) != Integer.parseInt(txtf_DVOferente.getValue().equals("") ? "0" : txtf_DVOferente.getValue())) {
                                txtf_DVOferente.setComponentError(new UserError(""));
                                lbl_errDVOferente.setValue("El dígito de verificación ingresado no corresponde al NIT.");
                            } else {
                                txtf_DVOferente.setComponentError(null);
                                lbl_errDVOferente.setValue("");
                            }
                        }

                    }
                } else {
                    txtf_DVOferente.setComponentError(new UserError(""));
                    lbl_errDVOferente.setValue("Este campo es requerido");
                }
                ValidarError();
            }
        });
        // txtf_DVOferente.setId("txtIden");
        txtf_DVOferente.setWidth(2, Sizeable.Unit.EM);

////////////////////////////////////////////////////////////////////////////////        
////////////////////////////////////////////////////////////////////////////////
        //Doceava fila de controles
        txtf_EFOferente.setMaxLength(3);
        vlInv.addComponent(lbl_EFOferente, 0, 31);
        lbl_asteriscoEFOferente.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoEFOferente, 1, 31);
        vlInv.addComponent(txtf_EFOferente, 2, 31);
        lbl_errEFOferente.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errEFOferente, 2, 32);

        txtf_EFOferente.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!txtf_EFOferente.getValue().equals("")) {
                    if (txtf_EFOferente.getValue().matches(regexAlpha)) {
                        txtf_EFOferente.setComponentError(null);
                        lbl_errEFOferente.setValue("");
                    } else {
                        txtf_EFOferente.setComponentError(new UserError(""));
                        lbl_errEFOferente.setValue("Este campo contiene caracteres no válidos");
                    }
                } else {
                    txtf_EFOferente.setComponentError(null);
                    lbl_errEFOferente.setValue("");
                }
                ValidarError();
            }
        });

        txtf_cuentaDecevalOferente.setMaxLength(8);
        vlInv.addComponent(lbl_cuentaDecevalOferente, 3, 31);
        lbl_asteriscoCuentaDecevalOferente.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoCuentaDecevalOferente, 4, 31);
        vlInv.addComponent(txtf_cuentaDecevalOferente, 5, 31);
        lbl_errCuentaDecevalOferente.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errCuentaDecevalOferente, 5, 32);

        txtf_cuentaDecevalOferente.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!txtf_cuentaDecevalOferente.getValue().equals("")) {
                    if (txtf_cuentaDecevalOferente.getValue().matches(regexNumeric)) {
                        if (Integer.parseInt(txtf_cuentaDecevalOferente.getValue()) > 0) {
                            txtf_cuentaDecevalOferente.setComponentError(null);
                            lbl_errCuentaDecevalOferente.setValue("");
                        } else {
                            txtf_cuentaDecevalOferente.setComponentError(new UserError(""));
                            lbl_errCuentaDecevalOferente.setValue("Cuenta inversionista inválida");
                        }
                    } else {
                        txtf_cuentaDecevalOferente.setComponentError(new UserError(""));
                        lbl_errCuentaDecevalOferente.setValue("Este campo contiene caracteres no válidos");
                    }
                } else {
                    txtf_cuentaDecevalOferente.setComponentError(new UserError(""));
                    lbl_errCuentaDecevalOferente.setValue("Este campo es requerido");
                }
                ValidarError();
            }
        });

////////////////////////////////////////////////////////////////////////////////        
////////////////////////////////////////////////////////////////////////////////
        //Trece Trigesima fila de controles
        vlInv.addComponent(lbl_scbOferente, 0, 33);
        lbl_asteriscoScbOferente.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoScbOferente, 1, 33);

        vlInv.addComponent(cmb_scbOferente, 2, 33);

        lbl_errScbOferente.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errScbOferente, 2, 34);

        cmb_scbOferente.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (cmb_scbOferente.getValue() == null || cmb_scbOferente.getValue().equals("")) {
                    cmb_scbOferente.setComponentError(new UserError(""));
                    lbl_errScbOferente.setValue("Este campo es requerido");
                } else {
                    cmb_scbOferente.setComponentError(null);
                    lbl_errScbOferente.setValue("");
                }
                ValidarError();
            }
        });

        //Campo MILA
        vlInv.addComponent(lbl_MILA, 3, 33);
        lbl_asteriscoMILA.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoMILA, 4, 33);

        vlInv.addComponent(cbox_MILA, 5, 33);
        lbl_errMILA.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errMILA, 5, 34);

        cbox_MILA.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (cbox_MILA.getValue() == null || cbox_MILA.getValue().equals(0)) {
                    cbox_MILA.setComponentError(new UserError(""));
                    lbl_errMILA.setValue("Este campo es requerido");
                } else {
                    cbox_MILA.setComponentError(null);
                    lbl_errMILA.setValue("");
                }
                ValidarError();
            }
        });

        
        txtf_ReferenciaComprador.setMaxLength(8);
        vlInv.addComponent(lbl_ReferenteComprador, 0, 35);
        vlInv.addComponent(txtf_ReferenciaComprador, 2, 35);
        lbl_errReferenciaComprador.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errReferenciaComprador, 2, 36);

        txtf_ReferenciaComprador.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!txtf_ReferenciaComprador.getValue().equals("")) {
                    if (txtf_ReferenciaComprador.getValue().matches(regexAlphaMay)) {
                        txtf_ReferenciaComprador.setValue(txtf_ReferenciaComprador.getValue().toUpperCase());
                        txtf_ReferenciaComprador.setComponentError(null);
                        lbl_errReferenciaComprador.setValue("");
                    } else {
                        txtf_ReferenciaComprador.setComponentError(new UserError(""));
                        lbl_errReferenciaComprador.setValue("Este campo contiene caracteres no válidos");
                    }
                } else {
                    txtf_ReferenciaComprador.setComponentError(null);
                    lbl_errReferenciaComprador.setValue("");
                }
                ValidarError();
            }
        });


        ////////////////////////////////////////////////////////////////////////////////
        //CARGA MASIVA       
        vlCab = new HorizontalLayout();
        vlCab.setWidth(97, Sizeable.Unit.PERCENTAGE);
        lbl_datosGeneralesCargaMasiva.setWidthUndefined();
        lbl_datosGeneralesCargaMasiva.setStyleName("tituloInversionistatit");
        Embedded imgEmb_datosGeneralesCargaMasiva = new Embedded(null, new ThemeResource("img/Inver.png"));
        imgEmb_datosGeneralesCargaMasiva.setStyleName("InverImg");
        imgEmb_datosGeneralesCargaMasiva.setHeight("35px");
        vlCab.addStyleName("tituloInversionista");
        vlCab.addComponent(imgEmb_datosGeneralesCargaMasiva);
        vlCab.addComponent(lbl_datosGeneralesCargaMasiva);
        vlCab.setComponentAlignment(lbl_datosGeneralesCargaMasiva, Alignment.MIDDLE_CENTER);
        vlInv.addComponent(vlCab, 0, 37, 6, 37);

        //Primera fila de controles masivos
        //Hora inicio carga masiva
        vlInv.addComponent(lbl_horaInicioOperacionCarga, 0, 38);
        lbl_asteriscoHoraInicioOperacionCarga.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoHoraInicioOperacionCarga, 1, 38);

        txtf_horaInicioOperacionCarga.setMaxLength(8);
        vlInv.addComponent(txtf_horaInicioOperacionCarga, 2, 38);

        txtf_horaInicioOperacionCarga.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (txtf_horaInicioOperacionCarga.getValue().equals("")) {
                    txtf_horaInicioOperacionCarga.setComponentError(new UserError(""));
                    lbl_errHoraInicioOperacionCarga.setValue("Este campo es requerido");
                } else {
                    if (txtf_horaInicioOperacionCarga.getValue().matches(regexHora)) {
                        txtf_horaInicioOperacionCarga.setComponentError(null);
                        lbl_errHoraInicioOperacionCarga.setValue("");
                    } else {
                        txtf_horaInicioOperacionCarga.setComponentError(new UserError(""));
                        lbl_errHoraInicioOperacionCarga.setValue("El formato de la hora inicio no es válido");
                    }

                }
                ValidarError();
            }
        });
        lbl_errHoraInicioOperacionCarga.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errHoraInicioOperacionCarga, 2, 39);

        //Hora Fin carga masiva
        vlInv.addComponent(lbl_horaFinOperacionCarga, 3, 38);
        lbl_asteriscoHoraFinOperacionCarga.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoHoraFinOperacionCarga, 4, 38);

        txtf_horaFinOperacionCarga.setMaxLength(8);
        vlInv.addComponent(txtf_horaFinOperacionCarga, 5, 38);
        //--      
        txtf_horaFinOperacionCarga.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (txtf_horaFinOperacionCarga.getValue().equals("")) {
                    txtf_horaFinOperacionCarga.setComponentError(new UserError(""));
                    lbl_errHoraFinOperacionCarga.setValue("Este campo es requerido");
                } else {
                    if (txtf_horaFinOperacionCarga.getValue().matches(regexHora)) {
                        txtf_horaFinOperacionCarga.setComponentError(null);
                        lbl_errHoraFinOperacionCarga.setValue("");
                    } else {
                        txtf_horaFinOperacionCarga.setComponentError(new UserError(""));
                        lbl_errHoraFinOperacionCarga.setValue("El formato de la hora fin no es válido");
                    }

                }
                ValidarError();
            }
        });

        lbl_errHoraFinOperacionCarga.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errHoraFinOperacionCarga, 5, 39);
////////////////////////////////////////////////////////////////////////////////        

        vlInv.addComponent(lbl_ActivarCm, 0, 40);
        lbl_asteriscoActivarCm.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoActivarCm, 1, 40);

        vlInv.addComponent(cbox_activarCm, 2, 40);

        lbl_errActivarCm.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errActivarCm, 2, 41);

        cbox_activarCm.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (cbox_activarCm.getValue() == null || cbox_activarCm.getValue().equals(0)) {
                    cbox_activarCm.setComponentError(new UserError(""));
                    lbl_errActivarCm.setValue("Este campo es requerido");
                } else {
                    cbox_activarCm.setComponentError(null);
                    lbl_errActivarCm.setValue("");
                }
                ValidarError();
            }
        });

        cbox_activarCm.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {

                if (!cbox_activarCm.getValue().equals(0)) {
                    ConfirmDialog.show(getUI(), "Confirmación", "¿Desea activar o inactivar el módulo de carga masiva de aceptaciones para los operadores SCB?", "ACEPTAR",
                            "CANCELAR", new ConfirmDialog.Listener() {
                        @Override
                        public void onClose(ConfirmDialog dialog) {
                            if (dialog.isConfirmed()) {

                            } else {
                                cbox_activarCm.select(0);
                            }

                        }
                    });
                }

            }
        });

        // BOLETIN INFORMATIVO
        vlCab = new HorizontalLayout();
        vlCab.setWidth(97, Sizeable.Unit.PERCENTAGE);
        lbl_datosGeneralesBoletinInfo.setWidthUndefined();
        lbl_datosGeneralesBoletinInfo.setStyleName("tituloInversionistatit");
        Embedded imgEmb_datosGeneralesBoletinInfo = new Embedded(null, new ThemeResource("img/Inver.png"));
        imgEmb_datosGeneralesBoletinInfo.setStyleName("InverImg");
        imgEmb_datosGeneralesBoletinInfo.setHeight("35px");
        vlCab.addStyleName("tituloInversionista");
        vlCab.addComponent(imgEmb_datosGeneralesBoletinInfo);
        vlCab.addComponent(lbl_datosGeneralesBoletinInfo);
        vlCab.setComponentAlignment(lbl_datosGeneralesBoletinInfo, Alignment.MIDDLE_CENTER);
        vlInv.addComponent(vlCab, 0, 42, 6, 42);

        //Acciones negociadas Boletin Informativo
        vlInv.addComponent(lbl_AccionesNegociadas, 0, 43);
        lbl_asteriscoAccionesNegociadas.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoAccionesNegociadas, 1, 43);

        txta_AccionesNegociadas.setMaxLength(30);
        // txta_AccionesNegociadas.setHeight(100,Sizeable.Unit.PERCENTAGE);
        vlInv.addComponent(txta_AccionesNegociadas, 2, 43);

        lbl_errAccionesNegociadas.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errAccionesNegociadas, 2, 44);

        txta_AccionesNegociadas.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (txta_AccionesNegociadas.getValue().equals("")) {
                    txta_AccionesNegociadas.setComponentError(new UserError(""));
                    lbl_errAccionesNegociadas.setValue("Este campo es requerido");
                } else {
                    txta_AccionesNegociadas.setComponentError(null);
                    lbl_errAccionesNegociadas.setValue("");

                }
                ValidarError();
            }
        });

        // Texto Boletín Informativo        
        vlInv.addComponent(lbl_TextoBoletinInfo, 0, 45);
        lbl_asteriscoTextoBoletinInfo.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoTextoBoletinInfo, 1, 45);

        txta_TextoBoletinInfo.setMaxLength(700);
        txta_TextoBoletinInfo.setWidth(97, Sizeable.Unit.PERCENTAGE);
        vlInv.addComponent(txta_TextoBoletinInfo, 2, 45, 5, 45);

        lbl_errTextoBoletinInfo.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errTextoBoletinInfo, 2, 46);

        txta_TextoBoletinInfo.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (txta_TextoBoletinInfo.getValue().equals("")) {
                    txta_TextoBoletinInfo.setComponentError(new UserError(""));
                    lbl_errTextoBoletinInfo.setValue("Este campo es requerido");
                } else {
                    txta_TextoBoletinInfo.setComponentError(null);
                    lbl_errTextoBoletinInfo.setValue("");

                }
                ValidarError();
            }
        });
        
        // Texto Boletín Informativo        
        vlInv.addComponent(lbl_TextBulletinInfo, 0, 47);
        lbl_asteriscoTextBulletinInfo.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoTextBulletinInfo, 1, 47);

        txta_TextBulletinInfo.setMaxLength(700);
        txta_TextBulletinInfo.setWidth(97, Sizeable.Unit.PERCENTAGE);
        vlInv.addComponent(txta_TextBulletinInfo, 2, 47, 5, 47);

        lbl_errTextBulletinInfo.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errTextBulletinInfo, 2, 48);

        txta_TextBulletinInfo.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (txta_TextBulletinInfo.getValue().equals("")) {
                    txta_TextBulletinInfo.setComponentError(new UserError(""));
                    lbl_errTextBulletinInfo.setValue("Este campo es requerido");
                } else {
                    txta_TextBulletinInfo.setComponentError(null);
                    lbl_errTextBulletinInfo.setValue("");

                }
                ValidarError();
            }
        });

       // Recalculo montos con el precio incluido        
        vlInv.addComponent(label_recalculo, 0, 49);
        vlInv.addComponent(check_recalculo, 2, 49); 


        //Cabezera del Quinto grupo        
        vlCab = new HorizontalLayout();
        vlCab.setWidth(97, Sizeable.Unit.PERCENTAGE);
        lbl_datosGeneralesAceptacionOPA.setWidthUndefined();
        lbl_datosGeneralesAceptacionOPA.setStyleName("tituloInversionistatit");
        Embedded imgEmb_datosGeneralesAceptacionOPA = new Embedded(null, new ThemeResource("img/Inver.png"));
        imgEmb_datosGeneralesAceptacionOPA.setStyleName("InverImg");
        imgEmb_datosGeneralesAceptacionOPA.setHeight("35px");
        vlCab.addStyleName("tituloInversionista");
        vlCab.addComponent(imgEmb_datosGeneralesAceptacionOPA);
        vlCab.addComponent(lbl_datosGeneralesAceptacionOPA);
        vlCab.setComponentAlignment(lbl_datosGeneralesAceptacionOPA, Alignment.MIDDLE_CENTER);
        vlInv.addComponent(vlCab, 0, 50, 6, 50);

        //Se agrega las condiciones de la emison para OPI: 
        vlInv.addComponent(lbl_textoTres, 0, 51);
        lbl_asteriscoTextoTres.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoTextoTres, 1, 51);

        txta_textoTres.setMaxLength(600);
        txta_textoTres.setWidth(97, Sizeable.Unit.PERCENTAGE);

        vlInv.addComponent(txta_textoTres, 2, 51, 5, 51);

        lbl_errTextoTres.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errTextoTres, 2, 52);

        txta_textoTres.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!txta_textoTres.getValue().equals("")) {
                    txta_textoTres.setComponentError(null);
                    lbl_errTextoTres.setValue("");
                } else {
                    txta_textoTres.setComponentError(new UserError(""));
                    lbl_errTextoTres.setValue("Este campo es requerido");
                }
                ValidarError();
            }
        });

        vlInv.addComponent(lbl_textoCuatro, 0, 53);
        lbl_asteriscoTextoCuatro.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoTextoCuatro, 1, 53);

        txta_textoCuatro.setMaxLength(600);
        txta_textoCuatro.setWidth(97, Sizeable.Unit.PERCENTAGE);
        vlInv.addComponent(txta_textoCuatro, 2, 53, 5, 53);

        lbl_errTextoCuatro.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errTextoCuatro, 2, 54);

        txta_textoCuatro.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!txta_textoCuatro.getValue().equals("")) {
                    txta_textoCuatro.setComponentError(null);
                    lbl_errTextoCuatro.setValue("");
                } else {
                    txta_textoCuatro.setComponentError(new UserError(""));
                    lbl_errTextoCuatro.setValue("Este campo es requerido");
                }
                ValidarError();
            }
        });

        vlInv.addComponent(lbl_textoCinco, 0, 55);
        lbl_asteriscoTextoCinco.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoTextoCinco, 1, 55);

        txta_textoCinco.setMaxLength(600);
        txta_textoCinco.setWidth(97, Sizeable.Unit.PERCENTAGE);
        vlInv.addComponent(txta_textoCinco, 2, 55, 5, 55);

        lbl_errTextoCinco.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errTextoCinco, 2, 56);

        txta_textoCinco.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!txta_textoCinco.getValue().equals("")) {
                    txta_textoCinco.setComponentError(null);
                    lbl_errTextoCinco.setValue("");
                } else {
                    txta_textoCinco.setComponentError(new UserError(""));
                    lbl_errTextoCinco.setValue("Este campo es requerido");
                }
                ValidarError();
            }
        });

        vlInv.addComponent(lbl_textoSeis, 0, 57);
        lbl_asteriscoTextoSeis.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoTextoSeis, 1, 57);

        txta_textoSeis.setMaxLength(600);
        txta_textoSeis.setWidth(97, Sizeable.Unit.PERCENTAGE);
        vlInv.addComponent(txta_textoSeis, 2, 57, 5, 57);

        lbl_errTextoSeis.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errTextoSeis, 2, 58);

        txta_textoSeis.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!txta_textoSeis.getValue().equals("")) {
                    txta_textoSeis.setComponentError(null);
                    lbl_errTextoSeis.setValue("");
                } else {
                    txta_textoSeis.setComponentError(new UserError(""));
                    lbl_errTextoSeis.setValue("Este campo es requerido");
                }
                ValidarError();
            }
        });

        vlInv.addComponent(lbl_textoSiete, 0, 59);
        lbl_asteriscoTextoSiete.setStyleName("asterix");
        vlInv.addComponent(lbl_asteriscoTextoSiete, 1, 59);

        txta_textoSiete.setMaxLength(640);
        txta_textoSiete.setWidth(97, Sizeable.Unit.PERCENTAGE);
        vlInv.addComponent(txta_textoSiete, 2, 59, 5, 59);

        lbl_errTextoSiete.setStyleName("lblerrores");
        vlInv.addComponent(lbl_errTextoSiete, 2, 60);
        
        txta_textoSiete.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!txta_textoSiete.getValue().equals("")) {
                    txta_textoSiete.setComponentError(null);
                    lbl_errTextoSiete.setValue("");
                } else {
                    txta_textoSiete.setComponentError(new UserError(""));
                    lbl_errTextoSiete.setValue("Este campo es requerido");
                }
                ValidarError();
            }
        });

        //DBABATIVA STARTS
        //Iniciar el Modal de selección de tipo de Oferta pública
        modal = new Window("Seleccione el Tipo de Oferta Pública");
        modal.setModal(true);
        modal.setClosable(false);
        modal.setResizable(false);

        modal.center();
        subContent.setMargin(true);
        subContent.addComponent(grid);

        modal.setContent(subContent);
        modal.setVisible(true);

        modal.addCloseListener(new Window.CloseListener() {
            @Override
            public void windowClose(Window.CloseEvent e) {
                listenOfferTypeBehavior();
            }
        });

        UI.getCurrent().addWindow(modal);

        cbox_tipoOferPublica.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                listenOfferTypeBehavior();
            }
        });

        //DBABATIVA Ends
////////////////////////////////////////////////////////////////////////////////        
//Fin de la tabla               
////////////////////////////////////////////////////////////////////////////////
        //Se Agrega al componente padre
        vlPadre.addComponent(vlInv);

        vlInv.setColumnExpandRatio(0, 33);
        vlInv.setColumnExpandRatio(1, 1);
        vlInv.setColumnExpandRatio(2, 15);
        vlInv.setColumnExpandRatio(3, 33);
        vlInv.setColumnExpandRatio(4, 1);
        vlInv.setColumnExpandRatio(5, 15);

        vlInv.setSpacing(true);

        VerticalLayout HL = new VerticalLayout();
        HL.setStyleName("noflex");
        btnGuardar.setStyleName("btn");
        error.setStyleName("lblError");
        HL.addComponent(btnGuardar);
        HL.addComponent(error);

        vlPadre.addComponent(HL);
        vlInv.setWidth(98, Sizeable.Unit.PERCENTAGE);
        vlPadre.setWidth(97, Sizeable.Unit.PERCENTAGE);
        HL.setWidth(97, Sizeable.Unit.PERCENTAGE);

        btnGuardar.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {

                try {
                    fechaI = datef_fechaInicioOperacion.getValue();
                } catch (NullPointerException e) {
                    fechaI = null;
                }
                try {
                    fechaF = datef_fechaFinOperacion.getValue();
                } catch (NullPointerException e) {
                    fechaF = null;
                }

                try {
                    comboPre = (Integer) cbox_existePreacuerdo.getValue();
                } catch (NullPointerException e) {
                    comboPre = 0;
                } catch (ClassCastException ex) {
                    comboPre = 0;
                }

                try {
                    combo = (Integer) cbox_vendeTN.getValue();
                } catch (NullPointerException e) {
                    combo = 0;
                } catch (ClassCastException ex) {
                    combo = 0;
                }

                try {
                    combocargaM = (Integer) cbox_activarCm.getValue();
                } catch (NullPointerException e) {
                    combocargaM = 0;
                } catch (ClassCastException ex) {
                    combocargaM = 0;
                }

                try {
                    comboPre = (Integer) cbox_existePreacuerdo.getValue();
                } catch (NullPointerException e) {
                    comboPre = 0;
                } catch (ClassCastException ex) {
                    comboPre = 0;
                }
                if (combocargaM == 0) {
                    cbox_activarCm.setComponentError(new UserError(""));
                    lbl_errActivarCm.setValue("Este campo es requerido");
                }
                if (combo == 0) {
                    cbox_vendeTN.setComponentError(new UserError(""));
                    lbl_errVendeTN.setValue("Este campo es requerido");
                }

                if (comboPre == 0) {
                    cbox_existePreacuerdo.setComponentError(new UserError(""));
                    lbl_errExistePreacuerdo.setValue("Este campo es requerido");
                }
                if (fechaI == null) {
                    datef_fechaInicioOperacion.setComponentError(new UserError(""));
                    lbl_errFechaInicioOperacion.setValue("Este campo es requerido");
                }
                if (fechaF == null) {
                    datef_fechaFinOperacion.setComponentError(new UserError(""));
                    lbl_errFechaFinOperacion.setValue("Este campo es requerido");
                }
                if (txtf_horaInicioOperacion.getValue().equals("")) {
                    txtf_horaInicioOperacion.setComponentError(new UserError(""));
                    lbl_errHoraInicioOperacion.setValue("Este campo es requerido");
                }
                if (txtf_horaFinOperacion.getValue().equals("")) {
                    txtf_horaFinOperacion.setComponentError(new UserError(""));
                    lbl_errHoraFinOperacion.setValue("Este campo es requerido");
                }
                if (txtf_horaInicioOperacionCarga.getValue().equals("")) {
                    txtf_horaInicioOperacionCarga.setComponentError(new UserError(""));
                    lbl_errHoraInicioOperacionCarga.setValue("Este campo es requerido");
                }
                if (txtf_horaFinOperacionCarga.getValue().equals("")) {
                    txtf_horaFinOperacionCarga.setComponentError(new UserError(""));
                    lbl_errHoraFinOperacionCarga.setValue("Este campo es requerido");
                }
                if (txtf_minimoDeAcciones.getValue().equals("")) {
                    txtf_minimoDeAcciones.setComponentError(new UserError(""));
                    lbl_errMinimoDeAcciones.setValue("Este campo es requerido");
                }
                if (txtf_maximoDeAcciones.getValue().equals("")) {
                    txtf_maximoDeAcciones.setComponentError(new UserError(""));
                    lbl_errMaximoDeAcciones.setValue("Este campo es requerido");
                }
                if (txtf_nombreDelOferente.getValue().equals("")) {
                    txtf_nombreDelOferente.setComponentError(new UserError(""));
                    lbl_errNombreDelOferente.setValue("Este campo es requerido");
                }
                if (txtf_precioDeLaOferta.getValue().equals("")) {
                    txtf_precioDeLaOferta.setComponentError(new UserError(""));
                    lbl_errPrecioDeLaOferta.setValue("Este campo es requerido");
                }
                
                if(txtf_comisionCompra.getValue().equals("")){
                    txtf_comisionCompra.setComponentError(new UserError(""));
                    lbl_errComisionCompra.setValue("Este campo es requerido");
                }

                if (tipoOfertaPublica.equals("OPI")) {

                    if (txtf_umbral.getValue().equals("")) {
                        txtf_umbral.setComponentError(new UserError(""));
                        lbl_errumbral.setValue("Este campo es requerido");
                    }

                    if (txtf_precioaccionespago.getValue().equals("")) {
                        txtf_precioaccionespago.setComponentError(new UserError(""));
                        lbl_errprecioaccionespago.setValue("Este campo es requerido");
                    }

                    if (txtf_porcentajeefectivopago.getValue().equals("")) {
                        txtf_porcentajeefectivopago.setComponentError(new UserError(""));
                        lbl_errporcentajeefectivopago.setValue("Este campo es requerido");
                    }

                    try {
                        comboPorcentajeLis = (Integer) cbox_porcentajeList.getValue();
                    } catch (NullPointerException e) {
                        comboPorcentajeLis = 0;
                    } catch (ClassCastException ex) {
                        comboPorcentajeLis = 0;
                    }

                    if (comboPorcentajeLis == 0) {
                        cbox_porcentajeList.setComponentError(new UserError(""));
                        lbl_errporcentajeefectivopagoList.setValue("Este campo es requerido");
                    }

                    if (txta_textoTres.getValue().equals("")) {
                        txta_textoTres.setComponentError(new UserError(""));
                        lbl_errTextoTres.setValue("Este campo es requerido");
                    }
                    if (txta_textoCuatro.getValue().equals("")) {
                        txta_textoCuatro.setComponentError(new UserError(""));
                        lbl_errTextoCuatro.setValue("Este campo es requerido");
                    }
                    if (txta_textoCinco.getValue().equals("")) {
                        txta_textoCinco.setComponentError(new UserError(""));
                        lbl_errTextoCinco.setValue("Este campo es requerido");
                    }
                    if (txta_textoSeis.getValue().equals("")) {
                        txta_textoSeis.setComponentError(new UserError(""));
                        lbl_errTextoSeis.setValue("Este campo es requerido");
                    }
                    if (txta_textoSiete.getValue().equals("")) {
                        txta_textoSiete.setComponentError(new UserError(""));
                        lbl_errTextoSiete.setValue("Este campo es requerido");
                    }

                }

                if (txtf_clasesDeAcciones.getValue().equals("")) {
                    txtf_clasesDeAcciones.setComponentError(new UserError(""));
                    lbl_errClasesDeAcciones.setValue("Este campo es requerido");
                }
                if (txtf_nanotecnico.getValue().equals("")) {
                    txtf_nanotecnico.setComponentError(new UserError(""));
                    lbl_errNanotectino.setValue("Este campo es requerido");
                }
                if (txtf_cantRpt.getValue().equals("")) {
                    txtf_cantRpt.setComponentError(new UserError(""));
                    lbl_errCantRpt.setValue("Este campo es requerido");
                }
                if (txtf_cantUsOp.getValue().equals("")) {
                    txtf_cantUsOp.setComponentError(new UserError(""));
                    lbl_errCantUsOp.setValue("Este campo es requerido");
                }

                try {
                    comboDireccion = (Integer) cbox_direccion.getValue();
                } catch (NullPointerException e) {
                    comboDireccion = 0;
                } catch (ClassCastException ex) {
                    comboDireccion = 0;
                }

                if (comboDireccion == 0) {
                    cbox_direccion.setComponentError(new UserError(""));
                    lbl_errdireccion.setValue("Este campo es requerido");
                }

                try {
                    comboMILA = (Integer) cbox_MILA.getValue();
                } catch (NullPointerException e) {
                    comboMILA = 0;
                } catch (ClassCastException ex) {
                    comboMILA = 0;
                }

                if (comboMILA == 0) {
                    cbox_MILA.setComponentError(new UserError(""));
                    lbl_errMILA.setValue("Este campo es requerido");
                }

                if (txta_textoUno.getValue().equals("")) {
                    txta_textoUno.setComponentError(new UserError(""));
                    lbl_errTextoUno.setValue("Este campo es requerido");
                }
                if (txta_textoDos.getValue().equals("")) {
                    txta_textoDos.setComponentError(new UserError(""));
                    lbl_errTextoDos.setValue("Este campo es requerido");
                }
                //Validacion nuevos campos
                try {
                    valorCombo = (Integer) cmb_TipoDocumentoOferente.getValue();
                } catch (NullPointerException e) {
                    valorCombo = 0;
                } catch (ClassCastException ex) {
                    valorCombo = 0;
                }
                if (valorCombo == 0) {
                    cmb_TipoDocumentoOferente.setComponentError(new UserError(""));
                    lbl_errTipoDocumentoOferente.setValue("Este campo es requerido");
                }

                if (txtf_numeroDocumentoOferente.getValue().equals("")) {
                    txtf_numeroDocumentoOferente.setComponentError(new UserError(""));
                    lbl_errNumeroDocumentoOferente.setValue("Este campo es requerido");
                } else if (valorCombo == 4) {
                    if (validacion.validarRut(txtf_numeroDocumentoOferente.getValue()) != Integer.parseInt(txtf_DVOferente.getValue().equals("") ? "0" : txtf_DVOferente.getValue())) {
                        txtf_DVOferente.setComponentError(new UserError(""));
                        lbl_errDVOferente.setValue("El dígito de verificación ingresado no corresponde al NIT.");
                    }
                } else {
                    txtf_DVOferente.setComponentError(null);
                    lbl_errDVOferente.setValue("");
                }

                if (txtf_cuentaDecevalOferente.getValue().equals("")) {
                    txtf_cuentaDecevalOferente.setComponentError(new UserError(""));
                    lbl_errCuentaDecevalOferente.setValue("Este campo es requerido");
                }

                try {
                    valorSCB = (Integer) cmb_scbOferente.getValue();
                } catch (NullPointerException e) {
                    valorSCB = 0;
                } catch (ClassCastException ex) {
                    valorSCB = 0;
                }
                if (valorSCB == 0) {
                    cmb_scbOferente.setComponentError(new UserError(""));
                    lbl_errScbOferente.setValue("Este campo es requerido");
                }

                //Ajuste min y max de acciones
                if (EsEntero(txtf_minimoDeAcciones.getValue())) {

                    txtf_minimoDeAcciones.setValue(moneyFormatter1.format(Double.parseDouble(txtf_minimoDeAcciones.getValue().replace(".", "").split("&")[0])));
                    if ((!txtf_minimoDeAcciones.getValue().toString().equalsIgnoreCase("0"))) {
                        if (txtf_minimoDeAcciones.getValue().replace(".", "").length() <= 11) {
                            txtf_minimoDeAcciones.setComponentError(null);
                            lbl_errMinimoDeAcciones.setValue("");
                        } else {
                            txtf_minimoDeAcciones.setComponentError(new UserError(""));
                            lbl_errMinimoDeAcciones.setValue("longitud Invalida");
                        }

                    } else {
                        txtf_minimoDeAcciones.setComponentError(new UserError(""));
                        lbl_errMinimoDeAcciones.setValue("Cantidad de Acciones Invalida");
                    }

                } else {
                    txtf_minimoDeAcciones.setComponentError(new UserError(""));
                    lbl_errMinimoDeAcciones.setValue("Este campo contiene caracteres no válidos");
                }
                if (EsEntero(txtf_maximoDeAcciones.getValue())) {

                    txtf_maximoDeAcciones.setValue(moneyFormatter1.format(Double.parseDouble(txtf_maximoDeAcciones.getValue().replace(".", "").split("&")[0])));
                    if ((!txtf_maximoDeAcciones.getValue().toString().equalsIgnoreCase("0"))) {
                        if (txtf_maximoDeAcciones.getValue().replace(".", "").length() <= 11) {
                            txtf_maximoDeAcciones.setComponentError(null);
                            lbl_errMaximoDeAcciones.setValue("");
                        } else {
                            txtf_maximoDeAcciones.setComponentError(new UserError(""));
                            lbl_errMaximoDeAcciones.setValue("longitud Invalida");
                        }

                    } else {
                        txtf_maximoDeAcciones.setComponentError(new UserError(""));
                        lbl_errMaximoDeAcciones.setValue("Cantidad de Acciones Invalida");
                    }

                } else {
                    txtf_maximoDeAcciones.setComponentError(new UserError(""));
                    lbl_errMaximoDeAcciones.setValue("Este campo contiene caracteres no válidos");
                }

                // PRECIO DE LA OFERTA ESTE ES DE OPA 
                if (txtf_precioDeLaOferta.getValue().contains(",")) {
                    if (txtf_precioDeLaOferta.getValue().matches(regexNumericPuntComa4)) {
                        if (EsDecimal(txtf_precioDeLaOferta.getValue())) {
                            //form2.setRoundingMode(RoundingMode.FLOOR);
                            txtf_precioDeLaOferta.setValue(format4Precio.format(Double.parseDouble(txtf_precioDeLaOferta.getValue().replace(".", "").replace(",", ".").split("&")[0])));

                            txtf_precioDeLaOferta.setComponentError(null);
                            lbl_errPrecioDeLaOferta.setValue("");
                        } else {
                            txtf_precioDeLaOferta.setComponentError(new UserError(""));
                            lbl_errPrecioDeLaOferta.setValue("Precio Inválido");
                        }

                    } else {
                        txtf_precioDeLaOferta.setComponentError(new UserError(""));
                        lbl_errPrecioDeLaOferta.setValue("Este campo requiere cuatro decimales");
                    }

                } else {
                    if (EsDecimal(txtf_precioDeLaOferta.getValue())) {
                        //form2.setRoundingMode(RoundingMode.FLOOR);
                        txtf_precioDeLaOferta.setValue(format4Precio.format(Double.parseDouble(txtf_precioDeLaOferta.getValue().replace(".", "").split("&")[0])));
                        txtf_precioDeLaOferta.setComponentError(null);
                        lbl_errPrecioDeLaOferta.setValue("");
                    } else {
                        txtf_precioDeLaOferta.setComponentError(new UserError(""));
                        lbl_errPrecioDeLaOferta.setValue("Precio Inválido");
                    }

                }
            
                   if (!txtf_comisionCompra.getValue().equals("")) {

                        if (txtf_comisionCompra.getValue().matches(regexNumericComaComision)) {
                            if (txtf_comisionCompra.getValue().matches(regexTresDecimales)) {
                                try {
                                    Double num = 0.0;
                                     Number valor = format3Comision.parse(txtf_comisionCompra.getValue());
                                    num = valor.doubleValue();
                                    if (num > 100) {
                                        txtf_comisionCompra.setComponentError(new UserError(""));
                                        lbl_errComisionCompra.setValue("Porcentaje no válido, debe ser entre 0% y 100%");

                                    }
                                    if (0 <= num && num <= 100) {
                                        txtf_comisionCompra.setValue(format3Comision.format(num));
                                        txtf_comisionCompra.setComponentError(null);
                                        lbl_errComisionCompra.setValue("");
                                    }
                                } catch (ParseException ex) {
                                    logger.error("OPI - " + CrearAceptaciones.class.getName(), ex);
                                }
                            } else {
                                txtf_comisionCompra.setComponentError(new UserError(""));
                                lbl_errComisionCompra.setValue("El valor supera el máximo de decimales permitidos");
                            }

                        } else {
                            txtf_comisionCompra.setComponentError(new UserError(""));
                            lbl_errComisionCompra.setValue("Este campo contiene caracteres no válidos");
                        }
                    }  else {
                    txtf_comisionCompra.setComponentError(new UserError(""));
                    lbl_errComisionCompra.setValue("Este campo es requerido");
                }

                //Validacion nuevos campos
                try {
                    valorCombo = (Integer) cmb_TipoDocumentoOferente.getValue();
                } catch (NullPointerException e) {
                    valorCombo = 0;
                } catch (ClassCastException ex) {
                    valorCombo = 0;
                }
                if (valorCombo == 0) {
                    cmb_TipoDocumentoOferente.setComponentError(new UserError(""));
                    lbl_errTipoDocumentoOferente.setValue("Este campo es requerido");
                }

                if (txtf_numeroDocumentoOferente.getValue().equals("")) {
                    txtf_numeroDocumentoOferente.setComponentError(new UserError(""));
                    lbl_errNumeroDocumentoOferente.setValue("Este campo es requerido");
                } else if (valorCombo == 4) {
                    if (validacion.validarRut(txtf_numeroDocumentoOferente.getValue()) != Integer.parseInt(txtf_DVOferente.getValue().equals("") ? "0" : txtf_DVOferente.getValue())) {
                        txtf_DVOferente.setComponentError(new UserError(""));
                        lbl_errDVOferente.setValue("El dígito de verificación ingresado no corresponde al NIT.");
                    }
                } else {
                    txtf_DVOferente.setComponentError(null);
                    lbl_errDVOferente.setValue("");
                }
                if (txtf_cuentaDecevalOferente.getValue().equals("")) {
                    txtf_cuentaDecevalOferente.setComponentError(new UserError(""));
                    lbl_errCuentaDecevalOferente.setValue("Este campo es requerido");
                }
                try {
                    valorSCB = (Integer) cmb_scbOferente.getValue();
                } catch (NullPointerException e) {
                    valorSCB = 0;
                } catch (ClassCastException ex) {
                    valorSCB = 0;
                }
                if (valorSCB == 0) {
                    cmb_scbOferente.setComponentError(new UserError(""));
                    lbl_errScbOferente.setValue("Este campo es requerido");
                }

                if (txta_AccionesNegociadas.getValue().equals("")) {
                    txta_AccionesNegociadas.setComponentError(new UserError(""));
                    lbl_errAccionesNegociadas.setValue("Este campo es requerido");
                }

                if (txta_TextoBoletinInfo.getValue().equals("")) {
                    txta_TextoBoletinInfo.setComponentError(new UserError(""));
                    lbl_errTextoBoletinInfo.setValue("Este campo es requerido");
                }

                ValidarError();
                if (!ValidaComponentError()) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                    String fechaIn = "";
                    String fechaFn = "";
                    fechaIn = String.valueOf(sdf.format(datef_fechaInicioOperacion.getValue()));
                    fechaFn = String.valueOf(sdf.format(datef_fechaFinOperacion.getValue()));

                    int consecutivo = 0;
                    if (txtf_numeroDeAceptacion.getValue()) {
                        facade.reiniciaCon();
                        facade.borrarAceptaciones();
                        consecutivo = 1;
                    }

                    String nomUsuario = userDetailsService.getUsuarioAutenticado().getUsername();

                    String strError = "";
                    // Inicio operacion fecha y hora
                    String fechaCreacion = "";
                    String FechaModificacion = "";
                    Date today;
                    SimpleDateFormat sdfh = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");

                    today = new Date(System.currentTimeMillis());

                    fechaCreacion = sdfh.format(today);
                    String DV = "";
                    try {
                        if (valorCombo == 4) {
                            DV = txtf_DVOferente.getValue();
                        } else {
                            DV = "";
                        }
                    } catch (Exception ex) {
                        DV = "";
                    }

                    //El guardado es dependiendo si es OPI u OPA
                    String CrearParametros = "";

                    if (tipoOfertaPublica.equals("OPA")) {
                        //Recalculo montos con el precio incluido
                        if (check_recalculo.getValue()) {
                            facade.RecalcularMontoTotalEfectivoAceptaciones(txtf_precioDeLaOferta.getValue().replace(".", "").replace(",", "."));
                        }
                        //Llamado a facade de OPA
                        CrearParametros = facade.CrearParametros(
                                userDetailsService.getUsuarioAutenticado().getId(), fechaIn, txtf_horaInicioOperacion.getValue(), fechaFn, txtf_horaFinOperacion.getValue(), txtf_minimoDeAcciones.getValue().replace(".", ""), txtf_maximoDeAcciones.getValue().replace(".", ""), txtf_nombreDelOferente.getValue(), txtf_precioDeLaOferta.getValue().replace(".", "").replace(",", "."), consecutivo, txta_textoUno.getValue().replace("'", "\'\'"), txta_textoDos.getValue().replace("'", "\'\'"), Integer.parseInt(cbox_existePreacuerdo.getValue().toString()), Integer.valueOf(txtf_cantRpt.getValue()), txtf_nanotecnico.getValue(), txtf_clasesDeAcciones.getValue(), Integer.valueOf(txtf_cantUsOp.getValue()), userDetailsService.getUsuarioAutenticado().getId(), fechaCreacion, userDetailsService.getUsuarioAutenticado().getId(), fechaCreacion, Integer.parseInt(cbox_vendeTN.getValue().toString()), Integer.parseInt(cbox_activarCm.getValue().toString()), nomUsuario, fechaCreacion,
                                valorCombo, txtf_numeroDocumentoOferente.getValue(), DV, txtf_EFOferente.getValue(), Integer.valueOf(txtf_cuentaDecevalOferente.getValue()), valorSCB, txtf_horaInicioOperacionCarga.getValue(), txtf_horaFinOperacionCarga.getValue(), txta_AccionesNegociadas.getValue().replace("'", "\'\'"), txta_TextoBoletinInfo.getValue().replace("'", "\'\'"), "0", "0.00", "0", "OPA", Integer.parseInt(cbox_direccion.getValue().toString()), Integer.parseInt(cbox_MILA.getValue().toString()),txta_TextBulletinInfo.getValue().replace("'", "\'\'"),txtf_accionesEnCirculacion.getValue().replace(".", ""), txtf_comisionCompra.getValue().replace(".", "").replace(",", "."), txtf_ReferenciaComprador.getValue());
                    } else {
                        //Llamado a facade de OPI
                        CrearParametros = facade.CrearParametros(
                                userDetailsService.getUsuarioAutenticado().getId(), fechaIn, txtf_horaInicioOperacion.getValue(), fechaFn, txtf_horaFinOperacion.getValue(), txtf_minimoDeAcciones.getValue().replace(".", ""), txtf_maximoDeAcciones.getValue().replace(".", ""), txtf_nombreDelOferente.getValue(), txtf_precioDeLaOferta.getValue().replace(".", "").replace(",", "."), consecutivo, txta_textoUno.getValue().replace("'", "\'\'"), txta_textoDos.getValue().replace("'", "\'\'"), Integer.parseInt(cbox_existePreacuerdo.getValue().toString()), Integer.valueOf(txtf_cantRpt.getValue()), txtf_nanotecnico.getValue(), txtf_clasesDeAcciones.getValue(), Integer.valueOf(txtf_cantUsOp.getValue()), userDetailsService.getUsuarioAutenticado().getId(), fechaCreacion, userDetailsService.getUsuarioAutenticado().getId(), fechaCreacion, Integer.parseInt(cbox_vendeTN.getValue().toString()), Integer.parseInt(cbox_activarCm.getValue().toString()), nomUsuario, fechaCreacion,
                                valorCombo, txtf_numeroDocumentoOferente.getValue(), DV, txtf_EFOferente.getValue(), Integer.valueOf(txtf_cuentaDecevalOferente.getValue()), valorSCB, txtf_horaInicioOperacionCarga.getValue(), txtf_horaFinOperacionCarga.getValue(), txta_AccionesNegociadas.getValue().replace("'", "\'\'"), txta_TextoBoletinInfo.getValue().replace("'", "\'\'"), txtf_umbral.getValue().replace(".", ""), txtf_precioaccionespago.getValue().replace(".", "").replace(",", "."), txtf_porcentajeefectivopago.getValue(), txta_textoTres.getValue().replace("'", "\'\'"), txta_textoCuatro.getValue().replace("'", "\'\'"), txta_textoCinco.getValue().replace("'", "\'\'"), txta_textoSeis.getValue().replace("'", "\'\'"), txta_textoSiete.getValue().replace("'", "\'\'"), "OPI", Integer.parseInt(cbox_porcentajeList.getValue().toString()), Integer.parseInt(cbox_direccion.getValue().toString()), Integer.parseInt(cbox_MILA.getValue().toString()),txta_TextBulletinInfo.getValue().replace("'", "\'\'"),txtf_accionesEnCirculacion.getValue().replace(".", ""));
                    }
                    Notification.show(CrearParametros, Notification.Type.HUMANIZED_MESSAGE);
                }

            }
        });
        
        setContent(vlPadre);
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
        if (datef_fechaInicioOperacion.getComponentError() != null || datef_fechaFinOperacion.getComponentError() != null) {
            return true;
        }
        if (txtf_horaInicioOperacion.getComponentError() != null || txtf_horaFinOperacion.getComponentError() != null) {
            return true;
        }
        if (txtf_horaInicioOperacionCarga.getComponentError() != null || txtf_horaFinOperacionCarga.getComponentError() != null) {
            return true;
        }
        if (txtf_minimoDeAcciones.getComponentError() != null || txtf_maximoDeAcciones.getComponentError() != null) {
            return true;
        }
        if (txtf_nombreDelOferente.getComponentError() != null || txtf_precioDeLaOferta.getComponentError() != null) {
            return true;
        }
        if (txtf_umbral.getComponentError() != null || txtf_precioaccionespago.getComponentError() != null) {
            return true;
        }
        if (txtf_porcentajeefectivopago.getComponentError() != null) {
            return true;
        }
        if (txtf_comisionCompra.getComponentError() != null) {
            return true;
        }
        if (cbox_porcentajeList.getComponentError() != null) {
            return true;
        }
        if (txtf_clasesDeAcciones.getComponentError() != null || txtf_nanotecnico.getComponentError() != null) {
            return true;
        }
        if (txtf_numeroDeAceptacion.getComponentError() != null || txtf_cantRpt.getComponentError() != null) {
            return true;
        }
        if (txtf_cantUsOp.getComponentError() != null || txta_textoUno.getComponentError() != null) {
            return true;
        }
        if (txta_textoDos.getComponentError() != null || cbox_existePreacuerdo.getComponentError() != null) {
            return true;
        }
        if (cbox_vendeTN.getComponentError() != null) {
            return true;
        }

        if (cbox_direccion.getComponentError() != null) {
            return true;
        }

        if (cbox_MILA.getComponentError() != null) {
            return true;
        }

        if (cbox_activarCm.getComponentError() != null) {
            return true;
        }
        if (txta_textoTres.getComponentError() != null || txta_textoCuatro.getComponentError() != null) {
            return true;
        }
        if (txta_textoCinco.getComponentError() != null) {
            return true;
        }
        if (txta_textoSeis.getComponentError() != null) {
            return true;
        }
        if (txta_textoSiete.getComponentError() != null) {
            return true;
        }
        if (txtf_numeroDocumentoOferente.getComponentError() != null || cmb_TipoDocumentoOferente.getComponentError() != null) {
            return true;
        }

        if (txtf_DVOferente.getComponentError() != null) {
            return true;
        }
        if (txtf_cuentaDecevalOferente.getComponentError() != null) {
            return true;
        }

        if (cmb_scbOferente.getComponentError() != null) {
            return true;
        }

        if (txta_AccionesNegociadas.getComponentError() != null) {
            return true;
        }

        if (txta_TextoBoletinInfo.getComponentError() != null) {
            return true;
        }
          if (txtf_accionesEnCirculacion.getComponentError() != null) {
            return true;
        }
        if (check_recalculo.getComponentError() != null) {
            return true;
        }

        return errores;
    }

    public void Limpiar() {

    }

    public Date ValidaFechaMajor(String parametro_Fecha) throws ParseException {
        calendar_fechaFinalParamtros.setTime(simpledatefortmat_fechaFinalParamtros.parse(datef_fechaFinOperacion.getValue().toString()));
        date_fechaFinalParamtros = calendar_fechaFinalParamtros.getTime();
        calendar_fechaInicioParametros.setTime(simpledatefortmat_fechaInicioParametros.parse(datef_fechaInicioOperacion.getValue().toString()));
        date_fechaInicioParamtros = calendar_fechaInicioParametros.getTime();
        return (date_fechaInicioParamtros.before(date_fechaFinalParamtros) ? date_fechaInicioParamtros : date_fechaFinalParamtros);
    }

    public Date ValidaFechaMenor(String parametro_Fecha) throws ParseException {
        calendar_fechaFinalParamtros.setTime(simpledatefortmat_fechaFinalParamtros.parse(datef_fechaFinOperacion.getValue().toString()));
        date_fechaFinalParamtros = calendar_fechaFinalParamtros.getTime();
        calendar_fechaInicioParametros.setTime(simpledatefortmat_fechaInicioParametros.parse(datef_fechaInicioOperacion.getValue().toString()));
        date_fechaInicioParamtros = calendar_fechaInicioParametros.getTime();
        return (date_fechaFinalParamtros.after(date_fechaInicioParamtros) ? date_fechaFinalParamtros : date_fechaInicioParamtros);
    }

    public ComboBox LlenarTipoDocumento() {
        Iterator<TipoDocumento> LTipo = null;
        LTipo = facade.RetornarDocumentosOferente().iterator();
        TipoDocumento TP = null;
        cmb_TipoDocumentoOferente.setNullSelectionAllowed(false);
        cmb_TipoDocumentoOferente.setTextInputAllowed(false);
        cmb_TipoDocumentoOferente.addItem("");
        cmb_TipoDocumentoOferente.setItemCaption("", "Seleccione");
        cmb_TipoDocumentoOferente.select("");
        while (LTipo.hasNext()) {
            TP = LTipo.next();
            cmb_TipoDocumentoOferente.addItem(TP.getTipodocumento());
            cmb_TipoDocumentoOferente.setItemCaption(TP.getTipodocumento(), TP.getNombredoc());
        }
        return cmb_TipoDocumentoOferente;
    }

    public ComboBox LlenarSCB() {

        Iterator<SCB> LSCB = null;
        LSCB = facade.RetornarSCB().iterator();
        SCB sc = null;
        cmb_scbOferente.setTextInputAllowed(false);
        cmb_scbOferente.setNullSelectionAllowed(false);
        cmb_scbOferente.addItem("");
        cmb_scbOferente.setItemCaption("", "Seleccione");
        while (LSCB.hasNext()) {
            sc = LSCB.next();
            cmb_scbOferente.addItem(sc.getIdScb());
            cmb_scbOferente.setItemCaption(sc.getIdScb(), sc.getCodigoEntidad() + " - " + sc.getRazonSocial());
        }
        return cmb_scbOferente;
    }

    public String RegExInteger(String number) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String unformat = number.replace(".", "");

        String regex = "^[0-9]{1,3}";
        int separadores = (int) Math.floor((unformat.length() - 1) / 3);
        for (int i = 0; i < separadores; i++) {
            regex += "[\\.][0-9]{3,3}";
        }
        regex += "$";
        logger.info("OPA - Expresion regular para el número" + regex);
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

    public Boolean EsDecimal(String number) {

        boolean respuesta = false;

        if (number.contains(",")) {

            String[] array = number.split(",");

            if (array[0].contains(".")) {
                if (array[0].matches(RegExInteger(array[0]))) {
                    respuesta = true;
                } else {

                    respuesta = false;
                }
            } else {
                if (array[0].matches(regexNumeric)) {
                    respuesta = true;
                } else {
                    respuesta = false;
                }
            }
        } else {
            if (number.matches(regexNumeric)) {
                respuesta = true;

            } else if (number.matches(RegExInteger(number))) {
                respuesta = true;

            }
        }
        return respuesta;
    }

    /**
     * Oculta los campos del formulario para Oferta pública d eIntercambio
     */
    public void ocultarCamposOPI() {

        //Oculta el encabezado del título
        vlCab.setVisible(Boolean.FALSE);

        //Oculta los Labels------------------------
        /* Oculta los campos Generales de la oferta*/
        lbl_umbral.setVisible(Boolean.FALSE);
        lbl_precioaccionespago.setVisible(Boolean.FALSE);
        lbl_porcentajeefectivopago.setVisible(Boolean.FALSE);
        lbl_porcentajeList.setVisible(Boolean.FALSE);

        /*Oculta los campos de Datos de la Aceptación de la Emisión*/
        lbl_datosGeneralesAceptacionOPA.setVisible(Boolean.FALSE);
        lbl_textoTres.setVisible(Boolean.FALSE);
        lbl_textoCuatro.setVisible(Boolean.FALSE);
        lbl_textoCinco.setVisible(Boolean.FALSE);
        lbl_textoSeis.setVisible(Boolean.FALSE);
        lbl_textoSiete.setVisible(Boolean.FALSE);

        //Oculta los asteriscos------------------------
        /* Oculta los campos Generales de la oferta*/
        lbl_astericoumbral.setVisible(Boolean.FALSE);
        lbl_asteriscoprecioaccionespago.setVisible(Boolean.FALSE);
        lbl_astericoporcentajeefectivopago.setVisible(Boolean.FALSE);
        lbl_astericoporcentajeefectivopagoList.setVisible(Boolean.FALSE);

        /*Oculta los campos de Datos de la Aceptación de la Emisión*/
        lbl_asteriscoTextoTres.setVisible(Boolean.FALSE);
        lbl_asteriscoTextoCuatro.setVisible(Boolean.FALSE);
        lbl_asteriscoTextoCinco.setVisible(Boolean.FALSE);
        lbl_asteriscoTextoSeis.setVisible(Boolean.FALSE);
        lbl_asteriscoTextoSiete.setVisible(Boolean.FALSE);

        //Oculta los controles ------------------------
        /* Oculta los campos Generales de la oferta*/
        txtf_umbral.setVisible(Boolean.FALSE);
        txtf_precioaccionespago.setVisible(Boolean.FALSE);
        txtf_porcentajeefectivopago.setVisible(Boolean.FALSE);
        cbox_porcentajeList.setVisible(Boolean.FALSE);

        /*Oculta los campos de Datos de la Aceptación de la Emisión*/
        txta_textoTres.setVisible(Boolean.FALSE);
        txta_textoCuatro.setVisible(Boolean.FALSE);
        txta_textoCinco.setVisible(Boolean.FALSE);
        txta_textoSeis.setVisible(Boolean.FALSE);
        txta_textoSiete.setVisible(Boolean.FALSE);
        
        label_recalculo.setVisible(Boolean.TRUE);
        check_recalculo.setVisible(Boolean.TRUE);
        
        activarDireccion(Boolean.FALSE);
    }

    /**
     * Oculta los campos del formulario para Oferta pública d eIntercambio
     */
    public void ajustarCamposOPI() {

        //Oculta los labels------------------------
        /* Oculta los campos Generales de la oferta*/
        lbl_precioDeLaOferta.setValue("Precio Acciones a Vender");
        lbl_comisionCompra.setVisible(Boolean.FALSE);
        txtf_comisionCompra.setVisible(Boolean.FALSE);
        lbl_asteriscoComisionCompra.setVisible(Boolean.FALSE);
    }

    /**
     * Muestra los campos del formulario para OPA
     */
    public void mostrarCamposOPA() {
        //Muestra los labels------------------------
        /* Muestra los campos Generales de la oferta*/
        lbl_precioDeLaOferta.setValue("Precio:");
        lbl_precioDeLaOferta.setVisible(Boolean.TRUE);

        //Muestra los asteriscos------------------------
        /* Muestra los campos Generales de la oferta*/
        lbl_asteriscoPrecioDeLaOferta.setVisible(Boolean.TRUE);

        //Muestra los controles ------------------------
        /* Muestra los campos Generales de la oferta*/
        txtf_precioDeLaOferta.setVisible(Boolean.TRUE);
                
    }

    /**
     * mostrar los campos del formulario para Oferta pública de Intercambio
     */
    public void mostrarCamposOPI() {

        //Muestra el encabezado del título
        vlCab.setVisible(Boolean.TRUE);

        //Muestra los Labels------------------------
        /* Muestra los campos Generales de la oferta*/
        lbl_umbral.setVisible(Boolean.TRUE);
        lbl_precioaccionespago.setVisible(Boolean.TRUE);
        lbl_porcentajeefectivopago.setVisible(Boolean.TRUE);
        lbl_porcentajeList.setVisible(Boolean.TRUE);
        
        /*Oculta check de recalculo*/
        label_recalculo.setVisible(Boolean.FALSE);
        check_recalculo.setVisible(Boolean.FALSE);

        /*Muestra los campos de Datos de la Aceptación de la Emisión*/
        lbl_datosGeneralesAceptacionOPA.setVisible(Boolean.TRUE);
        lbl_textoTres.setVisible(Boolean.TRUE);
        lbl_textoCuatro.setVisible(Boolean.TRUE);
        lbl_textoCinco.setVisible(Boolean.TRUE);
        lbl_textoSeis.setVisible(Boolean.TRUE);
        lbl_textoSiete.setVisible(Boolean.TRUE);

        //Muestra los asteriscos------------------------
        /* Muestra los campos Generales de la oferta*/
        lbl_astericoumbral.setVisible(Boolean.TRUE);
        lbl_asteriscoprecioaccionespago.setVisible(Boolean.TRUE);
        lbl_astericoporcentajeefectivopago.setVisible(Boolean.TRUE);
        lbl_astericoporcentajeefectivopagoList.setVisible(Boolean.TRUE);

        /*Muestra los campos de Datos de la Aceptación de la Emisión*/
        lbl_asteriscoTextoTres.setVisible(Boolean.TRUE);
        lbl_asteriscoTextoCuatro.setVisible(Boolean.TRUE);
        lbl_asteriscoTextoCinco.setVisible(Boolean.TRUE);
        lbl_asteriscoTextoSeis.setVisible(Boolean.TRUE);
        lbl_asteriscoTextoSiete.setVisible(Boolean.TRUE);

        //Muestra los controles ------------------------
        /* Muestra los campos Generales de la oferta*/
        txtf_umbral.setVisible(Boolean.TRUE);
        txtf_precioaccionespago.setVisible(Boolean.TRUE);
        txtf_porcentajeefectivopago.setVisible(Boolean.TRUE);
        cbox_porcentajeList.setVisible(Boolean.TRUE);

        /*Muestra los campos de Datos de la Aceptación de la Emisión*/
        txta_textoTres.setVisible(Boolean.TRUE);
        txta_textoCuatro.setVisible(Boolean.TRUE);
        txta_textoCinco.setVisible(Boolean.TRUE);
        txta_textoSeis.setVisible(Boolean.TRUE);
        txta_textoSiete.setVisible(Boolean.TRUE);
        
        activarDireccion(Boolean.TRUE);
    }

    public void listenOfferTypeBehavior() {
        if (cbox_tipoOferPublica.getValue().equals("OPA")) {

            //Todos los campos de OPI no deben aparecer:
            ocultarCamposOPI();

            //Todos los campos de OPA se deben mostrar
            mostrarCamposOPA();
            
            lbl_errSeleccionTipoOfertaPublica.setValue("");

            //Se comenta este PopUp para atenerder la forma en que se va a cambiar de tipo de Oepración   
        } else if(cbox_tipoOferPublica.getValue().equals("OPI")){
            
            lbl_errSeleccionTipoOfertaPublica.setValue("");
            ajustarCamposOPI();
            mostrarCamposOPI();
        }
    }
    
    public void activarDireccion(boolean activar) {
        lbl_habilitarDireccion.setVisible(activar);
        lbl_asteriscoHabilitarDireccion.setVisible(activar);
        cbox_direccion.setVisible(activar);
        
        if(activar == false)
            cbox_direccion.setValue(2);//Deshabilitado
        else if(facade.countAceptacionesExists() > 0)
            cbox_direccion.setValue(fqsParametrizacion.getDireccion());
        lbl_errdireccion.setVisible(activar);    
    }

}

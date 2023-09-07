/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.ui.contents;

/**
 *
 * @author LSIERRA
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.framework.common.domain.Perfil;
import com.framework.common.service.security.MyUserDetailsService;
import com.framework.common.ui.GenericContent;
import com.framework.common.ui.GenericTab;
import com.framework.common.ui.Main;
import com.framework.common.ui.util.AppConstants;
import com.framework.common.ui.util.ValidarCampos;
import com.quasar.frameq.data.OrigenMILA;
import com.quasar.frameq.db.Facade;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.FieldEvents;
import com.vaadin.server.Sizeable;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.dialogs.ConfirmDialog;
import com.jensjansson.pagedtable.PagedTable;
import com.quasar.frameq.data.SCB;
import com.quasar.frameq.data.TipoDocumento;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Validator;
import com.vaadin.server.UserError;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author jam
 */
public class RechazoAceptaciones extends GenericContent {


    PagedTable tabla;
    IndexedContainer ic;
    ComboBox cbxEstado;
    private Main main;
    Button Botditar = null;
    TextField txtObservaciones = null;
    TextField txtObs;
     Window subWindow;
    
    private Button btlimpiar = new Button();
    private Button btbuscar = new Button();
    private TextField txtnumAceptacion = new TextField();
    private TextField txtidTabla= new TextField();
    TextField txtnombreRazon;
    TextField txtconsecutivoOferta;
    TextField txtnumeroDoc;
    TextField txtDigitoverificacion;
    TextField txtEspecialFidu;
    TextField txtCuentaInv;
    TextField txtnumaceptVender;
    TextField txtDireccion;
    TextField txtEstado;
    TextField txtPorcentajeComision;
    
    ComboBox cbxtipDocumento;
    ComboBox cbxSevendetodoNada;
    ComboBox cbxexistePreacuerdo;
    ComboBox cbxRechazada;
    ComboBox cmbOrigenMila = null;        
    ComboBox txtrepresentante = new ComboBox();
    
    Label errOrigenMila = new Label();   
    Label lbnombreRazon;
    Label lbEspecialFidu;
    Label lbasteris10;
    
    private PopupDateField datef_fechaInicioOperacion = new PopupDateField();
    private PopupDateField datef_fechaFinOperacion = new PopupDateField();
    private TextField txtObservacion;
    //private Button BtnEditar;
    
    VerticalLayout verticallayoutTotal = new VerticalLayout();

    Facade facade = new Facade();
    ValidarCampos validacion = new ValidarCampos(); 
    
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
   
    Collection<Perfil> perfiles = myUserDetailsService.findPerfilesOpcionesModuloUsuarioAutenticado();

    List<String> parametrosList ;
    String muestraDireccion;
    
    int idesfila = 0;
    int select = 0;

    String numAcep = "";
    String FechAcep = "";
    String todoNada = "";
    String Acciones = "";
    String clasAcc = "";
    String ConsOft = "";
    String preacu = "";
    String NomApelli = "";
    String numDoc = "";
    String cuenInv = "";
    String espFidu = "";
    String nombRep = "";
    String regexAlpha = "^[a-zA-Z0-9]*$";
    String fechaInicio = "";
    String fechaFin = "";
    String numAceptacion = "";
    String pattern = "###,###,###,###,###,###";
    String regexTextTildesNumeros = "^[a-zA-Z0-9ñáéíóúÑÁÉÍÓÚ\\s]*$";
    String regexNumericFormat = "^[0-9\\.]*$";
    String regexNumericFormatPC = "^[0-9\\,]*$";
    String regexNumericPuntComa = "^[0-9,]*$";
    String regexTresDecimales = "\\d+(\\,\\d{1,3}|,{1})?";
    String regexAlphaNum = "^[a-zA-Z0-9- _\\s #]*$";
    String regexNumeric = "^[0-9]*$";
    String regexAlphaParen2 = "^[a-zA-Z0-9]*$";
    DecimalFormat moneyFormatter = new DecimalFormat(pattern);
    final DecimalFormat form3 = new DecimalFormat(pattern);
    String  idAceptacion ="";    
    String  observacion ="";
    Date Fecha1 = null;
    Date Fecha2 = null;
    String horario = "";
    Label lberror11;
    Label lberrorExistePre;
    Label lberrorMILA;
    Label error = new Label("");
    Label lberrorcmbR2 = new Label("");
    Label lberrorcmbR3 = new Label("");
    Label lberrorcmbR4 = new Label("");
    Label lberrorcmbR5 = new Label("");
    Label lberrorcmbR6 = new Label("");
    Label lberror12;
    Label lberror8;
    Label lberror3;
    Label lberror6;
    Label lberror7;
    Label lberror10;
    Label lberror4;
    Label errObservacion;
    Label errRechazada;
    String fechaAceptacion = "";
    String horaAceptacion  = "";
    String nomUsuarioOperador  = "";
    String claseAceptacion  = "";
    String consecutivoOferta = "";
    String nombreEntidad = "";
    String codEntidad  = "";
    String exisPreacuerdo  = "";
    String nombreRepresentante  = "";
    String nombApellidoRazon  = "";
    String tipoDocumento = "";
    String numDocumento = "";
    String digitoVerificacion  = "";
    String espeFiduciario = "";
    String cuentaInversionista  = "";
    String condicionTodoNada  = "";
    String numAccionVender  = "";
    String  estado  = "";
    String direccion  = "";
    String rechazo = "";
    String direccion1 = "";
    String precioAccion = "";
    String digVerificacion1 = "";
    String observacio = "";
    String porComision = "";
    
    final DecimalFormat form2 = new DecimalFormat("##0.000");
    
    int valorCombo = 0;
    int combo = 0;
    int comb1 = 0;
    int comboMILA = 0;
    int valorComboMila = 0;
    //String horario = validacion.fechaIngreso();
    
    
  //  Aceptaciones aceptacion = new Aceptaciones();

    public RechazoAceptaciones(GenericTab parentTab) {
        super(parentTab);
    }
    
     public VerticalLayout filtros() {
        VerticalLayout DF = new VerticalLayout();
         Panel panel = new Panel("Astronomer Panel");
         
         panel.setContent(DF);
         setContent(panel);
        return DF;
     }
  
    @Override
    public void initForm() {   

        int hayParametrizacion = facade.validaHayParametros();

        if (hayParametrizacion == 1) {
            parametrosList = facade.RetornaParametros();
            muestraDireccion = parametrosList.get(43);
         } else {
            throw new RuntimeException("No se ha realizado ninguna parametrización");
        }
        
        //
        if(!horario.equals("")) {
            ConfirmDialog cd = ConfirmDialog.getFactory().create("Confirmación", "", "ACEPTAR", "", "");
            cd.setWidth("400px");
            cd.setHeight("160px");
            HorizontalLayout texto = new HorizontalLayout();
            HorizontalLayout buttons = new HorizontalLayout();
            buttons.setStyleName("btnAceptar");
            Label lblmensaje = new Label(horario, ContentMode.HTML);
            texto.addComponent(lblmensaje);
            buttons.addComponent(cd.getOkButton());
            VerticalLayout content  = new VerticalLayout(lblmensaje, buttons);
            content.setStyleName("verticalDialog");
            content.setSizeFull();
            content.setSpacing(true);
            cd.setContent(content);
            cd.show(UI.getCurrent(), new ConfirmDialog.Listener() {
                @Override
                public void onClose(ConfirmDialog cd) {
                    
                }
            }, true);
        
        
    }else{
        
        final Panel panel = new Panel();
        final Panel panelgrilla = new Panel();
        final Panel panelPaginacion = new Panel();

        final GridLayout gridpanel = new GridLayout(4, 3);
        final GridLayout gridbotones = new GridLayout(1, 1);
        final GridLayout gridgrilla = new GridLayout(1, 1);

        final VerticalLayout verticallayoutpanel = new VerticalLayout();
        

        gridpanel.setSizeFull();
        gridpanel.setHeight(165, Sizeable.Unit.PIXELS);
        gridpanel.setSpacing(true);
        gridgrilla.setSizeFull();
        panelgrilla.setSizeFull();
        panelPaginacion.setSizeFull();
        panelgrilla.setWidth(100,Sizeable.Unit.PERCENTAGE);
        panelPaginacion.setWidth(100,Sizeable.Unit.PERCENTAGE);
        verticallayoutTotal.setSizeFull();
        verticallayoutTotal.setWidth(100,Sizeable.Unit.PERCENTAGE);
        gridbotones.setWidth(500, Sizeable.Unit.PIXELS);
        gridbotones.setHeight(50, Sizeable.Unit.PIXELS);

        //**********************************************
        //Número de Aceptacón
        //**********************************************
        Label lbnumAceptacion = new Label("Número de Aceptación");
        gridpanel.addComponent(lbnumAceptacion, 0, 0);
        gridpanel.setComponentAlignment(lbnumAceptacion, Alignment.MIDDLE_RIGHT);
        txtnumAceptacion = new TextField();
        gridpanel.addComponent(txtnumAceptacion, 1, 0);
        gridpanel.setComponentAlignment(txtnumAceptacion, Alignment.MIDDLE_LEFT);

        //**********************************************
        //Fecha Inicio Operación
        //**********************************************               
        Label lbfechInOperacion = new Label("Fecha Inicio Radicación");
        gridpanel.addComponent(lbfechInOperacion, 2, 0);
        gridpanel.setComponentAlignment(lbfechInOperacion, Alignment.MIDDLE_LEFT);
        datef_fechaInicioOperacion = new PopupDateField();
        datef_fechaInicioOperacion.setDateFormat("dd/MM/yyyy");
        datef_fechaInicioOperacion.setTextFieldEnabled(false);
        gridpanel.addComponent(datef_fechaInicioOperacion, 3, 0);
        gridpanel.setComponentAlignment(datef_fechaInicioOperacion, Alignment.MIDDLE_LEFT);

        //
        //**********************************************
        //Fecha Fin Operación
        //**********************************************               
        Label lbfechFinOperacion = new Label("Fecha Fin Radicación");
        gridpanel.addComponent(lbfechFinOperacion, 2, 1);
        gridpanel.setComponentAlignment(lbfechFinOperacion, Alignment.MIDDLE_LEFT);
        datef_fechaFinOperacion = new PopupDateField();
        datef_fechaFinOperacion.setDateFormat("dd/MM/yyyy");
        datef_fechaFinOperacion.setTextFieldEnabled(false);
        gridpanel.addComponent(datef_fechaFinOperacion, 3, 1);
        gridpanel.setComponentAlignment(datef_fechaFinOperacion, Alignment.MIDDLE_LEFT);

        //**********************************************
       //BOTON BUSCAR
       //**********************************************
        btbuscar = new Button("Filtrar");
        btbuscar.addClickListener(new Button.ClickListener() {    
            private static final long serialVersionUID = 1L;

            public void buttonClick(ClickEvent event) {
                   filtrarTabla();
            }
        });
        gridpanel.addComponent(btbuscar, 0, 2, 1, 2);
        gridpanel.setComponentAlignment(btbuscar, Alignment.MIDDLE_CENTER);

        //**********************************************
        //BOTON LIMPIAR
        //**********************************************
        btlimpiar = new Button("Limpiar");
        btlimpiar.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {         
                limpiarCampos();
                cargarTabla(); 
                tabla.setVisible(true);  
                tabla.refreshRowCache();
                tabla.markAsDirtyRecursive();
                
            }
        });
        gridpanel.addComponent(btlimpiar, 2, 2, 3, 2);
        gridpanel.setComponentAlignment(btlimpiar, Alignment.MIDDLE_CENTER);
        

        //***************************************************
        //Tabla
        //*****************************************************
        ic = new IndexedContainer();   
        ic.addContainerProperty(AppConstants.COL_N_ACEPTACION, Integer.class, null);
        ic.addContainerProperty(AppConstants.COL_FECHA_ACEPTACION, String.class, null);
        ic.addContainerProperty(AppConstants.COL_HORA_ACEPTACION, String.class, null);
        ic.addContainerProperty(AppConstants.COL_USUARIO_OPERADOR, String.class, null);
        ic.addContainerProperty(AppConstants.COL_CLASE_ACCIONES, String.class, null);        
        ic.addContainerProperty(AppConstants.COL_CONSECUTIVO, String.class, null);
        ic.addContainerProperty(AppConstants.COL_NOMBRE_ENTIDAD, String.class, null);
        ic.addContainerProperty(AppConstants.COL_CODIGO_ENTIDAD, String.class, null);
        ic.addContainerProperty(AppConstants.COL_PREACUERDO, String.class, null);
        ic.addContainerProperty(AppConstants.COL_NOMBRE_REPRESENTANTE, String.class, null);
        ic.addContainerProperty(AppConstants.COL_NOMBRE_RAZON, String.class, null);
        ic.addContainerProperty(AppConstants.COL_TIPO_DOC, String.class, null);
        ic.addContainerProperty(AppConstants.COL_NUMERO_DOC, String.class, null);
        ic.addContainerProperty(AppConstants.COL_DIGITO_VERIFICACION, String.class, null);
        ic.addContainerProperty(AppConstants.COL_ESP_FIDU, String.class, null);
        ic.addContainerProperty(AppConstants.COL_CUENTA_INVER, String.class, null);
        ic.addContainerProperty(AppConstants.COL_TODO_NADA, String.class, null);
        ic.addContainerProperty(AppConstants.COL_ACCIONES_VENDER, String.class, null);
        if (muestraDireccion.equals("1")) {
                ic.addContainerProperty(AppConstants.COL_DIRECCION, String.class, null);
        }
        ic.addContainerProperty(AppConstants.COL_ESTADO, String.class, null);
        ic.addContainerProperty(AppConstants.COL_RECHAZADA, String.class, null);
        ic.addContainerProperty(AppConstants.COL_OBSERVACIONES, String.class, null);
        ic.addContainerProperty(AppConstants.COL_PORCENTAJE_COMISION, String.class, null);        
        ic.addContainerProperty(AppConstants.COL_GUARDAR, Button.class, null);

        
        tabla = new PagedTableCustomscb("");   
        cargarTabla();
        
        tabla.setContainerDataSource(ic);
        //tabla.setPageLength(10);
        tabla.setSizeFull(); 
        tabla.setImmediate(true);
        tabla.setColumnReorderingAllowed(true);
        tabla.setSortContainerPropertyId(AppConstants.COL_N_ACEPTACION);
        tabla.setSortAscending(true);
        

            //********************************************** 
            //COMPONENTES DE LOS OBJETOSS
            //**********************************************
            verticallayoutpanel.addComponent(gridpanel);
            verticallayoutpanel.setComponentAlignment(gridpanel, Alignment.TOP_CENTER);
            panel.setContent(verticallayoutpanel);
            panelgrilla.setContent(tabla);    
            panelPaginacion.setContent(tabla.createControls());
            verticallayoutTotal.setSpacing(true);
            verticallayoutTotal.addComponent(panel);
            verticallayoutTotal.addComponent(panelgrilla);
            verticallayoutTotal.addComponent(panelPaginacion);
            addComponent(verticallayoutTotal);
}
    }    
    
    public void limpiarCampos() {
        datef_fechaInicioOperacion.setValue(null);
        datef_fechaFinOperacion.setValue(null);
        txtnumAceptacion.setValue("");
        datef_fechaInicioOperacion.setRequired(false);
        datef_fechaFinOperacion.setRequired(false);

    }
    
        public ComboBox listarOrigenMILA() {
        Iterator<OrigenMILA> LMila = null;
        OrigenMILA LM = null;
        LMila = facade.RetornarOrigenMILActivos().iterator();
        cmbOrigenMila.setNullSelectionAllowed(false);
        cmbOrigenMila.setTextInputAllowed(false);
        cmbOrigenMila.addItem(0);
        cmbOrigenMila.setItemCaption(0, "No Aplica");
        while (LMila.hasNext()) {
            LM = LMila.next();
            cmbOrigenMila.addItem(LM.getIdMila());
            cmbOrigenMila.setItemCaption(LM.getIdMila(), LM.getPais());
        }
        return cmbOrigenMila;
    }
        
        public ComboBox cargaRepresentante(String usuario) {
        txtrepresentante.removeAllItems();
        txtrepresentante.setComponentError(null);
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
        //System.out.println("Rep 1: "+lp.getRepresentante().trim());
        //System.out.println("Rep 2: "+lp.getRepresentante1().trim());
        //System.out.println("Rep 3: "+lp.getRepresentante2().trim());

        return txtrepresentante;
    }
        
    public void filtrarTabla() {
        String tfNumAceptaciones = "";
        String reformattedIni = "";
        String reformattedFin = "";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        lberrorcmbR3.setValue("");
        lberrorcmbR2.setValue("");
        lberrorcmbR5.setValue("");
        lberrorcmbR6.setValue("");
        
        //Num Aceptacion
        try {
            tfNumAceptaciones = txtnumAceptacion.getValue().toString();
        } catch (Exception e) {
            tfNumAceptaciones = "";
        }
        //Fecha inicio operacion
        try {
            reformattedFin = df.format(datef_fechaFinOperacion.getValue());

        } catch (Exception e) {
            reformattedFin = "";

        }
        //Fecha fin operacion 
        try {
            reformattedIni = df.format(datef_fechaInicioOperacion.getValue());
        } catch (Exception e) {
            reformattedIni = "";
        }
        
        try {
            Fecha1 = df.parse(reformattedIni);
        } catch (Exception e) {
            reformattedIni = "";
        } 
        
        try {
         Fecha2 = df.parse(reformattedFin);
        } catch (Exception e) {
           reformattedFin = "";
        } 
        

        if (((reformattedIni.equals("")) && (reformattedFin.equals("")) && (tfNumAceptaciones.equals("")))) {
            Notification.show("Por favor filtrar por un campo",
                    Notification.Type.ERROR_MESSAGE);
           // tabla.setVisible(false);
        }  else { 
          if ((reformattedIni.equals("")) && (!reformattedFin.equals(""))) {
            //datef_fechaInicioOperacion.setRequired(true);
            datef_fechaInicioOperacion.setRequiredError("Debe seleccionar la Fecha Inicio de Radicación");
            Notification.show("Debe seleccionar la Fecha Inicio de Radicación",
                    Notification.Type.ERROR_MESSAGE);
            tabla.setVisible(true);

        } else { 
            if ((reformattedFin.equals(""))&& (!reformattedIni.equals("")) ){
            //datef_fechaFinOperacion.setRequired(true);
            datef_fechaFinOperacion.setRequiredError("Debe seleccionar la Fecha Fin de Radicación");
            Notification.show("Debe seleccionar la Fecha Fin de Radicación",
                    Notification.Type.ERROR_MESSAGE);
            tabla.setVisible(true);

        } else  if ((!reformattedIni.equals("")) && (!reformattedFin.equals("")) && Fecha2.before(Fecha1)) {      
            Notification.show("La fecha inicial debe ser menor o igual a la fecha final",
                    Notification.Type.ERROR_MESSAGE);  
 
          } else {
            datef_fechaFinOperacion.setRequired(false);
            Button boton = new Button();
            boton.setStyleName("CssBoton");

            tabla.setVisible(true);

            tabla.getContainerDataSource().removeAllItems();
            String idUsuario = userDetailsService.getUsuarioAutenticado().getId().toString();
            int i;
            List<List<String>> listAceptaciones;
                        
            listAceptaciones = facade.ListarDemandasRechazadas(idUsuario, tfNumAceptaciones, reformattedIni, reformattedFin);
             

            for (i = 0; i < listAceptaciones.get(0).size(); i++) {
                //Preacuerdo 1 Si - 2 No
                String nomPreacuerdo = "";
                nomPreacuerdo = listAceptaciones.get(5).get(i);
                
                if (nomPreacuerdo==null){
                    nomPreacuerdo="";
                } else if (nomPreacuerdo.equals("1")) {
                    nomPreacuerdo = "Si";
                } else if (nomPreacuerdo.equals("2")) {
                    nomPreacuerdo = "No";
                }
                      
                //Rechazada 1 Si - 2 No
                String rechazado = "";
                if (listAceptaciones.get(20).get(i).equals("Rechazado")) {
                    rechazado = "Si";
                } else if (!listAceptaciones.get(20).get(i).equals("Rechazado")) {
                    rechazado = "No";
                }
         
                //Se vende con condición todo o nada
                String nomConTodoNada = "";
                  nomConTodoNada = listAceptaciones.get(10).get(i);
                  
                 if (nomConTodoNada == null) {
                    nomConTodoNada = "";
                   }  else if (nomConTodoNada.equals("1")) {
                    nomConTodoNada = "Si";
                } else if (nomConTodoNada.equals("0") || nomConTodoNada.equals("2")) {
                    nomConTodoNada = "No";
                }
                 
                //Digito de verificación
                String digVerificacion = "";
                digVerificacion= listAceptaciones.get(13).get(i);
                
                if (digVerificacion==null) {
                    digVerificacion = "";
                } else {
                    digVerificacion= listAceptaciones.get(13).get(i);
                }
                
                //observacion
                String observacion = "";
                observacion = listAceptaciones.get(22).get(i);

                if (observacion == null) {
                    observacion = "";
                } else {
                    observacion = listAceptaciones.get(22).get(i);
                }
                
                //Código de la entidad
                String codigo = listAceptaciones.get(23).get(i);
      	  
	          //estado
                String estadorec = listAceptaciones.get(20).get(i);
                
                //id y Origen MILA
                
                precioAccion = listAceptaciones.get(27).get(i);
                
                String porcentajeComision = listAceptaciones.get(28).get(i).replace(".", ",");
                
                Item item = ic.addItem(i);
                item.getItemProperty(AppConstants.COL_N_ACEPTACION).setValue(Integer.valueOf(listAceptaciones.get(0).get(i)));
                item.getItemProperty(AppConstants.COL_FECHA_ACEPTACION).setValue(listAceptaciones.get(17).get(i));
                item.getItemProperty(AppConstants.COL_HORA_ACEPTACION).setValue(listAceptaciones.get(18).get(i));
                item.getItemProperty(AppConstants.COL_USUARIO_OPERADOR).setValue(listAceptaciones.get(21).get(i));
                item.getItemProperty(AppConstants.COL_CLASE_ACCIONES).setValue(listAceptaciones.get(1).get(i));
                item.getItemProperty(AppConstants.COL_CONSECUTIVO).setValue(listAceptaciones.get(2).get(i));
                item.getItemProperty(AppConstants.COL_NOMBRE_ENTIDAD).setValue(listAceptaciones.get(6).get(i));
                item.getItemProperty(AppConstants.COL_CODIGO_ENTIDAD).setValue(listAceptaciones.get(23).get(i));
                item.getItemProperty(AppConstants.COL_PREACUERDO).setValue(nomPreacuerdo);
                item.getItemProperty(AppConstants.COL_NOMBRE_REPRESENTANTE).setValue(listAceptaciones.get(8).get(i));
                item.getItemProperty(AppConstants.COL_NOMBRE_RAZON).setValue(listAceptaciones.get(24).get(i)/*+" "+listAceptaciones.get(9).get(i)*/);
                item.getItemProperty(AppConstants.COL_TIPO_DOC).setValue(listAceptaciones.get(11).get(i));
                item.getItemProperty(AppConstants.COL_NUMERO_DOC).setValue(listAceptaciones.get(12).get(i));
                item.getItemProperty(AppConstants.COL_DIGITO_VERIFICACION).setValue(digVerificacion);
                item.getItemProperty(AppConstants.COL_ESP_FIDU).setValue(listAceptaciones.get(14).get(i));
                item.getItemProperty(AppConstants.COL_CUENTA_INVER).setValue(listAceptaciones.get(15).get(i));
                item.getItemProperty(AppConstants.COL_TODO_NADA).setValue(nomConTodoNada);
                item.getItemProperty(AppConstants.COL_ACCIONES_VENDER).setValue((form3.format(Double.valueOf(listAceptaciones.get(9).get(i)))));
                if (muestraDireccion.equals("1")) {
                    item.getItemProperty(AppConstants.COL_DIRECCION).setValue(listAceptaciones.get(25).get(i));
                }
                item.getItemProperty(AppConstants.COL_ESTADO).setValue(listAceptaciones.get(20).get(i));
                item.getItemProperty(AppConstants.COL_RECHAZADA).setValue(rechazado);
                item.getItemProperty(AppConstants.COL_OBSERVACIONES).setValue(observacion);                 
                item.getItemProperty(AppConstants.COL_PORCENTAJE_COMISION).setValue(porcentajeComision+" %");
                Button BtnEditar = new Button(AppConstants.COL_GUARDAR);
                BtnEditar.setData(i);
                item.getItemProperty(AppConstants.COL_GUARDAR).setValue(BtnEditar);
                
                             
                    BtnEditar.addClickListener(new Button.ClickListener() {
                    private static final long serialVersionUID = 1L;

                    public void buttonClick(ClickEvent event) {
                        int i = Integer.parseInt(event.getButton().getData().toString());
                        Item item=ic.getItem(i);
                        idAceptacion=tabla.getContainerDataSource().getItem(i).getItemProperty("N° de Aceptación").getValue().toString();
                        observacio = tabla.getContainerDataSource().getItem(i).getItemProperty("Observaciones").getValue().toString();
                        fechaAceptacion = tabla.getContainerDataSource().getItem(i).getItemProperty("Fecha de Aceptación").getValue().toString();//OK
                        horaAceptacion = tabla.getContainerDataSource().getItem(i).getItemProperty("Hora de Aceptación").getValue().toString();//OK
                        nomUsuarioOperador = tabla.getContainerDataSource().getItem(i).getItemProperty("Nombre Usuario Operador").getValue().toString();//OK
                        claseAceptacion = tabla.getContainerDataSource().getItem(i).getItemProperty("Clase de Acciones").getValue().toString();//OK
                        consecutivoOferta = tabla.getContainerDataSource().getItem(i).getItemProperty("Consecutivo Oferta de Venta").getValue().toString();//OK
                        nombreEntidad = tabla.getContainerDataSource().getItem(i).getItemProperty("Nombre de la SCB/Entidad").getValue().toString();//OK
                        codEntidad = tabla.getContainerDataSource().getItem(i).getItemProperty("Código de la SCB/Entidad").getValue().toString();//OK
                        exisPreacuerdo = tabla.getContainerDataSource().getItem(i).getItemProperty("Existe Preacuerdo").getValue().toString();//OK
                        nombreRepresentante = tabla.getContainerDataSource().getItem(i).getItemProperty("Nombre del Representante Legal de la SCB").getValue().toString();//OK
                        nombApellidoRazon = tabla.getContainerDataSource().getItem(i).getItemProperty("Nombres y Apellidos / Razón Social").getValue().toString();
                        tipoDocumento = tabla.getContainerDataSource().getItem(i).getItemProperty("Tipo de Documento").getValue().toString();//OK
                        numDocumento = tabla.getContainerDataSource().getItem(i).getItemProperty("Número de Documento").getValue().toString();//OK
                        digitoVerificacion = tabla.getContainerDataSource().getItem(i).getItemProperty("Dígito de Verificación").getValue().toString();//OK
                        espeFiduciario = tabla.getContainerDataSource().getItem(i).getItemProperty("Especial Fiduciario").getValue().toString();//OK
                        cuentaInversionista = tabla.getContainerDataSource().getItem(i).getItemProperty("Cuenta Inversionista").getValue().toString();//OK
                        condicionTodoNada = tabla.getContainerDataSource().getItem(i).getItemProperty("Se Vende con Condición Todo o Nada").getValue().toString();//OK
                        numAccionVender = tabla.getContainerDataSource().getItem(i).getItemProperty("No. de Acciones que Acepto Vender").getValue().toString();//OK
                        estado = tabla.getContainerDataSource().getItem(i).getItemProperty("Estado").getValue().toString();
                        rechazo =   tabla.getContainerDataSource().getItem(i).getItemProperty("Rechazada").getValue().toString();
                        porComision =   tabla.getContainerDataSource().getItem(i).getItemProperty("Porcentaje de Comisión").getValue().toString().replaceAll("[ %]", "");;
                        if (muestraDireccion.equals("1")) {
                         direccion =  tabla.getContainerDataSource().getItem(i).getItemProperty("Dirección").getValue().toString();//OK
                        }
                        try {
                            String[] idMila = facade.CargarIdMila(idAceptacion);
                            comboMILA = Integer.parseInt(idMila[0]);
                        } catch (SQLException ex) {
                            Logger.getLogger(RechazoAceptaciones.class.getName()).log(Level.SEVERE, null, ex);
                        }
                                      
                         
                        //String  observacion = txtObservaciones.getValue().toString();
                        if (estado.equals("")) {

                            Notification.show("Debe seleccionar una opción de rechazo",
                                    Notification.Type.ERROR_MESSAGE);
                        } else { 
                           modificarRechazoAceptaciones();
                       } 
                    }
                });
            }
            tabla.setColumnAlignment("No. de Acciones que Acepto Vender", Table.Align.RIGHT); 
            if (listAceptaciones.get(0).size() == 0) {

                Notification.show("No hay Aceptaciones",
                        Notification.Type.TRAY_NOTIFICATION);
                tabla.setVisible(false);
              }
            }
          }
        }

        tabla.setContainerDataSource(ic);
        tabla.setImmediate(true);
  }
    
    private void cargarTabla() {
        
        String tfNumAceptaciones = "";
        String reformattedIni = "";
        String reformattedFin = "";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        //Num Aceptacion
        try {
            tfNumAceptaciones = txtnumAceptacion.getValue().toString();
        } catch (Exception e) {
            tfNumAceptaciones = "";
        }
        //Fecha inicio operacion
        try {
            reformattedFin = df.format(datef_fechaFinOperacion.getValue());

        } catch (Exception e) {
            reformattedFin = "";

        }
        //Fecha fin operacion 
        try {
            reformattedIni = df.format(datef_fechaInicioOperacion.getValue());
        } catch (Exception e) {
            reformattedIni = "";
        }

           

            tabla.getContainerDataSource().removeAllItems();
            String idUsuario = userDetailsService.getUsuarioAutenticado().getId().toString();
            int i;
            List<List<String>> listAceptaciones;
                        
            listAceptaciones = facade.ListarDemandasRechazadas(idUsuario, tfNumAceptaciones, reformattedIni, reformattedFin);
            
             
            if (listAceptaciones.get(0).size() != 0) {
           
            for (i = 0; i < listAceptaciones.get(0).size(); i++) {
                //Preacuerdo 1 Si - 2 No
                String nomPreacuerdo = "";
                nomPreacuerdo = listAceptaciones.get(5).get(i);//OK
                
                if (nomPreacuerdo==null){
                    nomPreacuerdo="";
                } else if (nomPreacuerdo.equals("1")) {
                    nomPreacuerdo = "Si";
                } else if (nomPreacuerdo.equals("2")) {
                    nomPreacuerdo = "No";
                } 
                      
                //id y Origen MILA
                
                //Rechazada 1 Si - 2 No
                String rechazado = "";
                if (listAceptaciones.get(20).get(i).equals("Rechazado")) {//OK
                    rechazado = "Si";
                } else if (!listAceptaciones.get(20).get(i).equals("Rechazado")) {
                    rechazado = "No";
                }
                
         
                //Se vende con condición todo o nada
                String nomConTodoNada = "";
                nomConTodoNada = listAceptaciones.get(10).get(i);
                  
                 if (nomConTodoNada == null) {
                    nomConTodoNada = "";
                   }  else if (nomConTodoNada.equals("1")) {
                    nomConTodoNada = "Si";
                } else if (nomConTodoNada.equals("0") || nomConTodoNada.equals("2")) {
                    nomConTodoNada = "No";
                }
                 
                //Digito de verificación
                String digVerificacion = "";
                digVerificacion= listAceptaciones.get(13).get(i);//OK
                
                if (digVerificacion==null) {
                    digVerificacion = "";
                } else {
                    digVerificacion= listAceptaciones.get(13).get(i);
                }
                
                //observacion
                String observacion = "";
                observacion = listAceptaciones.get(22).get(i);//OK

                if (observacion == null) {
                    observacion = "";
                } else {
                    observacion = listAceptaciones.get(22).get(i);
                }

      	  
	          //estado
                String estadorec = listAceptaciones.get(20).get(i);//OK
                
                precioAccion = listAceptaciones.get(27).get(i);
                  
                //porcentaje Comsión
                String porcentajeComision = listAceptaciones.get(28).get(i).replace(".", ",");
                  
                Item item = ic.addItem(i);
                item.getItemProperty("N° de Aceptación").setValue(Integer.valueOf(listAceptaciones.get(0).get(i)));//OK
                item.getItemProperty("Fecha de Aceptación").setValue(listAceptaciones.get(17).get(i));//OK
                item.getItemProperty("Hora de Aceptación").setValue(listAceptaciones.get(18).get(i));//OK
                item.getItemProperty("Nombre Usuario Operador").setValue(listAceptaciones.get(21).get(i));//OK
                item.getItemProperty("Clase de Acciones").setValue(listAceptaciones.get(1).get(i));//OK
                item.getItemProperty("Consecutivo Oferta de Venta").setValue(listAceptaciones.get(2).get(i));//OK
                item.getItemProperty("Nombre de la SCB/Entidad").setValue(listAceptaciones.get(6).get(i));//OK
                item.getItemProperty("Código de la SCB/Entidad").setValue(listAceptaciones.get(23).get(i));//OK
                item.getItemProperty("Existe Preacuerdo").setValue(nomPreacuerdo);//OK
                item.getItemProperty("Nombre del Representante Legal de la SCB").setValue(listAceptaciones.get(8).get(i));//OK
                item.getItemProperty("Nombres y Apellidos / Razón Social").setValue(listAceptaciones.get(24).get(i)/*+" "+listAceptaciones.get(9).get(i)*/);
                item.getItemProperty("Tipo de Documento").setValue(listAceptaciones.get(11).get(i));//OK
                item.getItemProperty("Número de Documento").setValue(listAceptaciones.get(12).get(i));//OK
                item.getItemProperty("Dígito de Verificación").setValue(digVerificacion);//OK
                item.getItemProperty("Especial Fiduciario").setValue(listAceptaciones.get(14).get(i));//OK
                item.getItemProperty("Cuenta Inversionista").setValue(listAceptaciones.get(15).get(i));//OK
                item.getItemProperty("Se Vende con Condición Todo o Nada").setValue(nomConTodoNada);//OK
                item.getItemProperty("No. de Acciones que Acepto Vender").setValue((form3.format(Double.valueOf(listAceptaciones.get(9).get(i)))));//OK
                if (muestraDireccion.equals("1")) {
                    item.getItemProperty("Dirección").setValue(listAceptaciones.get(25).get(i));//OK
                }
                item.getItemProperty("Estado").setValue(listAceptaciones.get(20).get(i));//OK
                item.getItemProperty("Rechazada").setValue(rechazado);//OK
                item.getItemProperty("Observaciones").setValue(observacion);                  
                item.getItemProperty("Porcentaje de Comisión").setValue(porcentajeComision+" %");
              
                Button BtnEditar = new Button("Modificar");
                BtnEditar.setData(i);
                item.getItemProperty("Modificar").setValue(BtnEditar);
                
                BtnEditar.addClickListener(new Button.ClickListener() {
                    private static final long serialVersionUID = 1L;

                    public void buttonClick(ClickEvent event) {
                        int i = Integer.parseInt(event.getButton().getData().toString());
                        Item item=ic.getItem(i);
                        
                        idAceptacion=tabla.getContainerDataSource().getItem(i).getItemProperty("N° de Aceptación").getValue().toString();
                        observacio = tabla.getContainerDataSource().getItem(i).getItemProperty("Observaciones").getValue().toString();
                        fechaAceptacion = tabla.getContainerDataSource().getItem(i).getItemProperty("Fecha de Aceptación").getValue().toString();//OK
                        horaAceptacion = tabla.getContainerDataSource().getItem(i).getItemProperty("Hora de Aceptación").getValue().toString();//OK
                        nomUsuarioOperador = tabla.getContainerDataSource().getItem(i).getItemProperty("Nombre Usuario Operador").getValue().toString();//OK
                        claseAceptacion = tabla.getContainerDataSource().getItem(i).getItemProperty("Clase de Acciones").getValue().toString();//OK
                        consecutivoOferta = tabla.getContainerDataSource().getItem(i).getItemProperty("Consecutivo Oferta de Venta").getValue().toString();//OK
                        nombreEntidad = tabla.getContainerDataSource().getItem(i).getItemProperty("Nombre de la SCB/Entidad").getValue().toString();//OK
                        codEntidad = tabla.getContainerDataSource().getItem(i).getItemProperty("Código de la SCB/Entidad").getValue().toString();//OK
                        exisPreacuerdo = tabla.getContainerDataSource().getItem(i).getItemProperty("Existe Preacuerdo").getValue().toString();//OK
                        nombreRepresentante = tabla.getContainerDataSource().getItem(i).getItemProperty("Nombre del Representante Legal de la SCB").getValue().toString();//OK
                        nombApellidoRazon = tabla.getContainerDataSource().getItem(i).getItemProperty("Nombres y Apellidos / Razón Social").getValue().toString();
                        tipoDocumento = tabla.getContainerDataSource().getItem(i).getItemProperty("Tipo de Documento").getValue().toString();//OK
                        numDocumento = tabla.getContainerDataSource().getItem(i).getItemProperty("Número de Documento").getValue().toString();//OK
                        digitoVerificacion = tabla.getContainerDataSource().getItem(i).getItemProperty("Dígito de Verificación").getValue().toString();//OK
                        espeFiduciario = tabla.getContainerDataSource().getItem(i).getItemProperty("Especial Fiduciario").getValue().toString();//OK
                        cuentaInversionista = tabla.getContainerDataSource().getItem(i).getItemProperty("Cuenta Inversionista").getValue().toString();//OK
                        condicionTodoNada = tabla.getContainerDataSource().getItem(i).getItemProperty("Se Vende con Condición Todo o Nada").getValue().toString();//OK
                        numAccionVender = tabla.getContainerDataSource().getItem(i).getItemProperty("No. de Acciones que Acepto Vender").getValue().toString();//OK
                        estado = tabla.getContainerDataSource().getItem(i).getItemProperty("Estado").getValue().toString();
                        rechazo =   tabla.getContainerDataSource().getItem(i).getItemProperty("Rechazada").getValue().toString();
                        porComision =   tabla.getContainerDataSource().getItem(i).getItemProperty("Porcentaje de Comisión").getValue().toString().replaceAll("[ %]", "");
                        if (muestraDireccion.equals("1")) {
                         direccion =  tabla.getContainerDataSource().getItem(i).getItemProperty("Dirección").getValue().toString();//OK
                        }
                        try {
                            String[] idMila = facade.CargarIdMila(idAceptacion);
                            comboMILA = Integer.parseInt(idMila[0]);
                        } catch (SQLException ex) {
                            Logger.getLogger(RechazoAceptaciones.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        if (estado.equals("")) {

                            Notification.show("Debe seleccionar una opción de rechazo",
                                    Notification.Type.ERROR_MESSAGE);
                        } else { 
                        
                        modificarRechazoAceptaciones();
                         
                       }                          
                     
                    }
                });
            }
            tabla.setColumnAlignment("No. de Acciones que Acepto Vender", Table.Align.RIGHT); 

        }
        tabla.setContainerDataSource(ic);
        tabla.setImmediate(true);
    }
    
    public void ValidarError() {
        if (ValidaComponentError()) {
            error.setValue("Verificar campos en rojo");
        } else {
            error.setValue("");
        }
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
    
        public Boolean ValidaComponentError() {
        Boolean errores = false;
        
        if (txtnombreRazon.getComponentError() != null) {
            return true;
        }
        
        if (txtconsecutivoOferta.getComponentError() != null) {
            return true;
        }
        
        if (cbxexistePreacuerdo.getComponentError() != null) {
            return true;
        }
        
        if (txtrepresentante.getComponentError() != null) {
            return true;
        }

        if (cbxtipDocumento.getComponentError() != null) {
            return true;
        }

        if (txtnumeroDoc.getComponentError() != null || txtDigitoverificacion.getComponentError() != null) {
            return true;
        }
        
        if(txtCuentaInv.getComponentError() != null){
            return true;
        }
        
        if(cbxSevendetodoNada.getComponentError() != null){
            return true;
        }
        
        if(txtnumaceptVender.getComponentError() != null){
            return true;
        }
        
        if(cbxRechazada.getComponentError() != null){
            return true;
        }
        
        if(txtObservacion.getComponentError() != null){
            return true;
        }
        
        if(txtPorcentajeComision.getComponentError() != null){
            return true;
        }
        return errores;
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
        
    private void modificarRechazoAceptaciones() {
        error.setValue("");
        lberrorcmbR3.setValue("");
        lberrorcmbR2.setValue("");
        lberrorcmbR5.setValue("");
        lberrorcmbR6.setValue("");
      
        if (idAceptacion.equals("")) {
            Notification.show("Por favor Seleccione un Registro", Notification.Type.ERROR_MESSAGE);
          
        } else {

            subWindow = new Window("Modificación de Aceptaciones");
            subWindow.setHeight("520px");
            subWindow.setWidth("1010px");
            subWindow.setModal(true);
            subWindow.setClosable(true);
            subWindow.setResizable(false);

            VerticalLayout subContent = new VerticalLayout();
            HorizontalLayout HL = new HorizontalLayout();
            HL.setSpacing(true);
            GridLayout grid = new GridLayout(8, 24);
            grid.setSpacing(true);

            /**
             * **********************************************
             */
            /*N° de Aceptación*/
            /**
             * **********************************************
             */
            Label lbidAceptacion = new Label("N° de Aceptación");
            grid.addComponent(lbidAceptacion, 0, 0);
            grid.setComponentAlignment(lbidAceptacion, Alignment.MIDDLE_CENTER);
            lbidAceptacion.setWidth(11, Sizeable.Unit.EM);
            lbidAceptacion.setHeight(2, Sizeable.Unit.EM);

            TextField txtidAceptacion = new TextField();
            txtidAceptacion.setValue(idAceptacion);
            grid.addComponent(txtidAceptacion, 2, 0);
            grid.setComponentAlignment(txtidAceptacion, Alignment.MIDDLE_CENTER);
            txtidAceptacion.setWidth(15, Sizeable.Unit.EM);
            txtidAceptacion.setHeight(2, Sizeable.Unit.EM);
            txtidAceptacion.setEnabled(false);
            
                        /**
             * **********************************************
             */
            /*fecha Aceptacion*/
            /**
             * **********************************************
             */
            Label lbFechaAceptacion = new Label("Fecha de Aceptación");
            grid.addComponent(lbFechaAceptacion, 4, 0);
            grid.setComponentAlignment(lbFechaAceptacion, Alignment.MIDDLE_RIGHT);
            lbFechaAceptacion.setWidth(11, Sizeable.Unit.EM);
            lbFechaAceptacion.setHeight(2, Sizeable.Unit.EM);

            TextField txtfechaAceptacion = new TextField();
            txtfechaAceptacion.setValue(fechaAceptacion);
            grid.addComponent(txtfechaAceptacion, 6, 0);
            grid.setComponentAlignment(txtfechaAceptacion, Alignment.MIDDLE_CENTER);
            txtfechaAceptacion.setWidth(15, Sizeable.Unit.EM);
            txtfechaAceptacion.setHeight(2, Sizeable.Unit.EM);
            txtfechaAceptacion.setEnabled(false);

            /**
             * **********************************************
             */
            /*Hora Aceptacion*/
            /**
             * **********************************************
             */
            Label lbhoraAceptacion = new Label("Hora de Aceptación");
            grid.addComponent(lbhoraAceptacion, 0, 2);
            grid.setComponentAlignment(lbhoraAceptacion, Alignment.MIDDLE_CENTER);
            lbhoraAceptacion.setWidth(11, Sizeable.Unit.EM);
            lbhoraAceptacion.setHeight(2, Sizeable.Unit.EM);
            
            TextField txthoraAceptacion = new TextField();
            txthoraAceptacion.setValue(horaAceptacion);
            grid.addComponent(txthoraAceptacion, 2, 2);
            grid.setComponentAlignment(txtfechaAceptacion, Alignment.MIDDLE_CENTER);
            txthoraAceptacion.setWidth(15, Sizeable.Unit.EM);
            txthoraAceptacion.setHeight(2, Sizeable.Unit.EM);
            txthoraAceptacion.setEnabled(false);           
            

            /**
             * **********************************************
             */
            /*Nombre Usuario Operador*/
            /**
             * **********************************************
             */
            Label lbnombreUsuario = new Label("Nombre Usuario Operador");
            grid.addComponent(lbnombreUsuario, 4, 2);
            grid.setComponentAlignment(lbnombreUsuario, Alignment.MIDDLE_RIGHT);
            lbnombreUsuario.setWidth(11, Sizeable.Unit.EM);
            lbnombreUsuario.setHeight(2, Sizeable.Unit.EM);

            TextField txtnombreUsuario = new TextField();
            txtnombreUsuario.setValue(nomUsuarioOperador);
            grid.addComponent(txtnombreUsuario, 6, 2);
            grid.setComponentAlignment(txtnombreUsuario, Alignment.MIDDLE_CENTER);
            txtnombreUsuario.setWidth(15, Sizeable.Unit.EM);
            txtnombreUsuario.setHeight(2, Sizeable.Unit.EM);
            txtnombreUsuario.setEnabled(false);  

            /**
             * **********************************************
             */
            /*Clase de Acciones*/
            /**
             * **********************************************
             */
            Label lbclaseAcciones = new Label("Clase de Acciones");
            grid.addComponent(lbclaseAcciones, 0, 4);
            grid.setComponentAlignment(lbclaseAcciones, Alignment.MIDDLE_CENTER);
            lbclaseAcciones.setWidth(11, Sizeable.Unit.EM);
            lbclaseAcciones.setHeight(2, Sizeable.Unit.EM);

            TextField txtclaseAcciones = new TextField();
            txtclaseAcciones.setValue(claseAceptacion);
            grid.addComponent(txtclaseAcciones, 2, 4);
            grid.setComponentAlignment(txtclaseAcciones, Alignment.MIDDLE_CENTER);
            txtclaseAcciones.setWidth(15, Sizeable.Unit.EM);
            txtclaseAcciones.setHeight(2, Sizeable.Unit.EM);
            txtclaseAcciones.setEnabled(false);

            /**
             * **********************************************
             */
            /*Consecutivo Oferta de Venta*/
            /**
             * **********************************************
             */
            Label lbconsecutivoOferta = new Label("Consecutivo Oferta de Venta");
            grid.addComponent(lbconsecutivoOferta, 4, 4);
            grid.setComponentAlignment(lbconsecutivoOferta, Alignment.MIDDLE_RIGHT);
            lbconsecutivoOferta.setWidth(11, Sizeable.Unit.EM);
            lbconsecutivoOferta.setHeight(2, Sizeable.Unit.EM);

            Label lbasteris16 = new Label("*");
            lbasteris16.setStyleName("asterix");
            grid.addComponent(lbasteris16, 5, 4);
            grid.setComponentAlignment(lbasteris16, Alignment.MIDDLE_CENTER);
            lbasteris16.setWidth(5, Sizeable.Unit.EM);
            lbasteris16.setHeight(2, Sizeable.Unit.EM);
            
            txtconsecutivoOferta = new TextField();
            txtconsecutivoOferta.setValue(consecutivoOferta);
            grid.addComponent(txtconsecutivoOferta, 6, 4);
            grid.setComponentAlignment(txtconsecutivoOferta, Alignment.MIDDLE_CENTER);
            txtconsecutivoOferta.setWidth(15, Sizeable.Unit.EM);
            txtconsecutivoOferta.setHeight(2, Sizeable.Unit.EM);
            txtconsecutivoOferta.setMaxLength(8);
            //txtconsecutivoOferta.setEnabled(false);

            lberrorcmbR3.setStyleName("lblerrorestop");
            grid.addComponent(lberrorcmbR3, 6, 5);
            grid.setComponentAlignment(lberrorcmbR3, Alignment.BOTTOM_CENTER);
            lberrorcmbR3.setWidth(18, Sizeable.Unit.EM);
            lberrorcmbR3.setHeight(2, Sizeable.Unit.EM);

            txtconsecutivoOferta.addBlurListener(new FieldEvents.BlurListener() {
                @Override
                public void blur(FieldEvents.BlurEvent event) {
                    if (txtconsecutivoOferta.getValue().equals("")) {
                        txtconsecutivoOferta.setComponentError(new UserError(""));
                        lberrorcmbR3.setValue("Este campo es requerido");
                    } else {
                        if (txtconsecutivoOferta.getValue().matches(regexAlpha)) {
                            txtconsecutivoOferta.setComponentError(null);
                            lberrorcmbR3.setValue("");
                        } else {
                            txtconsecutivoOferta.setComponentError(new UserError(""));
                            lberrorcmbR3.setValue("Este campo contiene caracteres no válidos");
                        }
                    }
                    ValidarError();
                }
            });

            /**
             * **********************************************
             */
            /*Nombre de la SCB/Entidad*/
            /**
             * **********************************************
             */
            Label lbNombreScb = new Label("Nombre de la SCB/Entidad");
            grid.addComponent(lbNombreScb, 0, 6);
            grid.setComponentAlignment(lbNombreScb, Alignment.MIDDLE_CENTER);
            lbNombreScb.setWidth(11, Sizeable.Unit.EM);
            lbNombreScb.setHeight(2, Sizeable.Unit.EM);

            TextField txtNombreScb = new TextField();
            txtNombreScb.setValue(nombreEntidad);
            grid.addComponent(txtNombreScb, 2, 6);
            grid.setComponentAlignment(txtNombreScb, Alignment.MIDDLE_CENTER);
            txtNombreScb.setWidth(15, Sizeable.Unit.EM);
            txtNombreScb.setHeight(2, Sizeable.Unit.EM);
            txtNombreScb.setEnabled(false);

            /**
             * **********************************************
             */
            /*Código de la SCB/Entidad*/
            /**
             * **********************************************
             */
            Label lbcodigoEntidad = new Label("Código de la SCB/Entidad");
            grid.addComponent(lbcodigoEntidad, 4, 6);
            grid.setComponentAlignment(lbcodigoEntidad, Alignment.MIDDLE_CENTER);
            lbcodigoEntidad.setWidth(11, Sizeable.Unit.EM);
            lbcodigoEntidad.setHeight(2, Sizeable.Unit.EM);

            TextField txtCodigoScb = new TextField();
            txtCodigoScb.setValue(codEntidad);
            grid.addComponent(txtCodigoScb, 6, 6);
            grid.setComponentAlignment(txtNombreScb, Alignment.MIDDLE_CENTER);
            txtCodigoScb.setWidth(15, Sizeable.Unit.EM);
            txtCodigoScb.setHeight(2, Sizeable.Unit.EM);
            txtCodigoScb.setEnabled(false);

            /**
             * **********************************************
             */
            /*Existe Preacuerdo*/
            /**
             * **********************************************
             */
            Label lbexistePreacuerdo = new Label("Existe Preacuerdo");
            grid.addComponent(lbexistePreacuerdo, 0, 8);
            grid.setComponentAlignment(lbexistePreacuerdo, Alignment.MIDDLE_RIGHT);
            lbexistePreacuerdo.setWidth(11, Sizeable.Unit.EM);
            lbexistePreacuerdo.setHeight(2, Sizeable.Unit.EM);
            
            Label lbasteris15 = new Label("*");
            lbasteris15.setStyleName("asterix");
            grid.addComponent(lbasteris15, 1, 8);
            grid.setComponentAlignment(lbasteris15, Alignment.MIDDLE_CENTER);
            lbasteris15.setWidth(5, Sizeable.Unit.EM);
            lbasteris15.setHeight(2, Sizeable.Unit.EM);

            cbxexistePreacuerdo = new ComboBox();
            cbxexistePreacuerdo.setTextInputAllowed(false);
            cbxexistePreacuerdo.setNullSelectionAllowed(false);
            cbxexistePreacuerdo.addItem("");
            cbxexistePreacuerdo.setItemCaption("", "Seleccione");
            cbxexistePreacuerdo.select("");
            cbxexistePreacuerdo.addItem(1);
            cbxexistePreacuerdo.setItemCaption(1, "Si");
            cbxexistePreacuerdo.addItem(2);
            cbxexistePreacuerdo.setItemCaption(2, "No");

            if (exisPreacuerdo.equals("Si")) {
                cbxexistePreacuerdo.select(1);
            } else if (exisPreacuerdo.equals("No")) {
                cbxexistePreacuerdo.select(2);
            }
                        
            grid.addComponent(cbxexistePreacuerdo, 2, 8);
            grid.setComponentAlignment(cbxexistePreacuerdo, Alignment.MIDDLE_CENTER);
            cbxexistePreacuerdo.setWidth(15, Sizeable.Unit.EM);
            cbxexistePreacuerdo.setHeight(2, Sizeable.Unit.EM);
            if(exisPreacuerdo == null || exisPreacuerdo.isEmpty()){
                cbxexistePreacuerdo.setEnabled(false);
            }
            
            
            lberrorExistePre = new Label();
            lberrorExistePre.setStyleName("lblerrorcomboBox");
            grid.addComponent(lberrorExistePre, 2, 9);
            grid.setComponentAlignment(lberrorExistePre, Alignment.BOTTOM_CENTER);
            lberrorExistePre.setWidth(18, Sizeable.Unit.EM);
            lberrorExistePre.setHeight(2, Sizeable.Unit.EM);

            cbxexistePreacuerdo.addBlurListener(new FieldEvents.BlurListener() {
                @Override
                public void blur(FieldEvents.BlurEvent event) {
                    if (cbxexistePreacuerdo.getValue() == null || cbxexistePreacuerdo.getValue().equals("")) {
                        cbxexistePreacuerdo.setComponentError(new UserError(""));
                        lberrorExistePre.setValue("Este campo es requerido");
                    } else {
                        cbxexistePreacuerdo.setComponentError(null);
                        lberrorExistePre.setValue("");

                    }
                    ValidarError();
                }
            });
            
           

            /**
             * **********************************************
             */
            /*Nombre del Representante Legal de la SCB                       */
            /**
             * **********************************************
             */
            Label lbnombreRepresentanteLegal = new Label("Nombre del Representante Legal de la SCB");
            grid.addComponent(lbnombreRepresentanteLegal, 0, 10);
            grid.setComponentAlignment(lbnombreRepresentanteLegal, Alignment.MIDDLE_RIGHT);
            lbnombreRepresentanteLegal.setWidth(11, Sizeable.Unit.EM);
            lbnombreRepresentanteLegal.setHeight(2, Sizeable.Unit.EM);
            
            Label lbasteris14 = new Label("*");
            lbasteris14.setStyleName("asterix");
            grid.addComponent(lbasteris14, 1, 10);
            grid.setComponentAlignment(lbasteris14, Alignment.MIDDLE_CENTER);
            lbasteris14.setWidth(5, Sizeable.Unit.EM);
            lbasteris14.setHeight(2, Sizeable.Unit.EM);
            
            txtrepresentante = cargaRepresentante(codEntidad);
            txtrepresentante.select(nombreRepresentante.trim());
            
            grid.addComponent(txtrepresentante, 2, 10);
            grid.setComponentAlignment(txtrepresentante, Alignment.MIDDLE_CENTER);
            txtrepresentante.setWidth(15, Sizeable.Unit.EM);
            txtrepresentante.setHeight(2, Sizeable.Unit.EM);
            //txtnombreRepresentanteLegal.setEnabled(false);

            lberrorcmbR5.setStyleName("lblerrorestop");
            grid.addComponent(lberrorcmbR5, 2, 11);
            grid.setComponentAlignment(lberrorcmbR5, Alignment.BOTTOM_CENTER);
            lberrorcmbR5.setWidth(18, Sizeable.Unit.EM);
            lberrorcmbR5.setHeight(2, Sizeable.Unit.EM);
            

            txtrepresentante.addBlurListener(new FieldEvents.BlurListener() {

                @Override
                public void blur(FieldEvents.BlurEvent event) {

                    if (txtrepresentante.getValue() == null || txtrepresentante.getValue().equals("")) {
                        txtrepresentante.setComponentError(new UserError(""));
                        lberrorcmbR5.setValue("Este campo es requerido");
                    } else {
                        txtrepresentante.setComponentError(null);
                        lberrorcmbR5.setValue("");
                    }
                    ValidarError();
                }
            });

            /**
             * **********************************************
             */
            /*Nombre y Apellidos/Razón Social           */
            /**
             * **********************************************
             */
            lbnombreRazon = new Label("Nombre y Apellidos/Razón Social ");
            grid.addComponent(lbnombreRazon, 4, 10);
            grid.setComponentAlignment(lbnombreRazon, Alignment.MIDDLE_CENTER);
            lbnombreRazon.setWidth(11, Sizeable.Unit.EM);
            lbnombreRazon.setHeight(2, Sizeable.Unit.EM);
            
            lbasteris10 = new Label("*");
            lbasteris10.setStyleName("asterix");
            grid.addComponent(lbasteris10, 5, 10);
            grid.setComponentAlignment(lbasteris10, Alignment.MIDDLE_CENTER);
            lbasteris10.setWidth(5, Sizeable.Unit.EM);
            lbasteris10.setHeight(2, Sizeable.Unit.EM);

            txtnombreRazon = new TextField();
            txtnombreRazon.setValue(nombApellidoRazon);
            grid.addComponent(txtnombreRazon, 6, 10);
            grid.setComponentAlignment(txtnombreRazon, Alignment.MIDDLE_CENTER);
            txtnombreRazon.setWidth(15, Sizeable.Unit.EM);
            txtnombreRazon.setHeight(2, Sizeable.Unit.EM);
            txtnombreRazon.setMaxLength(60);

            lberrorcmbR2.setStyleName("lblerrorestop");
            grid.addComponent(lberrorcmbR2, 6, 11);
            grid.setComponentAlignment(lberrorcmbR2, Alignment.BOTTOM_CENTER);
            lberrorcmbR2.setWidth(18, Sizeable.Unit.EM);
            lberrorcmbR2.setHeight(2, Sizeable.Unit.EM);

            txtnombreRazon.addBlurListener(new FieldEvents.BlurListener() {
                @Override
                public void blur(FieldEvents.BlurEvent event) {
                    if (txtnombreRazon.getValue().equals("")) {
                        txtnombreRazon.setComponentError(new UserError(""));
                        lberrorcmbR2.setValue("Este campo es requerido");
                    } else {
                        if (txtnombreRazon.getValue().matches(regexTextTildesNumeros)) {
                            txtnombreRazon.setComponentError(null);
                            lberrorcmbR2.setValue("");
                        } else {
                            txtnombreRazon.setComponentError(new UserError(""));
                            lberrorcmbR2.setValue("Este campo contiene caracteres no válidos");
                        }
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
            grid.addComponent(lbtipDocumento, 0, 12);
            grid.setComponentAlignment(lbtipDocumento, Alignment.MIDDLE_CENTER);
            lbtipDocumento.setWidth(11, Sizeable.Unit.EM);
            lbtipDocumento.setHeight(2, Sizeable.Unit.EM);

            Label lbasteris3 = new Label("*");
            lbasteris3.setStyleName("asterix");
            grid.addComponent(lbasteris3, 1, 12);
            grid.setComponentAlignment(lbasteris3, Alignment.MIDDLE_CENTER);
            lbasteris3.setWidth(5, Sizeable.Unit.EM);
            lbasteris3.setHeight(2, Sizeable.Unit.EM);

            cbxtipDocumento = new ComboBox();
            cbxtipDocumento = LlenarTipoDocumentos();
            if (tipoDocumento.equals("Cédula de Ciudadanía")) {
                cbxtipDocumento.select(1);
            } else if (tipoDocumento.equals("Cédula de Extranjería")) {
                cbxtipDocumento.select(2);
            } else if (tipoDocumento.equals("Pasaporte")) {
                cbxtipDocumento.select(3);
            } else if (tipoDocumento.equals("NIT")) {
                cbxtipDocumento.select(4);
            } else if (tipoDocumento.equals("NIP o NUIP")) {
                cbxtipDocumento.select(5);
            } else if (tipoDocumento.equals("Tarjeta de Identidad")) {
                cbxtipDocumento.select(6);
            }

            grid.addComponent(cbxtipDocumento, 2, 12);
            grid.setComponentAlignment(cbxtipDocumento, Alignment.MIDDLE_CENTER);
            cbxtipDocumento.setWidth(15, Sizeable.Unit.EM);
            cbxtipDocumento.setHeight(3, Sizeable.Unit.EM);

            lberror3 = new Label();
            lberror3.setStyleName("lblerrorestop");
            grid.addComponent(lberror3, 2, 13);
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
                                txtEspecialFidu.setVisible(false);
                                txtEspecialFidu.setComponentError(null);
                                txtEspecialFidu.setValue("");
                                lberror6.setValue("");
                                txtnumeroDoc.setComponentError(null);
                                lberror8.setValue("");
                                lberrorcmbR3.setValue("");
                                lberrorcmbR2.setValue("");
                                lberrorcmbR5.setValue("");
                                lberrorcmbR6.setValue("");
                                txtconsecutivoOferta.setComponentError(null);
                                txtnombreRazon.setComponentError(null);
                                txtPorcentajeComision.setComponentError(null);
                                txtrepresentante.setComponentError(null);

                                if (valorCombo == 4) {
                                    txtDigitoverificacion.setVisible(true);
                                    txtDigitoverificacion.setEnabled(true);
                                    txtEspecialFidu.setVisible(true);
                                    txtEspecialFidu.setEnabled(true);

                                } else {
                                    txtDigitoverificacion.setVisible(false);
                                    txtDigitoverificacion.setComponentError(null);
                                    txtDigitoverificacion.setValue("");
                                    lberror12.setValue("");
                                    txtEspecialFidu.setVisible(false);
                                    txtEspecialFidu.setComponentError(null);
                                    txtEspecialFidu.setValue("");
                                    lberror6.setValue("");
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
             grid.addComponent(lbnumeroDoc, 4, 12);
             grid.setComponentAlignment(lbnumeroDoc, Alignment.MIDDLE_RIGHT);
             lbnumeroDoc.setWidth(11, Sizeable.Unit.EM);
             lbnumeroDoc.setHeight(2, Sizeable.Unit.EM);

             Label lbasteris7 = new Label("*");
             lbasteris7.setStyleName("asterix");
             grid.addComponent(lbasteris7, 5, 12);
             grid.setComponentAlignment(lbasteris7, Alignment.MIDDLE_CENTER);
             lbasteris7.setWidth(5, Sizeable.Unit.EM);
             lbasteris7.setHeight(2, Sizeable.Unit.EM);

             txtnumeroDoc = new TextField();
             txtnumeroDoc.setValue(numDocumento);
             grid.addComponent(txtnumeroDoc, 6, 12);
             grid.setComponentAlignment(txtnumeroDoc, Alignment.MIDDLE_CENTER);
             txtnumeroDoc.setWidth(15, Sizeable.Unit.EM);
             txtnumeroDoc.setHeight(2, Sizeable.Unit.EM);
             txtnumeroDoc.setMaxLength(15);

            lberror8 = new Label();
            lberror8.setStyleName("lblerrorestop");
            grid.addComponent(lberror8, 6, 13);
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
           txtDigitoverificacion.setValue(digitoVerificacion);
           grid.addComponent(txtDigitoverificacion, 7, 12);
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
           grid.addComponent(lberror12, 7, 13);
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

             lbEspecialFidu = new Label("Especial Fiduciario");
             grid.addComponent(lbEspecialFidu, 0, 14);
             grid.setComponentAlignment(lbEspecialFidu, Alignment.MIDDLE_CENTER);
             lbEspecialFidu.setWidth(11, Sizeable.Unit.EM);
             lbEspecialFidu.setHeight(2, Sizeable.Unit.EM);

             txtEspecialFidu = new TextField();
             txtEspecialFidu.setValue(espeFiduciario);
             grid.addComponent(txtEspecialFidu, 2, 14);
             grid.setComponentAlignment(txtEspecialFidu, Alignment.MIDDLE_CENTER);
             txtEspecialFidu.setWidth(15, Sizeable.Unit.EM);
             txtEspecialFidu.setHeight(2, Sizeable.Unit.EM);
             txtEspecialFidu.setVisible(false);
             txtEspecialFidu.setMaxLength(3);
             
            valorCombo = Integer.parseInt(cbxtipDocumento.getValue().toString());
            if (valorCombo == 4) {
                txtEspecialFidu.setVisible(true);
                txtEspecialFidu.setEnabled(true);
            } else {

                txtEspecialFidu.setVisible(false);
                txtEspecialFidu.setEnabled(false);
            }
            
             lberror6 = new Label();
             lberror6.setStyleName("lblerrorestop");
             grid.addComponent(lberror6, 2, 15);
             grid.setComponentAlignment(lberror6, Alignment.BOTTOM_CENTER);
             lberror6.setWidth(18, Sizeable.Unit.EM);
             lberror6.setHeight(2, Sizeable.Unit.EM);

             txtEspecialFidu.addBlurListener(new FieldEvents.BlurListener() {

                 @Override
                 public void blur(FieldEvents.BlurEvent event) {
                     if (!txtEspecialFidu.getValue().matches(regexAlpha)) {
                         txtEspecialFidu.setComponentError(new UserError(""));
                         lberror6.setValue("Este campo contiene caracteres no válidos");
                     }else {
                             txtEspecialFidu.setComponentError(null);
                             lberror6.setValue("");
                         }
                     
                     ValidarError();
                 }
             });
             
            Label lbcuentaInversi = new Label("Cuenta Inversionista");
            grid.addComponent(lbcuentaInversi, 4, 14);
            grid.setComponentAlignment(lbcuentaInversi, Alignment.MIDDLE_CENTER);
            lbcuentaInversi.setWidth(11, Sizeable.Unit.EM);
            lbcuentaInversi.setHeight(2, Sizeable.Unit.EM);
            
            Label lbasteris11 = new Label("*");
            lbasteris11.setStyleName("asterix");
            grid.addComponent(lbasteris11, 5, 14);
            grid.setComponentAlignment(lbasteris11, Alignment.MIDDLE_CENTER);
            lbasteris11.setWidth(5, Sizeable.Unit.EM);
            lbasteris11.setHeight(2, Sizeable.Unit.EM);
            
            txtCuentaInv = new TextField();
            txtCuentaInv.setValue(cuentaInversionista);
            grid.addComponent(txtCuentaInv, 6, 14);
            grid.setComponentAlignment(txtCuentaInv, Alignment.MIDDLE_CENTER);
            txtCuentaInv.setWidth(15, Sizeable.Unit.EM);
            txtCuentaInv.setHeight(2, Sizeable.Unit.EM);
            txtCuentaInv.setMaxLength(8);
            
             lberror7 = new Label();
             lberror7.setStyleName("lblerrorestop");
             grid.addComponent(lberror7, 6, 15);
             grid.setComponentAlignment(lberror7, Alignment.BOTTOM_CENTER);
             lberror7.setWidth(18, Sizeable.Unit.EM);
             lberror7.setHeight(2, Sizeable.Unit.EM);

            txtCuentaInv.addBlurListener(new FieldEvents.BlurListener() {

                @Override
                public void blur(FieldEvents.BlurEvent event) {

                    if (!txtCuentaInv.getValue().equals("")) {
                        if (txtCuentaInv.getValue().matches(regexNumeric)) {

                            if (Integer.parseInt(txtCuentaInv.getValue()) > 0) {
                                txtCuentaInv.setComponentError(null);
                                lberror7.setValue("");
                            } else {
                                txtCuentaInv.setComponentError(new UserError(""));
                                lberror7.setValue("Cuenta Inversionista Inválida");
                            }

                        } else {
                            txtCuentaInv.setComponentError(new UserError(""));
                            lberror7.setValue("Este campo contiene caracteres no válidos");
                        }
                    } else {
                        txtCuentaInv.setComponentError(new UserError(""));
                        lberror7.setValue("Este campo es requerido");
                    }
                    ValidarError();
                }
            });
             
            Label lbsevendeTodoNada = new Label("Se Vende con Condición Todo o Nada");
            grid.addComponent(lbsevendeTodoNada, 0, 16);
            grid.setComponentAlignment(lbsevendeTodoNada, Alignment.MIDDLE_CENTER);
            lbsevendeTodoNada.setWidth(11, Sizeable.Unit.EM);
            lbsevendeTodoNada.setHeight(2, Sizeable.Unit.EM);
            
            cbxSevendetodoNada = new ComboBox();
            cbxSevendetodoNada.setTextInputAllowed(false);
            cbxSevendetodoNada.setNullSelectionAllowed(false);
            cbxSevendetodoNada.addItem("");
            cbxSevendetodoNada.setItemCaption("", "Seleccione");
            cbxSevendetodoNada.select("");
            cbxSevendetodoNada.addItem(1);
            cbxSevendetodoNada.setItemCaption(1, "Si");
            cbxSevendetodoNada.addItem(0);
            cbxSevendetodoNada.setItemCaption(0, "No");
            
            if (condicionTodoNada.equals("Si")) {
                cbxSevendetodoNada.select(1);
            } else if (condicionTodoNada.equals("No")) {
                cbxSevendetodoNada.select(0);
            }
            
            Label lbasteris12 = new Label("*");
            lbasteris12.setStyleName("asterix");
            grid.addComponent(lbasteris12, 1, 16);
            grid.setComponentAlignment(lbasteris12, Alignment.MIDDLE_CENTER);
            lbasteris12.setWidth(5, Sizeable.Unit.EM);
            lbasteris12.setHeight(2, Sizeable.Unit.EM);
            
            grid.addComponent(cbxSevendetodoNada, 2, 16);
            grid.setComponentAlignment(cbxSevendetodoNada, Alignment.MIDDLE_CENTER);
            cbxSevendetodoNada.setWidth(15, Sizeable.Unit.EM);
            cbxSevendetodoNada.setHeight(2, Sizeable.Unit.EM);
            if(condicionTodoNada == null || condicionTodoNada.equals("") || condicionTodoNada.isEmpty()){
                cbxSevendetodoNada.setEnabled(false);
            }

            lberror11 = new Label();
            lberror11.setStyleName("lblerrorcomboBox");
            grid.addComponent(lberror11, 2, 17);
            grid.setComponentAlignment(lberror11, Alignment.BOTTOM_CENTER);
            lberror11.setWidth(18, Sizeable.Unit.EM);
            lberror11.setHeight(2, Sizeable.Unit.EM);
            
            cbxSevendetodoNada.addBlurListener(new FieldEvents.BlurListener() {
                @Override
                public void blur(FieldEvents.BlurEvent event) {
                    if (cbxSevendetodoNada.getValue() == null || cbxSevendetodoNada.getValue().equals("")) {
                        cbxSevendetodoNada.setComponentError(new UserError(""));
                        lberror11.setValue("Este campo es requerido");
                    } else {
                        cbxSevendetodoNada.setComponentError(null);
                        lberror11.setValue("");

                    }
                    ValidarError();
                }
            });
            
            Label lbGeneral = new Label("No. de Acciones que Acepto Vender");
            grid.addComponent(lbGeneral, 4, 16);
            grid.setComponentAlignment(lbGeneral, Alignment.MIDDLE_CENTER);
            lbGeneral.setWidth(11, Sizeable.Unit.EM);
            lbGeneral.setHeight(2, Sizeable.Unit.EM);
            
            Label lbasteris13 = new Label("*");
            lbasteris13.setStyleName("asterix");
            grid.addComponent(lbasteris13, 5, 16);
            grid.setComponentAlignment(lbasteris10, Alignment.MIDDLE_CENTER);
            lbasteris13.setWidth(5, Sizeable.Unit.EM);
            lbasteris13.setHeight(2, Sizeable.Unit.EM);
            
            txtnumaceptVender = new TextField();
            txtnumaceptVender.setValue(numAccionVender);
            grid.addComponent(txtnumaceptVender, 6, 16);
            grid.setComponentAlignment(txtnumaceptVender, Alignment.MIDDLE_CENTER);
            txtnumaceptVender.setWidth(15, Sizeable.Unit.EM);
            txtnumaceptVender.setHeight(2, Sizeable.Unit.EM);
            txtnumaceptVender.setMaxLength(11);
            
            lberror10 = new Label();
            lberror10.setStyleName("lblerrorestop");
            grid.addComponent(lberror10, 6, 17);
            grid.setComponentAlignment(lberror7, Alignment.BOTTOM_CENTER);
            lberror10.setWidth(18, Sizeable.Unit.EM);
            lberror10.setHeight(2, Sizeable.Unit.EM);
            
             txtnumaceptVender.addBlurListener(new FieldEvents.BlurListener() {

                @Override
                public void blur(FieldEvents.BlurEvent event) {
                    if (txtnumaceptVender.getValue().equals("")) {
                        txtnumaceptVender.setComponentError(new UserError(""));
                        lberror10.setValue("Este campo es requerido");
                    } else if (txtnumaceptVender.getValue().matches(regexNumericFormat)) {
                        if (EsEntero(txtnumaceptVender.getValue())) {

                            Double num = 0.0;
                            BigDecimal cantidadAcc = new BigDecimal(Double.valueOf(txtnumaceptVender.getValue().replace(".", "").split("&")[0]));
                            num = cantidadAcc.doubleValue();

                            try {

                                txtnumaceptVender.setValue(moneyFormatter.format(Double.parseDouble(txtnumaceptVender.getValue().replace(".", "").split("&")[0])));
                                if ((!txtnumaceptVender.getValue().toString().equalsIgnoreCase("0"))) {

                                    txtnumaceptVender.setComponentError(null);
                                    lberror10.setValue("");
                                } else {
                                    txtnumaceptVender.setComponentError(new UserError(""));
                                    lberror10.setValue("Cantidad de Acciones Invalida");
                                }

                            } catch (Validator.InvalidValueException e) {
                                txtnumaceptVender.setComponentError(new UserError(""));
                                lberror10.setValue(e.getMessage());
                            }
                        } else {
                            txtnumaceptVender.setComponentError(new UserError(""));
                            lberror10.setValue("Cantidad de Acciones Invalida");

                        }
                    } else {
                        txtnumaceptVender.setComponentError(new UserError(""));
                        lberror10.setValue("Este campo contiene caracteres no válidos");
                    }
                    ValidarError();
                }
            });
             
            Label lbEstado = new Label("Estado");
            grid.addComponent(lbEstado, 0, 18);
            grid.setComponentAlignment(lbEstado, Alignment.MIDDLE_CENTER);
            lbEstado.setWidth(11, Sizeable.Unit.EM);
            lbEstado.setHeight(2, Sizeable.Unit.EM);
            
            txtEstado = new TextField();
            txtEstado.setValue(estado);
            grid.addComponent(txtEstado, 2, 18);
            grid.setComponentAlignment(txtEstado, Alignment.MIDDLE_CENTER);
            txtEstado.setWidth(15, Sizeable.Unit.EM);
            txtEstado.setHeight(2, Sizeable.Unit.EM);
            txtEstado.setEnabled(false);
            
            Label lbRechazada = new Label("Rechazada");
            grid.addComponent(lbRechazada, 4, 18);
            grid.setComponentAlignment(lbsevendeTodoNada, Alignment.MIDDLE_CENTER);
            lbRechazada.setWidth(11, Sizeable.Unit.EM);
            lbRechazada.setHeight(2, Sizeable.Unit.EM);
            
            Label lbasteris17 = new Label("*");
            lbasteris17.setStyleName("asterix");
            grid.addComponent(lbasteris17, 5, 18);
            grid.setComponentAlignment(lbasteris16, Alignment.MIDDLE_CENTER);
            lbasteris17.setWidth(5, Sizeable.Unit.EM);
            lbasteris17.setHeight(2, Sizeable.Unit.EM);
            
            cbxRechazada = new ComboBox();
            cbxRechazada.setTextInputAllowed(false);
            cbxRechazada.setNullSelectionAllowed(false);
            cbxRechazada.addItem("");
            cbxRechazada.setItemCaption("", "Seleccione");
            cbxRechazada.addItem(1);
            cbxRechazada.setItemCaption(1, "Si");
            cbxRechazada.addItem(2);
            cbxRechazada.setItemCaption(2, "No");
            
            if (estado.equals("Rechazado")) {
                cbxRechazada.select(1);
            } else if (!estado.equals("Rechazado")) {
                cbxRechazada.select(2);
            }

            grid.addComponent(cbxRechazada, 6, 18);
            grid.setComponentAlignment(cbxRechazada, Alignment.MIDDLE_CENTER);
            cbxRechazada.setWidth(15, Sizeable.Unit.EM);
            cbxRechazada.setHeight(2, Sizeable.Unit.EM);
            
            errRechazada = new Label();
            errRechazada.setStyleName("lblerrorestop");
            grid.addComponent(errRechazada, 6, 20);
            grid.setComponentAlignment(errRechazada, Alignment.BOTTOM_CENTER);
            errRechazada.setWidth(18, Sizeable.Unit.EM);
            errRechazada.setHeight(2, Sizeable.Unit.EM);
            
            cbxRechazada.addBlurListener(new FieldEvents.BlurListener() {
                @Override
                public void blur(FieldEvents.BlurEvent event) {
                    if (cbxRechazada.getValue() == null || cbxRechazada.getValue().equals("")) {
                        cbxRechazada.setComponentError(new UserError(""));
                        errRechazada.setValue("Debe selecionar una opción de rechazo");
                    } else {
                        cbxRechazada.setComponentError(null);
                        errRechazada.setValue("");

                    }
                    ValidarError();
                }
            });
            
            /**
             * **********************************************
             */
            /*Observaciones*/
            /**
             * **********************************************
             */
            
            Label lbObservacion = new Label("Observaciones");
            grid.addComponent(lbObservacion, 0, 21);
            grid.setComponentAlignment(lbObservacion, Alignment.MIDDLE_CENTER);
            lbObservacion.setWidth(11, Sizeable.Unit.EM);
            lbRechazada.setHeight(2, Sizeable.Unit.EM);
            
            
            txtObservacion = new TextField();
            txtObservacion.setValue(observacio);
            grid.addComponent(txtObservacion, 2, 21);
            grid.setComponentAlignment(txtObservacion, Alignment.MIDDLE_CENTER);
            txtObservacion.setWidth(15, Sizeable.Unit.EM);
            txtObservacion.setHeight(2, Sizeable.Unit.EM);
            txtObservacion.setMaxLength(200);
            
            errObservacion = new Label();
            errObservacion.setStyleName("lblerrorestop");
            grid.addComponent(errObservacion, 2, 22);
            grid.setComponentAlignment(errObservacion, Alignment.BOTTOM_CENTER);
            errObservacion.setWidth(15, Sizeable.Unit.EM);
            errObservacion.setHeight(2, Sizeable.Unit.EM);
            
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
			
            /**
             * **********************************************
             */
            /*Porcentaje de comisión*/
            /**
             * **********************************************
             */
            Label lbporcentajeComision = new Label("Porcentaje de comisión");
            grid.addComponent(lbporcentajeComision, 4, 21);
            grid.setComponentAlignment(lbporcentajeComision, Alignment.MIDDLE_RIGHT);
            lbporcentajeComision.setWidth(11, Sizeable.Unit.EM);
            lbporcentajeComision.setHeight(2, Sizeable.Unit.EM);
            
            
            txtPorcentajeComision = new TextField();
            txtPorcentajeComision.setValue(porComision);
            grid.addComponent(txtPorcentajeComision, 6, 21);
            grid.setComponentAlignment(txtPorcentajeComision, Alignment.MIDDLE_CENTER);
            txtPorcentajeComision.setWidth(15, Sizeable.Unit.EM);
            txtPorcentajeComision.setHeight(2, Sizeable.Unit.EM);
            txtPorcentajeComision.setMaxLength(7);
            
            lberrorcmbR6.setStyleName("lblerrorestop");
            grid.addComponent(lberrorcmbR6, 6, 22);
            grid.setComponentAlignment(lberrorcmbR6, Alignment.BOTTOM_CENTER);
            lberrorcmbR6.setWidth(18, Sizeable.Unit.EM);
            lberrorcmbR6.setHeight(2, Sizeable.Unit.EM);

            Label lbPorcentaje = new Label("%");
            grid.addComponent(lbPorcentaje, 7, 21);
            grid.setComponentAlignment(lbPorcentaje, Alignment.MIDDLE_RIGHT);
            lbPorcentaje.setWidth(2, Sizeable.Unit.EM);
            lbPorcentaje.setHeight(2, Sizeable.Unit.EM);            
            
            txtPorcentajeComision.addBlurListener(new FieldEvents.BlurListener() {

                @Override
                public void blur(FieldEvents.BlurEvent event) {

                    if (!txtPorcentajeComision.getValue().equals("")) {

                        if (txtPorcentajeComision.getValue().matches(regexNumericPuntComa)) {
                            if (txtPorcentajeComision.getValue().matches(regexTresDecimales)) {
                                try {
                                    Double num = 0.0;
                                    /*                        DecimalFormatSymbols simbolo2 = new DecimalFormatSymbols();
                            simbolo2.setDecimalSeparator(',');
                            simbolo2.setGroupingSeparator('.');*/
                                    //Double valor = Double.parseDouble(txtf_precioDeLaOferta.getValue().replace(".", "").split("&")[0]);
                                    Number valor = form2.parse(txtPorcentajeComision.getValue());
                                    num = valor.doubleValue();
                                    if (num > 100) {
                                        txtPorcentajeComision.setComponentError(new UserError(""));
                                        lberrorcmbR6.setValue("Porcentaje no válido, debe ser entre 0% y 100%");

                                    }
                                    if (0 <= num && num <= 100) {
                                        txtPorcentajeComision.setValue(form2.format(num));
                                        txtPorcentajeComision.setComponentError(null);
                                        lberrorcmbR6.setValue("");
                                    }
                                } catch (ParseException ex) {
                                    logger.error("OPI - " + CrearAceptaciones.class.getName(), ex);
                                }
                            } else {
                                txtPorcentajeComision.setComponentError(new UserError(""));
                                lberrorcmbR6.setValue("El valor supera el máximo de decimales permitidos");
                            }

                        } else {
                            txtPorcentajeComision.setComponentError(new UserError(""));
                            lberrorcmbR6.setValue("Este campo contiene caracteres no válidos");
                        }
                    } else {
                        txtPorcentajeComision.setComponentError(null);
                        lberrorcmbR6.setValue("");

                    }

                    ValidarError();
                }
            });
            
                      
            cmbOrigenMila = new ComboBox();            
            cmbOrigenMila.setTextInputAllowed(false);
            cmbOrigenMila.setNullSelectionAllowed(false);
            cmbOrigenMila = listarOrigenMILA();
            cmbOrigenMila.select(comboMILA);
            if (comboMILA > 0 && Integer.parseInt(parametrosList.get(44)) == 1) {
                mostrarMila();
            }
            /**
             * **********************************************
             */
            /*Origen Operación MILA*/
            /**
             * **********************************************
             */
            if (Integer.parseInt(parametrosList.get(44)) == 1) {
            Label lboperacionMilla = new Label("Origen Operación MILA");
            grid.addComponent(lboperacionMilla, 4, 8);
            grid.setComponentAlignment(lboperacionMilla, Alignment.MIDDLE_RIGHT);
            lboperacionMilla.setWidth(11, Sizeable.Unit.EM);
            lboperacionMilla.setHeight(2, Sizeable.Unit.EM);         
            
            grid.addComponent(cmbOrigenMila, 6, 8);
            grid.setComponentAlignment(cmbOrigenMila, Alignment.MIDDLE_CENTER);
            cmbOrigenMila.setWidth(15, Sizeable.Unit.EM);
            cmbOrigenMila.setHeight(2, Sizeable.Unit.EM);
            
            lberrorMILA = new Label();
            lberrorMILA.setStyleName("lblerrorcomboBox");
            grid.addComponent(lberrorMILA, 6, 9);
            grid.setComponentAlignment(lberrorMILA, Alignment.BOTTOM_CENTER);
            lberrorMILA.setWidth(18, Sizeable.Unit.EM);
            lberrorMILA.setHeight(2, Sizeable.Unit.EM);
            
            cmbOrigenMila.addBlurListener(new FieldEvents.BlurListener() {
                @Override
                public void blur(FieldEvents.BlurEvent event) {
                    if (cmbOrigenMila.getValue() == null || Integer.parseInt(cmbOrigenMila.getValue().toString()) == 0) {
                        cbxtipDocumento.setValue("");
                        txtrepresentante.setComponentError(null);
                        txtnombreRazon.setValue("");
                        txtnumeroDoc.setValue("");
                        txtDigitoverificacion.setValue("");
                        txtCuentaInv.setValue("");
                        lberror3.setValue("");
                        lberror12.setValue("");
                        lberror7.setValue("");
                        lberror8.setValue("");
                        lberrorcmbR3.setValue("");
                        lberrorcmbR2.setValue("");
                        lberrorcmbR5.setValue("");
                        lberrorcmbR6.setValue("");
                        txtconsecutivoOferta.setComponentError(null);
                        txtnombreRazon.setComponentError(null);
                        txtPorcentajeComision.setComponentError(null);
                        txtrepresentante.setComponentError(null);
                        cbxtipDocumento.setComponentError(null);
                        txtnumeroDoc.setComponentError(null);
                        txtnombreRazon.setComponentError(null);
                        /*razonSocial.setComponentError(null);*/
                        txtDigitoverificacion.setComponentError(null);
                        txtCuentaInv.setComponentError(null);
                        cbxtipDocumento.setEnabled(true);
                        txtnumeroDoc.setEnabled(true);
                        txtnombreRazon.setEnabled(true);
                        txtDigitoverificacion.setEnabled(true);
                        txtCuentaInv.setEnabled(true);
                        lbEspecialFidu.setVisible(true);
                        txtEspecialFidu.setVisible(true);                                                
                    }
                    ValidarError();
                }
            });
            
            cmbOrigenMila.addValueChangeListener(new Property.ValueChangeListener() {
                @Override
                public void valueChange(Property.ValueChangeEvent event) {
                    try {
                        valorComboMila = (Integer) cmbOrigenMila.getValue();

                        if (valorComboMila > 0) {
                            OrigenMILA m = llenadoCampoMILA(valorComboMila);
                            txtnombreRazon.setEnabled(false);
                            txtnombreRazon.setValue(m.getPais());
                            txtnombreRazon.setComponentError(null);
                            lbasteris10.setVisible(Boolean.TRUE);
                            cbxtipDocumento.setValue(4);
                            txtDigitoverificacion.setVisible(true);
                            txtnumeroDoc.setValue(m.getNumeroDocumento());
                            txtDigitoverificacion.setValue(m.getNumVerificacion());
                            txtCuentaInv.setValue(m.getCuenta());
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
            }
      
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

                    if (txtnombreRazon.getValue().equals("")) {
                        txtnombreRazon.setComponentError(new UserError(""));
                        lberrorcmbR2.setValue("Este campo es requerido");
                    }
                    
                    if (txtconsecutivoOferta.getValue().equals("")) {
                        txtconsecutivoOferta.setComponentError(new UserError(""));
                        lberrorcmbR3.setValue("Este campo es requerido");
                    }
		    
		    if (txtrepresentante.getValue().equals("")) {
                        txtrepresentante.setComponentError(new UserError(""));
                        lberrorcmbR5.setValue("Este campo es requerido");
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

                    if (txtCuentaInv.getValue().equals("")) {
                        txtCuentaInv.setComponentError(new UserError(""));
                        lberror7.setValue("Este campo es requerido");
                    }
                    
                    
                    if (txtnumaceptVender.getValue().equals("")) {
                        txtnumaceptVender.setComponentError(new UserError(""));
                        lberror10.setValue("Este campo es requerido");
                    }

                    try {
                        comb1 = (Integer) cbxSevendetodoNada.getValue();
                    } catch (NullPointerException e) {
                        comb1 = 0;
                    } catch (ClassCastException ex) {
                        comb1 = 0;
                    }

                    // 

                    try {
                        digVerificacion1 = txtDigitoverificacion.getValue();
                    } catch (Exception ex) {
                        digVerificacion1 = "";
                    }                   
                    
                    int estadoId;
                    try {
                        estadoId = Integer.parseInt(cbxRechazada.getValue().toString());
                        switch (estadoId) {
                            case 1:
                                estado="Rechazado";
                                break;
                            case 2:
                                estado="Modificado";
                                break;
                            default:
                                estado = "Vacio";
                                break;
                        }
                    } catch (NumberFormatException  e) {
                        estadoId = 0;
                    } catch (ClassCastException ex) {
                        estadoId = 0;
                    }
                    
                    

                    
                    ValidarError();
                        if (!ValidaComponentError()) {
                            ConfirmDialog.show(getUI(), "Confirmación", "¿Está seguro que desea realizar los cambios?", "ACEPTAR",
                                    "CANCELAR", new ConfirmDialog.Listener() {
                                @Override
                                public void onClose(ConfirmDialog dialog) {
                                    if (dialog.isConfirmed()) {
                                        String nomUsuario ="";
                                        Date dNow = new Date();
                                        SimpleDateFormat ft;
                                        nomUsuario = userDetailsService.getUsuarioAutenticado().getUsername();
                                        //Fecha Modificación
                                        ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                        ft.format(dNow);
                                        
                                        Double numAcciones = Double.valueOf(txtnumaceptVender.getValue().replace(".", ""));

                                                            
                                        Double dig = null;

                                        try {
                                        dig = Double.valueOf(txtDigitoverificacion.getValue().toString());

                                        } catch (Exception e) {
                                        dig = null;
                                        }
                                        
                                        String resultado = facade.RechazarAceptacion(txtnombreRazon.getValue(), 
                                                txtconsecutivoOferta.getValue(),
                                                Integer.parseInt((cbxexistePreacuerdo.getValue().toString().isEmpty()) ? "0":cbxexistePreacuerdo.getValue().toString()),
                                                String.valueOf((cmbOrigenMila.getValue().toString().isEmpty()) ? comboMILA:cmbOrigenMila.getValue()),
                                                txtrepresentante.getValue().toString(),
                                                Integer.parseInt(cbxtipDocumento.getValue().toString()),
                                                txtnumeroDoc.getValue(),dig,
                                                txtEspecialFidu.getValue(),txtCuentaInv.getValue(),
                                                Integer.parseInt((cbxSevendetodoNada.getValue().toString().isEmpty()) ? "100":cbxSevendetodoNada.getValue().toString()),
                                                numAcciones, txtObservacion.getValue(),
                                                txtPorcentajeComision.getValue().equals("") ? "0.000":txtPorcentajeComision.getValue().replace(",", "."),
                                                estado, nomUsuario, ft.format(dNow).toString(), idAceptacion);                                        
                                        String recalculo = facade.RecalcularMontoTotalRechazo(precioAccion, numAcciones, idAceptacion);
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
                                    cargarTabla();
                                    verticallayoutTotal.setImmediate(true);
                                }
                            });
                        }
                }
            });

        }
    }
        public void mostrarMila() {
        cbxtipDocumento.setEnabled(false);
        txtnumeroDoc.setEnabled(false);
        lberror8.setValue("");
        txtDigitoverificacion.setEnabled(false);
        txtCuentaInv.setEnabled(false);
        lbEspecialFidu.setVisible(false);
        txtEspecialFidu.setVisible(false);
        txtnombreRazon.setEnabled(false);
        cbxtipDocumento.setComponentError(null);
        txtnumeroDoc.setComponentError(null);
        txtnombreRazon.setComponentError(null);
        txtDigitoverificacion.setComponentError(null);
        txtCuentaInv.setComponentError(null);
        lberror3.setValue("");
        lberror12.setValue("");
        lberror7.setValue("");
        lberrorcmbR3.setValue("");
        lberrorcmbR2.setValue("");
        lberrorcmbR5.setValue("");
        lberrorcmbR6.setValue("");
        txtconsecutivoOferta.setComponentError(null);
        txtnombreRazon.setComponentError(null);
        txtPorcentajeComision.setComponentError(null);
        txtrepresentante.setComponentError(null);
    }
}
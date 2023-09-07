/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.ui.contents;


import com.framework.common.domain.Perfil;
import com.framework.common.service.security.MyUserDetailsService;
import com.framework.common.ui.GenericContent;
import com.framework.common.ui.GenericTab;
import com.framework.common.ui.Main;
import com.framework.common.ui.util.AppConstants;
import com.framework.common.ui.util.ValidarCampos;
import com.quasar.frameq.db.Facade;
import com.vaadin.data.util.IndexedContainer;
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
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.dialogs.ConfirmDialog;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import java.util.Collection;
import java.text.DecimalFormat;


/**
 *
 * @author jam
 */
public class ModificarAceptaciones extends GenericContent {

    PagedTableCustomscb tabla;
    IndexedContainer ic;
    int startIndex =20;
    Button BtnEditar = null;
    Button BtnEditar1 = null;
    private Main main;
    
    private Button btlimpiar = new Button();
    private Button btbuscar = new Button();
    private TextField txtnumAceptacion = new TextField();
    private TextField txtidTabla= new TextField();
    private PopupDateField datef_fechaInicioOperacion = new PopupDateField();
    private PopupDateField datef_fechaFinOperacion = new PopupDateField();
    
    VerticalLayout verticallayoutTotal = new VerticalLayout();

    Facade facade = new Facade();
    ValidarCampos validacion = new ValidarCampos();
    String horario = validacion.fechaIngreso();
    String pattern = "###,###,###,###,###,###";
    final DecimalFormat form3 = new DecimalFormat(pattern);
    
    
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
   
    Collection<Perfil> perfiles = myUserDetailsService.findPerfilesOpcionesModuloUsuarioAutenticado();

    List<String> parametrosList;
    String muestraDireccion = "";
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

    String fechaInicio = "";
    String fechaFin = "";
    String numAceptacion = "";
    
    String  idAceptacion ="";
    Date Fecha1 = null;
    Date Fecha2 = null;
    

    public ModificarAceptaciones(GenericTab parentTab) {
        super(parentTab);
    }
    
     public VerticalLayout filtros() {
        VerticalLayout DF = new VerticalLayout();
         Panel panel = new Panel("Astronomer Panel");
         
         panel.setContent(DF);
         setContent(panel);
        return DF;
     }
     
    public VerticalLayout all() {
                  
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
            
        } else {

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
        gridpanel.setComponentAlignment(lbfechInOperacion, Alignment.MIDDLE_CENTER);
        datef_fechaInicioOperacion = new PopupDateField();
        datef_fechaInicioOperacion.setDateFormat("dd/MM/yyyy");
        datef_fechaInicioOperacion.setTextFieldEnabled(false);
        gridpanel.addComponent(datef_fechaInicioOperacion, 3, 0);
        gridpanel.setComponentAlignment(datef_fechaInicioOperacion, Alignment.MIDDLE_CENTER);
        datef_fechaInicioOperacion.setWidth(240, Sizeable.Unit.PIXELS);

        //
        //**********************************************
        //Fecha Fin Operación
        //**********************************************               
        Label lbfechFinOperacion = new Label("Fecha Fin Radicación");
        gridpanel.addComponent(lbfechFinOperacion, 2, 1);
        gridpanel.setComponentAlignment(lbfechFinOperacion, Alignment.MIDDLE_CENTER);
        datef_fechaFinOperacion = new PopupDateField();
        datef_fechaFinOperacion.setDateFormat("dd/MM/yyyy");
        datef_fechaFinOperacion.setTextFieldEnabled(false);
        gridpanel.addComponent(datef_fechaFinOperacion, 3, 1);
        gridpanel.setComponentAlignment(datef_fechaFinOperacion, Alignment.MIDDLE_CENTER);
        datef_fechaFinOperacion.setWidth(240, Sizeable.Unit.PIXELS);

        //**********************************************
       //BOTON FILTRAR
       //**********************************************
        btbuscar = new Button("Filtrar");
        btbuscar.addClickListener(new Button.ClickListener() {    
            private static final long serialVersionUID = 1L;

            public void buttonClick(ClickEvent event) {
                   filtrarTabla();
            }
        });
        gridpanel.addComponent(btbuscar, 0, 2, 1, 2);
        gridpanel.setComponentAlignment(btbuscar, Alignment.BOTTOM_RIGHT);

        //**********************************************
        //BOTON LIMPIAR
        //**********************************************
        btlimpiar = new Button("Limpiar");
        btlimpiar.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {         
                limpiarCampos();
                cargarTabla(); 
                tabla.setVisible(true);
            }
        });
        gridpanel.addComponent(btlimpiar, 2, 2, 3, 2);
        gridpanel.setComponentAlignment(btlimpiar, Alignment.BOTTOM_LEFT);

        //***************************************************
        //Tabla
        //*****************************************************
        ic = new IndexedContainer();    
            ic.addContainerProperty(AppConstants.COL_N_ACEPTACION, Integer.class, null);                 
            ic.addContainerProperty(AppConstants.COL_FECHA_ACEPTACION, String.class, null);                
            ic.addContainerProperty(AppConstants.COL_HORA_ACEPTACION, String.class, null);               
            ic.addContainerProperty(AppConstants.COL_CLASE_ACCIONES, String.class, null);                  
            ic.addContainerProperty(AppConstants.COL_CONSECUTIVO, String.class, null);        
            ic.addContainerProperty(AppConstants.COL_PREACUERDO, String.class, null);
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
            ic.addContainerProperty(AppConstants.COL_EDITAR, Button.class, null);
        
        tabla = new PagedTableCustomscb("");
        cargarTabla(); 
        tabla.setContainerDataSource(ic);
        tabla.setSizeFull();          
        tabla.setImmediate(true);
        tabla.setSelectable(false);
        tabla.setColumnReorderingAllowed(false);
                   
        
        //********************************************** 
        //COMPONENTES DE LOS OBJETOSS
        //**********************************************
        verticallayoutpanel.addComponent(gridpanel);
        verticallayoutpanel.setComponentAlignment(gridpanel, Alignment.TOP_CENTER);
        verticallayoutpanel.setWidth(95,Sizeable.Unit.PERCENTAGE);
        panel.setContent(verticallayoutpanel);
        panelPaginacion.setContent(tabla.createControls());
        panelgrilla.setContent(tabla);       
        verticallayoutTotal.setSpacing(true);
        verticallayoutTotal.addComponent(panel);
        verticallayoutTotal.addComponent(panelgrilla);
        verticallayoutTotal.addComponent(panelPaginacion);
        addComponent(verticallayoutTotal);

    }
   return verticallayoutTotal; 
  
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
        setContent(all());        

}    
    
    public void limpiarCampos() {
        datef_fechaInicioOperacion.setValue(null);
        datef_fechaFinOperacion.setValue(null);
        txtnumAceptacion.setValue("");
        datef_fechaInicioOperacion.setRequired(false);
        datef_fechaFinOperacion.setRequired(false);
    }

    public void filtrarTabla() {
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
        }  else { 
          if ((reformattedIni.equals("")) && (!reformattedFin.equals(""))) {
            datef_fechaInicioOperacion.setRequiredError("Debe seleccionar la Fecha Inicio de Radicación");
            Notification.show("Debe seleccionar la Fecha Inicio de Radicación",
                    Notification.Type.ERROR_MESSAGE);
            tabla.setVisible(true);

        } else { 
            if ((reformattedFin.equals(""))&& (!reformattedIni.equals("")) ){
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
            
            
             listAceptaciones = facade.ListarDemandas(idUsuario, tfNumAceptaciones, reformattedIni, reformattedFin);            
          
           
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
                
                Item item = ic.addItem(i);
                item.getItemProperty(AppConstants.COL_N_ACEPTACION).setValue(Integer.valueOf(listAceptaciones.get(0).get(i)));
                item.getItemProperty(AppConstants.COL_FECHA_ACEPTACION).setValue(listAceptaciones.get(17).get(i));
                item.getItemProperty(AppConstants.COL_HORA_ACEPTACION).setValue(listAceptaciones.get(18).get(i));
                item.getItemProperty(AppConstants.COL_CLASE_ACCIONES).setValue(listAceptaciones.get(1).get(i));
                item.getItemProperty(AppConstants.COL_CONSECUTIVO).setValue(listAceptaciones.get(2).get(i));
                item.getItemProperty(AppConstants.COL_PREACUERDO).setValue(nomPreacuerdo);
                item.getItemProperty(AppConstants.COL_NOMBRE_RAZON).setValue(listAceptaciones.get(22).get(i)/*+" "+listAceptaciones.get(9).get(i)*/);
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
                
                Button BtnEditar = new Button(AppConstants.COL_EDITAR);
                BtnEditar.setData(listAceptaciones.get(0).get(i));
                item.getItemProperty(AppConstants.COL_EDITAR).setValue(BtnEditar);


                BtnEditar.addClickListener(new Button.ClickListener() {
                    private static final long serialVersionUID = 1L;

                    public void buttonClick(ClickEvent event) {
                    
                        idAceptacion = event.getButton().getData().toString();

                        ModificacionAceptaciones miace = new ModificacionAceptaciones(getParentTab());
                        verticallayoutTotal.removeAllComponents();
                        miace.idAceptacion(idAceptacion);
                        verticallayoutTotal.addComponent(miace.all());
                        verticallayoutTotal.setImmediate(true);
                        setImmediate(true);
                    }
                });
                  
            }
            tabla.setColumnAlignment(AppConstants.COL_ACCIONES_VENDER, Table.Align.RIGHT); 
            
           editarTabla();
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
            
            
             listAceptaciones = facade.ListarDemandas(idUsuario, tfNumAceptaciones, reformattedIni, reformattedFin);
             
                    
                    
            if (!listAceptaciones.get(0).isEmpty()) {
           
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
                                
                //Se vende con condición todo o nada
                String nomConTodoNada = "";
                      nomConTodoNada = listAceptaciones.get(10).get(i);
                  
                 if (nomConTodoNada == null) {
                    nomConTodoNada = "";
                   }  else if (nomConTodoNada.equals("1")) {
                    nomConTodoNada = "Si";
                } else if (nomConTodoNada.equals("0")||nomConTodoNada.equals("2")) {
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
                Item item = ic.addItem(i);
                    item.getItemProperty(AppConstants.COL_N_ACEPTACION).setValue(Integer.valueOf(listAceptaciones.get(0).get(i)));
                    item.getItemProperty(AppConstants.COL_FECHA_ACEPTACION).setValue(listAceptaciones.get(17).get(i));
                    item.getItemProperty(AppConstants.COL_HORA_ACEPTACION).setValue(listAceptaciones.get(18).get(i));
                    item.getItemProperty(AppConstants.COL_CLASE_ACCIONES).setValue(listAceptaciones.get(1).get(i));
                    item.getItemProperty(AppConstants.COL_CONSECUTIVO).setValue(listAceptaciones.get(2).get(i));
                    item.getItemProperty(AppConstants.COL_PREACUERDO).setValue(nomPreacuerdo);
                    item.getItemProperty(AppConstants.COL_NOMBRE_RAZON).setValue(listAceptaciones.get(22).get(i)/*+" "+listAceptaciones.get(9).get(i)*/);
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
                    
                    Button BtnEditar = new Button(AppConstants.COL_EDITAR);
                BtnEditar.setData(listAceptaciones.get(0).get(i));
                    item.getItemProperty(AppConstants.COL_EDITAR).setValue(BtnEditar);

                BtnEditar.addClickListener(new Button.ClickListener() {
                    private static final long serialVersionUID = 1L;

                    public void buttonClick(ClickEvent event) {                       
                        idAceptacion = event.getButton().getData().toString();
                        ModificacionAceptaciones miace = new ModificacionAceptaciones(getParentTab());
                        verticallayoutTotal.removeAllComponents();
                        miace.idAceptacion(idAceptacion);
                        verticallayoutTotal.addComponent(miace.all());
                        verticallayoutTotal.setImmediate(true);
                        setImmediate(true);
                    }
                });

                
            }
            tabla.setColumnAlignment(AppConstants.COL_ACCIONES_VENDER, Table.Align.RIGHT); 
            
            editarTabla();                  

        }
        tabla.setContainerDataSource(ic);
        tabla.setImmediate(true);
    }

    private void editarTabla() {                        
            tabla.addValueChangeListener(new Property.ValueChangeListener() {
                @Override
                public void valueChange(Property.ValueChangeEvent event) {
                    
                    Integer itemId = (Integer) tabla.getValue();
                    int icIndex=(Integer)ic.indexOfId(itemId);

                    idAceptacion =  ic.getContainerProperty((itemId), AppConstants.COL_N_ACEPTACION).getValue().toString();
                       
                    }
                }); 

            }
    
public List<?> getItemIds(final int startIndex, final int numberOfItems) {
    return ic.getItemIds(this.startIndex + startIndex, numberOfItems);
}
    public String getMuestraDireccion() {
        return muestraDireccion;
    }

    public void setMuestraDireccion(String muestraDireccion) {
        this.muestraDireccion = muestraDireccion;
    }
      
    }
  


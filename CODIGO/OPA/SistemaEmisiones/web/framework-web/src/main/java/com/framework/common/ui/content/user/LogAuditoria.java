/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.ui.content.user;

import com.framework.common.service.security.MyUserDetailsService;
import com.framework.common.ui.GenericTab;
import com.framework.common.ui.GenericContent;
import com.framework.common.ui.contents.PagedTableCustomscb;
import com.quasar.frameq.db.Facade;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.FieldEvents;
import com.vaadin.ui.Button;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.server.Sizeable;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.UserError;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Roger Padilla C.
 */
public class LogAuditoria extends GenericContent {

    private static final Logger logger = Logger.getLogger(LogAuditoria.class.getName());
    private PopupDateField datef_fechaInicio = new PopupDateField();
    private PopupDateField datef_fechaFin = new PopupDateField();

    PagedTableCustomscb tabla;
    IndexedContainer ic;

    Label lbl_LoginUsuario = new Label();
    Label lbl_errpalabras = new Label(); //Label Error 
    Label lbl_Modulo = new Label();
    Label lbl_errModulo = new Label(); //Label Error 
    Label lbl_FechaInicio = new Label();
    Label lbl_errFechainicio = new Label(); //Label Error 
    Label lbl_FechaFin = new Label();
    Label lbl_errFechafin = new Label(); //Label Error 
    Label lbl_asteriscoModulo = new Label("*"); //Label asterisco seleccuionar módulo

    Label error = new Label("");
    TextField txt_LoginUsuario = new TextField();
    ComboBox cmb_modulo = new ComboBox();

    Button btnfiltrar = new Button("Filtrar");
    Button btnlimpiar = new Button("Limpiar");

    Integer valorCombo = null;
    Integer valcmb = null;

    Date Fecha1 = null;
    Date Fecha2 = null;

    String numerica = "^([0][1-9]|[12][0-9]|3[01])(\\/|-)([0][1-9]|[1][0-2])\\2(\\d{4})*$/";

    Facade facade = new Facade();

    /**
     *
     * @param parentTab
     */
    public LogAuditoria(GenericTab parentTab) {
        super(parentTab);
    }

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Override
    public void initForm() {

        final Panel panel = new Panel();
        final Panel panelgrilla = new Panel();
        final Panel panelPaginacion = new Panel();

        final GridLayout gridpanel = new GridLayout(6, 8);
        final GridLayout gridbotones = new GridLayout(1, 1);
        final GridLayout gridgrilla = new GridLayout(1, 1);

        VerticalLayout vlPadre = new VerticalLayout();

        gridpanel.setSizeFull();
        gridpanel.setHeight(165, Sizeable.Unit.PIXELS);
        gridpanel.setSpacing(true);
        gridgrilla.setSizeFull();
        panelgrilla.setSizeFull();
        panelPaginacion.setSizeFull();
        panelgrilla.setWidth(100, Sizeable.Unit.PERCENTAGE);
        panelPaginacion.setWidth(100, Sizeable.Unit.PERCENTAGE);
        vlPadre.setSizeFull();
        vlPadre.setWidth(100, Sizeable.Unit.PERCENTAGE);
        gridbotones.setWidth(500, Sizeable.Unit.PIXELS);
        gridbotones.setHeight(50, Sizeable.Unit.PIXELS);

        final VerticalLayout verticallayoutpanel = new VerticalLayout();

        HorizontalLayout horizo = new HorizontalLayout();
        gridpanel.setSizeFull();
        horizo.setWidth(97, Sizeable.Unit.PERCENTAGE);
        horizo.setHeight(97, Sizeable.Unit.PERCENTAGE);

        /*MODULO AUDITORIA*/
        Label lbltitulo = new Label("MÓDULO AUDITORÍA");
        lbltitulo.setWidth("100%");
        lbltitulo.setWidthUndefined();
        lbltitulo.setStyleName("tituloInversionistatit");
        Embedded image = new Embedded(null, new ThemeResource("img/Inver.png"));
        lbltitulo.setHeight("35px");
        image.setStyleName("InverImg");
        horizo.addStyleName("tituloAdjudicacion");
        horizo.addComponents(image, lbltitulo);
        horizo.setComponentAlignment(lbltitulo, Alignment.MIDDLE_CENTER);
        gridpanel.addComponent(horizo, 0, 0, 5, 0);

        /*COMPONENTES DE LOS OBJETOS*/
        vlPadre.addComponent(gridpanel);
        setContent(vlPadre);

        //**************************************************
        //Login usuario
        //**************************************************
        lbl_LoginUsuario.setValue("Login Usuario");
        gridpanel.addComponent(lbl_LoginUsuario, 0, 2);
        gridpanel.setComponentAlignment(lbl_LoginUsuario, Alignment.MIDDLE_RIGHT);

        txt_LoginUsuario.setMaxLength(20);
        gridpanel.addComponent(txt_LoginUsuario, 2, 2);
        gridpanel.setComponentAlignment(lbl_LoginUsuario, Alignment.MIDDLE_LEFT);

        //***************************************************
        // Módulo
        //***************************************************
        lbl_Modulo.setValue("Módulo");
        gridpanel.addComponent(lbl_Modulo, 3, 2);
        gridpanel.setComponentAlignment(lbl_Modulo, Alignment.MIDDLE_RIGHT);

//        lbl_asteriscoModulo.setStyleName("asterix");
//        gridpanel.addComponent(lbl_asteriscoModulo, 4, 2);
//        gridpanel.setComponentAlignment(lbl_asteriscoModulo, Alignment.MIDDLE_CENTER);

        gridpanel.addComponent(cmb_modulo, 5, 2);
        gridpanel.setComponentAlignment(cmb_modulo, Alignment.MIDDLE_LEFT);

        lbl_errModulo.setStyleName("lblerrores");
        gridpanel.addComponent(lbl_errModulo, 5, 3);

        cmb_modulo.setTextInputAllowed(false);
        cmb_modulo.setNullSelectionAllowed(false);
        cmb_modulo.addItem(0);
        cmb_modulo.setItemCaption(0, "Seleccione");
        cmb_modulo.addItem(1);
        cmb_modulo.setItemCaption(1, "Login");
        cmb_modulo.addItem(2);
        cmb_modulo.setItemCaption(2, "Gestión Aceptaciones");
        cmb_modulo.addItem(3);
        cmb_modulo.setItemCaption(3, "Parametrización");
        cmb_modulo.select(0);

        cmb_modulo.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (cmb_modulo.getValue() == null || cmb_modulo.getValue().equals(0)) {
                    cmb_modulo.setComponentError(new UserError(""));
                    lbl_errModulo.setValue("Este campo es requerido");
                } else {
                    cmb_modulo.setComponentError(null);
                    lbl_errModulo.setValue("");
                }

            }
        });

        cmb_modulo.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
//                datef_fechaFin.setDateFormat("");
//                datef_fechaInicio.setDateFormat("");
                txt_LoginUsuario.setValue("");
                datef_fechaInicio.setValue(null);
                datef_fechaFin.setValue(null);
                datef_fechaInicio.setRequired(false);
                datef_fechaFin.setRequired(false);

                try {
                    valorCombo = (Integer) cmb_modulo.getValue();
                } catch (NullPointerException ex) {
                    valorCombo = 0;
                } catch (ClassCastException e) {
                    valorCombo = 0;
                }
                if (null != valorCombo) {
                    switch (valorCombo) {
                        case 1:
                            valcmb = 1;
                            break;
                        case 2:
                            valcmb = 2;
                            break;
                        case 3:
                            valcmb = 3;
                            break;
                        default:
                            cmb_modulo.setComponentError(new UserError(""));
                            lbl_errModulo.setValue("Este campo es requerido");
                            break;
                    }
                }

            }
        });

        //***************************************************
        // Fecha Inicio
        //***************************************************        
        lbl_FechaInicio.setValue("Fecha Inicio");
        gridpanel.addComponent(lbl_FechaInicio, 0, 4);
        gridpanel.setComponentAlignment(lbl_FechaInicio, Alignment.MIDDLE_RIGHT);
        datef_fechaInicio.setDateFormat("dd/MM/yyyy");    
        datef_fechaInicio.setTextFieldEnabled(false);
        gridpanel.addComponent(datef_fechaInicio, 2, 4);
        gridpanel.setComponentAlignment(datef_fechaInicio, Alignment.MIDDLE_LEFT);
        lbl_errFechainicio.setStyleName("lblerrores");
        gridpanel.addComponent(lbl_errFechainicio, 2, 5);



        //***************************************************
        // Fecha Fin
        //***************************************************        
        lbl_FechaFin.setValue("Fecha Fin");
        gridpanel.addComponent(lbl_FechaFin, 3, 4);
        gridpanel.setComponentAlignment(lbl_FechaFin, Alignment.MIDDLE_RIGHT);
        datef_fechaFin.setDateFormat("dd/MM/yyyy");
        datef_fechaFin.setTextFieldEnabled(false);
        gridpanel.addComponent(datef_fechaFin, 5, 4);
        gridpanel.setComponentAlignment(datef_fechaFin, Alignment.MIDDLE_LEFT);
        lbl_errFechafin.setStyleName("lblerrores");
        gridpanel.addComponent(lbl_errFechafin, 5, 5);


        //**********************************************
        //BOTON FILTRAR
        //**********************************************
        btnfiltrar = new Button("Filtrar");
        btnfiltrar.addClickListener(new Button.ClickListener() {
            private static final long serialVersionUID = 1L;

            @Override
            public void buttonClick(Button.ClickEvent event) {

                try {
                    valorCombo = (Integer) cmb_modulo.getValue();
                } catch (NullPointerException ex) {
                    valorCombo = 0;
                } catch (ClassCastException e) {
                    valorCombo = 0;
                }

                if (valorCombo != 0) {
                    cargartabla();
                } else {
                    cmb_modulo.setComponentError(new UserError(""));
                    lbl_errModulo.setValue("Este campo es requerido");
                }

            }
        });
        gridpanel.addComponent(btnfiltrar, 1, 6, 2, 6);
        gridpanel.setComponentAlignment(btnfiltrar, Alignment.BOTTOM_RIGHT);

        //**********************************************
        //BOTON LIMPIAR
        //**********************************************
        btnlimpiar = new Button("Limpiar");
        btnlimpiar.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                limpiarCampos();
                // cargarTabla(); 
                // tabla.setVisible(true);
            }
        });
        gridpanel.addComponent(btnlimpiar, 3, 6, 4, 6);
        gridpanel.setComponentAlignment(btnlimpiar, Alignment.BOTTOM_LEFT);

        //***************************************************
        //Tabla
        //*****************************************************
        ic = new IndexedContainer();
        ic.addContainerProperty("Id Auditoría", Integer.class, null);
        ic.addContainerProperty("Login Usuario", String.class, null);
        ic.addContainerProperty("Fecha y Hora", String.class, null);
        ic.addContainerProperty("Valores", String.class, null);
        ic.addContainerProperty("Acción", String.class, null);

        tabla = new PagedTableCustomscb("");
        tabla.setContainerDataSource(ic);
        tabla.setSizeFull();
        tabla.setImmediate(true);
        tabla.setSelectable(false);
        tabla.setColumnReorderingAllowed(false);

        verticallayoutpanel.addComponent(gridpanel);
        verticallayoutpanel.setComponentAlignment(gridpanel, Alignment.TOP_CENTER);
        verticallayoutpanel.setWidth(95, Sizeable.Unit.PERCENTAGE);
        panel.setContent(verticallayoutpanel);
        panelPaginacion.setContent(tabla.createControls());
        panelgrilla.setContent(tabla);
        vlPadre.setSpacing(true);
        vlPadre.addComponent(panel);
        vlPadre.addComponent(panelgrilla);
        vlPadre.addComponent(panelPaginacion);
        addComponent(vlPadre);

    }

    public void limpiarCampos() {
        txt_LoginUsuario.setValue("");
        cmb_modulo.setValue(0);
        cmb_modulo.setRequired(false);
        cmb_modulo.setComponentError(null);
        lbl_errModulo.setValue("");
        datef_fechaInicio.setValue(null);
        datef_fechaFin.setValue(null);
        datef_fechaInicio.setRequired(false);
        datef_fechaFin.setRequired(false);

        tabla.setVisible(true);
        tabla.getContainerDataSource().removeAllItems();
        initForm();

    }

    public void cargartabla() {

        String Txtlogin;
        String DateIni = null;
        String DateFin = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        //Login Usuario 
        try {
            Txtlogin = txt_LoginUsuario.getValue();

        } catch (Exception e) {
            Txtlogin = "";

        }
        try {

                DateIni = fecha(datef_fechaInicio.getValue().toString());

           
        } catch (Exception e) {
            DateIni = "";


        }

        try {

                DateFin = fecha(datef_fechaFin.getValue().toString());

        } catch (Exception e) {
            DateFin = "";


        }
        try {
            Fecha1 = df.parse(DateIni);

        } catch (Exception e) {
            DateIni = "";
        }

        try {
            Fecha2 = df.parse(DateFin);
        } catch (Exception e) {
            DateFin = "";
        }

        if ((DateIni.equals("")) && (!DateFin.equals(""))) {
            datef_fechaInicio.setRequiredError("Debe seleccionar la Fecha Inicio de Busqueda");
            Notification.show("Debe seleccionar la Fecha Inicio de Radicación",
                    Notification.Type.ERROR_MESSAGE);
            tabla.setVisible(true);

        } else if ((DateFin.equals("")) && (!DateIni.equals(""))) {
            datef_fechaFin.setRequiredError("Debe seleccionar la Fecha Fin de Busqueda");
            Notification.show("Debe seleccionar la Fecha Fin de Radicación",
                    Notification.Type.ERROR_MESSAGE);
            tabla.setVisible(true);

        } else if ((!DateIni.equals("")) && (!DateFin.equals("")) && Fecha2.before(Fecha1)) {
            Notification.show("La fecha inicial debe ser menor o igual a la fecha final",
                    Notification.Type.ERROR_MESSAGE);

        } else {
            datef_fechaFin.setRequired(false);
            Button boton = new Button();
            boton.setStyleName("CssBoton");

            tabla.setVisible(true);
            tabla.getContainerDataSource().removeAllItems();

            try {
                valorCombo = (Integer) cmb_modulo.getValue();
            } catch (NullPointerException ex) {
                valorCombo = 0;
            } catch (ClassCastException e) {
                valorCombo = 0;
            }
            

            switch (valcmb) {
                case 1:
                    List<List<String>> ListaLogin;
                    ListaLogin = facade.ListarLogin(Txtlogin, DateIni, DateFin);

                    for (int i = 0; i < ListaLogin.get(0).size(); i++) {

                        Item item = ic.addItem(i);
                        item.getItemProperty("Id Auditoría").setValue(Integer.valueOf(ListaLogin.get(0).get(i)));
                        item.getItemProperty("Login Usuario").setValue(ListaLogin.get(1).get(i));
                        item.getItemProperty("Fecha y Hora").setValue(ListaLogin.get(2).get(i));
                        item.getItemProperty("Acción").setValue(ListaLogin.get(3).get(i));
                        item.getItemProperty("Valores").setValue(ListaLogin.get(4).get(i));

                        tabla.setSizeFull();

                    }

                    if (ListaLogin.get(0).size() == 0) {
                        Notification.show("No hay Registros ",
                                Notification.Type.TRAY_NOTIFICATION);
                        tabla.setVisible(false);
                    }
                    ;
                    break;
                case 2:
                    List<List<String>> ListaAuAcept;
                    ListaAuAcept = facade.ListarAuAcep(Txtlogin, DateIni, DateFin);

                    for (int i = 0; i < ListaAuAcept.get(0).size(); i++) {

                        Item item = ic.addItem(i);
                        item.getItemProperty("Id Auditoría").setValue(Integer.valueOf(ListaAuAcept.get(0).get(i)));
                        item.getItemProperty("Login Usuario").setValue(ListaAuAcept.get(1).get(i));
                        item.getItemProperty("Fecha y Hora").setValue(ListaAuAcept.get(2).get(i));
                        item.getItemProperty("Acción").setValue(ListaAuAcept.get(3).get(i));
                        item.getItemProperty("Valores").setValue(ListaAuAcept.get(4).get(i));
                        tabla.setSizeFull();

                    }

                    if (ListaAuAcept.get(0).size() == 0) {
                        Notification.show("No hay Registros ",
                                Notification.Type.TRAY_NOTIFICATION);
                        tabla.setVisible(false);
                    }
                    ;
                    break;
                case 3:
                    List<List<String>> ListaParametros;
                    ListaParametros = facade.ListarAuParametros(Txtlogin, DateIni, DateFin);

                    for (int i = 0; i < ListaParametros.get(0).size(); i++) {

                        Item item = ic.addItem(i);
                        item.getItemProperty("Id Auditoría").setValue(Integer.valueOf(ListaParametros.get(0).get(i)));
                        item.getItemProperty("Login Usuario").setValue(ListaParametros.get(1).get(i));
                        item.getItemProperty("Fecha y Hora").setValue(ListaParametros.get(2).get(i));
                        item.getItemProperty("Acción").setValue(ListaParametros.get(3).get(i));
                        item.getItemProperty("Valores").setValue(ListaParametros.get(4).get(i));
                        tabla.setSizeFull();

                    }

                    if (ListaParametros.get(0).size() == 0) {
                        Notification.show("No hay Registros ",
                                Notification.Type.TRAY_NOTIFICATION);
                        tabla.setVisible(false);
                    }
                    ;
                    break;
            }

            tabla.setContainerDataSource(ic);
            tabla.setImmediate(true); 


        }

    }

    public String fecha(String fecha) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String Formatfecha = "";
        DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ROOT);
        DateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = formatter.parse(fecha);  
           
            Formatfecha = formatter1.format(date.getTime());
           
        } catch (Exception e) {
            // Logger.getLogger(LogAuditoria.class.getName()).log(Level.SEVERE, null, e);
            logger.error("OPA - " + LogAuditoria.class.getName(), e);
        }

        return Formatfecha;

    }

}

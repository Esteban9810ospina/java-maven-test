/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.ui.content.user;
import com.framework.common.domain.Usuario;
import com.framework.common.service.Auditoria;
import com.framework.common.service.security.MyUserDetailsService;
import com.framework.common.ui.GenericTab;
import com.framework.common.ui.GenericContent;
import com.framework.common.ui.util.ValidarCampos;
import com.quasar.frameq.data.SCB;
import com.quasar.frameq.data.TipoDocumento;
import com.quasar.frameq.db.Facade;
import com.quasar.frameq.estructura.IpAutorizada;
import com.quasar.frameq.fachadas.FacadeDiccionario;
import com.quasar.frameq.seguridad.Perfil;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.event.FieldEvents;
import com.vaadin.event.SelectionEvent;
import com.vaadin.event.SelectionEvent.SelectionListener;
import com.vaadin.server.Page;
import com.vaadin.server.UserError;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SingleSelectionModel;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
//import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.vaadin.dialogs.ConfirmDialog;
import com.quasar.frameq.fachadas.FacadeParametros;
import com.quasar.frameq.fachadas.FacadeUsuarios;
import com.vaadin.server.Sizeable;
//import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import java.util.ArrayList;
import org.apache.log4j.Logger;
/**
 *
 * @author Roger Padilla C.
 */
@Configurable(preConstruction = true)
public class AdminUsuariosContent extends GenericContent {

    @Autowired
    private MyUserDetailsService userDetailsService;
    private static final Logger logger = Logger.getLogger(Auditoria.class.getName()); 

    String regexNumeric = "^[0-9]*$";
    String regexNumeric2 = "^[0-9]$";
    String regexLetras = "^[a-zA-Z\\s]*$";
    String regexAlpha = "^[a-zA-Z0-9]*$";
    String regexAlphaSpace = "^[a-zA-Z0-9\\s]*$";
    String regexEmailEstruct = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,3}$";
    String regexEmail = "^[-.@_a-zA-Z0-9]*$";
    String REG_EXP = "\\¿+|\\?+|\\°+|\\¬+|\\|+|\\!+|\\#+|\\$+|+\\%+|\\&+|\\+|\\=+|\\'+|\\¡+|\\++|\\*+|\\~+|\\[+|\\]+|\\{+|\\}+|\\^+|\\<+|\\>+|\\\"";
    String regexMayus = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    String regexIp ="^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$" ;
    Label errIdcmb = new Label();
    Label errnumDoc = new Label();
    Label errnombre = new Label();
    Label errape = new Label();
    Label erracorre = new Label();
    Label errlog = new Label();
    Label errcla = new Label();
    Label errvercla = new Label();
    Label errper = new Label();
    Label errest = new Label();
    Label errscb = new Label();
    Label errIp1 =new Label();    
    Label errIp2 =new Label();    
    Label errIp3 =new Label();  
    Label errIp4 =new Label();
    Label errIp5 =new Label();  
    Label errIp6 =new Label();  
    Label errIp7 =new Label();  
    Label errIp8 =new Label();  
    Label errIp9 =new Label();  
    Label errIp10 =new Label();  
    Label errIp11 =new Label();  
    Label errIp12 =new Label();  
    Label errIp13 =new Label();  
    Label errIp14 =new Label();  
    Label errIp15 =new Label();
    Label errIp16 =new Label();
    Label errIp17 =new Label();
    Label errIp18 =new Label();
    Label errIp19 =new Label();
    Label errIp20 =new Label();
    Label errIp21 =new Label();
    Label errIp22 =new Label();
    Label errIp23 =new Label();
    Label errIp24 =new Label();
    Label errIp25 =new Label();
    Label errIp26 =new Label();
    Label errIp27 =new Label();
    Label errIp28 =new Label();
    Label errIp29 =new Label();
    Label errIp30 =new Label();
    Label errIp31 =new Label();
    Label errIp32 =new Label();
    Label errIp33 =new Label();
    Label errIp34 =new Label();
    Label errIp35 =new Label();
    Label errIp36 =new Label();
    Label errIp37 =new Label();
    Label errIp38 =new Label();
    Label errIp39 =new Label();
    Label errIp40 =new Label();

    Boolean bCambioClave=false;    
    
    Label error = new Label("");
    int combo = 0;
    int comboPer = 0;
    int comboEst = 0;
    int comboScb = 0;
    int valorCombo = 0;

    Grid grid;
    int idesfila = 0;
    int select = 0;
    int controladorEve = 0;
    int controladorEve1 = 0;
    protected AbstractOrderedLayout authoritiesLayout;
    ValidarCampos validacion = new ValidarCampos();

    int id = 0;

    ConfirmDialog usuarios = new ConfirmDialog();
    ConfirmDialog modUsuarios = new ConfirmDialog();    
    ComboBox cmb = new ComboBox();
    TextField numDoc = new TextField();
    TextField nombres = new TextField();
    TextField apellidos = new TextField();
    TextField correo = new TextField();
    TextField login = new TextField();
    PasswordField clave = new PasswordField();
    PasswordField verclave = new PasswordField();
   

    ComboBox perfiles = new ComboBox();
    ComboBox Cbxestado = new ComboBox();
    ComboBox scb = new ComboBox();

    ComboBox mcmb = new ComboBox();
    TextField mnumDoc = new TextField();
    TextField mnombres = new TextField();
    TextField mapellidos = new TextField();
    TextField mcorreo = new TextField();
    TextField mlogin = new TextField();
    PasswordField mclave = new PasswordField();
    PasswordField mverclave = new PasswordField();

    TextField ip1 = new TextField();
    TextField ip2 = new TextField();
    TextField ip3 = new TextField();
    TextField ip4 = new TextField();
    TextField ip5 = new TextField();
    TextField ip6 = new TextField();
    TextField ip7 = new TextField();
    TextField ip8 = new TextField();
    TextField ip9 = new TextField();
    TextField ip10 = new TextField();
    TextField ip11 = new TextField();
    TextField ip12 = new TextField();
    TextField ip13 = new TextField();
    TextField ip14 = new TextField();
    TextField ip15 = new TextField();
    TextField ip16 = new TextField();
    TextField ip17 = new TextField();
    TextField ip18 = new TextField();
    TextField ip19 = new TextField();
    TextField ip20 = new TextField();
    TextField ip21 = new TextField();
    TextField ip22 = new TextField();
    TextField ip23 = new TextField();
    TextField ip24 = new TextField();
    TextField ip25 = new TextField();
    TextField ip26 = new TextField();
    TextField ip27 = new TextField();
    TextField ip28 = new TextField();
    TextField ip29 = new TextField();
    TextField ip30 = new TextField();
    TextField ip31 = new TextField();
    TextField ip32 = new TextField();
    TextField ip33 = new TextField();
    TextField ip34 = new TextField();
    TextField ip35 = new TextField();
    TextField ip36 = new TextField();
    TextField ip37 = new TextField();
    TextField ip38 = new TextField();
    TextField ip39 = new TextField();
    TextField ip40 = new TextField();
    
    Button createBtn = new Button("Nuevo");
    Button modiBtn = new Button("Modificar");

    ComboBox mperfiles = new ComboBox();
    ComboBox mestado = new ComboBox();

    Facade facade = new Facade();
    FacadeUsuarios facadeusaurios = new FacadeUsuarios();

    String idUsu = "";
    String tipoD = "";
    String numD = "";
    String nomb = "";
    String apell = "";
    String Ent = "";
    String cor = "";
    String log = "";
    String per = "";
    String est = "";
    String socSCB = "";

    String PerfilActual = "";
    String codigoSCB="";
    String socBol = "";
    String IdsocBol = "";
    Label sociedad = new Label();
    
    private VerticalLayout layConsulta = new VerticalLayout();
    private Panel panel;// Para lograr el scroll horizontal    
    
    FacadeParametros parametro = new FacadeParametros();
    // Diccionario de contraseñas
    FacadeDiccionario facadediccionario = new FacadeDiccionario();
    
    int tipoDocInt=0;
    
    /**
     *
     * @param parentTab
     */
    public AdminUsuariosContent(GenericTab parentTab) {
        super(parentTab);
    }

    @Override
    public void initForm() {

        PerfilActual = facade.RetornaPerfil(userDetailsService.getUsuarioAutenticado().getId());
        String cadena = "";

        cadena = facade.RetornarSCBusu(userDetailsService.getUsuarioAutenticado().getId());
        String[] result = cadena.split(";");
        codigoSCB = result[0];
        socBol = result[1];
        IdsocBol = result[2];

        sociedad.setValue(codigoSCB+" - "+socBol);
        
        
        final IndexedContainer ic = new IndexedContainer();

        ic.addContainerProperty("Id", String.class, null);
        ic.addContainerProperty("Tipo de Documento", String.class, null);
        ic.addContainerProperty("Número de Documento", String.class, null);
        ic.addContainerProperty("Nombres", String.class, null);
        ic.addContainerProperty("Apellidos", String.class, null);
        ic.addContainerProperty("SCB o Entidad", String.class, null);
        ic.addContainerProperty("Usuario", String.class, null);
        ic.addContainerProperty("Perfil", String.class, null);
        ic.addContainerProperty("Estado", String.class, null);
        ic.addContainerProperty("Email", String.class, null);
               
        // Define some columns
        grid = new Grid(ic);
                
        grid.getDefaultHeaderRow().getCell("SCB o Entidad").setText("SCB/Entidad");
        grid.getDefaultHeaderRow().getCell("Tipo de Documento").setText("Tipo de Documento");
        grid.getDefaultHeaderRow().getCell("Número de Documento").setText("Número de Documento");

        //createBtn.setDescription("Crear un usuario");
        createBtn.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {

                if (PerfilActual.equals("Administrador SCB")) {
                    int cantUsuariosOpe = parametro.CantUsuariosOpe();
                    String idScb = userDetailsService.getUsuarioAutenticado().getSbolsa().toString();
                    int cantUsuarios = facadeusaurios.CantUsuariosSCB(idScb);

                    if (cantUsuarios <cantUsuariosOpe) {
                         controladorEve++;
                    if (controladorEve == 1) {
                        retornaPanelCrearUsuarios();
                     }
                   } else {
                  Notification.show("Ya se han ingresado la cantidad de usuarios permitidos", Notification.Type.ERROR_MESSAGE);
                  }    
                } else {
                    controladorEve++;
                    if (controladorEve == 1) {
                        retornaPanelCrearUsuarios();
                    } 
              }
                Grid.HeaderRow filterRow = grid.getHeaderRow(1);
                for (final Object pid : grid.getContainerDataSource().getContainerPropertyIds()) {
                    Grid.HeaderCell cell = filterRow.getCell(pid);
                    TextField filterField = (TextField) cell.getComponent();
                    filterField.clear();
                    filterField.setImmediate(true);
                }
                ic.removeAllContainerFilters();

            }
        });

           
        modiBtn.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {

                if (select == 0) {
                    Notification.show("Por favor Seleccione un Registro", Notification.Type.ERROR_MESSAGE);
                } else {
                         mperfiles.setEnabled(false);
                    if ((per.equals("Administrador SCB") || per.equals("Riesgos") || per.equals("Administrador BVC")) && PerfilActual.equals("Administrador SCB")) {
                        Notification.show("No esta autorizado para realizar esta operacion", Notification.Type.ERROR_MESSAGE);
                        grid.select(null);
                        Limpiar();
                        Grid.HeaderRow filterRow = grid.getHeaderRow(1);
                        for (final Object pid : grid.getContainerDataSource().getContainerPropertyIds()) {
                            Grid.HeaderCell cell = filterRow.getCell(pid);
                            TextField filterField = (TextField) cell.getComponent();
                            filterField.clear();
                            filterField.setImmediate(true);
                        }
                        ic.removeAllContainerFilters();
                        
                        select = 0;
                    } else {
                        controladorEve1++;
                        if (controladorEve1 == 1) {
                            //Grid.HeaderRow filterRow = grid.appendHeaderRow();
                            Grid.HeaderRow filterRow = grid.getHeaderRow(1);
                            for (final Object pid : grid.getContainerDataSource().getContainerPropertyIds()) {
                                Grid.HeaderCell cell = filterRow.getCell(pid);
                                TextField filterField=(TextField) cell.getComponent();
                                filterField.clear();
                                filterField.setImmediate(true);
                            }    
                            ic.removeAllContainerFilters();
                            retornaPanelModificarUsuarios();
                        } else {

                        }

                    }
                }

            }
        });

        
         List<List<String>> listUsuarios;
        
        String idScb = userDetailsService.getUsuarioAutenticado().getSbolsa().toString();

        if (PerfilActual.equals("Administrador SCB")) {
           listUsuarios = facade.RetornarusuariosSCB(idScb);
        }
        else {

         listUsuarios = facade.Retornarusuarios();

        }
        String estado = "";
        for (int i = 0; i < listUsuarios.get(0).size(); i++) {
            if (listUsuarios.get(11).get(i).equals("A")) {
                estado = "Activo";
            } else if (listUsuarios.get(11).get(i).equals("I")) {
                estado = "Inactivo";
            } else if (listUsuarios.get(11).get(i).equals("B")) {
                estado = "Bloqueado";
            }
            
            //String scb =listUsuarios.get(18).get(i);

            /*String[] list = scb.split("-");
            String codigosc = list[0];*/

            grid.addRow(listUsuarios.get(0).get(i), listUsuarios.get(6).get(i), listUsuarios.get(7).get(i), listUsuarios.get(3).get(i), listUsuarios.get(4).get(i), listUsuarios.get(18).get(i), listUsuarios.get(1).get(i), listUsuarios.get(17).get(i), estado, listUsuarios.get(5).get(i));
        }

        grid.setSelectionMode(Grid.SelectionMode.SINGLE);

        grid.setSizeFull();

        Grid.HeaderRow filterRow = grid.appendHeaderRow();

// Set up a filter for all columns
        for (final Object pid : grid.getContainerDataSource()
                .getContainerPropertyIds()) {
            Grid.HeaderCell cell = filterRow.getCell(pid);
            TextField filterField = new TextField();
            filterField.setColumns(8);
            filterField.setWidth(100, Sizeable.Unit.PERCENTAGE);
            filterField.setId("filtrosusuarios");
           
            filterField.addTextChangeListener(new FieldEvents.TextChangeListener() {

                @Override
                public void textChange(FieldEvents.TextChangeEvent event) {

                    ic.removeContainerFilters(pid);

                    if (!event.getText().isEmpty()) {
                        ic.addContainerFilter(
                                new SimpleStringFilter(pid,
                                        event.getText(), true, false)); //To change body of generated methods, choose Tools | Templates.
                    }
                }
            });

            cell.setComponent(filterField);           
        }
        
          grid.addSelectionListener(new SelectionListener() {

            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            public void select(SelectionEvent event) {
                
                Object selected = ((SingleSelectionModel)
	                grid.getSelectionModel()).getSelectedRow();
                if (selected != null){                   

                  try {
                    idesfila = (Integer) grid.getSelectedRow();
                } catch (NullPointerException ex) {
                    idesfila = 0;
                }

                try {
                    select = 1;
                    idUsu = grid.getContainerDataSource().getItem(idesfila).getItemProperty("Id").toString();
                    tipoD = grid.getContainerDataSource().getItem(idesfila).getItemProperty("Tipo de Documento").toString();
                    numD = grid.getContainerDataSource().getItem(idesfila).getItemProperty("Número de Documento").toString();
                    nomb = grid.getContainerDataSource().getItem(idesfila).getItemProperty("Nombres").toString();
                    apell = grid.getContainerDataSource().getItem(idesfila).getItemProperty("Apellidos").toString();
                    socSCB = grid.getContainerDataSource().getItem(idesfila).getItemProperty("SCB o Entidad").toString();
                    cor = grid.getContainerDataSource().getItem(idesfila).getItemProperty("Email").toString();
                    log = grid.getContainerDataSource().getItem(idesfila).getItemProperty("Usuario").toString();
                    per = grid.getContainerDataSource().getItem(idesfila).getItemProperty("Perfil").toString();
                    est = grid.getContainerDataSource().getItem(idesfila).getItemProperty("Estado").toString();
                } catch (NullPointerException ex) {
                    tipoD = "";
                    numD = "";
                    nomb = "";
                    apell = "";
                    //Ent = "";
                    cor = "";
                    log = "";
                    per = "";
                    est = "";
                }
              } else {
                    select = 0;
                    //  Notification.show("Por favor Seleccione un Registro");
                }
            }
        });
         
        HorizontalLayout hbut = new HorizontalLayout();
        
        hbut.addComponents(createBtn, modiBtn);
        
        hbut.addStyleName("horizontal1");  
        
        
        modiBtn.addStyleName("Butt1");

        panel = new Panel("");
        panel.setWidth("98%"); // we want scrollbars
        panel.setHeight("75%");
        panel.setScrollLeft(5);
        panel.setScrollTop(5);
        panel.setImmediate(true);
        panel.setContent(grid);
        layConsulta.addComponent(panel);
        layConsulta.addComponent(hbut);
        layConsulta.setWidth(98, Sizeable.Unit.PERCENTAGE);
        layConsulta.setSpacing(true);
        
        addComponent(layConsulta);
        
        
       // hbut.addStyleName("horizontalButt");       
   
    }
   
    public ConfirmDialog retornaPanelCrearUsuarios() {

        Limpiar();

        usuarios = ConfirmDialog.getFactory().create("Crear Usuarios.", "", "", "", "");
        
        GridLayout vlInv = new GridLayout(6, 46);
        vlInv.setStyleName("StylegridLa");
        vlInv.setMargin(true);
        Label esp = new Label("");
        Label tpID = new Label("Tipo Documento:");
        cmb = LlenarTipoDocumentos();
        cmb.select("");
        
        

        cmb.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (cmb.getValue() == null || cmb.getValue().equals("")) {
                    cmb.setComponentError(new UserError(""));
                    errIdcmb.setValue("Este campo es requerido");
                } else {
                    cmb.setComponentError(null);
                    errIdcmb.setValue("");
                }
                
                numDoc.setComponentError(null);
                errnumDoc.setValue("");
                
                if(cmb.getValue() != null && !cmb.getValue().equals("")){
                
                 tipoDocInt = (Integer) cmb.getValue();
                
                 if (tipoDocInt== 1 || tipoDocInt == 4 || tipoDocInt == 6) {
                        if (!numDoc.getValue().matches(regexNumeric)) {
                            numDoc.setComponentError(new UserError(""));
                            errnumDoc.setValue("Este campo contiene caracteres no válidos");
                   }
                 }else{
                     numDoc.setComponentError(null);
                     errnumDoc.setValue("");
                 } 
                }
                
                ValidarError();
            }
        });

        vlInv.setSpacing(true);
        vlInv.addComponent(tpID, 0, 1);
        Label asteriscos = new Label("*");
        asteriscos.setStyleName("asterix");
        vlInv.addComponent(asteriscos, 1, 1);
        vlInv.addComponent(cmb, 2, 1);
        vlInv.setSpacing(true);
        Label ID = new Label("Número Documento:");
        vlInv.addComponent(ID, 3, 1);
        asteriscos = new Label("*");
        asteriscos.setStyleName("asterix");
        vlInv.addComponent(asteriscos, 4, 1);
        vlInv.addComponent(numDoc, 5, 1);

        numDoc.setMaxLength(15);

        numDoc.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                try {
                    valorCombo = (Integer) cmb.getValue();
                } catch (NullPointerException ex) {
                    valorCombo = 0;
                } catch (ClassCastException e) {
                    valorCombo = 0;
                }
                numDoc.setComponentError(null);
                errnumDoc.setValue("");
                if (numDoc.getValue().equals("")) {
                    numDoc.setComponentError(new UserError(""));
                    errnumDoc.setValue("Este campo es requerido");
                }
                if (valorCombo == 2 || valorCombo == 3) {
                    if (!numDoc.getValue().matches(regexAlpha)) {
                        numDoc.setComponentError(new UserError(""));
                        errnumDoc.setValue("Este campo contiene caracteres no válidos");
                    }else{
                                mnumDoc.setComponentError(null);
                                errnumDoc.setValue("");
                            }
                } else {
                    if (!numDoc.getValue().matches(regexNumeric)) {
                        numDoc.setComponentError(new UserError(""));
                        errnumDoc.setValue("Este campo contiene caracteres no válidos");
                    }
                }

                ValidarError();

            }
        });

        errIdcmb.setStyleName("lblerrores");
        vlInv.addComponent(errIdcmb, 2, 2);

        errnumDoc.setStyleName("lblerrores");
        vlInv.addComponent(errnumDoc, 5, 2);

        Label nom = new Label("Nombres:");

        vlInv.setSpacing(true);
        vlInv.addComponent(esp, 0, 3);
        vlInv.addComponent(nom, 0, 4);

        asteriscos = new Label("*");
        asteriscos.setStyleName("asterix");
        vlInv.addComponent(asteriscos, 1, 4);
        vlInv.addComponent(nombres, 2, 4);
        vlInv.setSpacing(true);
        Label ape = new Label("Apellidos:");

        vlInv.addComponent(ape, 3, 4);
        asteriscos = new Label("*");
        asteriscos.setStyleName("asterix");
        vlInv.addComponent(asteriscos, 4, 4);
        vlInv.addComponent(apellidos, 5, 4);        

        nombres.setMaxLength(50);

        nombres.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (nombres.getValue().equals("")) {
                    nombres.setComponentError(new UserError(""));
                    errnombre.setValue("Este campo es requerido");
                } else {
                    if (!nombres.getValue().equals("")) {
                        if (nombres.getValue().matches(regexLetras)) {
                            nombres.setComponentError(null);
                            errnombre.setValue("");
                        } else {
                            nombres.setComponentError(new UserError(""));
                            errnombre.setValue("Este campo contiene caracteres no válidos");
                        }
                    } else {
                        nombres.setComponentError(null);
                        errnombre.setValue("");
                    }

                }

                ValidarError();
            }
        });

        apellidos.setMaxLength(50);

        apellidos.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (apellidos.getValue().equals("")) {
                    apellidos.setComponentError(new UserError(""));
                    errape.setValue("Este campo es requerido");
                } else {
                    if (!apellidos.getValue().equals("")) {
                        if (apellidos.getValue().matches(regexLetras)) {
                            apellidos.setComponentError(null);
                            errape.setValue("");
                        } else {
                            apellidos.setComponentError(new UserError(""));
                            errape.setValue("Este campo contiene caracteres no válidos");
                        }
                    } else {
                        apellidos.setComponentError(null);
                        errape.setValue("");
                    }

                }
                ValidarError();
            }
        });

        errnombre.setStyleName("lblerrores");
        vlInv.addComponent(errnombre, 2, 5);

        errape.setStyleName("lblerrores");
        vlInv.addComponent(errape, 5, 5);

        Label scbEnti = new Label("SCB/Entidad:");
        Label corr = new Label("Correo Electrónico:");

        Label esp1 = new Label("");

        vlInv.setSpacing(true);
        vlInv.addComponent(esp1, 0, 6);        

        if (PerfilActual.equals("Riesgos") || PerfilActual.equals("Administrador General")) {
            scb = LlenarSCB();
            scb.setEnabled(true);
            scb.setWidth("140px");
            vlInv.addComponent(scbEnti, 0, 7);
            asteriscos = new Label("*");
            asteriscos.setStyleName("asterix");
            vlInv.addComponent(asteriscos, 1, 7);            
            vlInv.addComponent(scb, 2, 7);
            scb.select("");
            scb.addBlurListener(new FieldEvents.BlurListener() {
                @Override
                public void blur(FieldEvents.BlurEvent event) {
                    if (scb.getValue() == null || scb.getValue().equals("")) {
                        scb.setComponentError(new UserError(""));
                        errscb.setValue("Este campo es requerido");
                    } else {
                        scb.setComponentError(null);
                        errscb.setValue("");
                    }
                    ValidarError();
                }
            });
             errscb.setStyleName("lblerrores");
             vlInv.addComponent(errscb, 2, 8);

        } else {
            sociedad.setValue(codigoSCB+" - "+socBol);
            vlInv.addComponent(scbEnti, 0, 7);
            vlInv.addComponent(sociedad, 2, 7);
        }

        vlInv.setSpacing(true);

        Label log = new Label("Login:");

        vlInv.setSpacing(true);
        Label esp2 = new Label("");
        vlInv.addComponent(esp2, 0, 9);
        vlInv.addComponent(corr, 0, 10);
        asteriscos = new Label("*");
        asteriscos.setStyleName("asterix");
        vlInv.addComponent(asteriscos, 1, 10);
        vlInv.addComponent(correo, 2, 10);
        vlInv.addComponent(log, 3, 10);
        asteriscos = new Label("*");
        asteriscos.setStyleName("asterix");
        vlInv.addComponent(asteriscos, 4, 10);
        login.setMaxLength(20);
        vlInv.addComponent(login, 5, 10);
        
        correo.setMaxLength(100);

        correo.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (correo.getValue().equals("")) {
                    correo.setComponentError(new UserError(""));
                    erracorre.setValue("Este campo es requerido");
                } else {
                    if (correo.getValue().matches(regexEmail)) {
                        if (correo.getValue().matches(regexEmailEstruct)) {
                            correo.setComponentError(null);
                            erracorre.setValue("");
                        } else {
                            correo.setComponentError(new UserError(""));
                            erracorre.setValue("La estructura del Correo Electrónico no es válida");
                        }
                    } else {
                        correo.setComponentError(new UserError(""));
                        erracorre.setValue("Este campo contiene caracteres no válidos");
                    }
                }
                ValidarError();
            }
        });

        login.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!login.getValue().equals("")) {
                    if (login.getValue().matches(regexAlpha)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        if (validaLogin(login.getValue().toString())) {
                            login.setComponentError(null);
                            errlog.setValue("");
                        } else {
                            login.setComponentError(new UserError(""));
                            errlog.setValue("El nombre de usuario ya existe");
                        }   
                    } else {
                        login.setComponentError(new UserError(""));
                        errlog.setValue("Este campo contiene caracteres no válidos");
                    }
                } else {
                    login.setComponentError(new UserError(""));
                    errlog.setValue("Este campo es requerido");
                }
                ValidarError();
            }
        });

        erracorre.setStyleName("lblerrores");
        vlInv.addComponent(erracorre, 2, 11);

        errlog.setStyleName("lblerrores");
        vlInv.addComponent(errlog, 5, 11);

        Label esp3 = new Label("");
        vlInv.setSpacing(true);
        Label cont = new Label("Contraseña:");

        Label vecont = new Label("Confirmar Contraseña:");

        vlInv.addComponent(esp3, 0, 12);
        vlInv.addComponent(cont, 0, 13);
        asteriscos = new Label("*");
        asteriscos.setStyleName("asterix");
        vlInv.addComponent(asteriscos, 1, 13);
        clave.setMaxLength(20);
        vlInv.addComponent(clave, 2, 13);

        clave.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (clave.getValue().equals("")) {
                    clave.setComponentError(new UserError(""));
                    errcla.setValue("Este campo es requerido");
                } else {               
                    if (validaLongitudContra(clave.getValue())) {
                      if(caracteresConsecutivos(clave.getValue())){
                        if (validarSecuen(clave.getValue())) {
                            if (validaunaMayus(clave.getValue())) {
                                if (validalfaNum(clave.getValue())) {
                                    if (validaunCaracter(clave.getValue())) {
                                        if (validaunNumero(clave.getValue())) {
                                            //Diccionario de contraseñas
                                            //Validar que la clave no contega palabras restringidas                                             
                                            Boolean palpermitida = facadediccionario.validaRestringidas(clave.getValue());
                                            if (palpermitida){
                                               clave.setComponentError(new UserError(""));
                                               errcla.setValue("La contraseña contiene una palabra no permitida"); 
                                            }else{
                                                clave.setComponentError(null);
                                                errcla.setValue("");  
                                            }                                                                                  
                                        } else {
                                            clave.setComponentError(new UserError(""));
                                            errcla.setValue("La contraseña debe tener al menos un número");
                                        }
                                    } else {
                                        clave.setComponentError(new UserError(""));
                                        errcla.setValue("La contraseña debe tener al menos un carácter especial");
                                    }

                                } else {
                                    clave.setComponentError(new UserError(""));
                                    errcla.setValue("La contraseña debe ser alfanumerica");
                                }
                            } else {
                                clave.setComponentError(new UserError(""));
                                errcla.setValue("La contraseña debe tener al menos una mayúscula");
                            }
                        } else {
                            clave.setComponentError(new UserError(""));
                            errcla.setValue("La contraseña no debe contener caracteres consecutivos ");
                        }
                      } else {
                        clave.setComponentError(new UserError(""));
                        errcla.setValue("La contraseña no debe contener más de 3 caracteres idénticos consecutivos");
                     } 
                    } else {
                        clave.setComponentError(new UserError(""));
                        errcla.setValue("La contraseña debe contener mínimo 8 caracteres máximo 15");
                       }                      
                }
                ValidarError();
            }
        });
        vlInv.addComponent(vecont, 3, 13);
        asteriscos = new Label("*");
        asteriscos.setStyleName("asterix");
        vlInv.addComponent(asteriscos, 4, 13);
        vlInv.addComponent(verclave, 5, 13);
        verclave.setMaxLength(20);
        verclave.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (verclave.getValue().equals("")) {
                    verclave.setComponentError(new UserError(""));
                    errvercla.setValue("Este campo es requerido");
                } else {

                    if (!clave.getValue().equals(verclave.getValue())) {
                        verclave.setComponentError(new UserError(""));
                        errvercla.setValue("Las contraseñas ingresadas no coinciden");      
                    }else{
                        verclave.setComponentError(null);
                        errvercla.setValue("");
                    }
                }
                ValidarError();
            }
        });

        errcla.setStyleName("lblerrores");
        vlInv.addComponent(errcla, 2, 14);

        errvercla.setStyleName("lblerrores");
        vlInv.addComponent(errvercla, 5, 14);

        perfiles = LlenarTipoPerfiles();
        perfiles.select("");

        if (PerfilActual.equals("Riesgos")) {
            perfiles.removeItem(3);
            perfiles.removeItem(4);
            perfiles.removeItem(5);
        }

        if (PerfilActual.equals("Administrador SCB")) {
            perfiles.removeItem(1);
            perfiles.removeItem(2);
            perfiles.removeItem(3);
            perfiles.removeItem(5);
        }
        if (PerfilActual.equals("Administrador General")) {
            perfiles.removeItem(5);
        }

        perfiles.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (perfiles.getValue() == null || perfiles.getValue().equals("")) {
                    perfiles.setComponentError(new UserError(""));
                    errper.setValue("Este campo es requerido");
                } else {
                    perfiles.setComponentError(null);
                    errper.setValue("");
                }
                ValidarError();
            }
        });

        Cbxestado.setTextInputAllowed(false);
        Cbxestado.setNullSelectionAllowed(false);
        Cbxestado.addItem("");
        Cbxestado.setItemCaption("", "Seleccione");
        Cbxestado.addItem(1);
        Cbxestado.setItemCaption(1, "Activo");
        Cbxestado.addItem(2);
        Cbxestado.setItemCaption(2, "Inactivo");
        Cbxestado.addItem(3);
        Cbxestado.setItemCaption(3, "Bloqueado");

        Cbxestado.select("");

        Cbxestado.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (Cbxestado.getValue() == null || Cbxestado.getValue().equals("")) {
                    Cbxestado.setComponentError(new UserError(""));
                    errest.setValue("Este campo es requerido");
                } else {
                    Cbxestado.setComponentError(null);
                    errest.setValue("");
                }
                ValidarError();
            }
        });

        vlInv.setSpacing(true);
        Label esp4 = new Label("");
        Label per = new Label("Perfiles:");
        vlInv.addComponent(esp4, 0, 15);
        vlInv.addComponent(per, 0, 16);
        asteriscos = new Label("*");
        asteriscos.setStyleName("asterix");
        vlInv.addComponent(asteriscos, 1, 16);
        vlInv.addComponent(perfiles, 2, 16);
        vlInv.setSpacing(true);
        Label est = new Label("Estado:");
        vlInv.addComponent(est, 3, 16);
        asteriscos = new Label("*");
        asteriscos.setStyleName("asterix");
        vlInv.addComponent(asteriscos, 4, 16);
        vlInv.addComponent(Cbxestado, 5, 16);

        errper.setStyleName("lblerrores");
        vlInv.addComponent(errper, 2, 17);

        errest.setStyleName("lblerrores");
        vlInv.addComponent(errest, 5, 17);
        
        
        //Ip's
        Label ipLabel = new Label("Direcciones IP autorizadas:");        
        vlInv.addComponent(ipLabel,0,18);
        vlInv.addComponent(ip1,2,18);
        ip1.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                
                 if (ip1.getValue().equals("")) {
                        ip1.setComponentError(new UserError(""));
                        errIp1.setValue("Este campo es requerido");
                    } else {
                if (!ip1.getValue().equals("")) {
                    if (ip1.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip1.setComponentError(null);
                        errIp1.setValue("");
                    } else {
                        ip1.setComponentError(new UserError(""));
                        errIp1.setValue("Dirección Ip inválida");
                    }                                           
                } else {
                            ip1.setComponentError(null);
                            errIp1.setValue("");
                        }
               }
                ValidarError();
            }
        });
        errIp1.setStyleName("lblerrores");
        vlInv.addComponent(errIp1,2,19);
        
        
        
        vlInv.addComponent(ip2,3,18);
        ip2.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip2.getValue().equals("")) {
                    if (ip2.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip2.setComponentError(null);
                        errIp2.setValue("");
                    } else {
                        ip2.setComponentError(new UserError(""));
                        errIp2.setValue("Dirección Ip inválida");
                    }
                } else {
                            ip2.setComponentError(null);
                            errIp2.setValue("");
                        }
                ValidarError();
            }
        });
        errIp2.setStyleName("lblerrores");
        vlInv.addComponent(errIp2,3,19);

        vlInv.addComponent(ip3,5,18);
        ip3.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip3.getValue().equals("")) {
                    if (ip3.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip3.setComponentError(null);
                        errIp3.setValue("");
                    } else {
                        ip3.setComponentError(new UserError(""));
                        errIp3.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip3.setComponentError(null);
                            errIp3.setValue("");
                        }
                ValidarError();
            }
        });
        errIp3.setStyleName("lblerrores");
        vlInv.addComponent(errIp3,5,19);

        vlInv.addComponent(ip4,2,20);
        ip4.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip4.getValue().equals("")) {
                    if (ip4.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip4.setComponentError(null);
                        errIp4.setValue("");
                    } else {
                        ip4.setComponentError(new UserError(""));
                        errIp4.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip4.setComponentError(null);
                            errIp4.setValue("");
                        }
                ValidarError();
            }
        });
        errIp4.setStyleName("lblerrores");
        vlInv.addComponent(errIp4,2,21);

        vlInv.addComponent(ip5,3,20);
        ip5.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip5.getValue().equals("")) {
                    if (ip5.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip5.setComponentError(null);
                        errIp5.setValue("");
                    } else {
                        ip5.setComponentError(new UserError(""));
                        errIp5.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip5.setComponentError(null);
                            errIp5.setValue("");
                        }
                ValidarError();
            }
        });
        errIp5.setStyleName("lblerrores");
        vlInv.addComponent(errIp5,3,21);

        vlInv.addComponent(ip6,5,20);
        ip6.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip6.getValue().equals("")) {
                    if (ip6.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip6.setComponentError(null);
                        errIp6.setValue("");
                    } else {
                        ip6.setComponentError(new UserError(""));
                        errIp6.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip6.setComponentError(null);
                            errIp6.setValue("");
                        }
                ValidarError();
            }
        });
        errIp6.setStyleName("lblerrores");
        vlInv.addComponent(errIp6,5,21);

        vlInv.addComponent(ip7,2,22);
        ip7.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip7.getValue().equals("")) {
                    if (ip7.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip7.setComponentError(null);
                        errIp7.setValue("");
                    } else {
                        ip7.setComponentError(new UserError(""));
                        errIp7.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip7.setComponentError(null);
                            errIp7.setValue("");
                        }
                ValidarError();
            }
        });
        errIp7.setStyleName("lblerrores");
        vlInv.addComponent(errIp7,2,23);

        vlInv.addComponent(ip8,3,22);
        ip8.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip8.getValue().equals("")) {
                    if (ip8.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip8.setComponentError(null);
                        errIp8.setValue("");
                    } else {
                        ip8.setComponentError(new UserError(""));
                        errIp8.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip8.setComponentError(null);
                            errIp8.setValue("");
                        }
                ValidarError();
            }
        });
        errIp8.setStyleName("lblerrores");
        vlInv.addComponent(errIp8,3,23);

        vlInv.addComponent(ip9,5,22);
        ip9.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip9.getValue().equals("")) {
                    if (ip9.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip9.setComponentError(null);
                        errIp9.setValue("");
                    } else {
                        ip9.setComponentError(new UserError(""));
                        errIp9.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip9.setComponentError(null);
                            errIp9.setValue("");
                        }
                ValidarError();
            }
        });
        errIp9.setStyleName("lblerrores");
        vlInv.addComponent(errIp9,5,23);

        vlInv.addComponent(ip10,2,24);
        ip10.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip10.getValue().equals("")) {
                    if (ip10.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip10.setComponentError(null);
                        errIp10.setValue("");
                    } else {
                        ip10.setComponentError(new UserError(""));
                        errIp10.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip10.setComponentError(null);
                            errIp10.setValue("");
                        }
                ValidarError();
            }
        });
        errIp10.setStyleName("lblerrores");
        vlInv.addComponent(errIp10,2,25);

        vlInv.addComponent(ip11,3,24);
        ip11.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip11.getValue().equals("")) {
                    if (ip11.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip11.setComponentError(null);
                        errIp11.setValue("");
                    } else {
                        ip11.setComponentError(new UserError(""));
                        errIp11.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip11.setComponentError(null);
                            errIp11.setValue("");
                        }
                ValidarError();
            }
        });
        errIp11.setStyleName("lblerrores");
        vlInv.addComponent(errIp11,3,25);

        vlInv.addComponent(ip12,5,24);
        ip12.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip12.getValue().equals("")) {
                    if (ip12.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip12.setComponentError(null);
                        errIp12.setValue("");
                    } else {
                        ip12.setComponentError(new UserError(""));
                        errIp12.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip12.setComponentError(null);
                            errIp12.setValue("");
                        }
                ValidarError();
            }
        });
        errIp12.setStyleName("lblerrores");
        vlInv.addComponent(errIp12,5,25);

        vlInv.addComponent(ip13,2,26);
        ip13.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip13.getValue().equals("")) {
                    if (ip13.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip13.setComponentError(null);
                        errIp13.setValue("");
                    } else {
                        ip13.setComponentError(new UserError(""));
                        errIp13.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip13.setComponentError(null);
                            errIp13.setValue("");
                        }
                ValidarError();
            }
        });
        errIp13.setStyleName("lblerrores");
        vlInv.addComponent(errIp13,2,27);

        vlInv.addComponent(ip14,3,26);
        ip14.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip14.getValue().equals("")) {
                    if (ip14.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip14.setComponentError(null);
                        errIp14.setValue("");
                    } else {
                        ip14.setComponentError(new UserError(""));
                        errIp14.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip14.setComponentError(null);
                            errIp14.setValue("");
                        }
                ValidarError();
            }
        });
        errIp14.setStyleName("lblerrores");
        vlInv.addComponent(errIp14,3,27);

        vlInv.addComponent(ip15,5,26);
        ip15.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip15.getValue().equals("")) {
                    if (ip15.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip15.setComponentError(null);
                        errIp15.setValue("");
                    } else {
                        ip15.setComponentError(new UserError(""));
                        errIp15.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip15.setComponentError(null);
                            errIp15.setValue("");
                        }
                ValidarError();
            }
        });
        errIp15.setStyleName("lblerrores");
        vlInv.addComponent(errIp15,5,27);
        
        vlInv.addComponent(ip16,2,28);
        ip16.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip16.getValue().equals("")) {
                    if (ip16.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip16.setComponentError(null);
                        errIp16.setValue("");
                    } else {
                        ip16.setComponentError(new UserError(""));
                        errIp16.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip16.setComponentError(null);
                            errIp16.setValue("");
                        }
                ValidarError();
            }
        });
        errIp16.setStyleName("lblerrores");
        vlInv.addComponent(errIp16,2,29);
        
        vlInv.addComponent(ip17,3,28);
        ip17.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip17.getValue().equals("")) {
                    if (ip17.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip17.setComponentError(null);
                        errIp17.setValue("");
                    } else {
                        ip17.setComponentError(new UserError(""));
                        errIp17.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip17.setComponentError(null);
                            errIp17.setValue("");
                        }
                ValidarError();
            }
        });
        errIp17.setStyleName("lblerrores");
        vlInv.addComponent(errIp17,3,29);
        
        vlInv.addComponent(ip18,5,28);
        ip18.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip18.getValue().equals("")) {
                    if (ip18.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip18.setComponentError(null);
                        errIp18.setValue("");
                    } else {
                        ip18.setComponentError(new UserError(""));
                        errIp18.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip18.setComponentError(null);
                            errIp18.setValue("");
                        }
                ValidarError();
            }
        });
        errIp18.setStyleName("lblerrores");
        vlInv.addComponent(errIp18,5,29);
        
        vlInv.addComponent(ip19,2,30);
        ip19.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip19.getValue().equals("")) {
                    if (ip19.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip19.setComponentError(null);
                        errIp19.setValue("");
                    } else {
                        ip19.setComponentError(new UserError(""));
                        errIp19.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip19.setComponentError(null);
                            errIp19.setValue("");
                        }
                ValidarError();
            }
        });
        errIp19.setStyleName("lblerrores");
        vlInv.addComponent(errIp19,2,31);
        
        vlInv.addComponent(ip20,3,30);
        ip20.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip20.getValue().equals("")) {
                    if (ip20.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip20.setComponentError(null);
                        errIp20.setValue("");
                    } else {
                        ip20.setComponentError(new UserError(""));
                        errIp20.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip20.setComponentError(null);
                            errIp20.setValue("");
                        }
                ValidarError();
            }
        });
        errIp20.setStyleName("lblerrores");
        vlInv.addComponent(errIp20,3,31);
        
        vlInv.addComponent(ip21,5,30);
        ip21.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip21.getValue().equals("")) {
                    if (ip21.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip21.setComponentError(null);
                        errIp21.setValue("");
                    } else {
                        ip21.setComponentError(new UserError(""));
                        errIp21.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip21.setComponentError(null);
                            errIp21.setValue("");
                        }
                ValidarError();
            }
        });
        errIp21.setStyleName("lblerrores");
        vlInv.addComponent(errIp21,5,31);
        
        vlInv.addComponent(ip22,2,32);
        ip22.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip22.getValue().equals("")) {
                    if (ip22.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip22.setComponentError(null);
                        errIp22.setValue("");
                    } else {
                        ip22.setComponentError(new UserError(""));
                        errIp22.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip22.setComponentError(null);
                            errIp22.setValue("");
                        }
                ValidarError();
            }
        });
        errIp22.setStyleName("lblerrores");
        vlInv.addComponent(errIp22,2,33);
        
        vlInv.addComponent(ip23,3,32);
        ip23.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip23.getValue().equals("")) {
                    if (ip23.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip23.setComponentError(null);
                        errIp23.setValue("");
                    } else {
                        ip23.setComponentError(new UserError(""));
                        errIp23.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip23.setComponentError(null);
                            errIp23.setValue("");
                        }
                ValidarError();
            }
        });
        errIp23.setStyleName("lblerrores");
        vlInv.addComponent(errIp23,3,33);
        
        vlInv.addComponent(ip24,5,32);
        ip24.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip24.getValue().equals("")) {
                    if (ip24.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip24.setComponentError(null);
                        errIp24.setValue("");
                    } else {
                        ip24.setComponentError(new UserError(""));
                        errIp24.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip24.setComponentError(null);
                            errIp24.setValue("");
                        }
                ValidarError();
            }
        });
        errIp24.setStyleName("lblerrores");
        vlInv.addComponent(errIp24,5,33);
        
        vlInv.addComponent(ip25,2,34);
        ip25.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip25.getValue().equals("")) {
                    if (ip25.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip25.setComponentError(null);
                        errIp25.setValue("");
                    } else {
                        ip25.setComponentError(new UserError(""));
                        errIp25.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip25.setComponentError(null);
                            errIp25.setValue("");
                        }
                ValidarError();
            }
        });
        errIp25.setStyleName("lblerrores");
        vlInv.addComponent(errIp25,2,35);
        
        vlInv.addComponent(ip26,3,34);
        ip26.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip26.getValue().equals("")) {
                    if (ip26.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip26.setComponentError(null);
                        errIp26.setValue("");
                    } else {
                        ip26.setComponentError(new UserError(""));
                        errIp26.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip26.setComponentError(null);
                            errIp26.setValue("");
                        }
                ValidarError();
            }
        });
        errIp26.setStyleName("lblerrores");
        vlInv.addComponent(errIp26,3,35);
        
        vlInv.addComponent(ip27,5,34);
        ip27.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip27.getValue().equals("")) {
                    if (ip27.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip27.setComponentError(null);
                        errIp27.setValue("");
                    } else {
                        ip27.setComponentError(new UserError(""));
                        errIp27.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip27.setComponentError(null);
                            errIp27.setValue("");
                        }
                ValidarError();
            }
        });
        errIp27.setStyleName("lblerrores");
        vlInv.addComponent(errIp27,5,35);
        
        vlInv.addComponent(ip28,2,36);
        ip28.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip28.getValue().equals("")) {
                    if (ip28.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip28.setComponentError(null);
                        errIp28.setValue("");
                    } else {
                        ip28.setComponentError(new UserError(""));
                        errIp28.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip28.setComponentError(null);
                            errIp28.setValue("");
                        }
                ValidarError();
            }
        });
        errIp28.setStyleName("lblerrores");
        vlInv.addComponent(errIp28,2,37);
        
        vlInv.addComponent(ip29,3,36);
        ip29.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip29.getValue().equals("")) {
                    if (ip29.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip29.setComponentError(null);
                        errIp29.setValue("");
                    } else {
                        ip29.setComponentError(new UserError(""));
                        errIp29.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip29.setComponentError(null);
                            errIp29.setValue("");
                        }
                ValidarError();
            }
        });
        errIp29.setStyleName("lblerrores");
        vlInv.addComponent(errIp29,3,37);
        
        vlInv.addComponent(ip30,5,36);
        ip30.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip30.getValue().equals("")) {
                    if (ip30.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip30.setComponentError(null);
                        errIp30.setValue("");
                    } else {
                        ip30.setComponentError(new UserError(""));
                        errIp30.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip30.setComponentError(null);
                            errIp30.setValue("");
                        }
                ValidarError();
            }
        });
        errIp30.setStyleName("lblerrores");
        vlInv.addComponent(errIp30,5,37);
        
        vlInv.addComponent(ip31,2,38);
        ip31.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip31.getValue().equals("")) {
                    if (ip31.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip31.setComponentError(null);
                        errIp31.setValue("");
                    } else {
                        ip31.setComponentError(new UserError(""));
                        errIp31.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip31.setComponentError(null);
                            errIp31.setValue("");
                        }
                ValidarError();
            }
        });
        errIp31.setStyleName("lblerrores");
        vlInv.addComponent(errIp31,2,39);
        
        vlInv.addComponent(ip32,3,38);
        ip32.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip32.getValue().equals("")) {
                    if (ip32.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip32.setComponentError(null);
                        errIp32.setValue("");
                    } else {
                        ip32.setComponentError(new UserError(""));
                        errIp32.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip32.setComponentError(null);
                            errIp32.setValue("");
                        }
                ValidarError();
            }
        });
        errIp32.setStyleName("lblerrores");
        vlInv.addComponent(errIp32,3,39);
        
        vlInv.addComponent(ip33,5,38);
        ip33.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip33.getValue().equals("")) {
                    if (ip33.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip33.setComponentError(null);
                        errIp33.setValue("");
                    } else {
                        ip33.setComponentError(new UserError(""));
                        errIp33.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip33.setComponentError(null);
                            errIp33.setValue("");
                        }
                ValidarError();
            }
        });
        errIp33.setStyleName("lblerrores");
        vlInv.addComponent(errIp33,5,39);
        
        vlInv.addComponent(ip34,2,40);
        ip34.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip34.getValue().equals("")) {
                    if (ip34.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip34.setComponentError(null);
                        errIp34.setValue("");
                    } else {
                        ip34.setComponentError(new UserError(""));
                        errIp34.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip34.setComponentError(null);
                            errIp34.setValue("");
                        }
                ValidarError();
            }
        });
        errIp34.setStyleName("lblerrores");
        vlInv.addComponent(errIp34,2,41);
        
        vlInv.addComponent(ip35,3,40);
        ip35.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip35.getValue().equals("")) {
                    if (ip35.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip35.setComponentError(null);
                        errIp35.setValue("");
                    } else {
                        ip35.setComponentError(new UserError(""));
                        errIp35.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip35.setComponentError(null);
                            errIp35.setValue("");
                        }
                ValidarError();
            }
        });
        errIp35.setStyleName("lblerrores");
        vlInv.addComponent(errIp35,3,41);
        
        vlInv.addComponent(ip36,5,40);
        ip36.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip36.getValue().equals("")) {
                    if (ip36.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip36.setComponentError(null);
                        errIp36.setValue("");
                    } else {
                        ip36.setComponentError(new UserError(""));
                        errIp36.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip36.setComponentError(null);
                            errIp36.setValue("");
                        }
                ValidarError();
            }
        });
        errIp36.setStyleName("lblerrores");
        vlInv.addComponent(errIp36,5,41);
        
        vlInv.addComponent(ip37,2,42);
        ip37.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip37.getValue().equals("")) {
                    if (ip37.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip37.setComponentError(null);
                        errIp17.setValue("");
                    } else {
                        ip37.setComponentError(new UserError(""));
                        errIp37.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip37.setComponentError(null);
                            errIp37.setValue("");
                        }
                ValidarError();
            }
        });
        errIp37.setStyleName("lblerrores");
        vlInv.addComponent(errIp37,2,43);
        
        vlInv.addComponent(ip38,3,42);
        ip38.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip38.getValue().equals("")) {
                    if (ip38.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip38.setComponentError(null);
                        errIp38.setValue("");
                    } else {
                        ip38.setComponentError(new UserError(""));
                        errIp38.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip38.setComponentError(null);
                            errIp38.setValue("");
                        }
                ValidarError();
            }
        });
        errIp38.setStyleName("lblerrores");
        vlInv.addComponent(errIp38,3,43);
        
        vlInv.addComponent(ip39,5,42);
        ip39.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip39.getValue().equals("")) {
                    if (ip39.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip39.setComponentError(null);
                        errIp39.setValue("");
                    } else {
                        ip39.setComponentError(new UserError(""));
                        errIp39.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip39.setComponentError(null);
                            errIp39.setValue("");
                        }
                ValidarError();
            }
        });
        errIp39.setStyleName("lblerrores");
        vlInv.addComponent(errIp39,5,43);
        
        vlInv.addComponent(ip40,2,44);
        ip40.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip40.getValue().equals("")) {
                    if (ip40.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip40.setComponentError(null);
                        errIp40.setValue("");
                    } else {
                        ip40.setComponentError(new UserError(""));
                        errIp40.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip40.setComponentError(null);
                            errIp40.setValue("");
                        }
                ValidarError();
            }
        });
        errIp40.setStyleName("lblerrores");
        vlInv.addComponent(errIp40,2,45);
        
        Button guardar = new Button("Guardar");
        Button cancelar = new Button("Cancelar");

        cancelar.addClickListener(new Button.ClickListener() {
            private static final long serialVersionUID = 1L;
            public void buttonClick(ClickEvent event) {
                usuarios.close();
                Limpiar();
                controladorEve = 0;
                error.setValue("");
            }
        });
        vlInv.addComponent(guardar, 0, 45);
        vlInv.addComponent(cancelar, 1, 45);
        VerticalLayout vl = new VerticalLayout();
        HorizontalLayout h = new HorizontalLayout();
        h.addComponents(guardar, cancelar);
        error.setStyleName("lblErrorVer");
        h.addComponent(error);
        cancelar.addStyleName("ButtCancelar");
        vl.addComponents(vlInv, h);  
        vlInv.addStyleName("StylegridLa");
        h.addStyleName("horizontal1");
        vl.setComponentAlignment(h, Alignment.BOTTOM_CENTER);
        guardar.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                try {
                    combo = (Integer) cmb.getValue();
                } catch (NullPointerException e) {
                    combo = 0;
                } catch (ClassCastException ex) {
                    combo = 0;
                }

                try {
                    comboPer = (Integer) perfiles.getValue();
                } catch (NullPointerException e) {
                    comboPer = 0;
                } catch (ClassCastException ex) {
                    comboPer = 0;
                }

                try {
                    comboEst = (Integer) Cbxestado.getValue();
                } catch (NullPointerException e) {
                    comboEst = 0;
                } catch (ClassCastException ex) {
                    comboEst = 0;
                }
                try {
                    comboScb = (Integer) scb.getValue();
                } catch (NullPointerException e) {
                    comboScb = 0;
                } catch (ClassCastException ex) {
                    comboScb = 0;
                }

                if (combo == 0) {
                    cmb.setComponentError(new UserError(""));
                    errIdcmb.setValue("Este campo es requerido");
                }
                if (numDoc.getValue().equals("")) {
                    numDoc.setComponentError(new UserError(""));
                    errnumDoc.setValue("Este campo es requerido");
                }
                if (nombres.getValue().equals("")) {
                    nombres.setComponentError(new UserError(""));
                    errnombre.setValue("Este campo es requerido");
                }
                if (apellidos.getValue().equals("")) {
                    apellidos.setComponentError(new UserError(""));
                    errape.setValue("Este campo es requerido");
                }
                if (correo.getValue().equals("")) {
                    correo.setComponentError(new UserError(""));
                    erracorre.setValue("Este campo es requerido");
                }
                if (login.getValue().equals("")) {
                    login.setComponentError(new UserError(""));
                    errlog.setValue("Este campo es requerido");
                }
                if (clave.getValue().equals("")) {
                    clave.setComponentError(new UserError(""));
                    errcla.setValue("Este campo es requerido");
                }
                if (verclave.getValue().equals("")) {
                    verclave.setComponentError(new UserError(""));
                    errvercla.setValue("Este campo es requerido");
                }
                if (comboPer == 0) {
                    perfiles.setComponentError(new UserError(""));
                    errper.setValue("Este campo es requerido");
                }
                if (comboEst == 0) {
                    Cbxestado.setComponentError(new UserError(""));
                    errest.setValue("Este campo es requerido");
                }
                if (ip1.getValue().equals("")) {
                    ip1.setComponentError(new UserError(""));
                    errIp1.setValue("Este campo es requerido");
                }
                
               if (!PerfilActual.equals("Administrador SCB")) {
                if (comboScb == 0) {
                    scb.setComponentError(new UserError(""));
                    errscb.setValue("Este campo es requerido");
                    ValidarError();
                }
               } 
                 ValidarError();
                if (!ValidaComponentError()) {
                    Usuario usu = new Usuario();
                    String est = "";
                    String tipD = "";
                    usu.setNombres(nombres.getValue());
                    usu.setApellidos(apellidos.getValue());

                    if (cmb.getValue().toString().equals("1")) {
                        tipD = "CC";
                    } else if (cmb.getValue().toString().equals("2")) {
                        tipD = "CE";
                    } else if (cmb.getValue().toString().equals("3")) {
                        tipD = "PAS";
                    }

                    usu.setTipoIdentificacion(tipD);
                    usu.setIdentificacion(numDoc.getValue());
                    usu.setEmail(correo.getValue());
                    usu.setUsername(login.getValue());
                    usu.setPassword(clave.getValue());

                    if (PerfilActual.equals("Riesgos") ||  PerfilActual.equals("Administrador General") ) {
                        usu.setSbolsa(Integer.parseInt(scb.getValue().toString()));
                    } else {
                        usu.setSbolsa(Integer.parseInt(IdsocBol));
                    }

                    if (Cbxestado.getValue().toString().equals("1")) {
                        est = "A";
                    } else if (Cbxestado.getValue().toString().equals("2")) {
                        est = "I";
                    } else if (Cbxestado.getValue().toString().equals("3")) {
                        est = "B";
                    }

                    usu.setEstado(est);

                    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                    HttpServletRequest req = attr.getRequest();
                    Auditoria au = new Auditoria();
                    // AJUSTE IP REGISTRADA
                    //au.setIp(req.getRemoteAddr());
                    String remoteAddr = req.getHeader("X-Forwarded-For");
                    if (remoteAddr == null || "".equals(remoteAddr)) {
                        au.setIp(req.getRemoteAddr());
                    } else {
                        String ips[] = remoteAddr.split(",");
                        remoteAddr = ips[0];
                        au.setIp(remoteAddr);
                    }
                    //au.setIp(req.getHeader("X-Forwarded-For"));

                    logger.debug("OPA - REMOTEADDR_" + req.getRemoteAddr() + "x-forwarded-For_" + req.getHeader("X-Forwarded-For") + "IP:" + remoteAddr);
                    // 
                    au.setId_user(userDetailsService.getUsuarioAutenticado().getId());
                    
                    String nomUsuario = userDetailsService.getUsuarioAutenticado().getUsername();
                    usu.setUsuariosistemaultimamod(nomUsuario);
                    
                    String tipomodificacion ="Ingreso Usuario - Inserción";
                    usu.setTipomodificacion(tipomodificacion);

                    //Crea la lista de Ips
                    ArrayList <IpAutorizada> ipsAutorizadas=new ArrayList<IpAutorizada>();
                    IpAutorizada a=null;
                    if (!ip1.getValue().equals("")) {
                       a=new IpAutorizada(new Integer(0),ip1.getValue(),nomUsuario,"Ingreso IP - Inserción");
                       ipsAutorizadas.add(a);
                    }
                    if (!ip2.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip2.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip3.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip3.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip4.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip4.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip5.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip5.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip6.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip6.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip7.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip7.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip8.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip8.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip9.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip9.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip10.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip10.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip11.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip11.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip12.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip12.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip13.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip13.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip14.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip14.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip15.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip15.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip16.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip16.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip17.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip17.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip18.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip18.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip19.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip19.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip20.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip20.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip21.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip21.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip22.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip22.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip23.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip23.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip24.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip24.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip25.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip25.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip26.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip26.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip27.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip27.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip28.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip28.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip29.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip29.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip30.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip30.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip31.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip31.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip32.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip32.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip33.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip33.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip34.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip34.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip35.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip35.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip36.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip36.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip37.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip37.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip38.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip38.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip39.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip39.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    if (!ip40.getValue().equals("")) {
                        a = new IpAutorizada(new Integer(0), ip40.getValue(), nomUsuario, "Ingreso IP - Inserción");
                        ipsAutorizadas.add(a);
                    }
                    
                    usu = userDetailsService.saveUsuario(usu, au, perfiles.getValue().toString(),ipsAutorizadas);

                    if (usu != null) {
                        Notification notif = new Notification(
                                "Confirmación",
                                "Usuario creado satisfactoriamente",
                                Notification.Type.HUMANIZED_MESSAGE);
                        notif.setDelayMsec(40000);
              
                        notif.show(Page.getCurrent());                    
                        usuarios.close();
                        grid.getSelectedRows().clear();
                        grid.getContainerDataSource().removeAllItems();
                        List<List<String>> listUsuarios = facade.Retornarusuarios();
                        String estado = "";
                        for (int i = 0; i < listUsuarios.get(0).size(); i++) {
                            if (listUsuarios.get(11).get(i).equals("A")) {
                                estado = "Activo";
                            } else if (listUsuarios.get(11).get(i).equals("I")) {
                                estado = "Inactivo";
                            } else if (listUsuarios.get(11).get(i).equals("B")) {
                                estado = "Bloqueado";
                            }
                            userDetailsService.getUsuarioAutenticado().getId();

                            String idScb = userDetailsService.getUsuarioAutenticado().getSbolsa().toString();

                            if (PerfilActual.equals("Administrador SCB")) {
                                listUsuarios = facade.RetornarusuariosSCB(idScb);
                            } else {

                                listUsuarios = facade.Retornarusuarios();

                            }
                            

                            
                            grid.addRow(listUsuarios.get(0).get(i), listUsuarios.get(6).get(i), listUsuarios.get(7).get(i), listUsuarios.get(3).get(i), listUsuarios.get(4).get(i), listUsuarios.get(18).get(i), listUsuarios.get(1).get(i), listUsuarios.get(17).get(i), estado, listUsuarios.get(5).get(i));
                            
                        }

                    } else {
                        Notification.show("Hubo un error en la creación del usuario", Notification.Type.ERROR_MESSAGE);
                    }
                }
                controladorEve = 0;
            }
        });

        usuarios.addCloseListener(new Window.CloseListener() {

            @Override
            public void windowClose(Window.CloseEvent e) {

                Limpiar();
                controladorEve = 0;
                error.setValue("");
            }
        });
        vlInv.addStyleName("StylegridLa");
        usuarios.setContent(vl);
        usuarios.show(UI.getCurrent(), null, true);
        usuarios.setWidth(900, Sizeable.Unit.PIXELS);
        usuarios.setHeight(650, Sizeable.Unit.PIXELS);

        return usuarios;

    }

    public ConfirmDialog retornaPanelModificarUsuarios() {

        Limpiar();

        modUsuarios = ConfirmDialog.getFactory().create("Modificar Usuarios.", "", "", "", "");
        VerticalLayout vl = new VerticalLayout();
        vl.setSpacing(true);
        this.llenarIps();

        if ((per.equals("Operador SCB") || per.equals("Riesgos")) && PerfilActual.equals("Riesgos")) {

            final GridLayout vlInv = new GridLayout(6, 42);
            vlInv.setMargin(true);
            vlInv.setStyleName("StylegridLa");
            Label esp = new Label("");
            Label tpID = new Label("Tipo Documento:");
            mcmb = LlenarTipoDocumentos();
            if (tipoD.equals("CC")) {
                mcmb.select(1);
            } else if (tipoD.equals("CE")) {
                mcmb.select(2);
            } else if (tipoD.equals("PAS")) {
                mcmb.select(3);
            }
            

            mcmb.addBlurListener(new FieldEvents.BlurListener() {
                @Override
                public void blur(FieldEvents.BlurEvent event) {
                    
                try {
                       valorCombo = (Integer) mcmb.getValue();
                    } catch (NullPointerException ex) {
                        valorCombo = 0;
                    } catch (ClassCastException e) {
                        valorCombo = 0;
                    }
                
                    numDoc.setComponentError(null);
                    errnumDoc.setValue("");

                    if (mcmb.getValue() == null || mcmb.getValue().equals("")) {
                        mcmb.setComponentError(new UserError(""));
                        errIdcmb.setValue("Este campo es requerido");
                    } else {
                        mcmb.setComponentError(null);
                        errIdcmb.setValue("");
                    }
                        
                    if (valorCombo == 2 || valorCombo == 3) {
                        if (!mnumDoc.getValue().matches(regexAlpha)) {
                            mnumDoc.setComponentError(new UserError(""));
                            errnumDoc.setValue("Este campo contiene caracteres no válidos");
                        }else{
                                mnumDoc.setComponentError(null);
                                errnumDoc.setValue("");
                            }
                    } else {
                        if (!mnumDoc.getValue().matches(regexNumeric)) {
                            mnumDoc.setComponentError(new UserError(""));
                            errnumDoc.setValue("Este campo contiene caracteres no válidos");
                        }else{
                            mnumDoc.setComponentError(null);
                            errnumDoc.setValue("");
                            }
                    }
                    ValidarError();
                }
            });

            vlInv.setSpacing(true);
            vlInv.addComponent(tpID, 0, 1);
            Label asteriscos = new Label("*");
            asteriscos.setStyleName("asterix");
            vlInv.addComponent(asteriscos, 1, 1);
            vlInv.addComponent(mcmb, 2, 1);
            mcmb.setEnabled(false);
            vlInv.setSpacing(true);
            Label ID = new Label("Número Documento:");
            vlInv.addComponent(ID, 3, 1);
            asteriscos = new Label("*");
            asteriscos.setStyleName("asterix");
            vlInv.addComponent(asteriscos, 4, 1);

            mnumDoc.setValue(numD);
            mnumDoc.setEnabled(false);
            vlInv.addComponent(mnumDoc, 5, 1);

            mnumDoc.setMaxLength(15);

            errIdcmb.setStyleName("lblerrores");
            vlInv.addComponent(errIdcmb, 2, 2);

            errnumDoc.setStyleName("lblerrores");
            vlInv.addComponent(errnumDoc, 5, 2);

            Label nom = new Label("Nombres:");

            vlInv.setSpacing(true);
            vlInv.addComponent(esp, 0, 3);
            vlInv.addComponent(nom, 0, 4);
            asteriscos = new Label("*");
            asteriscos.setStyleName("asterix");
            vlInv.addComponent(asteriscos, 1, 4);
            mnombres.setValue(nomb);
            mnombres.setEnabled(false);

            vlInv.addComponent(mnombres, 2, 4);
            vlInv.setSpacing(true);
            Label ape = new Label("Apellidos:");

            vlInv.addComponent(ape, 3, 4);
            asteriscos = new Label("*");
            asteriscos.setStyleName("asterix");
            vlInv.addComponent(asteriscos, 4, 4);

            mapellidos.setValue(apell);
            mapellidos.setEnabled(false);

            vlInv.addComponent(mapellidos, 5, 4);

            mnombres.setMaxLength(50);

            mapellidos.setMaxLength(50);

            errnombre.setStyleName("lblerrores");
            vlInv.addComponent(errnombre, 2, 5);

            errape.setStyleName("lblerrores");
            vlInv.addComponent(errape, 5, 5);

            Label scbEnti = new Label("SCB/Entidad");
            Label corr = new Label("Correo Electrónico:");

            Label esp1 = new Label("");

            vlInv.setSpacing(true);
            vlInv.addComponent(esp1, 0, 6);

            vlInv.addComponent(scbEnti, 0, 7);            
            String nombre = facade.RetornarSCBusuSelec(Integer.parseInt(socSCB));
            sociedad.setValue(nombre);
            vlInv.addComponent(sociedad, 2, 7);

            vlInv.setSpacing(true);

            Label logi = new Label("Login:");

            vlInv.setSpacing(true);
            Label esp2 = new Label("");
            vlInv.addComponent(esp2, 0, 8);
            vlInv.addComponent(corr, 0, 9);
            asteriscos = new Label("*");
            asteriscos.setStyleName("asterix");
            vlInv.addComponent(asteriscos, 1, 9);

            mcorreo.setValue(cor);
            mcorreo.setEnabled(false);

            vlInv.addComponent(mcorreo, 2, 9);
            vlInv.addComponent(logi, 3, 9);
            asteriscos = new Label("*");
            asteriscos.setStyleName("asterix");
            vlInv.addComponent(asteriscos, 4, 9);

            mlogin.setValue(log);
            mlogin.setEnabled(false);
            mlogin.setMaxLength(20);

            vlInv.addComponent(mlogin, 5, 9);

            mcorreo.setMaxLength(100);

            erracorre.setStyleName("lblerrores");
            vlInv.addComponent(erracorre, 2, 10);

            errlog.setStyleName("lblerrores");
            vlInv.addComponent(errlog, 5, 10);

            vlInv.setSpacing(true);

            mperfiles = LlenarTipoPerfiles();

            if (per.equals("Administrador SCB")) {
                mperfiles.select(1);
            } else if (per.equals("Administrador BVC")) {
                mperfiles.select(2);
            } else if (per.equals("Riesgos")) {
                mperfiles.select(3);
            } else if (per.equals("Operador SCB")) {
                mperfiles.select(4);
            }

            
            mperfiles.setReadOnly(true);
            mperfiles.setEnabled(false);
           
            mperfiles.addBlurListener(new FieldEvents.BlurListener() {
                @Override
                public void blur(FieldEvents.BlurEvent event) {
                    if (mperfiles.getValue() == null || mperfiles.getValue().equals("")) {
                        mperfiles.setComponentError(new UserError(""));
                        errper.setValue("Este campo es requerido");
                    } else {
                        mperfiles.setComponentError(null);
                        errper.setValue("");
                    }
                    ValidarError();
                }
            });

            mestado.setTextInputAllowed(false);
            mestado.setNullSelectionAllowed(false);
            mestado.addItem("");
            mestado.setItemCaption("", "Seleccione");
            mestado.addItem(1);
            mestado.setItemCaption(1, "Activo");
            mestado.addItem(2);
            mestado.setItemCaption(2, "Inactivo");
            mestado.addItem(3);
            mestado.setItemCaption(3, "Bloqueado");

            if (est.equals("Activo")) {
                mestado.select(1);
            } else if (est.equals("Inactivo")) {
                mestado.select(2);
            } else if (est.equals("Bloqueado")) {
                mestado.select(3);
            }

            mestado.removeItem(2);

            mestado.addBlurListener(new FieldEvents.BlurListener() {
                @Override
                public void blur(FieldEvents.BlurEvent event) {
                    if (mestado.getValue() == null || mestado.getValue().equals("")) {
                        mestado.setComponentError(new UserError(""));
                        errest.setValue("Este campo es requerido");
                    } else {
                        mestado.setComponentError(null);
                        errest.setValue("");
                    }
                    ValidarError();
                }
            });

            Label esp4 = new Label("");
            Label per = new Label("Perfiles:");
            vlInv.addComponent(esp4, 0, 11);
            vlInv.addComponent(per, 0, 12);
            asteriscos = new Label("*");
            asteriscos.setStyleName("asterix");
            vlInv.addComponent(asteriscos, 1, 12);
            vlInv.addComponent(mperfiles, 2, 12);
            vlInv.setSpacing(true);
            Label est = new Label("Estado:");
            vlInv.addComponent(est, 3, 12);
            asteriscos = new Label("*");
            asteriscos.setStyleName("asterix");
            vlInv.addComponent(asteriscos, 4, 12);
            vlInv.addComponent(mestado, 5, 12);

            errper.setStyleName("lblerrores");
            vlInv.addComponent(errper, 2, 13);

            errest.setStyleName("lblerrores");
            vlInv.addComponent(errest, 5, 13);

            
        //Ip's
        Label ipLabel = new Label("Direcciones IP autorizadas:");        
        vlInv.addComponent(ipLabel,0,14);
        vlInv.addComponent(ip1,2,14);
        ip1.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                
                 if (ip1.getValue().equals("")) {
                        ip1.setComponentError(new UserError(""));
                        errIp1.setValue("Este campo es requerido");
                    } else {
                if (!ip1.getValue().equals("")) {
                    if (ip1.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip1.setComponentError(null);
                        errIp1.setValue("");
                    } else {
                        ip1.setComponentError(new UserError(""));
                        errIp1.setValue("Dirección Ip inválida");
                    }                                           
                } else {
                            ip1.setComponentError(null);
                            errIp1.setValue("");
                        }
               }
                ValidarError();
            }
        });
        errIp1.setStyleName("lblerrores");
        vlInv.addComponent(errIp1,2,15);
        
        
        
        vlInv.addComponent(ip2,3,14);
        ip2.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip2.getValue().equals("")) {
                    if (ip2.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip2.setComponentError(null);
                        errIp2.setValue("");
                    } else {
                        ip2.setComponentError(new UserError(""));
                        errIp2.setValue("Dirección Ip inválida");
                    }
                } else {
                            ip2.setComponentError(null);
                            errIp2.setValue("");
                        }
                ValidarError();
            }
        });
        errIp2.setStyleName("lblerrores");
        vlInv.addComponent(errIp2,3,15);

        vlInv.addComponent(ip3,5,14);
        ip3.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip3.getValue().equals("")) {
                    if (ip3.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip3.setComponentError(null);
                        errIp3.setValue("");
                    } else {
                        ip3.setComponentError(new UserError(""));
                        errIp3.setValue("Dirección Ip inválida");
                    }
                } else {
                            ip3.setComponentError(null);
                            errIp3.setValue("");
                        }
                ValidarError();
            }
        });
        errIp3.setStyleName("lblerrores");
        vlInv.addComponent(errIp3,5,15);

        vlInv.addComponent(ip4,2,16);
        ip4.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip4.getValue().equals("")) {
                    if (ip4.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip4.setComponentError(null);
                        errIp4.setValue("");
                    } else {
                        ip4.setComponentError(new UserError(""));
                        errIp4.setValue("Dirección Ip inválida");
                    }
                } else {
                            ip4.setComponentError(null);
                            errIp4.setValue("");
                        }
                ValidarError();
            }
        });
        errIp4.setStyleName("lblerrores");
        vlInv.addComponent(errIp4,2,17);
        
        vlInv.addComponent(ip5,3,16);
        ip5.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip5.getValue().equals("")) {
                    if (ip5.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip5.setComponentError(null);
                        errIp5.setValue("");
                    } else {
                        ip5.setComponentError(new UserError(""));
                        errIp5.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip5.setComponentError(null);
                            errIp5.setValue("");
                        }
                ValidarError();
            }
        });
        errIp5.setStyleName("lblerrores");
        vlInv.addComponent(errIp5,3,17);

        vlInv.addComponent(ip6,5,16);
        ip6.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip6.getValue().equals("")) {
                    if (ip6.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip6.setComponentError(null);
                        errIp6.setValue("");
                    } else {
                        ip6.setComponentError(new UserError(""));
                        errIp6.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip6.setComponentError(null);
                            errIp6.setValue("");
                        }
                ValidarError();
            }
        });
        errIp6.setStyleName("lblerrores");
        vlInv.addComponent(errIp6,5,17);

        vlInv.addComponent(ip7,2,18);
        ip7.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip7.getValue().equals("")) {
                    if (ip7.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip7.setComponentError(null);
                        errIp7.setValue("");
                    } else {
                        ip7.setComponentError(new UserError(""));
                        errIp7.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip7.setComponentError(null);
                            errIp7.setValue("");
                        }
                ValidarError();
            }
        });
        errIp7.setStyleName("lblerrores");
        vlInv.addComponent(errIp7,2,19);

        vlInv.addComponent(ip8,3,18);
        ip8.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip8.getValue().equals("")) {
                    if (ip8.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip8.setComponentError(null);
                        errIp8.setValue("");
                    } else {
                        ip8.setComponentError(new UserError(""));
                        errIp8.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip8.setComponentError(null);
                            errIp8.setValue("");
                        }
                ValidarError();
            }
        });
        errIp8.setStyleName("lblerrores");
        vlInv.addComponent(errIp8,3,19);

        vlInv.addComponent(ip9,5,18);
        ip9.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip9.getValue().equals("")) {
                    if (ip9.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip9.setComponentError(null);
                        errIp9.setValue("");
                    } else {
                        ip9.setComponentError(new UserError(""));
                        errIp9.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip9.setComponentError(null);
                            errIp9.setValue("");
                        }
                ValidarError();
            }
        });
        errIp9.setStyleName("lblerrores");
        vlInv.addComponent(errIp9,5,19);

        vlInv.addComponent(ip10,2,20);
        ip10.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip10.getValue().equals("")) {
                    if (ip10.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip10.setComponentError(null);
                        errIp10.setValue("");
                    } else {
                        ip10.setComponentError(new UserError(""));
                        errIp10.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip10.setComponentError(null);
                            errIp10.setValue("");
                        }
                ValidarError();
            }
        });
        errIp10.setStyleName("lblerrores");
        vlInv.addComponent(errIp10,2,21);

        vlInv.addComponent(ip11,3,20);
        ip11.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip11.getValue().equals("")) {
                    if (ip11.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip11.setComponentError(null);
                        errIp11.setValue("");
                    } else {
                        ip11.setComponentError(new UserError(""));
                        errIp11.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip11.setComponentError(null);
                            errIp11.setValue("");
                        }
                ValidarError();
            }
        });
        errIp11.setStyleName("lblerrores");
        vlInv.addComponent(errIp11,3,21);

        vlInv.addComponent(ip12,5,20);
        ip12.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip12.getValue().equals("")) {
                    if (ip12.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip12.setComponentError(null);
                        errIp12.setValue("");
                    } else {
                        ip12.setComponentError(new UserError(""));
                        errIp12.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip12.setComponentError(null);
                            errIp12.setValue("");
                        }
                ValidarError();
            }
        });
        errIp12.setStyleName("lblerrores");
        vlInv.addComponent(errIp12,5,21);

        vlInv.addComponent(ip13,2,22);
        ip13.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip13.getValue().equals("")) {
                    if (ip13.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip13.setComponentError(null);
                        errIp13.setValue("");
                    } else {
                        ip13.setComponentError(new UserError(""));
                        errIp13.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip13.setComponentError(null);
                            errIp13.setValue("");
                        }
                ValidarError();
            }
        });
        errIp13.setStyleName("lblerrores");
        vlInv.addComponent(errIp13,2,23);

        vlInv.addComponent(ip14,3,22);
        ip14.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip14.getValue().equals("")) {
                    if (ip14.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip14.setComponentError(null);
                        errIp14.setValue("");
                    } else {
                        ip14.setComponentError(new UserError(""));
                        errIp14.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip14.setComponentError(null);
                            errIp14.setValue("");
                        }
                ValidarError();
            }
        });
        errIp14.setStyleName("lblerrores");
        vlInv.addComponent(errIp14,3,23);

        vlInv.addComponent(ip15,5,22);
        ip15.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip15.getValue().equals("")) {
                    if (ip15.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip15.setComponentError(null);
                        errIp15.setValue("");
                    } else {
                        ip15.setComponentError(new UserError(""));
                        errIp15.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip15.setComponentError(null);
                            errIp15.setValue("");
                        }
                ValidarError();
            }
        });
        errIp15.setStyleName("lblerrores");
        vlInv.addComponent(errIp15,5,23);
        
        vlInv.addComponent(ip16,2,24);
        ip16.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip16.getValue().equals("")) {
                    if (ip16.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip16.setComponentError(null);
                        errIp16.setValue("");
                    } else {
                        ip16.setComponentError(new UserError(""));
                        errIp16.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip16.setComponentError(null);
                            errIp16.setValue("");
                        }
                ValidarError();
            }
        });
        errIp16.setStyleName("lblerrores");
        vlInv.addComponent(errIp16,2,25);
        
        vlInv.addComponent(ip17,3,24);
        ip17.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip17.getValue().equals("")) {
                    if (ip17.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip17.setComponentError(null);
                        errIp17.setValue("");
                    } else {
                        ip17.setComponentError(new UserError(""));
                        errIp17.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip17.setComponentError(null);
                            errIp17.setValue("");
                        }
                ValidarError();
            }
        });
        errIp17.setStyleName("lblerrores");
        vlInv.addComponent(errIp17,3,25);
        
        vlInv.addComponent(ip18,5,24);
        ip18.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip18.getValue().equals("")) {
                    if (ip18.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip18.setComponentError(null);
                        errIp18.setValue("");
                    } else {
                        ip18.setComponentError(new UserError(""));
                        errIp18.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip18.setComponentError(null);
                            errIp18.setValue("");
                        }
                ValidarError();
            }
        });
        errIp18.setStyleName("lblerrores");
        vlInv.addComponent(errIp18,5,25);
        
        vlInv.addComponent(ip19,2,26);
        ip19.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip19.getValue().equals("")) {
                    if (ip19.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip19.setComponentError(null);
                        errIp19.setValue("");
                    } else {
                        ip19.setComponentError(new UserError(""));
                        errIp19.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip19.setComponentError(null);
                            errIp19.setValue("");
                        }
                ValidarError();
            }
        });
        errIp19.setStyleName("lblerrores");
        vlInv.addComponent(errIp19,2,27);
        
        vlInv.addComponent(ip20,3,26);
        ip20.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip20.getValue().equals("")) {
                    if (ip20.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip20.setComponentError(null);
                        errIp20.setValue("");
                    } else {
                        ip20.setComponentError(new UserError(""));
                        errIp20.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip20.setComponentError(null);
                            errIp20.setValue("");
                        }
                ValidarError();
            }
        });
        errIp20.setStyleName("lblerrores");
        vlInv.addComponent(errIp20,3,27);
        
        vlInv.addComponent(ip21,5,26);
        ip21.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip21.getValue().equals("")) {
                    if (ip21.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip21.setComponentError(null);
                        errIp21.setValue("");
                    } else {
                        ip21.setComponentError(new UserError(""));
                        errIp21.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip21.setComponentError(null);
                            errIp21.setValue("");
                        }
                ValidarError();
            }
        });
        errIp21.setStyleName("lblerrores");
        vlInv.addComponent(errIp21,5,27);
        
        vlInv.addComponent(ip22,2,28);
        ip22.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip22.getValue().equals("")) {
                    if (ip22.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip22.setComponentError(null);
                        errIp22.setValue("");
                    } else {
                        ip22.setComponentError(new UserError(""));
                        errIp22.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip22.setComponentError(null);
                            errIp22.setValue("");
                        }
                ValidarError();
            }
        });
        errIp22.setStyleName("lblerrores");
        vlInv.addComponent(errIp22,2,29);
        
        vlInv.addComponent(ip23,3,28);
        ip23.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip23.getValue().equals("")) {
                    if (ip23.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip23.setComponentError(null);
                        errIp23.setValue("");
                    } else {
                        ip23.setComponentError(new UserError(""));
                        errIp23.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip23.setComponentError(null);
                            errIp23.setValue("");
                        }
                ValidarError();
            }
        });
        errIp23.setStyleName("lblerrores");
        vlInv.addComponent(errIp23,3,29);
        
        vlInv.addComponent(ip24,5,28);
        ip24.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip24.getValue().equals("")) {
                    if (ip24.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip24.setComponentError(null);
                        errIp24.setValue("");
                    } else {
                        ip24.setComponentError(new UserError(""));
                        errIp24.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip24.setComponentError(null);
                            errIp24.setValue("");
                        }
                ValidarError();
            }
        });
        errIp24.setStyleName("lblerrores");
        vlInv.addComponent(errIp24,5,29);
        
        vlInv.addComponent(ip25,2,30);
        ip25.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip25.getValue().equals("")) {
                    if (ip25.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip25.setComponentError(null);
                        errIp25.setValue("");
                    } else {
                        ip25.setComponentError(new UserError(""));
                        errIp25.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip25.setComponentError(null);
                            errIp25.setValue("");
                        }
                ValidarError();
            }
        });
        errIp25.setStyleName("lblerrores");
        vlInv.addComponent(errIp25,2,31);
        
        vlInv.addComponent(ip26,3,30);
        ip26.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip26.getValue().equals("")) {
                    if (ip26.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip26.setComponentError(null);
                        errIp26.setValue("");
                    } else {
                        ip26.setComponentError(new UserError(""));
                        errIp26.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip26.setComponentError(null);
                            errIp26.setValue("");
                        }
                ValidarError();
            }
        });
        errIp26.setStyleName("lblerrores");
        vlInv.addComponent(errIp26,3,31);
        
        vlInv.addComponent(ip27,5,30);
        ip27.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip27.getValue().equals("")) {
                    if (ip27.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip27.setComponentError(null);
                        errIp27.setValue("");
                    } else {
                        ip27.setComponentError(new UserError(""));
                        errIp27.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip27.setComponentError(null);
                            errIp27.setValue("");
                        }
                ValidarError();
            }
        });
        errIp27.setStyleName("lblerrores");
        vlInv.addComponent(errIp27,5,31);
        
        vlInv.addComponent(ip28,2,32);
        ip28.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip28.getValue().equals("")) {
                    if (ip28.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip28.setComponentError(null);
                        errIp28.setValue("");
                    } else {
                        ip28.setComponentError(new UserError(""));
                        errIp28.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip28.setComponentError(null);
                            errIp28.setValue("");
                        }
                ValidarError();
            }
        });
        errIp28.setStyleName("lblerrores");
        vlInv.addComponent(errIp28,2,33);
        
        vlInv.addComponent(ip29,3,32);
        ip29.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip29.getValue().equals("")) {
                    if (ip29.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip29.setComponentError(null);
                        errIp29.setValue("");
                    } else {
                        ip29.setComponentError(new UserError(""));
                        errIp29.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip29.setComponentError(null);
                            errIp29.setValue("");
                        }
                ValidarError();
            }
        });
        errIp29.setStyleName("lblerrores");
        vlInv.addComponent(errIp29,3,33);
        
        vlInv.addComponent(ip30,5,32);
        ip30.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip30.getValue().equals("")) {
                    if (ip30.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip30.setComponentError(null);
                        errIp30.setValue("");
                    } else {
                        ip30.setComponentError(new UserError(""));
                        errIp30.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip30.setComponentError(null);
                            errIp30.setValue("");
                        }
                ValidarError();
            }
        });
        errIp30.setStyleName("lblerrores");
        vlInv.addComponent(errIp30,5,33);
        
        vlInv.addComponent(ip31,2,34);
        ip31.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip31.getValue().equals("")) {
                    if (ip31.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip31.setComponentError(null);
                        errIp31.setValue("");
                    } else {
                        ip31.setComponentError(new UserError(""));
                        errIp31.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip31.setComponentError(null);
                            errIp31.setValue("");
                        }
                ValidarError();
            }
        });
        errIp31.setStyleName("lblerrores");
        vlInv.addComponent(errIp31,2,35);
        
        vlInv.addComponent(ip32,3,34);
        ip32.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip32.getValue().equals("")) {
                    if (ip32.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip32.setComponentError(null);
                        errIp32.setValue("");
                    } else {
                        ip32.setComponentError(new UserError(""));
                        errIp32.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip32.setComponentError(null);
                            errIp32.setValue("");
                        }
                ValidarError();
            }
        });
        errIp32.setStyleName("lblerrores");
        vlInv.addComponent(errIp32,3,35);
        
        vlInv.addComponent(ip33,5,34);
        ip33.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip33.getValue().equals("")) {
                    if (ip33.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip33.setComponentError(null);
                        errIp33.setValue("");
                    } else {
                        ip33.setComponentError(new UserError(""));
                        errIp33.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip33.setComponentError(null);
                            errIp33.setValue("");
                        }
                ValidarError();
            }
        });
        errIp33.setStyleName("lblerrores");
        vlInv.addComponent(errIp33,5,35);
        
        vlInv.addComponent(ip34,2,36);
        ip34.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip34.getValue().equals("")) {
                    if (ip34.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip34.setComponentError(null);
                        errIp34.setValue("");
                    } else {
                        ip34.setComponentError(new UserError(""));
                        errIp34.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip34.setComponentError(null);
                            errIp34.setValue("");
                        }
                ValidarError();
            }
        });
        errIp34.setStyleName("lblerrores");
        vlInv.addComponent(errIp34,2,37);
        
        vlInv.addComponent(ip35,3,36);
        ip35.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip35.getValue().equals("")) {
                    if (ip35.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip35.setComponentError(null);
                        errIp35.setValue("");
                    } else {
                        ip35.setComponentError(new UserError(""));
                        errIp35.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip35.setComponentError(null);
                            errIp35.setValue("");
                        }
                ValidarError();
            }
        });
        errIp35.setStyleName("lblerrores");
        vlInv.addComponent(errIp35,3,37);
        
        vlInv.addComponent(ip36,5,36);
        ip36.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip36.getValue().equals("")) {
                    if (ip36.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip36.setComponentError(null);
                        errIp36.setValue("");
                    } else {
                        ip36.setComponentError(new UserError(""));
                        errIp36.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip36.setComponentError(null);
                            errIp36.setValue("");
                        }
                ValidarError();
            }
        });
        errIp36.setStyleName("lblerrores");
        vlInv.addComponent(errIp36,5,37);
        
        vlInv.addComponent(ip37,2,38);
        ip37.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip37.getValue().equals("")) {
                    if (ip37.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip37.setComponentError(null);
                        errIp17.setValue("");
                    } else {
                        ip37.setComponentError(new UserError(""));
                        errIp37.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip37.setComponentError(null);
                            errIp37.setValue("");
                        }
                ValidarError();
            }
        });
        errIp37.setStyleName("lblerrores");
        vlInv.addComponent(errIp37,2,39);
        
        vlInv.addComponent(ip38,3,38);
        ip38.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip38.getValue().equals("")) {
                    if (ip38.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip38.setComponentError(null);
                        errIp38.setValue("");
                    } else {
                        ip38.setComponentError(new UserError(""));
                        errIp38.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip38.setComponentError(null);
                            errIp38.setValue("");
                        }
                ValidarError();
            }
        });
        errIp38.setStyleName("lblerrores");
        vlInv.addComponent(errIp38,3,39);
        
        vlInv.addComponent(ip39,5,38);
        ip39.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip39.getValue().equals("")) {
                    if (ip39.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip39.setComponentError(null);
                        errIp39.setValue("");
                    } else {
                        ip39.setComponentError(new UserError(""));
                        errIp39.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip39.setComponentError(null);
                            errIp39.setValue("");
                        }
                ValidarError();
            }
        });
        errIp39.setStyleName("lblerrores");
        vlInv.addComponent(errIp39,5,39);
        
        vlInv.addComponent(ip40,2,40);
        ip40.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip40.getValue().equals("")) {
                    if (ip40.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip40.setComponentError(null);
                        errIp40.setValue("");
                    } else {
                        ip40.setComponentError(new UserError(""));
                        errIp40.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip40.setComponentError(null);
                            errIp40.setValue("");
                        }
                ValidarError();
            }
        });
        errIp40.setStyleName("lblerrores");
        vlInv.addComponent(errIp40,2,41);
        
            final Button modificar = new Button("Modificar");
            final Button cancelar = new Button("Cancelar");

            cancelar.addClickListener(new Button.ClickListener() {
                private static final long serialVersionUID = 1L;

                public void buttonClick(ClickEvent event) {

                    modUsuarios.close();
                    grid.select(null);
                    Limpiar();
                    select = 0;
                    controladorEve1 = 0; 
                    error.setValue("");
                    
                }
            });

            modUsuarios.addCloseListener(new Window.CloseListener() {

                @Override
                public void windowClose(Window.CloseEvent e) {

                    grid.select(null);
                    Limpiar();
                    select = 0;
                    controladorEve1 = 0;
                    error.setValue("");

                }
            });

            vlInv.addComponent(modificar, 0, 41);

            vlInv.addComponent(cancelar, 1, 41);

            HorizontalLayout h = new HorizontalLayout();
            h.addComponents(modificar, cancelar);
            error.setStyleName("lblErrorVer");
            h.addComponent(error);
            cancelar.addStyleName("ButtCancelar");
            vl.addComponents(vlInv, h);
            vlInv.addStyleName("StylegridLa");
            h.addStyleName("horizontal1");
            vl.setComponentAlignment(h, Alignment.MIDDLE_CENTER);

            modificar.addClickListener(new Button.ClickListener() {

                @Override
                public void buttonClick(Button.ClickEvent event) {

                    try {
                        combo = (Integer) mcmb.getValue();
                    } catch (NullPointerException e) {
                        combo = 0;
                    } catch (ClassCastException ex) {
                        combo = 0;
                    }

                    try {
                        comboPer = (Integer) mperfiles.getValue();
                    } catch (NullPointerException e) {
                        comboPer = 0;
                    } catch (ClassCastException ex) {
                        comboPer = 0;
                    }

                    try {
                        comboEst = (Integer) mestado.getValue();
                    } catch (NullPointerException e) {
                        comboEst = 0;
                    } catch (ClassCastException ex) {
                        comboEst = 0;
                    }

                    if (combo == 0) {
                        mcmb.setComponentError(new UserError(""));
                        errIdcmb.setValue("Este campo es requerido");
                    }

                    if (ip1.getValue().equals("")) {
                        ip1.setComponentError(new UserError(""));
                        errIp1.setValue("Este campo es requerido");
                    }

                    if (mnumDoc.getValue().equals("")) {
                        mnumDoc.setComponentError(new UserError(""));
                        errnumDoc.setValue("Este campo es requerido");
                    }
                    if (mnombres.getValue().equals("")) {
                        mnombres.setComponentError(new UserError(""));
                        errnombre.setValue("Este campo es requerido");
                    }
                    if (mapellidos.getValue().equals("")) {
                        mapellidos.setComponentError(new UserError(""));
                        errape.setValue("Este campo es requerido");
                    }
                    if (mcorreo.getValue().equals("")) {
                        mcorreo.setComponentError(new UserError(""));
                        erracorre.setValue("Este campo es requerido");
                    }
                    if (mlogin.getValue().equals("")) {
                        mlogin.setComponentError(new UserError(""));
                        errlog.setValue("Este campo es requerido");
                    }
                    if (comboPer == 0) {
                        mperfiles.setComponentError(new UserError(""));
                        errper.setValue("Este campo es requerido");
                    }
                    if (comboEst == 0) {
                        mestado.setComponentError(new UserError(""));
                        errest.setValue("Este campo es requerido");
                    }
                   ValidarError();
                    if (!ValidaComponentError()) {
                        Usuario usu = new Usuario();
                        String est = "";

                        usu.setId(Integer.parseInt(idUsu));
                        usu.setNombres(mnombres.getValue());
                        usu.setApellidos(mapellidos.getValue());

                        String tipD = "";
                        if (mcmb.getValue().toString().equals("1")) {
                            tipD = "CC";
                        } else if (mcmb.getValue().toString().equals("2")) {
                            tipD = "CE";
                        } else if (mcmb.getValue().toString().equals("3")) {
                            tipD = "PAS";
                        }

                        usu.setTipoIdentificacion(tipD);
                        usu.setIdentificacion(mnumDoc.getValue());
                        usu.setEmail(mcorreo.getValue());
                        usu.setUsername(mlogin.getValue());
                        usu.setPassword(mclave.getValue());
                        
                        usu.setSbolsa(Integer.parseInt(socSCB));

                        if (mestado.getValue().toString().equals("1")) {
                            est = "A";
                        } else if (mestado.getValue().toString().equals("2")) {
                            est = "I";
                        } else if (mestado.getValue().toString().equals("3")) {
                            est = "B";
                        }
                        
                        String nomUsuario = userDetailsService.getUsuarioAutenticado().getUsername();
                        usu.setUsuariosistemaultimamod(nomUsuario);
                        
                        String tipomodificacion = "Modificación Usuario - Modificación";
                        usu.setTipomodificacion(tipomodificacion);

                        usu.setEstado(est);

                        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                        HttpServletRequest req = attr.getRequest();
                        Auditoria au = new Auditoria();
                        // AJUSTE IP REGISTRADA

                        //au.setIp(req.getRemoteAddr());
                        String remoteAddr = req.getHeader("X-Forwarded-For");
                        if (remoteAddr == null || "".equals(remoteAddr)) {
                            au.setIp(req.getRemoteAddr());
                        } else {
                            String ips[] = remoteAddr.split(",");
                            remoteAddr = ips[0];
                            au.setIp(remoteAddr);
                        }
                        //au.setIp(req.getHeader("X-Forwarded-For"));

                        logger.debug("OPA - REMOTEADDR_" + req.getRemoteAddr() + "x-forwarded-For_" + req.getHeader("X-Forwarded-For") + "IP:" + remoteAddr);

                        // 
                        au.setId_user(userDetailsService.getUsuarioAutenticado().getId());
                        //Crea la lista de Ips
                        ArrayList<IpAutorizada> ipsAutorizadas = new ArrayList<IpAutorizada>();
                        IpAutorizada a = null;
                        if (!ip1.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip1.getValue(), userDetailsService.getUsuarioAutenticado().getUsername(), "Ingreso IP - Modificación");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip2.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip2.getValue(), userDetailsService.getUsuarioAutenticado().getUsername(), "Ingreso IP - Modificación");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip3.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip3.getValue(), userDetailsService.getUsuarioAutenticado().getUsername(), "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        } 
                        
                        if (!ip4.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip4.getValue(), userDetailsService.getUsuarioAutenticado().getUsername(), "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip5.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip5.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip6.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip6.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                         if (!ip7.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip7.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip8.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip8.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip9.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip9.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip10.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip10.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip11.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip11.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip12.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip12.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip13.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip13.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip14.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip14.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip15.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip15.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                            if (!ip16.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip16.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip17.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip17.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip18.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip18.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip19.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip19.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip20.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip20.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip21.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip21.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip22.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip22.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip23.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip23.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip24.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip24.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip25.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip25.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip26.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip26.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip27.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip27.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip28.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip28.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip29.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip29.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip30.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip30.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip31.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip31.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip32.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip32.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip33.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip33.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip34.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip34.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip35.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip35.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip36.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip36.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip37.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip37.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip38.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip38.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip39.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip39.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        if (!ip40.getValue().equals("")) {
                            a = new IpAutorizada(new Integer(0), ip40.getValue(), nomUsuario, "Ingreso IP - Inserción");
                            ipsAutorizadas.add(a);
                        }
                        
                        usu = userDetailsService.saveUsuario(usu, au, mperfiles.getValue().toString(),ipsAutorizadas);
                        
                        
                        if (usu != null) {
                            Notification notif = new Notification(
                                    "Confirmación",
                                    "Usuario Modificado Satisfactoriamente",
                                    Notification.Type.HUMANIZED_MESSAGE);

                        notif.setDelayMsec(40000);                            

                            notif.show(Page.getCurrent());

                            modUsuarios.close();
                            grid.getSelectedRows().clear();
                            grid.getContainerDataSource().removeAllItems();
                            List<List<String>> listUsuarios = facade.Retornarusuarios();
                            
                            String estado="";
                            for (int i = 0; i < listUsuarios.get(0).size(); i++) {
                                if (listUsuarios.get(11).get(i).equals("A")) {
                                    estado = "Activo";
                                } else if (listUsuarios.get(11).get(i).equals("I")) {
                                    estado = "Inactivo";
                                } else if (listUsuarios.get(11).get(i).equals("B")) {
                                    estado = "Bloqueado";
                                }
                                //Lsierra 2016-04-08 Mantis 2515
                                /*String scb = listUsuarios.get(18).get(i);
                                String[] list = scb.split("-");
                                String codigosc = list[0]; */
                                
                                grid.addRow(listUsuarios.get(0).get(i), listUsuarios.get(6).get(i), listUsuarios.get(7).get(i), listUsuarios.get(3).get(i), listUsuarios.get(4).get(i), listUsuarios.get(18).get(i), listUsuarios.get(1).get(i), listUsuarios.get(17).get(i), estado, listUsuarios.get(5).get(i));
                               // grid.addRow(listUsuarios.get(0).get(i), listUsuarios.get(6).get(i), listUsuarios.get(7).get(i), listUsuarios.get(3).get(i), listUsuarios.get(4).get(i), listUsuarios.get(16).get(i), listUsuarios.get(1).get(i), listUsuarios.get(17).get(i), listUsuarios.get(11).get(i), listUsuarios.get(5).get(i));
                            }
                        } else {
                            Notification.show("Hubo un error en la modificacion del usuario", Notification.Type.ERROR_MESSAGE);
                        }
                    }
                    controladorEve1 = 0;
                }
            });

            
            /////////////////////////////////////////USUARIO ADM SCB Y SELECCIONA OPERADOR////////////////////////////
        } else {
            if (per.equals("Operador SCB") && PerfilActual.equals("Administrador SCB")) {
                
                final GridLayout vlInv = new GridLayout(6, 46);
                vlInv.setMargin(true);
                vlInv.setStyleName("StylegridLa");
                Label esp = new Label("");
                Label tpID = new Label("Tipo Documento:");
                mcmb = LlenarTipoDocumentos();
                if (tipoD.equals("CC")) {
                    mcmb.select(1);
                } else if (tipoD.equals("CE")) {
                    mcmb.select(2);
                } else if (tipoD.equals("PAS")) {
                    mcmb.select(3);
                }

                mcmb.setEnabled(true);

                mcmb.addBlurListener(new FieldEvents.BlurListener() {
                    @Override
                    public void blur(FieldEvents.BlurEvent event) {
                        
                    try {
                        valorCombo = (Integer) mcmb.getValue();
                    } catch (NullPointerException ex) {
                        valorCombo = 0;
                    } catch (ClassCastException e) {
                        valorCombo = 0;
                    }
                    
                    numDoc.setComponentError(null);
                    errnumDoc.setValue("");

                    if (mcmb.getValue() == null || mcmb.getValue().equals("")) {
                        mcmb.setComponentError(new UserError(""));
                        errIdcmb.setValue("Este campo es requerido");
                    } else {
                        mcmb.setComponentError(null);
                        errIdcmb.setValue("");
                    }

                    if (valorCombo == 2 || valorCombo == 3) {
                        if (!mnumDoc.getValue().matches(regexAlpha)) {
                            mnumDoc.setComponentError(new UserError(""));
                            errnumDoc.setValue("Este campo contiene caracteres no válidos");
                        }else{
                                mnumDoc.setComponentError(null);
                                errnumDoc.setValue("");
                            }
                    } else {
                        if (!mnumDoc.getValue().matches(regexNumeric)) {
                            mnumDoc.setComponentError(new UserError(""));
                            errnumDoc.setValue("Este campo contiene caracteres no válidos");
                        }else{
                                mnumDoc.setComponentError(null);
                                errnumDoc.setValue("");
                            }
                    }

                        ValidarError();
                    }
                });

                vlInv.setSpacing(true);
                vlInv.addComponent(tpID, 0, 1);
                Label asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 1, 1);
                vlInv.addComponent(mcmb, 2, 1);
                vlInv.setSpacing(true);
                Label ID = new Label("Número Documento:");
                vlInv.addComponent(ID, 3, 1);
                asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 4, 1);

                mnumDoc.setValue(numD);
                mnumDoc.setEnabled(true);
                vlInv.addComponent(mnumDoc, 5, 1);

                mnumDoc.setMaxLength(15);

                mnumDoc.addBlurListener(new FieldEvents.BlurListener() {

                    @Override
                    public void blur(FieldEvents.BlurEvent event) {

                        try {
                            valorCombo = (Integer) mcmb.getValue();
                        } catch (NullPointerException ex) {
                            valorCombo = 0;
                        } catch (ClassCastException e) {
                            valorCombo = 0;
                        }
                        mnumDoc.setComponentError(null);
                        errnumDoc.setValue("");
                        if (mnumDoc.getValue().equals("")) {
                            mnumDoc.setComponentError(new UserError(""));
                            errnumDoc.setValue("Este campo es requerido");
                        }
                        if (valorCombo == 2 || valorCombo == 3) {
                            if (!mnumDoc.getValue().matches(regexAlpha)) {
                                mnumDoc.setComponentError(new UserError(""));
                                errnumDoc.setValue("Este campo contiene caracteres no válidos");
                            }else{
                                mnumDoc.setComponentError(null);
                                errnumDoc.setValue("");
                            }
                        } else {
                            if (!mnumDoc.getValue().matches(regexNumeric)) {
                                mnumDoc.setComponentError(new UserError(""));
                                errnumDoc.setValue("Este campo contiene caracteres no válidos");
                            }else{
                                mnumDoc.setComponentError(null);
                                errnumDoc.setValue("");
                            }
                        }

                        ValidarError();

                    }
                });

                errIdcmb.setStyleName("lblerrores");
                vlInv.addComponent(errIdcmb, 2, 2);

                errnumDoc.setStyleName("lblerrores");
                vlInv.addComponent(errnumDoc, 5, 2);

                Label nom = new Label("Nombres:");

                vlInv.setSpacing(true);
                vlInv.addComponent(esp, 0, 3);
                vlInv.addComponent(nom, 0, 4);
                asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 1, 4);

                mnombres.setValue(nomb);
                mnombres.setEnabled(true);
                vlInv.addComponent(mnombres, 2, 4);
                vlInv.setSpacing(true);
                Label ape = new Label("Apellidos:");

                vlInv.addComponent(ape, 3, 4);
                asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 4, 4);

                mapellidos.setValue(apell);
                mapellidos.setEnabled(true);
                vlInv.addComponent(mapellidos, 5, 4);

                mnombres.setMaxLength(50);

                mnombres.addBlurListener(new FieldEvents.BlurListener() {

                    @Override
                    public void blur(FieldEvents.BlurEvent event) {

                        if (!mnombres.getValue().equals("")) {
                            if (mnombres.getValue().matches(regexLetras)) {
                                mnombres.setComponentError(null);
                                errnombre.setValue("");
                            } else {
                                mnombres.setComponentError(new UserError(""));
                                errnombre.setValue("Este campo contiene caracteres no válidos");
                            }
                        } else {
                            mnombres.setComponentError(null);
                            errnombre.setValue("");
                        }
                        ValidarError();
                    }
                });

                mapellidos.setMaxLength(50);

                mapellidos.addBlurListener(new FieldEvents.BlurListener() {

                    @Override
                    public void blur(FieldEvents.BlurEvent event) {

                        if (!mapellidos.getValue().equals("")) {
                            if (mapellidos.getValue().matches(regexLetras)) {
                                mapellidos.setComponentError(null);
                                errape.setValue("");
                            } else {
                                mapellidos.setComponentError(new UserError(""));
                                errape.setValue("Este campo contiene caracteres no válidos");
                            }
                        } else {
                            mapellidos.setComponentError(null);
                            errape.setValue("");
                        }
                        ValidarError();
                    }
                });

                errnombre.setStyleName("lblerrores");
                vlInv.addComponent(errnombre, 2, 5);

                errape.setStyleName("lblerrores");
                vlInv.addComponent(errape, 5, 5);

                Label scbEnti = new Label("SCB/Entidad");
                Label corr = new Label("Correo Electrónico:");

                Label esp1 = new Label("");

                vlInv.setSpacing(true);
                vlInv.addComponent(esp1, 0, 6);

                vlInv.addComponent(scbEnti, 0, 7);
                String codigoscb= facade.RetornarSCBusuarioSelectid(Integer.parseInt(socSCB));
                String nombre = facade.RetornarSCBusuSelec(Integer.parseInt(socSCB));
                sociedad.setValue(codigoscb +"-"+nombre);
                vlInv.addComponent(sociedad, 2, 7);

                vlInv.setSpacing(true);

                Label logi = new Label("Login:");

                vlInv.setSpacing(true);
                Label esp2 = new Label("");
                vlInv.addComponent(esp2, 0, 8);
                vlInv.addComponent(corr, 0, 9);
                asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 1, 9);

                mcorreo.setValue(cor);
                mcorreo.setEnabled(true);
                vlInv.addComponent(mcorreo, 2, 9);
                vlInv.addComponent(logi, 3, 9);
                asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 4, 9);

                mlogin.setValue(log);
                mlogin.setEnabled(false);
                mlogin.setMaxLength(20);
                vlInv.addComponent(mlogin, 5, 9);

                mcorreo.setMaxLength(100);

                mcorreo.addBlurListener(new FieldEvents.BlurListener() {

                    @Override
                    public void blur(FieldEvents.BlurEvent event) {
                        if (mcorreo.getValue().equals("")) {
                            mcorreo.setComponentError(new UserError(""));
                            erracorre.setValue("Este campo es requerido");
                        } else {
                            if (mcorreo.getValue().matches(regexEmail)) {
                                if (mcorreo.getValue().matches(regexEmailEstruct)) {
                                    mcorreo.setComponentError(null);
                                    erracorre.setValue("");
                                } else {
                                    mcorreo.setComponentError(new UserError(""));
                                    erracorre.setValue("La estructura del Correo Electrónico no es válida");
                                }
                            } else {
                                mcorreo.setComponentError(new UserError(""));
                                erracorre.setValue("Este campo contiene caracteres no válidos");
                            }
                        }
                        ValidarError();
                    }
                });

                mlogin.addBlurListener(new FieldEvents.BlurListener() {

                    @Override
                    public void blur(FieldEvents.BlurEvent event) {

                        if (!mlogin.getValue().equals("")) {
                            if (mlogin.getValue().matches(regexAlpha)) {
                                mlogin.setComponentError(null);
                                errlog.setValue("");
                            } else {
                                mlogin.setComponentError(new UserError(""));
                                errlog.setValue("Este campo contiene caracteres no válidos");
                            }
                        } else {
                            mlogin.setComponentError(null);
                            errlog.setValue("");
                        }
                        ValidarError();
                    }
                });

                erracorre.setStyleName("lblerrores");
                vlInv.addComponent(erracorre, 2, 10);

                errlog.setStyleName("lblerrores");
                vlInv.addComponent(errlog, 5, 10);

                Label esp3 = new Label("");
                vlInv.setSpacing(true);
                Label cont = new Label("Contraseña:");

                Label vecont = new Label("Confirmar Contraseña:");

                vlInv.addComponent(esp3, 0, 11);
                vlInv.addComponent(cont, 0, 12);
                asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 1, 12);
                vlInv.addComponent(mclave, 2, 12);
                mclave.setEnabled(true);
                mclave.setMaxLength(20);
                bCambioClave=false;
                mclave.addTextChangeListener(new FieldEvents.TextChangeListener() {
                    @Override
                    public void textChange(FieldEvents.TextChangeEvent event) {
                        if (mverclave.getValue().length()==0 && event.getText().length()==0) {
                           bCambioClave = false;
                            mclave.setComponentError(null);
                            errcla.setValue("");
                            mverclave.setComponentError(null);
                            errvercla.setValue("");
                           
                        } else  {
                           bCambioClave = true; 
                        }   
                        ValidarError();
                    }               

 });
                

                mclave.addBlurListener(new FieldEvents.BlurListener() {

                    @Override
                    public void blur(FieldEvents.BlurEvent event) {
                        if (bCambioClave) {
                            if (mclave.getValue().equals("")) {
                                mclave.setComponentError(new UserError(""));
                                errcla.setValue("Este campo es requerido");
                            } else if (validaPassAnteriores(mclave.getValue())) {
                                if (validaLongitudContra(mclave.getValue())) {
                                  if(caracteresConsecutivos(mclave.getValue())){
                                    if (validarSecuen(mclave.getValue())) {
                                        if (validaunaMayus(mclave.getValue())) {
                                            if (validalfaNum(mclave.getValue())) {
                                                if (validaunCaracter(mclave.getValue())) {
                                                    if (validaunNumero(mclave.getValue())) {
                                                        //Diccionario de contraseñas
                                                        //Validar que la clave no contega palabras restringidas modificar                                            
                                                        Boolean palpermitida = facadediccionario.validaRestringidas(mclave.getValue());
                                                        if (palpermitida) {
                                                            mclave.setComponentError(new UserError(""));
                                                            errcla.setValue("La contraseña contiene una palabra no permitida");
                                                        } else {
                                                        mclave.setComponentError(null);
                                                        errcla.setValue(""); 
                                                        }                                                        
                                                    } else {
                                                        mclave.setComponentError(new UserError(""));
                                                        errcla.setValue("La contraseña debe tener al menos un número");
                                                    }
                                                } else {
                                                    mclave.setComponentError(new UserError(""));
                                                    errcla.setValue("La contraseña debe tener al menos un carácter especial");
                                                }

                                            } else {
                                                mclave.setComponentError(new UserError(""));
                                                errcla.setValue("La contraseña debe ser alfanumerica");
                                            }
                                        } else {
                                            mclave.setComponentError(new UserError(""));
                                            errcla.setValue("La contraseña debe tener al menos una mayúscula");
                                        }
                                    } else {
                                        mclave.setComponentError(new UserError(""));
                                        errcla.setValue("La contraseña no debe contener caracteres consecutivos ");
                                    }
                                   } else {
                                       mclave.setComponentError(new UserError(""));
                                       errcla.setValue("La contraseña no debe contener más de 3 caracteres idénticos consecutivos");
                                    }                                 
                                } else {
                                    mclave.setComponentError(new UserError(""));
                                    errcla.setValue("La contraseña debe contener mínimo 8 caracteres o máximo 15");
                                }
                            } else {
                                mclave.setComponentError(new UserError(""));
                                errcla.setValue("La contraseña coincide con las últimas tres contraseñas anteriores");
                            }
                            ValidarError();
                        }
                    }
                }
                );

                vlInv.addComponent(vecont, 3, 12);
                asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 4, 12);
                vlInv.addComponent(mverclave, 5, 12);
                mverclave.setEnabled(true);
                mverclave.setMaxLength(20);

                mverclave.addTextChangeListener(new FieldEvents.TextChangeListener() {
                    @Override
                    public void textChange(FieldEvents.TextChangeEvent event) {
                        if (event.getText().length()==0 && mclave.getValue().length()==0) {
                           bCambioClave = false;
                            mclave.setComponentError(null);
                            errcla.setValue("");
                            mverclave.setComponentError(null);
                            errvercla.setValue("");
                           
                        } else  {
                           bCambioClave = true; 
                        }   
                        ValidarError();
                    }               
      });

                
                mverclave.addBlurListener(new FieldEvents.BlurListener() {

                    @Override
                    public void blur(FieldEvents.BlurEvent event) {
                        if (bCambioClave) {
                            if (mverclave.getValue().equals("")) {
                                mverclave.setComponentError(new UserError(""));
                                errvercla.setValue("Este campo es requerido");
                            } else if (!mclave.getValue().equals(mverclave.getValue())) {
                                mverclave.setComponentError(new UserError(""));
                                errvercla.setValue("Las contraseñas ingresadas no coinciden");
                            } else {
                                mverclave.setComponentError(null);
                                errvercla.setValue("");
                            }
                            ValidarError();
                        }
                    }
                }
                );

                errcla.setStyleName("lblerrores");
                vlInv.addComponent(errcla, 2, 13);

                errvercla.setStyleName("lblerrores");
                vlInv.addComponent(errvercla, 5, 13);
                
                mperfiles = LlenarTipoPerfiles();

                if (per.equals("Administrador SCB")) {
                    mperfiles.select(1);
                } else if (per.equals("Administrador BVC")) {
                    mperfiles.select(2);
                } else if (per.equals("Riesgos")) {
                    mperfiles.select(3);
                } else if (per.equals("Operador SCB")) {
                    mperfiles.select(4);
                }

                mperfiles.setEnabled(false);

                mperfiles.addBlurListener(new FieldEvents.BlurListener() {
                    @Override
                    public void blur(FieldEvents.BlurEvent event) {
                        if (mperfiles.getValue() == null || mperfiles.getValue().equals("")) {
                            mperfiles.setComponentError(new UserError(""));
                            errper.setValue("Este campo es requerido");
                        } else {
                            mperfiles.setComponentError(null);
                            errper.setValue("");
                        }
                        ValidarError();
                    }
                });

                mestado.setTextInputAllowed(false);
                mestado.setNullSelectionAllowed(false);
                mestado.addItem("");
                mestado.setItemCaption("", "Seleccione");
                mestado.addItem(1);
                mestado.setItemCaption(1, "Activo");
                mestado.addItem(2);
                mestado.setItemCaption(2, "Inactivo");
                mestado.addItem(3);
                mestado.setItemCaption(3, "Bloqueado");

                if (est.equals("Activo")) {
                    mestado.select(1);
                } else if (est.equals("Inactivo")) {
                    mestado.select(2);
                } else if (est.equals("Bloqueado")) {
                    mestado.select(3);
                }

                mestado.setEnabled(true);

                mestado.addBlurListener(new FieldEvents.BlurListener() {
                    @Override
                    public void blur(FieldEvents.BlurEvent event) {
                        if (mestado.getValue() == null || mestado.getValue().equals("")) {
                            mestado.setComponentError(new UserError(""));
                            errest.setValue("Este campo es requerido");
                        } else {
                            mestado.setComponentError(null);
                            errest.setValue("");
                        }
                        ValidarError();
                    }
                });

                vlInv.setSpacing(true);
                Label esp4 = new Label("");
                Label per = new Label("Perfiles:");
                vlInv.addComponent(esp4, 0, 14);
                vlInv.addComponent(per, 0, 15);
                asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 1, 15);
                vlInv.addComponent(mperfiles, 2, 15);
                vlInv.setSpacing(true);
                Label est = new Label("Estado:");
                vlInv.addComponent(est, 3, 15);
                asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 4, 15);
                vlInv.addComponent(mestado, 5, 15);

                errper.setStyleName("lblerrores");
                vlInv.addComponent(errper, 2, 16);

                errest.setStyleName("lblerrores");
                vlInv.addComponent(errest, 5, 16);

        //Ip's
        Label ipLabel = new Label("Direcciones IP autorizadas:");        
        vlInv.addComponent(ipLabel,0,17);
        vlInv.addComponent(ip1,2,17);
        ip1.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                
                 if (ip1.getValue().equals("")) {
                        ip1.setComponentError(new UserError(""));
                        errIp1.setValue("Este campo es requerido");
                    } else {
                if (!ip1.getValue().equals("")) {
                    if (ip1.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip1.setComponentError(null);
                        errIp1.setValue("");
                    } else {
                        ip1.setComponentError(new UserError(""));
                        errIp1.setValue("Dirección Ip inválida");
                    }                                           
                } else {
                            ip1.setComponentError(null);
                            errIp1.setValue("");
                        }
               }
                ValidarError();
            }
        });
        errIp1.setStyleName("lblerrores");
        vlInv.addComponent(errIp1,2,18);
        
        
        
        vlInv.addComponent(ip2,3,17);
        ip2.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip2.getValue().equals("")) {
                    if (ip2.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip2.setComponentError(null);
                        errIp2.setValue("");
                    } else {
                        ip2.setComponentError(new UserError(""));
                        errIp2.setValue("Dirección Ip inválida");
                    }
                } else {
                            ip2.setComponentError(null);
                            errIp2.setValue("");
                        }
                ValidarError();
            }
        });
        errIp2.setStyleName("lblerrores");
        vlInv.addComponent(errIp2,3,18);

        vlInv.addComponent(ip3,5,17);
        ip3.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip3.getValue().equals("")) {
                    if (ip3.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip3.setComponentError(null);
                        errIp3.setValue("");
                    } else {
                        ip3.setComponentError(new UserError(""));
                        errIp3.setValue("Dirección Ip inválida");
                    }
                } else {
                            ip3.setComponentError(null);
                            errIp3.setValue("");
                        }
                ValidarError();
            }
        });
        errIp3.setStyleName("lblerrores");
        vlInv.addComponent(errIp3,5,18);

        vlInv.addComponent(ip4,2,19);
        ip4.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip4.getValue().equals("")) {
                    if (ip4.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip4.setComponentError(null);
                        errIp4.setValue("");
                    } else {
                        ip4.setComponentError(new UserError(""));
                        errIp4.setValue("Dirección Ip inválida");
                    }
                } else {
                            ip4.setComponentError(null);
                            errIp4.setValue("");
                        }
                ValidarError();
            }
        });
        errIp4.setStyleName("lblerrores");
        vlInv.addComponent(errIp4,2,20);

        vlInv.addComponent(ip5,3,19);
        ip5.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip5.getValue().equals("")) {
                    if (ip5.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip5.setComponentError(null);
                        errIp5.setValue("");
                    } else {
                        ip5.setComponentError(new UserError(""));
                        errIp5.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip5.setComponentError(null);
                            errIp5.setValue("");
                        }
                ValidarError();
            }
        });
        errIp5.setStyleName("lblerrores");
        vlInv.addComponent(errIp5,3,20);

        vlInv.addComponent(ip6,5,19);
        ip6.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip6.getValue().equals("")) {
                    if (ip6.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip6.setComponentError(null);
                        errIp6.setValue("");
                    } else {
                        ip6.setComponentError(new UserError(""));
                        errIp6.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip6.setComponentError(null);
                            errIp6.setValue("");
                        }
                ValidarError();
            }
        });
        errIp6.setStyleName("lblerrores");
        vlInv.addComponent(errIp6,5,20);

        vlInv.addComponent(ip7,2,21);
        ip7.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip7.getValue().equals("")) {
                    if (ip7.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip7.setComponentError(null);
                        errIp7.setValue("");
                    } else {
                        ip7.setComponentError(new UserError(""));
                        errIp7.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip7.setComponentError(null);
                            errIp7.setValue("");
                        }
                ValidarError();
            }
        });
        errIp7.setStyleName("lblerrores");
        vlInv.addComponent(errIp7,2,22);

        vlInv.addComponent(ip8,3,21);
        ip8.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip8.getValue().equals("")) {
                    if (ip8.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip8.setComponentError(null);
                        errIp8.setValue("");
                    } else {
                        ip8.setComponentError(new UserError(""));
                        errIp8.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip8.setComponentError(null);
                            errIp8.setValue("");
                        }
                ValidarError();
            }
        });
        errIp8.setStyleName("lblerrores");
        vlInv.addComponent(errIp8,3,22);

        vlInv.addComponent(ip9,5,21);
        ip9.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip9.getValue().equals("")) {
                    if (ip9.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip9.setComponentError(null);
                        errIp9.setValue("");
                    } else {
                        ip9.setComponentError(new UserError(""));
                        errIp9.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip9.setComponentError(null);
                            errIp9.setValue("");
                        }
                ValidarError();
            }
        });
        errIp9.setStyleName("lblerrores");
        vlInv.addComponent(errIp9,5,22);

        vlInv.addComponent(ip10,2,23);
        ip10.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip10.getValue().equals("")) {
                    if (ip10.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip10.setComponentError(null);
                        errIp10.setValue("");
                    } else {
                        ip10.setComponentError(new UserError(""));
                        errIp10.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip10.setComponentError(null);
                            errIp10.setValue("");
                        }
                ValidarError();
            }
        });
        errIp10.setStyleName("lblerrores");
        vlInv.addComponent(errIp10,2,24);

        vlInv.addComponent(ip11,3,23);
        ip11.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip11.getValue().equals("")) {
                    if (ip11.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip11.setComponentError(null);
                        errIp11.setValue("");
                    } else {
                        ip11.setComponentError(new UserError(""));
                        errIp11.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip11.setComponentError(null);
                            errIp11.setValue("");
                        }
                ValidarError();
            }
        });
        errIp11.setStyleName("lblerrores");
        vlInv.addComponent(errIp11,3,24);

        vlInv.addComponent(ip12,5,23);
        ip12.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip12.getValue().equals("")) {
                    if (ip12.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip12.setComponentError(null);
                        errIp12.setValue("");
                    } else {
                        ip12.setComponentError(new UserError(""));
                        errIp12.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip12.setComponentError(null);
                            errIp12.setValue("");
                        }
                ValidarError();
            }
        });
        errIp12.setStyleName("lblerrores");
        vlInv.addComponent(errIp12,5,24);

        vlInv.addComponent(ip13,2,25);
        ip13.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip13.getValue().equals("")) {
                    if (ip13.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip13.setComponentError(null);
                        errIp13.setValue("");
                    } else {
                        ip13.setComponentError(new UserError(""));
                        errIp13.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip13.setComponentError(null);
                            errIp13.setValue("");
                        }
                ValidarError();
            }
        });
        errIp13.setStyleName("lblerrores");
        vlInv.addComponent(errIp13,2,26);

        vlInv.addComponent(ip14,3,25);
        ip14.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip14.getValue().equals("")) {
                    if (ip14.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip14.setComponentError(null);
                        errIp14.setValue("");
                    } else {
                        ip14.setComponentError(new UserError(""));
                        errIp14.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip14.setComponentError(null);
                            errIp14.setValue("");
                        }
                ValidarError();
            }
        });
        errIp14.setStyleName("lblerrores");
        vlInv.addComponent(errIp14,3,26);

        vlInv.addComponent(ip15,5,25);
        ip15.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip15.getValue().equals("")) {
                    if (ip15.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip15.setComponentError(null);
                        errIp15.setValue("");
                    } else {
                        ip15.setComponentError(new UserError(""));
                        errIp15.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip15.setComponentError(null);
                            errIp15.setValue("");
                        }
                ValidarError();
            }
        });
        errIp15.setStyleName("lblerrores");
        vlInv.addComponent(errIp15,5,26);
        
        vlInv.addComponent(ip16,2,27);
        ip16.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip16.getValue().equals("")) {
                    if (ip16.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip16.setComponentError(null);
                        errIp16.setValue("");
                    } else {
                        ip16.setComponentError(new UserError(""));
                        errIp16.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip16.setComponentError(null);
                            errIp16.setValue("");
                        }
                ValidarError();
            }
        });
        errIp16.setStyleName("lblerrores");
        vlInv.addComponent(errIp16,2,28);
        
        vlInv.addComponent(ip17,3,27);
        ip17.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip17.getValue().equals("")) {
                    if (ip17.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip17.setComponentError(null);
                        errIp17.setValue("");
                    } else {
                        ip17.setComponentError(new UserError(""));
                        errIp17.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip17.setComponentError(null);
                            errIp17.setValue("");
                        }
                ValidarError();
            }
        });
        errIp17.setStyleName("lblerrores");
        vlInv.addComponent(errIp17,3,28);
        
        vlInv.addComponent(ip18,5,27);
        ip18.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip18.getValue().equals("")) {
                    if (ip18.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip18.setComponentError(null);
                        errIp18.setValue("");
                    } else {
                        ip18.setComponentError(new UserError(""));
                        errIp18.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip18.setComponentError(null);
                            errIp18.setValue("");
                        }
                ValidarError();
            }
        });
        errIp18.setStyleName("lblerrores");
        vlInv.addComponent(errIp18,5,28);
        
        vlInv.addComponent(ip19,2,29);
        ip19.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip19.getValue().equals("")) {
                    if (ip19.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip19.setComponentError(null);
                        errIp19.setValue("");
                    } else {
                        ip19.setComponentError(new UserError(""));
                        errIp19.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip19.setComponentError(null);
                            errIp19.setValue("");
                        }
                ValidarError();
            }
        });
        errIp19.setStyleName("lblerrores");
        vlInv.addComponent(errIp19,2,30);
        
        vlInv.addComponent(ip20,3,29);
        ip20.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip20.getValue().equals("")) {
                    if (ip20.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip20.setComponentError(null);
                        errIp20.setValue("");
                    } else {
                        ip20.setComponentError(new UserError(""));
                        errIp20.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip20.setComponentError(null);
                            errIp20.setValue("");
                        }
                ValidarError();
            }
        });
        errIp20.setStyleName("lblerrores");
        vlInv.addComponent(errIp20,3,30);
        
        vlInv.addComponent(ip21,5,29);
        ip21.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip21.getValue().equals("")) {
                    if (ip21.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip21.setComponentError(null);
                        errIp21.setValue("");
                    } else {
                        ip21.setComponentError(new UserError(""));
                        errIp21.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip21.setComponentError(null);
                            errIp21.setValue("");
                        }
                ValidarError();
            }
        });
        errIp21.setStyleName("lblerrores");
        vlInv.addComponent(errIp21,5,30);
        
        vlInv.addComponent(ip22,2,31);
        ip22.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip22.getValue().equals("")) {
                    if (ip22.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip22.setComponentError(null);
                        errIp22.setValue("");
                    } else {
                        ip22.setComponentError(new UserError(""));
                        errIp22.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip22.setComponentError(null);
                            errIp22.setValue("");
                        }
                ValidarError();
            }
        });
        errIp22.setStyleName("lblerrores");
        vlInv.addComponent(errIp22,2,32);
        
        vlInv.addComponent(ip23,3,31);
        ip23.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip23.getValue().equals("")) {
                    if (ip23.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip23.setComponentError(null);
                        errIp23.setValue("");
                    } else {
                        ip23.setComponentError(new UserError(""));
                        errIp23.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip23.setComponentError(null);
                            errIp23.setValue("");
                        }
                ValidarError();
            }
        });
        errIp23.setStyleName("lblerrores");
        vlInv.addComponent(errIp23,3,32);
        
        vlInv.addComponent(ip24,5,31);
        ip24.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip24.getValue().equals("")) {
                    if (ip24.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip24.setComponentError(null);
                        errIp24.setValue("");
                    } else {
                        ip24.setComponentError(new UserError(""));
                        errIp24.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip24.setComponentError(null);
                            errIp24.setValue("");
                        }
                ValidarError();
            }
        });
        errIp24.setStyleName("lblerrores");
        vlInv.addComponent(errIp24,5,32);
        
        vlInv.addComponent(ip25,2,33);
        ip25.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip25.getValue().equals("")) {
                    if (ip25.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip25.setComponentError(null);
                        errIp25.setValue("");
                    } else {
                        ip25.setComponentError(new UserError(""));
                        errIp25.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip25.setComponentError(null);
                            errIp25.setValue("");
                        }
                ValidarError();
            }
        });
        errIp25.setStyleName("lblerrores");
        vlInv.addComponent(errIp25,2,34);
        
        vlInv.addComponent(ip26,3,33);
        ip26.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip26.getValue().equals("")) {
                    if (ip26.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip26.setComponentError(null);
                        errIp26.setValue("");
                    } else {
                        ip26.setComponentError(new UserError(""));
                        errIp26.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip26.setComponentError(null);
                            errIp26.setValue("");
                        }
                ValidarError();
            }
        });
        errIp26.setStyleName("lblerrores");
        vlInv.addComponent(errIp26,3,34);
        
        vlInv.addComponent(ip27,5,33);
        ip27.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip27.getValue().equals("")) {
                    if (ip27.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip27.setComponentError(null);
                        errIp27.setValue("");
                    } else {
                        ip27.setComponentError(new UserError(""));
                        errIp27.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip27.setComponentError(null);
                            errIp27.setValue("");
                        }
                ValidarError();
            }
        });
        errIp27.setStyleName("lblerrores");
        vlInv.addComponent(errIp27,5,34);
        
        vlInv.addComponent(ip28,2,35);
        ip28.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip28.getValue().equals("")) {
                    if (ip28.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip28.setComponentError(null);
                        errIp28.setValue("");
                    } else {
                        ip28.setComponentError(new UserError(""));
                        errIp28.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip28.setComponentError(null);
                            errIp28.setValue("");
                        }
                ValidarError();
            }
        });
        errIp28.setStyleName("lblerrores");
        vlInv.addComponent(errIp28,2,36);
        
        vlInv.addComponent(ip29,3,35);
        ip29.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip29.getValue().equals("")) {
                    if (ip29.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip29.setComponentError(null);
                        errIp29.setValue("");
                    } else {
                        ip29.setComponentError(new UserError(""));
                        errIp29.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip29.setComponentError(null);
                            errIp29.setValue("");
                        }
                ValidarError();
            }
        });
        errIp29.setStyleName("lblerrores");
        vlInv.addComponent(errIp29,3,36);
        
        vlInv.addComponent(ip30,5,35);
        ip30.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip30.getValue().equals("")) {
                    if (ip30.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip30.setComponentError(null);
                        errIp30.setValue("");
                    } else {
                        ip30.setComponentError(new UserError(""));
                        errIp30.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip30.setComponentError(null);
                            errIp30.setValue("");
                        }
                ValidarError();
            }
        });
        errIp30.setStyleName("lblerrores");
        vlInv.addComponent(errIp30,5,36);
        
        vlInv.addComponent(ip31,2,37);
        ip31.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip31.getValue().equals("")) {
                    if (ip31.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip31.setComponentError(null);
                        errIp31.setValue("");
                    } else {
                        ip31.setComponentError(new UserError(""));
                        errIp31.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip31.setComponentError(null);
                            errIp31.setValue("");
                        }
                ValidarError();
            }
        });
        errIp31.setStyleName("lblerrores");
        vlInv.addComponent(errIp31,2,38);
        
        vlInv.addComponent(ip32,3,37);
        ip32.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip32.getValue().equals("")) {
                    if (ip32.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip32.setComponentError(null);
                        errIp32.setValue("");
                    } else {
                        ip32.setComponentError(new UserError(""));
                        errIp32.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip32.setComponentError(null);
                            errIp32.setValue("");
                        }
                ValidarError();
            }
        });
        errIp32.setStyleName("lblerrores");
        vlInv.addComponent(errIp32,3,38);
        
        vlInv.addComponent(ip33,5,37);
        ip33.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip33.getValue().equals("")) {
                    if (ip33.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip33.setComponentError(null);
                        errIp33.setValue("");
                    } else {
                        ip33.setComponentError(new UserError(""));
                        errIp33.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip33.setComponentError(null);
                            errIp33.setValue("");
                        }
                ValidarError();
            }
        });
        errIp33.setStyleName("lblerrores");
        vlInv.addComponent(errIp33,5,38);
        
        vlInv.addComponent(ip34,2,40);
        ip34.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip34.getValue().equals("")) {
                    if (ip34.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip34.setComponentError(null);
                        errIp34.setValue("");
                    } else {
                        ip34.setComponentError(new UserError(""));
                        errIp34.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip34.setComponentError(null);
                            errIp34.setValue("");
                        }
                ValidarError();
            }
        });
        errIp34.setStyleName("lblerrores");
        vlInv.addComponent(errIp34,2,41);
        
        vlInv.addComponent(ip35,3,40);
        ip35.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip35.getValue().equals("")) {
                    if (ip35.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip35.setComponentError(null);
                        errIp35.setValue("");
                    } else {
                        ip35.setComponentError(new UserError(""));
                        errIp35.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip35.setComponentError(null);
                            errIp35.setValue("");
                        }
                ValidarError();
            }
        });
        errIp35.setStyleName("lblerrores");
        vlInv.addComponent(errIp35,3,41);
        
        vlInv.addComponent(ip36,5,40);
        ip36.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip36.getValue().equals("")) {
                    if (ip36.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip36.setComponentError(null);
                        errIp36.setValue("");
                    } else {
                        ip36.setComponentError(new UserError(""));
                        errIp36.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip36.setComponentError(null);
                            errIp36.setValue("");
                        }
                ValidarError();
            }
        });
        errIp36.setStyleName("lblerrores");
        vlInv.addComponent(errIp36,5,41);
        
        vlInv.addComponent(ip37,2,42);
        ip37.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip37.getValue().equals("")) {
                    if (ip37.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip37.setComponentError(null);
                        errIp17.setValue("");
                    } else {
                        ip37.setComponentError(new UserError(""));
                        errIp37.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip37.setComponentError(null);
                            errIp37.setValue("");
                        }
                ValidarError();
            }
        });
        errIp37.setStyleName("lblerrores");
        vlInv.addComponent(errIp37,2,43);
        
        vlInv.addComponent(ip38,3,42);
        ip38.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip38.getValue().equals("")) {
                    if (ip38.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip38.setComponentError(null);
                        errIp38.setValue("");
                    } else {
                        ip38.setComponentError(new UserError(""));
                        errIp38.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip38.setComponentError(null);
                            errIp38.setValue("");
                        }
                ValidarError();
            }
        });
        errIp38.setStyleName("lblerrores");
        vlInv.addComponent(errIp38,3,43);
        
        vlInv.addComponent(ip39,5,42);
        ip39.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip39.getValue().equals("")) {
                    if (ip39.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip39.setComponentError(null);
                        errIp39.setValue("");
                    } else {
                        ip39.setComponentError(new UserError(""));
                        errIp39.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip39.setComponentError(null);
                            errIp39.setValue("");
                        }
                ValidarError();
            }
        });
        errIp39.setStyleName("lblerrores");
        vlInv.addComponent(errIp39,5,43);
        
        vlInv.addComponent(ip40,2,44);
        ip40.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip40.getValue().equals("")) {
                    if (ip40.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip40.setComponentError(null);
                        errIp40.setValue("");
                    } else {
                        ip40.setComponentError(new UserError(""));
                        errIp40.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip40.setComponentError(null);
                            errIp40.setValue("");
                        }
                ValidarError();
            }
        });
        errIp40.setStyleName("lblerrores");
        vlInv.addComponent(errIp40,2,45);


                final Button modificar = new Button("Modificar");
                final Button cancelar = new Button("Cancelar");

                cancelar.addClickListener(new Button.ClickListener() {
                    private static final long serialVersionUID = 1L;

                    public void buttonClick(ClickEvent event) {

                        modUsuarios.close();
                        grid.select(null);
                        Limpiar();
                        select = 0;
                        controladorEve1 = 0;
                        error.setValue("");
                    }
                });

                modUsuarios.addCloseListener(new Window.CloseListener() {

                    @Override
                    public void windowClose(Window.CloseEvent e) {

                        grid.select(null);
                        Limpiar();
                        select = 0;
                        controladorEve1 = 0;
                        error.setValue("");
                    }
                });

                vlInv.addComponent(modificar, 0, 45);

                vlInv.addComponent(cancelar, 1, 45);

                HorizontalLayout h = new HorizontalLayout();
               h.addComponents(modificar, cancelar);
            error.setStyleName("lblErrorVer");
            h.addComponent(error);
            cancelar.addStyleName("ButtCancelar");
            vl.addComponents(vlInv, h);
            vlInv.addStyleName("StylegridLa");
            h.addStyleName("horizontal1");
                vl.setComponentAlignment(h, Alignment.MIDDLE_CENTER);

                modificar.addClickListener(new Button.ClickListener() {

                    @Override
                    public void buttonClick(Button.ClickEvent event) {

                        try {
                            combo = (Integer) mcmb.getValue();
                        } catch (NullPointerException e) {
                            combo = 0;
                        } catch (ClassCastException ex) {
                            combo = 0;
                        }

                        try {
                            comboPer = (Integer) mperfiles.getValue();
                        } catch (NullPointerException e) {
                            comboPer = 0;
                        } catch (ClassCastException ex) {
                            comboPer = 0;
                        }

                        try {
                            comboEst = (Integer) mestado.getValue();
                        } catch (NullPointerException e) {
                            comboEst = 0;
                        } catch (ClassCastException ex) {
                            comboEst = 0;
                        }

                        if (combo == 0) {
                            mcmb.setComponentError(new UserError(""));
                            errIdcmb.setValue("Este campo es requerido");
                        }
                        if (mnumDoc.getValue().equals("")) {
                            mnumDoc.setComponentError(new UserError(""));
                            errnumDoc.setValue("Este campo es requerido");
                        }
                        if (mnombres.getValue().equals("")) {
                            mnombres.setComponentError(new UserError(""));
                            errnombre.setValue("Este campo es requerido");
                        }
                        if (mapellidos.getValue().equals("")) {
                            mapellidos.setComponentError(new UserError(""));
                            errape.setValue("Este campo es requerido");
                        }
                        if (mcorreo.getValue().equals("")) {
                            mcorreo.setComponentError(new UserError(""));
                            erracorre.setValue("Este campo es requerido");
                        }
                        if (mlogin.getValue().equals("")) {
                            mlogin.setComponentError(new UserError(""));
                            errlog.setValue("Este campo es requerido");
                        }
                        if (mclave.getValue().equals("")) {
                            if (bCambioClave) {
                            mclave.setComponentError(new UserError(""));
                            errcla.setValue("Este campo es requerido");
                            }
                        }
                        if (mverclave.getValue().equals("")) {
                            if (bCambioClave) {
                            mverclave.setComponentError(new UserError(""));
                            errvercla.setValue("Este campo es requerido");
                            }
                        }
                        if (comboPer == 0) {
                            mperfiles.setComponentError(new UserError(""));
                            errper.setValue("Este campo es requerido");
                        }
                        if (comboEst == 0) {
                            mestado.setComponentError(new UserError(""));
                            errest.setValue("Este campo es requerido");
                        }
                        if (ip1.getValue().equals("")) {
                            ip1.setComponentError(new UserError(""));
                            errIp1.setValue("Este campo es requerido");
                        }
                        ValidarError();
                        if (!ValidaComponentError()) {
                            Usuario usu = new Usuario();
                            String est = "";

                            usu.setId(Integer.parseInt(idUsu));
                            usu.setNombres(mnombres.getValue());
                            usu.setApellidos(mapellidos.getValue());

                            String tipD = "";
                            if (mcmb.getValue().toString().equals("1")) {
                                tipD = "CC";
                            } else if (mcmb.getValue().toString().equals("2")) {
                                tipD = "CE";
                            } else if (mcmb.getValue().toString().equals("3")) {
                                tipD = "PAS";
                            }

                            usu.setTipoIdentificacion(tipD);
                            usu.setIdentificacion(mnumDoc.getValue());
                            usu.setEmail(mcorreo.getValue());
                            usu.setUsername(mlogin.getValue());
                            usu.setPassword(mclave.getValue());

                            if (PerfilActual.equals("Riesgos")) { ///////////////////////////////////////////////////////////cuando guardaaaaaaaaaaaa
                                usu.setSbolsa(Integer.parseInt(scb.getValue().toString()));
                            } else {
                                usu.setSbolsa(Integer.parseInt(IdsocBol));
                            }

                            if (mestado.getValue().toString().equals("1")) {
                                est = "A";
                            } else if (mestado.getValue().toString().equals("2")) {
                                est = "I";
                            } else if (mestado.getValue().toString().equals("3")) {
                                est = "B";
                            }
                            
                            String nomUsuario = userDetailsService.getUsuarioAutenticado().getUsername();
                            usu.setUsuariosistemaultimamod(nomUsuario);
                            
                            String tipomodificacion = "Modificación Usuario - Modificación";
                            usu.setTipomodificacion(tipomodificacion);

                            usu.setEstado(est);

                            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                            HttpServletRequest req = attr.getRequest();
                            Auditoria au = new Auditoria();
                            // AJUSTE IP REGISTRADA
                            //au.setIp(req.getRemoteAddr());
                            String remoteAddr = req.getHeader("X-Forwarded-For");
                            if (remoteAddr == null || "".equals(remoteAddr)) {
                                au.setIp(req.getRemoteAddr());
                            } else {
                                String ips[] = remoteAddr.split(",");
                                remoteAddr = ips[0];
                                au.setIp(remoteAddr);
                            }
                            //au.setIp(req.getHeader("X-Forwarded-For"));

                            logger.debug("OPA - REMOTEADDR_" + req.getRemoteAddr() + "x-forwarded-For_" + req.getHeader("X-Forwarded-For") + "IP:" + remoteAddr);

                                //
                            au.setId_user(userDetailsService.getUsuarioAutenticado().getId());
//Crea la lista de Ips
                            ArrayList<IpAutorizada> ipsAutorizadas = new ArrayList<IpAutorizada>();
                            IpAutorizada a = null;
                            if (!ip1.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip1.getValue(), userDetailsService.getUsuarioAutenticado().getUsername(), "Ingreso IP - Modificación");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip2.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip2.getValue(), userDetailsService.getUsuarioAutenticado().getUsername(), "Ingreso IP - Modificación");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip3.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip3.getValue(), userDetailsService.getUsuarioAutenticado().getUsername(), "Ingreso IP - Modificación");
                                ipsAutorizadas.add(a);
                            }
                            
                            if (!ip4.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip4.getValue(), userDetailsService.getUsuarioAutenticado().getUsername(), "Ingreso IP - Modificación");
                                ipsAutorizadas.add(a);
                            }
                             if (!ip5.getValue().equals("")) {
                                 a = new IpAutorizada(new Integer(0), ip5.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                             }
                            if (!ip6.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip6.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                             if (!ip7.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip7.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip8.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip8.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip9.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip9.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip10.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip10.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip11.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip11.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip12.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip12.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip13.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip13.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip14.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip14.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip15.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip15.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                                if (!ip16.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip16.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip17.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip17.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip18.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip18.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip19.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip19.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip20.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip20.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip21.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip21.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip22.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip22.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip23.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip23.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip24.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip24.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip25.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip25.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip26.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip26.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip27.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip27.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip28.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip28.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip29.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip29.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip30.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip30.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip31.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip31.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip32.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip32.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip33.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip33.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip34.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip34.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip35.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip35.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip36.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip36.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip37.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip37.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip38.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip38.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip39.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip39.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip40.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip40.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
              
                        usu = userDetailsService.saveUsuario(usu, au, mperfiles.getValue().toString(),ipsAutorizadas);
                            
                            
                            if (usu != null) {
                                Notification notif = new Notification(
                                        "Confirmación",
                                        "Usuario modificado satisfactoriamente",
                                        Notification.Type.HUMANIZED_MESSAGE);

  
                        notif.setDelayMsec(40000);
                                notif.show(Page.getCurrent());
                                modUsuarios.close();
                                grid.getSelectedRows().clear();
                                grid.getContainerDataSource().removeAllItems();
                                List<List<String>> listUsuarios = facade.Retornarusuarios();
                                
                                String estado ="";
                                for (int i = 0; i < listUsuarios.get(0).size(); i++) {

                                    if (listUsuarios.get(11).get(i).equals("A")) {
                                        estado = "Activo";
                                    } else if (listUsuarios.get(11).get(i).equals("I")) {
                                        estado = "Inactivo";
                                    } else if (listUsuarios.get(11).get(i).equals("B")) {
                                        estado = "Bloqueado";
                                    }

                                    String idScb = userDetailsService.getUsuarioAutenticado().getSbolsa().toString();

                                    if (PerfilActual.equals("Administrador SCB")) {
                                        listUsuarios = facade.RetornarusuariosSCB(idScb);
                                    } else {

                                        listUsuarios = facade.Retornarusuarios();

                                    }
                                    
                                    //Lsierra 2016-04-08 Mantis 2515
                                    /*String scb = listUsuarios.get(18).get(i);
                                    String[] list = scb.split("-");
                                    String codigosc = list[0];*/

                                    grid.addRow(listUsuarios.get(0).get(i), listUsuarios.get(6).get(i), listUsuarios.get(7).get(i), listUsuarios.get(3).get(i), listUsuarios.get(4).get(i), listUsuarios.get(18).get(i), listUsuarios.get(1).get(i), listUsuarios.get(17).get(i), estado, listUsuarios.get(5).get(i));
                                    //grid.addRow(listUsuarios.get(0).get(i), listUsuarios.get(6).get(i), listUsuarios.get(7).get(i), listUsuarios.get(3).get(i), listUsuarios.get(4).get(i), listUsuarios.get(16).get(i), listUsuarios.get(1).get(i), listUsuarios.get(17).get(i), listUsuarios.get(11).get(i), listUsuarios.get(5).get(i));
                                }
                            } else {
                                Notification.show("Hubo un error en la modificación del usuario", Notification.Type.ERROR_MESSAGE);
                            }
                        }
                        controladorEve1 = 0;
                    }

                });

            } //////////////////////////////////////////////////////////////////////ADMINISTRADOR GENERAL/////////////////////////////////////////////////////////////////////////
            else if (PerfilActual.equals("Administrador General")) {

                final GridLayout vlInv = new GridLayout(6, 46);
                vlInv.setMargin(true);
                vlInv.setStyleName("StylegridLa");
                Label esp = new Label("");
                Label tpID = new Label("Tipo Documento:");
                mcmb = LlenarTipoDocumentos();
                if (tipoD.equals("CC")) {
                    mcmb.select(1);
                } else if (tipoD.equals("CE")) {
                    mcmb.select(2);
                } else if (tipoD.equals("PAS")) {
                    mcmb.select(3);
                }

                mcmb.setEnabled(true);

                mcmb.addBlurListener(new FieldEvents.BlurListener() {
                    @Override
                    public void blur(FieldEvents.BlurEvent event) {
                        
                        try {
                            valorCombo = (Integer) mcmb.getValue();
                        } catch (NullPointerException ex) {
                            valorCombo = 0;
                        } catch (ClassCastException e) {
                            valorCombo = 0;
                        }
                        
                        numDoc.setComponentError(null);
                        errnumDoc.setValue("");
                        
                        
                        if (mcmb.getValue() == null || mcmb.getValue().equals("")) {
                            mcmb.setComponentError(new UserError(""));
                            errIdcmb.setValue("Este campo es requerido");
                        } else {
                            mcmb.setComponentError(null);
                            errIdcmb.setValue("");
                        }
                        
                        if (valorCombo == 2 || valorCombo == 3) {
                            if (!mnumDoc.getValue().matches(regexAlpha)) {
                                mnumDoc.setComponentError(new UserError(""));
                                errnumDoc.setValue("Este campo contiene caracteres no válidos");
                            }else{
                                mnumDoc.setComponentError(null);
                                errnumDoc.setValue("");
                            }
                        } else {
                            if (!mnumDoc.getValue().matches(regexNumeric)) {
                                mnumDoc.setComponentError(new UserError(""));
                                errnumDoc.setValue("Este campo contiene caracteres no válidos");
                            }else{
                                mnumDoc.setComponentError(null);
                                errnumDoc.setValue("");
                            }
                        }
                        
                        ValidarError();
                    }
                });

                vlInv.setSpacing(true);
                vlInv.addComponent(tpID, 0, 1);
                Label asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 1, 1);
                vlInv.addComponent(mcmb, 2, 1);
                vlInv.setSpacing(true);
                Label ID = new Label("Número Documento:");
                vlInv.addComponent(ID, 3, 1);
                asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 4, 1);

                mnumDoc.setValue(numD);
                mnumDoc.setEnabled(true);
                vlInv.addComponent(mnumDoc, 5, 1);

                mnumDoc.setMaxLength(15);

                mnumDoc.addBlurListener(new FieldEvents.BlurListener() {

                    @Override
                    public void blur(FieldEvents.BlurEvent event) {

                        try {
                            valorCombo = (Integer) mcmb.getValue();
                        } catch (NullPointerException ex) {
                            valorCombo = 0;
                        } catch (ClassCastException e) {
                            valorCombo = 0;
                        }
                        mnumDoc.setComponentError(null);
                        errnumDoc.setValue("");
                        if (mnumDoc.getValue().equals("")) {
                            mnumDoc.setComponentError(new UserError(""));
                            errnumDoc.setValue("Este campo es requerido");
                        }
                        if (valorCombo == 2 || valorCombo == 3) {
                            if (!mnumDoc.getValue().matches(regexAlpha)) {
                                mnumDoc.setComponentError(new UserError(""));
                                errnumDoc.setValue("Este campo contiene caracteres no válidos");
                            }else{
                                mnumDoc.setComponentError(null);
                                errnumDoc.setValue("");
                            }
                        } else {
                            if (!mnumDoc.getValue().matches(regexNumeric)) {
                                mnumDoc.setComponentError(new UserError(""));
                                errnumDoc.setValue("Este campo contiene caracteres no válidos");
                            }else{
                                mnumDoc.setComponentError(null);
                                errnumDoc.setValue("");
                            }
                        }

                        ValidarError();

                    }
                });

                errIdcmb.setStyleName("lblerrores");
                vlInv.addComponent(errIdcmb, 2, 2);

                errnumDoc.setStyleName("lblerrores");
                vlInv.addComponent(errnumDoc, 5, 2);

                Label nom = new Label("Nombres:");

                vlInv.setSpacing(true);
                vlInv.addComponent(esp, 0, 3);
                vlInv.addComponent(nom, 0, 4);
                asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 1, 4);

                mnombres.setValue(nomb);
                mnombres.setEnabled(true);
                vlInv.addComponent(mnombres, 2, 4);
                vlInv.setSpacing(true);
                Label ape = new Label("Apellidos:");

                vlInv.addComponent(ape, 3, 4);
                asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 4, 4);

                mapellidos.setValue(apell);
                mapellidos.setEnabled(true);
                vlInv.addComponent(mapellidos, 5, 4);

                mnombres.setMaxLength(50);

                mnombres.addBlurListener(new FieldEvents.BlurListener() {

                    @Override
                    public void blur(FieldEvents.BlurEvent event) {

                        if (!mnombres.getValue().equals("")) {
                            if (mnombres.getValue().matches(regexLetras)) {
                                mnombres.setComponentError(null);
                                errnombre.setValue("");
                            } else {
                                mnombres.setComponentError(new UserError(""));
                                errnombre.setValue("Este campo contiene caracteres no válidos");
                            }
                        } else {
                            mnombres.setComponentError(null);
                            errnombre.setValue("");
                        }
                        ValidarError();
                    }
                });

                mapellidos.setMaxLength(50);

                mapellidos.addBlurListener(new FieldEvents.BlurListener() {

                    @Override
                    public void blur(FieldEvents.BlurEvent event) {

                        if (!mapellidos.getValue().equals("")) {
                            if (mapellidos.getValue().matches(regexLetras)) {
                                mapellidos.setComponentError(null);
                                errape.setValue("");
                            } else {
                                mapellidos.setComponentError(new UserError(""));
                                errape.setValue("Este campo contiene caracteres no válidos");
                            }
                        } else {
                            mapellidos.setComponentError(null);
                            errape.setValue("");
                        }
                        ValidarError();
                    }
                });

                errnombre.setStyleName("lblerrores");
                vlInv.addComponent(errnombre, 2, 5);

                errape.setStyleName("lblerrores");
                vlInv.addComponent(errape, 5, 5);

                Label scbEnti = new Label("SCB/Entidad");
                Label corr = new Label("Correo Electrónico:");

                Label esp1 = new Label("");

                vlInv.setSpacing(true);
                vlInv.addComponent(esp1, 0, 6);

                scb = LlenarSCB();
                scb.setEnabled(false);
                scb.setWidth("140px");
                vlInv.addComponent(scbEnti, 0, 7);
                asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 1, 7);
                vlInv.addComponent(scb, 2, 7);

                scb.select(Integer.parseInt(socSCB));
                scb.addBlurListener(new FieldEvents.BlurListener() {
                    @Override
                    public void blur(FieldEvents.BlurEvent event) {
                        if (scb.getValue() == null || scb.getValue().equals("")) {
                            scb.setComponentError(new UserError(""));
                            errscb.setValue("Este campo es requerido");
                        } else {
                            scb.setComponentError(null);
                            errscb.setValue("");
                        }
                        ValidarError();
                    }
                });

                errscb.setStyleName("lblerrores");
                vlInv.addComponent(errscb, 2, 8);
                
                vlInv.setSpacing(true);

                Label logi = new Label("Login:");

                vlInv.setSpacing(true);
                Label esp2 = new Label("");
                vlInv.addComponent(esp2, 0, 9);
                vlInv.addComponent(corr, 0, 10);
                asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 1, 10);

                mcorreo.setValue(cor);
                mcorreo.setEnabled(true);
                vlInv.addComponent(mcorreo, 2, 10);
                vlInv.addComponent(logi, 3, 10);
                asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 4, 10);

                mlogin.setValue(log);
                mlogin.setEnabled(false);
                mlogin.setMaxLength(20);
                vlInv.addComponent(mlogin, 5, 10);

                mcorreo.setMaxLength(100);

                mcorreo.addBlurListener(new FieldEvents.BlurListener() {

                    @Override
                    public void blur(FieldEvents.BlurEvent event) {
                        if (mcorreo.getValue().equals("")) {
                            mcorreo.setComponentError(new UserError(""));
                            erracorre.setValue("Este campo es requerido");
                        } else {
                            if (mcorreo.getValue().matches(regexEmail)) {
                                if (mcorreo.getValue().matches(regexEmailEstruct)) {
                                    mcorreo.setComponentError(null);
                                    erracorre.setValue("");
                                } else {
                                    mcorreo.setComponentError(new UserError(""));
                                    erracorre.setValue("La estructura del Correo Electrónico no es válida");
                                }
                            } else {
                                mcorreo.setComponentError(new UserError(""));
                                erracorre.setValue("Este campo contiene caracteres no válidos");
                            }
                        }
                        ValidarError();
                    }
                });

                mlogin.addBlurListener(new FieldEvents.BlurListener() {

                    @Override
                    public void blur(FieldEvents.BlurEvent event) {

                        if (!mlogin.getValue().equals("")) {
                            if (mlogin.getValue().matches(regexAlpha)) {
                                mlogin.setComponentError(null);
                                errlog.setValue("");
                            } else {
                                mlogin.setComponentError(new UserError(""));
                                errlog.setValue("Este campo contiene caracteres no válidos");
                            }
                        } else {
                            mlogin.setComponentError(null);
                            errlog.setValue("");
                        }
                        ValidarError();
                    }
                });

                erracorre.setStyleName("lblerrores");
                vlInv.addComponent(erracorre, 2, 11);

                errlog.setStyleName("lblerrores");
                vlInv.addComponent(errlog, 5, 11);

                Label esp3 = new Label("");
                vlInv.setSpacing(true);
                Label cont = new Label("Contraseña:");

                Label vecont = new Label("Confirmar Contraseña:");

                vlInv.addComponent(esp3, 0, 12);
                vlInv.addComponent(cont, 0, 13);
                asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 1, 13);
                vlInv.addComponent(mclave, 2, 13);
                mclave.setEnabled(true);
                mclave.setMaxLength(20);
                bCambioClave=false;

                mclave.addTextChangeListener(new FieldEvents.TextChangeListener() {
                    @Override
                    public void textChange(FieldEvents.TextChangeEvent event) {
                        if (mverclave.getValue().length()==0 && event.getText().length()==0) {
                            bCambioClave = false;
                            mclave.setComponentError(null);
                            errcla.setValue("");
                            mverclave.setComponentError(null);
                            errvercla.setValue("");
                          
                        } else  {
                           bCambioClave = true; 
                        }   
                        ValidarError();
                    }

                });                
                mclave.addBlurListener(new FieldEvents.BlurListener() {

                    @Override
                    public void blur(FieldEvents.BlurEvent event) {
                        if (bCambioClave) {
                            if (mclave.getValue().equals("")) {
                                mclave.setComponentError(new UserError(""));
                                errcla.setValue("Este campo es requerido");
                            } else if (validaPassAnteriores(mclave.getValue())) {
                                if (validaLongitudContra(mclave.getValue())) {
                                  if(caracteresConsecutivos(mclave.getValue())){
                                    if (validarSecuen(mclave.getValue())) {
                                        if (validaunaMayus(mclave.getValue())) {
                                            if (validalfaNum(mclave.getValue())) {
                                                if (validaunCaracter(mclave.getValue())) {
                                                    if (validaunNumero(mclave.getValue())) {
                                                        //Diccionario de contraseñas
                                                        //Validar que la clave no contega palabras restringidas  adm general                                           
                                                        Boolean palpermitida = facadediccionario.validaRestringidas(mclave.getValue());
                                                        if (palpermitida) {
                                                            mclave.setComponentError(new UserError(""));
                                                            errcla.setValue("La contraseña contiene una palabra no permitida");
                                                        } else {
                                                        mclave.setComponentError(null);
                                                        errcla.setValue("");
                                                        }                                                        
                                                    } else {
                                                        mclave.setComponentError(new UserError(""));
                                                        errcla.setValue("La contraseña debe tener al menos un número");
                                                    }
                                                } else {
                                                    mclave.setComponentError(new UserError(""));
                                                    errcla.setValue("La contraseña debe tener al menos un carácter especial");
                                                }

                                            } else {
                                                mclave.setComponentError(new UserError(""));
                                                errcla.setValue("La contraseña debe ser alfanumerica");
                                            }
                                        } else {
                                            mclave.setComponentError(new UserError(""));
                                            errcla.setValue("La contraseña debe tener al menos una mayúscula");
                                        }
                                    } else {
                                        mclave.setComponentError(new UserError(""));
                                        errcla.setValue("La contraseña no debe contener caracteres consecutivos ");
                                    }
                                   } else {
                                     mclave.setComponentError(new UserError(""));
                                     errcla.setValue("La contraseña no debe contener más de 3 caracteres idénticos consecutivos");
                                   } 
                                } else {
                                    mclave.setComponentError(new UserError(""));
                                    errcla.setValue("La contraseña debe contener mínimo 8 caracteres o máximo 15");
                                }
                            } else {
                                mclave.setComponentError(new UserError(""));
                                errcla.setValue("La contraseña coincide con las últimas tres contraseñas anteriores");
                            }
                           
                            ValidarError();
                        }
                    }

                });

                vlInv.addComponent(vecont, 3, 13);
                asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 4, 13);
                vlInv.addComponent(mverclave, 5, 13);
                mverclave.setEnabled(true);
                mverclave.setMaxLength(20);
                
                mverclave.addTextChangeListener(new FieldEvents.TextChangeListener() {
                    @Override
                    public void textChange(FieldEvents.TextChangeEvent event) {
                        if (event.getText().length()==0 && mclave.getValue().length()==0) {
                           bCambioClave = false;
                            mclave.setComponentError(null);
                            errcla.setValue("");
                            mverclave.setComponentError(null);
                            errvercla.setValue("");
                           
                        } else  {
                           bCambioClave = true; 
                        } 
                        ValidarError();
                    }

                });                
                
                mverclave.addBlurListener(new FieldEvents.BlurListener() {

                    @Override
                    public void blur(FieldEvents.BlurEvent event) {
                        if (bCambioClave) {
                            if (mverclave.getValue().equals("")) {
                                mverclave.setComponentError(new UserError(""));
                                errvercla.setValue("Este campo es requerido");
                            } else if (!mclave.getValue().equals(mverclave.getValue())) {
                                mverclave.setComponentError(new UserError(""));
                                errvercla.setValue("Las contraseñas ingresadas no coinciden");
                            } else {
                                mverclave.setComponentError(null);
                                errvercla.setValue("");
                            }
                            ValidarError();
                        }
                    }
                });

                errcla.setStyleName("lblerrores");
                vlInv.addComponent(errcla, 2, 14);

                errvercla.setStyleName("lblerrores");
                vlInv.addComponent(errvercla, 5, 14);

                mperfiles = LlenarTipoPerfiles();

                if (per.equals("Administrador SCB")) {
                    mperfiles.select(1);
                } else if (per.equals("Administrador BVC")) {
                    mperfiles.select(2);
                } else if (per.equals("Riesgos")) {
                    mperfiles.select(3);
                } else if (per.equals("Operador SCB")) {
                    mperfiles.select(4);
                }
            mperfiles.setEnabled(false);                
                
                mperfiles.removeItem(5);

                //mperfiles.setEnabled(true);

                mperfiles.addBlurListener(new FieldEvents.BlurListener() {
                    @Override
                    public void blur(FieldEvents.BlurEvent event) {
                        if (mperfiles.getValue() == null || mperfiles.getValue().equals("")) {
                            mperfiles.setComponentError(new UserError(""));
                            errper.setValue("Este campo es requerido");
                        } else {
                            mperfiles.setComponentError(null);
                            errper.setValue("");
                        }
                        ValidarError();
                    }
                });

                mestado.setTextInputAllowed(false);
                mestado.setNullSelectionAllowed(false);
                mestado.addItem("");
                mestado.setItemCaption("", "Seleccione");
                mestado.addItem(1);
                mestado.setItemCaption(1, "Activo");
                mestado.addItem(2);
                mestado.setItemCaption(2, "Inactivo");
                mestado.addItem(3);
                mestado.setItemCaption(3, "Bloqueado");

                if (est.equals("Activo")) {
                    mestado.select(1);
                } else if (est.equals("Inactivo")) {
                    mestado.select(2);
                } else if (est.equals("Bloqueado")) {
                    mestado.select(3);
                }

                mestado.setEnabled(true);

                mestado.addBlurListener(new FieldEvents.BlurListener() {
                    @Override
                    public void blur(FieldEvents.BlurEvent event) {
                        if (mestado.getValue() == null || mestado.getValue().equals("")) {
                            mestado.setComponentError(new UserError(""));
                            errest.setValue("Este campo es requerido");
                        } else {
                            mestado.setComponentError(null);
                            errest.setValue("");
                        }
                        ValidarError();
                    }
                });

                vlInv.setSpacing(true);
                Label esp4 = new Label("");
                Label per = new Label("Perfiles:");
                vlInv.addComponent(esp4, 0, 15);
                vlInv.addComponent(per, 0, 16);
                asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 1, 16);
                vlInv.addComponent(mperfiles, 2, 16);
                vlInv.setSpacing(true);
                Label est = new Label("Estado:");
                vlInv.addComponent(est, 3, 16);
                asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 4, 16);
                vlInv.addComponent(mestado, 5, 16);

                errper.setStyleName("lblerrores");
                vlInv.addComponent(errper, 2, 17);

                errest.setStyleName("lblerrores");
                vlInv.addComponent(errest, 5, 17);
        //Ip's
        Label ipLabel = new Label("Direcciones IP autorizadas:");        
        vlInv.addComponent(ipLabel,0,18);
        vlInv.addComponent(ip1,2,18);
        ip1.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                
                 if (ip1.getValue().equals("")) {
                        ip1.setComponentError(new UserError(""));
                        errIp1.setValue("Este campo es requerido");
                    } else {
                if (!ip1.getValue().equals("")) {
                    if (ip1.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip1.setComponentError(null);
                        errIp1.setValue("");
                    } else {
                        ip1.setComponentError(new UserError(""));
                        errIp1.setValue("Dirección Ip inválida");
                    }                                           
                } else {
                            ip1.setComponentError(null);
                            errIp1.setValue("");
                        }
               }
                ValidarError();
            }
        });
        errIp1.setStyleName("lblerrores");
        vlInv.addComponent(errIp1,2,19);
        
        
        
        vlInv.addComponent(ip2,3,18);
        ip2.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip2.getValue().equals("")) {
                    if (ip2.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip2.setComponentError(null);
                        errIp2.setValue("");
                    } else {
                        ip2.setComponentError(new UserError(""));
                        errIp2.setValue("Dirección Ip inválida");
                    }
                } else {
                            ip2.setComponentError(null);
                            errIp2.setValue("");
                        }
                ValidarError();
            }
        });
        errIp2.setStyleName("lblerrores");
        vlInv.addComponent(errIp2,3,19);

        vlInv.addComponent(ip3,5,18);
        ip3.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip3.getValue().equals("")) {
                    if (ip3.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip3.setComponentError(null);
                        errIp3.setValue("");
                    } else {
                        ip3.setComponentError(new UserError(""));
                        errIp3.setValue("Dirección Ip inválida");
                    }
                } else {
                            ip3.setComponentError(null);
                            errIp3.setValue("");
                        }
                ValidarError();
            }
        });
        errIp3.setStyleName("lblerrores");
        vlInv.addComponent(errIp3,5,19);
        
        vlInv.addComponent(ip4,2,20);
        ip4.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip4.getValue().equals("")) {
                    if (ip4.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip4.setComponentError(null);
                        errIp4.setValue("");
                    } else {
                        ip4.setComponentError(new UserError(""));
                        errIp4.setValue("Dirección Ip inválida");
                    }
                } else {
                            ip4.setComponentError(null);
                            errIp4.setValue("");
                        }
                ValidarError();
            }
        });
        errIp4.setStyleName("lblerrores");
        vlInv.addComponent(errIp4,2,21);

        vlInv.addComponent(ip5,3,20);
        ip5.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip5.getValue().equals("")) {
                    if (ip5.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip5.setComponentError(null);
                        errIp5.setValue("");
                    } else {
                        ip5.setComponentError(new UserError(""));
                        errIp5.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip5.setComponentError(null);
                            errIp5.setValue("");
                        }
                ValidarError();
            }
        });
        errIp5.setStyleName("lblerrores");
        vlInv.addComponent(errIp5,3,21);

        vlInv.addComponent(ip6,5,20);
        ip6.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip6.getValue().equals("")) {
                    if (ip6.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip6.setComponentError(null);
                        errIp6.setValue("");
                    } else {
                        ip6.setComponentError(new UserError(""));
                        errIp6.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip6.setComponentError(null);
                            errIp6.setValue("");
                        }
                ValidarError();
            }
        });
        errIp6.setStyleName("lblerrores");
        vlInv.addComponent(errIp6,5,21);

        vlInv.addComponent(ip7,2,22);
        ip7.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip7.getValue().equals("")) {
                    if (ip7.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip7.setComponentError(null);
                        errIp7.setValue("");
                    } else {
                        ip7.setComponentError(new UserError(""));
                        errIp7.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip7.setComponentError(null);
                            errIp7.setValue("");
                        }
                ValidarError();
            }
        });
        errIp7.setStyleName("lblerrores");
        vlInv.addComponent(errIp7,2,23);

        vlInv.addComponent(ip8,3,22);
        ip8.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip8.getValue().equals("")) {
                    if (ip8.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip8.setComponentError(null);
                        errIp8.setValue("");
                    } else {
                        ip8.setComponentError(new UserError(""));
                        errIp8.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip8.setComponentError(null);
                            errIp8.setValue("");
                        }
                ValidarError();
            }
        });
        errIp8.setStyleName("lblerrores");
        vlInv.addComponent(errIp8,3,23);

        vlInv.addComponent(ip9,5,22);
        ip9.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip9.getValue().equals("")) {
                    if (ip9.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip9.setComponentError(null);
                        errIp9.setValue("");
                    } else {
                        ip9.setComponentError(new UserError(""));
                        errIp9.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip9.setComponentError(null);
                            errIp9.setValue("");
                        }
                ValidarError();
            }
        });
        errIp9.setStyleName("lblerrores");
        vlInv.addComponent(errIp9,5,23);

        vlInv.addComponent(ip10,2,24);
        ip10.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip10.getValue().equals("")) {
                    if (ip10.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip10.setComponentError(null);
                        errIp10.setValue("");
                    } else {
                        ip10.setComponentError(new UserError(""));
                        errIp10.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip10.setComponentError(null);
                            errIp10.setValue("");
                        }
                ValidarError();
            }
        });
        errIp10.setStyleName("lblerrores");
        vlInv.addComponent(errIp10,2,25);

        vlInv.addComponent(ip11,3,24);
        ip11.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip11.getValue().equals("")) {
                    if (ip11.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip11.setComponentError(null);
                        errIp11.setValue("");
                    } else {
                        ip11.setComponentError(new UserError(""));
                        errIp11.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip11.setComponentError(null);
                            errIp11.setValue("");
                        }
                ValidarError();
            }
        });
        errIp11.setStyleName("lblerrores");
        vlInv.addComponent(errIp11,3,25);

        vlInv.addComponent(ip12,5,24);
        ip12.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip12.getValue().equals("")) {
                    if (ip12.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip12.setComponentError(null);
                        errIp12.setValue("");
                    } else {
                        ip12.setComponentError(new UserError(""));
                        errIp12.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip12.setComponentError(null);
                            errIp12.setValue("");
                        }
                ValidarError();
            }
        });
        errIp12.setStyleName("lblerrores");
        vlInv.addComponent(errIp12,5,25);

        vlInv.addComponent(ip13,2,26);
        ip13.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip13.getValue().equals("")) {
                    if (ip13.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip13.setComponentError(null);
                        errIp13.setValue("");
                    } else {
                        ip13.setComponentError(new UserError(""));
                        errIp13.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip13.setComponentError(null);
                            errIp13.setValue("");
                        }
                ValidarError();
            }
        });
        errIp13.setStyleName("lblerrores");
        vlInv.addComponent(errIp13,2,27);

        vlInv.addComponent(ip14,3,26);
        ip14.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip14.getValue().equals("")) {
                    if (ip14.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip14.setComponentError(null);
                        errIp14.setValue("");
                    } else {
                        ip14.setComponentError(new UserError(""));
                        errIp14.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip14.setComponentError(null);
                            errIp14.setValue("");
                        }
                ValidarError();
            }
        });
        errIp14.setStyleName("lblerrores");
        vlInv.addComponent(errIp14,3,27);

        vlInv.addComponent(ip15,5,26);
        ip15.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip15.getValue().equals("")) {
                    if (ip15.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip15.setComponentError(null);
                        errIp15.setValue("");
                    } else {
                        ip15.setComponentError(new UserError(""));
                        errIp15.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip15.setComponentError(null);
                            errIp15.setValue("");
                        }
                ValidarError();
            }
        });
        errIp15.setStyleName("lblerrores");
        vlInv.addComponent(errIp15,5,27);
        
        vlInv.addComponent(ip16,2,28);
        ip16.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip16.getValue().equals("")) {
                    if (ip16.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip16.setComponentError(null);
                        errIp16.setValue("");
                    } else {
                        ip16.setComponentError(new UserError(""));
                        errIp16.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip16.setComponentError(null);
                            errIp16.setValue("");
                        }
                ValidarError();
            }
        });
        errIp16.setStyleName("lblerrores");
        vlInv.addComponent(errIp16,2,29);
        
        vlInv.addComponent(ip17,3,28);
        ip17.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip17.getValue().equals("")) {
                    if (ip17.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip17.setComponentError(null);
                        errIp17.setValue("");
                    } else {
                        ip17.setComponentError(new UserError(""));
                        errIp17.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip17.setComponentError(null);
                            errIp17.setValue("");
                        }
                ValidarError();
            }
        });
        errIp17.setStyleName("lblerrores");
        vlInv.addComponent(errIp17,3,29);
        
        vlInv.addComponent(ip18,5,28);
        ip18.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip18.getValue().equals("")) {
                    if (ip18.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip18.setComponentError(null);
                        errIp18.setValue("");
                    } else {
                        ip18.setComponentError(new UserError(""));
                        errIp18.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip18.setComponentError(null);
                            errIp18.setValue("");
                        }
                ValidarError();
            }
        });
        errIp18.setStyleName("lblerrores");
        vlInv.addComponent(errIp18,5,29);
        
        vlInv.addComponent(ip19,2,30);
        ip19.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip19.getValue().equals("")) {
                    if (ip19.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip19.setComponentError(null);
                        errIp19.setValue("");
                    } else {
                        ip19.setComponentError(new UserError(""));
                        errIp19.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip19.setComponentError(null);
                            errIp19.setValue("");
                        }
                ValidarError();
            }
        });
        errIp19.setStyleName("lblerrores");
        vlInv.addComponent(errIp19,2,31);
        
        vlInv.addComponent(ip20,3,30);
        ip20.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip20.getValue().equals("")) {
                    if (ip20.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip20.setComponentError(null);
                        errIp20.setValue("");
                    } else {
                        ip20.setComponentError(new UserError(""));
                        errIp20.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip20.setComponentError(null);
                            errIp20.setValue("");
                        }
                ValidarError();
            }
        });
        errIp20.setStyleName("lblerrores");
        vlInv.addComponent(errIp20,3,31);
        
        vlInv.addComponent(ip21,5,30);
        ip21.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip21.getValue().equals("")) {
                    if (ip21.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip21.setComponentError(null);
                        errIp21.setValue("");
                    } else {
                        ip21.setComponentError(new UserError(""));
                        errIp21.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip21.setComponentError(null);
                            errIp21.setValue("");
                        }
                ValidarError();
            }
        });
        errIp21.setStyleName("lblerrores");
        vlInv.addComponent(errIp21,5,31);
        
        vlInv.addComponent(ip22,2,32);
        ip22.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip22.getValue().equals("")) {
                    if (ip22.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip22.setComponentError(null);
                        errIp22.setValue("");
                    } else {
                        ip22.setComponentError(new UserError(""));
                        errIp22.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip22.setComponentError(null);
                            errIp22.setValue("");
                        }
                ValidarError();
            }
        });
        errIp22.setStyleName("lblerrores");
        vlInv.addComponent(errIp22,2,33);
        
        vlInv.addComponent(ip23,3,32);
        ip23.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip23.getValue().equals("")) {
                    if (ip23.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip23.setComponentError(null);
                        errIp23.setValue("");
                    } else {
                        ip23.setComponentError(new UserError(""));
                        errIp23.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip23.setComponentError(null);
                            errIp23.setValue("");
                        }
                ValidarError();
            }
        });
        errIp23.setStyleName("lblerrores");
        vlInv.addComponent(errIp23,3,33);
        
        vlInv.addComponent(ip24,5,32);
        ip24.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip24.getValue().equals("")) {
                    if (ip24.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip24.setComponentError(null);
                        errIp24.setValue("");
                    } else {
                        ip24.setComponentError(new UserError(""));
                        errIp24.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip24.setComponentError(null);
                            errIp24.setValue("");
                        }
                ValidarError();
            }
        });
        errIp24.setStyleName("lblerrores");
        vlInv.addComponent(errIp24,5,33);
        
        vlInv.addComponent(ip25,2,34);
        ip25.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip25.getValue().equals("")) {
                    if (ip25.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip25.setComponentError(null);
                        errIp25.setValue("");
                    } else {
                        ip25.setComponentError(new UserError(""));
                        errIp25.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip25.setComponentError(null);
                            errIp25.setValue("");
                        }
                ValidarError();
            }
        });
        errIp25.setStyleName("lblerrores");
        vlInv.addComponent(errIp25,2,35);
        
        vlInv.addComponent(ip26,3,34);
        ip26.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip26.getValue().equals("")) {
                    if (ip26.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip26.setComponentError(null);
                        errIp26.setValue("");
                    } else {
                        ip26.setComponentError(new UserError(""));
                        errIp26.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip26.setComponentError(null);
                            errIp26.setValue("");
                        }
                ValidarError();
            }
        });
        errIp26.setStyleName("lblerrores");
        vlInv.addComponent(errIp26,3,35);
        
        vlInv.addComponent(ip27,5,34);
        ip27.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip27.getValue().equals("")) {
                    if (ip27.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip27.setComponentError(null);
                        errIp27.setValue("");
                    } else {
                        ip27.setComponentError(new UserError(""));
                        errIp27.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip27.setComponentError(null);
                            errIp27.setValue("");
                        }
                ValidarError();
            }
        });
        errIp27.setStyleName("lblerrores");
        vlInv.addComponent(errIp27,5,35);
        
        vlInv.addComponent(ip28,2,36);
        ip28.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip28.getValue().equals("")) {
                    if (ip28.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip28.setComponentError(null);
                        errIp28.setValue("");
                    } else {
                        ip28.setComponentError(new UserError(""));
                        errIp28.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip28.setComponentError(null);
                            errIp28.setValue("");
                        }
                ValidarError();
            }
        });
        errIp28.setStyleName("lblerrores");
        vlInv.addComponent(errIp28,2,37);
        
        vlInv.addComponent(ip29,3,36);
        ip29.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip29.getValue().equals("")) {
                    if (ip29.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip29.setComponentError(null);
                        errIp29.setValue("");
                    } else {
                        ip29.setComponentError(new UserError(""));
                        errIp29.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip29.setComponentError(null);
                            errIp29.setValue("");
                        }
                ValidarError();
            }
        });
        errIp29.setStyleName("lblerrores");
        vlInv.addComponent(errIp29,3,37);
        
        vlInv.addComponent(ip30,5,36);
        ip30.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip30.getValue().equals("")) {
                    if (ip30.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip30.setComponentError(null);
                        errIp30.setValue("");
                    } else {
                        ip30.setComponentError(new UserError(""));
                        errIp30.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip30.setComponentError(null);
                            errIp30.setValue("");
                        }
                ValidarError();
            }
        });
        errIp30.setStyleName("lblerrores");
        vlInv.addComponent(errIp30,5,37);
        
        vlInv.addComponent(ip31,2,38);
        ip31.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip31.getValue().equals("")) {
                    if (ip31.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip31.setComponentError(null);
                        errIp31.setValue("");
                    } else {
                        ip31.setComponentError(new UserError(""));
                        errIp31.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip31.setComponentError(null);
                            errIp31.setValue("");
                        }
                ValidarError();
            }
        });
        errIp31.setStyleName("lblerrores");
        vlInv.addComponent(errIp31,2,39);
        
        vlInv.addComponent(ip32,3,38);
        ip32.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip32.getValue().equals("")) {
                    if (ip32.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip32.setComponentError(null);
                        errIp32.setValue("");
                    } else {
                        ip32.setComponentError(new UserError(""));
                        errIp32.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip32.setComponentError(null);
                            errIp32.setValue("");
                        }
                ValidarError();
            }
        });
        errIp32.setStyleName("lblerrores");
        vlInv.addComponent(errIp32,3,39);
        
        vlInv.addComponent(ip33,5,38);
        ip33.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip33.getValue().equals("")) {
                    if (ip33.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip33.setComponentError(null);
                        errIp33.setValue("");
                    } else {
                        ip33.setComponentError(new UserError(""));
                        errIp33.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip33.setComponentError(null);
                            errIp33.setValue("");
                        }
                ValidarError();
            }
        });
        errIp33.setStyleName("lblerrores");
        vlInv.addComponent(errIp33,5,39);
        
        vlInv.addComponent(ip34,2,40);
        ip34.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip34.getValue().equals("")) {
                    if (ip34.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip34.setComponentError(null);
                        errIp34.setValue("");
                    } else {
                        ip34.setComponentError(new UserError(""));
                        errIp34.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip34.setComponentError(null);
                            errIp34.setValue("");
                        }
                ValidarError();
            }
        });
        errIp34.setStyleName("lblerrores");
        vlInv.addComponent(errIp34,2,41);
        
        vlInv.addComponent(ip35,3,40);
        ip35.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip35.getValue().equals("")) {
                    if (ip35.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip35.setComponentError(null);
                        errIp35.setValue("");
                    } else {
                        ip35.setComponentError(new UserError(""));
                        errIp35.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip35.setComponentError(null);
                            errIp35.setValue("");
                        }
                ValidarError();
            }
        });
        errIp35.setStyleName("lblerrores");
        vlInv.addComponent(errIp35,3,41);
        
        vlInv.addComponent(ip36,5,40);
        ip36.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip36.getValue().equals("")) {
                    if (ip36.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip36.setComponentError(null);
                        errIp36.setValue("");
                    } else {
                        ip36.setComponentError(new UserError(""));
                        errIp36.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip36.setComponentError(null);
                            errIp36.setValue("");
                        }
                ValidarError();
            }
        });
        errIp36.setStyleName("lblerrores");
        vlInv.addComponent(errIp36,5,41);
        
        vlInv.addComponent(ip37,2,42);
        ip37.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip37.getValue().equals("")) {
                    if (ip37.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip37.setComponentError(null);
                        errIp17.setValue("");
                    } else {
                        ip37.setComponentError(new UserError(""));
                        errIp37.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip37.setComponentError(null);
                            errIp37.setValue("");
                        }
                ValidarError();
            }
        });
        errIp37.setStyleName("lblerrores");
        vlInv.addComponent(errIp37,2,43);
        
        vlInv.addComponent(ip38,3,42);
        ip38.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip38.getValue().equals("")) {
                    if (ip38.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip38.setComponentError(null);
                        errIp38.setValue("");
                    } else {
                        ip38.setComponentError(new UserError(""));
                        errIp38.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip38.setComponentError(null);
                            errIp38.setValue("");
                        }
                ValidarError();
            }
        });
        errIp38.setStyleName("lblerrores");
        vlInv.addComponent(errIp38,3,43);
        
        vlInv.addComponent(ip39,5,42);
        ip39.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip39.getValue().equals("")) {
                    if (ip39.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip39.setComponentError(null);
                        errIp39.setValue("");
                    } else {
                        ip39.setComponentError(new UserError(""));
                        errIp39.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip39.setComponentError(null);
                            errIp39.setValue("");
                        }
                ValidarError();
            }
        });
        errIp39.setStyleName("lblerrores");
        vlInv.addComponent(errIp39,5,43);
        
        vlInv.addComponent(ip40,2,44);
        ip40.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip40.getValue().equals("")) {
                    if (ip40.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip40.setComponentError(null);
                        errIp40.setValue("");
                    } else {
                        ip40.setComponentError(new UserError(""));
                        errIp40.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip40.setComponentError(null);
                            errIp40.setValue("");
                        }
                ValidarError();
            }
        });
        errIp40.setStyleName("lblerrores");
        vlInv.addComponent(errIp40,2,45);

                final Button modificar = new Button("Modificar");
                final Button cancelar = new Button("Cancelar");

                cancelar.addClickListener(new Button.ClickListener() {
                    private static final long serialVersionUID = 1L;

                    public void buttonClick(ClickEvent event) {

                        modUsuarios.close();
                        grid.select(null);
                        Limpiar();
                        select = 0;
                        controladorEve1 = 0;
                        error.setValue("");
                    }
                });

                modUsuarios.addCloseListener(new Window.CloseListener() {

                    @Override
                    public void windowClose(Window.CloseEvent e) {

                        grid.select(null);
                        Limpiar();
                        select = 0;
                        controladorEve1 = 0;
                        error.setValue("");
                    }
                });

                vlInv.addComponent(modificar, 0, 45);

                vlInv.addComponent(cancelar, 1, 45);

                HorizontalLayout h = new HorizontalLayout();
               h.addComponents(modificar, cancelar);
            error.setStyleName("lblErrorVer");
            h.addComponent(error);
            cancelar.addStyleName("ButtCancelar");
            vl.addComponents(vlInv, h);
            h.addStyleName("horizontal1");
                vl.setComponentAlignment(h, Alignment.MIDDLE_CENTER);

                modificar.addClickListener(new Button.ClickListener() {

                    @Override
                    public void buttonClick(Button.ClickEvent event) {

                        try {
                            combo = (Integer) mcmb.getValue();
                        } catch (NullPointerException e) {
                            combo = 0;
                        } catch (ClassCastException ex) {
                            combo = 0;
                        }

                        try {
                            comboPer = (Integer) mperfiles.getValue();
                        } catch (NullPointerException e) {
                            comboPer = 0;
                        } catch (ClassCastException ex) {
                            comboPer = 0;
                        }

                        try {
                            comboEst = (Integer) mestado.getValue();
                        } catch (NullPointerException e) {
                            comboEst = 0;
                        } catch (ClassCastException ex) {
                            comboEst = 0;
                        }
                        try {
                            comboScb = (Integer) scb.getValue();
                        } catch (NullPointerException e) {
                            comboScb = 0;
                        } catch (ClassCastException ex) {
                            comboScb = 0;
                        }

                        if (combo == 0) {
                            mcmb.setComponentError(new UserError(""));
                            errIdcmb.setValue("Este campo es requerido");
                        }
                        if (mnumDoc.getValue().equals("")) {
                            mnumDoc.setComponentError(new UserError(""));
                            errnumDoc.setValue("Este campo es requerido");
                        }
                        if (mnombres.getValue().equals("")) {
                            mnombres.setComponentError(new UserError(""));
                            errnombre.setValue("Este campo es requerido");
                        }
                        if (mapellidos.getValue().equals("")) {
                            mapellidos.setComponentError(new UserError(""));
                            errape.setValue("Este campo es requerido");
                        }
                        if (mcorreo.getValue().equals("")) {
                            mcorreo.setComponentError(new UserError(""));
                            erracorre.setValue("Este campo es requerido");
                        }
                        if (mlogin.getValue().equals("")) {
                            mlogin.setComponentError(new UserError(""));
                            errlog.setValue("Este campo es requerido");
                        }
                        if (mclave.getValue().equals("")) {
                            if (bCambioClave) {
                            mclave.setComponentError(new UserError(""));
                            errcla.setValue("Este campo es requerido");
                            }
                        }
                        if (mverclave.getValue().equals("")) {
                            if (bCambioClave) {
                            mverclave.setComponentError(new UserError(""));
                            errvercla.setValue("Este campo es requerido");
                            }
                        }
                        if (comboPer == 0) {
                            mperfiles.setComponentError(new UserError(""));
                            errper.setValue("Este campo es requerido");
                        }
                        if (comboEst == 0) {
                            mestado.setComponentError(new UserError(""));
                            errest.setValue("Este campo es requerido");
                        }
                        if (comboScb == 0) {
                            scb.setComponentError(new UserError(""));
                            errscb.setValue("Este campo es requerido");
                        }
                        if (ip1.getValue().equals("")) {
                            ip1.setComponentError(new UserError(""));
                            errIp1.setValue("Este campo es requerido");
                        }
                      ValidarError();
                        if (!ValidaComponentError()) {
                            Usuario usu = new Usuario();
                            String est = "";

                            usu.setId(Integer.parseInt(idUsu));
                            usu.setNombres(mnombres.getValue());
                            usu.setApellidos(mapellidos.getValue());

                            String tipD = "";
                            if (mcmb.getValue().toString().equals("1")) {
                                tipD = "CC";
                            } else if (mcmb.getValue().toString().equals("2")) {
                                tipD = "CE";
                            } else if (mcmb.getValue().toString().equals("3")) {
                                tipD = "PAS";
                            }

                            usu.setTipoIdentificacion(tipD);
                            usu.setIdentificacion(mnumDoc.getValue());
                            usu.setEmail(mcorreo.getValue());
                            usu.setUsername(mlogin.getValue());
                            usu.setPassword(mclave.getValue());

                            usu.setSbolsa(Integer.parseInt(scb.getValue().toString()));
                           

                            if (mestado.getValue().toString().equals("1")) {
                                est = "A";
                            } else if (mestado.getValue().toString().equals("2")) {
                                est = "I";
                            } else if (mestado.getValue().toString().equals("3")) {
                                est = "B";
                            }

                            String nomUsuario = userDetailsService.getUsuarioAutenticado().getUsername();
                            usu.setUsuariosistemaultimamod(nomUsuario);
                            
                            String tipomodificacion = "Modificación Usuario - Modificación";
                            usu.setTipomodificacion(tipomodificacion);
                    
                            usu.setEstado(est);
                            
                            
                            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                            HttpServletRequest req = attr.getRequest();
                            Auditoria au = new Auditoria();
                            // AJUSTE IP REGISTRADA
                            //au.setIp(req.getRemoteAddr());
                            String remoteAddr = req.getHeader("X-Forwarded-For");
                            if (remoteAddr == null || "".equals(remoteAddr)) {
                                au.setIp(req.getRemoteAddr());
                            } else {
                                String ips[] = remoteAddr.split(",");
                                remoteAddr = ips[0];
                                au.setIp(remoteAddr);
                            }
                            //au.setIp(req.getHeader("X-Forwarded-For"));

                            logger.debug("OPA - REMOTEADDR_" + req.getRemoteAddr() + "x-forwarded-For_" + req.getHeader("X-Forwarded-For") + "IP:" + remoteAddr);

                            // 
                            au.setId_user(userDetailsService.getUsuarioAutenticado().getId());
//Crea la lista de Ips
                            ArrayList<IpAutorizada> ipsAutorizadas = new ArrayList<IpAutorizada>();
                            IpAutorizada a = null;
                            if (!ip1.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip1.getValue(), userDetailsService.getUsuarioAutenticado().getUsername(), "Ingreso IP - Modificación");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip2.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip2.getValue(), userDetailsService.getUsuarioAutenticado().getUsername(), "Ingreso IP - Modificación");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip3.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip3.getValue(), userDetailsService.getUsuarioAutenticado().getUsername(), "Ingreso IP - Modificación");
                                ipsAutorizadas.add(a);
                            }
                            
                            if (!ip4.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip4.getValue(), userDetailsService.getUsuarioAutenticado().getUsername(), "Ingreso IP - Modificación");
                                ipsAutorizadas.add(a);
                            }
                            
                             if (!ip5.getValue().equals("")) {
                                 a = new IpAutorizada(new Integer(0), ip5.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                             }
                            if (!ip6.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip6.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                             if (!ip7.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip7.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip8.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip8.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip9.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip9.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip10.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip10.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip11.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip11.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip12.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip12.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip13.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip13.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip14.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip14.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip15.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip15.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip16.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip16.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip17.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip17.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip18.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip18.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip19.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip19.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip20.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip20.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip21.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip21.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip22.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip22.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip23.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip23.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip24.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip24.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip25.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip25.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip26.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip26.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip27.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip27.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip28.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip28.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip29.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip29.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip30.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip30.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip31.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip31.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip32.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip32.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip33.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip33.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip34.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip34.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip35.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip35.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip36.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip36.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip37.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip37.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip38.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip38.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip39.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip39.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip40.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip40.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                         
                            usu = userDetailsService.saveUsuario(usu, au, mperfiles.getValue().toString(),ipsAutorizadas);
                            
                            
                            if (usu != null) {
                                Notification notif = new Notification(
                                        "Confirmación",
                                        "Usuario modificado satisfactoriamente",
                                        Notification.Type.HUMANIZED_MESSAGE);

                        notif.setDelayMsec(40000);

                                notif.show(Page.getCurrent());
                                modUsuarios.close();
                                grid.getSelectedRows().clear();
                                grid.getContainerDataSource().removeAllItems();
                                List<List<String>> listUsuarios = facade.Retornarusuarios();
                                
                                String estado="";
                                for (int i = 0; i < listUsuarios.get(0).size(); i++) {
                                    if (listUsuarios.get(11).get(i).equals("A")) {
                                        estado = "Activo";
                                    } else if (listUsuarios.get(11).get(i).equals("I")) {
                                        estado = "Inactivo";
                                    } else if (listUsuarios.get(11).get(i).equals("B")) {
                                        estado = "Bloqueado";
                                    }
                                    
                                                                        
                                    //Lsierra 2016-04-08 Mantis 2515
                                    /*String scb = listUsuarios.get(18).get(i);
                                    String[] list = scb.split("-");
                                    String codigosc = list[0]; */

                                      grid.addRow(listUsuarios.get(0).get(i), listUsuarios.get(6).get(i), listUsuarios.get(7).get(i), listUsuarios.get(3).get(i), listUsuarios.get(4).get(i), listUsuarios.get(18).get(i), listUsuarios.get(1).get(i), listUsuarios.get(17).get(i), estado, listUsuarios.get(5).get(i));
                                   // grid.addRow(listUsuarios.get(0).get(i), listUsuarios.get(6).get(i), listUsuarios.get(7).get(i), listUsuarios.get(3).get(i), listUsuarios.get(4).get(i), listUsuarios.get(16).get(i), listUsuarios.get(1).get(i), listUsuarios.get(17).get(i), listUsuarios.get(11).get(i), listUsuarios.get(5).get(i));
                                }
                            } else {
                                Notification.show("Hubo un Error en la Modificacion del Usuario", Notification.Type.ERROR_MESSAGE);
                            }
                        }
                        controladorEve1 = 0;
                    }
                });

            } //////////////////////////////////////////////////////////////////////RIEGOS MOD ADMIN/////////////////////////////////////////////////////////////////////////
            else {
                final GridLayout vlInv = new GridLayout(6, 46);
                vlInv.setMargin(true);
                vlInv.setStyleName("StylegridLa");
                Label esp = new Label("");
                Label tpID = new Label("Tipo Documento:");
                mcmb = LlenarTipoDocumentos();
                if (tipoD.equals("CC")) {
                    mcmb.select(1);
                } else if (tipoD.equals("CE")) {
                    mcmb.select(2);
                } else if (tipoD.equals("PAS")) {
                    mcmb.select(3);
                }

                mcmb.setEnabled(true);

                mcmb.addBlurListener(new FieldEvents.BlurListener() {
                    @Override
                    public void blur(FieldEvents.BlurEvent event) {
                        
                        try {
                            valorCombo = (Integer) mcmb.getValue();
                        } catch (NullPointerException ex) {
                            valorCombo = 0;
                        } catch (ClassCastException e) {
                            valorCombo = 0;
                        }
                        
                        numDoc.setComponentError(null);
                        errnumDoc.setValue("");
                        
                        if (mcmb.getValue() == null || mcmb.getValue().equals("")) {
                            mcmb.setComponentError(new UserError(""));
                            errIdcmb.setValue("Este campo es requerido");
                        } else {
                            mcmb.setComponentError(null);
                            errIdcmb.setValue("");
                        }
                        
                        
                        if (valorCombo == 2 || valorCombo == 3) {
                            if (!mnumDoc.getValue().matches(regexAlpha)) {
                                mnumDoc.setComponentError(new UserError(""));
                                errnumDoc.setValue("Este campo contiene caracteres no válidos");
                            }else{
                                mnumDoc.setComponentError(null);
                                errnumDoc.setValue("");
                            }
                        } else {
                            if (!mnumDoc.getValue().matches(regexNumeric)) {
                                mnumDoc.setComponentError(new UserError(""));
                                errnumDoc.setValue("Este campo contiene caracteres no válidos");
                            }else{
                                mnumDoc.setComponentError(null);
                                errnumDoc.setValue("");
                            }
                        }
                        
                        ValidarError();
                    }
                });

                vlInv.setSpacing(true);
                vlInv.addComponent(tpID, 0, 1);
                Label asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 1, 1);
                vlInv.addComponent(mcmb, 2, 1);
                vlInv.setSpacing(true);
                Label ID = new Label("Número Documento:");
                vlInv.addComponent(ID, 3, 1);
                asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 4, 1);

                mnumDoc.setValue(numD);
                mnumDoc.setEnabled(true);
                vlInv.addComponent(mnumDoc, 5, 1);

                mnumDoc.setMaxLength(15);

                mnumDoc.addBlurListener(new FieldEvents.BlurListener() {

                    @Override
                    public void blur(FieldEvents.BlurEvent event) {

                        try {
                            valorCombo = (Integer) mcmb.getValue();
                        } catch (NullPointerException ex) {
                            valorCombo = 0;
                        } catch (ClassCastException e) {
                            valorCombo = 0;
                        }
                        mnumDoc.setComponentError(null);
                        errnumDoc.setValue("");
                        if (mnumDoc.getValue().equals("")) {
                            mnumDoc.setComponentError(new UserError(""));
                            errnumDoc.setValue("Este campo es requerido");
                        }else{
                                mnumDoc.setComponentError(null);
                                errnumDoc.setValue("");
                            }
                        if (valorCombo == 2 || valorCombo == 3) {
                            if (!mnumDoc.getValue().matches(regexAlpha)) {
                                mnumDoc.setComponentError(new UserError(""));
                                errnumDoc.setValue("Este campo contiene caracteres no válidos");
                            }else{
                                mnumDoc.setComponentError(null);
                                errnumDoc.setValue("");
                            }
                        } else {
                            if (!mnumDoc.getValue().matches(regexNumeric)) {
                                mnumDoc.setComponentError(new UserError(""));
                                errnumDoc.setValue("Este campo contiene caracteres no válidos");
                            }else{
                                numDoc.setComponentError(null);
                                errnumDoc.setValue("");
                            }
                        }

                        ValidarError();

                    }
                });

                errIdcmb.setStyleName("lblerrores");
                vlInv.addComponent(errIdcmb, 2, 2);

                errnumDoc.setStyleName("lblerrores");
                vlInv.addComponent(errnumDoc, 5, 2);

                Label nom = new Label("Nombres:");

                vlInv.setSpacing(true);
                vlInv.addComponent(esp, 0, 3);
                vlInv.addComponent(nom, 0, 4);
                asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 1, 4);

                mnombres.setValue(nomb);
                mnombres.setEnabled(true);
                vlInv.addComponent(mnombres, 2, 4);
                vlInv.setSpacing(true);
                Label ape = new Label("Apellidos:");

                vlInv.addComponent(ape, 3, 4);
                asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 4, 4);

                mapellidos.setValue(apell);
                mapellidos.setEnabled(true);
                vlInv.addComponent(mapellidos, 5, 4);

                mnombres.setMaxLength(50);

                mnombres.addBlurListener(new FieldEvents.BlurListener() {

                    @Override
                    public void blur(FieldEvents.BlurEvent event) {

                        if (!mnombres.getValue().equals("")) {
                            if (mnombres.getValue().matches(regexLetras)) {
                                mnombres.setComponentError(null);
                                errnombre.setValue("");
                            } else {
                                mnombres.setComponentError(new UserError(""));
                                errnombre.setValue("Este campo contiene caracteres no válidos");
                            }
                        } else {
                            mnombres.setComponentError(null);
                            errnombre.setValue("");
                        }
                        ValidarError();
                    }
                });

                mapellidos.setMaxLength(50);

                mapellidos.addBlurListener(new FieldEvents.BlurListener() {

                    @Override
                    public void blur(FieldEvents.BlurEvent event) {

                        if (!mapellidos.getValue().equals("")) {
                            if (mapellidos.getValue().matches(regexLetras)) {
                                mapellidos.setComponentError(null);
                                errape.setValue("");
                            } else {
                                mapellidos.setComponentError(new UserError(""));
                                errape.setValue("Este campo contiene caracteres no válidos");
                            }
                        } else {
                            mapellidos.setComponentError(null);
                            errape.setValue("");
                        }
                        ValidarError();
                    }
                });

                errnombre.setStyleName("lblerrores");
                vlInv.addComponent(errnombre, 2, 5);

                errape.setStyleName("lblerrores");
                vlInv.addComponent(errape, 5, 5);

                Label scbEnti = new Label("SCB/Entidad");
                Label corr = new Label("Correo Electrónico:");

                Label esp1 = new Label("");

                vlInv.setSpacing(true);
                vlInv.addComponent(esp1, 0, 6);

                if (PerfilActual.equals("Riesgos")) {
                    scb = LlenarSCB();
                    scb.setEnabled(false);
                    scb.setWidth("140px");
                    vlInv.addComponent(scbEnti, 0, 7);
                    asteriscos = new Label("*");
                    asteriscos.setStyleName("asterix");
                    vlInv.addComponent(asteriscos, 1, 7);
                    vlInv.addComponent(scb, 2, 7);

                    scb.select(Integer.parseInt(socSCB));
                    scb.addBlurListener(new FieldEvents.BlurListener() {
                        @Override
                        public void blur(FieldEvents.BlurEvent event) {
                            if (scb.getValue() == null || scb.getValue().equals("")) {
                                scb.setComponentError(new UserError(""));
                                errscb.setValue("Este campo es requerido");
                            } else {
                                scb.setComponentError(null);
                                errscb.setValue("");
                            }
                            ValidarError();
                        }
                    });
                    
                } else {
                    vlInv.addComponent(scbEnti, 0, 7);
                    String nombre = facade.RetornarSCBusuSelec(Integer.parseInt(socSCB));
                    sociedad.setValue(nombre);
                    vlInv.addComponent(sociedad, 2, 7);
                }
                
                errscb.setStyleName("lblerrores");
                vlInv.addComponent(errscb, 2, 8);

                vlInv.setSpacing(true);

                Label logi = new Label("Login:");

                vlInv.setSpacing(true);
                Label esp2 = new Label("");
                vlInv.addComponent(esp2, 0, 9);
                vlInv.addComponent(corr, 0, 10);
                asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 1, 10);

                mcorreo.setValue(cor);
                mcorreo.setEnabled(true);
                vlInv.addComponent(mcorreo, 2, 10);
                vlInv.addComponent(logi, 3, 10);
                asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 4, 10);

                mlogin.setValue(log);
                mlogin.setEnabled(false);
                mlogin.setMaxLength(20);
                vlInv.addComponent(mlogin, 5, 10);

                mcorreo.setMaxLength(100);

                mcorreo.addBlurListener(new FieldEvents.BlurListener() {

                    @Override
                    public void blur(FieldEvents.BlurEvent event) {
                        if (mcorreo.getValue().equals("")) {
                            mcorreo.setComponentError(new UserError(""));
                            erracorre.setValue("Este campo es requerido");
                        } else {
                            if (mcorreo.getValue().matches(regexEmail)) {
                                if (mcorreo.getValue().matches(regexEmailEstruct)) {
                                    mcorreo.setComponentError(null);
                                    erracorre.setValue("");
                                } else {
                                    mcorreo.setComponentError(new UserError(""));
                                    erracorre.setValue("La estructura del Correo Electrónico no es válida");
                                }
                            } else {
                                mcorreo.setComponentError(new UserError(""));
                                erracorre.setValue("Este campo contiene caracteres no válidos");
                            }
                        }
                        ValidarError();
                    }
                });

                mlogin.addBlurListener(new FieldEvents.BlurListener() {

                    @Override
                    public void blur(FieldEvents.BlurEvent event) {

                        if (!mlogin.getValue().equals("")) {
                            if (mlogin.getValue().matches(regexAlpha)) {
                                mlogin.setComponentError(null);
                                errlog.setValue("");
                            } else {
                                mlogin.setComponentError(new UserError(""));
                                errlog.setValue("Este campo contiene caracteres no válidos");
                            }
                        } else {
                            mlogin.setComponentError(null);
                            errlog.setValue("");
                        }
                        ValidarError();
                    }
                });

                erracorre.setStyleName("lblerrores");
                vlInv.addComponent(erracorre, 2, 11);

                errlog.setStyleName("lblerrores");
                vlInv.addComponent(errlog, 5, 11);

                Label esp3 = new Label("");
                vlInv.setSpacing(true);
                Label cont = new Label("Contraseña:");

                Label vecont = new Label("Verificar Contraseña:");

                vlInv.addComponent(esp3, 0, 12);
                vlInv.addComponent(cont, 0, 13);
                asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 1, 13);
                vlInv.addComponent(mclave, 2, 13);
                mclave.setEnabled(true);
                mclave.setMaxLength(20);
                bCambioClave=false;
                mclave.addTextChangeListener(new FieldEvents.TextChangeListener() {
                    @Override
                    public void textChange(FieldEvents.TextChangeEvent event) {
                        if (mverclave.getValue().length()==0 && event.getText().length()==0) {
                           bCambioClave = false;
                            mclave.setComponentError(null);
                            errcla.setValue("");
                            mverclave.setComponentError(null);
                            errvercla.setValue("");
                           
                        } else  {
                           bCambioClave = true; 
                        }   
                        ValidarError();
                    }               

                 });
                mclave.addBlurListener(new FieldEvents.BlurListener() {

                    @Override
                    public void blur(FieldEvents.BlurEvent event) {
                        if (bCambioClave) {
                            if (mclave.getValue().equals("")) {
                                mclave.setComponentError(new UserError(""));
                                errcla.setValue("Este campo es requerido");
                            } else if (validaPassAnteriores(mclave.getValue())) {
                                if (validaLongitudContra(mclave.getValue())) {
                                  if(caracteresConsecutivos(mclave.getValue())){
                                    if (validarSecuen(mclave.getValue())) {
                                        if (validaunaMayus(mclave.getValue())) {
                                            if (validalfaNum(mclave.getValue())) {
                                                if (validaunCaracter(mclave.getValue())) {
                                                    if (validaunNumero(mclave.getValue())) {                                                       														
                                                        //Diccionario de contraseñas
                                                        //Validar que la clave no contega palabras restringidas  riesgos mod admin                                          
                                                        Boolean palpermitida = facadediccionario.validaRestringidas(mclave.getValue());
                                                        if (palpermitida) {
                                                            mclave.setComponentError(new UserError(""));
                                                            errcla.setValue("La contraseña contiene una palabra no permitida");
                                                        } else {
                                                        mclave.setComponentError(null);
                                                        errcla.setValue("");
                                                        }  
                                                    } else {
                                                        mclave.setComponentError(new UserError(""));
                                                        errcla.setValue("La contraseña debe tener al menos un número");
                                                    }
                                                } else {
                                                    mclave.setComponentError(new UserError(""));
                                                    errcla.setValue("La contraseña debe tener un al menos carácter especial");
                                                }

                                            } else {
                                                mclave.setComponentError(new UserError(""));
                                                errcla.setValue("La contraseña debe ser alfanumerica");
                                            }
                                        } else {
                                            mclave.setComponentError(new UserError(""));
                                            errcla.setValue("La contraseña debe tener al menos una mayúscula");
                                        }
                                    } else {
                                        mclave.setComponentError(new UserError(""));
                                        errcla.setValue("La contraseña no debe contener caracteres consecutivos ");
                                    }
                                  } else {
                                    mclave.setComponentError(new UserError(""));
                                    errcla.setValue("La contraseña no debe contener más de 3 caracteres idénticos consecutivos");
                                    } 
                                } else {
                                    mclave.setComponentError(new UserError(""));
                                    errcla.setValue("la contraseña debe contener mínimo 8 caracteres o máximo 15");
                                }
                            } else {
                                mclave.setComponentError(new UserError(""));
                                errcla.setValue("La contraseña coincide con las últimas tres contraseñas anteriores");
                            }
                            ValidarError();
                        }
                    }
                });

                vlInv.addComponent(vecont, 3, 13);
                asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 4, 13);
                vlInv.addComponent(mverclave, 5, 13);
                mverclave.setEnabled(true);
                mverclave.setMaxLength(20);
                mverclave.addTextChangeListener(new FieldEvents.TextChangeListener() {
                    @Override
                    public void textChange(FieldEvents.TextChangeEvent event) {
                        if (event.getText().length()==0 && mclave.getValue().length()==0) {
                           bCambioClave = false;
                            mclave.setComponentError(null);
                            errcla.setValue("");
                            mverclave.setComponentError(null);
                            errvercla.setValue("");
                           
                        } else  {
                           bCambioClave = true; 
                        }   
                        ValidarError();
                           
                    }

                });                
                
                mverclave.addBlurListener(new FieldEvents.BlurListener() {

                    @Override
                    public void blur(FieldEvents.BlurEvent event) {
                        if (bCambioClave) {
                            if (mverclave.getValue().equals("")) {
                                mverclave.setComponentError(new UserError(""));
                                errvercla.setValue("Este campo es requerido");
                            } else if (!mclave.getValue().equals(mverclave.getValue())) {
                                mverclave.setComponentError(new UserError(""));
                                errvercla.setValue("Las contraseñas ingresadas no coinciden");
                            } else {
                                mverclave.setComponentError(null);
                                errvercla.setValue("");
                            }
                            ValidarError();
                        }
                    }
                });

                errcla.setStyleName("lblerrores");
                vlInv.addComponent(errcla, 2, 14);

                errvercla.setStyleName("lblerrores");
                vlInv.addComponent(errvercla, 5, 14);

                mperfiles = LlenarTipoPerfiles();

                if (per.equals("Administrador SCB")) {
                    mperfiles.select(1);
                } else if (per.equals("Administrador BVC")) {
                    mperfiles.select(2);
                } else if (per.equals("Riesgos")) {
                    mperfiles.select(3);
                } else if (per.equals("Operador SCB")) {
                    mperfiles.select(4);
                }

                mperfiles.setEnabled(false);

                mperfiles.addBlurListener(new FieldEvents.BlurListener() {
                    @Override
                    public void blur(FieldEvents.BlurEvent event) {
                        if (mperfiles.getValue() == null || mperfiles.getValue().equals("")) {
                            mperfiles.setComponentError(new UserError(""));
                            errper.setValue("Este campo es requerido");
                        } else {
                            mperfiles.setComponentError(null);
                            errper.setValue("");
                        }
                        ValidarError();
                    }
                });

                mestado.setTextInputAllowed(false);
                mestado.setNullSelectionAllowed(false);
                mestado.addItem("");
                mestado.setItemCaption("", "Seleccione");
                mestado.addItem(1);
                mestado.setItemCaption(1, "Activo");
                mestado.addItem(2);
                mestado.setItemCaption(2, "Inactivo");
                mestado.addItem(3);
                mestado.setItemCaption(3, "Bloqueado");

                if (est.equals("Activo")) {
                    mestado.select(1);
                } else if (est.equals("Inactivo")) {
                    mestado.select(2);
                } else if (est.equals("Bloqueado")) {
                    mestado.select(3);
                }

                mestado.setEnabled(true);

                mestado.addBlurListener(new FieldEvents.BlurListener() {
                    @Override
                    public void blur(FieldEvents.BlurEvent event) {
                        if (mestado.getValue() == null || mestado.getValue().equals("")) {
                            mestado.setComponentError(new UserError(""));
                            errest.setValue("Este campo es requerido");
                        } else {
                            mestado.setComponentError(null);
                            errest.setValue("");
                        }
                        ValidarError();
                    }
                });

                vlInv.setSpacing(true);
                Label esp4 = new Label("");
                Label per = new Label("Perfiles:");
                vlInv.addComponent(esp4, 0, 15);
                vlInv.addComponent(per, 0, 16);
                asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 1, 16);
                vlInv.addComponent(mperfiles, 2, 16);
                vlInv.setSpacing(true);
                Label est = new Label("Estado:");
                vlInv.addComponent(est, 3, 16);
                asteriscos = new Label("*");
                asteriscos.setStyleName("asterix");
                vlInv.addComponent(asteriscos, 4, 16);
                vlInv.addComponent(mestado, 5, 16);

                errper.setStyleName("lblerrores");
                vlInv.addComponent(errper, 2, 17);

                errest.setStyleName("lblerrores");
                vlInv.addComponent(errest, 5, 17);
        //Ip's
        Label ipLabel = new Label("Direcciones IP autorizadas:");        
        vlInv.addComponent(ipLabel,0,18);
        vlInv.addComponent(ip1,2,18);
        ip1.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                
                 if (ip1.getValue().equals("")) {
                        ip1.setComponentError(new UserError(""));
                        errIp1.setValue("Este campo es requerido");
                    } else {
                if (!ip1.getValue().equals("")) {
                    if (ip1.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip1.setComponentError(null);
                        errIp1.setValue("");
                    } else {
                        ip1.setComponentError(new UserError(""));
                        errIp1.setValue("Dirección Ip inválida");
                    }                                           
                } else {
                            ip1.setComponentError(null);
                            errIp1.setValue("");
                        }
               }
                ValidarError();
            }
        });
        errIp1.setStyleName("lblerrores");
        vlInv.addComponent(errIp1,2,19);
        
        
        
        vlInv.addComponent(ip2,3,18);
        ip2.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip2.getValue().equals("")) {
                    if (ip2.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip2.setComponentError(null);
                        errIp2.setValue("");
                    } else {
                        ip2.setComponentError(new UserError(""));
                        errIp2.setValue("Dirección Ip inválida");
                    }
                } else {
                            ip2.setComponentError(null);
                            errIp2.setValue("");
                        }
                ValidarError();
            }
        });
        errIp2.setStyleName("lblerrores");
        vlInv.addComponent(errIp2,3,19);

        vlInv.addComponent(ip3,5,18);
        ip3.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip3.getValue().equals("")) {
                    if (ip3.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip3.setComponentError(null);
                        errIp3.setValue("");
                    } else {
                        ip3.setComponentError(new UserError(""));
                        errIp3.setValue("Dirección Ip inválida");
                    }
                } else {
                            ip3.setComponentError(null);
                            errIp3.setValue("");
                        }
                ValidarError();
            }
        });
        errIp3.setStyleName("lblerrores");
        vlInv.addComponent(errIp3,5,19);

        vlInv.addComponent(ip4,2,20);
        ip4.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip4.getValue().equals("")) {
                    if (ip4.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip4.setComponentError(null);
                        errIp4.setValue("");
                    } else {
                        ip4.setComponentError(new UserError(""));
                        errIp4.setValue("Dirección Ip inválida");
                    }
                } else {
                            ip4.setComponentError(null);
                            errIp4.setValue("");
                        }
                ValidarError();
            }
        });
        errIp4.setStyleName("lblerrores");
        vlInv.addComponent(errIp4,2,21);

        vlInv.addComponent(ip5,3,20);
        ip5.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip5.getValue().equals("")) {
                    if (ip5.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip5.setComponentError(null);
                        errIp5.setValue("");
                    } else {
                        ip5.setComponentError(new UserError(""));
                        errIp5.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip5.setComponentError(null);
                            errIp5.setValue("");
                        }
                ValidarError();
            }
        });
        errIp5.setStyleName("lblerrores");
        vlInv.addComponent(errIp5,3,21);

        vlInv.addComponent(ip6,5,20);
        ip6.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip6.getValue().equals("")) {
                    if (ip6.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip6.setComponentError(null);
                        errIp6.setValue("");
                    } else {
                        ip6.setComponentError(new UserError(""));
                        errIp6.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip6.setComponentError(null);
                            errIp6.setValue("");
                        }
                ValidarError();
            }
        });
        errIp6.setStyleName("lblerrores");
        vlInv.addComponent(errIp6,5,21);

        vlInv.addComponent(ip7,2,22);
        ip7.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip7.getValue().equals("")) {
                    if (ip7.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip7.setComponentError(null);
                        errIp7.setValue("");
                    } else {
                        ip7.setComponentError(new UserError(""));
                        errIp7.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip7.setComponentError(null);
                            errIp7.setValue("");
                        }
                ValidarError();
            }
        });
        errIp7.setStyleName("lblerrores");
        vlInv.addComponent(errIp7,2,23);

        vlInv.addComponent(ip8,3,22);
        ip8.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip8.getValue().equals("")) {
                    if (ip8.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip8.setComponentError(null);
                        errIp8.setValue("");
                    } else {
                        ip8.setComponentError(new UserError(""));
                        errIp8.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip8.setComponentError(null);
                            errIp8.setValue("");
                        }
                ValidarError();
            }
        });
        errIp8.setStyleName("lblerrores");
        vlInv.addComponent(errIp8,3,23);

        vlInv.addComponent(ip9,5,22);
        ip9.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip9.getValue().equals("")) {
                    if (ip9.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip9.setComponentError(null);
                        errIp9.setValue("");
                    } else {
                        ip9.setComponentError(new UserError(""));
                        errIp9.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip9.setComponentError(null);
                            errIp9.setValue("");
                        }
                ValidarError();
            }
        });
        errIp9.setStyleName("lblerrores");
        vlInv.addComponent(errIp9,5,23);

        vlInv.addComponent(ip10,2,24);
        ip10.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip10.getValue().equals("")) {
                    if (ip10.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip10.setComponentError(null);
                        errIp10.setValue("");
                    } else {
                        ip10.setComponentError(new UserError(""));
                        errIp10.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip10.setComponentError(null);
                            errIp10.setValue("");
                        }
                ValidarError();
            }
        });
        errIp10.setStyleName("lblerrores");
        vlInv.addComponent(errIp10,2,25);

        vlInv.addComponent(ip11,3,24);
        ip11.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip11.getValue().equals("")) {
                    if (ip11.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip11.setComponentError(null);
                        errIp11.setValue("");
                    } else {
                        ip11.setComponentError(new UserError(""));
                        errIp11.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip11.setComponentError(null);
                            errIp11.setValue("");
                        }
                ValidarError();
            }
        });
        errIp11.setStyleName("lblerrores");
        vlInv.addComponent(errIp11,3,25);

        vlInv.addComponent(ip12,5,24);
        ip12.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip12.getValue().equals("")) {
                    if (ip12.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip12.setComponentError(null);
                        errIp12.setValue("");
                    } else {
                        ip12.setComponentError(new UserError(""));
                        errIp12.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip12.setComponentError(null);
                            errIp12.setValue("");
                        }
                ValidarError();
            }
        });
        errIp12.setStyleName("lblerrores");
        vlInv.addComponent(errIp12,5,25);

        vlInv.addComponent(ip13,2,26);
        ip13.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip13.getValue().equals("")) {
                    if (ip13.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip13.setComponentError(null);
                        errIp13.setValue("");
                    } else {
                        ip13.setComponentError(new UserError(""));
                        errIp13.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip13.setComponentError(null);
                            errIp13.setValue("");
                        }
                ValidarError();
            }
        });
        errIp13.setStyleName("lblerrores");
        vlInv.addComponent(errIp13,2,27);

        vlInv.addComponent(ip14,3,26);
        ip14.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip14.getValue().equals("")) {
                    if (ip14.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip14.setComponentError(null);
                        errIp14.setValue("");
                    } else {
                        ip14.setComponentError(new UserError(""));
                        errIp14.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip14.setComponentError(null);
                            errIp14.setValue("");
                        }
                ValidarError();
            }
        });
        errIp14.setStyleName("lblerrores");
        vlInv.addComponent(errIp14,3,27);

        vlInv.addComponent(ip15,5,26);
        ip15.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip15.getValue().equals("")) {
                    if (ip15.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip15.setComponentError(null);
                        errIp15.setValue("");
                    } else {
                        ip15.setComponentError(new UserError(""));
                        errIp15.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip15.setComponentError(null);
                            errIp15.setValue("");
                        }
                ValidarError();
            }
        });
        errIp15.setStyleName("lblerrores");
        vlInv.addComponent(errIp15,5,27);
        
        vlInv.addComponent(ip16,2,28);
        ip16.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip16.getValue().equals("")) {
                    if (ip16.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip16.setComponentError(null);
                        errIp16.setValue("");
                    } else {
                        ip16.setComponentError(new UserError(""));
                        errIp16.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip16.setComponentError(null);
                            errIp16.setValue("");
                        }
                ValidarError();
            }
        });
        errIp16.setStyleName("lblerrores");
        vlInv.addComponent(errIp16,2,29);
        
        vlInv.addComponent(ip17,3,28);
        ip17.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip17.getValue().equals("")) {
                    if (ip17.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip17.setComponentError(null);
                        errIp17.setValue("");
                    } else {
                        ip17.setComponentError(new UserError(""));
                        errIp17.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip17.setComponentError(null);
                            errIp17.setValue("");
                        }
                ValidarError();
            }
        });
        errIp17.setStyleName("lblerrores");
        vlInv.addComponent(errIp17,3,29);
        
        vlInv.addComponent(ip18,5,28);
        ip18.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip18.getValue().equals("")) {
                    if (ip18.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip18.setComponentError(null);
                        errIp18.setValue("");
                    } else {
                        ip18.setComponentError(new UserError(""));
                        errIp18.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip18.setComponentError(null);
                            errIp18.setValue("");
                        }
                ValidarError();
            }
        });
        errIp18.setStyleName("lblerrores");
        vlInv.addComponent(errIp18,5,29);
        
        vlInv.addComponent(ip19,2,30);
        ip19.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip19.getValue().equals("")) {
                    if (ip19.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip19.setComponentError(null);
                        errIp19.setValue("");
                    } else {
                        ip19.setComponentError(new UserError(""));
                        errIp19.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip19.setComponentError(null);
                            errIp19.setValue("");
                        }
                ValidarError();
            }
        });
        errIp19.setStyleName("lblerrores");
        vlInv.addComponent(errIp19,2,31);
        
        vlInv.addComponent(ip20,3,30);
        ip20.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip20.getValue().equals("")) {
                    if (ip20.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip20.setComponentError(null);
                        errIp20.setValue("");
                    } else {
                        ip20.setComponentError(new UserError(""));
                        errIp20.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip20.setComponentError(null);
                            errIp20.setValue("");
                        }
                ValidarError();
            }
        });
        errIp20.setStyleName("lblerrores");
        vlInv.addComponent(errIp20,3,31);
        
        vlInv.addComponent(ip21,5,30);
        ip21.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip21.getValue().equals("")) {
                    if (ip21.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip21.setComponentError(null);
                        errIp21.setValue("");
                    } else {
                        ip21.setComponentError(new UserError(""));
                        errIp21.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip21.setComponentError(null);
                            errIp21.setValue("");
                        }
                ValidarError();
            }
        });
        errIp21.setStyleName("lblerrores");
        vlInv.addComponent(errIp21,5,31);
        
        vlInv.addComponent(ip22,2,32);
        ip22.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip22.getValue().equals("")) {
                    if (ip22.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip22.setComponentError(null);
                        errIp22.setValue("");
                    } else {
                        ip22.setComponentError(new UserError(""));
                        errIp22.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip22.setComponentError(null);
                            errIp22.setValue("");
                        }
                ValidarError();
            }
        });
        errIp22.setStyleName("lblerrores");
        vlInv.addComponent(errIp22,2,33);
        
        vlInv.addComponent(ip23,3,32);
        ip23.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip23.getValue().equals("")) {
                    if (ip23.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip23.setComponentError(null);
                        errIp23.setValue("");
                    } else {
                        ip23.setComponentError(new UserError(""));
                        errIp23.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip23.setComponentError(null);
                            errIp23.setValue("");
                        }
                ValidarError();
            }
        });
        errIp23.setStyleName("lblerrores");
        vlInv.addComponent(errIp23,3,33);
        
        vlInv.addComponent(ip24,5,32);
        ip24.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip24.getValue().equals("")) {
                    if (ip24.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip24.setComponentError(null);
                        errIp24.setValue("");
                    } else {
                        ip24.setComponentError(new UserError(""));
                        errIp24.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip24.setComponentError(null);
                            errIp24.setValue("");
                        }
                ValidarError();
            }
        });
        errIp24.setStyleName("lblerrores");
        vlInv.addComponent(errIp24,5,33);
        
        vlInv.addComponent(ip25,2,34);
        ip25.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip25.getValue().equals("")) {
                    if (ip25.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip25.setComponentError(null);
                        errIp25.setValue("");
                    } else {
                        ip25.setComponentError(new UserError(""));
                        errIp25.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip25.setComponentError(null);
                            errIp25.setValue("");
                        }
                ValidarError();
            }
        });
        errIp25.setStyleName("lblerrores");
        vlInv.addComponent(errIp25,2,35);
        
        vlInv.addComponent(ip26,3,34);
        ip26.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip26.getValue().equals("")) {
                    if (ip26.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip26.setComponentError(null);
                        errIp26.setValue("");
                    } else {
                        ip26.setComponentError(new UserError(""));
                        errIp26.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip26.setComponentError(null);
                            errIp26.setValue("");
                        }
                ValidarError();
            }
        });
        errIp26.setStyleName("lblerrores");
        vlInv.addComponent(errIp26,3,35);
        
        vlInv.addComponent(ip27,5,34);
        ip27.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip27.getValue().equals("")) {
                    if (ip27.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip27.setComponentError(null);
                        errIp27.setValue("");
                    } else {
                        ip27.setComponentError(new UserError(""));
                        errIp27.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip27.setComponentError(null);
                            errIp27.setValue("");
                        }
                ValidarError();
            }
        });
        errIp27.setStyleName("lblerrores");
        vlInv.addComponent(errIp27,5,35);
        
        vlInv.addComponent(ip28,2,36);
        ip28.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip28.getValue().equals("")) {
                    if (ip28.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip28.setComponentError(null);
                        errIp28.setValue("");
                    } else {
                        ip28.setComponentError(new UserError(""));
                        errIp28.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip28.setComponentError(null);
                            errIp28.setValue("");
                        }
                ValidarError();
            }
        });
        errIp28.setStyleName("lblerrores");
        vlInv.addComponent(errIp28,2,37);
        
        vlInv.addComponent(ip29,3,36);
        ip29.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip29.getValue().equals("")) {
                    if (ip29.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip29.setComponentError(null);
                        errIp29.setValue("");
                    } else {
                        ip29.setComponentError(new UserError(""));
                        errIp29.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip29.setComponentError(null);
                            errIp29.setValue("");
                        }
                ValidarError();
            }
        });
        errIp29.setStyleName("lblerrores");
        vlInv.addComponent(errIp29,3,37);
        
        vlInv.addComponent(ip30,5,36);
        ip30.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip30.getValue().equals("")) {
                    if (ip30.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip30.setComponentError(null);
                        errIp30.setValue("");
                    } else {
                        ip30.setComponentError(new UserError(""));
                        errIp30.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip30.setComponentError(null);
                            errIp30.setValue("");
                        }
                ValidarError();
            }
        });
        errIp30.setStyleName("lblerrores");
        vlInv.addComponent(errIp30,5,37);
        
        vlInv.addComponent(ip31,2,38);
        ip31.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip31.getValue().equals("")) {
                    if (ip31.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip31.setComponentError(null);
                        errIp31.setValue("");
                    } else {
                        ip31.setComponentError(new UserError(""));
                        errIp31.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip31.setComponentError(null);
                            errIp31.setValue("");
                        }
                ValidarError();
            }
        });
        errIp31.setStyleName("lblerrores");
        vlInv.addComponent(errIp31,2,39);
        
        vlInv.addComponent(ip32,3,38);
        ip32.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip32.getValue().equals("")) {
                    if (ip32.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip32.setComponentError(null);
                        errIp32.setValue("");
                    } else {
                        ip32.setComponentError(new UserError(""));
                        errIp32.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip32.setComponentError(null);
                            errIp32.setValue("");
                        }
                ValidarError();
            }
        });
        errIp32.setStyleName("lblerrores");
        vlInv.addComponent(errIp32,3,39);
        
        vlInv.addComponent(ip33,5,38);
        ip33.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip33.getValue().equals("")) {
                    if (ip33.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip33.setComponentError(null);
                        errIp33.setValue("");
                    } else {
                        ip33.setComponentError(new UserError(""));
                        errIp33.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip33.setComponentError(null);
                            errIp33.setValue("");
                        }
                ValidarError();
            }
        });
        errIp33.setStyleName("lblerrores");
        vlInv.addComponent(errIp33,5,39);
        
        vlInv.addComponent(ip34,2,40);
        ip34.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip34.getValue().equals("")) {
                    if (ip34.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip34.setComponentError(null);
                        errIp34.setValue("");
                    } else {
                        ip34.setComponentError(new UserError(""));
                        errIp34.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip34.setComponentError(null);
                            errIp34.setValue("");
                        }
                ValidarError();
            }
        });
        errIp34.setStyleName("lblerrores");
        vlInv.addComponent(errIp34,2,41);
        
        vlInv.addComponent(ip35,3,40);
        ip35.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip35.getValue().equals("")) {
                    if (ip35.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip35.setComponentError(null);
                        errIp35.setValue("");
                    } else {
                        ip35.setComponentError(new UserError(""));
                        errIp35.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip35.setComponentError(null);
                            errIp35.setValue("");
                        }
                ValidarError();
            }
        });
        errIp35.setStyleName("lblerrores");
        vlInv.addComponent(errIp35,3,41);
        
        vlInv.addComponent(ip36,5,40);
        ip36.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip36.getValue().equals("")) {
                    if (ip36.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip36.setComponentError(null);
                        errIp36.setValue("");
                    } else {
                        ip36.setComponentError(new UserError(""));
                        errIp36.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip36.setComponentError(null);
                            errIp36.setValue("");
                        }
                ValidarError();
            }
        });
        errIp36.setStyleName("lblerrores");
        vlInv.addComponent(errIp36,5,41);
        
        vlInv.addComponent(ip37,2,42);
        ip37.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip37.getValue().equals("")) {
                    if (ip37.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip37.setComponentError(null);
                        errIp17.setValue("");
                    } else {
                        ip37.setComponentError(new UserError(""));
                        errIp37.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip37.setComponentError(null);
                            errIp37.setValue("");
                        }
                ValidarError();
            }
        });
        errIp37.setStyleName("lblerrores");
        vlInv.addComponent(errIp37,2,43);
        
        vlInv.addComponent(ip38,3,42);
        ip38.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip38.getValue().equals("")) {
                    if (ip38.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip38.setComponentError(null);
                        errIp38.setValue("");
                    } else {
                        ip38.setComponentError(new UserError(""));
                        errIp38.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip38.setComponentError(null);
                            errIp38.setValue("");
                        }
                ValidarError();
            }
        });
        errIp38.setStyleName("lblerrores");
        vlInv.addComponent(errIp38,3,43);
        
        vlInv.addComponent(ip39,5,42);
        ip39.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip39.getValue().equals("")) {
                    if (ip39.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip39.setComponentError(null);
                        errIp39.setValue("");
                    } else {
                        ip39.setComponentError(new UserError(""));
                        errIp39.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip39.setComponentError(null);
                            errIp39.setValue("");
                        }
                ValidarError();
            }
        });
        errIp39.setStyleName("lblerrores");
        vlInv.addComponent(errIp39,5,43);
        
        vlInv.addComponent(ip40,2,44);
        ip40.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (!ip40.getValue().equals("")) {
                    if (ip40.getValue().matches(regexIp)) {
                        //Aqui agregar condicional de busqueda de datos de login ya existente
                        ip40.setComponentError(null);
                        errIp40.setValue("");
                    } else {
                        ip40.setComponentError(new UserError(""));
                        errIp40.setValue("Dirección Ip inválida");
                    }
                }else {
                            ip40.setComponentError(null);
                            errIp40.setValue("");
                        }
                ValidarError();
            }
        });
        errIp40.setStyleName("lblerrores");
        vlInv.addComponent(errIp40,2,45);

                final Button modificar = new Button("Modificar");
                final Button cancelar = new Button("Cancelar");

                cancelar.addClickListener(new Button.ClickListener() {
                    private static final long serialVersionUID = 1L;

                    public void buttonClick(ClickEvent event) {

                        modUsuarios.close();
                        grid.select(null);
                        Limpiar();
                        select = 0;
                        controladorEve1 = 0;
                        error.setValue("");
                    }
                });

                modUsuarios.addCloseListener(new Window.CloseListener() {

                    @Override
                    public void windowClose(Window.CloseEvent e) {

                        grid.select(null);
                        Limpiar();
                        select = 0;
                        controladorEve1 = 0;
                        error.setValue("");
                    }
                });

                vlInv.addComponent(modificar, 0, 45);

                vlInv.addComponent(cancelar, 1, 45);

                HorizontalLayout h = new HorizontalLayout();
                h.addComponents(modificar, cancelar);
                error.setStyleName("lblErrorVer");
                h.addComponent(error);
                cancelar.addStyleName("ButtCancelar");
                vl.addComponents(vlInv, h);
                h.addStyleName("horizontal1");
                vl.setComponentAlignment(h, Alignment.MIDDLE_CENTER);
                

                modificar.addClickListener(new Button.ClickListener() {

                    @Override
                    public void buttonClick(Button.ClickEvent event) {

                        try {
                            combo = (Integer) mcmb.getValue();
                        } catch (NullPointerException e) {
                            combo = 0;
                        } catch (ClassCastException ex) {
                            combo = 0;
                        }

                        try {
                            comboPer = (Integer) mperfiles.getValue();
                        } catch (NullPointerException e) {
                            comboPer = 0;
                        } catch (ClassCastException ex) {
                            comboPer = 0;
                        }

                        try {
                            comboEst = (Integer) mestado.getValue();
                        } catch (NullPointerException e) {
                            comboEst = 0;
                        } catch (ClassCastException ex) {
                            comboEst = 0;
                        }
                        try {
                            comboScb = (Integer) scb.getValue();
                        } catch (NullPointerException e) {
                            comboScb = 0;
                        } catch (ClassCastException ex) {
                            comboScb = 0;
                        }

                        if (combo == 0) {
                            mcmb.setComponentError(new UserError(""));
                            errIdcmb.setValue("Este campo es requerido");
                        }
                        if (mnumDoc.getValue().equals("")) {
                            mnumDoc.setComponentError(new UserError(""));
                            errnumDoc.setValue("Este campo es requerido");
                        }
                        if (mnombres.getValue().equals("")) {
                            mnombres.setComponentError(new UserError(""));
                            errnombre.setValue("Este campo es requerido");
                        }
                        if (mapellidos.getValue().equals("")) {
                            mapellidos.setComponentError(new UserError(""));
                            errape.setValue("Este campo es requerido");
                        }
                        if (mcorreo.getValue().equals("")) {
                            mcorreo.setComponentError(new UserError(""));
                            erracorre.setValue("Este campo es requerido");
                        }
                        if (mlogin.getValue().equals("")) {
                            mlogin.setComponentError(new UserError(""));
                            errlog.setValue("Este campo es requerido");
                        }
                        if (mclave.getValue().equals("")) {
                            if (bCambioClave) {
                            mclave.setComponentError(new UserError(""));
                            errcla.setValue("Este campo es requerido");
                            }
                        }
                        if (mverclave.getValue().equals("")) {
                            if (bCambioClave) {
                            mverclave.setComponentError(new UserError(""));
                            errvercla.setValue("Este campo es requerido");
                            }
                        }
                        if (comboPer == 0) {
                            mperfiles.setComponentError(new UserError(""));
                            errper.setValue("Este campo es requerido");
                        }
                        if (comboEst == 0) {
                            mestado.setComponentError(new UserError(""));
                            errest.setValue("Este campo es requerido");
                        }
                        if (comboScb == 0) {
                            scb.setComponentError(new UserError(""));
                            errscb.setValue("Este campo es requerido");
                        }
                        if (ip1.getValue().equals("")) {
                            ip1.setComponentError(new UserError(""));
                            errIp1.setValue("Este campo es requerido");
                        }
                        ValidarError();
                        if (!ValidaComponentError()) {
                            Usuario usu = new Usuario();
                            String est = "";

                            usu.setId(Integer.parseInt(idUsu));
                            usu.setNombres(mnombres.getValue());
                            usu.setApellidos(mapellidos.getValue());

                            String tipD = "";
                            if (mcmb.getValue().toString().equals("1")) {
                                tipD = "CC";
                            } else if (mcmb.getValue().toString().equals("2")) {
                                tipD = "CE";
                            } else if (mcmb.getValue().toString().equals("3")) {
                                tipD = "PAS";
                            }

                            usu.setTipoIdentificacion(tipD);
                            usu.setIdentificacion(mnumDoc.getValue());
                            usu.setEmail(mcorreo.getValue());
                            usu.setUsername(mlogin.getValue());
                            usu.setPassword(mclave.getValue());

                            if (PerfilActual.equals("Riesgos")) { ///////////////////////////////////////////////////////////cuando guardaaaaaaaaaaaa
                                usu.setSbolsa(Integer.parseInt(scb.getValue().toString()));
                            } else {
                                usu.setSbolsa(Integer.parseInt(IdsocBol));
                            }

                            if (mestado.getValue().toString().equals("1")) {
                                est = "A";
                            } else if (mestado.getValue().toString().equals("2")) {
                                est = "I";
                            } else if (mestado.getValue().toString().equals("3")) {
                                est = "B";
                            }
                            
                            String nomUsuario = userDetailsService.getUsuarioAutenticado().getUsername();
                            usu.setUsuariosistemaultimamod(nomUsuario);
                            
                            String tipomodificacion = "Modificación Usuario - Modificación";
                            usu.setTipomodificacion(tipomodificacion);

                            usu.setEstado(est);

                            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                            HttpServletRequest req = attr.getRequest();
                            Auditoria au = new Auditoria();
                            // AJUSTE IP REGISTRADA
                            //au.setIp(req.getRemoteAddr());
                            String remoteAddr = req.getHeader("X-Forwarded-For");
                            if (remoteAddr == null || "".equals(remoteAddr)) {
                                au.setIp(req.getRemoteAddr());
                            } else {
                                String ips[] = remoteAddr.split(",");
                                remoteAddr = ips[0];
                                au.setIp(remoteAddr);
                            }
                            //au.setIp(req.getHeader("X-Forwarded-For"));

                            logger.debug("OPA - REMOTEADDR_" + req.getRemoteAddr() + "x-forwarded-For_" + req.getHeader("X-Forwarded-For") + "IP:" + remoteAddr);

                            // 
                            au.setId_user(userDetailsService.getUsuarioAutenticado().getId());
//Crea la lista de Ips
                            ArrayList<IpAutorizada> ipsAutorizadas = new ArrayList<IpAutorizada>();
                            IpAutorizada a = null;
                            if (!ip1.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip1.getValue(), userDetailsService.getUsuarioAutenticado().getUsername(), "Ingreso IP - Modificación");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip2.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip2.getValue(), userDetailsService.getUsuarioAutenticado().getUsername(), "Ingreso IP - Modificación");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip3.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip3.getValue(), userDetailsService.getUsuarioAutenticado().getUsername(), "Ingreso IP - Modificación");
                                ipsAutorizadas.add(a);
                            }

                             if (!ip4.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip4.getValue(), userDetailsService.getUsuarioAutenticado().getUsername(), "Ingreso IP - Modificación");
                                ipsAutorizadas.add(a);
                            }

                            if (!ip5.getValue().equals("")) {
                                 a = new IpAutorizada(new Integer(0), ip5.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                             }
                            if (!ip6.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip6.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                             if (!ip7.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip7.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip8.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip8.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip9.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip9.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip10.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip10.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip11.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip11.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip12.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip12.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip13.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip13.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip14.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip14.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip15.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip15.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip16.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip16.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip17.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip17.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip18.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip18.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip19.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip19.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip20.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip20.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip21.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip21.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip22.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip22.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip23.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip23.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip24.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip24.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip25.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip25.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip26.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip26.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip27.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip27.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip28.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip28.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip29.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip29.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip30.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip30.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip31.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip31.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip32.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip32.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip33.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip33.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip34.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip34.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip35.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip35.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip36.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip36.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip37.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip37.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip38.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip38.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip39.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip39.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                            if (!ip40.getValue().equals("")) {
                                a = new IpAutorizada(new Integer(0), ip40.getValue(), nomUsuario, "Ingreso IP - Inserción");
                                ipsAutorizadas.add(a);
                            }
                         
                            usu = userDetailsService.saveUsuario(usu, au, mperfiles.getValue().toString(),ipsAutorizadas);

                            if (usu != null) {
                                Notification notif = new Notification(
                                        "Confirmación",
                                        "Usuario modificado satisfactoriamente",
                                        Notification.Type.HUMANIZED_MESSAGE);

                               notif.setDelayMsec(40000);

                                notif.show(Page.getCurrent());
                                modUsuarios.close();
                                grid.getSelectedRows().clear();
                                grid.getContainerDataSource().removeAllItems();
                                List<List<String>> listUsuarios = facade.Retornarusuarios();
                                
                                String estado="";
                                for (int i = 0; i < listUsuarios.get(0).size(); i++) {
                                    if (listUsuarios.get(11).get(i).equals("A")) {
                                        estado = "Activo";
                                    } else if (listUsuarios.get(11).get(i).equals("I")) {
                                        estado = "Inactivo";
                                    } else if (listUsuarios.get(11).get(i).equals("B")) {
                                        estado = "Bloqueado";
                                    }
                                    
                                    //Lsierra 2016-04-08 Mantis 2515
                                    /*String scb = listUsuarios.get(18).get(i);
                                    String[] list = scb.split("-");
                                    String codigosc = list[0];*/

                                      grid.addRow(listUsuarios.get(0).get(i), listUsuarios.get(6).get(i), listUsuarios.get(7).get(i), listUsuarios.get(3).get(i), listUsuarios.get(4).get(i), listUsuarios.get(18).get(i), listUsuarios.get(1).get(i), listUsuarios.get(17).get(i), estado, listUsuarios.get(5).get(i));
                                    //grid.addRow(listUsuarios.get(0).get(i), listUsuarios.get(6).get(i), listUsuarios.get(7).get(i), listUsuarios.get(3).get(i), listUsuarios.get(4).get(i), listUsuarios.get(16).get(i), listUsuarios.get(1).get(i), listUsuarios.get(17).get(i), listUsuarios.get(11).get(i), listUsuarios.get(5).get(i));
                                }
                            } else {
                                Notification.show("Hubo un error en la modificacion del usuario", Notification.Type.ERROR_MESSAGE);
                            }
                        }
                        controladorEve1 = 0;
                    }
                });
            }

        }
        vl.addStyleName("StylegridLa");
        modUsuarios.setContent(vl);
        modUsuarios.show(UI.getCurrent(), null, true);
        modUsuarios.setWidth(900, Sizeable.Unit.PIXELS);
        modUsuarios.setHeight(650, Sizeable.Unit.PIXELS);

        return modUsuarios;

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
            if (TP.getTipodocumento() == 1 || TP.getTipodocumento() == 2 || TP.getTipodocumento() == 3) {
                combo.addItem(TP.getTipodocumento());
                combo.setItemCaption(TP.getTipodocumento(), TP.getNombredoc());
            }
        }
        return combo;
    }

    public ComboBox LlenarTipoPerfiles() {

        Iterator<Perfil> LPerfil = null;
        LPerfil = facade.RetornarPerfiles().iterator();
        Perfil Pe = null;
        ComboBox combo = new ComboBox();
        combo.setTextInputAllowed(false);
        combo.setNullSelectionAllowed(false);
        combo.addItem("");
        combo.setItemCaption("", "Seleccione");
        while (LPerfil.hasNext()) {
            Pe = LPerfil.next();
            combo.addItem(Pe.getPerfil());
            combo.setItemCaption(Pe.getPerfil(), Pe.getNombre());
        }
        return combo;
    }

    public ComboBox LlenarSCB() {

        Iterator<SCB> LSCB = null;
        LSCB = facade.RetornarSCB().iterator();
        SCB sc = null;
        scb.setTextInputAllowed(false);
        scb.setNullSelectionAllowed(false);
        scb.addItem("");
        scb.setItemCaption("", "Seleccione");
        while (LSCB.hasNext()) {
            sc = LSCB.next();
            scb.addItem(sc.getIdScb());
            scb.setItemCaption(sc.getIdScb(), sc.getCodigoEntidad()+" - "+sc.getRazonSocial());
        }
        return scb;
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
        if (cmb.getComponentError() != null || numDoc.getComponentError() != null) {
            return true;
        }
        if (nombres.getComponentError() != null || apellidos.getComponentError() != null) {
            return true;
        }
        if (correo.getComponentError() != null || login.getComponentError() != null) {
            return true;
        }
        if (clave.getComponentError() != null || verclave.getComponentError() != null) {
            return true;
        }
        if (perfiles.getComponentError() != null || Cbxestado.getComponentError() != null) {
            return true;
        }
        if (mcmb.getComponentError() != null || mnumDoc.getComponentError() != null) {
            return true;
        }
        if (mnombres.getComponentError() != null || mapellidos.getComponentError() != null) {
            return true;
        }
        if (mcorreo.getComponentError() != null || mlogin.getComponentError() != null) {
            return true;
        }
        if (mclave.getComponentError() != null || mverclave.getComponentError() != null) {
            if (bCambioClave)
               return true;
            else 
               return false;
        }
        if (mperfiles.getComponentError() != null || mestado.getComponentError() != null) {
            return true;
        }
        if (scb.getComponentError() != null) {
            return true;
        }
        if (ip1.getComponentError() != null || ip2.getComponentError() != null || ip3.getComponentError() != null || ip4.getComponentError() != null
            || ip5.getComponentError() != null || ip6.getComponentError() != null || ip7.getComponentError() != null || ip8.getComponentError() != null
            || ip9.getComponentError() != null || ip10.getComponentError() != null || ip11.getComponentError() != null || ip12.getComponentError() != null
            || ip13.getComponentError() != null || ip14.getComponentError() != null || ip15.getComponentError() != null || ip16.getComponentError() != null
            || ip17.getComponentError() != null || ip18.getComponentError() != null || ip19.getComponentError() != null || ip20.getComponentError() != null
            || ip21.getComponentError() != null || ip22.getComponentError() != null || ip23.getComponentError() != null || ip24.getComponentError() != null
            || ip25.getComponentError() != null || ip26.getComponentError() != null || ip27.getComponentError() != null || ip28.getComponentError() != null
            || ip29.getComponentError() != null || ip30.getComponentError() != null || ip31.getComponentError() != null || ip32.getComponentError() != null
            || ip33.getComponentError() != null || ip34.getComponentError() != null || ip35.getComponentError() != null || ip36.getComponentError() != null
            || ip37.getComponentError() != null || ip38.getComponentError() != null || ip39.getComponentError() != null || ip40.getComponentError() != null) {
            return true;
        }
        return errores;
    }

    public void Limpiar() {
        errIdcmb.setValue("");
        errnumDoc.setValue("");
        errnombre.setValue("");
        errape.setValue("");
        erracorre.setValue("");
        errlog.setValue("");
        errcla.setValue("");
        errvercla.setValue("");
        errper.setValue("");
        errest.setValue("");
        errscb.setValue("");
        errIp1.setValue("");
        errIp2.setValue("");
        errIp3.setValue("");
        errIp4.setValue("");
        errIp5.setValue("");
        errIp6.setValue("");
        errIp7.setValue("");
        errIp8.setValue("");
        errIp9.setValue("");
        errIp10.setValue("");
        errIp11.setValue("");
        errIp12.setValue("");
        errIp13.setValue("");
        errIp14.setValue("");
        errIp15.setValue("");
        errIp16.setValue("");
        errIp17.setValue("");
        errIp18.setValue("");
        errIp19.setValue("");
        errIp20.setValue("");
        errIp21.setValue("");
        errIp22.setValue("");
        errIp23.setValue("");
        errIp24.setValue("");
        errIp25.setValue("");
        errIp26.setValue("");
        errIp27.setValue("");
        errIp28.setValue("");
        errIp29.setValue("");
        errIp30.setValue("");
        errIp31.setValue("");
        errIp32.setValue("");
        errIp33.setValue("");
        errIp34.setValue("");
        errIp35.setValue("");
        errIp36.setValue("");
        errIp37.setValue("");
        errIp38.setValue("");
        errIp39.setValue("");
        errIp40.setValue("");

        numDoc.setValue("");
        numDoc.setComponentError(null);
        nombres.setValue("");
        nombres.setComponentError(null);
        apellidos.setValue("");
        apellidos.setComponentError(null);
        correo.setValue("");
        correo.setComponentError(null);
        login.setValue("");
        login.setComponentError(null);
        clave.setValue("");
        clave.setComponentError(null);
        verclave.setValue("");
        verclave.setComponentError(null);

        mnumDoc.setValue("");
        mnumDoc.setComponentError(null);
        mnombres.setValue("");
        mnombres.setComponentError(null);
        mapellidos.setValue("");
        mapellidos.setComponentError(null);
        mcorreo.setValue("");
        mcorreo.setComponentError(null);
        mlogin.setValue("");
        mlogin.setComponentError(null);
        mclave.setValue("");
        mclave.setComponentError(null);
        mverclave.setValue("");
        mverclave.setComponentError(null);
        ip1.setComponentError(null);
        ip1.setValue("");
        ip2.setComponentError(null);
        ip2.setValue("");
        ip3.setComponentError(null);
        ip3.setValue("");
        ip4.setComponentError(null);
        ip4.setValue("");
        ip5.setComponentError(null);
        ip5.setValue("");
        ip6.setComponentError(null);
        ip6.setValue("");
        ip7.setComponentError(null);
        ip7.setValue("");
        ip8.setComponentError(null);
        ip8.setValue("");
        ip9.setComponentError(null);
        ip9.setValue("");
        ip10.setComponentError(null);
        ip10.setValue("");
        ip11.setComponentError(null);
        ip11.setValue("");
        ip12.setComponentError(null);
        ip12.setValue("");
        ip13.setComponentError(null);
        ip13.setValue("");
        ip14.setComponentError(null);
        ip14.setValue("");
        ip15.setComponentError(null);
        ip15.setValue("");
        ip16.setComponentError(null);
        ip16.setValue("");
        ip17.setComponentError(null);
        ip17.setValue("");
        ip18.setComponentError(null);
        ip18.setValue("");
        ip19.setComponentError(null);
        ip19.setValue("");
        ip20.setComponentError(null);
        ip20.setValue("");
        ip21.setComponentError(null);
        ip21.setValue("");
        ip22.setComponentError(null);
        ip22.setValue("");
        ip23.setComponentError(null);
        ip23.setValue("");
        ip24.setComponentError(null);
        ip24.setValue("");
        ip25.setComponentError(null);
        ip25.setValue("");
        ip26.setComponentError(null);
        ip26.setValue("");
        ip27.setComponentError(null);
        ip27.setValue("");
        ip28.setComponentError(null);
        ip28.setValue("");
        ip29.setComponentError(null);
        ip29.setValue("");
        ip30.setComponentError(null);
        ip30.setValue("");
        ip31.setComponentError(null);
        ip31.setValue("");
        ip32.setComponentError(null);
        ip32.setValue("");
        ip33.setComponentError(null);
        ip33.setValue("");
        ip34.setComponentError(null);
        ip34.setValue("");
        ip35.setComponentError(null);
        ip35.setValue("");
        ip36.setComponentError(null);
        ip36.setValue("");
        ip37.setComponentError(null);
        ip37.setValue("");
        ip38.setComponentError(null);
        ip38.setValue("");
        ip39.setComponentError(null);
        ip39.setValue("");
        ip40.setComponentError(null);
        ip40.setValue("");
        cmb.select("");
        cmb.setComponentError(null);
        perfiles.select(" ");
        perfiles.setComponentError(null);
        Cbxestado.select("");
        Cbxestado.setComponentError(null);

        mcmb.select("");
        mcmb.setComponentError(null);
        mperfiles.select(" ");
        mperfiles.setComponentError(null);
        mestado.select("");
        mestado.setComponentError(null);
        scb.select("");
        scb.setComponentError(null);
    }

    public boolean validaLongitudContra(String cadena) {

        boolean longitud = false;

        if (cadena.length() < 8) {
            longitud = false;
        } else if (cadena.length() <= 15) {
            longitud = true;
        } else {
            longitud = false;
        }

        return longitud;
    }

    public boolean validaunaMayus(String cadena) {

        boolean mayuscula = false;

        int tamano = 0;

        while (tamano < cadena.length()) {

            for (int i = 0; i < regexMayus.length(); i++) {
                if (regexMayus.charAt(i) == cadena.charAt(tamano)) {
                    mayuscula = true;
                }

            }
            tamano++;
        }
        return mayuscula;
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

    public boolean validaunCaracter(String cadena) {

        boolean caracter = false;

        for (int i = 0; i < cadena.length(); i++) {
            if (!String.valueOf(cadena.charAt(i)).matches(regexAlpha)) {
                caracter = true;
                break;
            }
        }

        return caracter;
    }
    

    public boolean validaunNumero(String cadena) {

        boolean caracter = false;

        for (int i = 0; i < cadena.length(); i++) {
            if (String.valueOf(cadena.charAt(i)).matches(regexNumeric2)) {
                caracter = true;
                break;
            }
        }

        return caracter;
    }    

    public boolean validaPassAnteriores(String cadena) {

        boolean result = true;

        String password = userDetailsService.decript(cadena, "", userDetailsService.getUsuarioAutenticado(), 1);

        List<List<String>> passAnte = facade.RetornaPassusuarios(idUsu);

        for (int i = 0; i < passAnte.get(0).size(); i++) {
        String datos = userDetailsService.decript(passAnte.get(0).get(i), passAnte.get(3).get(i), userDetailsService.getUsuarioAutenticado(), 0);
            if (datos.equals(password)) {
               result = false;
            }

        }

        return result;
    }

    
    public boolean caracteresConsecutivos(String paaword){
            int i;
            int a;
            int c;
            int contador = 0;
            boolean result = true;
            
            try {
                for (i = 0; i < paaword.length(); i++) {
                   a = i + 1;
                   c = i + 2;
                    if (paaword.charAt(i) == paaword.charAt(a) &&  paaword.charAt(i) == paaword.charAt(c)) {
                            result = false;
                    }

                }

            } catch (Exception e) {

            }
        
            return result;
        }
        
   
    public boolean validarSecuen(String password) {

        boolean result = true;
        char[] abecedario;
        abecedario = new char[26];
        for (int i = 0; i < 26; i++) {
            abecedario[i] = (char) ('A' + i);
        }

        password = password.toUpperCase();
        for (int j = 0; j < password.length() - 2; j++) {
            char chrs = password.charAt(j);
            char valor = password.charAt(j + 1);
            if (!Character.isDigit(chrs) && !Character.isDigit(valor) && !Character.isDigit(password.charAt(j + 2))) {
                for (int i = 0; i < abecedario.length; i++) {
                    if (chrs == abecedario[i]) {
                        if( (i + 1) == abecedario.length){
                            break;
                        }  
                        if (valor == abecedario[i + 1]) {
                            if (password.charAt(j + 2) == abecedario[i + 2]) {
                                result = false;
                                break;
                            }
                        }
                    }
                }
            }
        }

        for (int j = 0; j < password.length() - 2; j++) {
            char chrs = password.charAt(j);
            char valor = password.charAt(j + 1);
            if (Character.isDigit(chrs) && Character.isDigit(valor) && Character.isDigit(password.charAt(j + 2))) {
                if (chrs + 1 == valor && valor + 1 == password.charAt(j + 2)) {
                    result = false;
                }
            }
        }
        return result;
    }
    
    public boolean validaLogin(String cadena) {
        boolean result = true;
        List<List<String>> logAnte = facade.RetornaLogin(cadena.toLowerCase());
        for (int i = 0; i < logAnte.get(0).size(); i++) {
            if (logAnte.get(0).get(i).equals((cadena.toLowerCase()))) {
                result = false;
            }
        }
        return result;
    }    
    
    private void llenarIps() {
        ArrayList ipAutorizadas=facade.traerIpAutorizada(Integer.parseInt(idUsu));
        ip1.clear();
        ip2.clear();
        ip3.clear();
        ip4.clear();
        ip5.clear();
        ip6.clear();
        ip7.clear();
        ip8.clear();
        ip9.clear();
        ip10.clear();
        ip11.clear();
        ip12.clear();
        ip13.clear();
        ip14.clear();
        ip15.clear();
        ip16.clear();
        ip17.clear();
        ip18.clear();
        ip19.clear();
        ip20.clear();
        ip21.clear();
        ip22.clear();
        ip23.clear();
        ip24.clear();
        ip25.clear();
        ip26.clear();
        ip27.clear();
        ip28.clear();
        ip29.clear();
        ip30.clear();
        ip31.clear();
        ip32.clear();
        ip33.clear();
        ip34.clear();
        ip35.clear();
        ip36.clear();
        ip37.clear();
        ip38.clear();
        ip39.clear();
        ip40.clear();

        int i=0;
        Iterator<IpAutorizada> myitera = ipAutorizadas.iterator();
        while (myitera.hasNext()) {
            IpAutorizada elemento = myitera.next();
            if (i == 0) {
                ip1.setValue(elemento.getIp());
            }
            if (i == 1) {
                ip2.setValue(elemento.getIp());
            }
            if (i == 2) {
                ip3.setValue(elemento.getIp());
            }
            if (i == 3) {
                ip4.setValue(elemento.getIp());
            }
            if (i == 4) {
                ip5.setValue(elemento.getIp());
            }
            if (i == 5) {
                ip6.setValue(elemento.getIp());
            }
            if (i == 6) {
                ip7.setValue(elemento.getIp());
            }
            if (i == 7) {
                ip8.setValue(elemento.getIp());
            }
            if (i == 8) {
                ip9.setValue(elemento.getIp());
            }
            if (i == 9) {
                ip10.setValue(elemento.getIp());
            }
            if (i == 10) {
                ip11.setValue(elemento.getIp());
            }
            if (i == 11) {
                ip12.setValue(elemento.getIp());
            }
            if (i == 12) {
                ip13.setValue(elemento.getIp());
            }
            if (i == 13) {
                ip14.setValue(elemento.getIp());
            }
            if (i == 14) {
                ip15.setValue(elemento.getIp());
            }
            if (i == 15) {
                ip16.setValue(elemento.getIp());
            }
            if (i == 16) {
                ip17.setValue(elemento.getIp());
            }
            if (i == 17) {
                ip18.setValue(elemento.getIp());
            }
            if (i == 18) {
                ip19.setValue(elemento.getIp());
            }
            if (i == 19) {
                ip20.setValue(elemento.getIp());
            }
            if (i == 20) {
                ip21.setValue(elemento.getIp());
            }
            if (i == 21) {
                ip22.setValue(elemento.getIp());
            }
            if (i == 22) {
                ip23.setValue(elemento.getIp());
            }
            if (i == 23) {
                ip24.setValue(elemento.getIp());
            }
            if (i == 24) {
                ip25.setValue(elemento.getIp());
            }
            if (i == 25) {
                ip26.setValue(elemento.getIp());
            }
            if (i == 26) {
                ip27.setValue(elemento.getIp());
            }
            if (i == 27) {
                ip28.setValue(elemento.getIp());
            }
            if (i == 28) {
                ip29.setValue(elemento.getIp());
            }
            if (i == 29) {
                ip30.setValue(elemento.getIp());
            }
            if (i == 30) {
                ip31.setValue(elemento.getIp());
            }
            if (i == 31) {
                ip32.setValue(elemento.getIp());
            }
            if (i == 32) {
                ip33.setValue(elemento.getIp());
            }
            if (i == 33) {
                ip34.setValue(elemento.getIp());
            }
            if (i == 34) {
                ip35.setValue(elemento.getIp());
            }
            if (i == 35) {
                ip36.setValue(elemento.getIp());
            }
            if (i == 36) {
                ip37.setValue(elemento.getIp());
            }
            if (i == 37) {
                ip38.setValue(elemento.getIp());
            }
            if (i == 38) {
                ip39.setValue(elemento.getIp());
            }
            if (i == 39) {
                ip40.setValue(elemento.getIp());
            }
            i++;
        }
    }
}

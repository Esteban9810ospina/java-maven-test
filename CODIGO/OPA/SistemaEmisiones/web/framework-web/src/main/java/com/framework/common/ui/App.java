/*
 * Informacion de Valoracion framework, Bolsa de Valores de Colombia BVC
 * Copyright (C) 2012 Quasar Software Ltda.
 */
package com.framework.common.ui;


import com.framework.common.service.security.MyUserDetailsService;
import com.quasar.frameq.db.AppConfigParams;
import com.quasar.frameq.db.Facade;
import com.quasar.frameq.fachadas.FacadeDiccionario;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.JavaScript;
import com.vaadin.event.FieldEvents;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.*;
import com.vaadin.ui.*;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.dialogs.ConfirmDialog;
import com.quasar.frameq.fachadas.FacadeUsuarios;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Punto principal de entrada a la aplicacion
 */
@Component(value = "com.framework.common.ui.App")
@Scope(value = "session")
@Configurable(preConstruction=true,autowire=Autowire.BY_TYPE)
@JavaScript({"../../VAADIN/javascript/libs/jquery-3.6.1.min.js", "../../VAADIN/javascript/framework.js"})
@Theme("framework")
public class App extends UI {

    private static final long serialVersionUID = -4879742890483528287L;
    private static final Logger logger = Logger.getLogger(App.class.getName());
    
    Navigator navegador;
	
	public Navigator getNavegador(){
		return navegador;
	}
   private MyUserDetailsService userDetailService;   
   
       @Autowired
    private MyUserDetailsService userDetailsService;
    
    Facade facade = new Facade();
    
    FacadeUsuarios facadeUsu = new FacadeUsuarios();
    
    //String PerfilActual = "";
    String idUsu = "";
    String regexMayus = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    String regexLetras = "^[a-zA-Z\\s]*$";
    String regexAlpha = "^[a-zA-Z0-9]*$";
    String regexNumeric = "^[0-9]*$";
    String regexNumeric2 = "^[0-9]$";
    String contraAnterior;
    
    int idUusuario;
    
    Boolean bCambioClave=false;
    
    Window subWindow;
    Window pantalla;
    Label lberror1 = new Label();
    Label lberror2 = new Label();
    Label lberror3 = new Label();
    Label error = new Label("");
        
    PasswordField txtnuevaContra;
    PasswordField txtconfirmarContra;
    PasswordField txtcontrasenaAc;
    Button btnGuardar;
    
    // Diccionario de contraseñas
    FacadeDiccionario facadediccionario = new FacadeDiccionario();
    
    VerticalLayout vlpadre = new VerticalLayout();    
   

    @Override
    protected void init(VaadinRequest request) {
        pantalla = new Window();
        setContent(new Main(pantalla));  
        VaadinSession session = UI.getCurrent().getSession();
        int min = AppConfigParams.getInstance().getGeneric().getAutenticacionTiempoDeslogueoInactividad();
        int milis= min*60000;
        int timeOut = session == null ? 30000 : milis; // milliseconds
        String destinationUrl = "start/login?error=expired";
        String js =
        " jQuery(function() {\n"
        + "   var timer = new framework.util.SessionTimer({timeOut: " + timeOut + ", destinationUrl: '" + destinationUrl + "'});\n"
        + "   timer.start();\n"
        + " });";
        Page.getCurrent().getJavaScript().execute(js);

        
        String userNameDetailsService;      

        userNameDetailsService = userDetailsService.getUsuarioAutenticado().getUsername();
        contraAnterior= userDetailsService.getUsuarioAutenticado().getPassword();
        idUusuario= userDetailsService.getUsuarioAutenticado().getId();
        boolean cambicontra=facade.CambiodeContrasena(userNameDetailsService);
        int dias  =facadeUsu.parametroCambioClave();
        String ultimoCambio = facadeUsu.ultimoCambioContrasena(idUusuario);
        boolean cambiarContrase=false;
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        try {            
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date dNow = new Date();
            String fechaActual = df.format(dNow); 
            Date ultimocambio = df.parse(ultimoCambio);
            Date fechaActu = df.parse(fechaActual);
            long resta =   fechaActu.getTime() -  ultimocambio.getTime();
            double dias1 = Math.floor(resta / 86400000L);
            int x = (int) dias1; 
    
            if (x==dias || x>dias){
                cambiarContrase=true;
            }
        } catch (ParseException ex) {
            
            logger.error("OPA - " + App.class.getName(), ex);	
        }

        if (cambicontra||cambiarContrase){
        subWindow = new Window("Debe cambiar su contraseña");
        subWindow.setHeight("332px");
        subWindow.setWidth("1000px");      
        subWindow.setModal(true);
        subWindow.setClosable(false);
        subWindow.setResizable(false);
        VerticalLayout subContent = new VerticalLayout();
        HorizontalLayout HL = new HorizontalLayout();
        GridLayout grid = new GridLayout(7, 5);       
       
        /************************************/
        Label lblogin = new Label("Login:");
        grid.addComponent(lblogin, 0, 0);
        grid.setComponentAlignment(lblogin, Alignment.MIDDLE_CENTER);
        lblogin.setWidth(11, Sizeable.Unit.EM);
        lblogin.setHeight(2, Sizeable.Unit.EM);
        
        TextField txtlogin = new TextField();
        grid.addComponent(txtlogin, 2, 0);
        grid.setComponentAlignment(txtlogin, Alignment.MIDDLE_CENTER);
        txtlogin.setWidth(15, Sizeable.Unit.EM);
        txtlogin.setHeight(2, Sizeable.Unit.EM);
        txtlogin.setValue(userNameDetailsService);
        txtlogin.setEnabled(false);
        
        
        /***********************************************/
        
        Label lbnuevaContra = new Label("Nueva Contraseña:");
        grid.addComponent(lbnuevaContra, 0, 2);
        grid.setComponentAlignment(lbnuevaContra, Alignment.MIDDLE_CENTER);
        lbnuevaContra.setWidth(11, Sizeable.Unit.EM);
        lbnuevaContra.setHeight(2, Sizeable.Unit.EM);
        
        
        Label lbasteris2 = new Label("*");
        lbasteris2.setStyleName("asterix");
        grid.addComponent(lbasteris2, 1, 2);
        grid.setComponentAlignment(lbasteris2, Alignment.MIDDLE_CENTER);
        lbasteris2.setWidth(5, Sizeable.Unit.EM);
        lbasteris2.setHeight(2, Sizeable.Unit.EM);
        
        txtnuevaContra = new PasswordField();
        grid.addComponent(txtnuevaContra, 2, 2);
        grid.setComponentAlignment(txtnuevaContra, Alignment.MIDDLE_CENTER);
        txtnuevaContra.setWidth(15, Sizeable.Unit.EM);        
        txtnuevaContra.setHeight(2, Sizeable.Unit.EM);
        txtnuevaContra.setMaxLength(20);
        
        
        lberror2.setStyleName("lblerrorestop");
        grid.addComponent(lberror2, 2, 3);
        grid.setComponentAlignment(lberror2, Alignment.BOTTOM_CENTER);
        lberror2.setWidth(18, Sizeable.Unit.EM); 
        lberror2.setHeight(2, Sizeable.Unit.EM);
        
        bCambioClave=false;
        txtnuevaContra.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (txtnuevaContra.getValue().equals("")) {
                    txtnuevaContra.setComponentError(new UserError(""));
                    lberror2.setValue("Este campo es requerido");
                } else { 
                    if (validaPassAnteriores(txtnuevaContra.getValue())) {
                    if (validaLongitudContra(txtnuevaContra.getValue())) {
                     if(caracteresConsecutivos(txtnuevaContra.getValue())){
                        if (validarSecuen(txtnuevaContra.getValue())) {
                            if (validaunaMayus(txtnuevaContra.getValue())) {
                                if (validalfaNum(txtnuevaContra.getValue())) {
                                    if (validaunCaracter(txtnuevaContra.getValue())) {
                                        if (validaunNumero(txtnuevaContra.getValue())) {
                                            //Diccionario de contraseñas
                                            //Validar que la clave no contega palabras restringidas  adm general                                           
                                            Boolean palpermitida = facadediccionario.validaRestringidas(txtnuevaContra.getValue());
                                            if (palpermitida) {
                                                txtnuevaContra.setComponentError(new UserError(""));
                                                lberror2.setValue("La contraseña contiene una palabra no permitida");
                                            } else {
                                                txtnuevaContra.setComponentError(null);
                                                lberror2.setValue("");
                                            }                                                                               
                                        } else {
                                            txtnuevaContra.setComponentError(new UserError(""));
                                            lberror2.setValue("La contraseña debe tener al menos un número");
                                        }
                                    } else {
                                        txtnuevaContra.setComponentError(new UserError(""));
                                        lberror2.setValue("La contraseña debe tener al menos un carácter especial");
                                    }

                                } else {
                                    txtnuevaContra.setComponentError(new UserError(""));
                                    lberror2.setValue("La contraseña debe ser alfanumerica");
                                }
                            } else {
                                txtnuevaContra.setComponentError(new UserError(""));
                                lberror2.setValue("La contraseña debe tener al menos una mayúscula");
                            }
                        } else {
                            txtnuevaContra.setComponentError(new UserError(""));
                            lberror2.setValue("La contraseña no debe contener caracteres consecutivos ");
                        }
                        
                       } else {
                        txtnuevaContra.setComponentError(new UserError(""));
                        lberror2.setValue("La contraseña no debe contener más de 3 caracteres idénticos consecutivos");
                     } 
                    } else {
                        txtnuevaContra.setComponentError(new UserError(""));
                        lberror2.setValue("La contraseña debe contener mínimo 8 caracteres máximo 15");
                     } 
                    } else {
                       txtnuevaContra.setComponentError(new UserError(""));
                       lberror2.setValue("La contraseña coincide con las últimas tres contraseñas anteriores");       
                     }                      
                }
              ValidarError();
            }
        });
  
        
        /***************************************/
        
        Label lbcontrasenaAc = new Label("Contraseña Actual:");
        grid.addComponent(lbcontrasenaAc, 4, 0);
        grid.setComponentAlignment(lbcontrasenaAc, Alignment.MIDDLE_CENTER);
        lbcontrasenaAc.setWidth(15, Sizeable.Unit.EM);
        lbcontrasenaAc.setHeight(2, Sizeable.Unit.EM);
        grid.setSpacing(true);
        grid.setWidth(80, Sizeable.Unit.PIXELS);

        
               
        Label lbasteris1 = new Label("*");
        lbasteris1.setStyleName("asterix");
        grid.addComponent(lbasteris1, 5, 0);
        grid.setComponentAlignment(lbasteris1, Alignment.MIDDLE_CENTER);        
        lbasteris1.setWidth(5, Sizeable.Unit.EM);  
        lbasteris1.setHeight(2, Sizeable.Unit.EM);

                
        txtcontrasenaAc = new PasswordField();
        grid.addComponent(txtcontrasenaAc, 6, 0); 
        grid.setComponentAlignment(txtcontrasenaAc, Alignment.MIDDLE_CENTER);
        txtcontrasenaAc.setWidth(15, Sizeable.Unit.EM);
        txtcontrasenaAc.setHeight(2, Sizeable.Unit.EM);
        txtcontrasenaAc.setMaxLength(20);


        lberror1.setStyleName("lblerrorestop");
        grid.addComponent(lberror1, 6, 1);
        grid.setComponentAlignment(lberror1, Alignment.BOTTOM_CENTER);
        lberror1.setWidth(18, Sizeable.Unit.EM); 
        lberror1.setHeight(2, Sizeable.Unit.EM);
        
                
        txtcontrasenaAc.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (txtcontrasenaAc.getValue().equals("")) {
                    txtcontrasenaAc.setComponentError(new UserError(""));
                    lberror1.setValue("Este campo es requerido");
                } else {
                    if (validaPassActual(txtcontrasenaAc.getValue())) {
                        txtcontrasenaAc.setComponentError(new UserError(""));
                        lberror1.setValue("Contraseña Incorrecta");      
                    }else{
                        txtcontrasenaAc.setComponentError(null);
                        lberror1.setValue("");
                    }
                }
             ValidarError();
            }
        });
        
        

        /***********************************************/
        
        Label lbconfirmarContra = new Label("Confirmar Nueva Contraseña:");
        grid.addComponent(lbconfirmarContra, 4, 2);
        grid.setComponentAlignment(lbconfirmarContra,  Alignment.MIDDLE_CENTER);
        lbconfirmarContra.setWidth(15, Sizeable.Unit.EM);
        lbconfirmarContra.setHeight(2, Sizeable.Unit.EM);

        
        Label lbasteris3 = new Label("*");
        lbasteris3.setStyleName("asterix");
        grid.addComponent(lbasteris3, 5, 2);
        grid.setComponentAlignment(lbasteris3, Alignment.MIDDLE_CENTER);
        lbasteris3.setWidth(5, Sizeable.Unit.EM);
        lbasteris3.setHeight(2, Sizeable.Unit.EM);
        
        txtconfirmarContra = new PasswordField();
        grid.addComponent(txtconfirmarContra, 6, 2);
        grid.setComponentAlignment(txtconfirmarContra, Alignment.MIDDLE_CENTER);
        txtconfirmarContra.setWidth(15, Sizeable.Unit.EM);
        txtconfirmarContra.setHeight(2, Sizeable.Unit.EM);
        txtconfirmarContra.setMaxLength(20);
        
        lberror3.setStyleName("lblerrorestop");
        grid.addComponent(lberror3, 6, 3);
        grid.setComponentAlignment(lberror3, Alignment.BOTTOM_CENTER);
        lberror3.setWidth(18, Sizeable.Unit.EM); 
        lberror3.setHeight(2, Sizeable.Unit.EM);
        
         txtconfirmarContra.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {
                if (txtconfirmarContra.getValue().equals("")) {
                    txtconfirmarContra.setComponentError(new UserError(""));
                    lberror3.setValue("Este campo es requerido");
                } else {

                    if (!txtnuevaContra.getValue().equals(txtconfirmarContra.getValue())) {
                        txtconfirmarContra.setComponentError(new UserError(""));
                        lberror3.setValue("Las contraseñas ingresadas no coinciden");      
                    }else{
                        txtconfirmarContra.setComponentError(null);
                        lberror3.setValue("");
                    }
                }
             ValidarError();
            }
        });

        VerticalLayout vl = new VerticalLayout();
        Button btnGuardar = new Button("Guardar");
        HL.addComponent(btnGuardar); 
 

            btnGuardar.addClickListener(new Button.ClickListener() {
                public void buttonClick(final Button.ClickEvent event) {                    
  
                    
                    if (txtcontrasenaAc.getValue().equals("")) {
                        txtcontrasenaAc.setComponentError(new UserError(""));
                        lberror1.setValue("Este campo es requerido");
                    }
                    
                    if (txtconfirmarContra.getValue().equals("")) {
                        txtconfirmarContra.setComponentError(new UserError(""));
                        lberror3.setValue("Este campo es requerido");
                    }
                    
                    if (txtnuevaContra.getValue().equals("")) {
                        txtnuevaContra.setComponentError(new UserError(""));
                        lberror2.setValue("Este campo es requerido");
                    }

                      ValidarError();
                     if (!ValidaComponentError()) {    
                         UI.getCurrent().removeWindow(subWindow);  
                         userDetailsService.updateUsuarioContrasena(txtnuevaContra.getValue(),idUusuario, userDetailsService.getUsuarioAutenticado());
                         ConfirmDialog cd = ConfirmDialog.getFactory().create("Confirmación", "", "ACEPTAR", "", "");
                         cd.setWidth("448px");
                         cd.setHeight("150px");
                         HorizontalLayout texto = new HorizontalLayout();
                         HorizontalLayout buttons = new HorizontalLayout();
                         buttons.setStyleName("btnAceptar");
                         Label lblmensaje = new Label("Contraseña actualizada correctamente", ContentMode.HTML);
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
                     
//                         pantalla.setEnabled(false);
                     }
                }
            });


        error.setStyleName("lblErrorVer");        
        vl.addComponents(HL);
        HL.addComponent(error);
        HL.setComponentAlignment(error, Alignment.BOTTOM_CENTER);
        HL.addStyleName("horizontal1");
        subWindow.center();
        subContent.setMargin(true);
        subContent.addComponent(grid);
       
        subWindow.setContent(subContent);
       
        addWindow(subWindow);
        
        subContent.addComponent(HL);

        HL.setComponentAlignment(btnGuardar, Alignment.MIDDLE_CENTER);
 
    } else {
           
          // pantalla.setEnabled(false);        
     
        }
    
  }
    
       public void pantallaPrincipal(){

        
} 
    
    
    public static void setDefaultLocale() {
        AppConfigParams acp = AppConfigParams.getInstance();
        Locale.setDefault(acp.getGeneric().getLocale());


    }
    
        public boolean validaPassAnteriores(String cadena) {

        boolean result = true;
        String password="";
        try {
        String idUsuario = "";

        idUsuario = String.valueOf(idUusuario);

        password = userDetailsService.decript(cadena, "", userDetailsService.getUsuarioAutenticado(), 1);

        List<List<String>> passAnte = facade.RetornaPassusuarios(idUsuario);
        int i = 0;

        for (i = 0; i < passAnte.get(0).size(); i++) {
            String datos = userDetailsService.decript(passAnte.get(0).get(i), passAnte.get(3).get(i), userDetailsService.getUsuarioAutenticado(), 0);
            if (datos.equals(password)) {
                result = false;
            }
        }
        
   } catch (Exception e) {
     password="";
     
    }
        return result;
    }
        
        
       public boolean validaPassActual(String cadena) {
        boolean result = true;
            
          String password = userDetailsService.validPassword(cadena, userDetailsService.getUsuarioAutenticado());
        
          String passActual = facade.retornaPassActual(idUusuario);
        
        if(password.equals(passActual)){
            result=false;
        }

        return result;
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
//                        contador++;
//                        if (contador == 3) {
                            result = false;
//                        }
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
                        if ((i + 1) == abecedario.length) {
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
   
   
       public void ValidarError() {
        if (ValidaComponentError()) {
            error.setValue("Verificar campos en rojo");
        } else {          
            error.setValue("");
        }
    }
       
        public Boolean ValidaComponentError() {
            Boolean errores = false;
          if (txtnuevaContra.getComponentError() != null || txtconfirmarContra.getComponentError() != null) {
            return true;
           }
            if (txtcontrasenaAc.getComponentError() != null ) {
            return true;
           }
          
           return errores;
        }
}

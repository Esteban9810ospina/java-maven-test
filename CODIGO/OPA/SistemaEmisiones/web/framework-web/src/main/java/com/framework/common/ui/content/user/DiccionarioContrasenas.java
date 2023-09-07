/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.ui.content.user;

import com.framework.common.service.security.MyUserDetailsService;
import com.framework.common.ui.GenericTab;
import com.framework.common.ui.GenericContent;
import com.quasar.frameq.db.Facade;
import com.quasar.frameq.fachadas.FacadeDiccionario;
import com.vaadin.event.FieldEvents;
import com.vaadin.server.UserError;
import com.vaadin.ui.Button;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import java.util.List;
import org.springframework.beans.factory.annotation.Configurable;
import com.vaadin.server.Sizeable;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Embedded;
//import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Roger Padilla C.
 */
@Configurable(preConstruction = true)
public class DiccionarioContrasenas extends GenericContent {
    private static final Logger logger = Logger.getLogger(DiccionarioContrasenas.class.getName());
    Label texto = new Label();
    Label lbl_errpalabras = new Label(); //Label Error 
    Label error = new Label("");
    // TextField palabras = new TextField();
    TextArea palabras = new TextArea();
    Button guardar = new Button("Guardar");
    Button cancelar = new Button("Cancelar");

    FacadeDiccionario facadediccionario = new FacadeDiccionario();
    Facade facade = new Facade();
    List<List<String>> restringidas;
    List<String> listvalidar = new ArrayList<String>();

    String guardarpalabras = "";
    String listapalabras = "";
    String palarray = "";
    String palabradiv = "";
    String regexpuntoycomafinal = "([A-Za-z0-9·ÈÌÛ˙Ò—¡…Õ”⁄_+-.,!@#$%^&*()\\/|<>\"'])\\S+;$";

    /**
     *
     * @param parentTab
     */
    public DiccionarioContrasenas(GenericTab parentTab) {
        super(parentTab);
    }

    @Autowired
    private MyUserDetailsService userDetailsService;
    
    public void close() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        try {
            palabras.setValue("");
            listapalabras = "";
            palabras.setComponentError(null);
            lbl_errpalabras.setValue("");
            ValidarError();
            initForm();
        } catch (Exception ex) {
          
            logger.error("OPA - " + DiccionarioContrasenas.class.getName(), ex);	
        }
    }

    @Override
    public void initForm() {

        // consultar si hay palabras 
        int hayPalabras = facadediccionario.validaHayPalabras();
        if (hayPalabras > 1) {
            //obtener lista de palabras restirngidas     

            restringidas = facadediccionario.ListarPalabras();

            for (int i = 0; i < restringidas.get(0).size(); i++) {
                listapalabras = listapalabras + (restringidas.get(0).get(i));
            }
            palabras.setValue("");
            palabras.setValue(listapalabras);
        } else {
            palabras.setValue("");
        }

        VerticalLayout vlPadre = new VerticalLayout();
        GridLayout grid = new GridLayout(4, 10);


        HorizontalLayout horizo = new HorizontalLayout();
        grid.setSizeFull();
        horizo.setWidth(97, Sizeable.Unit.PERCENTAGE);
        horizo.setHeight(97, Sizeable.Unit.PERCENTAGE);

        /*TITULO DICCIONARIO CONTRASE—AS*/
        Label lbltitulo = new Label("DICCIONARIO DE CONTRASE—AS");
        lbltitulo.setWidth("100%");
        lbltitulo.setWidthUndefined();
        lbltitulo.setStyleName("tituloInversionistatit");
        Embedded image = new Embedded(null, new ThemeResource("img/Inver.png"));
        lbltitulo.setHeight("35px");
        image.setStyleName("InverImg");
        horizo.addStyleName("tituloAdjudicacion");
        horizo.addComponents(image, lbltitulo);
        horizo.setComponentAlignment(lbltitulo, Alignment.MIDDLE_CENTER);
        grid.addComponent(horizo, 0, 0, 3, 0);

        /*COMPONENTES DE LOS OBJETOS*/
        vlPadre.addComponent(grid);
        setContent(vlPadre);

        //texto cabecera
        texto = new Label("Favor ingresar las palabras restringidas para no ser usadas en las contraseÒas, separadas por punto y coma (;) y sin espacios");
        texto.setWidth(96, Sizeable.Unit.PERCENTAGE);
        grid.setSpacing(true);
        grid.addComponent(texto, 0, 2, 3, 2);
        grid.setComponentAlignment(texto, Alignment.MIDDLE_CENTER);

        //campo de texto libre
        palabras.setMaxLength(500);
        palabras.setWidth(96, Sizeable.Unit.PERCENTAGE);
        grid.addComponent(palabras, 0, 3, 3, 8);
        grid.setComponentAlignment(palabras, Alignment.MIDDLE_CENTER);

        lbl_errpalabras.setStyleName("lblerrores");
        grid.addComponent(lbl_errpalabras, 0, 9, 3, 9);

        palabras.addBlurListener(new FieldEvents.BlurListener() {
            @Override
            public void blur(FieldEvents.BlurEvent event) {

                if (!palabras.getValue().isEmpty()) {
                    // Validar que no se encuentren palabras repetidas dentro de la cadena
                    listapalabras = "";
                    palabradiv = palabras.getValue();
                    if (palabradiv.contains(";;")) {
                        palabras.setComponentError(new UserError(""));
                        lbl_errpalabras.setValue("No pueden existir dos punto y coma (;) seguidos.");
                    } else {
                        String[] arraypaldiv = palabradiv.split(";");
                          
                        if (validaestrutura(palabradiv) && puntoycomafinal(palabradiv)) {
                            listvalidar = Arrays.asList(arraypaldiv);
                            Boolean resultado = isDuplicate(listvalidar);
                            if (resultado) {
                                palabras.setComponentError(new UserError(""));
                                lbl_errpalabras.setValue("El campo contiene palabras repetidas");

                            } else {
                                for (int i = 0; i < listvalidar.size(); i++) {
                                    //validar que palabra no supere m·ximo de la contraseÒa
                                    if (listvalidar.get(i).length() > 15) {
                                        palabras.setComponentError(new UserError(""));
                                        lbl_errpalabras.setValue(listvalidar.get(i) + " tiene una longitud mayor a la permitida");
                                        break;
                                    } else {
                                        palarray = listvalidar.toString().replace(",", ";").replace("[", "").replace("]", "").replace(" ", "").trim().concat(";");
                                        palabras.setComponentError(null);
                                        lbl_errpalabras.setValue("");
                                    }
                                }
                            }
                        } else {
                            palabras.setComponentError(new UserError(""));
                            lbl_errpalabras.setValue("La estructura del campo no debe tener espacios y debe terminar con (;).");
                        }
                    }
                } else {
                    palarray = ("");
                    palabras.setComponentError(null);
                    lbl_errpalabras.setValue("");
                }
                ValidarError();

            }
        });

        HorizontalLayout hll = new HorizontalLayout();
        hll.addComponents(guardar, cancelar);
        hll.addStyleName("horizontal1");
        cancelar.addStyleName("Butt1");
        //error.setStyleName("lblError");     
        vlPadre.addComponents(hll);

//        
        cancelar.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(final Button.ClickEvent event) {
                close();
            }
        });

        guardar.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                
                ValidarError();
                String nomUsuario = userDetailsService.getUsuarioAutenticado().getUsername();
                if (!ValidaComponentError()) {

                    guardarpalabras = facade.GuardarPalabras(String.valueOf(palarray),nomUsuario);
                    Notification.show(guardarpalabras, Notification.Type.HUMANIZED_MESSAGE);

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
        if (palabras.getComponentError() != null) {
            return true;
        }
        return errores;

    }

    public boolean isDuplicate(List<String> lista) {

        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = i + 1; j < lista.size(); j++) {

                if (lista.get(i).equals(lista.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean validaestrutura(String cadena) {
        String regexpalabra = "([A-Za-z0-9·ÈÌÛ˙Ò—¡…Õ”⁄_+-.,!@#$%^&*()\\/|<>\"'])\\S+";
        if (cadena.length() > 1){    
            String[] separapal = cadena.split(";");
            if (separapal.length > 1) {
                for (String paldiv : separapal) {
                    if (paldiv.length() > 1) {
                       if (paldiv.matches(regexpalabra)) {
                       return true;
                        }
                    }  else{
                        return true;                        
                    } 
                }
            }else
               if (separapal.length == 1) {                      
                    return true;                       
                }
            }
                     
        return false;
    }

    public boolean puntoycomafinal(String cadena) {
        // String regexpuntoycomafinal= "([A-Za-z0-9·ÈÌÛ˙Ò—¡…Õ”⁄_+-.,!@#$%^&*()\\/|<>\"'])\\S+;$";
        String[] separapal1 = cadena.split(";");
        if (cadena.length() > 1){
            if (separapal1.length ==1){
                return true;
            } else{
                if (cadena.matches(regexpuntoycomafinal)) {
                return true;
                }
            }
            
        }
      
        return false;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.ui.contents;

import com.framework.common.ui.GenericContent;
import com.framework.common.ui.GenericTab;
import com.framework.common.ui.util.*;
import com.quasar.frameq.db.Facade;
import com.vaadin.server.FileDownloader;
import com.vaadin.server.FileResource;
import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.TextField;
import com.vaadin.event.FieldEvents;
import java.io.File;
import java.util.Calendar;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.vaadin.dialogs.ConfirmDialog;

/**
 *
 * @author Catherine_Ovalle
 */
public class GenerarBoletin extends GenericContent {

    private static final Logger logger = Logger.getLogger(GenerarBoletin.class.getName());
    static Facade fachada = new Facade();
    static String rutaCargue = fachada.rutaBoletin();
    Button descargar = new Button("Descargar");
    ValidarCampos validacion = new ValidarCampos();
    String hayParametros = validacion.validaParametrovacio();
    Button btnValidar;
    TextField txtConsecutivo = new TextField();
    Window modalGenerar = new Window("");
    VerticalLayout vlPadre = new VerticalLayout();
    GridLayout grid = new GridLayout(4, 10);
    HorizontalLayout horizo = new HorizontalLayout();
    boolean resp = false;
    HorizontalLayout cintaGenerar = new HorizontalLayout();
    String regexNumeric = "^[0-9]*$";
    Label errConsecutivo = new Label();
    
    public GenerarBoletin(GenericTab parentTab) {
        super(parentTab);
    }

    public void GenerarReporteExcel() {
        String consecutivoArchivo = txtConsecutivo.getValue();
        if (validate(consecutivoArchivo)) {
            resp = GenerarArchivoBoletin.generateExcelFile(consecutivoArchivo);
            HorizontalLayout hll = new HorizontalLayout();
            hll.addComponent(descargar);
            hll.addStyleName("horizontal1");
            vlPadre.addComponents(hll);
            vlPadre.removeComponent(cintaGenerar);
            descargar.setEnabled(true);
            descargar.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(final Button.ClickEvent event) {
                }
            });           
            if (resp) {
                modalGenerar.close();
                descargar.setEnabled(true);
                try{
                    logger.info("OPA - " + GenerarBoletin.class.getName() + " -entro a descargar el reporte generado en el servidor ");                                 
                    Resource res = new FileResource(new File(rutaCargue + "/descargable/boletin_" +fileToDownload()+ "_No_" + consecutivoArchivo+".zip"));
                    FileDownloader ejemplo = new FileDownloader(res);
                    ejemplo.extend(descargar);  
                }catch(Exception e){
                    logger.error("OPA - " + GenerarBoletin.class.getName() + " -Error descargando archivo ");     
                }                
            }

        }
    }

    @SuppressWarnings("UseSpecificCatch")
    public void showModal() {
        try {
            btnValidar = new Button("Generar");
            btnValidar.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(final Button.ClickEvent event) {
                    GenerarReporteExcel();
                }
            });
            txtConsecutivo.addTextChangeListener(new FieldEvents.TextChangeListener() {
                @Override
                public void textChange(FieldEvents.TextChangeEvent event) {
                    validate(event.getText());
                }
            });
            btnValidar.setEnabled(false);
            VerticalLayout subContent = new VerticalLayout();
            txtConsecutivo.addStyleName("v-div-modal-generar");
            txtConsecutivo.addStyleName("v-btn-generar");
            txtConsecutivo.setWidth("193");
            txtConsecutivo.setMaxLength(4);
            VerticalLayout subContentheader = new VerticalLayout();
            subContentheader.setWidth("280");
            subContentheader.setHeight("80");
            subContentheader.addComponent(new Label("Consecutivo*"));
            subContentheader.addComponent(txtConsecutivo);
            subContentheader.addComponent(errConsecutivo);            
            subContentheader.addStyleName("v-generar-header");
            VerticalLayout subContentBoton = new VerticalLayout();
            subContentBoton.setWidth("100%");
            subContentBoton.addStyleName("v-centrado");
            subContentBoton.addComponent(btnValidar);
            subContent.addStyleName("v-div-bordered");            
            subContent.setWidth("220");
            subContent.setHeight("150");
            subContent.addComponent(subContentheader);      
            subContent.addComponent(subContentBoton);
            cintaGenerar.addComponent(subContent);
            cintaGenerar.addStyleName("horizontal1");
            vlPadre.addComponents(cintaGenerar);
        } catch (Exception ex) {
            logger.error("OPA - " + GenerarBoletin.class.getName(), ex);
        }
    }

    public boolean validate(String dato) {
        dato = dato.trim();
        @SuppressWarnings("UnusedAssignment")
        boolean esValido = false;
        try {
            if (dato.length() > 0 && dato.substring(dato.length() - 1).equals(".")) {
                esValido = false;
            } else {
                if (dato.length() > 2 && dato.length() < 5) {
                    Double.parseDouble(dato);
                    esValido = true;
                } else {
                    esValido = false;
                }
            }
        } catch (NumberFormatException e) {
            esValido = false;
        }
        btnValidar.setEnabled(esValido);
        if (dato.matches(regexNumeric)) {
            errConsecutivo.setValue("");
        }else{            
            errConsecutivo.setValue("Este campo contiene caracteres no válidos");
            esValido = false;
        }
        return esValido;
    }

    public static String fileToDownload() {
        Calendar fecha = Calendar.getInstance();
        int anio = fecha.get(Calendar.YEAR);
        int month = fecha.get(Calendar.MONTH) + 1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        String monthReturn = "" + month;
        String diaReturn = ""+dia;
        if (month < 10) {
            monthReturn = "0" + month;
        }
        
        if (dia < 10) {
            diaReturn = "0" + ""+dia;
        }
               
               
        return anio + "_" + monthReturn + "_" + diaReturn;
    }

   @Override
    @SuppressWarnings("UseSpecificCatch")
    public void initForm() {

        modalGenerar.close();
        errConsecutivo.setStyleName("lblerroreConsecutivo");
        if (!"".equals(hayParametros)) {
            ConfirmDialog cd = ConfirmDialog.getFactory().create("Confirmación", "", "ACEPTAR", "", "");
            cd.setWidth("400px");
            cd.setHeight("160px");
            HorizontalLayout texto = new HorizontalLayout();
            HorizontalLayout buttons = new HorizontalLayout();
            buttons.setStyleName("btnAceptar");
            Label lblmensaje = new Label(hayParametros, ContentMode.HTML);
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
            PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
            try {                
                grid.setSizeFull();
                horizo.setWidth(97, Sizeable.Unit.PERCENTAGE);
                horizo.setHeight(97, Sizeable.Unit.PERCENTAGE);
                Label lbltitulo = new Label("BOLETÍN INFORMATIVO");
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
                vlPadre.addComponent(grid);
                setContent(vlPadre);                
                VerticalLayout vlAux = new VerticalLayout();
                vlAux.addStyleName("v-div-height-5");
                vlPadre.addComponents(vlAux);
                descargar.setEnabled(false);
                showModal();
            } catch (Exception ex) {
                logger.error("OPA - " + GenerarBoletin.class.getName(), ex);
            }

        }
    }
}

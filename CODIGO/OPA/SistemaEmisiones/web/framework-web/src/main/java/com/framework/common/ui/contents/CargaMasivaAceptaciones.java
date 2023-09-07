/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.ui.contents;

import com.framework.common.service.security.MyUserDetailsService;
import com.framework.common.ui.GenericContent;
import com.framework.common.ui.GenericTab;
import com.framework.common.ui.util.ValidarCampos;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.dialogs.ConfirmDialog;

public class CargaMasivaAceptaciones extends GenericContent {

    @Autowired
    private MyUserDetailsService userDetailsService;
    
    public CargaMasivaAceptaciones(GenericTab parentTab) {
        super(parentTab);
    }
    
    ValidarCampos validar = new ValidarCampos();
    
    @Override
    public void initForm() {
        
                String horario = validar.fechaIngresoCarga();
                boolean moduloCm = validar.validarEstadoCargaMasiva();
                if(!moduloCm){                    
                    ConfirmDialog cd = ConfirmDialog.getFactory().create("Confirmación", "", "ACEPTAR", "", "");
                    cd.setWidth("400px");
                    cd.setHeight("160px");
                    HorizontalLayout texto = new HorizontalLayout();
                    HorizontalLayout buttons = new HorizontalLayout();
                    buttons.setStyleName("btnAceptar");
                    Label lblmensaje = new Label("La funcionalidad de carga masiva no está habilitada para esta operación.", ContentMode.HTML);
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
        if (!horario.equals("")) {
            ConfirmDialog cd = ConfirmDialog.getFactory().create("Confirmación", "", "ACEPTAR", "", "");
            cd.setWidth("400px");
            cd.setHeight("200px");
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
            CargaMasivaModal modal = new CargaMasivaModal(userDetailsService);
            modal.setWidth("800px");
            modal.setHeight("500px");
            UI.getCurrent().addWindow(modal);
        }
     }          
    }

}
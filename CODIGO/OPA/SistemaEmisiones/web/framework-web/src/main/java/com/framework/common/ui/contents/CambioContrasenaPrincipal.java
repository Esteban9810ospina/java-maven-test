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

public class CambioContrasenaPrincipal extends GenericContent {
    
        @Autowired
    private MyUserDetailsService userDetailsService;
    
    public CambioContrasenaPrincipal(GenericTab parentTab) {
        super(parentTab);
    }
    
        @Override
    public void initForm() {
        
            CambioContrasena modalCambioContrasena = new CambioContrasena(userDetailsService);
            modalCambioContrasena.setWidth("1000px");
            modalCambioContrasena.setHeight("332px");
            UI.getCurrent().addWindow(modalCambioContrasena);
            
        
    }
    
}

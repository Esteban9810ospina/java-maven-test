/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.opa.reporte.service;

import com.framework.common.service.AbstractService;
import com.framework.reportEngine.QueryContainer;
import com.vaadin.ui.UI;

/**
 *
 * @author jam
 */
public interface ReporteServiceGeneral {
    public QueryContainer tablaReporteAceptaciones(final UI app );
}

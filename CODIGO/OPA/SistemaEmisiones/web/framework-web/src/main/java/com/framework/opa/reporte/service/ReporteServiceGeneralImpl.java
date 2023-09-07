/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.opa.reporte.service;

import com.framework.common.service.AbstractService;
import com.framework.reportEngine.ConfigCampoVO;
import com.framework.reportEngine.QueryContainer;
import com.framework.reportEngine.ReportService;
import com.framework.reportEngine.formatter.DecimalFormatter;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author jam
 */
@Service
public class ReporteServiceGeneralImpl extends AbstractService implements ReporteServiceGeneral {

     public QueryContainer tablaReporteAceptaciones(final UI app ) {
        String query = "(SELECT martillo.c_nemotecnico AS martillo,scb.i_d_scb AS idscb, scb.c_nombre AS sociedad, lotes.id_lotes AS lotes, vuelta.i_id_vuelta AS vuelta, "
                + "vuelta.d_precio AS precio, oferta.i_cantidad AS cantidad, "
                + "FORMAT(oferta.i_num_minimo,0) AS num_minimo, "
                + "oferta.i_cantidad_adjudicada AS cantidad_adjudicada, "
                + "CASE oferta.b_es_todo_nada WHEN 1 THEN 'SI' WHEN 0 THEN 'NO' END AS modalidad, oferta.d_val_minimo AS minimo "
                + "FROM ma_oferta AS oferta "
                + "INNER JOIN ma_postor postor ON oferta.i_ma_postor_i_id_postor = postor.i_id_postor AND oferta.i_ma_martillo_i_id_martillo = postor.i_ma_martillo_i_id_martillo "
                + "INNER JOIN ma_vuelta vuelta ON oferta.i_vuelta_idvuelta = vuelta.i_id_vuelta AND oferta.i_ma_martillo_i_id_martillo = vuelta.i_ma_martillo_i_id_martillo AND  oferta.i_ma_lotes_id_lotes=vuelta.i_ma_lotes_id_lotes "
                + "INNER JOIN ma_lotes lotes ON lotes.id_lotes = vuelta.i_ma_lotes_id_lotes AND lotes.i_ma_martillo_id_martillo_lotes = vuelta.i_ma_martillo_i_id_martillo "
                + "INNER JOIN ma_martillo AS martillo ON lotes.i_ma_martillo_id_martillo_lotes = martillo.i_id_martillo "
                + "INNER JOIN ma_scb scb ON postor.i_ma_scb_i_d_scb = scb.i_d_scb "
                + "WHERE martillo.i_id_martillo = ? "
                + "AND lotes.id_lotes = ? "
                + "AND postor.i_id_postor = ? "
                + "AND vuelta.i_id_vuelta = ? )UNION "
                + "(SELECT 'TOTALES','', '', '', '', '', IFNULL(SUM(oferta.i_cantidad),0.00) AS cantidad, '' AS num_minimo, "
                + "IFNULL(SUM(oferta.i_cantidad_adjudicada),0.00) AS cantidad_adjudicada, '', '' "
                + "FROM ma_oferta AS oferta "
                + "INNER JOIN ma_postor postor ON oferta.i_ma_postor_i_id_postor = postor.i_id_postor "
                + "AND oferta.i_ma_martillo_i_id_martillo = postor.i_ma_martillo_i_id_martillo "
                + "INNER JOIN ma_vuelta vuelta ON oferta.i_vuelta_idvuelta = vuelta.i_id_vuelta "
                + "AND oferta.i_ma_martillo_i_id_martillo = vuelta.i_ma_martillo_i_id_martillo "
                + "AND  oferta.i_ma_lotes_id_lotes=vuelta.i_ma_lotes_id_lotes "
                + "INNER JOIN ma_lotes lotes ON lotes.id_lotes = vuelta.i_ma_lotes_id_lotes "
                + "AND lotes.i_ma_martillo_id_martillo_lotes = vuelta.i_ma_martillo_i_id_martillo "
                + "INNER JOIN ma_martillo AS martillo ON lotes.i_ma_martillo_id_martillo_lotes = martillo.i_id_martillo "
                + "INNER JOIN ma_scb scb ON postor.i_ma_scb_i_d_scb = scb.i_d_scb  "
                + "WHERE martillo.i_id_martillo = ? AND lotes.id_lotes = ? AND postor.i_id_postor = ? AND vuelta.i_id_vuelta = ?)";

        ReportService reporte = new ReportService();
        ConfigCampoVO cfgCampo;
        List<ConfigCampoVO> configCampos = new ArrayList<ConfigCampoVO>();

        cfgCampo = new ConfigCampoVO();
        cfgCampo.setCampo("martillo");
        cfgCampo.setTitulo("MARTILLO");
        cfgCampo.setTamano(100);
        configCampos.add(cfgCampo);

        cfgCampo = new ConfigCampoVO();
        cfgCampo.setCampo("idscb");
        cfgCampo.setTitulo("Código SCB");
        cfgCampo.setTamano(100);
        configCampos.add(cfgCampo);


        cfgCampo = new ConfigCampoVO();
        cfgCampo.setCampo("sociedad");
        cfgCampo.setTitulo("S. COMISIONISTA");
        cfgCampo.setTamano(100);
        configCampos.add(cfgCampo);

        cfgCampo = new ConfigCampoVO();
        cfgCampo.setCampo("lotes");
        cfgCampo.setTitulo("LOTE");
        cfgCampo.setTamano(100);
        configCampos.add(cfgCampo);

        cfgCampo = new ConfigCampoVO();
        cfgCampo.setCampo("vuelta");
        cfgCampo.setTitulo("VUELTA");
        cfgCampo.setTamano(100);
        configCampos.add(cfgCampo);

        cfgCampo = new ConfigCampoVO();
        cfgCampo.setCampo("precio");
        cfgCampo.setTitulo("PRECIO");
        cfgCampo.setTamano(100);
        configCampos.add(cfgCampo);

        cfgCampo = new ConfigCampoVO();
        cfgCampo.setCampo("cantidad");
        cfgCampo.setTitulo("CANTIDAD");
        cfgCampo.setCampoFormatter(new DecimalFormatter("#,##0"));

        cfgCampo.setTamano(100);
        configCampos.add(cfgCampo);

        cfgCampo = new ConfigCampoVO();
        cfgCampo.setCampo("num_minimo");
        cfgCampo.setTitulo("MÍNIMO");

        cfgCampo.setTamano(100);
        configCampos.add(cfgCampo);

        cfgCampo = new ConfigCampoVO();
        cfgCampo.setCampo("cantidad_adjudicada");
        cfgCampo.setTitulo("ADJUDICADO");
        cfgCampo.setCampoFormatter(new DecimalFormatter("#,##0"));

        cfgCampo.setTamano(100);
        configCampos.add(cfgCampo);

        cfgCampo = new ConfigCampoVO();
        cfgCampo.setCampo("modalidad");
        cfgCampo.setTitulo("TODO/NADA");
        cfgCampo.setTamano(100);
        configCampos.add(cfgCampo);

        cfgCampo = new ConfigCampoVO();
        cfgCampo.setCampo("minimo");
        cfgCampo.setTitulo("VALOR MÍNIMO");
        cfgCampo.setTamano(100);
        configCampos.add(cfgCampo);

        reporte.setTitulo("Reporte Pantalla");
        reporte.setSubtitulo("");
        reporte.setFormatoSalida("Web20");
        reporte.setArchivoSalida("salida2." + "Web20".toLowerCase());
        reporte.setQuery(query );
        reporte.setConfigCampos(configCampos);       

        return reporte.creaConsultaWeb20(app);
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quasar.frameq.fachadas;

import com.quasar.frameq.data.TipoDocumento;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Administrador
 */
public class FacadeTipoDocumento {

    private static final Logger logger = Logger.getLogger(FacadeTipoDocumento.class.getName());

    public List<TipoDocumento> RetornarDocumentos() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        TipoDocumento tp = new TipoDocumento();
        List<TipoDocumento> tiposDocumentos = new ArrayList<TipoDocumento>();

        try {

            tp.consultaLectura("select i_tipodocumento, c_nombredoc, c_validadv, c_dominio, c_codigobolsa, c_descripcion"
                    + " from dm_tipodocumento");
            while (tp.rs.next()) {
                TipoDocumento tpDoc = new TipoDocumento();
                tpDoc.cerrarConexiones();
                tpDoc.setTipodocumento(tp.rs.getInt("i_tipodocumento"));
                tpDoc.setNombredoc(tp.rs.getString("c_nombredoc"));
                tpDoc.setValidadv(tp.rs.getString("c_validadv"));
                tpDoc.setDominio(tp.rs.getString("c_dominio"));
                tpDoc.setCodigobolsa(tp.rs.getString("c_codigobolsa"));
                tpDoc.setDescripcion(tp.rs.getString("c_descripcion"));
                tiposDocumentos.add(tpDoc);
            }

        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeTipoDocumento.class.getName(), ex);

        } finally {
            tp.cerrarConexiones();

        }
        return tiposDocumentos;
    }

    public List<TipoDocumento> RetornarDocumentosOferente() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        TipoDocumento tp = new TipoDocumento();
        List<TipoDocumento> tiposDocumentos = new ArrayList<TipoDocumento>();
        try {
            tp.consultaLectura("select i_tipodocumento, c_nombredoc, c_validadv, c_dominio, c_codigobolsa, c_descripcion"
                    + " from dm_tipodocumento where c_aplica!='C'");
            while (tp.rs.next()) {
                TipoDocumento tpDoc = new TipoDocumento();
                tpDoc.cerrarConexiones();
                tpDoc.setTipodocumento(tp.rs.getInt("i_tipodocumento"));
                tpDoc.setNombredoc(tp.rs.getString("c_nombredoc"));
                tpDoc.setValidadv(tp.rs.getString("c_validadv"));
                tpDoc.setDominio(tp.rs.getString("c_dominio"));
                tpDoc.setCodigobolsa(tp.rs.getString("c_codigobolsa"));
                tpDoc.setDescripcion(tp.rs.getString("c_descripcion"));
                tiposDocumentos.add(tpDoc);
            }
            //tp.cerrarConexiones();

        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeTipoDocumento.class.getName(), ex);
            //tp.cerrarConexiones();
        } finally {
            tp.cerrarConexiones();

        }
        return tiposDocumentos;
    }

    public List<TipoDocumento> RetornarDocumentoApoderado() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        TipoDocumento tp = new TipoDocumento();
        List<TipoDocumento> tiposDocumentos = new ArrayList<TipoDocumento>();
        try {
            tp.consultaLectura("select i_tipodocumento, c_nombredoc, c_validadv, c_dominio, c_codigobolsa, c_descripcion"
                    + " from dm_tipodocumento where i_tipodocumento not in (3, 4)");
            while (tp.rs.next()) {
                TipoDocumento tpDoc = new TipoDocumento();
                tpDoc.cerrarConexiones();
                tpDoc.setTipodocumento(tp.rs.getInt("i_tipodocumento"));
                tpDoc.setNombredoc(tp.rs.getString("c_nombredoc"));
                tpDoc.setValidadv(tp.rs.getString("c_validadv"));
                tpDoc.setDominio(tp.rs.getString("c_dominio"));
                tpDoc.setCodigobolsa(tp.rs.getString("c_codigobolsa"));
                tpDoc.setDescripcion(tp.rs.getString("c_descripcion"));
                tiposDocumentos.add(tpDoc);
            }
            //tp.cerrarConexiones();
        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeTipoDocumento.class.getName(), ex);
            //tp.cerrarConexiones();
        } finally {
            tp.cerrarConexiones();
        }
        return tiposDocumentos;
    }

    public int existeDocumento(String nombre) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        TipoDocumento tp = new TipoDocumento();
        int existeID = 0;
        try {
            tp.consultaLectura("select i_tipodocumento from dm_tipodocumento where c_nombredoc = '" + nombre + "' Limit 1");
            if (tp.rs.first()) {
                existeID = tp.rs.getInt("i_tipodocumento");
            }
            // tp.cerrarConexiones();
        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeTipoDocumento.class.getName(), ex);
            //tp.cerrarConexiones();
        } finally {
            tp.cerrarConexiones();
        }
        return existeID;
    }

    public String devolverLetraDocumento(int idDoc) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        TipoDocumento tp = new TipoDocumento();
        String documento = "";
        try {
            tp.consultaLectura("select c_nombredoc from dm_tipodocumento where i_tipodocumento = '" + idDoc + "' Limit 1");         
            if (tp.rs.first()) {
                documento = tp.rs.getString("c_nombredoc");
            }
            //tp.cerrarConexiones();
        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeTipoDocumento.class.getName(), ex);
            //tp.cerrarConexiones();
        } finally {
            tp.cerrarConexiones();
        }
        return documento;
    }

    public List<TipoDocumento> RetornarDocumentoRepresentanteL() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        TipoDocumento tp = new TipoDocumento();
        List<TipoDocumento> tiposDocumentos = new ArrayList<TipoDocumento>();

        try {

            tp.consultaLectura("select i_tipodocumento, c_nombredoc, c_validadv, c_dominio, c_codigobolsa, c_descripcion"
                    + " from dm_tipodocumento"
                    + " where i_tipodocumento not like '6' and i_tipodocumento not like '4'");
            while (tp.rs.next()) {
                TipoDocumento tpDoc = new TipoDocumento();
                tpDoc.cerrarConexiones();
                tpDoc.setTipodocumento(tp.rs.getInt("i_tipodocumento"));
                tpDoc.setNombredoc(tp.rs.getString("c_nombredoc"));
                tpDoc.setValidadv(tp.rs.getString("c_validadv"));
                tpDoc.setDominio(tp.rs.getString("c_dominio"));
                tpDoc.setCodigobolsa(tp.rs.getString("c_codigobolsa"));
                tpDoc.setDescripcion(tp.rs.getString("c_descripcion"));
                tiposDocumentos.add(tpDoc);

            }
            // tp.cerrarConexiones();
        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeTipoDocumento.class.getName(), ex);
            //tp.cerrarConexiones();
        } finally {
            tp.cerrarConexiones();
        }
        return tiposDocumentos;
    }

}

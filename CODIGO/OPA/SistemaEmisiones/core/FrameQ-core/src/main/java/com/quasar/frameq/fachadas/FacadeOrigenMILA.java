/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quasar.frameq.fachadas;

import com.quasar.frameq.data.OrigenMILA;
import com.quasar.frameq.parametros.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Administrador
 */
public class FacadeOrigenMILA {

    private static final Logger logger = Logger.getLogger(FacadeOrigenMILA.class.getName());

    public List<OrigenMILA> RetornarOrigenMILA() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        OrigenMILA om = new OrigenMILA();
        List<OrigenMILA> origenMila = new ArrayList<OrigenMILA>();

        try {

            om.consultaLectura("SELECT i_id,codigo_pais, pais, tipo_doc, numero_doc,"
                    + " numero_ver, cuenta, estado, TD.c_nombredoc AS nombre_doc"
                    + " FROM dm_origen_mila om INNER JOIN dm_tipodocumento TD"
                    + " ON om.tipo_doc = TD.i_tipodocumento");
            while (om.rs.next()) {
                OrigenMILA oMila = new OrigenMILA();
                oMila.cerrarConexiones();
                oMila.setIdMila(om.rs.getInt("i_id"));
                oMila.setCodigoPais(om.rs.getInt("codigo_pais"));
                oMila.setPais(om.rs.getString("pais"));
                oMila.setTipoDocumento(om.rs.getInt("tipo_doc"));
                oMila.setNumeroDocumento(om.rs.getString("numero_doc"));
                oMila.setNumVerificacion(om.rs.getString("numero_ver"));
                oMila.setCuenta(om.rs.getString("cuenta"));
                oMila.setEstado(om.rs.getInt("estado"));
                oMila.setNombreTipoDocumento(om.rs.getString("nombre_doc"));
                origenMila.add(oMila);
            }

        } catch (SQLException ex) {
            logger.error("OPA1 - " + FacadeOrigenMILA.class.getName(), ex);

        } finally {
            om.cerrarConexiones();

        }
        return origenMila;
    }
    
    public List<OrigenMILA> RetornarOrigenMILActivos() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        OrigenMILA om = new OrigenMILA();
        List<OrigenMILA> origenMila = new ArrayList<OrigenMILA>();

        try {

            om.consultaLectura("select i_id, codigo_pais, pais, tipo_doc, numero_doc, numero_ver, cuenta, estado"
                    + " from dm_origen_mila WHERE estado=1");
            while (om.rs.next()) {
                OrigenMILA oMila = new OrigenMILA();
                oMila.cerrarConexiones();
                oMila.setIdMila(om.rs.getInt("i_id"));
                oMila.setCodigoPais(om.rs.getInt("codigo_pais"));
                oMila.setPais(om.rs.getString("pais"));
                oMila.setTipoDocumento(om.rs.getInt("tipo_doc"));
                oMila.setNumeroDocumento(om.rs.getString("numero_doc"));
                oMila.setNumVerificacion(om.rs.getString("numero_ver"));
                oMila.setCuenta(om.rs.getString("cuenta"));
                oMila.setEstado(om.rs.getInt("estado"));
                origenMila.add(oMila);
            }

        } catch (SQLException ex) {
            logger.error("OPA1 - " + FacadeOrigenMILA.class.getName(), ex);

        } finally {
            om.cerrarConexiones();

        }
        return origenMila;
    }

    public List<OrigenMILA> ListarMilaFiltros(String codigoPais, String pais, int estado) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        OrigenMILA om = new OrigenMILA();
        List<OrigenMILA> origenMila = new ArrayList<OrigenMILA>();
        String sqlquery = "";

 
        try {
            sqlquery = ("SELECT i_id, codigo_pais, pais, c_nombredoc, cuenta, "
                    + "  numero_doc, numero_ver, tipo_doc, estado "
                    + " FROM dm_origen_mila om "
                    + " INNER JOIN dm_tipodocumento td ON tipo_doc = td.i_tipodocumento");

            if (!codigoPais.equals("")) {
                sqlquery = sqlquery.concat(" AND om.codigo_pais= " + codigoPais);
            }

            if (!pais.equals("")) {
                sqlquery = sqlquery.concat(" AND om.pais LIKE '%" + pais + "%'");
            }

            if (estado != 3) {
                sqlquery = sqlquery.concat(" AND om.estado=" + estado);
            }
            sqlquery = sqlquery.concat(" ORDER BY codigo_pais");
            om.consultaLectura(sqlquery);

            while (om.rs.next()) {
                OrigenMILA oMila = new OrigenMILA();
                oMila.cerrarConexiones();
                
                oMila.setIdMila(om.rs.getInt("i_id"));
                oMila.setCodigoPais(om.rs.getInt("codigo_pais"));
                oMila.setPais(om.rs.getString("pais"));
                oMila.setTipoDocumento(om.rs.getInt("tipo_doc"));
                oMila.setNumeroDocumento(om.rs.getString("numero_doc"));
                oMila.setNumVerificacion(om.rs.getString("numero_ver"));
                oMila.setNombreTipoDocumento(om.rs.getString("c_nombredoc"));
                oMila.setCuenta(om.rs.getString("cuenta"));
                oMila.setEstado(om.rs.getInt("estado"));
                origenMila.add(oMila);;
               
            }
            // form.cerrarConexiones();

        } catch (SQLException ex) {
            logger.error("OPA1 - " + FacadeSCB.class.getName(), ex);
            // form.cerrarConexiones();
        } finally {
            om.cerrarConexiones();
        }
        return origenMila;
    }

    public String IngresarOrigenMILA(OrigenMILA om) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String result = "Error";
        Parametro crearscb = new Parametro();
        try {
            crearscb.Insert("INSERT INTO dm_origen_mila (codigo_pais, pais, tipo_doc, numero_doc, numero_ver, cuenta, estado) "
                    + "	VALUES (" + om.getCodigoPais() + ", '" + om.getPais() + "', '" + om.getTipoDocumento() + "', " + om.getNumeroDocumento() + ", '" + om.getNumVerificacion()
                    + "', '" + om.getCuenta() + "', '" + om.getEstado() + "')");

        } catch (SQLException e) {
            logger.error("OPA1 - " + FacadeOrigenMILA.class.getName(), e);
            result = "Error";
        } finally {
            crearscb.cerrarConexiones();
        }
        return result;
    }

    public String ModificarOrigenMILA(OrigenMILA om) {

        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String result = "Error";
        Parametro crearscb = new Parametro();
        try {
            crearscb.actualizar("UPDATE dm_origen_mila SET codigo_pais ='" + om.getCodigoPais() + "', pais ='" + om.getPais() + "', tipo_doc= '" + om.getTipoDocumento()
                    + "', numero_doc= " + om.getNumeroDocumento() + " ,  numero_ver= '" + om.getNumVerificacion() + "' , cuenta= '" + om.getCuenta() + "', "
                    + " estado= '" + om.getEstado() + "' WHERE i_id = '" + om.getIdMila() + "'");

        } catch (Exception e) {
            logger.error("OPA1 - " + FacadeOrigenMILA.class.getName(), e);

        } finally {
            crearscb.cerrarConexiones();
        }
        return result;
    }
    
    public boolean ValidarCodigoPais(String codigoPais) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        OrigenMILA sc = new OrigenMILA();
        boolean validar = false;

        try {
            sc.consultaLectura("SELECT codigo_pais FROM dm_origen_mila WHERE codigo_pais= " + codigoPais);
            if (sc.rs.next()) {
                validar = true;
            }
            //sc.cerrarConexiones();
        } catch (SQLException ex) {
            logger.error("OPA1 - " + FacadeOrigenMILA.class.getName(), ex);
            //sc.cerrarConexiones();
        } finally {
            sc.cerrarConexiones();
        }
        return validar;
    }
    
    public boolean ValidarDocumento(String documento) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        OrigenMILA sc = new OrigenMILA();
        boolean validar = false;

        try {
            sc.consultaLectura("SELECT numero_doc FROM dm_origen_mila WHERE numero_doc= " + documento);
            if (sc.rs.next()) {
                validar = true;
            }
            //sc.cerrarConexiones();
        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeOrigenMILA.class.getName(), ex);
            //sc.cerrarConexiones();
        } finally {
            sc.cerrarConexiones();
        }
        return validar;
    }

}

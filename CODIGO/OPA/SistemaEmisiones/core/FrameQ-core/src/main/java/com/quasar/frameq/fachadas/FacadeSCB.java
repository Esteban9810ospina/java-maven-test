/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quasar.frameq.fachadas;

import com.quasar.frameq.data.SCB;
import com.quasar.frameq.parametros.Parametro;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author jam
 */
public class FacadeSCB {

    private static final Logger logger = Logger.getLogger(FacadeSCB.class.getName());
    public List<SCB> RetornarSCB() {
        
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        SCB sc = new SCB();
        List<SCB> tiposSCB = new ArrayList<SCB>();

        try {
            sc.consultaLectura("select *from dm_scb where estado !=2 ORDER BY i_scb");
            while (sc.rs.next()) {

                SCB sc1 = new SCB();
                sc1.cerrarConexiones();
                sc1.setIdScb(sc.rs.getInt("i_scb"));
                sc1.setNombredoc(sc.rs.getString("c_documento"));
                sc1.setTipoDoc(sc.rs.getInt("i_tipodocumento"));
                sc1.setCodigoEntidad(sc.rs.getString("i_codigoentidad"));
                sc1.setRazonSocial(sc.rs.getString("c_razonsocial"));
                sc1.setTipoPersona(sc.rs.getString("c_tipopersona"));
                sc1.setRepresentante(sc.rs.getString("c_representante"));
                sc1.setDireccion(sc.rs.getString("c_direccion"));
                sc1.setTelefono(sc.rs.getString("c_telefono"));
                sc1.setFax(sc.rs.getString("c_fax"));
                sc1.setPais(sc.rs.getString("c_pais"));
                sc1.setCodDep(sc.rs.getInt("i_codigodepto"));
                sc1.setCodPais(sc.rs.getInt("i_codigociudad"));
                sc1.setEntidadColocadora(sc.rs.getInt("i_entidadcolocadora"));

                tiposSCB.add(sc1);
            }
            //sc.cerrarConexiones();

        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeSCB.class.getName(), ex);
            //sc.cerrarConexiones();
        } finally {
            sc.cerrarConexiones();
        }
        return tiposSCB;
    }

    public List<List<String>> Listarscb() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        SCB form = new SCB();
        List<List<String>> listDatSCB = new ArrayList<List<String>>();
        String sqlquery = "";

        for (int i = 0; i <= 24; i++) {
            listDatSCB.add(new ArrayList<String>());
        }

        try {
            sqlquery = ("SELECT scb.i_scb, scb.c_documento, td.c_nombredoc, scb.i_codigoentidad, scb.c_razonsocial, "
                    + " scb.c_tipopersona, scb.c_representante, scb.c_direccion, c_telefono, "
                    + " scb.c_fax, scb.c_pais, scb.i_codigodepto, scb.i_codigociudad, scb.i_entidadcolocadora, "
                    + " scb.c_representante, scb.c_representante2, scb.c_representante3, scb.c_digito_verificacion, scb.estado, " 
                    + " CASE WHEN (scb.c_tipodoc_representante = 0) THEN 'Seleccione' "
                    + " WHEN (scb.c_tipodoc_representante = 1) THEN 'Cédula de Ciudadanía' " 
                    + " WHEN (scb.c_tipodoc_representante = 2) THEN 'Cédula de Extranjería' " 
                    + " WHEN (scb.c_tipodoc_representante = 3) THEN 'Pasaporte' " 
                    + " WHEN (scb.c_tipodoc_representante = 5) THEN 'NIP o NUIP'  END AS nombredoc1, scb.c_numdoc_representante," 
                    + " CASE WHEN (scb.c_tipodoc_representante2 = 0) THEN 'Seleccione' " 
                    + " WHEN (scb.c_tipodoc_representante2 = 1) THEN 'Cédula de Ciudadanía' " 
                    + " WHEN (scb.c_tipodoc_representante2 = 2) THEN 'Cédula de Extranjería' " 
                    + " WHEN (scb.c_tipodoc_representante2 = 3) THEN 'Pasaporte' " 
                    + " WHEN (scb.c_tipodoc_representante2 = 5) THEN 'NIP o NUIP'  END AS nombredoc2,scb.c_numdoc_representante2, " 
                    + " CASE WHEN (scb.c_tipodoc_representante3 = 0) THEN 'Seleccione' "
                    + " WHEN (scb.c_tipodoc_representante3 = 1) THEN 'Cédula de Ciudadanía' "
                    + " WHEN (scb.c_tipodoc_representante3 = 2) THEN 'Cédula de Extranjería'  " 
                    + " WHEN (scb.c_tipodoc_representante3 = 3) THEN 'Pasaporte' " 
                    + " WHEN (scb.c_tipodoc_representante3 = 5) THEN 'NIP o NUIP'  END AS nombredoc3,scb.c_numdoc_representante3"
                    + "	FROM dm_scb scb "
                    + " INNER JOIN dm_tipodocumento td WHERE "
                    + "	scb.i_tipodocumento = td.i_tipodocumento " 
                    + " ORDER BY scb.i_scb ");
            
               form.consultaLectura(sqlquery);

            while (form.rs.next()) {

                listDatSCB.get(0).add(String.valueOf(form.rs.getInt("scb.i_scb")));
                listDatSCB.get(1).add(form.rs.getString("scb.c_documento"));
                listDatSCB.get(2).add(form.rs.getString("td.c_nombredoc"));
                listDatSCB.get(3).add(form.rs.getString("scb.c_razonsocial"));
                listDatSCB.get(4).add(form.rs.getString("scb.c_tipopersona"));
                listDatSCB.get(5).add(form.rs.getString("scb.c_representante"));
                listDatSCB.get(6).add(form.rs.getString("scb.c_direccion"));
                listDatSCB.get(7).add(form.rs.getString("scb.c_telefono"));
                listDatSCB.get(8).add(form.rs.getString("scb.c_fax"));
                listDatSCB.get(9).add(form.rs.getString("scb.c_pais"));
                listDatSCB.get(10).add(form.rs.getString("scb.i_codigodepto"));
                listDatSCB.get(11).add(form.rs.getString("scb.i_codigociudad"));
                listDatSCB.get(12).add(form.rs.getString("scb.i_entidadcolocadora"));
                listDatSCB.get(13).add(form.rs.getString("scb.c_representante2"));
                listDatSCB.get(14).add(form.rs.getString("scb.c_representante3"));
                listDatSCB.get(15).add(form.rs.getString("scb.c_digito_verificacion"));
                listDatSCB.get(16).add(form.rs.getString("scb.estado"));
                listDatSCB.get(17).add(form.rs.getString("scb.i_codigoentidad"));
                listDatSCB.get(18).add(form.rs.getString("nombredoc1"));
                listDatSCB.get(19).add(form.rs.getString("scb.c_numdoc_representante"));
                listDatSCB.get(20).add(form.rs.getString("nombredoc2"));
                listDatSCB.get(21).add(form.rs.getString("scb.c_numdoc_representante2"));
                listDatSCB.get(22).add(form.rs.getString("nombredoc3"));
                listDatSCB.get(23).add(form.rs.getString("scb.c_numdoc_representante3"));

            }
            //form.cerrarConexiones();

        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeSCB.class.getName(), ex);
            //form.cerrarConexiones();
        } finally {
            form.cerrarConexiones();
        }
        return listDatSCB;
    }

    public List<List<String>> ListarscbFiltros(String codigoscb, String entidad, int comboEst) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        SCB form = new SCB();
        List<List<String>> listDatSCB = new ArrayList<List<String>>();
        String sqlquery = "";

        for (int i = 0; i <= 24; i++) {
            listDatSCB.add(new ArrayList<String>());
        }

        try {
            sqlquery = ("SELECT scb.i_scb, scb.i_codigoentidad, scb.c_documento, td.c_nombredoc, scb.c_razonsocial, "
                    + " scb.c_tipopersona, scb.c_representante, scb.c_direccion, c_telefono, "
                    + " scb.c_fax, scb.c_pais, scb.i_codigodepto, scb.i_codigociudad, scb.i_entidadcolocadora, "
                    + " scb.c_representante, scb.c_representante2, scb.c_representante3, scb.c_digito_verificacion, scb.estado, "
                    + " CASE WHEN (scb.c_tipodoc_representante = 0) THEN 'Seleccione' "
                    + " WHEN (scb.c_tipodoc_representante = 1) THEN 'Cédula de Ciudadanía' " 
                    + " WHEN (scb.c_tipodoc_representante = 2) THEN 'Cédula de Extranjería' " 
                    + " WHEN (scb.c_tipodoc_representante = 3) THEN 'Pasaporte' " 
                    + " WHEN (scb.c_tipodoc_representante = 5) THEN 'NIP o NUIP'  END AS nombredoc1, scb.c_numdoc_representante," 
                    + " CASE WHEN (scb.c_tipodoc_representante2 = 0) THEN 'Seleccione' " 
                    + " WHEN (scb.c_tipodoc_representante2 = 1) THEN 'Cédula de Ciudadanía' " 
                    + " WHEN (scb.c_tipodoc_representante2 = 2) THEN 'Cédula de Extranjería' " 
                    + " WHEN (scb.c_tipodoc_representante2 = 3) THEN 'Pasaporte' " 
                    + " WHEN (scb.c_tipodoc_representante2 = 5) THEN 'NIP o NUIP'  END AS nombredoc2,scb.c_numdoc_representante2, " 
                    + " CASE WHEN (scb.c_tipodoc_representante3 = 0) THEN 'Seleccione' "
                    + " WHEN (scb.c_tipodoc_representante3 = 1) THEN 'Cédula de Ciudadanía' "
                    + " WHEN (scb.c_tipodoc_representante3 = 2) THEN 'Cédula de Extranjería'  " 
                    + " WHEN (scb.c_tipodoc_representante3 = 3) THEN 'Pasaporte' " 
                    + " WHEN (scb.c_tipodoc_representante3 = 5) THEN 'NIP o NUIP'  END AS nombredoc3,scb.c_numdoc_representante3"
                    + " FROM dm_scb scb "
                    + " INNER JOIN dm_tipodocumento td ON scb.i_tipodocumento = td.i_tipodocumento WHERE 1=1");

            if (!codigoscb.equals("")) {
                sqlquery = sqlquery.concat(" AND scb.i_codigoentidad= " + codigoscb);
            }

            if (!entidad.equals("")) {
                sqlquery = sqlquery.concat(" AND scb.c_razonsocial LIKE '%" + entidad + "%'");
            }

            if (comboEst != 3) {
                sqlquery = sqlquery.concat(" AND scb.estado=" + comboEst);
            }
            sqlquery = sqlquery.concat(" ORDER BY scb.i_scb");

            form.consultaLectura(sqlquery);

            while (form.rs.next()) {

                listDatSCB.get(0).add(String.valueOf(form.rs.getInt("scb.i_scb")));
                listDatSCB.get(1).add(form.rs.getString("scb.c_documento"));
                listDatSCB.get(2).add(form.rs.getString("td.c_nombredoc"));
                listDatSCB.get(3).add(form.rs.getString("scb.c_razonsocial"));
                listDatSCB.get(4).add(form.rs.getString("scb.c_tipopersona"));
                listDatSCB.get(5).add(form.rs.getString("scb.c_representante"));
                listDatSCB.get(6).add(form.rs.getString("scb.c_direccion"));
                listDatSCB.get(7).add(form.rs.getString("scb.c_telefono"));
                listDatSCB.get(8).add(form.rs.getString("scb.c_fax"));
                listDatSCB.get(9).add(form.rs.getString("scb.c_pais"));
                listDatSCB.get(10).add(form.rs.getString("scb.i_codigodepto"));
                listDatSCB.get(11).add(form.rs.getString("scb.i_codigociudad"));
                listDatSCB.get(12).add(form.rs.getString("scb.i_entidadcolocadora"));
                listDatSCB.get(13).add(form.rs.getString("scb.c_representante2"));
                listDatSCB.get(14).add(form.rs.getString("scb.c_representante3"));
                listDatSCB.get(15).add(form.rs.getString("scb.c_digito_verificacion"));
                listDatSCB.get(16).add(form.rs.getString("scb.estado"));
                listDatSCB.get(17).add(form.rs.getString("scb.i_codigoentidad"));
                listDatSCB.get(18).add(form.rs.getString("nombredoc1"));
                listDatSCB.get(19).add(form.rs.getString("scb.c_numdoc_representante"));
                listDatSCB.get(20).add(form.rs.getString("nombredoc2"));
                listDatSCB.get(21).add(form.rs.getString("scb.c_numdoc_representante2"));
                listDatSCB.get(22).add(form.rs.getString("nombredoc3"));
                listDatSCB.get(23).add(form.rs.getString("scb.c_numdoc_representante3"));

            }
            // form.cerrarConexiones();

        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeSCB.class.getName(), ex);
            // form.cerrarConexiones();
        } finally {
            form.cerrarConexiones();
        }
        return listDatSCB;
    }

    public String RetornarSCBusuario(int usuario) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        SCB sc = new SCB();
        String scb = "";
        String Idscb = "";
        String cadena = "";
        String codigo = "";

        try {
            sc.consultaLectura("SELECT sc.i_codigoentidad codigoscb, sc.c_razonsocial SCB, sc.i_scb id FROM dm_scb sc "
                    + " INNER JOIN fqs_usuario us ON us.i_cod_agente= sc.i_scb "
                    + " WHERE us.i_usuario=" + usuario + "");
            if (sc.rs.next()) {
                codigo = sc.rs.getString("codigoscb");
                scb = sc.rs.getString("SCB");
                Idscb = String.valueOf(sc.rs.getInt("id"));
                cadena = codigo + ";" + scb + ";" + Idscb;
            }
            
        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeSCB.class.getName(), ex);
            
        } finally {
            sc.cerrarConexiones();
        }
        return cadena;
    }

    public boolean ValidarCodigoSCB(String codigoScb) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        SCB sc = new SCB();
        String scb = "";
        String Idscb = "";
        boolean validar = false;

        try {
            sc.consultaLectura("SELECT i_codigoentidad FROM dm_scb WHERE i_codigoentidad= " + codigoScb);
            if (sc.rs.next()) {
                scb = sc.rs.getString("i_codigoentidad");
                validar = true;
            }
            //sc.cerrarConexiones();
        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeSCB.class.getName(), ex);
            //sc.cerrarConexiones();
        } finally {
            sc.cerrarConexiones();
        }
        return validar;
    }

    public String RetornarSCBusuarioSelect(int idscb) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        SCB sc = new SCB();
        String scb = "";

        try {
            sc.consultaLectura("SELECT c_razonsocial nombre FROM dm_scb  WHERE  i_scb = " + idscb + "");
            if (sc.rs.next()) {

                scb = sc.rs.getString("nombre");

            }
            //sc.cerrarConexiones();
        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeSCB.class.getName(), ex);
            //sc.cerrarConexiones();
        } finally {
            sc.cerrarConexiones();
        }
        return scb;
    }

    public String RetornarSCBusuarioSelectid(int idscb) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        SCB sc = new SCB();
        String scb = "";

        try {
            sc.consultaLectura("SELECT i_codigoentidad FROM dm_scb  WHERE  i_scb = " + idscb + "");
            if (sc.rs.next()) {

                scb = sc.rs.getString("i_codigoentidad");

            }
            //sc.cerrarConexiones();
        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeSCB.class.getName(), ex);
            //sc.cerrarConexiones();
        } finally {
            sc.cerrarConexiones();
        }
        return scb;
    }

    public String IngresarSCB(String codigoScb, String nombreScb, int tipoDocumento, String documento, String digitoVerificacion, String c_direccion, String telefono, String representante, String representante2, String representante3, int estado, int tipodocumento1, String documento1, int tipodocumento2, String documento2, int tipodocumento3, String documento3) {
        
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String result = "Error";
        Parametro crearscb = new Parametro();
        try {
            crearscb.Insert("INSERT INTO dm_scb (i_scb, i_codigoentidad, c_razonsocial, i_tipodocumento, c_documento, c_digito_verificacion, "
                    + " c_direccion, c_telefono, c_representante, c_representante2, c_representante3, "
                    + " estado, c_tipodoc_representante,c_numdoc_representante, c_tipodoc_representante2, c_numdoc_representante2, c_tipodoc_representante3,c_numdoc_representante3) "
                    + "	VALUES (" + codigoScb + ", '" + codigoScb + "', '" + nombreScb + "', " + tipoDocumento + ", '" + documento + "', '" + digitoVerificacion + "', '" + c_direccion + "', '" + telefono + "', '" + representante + "', "
                    + " '" + representante2 + "', '" + representante3 + "', " + estado + ", " + tipodocumento1 + ", '" + documento1 + "'," + tipodocumento2 + ", '" + documento2 + "'," + tipodocumento3 + ", '" + documento3 + "')");

            //crearscb.cerrarConexiones();
        } catch (SQLException e) {
            logger.error("OPA - " + FacadeSCB.class.getName(), e);
            //crearscb.cerrarConexiones();
            result = "Error";
        } finally {
            crearscb.cerrarConexiones();
        }
        return result;
    }

    public String ModificarSCB(String codigoScb, String nombreScb, int tipoDocumento, String documento, String digitoVerificacion, String c_direccion, String telefono, String representante, String representante1, String representante2, int estado, int tipodocumento1, String documento1, int tipodocumento2, String documento2, int tipodocumento3, String documento3) {

        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String result = "Error";
        Parametro crearscb = new Parametro();
        try {
            crearscb.actualizar("UPDATE dm_scb SET i_scb ='" + codigoScb + "', i_codigoentidad ='" + codigoScb + "', c_razonsocial= '" + nombreScb + "', i_tipodocumento= " + tipoDocumento + " ,  c_documento= '" + documento + "' , c_digito_verificacion= '" + digitoVerificacion + "', "
                    + " c_direccion= '" + c_direccion + "', c_telefono= '" + telefono + "', c_representante= '" + representante + "' , c_representante2= '" + representante1 + "' , c_representante3= '" + representante2 + " ', "
                    + " estado= '" + estado + "', c_tipodoc_representante= " + tipodocumento1 + ", c_numdoc_representante= '" + documento1 + "', c_tipodoc_representante2 = " + tipodocumento2 + ", c_numdoc_representante2 ='" + documento2 + "', c_tipodoc_representante3 = " + tipodocumento3 + ", c_numdoc_representante3 ='" + documento3 + "' "
                    + " WHERE i_codigoentidad = '" + codigoScb + "'");
            //crearscb.cerrarConexiones();
        } catch (Exception e) {
            logger.error("OPA - " + FacadeSCB.class.getName(), e);
            //crearscb.cerrarConexiones();

        } finally {
            crearscb.cerrarConexiones();
        }
        return result;
    }

    public List<List<String>> UsuariosActivosScb(String codigoScb) {

        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Parametro scb = new Parametro();
        List<List<String>> usuActivos = new ArrayList<List<String>>();

        for (int i = 0; i <= 2; i++) {
            usuActivos.add(new ArrayList<String>());
        }

        try {
            scb.consultaLectura("SELECT usu.i_usuario, usu.c_estado, scb.i_scb FROM fqs_usuario usu "
                    + "INNER JOIN dm_scb scb WHERE scb.i_codigoentidad = " + codigoScb + " AND  (usu.c_estado LIKE '%A%' OR usu.c_estado LIKE '%B%')"
                    + "AND scb.i_scb=usu.i_cod_agente");

            while (scb.rs.next()) {
                usuActivos.get(0).add(scb.rs.getString("usu.i_usuario"));
                usuActivos.get(1).add(scb.rs.getString("usu.c_estado"));
                usuActivos.get(2).add(scb.rs.getString("scb.i_scb"));

            }
            //scb.cerrarConexiones();
        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeSCB.class.getName(), ex);
        } finally {
            scb.cerrarConexiones();
        }

        return usuActivos;
    }

}

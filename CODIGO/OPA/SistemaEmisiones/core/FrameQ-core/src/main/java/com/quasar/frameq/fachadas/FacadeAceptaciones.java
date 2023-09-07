/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quasar.frameq.fachadas;

import com.quasar.frameq.data.Aceptaciones;
import com.quasar.frameq.data.Formulario;
import com.quasar.frameq.data.Parametrizacion;
import com.quasar.frameq.data.SCB;
import com.quasar.frameq.db.Facade;
import com.quasar.frameq.parametros.Parametro;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Colsubsidio
 */
public class FacadeAceptaciones {

    private static final Logger logger = Logger.getLogger(FacadeAceptaciones.class.getName());
    
    private final String QUERY_DATOS_PARAM = "SELECT PAR.TextoUno, CONCAT((SELECT CONCAT(LetraDia, ' (', EntidadDeNegociosID, ')')"
                    + " FROM Diccionarios_DiasLetras WHERE EntidadDeNegociosID = DAY(NOW())), "
                    + " DATE_FORMAT(PAR.FechaIniOperacion, CONCAT(' De ', '%M', ' del ','%Y'))) AS 'FECHA', "
                    + " PAR.ClaseAcciones, PAR.ExistePreacuerdo, PAR.TextoDos, PAR.TextoTres, PAR.TextoCuatro, PAR.TextoCinco, "
                    + " PAR.tipo_oferta_publica, PAR.tipo_pago "
                    + " FROM fqs_Parametrizacion AS PAR; ";

    public String retornaFechaAceptacion(int usuario) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String fecha = "";
        Parametro Traesesion = new Parametro();
        try {
            Traesesion.consultaLectura("SELECT CONCAT((SELECT concat(LetraDia, ' (', EntidadDeNegociosID, ')')  FROM Diccionarios_DiasLetras WHERE EntidadDeNegociosID = DAY(NOW())), DATE_FORMAT(FechaIniOperacion, Concat(' De ', '%M', ' del ','%Y'))) AS 'FECHA' FROM fqs_Parametrizacion ");
            if (Traesesion.rs.first()) {
                fecha = Traesesion.rs.getString("FECHA");
                //Traesesion.cerrarConexiones();
            }
        } catch (SQLException e) {
            logger.error("OPA - " + FacadeAceptaciones.class.getName(), e);

        } finally {
            Traesesion.cerrarConexiones();
        }
        return fecha;
    }

    public String[] RetornarDatosParam() {

        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Parametro par = new Parametro();
        String[] listPar = null;
        @SuppressWarnings("UnusedAssignment")
        String texto1 = " ";
        String fecha = " ";
        String claseA = " ";
        String prea = " ";
        String texto2 = " ";
        String texto3 = " ";
        String texto4 = " ";

        try {
            par.consultaLectura(QUERY_DATOS_PARAM);
            if (par.rs.first()) {

                texto1 = par.rs.getString("TextoUno");
                fecha = par.rs.getString("FECHA");
                claseA = par.rs.getString("ClaseAcciones");
                prea = par.rs.getString("ExistePreacuerdo");
                texto2 = par.rs.getString("TextoDos");
                texto3 = par.rs.getString("TextoTres");
                texto4 = par.rs.getString("TextoCuatro");

                listPar = new String[]{texto1, fecha, claseA, prea, texto2, texto3, texto4};

            }

        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeAceptaciones.class.getName(), ex);

        } finally {
            par.cerrarConexiones();
        }
        return listPar;
    }
    
    public Parametrizacion retornarParametrizacionParcial() {

        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Parametro par = new Parametro();
        String[] listPar = null;
        @SuppressWarnings("UnusedAssignment")

        Parametrizacion parametrizacion = new Parametrizacion();

        try {
            par.consultaLectura(QUERY_DATOS_PARAM);
            if (par.rs.first()) {

                parametrizacion.setTextoUno(par.rs.getString("TextoUno"));
                parametrizacion.setTextoDos(par.rs.getString("TextoDos"));
                parametrizacion.setTextoTres(par.rs.getString("TextoTres"));
                parametrizacion.setTextoCuatro(par.rs.getString("TextoCuatro"));
                parametrizacion.setFecha(par.rs.getString("FECHA"));
                parametrizacion.setClaseAcciones(par.rs.getString("ClaseAcciones"));
                parametrizacion.setExistePreacuerdo(par.rs.getString("ExistePreacuerdo"));
                
                //listPar = new String[]{texto1, fecha, claseA, prea, texto2, texto3, texto4};
            }

        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeAceptaciones.class.getName(), ex);

        } finally {
            par.cerrarConexiones();
        }
        return parametrizacion;
    }

    //ingresar aceptación OPA
    public String IngresarAceptacion(String claseAcciones, String consecutivo, String texto1, String texto2, String preacuerdo,
            String codigoScb, String nombreScb, String representante, String nombre, Double numAcciones, Integer TN,
            int tipoDoc, String numDoc, Double numVer, String fiduciario, String cuentaInv, int usuario,
            String fecha, int usuarioMod, String fechaMod, String nomUsuario, Double porcentajeComision, Double precioAccion, String direccion,int idMila) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        
        //
        Double monto = 0.0;
        BigDecimal a = new BigDecimal(precioAccion.toString());
        BigDecimal precio1 = new BigDecimal(numAcciones);
        BigDecimal tot = a.multiply(precio1).setScale(2, RoundingMode.DOWN);
        monto = tot.doubleValue();
        //
        
        String result = "Error";
        Parametro crearAceptacion = new Parametro();
        String estado = "Ingresado";
        String tipMod = "Ingreso Demanda - Insercin";
        try {
            int indices[] = obtenerSecuenciasFormulario();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date now = new Date();
            String fechafin = sdf.format(now);
            crearAceptacion.Insert(
                    "INSERT INTO fqs_CrearAceptacion (EntidadDeNegociosID,ClaseAcciones, ConOfeVen, TextoUno,  "
                    + " TextoDos, ExistePreacuerdo, CodScb, NombreSCB, RepresentanteLegal, NombreRazonSocial, NumAcciones, VenCon, "
                    + " TipDocumento, NumNitDoc, NumVer, EspFid, CtaInv, NombreUsuarioIdCreacion, FechaCreacion, NombreUsuarioIdModificacion, "
                    + " FechaModificacion, estado,PorcentajeComision, c_usuario_sistema_ultima_mod, c_tipo_modificacion, MontoTotalEfectivo, tipo_oferta_publica, direccion,idMila) "
                    + "VALUES (" + indices[0] + ", '" + claseAcciones + "', '" + consecutivo 
                    + "', '" + texto1 + "', '" + texto2 + "', " + preacuerdo + ", '" + codigoScb + "', "
                    + " '" + nombreScb + "', '" + representante + "', '" + nombre
                    + "', " +  numAcciones + ", " + TN + ", " + tipoDoc + ", '" + numDoc + "', " 
                    + numVer + ", '" + fiduciario + "', " + " '" + cuentaInv + "', " 
                    + usuario + ", '" + fecha + "', " + usuarioMod + ", '" + fechaMod 
                    + "', '" + estado + "'," + porcentajeComision + ", '" + nomUsuario 
                    + "', '" + tipMod + "'," + monto + ", 'OPA', '" + direccion+ "','" + idMila + "')");
            
            result = "Oferta Ingresada No." + indices[0] + " radicada con fecha " + fechafin + "";
            //crearAceptacion.cerrarConexiones();
        } catch (SQLException e) {
            logger.error("OPA - " + FacadeAceptaciones.class.getName(), e);
            //crearAceptacion.cerrarConexiones();
            result = "Error";
        } finally {
            crearAceptacion.cerrarConexiones();
        }
        return result;
    }
         
    //Ingresar Aceptación OPI
    public String IngresarAceptacion(String claseAcciones, String consecutivo, String texto1, String texto2, String preacuerdo,
            String codigoScb, String nombreScb, String representante, String nombre, Double numAcciones, Integer TN,
            int tipoDoc, String numDoc, Double numVer, String fiduciario, String cuentaInv, int usuario,
            String fecha, int usuarioMod, String fechaMod, String nomUsuario, Double porcentajeComision, Double porcentajePagoEfectivo, int tipoPago ,Double precioAccion, String condicion1, String condicion2, String direccion,int idMila) {

        PropertyConfigurator.configure("/apps/OPI/logs/opi-log4j.properties");
        Double monto = 0.0;
        BigDecimal a = new BigDecimal(precioAccion.toString());
        BigDecimal precio1 = new BigDecimal(numAcciones);
        BigDecimal tot = a.multiply(precio1);
        monto = tot.doubleValue();

        String result = "Error";
        Parametro crearAceptacion = new Parametro();
        String estado = "Ingresado";
        String tipMod = "Ingreso Demanda - Inserción";  
        try {

            int indices[] = obtenerSecuenciasFormulario();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date now = new Date();
            String fechafin = sdf.format(now);
            
            crearAceptacion.Insert("INSERT INTO fqs_CrearAceptacion (EntidadDeNegociosID,ClaseAcciones, ConOfeVen, TextoUno,  "
                    + " TextoDos, ExistePreacuerdo, CodScb, NombreSCB, RepresentanteLegal, NombreRazonSocial, NumAcciones, VenCon, "
                    + " TipDocumento, NumNitDoc, NumVer, EspFid, CtaInv, NombreUsuarioIdCreacion, FechaCreacion, NombreUsuarioIdModificacion, "
                    + " FechaModificacion, estado, PorcentajeComision, PorcentajePagoEfectivo, tipo_pago, MontoTotalEfectivo,Condicion1,Condicion2, c_usuario_sistema_ultima_mod, c_tipo_modificacion,  tipo_oferta_publica, direccion, idMila) VALUES (" + indices[0] + ", '" + claseAcciones + "', '" + consecutivo + "', '" + texto1 + "', '" + texto2 + "', " + preacuerdo + ", '" + codigoScb + "', "
                    + " '" + nombreScb + "', '" + representante + "', '" + nombre + "', " + numAcciones + ", " + TN + ", " + tipoDoc + ", '" + numDoc + "', " + numVer + ", '" + fiduciario + "', "
                    + " '" + cuentaInv + "', " + usuario + ", '" + fecha + "', " + usuarioMod + ", '" + fechaMod + "', '" + estado + "'," + porcentajeComision + "," + porcentajePagoEfectivo + "," + tipoPago +"," + monto + ",'" + condicion1 + "','" + condicion2 + "', '" + nomUsuario + "', '" + tipMod + "', 'OPI', '"+ direccion+ "','" + idMila + "')");
            result = "Oferta Ingresada No." + indices[0] + " radicada con fecha " + fechafin + "";
            crearAceptacion.cerrarConexiones();
        } catch (SQLException ex) {
            logger.error("OPI - " + FacadeAceptaciones.class.getName(), ex);
            crearAceptacion.cerrarConexiones();
            result = "Error";
        } finally {
            crearAceptacion.cerrarConexiones();
        }
        return result;
    }

    public boolean RetornaConsecutivo(String consecutivo) {

        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        boolean result = false;
        Parametro Traconsecutivo = new Parametro();
        try {
            Traconsecutivo.consultaG("SELECT IFNULL(EntidadDeNegociosID, 'O.K.') AS 'Validacion' FROM fqs_CrearAceptacion WHERE ConOfeVen = ?", consecutivo);
            if (Traconsecutivo.rs.first()) {
                result = true;
            } else {
                result = false;
            }

            //Traconsecutivo.cerrarConexiones();
        } catch (SQLException e) {
            logger.error("OPA - " + FacadeAceptaciones.class.getName(), e);
        } finally {
            Traconsecutivo.cerrarConexiones();
        }
        return result;
    }

    public String FechaAceptacion(int usuario) {

        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String fecha = "";
        Parametro Trafecha = new Parametro();
        try {
            Trafecha.consultaLectura("SELECT CONCAT((SELECT CONCAT(LetraDia, ' (', EntidadDeNegociosID, ')') "
                    + " FROM Diccionarios_DiasLetras WHERE EntidadDeNegociosID = DAY(NOW())), "
                    + " DATE_FORMAT(FechaIniOperacion, CONCAT(' de ', "
                    + " (SELECT CASE (DATE_FORMAT(FechaIniOperacion,'%M')) WHEN 'January' "
                    + " THEN 'Enero' WHEN 'February' THEN 'Febrero' WHEN 'March' THEN 'Marzo' "
                    + " WHEN 'April' THEN 'Abril' WHEN 'May' THEN 'Mayo' WHEN 'June' THEN 'Junio' "
                    + " WHEN 'July' THEN 'Julio' WHEN 'August' THEN 'Agosto' WHEN 'September' THEN 'Septiembre' "
                    + " WHEN 'October' THEN 'Octubre' WHEN 'November' THEN 'Noviembre' WHEN 'December' THEN 'Diciembre' END), ' del ', '%Y'))) "
                    + " AS 'FECHA' FROM fqs_Parametrizacion ");
            if (Trafecha.rs.first()) {
                fecha = Trafecha.rs.getString("FECHA");
            }
        } catch (SQLException e) {
            logger.error("OPA - " + FacadeAceptaciones.class.getName(), e);
        } finally {
            Trafecha.cerrarConexiones();
        }
        return fecha;
    }

    public static synchronized int[] obtenerSecuenciasFormulario() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Formulario formulario = new Formulario();
        try {
            formulario.consultaG("select seq('dm_formulario') i_numformulario, seq('dm_ofertante') i_ofertante");
            if (formulario.first()) {
                return new int[]{formulario.rs.getInt("i_numformulario"), formulario.rs.getInt("i_ofertante")};
            }

            throw new RuntimeException("Error inesperado obteniendo valores de secuencia, la consulta no arrojo resultados");

        } catch (SQLException e) {

            throw new RuntimeException("Error inesperado obteniendo valores de secuencia", e);

        } finally {
            formulario.cerrarConexiones();
        }
    }

    public void BorraAceptaciones() {

        Parametro par = new Parametro();
        par.eliminarAceptaciones();
        par.cerrarConexiones();

    }

    public String ModificarAceptacion(String claseAcciones, String consecutivo, String texto1, String texto2, Integer preacuerdo,
            String codigoScb, String nombreScb, String representante, String nombre, /*String apellidoRazonSocial,*/ Double numAcciones, Integer TN,
            int tipoDoc, String numDoc, Double numVer, String fiduciario, String cuentaInv, int usuario,
            String fecha, int usuarioMod, String fechaMod, String observacion, String nomUsuario, String idAceptacion, Double porcentajeComision, String direccion,int idMila) {

        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String result = "Los cambios fueron realizados con éxito";
        Parametro modAceptacion = new Parametro();
        String tipMod = "Modificación Aceptación - Modificación";
        String estado = "Modificado";
        try {
            modAceptacion.actualizar("UPDATE fqs_CrearAceptacion SET TipDocumento = '" + 
                    tipoDoc + "', NombreRazonSocial = '" + nombre /*+ " " + apellidoRazonSocial*/ +  "', NumNitDoc = '" + numDoc + "', "
                    + "NumVer = " + numVer + ", EspFid = '" + fiduciario + "', CtaInv = '" + cuentaInv + "', observacion = '" + observacion + "', c_usuario_bd_datos = '" + nomUsuario + "',"
                    + " FechaModificacion = '" + fechaMod + "', estado = '" + estado + "', c_tipo_modificacion = '" + tipMod + "', PorcentajeComision=" + porcentajeComision + ", direccion = '"+ direccion +"', idMila = '"+ idMila +"' WHERE EntidadDeNegociosID = '" + idAceptacion + "'");

        } catch (Exception e) {
            result = "Error";
            logger.error("OPA - " + FacadeAceptaciones.class.getName(), e);

        } finally {
            modAceptacion.cerrarConexiones();
        }

        return result;
    }
    
    public String RecalcularMontoTotalEfectivoAceptaciones(String precio) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String result = "Los cambios fueron realizados con éxito";
        logger.info("Inicio RecalcularMontoTotalEfectivoAceptaciones");
        Parametro modAceptacion = new Parametro();
        
        //Select de aceptaciones existentes
        List<List<String>> aceptaciones = ListarDemandasIncluidas();
        Double monto;
        for(int i=0; i < aceptaciones.get(0).size(); i++){
            
            BigDecimal precioBigDecimal = new BigDecimal(precio);
            BigDecimal numeroDeAcciones = new BigDecimal(aceptaciones.get(9).get(i));
            BigDecimal tot = precioBigDecimal.multiply(numeroDeAcciones).setScale(2, RoundingMode.DOWN);
            monto = tot.doubleValue();

            try {
                modAceptacion.actualizar("UPDATE fqs_CrearAceptacion SET MontoTotalEfectivo = '" + monto + "' WHERE EntidadDeNegociosID = '" + aceptaciones.get(0).get(i) + "'");

            } catch (Exception e) {
                result = "Error";
                logger.error("OPA - " + FacadeAceptaciones.class.getName(), e);

            } finally {
                modAceptacion.cerrarConexiones();
            }
        }
        logger.info("Fin RecalcularMontoTotalEfectivoAceptaciones");
        return result;
    }
    
    public String RecalcularMontoTotalRechazo(String precio, Double numeAccion, String idAceptacion) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String result = "Los cambios fueron realizados con éxito";
        logger.info("Inicio RecalcularMontoTotalRechazo");
        Parametro modAceptacion = new Parametro();
        
        Double monto;
            
            BigDecimal precioBigDecimal = new BigDecimal(precio);
            BigDecimal numeroDeAcciones = new BigDecimal(numeAccion);
            BigDecimal tot = precioBigDecimal.multiply(numeroDeAcciones).setScale(2, RoundingMode.DOWN);
            monto = tot.doubleValue();

            try {
                modAceptacion.actualizar("UPDATE fqs_CrearAceptacion SET MontoTotalEfectivo = '" + monto + "' WHERE EntidadDeNegociosID = '" + idAceptacion + "'");

            } catch (Exception e) {
                result = "Error";
                logger.error("OPA2 - " + FacadeAceptaciones.class.getName(), e);

            } finally {
                modAceptacion.cerrarConexiones();
            }
        
        logger.info("Fin RecalcularMontoTotalRechazo");
        return result;
    }

    public String RechazarAceptacion(String apellidoRazon, String consecutivoOferta, Integer existePreacuerdo, String idMila, String nombreRepresentanteLegal, int tipoDoc, String numDoc, Double digV, String especFidu, String cuenInv, Integer tipoCon, Double numAcc, String observacion, String porcentajeCom, String estado,  String nomUsuario,
            String fecha, String idAceptacion) {

        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String result = "Los cambios fueron realizados con éxito";
        Parametro modAceptacion = new Parametro();
        String tipMod = "Modificación Rechazo - Rechazo";
        
        if(existePreacuerdo == 0){
            existePreacuerdo = null;            
        }
        if(tipoCon == 100){
            tipoCon = null;
        }
        
        try {
          modAceptacion.actualizar("UPDATE fqs_CrearAceptacion SET NombreRazonSocial = '" + apellidoRazon 
                    + "', ConOfeVen = '" + consecutivoOferta + "', ExistePreacuerdo = " + existePreacuerdo
                    + ", idMila = '" + idMila + "', RepresentanteLegal = '" + nombreRepresentanteLegal 
                    + "', TipDocumento = " + tipoDoc + ", NumNitDoc = '" 
                    + numDoc + "', NumVer = " + digV + ", EspFid = '" + especFidu + "', CtaInv = '" + cuenInv + "', VenCon = " + tipoCon + ", NumAcciones = " + numAcc 
                    + ", observacion = '" + observacion + "', PorcentajeComision = " + porcentajeCom
                    + ", estado = '" + estado + "', c_usuario_bd_datos = '" + nomUsuario + "', "
                    + " FechaModificacion = '" + fecha + "', c_tipo_modificacion = '" + tipMod + "' WHERE EntidadDeNegociosID = '" + idAceptacion + "'");

        } catch (Exception e) {
            result = "Eror";
            logger.error("OPA - " + FacadeAceptaciones.class.getName(), e);

        } finally {
            modAceptacion.cerrarConexiones();
        }

        return result;
    }

    public List<List<String>> ListarDemandas(String usuario, String numAceptaciones, String FechIni, String FechaFin) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Aceptaciones form = new Aceptaciones();
        List<List<String>> listDatDem = new ArrayList<List<String>>();
        String sqlquery = "";

        for (int i = 0; i < 27; i++) {
            listDatDem.add(new ArrayList<String>());
        }

        try {

            sqlquery = ("SELECT  CA.EntidadDeNegociosID,  CA.ClaseAcciones, CA.ConOfeVen,"
                    + "CA.TextoUno, CA.TextoDos, CA.ExistePreacuerdo, CA.CodScb,"
                    + "CA.NombreSCB, CA.RepresentanteLegal, "
                    + "CA.NumAcciones, CA.VenCon, CA.TipDocumento, CA.NumNitDoc,"
                    + "CA.NumVer, CA.EspFid, CA.CtaInv, CA.NombreUsuarioIdCreacion,"
                    + "DATE(CA.FechaCreacion) AS FechaCreacion, TIME(CA.FechaCreacion) AS FechaCreacion2,"
                    + "CA.NombreUsuarioIdModificacion, TD.c_nombredoc,"
                    + "CA.estado, CA.PorcentajeComision,CA.NombreRazonSocial,CA.PorcentajePagoEfectivo,CA.MontoTotalEfectivo,CA.direccion, CA.idMila "
                    + "FROM fqs_CrearAceptacion CA INNER JOIN dm_tipodocumento TD"
                    + " ON CA.TipDocumento = TD.i_tipodocumento"
                    + " WHERE estado != 'Rechazado' AND NombreUsuarioIdCreacion= " + usuario);

            if (!numAceptaciones.equals("")) {
                sqlquery = sqlquery.concat(" AND EntidadDeNegociosID LIKE '%" + numAceptaciones + "%'");
            } else {
            }
            if (!FechIni.equals("")) {
                sqlquery = sqlquery.concat(" AND DATE(FechaCreacion)>= '" + FechIni + "'");
            } else {
            }
            if (!FechIni.equals("")) {
                sqlquery = sqlquery.concat(" AND DATE(FechaCreacion)<= '" + FechaFin + "'");
            }

            sqlquery = sqlquery.concat(" ORDER BY CA.EntidadDeNegociosID");

            form.consultaLectura(sqlquery);

            while (form.rs.next()) {

                listDatDem.get(0).add(String.valueOf(form.rs.getInt("EntidadDeNegociosID")));
                listDatDem.get(1).add(form.rs.getString("ClaseAcciones"));
                listDatDem.get(2).add(form.rs.getString("ConOfeVen"));
                listDatDem.get(3).add(form.rs.getString("TextoUno"));
                listDatDem.get(4).add(form.rs.getString("TextoDos"));
                listDatDem.get(5).add(form.rs.getString("ExistePreacuerdo"));
                listDatDem.get(6).add(form.rs.getString("CodScb"));
                listDatDem.get(7).add(form.rs.getString("NombreSCB"));
                listDatDem.get(8).add(form.rs.getString("RepresentanteLegal"));
                listDatDem.get(9).add(form.rs.getString("NumAcciones"));
                listDatDem.get(10).add(form.rs.getString("VenCon"));
                listDatDem.get(11).add(form.rs.getString("c_nombredoc"));
                listDatDem.get(12).add(form.rs.getString("NumNitDoc"));
                listDatDem.get(13).add((form.rs.getString("NumVer")));
                listDatDem.get(14).add(form.rs.getString("EspFid"));
                listDatDem.get(15).add(form.rs.getString("CtaInv"));
                listDatDem.get(16).add(form.rs.getString("NombreUsuarioIdCreacion"));
                listDatDem.get(17).add(form.rs.getString("FechaCreacion"));
                listDatDem.get(18).add(form.rs.getString("FechaCreacion2"));
                listDatDem.get(19).add(form.rs.getString("NombreUsuarioIdModificacion"));
                listDatDem.get(20).add(form.rs.getString("estado"));
                listDatDem.get(21).add(form.rs.getString("PorcentajeComision"));
                listDatDem.get(22).add(form.rs.getString("NombreRazonSocial"));
                listDatDem.get(23).add(form.rs.getString("PorcentajePagoEfectivo"));
                listDatDem.get(24).add(form.rs.getString("MontoTotalEfectivo"));
                listDatDem.get(25).add(form.rs.getString("direccion"));
                listDatDem.get(26).add(form.rs.getString("idMila"));

            }

        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeAceptaciones.class.getName(), ex);

        } finally {
            form.cerrarConexiones();
        }
        return listDatDem;

    }

    public List<List<String>> ListarDemandasRechazadas(String usuario, String numAceptaciones, String FechIni, String FechaFin) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Aceptaciones form = new Aceptaciones();
        List<List<String>> listDatDem = new ArrayList<List<String>>();
        String sqlquery = "";

        for (int i = 0; i < 30; i++) {
            listDatDem.add(new ArrayList<String>());
        }

        try {

            sqlquery = ("SELECT DISTINCT CA.EntidadDeNegociosID, SCB.i_codigoentidad, SCB.c_razonsocial, CA.ClaseAcciones, CA.ConOfeVen,"
                    + "CA.c_usuario_sistema_ultima_mod, "
                    + "CA.TextoUno, CA.TextoDos, CA.ExistePreacuerdo, CA.CodScb,"
                    + "CA.NombreSCB, CA.RepresentanteLegal,CA.NombreRazonSocial, "
                    + "CA.NumAcciones, CA.VenCon, CA.TipDocumento, CA.NumNitDoc,"
                    + "CA.NumVer, CA.EspFid, CA.CtaInv, CA.NombreUsuarioIdCreacion,"
                    + "DATE(CA.FechaCreacion) AS FechaCreacion, TIME(CA.FechaCreacion) AS FechaCreacion2,"
                    + "CA.NombreUsuarioIdModificacion, TD.c_nombredoc,"
                    + "CA.estado, CA.observacion, CA.direccion, CA.idMila, PA.PrecioAceptaciones, CA.PorcentajeComision,"
                    + " CASE"
                    + " WHEN CA.idMila = 0 THEN 'No Aplica'"
                    + " ELSE OM.pais"
                    + " END AS origenMILA"
                    + " FROM   fqs_Parametrizacion PA, fqs_CrearAceptacion CA INNER JOIN dm_tipodocumento TD"
                    + " ON CA.TipDocumento = TD.i_tipodocumento"
                    + " INNER JOIN dm_scb SCB "
                    + " ON CA.CodScb=SCB.i_scb  "
                    + " LEFT JOIN dm_origen_mila OM "
                    + " ON CA.idMila = OM.i_id "
                    + " WHERE  1=1 ");

            if (!numAceptaciones.equals("")) {
                sqlquery = sqlquery.concat(" AND CA.EntidadDeNegociosID LIKE '%" + numAceptaciones + "%'");
            } else {
            }
            if (!FechIni.equals("")) {
                sqlquery = sqlquery.concat(" AND DATE(CA.FechaCreacion)>= '" + FechIni + "'");
            } else {
            }
            if (!FechIni.equals("")) {
                sqlquery = sqlquery.concat(" AND DATE(CA.FechaCreacion)<= '" + FechaFin + "'");
            }

            sqlquery = sqlquery.concat(" ORDER BY CA.EntidadDeNegociosID");
            form.consultaLectura(sqlquery);

            while (form.rs.next()) {

                listDatDem.get(0).add(String.valueOf(form.rs.getInt("EntidadDeNegociosID")));
                listDatDem.get(1).add(form.rs.getString("ClaseAcciones"));
                listDatDem.get(2).add(form.rs.getString("ConOfeVen"));
                listDatDem.get(3).add(form.rs.getString("TextoUno"));
                listDatDem.get(4).add(form.rs.getString("TextoDos"));
                listDatDem.get(5).add(form.rs.getString("ExistePreacuerdo"));
                listDatDem.get(6).add(form.rs.getString("c_razonsocial"));
                listDatDem.get(7).add(form.rs.getString("c_razonsocial"));
                listDatDem.get(8).add(form.rs.getString("RepresentanteLegal"));
                listDatDem.get(9).add(form.rs.getString("NumAcciones"));
                listDatDem.get(10).add(form.rs.getString("VenCon"));
                listDatDem.get(11).add(form.rs.getString("c_nombredoc"));
                listDatDem.get(12).add(form.rs.getString("NumNitDoc"));
                listDatDem.get(13).add((form.rs.getString("NumVer")));
                listDatDem.get(14).add(form.rs.getString("EspFid"));
                listDatDem.get(15).add(form.rs.getString("CtaInv"));
                listDatDem.get(16).add(form.rs.getString("NombreUsuarioIdCreacion"));
                listDatDem.get(17).add(form.rs.getString("FechaCreacion"));
                listDatDem.get(18).add(form.rs.getString("FechaCreacion2"));
                listDatDem.get(19).add(form.rs.getString("NombreUsuarioIdModificacion"));
                listDatDem.get(20).add(form.rs.getString("estado"));
                listDatDem.get(21).add(form.rs.getString("c_usuario_sistema_ultima_mod"));
                listDatDem.get(22).add(form.rs.getString("observacion"));
                listDatDem.get(23).add(form.rs.getString("i_codigoentidad"));
                listDatDem.get(24).add(form.rs.getString("NombreRazonSocial"));
                listDatDem.get(25).add(form.rs.getString("direccion"));
                listDatDem.get(26).add(form.rs.getString("idMila"));
                listDatDem.get(27).add(form.rs.getString("PrecioAceptaciones"));
                listDatDem.get(28).add(form.rs.getString("PorcentajeComision"));
                listDatDem.get(29).add(form.rs.getString("OrigenMila"));

            }

        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeAceptaciones.class.getName(), ex);

        } finally {
            form.cerrarConexiones();
        }
        return listDatDem;

    }

    public String estadoAceptacion(String usuario) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String fecha = "";
        Parametro Traesesion = new Parametro();
        try {
            Traesesion.consultaLectura("SELECT CONCAT((SELECT concat(LetraDia, ' (', EntidadDeNegociosID, ')')  FROM Diccionarios_DiasLetras WHERE EntidadDeNegociosID = DAY(NOW())), DATE_FORMAT(FechaIniOperacion, Concat(' De ', '%M', ' del ','%Y'))) AS 'FECHA' FROM fqs_Parametrizacion ");
            if (Traesesion.rs.first()) {
                fecha = Traesesion.rs.getString("FECHA");
            }

        } catch (SQLException e) {
            logger.error("OPA - " + FacadeAceptaciones.class.getName(), e);

        } finally {
            Traesesion.cerrarConexiones();
        }
        return fecha;
    }

    public boolean isTNShow() {

        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        boolean TNShow = false;
        Aceptaciones aceptacion = new Aceptaciones();
        try {
            aceptacion.consultaG("SELECT TodoONada FROM fqs_Parametrizacion WHERE TodoONada=?", new Boolean(Boolean.TRUE));
            if (aceptacion.rs.first()) {
                TNShow = true;
            }
        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeAceptaciones.class.getName(), ex);

        } finally {
            aceptacion.cerrarConexiones();
        }
        return TNShow;
    }

    public boolean existePreacuerdo() {

        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        boolean preacuerdo = false;
        Aceptaciones aceptacion = new Aceptaciones();
        try {
            aceptacion.consultaG("SELECT ExistePreacuerdo FROM fqs_Parametrizacion WHERE ExistePreacuerdo=?", new Boolean(Boolean.TRUE));
            if (aceptacion.rs.first()) {
                preacuerdo = true;
            }
        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeAceptaciones.class.getName(), ex);

        } finally {
            aceptacion.cerrarConexiones();
        }
        return preacuerdo;
    }

    public List<List<String>> ListarDemandasReporteConsolidado(String usuario, String FechIni, 
            String FechaFin, Integer perfil, Integer scb) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Aceptaciones form = new Aceptaciones();
        List<List<String>> listDatDem = new ArrayList<List<String>>();
        String sqlquery = "";

        //Seleccionar de usuario el perfil
        for (int i = 0; i < 35; i++) {
            listDatDem.add(new ArrayList<String>());
        }

        try {
            //Se quitan los campos CA.Nombres, CA.ApellidoRazonSocial y se pone CA.NombreRazonSocial
            sqlquery = (" SELECT  CA.EntidadDeNegociosID,  CA.ClaseAcciones, CA.ConOfeVen,"
                    + " CA.TextoUno, CA.TextoDos, CA.ExistePreacuerdo, CA.CodScb,"
                    + " CA.NombreSCB, CA.RepresentanteLegal, CA.NombreRazonSocial,"
                    + " CA.NumAcciones, CA.VenCon, CA.TipDocumento, CA.NumNitDoc,"
                    + " CA.NumVer, CA.EspFid, CA.CtaInv, CA.NombreUsuarioIdCreacion,"
                    + " DATE(CA.FechaCreacion) AS FechaCreacion, TIME(CA.FechaCreacion) AS FechaCreacion2,"
                    + " CA.NombreUsuarioIdModificacion, TD.c_nombredoc,"
                    + " CA.estado ,  PA.Nanotecnico, US.c_login, SCB.i_codigoentidad, SCB.c_razonsocial, SCB.i_scb,"
                    + " CA.RepresentanteLegal, CA.MontoTotalEfectivo AS monto, PA.PrecioAceptaciones, "
                    + " REPLACE(REPLACE(REPLACE(FORMAT(CA.PorcentajeComision,3),'.','@'),',','.'),'@',',') AS PorcentajeComision , "
                    + " CA.observacion,  CA.PorcentajePagoEfectivo, CA.direccion, CA.idMila"
                    + " FROM  fqs_Parametrizacion PA, fqs_CrearAceptacion CA "
                    + " INNER JOIN dm_tipodocumento TD "
                    + " ON CA.TipDocumento = TD.i_tipodocumento "
                    + " INNER JOIN fqs_usuario  US "
                    + " ON CA.NombreUsuarioIdCreacion=US.i_usuario "
                    + " INNER JOIN dm_scb SCB "
                    + " ON CA.CodScb=SCB.i_scb  "
                    + " WHERE 1=1 ");

            if (!FechIni.equals("")) {
                sqlquery = sqlquery.concat(" AND DATE(CA.FechaCreacion)>= '" + FechIni + "'");
            }
            if (!FechIni.equals("")) {
                sqlquery = sqlquery.concat(" AND DATE(CA.FechaCreacion)<= '" + FechaFin + "'");
            }
            if (perfil.intValue() == 4) {
                sqlquery = sqlquery.concat(" AND CA.NombreUsuarioIdCreacion= " + usuario);
            }
            if (perfil.intValue() == 1) {
                sqlquery = sqlquery.concat(" AND CA.CodScb=" + scb);
            }
            sqlquery = sqlquery.concat(" ORDER BY CA.EntidadDeNegociosID ");

            form.consultaLectura(sqlquery);
            while (form.rs.next()) {

                listDatDem.get(0).add(String.valueOf(form.rs.getInt("EntidadDeNegociosID")));
                listDatDem.get(1).add(form.rs.getString("ClaseAcciones"));
                listDatDem.get(2).add(form.rs.getString("ConOfeVen"));
                listDatDem.get(3).add(form.rs.getString("TextoUno"));
                listDatDem.get(4).add(form.rs.getString("TextoDos"));
                listDatDem.get(5).add(form.rs.getString("ExistePreacuerdo"));
                listDatDem.get(6).add(form.rs.getString("CodScb"));
                listDatDem.get(7).add(form.rs.getString("NombreSCB"));
                listDatDem.get(8).add(form.rs.getString("RepresentanteLegal"));
                listDatDem.get(9).add(form.rs.getString("NumAcciones"));
                listDatDem.get(10).add(form.rs.getString("VenCon"));
                listDatDem.get(11).add(form.rs.getString("c_nombredoc"));
                listDatDem.get(12).add(form.rs.getString("NumNitDoc"));
                listDatDem.get(13).add((form.rs.getString("NumVer")));
                listDatDem.get(14).add(form.rs.getString("EspFid"));
                listDatDem.get(15).add(form.rs.getString("CtaInv"));
                listDatDem.get(16).add(form.rs.getString("NombreUsuarioIdCreacion"));
                listDatDem.get(17).add(form.rs.getString("FechaCreacion"));
                listDatDem.get(18).add(form.rs.getString("FechaCreacion2"));
                listDatDem.get(19).add(form.rs.getString("NombreUsuarioIdModificacion"));
                listDatDem.get(20).add(form.rs.getString("estado"));
                listDatDem.get(21).add(form.rs.getString("Nanotecnico"));
                listDatDem.get(22).add(form.rs.getString("c_login"));
                listDatDem.get(23).add(form.rs.getString("c_razonsocial"));
                listDatDem.get(24).add(form.rs.getString("i_scb"));
                listDatDem.get(25).add(form.rs.getString("RepresentanteLegal"));
                listDatDem.get(26).add(form.rs.getString("monto"));
                listDatDem.get(27).add(form.rs.getString("PrecioAceptaciones"));
                listDatDem.get(28).add(form.rs.getString("observacion"));
                if (form.rs.getString("PorcentajeComision") != null) // listDatDem.get(30).add(form.rs.getString("PorcentajeComision").concat(" %")); 
                {
                    listDatDem.get(29).add(form.rs.getString("PorcentajeComision"));
                } else {
                    listDatDem.get(29).add("");
                }
                listDatDem.get(30).add(form.rs.getString("i_codigoentidad"));
                listDatDem.get(31).add(form.rs.getString("NombreRazonSocial"));
                listDatDem.get(32).add(form.rs.getString("PorcentajePagoEfectivo"));
                listDatDem.get(33).add(form.rs.getString("direccion"));
                listDatDem.get(34).add(form.rs.getString("idMila"));

            }

        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeAceptaciones.class.getName(), ex);

        } finally {
            form.cerrarConexiones();
        }
        return listDatDem;

    }
    
//OPA
    public String[] CargarAceptacion(String id) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Aceptaciones tp = new Aceptaciones();

        String[] listAceptacion = null;

        try {

            tp.consultaLectura("select FechaCreacion, NombreSCB, ConOfeVen, VenCon, ExistePreacuerdo, NumAcciones, "
                    + "NombreRazonSocial, TipDocumento, NumNitDoc, EspFid, "
                    + " CtaInv, RepresentanteLegal, EntidadDeNegociosID, NumVer, "
                    + "observacion, PorcentajeComision, MontoTotalEfectivo,"
                    + "PorcentajePagoEfectivo,Condicion1,Condicion2, tipo_pago, "
                    + "direccion, idMila from fqs_CrearAceptacion where EntidadDeNegociosID = " + id);

            if (tp.rs.first()) {

                listAceptacion = new String[]{
                    tp.rs.getString("FechaCreacion"), 
                    tp.rs.getString("NombreSCB"), 
                    tp.rs.getString("ConOfeVen"),
                    tp.rs.getString("VenCon"), 
                    tp.rs.getString("ExistePreacuerdo"), 
                    tp.rs.getString("NumAcciones"),                     
                    tp.rs.getString("TipDocumento"), 
                    tp.rs.getString("NumNitDoc"), 
                    tp.rs.getString("EspFid"), 
                    tp.rs.getString("CtaInv"), 
                    tp.rs.getString("RepresentanteLegal"), 
                    tp.rs.getString("EntidadDeNegociosID"), 
                    tp.rs.getString("NumVer"), 
                    tp.rs.getString("observacion"), 
                    tp.rs.getString("PorcentajeComision"),
                    tp.rs.getString("NombreRazonSocial"),
                    tp.rs.getString("tipo_pago"),                     
                    tp.rs.getString("direccion"), 
                    tp.rs.getString("idMila")};

            }

        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeAceptaciones.class.getName(), ex);

        } finally {
            tp.cerrarConexiones();
        }
        return listAceptacion;
    }
    
    //OPI
    public String[] CargarAceptacionOPI(String id) {
        PropertyConfigurator.configure("/apps/OPI/logs/opi-log4j.properties");
        Aceptaciones tp = new Aceptaciones();

        String FechaCreacion;
        String NombreSCB = " ";
        String consecutivoOfertaVenta = " ";
        String ConTodoNada = " ";
        String ExistePreacuerdo = " ";
        String tNumAcciones = " ";
        String Nombres = " ";
        String TipDocumento = " ";
        String NumNitDoc = " ";
        String EspFid = " ";
        String CtaInv = " ";
        String RepresentanteLegal = " ";
        String[] listAceptacion = null;
        String idAceptacion = "";
        String NumVer = "";
        String observacion = "";
        String MontoTotalAcciones = "";
        String PorcentajePagoEfectivo = "";
        String Condicion1 = "";
        String Condicion2 = "";
        String tipoPago = "";
        String direccion = "";
        String idMila = "";

        try {

            tp.consultaLectura("SELECT FechaCreacion, NombreSCB, ConOfeVen, "
                    + "VenCon, ExistePreacuerdo, NumAcciones, "
                    + "NombreRazonSocial, TipDocumento, NumNitDoc, EspFid, "
                    + " CtaInv, RepresentanteLegal, EntidadDeNegociosID, "
                    + "NumVer, observacion, PorcentajeComision, "
                    + "MontoTotalEfectivo,PorcentajePagoEfectivo,Condicion1,"
                    + "Condicion2, tipo_pago, direccion, idMila "
                    + "FROM fqs_CrearAceptacion WHERE EntidadDeNegociosID = " + id);

            if (tp.rs.first()) {

                FechaCreacion = tp.rs.getString("FechaCreacion");
                NombreSCB = tp.rs.getString("NombreSCB");
                consecutivoOfertaVenta = tp.rs.getString("ConOfeVen");
                ConTodoNada = tp.rs.getString("VenCon");
                ExistePreacuerdo = tp.rs.getString("ExistePreacuerdo");
                tNumAcciones = tp.rs.getString("NumAcciones");
                TipDocumento = tp.rs.getString("TipDocumento");
                NumNitDoc = tp.rs.getString("NumNitDoc");
                EspFid = tp.rs.getString("EspFid");
                CtaInv = tp.rs.getString("CtaInv");
                RepresentanteLegal = tp.rs.getString("RepresentanteLegal");
                idAceptacion = tp.rs.getString("EntidadDeNegociosID");
                NumVer = tp.rs.getString("NumVer");
                observacion = tp.rs.getString("observacion");
                Nombres = tp.rs.getString("NombreRazonSocial");
                MontoTotalAcciones = tp.rs.getString("MontoTotalEfectivo");
                PorcentajePagoEfectivo = tp.rs.getString("PorcentajePagoEfectivo");
                Condicion1 = tp.rs.getString("Condicion1");
                Condicion2 = tp.rs.getString("Condicion2");
                tipoPago = tp.rs.getString("tipo_pago");
                direccion = tp.rs.getString("direccion");
                idMila = tp.rs.getString("idMila");
                listAceptacion = new String[]{
                    FechaCreacion, 
                    NombreSCB, 
                    consecutivoOfertaVenta, 
                    ConTodoNada, 
                    ExistePreacuerdo, 
                    tNumAcciones, 
                    TipDocumento, 
                    NumNitDoc, 
                    EspFid, 
                    CtaInv, 
                    RepresentanteLegal, 
                    idAceptacion, 
                    NumVer, 
                    observacion, 
                    tp.rs.getString("PorcentajeComision"), 
                    Nombres, 
                    MontoTotalAcciones, 
                    PorcentajePagoEfectivo, 
                    Condicion1, 
                    Condicion2, 
                    tipoPago, 
                    direccion,
                    idMila};

            }

            tp.cerrarConexiones();
        } catch (SQLException ex) {
            logger.error("OPI - "+FacadeAceptaciones.class.getName(), ex);
        } finally {
            tp.cerrarConexiones();
        }
        return listAceptacion;
    }

    public List<List<String>> ListarDemandasAdjudicacion() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Aceptaciones form = new Aceptaciones();
        List<List<String>> listDatDem = new ArrayList<List<String>>();
        String sqlquery = "";

        for (int i = 0; i < 21; i++) {
            listDatDem.add(new ArrayList<String>());
        }

        try {

            sqlquery = ("SELECT  CA.EntidadDeNegociosID,  CA.ClaseAcciones, CA.ConOfeVen,"
                    + "CA.TextoUno, CA.TextoDos, CA.ExistePreacuerdo, CA.CodScb,"
                    + "CA.NombreSCB, CA.RepresentanteLegal, "
                    + "CA.NumAcciones, CA.VenCon, CA.TipDocumento, CA.NumNitDoc,"
                    + "CA.NumVer, CA.EspFid, CA.CtaInv, CA.NombreUsuarioIdCreacion,"
                    + "DATE(CA.FechaCreacion) AS FechaCreacion, TIME(CA.FechaCreacion) AS FechaCreacion2,"
                    + "CA.NombreUsuarioIdModificacion, TD.c_nombredoc,"
                    + "CA.estado FROM fqs_CrearAceptacion CA INNER JOIN dm_tipodocumento TD"
                    + " ON CA.TipDocumento = TD.i_tipodocumento WHERE VenCon!=1  AND (estado LIKE '%Ingresado%' or estado LIKE '%Modificado%')");

            form.consultaLectura(sqlquery);

            while (form.rs.next()) {
                listDatDem.get(0).add(form.rs.getString("EntidadDeNegociosID"));
                listDatDem.get(1).add(form.rs.getString("ClaseAcciones"));
                listDatDem.get(2).add(form.rs.getString("ConOfeVen"));
                listDatDem.get(3).add(form.rs.getString("TextoUno"));
                listDatDem.get(4).add(form.rs.getString("TextoDos"));
                listDatDem.get(5).add(form.rs.getString("ExistePreacuerdo"));
                listDatDem.get(6).add(form.rs.getString("CodScb"));
                listDatDem.get(7).add(form.rs.getString("NombreSCB"));
                listDatDem.get(8).add(form.rs.getString("RepresentanteLegal"));
                listDatDem.get(9).add(form.rs.getString("NumAcciones"));
                listDatDem.get(10).add(form.rs.getString("VenCon"));
                listDatDem.get(11).add(form.rs.getString("c_nombredoc"));
                listDatDem.get(12).add(form.rs.getString("NumNitDoc"));
                listDatDem.get(13).add((form.rs.getString("NumVer")));
                listDatDem.get(14).add(form.rs.getString("EspFid"));
                listDatDem.get(15).add(form.rs.getString("CtaInv"));
                listDatDem.get(16).add(form.rs.getString("NombreUsuarioIdCreacion"));
                listDatDem.get(17).add(form.rs.getString("FechaCreacion"));
                listDatDem.get(18).add(form.rs.getString("FechaCreacion2"));
                listDatDem.get(19).add(form.rs.getString("NombreUsuarioIdModificacion"));
                listDatDem.get(20).add(form.rs.getString("estado"));

            }

        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeAceptaciones.class.getName(), ex);

        } finally {
            form.cerrarConexiones();
        }
        return listDatDem;

    }

    public List<List<String>> ListarDemandas() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Aceptaciones form = new Aceptaciones();
        List<List<String>> listDatDem = new ArrayList<List<String>>();
        String sqlquery = "";

        for (int i = 0; i < 24; i++) {
            listDatDem.add(new ArrayList<String>());
        }

        try {

            sqlquery = ("SELECT  CA.EntidadDeNegociosID,  CA.ClaseAcciones, CA.ConOfeVen,"
                    + "CA.TextoUno, CA.TextoDos, CA.ExistePreacuerdo, CA.CodScb,"
                    + "CA.NombreSCB, CA.RepresentanteLegal, "
                    + "CA.NumAcciones, CA.VenCon, CA.TipDocumento, CA.NumNitDoc,"
                    + "CA.NumVer, CA.EspFid, CA.CtaInv, CA.NombreUsuarioIdCreacion,"
                    + "DATE(CA.FechaCreacion) AS FechaCreacion, TIME(CA.FechaCreacion) AS FechaCreacion2,"
                    + "CA.NombreUsuarioIdModificacion, TD.c_nombredoc,"
                    + "CA.estado,CA.NombreRazonSocial,CA.PorcentajePagoEfectivo,CA.MontoTotalEfectivo FROM fqs_CrearAceptacion CA INNER JOIN dm_tipodocumento TD"
                    + " ON CA.TipDocumento = TD.i_tipodocumento WHERE estado LIKE '%Ingresado%' or estado LIKE '%Modificado%'");

            form.consultaLectura(sqlquery);

            while (form.rs.next()) {
                listDatDem.get(0).add(form.rs.getString("EntidadDeNegociosID"));
                listDatDem.get(1).add(form.rs.getString("ClaseAcciones"));
                listDatDem.get(2).add(form.rs.getString("ConOfeVen"));
                listDatDem.get(3).add(form.rs.getString("TextoUno"));
                listDatDem.get(4).add(form.rs.getString("TextoDos"));
                listDatDem.get(5).add(form.rs.getString("ExistePreacuerdo"));
                listDatDem.get(6).add(form.rs.getString("CodScb"));
                listDatDem.get(7).add(form.rs.getString("NombreSCB"));
                listDatDem.get(8).add(form.rs.getString("RepresentanteLegal"));
                listDatDem.get(9).add(form.rs.getString("NumAcciones"));
                listDatDem.get(10).add(form.rs.getString("VenCon"));
                listDatDem.get(11).add(form.rs.getString("c_nombredoc"));
                listDatDem.get(12).add(form.rs.getString("NumNitDoc"));
                listDatDem.get(13).add((form.rs.getString("NumVer")));
                listDatDem.get(14).add(form.rs.getString("EspFid"));
                listDatDem.get(15).add(form.rs.getString("CtaInv"));
                listDatDem.get(16).add(form.rs.getString("NombreUsuarioIdCreacion"));
                listDatDem.get(17).add(form.rs.getString("FechaCreacion"));
                listDatDem.get(18).add(form.rs.getString("FechaCreacion2"));
                listDatDem.get(19).add(form.rs.getString("NombreUsuarioIdModificacion"));
                listDatDem.get(20).add(form.rs.getString("estado"));
                listDatDem.get(21).add(form.rs.getString("NombreRazonSocial"));
                listDatDem.get(22).add(form.rs.getString("PorcentajePagoEfectivo"));
                listDatDem.get(23).add(form.rs.getString("MontoTotalEfectivo"));

            }

        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeAceptaciones.class.getName(), ex);

        } finally {
            form.cerrarConexiones();
        }
        return listDatDem;

    }
    
    public List<List<String>> ListarDemandasIncluidas() {
        PropertyConfigurator.configure("/apps/OPA2/logs/opa2-log4j.properties");
        Aceptaciones form = new Aceptaciones();
        List<List<String>> listDatDem = new ArrayList<List<String>>();
        String sqlquery = "";

        for (int i = 0; i < 24; i++) {
            listDatDem.add(new ArrayList<String>());
        }

        try {

            sqlquery = ("SELECT  CA.EntidadDeNegociosID,  CA.ClaseAcciones, CA.ConOfeVen,"
                    + "CA.TextoUno, CA.TextoDos, CA.ExistePreacuerdo, CA.CodScb,"
                    + "CA.NombreSCB, CA.RepresentanteLegal, "
                    + "CA.NumAcciones, CA.VenCon, CA.TipDocumento, CA.NumNitDoc,"
                    + "CA.NumVer, CA.EspFid, CA.CtaInv, CA.NombreUsuarioIdCreacion,"
                    + "DATE(CA.FechaCreacion) AS FechaCreacion, TIME(CA.FechaCreacion) AS FechaCreacion2,"
                    + "CA.NombreUsuarioIdModificacion, TD.c_nombredoc,"
                    + "CA.estado,CA.NombreRazonSocial,CA.PorcentajePagoEfectivo,CA.MontoTotalEfectivo FROM fqs_CrearAceptacion CA INNER JOIN dm_tipodocumento TD"
                    + " ON CA.TipDocumento = TD.i_tipodocumento");

            form.consultaLectura(sqlquery);

            while (form.rs.next()) {
                listDatDem.get(0).add(form.rs.getString("EntidadDeNegociosID"));
                listDatDem.get(1).add(form.rs.getString("ClaseAcciones"));
                listDatDem.get(2).add(form.rs.getString("ConOfeVen"));
                listDatDem.get(3).add(form.rs.getString("TextoUno"));
                listDatDem.get(4).add(form.rs.getString("TextoDos"));
                listDatDem.get(5).add(form.rs.getString("ExistePreacuerdo"));
                listDatDem.get(6).add(form.rs.getString("CodScb"));
                listDatDem.get(7).add(form.rs.getString("NombreSCB"));
                listDatDem.get(8).add(form.rs.getString("RepresentanteLegal"));
                listDatDem.get(9).add(form.rs.getString("NumAcciones"));
                listDatDem.get(10).add(form.rs.getString("VenCon"));
                listDatDem.get(11).add(form.rs.getString("c_nombredoc"));
                listDatDem.get(12).add(form.rs.getString("NumNitDoc"));
                listDatDem.get(13).add((form.rs.getString("NumVer")));
                listDatDem.get(14).add(form.rs.getString("EspFid"));
                listDatDem.get(15).add(form.rs.getString("CtaInv"));
                listDatDem.get(16).add(form.rs.getString("NombreUsuarioIdCreacion"));
                listDatDem.get(17).add(form.rs.getString("FechaCreacion"));
                listDatDem.get(18).add(form.rs.getString("FechaCreacion2"));
                listDatDem.get(19).add(form.rs.getString("NombreUsuarioIdModificacion"));
                listDatDem.get(20).add(form.rs.getString("estado"));
                listDatDem.get(21).add(form.rs.getString("NombreRazonSocial"));
                listDatDem.get(22).add(form.rs.getString("PorcentajePagoEfectivo"));
                listDatDem.get(23).add(form.rs.getString("MontoTotalEfectivo"));

            }

        } catch (SQLException ex) {
            logger.error("OPA2 - " + FacadeAceptaciones.class.getName(), ex);

        } finally {
            form.cerrarConexiones();
        }
        return listDatDem;

    }

    //OPA
    public String IngresarAceptacionCargueMasivo(String claseAcciones, 
                                                 String consecutivo, 
                                                 String texto1, 
                                                 String texto2, 
                                                 String preacuerdo,
                                                 String codigoScb, 
                                                 String nombreScb, 
                                                 String representante,  
                                                 String nombreRazonSocial, 
                                                 Double numAcciones, 
                                                 Integer TN,
                                                 int tipoDoc, 
                                                 String numDoc, 
                                                 Double numVer, 
                                                 String fiduciario, 
                                                 String cuentaInv, 
                                                 int usuario,
                                                 String fecha, 
                                                 int usuarioMod, 
                                                 String fechaMod, 
                                                 String nomUsuario, 
                                                 Double porcentajeComision, 
                                                 Double precioAccion, 
                                                 String direccion) {
        PropertyConfigurator.configure(Facade.cargarPropertiesLog());
        //
        Double monto = 0.0;
        BigDecimal a = new BigDecimal(precioAccion.toString());
        BigDecimal precio1 = new BigDecimal(numAcciones);
        BigDecimal tot = a.multiply(precio1).setScale(2, RoundingMode.DOWN);
        monto = tot.doubleValue();             
        //
                
        String result = "Error";
        Parametro crearAceptacion = new Parametro();
        String estado = "Ingresado";
        String tipMod = "Ingreso Demanda - Archivo";
        try {
            int indices[] = obtenerSecuenciasFormulario();
            
            crearAceptacion.Insert("INSERT INTO fqs_CrearAceptacion (EntidadDeNegociosID,ClaseAcciones, ConOfeVen, TextoUno,  "
                    + " TextoDos, ExistePreacuerdo, CodScb, NombreSCB, RepresentanteLegal, NombreRazonSocial, NumAcciones, VenCon, "
                    + " TipDocumento, NumNitDoc, NumVer, EspFid, CtaInv, NombreUsuarioIdCreacion, FechaCreacion, NombreUsuarioIdModificacion, "
                    + " FechaModificacion, estado, PorcentajeComision, c_usuario_sistema_ultima_mod, c_tipo_modificacion, MontoTotalEfectivo, "
                    + " tipo_oferta_publica, direccion)"
                    + " VALUES (" + indices[0] + ", '" 
                                  + claseAcciones + "', '" 
                                  + consecutivo + "', '" 
                                  + texto1 + "', '" 
                                  + texto2 + "', " 
                                  + preacuerdo + ", '" 
                                  + codigoScb + "', " 
                                  + " '" + nombreScb + "', '" 
                                  + representante + "', '"
                                  + nombreRazonSocial + "', '" 
                                  + numAcciones + "', " 
                                  + TN + ", " 
                                  + tipoDoc + ", '" 
                                  + numDoc + "', " 
                                  + numVer + ", '" 
                                  + fiduciario + "', "
                                  + " '" 
                                  + cuentaInv + "', " 
                                  + usuario + ", '" 
                                  + fecha + "', " 
                                  + usuarioMod + ", '" 
                                  + fechaMod + "', '" 
                                  + estado + "'," 
                                  + porcentajeComision + ",'" 
                                  + nomUsuario + "', '" 
                                  + tipMod + "'," 
                                  + monto 
                                  + ", 'OPA' , '" + direccion +  "' )");
            result = "Oferta Ingresada No." + indices[0] + " radicada con fecha " + fecha + "";

        } catch (SQLException e) {
            logger.error("OPA - " + FacadeAceptaciones.class.getName(), e);

            result = "Error";
        } finally {
            //logger.error("OPA - CARGA MASIVA " + FacadeAceptaciones.class.getName());
            crearAceptacion.cerrarConexiones();
        }
        return result;
    }
    
    //OPI
    public String IngresarAceptacionCargueMasivo(String claseAcciones, String consecutivo, String texto1, String texto2, String preacuerdo,
            String codigoScb, String nombreScb, String representante, String nombreRazonSocial, /*String apellidoRazonSocial,*/ Double numAcciones, Integer TN,
            int tipoDoc, String numDoc, Double numVer, String fiduciario, String cuentaInv, int usuario,
            String fecha, int usuarioMod, String fechaMod, String nomUsuario, Double porcentajeComision, Double porcentajePagoefectivo,
            int tipoPago , Double PrecioAccion, String Condicion1, String Condicion2, String direccion) {

        PropertyConfigurator.configure("/apps/OPI/logs/opi-log4j.properties");
        Double num = 0.0;
        BigDecimal a = new BigDecimal(PrecioAccion.toString());
        BigDecimal precio1 = new BigDecimal(numAcciones);
        BigDecimal tot = a.multiply(precio1);
        num = tot.doubleValue();

        String result = "Error";
        Parametro crearAceptacion = new Parametro();
        String estado = "Ingresado";
        String tipMod = "Ingreso Demanda - Archivo";
        
        try {

            int indices[] = obtenerSecuenciasFormulario();
          
            crearAceptacion.Insert("INSERT INTO fqs_CrearAceptacion (EntidadDeNegociosID,ClaseAcciones, ConOfeVen, TextoUno,  "
                    + " TextoDos, ExistePreacuerdo, CodScb, NombreSCB, RepresentanteLegal, nombreRazonSocial, NumAcciones, VenCon, "
                    + " TipDocumento, NumNitDoc, NumVer, EspFid, CtaInv, NombreUsuarioIdCreacion, FechaCreacion, NombreUsuarioIdModificacion, "
                    + " FechaModificacion, estado, PorcentajeComision, c_usuario_sistema_ultima_mod, c_tipo_modificacion, PorcentajePagoEfectivo,"
                    + " tipo_pago, MontoTotalEfectivo, Condicion1,Condicion2, tipo_oferta_publica, direccion) VALUES (" + indices[0] + ", '" 
                    + claseAcciones + "', '" + consecutivo + "', '" + texto1 + "', '" + texto2 + "', " + preacuerdo + ", '" + codigoScb + "', "
                    + " '" + nombreScb + "', '" + representante + "', '" + nombreRazonSocial + "', '"+ /*apellidoRazonSocial +"', " + */numAcciones + "', " 
                    + TN + ", " + tipoDoc + ", '" + numDoc + "', " + numVer + ", '" + fiduciario + "', "
                    + " '" + cuentaInv + "', " + usuario + ", '" + fecha + "', " + usuarioMod + ", '" + fechaMod + "', '" + estado 
                    + "'," + porcentajeComision + ",'" + nomUsuario + "', '" + tipMod + "'," + porcentajePagoefectivo + ","+  tipoPago +", '" + num 
                    + "','" + Condicion1 + "','" + Condicion2 + "', 'OPI' , '"+ direccion+ "' )");

            result = "Oferta Ingresada No." + indices[0] + " radicada con fecha " + fecha + "";
            crearAceptacion.cerrarConexiones();

        } catch (SQLException ex) {

            logger.error("OPI - " + FacadeAceptaciones.class.getName(), ex);
            crearAceptacion.cerrarConexiones();
            result = "Error.";

        } finally {
            crearAceptacion.cerrarConexiones();
        }

        return result;
    }

    public String retornarDia(int id) {

        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String fecha = "";
        Parametro Trafecha = new Parametro();
        try {
            Trafecha.consultaG("SELECT LetraDia FROM Diccionarios_DiasLetras WHERE EntidadDeNegociosID = ?", id);
            if (Trafecha.rs.first()) {
                fecha = Trafecha.rs.getString("LetraDia");
            }

            //Trafecha.cerrarConexiones();
        } catch (SQLException e) {
            logger.error("OPA - " + FacadeAceptaciones.class.getName(), e);
        } finally {

            Trafecha.cerrarConexiones();
        }
        return fecha;
    }

    public String Totales(String usuario, Integer perfil, Integer scb, String FechIni, String FechaFin) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Parametro traerTotal = new Parametro();
        String totalAceptaciones = "";
        String totalmonto = "";
        String totalAcciones = "";
        String sqlquery = "";

        try {
            sqlquery = ("SELECT SUM(t1.NumAcciones) AS total_acciones, SUM(t1.MontoTotalEfectivo) AS total_monto "
                    + "FROM fqs_CrearAceptacion t1 "
                    + "WHERE t1.estado IN ('Ingresado','Modificado') ");

            if (perfil.intValue() == 4) {
                sqlquery = sqlquery.concat(" AND t1.NombreUsuarioIdCreacion= " + usuario);
            }
            if (perfil.intValue() == 1) {
                sqlquery = sqlquery.concat(" AND t1.CodScb=" + scb);
            }

            if (!FechIni.equals("")) {
                sqlquery = sqlquery.concat(" AND DATE(t1.FechaCreacion)>= '" + FechIni + "'");
            }
            if (!FechIni.equals("")) {
                sqlquery = sqlquery.concat(" AND DATE(t1.FechaCreacion)<= '" + FechaFin + "'");
            }

            traerTotal.consultaG(sqlquery);

            if (traerTotal.rs.first()) {
                totalmonto = traerTotal.rs.getString("total_monto");
                totalAcciones = traerTotal.rs.getString("total_acciones");
            }

            if (totalmonto == null && totalAcciones == null) {
                totalAceptaciones = "0;0";
            } else {
                totalAceptaciones = totalmonto + ";" + totalAcciones;
            }

            //traerTotal.cerrarConexiones();
        } catch (SQLException e) {
            logger.error("OPA - " + FacadeAceptaciones.class.getName(), e);
        } finally {
            traerTotal.cerrarConexiones();
        }

        return totalAceptaciones;
    }

    public SCB CargarRepresentante(String codigo) {

        //PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        SCB rp = new SCB();
        SCB listDat = null;

        try {

            rp.consultaG("SELECT a.c_representante, a.c_representante2, a.c_representante3, a.c_numdoc_representante, a.c_numdoc_representante2, "
                    + " a.c_numdoc_representante3 "
                    + " FROM dm_scb a"
                    + " where a.i_codigoentidad  = " + codigo);

            if (rp.rs.next()) {
                listDat = new SCB();
                listDat.cerrarConexiones();

                listDat.setRepresentante(rp.rs.getString("a.c_representante"));
                listDat.setRepresentante1(rp.rs.getString("a.c_representante2"));
                listDat.setRepresentante2(rp.rs.getString("a.c_representante3"));
                listDat.setNombredocr(rp.rs.getString("a.c_numdoc_representante"));
                listDat.setNombredoc1(rp.rs.getString("a.c_numdoc_representante2"));
                listDat.setNombredoc2(rp.rs.getString("a.c_numdoc_representante3"));

            }

        } catch (SQLException ex) {
            logger.error("OPA - " + FacadeAceptaciones.class.getName(), ex);

        } finally {

            rp.cerrarConexiones();

        }

        return listDat;

    }
    
    public List<List<String>> ListarDemandasAdjudicacionconsolidado(String ctaInv) {

        PropertyConfigurator.configure("/apps/OPI/logs/opi-log4j.properties");
        Aceptaciones form = new Aceptaciones();
        List<List<String>> listDatDem = new ArrayList<List<String>>();
        String sqlquery = "";

        for (int i = 0; i < 25; i++) {
            listDatDem.add(new ArrayList<String>());
        }
        try {

            sqlquery = ("SELECT  CA.EntidadDeNegociosID,  CA.ClaseAcciones, CA.ConOfeVen,\n"
                    + "                     CA.CodScb, CA.NombreRazonSocial,                    \n"
                    + "                     CA.NumAcciones, CA.VenCon, CA.TipDocumento, CA.NumNitDoc,\n"
                    + "                     CA.NumVer, CA.EspFid, CA.CtaInv, CA.NombreUsuarioIdCreacion,\n"
                    + "                     DATE(CA.FechaCreacion) AS FechaCreacion, TIME(CA.FechaCreacion) AS FechaCreacion2,\n"
                    + "                     CA.NombreUsuarioIdModificacion, TD.c_nombredoc,\n"
                    + "                     CA.estado,CA.PorcentajePagoEfectivo,CA.MontoTotalEfectivo,\n"
                    + "                      ADJ.i_id_adjudicacion, ADJ.i_id_aceptacion,ADJ.i_acciones_adjudicadas, ADJ.d_precio, ADJ.d_monto,\n"
                    + "                     CA.estado FROM fqs_CrearAceptacion CA, dm_tipodocumento TD, fqs_adjudicacion ADJ\n"
                    + "                     WHERE CA.TipDocumento = TD.i_tipodocumento AND (CA.estado LIKE '%Ingresado%' or CA.estado LIKE '%Modificado%')\n"
                    + "                      AND CA.EntidadDeNegociosID = ADJ.i_id_aceptacion AND CA.CtaInv=" + ctaInv + ";");

            form.consultaLectura(sqlquery);

            while (form.rs.next()) {
                listDatDem.get(0).add(form.rs.getString("EntidadDeNegociosID"));
                listDatDem.get(1).add(form.rs.getString("ClaseAcciones"));
                listDatDem.get(2).add(form.rs.getString("ConOfeVen"));
                listDatDem.get(3).add(form.rs.getString("CodScb"));
                listDatDem.get(4).add(form.rs.getString("NombreRazonSocial"));
                listDatDem.get(5).add(form.rs.getString("NumAcciones"));
                listDatDem.get(6).add(form.rs.getString("VenCon"));
                listDatDem.get(7).add(form.rs.getString("TipDocumento"));
                listDatDem.get(8).add(form.rs.getString("NumNitDoc"));
                listDatDem.get(9).add((form.rs.getString("NumVer")));
                listDatDem.get(10).add(form.rs.getString("EspFid"));
                listDatDem.get(11).add(form.rs.getString("CtaInv"));
                listDatDem.get(12).add(form.rs.getString("NombreUsuarioIdCreacion"));
                listDatDem.get(13).add(form.rs.getString("FechaCreacion"));
                listDatDem.get(14).add(form.rs.getString("FechaCreacion2"));
                listDatDem.get(15).add(form.rs.getString("NombreUsuarioIdModificacion"));
                listDatDem.get(16).add(form.rs.getString("c_nombredoc"));
                listDatDem.get(17).add(form.rs.getString("estado"));
                listDatDem.get(18).add(form.rs.getString("PorcentajePagoEfectivo"));
                listDatDem.get(19).add(form.rs.getString("MontoTotalEfectivo"));
                listDatDem.get(20).add(form.rs.getString("i_id_adjudicacion"));
                listDatDem.get(21).add(form.rs.getString("i_id_aceptacion"));
                listDatDem.get(22).add(form.rs.getString("i_acciones_adjudicadas"));
                listDatDem.get(23).add(form.rs.getString("d_precio"));
                listDatDem.get(24).add(form.rs.getString("d_monto"));
            }
            form.cerrarConexiones();
        } catch (SQLException ex) {
            logger.error("OPI - "+FacadeAceptaciones.class.getName(), ex);
        } finally {
            form.cerrarConexiones();
        }
        return listDatDem;

    }
    
    /**
     * Consulta el tipo de oferta pública de una aceptación para cargar la info 
     * en pantalla
     * @param id
     * @return 
     */
    public String findAceptacionTypeById(String id){
        String type = "";
        Aceptaciones acpt = new Aceptaciones();
        try {
            acpt.consultaG("SELECT tipo_oferta_publica FROM fqs_crearaceptacion WHERE EntidadDeNegociosID = ?", id);
            if (acpt.rs.first()) {
                type = acpt.rs.getString("tipo_oferta_publica");
            }
        } catch (SQLException e) {
            logger.error("OPA - " + FacadeAceptaciones.class.getName(), e);
        } finally {
            acpt.cerrarConexiones();
        }
        return type;
    }

    public long countAceptacionesExists(){
       Aceptaciones acpt = new Aceptaciones();
       long counter=0;
        try {
            acpt.consultaG2("SELECT COUNT(EntidadDeNegociosID) AS cantidad FROM fqs_CrearAceptacion ;");
            if (acpt.rs.first()) {
                counter = acpt.rs.getLong("cantidad");
            }
        } catch (SQLException e) {
            logger.error("OPA - " + FacadeAceptaciones.class.getName(), e);
        } finally {
            acpt.cerrarConexiones();
        }
        return counter;
   }
    
   public String[] CargarIdMila(String idNegocio) throws SQLException{
        PropertyConfigurator.configure("/apps/OPI/logs/opi-log4j.properties");
        Aceptaciones form = new Aceptaciones();
        
        String[] aceptacionIdMilla = null;
        
        form.consultaLectura("Select idMila from fqs_crearaceptacion WHERE EntidadDeNegociosID = "+idNegocio);
        
        
        if(form.rs.first()){
            aceptacionIdMilla = new String[]{
            form.rs.getString("idMila")};
        }
       
        return aceptacionIdMilla;
   }

}
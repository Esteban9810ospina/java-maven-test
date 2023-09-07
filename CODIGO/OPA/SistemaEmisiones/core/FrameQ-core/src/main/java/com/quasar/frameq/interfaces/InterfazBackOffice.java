/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quasar.frameq.interfaces;

import com.quasar.frameq.data.Aceptaciones;
import com.quasar.frameq.data.BulletinReport;
import com.quasar.frameq.db.Facade;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Cristian
 */
public class InterfazBackOffice {

    Facade facade = new Facade();
    private static final Logger logger = Logger.getLogger(InterfazBackOffice.class.getName());
    List<String> parametros = null;
    private String tipoOfertaPublica = "";
    
    //Constantes que corresponden a las consultas dinámicas de acuerdo al tipo de Oferta pública: OPI u OPA
    private  String FROM_FORMA_PAGO_OPI = ", fqs_formapago FormaPago ";
    private  String CANTIDAD_ACCIONES_PAGO_OPI = " ,FormaPago.CantidadAccionesPago ";
    private  String AND_CONDICIONAL_OPI = " AND adj.i_id_aceptacion=FormaPago.i_id_aceptacion ";
    private  String orderByOPI = " order by FormaPago.CantidadAccionesPago desc,FormaPago.i_id_aceptacion asc ";

    public int ObtenerSecuenciaIDR() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Aceptaciones adj = new Aceptaciones();
        int seq = 0;
        try {
            adj.consultaLectura("SELECT seqInterfazBackOffice()");
            if (adj.rs.first()) {
                seq = adj.rs.getInt(1);
            }
        } catch (SQLException ex) {
            logger.error("OPA - " + InterfazBackOffice.class.getName(), ex);
        } finally {
            adj.cerrarConexiones();
        }
        return seq;
    }

    public int ObtenerSecuenciaReporte() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Aceptaciones adj = new Aceptaciones();
        int seq = 0;
        try {
            adj.consultaLectura("SELECT seqReporteAdjudicacion()");
            if (adj.rs.first()) {
                seq = adj.rs.getInt(1);
            }
        } catch (SQLException ex) {
            logger.error("OPA - " + InterfazBackOffice.class.getName(), ex);
        } finally {
            adj.cerrarConexiones();
        }
        return seq;
    }
    
     public int ObtenerSecuenciaI20() {
        PropertyConfigurator.configure("/apps/OPI/logs/opi-log4j.properties");
        Aceptaciones adj = new Aceptaciones();
        int seq = 0;
        try {
            adj.consultaLectura("SELECT seqInterfaz20()");
            if (adj.rs.first()) {
                seq = adj.rs.getInt(1);
            }
        } catch (SQLException ex) {
            logger.error("OPI - "+InterfazBackOffice.class.getName(), ex);
        } finally {
            adj.cerrarConexiones();
        }
        return seq;
    }

    public List<List<String>> AdjudicacionesInterfaz() {

        int hayParametrizacion = facade.validaHayParametros();
        if (hayParametrizacion == 1) {
            parametros = facade.RetornaParametros();
        }else{
            throw new RuntimeException("No se ha creado una parametrización todavía");
        }
        
        //Se deja este ordenamiento en blanco por SOE-261 para hacerse igual que el de OPA
       //  orderByOPI = "";
        
        tipoOfertaPublica = parametros.get(41);
        if (tipoOfertaPublica.equals("OPA")) {
            AND_CONDICIONAL_OPI = "";
            orderByOPI = "";
            FROM_FORMA_PAGO_OPI = "";
            CANTIDAD_ACCIONES_PAGO_OPI = "";
        }

        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Aceptaciones adj = new Aceptaciones();
        List<List<String>> listAdj = new ArrayList<List<String>>();

        for (int i = 0; i <= 24; i++) {
            listAdj.add(new ArrayList<String>());
        }

        try {
            adj.consultaLectura("SELECT LPAD(adj.i_acciones_adjudicadas, 11, 0) i_acciones_adjudicadas, "
                    + "RPAD(param.Nanotecnico, 10, ' ') Nanotecnico, LPAD(adj.d_precio, 14, 0) d_precio, "
                    + "LPAD(acep.CodScb, 3, 0) CodScbCompra, LPAD(param.SCBOferente, 3, 0) CodScbVenta, '   ' Liquidacion, "
                    + "'C' TLiquidacion, 'S' MercadoOpe, 'P' TOperacion, "
                    + "CASE WHEN acep.NumNitDoc != SCB.c_documento THEN 'T' WHEN acep.NumNitDoc = SCB.c_documento "
                    + "AND acep.EspFid = '' THEN 'P' WHEN acep.NumNitDoc = SCB.c_documento "
                    + "AND acep.EspFid != '' THEN 'E' END 'OriRecursoVenta', "
                    + "CASE WHEN param.NumeroDocumentoOferente != SCB2.c_documento THEN 'T' WHEN "
                    + "param.NumeroDocumentoOferente = SCB2.c_documento AND (param.EFOferente = '' OR param.EFOferente = NULL )  "
                    + "THEN 'P' WHEN param.NumeroDocumentoOferente = SCB2.c_documento AND "
                    + "param.EFOferente != '' THEN 'E' END 'OriRecursoCompra', acep.TipDocumento, "
                    + "acep.NumNitDoc, IFNULL(acep.NumVer, '') NumVer, RPAD(acep.EspFid, 3, ' ') EspFid, "
                    + "LPAD(acep.CtaInv, 10, 0) CtaInv, RPAD(acep.ConOfeVen, 8, ' ') ConOfeVen, param.TipoDocumentoOferente, "
                    + "param.NumeroDocumentoOferente, param.DVOferente, "
                    + "RPAD(param.EFOferente, 3, ' ') EFOferente, LPAD(param.CuentaDecevalOferente, 10, 0) CuentaDecevalOferente, RPAD(param.referenciaComprador, 8, ' ') RefCompra, "
                    + "IFNULL(LPAD(REPLACE(REPLACE(REPLACE(FORMAT(PorcentajeComision, 3), '.', '@'), ',', ''), '@', ''),6,'0'),'000000')   porcentajeComisionV, IFNULL(LPAD(REPLACE(REPLACE(REPLACE(FORMAT(param.comisionCompra, 3), '.', '@'), ',', ''), '@', ''),6,'0'),'000000') porcentajeComisionC "+CANTIDAD_ACCIONES_PAGO_OPI+""
                    + "FROM fqs_adjudicacion adj, fqs_CrearAceptacion acep, dm_scb SCB, fqs_Parametrizacion param, "
                    + "fqs_usuario usu, dm_scb SCB2 "+ FROM_FORMA_PAGO_OPI+ " WHERE adj.i_acciones_adjudicadas!=0 AND adj.i_id_aceptacion = acep.EntidadDeNegociosID "
                    + "AND SCB2.i_scb = param.SCBOferente AND SCB.i_scb = acep.CodScb AND adj.d_precio > 0 " + AND_CONDICIONAL_OPI
                    + "GROUP BY adj.i_id_adjudicacion "
                    + orderByOPI);

            while (adj.rs.next()) {
                listAdj.get(0).add(adj.rs.getString("i_acciones_adjudicadas"));
                listAdj.get(1).add(adj.rs.getString("Nanotecnico"));
                listAdj.get(2).add(adj.rs.getString("d_precio"));
                listAdj.get(3).add(adj.rs.getString("CodScbCompra"));
                listAdj.get(4).add(adj.rs.getString("CodScbVenta"));
                listAdj.get(5).add(adj.rs.getString("Liquidacion"));
                listAdj.get(6).add(adj.rs.getString("TLiquidacion"));
                listAdj.get(7).add(adj.rs.getString("MercadoOpe"));
                listAdj.get(8).add(adj.rs.getString("TOperacion"));
                listAdj.get(9).add(adj.rs.getString("OriRecursoVenta"));
                listAdj.get(10).add(adj.rs.getString("OriRecursoCompra"));
                listAdj.get(11).add(adj.rs.getString("TipDocumento"));
                listAdj.get(12).add(adj.rs.getString("NumNitDoc"));
                listAdj.get(13).add(adj.rs.getString("NumVer"));
                listAdj.get(14).add(adj.rs.getString("EspFid"));
                listAdj.get(15).add(adj.rs.getString("CtaInv"));
                listAdj.get(16).add(adj.rs.getString("ConOfeVen"));
                listAdj.get(17).add(adj.rs.getString("TipoDocumentoOferente"));
                listAdj.get(18).add(adj.rs.getString("NumeroDocumentoOferente"));
                listAdj.get(19).add(adj.rs.getString("DVOferente"));
                listAdj.get(20).add(adj.rs.getString("EFOferente"));
                listAdj.get(21).add(adj.rs.getString("CuentaDecevalOferente"));
                listAdj.get(22).add(adj.rs.getString("RefCompra"));
                listAdj.get(23).add(adj.rs.getString("porcentajeComisionV"));
                listAdj.get(24).add(adj.rs.getString("porcentajeComisionC"));

            }
        } catch (SQLException ex) {
            logger.error("OPA - " + InterfazBackOffice.class.getName(), ex);
        } finally {
            adj.cerrarConexiones();
        }
        return listAdj;
    }

    /**
     * Es usado para generar el reporter de OPA
     *
     * @return
     */
    public List<List<String>> AdjudicacionesReporte() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Aceptaciones adj = new Aceptaciones();
        List<List<String>> listAdj = new ArrayList<List<String>>();

        try {
            adj.consultaLectura("  SELECT 1 AS ORDEN, a.Nanotecnico, a.ClaseAcciones, b.EntidadDeNegociosID, DATE_FORMAT(b.FechaCreacion,'%d-%m-%Y') AS Fecha,DATE_FORMAT(b.FechaCreacion,'%H:%i:%S') AS Hora,"
                    + " b.ConOfeVen,  CASE b.ExistePreacuerdo  WHEN \"1\" THEN \"Si\" WHEN \"2\" THEN \"No\" ELSE \"\"  END AS ExistePreacuerdo , "
                    + " i_codigoentidad AS CodScb,"
                    + " c_razonsocial,"
                    + "  CONCAT(d.c_nombre,' ' ,c_apellidos) AS nombres, b.RepresentanteLegal,"
                    + " b.NombreRazonSocial, e.c_nombredoc, b.NumNitDoc, b.NumVer, b.CtaInv, b.EspFid, "
                    + " CASE b.VenCon WHEN '1' THEN 'Si'  WHEN '0' THEN 'No' ELSE ''  END AS VenCon ,"
                    + " REPLACE(REPLACE(REPLACE(FORMAT(b.NumAcciones,0 ),'.','@'),',','.'),'@',',') NumAcciones, "
                    + " REPLACE(REPLACE(REPLACE(FORMAT(b.NumAcciones*a.PrecioAceptaciones,2),'.','@'),',','.'),'@',',') AS MontoSolicitado, "
                    + " REPLACE(REPLACE(REPLACE(FORMAT(a.PrecioAceptaciones,2),'.','@'),',','.'),'@',',') AS PrecioAceptaciones , "
                    + " REPLACE(REPLACE(REPLACE(FORMAT( f.i_acciones_adjudicadas,0),'.','@'),',','.'),'@',',') AS i_acciones_adjudicadas , "
                    + " REPLACE(REPLACE(REPLACE(FORMAT(f.d_monto,2),'.','@'),',','.'),'@',',') AS d_monto,"
                    + " REPLACE(REPLACE(REPLACE(FORMAT(b.PorcentajeComision,3),'.','@'),',','.'),'@',',') AS PorcentajeComision "
                    + " FROM fqs_Parametrizacion a, fqs_CrearAceptacion b"
                    + " INNER JOIN dm_scb c ON b.CodScb=c.i_scb"
                    + " INNER JOIN fqs_usuario d ON b.NombreUsuarioIdCreacion=d.i_usuario"
                    + " INNER JOIN dm_tipodocumento e ON b.TipDocumento=e.i_tipodocumento"
                    + " INNER JOIN fqs_adjudicacion f ON b.EntidadDeNegociosID=f.i_id_aceptacion"
                    + " UNION "
                    + " SELECT 2 AS ORDEN,'TOTALES' AS Nanotecnico, '' AS ClaseAcciones , NULL AS EntidadDeNegociosID,'' AS Fecha,'' AS Hora,"
                    + " '' AS ConOfeVen,  '' AS ExistePreacuerdo , "
                    + " ''  AS CodScb,"
                    + " '' AS c_razonsocial, "
                    + " '' AS nombres, '' AS RepresentanteLegal,"
                    + " '' AS NombreRazonSocial, '' AS c_nombredoc, '' AS NumNitDoc, '' AS NumVer, '' AS CtaInv, '' AS EspFid, "
                    + " '' AS VenCon ,"
                    + " REPLACE(REPLACE(REPLACE(FORMAT(SUM(b.NumAcciones),0 ),'.','@'),',','.'),'@',',') AS NumAcciones,"
                    + " REPLACE(REPLACE(REPLACE(FORMAT(SUM(b.NumAcciones*a.PrecioAceptaciones),2),'.','@'),',','.'),'@',',') AS MontoSolicitado, "
                    + " '' AS PrecioAceptaciones , "
                    + " REPLACE(REPLACE(REPLACE(FORMAT( SUM(f.i_acciones_adjudicadas),0),'.','@'),',','.'),'@',','), "
                    + " REPLACE(REPLACE(REPLACE(FORMAT(SUM(f.d_monto),2),'.','@'),',','.'),'@',',') AS d_monto,"
                    + " '' AS PorcentajeComision "
                    + " FROM fqs_Parametrizacion a, fqs_CrearAceptacion b"
                    + " INNER JOIN dm_scb c ON b.CodScb=c.i_scb"
                    + " INNER JOIN fqs_usuario d ON b.NombreUsuarioIdCreacion=d.i_usuario"
                    + " INNER JOIN dm_tipodocumento e ON b.TipDocumento=e.i_tipodocumento"
                    + " INNER JOIN fqs_adjudicacion f ON b.EntidadDeNegociosID=f.i_id_aceptacion order by 1 asc,4 ASC");

            while (adj.rs.next()) {
                List myList = new ArrayList();
                myList.add(adj.rs.getString("Nanotecnico"));
                myList.add(adj.rs.getString("ClaseAcciones"));
                myList.add(adj.rs.getString("EntidadDeNegociosID"));
                myList.add(adj.rs.getString("Fecha"));
                myList.add(adj.rs.getString("Hora"));
                myList.add(adj.rs.getString("ConOfeVen"));
                myList.add(adj.rs.getString("ExistePreacuerdo"));
                myList.add(adj.rs.getString("CodScb"));
                myList.add(adj.rs.getString("c_razonsocial"));
                myList.add(adj.rs.getString("nombres"));
                myList.add(adj.rs.getString("RepresentanteLegal"));
                myList.add(adj.rs.getString("NombreRazonSocial"));
                /*myList.add(adj.rs.getString("ApellidoRazonSocial"));*/
                myList.add(adj.rs.getString("c_nombredoc"));
                myList.add(adj.rs.getString("NumNitDoc"));
                myList.add(adj.rs.getString("NumVer"));
                myList.add(adj.rs.getString("CtaInv"));
                myList.add(adj.rs.getString("EspFid"));
                myList.add(adj.rs.getString("VenCon"));
                myList.add(adj.rs.getString("NumAcciones"));
                myList.add(adj.rs.getString("MontoSolicitado"));
                myList.add(adj.rs.getString("PrecioAceptaciones"));
                if (adj.rs.getString("PorcentajeComision") != null && !adj.rs.getString("PorcentajeComision").equals("")) {
                    myList.add(adj.rs.getString("PorcentajeComision").concat(" %"));
                } else {
                    myList.add("");
                }
                myList.add(adj.rs.getString("i_acciones_adjudicadas"));
                myList.add(adj.rs.getString("d_monto"));
                listAdj.add(myList);
            }
        } catch (SQLException ex) {
            logger.error("OPA - " + InterfazBackOffice.class.getName(), ex);
        } finally {
            adj.cerrarConexiones();
        }
        return listAdj;
    }

    /**
     * Consulta para generar reporte en OPI
     *
     * @return
     */
    public List<List<String>> AdjudicacionesReporteOPI() {
        PropertyConfigurator.configure("/apps/OPI/logs/opi-log4j.properties");
        Aceptaciones adj = new Aceptaciones();
        List<List<String>> listAdj = new ArrayList<List<String>>();
//        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest req = attr.getRequest();
//        HttpSession session = req.getSession();

        /*  for (int i = 0; i <= 22; i++) {
            listAdj.add(new ArrayList<String>());
        }*/
        try {
            adj.consultaLectura("SELECT 1 AS ORDEN, a.Nanotecnico, a.ClaseAcciones, b.EntidadDeNegociosID, DATE_FORMAT(b.FechaCreacion,'%d-%m-%Y') AS Fecha,DATE_FORMAT(b.FechaCreacion,'%H:%i:%S') AS Hora,"
                    + " b.ConOfeVen,  CASE b.ExistePreacuerdo  WHEN \"1\" THEN \"Si\" WHEN \"2\" THEN \"No\" ELSE \"\"  END AS ExistePreacuerdo , "
                    + " i_codigoentidad AS CodScb,"
                    + " c_razonsocial,"
                    + "  CONCAT(d.c_nombre,' ' ,c_apellidos) AS nombres, b.RepresentanteLegal,"
                    + " b.NombreRazonSocial, e.c_nombredoc, b.NumNitDoc, b.NumVer, b.CtaInv, b.EspFid, "
                    + " CASE b.VenCon WHEN '1' THEN 'Si'  WHEN '0' THEN 'No' ELSE ''  END AS VenCon ,b.PorcentajePagoEfectivo,"
                    + " REPLACE(REPLACE(REPLACE(FORMAT(b.NumAcciones,0 ),'.','@'),',','.'),'@',',') NumAcciones, "
                    + " REPLACE(REPLACE(REPLACE(FORMAT(b.NumAcciones*a.PrecioAceptaciones,2),'.','@'),',','.'),'@',',') AS MontoSolicitado, "
                    + " REPLACE(REPLACE(REPLACE(FORMAT(a.PrecioAceptaciones,2),'.','@'),',','.'),'@',',') AS PrecioAceptaciones , "
                    + " REPLACE(REPLACE(REPLACE(FORMAT( f.i_acciones_adjudicadas,0),'.','@'),',','.'),'@',',') AS i_acciones_adjudicadas , "
                    + " REPLACE(REPLACE(REPLACE(FORMAT(f.d_monto,2),'.','@'),',','.'),'@',',') AS d_monto,"
                    //+ " REPLACE(REPLACE(REPLACE(truncate(((b.NumAcciones*a.PrecioAceptaciones)*((100-b.PorcentajePagoEfectivo)/100))/a.precioaccionespago,0),'.','@'),',','.'),'@',',') AS GA_inicial,"
                    + " REPLACE(REPLACE(REPLACE(FORMAT(a.precioaccionespago,2),'.','@'),',','.'),'@',',') AS precioaccionespago,"
                    + " REPLACE(REPLACE(REPLACE(FORMAT(	g.PorcentajeEfectivoAsignado,2),'.','@'),',','.'),'@',',') AS PorcentajeEfectivoAsignado,"
                    + " REPLACE(REPLACE(REPLACE(FORMAT(g.MontoEfectivoAsignado,2),'.','@'),',','.'),'@',',') AS MontoEfectivoAsignado,"
                    + " REPLACE(REPLACE(REPLACE(FORMAT(	g.PorcentajeTitulosAsignado,2),'.','@'),',','.'),'@',',') AS PorcentajeTitulosAsignado,"
                    + " REPLACE(REPLACE(REPLACE(FORMAT(g.MontoTitulosAsignado,2),'.','@'),',','.'),'@',',') AS MontoTitulosAsignado,"
                    + " REPLACE(REPLACE(REPLACE(FORMAT(g.CantidadAccionesPago,2),'.','@'),',','.'),'@',',') AS CantidadAccionesPago,"
                    + " REPLACE(REPLACE(REPLACE(FORMAT(g.MontoTitulosFinal,2),'.','@'),',','.'),'@',',') AS MontoTitulosFinal,"
                    + " REPLACE(REPLACE(REPLACE(FORMAT(g.SaldoMontoTitulos,2),'.','@'),',','.'),'@',',') AS SaldoMontoTitulos,"
                    + " REPLACE(REPLACE(REPLACE(FORMAT(g.MontoEfectivoFinal,2),'.','@'),',','.'),'@',',') AS MontoEfectivoFinal,"
                    + " REPLACE(REPLACE(REPLACE(FORMAT(g.CantidadAccionesPago,0),'.','@'),',','.'),'@',',') AS GAdefinitivas,"
                    + " REPLACE(REPLACE(REPLACE(FORMAT(b.PorcentajeComision,3),'.','@'),',','.'),'@',',') AS PorcentajeComision "
                    + " FROM fqs_Parametrizacion a, fqs_CrearAceptacion b"
                    + " INNER JOIN dm_scb c ON b.CodScb=c.i_scb"
                    + " INNER JOIN fqs_usuario d ON b.NombreUsuarioIdCreacion=d.i_usuario"
                    + " INNER JOIN dm_tipodocumento e ON b.TipDocumento=e.i_tipodocumento"
                    + " INNER JOIN fqs_adjudicacion f ON b.EntidadDeNegociosID=f.i_id_aceptacion"
                    + " INNER JOIN fqs_formapago g ON g.i_id_aceptacion =f.i_id_aceptacion"
                    + " UNION "
                    + " SELECT 2 AS ORDEN,'TOTALES' AS Nanotecnico, '' AS ClaseAcciones , NULL AS EntidadDeNegociosID,'' AS Fecha,'' AS Hora,"
                    + " '' AS ConOfeVen,  '' AS ExistePreacuerdo , "
                    + " ''  AS CodScb,"
                    + " '' AS c_razonsocial, "
                    + " '' AS nombres, '' AS RepresentanteLegal,"
                    + " '' AS NombreRazonSocial, '' AS c_nombredoc, '' AS NumNitDoc, '' AS NumVer, '' AS CtaInv, '' AS EspFid,  "
                    + " '' AS VenCon ,'' AS PorcentajePagoEfectivo ,"
                    + " REPLACE(REPLACE(REPLACE(FORMAT(SUM(b.NumAcciones),0 ),'.','@'),',','.'),'@',',') AS NumAcciones,"
                    + " REPLACE(REPLACE(REPLACE(FORMAT(SUM(b.NumAcciones*a.PrecioAceptaciones),2),'.','@'),',','.'),'@',',') AS MontoSolicitado, "
                    + " '' AS PrecioAceptaciones , "
                    + " REPLACE(REPLACE(REPLACE(FORMAT( SUM(f.i_acciones_adjudicadas),0),'.','@'),',','.'),'@',',') AS i_acciones_adjudicadas, "
                    + " REPLACE(REPLACE(REPLACE(FORMAT(SUM(f.d_monto),2),'.','@'),',','.'),'@',',') AS d_monto,"
                    //+ " REPLACE(REPLACE(REPLACE(FORMAT(SUM(TRUNCATE((((b.NumAcciones*a.PrecioAceptaciones)*((100-b.PorcentajePagoEfectivo)/100))/a.precioaccionespago),0)),2),'.','@'),',','.'),'@',',') AS GA_inicial, "
                    + " '' AS precioaccionespago,"
                    + " '' AS PorcentajeEfectivoAsignado,"
                    + " REPLACE(REPLACE(REPLACE(FORMAT(SUM(g.MontoEfectivoAsignado),2),'.','@'),',','.'),'@',',') AS MontoEfectivoAsignado,"
                    + " '' AS	PorcentajeTitulosAsignado,"
                    + " REPLACE(REPLACE(REPLACE(FORMAT(SUM(g.MontoTitulosAsignado),2),'.','@'),',','.'),'@',',') AS MontoTitulosAsignado,"
                    + " REPLACE(REPLACE(REPLACE(FORMAT(SUM(g.CantidadAccionesPago),2),'.','@'),',','.'),'@',',') AS CantidadAccionesPago,"
                    + " REPLACE(REPLACE(REPLACE(FORMAT(SUM(g.MontoTitulosFinal),2),'.','@'),',','.'),'@',',') AS MontoTitulosFinal,"
                    + " REPLACE(REPLACE(REPLACE(FORMAT(SUM(g.SaldoMontoTitulos),2),'.','@'),',','.'),'@',',') AS SaldoMontoTitulos,"
                    + " REPLACE(REPLACE(REPLACE(FORMAT(SUM(g.MontoEfectivoFinal),2),'.','@'),',','.'),'@',',') AS MontoEfectivoFinal,"
                    + " REPLACE(REPLACE(REPLACE(FORMAT(SUM(g.CantidadAccionesPago),0),'.','@'),',','.'),'@',',') AS GAdefinitivas, "
                    + " '' AS PorcentajeComision "
                    + " FROM fqs_Parametrizacion a, fqs_CrearAceptacion b"
                    + " INNER JOIN dm_scb c ON b.CodScb=c.i_scb"
                    + " INNER JOIN fqs_usuario d ON b.NombreUsuarioIdCreacion=d.i_usuario"
                    + " INNER JOIN dm_tipodocumento e ON b.TipDocumento=e.i_tipodocumento"
                    + " INNER JOIN fqs_adjudicacion f ON b.EntidadDeNegociosID=f.i_id_aceptacion "
                    + " INNER JOIN fqs_formapago g ON g.i_id_aceptacion =f.i_id_aceptacion "
                    + " order by 1 asc,4 ASC");

            while (adj.rs.next()) {
                List myList = new ArrayList();

                myList.add(adj.rs.getString("Nanotecnico"));
                myList.add(adj.rs.getString("ClaseAcciones"));
                myList.add(adj.rs.getString("EntidadDeNegociosID"));
                myList.add(adj.rs.getString("Fecha"));
                myList.add(adj.rs.getString("Hora"));
                myList.add(adj.rs.getString("ConOfeVen"));
                myList.add(adj.rs.getString("ExistePreacuerdo"));
                myList.add(adj.rs.getString("CodScb"));
                myList.add(adj.rs.getString("c_razonsocial"));
                myList.add(adj.rs.getString("nombres"));
                myList.add(adj.rs.getString("RepresentanteLegal"));
                myList.add(adj.rs.getString("NombreRazonSocial"));
                /*myList.add(adj.rs.getString("ApellidoRazonSocial"));*/
                myList.add(adj.rs.getString("c_nombredoc"));
                myList.add(adj.rs.getString("NumNitDoc"));
                myList.add(adj.rs.getString("NumVer"));
                myList.add(adj.rs.getString("CtaInv"));
                myList.add(adj.rs.getString("EspFid"));
                myList.add(adj.rs.getString("VenCon"));
                if (adj.rs.getString("PorcentajePagoEfectivo") != null && !adj.rs.getString("PorcentajePagoEfectivo").equals("")) {
                    myList.add(adj.rs.getString("PorcentajePagoEfectivo").concat(" %"));
                } else {
                    myList.add("");
                }
                myList.add(adj.rs.getString("NumAcciones"));
                myList.add(adj.rs.getString("MontoSolicitado") != null ? "$" + adj.rs.getString("MontoSolicitado") : "");
                myList.add(adj.rs.getString("PrecioAceptaciones"));
                myList.add(adj.rs.getString("i_acciones_adjudicadas"));
                myList.add(adj.rs.getString("d_monto") != null ? "$" + adj.rs.getString("d_monto") : "");
                //myList.add(adj.rs.getString("GA_inicial"));
                myList.add(adj.rs.getString("precioaccionespago"));
                if (adj.rs.getString("PorcentajeEfectivoAsignado") != null && !adj.rs.getString("PorcentajeEfectivoAsignado").equals("")) {
                    myList.add(adj.rs.getString("PorcentajeEfectivoAsignado").concat(" %"));
                } else {
                    myList.add("");
                }
                myList.add(adj.rs.getString("MontoEfectivoAsignado") != null ? "$" + adj.rs.getString("MontoEfectivoAsignado") : "");
                if (adj.rs.getString("PorcentajeTitulosAsignado") != null && !adj.rs.getString("PorcentajeTitulosAsignado").equals("")) {
                    myList.add(adj.rs.getString("PorcentajeTitulosAsignado").concat(" %"));
                } else {
                    myList.add("");
                }
                myList.add(adj.rs.getString("MontoTitulosAsignado") != null ? "$" + adj.rs.getString("MontoTitulosAsignado") : "");
                myList.add(adj.rs.getString("CantidadAccionesPago"));
                myList.add(adj.rs.getString("MontoTitulosFinal") != null ? "$" + adj.rs.getString("MontoTitulosFinal") : "");
                myList.add(adj.rs.getString("SaldoMontoTitulos"));
                myList.add(adj.rs.getString("MontoEfectivoFinal") != null ? "$" + adj.rs.getString("MontoEfectivoFinal") : "");
                myList.add(adj.rs.getString("GAdefinitivas"));
                if (adj.rs.getString("PorcentajeComision") != null && !adj.rs.getString("PorcentajeComision").equals("")) {
                    myList.add(adj.rs.getString("PorcentajeComision").concat(" %"));
                } else {
                    myList.add("");
                }
                listAdj.add(myList);
            }
        } catch (SQLException ex) {
            logger.error("OPI - " + InterfazBackOffice.class.getName(), ex);
        } finally {
            adj.cerrarConexiones();
        }
        return listAdj;
    }

    //public static String[] BoletinReporte() {
    public static BulletinReport BoletinReporte() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        BulletinReport bulletinReport = null;
        Aceptaciones adj = new Aceptaciones();
        try {
            String sql = "select p.ClaseAcciones,p.Accionesnegociadas,p.TxtBoletinInformativo,p.TxtBulletinInformative,p.tipo_oferta_publica,p.NombreRazonSocial, \n"
                    + "                    REPLACE(REPLACE(REPLACE(FORMAT((select p.AccionesEnCirculacion from fqs_Parametrizacion as p ),0 ),'.','@'),',','.'),'@',',') as AccionesEnCirculacion, \n"
                    + "                    (select(ROUND((TRUNCATE((((select sum(NumAcciones) from fqs_CrearAceptacion where estado not like 'R%')/(select AccionesEnCirculacion from fqs_Parametrizacion))*100),3))*100)/100)) percentageShares, "
                    + "                    REPLACE(REPLACE(REPLACE(FORMAT((select count(*) from fqs_CrearAceptacion where estado not like 'R%' AND (FechaCreacion < CURRENT_DATE() )),0 ),'.','@'),',','.'),'@',',') as A, \n"
                    + "                    REPLACE(REPLACE(REPLACE(FORMAT((select count(*) from fqs_CrearAceptacion where estado not like 'R%' AND (FechaCreacion >= CURRENT_DATE() )),0 ),'.','@'),',','.'),'@',',') as B, \n"
                    + "                    REPLACE(REPLACE(REPLACE(FORMAT((select count(*) from fqs_CrearAceptacion where estado not like 'R%' ),0 ),'.','@'),',','.'),'@',',') as C, \n"
                    + "                    IFNULL( REPLACE(REPLACE(REPLACE(FORMAT((select sum(NumAcciones) from fqs_CrearAceptacion where estado not like 'R%' AND (FechaCreacion < CURRENT_DATE() )),0 ),'.','@'),',','.'),'@',','),'0') as D, \n"
                    + "                    IFNULL( REPLACE(REPLACE(REPLACE(FORMAT((select sum(NumAcciones) from fqs_CrearAceptacion where estado not like 'R%' AND (FechaCreacion >= CURRENT_DATE() )),0 ),'.','@'),',','.'),'@',','),'0') as E, \n"
                    + "	                   IFNULL( REPLACE(REPLACE(REPLACE(FORMAT((select sum(NumAcciones) from fqs_CrearAceptacion where estado not like 'R%'),0 ),'.','@'),',','.'),'@',','),'0') as F, \n"
                    + "                    IFNULL( REPLACE(REPLACE(REPLACE(FORMAT(((select sum(NumAcciones) *100 from fqs_CrearAceptacion where estado not like 'R%' AND (FechaCreacion < CURRENT_DATE() ))/(select MaxAccionesObjOferta from fqs_Parametrizacion) ),2),'.','@'),',','.'),'@',','),'0') as G, \n"
                    + "                    IFNULL( REPLACE(REPLACE(REPLACE(FORMAT(((select sum(NumAcciones) *100 from fqs_CrearAceptacion where estado not like 'R%' AND (FechaCreacion >= CURRENT_DATE()))/ (select MaxAccionesObjOferta from fqs_Parametrizacion) ),2 ),'.','@'),',','.'),'@',','),'0') as H, \n"
                    + "                    IFNULL( REPLACE(REPLACE(REPLACE(FORMAT(((select sum(NumAcciones) *100 from fqs_CrearAceptacion where estado not like 'R%' )/(select MaxAccionesObjOferta from fqs_Parametrizacion)),2 ),'.','@'),',','.'),'@',','),'0') as I, \n"
                    + "                    REPLACE(REPLACE(REPLACE(FORMAT((select count(*) from fqs_CrearAceptacion where estado not like 'R%' AND (FechaCreacion < CURRENT_DATE() )  AND VenCon=1),0 ),'.','@'),',','.'),'@',',') as J, \n"
                    + "                    REPLACE(REPLACE(REPLACE(FORMAT((select count(*) from fqs_CrearAceptacion where estado not like 'R%' AND (FechaCreacion >= CURRENT_DATE() )  AND VenCon=1),0 ),'.','@'),',','.'),'@',',') as K, \n"
                    + "                    REPLACE(REPLACE(REPLACE(FORMAT((select count(*) from fqs_CrearAceptacion where estado not like 'R%'  AND VenCon=1),0 ),'.','@'),',','.'),'@',',') as L, \n"
                    + "                    IFNULL( REPLACE(REPLACE(REPLACE(FORMAT((select sum(NumAcciones) from fqs_CrearAceptacion where estado not like 'R%' AND (FechaCreacion < CURRENT_DATE() ) AND VenCon=1),0 ),'.','@'),',','.'),'@',','),'0') as M, \n"
                    + "                    IFNULL( REPLACE(REPLACE(REPLACE(FORMAT((select sum(NumAcciones) from fqs_CrearAceptacion where estado not like 'R%' AND (FechaCreacion >= CURRENT_DATE() ) AND VenCon=1),0 ),'.','@'),',','.'),'@',','),'0') as N, \n"
                    + "                    IFNULL( REPLACE(REPLACE(REPLACE(FORMAT((select sum(NumAcciones) from fqs_CrearAceptacion where estado not like 'R%' AND VenCon=1),0 ),'.','@'),',','.'),'@',','),'0') as O                      \n"
                    + "                    from fqs_Parametrizacion as p;";
            adj.consultaLectura(sql);
            if (adj.next()) {
               bulletinReport = new BulletinReport();
               bulletinReport.setClassShares(adj.rs.getString("ClaseAcciones"));                            //ClaseAcciones
               bulletinReport.setSharesTraded(adj.rs.getString("Accionesnegociadas"));                      //Accionesnegociadas
               bulletinReport.setSpanishNewsletterText(adj.rs.getString("TxtBoletinInformativo"));          //TxtBoletinInformativo
               bulletinReport.setEnglishNewsletterText(adj.rs.getString("TxtBulletinInformative"));         //TxtBulletinInformative
               bulletinReport.setTipoOfertaPublica(adj.rs.getString("tipo_oferta_publica"));                //tipo_oferta_publica
               bulletinReport.setNombreRazonSocial(adj.rs.getString("Accionesnegociadas"));                  //NombreRazonSocial
               bulletinReport.setOutStandingShares(adj.rs.getString("AccionesEnCirculacion"));              //accionesEnCirculacion
               try{
                    bulletinReport.setPercentageShares(adj.rs.getString("percentageShares"));               //percentageShares            
               }catch(Exception e){
                    bulletinReport.setPercentageShares("0");                                               //percentageShares            
                }
               bulletinReport.setAcceptanceCreatedBeforeToday(adj.rs.getString("A"));                       //acceptanceCreatedBeforeToday
               bulletinReport.setAcceptanceCreatedToday(adj.rs.getString("B"));                             //acceptanceCreatedToday
               bulletinReport.setTotalAcceptancesCreated(adj.rs.getString("C"));                            //totalAcceptancesCreated
               bulletinReport.setActionsCreatedBeforeToday(adj.rs.getString("D"));                          //actionsCreatedBeforeToday
               bulletinReport.setActionsCreatedToday(adj.rs.getString("E"));                                //actionsCreatedToday
               bulletinReport.setTotalActionsCreated(adj.rs.getString("F"));                                //totalActionsCreated
               bulletinReport.setActionsCreatedBeforeTodayPercentage(adj.rs.getString("G").concat("%"));    //actionsCreatedBeforeTodayPercentage
               bulletinReport.setActionsCreatedTodayPercentage(adj.rs.getString("H").concat("%"));          //actionsCreatedTodayPercentage
               bulletinReport.setTotalActionsCreatedPercentage(adj.rs.getString("I").concat("%"));          //totalActionsCreatedPercentage
               bulletinReport.setAcceptanceCreatedBeforeTodayVenCon1(adj.rs.getString("J"));                //acceptanceCreatedBeforeTodayVenCon1
               bulletinReport.setAcceptanceCreatedTodayVenCon1(adj.rs.getString("K"));                      //acceptanceCreatedTodayVenCon1
               bulletinReport.setTotalAcceptancesCreatedVenCon1(adj.rs.getString("L"));                     //totalAcceptancesCreatedVenCon1
               bulletinReport.setActionsCreatedBeforeTodayVenCon1(adj.rs.getString("M"));                   //actionsCreatedBeforeTodayVenCon1
               bulletinReport.setActionsCreatedTodayVenCon1(adj.rs.getString("N"));                         //actionsCreatedTodayVenCon1
               bulletinReport.setTotalActionsCreatedVenCon1(adj.rs.getString("O"));                         //totalActionsCreatedVenCon1               
                }
        } catch (SQLException ex) {
            bulletinReport = null;
            logger.error("OPA - " + InterfazBackOffice.class.getName(), ex);
        } finally {
            adj.cerrarConexiones();
        }
        return bulletinReport;
    }

    public List<List<String>> AdjudicacionesI20() {
        PropertyConfigurator.configure("/apps/OPI/logs/opi-log4j.properties");
        int consecutivo = 0;

        Formatter fmt1 = new Formatter();

        Aceptaciones adj = new Aceptaciones();
        List<List<String>> listAdj = new ArrayList<List<String>>();

        for (int i = 0; i <= 33; i++) {
            listAdj.add(new ArrayList<String>());
        }

        try {
            adj.consultaLectura("SELECT "
                    + "LPAD(adj.i_id_aceptacion,8,0) AS IdAceptacion,acep.TipDocumento,"
                    + "RPAD((CASE acep.TipDocumento  WHEN \"4\" THEN (CONCAT(acep.NumNitDoc,acep.NumVer)) ELSE acep.NumNitDoc  END),15,' ') AS NumNitDoc,"
                    + "RPAD(acep.EspFid, 3, ' ') EspFid,"
                    + "CASE acep.TipDocumento  WHEN \"4\" THEN \"2\" ELSE \"1\"  END AS TipoPersona,"
                    /*+ "RPAD(UPPER(acep.ApellidorazonSocial),30,' ') AS ApellidoRazonSocial,"*/
                    + "RPAD(UPPER(acep.NombreRazonSocial),30,' ') AS NombreRazonSocial,"
                    + "LPAD(FormaPago.CantidadAccionesPago,12,0) AS CantidadAccionesPago,"
                    + "LPAD(REPLACE((REPLACE(FORMAT(param.precioaccionespago,2),'.','')),',',''),12,0) AS precioaccionespago,"
                    + "LPAD(REPLACE((FORMAT(FormaPago.MontoTitulosFinal,0)),',',''),15,0) AS MontoTitulosFinal1,"
                    + "CONCAT('+',(LPAD(REPLACE((REPLACE((FORMAT(FormaPago.MontoTitulosFinal,2)),'.','')),',',''),14,0))) AS MontoTitulosFinal2,"
                    + "REPLACE((SUBSTRING(adj.ts_fecha_hora_ultima_modificacion,1,10)),'-','') AS FechaAdjudica,"
                    + "REPLACE((SUBSTRING(acep.FechaCreacion,1,10)),'-','') AS FechaCreacion,"
                    + "LPAD(acep.Codscb,4,0) AS Codscb,"
                    + "LPAD(acep.CtaInv, 8, 0) CtaInv,"
                    + "RPAD(acep.ConOfeVen, 8, ' ') ConOfeVen "
                    + "FROM fqs_adjudicacion adj, fqs_CrearAceptacion acep, dm_scb SCB, fqs_Parametrizacion param,"
                    + "fqs_usuario usu, dm_scb SCB2,fqs_formapago FormaPago WHERE adj.i_acciones_adjudicadas!=0 AND adj.i_id_aceptacion = acep.EntidadDeNegociosID "
                    + "AND SCB2.i_scb = param.SCBOferente AND SCB.i_scb = acep.CodScb AND adj.d_precio > 0 and adj.i_id_aceptacion=FormaPago.i_id_aceptacion "
                    + "AND FormaPago.CantidadAccionesPago!=0 "
                    + "GROUP BY adj.i_id_adjudicacion "
                    + "order by FormaPago.CantidadAccionesPago desc,FormaPago.i_id_aceptacion  asc");

            while (adj.rs.next()) {

                listAdj.get(0).add(fmt1.format("%09d", ++consecutivo).toString());
                listAdj.get(1).add(adj.rs.getString("IdAceptacion"));
                listAdj.get(2).add("0");
                listAdj.get(3).add(adj.rs.getString("TipDocumento"));
                listAdj.get(4).add(adj.rs.getString("NumNitDoc"));
                listAdj.get(5).add(adj.rs.getString("EspFid"));
                listAdj.get(6).add(adj.rs.getString("TipoPersona"));
                /*listAdj.get(7).add(adj.rs.getString("ApellidoRazonSocial"));*/
                listAdj.get(7).add(adj.rs.getString("NombreRazonSocial"));
                listAdj.get(8).add("0");
                listAdj.get(9).add("2");
                listAdj.get(10).add("169");
                listAdj.get(11).add("1");
                listAdj.get(12).add("00000");
                fmt1 = new Formatter();
                listAdj.get(13).add(fmt1.format("%09d", consecutivo).toString());
                listAdj.get(14).add(adj.rs.getString("CantidadAccionesPago"));
                listAdj.get(15).add(adj.rs.getString("precioaccionespago"));
                listAdj.get(16).add(adj.rs.getString("MontoTitulosFinal1"));
                listAdj.get(17).add(adj.rs.getString("MontoTitulosFinal1"));
                listAdj.get(18).add("0000000");
                listAdj.get(19).add("000000000000000");
                listAdj.get(20).add(adj.rs.getString("MontoTitulosFinal2"));
                //listAdj.get(21).add("+00000000000000");   //Se comenta por el error reportado en SOE-260
                listAdj.get(21).add(adj.rs.getString("MontoTitulosFinal1"));
                listAdj.get(22).add("1");
                listAdj.get(23).add(adj.rs.getString("FechaAdjudica"));
                listAdj.get(24).add(adj.rs.getString("FechaCreacion"));
                listAdj.get(25).add(adj.rs.getString("FechaCreacion"));
                listAdj.get(26).add(adj.rs.getString("Codscb"));
                listAdj.get(27).add(adj.rs.getString("CtaInv"));
                listAdj.get(28).add("2");
                listAdj.get(29).add("090");
                listAdj.get(30).add(adj.rs.getString("Codscb"));
                listAdj.get(31).add(adj.rs.getString("ConOfeVen"));
                listAdj.get(32).add("C");

                fmt1 = new Formatter();

            }
//            consecutivo = 0;

        } catch (SQLException ex) {
            logger.error("OPI - " + InterfazBackOffice.class.getName(), ex);
        } finally {
            adj.cerrarConexiones();
        }
        return listAdj;
    }
}

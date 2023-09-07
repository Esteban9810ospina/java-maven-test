/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quasar.frameq.Dao;

import com.quasar.frameq.data.Adjudicacion;
import com.quasar.frameq.fachadas.FacadeUsuarios;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


/**
 *
 * @author jam
 */
public class AdjudicacionDao {
    
        
       private static final Logger logger = Logger.getLogger(AdjudicacionDao.class.getName());
       public String  traerDatos() {
       
       PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
       String SumaAdjudiTotal = "";
       Adjudicacion adjudicacion = new Adjudicacion();

        try {

            String MinAccionesObjOferta = "";
            String MaxAccionesObjOferta = "";
            String NombreRazonSocial = "";
            String PrecioAceptaciones = "";            
            String Nanotecnico = "";
            String ClaseAcciones = "";
            String NumeroDocumentoOferente;
            String DVOferente;
            String EFOferente;
            String CuentaDecevalOferente;
            
           adjudicacion.consultaLectura("SELECT EntidadDeNegociosID, UsuarioID, FechaIniOperacion, HoraIniOperacion, FechaFinOperacion, HoraFinOperacion, MinAccionesObjOferta, "
            + "MaxAccionesObjOferta, NombreRazonSocial, PrecioAceptaciones, NumeroAceptacion, TextoUno, TextoDos, ExistePreacuerdo,"
            + "CantReporte, Nanotecnico, ClaseAcciones, CantUsuariosOpe, NombreUsuarioIdCreacion, FechaCreacion, NombreUsuarioIdModificacion, "
            + "FechaModificacion, TodoONada, TipoDocumentoOferente, NumeroDocumentoOferente, DVOferente, EFOferente, CuentaDecevalOferente, "
            + "SCBOferente FROM fqs_Parametrizacion");

             if (adjudicacion.rs.first()) {
                MinAccionesObjOferta = adjudicacion.rs.getString("MinAccionesObjOferta");
                MaxAccionesObjOferta = adjudicacion.rs.getString("MaxAccionesObjOferta");
                ClaseAcciones = adjudicacion.rs.getString("ClaseAcciones");
                Nanotecnico = adjudicacion.rs.getString("Nanotecnico");                
                PrecioAceptaciones = adjudicacion.rs.getString("PrecioAceptaciones");
                NombreRazonSocial = adjudicacion.rs.getString("NombreRazonSocial");
                NumeroDocumentoOferente = adjudicacion.rs.getString("NumeroDocumentoOferente");
                DVOferente = adjudicacion.rs.getString("DVOferente");
                EFOferente = adjudicacion.rs.getString("EFOferente");
                CuentaDecevalOferente = adjudicacion.rs.getString("CuentaDecevalOferente");                 
                adjudicacion.cerrarConexiones();

                SumaAdjudiTotal = MinAccionesObjOferta + ";" + MaxAccionesObjOferta + ";" + ClaseAcciones + ";"+ Nanotecnico + ";"+PrecioAceptaciones +";"+NombreRazonSocial +";"+NumeroDocumentoOferente +";"+DVOferente +";"+EFOferente +";"+CuentaDecevalOferente; 

            }
      
         } catch (SQLException e) {
            logger.error("OPA - " + AdjudicacionDao.class.getName(), e);
            adjudicacion.cerrarConexiones();  
        } finally {
            adjudicacion.cerrarConexiones();
        }

       return SumaAdjudiTotal;
    }
    
    
    
    
   public String nomCodSCB() {
       PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
       String Scb = "";
       Adjudicacion adjudicacion = new Adjudicacion();
       
    try {  
        adjudicacion.consultaLectura("SELECT c_razonsocial FROM dm_scb scb INNER JOIN fqs_Parametrizacion para " +
                                 " ON scb.i_scb = para.SCBOferente");        
     
        if (adjudicacion.rs.first()) {
            Scb = (adjudicacion.rs.getString("c_razonsocial"));
        }

    } catch (SQLException e) {
            logger.error("OPA - " + AdjudicacionDao.class.getName(), e);
            adjudicacion.cerrarConexiones(); 
        } finally {
            adjudicacion.cerrarConexiones();
        }
 
    return Scb;
  } 
   
   public String CodSCB() {
       PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
       String Scb = "";
       Adjudicacion adjudicacion = new Adjudicacion();
       
    try {  
        adjudicacion.consultaLectura("SELECT i_codigoentidad FROM dm_scb scb INNER JOIN fqs_Parametrizacion para " +
                                 " ON scb.i_scb = para.SCBOferente");        
     
        if (adjudicacion.rs.first()) {
            Scb = (adjudicacion.rs.getString("i_codigoentidad"));
        }

    } catch (SQLException e) {
            logger.error("OPA - " + AdjudicacionDao.class.getName(), e);
            adjudicacion.cerrarConexiones();  
        } finally {
            adjudicacion.cerrarConexiones();
        }
 
    return Scb;
  } 
    
    public String tipDocumento() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String tipDoc = "";
        Adjudicacion adjudicacion = new Adjudicacion();
    try {
        adjudicacion.consultaLectura("SELECT  c_nombredoc FROM dm_tipodocumento doc INNER JOIN fqs_Parametrizacion para " +
                                         " ON doc.i_tipodocumento = para.TipoDocumentoOferente");        
      
          if (adjudicacion.rs.first()) {
             tipDoc = adjudicacion.rs.getString("c_nombredoc");
      }

    } catch (SQLException e) {
            logger.error("OPA - " + AdjudicacionDao.class.getName(), e);
            adjudicacion.cerrarConexiones();
        } finally {
            adjudicacion.cerrarConexiones();
        }
    return tipDoc;
  } 
    
    public String canTotalAcciones() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String cantTotal = "";
        Adjudicacion adjudicacion = new Adjudicacion();
        try {

            adjudicacion.consultaLectura("SELECT SUM(NumAcciones) AS cantTotal FROM fqs_CrearAceptacion WHERE estado !='Rechazado'");

            if (adjudicacion.rs.first()) {
                cantTotal = adjudicacion.rs.getString("cantTotal");
            }

            if (cantTotal == null) {
                cantTotal = "0";
            }

        } catch (SQLException e) {
            logger.error("OPA - " + AdjudicacionDao.class.getName(), e);
            adjudicacion.cerrarConexiones();
        } finally {
            adjudicacion.cerrarConexiones();
        }
        return cantTotal;
    }
    
     public String canAccionesTodoNada() {
         PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
         String cantTotalTN = "";
         Adjudicacion adjudicacion = new Adjudicacion();
    try {        

      adjudicacion.consultaLectura("SELECT SUM(NumAcciones) AS cantaccionestodonada FROM fqs_CrearAceptacion WHERE VenCon=1 AND estado IN ('Ingresado','Modificado')");

        if (adjudicacion.rs.first()) {
           cantTotalTN = adjudicacion.rs.getString("cantaccionestodonada");
        }
        
         if (cantTotalTN == null) {
                cantTotalTN = "0";
            }

    } catch (SQLException e) {
            logger.error("OPA - " + AdjudicacionDao.class.getName(), e);
            adjudicacion.cerrarConexiones();   
        } finally {
            adjudicacion.cerrarConexiones();
        }
    return cantTotalTN;
  }  
     
    public String canAccionesSinTodoNada() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String cantAccionSinTN = "";
        Adjudicacion adjudicacion = new Adjudicacion();
    try {
         adjudicacion.consultaLectura("SELECT SUM(NumAcciones) AS cantaccionessintodonada FROM fqs_CrearAceptacion WHERE VenCon!=1  AND (estado LIKE '%Ingresado%' or estado LIKE '%Modificado%')");  
       
      if(adjudicacion.rs.first()){
        cantAccionSinTN = adjudicacion.rs.getString("cantaccionessintodonada");
      }
      
      if (cantAccionSinTN==null){
          cantAccionSinTN="0";
      }

    } catch (SQLException e) {
            logger.error("OPA - " + AdjudicacionDao.class.getName(), e);
            adjudicacion.cerrarConexiones(); 
        } finally {
            adjudicacion.cerrarConexiones();
        }
    return cantAccionSinTN;
  }   
     
    public String totalAceptaciones() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String tipDoc = "";
        Adjudicacion adjudicacion = new Adjudicacion();
    try {
         adjudicacion.consultaLectura("SELECT COUNT(EntidadDeNegociosID) AS totalAceptaciones FROM fqs_CrearAceptacion WHERE estado != 'Rechazado'"); 
    
      if (adjudicacion.rs.first()) {
          tipDoc = adjudicacion.rs.getString("totalAceptaciones");
      }

    } catch (SQLException e) {
            logger.error("OPA - " + AdjudicacionDao.class.getName(), e);
            adjudicacion.cerrarConexiones(); 
        } finally {
            adjudicacion.cerrarConexiones();
        }
    return tipDoc;
  }

   public String totalAceptacionesTN() {
       PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
       String tipDoc = "";
       Adjudicacion adjudicacion = new Adjudicacion();
    try {

       adjudicacion.consultaLectura("SELECT COUNT(EntidadDeNegociosID) AS totalAceptaciones FROM fqs_CrearAceptacion WHERE VenCon=1 AND estado IN ('Ingresado','Modificado')");

        if (adjudicacion.rs.first()) {
           tipDoc = adjudicacion.rs.getString("totalAceptaciones");  
        }


    } catch (SQLException e) {
            logger.error("OPA - " + AdjudicacionDao.class.getName(), e);
            adjudicacion.cerrarConexiones();
        } finally {
            adjudicacion.cerrarConexiones();
        }
    return tipDoc;
  }    
   
    public List<List<String>> ListAccionesMinAcciones() {
       PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String datos = "";
       Adjudicacion adjudicacion = new Adjudicacion();
       List<List<String>> listAccionesMin = new ArrayList<List<String>>();
              
        try {
            for (int i = 0; i <= 2; i++) {
                listAccionesMin.add(new ArrayList<String>());
            }
          
            adjudicacion.consultaLectura("SELECT ACP.FechaCreacion, ADJ.i_acciones_adjudicadas AS minAcciones, ADJ.i_id_aceptacion AS  i_id_aceptacion FROM fqs_adjudicacion ADJ "
                    + " INNER JOIN fqs_CrearAceptacion ACP "
                    + " ON ADJ.i_id_aceptacion = ACP.EntidadDeNegociosID "
                    + " WHERE  ADJ.estado='Ingresado' "
                    + " ORDER BY  ADJ.i_acciones_adjudicadas ASC, ADJ.i_id_aceptacion ASC, ACP.FechaCreacion ASC");
            
             while (adjudicacion.rs.next()) {
                 listAccionesMin.get(0).add(adjudicacion.rs.getString("FechaCreacion"));
                 listAccionesMin.get(1).add(adjudicacion.rs.getString("minAcciones"));
                 listAccionesMin.get(2).add(adjudicacion.rs.getString("i_id_aceptacion"));
                 
             }
      
    } catch (SQLException e) {
            logger.error("OPA - " + AdjudicacionDao.class.getName(), e);
            adjudicacion.cerrarConexiones();  
        } finally {
            adjudicacion.cerrarConexiones();
        }
       return listAccionesMin;
    }
    
     public List<List<String>> ListAccionesMasAcciones() {
       PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
         String datos = "";
        Adjudicacion adjudicacion = new Adjudicacion();
         List<List<String>> listAccionesMax = new ArrayList<List<String>>();
        try {
          
            for (int i = 0; i <= 2; i++) {
                listAccionesMax.add(new ArrayList<String>());
            }

          
            adjudicacion.consultaLectura("SELECT ACP.FechaCreacion, ADJ.i_acciones_adjudicadas AS minAcciones, ADJ.i_id_aceptacion AS  i_id_aceptacion FROM fqs_adjudicacion ADJ "
                    + " INNER JOIN fqs_CrearAceptacion ACP "
                    + " ON ADJ.i_id_aceptacion = ACP.EntidadDeNegociosID "
                    + " WHERE  ADJ.estado='Ingresado' "
                    + " ORDER BY  ADJ.i_acciones_adjudicadas DESC, ADJ.i_id_aceptacion ASC, ACP.FechaCreacion ASC LIMIT 1");

                 while (adjudicacion.rs.next()) {
                 listAccionesMax.get(0).add(adjudicacion.rs.getString("FechaCreacion"));
                 listAccionesMax.get(1).add(adjudicacion.rs.getString("minAcciones"));
                 listAccionesMax.get(2).add(adjudicacion.rs.getString("i_id_aceptacion"));
                 
                 }     
    } catch (SQLException e) {
            logger.error("OPA - " + AdjudicacionDao.class.getName(), e);
            adjudicacion.cerrarConexiones();   
        } finally {
            adjudicacion.cerrarConexiones();
        }
       return listAccionesMax;
    }
     
    public BigDecimal numAccionesAceptacion(String id) {
       PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
       BigDecimal numAcciones = new BigDecimal("0.0");
       Adjudicacion adjudicacion = new Adjudicacion();
        try {

          adjudicacion.consultaLectura("SELECT NumAcciones FROM fqs_CrearAceptacion WHERE EntidadDeNegociosID = " + id);
          
             if (adjudicacion.rs.first()) {
                numAcciones = adjudicacion.rs.getBigDecimal("NumAcciones");
            } 
             
    } catch (SQLException e) {
            logger.error("OPA - " + AdjudicacionDao.class.getName(), e);
            adjudicacion.cerrarConexiones();   
        } finally {
            adjudicacion.cerrarConexiones();
        }
       return numAcciones;
    }  
    
    
      public String  SumAdjudicacion() {
       String SumaAdjudiTotal = "";
       Adjudicacion adjudicacion = new Adjudicacion();
        try {
            
          String totalAcciones="";
          String totalPrecio = "";
          String totalmonto ="";          
          
          adjudicacion.consultaLectura("");

            if (adjudicacion.rs.first()) {   
                totalAcciones = adjudicacion.rs.getString("totalAcciones");
                totalPrecio = adjudicacion.rs.getString("totalPrecio");
                totalmonto = adjudicacion.rs.getString("totalmonto");

                SumaAdjudiTotal = totalAcciones + ";" + totalPrecio + ";"+ totalmonto; 

            }
      
    } catch (SQLException e) {
            logger.error("OPA - " + AdjudicacionDao.class.getName(), e);
            adjudicacion.cerrarConexiones();   
        } catch (NullPointerException e) {
                SumaAdjudiTotal = "0";
        } 
        
        finally {
            adjudicacion.cerrarConexiones();
        }

       return SumaAdjudiTotal;
    }
      
     public void deleteAccionesAdj() {
        String resultado = "Exito";
        Adjudicacion adjudicacion = new Adjudicacion();
        try {             
            adjudicacion.actualizar("DELETE FROM fqs_adjudicacion ");

        } catch (Exception e) {
            logger.error("OPA - " + AdjudicacionDao.class.getName(), e);
            adjudicacion.cerrarConexiones();
        } finally {
            adjudicacion.cerrarConexiones();
        }
   
     }    
     
     public void deleteFormapago() {
        PropertyConfigurator.configure("/apps/OPI/logs/opi-log4j.properties");
        String resultado = "Exito";
        Adjudicacion adjudicacion = new Adjudicacion();
        try {
            adjudicacion.actualizar("DELETE FROM fqs_formapago;");

        } catch (Exception e) {
            logger.error("OPI - "+AdjudicacionDao.class.getName(), e);
            adjudicacion.cerrarConexiones();
        } finally {
            adjudicacion.cerrarConexiones();
        }

    }
   
    
    public String updateAcciones(String id, java.math.BigInteger numAcciones, java.math.BigDecimal  monto) {
        String resultado = "Exito";
        Adjudicacion adjudicacion = new Adjudicacion();
        try {
             adjudicacion.actualiza("UPDATE fqs_adjudicacion SET d_monto=?, i_acciones_adjudicadas = ? WHERE i_id_aceptacion = ? " ,monto, numAcciones, id);
        } catch (Exception e) {
            logger.error("OPA - " + AdjudicacionDao.class.getName(), e);
            adjudicacion.cerrarConexiones();
        }  finally {
            adjudicacion.cerrarConexiones();
        }
        return resultado;
    }
    
    public String insertAceptacionesDesiertas(String idAceptacion, java.math.BigDecimal accionesAdj, 
        java.math.BigDecimal precio, java.math.BigDecimal monto, String estado, String usuario, String tipomod) {
        String resultado="Exito";   
        Adjudicacion adjudicacion = new Adjudicacion();
        
    try {
      adjudicacion.actualiza("INSERT INTO fqs_adjudicacion (i_id_aceptacion, i_acciones_adjudicadas, d_precio, d_monto, estado, c_usuario_sistema_ultima_mod, c_tipo_modificacion)" 
                                              + " VALUES (?,?,?,?,?,?,?)", idAceptacion , accionesAdj, precio ,monto , estado,  usuario , tipomod); 

      
      adjudicacion.cerrarConexiones();      

    } catch (SQLException e) {
            logger.error("OPA - " + AdjudicacionDao.class.getName(), e);
            adjudicacion.cerrarConexiones();
        } finally {
            adjudicacion.cerrarConexiones();
        }
     return resultado;
  }
    
     public String updateFormapago(String id, Double PorcentajePagoEfectivo, java.math.BigDecimal MontoEfectivoAsignado, java.math.BigDecimal Montodjudicado, java.math.BigDecimal PrecioAccionesParametrizado) {
        PropertyConfigurator.configure("/apps/OPI/logs/opi-log4j.properties");
        String resultado = "Exito";
        BigDecimal totalPorcentaje = new BigDecimal(100);

        Adjudicacion adjudicacion = new Adjudicacion();

        BigDecimal montoEfectivoAsignado = MontoEfectivoAsignado.divide(totalPorcentaje, 2, RoundingMode.DOWN);
        BigDecimal PorcentajetituloAsignado = new BigDecimal(100 - PorcentajePagoEfectivo);
        BigDecimal montoTitulosAsignado = (PorcentajetituloAsignado.multiply(Montodjudicado)).divide(totalPorcentaje, 2, RoundingMode.DOWN);
        BigDecimal cantidadAccionesPago = (montoTitulosAsignado.divide(PrecioAccionesParametrizado, 0, RoundingMode.DOWN));
//        BigDecimal cantidadAccionesPago = (montoTitulosAsignado.divide(PrecioAccionesParametrizado,0,RoundingMode.DOWN)).setScale(0,RoundingMode.DOWN);
        BigDecimal montoTitulosFinal = cantidadAccionesPago.multiply(PrecioAccionesParametrizado);
        BigDecimal saldoMontoTitulos = montoTitulosAsignado.subtract(montoTitulosFinal);
        BigDecimal montoEfectivoFinal = montoEfectivoAsignado.add(saldoMontoTitulos);

//        System.out.println("cantidadAccionesPago___"+cantidadAccionesPago);
        try {
            adjudicacion.actualiza("UPDATE fqs_formapago SET PorcentajeEfectivoAsignado=" + PorcentajePagoEfectivo
                    + ",MontoEfectivoAsignado=" + montoEfectivoAsignado
                    + ",PorcentajeTitulosAsignado=" + PorcentajetituloAsignado
                    + ",MontoTitulosAsignado=" + montoTitulosAsignado
                    + ",CantidadAccionesPago=" + cantidadAccionesPago
                    + ",MontoTitulosFinal=" + montoTitulosFinal
                    + ",SaldoMontoTitulos=" + saldoMontoTitulos
                    + ",MontoEfectivoFinal=" + montoEfectivoFinal
                    + " WHERE i_id_aceptacion =" + id + ";");
        } catch (Exception e) {
            logger.error("OPI - "+AdjudicacionDao.class.getName(), e);
            adjudicacion.cerrarConexiones();
        } finally {
            adjudicacion.cerrarConexiones();
        }
        return resultado;
    }

    public String insertFormaPago(String idAceptacion, java.math.BigDecimal accionesAdj,
            java.math.BigDecimal precio, java.math.BigDecimal monto, String estado, String usuario, String tipomod) {
        PropertyConfigurator.configure("/apps/OPI/logs/opi-log4j.properties");
        String resultado = "Exito";
        Adjudicacion adjudicacion = new Adjudicacion();

        try {
            adjudicacion.actualiza("INSERT INTO fqs_formapago (`i_id_aceptacion`) VALUES (" + idAceptacion + ");");

            adjudicacion.cerrarConexiones();

        } catch (SQLException e) {
            logger.error("OPI - "+AdjudicacionDao.class.getName(), e);
            adjudicacion.cerrarConexiones();
        } finally {
            adjudicacion.cerrarConexiones();
        }
        return resultado;
    }

    public String umbral() {
        PropertyConfigurator.configure("/apps/OPI/logs/opi-log4j.properties");

        String umbral = "";
        Adjudicacion adjudicacion = new Adjudicacion();

        try {
            adjudicacion.consultaLectura("SELECT umbral FROM fqs_Parametrizacion;");
            if (adjudicacion.rs.first()) {
                umbral = adjudicacion.rs.getString("umbral");
            }
        } catch (SQLException e) {
            logger.error("OPI - "+AdjudicacionDao.class.getName(), e);
            adjudicacion.cerrarConexiones();
        } finally {
            adjudicacion.cerrarConexiones();
        }
        return umbral;

    }

    public String precioaccionespago() {
        PropertyConfigurator.configure("/apps/OPI/logs/opi-log4j.properties");

        String precioaccionespago = "";
        Adjudicacion adjudicacion = new Adjudicacion();

        try {
            adjudicacion.consultaLectura("SELECT precioaccionespago FROM fqs_Parametrizacion;");
            if (adjudicacion.rs.first()) {
                precioaccionespago = adjudicacion.rs.getString("precioaccionespago");
            }
        } catch (SQLException e) {
            logger.error("OPI - "+AdjudicacionDao.class.getName(), e);
            adjudicacion.cerrarConexiones();
        } finally {
            adjudicacion.cerrarConexiones();
        }
        return precioaccionespago;

    }

    public String porcentajeefectivopago() {
        PropertyConfigurator.configure("/apps/OPI/logs/opi-log4j.properties");

        String porcentajeefectivopago = "";
        Adjudicacion adjudicacion = new Adjudicacion();

        try {
            adjudicacion.consultaLectura("SELECT porcentajeefectivopago FROM fqs_Parametrizacion;");
            if (adjudicacion.rs.first()) {
                porcentajeefectivopago = adjudicacion.rs.getString("porcentajeefectivopago");
            }
        } catch (SQLException e) {
            logger.error("OPI - "+AdjudicacionDao.class.getName(), e);
            adjudicacion.cerrarConexiones();
        } finally {
            adjudicacion.cerrarConexiones();
        }
        return porcentajeefectivopago;

    }

}

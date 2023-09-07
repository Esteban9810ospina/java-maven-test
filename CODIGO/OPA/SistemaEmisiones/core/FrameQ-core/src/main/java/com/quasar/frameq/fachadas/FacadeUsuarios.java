/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quasar.frameq.fachadas;

import com.quasar.frameq.estructura.IpAutorizada;
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
public class FacadeUsuarios {
    private static final Logger logger = Logger.getLogger(FacadeUsuarios.class.getName());
    
    public int retornaSesion(int usuario) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        int sesion = 0;
        Parametro Traesesion = new Parametro();
        try {
            Traesesion.consultaG2("select sesion from fqs_usuario where i_usuario = ?", usuario);
            if (Traesesion.rs.first()) {
                sesion = Traesesion.rs.getInt("sesion");
                //Traesesion.cerrarConexiones();
            }
        } catch (SQLException e) {
            
            logger.error("OPA - " +FacadeUsuarios.class.getName(), e);
        } finally {
            Traesesion.cerrarConexiones();
        }
        return sesion;
    }
    
        public int parametroCambioClave() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
            int contrasena = 0;
        Parametro Traesesion = new Parametro();
        try {
            Traesesion.consultaG2("select c_valor from fqs_parametro where i_parametro = 20008");
            if (Traesesion.rs.first()) {
                contrasena = Traesesion.rs.getInt("c_valor");
                //Traesesion.cerrarConexiones();
            }
        } catch (SQLException e) {
            
            logger.error("OPA - " +FacadeUsuarios.class.getName(), e);	
        } finally {
            Traesesion.cerrarConexiones();
        }
        return contrasena;
    }
        
        public String ultimoCambioContrasena(int id) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
            String contrasena = "";
        Parametro Traesesion = new Parametro();
        try {
            Traesesion.consultaG2("select f_ult_cambio_clave from fqs_usuario where i_usuario = ?",id);
            if (Traesesion.rs.first()) {
                contrasena = Traesesion.rs.getString("f_ult_cambio_clave");
                //Traesesion.cerrarConexiones();
            }
        } catch (SQLException e) {
            
            logger.error("OPA - " +FacadeUsuarios.class.getName(), e);
        } finally {
            Traesesion.cerrarConexiones();
        }
        return contrasena;
    }
    
        public String retornaPassActual(int id) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String contrasena = "";
        Parametro Traesesion = new Parametro();
        try {
            Traesesion.consultaG2("select c_contrasena from fqs_usuario where i_usuario = ?", id);
            if (Traesesion.rs.first()) {
                contrasena = Traesesion.rs.getString("c_contrasena");
                //Traesesion.cerrarConexiones();
            }
        } catch (SQLException e) {
            
            logger.error("OPA - " +FacadeUsuarios.class.getName(), e);
        } finally {
            Traesesion.cerrarConexiones();
        }
        return contrasena;
    }

    public void updateSesion(int usuario) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Parametro update = new Parametro();

        try {
            update.actualiza("UPDATE fqs_usuario SET sesion=1  WHERE i_usuario = ?", usuario);
            //update.cerrarConexiones();
        } catch (SQLException ex) {
            
            logger.error("OPA - " +FacadeUsuarios.class.getName(), ex);
        } finally {
            update.cerrarConexiones();
        }
    }

    public void cierraSesion(int usuario) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Parametro update = new Parametro();

        try {
            update.actualiza("UPDATE fqs_usuario SET sesion=0  WHERE i_usuario = ?", usuario);
            //update.cerrarConexiones();
        } catch (SQLException ex) {
            
            logger.error("OPA - " +FacadeUsuarios.class.getName(), ex);
        } finally {
            update.cerrarConexiones();
        }
    }
    
    public void actualizarHistorial (int idusuario, String password, String fecha, int idUsuarioMod){
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
       Parametro update = new Parametro();
        try {
            update.actualiza("INSERT INTO fqs_usuario_password_historial (i_usuario, PASSWORD, fecha, i_usuario_modificador)" +
                             " VALUES (?,?,?,?)", idusuario, password, fecha, idUsuarioMod);
            //update.cerrarConexiones();
        } catch (SQLException ex) {
            
            logger.error("OPA - " +FacadeUsuarios.class.getName(), ex);
        } finally {
            update.cerrarConexiones();
        }
    }
    
        public List<List<String>> RetornarUsuariosSCB(String id) {
            PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Parametro Traeusuarios = new Parametro();
        List<List<String>> listUsuarios = new ArrayList<List<String>>();

        for (int i = 0; i <= 18; i++) {
            listUsuarios.add(new ArrayList<String>());
        }

        try {
            Traeusuarios.consultaLectura("SELECT usr.i_usuario id, LOWER(usr.c_login ) login, usr.c_contrasena contrasena, usr.c_nombre nombres, "
                    + " usr.c_apellidos apellidos, usr.c_email email, usr.c_tipo_identificacion tipo_identificacion, "
                    + " usr.c_identificacion identificacion, usr.dt_ultimologin ultimo_login, "
                    + " usr.i_numsesiones numero_sesiones, usr.f_ult_cambio_clave ultimo_cambio_clave, "
                    + " usr.c_estado estado, usr.f_ult_cambio_reintento ultimo_cambio_reintento, "
                    + " usr.i_usuariosupvisor supervisor_id, usr.c_direccion direccion, usr.c_telefono telefono, usr.i_cod_agente sbolsa, pe.c_nombre perfil, SCB.i_codigoentidad "
                    + " FROM fqs_usuario usr "
                    + " inner join fqs_usuario_has_fqs_perfil pu  on usr.i_usuario= pu.fqs_usuario_i_usuario "
                    + " inner join fqs_perfil pe on pe.i_perfil= pu.fqs_perfil_i_perfil "
                    + " INNER JOIN dm_scb SCB ON SCB.i_scb = usr.i_cod_agente "
                    + " AND  pe.i_perfil  in (4) AND usr.i_cod_agente = " + id);

            while (Traeusuarios.rs.next()) {

                listUsuarios.get(0).add(String.valueOf(Traeusuarios.rs.getInt("id")));
                listUsuarios.get(1).add(Traeusuarios.rs.getString("login"));
                listUsuarios.get(2).add(Traeusuarios.rs.getString("contrasena"));
                listUsuarios.get(3).add(Traeusuarios.rs.getString("nombres"));
                listUsuarios.get(4).add(Traeusuarios.rs.getString("apellidos"));
                listUsuarios.get(5).add(Traeusuarios.rs.getString("email"));
                listUsuarios.get(6).add(Traeusuarios.rs.getString("tipo_identificacion"));
                listUsuarios.get(7).add(Traeusuarios.rs.getString("identificacion"));
                listUsuarios.get(8).add(Traeusuarios.rs.getString("ultimo_login"));
                listUsuarios.get(9).add(String.valueOf(Traeusuarios.rs.getInt("numero_sesiones")));
                listUsuarios.get(10).add(Traeusuarios.rs.getString("ultimo_cambio_clave"));
                listUsuarios.get(11).add(Traeusuarios.rs.getString("estado"));
                listUsuarios.get(12).add(Traeusuarios.rs.getString("ultimo_cambio_reintento"));
                listUsuarios.get(13).add(Traeusuarios.rs.getString("supervisor_id"));
                listUsuarios.get(14).add(Traeusuarios.rs.getString("direccion"));
                listUsuarios.get(15).add(Traeusuarios.rs.getString("telefono"));
                listUsuarios.get(16).add(Traeusuarios.rs.getString("sbolsa"));
                listUsuarios.get(17).add(Traeusuarios.rs.getString("perfil"));
                listUsuarios.get(18).add(Traeusuarios.rs.getString("i_codigoentidad"));
            }
            //Traeusuarios.cerrarConexiones();
        } catch (SQLException ex) {
            
            logger.error("OPA - " +FacadeUsuarios.class.getName(), ex);
        } finally {
            Traeusuarios.cerrarConexiones();
        }
        return listUsuarios;
    }


    public List<List<String>> RetornarUsuarios() {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Parametro Traeusuarios = new Parametro();
        List<List<String>> listUsuarios = new ArrayList<List<String>>();

        for (int i = 0; i <= 18; i++) {
            listUsuarios.add(new ArrayList<String>());
        }

        try {
            Traeusuarios.consultaLectura("SELECT usr.i_usuario id, LOWER(usr.c_login ) login, usr.c_contrasena contrasena, usr.c_nombre nombres, "
                    + " usr.c_apellidos apellidos, usr.c_email email, usr.c_tipo_identificacion tipo_identificacion, "
                    + " usr.c_identificacion identificacion, usr.dt_ultimologin ultimo_login, "
                    + " usr.i_numsesiones numero_sesiones, usr.f_ult_cambio_clave ultimo_cambio_clave, "
                    + " usr.c_estado estado, usr.f_ult_cambio_reintento ultimo_cambio_reintento, "
                    + " usr.i_usuariosupvisor supervisor_id, usr.c_direccion direccion, usr.c_telefono telefono, "
                    + " usr.i_cod_agente sbolsa, pe.c_nombre perfil, SCB.i_codigoentidad "
                    + " FROM fqs_usuario usr INNER JOIN fqs_usuario_has_fqs_perfil pu  ON usr.i_usuario= pu.fqs_usuario_i_usuario "
                    + " INNER JOIN fqs_perfil pe ON pe.i_perfil= pu.fqs_perfil_i_perfil AND  pe.i_perfil != 5"
                    + " INNER JOIN dm_scb SCB "
                    + " ON SCB.i_scb = usr.i_cod_agente");

            while (Traeusuarios.rs.next()) {

                listUsuarios.get(0).add(String.valueOf(Traeusuarios.rs.getInt("id")));
                listUsuarios.get(1).add(Traeusuarios.rs.getString("login"));
                listUsuarios.get(2).add(Traeusuarios.rs.getString("contrasena"));
                listUsuarios.get(3).add(Traeusuarios.rs.getString("nombres"));
                listUsuarios.get(4).add(Traeusuarios.rs.getString("apellidos"));
                listUsuarios.get(5).add(Traeusuarios.rs.getString("email"));
                listUsuarios.get(6).add(Traeusuarios.rs.getString("tipo_identificacion"));
                listUsuarios.get(7).add(Traeusuarios.rs.getString("identificacion"));
                listUsuarios.get(8).add(Traeusuarios.rs.getString("ultimo_login"));
                listUsuarios.get(9).add(String.valueOf(Traeusuarios.rs.getInt("numero_sesiones")));
                listUsuarios.get(10).add(Traeusuarios.rs.getString("ultimo_cambio_clave"));
                listUsuarios.get(11).add(Traeusuarios.rs.getString("estado"));
                listUsuarios.get(12).add(Traeusuarios.rs.getString("ultimo_cambio_reintento"));
                listUsuarios.get(13).add(Traeusuarios.rs.getString("supervisor_id"));
                listUsuarios.get(14).add(Traeusuarios.rs.getString("direccion"));
                listUsuarios.get(15).add(Traeusuarios.rs.getString("telefono"));
                listUsuarios.get(16).add(Traeusuarios.rs.getString("sbolsa"));
                listUsuarios.get(17).add(Traeusuarios.rs.getString("perfil"));
                listUsuarios.get(18).add(Traeusuarios.rs.getString("i_codigoentidad"));
            }
            //Traeusuarios.cerrarConexiones();
        } catch (SQLException ex) {
            
            logger.error("OPA - " +FacadeUsuarios.class.getName(), ex);
        } finally {
            Traeusuarios.cerrarConexiones();
        }
        return listUsuarios;
    }

    public List<List<String>> RetornarPassUsuarios(String usuario) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Parametro pass = new Parametro();
        List<List<String>> passAnte = new ArrayList<List<String>>();

        for (int i = 0; i <= 3; i++) {
            passAnte.add(new ArrayList<String>());
        }
        int user = Integer.parseInt(usuario);

        try {
            pass.consultaLectura("SELECT ph.password pass, ph.fecha fecha,ph.i_usuario usuario,ph.llave_codificada llave "
                    + " FROM fqs_usuario_password_historial ph WHERE ph.i_usuario=" + user + " ORDER BY ph.fecha DESC LIMIT 3 ");

            while (pass.rs.next()) {

                passAnte.get(0).add(pass.rs.getString("pass"));
                passAnte.get(1).add(pass.rs.getString("fecha"));
                passAnte.get(2).add(pass.rs.getString("usuario"));
                passAnte.get(3).add(pass.rs.getString("llave"));

            }
           // pass.cerrarConexiones();
        } catch (SQLException ex) {
            
            logger.error("OPA - " +FacadeUsuarios.class.getName(), ex);
        } finally {
            pass.cerrarConexiones();
        }

        return passAnte;
    }
    
    public List<List<String>> RetornaLogin(String usuario) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Parametro log = new Parametro();
        List<List<String>> logAnte = new ArrayList<List<String>>();

        for (int i = 0; i <= 2; i++) {
            logAnte.add(new ArrayList<String>());
        }

        try {
            log.consultaLectura("SELECT ph.c_login login "
                    + " FROM fqs_usuario ph WHERE LOWER(ph.c_login)='" + usuario.toLowerCase() + "' ");

            while (log.rs.next()) {

                logAnte.get(0).add(log.rs.getString("login"));

            }
            //log.cerrarConexiones();
        } catch (SQLException ex) {
            
            logger.error("OPA - " +FacadeUsuarios.class.getName(), ex);
        } finally {
            log.cerrarConexiones();
        }

        return logAnte;
    }

    public int CantUsuariosSCB(String id) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        int VariableLocal_Resultado = 1;
        Parametro ValidarParametro = new Parametro();
        try {
            ValidarParametro.consultaG("SELECT COUNT(a.i_cod_agente) AS agente FROM fqs_usuario a INNER JOIN fqs_usuario_has_fqs_perfil b ON a.i_usuario=b.fqs_usuario_i_usuario WHERE  b.fqs_perfil_i_perfil=4 AND a.i_cod_agente=?", id);
            if (ValidarParametro.rs.first()) {
                VariableLocal_Resultado = Integer.parseInt(ValidarParametro.rs.getString("agente"));
                //ValidarParametro.cerrarConexiones();
            }
            else{
                VariableLocal_Resultado = 1;
            }
        } catch (Exception e) {
            VariableLocal_Resultado = 1;
        }finally{
            ValidarParametro.cerrarConexiones();
        }
        return VariableLocal_Resultado;
    }
    
      public Boolean CambiodeContrasena(String login) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Boolean VariableLocal = false;
        String VariableLocal_Resultado ="";
        Parametro ValidarParametro = new Parametro();
        try {
            ValidarParametro.consultaG("SELECT ty_cambiocontrasena FROM fqs_usuario WHERE c_login =?", login);
            if (ValidarParametro.rs.first()) {
                VariableLocal_Resultado = (ValidarParametro.rs.getString("ty_cambiocontrasena"));
                // ValidarParametro.cerrarConexiones();
                if (VariableLocal_Resultado.equalsIgnoreCase("0")){
                    VariableLocal = true;
                }
            }
            else{
                VariableLocal_Resultado = "";
            }
            
        } catch (Exception e) {
            VariableLocal_Resultado = "";
            
        }finally{
            ValidarParametro.cerrarConexiones();
        }
        return VariableLocal;
    }
      
    public ArrayList<IpAutorizada> traerIpAutorizada(Integer idUsuario) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Parametro ValidarParametro = new Parametro();
        
        ArrayList<IpAutorizada> ipsAutorizadas = new ArrayList<IpAutorizada>();
        IpAutorizada a = null;
        try {
            ValidarParametro.consultaG("SELECT ip_usuario,ip,c_usuario_sistema_ultima_mod,c_tipo_modificacion FROM fqs_IpAutorizada WHERE ip_usuario=? LIMIT 40",idUsuario);
        while (ValidarParametro.rs.next()) {
            a = new IpAutorizada(ValidarParametro.rs.getInt("ip_usuario"), ValidarParametro.rs.getString("ip"), ValidarParametro.rs.getString("c_usuario_sistema_ultima_mod"), ValidarParametro.rs.getString("c_tipo_modificacion"));
            ipsAutorizadas.add(a);
        }
        
        
        } catch (SQLException ex) {
            
            logger.error("OPA - " +FacadeUsuarios.class.getName(), ex);
        
        } finally {
            ValidarParametro.cerrarConexiones();
        }
        
        return ipsAutorizadas;
        
    }
    
    
        public int CantReportesExportados(int id, String fecha) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        int VariableLocal_Resultado = 1;
        Parametro ValidarParametro = new Parametro();
        try { 
            
            ValidarParametro.consultaG("SELECT COUNT(i_id_auditoria) AS CANTIDAD FROM au_reporteUsuario "
                                        + " WHERE i_id_usuario= " +id+ " AND fecha= '" + fecha + "'");
                                    
            if (ValidarParametro.rs.first()) {
                VariableLocal_Resultado = Integer.parseInt(ValidarParametro.rs.getString("CANTIDAD"));
                //ValidarParametro.cerrarConexiones();
            }
            else{
                VariableLocal_Resultado = 1;
            }
        } catch (Exception e) {
            VariableLocal_Resultado = 1;
            //ValidarParametro.cerrarConexiones();
        }finally{
            ValidarParametro.cerrarConexiones();
        }
        return VariableLocal_Resultado;
    }
          
          
    public String IngresarExpReport(int numreport, int idusuario, String Fechahoy) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        String result = "Error";
        Parametro ValidarParametro = new Parametro();
        String query = "INSERT INTO dm_reporteUsuario (i_num_reporte, i_id_usuario, fecha) VALUES ("+numreport+ ", " +idusuario+ ", '" + Fechahoy + "')";
        try {
            ValidarParametro.Insert("INSERT INTO dm_reporteUsuario (i_num_reporte, i_id_usuario, fecha) VALUES ("+numreport+ ", " +idusuario+ ", '" + Fechahoy + "')");
        } catch (SQLException e) {
            
            logger.error("OPA - " +FacadeUsuarios.class.getName(), e);
            //ValidarParametro.cerrarConexiones();
            result = "Error";
        } finally {
            ValidarParametro.cerrarConexiones();
        }
        return result;
    } 
    
    
    
    
       public void Actualizartablareportes(int idusuario, String Fechahoy) {
           PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Parametro update = new Parametro();

        try {
            
            update.actualiza("UPDATE dm_reporteUsuario SET i_id_usuario = "+idusuario+", fecha = '"+Fechahoy+"'  WHERE fecha = '"+Fechahoy+"' AND i_id_usuario = "+idusuario+"");
            //update.cerrarConexiones();
        } catch (SQLException ex) {
            
            logger.error("OPA - " +FacadeUsuarios.class.getName(), ex);
             //update.cerrarConexiones();
        } finally {
            update.cerrarConexiones();
        }
    }

    public List<List<String>> ListarLogin(String Txtlogin, String DateIni, String DateFin) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Parametro login = new Parametro();
        StringBuffer sqlquery = new StringBuffer();
        
        List<List<String>> listLogin = new ArrayList<List<String>>();

        for (int i = 0; i <= 5; i++) {
            listLogin.add(new ArrayList<String>());
        }
        
         try{
             
             sqlquery.append(" SELECT A.id, B.c_login, A.t_fecha, A.c_evento, "
                              + " CONCAT_WS(\"| \", A.id, A.c_ip, " 
                              + " A.c_evento, A.c_resultado) AS VALORES "
                              + " FROM fqs_auditoria A"
                              + " INNER JOIN fqs_usuario B ON A.i_idusuario = B.i_usuario");
             
             if (!"".equals(Txtlogin) || !"".equals(DateIni) || !"".equals(DateFin) ){
                 sqlquery.append(" WHERE ");
             }
             
             if (!"".equals(Txtlogin)){
                 sqlquery.append (" B.c_login LIKE '%" + Txtlogin + "%'");
             }
             
             
             if (!"".equals(DateIni) && !"".equals(DateFin)){
                 //sqlquery.append ("OR T_FECHA BETWEEN " + DateIni + " AND " + DateFin);
                if (!"".equals(Txtlogin)){
                     sqlquery.append (" AND A.t_fecha  BETWEEN  CAST('" + DateIni + "' AS DATETIME) AND CAST(REPLACE('" + DateFin + "','00:00:00','23:59:00') AS DATETIME)");
                }else{
                     sqlquery.append ("A.t_fecha  BETWEEN  CAST('" + DateIni + "' AS DATETIME) AND CAST(REPLACE('" + DateFin + "','00:00:00','23:59:00') AS DATETIME)");
                }
          
             }
             
             sqlquery.append(" ORDER BY A.id");
                         
             
            login.consultaG(sqlquery.toString());
            
            
            while(login.rs.next()){
                
                listLogin.get(0).add(String.valueOf(login.rs.getInt("id")));
                listLogin.get(1).add(login.rs.getString("c_login"));
                listLogin.get(2).add(login.rs.getString("t_fecha"));
                listLogin.get(3).add(login.rs.getString("c_evento"));
                listLogin.get(4).add(login.rs.getString("VALORES"));
                                                          
            }
            //login.cerrarConexiones();
         }catch(SQLException ex ) {
              
              logger.error("OPA - " +FacadeUsuarios.class.getName(), ex);
             //login.cerrarConexiones();
         }finally{
             login.cerrarConexiones();
         }
           
                 
         return listLogin;    
    }

    public List<List<String>> ListarAuParametros(String Txtlogin, String DateIni, String DateFin) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Parametro AuParam = new Parametro();
        StringBuffer sqlquery = new StringBuffer();
        
        List<List<String>> listAuParam = new ArrayList<List<String>>();

        for (int i = 0; i <= 5; i++) {
            listAuParam.add(new ArrayList<String>());
        }
        
         try{
             
             sqlquery.append(" SELECT a.id_auditoria,a.c_usuario_sistema_ultima_mod,a.FechaModificacion,a.c_tipo_modificacion," 
                           + " CONCAT_WS(\"|\", a.FechaIniOperacion,a.HoraIniOperacion,a.FechaFinOperacion,a.HoraFinOperacion, " 
                           + " a.MinAccionesObjOferta,a.MaxAccionesObjOferta,a.NombreRazonSocial,a.PrecioAceptaciones," 
			   + " CASE WHEN a.NumeroAceptacion = 0 THEN \"Inactivo Reiniciar Consecutivo\" ELSE \"Reiniciar Consecutivo\" END,"
                           + " a.TextoUno,a.TextoDos," 
 		           + " CASE WHEN a.ExistePreacuerdo = 1 THEN \"Activo Preacuerdo\" ELSE \"Inactivo Preacuerdo\" END," 
 			   + " a.CantReporte,a.Nanotecnico,a.ClaseAcciones,a.CantUsuariosOpe," 
 			   + " CASE WHEN a.TodoONada = 1 THEN \"Activo Todo o Nada\" ELSE \"Inactivo Todo o Nada\" END," 
			   + " b.c_nombredoc, a.NumeroDocumentoOferente,a.DVOferente,a.EFOferente,a.CuentaDecevalOferente,a.SCBOferente,"
			   + " CASE WHEN a.ActivarCargaMasiva = 1 THEN \"Activo Carga Masiva\" ELSE \"Inactivo Carga Masiva\" END ,"
                           + " a.HoraIniOperacionCarga,a.HoraFinOperacionCarga,a.Accionesnegociadas,a.TxtBoletinInformativo) AS VALORES "
                           + " FROM au_Parametrizacion a INNER JOIN dm_tipodocumento b ON b.i_tipodocumento=a.TipoDocumentoOferente");
             
             if (!"".equals(Txtlogin) || !"".equals(DateIni) || !"".equals(DateFin) ){
                 sqlquery.append(" WHERE ");
             }
             
             if (!"".equals(Txtlogin)){
                 sqlquery.append (" a.c_usuario_sistema_ultima_mod LIKE '%" + Txtlogin + "%'");
             }
             
             
             if (!"".equals(DateIni) && !"".equals(DateFin)){
                 //sqlquery.append ("OR T_FECHA BETWEEN " + DateIni + " AND " + DateFin);
                if (!"".equals(Txtlogin)){
                     sqlquery.append (" AND a.FechaModificacion  BETWEEN  CAST('" + DateIni + "' AS DATETIME) AND CAST(REPLACE('" + DateFin + "','00:00:00','23:59:00') AS DATETIME)");
                }else{
                     sqlquery.append (" a.FechaModificacion  BETWEEN  CAST('" + DateIni + "' AS DATETIME) AND CAST(REPLACE('" + DateFin + "','00:00:00','23:59:00') AS DATETIME)");
                }
          
             }
             
             sqlquery.append(" ORDER BY a.id_auditoria");
                         
             
            AuParam.consultaG(sqlquery.toString());
            
            while(AuParam.rs.next()){
                
                listAuParam.get(0).add(String.valueOf(AuParam.rs.getInt("id_auditoria")));
                listAuParam.get(1).add(AuParam.rs.getString("c_usuario_sistema_ultima_mod"));
                listAuParam.get(2).add(AuParam.rs.getString("FechaModificacion"));
                listAuParam.get(3).add(AuParam.rs.getString("c_tipo_modificacion"));
                listAuParam.get(4).add(AuParam.rs.getString("VALORES"));
                                                          
            }
            // AuParam.cerrarConexiones();
         }catch(SQLException ex ) {
              
              logger.error("OPA - " +FacadeUsuarios.class.getName(), ex);
             //AuParam.cerrarConexiones();
         }finally{
             AuParam.cerrarConexiones();
         }
           
                 
         return listAuParam;
    }

    public List<List<String>> ListaAuAcep(String Txtlogin, String DateIni, String DateFin) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Parametro AuAcep = new Parametro();
        StringBuffer sqlquery = new StringBuffer();
        
        List<List<String>> listAuAcep = new ArrayList<List<String>>();

        for (int i = 0; i <= 5; i++) {
            listAuAcep.add(new ArrayList<String>());
        }
        
         try{
             
             sqlquery.append(" SELECT a.id_auditoria, a.c_usuario_sistema_ultima_mod, a.FechaModificacion, a.au_tipo_accion ,"
                           + " CONCAT_WS(\"| \",a.EntidadDeNegociosID, a.ClaseAcciones,a.ConOfeVen,a.TextoUno,a.TextoDos,"
                           + " CASE WHEN a.ExistePreacuerdo = 1 THEN \"Acepto Preacuerdo\" WHEN a.ExistePreacuerdo = 2 THEN \"No Acepto Preacuerdo\" ELSE \"\" END, "
                           + " a.CodScb, a.NombreSCB,a.RepresentanteLegal,a.NombreRazonSocial,a.NumAcciones,"
                           + " CASE WHEN a.VenCon = 1 THEN \"Acepto Todo o Nada\" WHEN a.VenCon = 0 THEN \"No Acepto Todo Nada\" ELSE \"\" END, "
                           + " b.c_nombredoc,a.NumNitDoc,a.NumVer,a.EspFid,a.CtaInv,"
                           + " a.estado,a.PorcentajeComision,a.observacion,a.c_tipo_modificacion) AS VALORES "
                           + " FROM au_CrearAceptacion a inner join dm_tipodocumento b on b.i_tipodocumento=a.TipDocumento " );
             
             if (!"".equals(Txtlogin) || !"".equals(DateIni) || !"".equals(DateFin) ){
                 sqlquery.append(" WHERE ");
             }
             
             if (!"".equals(Txtlogin)){
                 sqlquery.append (" a.c_usuario_sistema_ultima_mod LIKE '%" + Txtlogin + "%'");
             }
             
             
             if (!"".equals(DateIni) && !"".equals(DateFin)){
                 //sqlquery.append ("OR T_FECHA BETWEEN " + DateIni + " AND " + DateFin);
                if (!"".equals(Txtlogin)){
                      sqlquery.append (" AND a.FechaModificacion  BETWEEN  CAST('" + DateIni + "' AS DATETIME) AND CAST(REPLACE('" + DateFin + "','00:00:00','23:59:00') AS DATETIME)");
                }else{
                     sqlquery.append ("a.FechaModificacion  BETWEEN  CAST('" + DateIni + "' AS DATETIME) AND CAST(REPLACE('" + DateFin + "','00:00:00','23:59:00') AS DATETIME)");
                }
          
             }
             
             sqlquery.append(" ORDER BY a.id_auditoria");
             
             
             
            AuAcep.consultaG(sqlquery.toString());
            
            while(AuAcep.rs.next()){
                
                listAuAcep.get(0).add(String.valueOf(AuAcep.rs.getInt("id_auditoria")));
                listAuAcep.get(1).add(AuAcep.rs.getString("c_usuario_sistema_ultima_mod"));
                listAuAcep.get(2).add(AuAcep.rs.getString("FechaModificacion"));
                listAuAcep.get(3).add(AuAcep.rs.getString("au_tipo_accion"));
                listAuAcep.get(4).add(AuAcep.rs.getString("VALORES"));
                                                          
            }
            //AuAcep.cerrarConexiones();

         }catch(SQLException ex ) {
              
              logger.error("OPA - " +FacadeUsuarios.class.getName(), ex);
             //AuAcep.cerrarConexiones();
         }finally{
             AuAcep.cerrarConexiones();
         }
     
         return listAuAcep;
    }

 


}

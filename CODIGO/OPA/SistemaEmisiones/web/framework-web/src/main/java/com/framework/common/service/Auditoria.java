/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.service;

import com.quasar.frameq.estructura.Ayuda;
import com.framework.common.domain.Usuario;
import com.framework.common.service.security.MyUserDetailsService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author jam
 */
@Configurable(preConstruction=true)
public class Auditoria {
  
  private static final Logger logger = Logger.getLogger(Auditoria.class.getName());  
  public Integer getId_user() {
    return id_user;
  }

  @Autowired
  protected MyUserDetailsService userDetailsService;
  
  
   
  
  
  
  
  public Auditoria() {
    
     this.id_user=0;
  this.evento="";
  this.Resultado="";
  this.ip="";
 ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest req = attr.getRequest();    
// AJUSTE IP REGISTRADA
    //this.ip=req.getRemoteAddr();
    String ipf=req.getHeader("X-Forwarded-For");
    if (ipf == null || "".equals(ipf) ){
            this.ip = req.getRemoteAddr();    
        }else{            
            String ips[]= ipf.split(",");
            this.ip= ips[0];
            logger.debug("OPA - REMOTEADDR_" + req.getRemoteAddr() + "x-forwarded-For_" + req.getHeader("X-Forwarded-For") + "ip" + ips[0]);             

        }    
    
//
  }


  public void setid()
  {
    this.id_user=userDetailsService.getUsuarioAutenticado().getId();
  }

  public void setId_user(Integer id_user) {
    

 //  userDetailsService.getUsuarioAutenticado().getId();

    this.id_user = id_user;
  }

  public String getEvento() {
    return evento;
  }

  public void setEvento(String evento) {
    this.evento = evento;
  }

  public String getResultado() {
    return Resultado;
  }

  public void setResultado(String Resultado) {
    this.Resultado = Resultado;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }
  
  
  
  Integer id_user;
  String evento;
  String Resultado;
  String ip;
   Usuario usuario;
  
  public void inserta(){
    String usuarioQuery;
    Statement stamquery;
    stamquery = null;
    Ayuda proceso = new Ayuda();
    PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
    try {
      stamquery = proceso.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    } catch (SQLException ex) {
      logger.error("OPA - " + Auditoria.class.getName(), ex);	
    }
    usuarioQuery = "insert into fqs_auditoria (t_fecha, i_idusuario, c_ip, c_evento, c_resultado) values(now()," + id_user + ",'" + ip + "','" + evento + "','" + Resultado + "')";
    try {
      stamquery.executeUpdate(usuarioQuery);
    } catch (SQLException ex) {
      logger.error("OPA - " + Auditoria.class.getName(), ex);
    } finally {
        proceso.cerrarConexiones();
    }
  }
  
  
  
  
  
}

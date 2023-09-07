/*
 * ParametrosDAO.java
 *
 * Created on 17 de noviembre de 2008, 12:11 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package com.quasar.frameq.seguridad;

import com.quasar.frameq.db.JDBCAdapter;
import java.sql.*;
import java.util.logging.Level;
// import java.util.logging.Logger;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ParametrosDAO {
    
  private static final Logger logger = Logger.getLogger(ParametrosDAO.class.getName());  
  public ParametrosDAO() {
    rsParametros = null;
    psParametros = null;
    lfecha = null;
    tabla = new JDBCAdapter();
    try {
      psParametros = tabla.getConnection().prepareStatement(sqlParametros);
    } catch (SQLException ex) {
      logger.error("error: " + ex);
    }
  }

  public String buscarParametro(int parametro) {
    String Parametros = "";
    PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
    try {
      psParametros.setInt(1, parametro);
      for (rsParametros = psParametros.executeQuery(); rsParametros.next();) {
        Parametros = new String(rsParametros.getString("c_valor"));
      }

    } catch (SQLException ex) {
      // Logger.getLogger(ParametrosDAO.class.getName()).log(Level.SEVERE, "Error al consultar parametro" , ex);       
      logger.error("OPA - " + ParametrosDAO.class.getName(),ex);	
      logger.error("error: " + ex);
    }
    return Parametros;
  }
  private JDBCAdapter tabla;
  private static String sqlParametros = "select i_parametro, i_tipodato, c_valor, c_descripcion, c_nombre from fqs_parametro where i_parametro = ?";
  private ResultSet rsParametros;
  private PreparedStatement psParametros;
  private Date lfecha;
}
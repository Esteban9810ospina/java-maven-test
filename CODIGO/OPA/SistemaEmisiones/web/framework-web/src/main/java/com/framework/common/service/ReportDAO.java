package com.framework.common.service;

import com.quasar.frameq.db.DataSourceUtil;
import com.quasar.frameq.db.DbUtil;
import com.framework.reportEngine.exception.ReportExecutionException;
import java.sql.*;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase DAO sencilla para extraccion de datos via JDBC con spring
 *
 * @author pedrorozo - http://www.smartjsp.com
 * @author Alejandro Riveros
 * @author Carlos Uribe [curibe@quasarbi.com]
 * @author Roger Padilla
 */
public class ReportDAO {

  protected final Logger logger = LoggerFactory.getLogger(getClass());
  private DataSource dataSource = DataSourceUtil.getInstance().obtainDataSource();
  private Connection conn = null;
  private PreparedStatement ps = null;
  private ResultSet rs = null;

  public ResultSet consultaBaseDatos(String query, Object... args) {
    try {
      conn = getConnection();
      ps = conn.prepareStatement(query);

      if (args != null) {
        int idx = 0;
        for (Object arg : args) {
          ps.setObject(++idx, arg);
        }
      } else {
        consultaBaseDatos(query);
      }

      rs = ps.executeQuery();

    } catch (SQLException ex) {
      throw new ReportExecutionException(ex.getMessage(), ex);
    }
    logger.debug("OPA - " + "PreparedStatement's query: {}", ps);
    return rs;
  }

  public ResultSet consultaBaseDatos(String query) {
    try {
      conn = getConnection();
      ps = conn.prepareStatement(query);
      rs = ps.executeQuery();
    } catch (SQLException ex) {
      throw new ReportExecutionException(ex.getMessage(), ex);
    }
    logger.debug("OPA - " + "PreparedStatement's query: {}", ps);
    return rs;
  }

  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public Connection getConnection() {
    try {
      return this.dataSource.getConnection();
    } catch (SQLException ex) {
      throw new ReportExecutionException(ex.getMessage(), ex);
    }
  }

  public void closeConnection() {
    DbUtil.closeRecurso(this);
  }

    @Override
    protected void finalize() throws Throwable {
        try {
            this.closeConnection();
        } finally {
            super.finalize();
        }
    }
}

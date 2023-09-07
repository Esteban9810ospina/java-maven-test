package com.quasar.frameq.db;

import java.util.ResourceBundle;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Roger Padilla C.
 */
public class DataSourceUtil {

  private Logger logger = LoggerFactory.getLogger(getClass());
  

  public DataSource obtainDataSource() {

    Context context = null;
    DataSource dataSource = null;

    ResourceBundle rb = ResourceBundle.getBundle("database");

    try {
      context = new InitialContext();
      dataSource = (DataSource) context.lookup(rb.getString("datasource.jndi.name"));
    } catch (NamingException exc) {
      logger.debug("OPA - " + exc.getExplanation(), exc);
    } finally {
      try {
        context.close();
      } catch (Exception exc) {
        logger.debug("OPA - " + exc.getMessage(), exc);
      }
    }

    return dataSource;
  }

  public static DataSourceUtil getInstance() {
    return SingletonHolder.INSTANCE;
  }

  private static class SingletonHolder {
    public static final DataSourceUtil INSTANCE = new DataSourceUtil();
  }
}
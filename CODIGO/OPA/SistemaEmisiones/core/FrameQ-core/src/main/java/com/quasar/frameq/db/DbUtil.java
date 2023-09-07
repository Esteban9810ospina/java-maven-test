package com.quasar.frameq.db;

import com.quasar.frameq.exception.FrameworkSistemaException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Esta clase permite centralizar, agilizar y hacer el cierre de recursos de BD menos propenso
 * a errores en el código del Core, básicamente, esta clase tiene como propósito cerrar todos
 * los recursos de base de datos automáticamente, evitando la necesidad de hacer explícito el
 * cierre individual de cada recurso de las clases y los de sus clases ancestras.
 *
 * @author Roger Padilla C.
 */
public class DbUtil {

  private static final Logger logger = LoggerFactory.getLogger(DbUtil.class);

  /**
   * Este método escanea (mediante el API de reflexión) todos los atributos de instancia
   * (tanto propios como de las clases ancestras del recurso en cuestión) que sean de
   * tipo ResultSet, Statement, PreparedStatement, Connection, JDBCAdapter o Persistente,
   * cerrándolos automáticamente.
   *
   * @param resource Referencia al objeto a cerrarle los recursos
   */
  public static void closeRecurso(Object resource) {

//    long tStart = System.currentTimeMillis();
    
    
    if (resource == null) {
    
      return;
    }

    if (resource instanceof ResultSet) {
      closeResultSet((ResultSet) resource);
    } else if (resource instanceof Statement) {
      closeStatement((Statement) resource);
    } else if (resource instanceof Connection) {
      closeConnection((Connection) resource);
    } else if (resource instanceof JDBCAdapter) {
      closeJdbcAdapter((JDBCAdapter) resource);
    } else {

      Class recursoClass = resource.getClass();
      
      List<Field> fields = new ArrayList<Field>();

      while (recursoClass != Object.class) {
        Field[] fieldsAux = recursoClass.getDeclaredFields();
        Collections.addAll(fields, fieldsAux);
        recursoClass = recursoClass.getSuperclass();
      }

      List<ResultSet> resultsetsChildren = new ArrayList<ResultSet>(3);
      List<Statement> statementsChildren = new ArrayList<Statement>(3);
      List<Connection> connectionsChildren = new ArrayList<Connection>(1);
      List<JDBCAdapter> jdbcAdaptersChildren = new ArrayList<JDBCAdapter>(1);
      List othersChildren = new ArrayList();

      for (Field field : fields) {

        field.setAccessible(true);

        try {

          Object it = field.get(resource);

          if (it == null || it == resource) {
            continue;
          }

          if (it instanceof ResultSet) {
            resultsetsChildren.add((ResultSet) it);
          } else if (it instanceof Statement) {
            statementsChildren.add((Statement) it);
          } else if (it instanceof Connection) {
            connectionsChildren.add((Connection) it);
          } else if (it instanceof JDBCAdapter) {
            jdbcAdaptersChildren.add((JDBCAdapter) it);
          } else if (it instanceof Persistente) {
            othersChildren.add(it);
          } else {
            Class clase = it.getClass();
            Package pack = clase.getPackage();
            if (pack != null && pack.getName().startsWith("com.bvc")) {
              othersChildren.add(it);
            }
          }

        } catch (IllegalArgumentException ex) {
          logger.error(ex.getMessage(), ex);
        } catch (IllegalAccessException ex) {
          logger.error(ex.getMessage(), ex);
        }
      }

      fields.clear();
      fields = null;

      closeResultSets(resultsetsChildren);
      closeStatements(statementsChildren);
      closeConnections(connectionsChildren);
      closeJdbcAdapters(jdbcAdaptersChildren);
      closeRecursos(othersChildren);

    }


  }

  public static void closeRecursos(List others) {
    for (Object obj : others) {
      closeRecurso(obj);
    }
  }

  public static void closeResultSet(ResultSet rs) {
     
    if (rs == null) {
      return;
    }
    try {
      rs.close();
    } catch (Exception exc) {
      logger.warn("OPA - " + exc.getMessage(), exc);
    }
  }

  public static void closeResultSets(List<ResultSet> rss) {
    for (ResultSet resultSet : rss) {
      closeResultSet(resultSet);
    }
  }

  public static void closeStatement(Statement st) {
    
    if (st == null) {
      return;
    }
    try {
      st.close();
    } catch (Exception exc) {
      logger.warn("OPA - " + exc.getMessage(), exc);
    }
  }

  public static void closeStatements(List<Statement> sts) {
    for (Statement statement : sts) {
      closeStatement(statement);
    }
  }

  public static void closeConnection(Connection conn) {
    
    if (conn == null) {
      return;
    }
    try {
      conn.close();
      //lore
      conn = null;
    } catch (Exception exc) {
      logger.warn("OPA - " + exc.getMessage(), exc);
    }
  }

  public static void closeConnections(List<Connection> conns) {
    for (Connection statement : conns) {
      closeConnection(statement);
    }
  }

  public static void closeJdbcAdapter(JDBCAdapter jdbcAdapter) {
    
    if (jdbcAdapter == null) {
      return;
    }
    try {
      jdbcAdapter.cerrarConexiones();
    } catch (Exception exc) {
      logger.warn("OPA - " + exc.getMessage(), exc);
    }
  }

  public static void closeJdbcAdapters(List<JDBCAdapter> jdbcAdapters) {
    for (JDBCAdapter jdbcAdapter : jdbcAdapters) {
      closeJdbcAdapter(jdbcAdapter);
    }
  }

  public static List<Map<String, Object>> extractData(ResultSet rs) {

    List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

    try {

      ResultSetMetaData metaData = rs.getMetaData();
      int columnCount = metaData.getColumnCount();
      List<String> columnsLabels = new ArrayList<String>(columnCount);

      for (int i = 1; i <= columnCount; i++) {
        columnsLabels.add(metaData.getColumnLabel(i));
      }

      rs.beforeFirst();

      Map<String, Object> dataRow;

      while (rs.next()) {
        dataRow = new LinkedHashMap<String, Object>(columnCount);
        for (String lbl : columnsLabels) {
          dataRow.put(lbl, rs.getObject(lbl));
        }
        data.add(dataRow);
      }

    } catch (SQLException ex) {
      throw new FrameworkSistemaException(ex.getMessage(), ex);
    } finally {
      closeResultSet(rs);
    }

    return data;
  }

  public static Map<String, String> extractDataToMap(ResultSet rs, String keyName, String valName) {

    Map<String, String> data = new HashMap<String, String>();

    try {
      while (rs.next()) {
        data.put(rs.getString(keyName), rs.getString(valName));
      }
    } catch (SQLException ex) {
      throw new FrameworkSistemaException(ex.getMessage(), ex);
    } finally {
      closeResultSet(rs);
    }

    return data;
  }

}

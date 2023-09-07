package com.quasar.frameq.db;

import com.quasar.frameq.exception.FrameworkSistemaException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Roger Padilla C.
 */
public class AppConfigParams {

  private static final long serialVersionUID = -723612895035624L;
  private final Logger logger = LoggerFactory.getLogger(getClass());
  /**
   * Namespaces. An object for grouping the parameters by each table in the BD.
   */
  private Generic generic;

  public static class Generic {

    private Boolean Captcha;
    private Integer autenticacionIntentosFallidosBloqueo;
    private Integer autenticacionTiempoDeslogueoInactividad;
    private Integer passwordHistorialRestriccion;
    private Integer passwordTiempoMinimoCambio;
    
    private Locale locale;
   
  
    public Integer getAutenticacionIntentosFallidosBloqueo() {
      return autenticacionIntentosFallidosBloqueo;
    }

    public Integer getAutenticacionTiempoDeslogueoInactividad() {
      return autenticacionTiempoDeslogueoInactividad;
    }
    
      public Boolean isCaptcha() {
      return Captcha;
    }

  
    public Boolean getCaptcha() {
      return Captcha;
    }

    public Integer getPasswordHistorialRestriccion() {
      return passwordHistorialRestriccion;
    }

    public Integer getPasswordTiempoMinimoCambio() {
      return passwordTiempoMinimoCambio;
    }

    public Locale getLocale() {
      return locale;
    }
 
  }

  
  private AppConfigParams() {
    init();
  }

  public AppConfigParams.Generic getGeneric() {
    return this.generic;
  }

  
  Connection conn = null;

  private void init() {
      
    PreparedStatement statement = null;
    StringBuilder sqlSentence = new StringBuilder(80);
    ResultSet rs = null;
    
    try {
      this.generic = new AppConfigParams.Generic();
  
      Map<String, Object> mapeador = new LinkedHashMap<String, Object>();
      mapeador.put("fqs_parametro", this.generic);
  
      DataSource dataSource = DataSourceUtil.getInstance().obtainDataSource();
      
      sqlSentence.append("SELECT c_nombre nombre, c_valor valor FROM fqs_parametro WHERE 1 = ? ");
      conn = dataSource.getConnection();
      //Statement stmt = conn.createStatement();      

      for (Map.Entry<String, Object> entry : mapeador.entrySet()) {

        String tblName = entry.getKey();
        Object namespace = entry.getValue();
        try{
          statement = conn.prepareStatement(sqlSentence.toString()); 
          statement.setInt(1, 1);
          
        }catch(SQLException e){
        }     

        rs = statement.executeQuery();
        //ResultSet rs = stmt.executeQuery("SELECT c_nombre nombre, c_valor valor FROM " + tblName);
        Map<String, String> data = DbUtil.extractDataToMap(rs, "nombre", "valor");

        Field[] fields = namespace.getClass().getDeclaredFields();

        for (Field field : fields) {
          String fieldName = field.getName();
          if ("this$0".equals(fieldName)) {
            continue;
          }
          String sourceVal = data.get(fieldName);
          if (sourceVal == null) {
            throw new FrameworkSistemaException("Parámetro " + fieldName + " no encontrado en la tabla " + tblName);
          }
          setFieldValue(namespace, field, sourceVal);
        }
      }
    } catch (Exception ex) {
      logger.error(ex.getMessage(), ex);
      throw new FrameworkSistemaException(ex.getMessage(), ex);
    } finally {
      DbUtil.closeConnection(conn);
    }
  }

  private void setFieldValue(Object namespace, Field field, String sourceVal) {
    field.setAccessible(true);
    Object value = obtainParamValueForField(field, sourceVal);
    try {
      field.set(namespace, value);
    } catch (IllegalArgumentException ex) {
      throw new FrameworkSistemaException(ex.getMessage(), ex);
    } catch (IllegalAccessException ex) {
      throw new FrameworkSistemaException(ex.getMessage(), ex);
    }
  }

  private Object obtainParamValueForField(Field field, String sourceVal) {
    Object value;
    Class classType = field.getType();
    if (classType == String.class) {
      value = sourceVal;
    } else if (classType == Locale.class) {
      String[] valsStr = sourceVal == null ? new String[]{"en", "US"} : sourceVal.split("_");
      value = new Locale(valsStr[0], valsStr[1]);
    } else if (classType.isArray()) {
      String[] valsStr = sourceVal == null ? null : sourceVal.split("\\s+");
      if (classType == Integer[].class) {
        Integer[] valsInt = new Integer[valsStr.length];
        for (int i = 0; i < valsStr.length; i++) {
          valsInt[i] = Integer.parseInt(valsStr[i]);
        }
        value = valsInt;
      } else {
        value = valsStr;
      }
    } else {
      try {
        Method valueOfMethod = classType.getMethod("valueOf", String.class);
        value = valueOfMethod.invoke(classType, sourceVal);
      } catch (InvocationTargetException ex) {
        throw new FrameworkSistemaException(ex.getMessage(), ex);
      } catch (IllegalAccessException ex) {
        throw new FrameworkSistemaException(ex.getMessage(), ex);
      } catch (NoSuchMethodException ex) {
        throw new FrameworkSistemaException(ex.getMessage(), ex);
      }
    }
    return value;
  }

  public static AppConfigParams getInstance() {
    return AppConfigParams.SingletonHolder.INSTANCE;
  }

  private static class SingletonHolder {

    public static final AppConfigParams INSTANCE = new AppConfigParams();
  }

  @Override
  public String toString() {
    return "AppConfigParams{" + "generic=" + generic + "'}'";
  }
}
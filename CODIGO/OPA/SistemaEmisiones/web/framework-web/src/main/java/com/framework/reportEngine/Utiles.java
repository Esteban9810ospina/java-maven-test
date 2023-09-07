/**
 * Motor de Consultas, reportes y CRUDs (mantenedores) para framework-c
 */
package com.framework.reportEngine;

import com.framework.common.ui.App;
import static com.framework.reportEngine.config.Constantes.*;


import java.math.BigDecimal;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.framework.reportEngine.config.Constantes;
import java.text.Format;

/**
 * Provee metodos geenricos de utilidad (estaticos) para procesamiento/corrección de datos
 *
 * @author pedrorozo
 *
 */
public class Utiles {

  static private final Logger logger = LoggerFactory.getLogger(Utiles.class);

  /**
   * Convierte fechas de java.util.Date a java.sql.Date (YYYY-MM-DD)
   *
   * @param entrada
   * @return
   */
  public static java.sql.Date corrigeFecha(java.util.Date entrada) {
    java.sql.Date salida = null;

    Format f = FORMATEADORES.get("DATE");
    salida = java.sql.Date.valueOf(f.format(entrada));
    

    return salida;
  }

  /**
   * Convierte otros tipos de dato a string (en estudio)
   *
   * @param entrada
   * @return
   */
  public static String corrigeDatos(Object entrada) {
    String salida = "";
    if (entrada != null) {
      Class clase = entrada.getClass();
      if (clase == String.class) {
        salida = (String) entrada;
      } else if (clase == java.sql.Time.class) {
        java.sql.Time t = (java.sql.Time) entrada;
        salida = t.toString();
      } else if (clase == java.sql.Timestamp.class) {
        // SimpleDateFormat f = new SimpleDateFormat(FORMATO_FECHAS);
        java.sql.Timestamp t = (java.sql.Timestamp) entrada;
        salida = t.toString();
      } else if (clase == Integer.class) {
        java.lang.Integer t = (java.lang.Integer) entrada;
        salida = t.toString();
      } else if (clase == Double.class) {
        java.lang.Double t = (java.lang.Double) entrada;
        salida = t.toString();
      } else if (clase == java.lang.Float.class) {
        java.lang.Float t = (java.lang.Float) entrada;
        salida = t.toString();
      } else {
        salida = "invalido: " + entrada.getClass().getName().toString();
      }
    }
    // logger.debug("OPA - " + "Corregido:"+salida);

    return salida;
  }

  /**
   * Convierte de entero a boolean la condicion de requerido
   *
   * @param requerido
   * @return
   */
  static boolean esRequerido(int requerido) {
    if (requerido == 1) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Crea un hashmap con el nombre de la columna y el numero de posicion en el resulset creado por que en jdbc (jdk 6) solo se provee acceso a tipos
   * de columna por posicion y en la configuracion del reporteador solo se sabe el nombre de la columna y no su posicion.
   *
   * @param rs
   * @return
   */
  static HashMap<String, Integer> getInfoColsResulset(ResultSetMetaData rsm) {
    HashMap<String, Integer> info = new HashMap<String, Integer>();
    try {
      for (int k = 1; k <= rsm.getColumnCount(); k++) {
        info.put(rsm.getColumnName(k), k);
      }
    } catch (SQLException e) {
      logger.debug("OPA - " + e.getMessage());
    }

    return info;
  }

  /**
   * Formatea un campo de la base de datos segun el formato provisto y alineacion si no se provee formato, usa los valores por defecto definidos en
   * las constantes
   *
   * @param valor
   * @param tipo
   * @param formato
   * @param alineacion
   * @return
   */
  static String formateaDatos(Object valor, String tipo, String formato,
          int tamano, Constantes.Alineacion alineacion, int precision) {

    tipo = tipo.toUpperCase();

    String retorno = "";
    Format formateador = null;
    if (tipo.equalsIgnoreCase("DOUBLE") || tipo.equalsIgnoreCase("FLOAT") || tipo.equalsIgnoreCase("DECIMAL")) {
        if (precision>=0 && precision<=9){
            formateador = FORMATEADORES.get(tipo+precision);
        } else {
            formateador = FORMATEADORES.get(tipo+9);
        }
    } else {
        formateador = FORMATEADORES.get(tipo);
    }

    App.setDefaultLocale();

    // logger.debug("OPA - " + "Campo inicial:"+valor+"-"+tipo);
    if (formateador != null) // si hay formato por
    // defecto para este
    // tipo de datos
    {
      // en esta seccion dependiendo del tipo de datos lo formatea
      if ("DATE".equals(tipo)) {
        if (valor == null) {
          retorno = null;
        } else if (valor instanceof String) {
          retorno = (String) valor;
        } else {
          Date fecha = (Date) valor;
          retorno = formateador.format(fecha);
        }
      } else if ("TIME".equals(tipo)) {
        //Time hora = Time.valueOf((String) valor);
        retorno = formateador.format(valor);
      } else if ("TIMESTAMP".equals(tipo)) {
        //Timestamp fechaCompleta = Timestamp.valueOf(valor);
         //Timestamp fechaCompleta = Timestamp.valueOf(valor);
         if (valor == null) {
          retorno = null;
        } else if (valor instanceof String) {
          retorno = (String) valor;
        } else {  
         retorno = formateador.format(valor);
        }  
        
      } else if ("INT".equals(tipo) || "INTEGER".equals(tipo)) {
        Integer numero;  //cambio Integer por long
        if (valor != null) {
          if (valor.getClass() == Integer.class) {  //valor.getClass() == Integer.class
            numero = (Integer) valor;  // numero = (Integer) valor;
          } else {
            String aux = valor.toString();
            if ("0.0".equals(aux) || aux.isEmpty()) {
              numero = 0; //numero = 0;
            } else {
              numero = new Integer((Utiles.retiraFormatoMiles(valor.toString()))); //numero = new Integer((Utiles.retiraFormatoMiles(valor.toString())));
            }
          }
        } else {
          numero = 0;
        }
        retorno = formateador.format(numero);
      } else if ("DOUBLE".equals(tipo)) {
        Double numero = 0.0;
        if (valor.getClass() == Double.class) {
          numero = (Double) valor;
        } else {
          String aux=valor.toString();  
          if (aux.isEmpty() ){
              numero=0.0;
          }  else {
              numero = new Double((Utiles.retiraFormatoMiles(valor.toString())));
          }
        }
        retorno = formateador.format(numero);
      } else if ("FLOAT".equals(tipo)) {
        Float numero = new Float(0);
        if (valor.getClass() == Float.class) {
          numero = (Float) valor;
        } else {
          String aux=valor.toString();  
          if (aux.isEmpty() ){
              numero=new Float(0);
          }  else {
                numero = new Float((Utiles.retiraFormatoMiles(valor.toString())));
            }
        }

        retorno = formateador.format(numero);
      } else if ("DECIMAL".equals(tipo)) {
        BigDecimal numero = new BigDecimal(0);
        if (valor.getClass() == BigDecimal.class) {
          numero = (BigDecimal) valor;
        } else {
          String aux=valor.toString();  
          if (aux.isEmpty() ){
              numero=new BigDecimal(0);
          }  else {
                numero = new BigDecimal((Utiles.retiraFormatoMiles(valor.toString())));
            }
        }

        retorno = formateador.format(numero);
      }

    } else if (valor != null) {
      retorno = valor.toString();
    }

    // Esta seccion puede ser util en el futuro para aplicar la
    // justificacion al String de forma manual
    // actualmente es implementada con la alineacion de columnas de vaadin

    /*
     * if (alineacion.equals(Alineacion.DERECHA)) { retorno =
     * retorno.format("%"+ tamano +"s", retorno); } else { retorno =
     * retorno.format("%-"+ tamano +"s", retorno); }
     * //PrintfFormat("Pre %s Post").sprintf("target"));
     */

    // logger.debug("OPA - " + "campo final:"+retorno);

    return retorno;
  }

 /**
   * Formatea un campo de la base de datos segun el formato provisto y alineacion si no se provee formato, usa los valores por defecto definidos en
   * las constantes
   *
   * @param valor
   * @param tipo
   * @param formato
   * @param alineacion
   * @return
   */
  static String formateaDatos2(Object valor, String tipo, String formato,
          int tamano, Constantes.Alineacion alineacion, int precision) {

    tipo = tipo.toUpperCase();

    String retorno = "";
    Format formateador = null;
    if (tipo.equalsIgnoreCase("DOUBLE") || tipo.equalsIgnoreCase("FLOAT") || tipo.equalsIgnoreCase("DECIMAL")) {
        formateador=Utiles.construirFormatoFinal(Utiles.construirFormato(precision));
    } else {
        if (tipo.equalsIgnoreCase("INTEGER") || tipo.equalsIgnoreCase("INT")) {
            formateador=Utiles.construirFormatoFinal(Utiles.construirFormato(0));
        } else {
           formateador = FORMATEADORES.get(tipo);
        }
    }

    App.setDefaultLocale();

    // logger.debug("OPA - " + "Campo inicial:"+valor+"-"+tipo);
    if (formateador != null) // si hay formato por
    // defecto para este
    // tipo de datos
    {
      // en esta seccion dependiendo del tipo de datos lo formatea
      if ("DATE".equals(tipo)) {
        if (valor == null) {
          retorno = null;
        } else if (valor instanceof String) {
          retorno = (String) valor;
        } else {
          Date fecha = (Date) valor;
          retorno = formateador.format(fecha);
        }
      } else if ("TIME".equals(tipo)) {
        //Time hora = Time.valueOf((String) valor);
        retorno = formateador.format(valor);
      } else if ("TIMESTAMP".equals(tipo)) {
        //Timestamp fechaCompleta = Timestamp.valueOf(valor);
         //Timestamp fechaCompleta = Timestamp.valueOf(valor);
         if (valor == null) {
          retorno = null;
        } else if (valor instanceof String) {
          retorno = (String) valor;
        } else {  
         retorno = formateador.format(valor);
        }  
        
      } else if ("INT".equals(tipo) || "INTEGER".equals(tipo)) {
        Integer numero;
        if (valor != null) {
          if (valor.getClass() == Integer.class) {
            numero = (Integer) valor;
          } else {
            String aux = valor.toString();
            if ("0.0".equals(aux) || aux.isEmpty()) {
              numero = 0;
            } else {
              numero = new Integer((valor.toString()));
            }
          }
        } else {
          numero = 0;
        }
        retorno = formateador.format(numero);
      } else if ("DOUBLE".equals(tipo)) {
        Double numero = 0.0;
        if (valor.getClass() == Double.class) {
          numero = (Double) valor;
        } else {
          String aux=valor.toString();  
          if (aux.isEmpty() ){
              numero=0.0;
          }  else {
              numero = new Double((valor.toString()));
          }
        }
        retorno = formateador.format(numero);
      } else if ("FLOAT".equals(tipo)) {
        Float numero = new Float(0);
        if (valor.getClass() == Float.class) {
          numero = (Float) valor;
        } else {
          String aux=valor.toString();  
          if (aux.isEmpty() ){
              numero=new Float(0);
          }  else {
                numero = new Float((valor.toString()));
            }
        }

        retorno = formateador.format(numero);
      } else if ("DECIMAL".equals(tipo)) {
        BigDecimal numero = new BigDecimal(0);
        if (valor.getClass() == BigDecimal.class) {
          numero = (BigDecimal) valor;
        } else {
          String aux=valor.toString();  
          if (aux.isEmpty() ){
              numero=new BigDecimal(0);
          }  else {
                numero = new BigDecimal((valor.toString()));
            }
        }

        retorno = formateador.format(numero);
      }

    } else if (valor != null) {
      retorno = valor.toString();
    }



    return retorno;
  }  
  
  /**
   * Valida si vector tiene nulos (obligatorios)
   *
   * @param nulos
   * @param siNulo
   * @return
   */
  static public boolean VerificaNulos(Vector nulos, int siNulo[]) {
    boolean ejecuta = false;
    int sq = 0;
    if (nulos.size() != siNulo.length) {
      return false;
    }
    for (sq = 0; sq < nulos.size(); sq++) {
      if ((String) nulos.elementAt(sq) == "" && siNulo[sq] == 1) {
        return false;
      }
      if (nulos.elementAt(sq) == null && siNulo[sq] == 1) {
        return false;
      }
      String varop = nulos.elementAt(sq).toString();
      if ((varop.equals(new String(""))) && (siNulo[sq] == 1)) {
        return false;
      }
    }
    if (sq == nulos.size()) {
      return true;
    }
    return false;
  }
    public static String construirFormato(int decimales) {
        String format="#,##0";
        for (int i=0;i<decimales;i++) {
            if (i==0) {
                format=format+".";
            }
            format=format+"0";
        }
        return format;
    }  

    public static DecimalFormat construirFormatoFinal(String formato) {
        DecimalFormat format=new DecimalFormat(formato);
        return format;
    }  
    
    
  public static String retiraFormatoMiles(String a) {
      return a.replace(",", "");
  }
}

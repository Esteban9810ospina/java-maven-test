package com.quasar.frameq.parametros;

import com.quasar.frameq.db.Persistente;
import java.sql.*;
import java.util.HashMap;
import java.util.Vector;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * <p>Title: SPIVI - Desarrollo</p> <p>Description: Administración de registros de la tabla Festivo> <p>Copyright: Copyright (c) 2002</p> <p>Company:
 * Quasar Software</p>
 *
 * @author Diana Marcela Quiroga
 * @version 1.0a071102
 */
public class Festivo extends Persistente {

  private static final Logger logger = Logger.getLogger(Festivo.class.getName());  
  private Date fecha;

  //** Constructores
  public Festivo() {
    this.setFecha(new Date(18990101));
  }

  public Festivo(String TFecha) {
    Date fech = Date.valueOf(TFecha);
    this.setFecha(fech);
  }

  public void setFecha(Date setFecha) {
    this.fecha = setFecha;
  }

  public final Date getFecha() {
    return this.fecha;
  }

  public Festivo(Date fecha) {
    setFecha(fecha);
  }

  @Override
  public Vector getContenido() {
    Vector v = new Vector();
    v.add(fecha);
    return v;
  }

  @Override
  public void inicializar() {
    setPersistente(this);
    String atributos[] = {"d_fecha"};

    setAtributos(atributos);
    setNombreTabla("fqs_festivo");
    setElementosLLave(1);
  }

  //** nuevo parametros Vector con atributos de Fecha
  @Override
  public Persistente nuevo(Vector v) {
    Festivo festivo;
    if (v.elementAt(0).getClass() == String.class) {
      festivo = new Festivo((String) v.elementAt(0));
    } else {
      festivo = new Festivo((Date) v.elementAt(0));
    }
    return festivo;
  }

  public final void fecha() {
  }

  @Override
  public void setContenido() {
    PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
      try {
      this.setFecha(rs.getDate("d_fecha"));
    } catch (SQLException se) {
      // Logger.getLogger(Festivo.class.getName()).log(Level.SEVERE, null, se);
      logger.error(Festivo.class.getName(), se);	
    }
  }

  @Override
  public void setContenido(Vector v) {
    PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
      try {
      logger.debug("OPA - " + "contenido: {}" + v);
      String auxS = (String) v.elementAt(0);
      if (auxS != null && !auxS.equals("0000-00-00")) {
        logger.debug("OPA - " + "auxS 1: {}" + auxS);
        this.setFecha(Date.valueOf(auxS));
      } else if (auxS.equals("0000-00-00")) {
        this.setFecha(Date.valueOf("1899-01-01"));
      } else {
        this.setFecha(new Date(java.util.Calendar.DATE));
      }
    } catch (NumberFormatException tnfe) {
      //Logger.getLogger(Festivo.class.getName()).log(Level.SEVERE, null, tnfe);
      logger.error(Festivo.class.getName(), tnfe);
    } catch (ClassCastException cce) {
      //Logger.getLogger(Festivo.class.getName()).log(Level.SEVERE, null, cce);
      logger.error(Persistente.class.getName(), cce);	
    }
    logger.debug("OPA - " + "fecha: {}" + this.getFecha());
  }

  public boolean referencia(Vector v) {
    return true;
  }
////---Validar Registros

  @Override
  public boolean validaRegistro(Vector registro) throws SQLException {
    String llave = ((String) registro.elementAt(0));
    consultaG("SELECT d_fecha FROM fqs_festivo WHERE d_fecha = ?", llave);

    if (getSize() > 0) {
      setMensajeRegistro("Error. Esta intentando duplicar un registro!");
      return false;
    }
    return true;
  }

  public HashMap validarRegControl(String linea, String nombre, int registros) {
    PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
      HashMap list = new HashMap(); // Tabla para guardar los codigos de error
    linea = linea.toUpperCase();
    try {
      if (linea.length() != 46) {
        list.put("longitud", new Integer(151));
      } else {
        nombre = nombre.toUpperCase();
        String fecha = linea.substring(32, 40);
        String nit = linea.substring(22, 32);

        String fechaSistema = "";
        Integer numRegistros = new Integer(linea.substring(40, 46));

        Parametro parametro = new Parametro();

        try {
          parametro.consultaP("WHERE i_parametro = ?", 3);
          if (parametro.first()) {
            fechaSistema = parametro.rs.getString("c_valor");
          }
        } catch (SQLException se) {
           logger.error("Verifique que el parametro fecha exista en la base de datos.", se);
        } finally {
          parametro.cerrarConexiones();
        }

        if (!(linea.substring(0, 6)).equals("000001")) {
          list.put("consecutivo", new Integer(101)); // Consecutivo no es 000001
        }
        if (linea.charAt(6) != 'C') {
          list.put("tipoRegistro", new Integer(102)); // Tipo de registro de cabecera no es 'C'
        }
        if (!((linea.substring(7, 10)).equals("SEN") || (linea.substring(7, 10)).equals("MEC")
                || (linea.substring(7, 10)).equals("DCV") || (linea.substring(7, 10)).equals("SPV"))) {
          list.put("sistema", new Integer(203)); // Sistema proveedor no valido
        }
        if (((linea.substring(10, 22)).equalsIgnoreCase(nombre)) == false) {
          list.put("narchivo", new Integer(120)); // Campo nombre de archivo no valido
        }
        if (!esNumerico(nit)) {
          list.put("nit", new Integer(130)); // El contenido de nit no es numerico
        }
        if (!esNumerico(fecha)) {
          list.put("numFecha", new Integer(205));// Campo de fecha no numerico
        }
        if (!validaFecha(fecha, fechaSistema)) {
          list.put("fecha", new Integer(20)); // fecha de transmision no valida
        }
        if (registros - 1 != numRegistros.intValue()) {
          list.put("numregistros", new Integer(40));// Longitud de registros no valida
        }
      }
    } catch (NumberFormatException nfe) {
     // Logger.getLogger(Festivo.class.getName()).log(Level.SEVERE, null, nfe);;
     logger.error(Festivo.class.getName(), nfe);	
    } catch (Exception e) {
      logger.error("El registro de control no es válido", e);
    }
    return list;
  }

  public HashMap validacionRegistro(String linea, int contador) {
    PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
      linea = linea.toUpperCase();
    Vector vector = new Vector();
    HashMap list = new HashMap();

    if (contador != 1 && linea.length() != 16) {
      list.put("longitud", new Integer(40));
    } else {
      int consecutivo = Integer.parseInt(linea.substring(0, 6));
      if (consecutivo != contador) {
        list.put("numSecuencia", new Integer(001));
      }
      String tipoRegistro = new String(linea.substring(6, 7));
      String accion = new String(linea.substring(7, 8));
      String fecha = new String(linea.substring(8, 16));
      if (!tipoRegistro.equals("D")) {
        vector.add(new String("11")); // Agregar el error
        list.put("tipoRegistro", new Integer(11));
      }
      if (!(accion.equals("A") || accion.equals("M") || accion.equals("B"))) {
        vector.add(new String("31"));
        list.put("accion", new Integer(31));
      }
      try {
        char accionSobreReg = linea.charAt(6);
      } catch (NumberFormatException nfe) {
        vector.add(new String("30")); // Campo accion no es un caracter
        list.put("accion", new Integer(30));
      } catch (ClassCastException cce) {
        vector.add(new String("30"));
        list.put("accion", new Integer(30));
      }
      if (!esNumerico(fecha)) {
        vector.add(new String("205"));
        list.put("fecha", new Integer(205));
      } else { // Si la fecha tiene formato numerico
        Parametro parametro = new Parametro();
        try {
          String fechaSistema = parametro.rs.getString("c_valor");
          if (!validaFecha(fecha, fechaSistema)) {
            list.put("fecha", new Integer(1502));
          }
        } catch (ClassCastException cce) {
          list.put("fecha", new Integer(1500));
        } catch (IllegalArgumentException iae) {
          list.put("fecha", new Integer(1500));
        } catch (SQLException se) {
          //Logger.getLogger(Festivo.class.getName()).log(Level.SEVERE, null, se);
          logger.error(Festivo.class.getName(), se);	
        } finally {
          parametro.cerrarConexiones();
        }
      }
    }
    return list;
  }

  @Override
  public String addSeparator(String fecha) {
    String conSeparador = "";
    conSeparador = fecha.substring(0, 4);
    conSeparador += "-";
    conSeparador += fecha.substring(4, 6);
    conSeparador += "-";
    conSeparador += fecha.substring(6, 8);
    return conSeparador;
  }

  public void cargaFestivo(String registro) {
    PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
      Vector vector = new Vector();
    String date = registro.substring(8, 16);
    date = addSeparator(date);
    //this.consultaP("where d_fecha = '"+fecha+"'");
    registro = registro.toUpperCase();
    char accion = registro.charAt(7);
    vector.add(date);
    try {
      this.consultaP("WHERE d_fecha = ?", date);
      if (!this.rs.last()) {
        this.setContenido(vector);
        switch (accion) {
          case 'A':
          case 'M':
            this.insertar();
            vector.removeAllElements();
            break;
          case 'B':
            this.eliminar();
            vector.removeAllElements();
        }
      }
    } catch (SQLException se) {
     // Logger.getLogger(Festivo.class.getName()).log(Level.SEVERE, null, se);
     logger.error(Festivo.class.getName(), se);	
    }finally{
        
        this.cerrarConexiones();
    }
  }

  public void cerrarConexion() {
    super.cerrarConexiones();
  }
}
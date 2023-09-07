package com.quasar.frameq.db;

import java.text.DateFormat;
import java.util.Date;

public class Fecha {

  private java.util.Calendar calendario;
  private int formato = 0;
  public int FORMATO_DDMMYYYY = 0;
  public int FORMATO_YYYYMMDD = 1;
  public int FORMATO_MMDDYYYY = 2;
  public int FORMATO_YYYYDDMM = 3;
  public int FORMATO_DDMM = 4;
  private String separador = "/";
  private String fech;
  private Date fechaU;

  /**
   * Fecha constructor comment.
   */
  public Fecha() {
    calendario = new java.util.GregorianCalendar().getInstance();
    setFormato(FORMATO_DDMMYYYY);
  }

  public Fecha(String fecha, int formato, String separador) {
    calendario = new java.util.GregorianCalendar().getInstance();
    setFormato(formato);
    setSeparador(separador);
    int p1 = fecha.indexOf(separador);
    int p2 = fecha.indexOf(separador, p1 + 1);
    switch (getFormato()) {
      case 0:
        setDia(new Integer(fecha.substring(0, p1)).intValue());
        setMes(new Integer(fecha.substring(p1 + 1, p2)).intValue());
        setAno(new Integer(fecha.substring(p2 + 1)).intValue());
        break;
      case 1:
        setAno(new Integer(fecha.substring(0, p1)).intValue());
        setMes(new Integer(fecha.substring(p1 + 1, p2)).intValue());
        setDia(new Integer(fecha.substring(p2 + 1)).intValue());
        break;
      case 2:
        setMes(new Integer(fecha.substring(0, p1)).intValue());
        setDia(new Integer(fecha.substring(p1 + 1, p2)).intValue());
        setAno(new Integer(fecha.substring(p2 + 1)).intValue());
        break;
      case 4:
        setDia(new Integer(fecha.substring(0, p1)).intValue());
        setMes(new Integer(fecha.substring(p1 + 1)).intValue());
        break;
    }
  }

  /**
   * This method was created in VisualAge.
   *
   * @param newValue java.util.Calendar
   */
  public Fecha(java.util.Calendar newValue) {
    this.calendario = newValue;
  }

  public Fecha(String fechaHora) {
    Date myfecha = new Date();

    String fechat = DateFormat.getDateInstance().format(myfecha);
    String dia = "";
    String mes = "";
    String agno = "";
    if (fechat.length() < 10) {
      for (int i = 0; i < fechat.length(); i++) {
        if (fechat.charAt(i) == '/' || fechat.charAt(i) == '-') {
          dia = fechat.substring(0, 1);
          mes = fechat.substring(i + 1, i + 3);
          break;
        }
      }
      if (dia.length() == 1) {
        dia = "0" + dia;
      }
      if (mes.length() == 1) {
        mes = "0" + mes;
      }
      agno = fechat.substring(fechat.length() - 4, fechat.length());
      fechat = dia + "/" + mes + "/" + agno;
    }
    String fechaS = DateFormat.getTimeInstance().format(myfecha);
    fechaS = fechaS.substring(0, fechaS.length() - 2);
    String agno1 = fechat.substring(6, 10);
    String mes1 = fechat.substring(3, 5);
    String dia1 = fechat.substring(0, 2);
    fechat = agno1 + "-" + mes1 + "-" + dia1;
    fech = fechat + " " + fechaS.trim();
  }

  public String getFechaHora() {
    return this.fech;
  }

  public Fecha(Object fecha) {
    String fech = fecha.toString();
    int agno = Integer.parseInt(fech.substring(0, 4));
    int mes = Integer.parseInt(fech.substring(5, 7));
    int dia = Integer.parseInt(fech.substring(8, 10));
    int hora = Integer.parseInt(fech.substring(11, 13));
    int min = Integer.parseInt(fech.substring(14, 16));
    int sec = Integer.parseInt(fech.substring(17, 19));
    calendario = new java.util.GregorianCalendar(agno, mes, dia, hora, min, sec);
  }

  /**
   * This method was created in VisualAge.
   *
   * @return int
   */
  public int getAno() {
    return calendario.get(calendario.YEAR);
  }

  /**
   * This method was created in VisualAge.
   *
   * @return int
   */
  public int getDia() {
    return calendario.get(calendario.DAY_OF_MONTH);
  }

  /**
   * This method was created in VisualAge.
   *
   * @return int
   */
  public int getFormato() {
    return formato;
  }

  /**
   * This method was created in VisualAge.
   *
   * @return int
   */
  public int getHora() {
    return calendario.get(calendario.HOUR_OF_DAY);
  }

  /**
   * This method was created in VisualAge.
   *
   * @return int
   */
  public int getMes() {
    return calendario.get(calendario.MONTH) + 1;
  }

  /**
   * This method was created in VisualAge.
   *
   * @return int
   */
  public int getMinuto() {
    return calendario.get(calendario.MINUTE);
  }

  /**
   * This method was created in VisualAge.
   *
   * @return int
   */
  public int getSegundo() {
    return calendario.get(calendario.SECOND);
  }

  /**
   * This method was created in VisualAge.
   *
   * @return java.lang.String
   */
  public String getSeparador() {
    return separador;
  }

  /**
   * This method was created in VisualAge.
   *
   * @param args java.lang.String[]
   */
  public static void main(String args[]) {
    Fecha fecha = new Fecha();
    if (args[0] != null) {
      fecha = new Fecha(args[0], fecha.FORMATO_DDMMYYYY, "/");
    }
  }

  /**
   * This method was created in VisualAge.
   *
   * @param newValue int
   */
  public void setAno(int newValue) {
    calendario.set(calendario.YEAR, newValue);
  }

  /**
   * This method was created in VisualAge.
   *
   * @param newValue int
   */
  public void setDia(int newValue) {
    calendario.set(calendario.DAY_OF_MONTH, newValue);
  }

  /**
   * This method was created in VisualAge.
   *
   * @param newValue int
   */
  public void setFormato() {
    String newValue = (String) (System.getProperties()).get("fecha.formato");
    if (newValue.equals("DDMMYYYY")) {
      this.formato = 0;
    } else if (newValue.equals("YYYYMMDD")) {
      this.formato = 1;
    } else if (newValue.equals("MMDDYYYY")) {
      this.formato = 2;
    } else if (newValue.equals("YYYYMMDD")) {
      this.formato = 3;
    } else {
      this.formato = 0;
    }
  }

  /**
   * This method was created in VisualAge.
   *
   * @param newValue int
   */
  public void setFormato(int newValue) {
    this.formato = newValue;
  }

  /**
   * This method was created in VisualAge.
   *
   * @param newValue int
   */
  public void setFormato(String newValue) {
    if (newValue.equals("DDMMYYYY")) {
      this.formato = 0;
    } else if (newValue.equals("YYYYMMDD")) {
      this.formato = 1;
    } else if (newValue.equals("MMDDYYYY")) {
      this.formato = 2;
    } else if (newValue.equals("YYYYMMDD")) {
      this.formato = 3;
    } else {
      this.formato = 0;
    }
  }

  /**
   * This method was created in VisualAge.
   *
   * @param newValue int
   */
  public void setHora(int newValue) {
    calendario.set(calendario.HOUR_OF_DAY, newValue);
  }

  /**
   * This method was created in VisualAge.
   *
   * @param newValue int
   */
  public void setMes(int newValue) {
    calendario.set(calendario.MONTH, newValue - 1);
  }

  /**
   * This method was created in VisualAge.
   *
   * @param newValue int
   */
  public void setMinuto(int newValue) {
    calendario.set(calendario.MINUTE, newValue);
  }

  /**
   * This method was created in VisualAge.
   *
   * @param newValue int
   */
  public void setSegundo(int newValue) {
    calendario.set(calendario.SECOND, newValue);
  }

  /**
   * This method was created in VisualAge.
   *
   * @param newValue java.lang.String
   */
  public void setSeparador(String newValue) {
    this.separador = newValue;
  }

  /**
   * This method was created in VisualAge.
   *
   * @return java.lang.String
   */
  public String toString() {
    String resp = "";
    String dia = "" + getDia();
    if (dia.length() == 1) {
      dia = "0" + dia;
    }
    String mes = "" + getMes();
    if (mes.length() == 1) {
      mes = "0" + mes;
    }
    switch (getFormato()) {
      case 0:
        resp = dia + getSeparador() + mes + getSeparador() + getAno();
        break;
      case 1:
        resp = getAno() + getSeparador() + mes + getSeparador() + dia;
        break;
      case 2:
        resp = mes + getSeparador() + dia + getSeparador() + getAno();
        break;
    }
    return resp;
  }

  /**
   * This method was created in VisualAge.
   *
   * @return java.lang.String
   */
  public String toString(int formato, String separador) {
    setFormato(formato);
    setSeparador(separador);
    String resp = "";
    String dia = "" + getDia();
    if (dia.length() == 1) {
      dia = "0" + dia;
    }
    String mes = "" + getMes();
    if (mes.length() == 1) {
      mes = "0" + mes;
    }
    switch (getFormato()) {
      case 0:
        resp = dia + getSeparador() + mes + getSeparador() + getAno();
        break;
      case 1:
        resp = getAno() + getSeparador() + mes + getSeparador() + dia;
        break;
      case 2:
        resp = mes + getSeparador() + dia + getSeparador() + getAno();
        break;
      case 4:
        resp = dia + getSeparador() + mes + getSeparador();
        break;
    }
    return resp;
  }

  /**
   * This method was created in VisualAge.
   *
   * @return java.lang.String
   */
  public String toStringLarge(int formato, String separador) {
    setFormato(formato);
    setSeparador(separador);
    String resp = "";
    String dia = "" + getDia();
    if (dia.length() == 1) {
      dia = "0" + dia;
    }
    String meses[] = {"", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    String mes = meses[getMes()];
    switch (getFormato()) {
      case 0:
        resp = dia + getSeparador() + mes + getSeparador() + getAno();
        break;
      case 1:
        resp = getAno() + getSeparador() + mes + getSeparador() + dia;
        break;
      case 2:
        resp = mes + getSeparador() + dia + getSeparador() + getAno();
        break;
      case 4:
        resp = dia + getSeparador() + mes + getSeparador();
        break;
    }
    return resp;
  }
}

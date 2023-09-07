package com.quasar.frameq.db;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Registro
{

  public Registro() {
  }
  
  public boolean validaFecha(String fecha,String fechaSistema) {

    boolean respuesta = true;
    int agno = Integer.parseInt(fecha.substring(0,4));
    int mes = Integer.parseInt(fecha.substring(4,6));
    int dia = Integer.parseInt(fecha.substring(6,8));

    int agno1 = Integer.parseInt(fechaSistema.substring(0,4));
    if (agno < agno1){
      respuesta = false;
    }

    if (mes == 4 || mes == 6 || mes == 9 || mes == 11)
      if (dia > 30)
        respuesta = false;
    if (!esBisiesto(agno)) {
      if (mes == 2) {
        if (dia >28) {
          respuesta = false;
        }
      }
    }

    int mes1 = Integer.parseInt(fechaSistema.substring(4,6));

    if ( mes > 12 || mes < 1 || (mes < mes1) ){
      respuesta = false;
    }

    if (dia > 31 || dia < 1){
      respuesta = false;
    }
    return respuesta;
  }
  
  public boolean esBisiesto(int agno) {
    if (agno%4 == 0)
      return true;
    else
      return false;
  }

 public boolean esFloat(String numero) {
    boolean result = true;
    try {
      float valor;
      valor = Float.parseFloat(numero);
      result = true;
    }
    catch (NumberFormatException nfe) {
      Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, nfe);
      result = false;
    }
    catch (ClassCastException cce) {
      Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, cce);
    }
    return result;
  }
 
  public boolean esDouble(String numero) {
    boolean result = true;
    try {
      double valor;
      valor = Double.parseDouble(numero);
      result = true;
    }
    catch (NumberFormatException nfe) {
      Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, nfe);
      result = false;
    }
    catch (ClassCastException cce) {
      Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, cce);
    }
    return result;
  }

}
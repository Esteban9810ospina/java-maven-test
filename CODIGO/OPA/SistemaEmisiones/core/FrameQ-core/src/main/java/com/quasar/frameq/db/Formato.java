package com.quasar.frameq.db;

import java.text.DecimalFormat;

public class Formato
{
/* Constructor del objeto
------------------------------*/
   public Formato()///Cambio Paola
   {
   }
   public String AddFormat(Object forma) {
          String respuesta = "";
	  if (forma.getClass() == String.class)
	      respuesta = forma.toString();
	  else if (forma.getClass() == java.sql.Date.class)
	      respuesta = forma.toString();
	  else if (forma.getClass() == java.math.BigDecimal.class){
	      DecimalFormat formato = new DecimalFormat();
	      formato.applyPattern("#,##0.#########");
	      respuesta = formato.format(forma);
	  }
	  else if (forma.getClass() == java.lang.Float.class){
	      DecimalFormat formato = new DecimalFormat();
	      formato.applyPattern("#,##0.#########");
	      respuesta = formato.format(forma);
	  }
	  else if (forma.getClass() == java.lang.Double.class){
	      DecimalFormat formato = new DecimalFormat();
	      formato.applyPattern("#,##0.#########");
	      respuesta = formato.format(forma);
	  }
	  else if (forma.getClass() == java.lang.Integer.class){
	      DecimalFormat formato = new DecimalFormat();
	      formato.applyPattern("#,##0.#########");
	      respuesta = formato.format(forma);
	  }
       return respuesta;
   }

}
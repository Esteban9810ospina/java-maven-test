package com.quasar.frameq.util;



import java.io.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.*;

public class Auditoria {

 public Auditoria(HttpServletRequest request, String CodUsuario, String Usuario, String Valor, String Descripcion, String Tipo) throws IOException {


   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   String today=formatter.format(new java.util.Date());

  

 }

 public Auditoria(HttpServletRequest request, String CodUsuario, String Usuario, String Valor, String Descripcion, String Tipo,String Administrador) throws IOException {

  

  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  String today=formatter.format(new java.util.Date());

 

}


}

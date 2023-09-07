/*
 * ColombiaCapital.java
 *
 * Created on 23 de septiembre de 2008, 11:34
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.quasar.frameq.seguridad;

import com.quasar.frameq.parametros.Parametro;
import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author QUASAR
 */
public class LogAuditoria {
    private HttpSession Session_Usuario= null;
    /** Creates a new instance of ColombiaCapital */
    public LogAuditoria() {
    }

    public Vector[] getAllUsuariosCombo(String seleccion) throws SQLException{
        Parametro conexion=new Parametro();
        Vector Consulta[]=null;
        String sqlconsulta="SELECT c_login, c_login FROM ad_usuario";
        try{
            conexion.consultaG(sqlconsulta);
                Consulta = new Vector[2];

                for(int i=0; i<Consulta.length; i++){
                    Consulta[i]= new Vector();
                }

            if(seleccion.compareTo("")==0){
                Consulta[0].add("");
                Consulta[1].add("");

                while(conexion.rs.next()){
                    for(int i=0; i<Consulta.length; i++){
                        Consulta[i].add(conexion.rs.getString(i+1));
                    }
               }
            }
            else{
                sqlconsulta="SELECT c_login, c_login FROM ad_usuario where c_login='"+seleccion+"'";
                conexion.consultaG(sqlconsulta);
                while(conexion.rs.next()){
                    for(int i=0; i<Consulta.length; i++){
                        Consulta[i].add(conexion.rs.getString(i+1));
                    }
               }
                Consulta[0].add("");
                Consulta[1].add("");

                sqlconsulta="SELECT c_login, c_login FROM ad_usuario where c_login<>'"+seleccion+"'";
                conexion.consultaG(sqlconsulta);
                while(conexion.rs.next()){
                    for(int i=0; i<Consulta.length; i++){
                        Consulta[i].add(conexion.rs.getString(i+1));
                    }
               }
            }

                conexion.rs.close();
        }
        catch(Exception e){
            Logger.getLogger(LogAuditoria.class.getName()).log(Level.SEVERE, null, e);            
            Consulta=null;
            conexion.rs.close();
        }          
        return Consulta;

    }

    public Vector[] getAllTipoAccesoCombo(String seleccion) throws SQLException{
        Parametro conexion=new Parametro();
        Vector Consulta[]=null;
        String sqlconsulta="SELECT i_tipo_acceso, c_tipo_acceso FROM ad_log_tipo_acceso";
        try{
            conexion.consultaG(sqlconsulta);
                Consulta = new Vector[2];

                for(int i=0; i<Consulta.length; i++){
                    Consulta[i]= new Vector();
                }

            if(seleccion.compareTo("")==0){
                Consulta[0].add("");
                Consulta[1].add("");

                while(conexion.rs.next()){
                    for(int i=0; i<Consulta.length; i++){
                        Consulta[i].add(conexion.rs.getString(i+1));
                    }
               }
            }
            else{
                sqlconsulta="SELECT i_tipo_acceso, c_tipo_acceso "
                        + "FROM ad_log_tipo_acceso where i_tipo_acceso='"+seleccion+"'";
                conexion.consultaG(sqlconsulta);
                while(conexion.rs.next()){
                    for(int i=0; i<Consulta.length; i++){
                        Consulta[i].add(conexion.rs.getString(i+1));
                    }
               }
                Consulta[0].add("");
                Consulta[1].add("");

                sqlconsulta="SELECT i_tipo_acceso, c_tipo_acceso "
                        + "FROM ad_log_tipo_acceso where i_tipo_acceso<>'"+seleccion+"'";
                conexion.consultaG(sqlconsulta);
                while(conexion.rs.next()){
                    for(int i=0; i<Consulta.length; i++){
                        Consulta[i].add(conexion.rs.getString(i+1));
                    }
               }
            }

                conexion.rs.close();
        }
        catch(Exception e){
            Logger.getLogger(LogAuditoria.class.getName()).log(Level.SEVERE, null, e);
            Consulta=null;
            conexion.rs.close();
        }
            return Consulta;
    }

    public Vector[] getAllAccionCombo(String seleccion) throws SQLException{
        Parametro conexion=new Parametro();
        Vector Consulta[]=null;
        String sqlconsulta="SELECT i_accion, c_accion, c_sql FROM ad_log_accion";
        try{
            conexion.consultaG(sqlconsulta);
                Consulta = new Vector[2];

                for(int i=0; i<Consulta.length; i++){
                    Consulta[i]= new Vector();
                }

            if(seleccion.compareTo("")==0){
                Consulta[0].add("");
                Consulta[1].add("");

                while(conexion.rs.next()){
                    for(int i=0; i<Consulta.length; i++){
                        Consulta[i].add(conexion.rs.getString(i+1));
                    }
               }
            }
            else{
                sqlconsulta="SELECT i_accion, c_accion, c_sql FROM ad_log_accion where i_accion='"+seleccion+"'";
                conexion.consultaG(sqlconsulta);
                while(conexion.rs.next()){
                    for(int i=0; i<Consulta.length; i++){
                        Consulta[i].add(conexion.rs.getString(i+1));
                    }
               }
                Consulta[0].add("");
                Consulta[1].add("");

                sqlconsulta="SELECT i_accion, c_accion, c_sql FROM ad_log_accion where i_accion<>'"+seleccion+"'";
                conexion.consultaG(sqlconsulta);
                while(conexion.rs.next()){
                    for(int i=0; i<Consulta.length; i++){
                        Consulta[i].add(conexion.rs.getString(i+1));
                    }
               }
            }

                conexion.rs.close();
        }
        catch(Exception e){
            Logger.getLogger(LogAuditoria.class.getName()).log(Level.SEVERE, null, e);
            Consulta=null;
            conexion.rs.close();
        }

            return Consulta;
    }

    /* public String getMaxRegistros() throws SQLException{
        Parametro conexion=new Parametro();
        String max="";
        String sqlconsulta="select c_valor from fqs_parametro where i_parametro=3000";
        try{
            conexion.consultaG(sqlconsulta);

                while(conexion.rs.next()){
                    max=conexion.rs.getString("c_valor");
               }
                conexion.rs.close();
        }
        catch(Exception e){
            Logger.getLogger(LogAuditoria.class.getName()).log(Level.SEVERE, null, e);            
            conexion.rs.close();
        }

            return max;
    }*/


     /*CONSULTA PARA BOOKBUILDING*/

     public Vector[] getConsulta(HttpServletRequest request) throws SQLException{
        Parametro conexion=new Parametro();
        Vector Consulta[]=null;
        String sqlconsulta="";
        try{

            sqlconsulta=" select usr.c_login as Usuario,usr.e_identificacion as Identificación,CONCAT(usr.c_nombre,' ',usr.c_apellidos) as Nombres,log.c_canal as Canal,log.dt_horaingreso as FechaHora,log.c_equipo as Equipo,acc.c_accion as AccionEjecutada,tipoacceso.c_tipo_acceso as TipoAcceso,log.c_descripcion as Descripción,log.t_sql as Consulta from ad_logauditoria as log  ";
            sqlconsulta=sqlconsulta+"left outer join fqs_usuario as usr on log.c_usuario=usr.c_login  left outer join ad_log_accion as acc on acc.i_accion=log.i_tipoafectacion left outer join ad_log_tipo_acceso as tipoacceso on tipoacceso.i_tipo_acceso=log.i_tipousuario ";
            int bandera=0;

            if (request.getParameter("d_fechai") != null && request.getParameter("d_fechai").length() != 0 && request.getParameter("d_fechaf") != null && request.getParameter("d_fechaf").length() != 0){
                if(bandera==0){
                    sqlconsulta=sqlconsulta+" where log.dt_horaingreso between '"+request.getParameter("d_fechai")+" 00-00-00' and '"+request.getParameter("d_fechaf")+" 23-59-59'";
                    bandera=1;
                }else{
                    sqlconsulta=sqlconsulta+" and log.dt_horaingreso between '"+request.getParameter("d_fechai")+" 00-00-00' and '"+request.getParameter("d_fechaf")+" 23-59-59'";
                }
            }
            if (request.getParameter("usuario") != null && request.getParameter("usuario").compareTo("")!=0){
                if(bandera==0){
                    sqlconsulta=sqlconsulta+" where usr.e_identificacion like '%"+request.getParameter("usuario")+"%'";
                    bandera=1;
                }else{
                    sqlconsulta=sqlconsulta+" and usr.e_identificacion like '%"+request.getParameter("usuario")+"%'";
                }
            }
            if (request.getParameter("equipo") != null && request.getParameter("equipo").compareTo("")!=0){
                if(bandera==0){
                    sqlconsulta=sqlconsulta+" where log.c_equipo like '%"+request.getParameter("equipo")+"%'";
                    bandera=1;
                }else{
                    sqlconsulta=sqlconsulta+" and log.c_equipo like '%"+request.getParameter("equipo")+"%'";
                }
           }

            if (request.getParameter("seleccionaccion") != null && request.getParameter("seleccionaccion").compareTo("")!=0 && request.getParameter("seleccionaccion").compareTo("0")!=0){
                if(bandera==0){
                    sqlconsulta=sqlconsulta+" where log.i_tipoafectacion="+request.getParameter("seleccionaccion")+"";
                    bandera=1;
                }else{
                    sqlconsulta=sqlconsulta+" and log.i_tipoafectacion="+request.getParameter("seleccionaccion")+"";
                }
            }
            if (request.getParameter("selecciontipo") != null && request.getParameter("selecciontipo").compareTo("")!=0 && request.getParameter("selecciontipo").compareTo("0")!=0){
                if(bandera==0){
                    sqlconsulta=sqlconsulta+" where log.i_tipousuario="+request.getParameter("selecciontipo")+"";
                    bandera=1;
                }else{
                    sqlconsulta=sqlconsulta+" and log.i_tipousuario="+request.getParameter("selecciontipo")+"";
                }
            }

            if (request.getParameter("descripcion") != null && request.getParameter("descripcion").compareTo("")!=0){
                if(bandera==0){
                    sqlconsulta=sqlconsulta+" where log.c_descripcion like '%"+request.getParameter("descripcion")+"%'";
                    bandera=1;
                }else{
                    sqlconsulta=sqlconsulta+" and log.c_descripcion like '%"+request.getParameter("descripcion")+"%'";
                }
            }
             if (request.getParameter("orden") != null && request.getParameter("orden").compareTo("")!=0){
                String ordenamiento="";
                ordenamiento=request.getParameter("orden").toString();
                if(ordenamiento.length()>8){
                    ordenamiento = ordenamiento.replaceAll("desc","desc,");
                    ordenamiento = ordenamiento.replaceAll("asc","asc,");
                    ordenamiento=ordenamiento.substring(0,ordenamiento.length()-1);
                }
                sqlconsulta=sqlconsulta+" order by "+ordenamiento+"";
            }
                conexion.consultaG(sqlconsulta);

                Consulta = new Vector[10];
                for(int i=0; i<Consulta.length; i++){
                    Consulta[i]= new Vector();
                }
                while(conexion.rs.next()){
                    for(int i=0; i<Consulta.length; i++){
                        Consulta[i].add(conexion.rs.getString(i+1));
                    }
               }
                conexion.rs.close();
        }
        catch(Exception e){
            Logger.getLogger(LogAuditoria.class.getName()).log(Level.SEVERE, null, e);
            Consulta=null;
            conexion.rs.close();
        }
            return Consulta;
    }

     public String [] getFileList(String path,String emp) throws IOException {
       String [] fl;
       File f = new File(path+emp);
       fl = f.list();
       return fl;
     }

//       public void copyFileList(String path,String emp) throws IOException {
//       String [] fl;
//       File f = new File(path);
//       String [] flist=f.list();
//       File f2;
//       fl = f.list();
//       String Origen="/archivos_plataformacolombia/"+emp+"/";
//       String Destino=path;
//       for (int i = 0; i < flist.length; i++) {
//
//            f2 = new  File(Destino);
//
//           if(f2.exists()){
//           }
//           else{
//               f2.mkdir();
//           }
//
//            File inputFile = new File(Origen+flist[i].toString());
//            File outputFile = new File(Destino+flist[i].toString());
//            FileReader in;
//            try {
//                in = new FileReader(inputFile);
//                FileWriter out = new FileWriter(outputFile);
//                int c;
//
//                while ((c = in.read()) != -1)
//                  out.write(c);
//
//                in.close();
//                out.close();
//            } catch (FileNotFoundException ex) {
//                ex.printStackTrace();
//            }
//
//       }
//
//     }

    public Vector[] getRazonSocial(HttpServletRequest session) throws SQLException{
        Parametro conexion=new Parametro();
        Vector Consulta[]=null;
        Session_Usuario=session.getSession(true);
        String sqlconsulta="select c_nombresrasocial from fqs_suscriptor where c_nombreusuario='"+Session_Usuario.getAttribute("usuario")+"'";
        try{
            conexion.consultaG(sqlconsulta);

                Consulta = new Vector[1];
                for(int i=0; i<Consulta.length; i++){
                    Consulta[i]= new Vector();
                }
                while(conexion.rs.next()){
                    for(int i=0; i<Consulta.length; i++){
                        Consulta[i].add(conexion.rs.getString(i+1));
                    }
               }
                conexion.rs.close();
        }
        catch(Exception e){
            Logger.getLogger(LogAuditoria.class.getName()).log(Level.SEVERE, null, e);
            Consulta=null;
            conexion.rs.close();
        }

            return Consulta;
    }

    public Vector[] getNombreUsuario(HttpServletRequest session) throws SQLException{
      Parametro conexion=new Parametro();
        Vector Consulta[]=null;
        Session_Usuario=session.getSession(true);
        String sqlconsulta="select c_nombreusuario from fqs_suscriptor where c_nombreusuario='"+Session_Usuario.getAttribute("usuario")+"'";
        try{
            conexion.consultaG(sqlconsulta);
                Consulta = new Vector[1];
                for(int i=0; i<Consulta.length; i++){
                    Consulta[i]= new Vector();
                }
                while(conexion.rs.next()){
                    for(int i=0; i<Consulta.length; i++){
                        Consulta[i].add(conexion.rs.getString(i+1));
                    }
               }
                conexion.rs.close();
        }
        catch(Exception e){
            Logger.getLogger(LogAuditoria.class.getName()).log(Level.SEVERE, null, e);
            Consulta=null;
            conexion.rs.close();
        }
            return Consulta;
    }

     public Vector[] getEmail(HttpServletRequest session) throws SQLException{
        Parametro conexion=new Parametro();
        Vector Consulta[]=null;
        Session_Usuario=session.getSession(true);
        String sqlconsulta="select c_email from fqs_suscriptor where c_nombreusuario='"+Session_Usuario.getAttribute("usuario")+"'";
        try{
            conexion.consultaG(sqlconsulta);

                Consulta = new Vector[1];
                for(int i=0; i<Consulta.length; i++){
                    Consulta[i]= new Vector();
                }
                while(conexion.rs.next()){
                    for(int i=0; i<Consulta.length; i++){
                        Consulta[i].add(conexion.rs.getString(i+1));
                    }
               }
                conexion.rs.close();
        }
        catch(Exception e){
            Logger.getLogger(LogAuditoria.class.getName()).log(Level.SEVERE, null, e);
            Consulta=null;
            conexion.rs.close();
        }
        return Consulta;
    }

public boolean esNumerico(String numero) {
    boolean result = true;
    try {
      double valor;
      valor = Double.parseDouble(numero);
      result = true;
    }
    catch (NumberFormatException nfe) {
      result = false;
    }
    return result;
  }

 /*   public static void main(String[] args){
        LogAuditoria sector = new LogAuditoria();
        String [] flist;
        try {
           sector.getMaxRegistros();
        } catch (SQLException ex) {
            Logger.getLogger(LogAuditoria.class.getName()).log(Level.SEVERE, null, ex);
        }

    }*/
}

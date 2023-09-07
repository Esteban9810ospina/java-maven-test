package com.quasar.frameq.util;

import com.quasar.frameq.seguridad.OpcionModulo;
import java.sql.*;
import java.util.logging.Level;
// import java.util.logging.Logger;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Menu {

  private static final Logger logger = Logger.getLogger(Menu.class.getName());
  private String usuario = "";
  private OpcionModulo opc = new OpcionModulo();
  private String filejs = "";
  private String orientacion = "";


  public Menu(String usuario, String orientacion) {
    this.usuario=usuario;
    this.filejs ="\n<SCRIPT language=JavaScript src='lib/menujs/menu_src.js' type=text/javascript></SCRIPT>";
    this.filejs+="\n<SCRIPT language=JavaScript src='lib/menujs/menudata.js' type=text/javascript></SCRIPT>";
    this.orientacion=orientacion;
  }


  public String getMenu() {
    PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
    OpcionModulo opcAuxP = new OpcionModulo();
    OpcionModulo opcAuxH = new OpcionModulo();
    String menu = new String(this.getItemsFirst());
    String sql = new String("select o.* from fqs_usuario u, fqs_permiso p, fqs_opcionmodulo o where u.i_perfil=p.i_perfil and o.i_opcionmodulo = p.i_opcionmodulo and (p.dt_horainipermiso <= now() and p.dt_horafinpermiso >= now()) and u.c_login = '" + this.usuario + "' and i_opciondepende <> 0 group by i_opciondepende order by o.i_orden");

    try {
            
          opc.consultaG(sql);
          while(opc.rs.next()) {
            menu = menu.concat("with(menuq=new menuname(\"");
            menu = menu.concat(opc.rs.getString("i_opciondepende"));
            menu = menu.concat("\")){style=XPMenuStyle;");
            menu = menu.concat("overflow=\"scroll\";");
            menu = menu.concat("orientation=\"vertical\";");

            sql="select o.* from fqs_usuario u, fqs_permiso p, fqs_opcionmodulo o where u.i_perfil=p.i_perfil and o.i_opcionmodulo = p.i_opcionmodulo and (p.dt_horainipermiso <= now() and p.dt_horafinpermiso >= now()) and u.c_login = '" + this.usuario + "' and i_opciondepende = "+opc.rs.getString("i_opciondepende")+" order by o.i_orden";
            opcAuxP.consultaG(sql);

            while(opcAuxP.rs.next()) {
              sql="select o.* from fqs_usuario u, fqs_permiso p, fqs_opcionmodulo o where u.i_perfil=p.i_perfil and o.i_opcionmodulo = p.i_opcionmodulo and (p.dt_horainipermiso <= now() and p.dt_horafinpermiso >= now()) and u.c_login = '" + this.usuario + "' and i_opciondepende = "+opcAuxP.rs.getString("i_opcionmodulo")+" order by o.i_orden";
              opcAuxH.consultaG(sql);
              if(opcAuxH.rs.next()) {
                 menu = menu.concat("\naI(\"text=");
                 menu = menu.concat(opcAuxP.rs.getString("c_nombre"));
                 menu = menu.concat("&nbsp;status=");
                 menu = menu.concat(opcAuxP.rs.getString("i_codigopagina"));
                 menu = menu.concat(";url=JMenuIzq.jsp?Modulo=");
                 menu = menu.concat(opcAuxP.rs.getString("i_modulosistema"));
                 menu = menu.concat("&Opcion=");
                 menu = menu.concat(opcAuxP.rs.getString("i_opcionmodulo"));
                 menu = menu.concat("&Pagina=" + "OPA");
                 menu = menu.concat(opc.rs.getString("i_codigopagina"));
                 menu = menu.concat(";showmenu=");
                 menu = menu.concat(opcAuxP.rs.getString("i_opcionmodulo"));
  		 menu = menu.concat(";\");");
              }
              else {
                 menu = menu.concat("\naI(\"text=");
                 menu = menu.concat(opcAuxP.rs.getString("c_nombre"));
                 menu = menu.concat("&nbsp;status=");
                 menu = menu.concat(opcAuxP.rs.getString("i_codigopagina"));
                 menu = menu.concat(";url=JMenuIzq.jsp?Modulo=");
                 menu = menu.concat(opcAuxP.rs.getString("i_modulosistema"));
                 menu = menu.concat("&Opcion=");
                 menu = menu.concat(opcAuxP.rs.getString("i_opcionmodulo"));
                 menu = menu.concat("&Pagina=" + "OPA");
                 menu = menu.concat(opc.rs.getString("i_codigopagina"));
                 menu = menu.concat(";\");");
              }
            }
            menu = menu.concat("}");
            menu = menu.concat(" ");
          }
      menu+=" drawMenus();";
      menu = this.filejs + "<script>" + menu + "</script>";
    }
    catch (SQLException ex) {
           logger.error("OPA - " + Menu.class.getName(), ex);
        }finally{
        opc.cerrarConexiones();
        opcAuxP.cerrarConexiones();
    }
    return(menu);
  }



  private String getItemsFirst() {

      PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
      OpcionModulo opcAuxH = new OpcionModulo();
      String cadena = "";
      String sql = new String("select o.* from fqs_usuario u, fqs_permiso p, fqs_opcionmodulo o where u.i_perfil=p.i_perfil and o.i_opcionmodulo = p.i_opcionmodulo and (p.dt_horainipermiso <= now() and p.dt_horafinpermiso >= now()) and u.c_login = '" + this.usuario + "' and i_opciondepende = 0 order by o.i_orden");
      try {
            opc.consultaG(sql);
            cadena="with(menuq=new menuname(\"MainMenu\")){style=XPMainStyle;";
            cadena = cadena.concat("alwaysvisible=1;");
            cadena = cadena.concat("orientation=\"");
            cadena = cadena.concat(this.orientacion);
            cadena = cadena.concat("\";");
            cadena = cadena.concat("position=\"relative\"; top=15;left=20;");
            
            while(opc.rs.next()) {

              sql="select o.* from fqs_usuario u, fqs_permiso p, fqs_opcionmodulo o where u.i_perfil=p.i_perfil and o.i_opcionmodulo = p.i_opcionmodulo and (p.dt_horainipermiso <= now() and p.dt_horafinpermiso >= now()) and u.c_login = '";
              sql = sql.concat(this.usuario); 
              sql = sql.concat("' and i_opciondepende = ");
              sql = sql.concat(opc.rs.getString("i_opcionmodulo"));
              sql = sql.concat(" order by o.i_orden");
              opcAuxH.consultaG(sql);
              if(opcAuxH.rs.next()) {
                cadena = cadena.concat("\naI(\"text=");
                cadena = cadena.concat(opc.rs.getString("c_nombre"));
                cadena = cadena.concat(";status=");
                cadena = cadena.concat(opc.rs.getString("i_codigopagina"));
                cadena = cadena.concat(";url=JMenuIzq.jsp?Modulo=");
                cadena = cadena.concat(opc.rs.getString("i_modulosistema"));
                cadena = cadena.concat("&Opcion=");
                cadena = cadena.concat(opc.rs.getString("i_opcionmodulo"));
                cadena = cadena.concat("&Pagina=" + "OPA" );
                cadena = cadena.concat(opc.rs.getString("i_codigopagina"));
                cadena = cadena.concat(";showmenu=");
                cadena = cadena.concat(opc.rs.getString("i_opcionmodulo"));
                cadena = cadena.concat("\");");
              }
              else {
                cadena = cadena.concat("\naI(\"text=");
                cadena = cadena.concat(opc.rs.getString("c_nombre"));
                cadena = cadena.concat(";status=");
                cadena = cadena.concat(opc.rs.getString("i_codigopagina"));
                cadena = cadena.concat(";url=JMenuIzq.jsp?Modulo=");
                cadena = cadena.concat(opc.rs.getString("i_modulosistema"));
                cadena = cadena.concat("&Opcion=");
                cadena = cadena.concat(opc.rs.getString("i_opcionmodulo"));
                cadena = cadena.concat("&Pagina=" + "OPA");
                cadena = cadena.concat(opc.rs.getString("i_codigopagina"));
                cadena = cadena.concat(";\");");
              }
            }
            cadena = cadena.concat("}");
          }
      catch (SQLException ex) {
             logger.error("OPA - " + Menu.class.getName(), ex);	
          }finally{
          opc.cerrarConexiones();
          opcAuxH.cerrarConexiones();
      }
    return(cadena);
  }

}

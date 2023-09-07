package com.quasar.frameq.util;

import com.quasar.frameq.seguridad.OpcionModulo;
import java.sql.*;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class MenuTree {
    
  private static final Logger logger = Logger.getLogger(MenuTree.class.getName());  
  private String menu = "";
  private String menuname = "";



  public MenuTree(String menuname) {

    this.menu="<script language='JavaScript' src='portafolio/lib/menujs/cooltree.js'></script>" +
              "<script language='JavaScript' src='portafolio/lib/menujs/tree1_format.js'></script>"+
              "<link href='portafolio/lib/menujs/tree1.css' rel='stylesheet' type='text/css'>";
    this.menuname=menuname;
  }



  public String getMenu(String usuario) {

   PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
   OpcionModulo opc = new OpcionModulo();
   OpcionModulo opcAux = new OpcionModulo();
   String cadena = new String("var TREE1_NODES = [");
  String sql= new String("select e.c_nombre NEMP from pf_tipoportafolio tp, pf_portafolio p, pf_empresa e, pf_tipoempresa te,pf_usuarioportafolio up "+
                          "where tp.i_tipoportafolio=p.i_pftipoportafolio and p.i_pfempresa=e.i_empresa"+
                          " and te.i_tipoempresa=e.i_pftipoempresa and up.i_empresa=p.i_pfempresa and up.c_usuario='"+usuario+"' group by NEMP");

   try {
     opc.consultaG(sql);

     while (opc.rs.next()) {
       cadena = cadena.concat("['&nbsp;");
       cadena = cadena.concat(opc.rs.getString("NEMP"));
       cadena = cadena.concat("', null, null,");
       
       sql="select p.i_pftipoportafolio TPOR, p.i_pfempresa EPOR, tp.c_nombre NPOR"+
           " from pf_tipoportafolio tp, pf_portafolio p, pf_empresa e, pf_tipoempresa te "+
           " where tp.i_tipoportafolio=p.i_pftipoportafolio and p.i_pfempresa=e.i_empresa"+
           " and te.i_tipoempresa=e.i_pftipoempresa and e.c_nombre='"+opc.rs.getString("NEMP")+"'";
       opcAux.consultaG(sql);
       while (opcAux.rs.next()) {
           cadena = cadena.concat("['&nbsp;");
           cadena = cadena.concat(opcAux.rs.getString("NPOR"));
           cadena = cadena.concat("', \"javascript:verPortafolio('");
           cadena = cadena.concat(opcAux.rs.getString("TPOR"));
           cadena = cadena.concat("','");
           cadena = cadena.concat(opcAux.rs.getString("EPOR"));
           cadena = cadena.concat("');\", ''],");
       }
       cadena = cadena.concat("],");
     }
     cadena = cadena.concat("];");
   }

   catch (SQLException ex) {
        logger.error("OPA - " + MenuTree.class.getName(), ex);
       }finally{
       opc.cerrarConexiones();
       opcAux.cerrarConexiones();
              
   }

   cadena=this.menu + "<script>"+cadena+"</script>";
   cadena+="<script language='JavaScript'>var menuname = \""+this.menuname+"\"; var arbol; arbol=new COOLjsTree (menuname, TREE1_NODES, TREE1_FORMAT); arbol.expandNode(0); arbol.expandNode(1);</script>";
   return(cadena);
  }


}

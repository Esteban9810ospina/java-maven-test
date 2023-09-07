/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quasar.frameq.fachadas;

import com.quasar.frameq.seguridad.Perfil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author jam
 */
public class FacadePerfiles {
    
     private static final Logger logger = Logger.getLogger(FacadePerfiles.class.getName());   
     public List<Perfil> RetornarPerfiles()
    {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Perfil per = new Perfil();
        List<Perfil> perfiles = new ArrayList<Perfil>();
        
        try {
            per.consultaLectura("select i_perfil, c_nombre, dt_horainisesion, dt_horafinsesion, c_descripcion"
                    + " from fqs_perfil");
            while (per.rs.next()) {
                Perfil pr = new Perfil();
                pr.cerrarConexiones();
                pr.setperfil(per.rs.getInt("i_perfil"));
                pr.setnombre(per.rs.getString("c_nombre"));
                pr.sethoraInicioSesion(per.rs.getString("dt_horainisesion"));
                pr.sethoraFinSesion(per.rs.getString("dt_horafinsesion"));
                pr.setdescripcion(per.rs.getString("c_descripcion"));

                perfiles.add(pr);
            }
            //per.cerrarConexiones();
            
        } catch (SQLException ex) {
            logger.error("OPA - " + FacadePerfiles.class.getName(), ex);	
            //per.cerrarConexiones();
        }
        finally{
           per.cerrarConexiones(); 
        }
        return perfiles;
    }
     
      public  String  RetornarPerfilUsuario(int usuario)
    {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        Perfil per = new Perfil();
        String perfil="";
        
        try {
            per.consultaLectura("SELECT rol.i_perfil id, rol.c_nombre nombre, usr_rol.c_proceso proceso "
                    + " FROM fqs_perfil rol "
                    + " INNER JOIN fqs_usuario_has_fqs_perfil usr_rol ON rol.i_perfil = usr_rol.fqs_perfil_i_perfil "
                    + " INNER JOIN fqs_usuario usr ON usr.i_usuario = usr_rol.fqs_usuario_i_usuario "
                    + " WHERE usr.i_usuario = "+usuario+"");
            if(per.rs.next()) {                
               
                perfil=per.rs.getString("nombre");
            }
            //per.cerrarConexiones();
        } catch (SQLException ex) {
            logger.error("OPA - " + FacadePerfiles.class.getName(), ex);
            //per.cerrarConexiones();
        }
        finally{
          per.cerrarConexiones();   
        }
        return perfil;
    }
    
    
}

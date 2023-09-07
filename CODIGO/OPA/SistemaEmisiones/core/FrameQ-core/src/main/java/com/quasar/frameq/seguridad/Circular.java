package com.quasar.frameq.seguridad;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.bvc.democratiza.seguridad:
//            Usuario

public class Circular
{
    public Circular()
    {
    }
    public String cambioClave(String usuarioSession, String claveAnterior, String claveNueva)
    {
        Usuario usuarioClass = new Usuario();
        String estado = "";
        try
        {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dNow = new java.util.Date();            
            String fechaActual = df.format(dNow); 
            usuarioClass.consultaP(" where c_login = '" + usuarioSession + "' and c_contrasena = MD5('" + claveAnterior + "')");
            if(usuarioClass.first())
            {
                if(usuarioClass.actualiza("update fqs_usuario set f_ult_cambio_clave = '"+ fechaActual+ "' c_contrasena =MD5('" + claveNueva + "') " + " where c_login = '" + usuarioSession + "' and c_contrasena = MD5('" + claveAnterior + "')") == 1)
                    estado = "Cambio de Clave exitoso";
                else
                    estado = "No se realizó cambio de clave";
            } else
            {
                estado = "Clave de usuario erronea";
            }
            usuarioClass.cerrarConexiones();
        }
        catch(Exception e)
        {
            Logger.getLogger(Circular.class.getName()).log(Level.SEVERE, "Error consultando al Usuario", e); 
        }
        return estado;
    }

    public int actualizaUsuarios(Vector datos)
    {
        Usuario usuarioClass = new Usuario();
        Usuario usuarioClass1 = new Usuario();
        int actualizaUsr = 0;

        try
        {
            usuarioClass1.consultaG("select c_contrasena from fqs_usuario where  i_usuario=" + datos.elementAt(0));
            if(usuarioClass1.first()){
                if(usuarioClass1.rs.getString("c_contrasena").equalsIgnoreCase(datos.elementAt(9).toString())){
                  actualizaUsr = usuarioClass.actualiza("update fqs_usuario set  i_usuario=" + datos.elementAt(0) + ",i_perfil=" + datos.elementAt(1) + ","+
                     "e_identificacion=" + datos.elementAt(2) + "," + " c_nombre='" + datos.elementAt(3) + "',c_apellidos='" + datos.elementAt(4) + "',"+
                    "c_direccion='" + datos.elementAt(5) + "'," + " c_telefono='" + datos.elementAt(6) + "',c_email='" + datos.elementAt(7) + "',c_login='" + datos.elementAt(8) + "'," +
                    " c_contrasena='" + datos.elementAt(9) + "',dt_ultimologin='" + datos.elementAt(10) + "',i_empresa=" + datos.elementAt(11) + "," +
                    " i_usuario_padre=" + datos.elementAt(12) + ",c_estado='" + datos.elementAt(13) + "',f_ult_cambio_clave='" + datos.elementAt(14) + "'," +
                    " i_numsesiones=" + datos.elementAt(15) + ",i_usuariosupvisor=" + datos.elementAt(16) + ",c_proceso='" + datos.elementAt(17) + "'," +
                    " f_ult_cambio_reintento='" + datos.elementAt(18) + " ' where  i_usuario=" + datos.elementAt(0)) ;
                    usuarioClass.cerrarConexiones();

                }else{
                    actualizaUsr = usuarioClass.actualiza("update fqs_usuario set  i_usuario=" + datos.elementAt(0) + ",i_perfil=" + datos.elementAt(1) + ","+
                     "e_identificacion=" + datos.elementAt(2) + "," + " c_nombre='" + datos.elementAt(3) + "',c_apellidos='" + datos.elementAt(4) + "',"+
                    "c_direccion='" + datos.elementAt(5) + "'," + " c_telefono='" + datos.elementAt(6) + "',c_email='" + datos.elementAt(7) + "',c_login='" + datos.elementAt(8) + "'," +
                    " c_contrasena=MD5('" + datos.elementAt(9) + "'),dt_ultimologin='" + datos.elementAt(10) + "',i_empresa=" + datos.elementAt(11) + "," +
                    " i_usuario_padre=" + datos.elementAt(12) + ",c_estado='" + datos.elementAt(13) + "',f_ult_cambio_clave='" + datos.elementAt(14) + "'," +
                    " i_numsesiones=" + datos.elementAt(15) + ",i_usuariosupvisor=" + datos.elementAt(16) + ",c_proceso='" + datos.elementAt(17) + "'," +
                    " f_ult_cambio_reintento='" + datos.elementAt(18) + " ' where  i_usuario=" + datos.elementAt(0)) ;
                    usuarioClass.cerrarConexiones();
                }
            usuarioClass1.cerrarConexiones();
            }


        }

        catch(Exception e)
        {
         Logger.getLogger(Circular.class.getName()).log(Level.SEVERE, "Error actualizando los Usuarios", e);
        }
        return actualizaUsr;
    }

    public int ingresaUsuarios(Vector datos)
    {
        Usuario usuarioClass = new Usuario();
        int actualizaUsr = 0;
        try
        {
            actualizaUsr = usuarioClass.actualiza("insert into  fqs_usuario values( " + datos.elementAt(0) + "," + datos.elementAt(1) + ",'" + datos.elementAt(2) + "'," + "'" + datos.elementAt(3) + "','" + datos.elementAt(4) + "','" + datos.elementAt(5) + "'," + "'" + datos.elementAt(6) + "','" + datos.elementAt(7) + "','" + datos.elementAt(8) + "'," + "MD5('" + datos.elementAt(9) + "'),'" + datos.elementAt(10) + "'," + datos.elementAt(11) + "," + datos.elementAt(12) + ",'" + datos.elementAt(13) + "','" + datos.elementAt(14) + "'," + datos.elementAt(15) + "," + datos.elementAt(16) + ",'" + datos.elementAt(17) + "'," + "'" + datos.elementAt(18) + "')");
            usuarioClass.cerrarConexiones();
        }
        catch(Exception e)
        {
            actualizaUsr = 0;            
        Logger.getLogger(Circular.class.getName()).log(Level.SEVERE, "Error actualizando los Usuarios", e);
        }
        return actualizaUsr;
    }

    public int desbloqueaUsuarios(String usuario)
    {
        Usuario usuarioClass = new Usuario();
        int actualizaUsr = 0;
        try
        {
            actualizaUsr = usuarioClass.actualiza("update fqs_usuario set c_estado='A',i_numsesiones=0 where i_usuario=" + usuario);
            usuarioClass.cerrarConexiones();
        }
        catch(Exception e)
        {
           actualizaUsr = 0;           
           Logger.getLogger(Circular.class.getName()).log(Level.SEVERE, "Error actualizando los Usuarios", e);  
        }
        return actualizaUsr;
    }
}

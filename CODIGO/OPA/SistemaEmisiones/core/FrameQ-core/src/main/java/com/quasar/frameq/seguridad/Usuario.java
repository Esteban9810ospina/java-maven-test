// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name:   Usuario.java

package com.quasar.frameq.seguridad;

import com.quasar.frameq.db.Persistente;
import java.awt.BorderLayout;
import java.sql.*;
import java.util.Vector;
import java.net.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Usuario extends Persistente
{
 private static final Logger logger = Logger.getLogger(Usuario.class.getName());
    private Integer usuario;
    private Integer perfil;
    private Double identificacion;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String email;
    private String login;
    private String contrasena;
    private Timestamp ultimologin;
    private Integer empresa;
    private Integer padre;
    private String estado;
    private Date fechaclave;
    private Integer numsesiones;
    private Integer usuariosupvisor;
    private String proceso;
    private Timestamp ultcambioreintento;
    private Integer sbolsa;
    

    public Integer getSbolsa() {
        return sbolsa;
    }

    public void setSbolsa(Integer sbolsa) {
        this.sbolsa = sbolsa;
    }


    public Usuario()
    {
        setUsuario(new Integer(0));
        setPerfil(new Integer(0));
        setIdentificacion(new Double(0.0));
        setNombre("");
        setApellidos("");
        setDireccion("");
        setTelefono("");
        setEmail("");
        setLogin("");
        setContrasena("");
        setUltimologin(new Timestamp(System.currentTimeMillis()));
        setempresa(new Integer(0));
        setPadre(new Integer(0));
        setEstado("");
        setFechaClave(Date.valueOf("2001-01-01"));
        setNumsesiones(new Integer(0));
        setUsuariosupvisor(new Integer(0));
        setProceso("");
        setUltcambioreintento(new Timestamp(System.currentTimeMillis()));
        setSbolsa(new Integer(0));
    }

    public Usuario(Integer usuario, Integer perfil, Double identificacion, String nombre, String apellidos, String direccion, String telefono,
            String email, String login, String contrasena, Timestamp ultimologin, Integer empresa, Integer padre, String estado,
            Date fechaclave, Integer numsesiones, Integer usuariosupvisor, String proceso, Timestamp ultcambioreintento, Integer sbolsa)
    {
        setUsuario(usuario);
        setPerfil(perfil);
        setIdentificacion(identificacion);
        setNombre(nombre);
        setApellidos(apellidos);
        setDireccion(direccion);
        setTelefono(telefono);
        setEmail(email);
        setLogin(login);
        setContrasena(contrasena);
        setUltimologin(ultimologin);
        setempresa(empresa);
        setPadre(padre);
        setEstado(estado);
        setFechaClave(fechaclave);
        setNumsesiones(numsesiones);
        setUsuariosupvisor(usuariosupvisor);
        setProceso(proceso);
        setUltcambioreintento(ultcambioreintento);
        setSbolsa(sbolsa);
    }

    public void setUsuario(Integer usuario)
    {
        this.usuario = usuario;
    }

    public void setPerfil(Integer perfil)
    {
        this.perfil = perfil;
    }

    public void setIdentificacion(Double identificacion)
    {
        this.identificacion = identificacion;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos)
    {
        this.apellidos = apellidos;
    }

    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public void setContrasena(String contrasena)
    {
        this.contrasena = contrasena;
    }

    public void setUltimologin(Timestamp ultimologin)
    {
        this.ultimologin = ultimologin;
    }

    public void setempresa(Integer empresa)
    {
        this.empresa = empresa;
    }

    public void setPadre(Integer padre)
    {
        this.padre = padre;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
    }

    public void setFechaClave(Date fechaclave)
    {
        this.fechaclave = fechaclave;
    }

    public void setNumsesiones(Integer numsesiones)
    {
        this.numsesiones = numsesiones;
    }

    public void setUsuariosupvisor(Integer usuariosupvisor)
    {
        this.usuariosupvisor = usuariosupvisor;
    }

    public void setProceso(String proceso)
    {
        this.proceso = proceso;
    }

    public void setUltcambioreintento(Timestamp ultcambioreintento)
    {
        this.ultcambioreintento = ultcambioreintento;
    }

    public Integer getUsuario()
    {
        return usuario;
    }

    public Integer getPerfil()
    {
        return perfil;
    }

    public Double getIdentificacion()
    {
        return identificacion;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getApellidos()
    {
        return apellidos;
    }

    public String getDireccion()
    {
        return direccion;
    }

    public String getTelefono()
    {
        return telefono;
    }

    public String getEmail()
    {
        return email;
    }

    public String getLogin()
    {
        return login;
    }

    public String getContrasena()
    {
        return contrasena;
    }

    public Timestamp getUltimologin()
    {
        return ultimologin;
    }

    public Integer getempresa()
    {
        return empresa;
    }

    public Integer getPadre()
    {
        return padre;
    }

    public String getEstado()
    {
        return estado;
    }

    public Date getFechaClave()
    {
        return fechaclave;
    }

    public Integer getNumsesiones()
    {
        return numsesiones;
    }

    public Integer getUsuariosupvisor()
    {
        return usuariosupvisor;
    }

    public String getProceso()
    {
        return proceso;
    }

    public Timestamp getUltcambioreintento()
    {
        return ultcambioreintento;
    }

    public Vector getContenido()
    {
        Vector v = new Vector();
        v.add(usuario);
        v.add(perfil);
        v.add(identificacion);
        v.add(nombre);
        v.add(apellidos);
        v.add(direccion);
        v.add(telefono);
        v.add(email);
        v.add(login);
        v.add(contrasena);
        v.add(ultimologin);
        v.add(empresa);
        v.add(padre);
        v.add(estado);
        v.add(fechaclave);
        v.add(numsesiones);
        v.add(usuariosupvisor);
        v.add(proceso);
        v.add(ultcambioreintento);
        v.add(sbolsa);
        return v;
    }

    public void inicializar()
    {
        setPersistente(this);
        String atributos[] = {
            "i_usuario", "i_perfil", "e_identificacion", "c_nombre", "c_apellidos", "c_direccion", "c_telefono", "c_email", "c_login", "c_contrasena",
            "dt_ultimologin", "i_empresa", "i_usuario_padre", "c_estado", "f_ult_cambio_clave", "i_numsesiones", "i_usuariosupvisor", "c_proceso", "f_ult_cambio_reintento",
            "i_cod_agente"
        };  
        int precision[] = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
        };
        setPrecision(precision);
        setAtributos(atributos);
        setNombreTabla("fqs_usuario");
        setElementosLLave(2);
    }

    public Persistente nuevo(Vector v)
    {
        return new Usuario((Integer)v.elementAt(0), (Integer)v.elementAt(1), (Double)v.elementAt(2), (String)v.elementAt(3), (String)v.elementAt(4), (String)v.elementAt(5), (String)v.elementAt(6), (String)v.elementAt(7), (String)v.elementAt(8), (String)v.elementAt(9), (Timestamp)v.elementAt(10), (Integer)v.elementAt(11), (Integer)v.elementAt(12), (String)v.elementAt(13), (Date)v.elementAt(14), (Integer)v.elementAt(15), (Integer)v.elementAt(16), (String)v.elementAt(17), (Timestamp)v.elementAt(18), (Integer)v.elementAt(19));
    }

    public void setContenido()
        throws SQLException
    {
        setUsuario(new Integer(rs.getInt("i_usuario")));
        setPerfil(new Integer(rs.getInt("i_perfil")));
        setIdentificacion(new Double(rs.getDouble("e_identificacion")));
        setNombre((rs.getString("c_nombre")));
        setApellidos((rs.getString("c_apellidos")));
        setDireccion((rs.getString("c_direccion")));
        setTelefono((rs.getString("c_telefono")));
        setEmail((rs.getString("c_email")));
        setLogin((rs.getString("c_login")));
        setContrasena((rs.getString("c_contrasena")));
        setUltimologin(rs.getTimestamp("dt_ultimologin"));
        setempresa(new Integer(rs.getInt("i_empresa")));
        setPadre(new Integer(rs.getInt("i_usuario_padre")));
        setEstado((rs.getString("c_estado")));
        setFechaClave(rs.getDate("f_ult_cambio_clave"));
        setNumsesiones(new Integer(rs.getInt("i_numsesiones")));
        setUsuariosupvisor(new Integer(rs.getInt("i_usuariosupvisor")));
        setProceso((rs.getString("c_proceso")));
        setUltcambioreintento(rs.getTimestamp("f_ult_cambio_reintento"));
        setSbolsa(rs.getInt("i_cod_agente"));
    }

    public void setContenido(Vector v)
    {
        String auxS = v.elementAt(0).toString();
        Integer auxI = new Integer(auxS);
        if(auxI != null)
            setUsuario(auxI);
        else
            setUsuario(new Integer(0));
        auxS = v.elementAt(1).toString();
        auxI = new Integer(auxS);
        if(auxI != null)
            setPerfil(auxI);
        else
            setPerfil(new Integer(0));


        auxS = v.elementAt(2).toString();
        Double auxDb = new Double(auxS);
        if(auxDb != null)
            setIdentificacion(auxDb);
        else
            setIdentificacion(new Double(0));

        setNombre((String)v.elementAt(3));
        setApellidos((String)v.elementAt(4));
        setDireccion((String)v.elementAt(5));
        setTelefono((String)v.elementAt(6));
        setEmail((String)v.elementAt(7));
        setLogin((String)v.elementAt(8));
        setContrasena((String)v.elementAt(9));
        auxS = v.elementAt(10).toString();
        Timestamp auxT = Timestamp.valueOf(auxS);
        if(auxT != null)
            setUltimologin(auxT);
        else
            setUltimologin(new Timestamp(System.currentTimeMillis()));
        auxS = v.elementAt(11).toString();
        auxI = new Integer(auxS);
        if(auxI != null)
            setempresa(auxI);
        else
            setempresa(new Integer(0));
        auxS = v.elementAt(12).toString();
        auxI = new Integer(auxS);
        if(auxI != null)
            setPadre(auxI);
        else
            setPadre(new Integer(0));
        setEstado((String)v.elementAt(13));
        auxS = v.elementAt(14).toString();
        Date auxD = Date.valueOf(auxS);
        if(auxD != null)
            setFechaClave(auxD);
        else
            setFechaClave(Date.valueOf(""));
        auxS = v.elementAt(15).toString();
        auxI = new Integer(auxS);
        if(auxI != null)
            setNumsesiones(auxI);
        else
            setNumsesiones(new Integer(0));
        auxS = v.elementAt(16).toString();
        auxI = new Integer(auxS);
        if(auxI != null)
            setUsuariosupvisor(auxI);
        else
            setUsuariosupvisor(new Integer(0));
        setProceso((String)v.elementAt(17));
        auxS = v.elementAt(18).toString();
        auxT = Timestamp.valueOf(auxS);
        if(auxD != null)
            setUltcambioreintento(auxT);
        else
            setUltcambioreintento(new Timestamp(System.currentTimeMillis()));
        setSbolsa((Integer)v.elementAt(19));
    }

    public boolean referencia(Vector v)
    {
        return true;
    }



  /**
   * Si el valor del vecto en la última posicion es diferente de -1 verifica si tiene usuarios dependientes, si tiene lo inserta en el vector sino,
   * si es la última posicion del vector inserta -1
   *
   * @param usuario int
   * @param sUsuario String
   * @param fecha String
   * @return Vector
   */
  public String buscaUsuario(int usuario, String sUsuario) {
    PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
      Vector cUser = new Vector();
    Vector nombreUsuario = new Vector();
    int i = 1;
    int j = 0;
    String sIn = "";

      
    try {
      cUser.add(String.valueOf(usuario));
      nombreUsuario.add(sUsuario);

      String query =
                "select i_usuario, c_tipo_identificacion, c_identificacion, c_nombre, c_apellidos, "
                + "c_direccion, c_telefono, c_email, c_login, c_contrasena, dt_ultimologin, i_empresa, "
                + "i_usuario_padre, c_estado, f_ult_cambio_clave, i_numsesiones, i_usuariosupvisor, i_usuariosupvisor"
                + ", f_ult_cambio_reintento, sesion, i_cod_agente FROM fqs_usuario"
                + " WHERE i_usuariosupvisor = ? AND i_usuario != ?";

      while (!cUser.lastElement().equals("-1")) {
        usuario = Integer.parseInt(cUser.elementAt(j).toString());
        j++;
        consultaG(query, usuario, usuario);
        logger.debug("OPA - " + query);

        if (first()) {
          do {
            cUser.add(rs.getString("i_usuario"));
            nombreUsuario.add(rs.getString("c_login"));
            i++;
          } while (next());
        } else if (cUser.size() == j) {
          cUser.add("-1");
        }
      }
      for (i = 1; i <= nombreUsuario.size() - 1; i++) {
        sIn = "'" + nombreUsuario.elementAt(i).toString() + "'," + sIn;
      }

      logger.debug("OPA - " + "sIn{}" + sIn);
      sIn = sIn.substring(0, sIn.length() - 1);
    } catch (SQLException ex) {
      // logger.error("Error en buscaUsuario - 1 {}", ex.getMessage(),ex);
      logger.error("Error en buscaUsuario - 1 {}" + ex.getMessage(),ex);
      
    }finally{
        
        cerrarConexiones();
    }

    return sIn;
  }

  /**
   * Valida que una operación que se va a excluir haya sido autorizada por el usuario supervisor.
   *
   * @param folio int
   * @param fecha String
   * @param sistema String
   * @return String
   */
  public String validaAutorizacion(int folio, String fecha, String sistema) {
    PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
      String valida = "";
    
      try {
      this.consultaLectura("select a.*,b.* from fqs_usuario a,fqs_logoperexc b"
              + " where a.c_login=b.c_usuario and b.c_accion='Autoriza'"
              + " and d_fechaoperacion='" + fecha + "' and i_folio=" + folio
              + " and c_sistnegcion='" + sistema + "'");
      if (this.first()) {
        valida = this.rs.getString("a.c_nombre") + " " + this.rs.getString("a.c_apellidos");
      } else {
        valida = "";
      };
    } catch (Exception ex) {
      logger.error("Error en validaAutorizacion" + ParametrosDAO.class.getName(), ex);	
        //Logger.getLogger(ParametrosDAO.class.getName()).log(Level.SEVERE, "Error en validaAutorizacion" , ex); 
    }finally{
        
        this.cerrarConexiones();
    }
    return valida;
  }

   public void getDirIp (){
     PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
       try {
         InetAddress localaddr = InetAddress.getLocalHost();
        }
      catch ( UnknownHostException e )
         {
         //Logger.getLogger(ParametrosDAO.class.getName()).log(Level.SEVERE, "Can't detect localhost : " , e); 
         logger.error(Usuario.class.getName()+ "Can't detect localhost : " + e);
         }



  }



    public static void main(String args[])
    {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        
        try
        {
            Usuario prueba = new Usuario(new Integer(1), new Integer(1), new Double(0.0), new String("Datos prueba campo 3"), new String("Datos prueba campo 4"), new String("Datos prueba campo 5"), new String("Datos prueba campo 6"), new String("Datos prueba campo 7"), new String("Datos prueba campo 8"), new String("Datos prueba campo 9"), new Timestamp(System.currentTimeMillis()), new Integer(1), new Integer(1), new String("Datos prueba campo 13"), Date.valueOf("2001-01-01"), new Integer(1), new Integer(1), new String("Datos prueba campo 17"), new Timestamp(System.currentTimeMillis()), new Integer(1));
            prueba.insertar();
            prueba.consultaG("select i_usuario, c_tipo_identificacion, c_identificacion, c_nombre, c_apellidos, "
                        + "c_direccion, c_telefono, c_email, c_login, c_contrasena, dt_ultimologin, i_empresa, "
                        + "i_usuario_padre, c_estado, f_ult_cambio_clave, i_numsesiones, i_usuariosupvisor, i_usuariosupvisor"
                        + ", f_ult_cambio_reintento, sesion, i_cod_agente from fqs_usuario where i_usuario='1'");
            prueba.first();
            prueba.setContenido();
            prueba.actualizar();
            prueba.consultaG("select select i_usuario, c_tipo_identificacion, c_identificacion, c_nombre, c_apellidos, "
                        + "c_direccion, c_telefono, c_email, c_login, c_contrasena, dt_ultimologin, i_empresa, "
                        + "i_usuario_padre, c_estado, f_ult_cambio_clave, i_numsesiones, i_usuariosupvisor, i_usuariosupvisor"
                        + ", f_ult_cambio_reintento, sesion, i_cod_agente from fqs_usuario ");
            
            for(; prueba.next(); prueba.setContenido());
            
            prueba.cerrarConexiones();
        }
        catch(Exception Ex)
        {
            //Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, Ex);
            logger.error(Usuario.class.getName(), Ex);	
        }
    }


}


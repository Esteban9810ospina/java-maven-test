package com.quasar.frameq.beans;

import com.quasar.frameq.seguridad.ParametrosDAO;
import com.quasar.frameq.seguridad.Usuario;

import java.sql.Timestamp;
import java.util.Date;
import java.util.GregorianCalendar;
import java.sql.SQLException;

public class SessionBean {

  private String usuario = "";
  private String password = "";
  private String ip = "";
  private int perfil = 0;
  Usuario usua = new Usuario();
  ParametrosDAO parametro = new ParametrosDAO();
  java.text.SimpleDateFormat formaFecha = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
  private int perfilUsu;
  //private Vector vector;
  private String suscriptor = "";
  private String pwdSusc = "";
  private String nombreS = "";
  private String sexoS = "";
  private int scb;

    public int getScb() {
        return scb;
    }

    public void setScb(int scb) {
        this.scb = scb;
    }

  public boolean execConsulta(int a) {
    try {
      usua.consultaLectura("select i_usuario, c_tipo_identificacion, c_identificacion, c_nombre, c_apellidos, "
              + "c_direccion, c_telefono, c_email, c_login, c_contrasena, dt_ultimologin, i_empresa, "
              + "i_usuario_padre, c_estado, f_ult_cambio_clave, i_numsesiones, i_usuariosupvisor, "
              + "i_usuariosupvisor, f_ult_cambio_reintento, sesion, i_cod_agente "
              + "from fqs_usuario where c_login ='" + usuario + "' and c_contrasena = '" + password + "'");
      if (usua.first()) {
        perfilUsu = usua.rs.getInt("i_perfil");
        if (perfilUsu > 0) {
          return true;
        }
      }
    } catch (SQLException se) {
      se.toString();
    } finally {

      usua.cerrarConexiones();

    }
    return false;
  }

  public int execConsulta() {
    try {


      int minutosbloqueo;
      int tmpBloqueo;
      boolean validaIP;
      GregorianCalendar controlAcceso;
      String idusuario;
      minutosbloqueo = Integer.parseInt(parametro.buscarParametro(10005));
      validaIP = false;
      controlAcceso = new GregorianCalendar();

      usua.cerrarConexiones();

      usua.consultaLectura("select i_usuario, c_tipo_identificacion, c_identificacion, c_nombre, c_apellidos, "
              + "c_direccion, c_telefono, c_email, c_login, c_contrasena, dt_ultimologin, i_empresa, "
              + "i_usuario_padre, c_estado, f_ult_cambio_clave, i_numsesiones, i_usuariosupvisor, "
              + "i_usuariosupvisor, f_ult_cambio_reintento, sesion, i_cod_agente "
              + "from fqs_usuario where c_login ='" + usuario + "' and c_contrasena = md5('" + password + "')");
      if (usua.first()) {
        usua.setContenido();
        perfil = usua.rs.getInt("i_perfil");
        usua.setPerfil(perfil);
        idusuario = usua.rs.getString("i_usuario");
        scb = usua.rs.getInt("i_cod_agente");
        if (usua.getEstado().equals("I")) {
          this.fallido(usua, -4);
          return -4; //Usuario inactivo
        } else if (usua.getEstado().equals("B")) {
          controlAcceso.setTime(usua.getUltcambioreintento());
          controlAcceso.add(12, minutosbloqueo);
          if (controlAcceso.getTime().before(new Date(System.currentTimeMillis()))) {
            if (this.fallido(usua, -6).equalsIgnoreCase("B")) {
              return -6;
            }
          } else {
            return -6;
          }
        }

        if (validaIP) {
          if (usua.getFechaClave().compareTo(new java.sql.Date(System.currentTimeMillis())) < 0) {
            this.fallido(usua, -5);
            return -5; //Fecha de clave caduco
          }
        } else {
          if (usua.getFechaClave().compareTo(new java.sql.Date(System.currentTimeMillis())) < 0) {
            this.fallido(usua, -5);
            return -5; //Fecha de clave caduco
          } else {
            if (usua.getEstado().equalsIgnoreCase("B")) {
              this.valido(usua);
              return -6;
            } else {
              this.valido(usua);
              return 1;
            }
          }
        }
      } else {
        usua.cerrarConexiones();
        usua.consultaLectura("select i_usuario, c_tipo_identificacion, c_identificacion, c_nombre, c_apellidos, "
              + "c_direccion, c_telefono, c_email, c_login, c_contrasena, dt_ultimologin, i_empresa, "
              + "i_usuario_padre, c_estado, f_ult_cambio_clave, i_numsesiones, i_usuariosupvisor, "
              + "i_usuariosupvisor, f_ult_cambio_reintento, sesion, i_cod_agente "
              + " from fqs_usuario where c_login ='" + usuario + "'");
        if (usua.first()) {
          usua.setContenido();
          controlAcceso.setTime(usua.getUltcambioreintento());
          controlAcceso.add(12, minutosbloqueo);

          if (usua.getEstado().equalsIgnoreCase("B")) {
            if (controlAcceso.getTime().before(new Date(System.currentTimeMillis()))) {
              if (this.fallido(usua, -6).equalsIgnoreCase("B")) {
                return -6;
              } else {
                tmpBloqueo = (usua.getNumsesiones()) + 1;
                usua.setNumsesiones(tmpBloqueo);
                usua.actualizar();
                if (Integer.parseInt(parametro.buscarParametro(10003)) == 1) {
                  return -6;
                } else {
                  return -1;
                }

              }
            } else {
              if (fallido(usua, -1).equalsIgnoreCase("B")) {
                return -6;
              } else {
                return -1;
              }
            }
          } else {
            if (fallido(usua, -1).equalsIgnoreCase("B")) {
              return -6;
            } else {
              return -1;
            }
          }
        }
      }

    } catch (NumberFormatException se) {

      se.getMessage();
      se.getStackTrace();
      se.toString();

    } catch (SQLException se) {
        se.getMessage();
        se.getStackTrace();
        se.toString();
    }

    try {
      if (usua.rs != null) {
        usua.rs.close();
      }
    } catch (SQLException e) {
      e.getMessage();
      e.toString();
    }

    return 1;
  }

  // Suscripciones

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public int getPerfil() {
    return perfil;
  }

  public void setUsuario(int perfil) {
    this.perfil = perfil;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  // Suscripciones
  public String getSuscriptor() {
    return suscriptor;
  }

  public void setSuscriptor(String suscr) {
    this.suscriptor = suscr;
  }

  public String getPwdSusc() {
    return this.pwdSusc;
  }

  public void setPwdSusc(String pwdSuscriptor) {
    this.pwdSusc = pwdSuscriptor;
  }

  public String getNombreS() {
    return this.nombreS;
  }

  public void setNombreS(String nombreSuscriptor) {
    this.nombreS = nombreSuscriptor;
  }

  public String getSexoS() {
    return this.sexoS;
  }

  public void setSexoS(String sexoSusc) {
    this.sexoS = sexoSusc;
  }

  public String fallido(Usuario usua, int motivo) throws SQLException {
    String estado;
    int reintentos;
    int intentosusuario;
    if (motivo != -6) {
      reintentos = Integer.parseInt(parametro.buscarParametro(10003));
      intentosusuario = usua.rs.getInt("i_numsesiones");
      usua.setUltcambioreintento(Timestamp.valueOf(formaFecha.format(new Date(System.currentTimeMillis()))));
      intentosusuario++;
      usua.setNumsesiones(intentosusuario);
      if (intentosusuario >= reintentos) {
          usua.setEstado("B");
          estado = "B";
      } else {
          estado = usua.getEstado();
      }
    } else {
        usua.setUltimologin(Timestamp.valueOf(formaFecha.format(new Date(System.currentTimeMillis()))));
        usua.setUltcambioreintento(Timestamp.valueOf(formaFecha.format(new Date(System.currentTimeMillis()))));
        usua.setNumsesiones(0);
        usua.setEstado("A");
        estado = "A";
    }
    usua.actualizar();
    return estado;
  }

  public boolean valido(Usuario usua) {
    if (!usua.getEstado().equalsIgnoreCase("B")) {
      usua.setUltimologin(Timestamp.valueOf(formaFecha.format(new Date(System.currentTimeMillis()))));
      usua.setNumsesiones(0);
      usua.setUltcambioreintento(Timestamp.valueOf(formaFecha.format(new Date(System.currentTimeMillis()))));
      usua.actualizar();
      return true;
    } else {
      return false;
    }
  } 
}
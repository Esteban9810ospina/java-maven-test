package com.quasar.frameq.seguridad;

import com.quasar.frameq.beans.SessionBean;

public class ValidaUsuario {

  public ValidaUsuario() {
  }

  public boolean cargaSesion(String usuario, String contrasena,javax.servlet.http.HttpSession session){
    SessionBean validar = new SessionBean();
    SessionBean sesion = new SessionBean();
    usuario="upruebas";
    contrasena="pquasar";
    validar.setUsuario(usuario);
    validar.setPassword(contrasena);
    boolean valido = validar.execConsulta(1);
    if (valido == true) {
      sesion.setUsuario(usuario);
      sesion.setPassword(contrasena);
      return true;
    }
    else {
      return false;
    }
  }
}

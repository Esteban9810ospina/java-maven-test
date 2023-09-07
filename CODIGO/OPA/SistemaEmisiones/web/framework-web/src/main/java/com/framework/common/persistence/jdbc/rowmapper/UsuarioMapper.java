/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.persistence.jdbc.rowmapper;

import com.framework.common.domain.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Roger Padilla C.
 */
public class UsuarioMapper implements RowMapper<Usuario> {

  @Override
  public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {

    Integer id = rs.getInt("id");
    String username = rs.getString("login");
    String password = rs.getString("contrasena");
    String llaveCodifi = rs.getString("llave_codificada");
    String estado = rs.getString("estado");
    String email = rs.getString("email");
    String direccion = rs.getString("direccion");
    String telefono = rs.getString("telefono");
    String identificacion = rs.getString("identificacion");
    Integer Sbolsa = rs.getInt("sbolsa");
    String usuariosistemaultimamod = rs.getString("c_usuario_sistema_ultima_mod");
    String usuariobddatos = rs.getString("c_usuario_bd_datos");
    Timestamp fechahoraultimamodificacion = rs.getTimestamp("ts_fecha_hora_ultimo_modificacion");
    String tipomodificacion = rs.getString("c_tipo_modificacion");
    String cambiocontrasena = rs.getString("ty_cambiocontrasena");
    
    
    
    Usuario usuario = new Usuario(id, username, password, estado, email, Sbolsa, direccion, telefono,identificacion,
    usuariosistemaultimamod, usuariobddatos, fechahoraultimamodificacion, tipomodificacion, cambiocontrasena, llaveCodifi);

    usuario.setTipoIdentificacion(rs.getString("tipo_identificacion"));
    usuario.setIdentificacion(rs.getString("identificacion"));
    usuario.setNombres(rs.getString("nombres"));
    usuario.setApellidos(rs.getString("apellidos"));
    usuario.setEmail(rs.getString("email"));
    usuario.setDireccion(rs.getString("direccion"));
    usuario.setTelefono(rs.getString("telefono"));
    usuario.setNumeroSesiones(rs.getInt("numero_sesiones"));
    usuario.setSupervisorId(rs.getInt("supervisor_id"));
    usuario.setSbolsa(Sbolsa);
    usuario.setUsuariosistemaultimamod(rs.getString("c_usuario_sistema_ultima_mod"));
    usuario.setUsuariobddatos(rs.getString("c_usuario_bd_datos"));
    usuario.setFechahoraultimamodificacion(rs.getTimestamp("ts_fecha_hora_ultimo_modificacion"));
    usuario.setTipomodificacion(rs.getString("c_tipo_modificacion"));
    usuario.setCambioContrasena(rs.getString("ty_cambiocontrasena"));
    usuario.setLlaveCodifi(rs.getString("llave_codificada"));
    
   // usuario.setIdentificacion("identificacion");

    Timestamp dateAux = rs.getTimestamp("ultimo_login");
    if (dateAux != null) {
      Calendar ultimoLogin = Calendar.getInstance();
      ultimoLogin.setTime(dateAux);
      usuario.setUltimoLogin(ultimoLogin);
    }

    dateAux = rs.getTimestamp("ultimo_cambio_clave");
    if (dateAux != null) {
      Calendar ultimoCambioClave = Calendar.getInstance();
      ultimoCambioClave.setTime(dateAux);
      usuario.setUltimoCambioClave(ultimoCambioClave);
    }

    dateAux = rs.getTimestamp("ultimo_cambio_reintento");
    if (dateAux != null) {
      Calendar ultimoCambioReintento = Calendar.getInstance();
      ultimoCambioReintento.setTime(dateAux);
      usuario.setUltimoCambioReintento(ultimoCambioReintento);
    }

    return usuario;
  }
}
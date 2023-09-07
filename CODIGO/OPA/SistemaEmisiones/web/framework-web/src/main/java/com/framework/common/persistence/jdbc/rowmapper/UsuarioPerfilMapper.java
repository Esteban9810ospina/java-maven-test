/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.persistence.jdbc.rowmapper;

import com.framework.common.domain.Perfil;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Roger Padilla C.
 */
public class UsuarioPerfilMapper extends PerfilMapper {

  @Override
  public Perfil mapRow(ResultSet rs, int rowNum) throws SQLException {
    Perfil perfil = super.mapRow(rs, rowNum);
    boolean proceso = "S".equals(rs.getString("proceso"));
    perfil.setProceso(proceso);
    return perfil;
  }
}

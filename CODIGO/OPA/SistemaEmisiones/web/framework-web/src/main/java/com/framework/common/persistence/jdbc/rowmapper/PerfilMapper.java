/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.persistence.jdbc.rowmapper;

import com.framework.common.domain.Perfil;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Roger Padilla C.
 */
public class PerfilMapper implements RowMapper<Perfil> {

  @Override
  public Perfil mapRow(ResultSet rs, int rowNum) throws SQLException {
    Perfil perfil = new Perfil();
    perfil.setId(rs.getInt("id"));
    perfil.setAuthority(rs.getString("nombre"));
    return perfil;
  }
}

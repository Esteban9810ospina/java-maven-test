/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.persistence.jdbc.rowmapper;

import com.framework.common.domain.OpcionModulo;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Roger Padilla C.
 */
public class OpcionModuloMapper implements RowMapper<OpcionModulo> {

  private PaginaMapper paginaMapper = new PaginaMapper();

  @Override
  public OpcionModulo mapRow(ResultSet rs, int rowNum) throws SQLException {

    // Opcion Modulo
    OpcionModulo opcionModulo = new OpcionModulo();
    opcionModulo.setId(rs.getInt("opm_id"));
    opcionModulo.setPerfilId(rs.getInt("perfil_id"));
    opcionModulo.setNombre(rs.getString("opm_nombre"));
    opcionModulo.setOpcionDepende((Integer)rs.getObject("opm_padre"));
    opcionModulo.setOrden(rs.getInt("opm_orden"));
    opcionModulo.setPagina(paginaMapper.mapRow(rs, rowNum));
    return opcionModulo;
  }
}

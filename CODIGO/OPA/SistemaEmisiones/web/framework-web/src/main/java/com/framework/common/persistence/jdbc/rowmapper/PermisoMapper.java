package com.framework.common.persistence.jdbc.rowmapper;

import com.framework.common.domain.Permiso;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Roger Padilla C.
 */
public class PermisoMapper implements RowMapper<Permiso> {

  private OpcionModuloMapper opcionModuloMapper = new OpcionModuloMapper();

  @Override
  public Permiso mapRow(ResultSet rs, int rowNum) throws SQLException {

    // Permiso
    Calendar permHorainicio = Calendar.getInstance();
    permHorainicio.setTime(rs.getDate("perm_hora_inicio"));
    Calendar permHoraFin = Calendar.getInstance();
    permHoraFin.setTime(rs.getDate("perm_hora_fin"));
    Permiso permiso = new Permiso();
    permiso.setId(rs.getInt("perm_id"));
    permiso.setPerfilId(rs.getInt("perfil_id"));
    permiso.setHoraInicio(permHorainicio);
    permiso.setHoraFin(permHoraFin);

    // OpcionModulo
    permiso.setOpcionModulo(opcionModuloMapper.mapRow(rs, rowNum));

    return permiso;
  }
}
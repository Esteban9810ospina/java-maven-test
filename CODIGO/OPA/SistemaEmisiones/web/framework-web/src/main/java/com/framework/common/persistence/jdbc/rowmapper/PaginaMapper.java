/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.persistence.jdbc.rowmapper;

import com.framework.common.domain.Pagina;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Roger Padilla C.
 */
public class PaginaMapper  implements RowMapper<Pagina> {

  @Override
  public Pagina mapRow(ResultSet rs, int rowNum) throws SQLException {

    // Pagina
    Pagina pagina = new Pagina();
    pagina.setId(rs.getInt("pag_id"));
    pagina.setNombre(rs.getString("pag_nombre"));
    pagina.setSubtitulo(rs.getString("pag_subtitulo"));

    return pagina;
  }

}

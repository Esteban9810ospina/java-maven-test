package com.framework.common.persistence.jdbc.rowmapper;

import com.framework.common.domain.UsuarioReporte;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author kgarcia_sophos
 */
public class UsuarioReporteMapper implements RowMapper<UsuarioReporte>{

    @Override
    public UsuarioReporte mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        UsuarioReporte usuario = new UsuarioReporte();
        usuario.setNombres(rs.getString("nombres"));
        usuario.setApellidos(rs.getString("apellidos"));
        usuario.setScb(rs.getString("scb"));
        usuario.setUsername(rs.getString("login"));
        usuario.setPerfil(rs.getString("perfil"));
        usuario.setEstado(rs.getString("estado"));
        usuario.setEmail(rs.getString("email"));
        usuario.setTelefono(rs.getString("telefono"));
        return usuario;
        
    }

}

/*
 * Informacion de Valoracion framework, Bolsa de Valores de Colombia BVC
 * Copyright (C) 2012 Quasar Software Ltda.
 */
package com.framework.common.service.security;

import com.quasar.frameq.exception.FrameworkNegocioException;
import com.framework.common.domain.OpcionModulo;
import com.framework.common.domain.Perfil;
import com.framework.common.domain.Usuario;
import com.framework.common.persistence.jdbc.rowmapper.OpcionModuloMapper;

import com.framework.common.service.AbstractServiceDao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alejandro Riveros Cruz
 */
@Service
public class OpcionModuloServiceImpl extends AbstractServiceDao implements OpcionModuloService {

    private static final String DEF_OPCION_MODULO_QUERY
            = "SELECT perm.i_perfil perfil_id,"
            + " opm.i_opcionmodulo opm_id, opm.c_nombre opm_nombre, opm.i_opciondepende opm_padre,"
            + " opm.i_orden opm_orden,"
            + " pag.i_codigopagina pag_id, pag.c_nombre pag_nombre, pag.c_subtitulo pag_subtitulo"
            + " FROM fqs_permiso perm"
            + " INNER JOIN fqs_opcionmodulo opm ON perm.i_opcionmodulo = opm.i_opcionmodulo AND opm.i_estado = 1"
            + " INNER JOIN fqs_pagina pag ON opm.i_codigopagina = pag.i_codigopagina"
            + " ORDER BY opm_orden";

    private static final String DEF_OPCION_MODULO_BY_PROCESO_QUERY
            = "SELECT opm.i_opcionmodulo opm_id, opm.c_nombre opm_nombre,pag.i_codigopagina pag_id,"
            + " opm.i_opciondepende opm_padre, opm.i_orden opm_orden,opp.i_numveces num_vec"
            + " FROM fqs_opcionmodulo opm"
            + " INNER JOIN fqs_opcionprocesos opp ON opp.i_opcionmodulo = opm.i_opcionmodulo"
            + " WHERE opp.i_proceso = ?";

    private static final String DEF_ONE_OPCION_MODULO_BY_PROCESO_QUERY
            = "SELECT opm.i_opcionmodulo opm_id, opm.c_nombre opm_nombre,pag.i_codigopagina pag_id,"
            + " opm.i_opciondepende opm_padre, opm.i_orden opm_orden,opp.i_numveces num_vec"
            + " FROM fqs_opcionmodulo opm"
            + " INNER JOIN fqs_opcionprocesos opp ON opp.i_opcionmodulo = opm.i_opcionmodulo"
            + " INNER JOIN fqs_pagina pag ON opm.i_codigopagina = pag.i_codigopagina"
            + " WHERE opp.i_proceso = ?";

    @Override
    public Map<Integer, OpcionModulo> findOpcionesModulosMap() {
        Map<Integer, OpcionModulo> opMap = new HashMap<Integer, OpcionModulo>();

        for (OpcionModulo opcionModulo : findOpcionesModulos()) {
            opMap.put(opcionModulo.getId(), opcionModulo);
        }

        return opMap;
    }

    @Override
    public List<OpcionModulo> findOpcionesModulos() {
        return getJdbcTemplate().query(DEF_OPCION_MODULO_QUERY, new OpcionModuloMapper());
    }

    @Override
    public OpcionModulo findOpcionesModulosByProceso(int procesoId) {
        try {
            return getJdbcTemplate().queryForObject(DEF_OPCION_MODULO_BY_PROCESO_QUERY, new Object[]{procesoId}, new OpcionModuloMapper());
        } catch (EmptyResultDataAccessException ex) {
            throw new FrameworkNegocioException(getMessage("error.opcion_modulo_not_found"), ex);
        }
    }

    @Override
    public OpcionModulo findOpcionModuloByPagina(Class<?> pagina) {
        for (OpcionModulo opcionModulo : findOpcionesModulos()) {
            if (pagina.getName().equals(opcionModulo.getPagina().getNombre())) {
                return opcionModulo;
            }
        }
        throw new FrameworkNegocioException(getMessage("error.opcion_modulo_not_found"));
    }

    /**
     * Loads authorities by executing the SQL from
     * <tt>groupAuthoritiesByUsernameQuery</tt>.
     *
     * @return a list of GrantedAuthority objects for the user
     */
    @Override
    public List<Perfil> findPerfilesOpcionesModulo(Usuario usuario) {

        List<Perfil> perfiles = usuario.getAuthorities();

        List<OpcionModulo> opcionesModulo
                = getJdbcTemplate().query(DEF_OPCION_MODULO_QUERY, new OpcionModuloMapper());

        for (Perfil perfil : perfiles) {
            perfil.setOpcionesModulo(new ArrayList<OpcionModulo>());
            for (OpcionModulo opcionModulo : opcionesModulo) {
                if (opcionModulo.getPerfilId().equals(perfil.getId())) {
                    perfil.getOpcionesModulo().add(opcionModulo);
                }
            }
        }

        return perfiles;
    }
}

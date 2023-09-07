/*
 * Informacion de Valoracion framework, Bolsa de Valores de Colombia BVC
 * Copyright (C) 2012 Quasar Software Ltda.
 */
package com.framework.common.service.security;

import com.framework.common.domain.OpcionModulo;
import com.framework.common.domain.Perfil;
import com.framework.common.domain.Usuario;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Alejandro Riveros Cruz
 */
public interface OpcionModuloService {

  Map<Integer, OpcionModulo> findOpcionesModulosMap();

  List<OpcionModulo> findOpcionesModulos();

  OpcionModulo findOpcionesModulosByProceso(int procesoId);

  List<Perfil> findPerfilesOpcionesModulo(Usuario usuario);

  OpcionModulo findOpcionModuloByPagina(Class<?> pagina);
}

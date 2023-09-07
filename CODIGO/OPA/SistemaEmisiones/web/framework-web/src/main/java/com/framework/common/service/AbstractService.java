/*
 * Información de Valoración framework, Bolsa de Valores de Colombia BVC
 * Copyright (C) 2012 Quasar Software Ltda.
 */
package com.framework.common.service;

import com.quasar.frameq.db.AppConfigParams;
import com.framework.common.domain.Usuario;
import java.io.Serializable;
import java.util.Locale;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author Roger Padilla C.
 */
public abstract class AbstractService implements Serializable {

  protected final Logger logger = LoggerFactory.getLogger(getClass());
  protected final AppConfigParams appConfigParams = AppConfigParams.getInstance();

  @Resource
  protected MessageSource messages;

  protected String getMessage(String code, Object... args) {
    return messages.getMessage(code, args, Locale.ROOT);
  }

  protected String getMessage(String code) {
    return getMessage(code, (Object[]) null);
  }

  public Usuario getUsuarioAutenticado() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Usuario usuario = null;
    if (authentication != null) {
      usuario = (Usuario) authentication.getPrincipal();
    }
    return usuario;
  }
}

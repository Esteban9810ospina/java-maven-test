/*
 * Información de Valoración framework, Bolsa de Valores de Colombia BVC
 * Copyright (C) 2012 Quasar Software Ltda.
 */
package com.framework.common.service.security;

import edu.vt.middleware.password.*;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

/**
 *
 * @author robert
 */
@Configurable(preConstruction = true)
public class HistoryRuleQuasar extends AbstractDigester implements Rule {

  /**
   * Error code for history violation.
   */
  public static final String ERROR_CODE = "HISTORY_VIOLATION";
  @Autowired
  private MyUserDetailsService myUserDetailsService;

  @Override
  public RuleResult validate(PasswordData passwordData) {
    final RuleResult result = new RuleResult(true);
    final int size = passwordData.getPasswordHistory().size();
    if (size == 0) {
      return result;
    }

    final String cleartext = passwordData.getPassword().getText();
    for (String previousPassword : passwordData.getPasswordHistory()) {
      if (myUserDetailsService.isPasswordValid(previousPassword, cleartext, passwordData.getUsername())) {
        result.setValid(false);
        result.getDetails().add(
                new RuleResultDetail(
                ERROR_CODE, createRuleResultDetailParameters(size)));
      }
    }
    return result;
  }

  /**
   * Creates the parameter data for the rule result detail.
   *
   * @param size of the history list
   *
   * @return map of parameter name to value
   */
  protected Map<String, ?> createRuleResultDetailParameters(final int size) {
    final Map<String, Object> m = new LinkedHashMap<String, Object>();
    m.put("historySize", size);
    return m;
  }
}
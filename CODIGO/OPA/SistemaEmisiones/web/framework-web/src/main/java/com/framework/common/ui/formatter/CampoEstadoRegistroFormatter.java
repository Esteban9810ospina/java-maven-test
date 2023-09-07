package com.framework.common.ui.formatter;

import com.framework.reportEngine.formatter.CampoFormatter;
import java.util.Map;

/**
 *
 * @author Roger Padilla C.
 */
public class CampoEstadoRegistroFormatter implements CampoFormatter {

  @Override
  public String format(String campo, Map<String, Object> row) {
    String val = (String) row.get(campo);
    if ("A".equals(val)) {
      return "Activo";
    }
    if ("I".equals(val)) {
      return "Inactivo";
    }
    if ("S".equals(val)) {
      return "Si";
    }
    if ("N".equals(val)) {
      return "No";
    }
    return val;
  }
}

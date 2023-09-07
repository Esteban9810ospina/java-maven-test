/*
 * Informacion de Valoracion framework, Bolsa de Valores de Colombia BVC
 * Copyright (C) 2012 Quasar Software Ltda.
 */
package com.framework.common.ui.formatter;

import com.quasar.frameq.util.DateUtil;
import com.framework.reportEngine.formatter.CampoFormatter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * @author Carlos Uribe [curibe@quasarbi.com]
 */
public class CampoTimingFormatter implements CampoFormatter {

  private String startTimeFieldName;
  private String endTimeFieldName;

  public CampoTimingFormatter(String startTimeFieldName, String endTimeFieldName) {
    this.startTimeFieldName = startTimeFieldName;
    this.endTimeFieldName = endTimeFieldName;
  }

  @Override
  public String format(String campo, Map<String, Object> row) {
    Object start = row.get(startTimeFieldName);
    Object end = row.get(endTimeFieldName);

    Date startTime = new Date();
    Date endTime = new Date();

    if (start instanceof String) {
      String startData = (String) start;
      startTime = DateUtil.parseDateTime(startData);
    } else if (start instanceof Timestamp) {
      startTime = (Timestamp) start;
    }

    if (start instanceof String) {
      String endData = (String) end;
      endTime = DateUtil.parseDateTime(endData);
    } else if (start instanceof Timestamp) {
      endTime = (Timestamp) end;
    }

    long millis = endTime.getTime() - startTime.getTime();
    int seconds = (int) (millis / 1000) % 60;
    int minutes = (int) ((millis / (1000 * 60)) % 60);
    int hours = (int) ((millis / (1000 * 60 * 60)) % 24);

    return String.format("%d h, %d min, %d seg",
            hours < 0 ? 0 : hours,
            minutes < 0 ? 0 : minutes,
            seconds < 0 ? 0 : seconds);
  }
}

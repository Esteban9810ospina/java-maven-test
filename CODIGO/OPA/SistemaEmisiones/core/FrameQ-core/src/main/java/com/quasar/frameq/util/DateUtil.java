package com.quasar.frameq.util;

import com.quasar.frameq.exception.FrameworkSistemaException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Wrapper class for date-string formatting facilities.
 *
 * @author Roger Padilla C.
 * @author Carlos Uribe [curibe@quasarbi.com]
 */
public class DateUtil {

  public static final String YYYY_MM_DD = "yyyy-MM-dd";
  public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
  public static final String HUMAN_FULL = "EEEE d 'de' MMMMM 'de' yyyy hh:mm:ss a";
  private static final Map<String, DateFormat> dateFormatMap = new HashMap<String, DateFormat>();
  private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

  // Private constructor prevents instantiation from other classes
  static {
    dateFormatMap.put(YYYY_MM_DD, new SimpleDateFormat(YYYY_MM_DD));
    dateFormatMap.put(YYYY_MM_DD_HH_MM_SS, new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS));
    dateFormatMap.put(HUMAN_FULL, new SimpleDateFormat(HUMAN_FULL, new Locale("es", "CO")));
  }

  private DateUtil() {
  }

  public static Date currentDate() {
    return Calendar.getInstance().getTime();
  }

  public static String currentDateAsString() {
    return formatDateAsString(currentDate());
  }

  /**
   * Format the current time as {@link String}.
   *
   * @return a date-time string formatted as yyyy-MM-dd HH:mm:ss.
   * @see formatDateTimeAsString(Date)
   */
  public static String currentDateAsDateTimeString() {
    return formatDateTimeAsString(currentDate());
  }

  /**
   * Format the specified time as {@link String}.
   *
   * @param fecha a {@link Date} object.
   * @return a date-time string formatted as yyyy-MM-dd HH:mm:ss.
   */
  public static String formatDateTimeAsString(Date fecha) {
    return dateFormatMap.get(YYYY_MM_DD_HH_MM_SS).format(fecha);
  }

  /**
   * Format the specified calendar object as {@link String}.
   *
   * @param fecha a {@link Calendar} object.
   * @return a string formatted as EEEE d.MMMMM.yyyy hh:mm:ss a.
   * @see formatAsHumanFull(Date)
   */
  public static String formatAsHumanFull(Calendar fecha) {
    return formatAsHumanFull(fecha.getTime());
  }

  /**
   * Format the specified date object as {@link String}.
   *
   * @param fecha a {@link Date} object.
   * @return a string formatted as EEEE d.MMMMM.yyyy hh:mm:ss a.
   */
  public static String formatAsHumanFull(Date fecha) {
    return dateFormatMap.get(HUMAN_FULL).format(fecha);
  }

  /**
   * Format the specified date object as {@link String}.
   *
   * @param date a {@link Date} object.
   * @return a string formatted as yyyy-MM-dd.
   * @see parseDate(Date, String)
   */
  public static String formatDateAsString(Date date) {
    return parseDate(date, YYYY_MM_DD);
  }

  /**
   * Format the specified date object as {@link String}.
   *
   * @param date a {@link Date} object.
   * @return a string formatted as yyyy-MM-dd.
   * @see parseDate(Date, String)
   */
  public static String formatDateAsString(Date date, String defaultValue) {
    if (date != null) {
     return parseDate(date, YYYY_MM_DD);
    }
    return defaultValue;
  }

  /**
   * Format the specified date object as {@link String}.
   *
   * @param date a {@link Date} object.
   * @return a string formatted as yyyy-MM-dd.
   * @see parseDate(Date, String)
   */
  public static String formatDateAsString(Date date, Date defaultValue) {
    if (date != null) {
     return parseDate(date, YYYY_MM_DD);
    }
    if (defaultValue == null) {
      return null;
    }
    return formatDateAsString(defaultValue);
  }

  /**
   * Format a calendar object into a specified pattern or format.
   *
   * @param calendar a {@link Calendar} object.
   * @param pattern date format used for string conversion.
   * @return a pattern-based formatted {@link String}.
   * @see parseDate(Date, String)
   */
  public static String parseDate(Calendar calendar, String pattern) {
    return parseDate(calendar.getTime(), pattern);
  }

  /**
   * Format a date object into a specified pattern or format.
   *
   * @param date a {@link Date} object.
   * @param pattern date format used for string conversion.
   * @return a pattern-based formatted {@link String}.
   */
  public static String parseDate(Date date, String pattern) {
    DateFormat dateFormat;
    if ((dateFormat = dateFormatMap.get(pattern)) == null) {
      dateFormat = new SimpleDateFormat(pattern);
    }
    return dateFormat.format(date);
  }

  /**
   * Parse a date string building a {@link Date} object.
   *
   * @param date a {@link String} object containing a date.
   * @return a new {@link Date} parsed object.
   */
  public static Date parseDate(String date) {
    try {
      return dateFormatMap.get(YYYY_MM_DD).parse(date);
    } catch (ParseException ex) {
      logger.error(ex.getMessage(),ex);
      throw new FrameworkSistemaException(ex.getMessage(), ex);
    }
  }

  public static Date parseDateTime(String date) {
    try {
      return dateFormatMap.get(YYYY_MM_DD_HH_MM_SS).parse(date);
    } catch (ParseException ex) {
      logger.error(ex.getMessage(),ex);
      throw new FrameworkSistemaException(ex.getMessage(), ex);
    }
  }

  /**
   * Parse a date string building a {@link Date} object.
   *
   * @param date a {@link String} object containing a date.
   * @return a new {@link Date} parsed object.
   */
  public static java.sql.Date parseAsDateSql(String date) {
    if (date == null || "0000-00-00".equals(date) || date.equals("")) {
      return null;
    }
    return java.sql.Date.valueOf(date);
  }

  public static String parseAsTimeStamp(String timestamp) {
    if (timestamp != null) {
      if (timestamp.trim().isEmpty()) {
        return "1970-01-01:00:00:00.000000";
      }
      if (timestamp.startsWith("0001")) {
        timestamp = "1970" + timestamp.substring(4, timestamp.length());
      }
    }
    return timestamp;
  }

}

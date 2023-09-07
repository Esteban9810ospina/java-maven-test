/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quasar.frameq.util;

import java.text.Normalizer;
import java.util.regex.Pattern;

/**
 *
 * @author Roger Padilla C.
 */
public class StringUtil {

  private static Pattern textNormalizerPattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

  private StringUtil() {
  }

  public static String unAccent(String name) {
    String temp = Normalizer.normalize(name, Normalizer.Form.NFD);
    temp = textNormalizerPattern.matcher(temp).replaceAll("");
    return temp;
  }

  public static boolean isNotEmpty(String str) {
    return str != null && !"".equals(str);
  }

  public static String repeat(String str, int num) {
    int len = num * str.length();
    StringBuilder sb = new StringBuilder(len);
    for (int i = 0; i < num; ++i) {
      sb.append(str);
    }
    return sb.toString();
  }
}

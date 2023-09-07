/*
 * Informacion de Valoracion framework, Bolsa de Valores de Colombia BVC
 * Copyright (C) 2012 Quasar Software Ltda.
 */
package com.framework.common.ui.content.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Alejandro Riveros Cruz
 */
public class RegexArchivosFilter implements FilenameFilter {

  private Pattern pattern;

  public RegexArchivosFilter(String regexStr) {
    this.pattern = Pattern.compile(regexStr);
  }
  



  @Override
  public boolean accept(File dir, String name) {

    String ext = name.substring(name.length() - 3, name.length());
    Matcher matcher = pattern.matcher(ext);
    File tempFile = new File(dir, name);
    if (name.startsWith(".") || tempFile.isDirectory()) {
      return false;
    } else if((name.substring(name.length()-4, name.length()-3)).equals(".")){//if (matcher.find()) {
      return true;
    }
    return false;
  }
}

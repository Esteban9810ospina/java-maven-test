package com.framework.common.ui.content.util;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Informacion de Valoracion framework, Bolsa de Valores de Colombia BVC
 * Copyright (C) 2012 Quasar Software Ltda.
 */


 /*
 * @author Diana Quiroga [dquiroga@quasarbi.com]
 * Filtar el luistado de los archivos y sólo tomas los que comiencen por 'nombre' , que es el parámtro que se envía
 */

public class RegexArchivosFilterName implements FilenameFilter {

  String nombre;

    public RegexArchivosFilterName(String nombre){
        this.nombre=nombre;
    }

    @Override
    public boolean accept(File dir, String name){
        return name.startsWith(nombre);
    }
}


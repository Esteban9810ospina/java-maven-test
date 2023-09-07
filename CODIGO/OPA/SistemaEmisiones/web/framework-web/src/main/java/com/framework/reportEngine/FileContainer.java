/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.reportEngine;

//import com.bvc.spivi.exception.InfovalmerNegocioException;
//import com.bvc.spivi.util.DateUtil;
//import com.infovalmer.common.ui.GenericTab;
//import com.infovalmer.common.ui.content.GenericContent;
//import com.infovalmer.common.ui.form.DateFieldButtonForm;
//import com.infovalmer.common.ui.formatter.CampoTipoArchivoAccionesFormatter;

import com.framework.reportEngine.formatter.CampoTipoArchivoFormatter;
import com.vaadin.server.FileResource;
//import com.vaadin.Application;
//import com.vaadin.terminal.FileResource;
import com.vaadin.ui.Link;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 * Consulta Archivos Cargados
 * 
* @author Edison Tarquino [etarquino@quasarbi.com]
 */

public class FileContainer {

    //private DateFieldButtonForm dateFieldButtonForm;
    String ubicacion="";
    UI app;
    
    public FileContainer(String ubicacion, UI app) {
        this.app=app;
        this.ubicacion=ubicacion;
    }
    
    public Table procesar( ) throws Exception{
        File path = new File(ubicacion);
        Table miTabla;
        if (path.exists()) {
            miTabla=buildTable(path);
        } else {
            throw new Exception("error.files_not_found");
        }
        return miTabla;
    }


    private Table buildTable(File path) {
        Table fileTable = new Table("Archivos : " );
        fileTable.addContainerProperty("Archivo", Link.class, fileTable);
        fileTable.addContainerProperty("Interfaz", String.class, fileTable);
        fileTable.addContainerProperty("Tama&ntilde;o", String.class, fileTable);
        fileTable.addContainerProperty("Modificado", Date.class, fileTable);
        fileTable.setPageLength(path.listFiles().length);
        int idx = 0;
        String start;
        String description;
        Link fileLink;
        File[] fileList = path.listFiles();
   Arrays.sort(fileList, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                int n1 = extractNumber(o1.getName());
                int n2 = extractNumber(o2.getName());
                return n1 - n2;
            }

            private int extractNumber(String name) {
                int i = 0;
                try {
                    int s = name.indexOf('_')+1;
                    int e = name.lastIndexOf('.');
                    String number = name.substring(s, e);
                    i = Integer.parseInt(number);
                } catch(Exception e) {
                    i = 0; // if filename does not match the format
                           // then default to 0
                }
                return i;
            }
        });
        for (File file :fileList) {
            start = file.getName().substring(0, 1).toUpperCase();
            description = new CampoTipoArchivoFormatter().format(start, null);
            fileLink = new Link(file.getName(), new FileResource(file));
            fileTable.addItem(new Object[]{fileLink, description, file.length() + "Bytes", new Date(file.lastModified())}, ++idx);
        }
        //dateFieldButtonForm.setContent(fileTable);
        return fileTable;
    }
    
}

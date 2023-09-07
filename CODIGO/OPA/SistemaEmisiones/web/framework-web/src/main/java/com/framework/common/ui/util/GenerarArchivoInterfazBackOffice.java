/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.ui.util;

import com.quasar.frameq.db.Facade;
import com.quasar.frameq.interfaces.InterfazBackOffice;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import com.framework.common.ui.util.wsclient.*;
import com.framework.common.ui.util.wsclient.UtilUploadIdrClient;
import com.framework.common.ui.util.wsclient.dto.FileUpload;
import com.framework.common.ui.util.wsclient.dto.FileUploadRequest;
import com.framework.common.ui.util.wsclient.dto.FileUploadResponse;
import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Level;

/**
 * @author Cristian
 */
public class GenerarArchivoInterfazBackOffice {
    private static final Logger logger = Logger.getLogger(GenerarArchivoInterfazBackOffice.class.getName());
    InterfazBackOffice interfaz = new InterfazBackOffice();
    Facade fachada = new Facade();
    Properties propiedades = new Properties();
    Calendar cal = Calendar.getInstance();
    String rutaCargue = fachada.rutaIDRD();
    
    public void CrearArchivoIDR() {
        try {
            propiedades.load(new FileReader("/apps/OPA/properties/bloquesIDR.properties"));
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(GenerarArchivoInterfazBackOffice.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(GenerarArchivoInterfazBackOffice.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        int vecesIDR = 0;
        int mod = 0;
        int ayudabloque = 0;
        int blockSize = Integer.parseInt(propiedades.getProperty("BLOCKSIZE","5000"));
        int timeSleep = Integer.parseInt(propiedades.getProperty("TIMESLEEP","300"));
        
        List<List<String>> adjudicaciones = new ArrayList<List<String>>();
        adjudicaciones = interfaz.AdjudicacionesInterfaz();
        Iterator myIterator=adjudicaciones.iterator();
        if (myIterator.hasNext()) {
            List myList=(List)myIterator.next();
            mod = myList.size() % blockSize;
            if (mod == 0) {
                vecesIDR = myList.size() / blockSize;
            } else {
                vecesIDR = myList.size() / blockSize + 1;
            }
        } else {
            mod=0;
            vecesIDR = 0;
        }
        
        Calendar myCalendar=new GregorianCalendar();
        SimpleDateFormat dt = new SimpleDateFormat("yyyyMMdd");
        BufferedWriter bw = null;
        try {
            for (int k = 0; k < vecesIDR; k++) {
                int seq = interfaz.ObtenerSecuenciaIDR();
                File idr = new File(rutaCargue + "//IDR_" + dt.format(new Date(myCalendar.getTimeInMillis())) + seq + ".txt");
                bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(idr)));
                if (adjudicaciones.get(0).size() > 0) {
                    for (int i = ayudabloque; i < ayudabloque + blockSize; i++) {
                        if (i >= adjudicaciones.get(0).size()) {
                            break;
                        }
                        String CurrentLine = "";
                        String tipoDoc = "";
                        for (int j = 0; j < 25; j++) {
                            if (j == 2)
                                CurrentLine += adjudicaciones.get(j).get(i).replace(".", ",");
                            else if (j == 11 || j == 17) {
                                tipoDoc = convertirTipoDoc(adjudicaciones.get(j).get(i));
                                CurrentLine += tipoDoc;
                            } else {
                                if (j == 12 || j == 18) {
                                    if (tipoDoc.equals("N"))
                                        CurrentLine += String.format("%1$-15s", adjudicaciones.get(j).get(i) + "-" + adjudicaciones.get(j + 1).get(i));
                                    else
                                        CurrentLine += String.format("%1$-15s", adjudicaciones.get(j).get(i));
                                    j++;
                                } else
                                    CurrentLine += adjudicaciones.get(j).get(i);
                            }
                        }
                        bw.write(CurrentLine);
                        bw.newLine();
                    }
                    
                }
                bw.close();
                ayudabloque += blockSize;
                this.cargarArchivoS3(idr);
                if(vecesIDR > 1)
                {
                    try {
                    //Ponemos a "Dormir" el programa durante los ms que sea requerido
                    Thread.sleep(timeSleep*1000);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            logger.error("OPA - " + GenerarArchivoInterfazBackOffice.class.getName(), ex);
        } catch (IOException ex) {
            logger.error("OPA - " + GenerarArchivoInterfazBackOffice.class.getName(), ex);
        } finally {
            try {
                if (bw != null)bw.close();
            } catch (IOException ex) {
                logger.error("OPA - " + GenerarArchivoInterfazBackOffice.class.getName(), ex);
            }
        }
    }
    
    public String convertirTipoDoc(String tipo) {
        String doc = fachada.devolverLetraDocumento(Integer.parseInt(tipo));
        if (doc.equals("Cédula de Ciudadanía"))
            return "C";
        else if (doc.equals("Cédula de Extranjería"))
            return "E";
        else if (doc.equals("Pasaporte"))
            return "P";
        else if (doc.equals("NIT"))
            return "N";
        else if (doc.equals("NIP o NUIP"))
            return "I";
        else if (doc.equals("Tarjeta de Identidad"))
            return "T";
        else
            return "";
    }

    public void cargarArchivoS3(File idr) {
        try{
            String path = idr.getAbsolutePath().replace("\\", "/");
            UtilUploadIdrClient utilUploadIdrClient = new UtilUploadIdrClient();
            FileUploadRequest request = new FileUploadRequest();
            FileUpload fileUpload = new FileUpload();
            fileUpload.setPath(path);
            request.setFileUpload(fileUpload);
            FileUploadResponse FileUploadResponse = utilUploadIdrClient.uploadFile(request);
            String[] vpat = path.split("/");            
            logger.info("OPA - "+GenerarArchivoInterfazBackOffice.class.getName()+" Carga del archivo "+ vpat[vpat.length-1] +"  "+FileUploadResponse.toString());
        }catch(Exception e){
            logger.error("OPA - " + GenerarArchivoInterfazBackOffice.class.getName(), e);
        }        
    }
}
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
import java.util.Calendar;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * El nombre generico del archivo será: OBBCCMMDD.XXX Donde :	O	Constante
 * (O=Operaciones) BB Es el código de la Bolsa Valores de Colombia (90) CC
 * Consecutivo de archivo, que comienza en CERO-UNO (01) MM Mes de Proceso o
 * Generación DD Día de Proceso o Generación XXX Es un consecutivo de envio, que
 * comienza en CERO-UNO (01) Nota: Los consecutivos "CC" y ".XXX" del nombre, se
 * iran incrementado en uno, cada vez que se realiza una nueva adjduciación
 * diaria, ademas deben reiniciar y volver a empezar en "01" y "001"
 * respectivamente, al dia siguiente.
 *
 *
 * @author Catherine
 */
public class GenerarArchivoInterfaz20 {
    private static final Logger logger = Logger.getLogger(GenerarArchivoInterfaz20.class.getName());


    InterfazBackOffice interfaz = new InterfazBackOffice();
    Facade fachada = new Facade();
    Calendar cal = Calendar.getInstance();
    String rutaCargue = fachada.rutaI20();

    public void CrearArchivoI20() {
        PropertyConfigurator.configure("/apps/OPI/logs/opi-log4j.properties");
        
        int vecesI20 = 0;
        int mod = 0;
        int ayudabloque = 0;

        List<List<String>> adjudicaciones = new ArrayList<List<String>>();
        adjudicaciones = interfaz.AdjudicacionesI20();
        Iterator myIterator = adjudicaciones.iterator();
        if (myIterator.hasNext()) {
            List myList = (List) myIterator.next();
            mod = myList.size() % 5000;
            if (mod == 0) {
                vecesI20 = myList.size() / 5000;
            } else {
                vecesI20 = myList.size() / 5000 + 1;
            }
        } else {
            mod = 0;
            vecesI20 = 0;
        }

        Calendar myCalendar = new GregorianCalendar();
        SimpleDateFormat dt = new SimpleDateFormat("MMdd");
        BufferedWriter bw = null;
        try {
            for (int k = 0; k < vecesI20; k++) {
                int seq = interfaz.ObtenerSecuenciaI20();
                File idr = new File(rutaCargue + "//O90" + "01" + dt.format(new Date(myCalendar.getTimeInMillis())) +"."+ String.format("%03d", seq));
                //File idr = new File(rutaCargue + "//O90" + "01" + dt.format(new Date(myCalendar.getTimeInMillis())) + String.format("%03d", seq) + ".txt");
                //System.out.println("archivo nombre: " + idr.getName());
                bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(idr)));
                if (adjudicaciones.get(0).size() > 0) {
                    for (int i = ayudabloque; i < ayudabloque + 5000; i++) {
                        if (i >= adjudicaciones.get(0).size()) {
                            break;
                        }
                        String CurrentLine = "";
                        String tipoDoc = "";
                        for (int j = 0; j <= 32; j++) {

                             if (j == 3) {
                                tipoDoc = convertirTipoDoc(Integer.parseInt(adjudicaciones.get(j).get(i)));
                                CurrentLine += tipoDoc;
                            }
                            else{
                                CurrentLine += adjudicaciones.get(j).get(i);
                            }
                        }
                        bw.write(CurrentLine);
                        bw.newLine();
                    }

                }
                bw.close();
                ayudabloque += 5000;
            }
        } catch (FileNotFoundException ex) {
            logger.error("OPI - "+GenerarArchivoInterfaz20.class.getName(), ex);
        } catch (IOException ex) {
            logger.error("OPI - "+GenerarArchivoInterfaz20.class.getName(), ex);
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException ex) {
                logger.error("OPI - "+GenerarArchivoInterfaz20.class.getName(), ex);
            }
        }
    }

    public String convertirTipoDoc(int tipo) {
        switch (tipo) {
            case 1:
                return "1";
            case 2:
                return "5";
            case 3:
                return "6";
            case 4:
                return "2";
            case 5:
                return "4";
            case 6:
                return "3";
        }
        return "";
    }
}

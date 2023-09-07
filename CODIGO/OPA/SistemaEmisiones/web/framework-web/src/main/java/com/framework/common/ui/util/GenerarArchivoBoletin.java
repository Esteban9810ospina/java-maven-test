package com.framework.common.ui.util;

import com.quasar.frameq.data.BulletinReport;
import com.quasar.frameq.db.Facade;
import com.quasar.frameq.interfaces.InterfazBackOffice;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class GenerarArchivoBoletin {
    private static final Logger logger = Logger.getLogger(GenerarArchivoBoletin.class.getName());
    static List<String> parametros1 = null;
    static String tipoOfertaPublica = "";
    static String nombreRazonSocial = "";
    static String companyName = "";
    static String accionesEnCirculacion = "";
    static BulletinReport bulletinReport = null;
    static InterfazBackOffice interfaz = new InterfazBackOffice();
    static SimpleDateFormat fd = new SimpleDateFormat("dd MMMMM yyyy");
    static Facade fachada = new Facade();
    static String rutaCargue = fachada.rutaBoletin();
    public static int titleSizeText = 11;
    public static String fuente = "Tahoma";
    public static String txtConsecutive = "";
    public static BigDecimal percentageSharesBd = new BigDecimal("0");
    public static String tituloEspañol = "";
    public static String tituloIngles = "";
    public static String subtituloEspañol = "";
    public static String subtituloIngles = "";
    public static String asuntoEspañol = "";
    public static String asuntoIngles = "";
    public static String textoOperacionEspañol = "";
    public static String textoOperacionIngles = "";
    public static String cierreTxtoperacionEspañol = "";
    public static String cierreTxtoperacionIngles = "";

    
    /*Método que crea los boletines, y los guarda en una carpeta comprimida*/
    public static Boolean generateExcelFile(String txtConsecutiveParam) {
        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        txtConsecutive = txtConsecutiveParam;
        Date d = new Date();
        @SuppressWarnings("UnusedAssignment")
        String nuevoDirectorio = "";
        boolean resp = false;        
        @SuppressWarnings("UnusedAssignment")
        boolean isError = false;
        String month = getMonth();
        try {
            try {
                bulletinReport = InterfazBackOffice.BoletinReporte();
                tipoOfertaPublica = bulletinReport.getTipoOfertaPublica();
                nombreRazonSocial = "Acciones en Circulación* " + bulletinReport.getNombreRazonSocial();
                companyName = "Outstanding Shares* " + bulletinReport.getNombreRazonSocial();
                accionesEnCirculacion = bulletinReport.getOutStandingShares();
                System.out.println(percentageSharesBd);
                try{
                    percentageSharesBd = new BigDecimal(bulletinReport.getPercentageShares()).setScale(2, RoundingMode.DOWN);   
                }catch(Exception ex){
                    percentageSharesBd = new BigDecimal("0").setScale(2, RoundingMode.DOWN);   
                }             
                Properties properties = new Properties();
                Properties utilProperties = new Properties();
                InputStream is = GenerarBoletinPdf.class.getResourceAsStream("/util.properties");
                utilProperties.load(is);
                properties.load(new FileInputStream(new File(utilProperties.getProperty("propiedades.opa"))));  
                String origenBoletin = "";
                if (tipoOfertaPublica.equals("OPA")) {
                    origenBoletin = "opa";
                } else {
                    origenBoletin = "opi";
                }

                tituloEspañol               = properties.getProperty("titulo."+origenBoletin+".espanol");
                subtituloEspañol            = properties.getProperty("subtitulo."+origenBoletin+".espanol");
                asuntoEspañol               = properties.getProperty("asunto."+origenBoletin+".espanol");
                textoOperacionEspañol       = properties.getProperty("txtoperacion."+origenBoletin+".espanol");
                cierreTxtoperacionEspañol   = properties.getProperty("cierreTxtoperacion."+origenBoletin+".espanol");
                
                tituloIngles                = properties.getProperty("titulo."+origenBoletin+".ingles");;                
                subtituloIngles             = properties.getProperty("subtitulo."+origenBoletin+".ingles");
                asuntoIngles                = properties.getProperty("asunto."+origenBoletin+".ingles");                
                textoOperacionIngles        = properties.getProperty("txtoperacion."+origenBoletin+".ingles");             
                cierreTxtoperacionIngles    = properties.getProperty("cierreTxtoperacion."+origenBoletin+".ingles");
               
                correctAccent();
                isError = (bulletinReport == null);
            } catch (IOException e) {
                isError = true;
            }
            if (isError) {
                throw new RuntimeException("No se ha realizado ninguna parametrización");
            }
            String fecha = fd.format(d);
            String[] fecha_split = fecha.split(" ");
            String dia = fecha_split[0];
            String mes = fecha_split[1];
            String anio = fecha_split[2];
            String monthInNumber = getMonthInNumber();
            int dia_switch = Integer.parseInt(dia);
            String bulletinIssue;
            nuevoDirectorio = rutaCargue + "/descargable/boletin_" + anio + "_" + monthInNumber + "_" + dia + "_No_" + txtConsecutive;
            if (createDirectory(nuevoDirectorio)) {
                String creacionBoletin = "N\u00b0 " + txtConsecutive + " Bogotá D.C., " + dia + " de " + mes + " de " + anio;
                String newsletterCreation = "N\u00b0 " + txtConsecutive + " Bogotá D.C., on " + month + " " + dia + ", " + anio;
                String asuntoBoletin = asuntoEspañol.replace("[FECHA]" , dia + " DE " + mes.toUpperCase() + " DE " + anio)+" "+textoOperacionEspañol +" DE "+ bulletinReport.getNombreRazonSocial()+" "+  cierreTxtoperacionEspañol;
                switch(dia_switch){
                    case 1 : bulletinIssue = asuntoIngles.replace("[DATE]" ,  dia + "ST OF " + month.toUpperCase() + " " + anio)+" "+ textoOperacionIngles +" "+ bulletinReport.getNombreRazonSocial() +" "+ cierreTxtoperacionIngles;
                    break;
                    case 2 : bulletinIssue = asuntoIngles.replace("[DATE]" ,  dia + "ND OF " + month.toUpperCase() + " " + anio)+" "+ textoOperacionIngles +" "+ bulletinReport.getNombreRazonSocial() +" "+ cierreTxtoperacionIngles;
                    break;
                    case 3 : bulletinIssue = asuntoIngles.replace("[DATE]" ,  dia + "RD OF " + month.toUpperCase() + " " + anio)+" "+ textoOperacionIngles +" "+ bulletinReport.getNombreRazonSocial() +" "+ cierreTxtoperacionIngles;
                    break;
                    case 21 : bulletinIssue = asuntoIngles.replace("[DATE]" ,  dia + "ST OF " + month.toUpperCase() + " " + anio)+" "+ textoOperacionIngles +" "+ bulletinReport.getNombreRazonSocial() +" "+ cierreTxtoperacionIngles;
                    break;
                    case 22 : bulletinIssue = asuntoIngles.replace("[DATE]" ,  dia + "ND OF " + month.toUpperCase() + " " + anio)+" "+ textoOperacionIngles +" "+ bulletinReport.getNombreRazonSocial() +" "+ cierreTxtoperacionIngles;
                    break;
                    case 23 : bulletinIssue = asuntoIngles.replace("[DATE]" ,  dia + "RD OF " + month.toUpperCase() + " " + anio)+" "+ textoOperacionIngles +" "+ bulletinReport.getNombreRazonSocial() +" "+ cierreTxtoperacionIngles;
                    break;
                    case 31 : bulletinIssue = asuntoIngles.replace("[DATE]" ,  dia + "ST OF " + month.toUpperCase() + " " + anio)+" "+ textoOperacionIngles +" "+ bulletinReport.getNombreRazonSocial() +" "+ cierreTxtoperacionIngles;
                    break;
                    default: bulletinIssue = asuntoIngles.replace("[DATE]" ,  dia + "TH OF " + month.toUpperCase() + " " + anio)+" "+ textoOperacionIngles +" "+ bulletinReport.getNombreRazonSocial() +" "+ cierreTxtoperacionIngles;
                    break;
                }
                String parrafoEnEspañol = bulletinReport.getSpanishNewsletterText();
                String parrafoEnIngles = bulletinReport.getEnglishNewsletterText();
                generateNewsletter(creacionBoletin, asuntoBoletin, parrafoEnEspañol, nuevoDirectorio + "/boletin_" + anio + "_" + monthInNumber + "_" + dia + "_No_" + txtConsecutive + ".xls", "español");
                generateNewsletter(newsletterCreation, bulletinIssue, parrafoEnIngles, nuevoDirectorio + "/bulletin_" + anio + "_" + monthInNumber + "_" + dia + "_No_" + txtConsecutive + ".xls", "ingles");
                /*Generar Boletín en ingles*/
                try {
                    String path = nuevoDirectorio + "/bulletin_" + anio + "_" + monthInNumber + "_" + dia + "_No_" + txtConsecutive+".pdf";
                    String titulo = tituloIngles;
                    String subTitulo = newsletterCreation;
                    String subTitulo2 = subtituloIngles;
                    String textoInformativo = parrafoEnIngles;
                    String asunto = bulletinIssue;
                    String contentCellDescription = "Description";
                    String totalAceptacionesRecibidas1 = "Total Acceptances Received";
                    String totalAceptacionesRecibidas2 = "(Includes acceptances with and without All or Nothing Modality)";
                    String totalAceptacionesRecibidas3 = "Total Acceptances Received under All or Nothing Modality";
                    String numAceptaciones = "Number of Acceptances";
                    String cantAcciones = "Amount of shares";
                    String porcMaxComprar = "Percentage from the maximum to buy";
                    String saldoAcumulado0       = "Previous business day Accumulated balance";
                    String recinidoHoy0          = "Received for today";
                    String saldoAcumuladoCierre0 = "Today accumulated balance";
                    String accinesEnCirculacion0 = companyName;
                    String totalAccinesEnCirculacion0 = "Total shares intended to purchase over outstanding shares";
                    String testoAccionesOrdinarias = "* Outstanding Shares reported on the Offer Booklet.";
                        generateNewsletterInPdf(
                            path,
                            titulo,
                            subTitulo,
                            subTitulo2,
                            textoInformativo,
                            asunto,
                            contentCellDescription,
                            totalAceptacionesRecibidas1,
                            totalAceptacionesRecibidas2,
                            totalAceptacionesRecibidas3,
                            numAceptaciones,
                            cantAcciones,
                            porcMaxComprar,
                            saldoAcumulado0,
                            recinidoHoy0,
                            saldoAcumuladoCierre0,
                            accinesEnCirculacion0,
                            totalAccinesEnCirculacion0,
                            testoAccionesOrdinarias,
                            "SUBJECT:");
                } catch (Exception ex) {
                    logger.error("OPA - " + GenerarArchivoBoletin.class.getName(), ex);
                }                                
                /*Generar Boletín en español*/
                try {
                    String path = nuevoDirectorio + "/boletin_" + anio + "_" + monthInNumber + "_" + dia + "_No_" + txtConsecutive+".pdf";
                    String titulo = tituloEspañol;
                    String subTitulo = creacionBoletin;
                    String subTitulo2 = subtituloEspañol;
                    String textoInformativo = parrafoEnEspañol;
                    String asunto = asuntoBoletin;
                    String contentCellDescription = "Descripción";
                    String totalAceptacionesRecibidas1 = "Total Aceptaciones Recibidas";
                    String totalAceptacionesRecibidas2 = "(Incluye aceptaciones con y sin modalidad todo o nada)";
                    String totalAceptacionesRecibidas3 = "Total Aceptaciones recibidas bajo la modalidad Todo o Nada";
                    String numAceptaciones = "Número de Aceptaciones";
                    String cantAcciones = "Cantidad de Acciones";
                    String porcMaxComprar = "Porcentaje del máximo a comprar";
                    String saldoAcumulado0       = "Saldo acumulado día hábil anterior";
                    String recinidoHoy0          = "Recibido para el día de hoy";
                    String saldoAcumuladoCierre0 = "Saldo acumulado al cierre del día";
                    String accinesEnCirculacion0 = nombreRazonSocial;
                    String totalAccinesEnCirculacion0 = "Total acciones demandadas sobre acciones en circulación";
                    String testoAccionesOrdinarias = "* Acciones Ordinarias en circulación informadas en Cuadernillo de Oferta.";
                        generateNewsletterInPdf(
                            path,
                            titulo,
                            subTitulo,
                            subTitulo2,
                            textoInformativo,
                            asunto,
                            contentCellDescription,
                            totalAceptacionesRecibidas1,
                            totalAceptacionesRecibidas2,
                            totalAceptacionesRecibidas3,
                            numAceptaciones,
                            cantAcciones,
                            porcMaxComprar,
                            saldoAcumulado0,
                            recinidoHoy0,
                            saldoAcumuladoCierre0,
                            accinesEnCirculacion0,
                            totalAccinesEnCirculacion0,
                            testoAccionesOrdinarias,
                            "ASUNTO:");
                } catch (Exception ex) {
                    logger.error("OPA - " + GenerarArchivoBoletin.class.getName(), ex);
                }
                
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    logger.error("OPA - " + GenerarArchivoBoletin.class.getName(), ex);
                }
                
                compressFile(nuevoDirectorio, nuevoDirectorio + ".zip");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    logger.error("OPA - " + GenerarArchivoBoletin.class.getName(), ex);
                }
                
                deleteDirectory(nuevoDirectorio);
                deleteFile(rutaCargue + "/base"+txtConsecutive+"_Boletin.xls");
                deleteFile(rutaCargue + "/base"+txtConsecutive+"_Bulletin.xls");
            }
            resp = true;
        } catch (FileNotFoundException ex) {
            logger.error("OPA - " + GenerarArchivoBoletin.class.getName(), ex);
        } catch (IOException ex) {
            logger.error("OPA - " + GenerarArchivoBoletin.class.getName(), ex);
        }
        return resp;
    }

    /*Método que crea una celda centrada*/
    private static HSSFCellStyle cellTextStyleCenter(HSSFWorkbook wb, HSSFFont font) {
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setFont(font);
        return style;
    }

    /*Método que crea una celda alineada en la parte superior izquierda*/
    private static HSSFCellStyle cellTextStyleTopLeft(HSSFWorkbook wb, HSSFFont font) {
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_JUSTIFY);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        style.setFont(font);
        return style;
    }

     /*Método que crea un estilo de letra*/
    private static HSSFFont fontStyle(HSSFWorkbook wb, int fontSize) {
        HSSFFont font = wb.createFont();
        font.setFontName(fuente);
        font.setFontHeightInPoints((short) fontSize);
        return font;
    }

    /*Método que copia un archivo*/
    public static void copy(String nombreFuente, String nombreDestino) throws IOException {
        java.io.FileInputStream fis = new java.io.FileInputStream(nombreFuente);
        FileOutputStream fos = new FileOutputStream(nombreDestino);
        FileChannel canalFuente = fis.getChannel();
        FileChannel canalDestino = fos.getChannel();
        canalFuente.transferTo(0L, canalFuente.size(), canalDestino);
        fis.close();
        fos.close();
        canalFuente.close();
        canalDestino.close();
    }

    /*Método que crea un directorio*/
    public static boolean createDirectory(String nuevoDir) {
        boolean creado = false;
        try {
            File directorio = new File(nuevoDir);
            if (!directorio.exists()) {
                if (directorio.mkdirs()) {
                    creado = true;
                }
            }
        } catch (Exception e) {
        }
        return creado;
    }

    /*Método que comprime un directorio*/
    @SuppressWarnings("UnusedAssignment")
    public static void compressFile(String srcFolder, String zipFile) {
        try {
            File folder = new File(srcFolder);
            String[] sourceFiles = folder.list();
            byte[] buffer = new byte[1024];
            FileOutputStream fout = new FileOutputStream(zipFile);
            ZipOutputStream zout = new ZipOutputStream(fout);
            for (int i = 0; i < sourceFiles.length; i++) {
                {
                    sourceFiles[i] = srcFolder + "/" + sourceFiles[i];
                    FileInputStream fin = new FileInputStream(sourceFiles[i]);
                    zout.putNextEntry(new ZipEntry(sourceFiles[i].substring(sourceFiles[i].lastIndexOf("/") + 1)));
                    int length;
                    while ((length = fin.read(buffer)) > 0) {
                        zout.write(buffer, 0, length);
                    }
                    zout.closeEntry();
                    fin.close();
                }
            }
            sourceFiles = null;
            zout.close();
            fout.close();
            folder = null;
        } catch (IOException ioe) {
            logger.error("OPA - " + GenerarArchivoBoletin.class.getName(), ioe);
        }
    }

    /*Método que obtiene el nombre mes*/
    public static String getMonth() {
        Calendar fecha = Calendar.getInstance();
        return fecha.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
    }

    
    /*Método que obtiene el nombre de un mes en ingles*/
    public static String getMonthInNumber() {
        Calendar fecha = Calendar.getInstance();
        int month = fecha.get(Calendar.MONTH) + 1;
        String monthReturn = "" + month;
        if (month < 10) {
            monthReturn = "0" + month;
        }
        return monthReturn;
    }

    /*Método que borra un directorio*/
    public static boolean deleteDirectory(String dir) {
        if (!dir.endsWith(File.separator)) {
            dir = dir + File.separator;
        }
        File dirFile = new File(dir);
        if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
            return false;
        }
        boolean flag = true;
        File[] files = dirFile.listFiles();
        for (File file : files) {
            // eliminar subarchivo
            if (file.isFile()) {
                flag = DeleteFileUtil.deleteFile(file.getAbsolutePath());
                if (!flag) {
                    break;
                }
            } // eliminar subdirectorio
            else if (file.isDirectory()) {
                flag = DeleteFileUtil.deleteDirectory(file.getAbsolutePath());
                if (!flag) {
                    break;
                }
            }
        }
        if (!flag) {
            System.out.println("¡Error al eliminar el directorio!");
            return false;
        }
        // eliminar el directorio actual
        if (dirFile.delete()) {
            System.out.println("Eliminar directorio" + dir + "¡Éxito!");
            return true;
        } else {
            return false;
        }
    }
    
    /*Método que borra un archivo*/
    public static void deleteFile(String file) {
        DeleteFileUtil.deleteFile(new File(file).getAbsolutePath());
    }

 
    /*Método que genera el boletín en excel*/
    @SuppressWarnings("null")
    public static void generateNewsletter(String creacionBoletin, String asuntoBoletin, String parrafoBoletin, String nuevoDirectorio, String tipo) throws IOException {
        FileInputStream file = null;        
        String archivoBaseEnEspañol = rutaCargue + "/base"+txtConsecutive+"_Boletin.xls";
        String archivoBaseEnIngles = rutaCargue + "/base"+txtConsecutive+"_Bulletin.xls"; 
        String subtituloBoletin = "";
        try{
            copy(rutaCargue + "/Boletin.xls", archivoBaseEnEspañol);
            copy(rutaCargue + "/Bulletin.xls",archivoBaseEnIngles);
        }catch(IOException e){
            logger.error("OPA - " + GenerarArchivoBoletin.class.getName(), e);
        }                        
        if (tipo.equals("español")) {
            subtituloBoletin = subtituloEspañol;           
            file = new FileInputStream(new File(archivoBaseEnEspañol));         
        } else {
            if (tipo.equals("ingles")) {
                subtituloBoletin = subtituloIngles;
                file = new FileInputStream(new File(archivoBaseEnIngles));
            }
        }
        HSSFWorkbook workbook = new HSSFWorkbook(file);
        /*Estilos*/
        HSSFFont fontHeader = GenerarArchivoBoletin.fontStyle(workbook, GenerarArchivoBoletin.titleSizeText);
        HSSFCellStyle centerTxt = GenerarArchivoBoletin.cellTextStyleCenter(workbook, fontHeader);
        HSSFCellStyle topLeftTxt = GenerarArchivoBoletin.cellTextStyleTopLeft(workbook, fontHeader);
        HSSFSheet sheet = workbook.getSheetAt(0);
        @SuppressWarnings("UnusedAssignment")
        Cell cell = null;
        cell = sheet.getRow(8).getCell(2);
        cell.setCellValue("");
        cell.setCellValue(creacionBoletin);
        cell = sheet.getRow(9).getCell(2);
        cell.setCellValue("");
        cell.setCellValue(subtituloBoletin);
        cell = sheet.getRow(12).getCell(3);
        cell.setCellValue("");
        //cell.setCellStyle(topTxtBlack);        
        cell.setCellValue(asuntoBoletin);
        cell = sheet.getRow(14).getCell(1);
        cell.setCellStyle(topLeftTxt);
        cell.setCellValue(parrafoBoletin);
        //DATOS TABLA
        //A-B-C
        cell = sheet.getRow(28).getCell(3);
        cell.setCellValue("");
        cell.setCellStyle(centerTxt);
        cell.setCellValue(bulletinReport.getAcceptanceCreatedBeforeToday());
        cell = sheet.getRow(29).getCell(3);
        cell.setCellValue("");
        cell.setCellStyle(centerTxt);
        cell.setCellValue(bulletinReport.getAcceptanceCreatedToday());
        cell = sheet.getRow(30).getCell(3);
        cell.setCellValue("");
        cell.setCellStyle(centerTxt);
        cell.setCellValue(bulletinReport.getTotalAcceptancesCreated());
        //D-E-F
        cell = sheet.getRow(28).getCell(4);
        cell.setCellValue("");
        cell.setCellStyle(centerTxt);
        cell.setCellValue(bulletinReport.getActionsCreatedBeforeToday());
        cell = sheet.getRow(29).getCell(4);
        cell.setCellValue("");
        cell.setCellStyle(centerTxt);
        cell.setCellValue(bulletinReport.getActionsCreatedToday());
        
        cell = sheet.getRow(30).getCell(4);
        cell.setCellValue("");
        cell.setCellStyle(centerTxt);
        cell.setCellValue(bulletinReport.getTotalActionsCreated());
        
        //G-H-I
        cell = sheet.getRow(28).getCell(6);
        cell.setCellValue("");
        cell.setCellStyle(centerTxt);
        cell.setCellValue(bulletinReport.getActionsCreatedBeforeTodayPercentage());
        cell = sheet.getRow(29).getCell(6);
        cell.setCellValue("");
        cell.setCellStyle(centerTxt);
        cell.setCellValue(bulletinReport.getActionsCreatedTodayPercentage());
        cell = sheet.getRow(30).getCell(6);
        cell.setCellValue("");
        cell.setCellStyle(centerTxt);
        cell.setCellValue(bulletinReport.getTotalActionsCreatedPercentage());
        //J-K-L
        cell = sheet.getRow(28).getCell(7);
        cell.setCellValue("");
        cell.setCellStyle(centerTxt);
        cell.setCellValue(bulletinReport.getAcceptanceCreatedBeforeTodayVenCon1());
        cell = sheet.getRow(29).getCell(7);
        cell.setCellValue("");
        cell.setCellStyle(centerTxt);
        cell.setCellValue(bulletinReport.getAcceptanceCreatedTodayVenCon1());
        cell = sheet.getRow(30).getCell(7);
        cell.setCellValue("");
        cell.setCellStyle(centerTxt);
        cell.setCellValue(bulletinReport.getTotalAcceptancesCreatedVenCon1());
        //M-N-O
        cell = sheet.getRow(28).getCell(8);
        cell.setCellValue("");
        cell.setCellStyle(centerTxt);
        cell.setCellValue(bulletinReport.getActionsCreatedBeforeTodayVenCon1());
        cell = sheet.getRow(29).getCell(8);
        cell.setCellValue("");
        cell.setCellStyle(centerTxt);
        cell.setCellValue(bulletinReport.getActionsCreatedTodayVenCon1());
        cell = sheet.getRow(30).getCell(8);
        cell.setCellValue("");
        cell.setCellStyle(centerTxt);
        cell.setCellValue(bulletinReport.getTotalActionsCreatedVenCon1());
        cell = sheet.getRow(32).getCell(1);
        cell.setCellValue("");
        if (tipo.equals("español")) {
            cell.setCellValue(GenerarArchivoBoletin.nombreRazonSocial);
        } else {
            if (tipo.equals("ingles")) {
                cell.setCellValue(companyName);
            }
        }
        
        cell = sheet.getRow(32).getCell(4);
        cell.setCellValue("");
        cell.setCellValue(GenerarArchivoBoletin.accionesEnCirculacion);
        
        cell = sheet.getRow(32).getCell(8);
        cell.setCellValue("");
        cell.setCellValue(percentageSharesBd.toString() + "%");
        file.close();
               
        if (tipo.equals("español")) {
            FileOutputStream outFile = new FileOutputStream(new File(archivoBaseEnEspañol));
            workbook.write(outFile);
            outFile.close();
            workbook.close();
            copy(archivoBaseEnEspañol, nuevoDirectorio);
        } else {
            if (tipo.equals("ingles")) {
                FileOutputStream outFile = new FileOutputStream(new File(archivoBaseEnIngles));
                workbook.write(outFile);
                outFile.close();
                workbook.close();
                copy(archivoBaseEnIngles, nuevoDirectorio);
            }
        }
    }
    
    /*Método que genera el boletín en pdf*/
    public static void generateNewsletterInPdf( 
        String path,
        String titulo,
        String subTitulo,
        String subTitulo2,
        String textoInformativo,
        String asunto,
        String contentCellDescription,
        String totalAceptacionesRecibidas1,
        String totalAceptacionesRecibidas2,
        String totalAceptacionesRecibidas3,
        String numAceptaciones,
        String cantAcciones,
        String porcMaxComprar,
        String saldoAcumulado0,
        String recinidoHoy0,
        String saldoAcumuladoCierre0,
        String accinesEnCirculacion0,
        String totalAccinesEnCirculacion0,
        String testoAccionesOrdinarias,
        String tituloAsunto
    ){
        try {
                    
                    String saldoAcumulado1       = bulletinReport.getAcceptanceCreatedBeforeToday();
                    String saldoAcumulado2       = bulletinReport.getActionsCreatedBeforeToday();
                    String saldoAcumulado3       = bulletinReport.getActionsCreatedBeforeTodayPercentage();
                    String saldoAcumulado4       = bulletinReport.getAcceptanceCreatedBeforeTodayVenCon1();
                    String saldoAcumulado5       = bulletinReport.getActionsCreatedBeforeTodayVenCon1();
                    
                    String recinidoHoy1          = bulletinReport.getAcceptanceCreatedToday();
                    String recinidoHoy2          = bulletinReport.getActionsCreatedToday();
                    String recinidoHoy3          = bulletinReport.getActionsCreatedTodayPercentage();
                    String recinidoHoy4          = bulletinReport.getAcceptanceCreatedTodayVenCon1();
                    String recinidoHoy5          = bulletinReport.getActionsCreatedTodayVenCon1();
                    
                    String saldoAcumuladoCierre1 = bulletinReport.getTotalAcceptancesCreated();
                    String saldoAcumuladoCierre2 = bulletinReport.getTotalActionsCreated();
                    String saldoAcumuladoCierre3 = bulletinReport.getTotalActionsCreatedPercentage();
                    String saldoAcumuladoCierre4 = bulletinReport.getTotalAcceptancesCreatedVenCon1();
                    String saldoAcumuladoCierre5 = bulletinReport.getTotalActionsCreatedVenCon1();
                    
                    LinkedList<String> listaFila1 = new LinkedList();
                    listaFila1.add(0,saldoAcumulado0);
                    listaFila1.add(1,saldoAcumulado1);
                    listaFila1.add(2,saldoAcumulado2);
                    listaFila1.add(3,saldoAcumulado3);
                    listaFila1.add(4,saldoAcumulado4);
                    listaFila1.add(5,saldoAcumulado5);
                    LinkedList<String> listaFila2 = new LinkedList();
                    listaFila2.add(0,recinidoHoy0);
                    listaFila2.add(1,recinidoHoy1);
                    listaFila2.add(2,recinidoHoy2);
                    listaFila2.add(3,recinidoHoy3);
                    listaFila2.add(4,recinidoHoy4);
                    listaFila2.add(5,recinidoHoy5);
                    LinkedList<String> listaFila3 = new LinkedList();
                    listaFila3.add(0,saldoAcumuladoCierre0);
                    listaFila3.add(1,saldoAcumuladoCierre1);
                    listaFila3.add(2,saldoAcumuladoCierre2);
                    listaFila3.add(3,saldoAcumuladoCierre3);
                    listaFila3.add(4,saldoAcumuladoCierre4);
                    listaFila3.add(5,saldoAcumuladoCierre5);
                    LinkedList<LinkedList> listaInfo = new LinkedList();
                    listaInfo.add(listaFila1);
                    listaInfo.add(listaFila2);
                    listaInfo.add(listaFila3);
                    String accinesEnCirculacion1 = GenerarArchivoBoletin.accionesEnCirculacion;
                    String totalAccinesEnCirculacion1 = percentageSharesBd.toString()+"%";
                    LinkedList<String> listaFooter = new LinkedList();
                    listaFooter.add(0,accinesEnCirculacion0);
                    listaFooter.add(1,accinesEnCirculacion1);
                    listaFooter.add(2,totalAccinesEnCirculacion0);
                    listaFooter.add(3,totalAccinesEnCirculacion1);
                    listaFooter.add(4,testoAccionesOrdinarias);
                    try {
                        new GenerarBoletinPdf(
                                path,
                                titulo,
                                subTitulo,
                                subTitulo2,
                                asunto,
                                textoInformativo,
                                contentCellDescription,
                                totalAceptacionesRecibidas1,
                                totalAceptacionesRecibidas2,
                                totalAceptacionesRecibidas3,
                                numAceptaciones,
                                cantAcciones,
                                porcMaxComprar,
                                listaInfo,
                                listaFooter,
                                tituloAsunto
                        ); 
                    }catch (Exception e) {
                        logger.error("OPA - " + GenerarArchivoBoletin.class.getName(), e);
                    }
                } catch (Exception ex) {
                    logger.error("OPA - " + GenerarArchivoBoletin.class.getName(), ex);
                }
    }
    public static void correctAccent(){
        tituloEspañol = tituloEspañol.replace("*A*", "Á").replace("*E*", "É").replace("*I*", "Í").replace("*O*", "Ó").replace("*U*", "Ú");
        subtituloEspañol = subtituloEspañol.replace("*A*", "Á").replace("*E*", "É").replace("*I*", "Í").replace("*O*", "Ó").replace("*U*", "Ú");                
        asuntoEspañol = asuntoEspañol.replace("*A*", "Á").replace("*E*", "É").replace("*I*", "Í").replace("*O*", "Ó").replace("*U*", "Ú");
        textoOperacionEspañol = textoOperacionEspañol.replace("*A*", "Á").replace("*E*", "É").replace("*I*", "Í").replace("*O*", "Ó").replace("*U*", "Ú");
        cierreTxtoperacionEspañol = cierreTxtoperacionEspañol.replace("*A*", "Á").replace("*E*", "É").replace("*I*", "Í").replace("*O*", "Ó").replace("*U*", "Ú");
    }
   
}
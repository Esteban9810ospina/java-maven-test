/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.ui.util;

import com.quasar.frameq.db.Facade;
import com.quasar.frameq.interfaces.InterfazBackOffice;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.LoggerFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author Cristian
 */
public class GenerarArchivoReporteAdjudicacion {

    private static final Logger logger = Logger.getLogger(GenerarArchivoInterfazBackOffice.class.getName());
    InterfazBackOffice interfaz = new InterfazBackOffice();
    Facade fachada = new Facade();
    Calendar cal = Calendar.getInstance();
    String rutaCargue = fachada.rutaAdjudicacion();
    List<String> parametros = null;
    String tipoOfertaPublica = "";

    public void CrearArchivoExcel() {

        PropertyConfigurator.configure("/apps/OPA/logs/opa-log4j.properties");
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Reporte de adjudicación");
        LoggerFactory.getLogger(getClass()).debug("OPA - Iniciando Reporte Adjudicacón");
        int seq = interfaz.ObtenerSecuenciaReporte();
        LoggerFactory.getLogger(getClass()).debug("OPA - Secuencia obtenida " + seq);
        List<List<String>> adjudicaciones = new ArrayList<List<String>>();
        
        parametros = fachada.RetornaParametros();
        tipoOfertaPublica = parametros.get(41);

        if (tipoOfertaPublica.equals("OPI")) {
            adjudicaciones = interfaz.AdjudicacionesReporteOPI();
        } else {
            adjudicaciones = interfaz.AdjudicacionesReporte();
        }

        LoggerFactory.getLogger(getClass()).debug("OPA - Lista obtenida " + adjudicaciones.size());
       

        Iterator a = adjudicaciones.iterator();
        List datos = new ArrayList();
        int rownum = 0;
        Iterator b;
        Object obj;
        try {
            //Imprime el titulo
            int cellnum = 0;

            Row row = sheet.createRow(rownum++);
            Cell cell = row.createCell(cellnum++);
            cell.setCellValue("REPORTE DE ADJUDICACION");
            CellStyle cellStyleH = workbook.createCellStyle();
            cellStyleH.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            cellStyleH.setFillPattern(CellStyle.SOLID_FOREGROUND);
            cellStyleH.setAlignment(CellStyle.ALIGN_CENTER);
            Font font = workbook.createFont();
            font.setFontHeightInPoints((short) 14);
            font.setFontName("Arial");
            font.setColor(IndexedColors.WHITE.getIndex());
            cellStyleH.setFont(font);

            cell.setCellStyle(cellStyleH);

            sheet.addMergedRegion(new CellRangeAddress(
                    0, //first row (0-based)
                    0, //last row  (0-based)
                    0, //first column (0-based)
                    23 //last column  (0-based)
            ));

            row = sheet.createRow(rownum++);
            //copia no controlada
            cellnum = 0;
            row = sheet.createRow(rownum++);
            cell = row.createCell(cellnum++);
            cell.setCellValue("Este reporte corresponde a una copia no controlada");

            cellnum = 0;
            row = sheet.createRow(rownum++);
            cell = row.createCell(cellnum++);
            cell.setCellValue("DATOS DE ADJUDICACION");
            //Colocar fecha de adjudicación
            cellnum = 0;
            row = sheet.createRow(rownum++);
            cell = row.createCell(cellnum++);
            cell.setCellValue("Fecha: " + fachada.fechaAdjudicacion());

            //Colocar fecha de adjudicación
            cellnum = 0;
            row = sheet.createRow(rownum++);
            cell = row.createCell(cellnum++);
            cell.setCellValue("Hora: " + fachada.horaAdjudicacion());

            //Colocar fecha de adjudicación
            cellnum = 0;
            row = sheet.createRow(rownum++);
            cell = row.createCell(cellnum++);
            cell.setCellValue("Usuario: " + fachada.usuarioAdjudicacion());

            //Campos para OPI start
            if (tipoOfertaPublica.equals("OPI")) {
                //Colocar umbral
                cellnum = 0;
                row = sheet.createRow(rownum++);
                cell = row.createCell(cellnum++);
                cell.setCellValue("Umbral: " + fachada.umbral_Pago_Rango().get(0));

                //Colocar Pago rango 2
                cellnum = 0;
                row = sheet.createRow(rownum++);
                cell = row.createCell(cellnum++);
                cell.setCellValue("Pago rango 2:  " + fachada.umbral_Pago_Rango().get(1) + "%");
            }
            ////Campos para OPI end

            row = sheet.createRow(rownum++);
            //Imprime la cabecera
            cellnum = 0;
            b = crearCabecera().iterator();
            row = sheet.createRow(rownum++);
            LoggerFactory.getLogger(getClass()).debug("OPA - Cabecera impresa ");
            while (b.hasNext()) {
                obj = b.next();
                cell = row.createCell(cellnum++);

                if (obj instanceof Date) {
                    cell.setCellValue((Date) obj);
                } else if (obj instanceof Boolean) {
                    cell.setCellValue((Boolean) obj);
                } else if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Double) {
                    cell.setCellValue((Double) obj);
                }
                CellStyle cellStyle = workbook.createCellStyle();
                cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
                cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
                cellStyle.setBorderRight(CellStyle.BORDER_THIN);
                cellStyle.setBorderTop(CellStyle.BORDER_THIN);

                if (cellnum > 18) {
                    cellStyle.setAlignment(CellStyle.ALIGN_RIGHT);
                }
                cell.setCellStyle(cellStyle);
                sheet.autoSizeColumn(cell.getColumnIndex());

            }

            CellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
            cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
            cellStyle.setBorderRight(CellStyle.BORDER_THIN);
            cellStyle.setBorderTop(CellStyle.BORDER_THIN);
            //Imprime los detalles
            while (a.hasNext()) {
                row = sheet.createRow(rownum++);
                datos = (List) a.next();
                b = datos.iterator();
                cellnum = 0;
                while (b.hasNext()) {
                    obj = b.next();
                    cell = row.createCell(cellnum++);
                    if (obj instanceof Date) {
                        cell.setCellValue((Date) obj);
                    } else if (obj instanceof Boolean) {
                        cell.setCellValue((Boolean) obj);
                    } else if (obj instanceof String) {
                        cell.setCellValue((String) obj);
                    } else if (obj instanceof Double) {
                        cell.setCellValue((Double) obj);
                    }

                    if (cellnum > 18) {
                        cellStyle.setAlignment(CellStyle.ALIGN_RIGHT);
                    } else {
                        cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
                    }
                    cell.setCellStyle(cellStyle);
                }
                if (rownum % 100 == 0) {
                    LoggerFactory.getLogger(getClass()).debug("OPA - Fila " + rownum + " impresa");
                }
            }
            for (int i = 0; i <= 22; i++) {
                sheet.autoSizeColumn(i);
            }

        } catch (Exception ex) {
            logger.error("OPA - " + GenerarArchivoInterfazBackOffice.class.getName(), ex);
        }
        Calendar myCalendar = new GregorianCalendar();
        SimpleDateFormat dt = new SimpleDateFormat("yyyyMMdd");
        try {
            FileOutputStream out
                    = new FileOutputStream(new File(rutaCargue + "/ADJUDICA_" + dt.format(new Date(myCalendar.getTimeInMillis())) + seq + ".xls"));
            workbook.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            logger.error("OPA - " + GenerarArchivoInterfazBackOffice.class.getName(), e);
        } catch (IOException e) {
            logger.error("OPA - " + GenerarArchivoInterfazBackOffice.class.getName(), e);
        }
    }

    private ArrayList crearCabecera() {
        ArrayList arr = new ArrayList();

        arr.add("ESPECIE");
        arr.add("CLASE DE ACCIONES");
        arr.add("NO. DE ACEPTACIÓN");
        arr.add("FECHA DE ACEPTACIÓN");
        arr.add("HORA DE ACEPTACIÓN");
        arr.add("CONSECUTIVO OFERTA DE VENTA");
        arr.add("PREACUERDO");
        arr.add("CÓDIGO DE LA SCB");
        arr.add("NOMBRE DE LA SCB");
        arr.add("NOMBRE USUARIO OPERADOR SCB");
        arr.add("REPRESENTANTE LEGAL DE LA SCB");
        //arr.add("NOMBRES");
        arr.add("NOMBRES APELLIDO / RAZÓN SOCIAL");
        arr.add("TIPO DE DOCUMENTO");
        arr.add("NÚMERO DE DOCUMENTO");
        arr.add("DÍGITO DE VERIFICACIÓN");
        arr.add("CUENTA INVERSIONISTA");
        arr.add("ESPECIAL FIDUCIARIO");
        arr.add("CONDICIÓN TODO O NADA");

        if (tipoOfertaPublica.equals("OPI")) {
            arr.add("PORCENTAJE PARA PAGO EN EFECTIVO");
        }

        arr.add("NO. DE ACCIONES QUE ACEPTO VENDER");

        if (tipoOfertaPublica.equals("OPI")) {
            arr.add("MONTO TOTAL DE ACCIONES QUE ACEPTO VENDER");
            arr.add("PRECIO ACCIONES A VENDER");
        } else {
            arr.add("MONTO SOLICITADO");
            arr.add("PRECIO");
            arr.add("PORCENTAJE DE COMISIÓN");
        }

        arr.add("CANTIDAD DE ACCIONES ADJUDICADAS");
        arr.add("MONTO ADJUDICADO");

        if (tipoOfertaPublica.equals("OPI")) {
            //arr.add("CANTIDAD DE ACCIONES GA QUE ACEPTO COMPRAR INICIALES");//
            arr.add("PRECIO ACCIONES QUE ACEPTO COMPRAR");
            arr.add("PORCENTAJE PARA PAGO EN EFECTIVO POR FORMA DE PAGO ASIGNADA");
            arr.add("MONTO EN EFECTIVO POR FORMA DE PAGO ASIGNADA");
            arr.add("PORCENTAJE PARA PAGO EN TÍTULOS ASIGNADO POR FORMA DE PAGO");
            arr.add("MONTO EN TÍTULOS POR FORMA DE PAGO ASIGNADA");
            arr.add("CANTIDAD DE ACCIONES PARA PAGO, CUMPLIMIENTO EN TITULOS");
            arr.add("MONTO CUMPLIMIENTO EN TÍTULOS");
            arr.add("SALDO EN PESOS POR CUMPLIMIENTO EN TITULOS");
            arr.add("MONTO CUMPLIMIENTO EN EFECTIVO");
            arr.add("CANTIDAD DE ACCIONES QUE ACEPTO COMPRAR DEFINITIVAS");
            arr.add("PORCENTAJE DE COMISIÓN");
        }

        return arr;
    }
}

package com.framework.common.ui.util;

import java.awt.Color;
import java.io.FileOutputStream;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Properties;

public class GenerarBoletinPdf {
    @SuppressWarnings("UseSpecificCatch")
    public GenerarBoletinPdf(
            String archivoPdf,
            String titulo,
            String subTitulo,
            String subTitulo2,
            String asunto,
            String textoInformativo,
            String contentCellDescription,
            String totalAceptacionesRecibidas1,
            String totalAceptacionesRecibidas2,
            String totalAceptacionesRecibidas3,
            String numAceptaciones,
            String cantAcciones,
            String porcMaxComprar,
            LinkedList<LinkedList> listaInfo,
            LinkedList<String> listaFooter,
            String tituloAsunto
    ) {
        Document document = new Document(PageSize.LETTER, 0, 30, 0, 0);
        try {            
            System.out.println("ENTRÓ A GENERAR EL ARCHIVO PDF");
            Properties properties = new Properties();
            System.out.println("PREPARÓ LAS PROPIEDADES");
            Properties utilProperties = new Properties();             
            System.out.println("LEER LAS PROPIEDADES LOCALES");
            InputStream is = GenerarBoletinPdf.class.getResourceAsStream("/util.properties");            
            System.out.println("PROPIEDADES LOCALES LEIDAS");
            utilProperties.load(is);
            properties.load(new FileInputStream(new File(utilProperties.getProperty("propiedades.opa"))));
            
            System.out.println("cargar propiedades");
            
            String logo = properties.getProperty("imagen.logo.bvc");
             System.out.println("Parametros--->"+logo);
            String logoVigilado = properties.getProperty("imagen.logo.vigilado");
             System.out.println("logoVigilado--->"+logoVigilado);
            String fuenteTahomaRegular = properties.getProperty("fuente.tahoma.regular");
            System.out.println("fuenteTahomaRegular--->"+fuenteTahomaRegular);
            String fuenteTahomaBold = properties.getProperty("fuente.tahoma.bold");
            System.out.println("fuenteTahomaBold--->"+fuenteTahomaBold);
            
            
            Image logo_vigilado = Image.getInstance(logoVigilado);
            logo_vigilado.setAbsolutePosition(37, 250);
            logo_vigilado.scalePercent(8);
            Image logoBVC = Image.getInstance(logo);
            logoBVC.setAbsolutePosition(60, 646);
            logoBVC.scalePercent(9);            
            String fNormal = fuenteTahomaRegular;
            String fBold = fuenteTahomaBold;

            BaseFont tahomaNormal = BaseFont.createFont(fNormal, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
            BaseFont tahomaBold = BaseFont.createFont(fBold, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

            Font font8 = new Font(tahomaNormal, 8);
            Font font8Bold = new Font(tahomaBold, 8);
            Font font9 = new Font(tahomaNormal, 9);
            Font font9Bold = new Font(tahomaBold, 9);
            Font font10 = new Font(tahomaNormal, 10);
            Font font10Bold = new Font(tahomaBold, 10);
            Font font11 = new Font(tahomaNormal, 11);
            Font font11Bold = new Font(tahomaBold, 11);
            Font nfont = new Font(tahomaNormal, 40);
            nfont.setColor(Color.white);

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(archivoPdf));

            document.open();
            document.add(logoBVC);
            document.add(logo_vigilado);

            PdfContentByte cb = writer.getDirectContent();
            cb.beginText();
            int y = 610;
                        
            Table tablaprov = new Table(5);
            tablaprov.setWidth(67);
            tablaprov.setBorderWidth(0);
            tablaprov.setPadding(3);
            tablaprov.setSpacing(0);
            Paragraph prov0 = new Paragraph(".", nfont);
            Cell c0 = new Cell(prov0);
            c0.setBorder(0);
            tablaprov.addCell(c0);                                              
            document.add(tablaprov);
            
            Paragraph ProvisionalParagraph = new Paragraph(".", nfont);
            document.add(ProvisionalParagraph);

            Paragraph paragraphTitlle = new Paragraph(titulo, font11Bold);
            paragraphTitlle.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraphTitlle);

            Table body = new Table(5);
            body.setWidth(80);
            body.setBorderWidth(1);
            body.setPadding(3);
            body.setSpacing(0);
                         
            Paragraph prov1 = new Paragraph(" ", font11Bold);
            Cell celSTituloProv1 = new Cell(prov1);
            celSTituloProv1.setBorder(0);
            body.addCell(celSTituloProv1);
                                    
            Paragraph psTitulo = new Paragraph(subTitulo, font11Bold);
            Cell celSTitulo = new Cell(psTitulo);
            celSTitulo.setVerticalAlignment(Element.ALIGN_TOP);
            celSTitulo.setHorizontalAlignment(Element.ALIGN_CENTER);
            celSTitulo.setRowspan(2);
            celSTitulo.setColspan(3);
            celSTitulo.setBorder(0);
            body.addCell(celSTitulo);
                        
            Paragraph prov2 = new Paragraph(" ", font11Bold);
            Cell celSTituloProv2 = new Cell(prov2);
            celSTituloProv2.setBorder(0);
            body.addCell(celSTituloProv2);
            body.setSpacing(0);
            
            document.add(body);

            Table tablaAsunto = new Table(5);
            tablaAsunto.setBorderWidth(0);
            tablaAsunto.setPadding(2);
            tablaAsunto.setSpacing(2);
            
            Paragraph paragraphSubTitulo2 = new Paragraph(subTitulo2, font11Bold);
            Paragraph paragraphAsunto = new Paragraph(tituloAsunto, font11Bold);
            Paragraph paragraphAsunto2 = new Paragraph(asunto, font11Bold);
            Font provFont = new Font(tahomaNormal, 7);
            provFont.setColor(Color.white);
            Paragraph paragraphAsuntoprov = new Paragraph(".",provFont );
            
            Cell headerSubtitulo2 = new Cell(paragraphSubTitulo2);
            headerSubtitulo2.setHeader(true);
            headerSubtitulo2.setColspan(5);
            headerSubtitulo2.setBorder(0);
            headerSubtitulo2.setVerticalAlignment(Element.ALIGN_TOP);
            headerSubtitulo2.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaAsunto.addCell(headerSubtitulo2);
            tablaAsunto.endHeaders();
            
            Cell cellParagraphAsuntoprov = new Cell(paragraphAsuntoprov);
            cellParagraphAsuntoprov.setColspan(5);
            cellParagraphAsuntoprov.setBorder(0);
            tablaAsunto.addCell(cellParagraphAsuntoprov);
            
            Cell asuntoLeft = new Cell(paragraphAsunto);
            asuntoLeft.setRowspan(3);
            asuntoLeft.setBorder(0);
            tablaAsunto.addCell(asuntoLeft);
            
            Cell cellAsuntoRight = new Cell(paragraphAsunto2);
            cellAsuntoRight.setRowspan(3);
            cellAsuntoRight.setColspan(4);
            cellAsuntoRight.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            cellAsuntoRight.setBorder(0);
            tablaAsunto.addCell(cellAsuntoRight);
            
            Paragraph paragraphTextoInformativo = new Paragraph(textoInformativo, font11);
            Cell headerTextoInformativo = new Cell(paragraphTextoInformativo);
            headerTextoInformativo.setHeader(true);
            headerTextoInformativo.setColspan(5);
            headerTextoInformativo.setRowspan(8);
            headerTextoInformativo.setBorder(0);
            headerTextoInformativo.setVerticalAlignment(Element.ALIGN_TOP);
            headerTextoInformativo.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
                       
            tablaAsunto.addCell(headerTextoInformativo);
            
            document.add(tablaAsunto);

            Table tablaInfo = new Table(6);
            tablaInfo.setBorderWidth(0);
            tablaInfo.setPadding(2);
            tablaInfo.setSpacing(0);

            Paragraph dsc = new Paragraph(contentCellDescription, font11Bold);
            Paragraph tar1 = new Paragraph(totalAceptacionesRecibidas1, font11Bold);
            Paragraph tar2 = new Paragraph(totalAceptacionesRecibidas2, font8);
            Paragraph tar3 = new Paragraph(totalAceptacionesRecibidas3, font11Bold);
            Paragraph na1 = new Paragraph(numAceptaciones, font8Bold);
            Paragraph ca1 = new Paragraph(cantAcciones, font8Bold);
            Paragraph pmac = new Paragraph(porcMaxComprar, font8Bold);
            Paragraph na2 = new Paragraph(numAceptaciones, font8Bold);
            Paragraph ca2 = new Paragraph(cantAcciones, font8Bold);

            Cell cellDescripcion = new Cell(dsc);
            cellDescripcion.setRowspan(4);
            cellDescripcion.setBorderColor(new Color(0, 0, 0));
            cellDescripcion.setBorderWidth(1);
            cellDescripcion.setBackgroundColor(Color.LIGHT_GRAY);
            cellDescripcion.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cellDescripcion.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaInfo.addCell(cellDescripcion);

            

            

            
            
            Cell cellTotalAceptacionesRecibidas1 = new Cell(tar1);
            cellTotalAceptacionesRecibidas1.setColspan(3);
            cellTotalAceptacionesRecibidas1.setBorderWidth(1);            
            cellTotalAceptacionesRecibidas1.setBorderWidthTop(1);
            cellTotalAceptacionesRecibidas1.setBorderWidthLeft(1);
            cellTotalAceptacionesRecibidas1.setBorderWidthRight(1);
            cellTotalAceptacionesRecibidas1.setBorderWidthBottom(0);
            cellTotalAceptacionesRecibidas1.setBorderColorTop(new Color(0, 0, 0));
            cellTotalAceptacionesRecibidas1.setBorderColorLeft(new Color(0, 0, 0));
            cellTotalAceptacionesRecibidas1.setBorderColorRight(new Color(0, 0, 0));                     
            cellTotalAceptacionesRecibidas1.setBackgroundColor(Color.LIGHT_GRAY);
            cellTotalAceptacionesRecibidas1.setVerticalAlignment(Element.ALIGN_BASELINE);
            cellTotalAceptacionesRecibidas1.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaInfo.addCell(cellTotalAceptacionesRecibidas1);
            
            Cell cellTotalAceptacionesRecibidas3 = new Cell(tar3);
            cellTotalAceptacionesRecibidas3.setColspan(2);
            cellTotalAceptacionesRecibidas3.setRowspan(2);
            cellTotalAceptacionesRecibidas3.setBorderWidth(1);
            cellTotalAceptacionesRecibidas3.setBorderColor(new Color(0, 0, 0));
            cellTotalAceptacionesRecibidas3.setBackgroundColor(Color.LIGHT_GRAY);
            cellTotalAceptacionesRecibidas3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cellTotalAceptacionesRecibidas3.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaInfo.addCell(cellTotalAceptacionesRecibidas3);
            
            Cell cellTotalAceptacionesRecibidas2 = new Cell(tar2);
            cellTotalAceptacionesRecibidas2.setColspan(3);
            cellTotalAceptacionesRecibidas2.setBorderWidthTop(0);
            cellTotalAceptacionesRecibidas2.setBorderWidthBottom(1);
            cellTotalAceptacionesRecibidas2.setBorderWidthLeft(1);
            cellTotalAceptacionesRecibidas2.setBorderWidthRight(1);
            cellTotalAceptacionesRecibidas2.setBorderColorLeft(new Color(0, 0, 0));
            cellTotalAceptacionesRecibidas2.setBorderColorRight(new Color(0, 0, 0));
            cellTotalAceptacionesRecibidas2.setBorderColorBottom(new Color(0, 0, 0));
            cellTotalAceptacionesRecibidas2.setBackgroundColor(Color.LIGHT_GRAY);
            cellTotalAceptacionesRecibidas2.setVerticalAlignment(Element.ALIGN_TOP);
            cellTotalAceptacionesRecibidas2.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaInfo.addCell(cellTotalAceptacionesRecibidas2); 
            
            

            Cell cellNumAceptaciones1 = new Cell(na1);
            cellNumAceptaciones1.setBorderColor(new Color(0, 0, 0));
            cellNumAceptaciones1.setRowspan(2);
            cellNumAceptaciones1.setBorderWidth(1);
            cellNumAceptaciones1.setBackgroundColor(Color.LIGHT_GRAY);
            cellNumAceptaciones1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cellNumAceptaciones1.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaInfo.addCell(cellNumAceptaciones1);

            Cell cellCantAcciones = new Cell(ca1);
            cellCantAcciones.setBorderColor(new Color(0, 0, 0));
            cellCantAcciones.setRowspan(2);
            cellCantAcciones.setBorderWidth(1);
            cellCantAcciones.setBackgroundColor(Color.LIGHT_GRAY);
            cellCantAcciones.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cellCantAcciones.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaInfo.addCell(cellCantAcciones);

            Cell cellPorcMaximo = new Cell(pmac);
            cellPorcMaximo.setBorderColor(new Color(0, 0, 0));
            cellPorcMaximo.setRowspan(2);
            cellPorcMaximo.setBorderWidth(1);
            cellPorcMaximo.setBackgroundColor(Color.LIGHT_GRAY);
            cellPorcMaximo.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cellPorcMaximo.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaInfo.addCell(cellPorcMaximo);
            Cell cellNumAceptaciones2 = new Cell(na2);
            cellNumAceptaciones2.setBorderColor(new Color(0, 0, 0));
            cellNumAceptaciones2.setRowspan(2);
            cellNumAceptaciones2.setBorderWidth(1);
            cellNumAceptaciones2.setBackgroundColor(Color.LIGHT_GRAY);
            cellNumAceptaciones2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cellNumAceptaciones2.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaInfo.addCell(cellNumAceptaciones2);
            Cell cellCantidadAcciones = new Cell(ca2);
            cellCantidadAcciones.setBorderColor(new Color(0, 0, 0));
            cellCantidadAcciones.setRowspan(2);
            cellCantidadAcciones.setBorderWidth(1);
            cellCantidadAcciones.setBackgroundColor(Color.LIGHT_GRAY);
            cellCantidadAcciones.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cellCantidadAcciones.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaInfo.addCell(cellCantidadAcciones);
            
            for (int i = 0; i < listaInfo.size(); i++) {
                LinkedList fila = (LinkedList) listaInfo.get(i);
                for (int j = 0; j < fila.size(); j++) {
                    Font fuente = font11;
                    if (j == 0) {
                        fuente = font10;
                    }
                    Paragraph Paragraph = new Paragraph(fila.get(j).toString(), fuente);
                    Cell cellInfo = new Cell(Paragraph);
                    cellInfo.setBorderColor(new Color(0, 0, 0));
                    cellInfo.setBorderWidth(1);
                    cellInfo.setBackgroundColor(Color.WHITE);
                    cellInfo.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cellInfo.setHorizontalAlignment(Element.ALIGN_CENTER);
                    tablaInfo.addCell(cellInfo);
                }
            }
            Font nfont2 = new Font(tahomaNormal, 4);
            nfont.setColor(Color.white);
            ProvisionalParagraph = new Paragraph(".", nfont2);
            document.add(ProvisionalParagraph);
            
            document.add(tablaInfo);
            
            
            Table tablaFooter = new Table(6);
            tablaFooter.setBorderWidth(1);
            tablaFooter.setBorderColor(new Color(0, 0, 0));
            tablaFooter.setPadding(4);
            tablaFooter.setSpacing(0);
            for (int i = 0; i < 4; i++) {
                Font fuente = font11;
                Color background = Color.WHITE;
                int colspan = 1;
                if (i == 0 || i == 2) {
                    fuente = font9Bold;
                    background = Color.LIGHT_GRAY;
                    colspan = 2;
                }
                Paragraph Paragraph = new Paragraph(listaFooter.get(i), fuente);
                Cell cellFooter = new Cell(Paragraph);
                cellFooter.setBorderColor(new Color(0, 0, 0));
                cellFooter.setBorderWidth(1);
                cellFooter.setColspan(colspan);
                cellFooter.setBackgroundColor(background);
                cellFooter.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cellFooter.setHorizontalAlignment(Element.ALIGN_CENTER);
                tablaFooter.addCell(cellFooter);
            }           
            document.add(tablaFooter);            
            
            Table tablaTextFooter = new Table(6);
            tablaTextFooter.setBorderWidth(0);
            tablaTextFooter.setBorderColor(new Color(0, 0, 0));
            tablaTextFooter.setPadding(0);
            tablaTextFooter.setSpacing(0);
            Paragraph ParagraphAccionesOrdinarias = new Paragraph(listaFooter.get(4), font10);
            Cell cellAccionesOrdinarias = new Cell(ParagraphAccionesOrdinarias);
            cellAccionesOrdinarias.setBorderColor(new Color(0, 0, 0));
            cellAccionesOrdinarias.setBorderWidth(0);
            cellAccionesOrdinarias.setColspan(6);
            cellAccionesOrdinarias.setBackgroundColor(Color.WHITE);
            cellAccionesOrdinarias.setVerticalAlignment(Element.ALIGN_TOP);
            cellAccionesOrdinarias.setHorizontalAlignment(Element.ALIGN_LEFT);
            tablaTextFooter.addCell(cellAccionesOrdinarias);
            document.add(tablaTextFooter);                                    
            cb.endText();
            document.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}

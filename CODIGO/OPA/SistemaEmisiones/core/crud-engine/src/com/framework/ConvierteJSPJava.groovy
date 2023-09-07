package com.framework

import groovy.text.*
import java.nio.charset.Charset;
/**
 * Script para convertir JSP de FrameQ a clases JAVA Maestro - Detalle de Vaadin
 * @author pedrorozo
 *
 */
class ConvierteJSPJava {

	static main(args) {

    println "Framework - Conversor de Paginas JSP a clases Java"
    def patronBeans = ~/\s*<jsp\:useBean\s+id="(.*)"\s+class="(.*)".*\/>/

    def patronDeclara = "<%!"
    def patronDeclaraFin = "%>"
    def patronInicia = "<%"
    def patronIniciaFin = "%>"
    // a configurar
    def plantillaMaestro =  "C:/framework/MaestroPla.java" // plantilla de codigo maestro
    def plantillaMaestroDetalle =  "C:/framework/MaestroDetallePla.java" // plantilla de codigo maestro detalle
    def plantillaFuente
    def directorioSalida = "C:/Users/jam/proyectos/bvc/framework/web/framework-web/src/main/java/com/framework/cruds/ui/content/"
    List lines;
    // variables macro
    def nombrePaquete = "com.framework.cruds.ui.content"

    def nombreClase = ["AbmBolsaorigen"]

    for (int j=0;j< nombreClase.size()  ;j++)
    {

      def archivoSalida = new File(directorioSalida+nombreClase[j]+".java")
      // a configurar localizacion base para los JSP
      def archivoJsp = "C:/Users/jam/Documents/NetBeansProjects/sandbox/FrameQ/web/FrameQ-web/src/main/webapp/"+nombreClase[j]+".jsp"

      def declara = ""
      def inicia = ""
      def myFile= new BufferedReader(new InputStreamReader(new FileInputStream(archivoJsp), "ISO-8859-1" )) 	  // lee el archivo jsp

      lines = myFile.readLines();
      myFile.close();

      int pos = 0;

      def nombreBeanMaestro;
      def nombreBeanDetalle;

      if (lines.size() > 0) {

        nombreBeanMaestro = null;
        nombreBeanDetalle = null;

        for(it in lines){
          def matcher = patronBeans.matcher(it);
          def matches = matcher.matches();
          if (matches) {
            if (matcher[0][1] == "maestro") {
              nombreBeanMaestro = matcher[0][2];
            } else if (matcher[0][1] == "detalle") {
              nombreBeanDetalle = matcher[0][2];
            }
            if (nombreBeanMaestro != null && nombreBeanDetalle != null) {
              break;
            }
          }
        };

        def line = lines[pos];

        while (!(line =~ patronDeclara)) {
          line = lines[pos];
          ++pos;
        }

        declara += " /* ************************* Seccion de declaraciones ************************* */ \n"
        line = lines[pos];
        ++pos;

        while ( !(line =~ patronDeclaraFin)) {
          declara += line + "\n"  // arma string de declaraciones
          line = lines[pos];
          ++pos;
        }

        declara += " /* ************************* Fin Seccion de declaraciones ************************* */ \n "
        line = lines[pos];
        ++pos;

        while (!(line =~ patronInicia))
        {
          line = lines[pos];
          ++pos;
        }


        inicia += " /* ************************* Seccion de Inicializacion ************************* */ \n"

        line = lines[pos];
        ++pos;

        while ( !(line =~ patronIniciaFin)) {
          inicia += line + "\n"   // arma string de inciializaciones
          line = lines[pos];
          ++pos;
        }

        inicia +=  " /* ************************* Fin de Seccion de Inicializacion ************************* */ \n"
      } // while

      lines.clear();

      def datos = [
        'nombrePaquete' : nombrePaquete,
        'nombreClase' : nombreClase[j],
        'inicia' : inicia,
        'declara' : declara,
        'nombreBeanMaestro' : nombreBeanMaestro,
        'nombreBeanDetalle' : nombreBeanDetalle
      ]

      //procesa plantilla con datos
      //def engine = new SimpleTemplateEngine()
      def engine = new groovy.text.GStringTemplateEngine()
      if (nombreBeanDetalle != null)    // tiene detalle
      {
        plantillaFuente = plantillaMaestroDetalle;
      }
      else    // es solo maestro - no tiene detalle
      {
        plantillaFuente = plantillaMaestro;
      }

      def plantilla = engine.createTemplate(new File(plantillaFuente))

      def resultados = plantilla.make(datos)
      //def resultaCoded = new String(resultados.toString().getBytes(),"ISO-8859-1")
      def resultaCoded = resultados
      //println resultaCoded

      archivoSalida.write(resultaCoded.toString());
      println " -- Archivo:"+archivoJsp+ " \n convertido a: \n "+archivoSalida

    }  // for

  } // main
} // clase

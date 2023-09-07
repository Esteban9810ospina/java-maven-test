package com.quasar.frameq.db;

import com.quasar.frameq.parametros.Festivo;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpeFechas {

  private Logger logger = LoggerFactory.getLogger(getClass());

  int Fechaini;
  int Fechafin;
  int Fanoini;
  int Fmesini;
  int Fdiaini;
  int Fanofin;
  int Fmesfin;
  int Fdiafin;
  int DiasMesini[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  int DiasMesfin[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  /* Constructor del objeto
   ------------------------------*/
  public OpeFechas(int inifecha) {
    Fechaini = inifecha;
    Fechafin = 0;
    Fanofin = 0;
    Fmesfin = 0;
    Fdiafin = 0;
    Fecha fec = new Fecha();
    int amd = fec.getDia();
    if (amd <= 9) {

      Fanoini = inifecha / 1000;
      Fmesini = (inifecha - Fanoini * 1000) / 10;
      Fdiaini = (inifecha - Fanoini * 1000) - Fmesini * 10;
    } else {

      Fanoini = inifecha / 10000;
      Fmesini = (inifecha - Fanoini * 10000) / 100;
      Fdiaini = (inifecha - Fanoini * 10000) - Fmesini * 100;
    }
    DiasMesini[1] = EvalueAno(Fanoini);
    DiasMesfin[1] = EvalueAno(Fanofin);
  }

  public OpeFechas(int inifecha, double sa) {
    Fechaini = inifecha;
    Fechafin = 0;
    Fanofin = 0;
    Fmesfin = 0;
    Fdiafin = 0;

    Fanoini = inifecha / 10000;
    Fmesini = (inifecha - Fanoini * 10000) / 100;
    Fdiaini = (inifecha - Fanoini * 10000) - Fmesini * 100;
    DiasMesini[1] = EvalueAno(Fanoini);
    DiasMesfin[1] = EvalueAno(Fanofin);
  }

  public OpeFechas(int inifecha, int finfecha) {
    Fechaini = inifecha;
    Fechafin = finfecha;
    Fanofin = finfecha / 10000;
    Fmesfin = (finfecha - Fanofin * 10000) / 100;
    Fdiafin = (finfecha - Fanofin * 10000) - Fmesfin * 100;
    Fanoini = inifecha / 10000;
    Fmesini = (inifecha - Fanoini * 10000) / 100;
    Fdiaini = (inifecha - Fanoini * 10000) - Fmesini * 100;
    DiasMesini[1] = EvalueAno(Fanoini);
    DiasMesfin[1] = EvalueAno(Fanofin);
  }

///*** Da como resutlado n dias apartir de la fehca actual
  public int ResteDiasCal(int NroDias) {
    int r = 0;
    int Rano = Fanoini;
    int Rmes = Fmesini - 1;
    int Rdia = Fdiaini;
    int RDiasMes[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    RDiasMes[1] = EvalueAno(Rano);
    while (NroDias > 0) {
      if (NroDias > Rdia) {
        NroDias -= Rdia;
        Rmes -= 1;
        if (Rmes < 0) {
          Rmes = 11;
          Rano -= 1;
          DiasMesini[1] = EvalueAno(Rano);
        }
        Rdia = DiasMesini[Rmes];
      } else {

        Rdia -= NroDias;
        NroDias = 0;
      }
    }
    r = (Rano * 10000) + ((Rmes + 1) * 100) + Rdia;
    return r;
  }

///*** Retorna la fecha que recibe menos n días.
  public int ResteDias(int NroDias, String fecha1) {
    int r = 0;
    int Ano = Integer.parseInt(fecha1.substring(0, 4).trim());
    int Mes = Integer.parseInt(fecha1.substring(5, 7).trim());
    int Dia = Integer.parseInt(fecha1.substring(8, 10).trim());

    int Rano = Ano;
    int Rmes = Mes - 1;
    int Rdia = Dia;
    int RDiasMes[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    RDiasMes[1] = EvalueAno(Rano);
    while (NroDias > 0) {
      if ((Rdia - 1) == 0) {
        if ((Rmes - 1) < 0) {
          Rmes = 11;
          Rano -= 1;
          DiasMesini[1] = EvalueAno(Rano);
        } else {
          Rmes--;
        }
        Rdia = DiasMesini[Rmes];
        NroDias--;
      } else {
        Rdia--;
        NroDias--;
      };
    } // end while
    r = (Rano * 10000) + ((Rmes + 1) * 100) + Rdia;
    return r;
  }

///***Suma n dias a partir de la fecha dada
  public int SumeDias(int NroDias, String fecha1) {
    int r;
    int Ano = Integer.parseInt(fecha1.substring(0, 4).trim());
    int Mes = Integer.parseInt(fecha1.substring(4, 6).trim());
    int Dia = Integer.parseInt(fecha1.substring(6, 8).trim());

    int Rano = Ano;
    int Rmes = Mes - 1;
    int Rdia = Dia;
    int RDiasMes[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    RDiasMes[1] = EvalueAno(Rano);
    while (NroDias > 0) {
      if (Rdia < RDiasMes[Rmes]) {
        Rdia += 1;
      } else {
        Rdia = 1;
        Rmes += 1;
        if (Rmes == 12) {
          Rano += 1;
          Rmes = 0;
        }
      }
      NroDias--;
    }
    r = (Rano * 10000) + ((Rmes + 1) * 100) + Rdia;
    return r;
  }

///***Suma n dias a partir de la fecha dada
  public int SumeDiasD(int NroDias, String fecha1) {
    int r;

    int Ano = Integer.parseInt(fecha1.substring(0, 4).trim());
    int Mes = Integer.parseInt(fecha1.substring(4, 6).trim());
    int Dia = Integer.parseInt(fecha1.substring(6, 8).trim());

    int Rano = Ano;
    int Rmes = Mes - 1;
    int Rdia = Dia;
    int RDiasMes[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    RDiasMes[1] = EvalueAno(Rano);
    while (NroDias > 0) {
      if (Rdia < RDiasMes[Rmes]) {
        Rdia += 1;
      } else {
        Rdia = 1;
        Rmes += 1;
        if (Rmes == 12) {
          Rano += 1;
          Rmes = 0;
        }
      }
      NroDias--;
    }
    r = (Rano * 10000) + ((Rmes + 1) * 100) + Rdia;
    return r;
  }

///***Suma n dias a partir de la fecha actual sin corrimiento
  public int SumeDiasCal(int NroDias) {
    int r = 0;
    int Rano = Fanoini;
    int Rmes = Fmesini - 1;
    int Rdia = Fdiaini;
    int RDiasMes[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    RDiasMes[1] = EvalueAno(Rano);
    while (NroDias > 0) {
      if (Rdia < RDiasMes[Rmes]) {
        Rdia += 1;
      } else {
        Rdia = 1;
        Rmes += 1;
        if (Rmes == 12) {
          Rano += 1;
          Rmes = 0;
        }
      }
      NroDias--;
    }
    r = (Rano * 10000) + ((Rmes + 1) * 100) + Rdia;
    return r;
  }

  public int ResteDiasHab(int NroDias) throws SQLException {
    int r = 0;
    int Rano = Fanoini;
    int Rmes = Fmesini - 1;
    int Rdia = Fdiaini;
    int RDiasMes[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    RDiasMes[1] = EvalueAno(Rano);
    while (NroDias > 0) {
      if ((Rdia - 1) == 0) {
        if ((Rmes - 1) < 0) {
          Rmes = 11;
          Rano -= 1;
          DiasMesini[1] = EvalueAno(Rano);
        } else {
          Rmes--;
        }
        Rdia = DiasMesini[Rmes];
      } else {
        Rdia--;
      }
      int d = DiaSemana(Rano, Rmes, Rdia);
      if (d > 1 && d < 7) {
        Fecha fecha = new Fecha();
        fecha.setAno(Rano);
        fecha.setMes(Rmes + 1);
        fecha.setDia(Rdia);
        fecha.setFormato(fecha.FORMATO_YYYYMMDD);
        fecha.setSeparador("-");
        Festivo festivo = new Festivo(fecha.toString());
        Vector v_festivos = festivo.consultar();
        if (v_festivos.size() == 0) {
          NroDias--;
        }
      }
      if (NroDias == 0) {
        Fecha fecha = new Fecha();
        fecha.setAno(Rano);
        fecha.setMes(Rmes + 1);
        fecha.setDia(Rdia);
        fecha.setFormato(fecha.FORMATO_YYYYMMDD);
        fecha.setSeparador("-");
        Festivo festivo = new Festivo(fecha.toString());
        Vector v_festivos = festivo.consultar();
        if (v_festivos.size() > 0) {
          NroDias++;
        }
      }
    } // end while
    r = (Rano * 10000) + ((Rmes + 1) * 100) + Rdia;
    return r;
  }

//------Resta días hábiles de una determinada fecha
  public int ResteDiasHabiles(int NroDias, String fecha1) throws SQLException {
    int r;
    // CAMBIOS DIANA
    int Ano = Integer.parseInt(fecha1.substring(0, 4).trim());
    int Mes = Integer.parseInt(fecha1.substring(4, 6).trim());
    int Dia = Integer.parseInt(fecha1.substring(6, 8).trim());

    int Rano = Ano;
    int Rmes = Mes - 1;
    int Rdia = Dia;
    int RDiasMes[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    RDiasMes[1] = EvalueAno(Rano);
    while (NroDias > 0) {
      if ((Rdia - 1) == 0) {
        if ((Rmes - 1) < 0) {
          Rmes = 11;
          Rano -= 1;
          DiasMesini[1] = EvalueAno(Rano);
        } else {
          Rmes--;
        }
        Rdia = DiasMesini[Rmes];
      } else {
        Rdia--;
      }
      int d = DiaSemana(Rano, Rmes, Rdia);
      if (d > 1 && d < 7) {
        Fecha fecha = new Fecha();
        fecha.setAno(Rano);
        fecha.setMes(Rmes + 1);
        fecha.setDia(Rdia);
//Cambios Diana
        fecha.setFormato(fecha.FORMATO_YYYYMMDD);
        fecha.setSeparador("-");
        Festivo festivo = new Festivo(fecha.toString());
        Vector v_festivos = festivo.consultar();
        festivo.cerrarConexiones();
        if (v_festivos.size() == 0) {
          NroDias--;
        }
      }
      if (NroDias == 0) {
        Fecha fecha = new Fecha();
        fecha.setAno(Rano);
        fecha.setMes(Rmes + 1);
        fecha.setDia(Rdia);
        fecha.setSeparador("-");
        // cambio de formato FORMATO_DDMMYYYY  a FORMATO_YYYYMMDD 2012-09-2012
        fecha.setFormato(fecha.FORMATO_YYYYMMDD);

        Festivo festivo = new Festivo(fecha.toString());
        Vector v_festivos = festivo.consultar();
        festivo.cerrarConexiones();
        if (v_festivos.size() > 0) {
          NroDias++;
        }
      }
    } // end while
    r = (Rano * 10000) + ((Rmes + 1) * 100) + Rdia;
    return r;
  }

  /**
   * Evalúa si un año es bisiesto
   *
   * @param Eano Entero que representa el año que se va a evaluar.
   * @return Entero con el número de días que contiene Febrero.
   */
  public int EvalueAno(int Eano) {
    int a;
    if (((Eano % 4 == 0) && (Eano % 100 != 0)) || (Eano % 400 == 0)) {
      a = 29;
    } else {
      a = 28;
    }
    return a;
  }

  public int DiaSemana(int DSano, int DSmes, int DSdia) {
    Calendar cal = new GregorianCalendar().getInstance();
    cal.set(cal.YEAR, DSano);
    cal.set(cal.MONTH, DSmes);
    cal.set(cal.DAY_OF_MONTH, DSdia);
    int d = cal.get(cal.DAY_OF_WEEK);
    return d;
  }

  public int CuenteDias() {
    if ((Fechaini > 0 && Fechafin > 0) && (Fechaini <= Fechafin)) {
      int dias = ((Juliano(Fdiafin, Fmesfin, Fanofin) - Juliano(Fdiaini, Fmesini, Fanoini)));
      return dias;
    }
    return 0;
  }

  public int Juliano(int day, int month, int year) {
    int MIN_YEAR = 1900;
    int FIRST_TWO_MONTHS = 58;        // 1900 was not a leap year
    final int FIRST_DAY_OF_WEEK = 1;  // 01/01/1900 was a Monday

    if ((year < MIN_YEAR) && (month < 3)) {
      if (month == 1) {
        return (day - 1);
      } else {
        return (day + 30);
      }
    } else {
      if (month > 2) {
        month -= 3;
      } else {
        month += 9;
        year--;
      }
      year -= MIN_YEAR;
      return (year / 100) * 146097 / 4 + (year % 100) * 1461 / 4
              + (153 * month + 2) / 5 + day + FIRST_TWO_MONTHS;
    }
  }

    public boolean validaDiaHabil(String fechaini) {
    fechaini = this.quitSeparator(fechaini);
    int Ano = Integer.parseInt(fechaini.substring(0, 4).trim());
    int Mes = Integer.parseInt(fechaini.substring(4, 6).trim());
    int Dia = Integer.parseInt(fechaini.substring(6, 8).trim());

    try {
      Calendar calendar = GregorianCalendar.getInstance();
      calendar.set(Calendar.YEAR, Ano);
      calendar.set(Calendar.MONTH, Mes - 1);
      calendar.set(Calendar.DAY_OF_MONTH, Dia);

      int dia = calendar.get(Calendar.DAY_OF_WEEK);

      if ((dia == Calendar.SATURDAY) || (dia == Calendar.SUNDAY)) {
        logger.debug("OPA - " + "SABADO o DOMINGO!");
        return false;
      }

      Fecha fecha = new Fecha();
      fecha.setAno(Ano);
      fecha.setMes(Mes);
      fecha.setDia(Dia);
      fecha.setFormato(fecha.FORMATO_YYYYMMDD);
      fecha.setSeparador("-");

      Festivo festivo = new Festivo(fecha.toString());
      Collection v_festivos = festivo.consultar();
      festivo.cerrarConexion();

      if (v_festivos.isEmpty()) {
        return true;
      }

      logger.debug("OPA - " + "Festivo!");

    } catch (Exception e) {
      logger.error("Error al comprobar dia. Msg: {}", e.getMessage(), e);
    }
    return false;
  }

  public String quitSeparator(String fecha) {
    if (fecha.length() == 10) {
      String fecha1 = "";
      for (int i = 0; i < fecha.length(); i++) {
        if (fecha.charAt(i) == '-') {
          fecha = fecha.substring(0, i) + fecha.substring(i + 1, fecha.length());
        }
      }
      fecha1 = fecha;
      return fecha1;
    } else {
      return fecha;
    }
  }

  public Calendar nextCupon(Date fechaEmision, Date fechaVencimiento, char periodicidad,
          char baseInt) {
    Calendar result = null;
    Integer resta = null;
    Integer agno = new Integer(quitSeparator(fechaEmision.toString()).substring(0, 4));
    Integer mes = new Integer(quitSeparator(fechaEmision.toString()).substring(4, 6));
    Integer dia = new Integer(quitSeparator(fechaEmision.toString()).substring(6, 8));
    GregorianCalendar emision = new GregorianCalendar(agno.intValue(), mes.intValue() - 1, dia.intValue());
    Integer agnoV = new Integer(quitSeparator(fechaVencimiento.toString()).substring(0, 4));
    Integer mesV = new Integer(quitSeparator(fechaVencimiento.toString()).substring(4, 6));
    Integer diaV = new Integer(quitSeparator(fechaVencimiento.toString()).substring(6, 8));
    Calendar vencimiento = new GregorianCalendar(agnoV.intValue(), mesV.intValue() - 1, diaV.intValue());
    int flagComercial = 0;
    int month = 0;

    switch (periodicidad) {
      /**
       * Periodicidad anual
       */
      case 'A':
        switch (baseInt) {
          case 'N':// Base normal 365 días (no incluye el 29 de febrero)
            do {
              if (emision.get(Calendar.MONTH) == 1 && emision.get(Calendar.DATE) > 28) {
                emision.set(Calendar.DATE, 28); // pasar al 28 de febrero del siguiente año
                emision.add(Calendar.YEAR, 1);
              } else {
                emision.add(Calendar.YEAR, 1);
              }
            } while (emision.before(vencimiento));
            result = emision;
            break;
          case 'C': // Base comercial, meses de 30 días
            if (emision.get(Calendar.DATE) > 30) {
              emision.set(Calendar.DATE, 30);
            }
            do {
              if (emision.get(Calendar.MONTH) == 1 && emision.get(Calendar.DATE) > 28) {
                emision.set(Calendar.DATE, 28);
                emision.add(Calendar.YEAR, 1);
              } else {
                emision.add(Calendar.YEAR, 1);
              }
            } while (emision.before(vencimiento));
            result = emision;

            break;
          case 'D': // Base día, incluye el 29 de febrero
            do {
              emision.add(Calendar.YEAR, 1);
            } while (emision.before(vencimiento));
            result = emision;
            break;
          default:
            break;
        }
        break;
      /**
       * Periodicidad diaria
       */
      case 'D':
        switch (baseInt) {
          case 'N':// Base normal 365 días (no incluye el 29 de febrero)
            do {
              if (emision.isLeapYear(emision.get(Calendar.YEAR)) && emision.get(Calendar.MONTH) == 1 && emision.get(Calendar.DATE) == 28) // Si el año no es bisiesto
              {
                emision.add(Calendar.DATE, 2);
              } else {
                emision.add(Calendar.DATE, 1);
              }
            } while (emision.before(vencimiento));
            result = emision;
            break;
          case 'C':// Base comercial 360 días (no incluye el 29 de febrero)
            do {
              if (emision.isLeapYear(emision.get(Calendar.YEAR)) && emision.get(Calendar.MONTH) == 1 && emision.get(Calendar.DATE) == 28) // Si el año no es bisiesto
              {
                emision.add(Calendar.DATE, 2);
              } else if (emision.get(Calendar.DATE) > 29) { // si el día de emisión es 30 ó 31
                emision.set(Calendar.DATE, 1); // pasar al primero del siguiente mes
                emision.add(Calendar.MONTH, 1);
              } else {
                emision.add(Calendar.DATE, 1);
              }
            } while (emision.before(vencimiento));
            result = emision;
          case 'D':// Base 366
            do {
              emision.add(Calendar.DATE, 1);
            } while (emision.before(vencimiento));
            result = emision;
            break;
          default:
            break;
        }
        break;
      /**
       * Periodicidad mensual
       */
      case 'M':
        switch (baseInt) {
          case 'N':// Base normal 365 días (no incluye el 29 de febrero)
            do { // Si el mes es enero y la periodicidad es mensual
              if (emision.get(Calendar.MONTH) == 0 && emision.get(Calendar.DATE) > 28) {
                flagComercial = emision.get(Calendar.DATE);
                emision.set(Calendar.DATE, 28);
                emision.set(Calendar.MONTH, 1); //Pasar a febrero 28
              } else if (emision.get(Calendar.MONTH) == 1 && emision.get(Calendar.DATE) == 28 && flagComercial != 0) {
                emision.set(Calendar.MONTH, 2); // Pasar a marzo
                emision.set(Calendar.DATE, flagComercial);
              } else if (flagComercial != 0) {
                if (flagComercial < 31) {
                  emision.add(Calendar.MONTH, 1);
                } else if (emision.get(Calendar.MONTH) == 2 || emision.get(Calendar.MONTH) == 4 || emision.get(Calendar.MONTH) == 7
                        || emision.get(Calendar.MONTH) == 9) {
                  emision.set(Calendar.DATE, 30);
                  emision.add(Calendar.MONTH, 1);
                } else {
                  emision.add(Calendar.MONTH, 1);
                  emision.set(Calendar.DATE, flagComercial);
                }
              } else {
                emision.add(Calendar.MONTH, 1);
              }
            } while (emision.before(vencimiento));
            result = emision;
            break;
          case 'C':// Base comercial 360 días (no incluye el 29 de febrero)
            if (emision.get(Calendar.DATE) > 30) {
              emision.set(Calendar.DATE, 30);
            }
            do {
              if (emision.get(Calendar.MONTH) == 0 && emision.get(Calendar.DATE) > 28) { // Si el mes es enero
                flagComercial = emision.get(Calendar.DATE);
                emision.set(Calendar.DATE, 28);
                emision.add(Calendar.MONTH, 1); // Pasar a febrero 28
              } else if (emision.get(Calendar.MONTH) == 1 && emision.get(Calendar.DATE) == 28 && flagComercial != 0) {
                emision.set(Calendar.MONTH, 2); // Pasar a marzo
                emision.set(Calendar.DATE, flagComercial);
              } else {
                emision.add(Calendar.MONTH, 1);
              }
            } while (emision.before(vencimiento));
            result = emision;
            break;
          case 'D':// Base 366
            do {
              emision.add(Calendar.MONTH, 1);
            } while (emision.before(vencimiento));
            result = emision;
            break;
          default:
            break;
        }
        break;
      /**
       * Periodicidad bimensual
       */
      case 'B':
        switch (baseInt) {
          case 'N':// Base normal 365 días (no incluye el 29 de febrero)
            if (emision.get(Calendar.DATE) > 28) {
              flagComercial = emision.get(Calendar.DATE);
            }
            do {
              month = emision.get(Calendar.MONTH);
              if (month == 11 && flagComercial > 28) {
                emision.set(Calendar.DATE, 28);
                emision.set(Calendar.MONTH, 1); //Pasar a febrero 28 del siguiente año
                emision.add(Calendar.YEAR, 1);
              } else if (flagComercial != 0) {
                if ((month == 1 || month == 3 || month == 6 || month == 8) && flagComercial > 30) {
                  emision.add(Calendar.MONTH, 2);
                  emision.set(Calendar.DATE, 30);
                } else {
                  emision.add(Calendar.MONTH, 2);
                  emision.set(Calendar.DATE, flagComercial);
                }
              } else {
                emision.add(Calendar.MONTH, 2); // Agregar dos meses a la fecha de emisión.
              }
            } while (emision.before(vencimiento));
            result = emision;
            break;
          case 'C':// Base comercial 360 días (no incluye el 29 de febrero)
            if (emision.get(Calendar.DATE) > 30) {
              emision.set(Calendar.DATE, 30);
            }
            do {
              if (emision.get(Calendar.MONTH) == 11 && emision.get(Calendar.DATE) > 28) {// Si el mes es diciembre
                flagComercial = emision.get(Calendar.DATE); // Guardar el día
                emision.set(Calendar.DATE, 28);
                emision.add(Calendar.MONTH, 2);
              } else if (emision.get(Calendar.MONTH) == 1 && emision.get(Calendar.DATE) > 27 && flagComercial != 0) {
                emision.set(Calendar.MONTH, 3);
                emision.set(Calendar.DATE, flagComercial);
              } else {
                emision.add(Calendar.MONTH, 2); // Sumar dos meses
              }
            } while (emision.before(vencimiento));
            result = emision;
            break;
          case 'D':
            do {
              emision.add(Calendar.MONTH, 2); // Agregar dos meses
            } while (emision.before(vencimiento));
            result = emision;
            break;
          default:
            break;
        }
        break;
      /**
       * Periodicidad trimestral
       */
      case 'T':
        switch (baseInt) {
          case 'N':// Base normal 365 días (no incluye el 29 de febrero)
            if (emision.get(Calendar.DATE) > 28) {
              flagComercial = emision.get(Calendar.DATE);
            }
            do {
              month = emision.get(Calendar.MONTH);
              if (month == 10 && flagComercial > 28) {
                emision.set(Calendar.DATE, 28);
                emision.set(Calendar.MONTH, 1); //Pasar a febrero 28 del siguiente año
                emision.add(Calendar.YEAR, 1);
              } else if (flagComercial != 0) {
                if ((month == 0 || month == 2 || month == 5 || month == 7) && flagComercial > 30) {
                  emision.add(Calendar.MONTH, 3);
                  emision.set(Calendar.DATE, 30);
                } else {
                  emision.add(Calendar.MONTH, 3);
                  emision.set(Calendar.DATE, flagComercial);
                }
              } else {
                emision.add(Calendar.MONTH, 3); // Agregar dos meses a la fecha de emisión.
              }
            } while (emision.before(vencimiento));
            result = emision;
            break;
          case 'C':// Base comercial 360 días (no incluye el 29 de febrero)
            if (emision.get(Calendar.DATE) > 30) {
              emision.set(Calendar.DATE, 30);
            }
            do {
              if (emision.get(Calendar.MONTH) == 10 && emision.get(Calendar.DATE) > 28) {// Si el mes es noviembre
                flagComercial = emision.get(Calendar.DATE); // Guardar el día
                emision.set(Calendar.DATE, 28);
                emision.add(Calendar.MONTH, 3);
              } else if (emision.get(Calendar.MONTH) == 1 && emision.get(Calendar.DATE) == 28 && flagComercial != 0) {
                emision.set(Calendar.MONTH, 4);
                emision.set(Calendar.DATE, flagComercial);
              } else {
                emision.add(Calendar.MONTH, 3); // sumar tres meses
              }
            } while (emision.before(vencimiento));
            result = emision;
            break;
          case 'D':
            do {
              emision.add(Calendar.MONTH, 3);
            } while (emision.before(vencimiento));
            result = emision;
            break;
          default:
            break;
        }
        break;
      /**
       * Periodicidad cuatrimestral
       */
      case 'C':
        switch (baseInt) {
          case 'N':// Base normal 365 días (no incluye el 29 de febrero)
            if (emision.get(Calendar.DATE) > 28) {
              flagComercial = emision.get(Calendar.DATE);
            }
            do {
              month = emision.get(Calendar.MONTH);
              if (month == 9 && flagComercial > 28) {
                emision.set(Calendar.DATE, 28);
                emision.add(Calendar.MONTH, 4);
              } else if (flagComercial != 0) {
                if ((month == 1 || month == 4 || month == 6 || month == 11) && flagComercial > 30) {
                  emision.add(Calendar.MONTH, 4);
                  emision.set(Calendar.DATE, 30);
                } else {
                  emision.add(Calendar.MONTH, 4);
                  emision.set(Calendar.DATE, flagComercial);
                }
              } else {
                emision.add(Calendar.MONTH, 4); // Agregar dos meses a la fecha de emisión.
              }
            } while (emision.before(vencimiento));
            result = emision;
            break;
          case 'C':// Base comercial 360 días (no incluye el 29 de febrero)
            if (emision.get(Calendar.DATE) > 30) {
              emision.set(Calendar.DATE, 30);
            }
            do {
              if (emision.get(Calendar.MONTH) == 9 && emision.get(Calendar.DATE) > 28) {// Si el mes es octubre
                flagComercial = emision.get(Calendar.DATE); // Guardar el día
                emision.set(Calendar.DATE, 28);
                emision.add(Calendar.MONTH, 4); // Sumar cuatro meses
              } else if (emision.get(Calendar.MONTH) == 1 && emision.get(Calendar.DATE) == 28 && flagComercial != 0) {
                emision.set(Calendar.MONTH, 5);  // Pasar a junio con la fecha anterior
                emision.set(Calendar.DATE, flagComercial);
              } else {
                emision.add(Calendar.MONTH, 4); // sumar 4 meses
              }
            } while (emision.before(vencimiento));
            result = emision;
            break;
          case 'D':
            do {
              emision.add(Calendar.MONTH, 4);
            } while (emision.before(vencimiento));
            result = emision;
            break;
          default:
            break;
        }
        break;
      /**
       * Periodicidad semestral
       */
      case 'S':
        switch (baseInt) {
          case 'N':// Base normal 365 días (no incluye el 29 de febrero)
            if (emision.get(Calendar.DATE) > 28) {
              flagComercial = emision.get(Calendar.DATE);
            }
            do {
              month = emision.get(Calendar.MONTH);
              if (month == 7 && flagComercial > 28) {
                emision.set(Calendar.DATE, 28);
                emision.add(Calendar.MONTH, 6);
              } else if (flagComercial != 0) {
                if ((month == 9 || month == 11 || month == 2 || month == 4) && flagComercial > 30) {
                  emision.add(Calendar.MONTH, 6);
                  emision.set(Calendar.DATE, 30);
                } else {
                  emision.add(Calendar.MONTH, 6);
                  emision.set(Calendar.DATE, flagComercial);
                }
              } else {
                emision.add(Calendar.MONTH, 6); // Agregar dos meses a la fecha de emisión.
              }
            } while (emision.before(vencimiento));
            result = emision;
            break;
          case 'C':
            if (emision.get(Calendar.DATE) > 30) {
              emision.set(Calendar.DATE, 30);
            }
            do {
              if (emision.get(Calendar.MONTH) == 7 && emision.get(Calendar.DATE) > 28) {// Si el mes es agosto
                flagComercial = emision.get(Calendar.DATE); // Guardar el día
                emision.set(Calendar.DATE, 28);
                emision.add(Calendar.MONTH, 6);
              } else if (emision.get(Calendar.MONTH) == 1 && emision.get(Calendar.DATE) == 28 && flagComercial != 0) {
                emision.set(Calendar.MONTH, 7);  // Pasar a junio con la fecha anterior
                emision.set(Calendar.DATE, flagComercial);
              } else {
                emision.add(Calendar.MONTH, 6);
              }
            } while (emision.before(vencimiento));
            result = emision;
            break;
          case 'D':
            do {
              emision.add(Calendar.MONTH, 6); // Sumar un semestre
            } while (emision.before(vencimiento));
            result = emision;
            break;
          default:
            break;
        }
        break;
      default:
        break;
    }
    return result;
  }

  /**
   * Agrega un caracter de separación a una fecha en formato String
   *
   * @param fecha String que contiene la fecha.
   * @return String con separador.
   */
  public String addSeparator(String fecha) {
    if (fecha.length() == 8) {
      String conSeparador = "";
      conSeparador = fecha.substring(0, 4);
      conSeparador += "-";
      conSeparador += fecha.substring(4, 6);
      conSeparador += "-";
      conSeparador += fecha.substring(6, 8);
      return conSeparador;
    } else {
      return fecha;
    }
  }
}

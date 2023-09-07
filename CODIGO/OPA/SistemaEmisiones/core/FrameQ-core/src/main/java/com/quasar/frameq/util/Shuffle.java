package com.quasar.frameq.util;

import java.security.SecureRandom;
import java.util.*;

public class Shuffle {
    public static void main(String args[]) {
        //List l = Arrays.asList(args);
        String[] basura = new String[4];
        for (int i=0; i<basura.length ;i++ ) {
          basura[i] = String.valueOf(i+1);
        }
        int[] nuevo = new int[4];
        for (int i=0; i<nuevo.length ; i++ ) {
          nuevo[i] = i+1;
        }
        List l = Arrays.asList(basura);
        HashMap operacion = new HashMap();
        int acumulado = 0;
        for (int i=0; i<nuevo.length ; i++ ) {
          for (int j=i+1; j<nuevo.length ;j++ ) {
            acumulado += nuevo[j];
          }
          //acumulado += nuevo[i];

        }

        acumulado = 0;
        seguir:
        for (int i=0; i<nuevo.length ; i++ ) {
          acumulado = 0;
          for (int k = i+1; k < nuevo.length; k ++) {
            // Armar las n-tuplas de elementos del arreglo
            acumulado = nuevo[i] + nuevo[k];
            //continue seguir;
          }
        }


        Vector permuta = new Vector();
        seguir:
        while (permuta.size() < 25) {
          SecureRandom random = new SecureRandom();
          Collections.shuffle(l, random);
          for (int j=0; j<permuta.size() ; j++ ) {
            if (permuta.elementAt(j).equals(l))
              continue seguir;
          }
          permuta.add(l);
        }
    }

    public void sumaVector () {

    double monto = 17.0d;
    double suma = 0.0d;
    double acumulado = 0.0d;
    SecureRandom elemento = new SecureRandom();

    double[] valores = new double[8];
    int[] valInt = new int[valores.length];
    for (int i=0; i<valInt.length; i++)
      valInt[i] = i+1;
    int[] indices = getNumbers(valInt);
    for (int i=0; i<valores.length; i++)
      valores[i] = valores.length-i;

    salir:
    for (int i=1; i<valores.length; i++) {
      for (int j=1; j<=valores.length-i; j++) { // Está bien, recorre todos los elementos una vez
        suma = 0.0d;
        for (int k=i; k<valores.length; k+=j) {
          acumulado = 0.0d;
          for (int l=1;l<k+1 ;l++ ) {
            acumulado += valores[l];
            if (l+k < valores.length)
              if (acumulado + valores[l+k] == monto)
                break salir;
          }
          suma += valores[k];

          if (suma == monto || valores[k] == monto || acumulado == monto)
            break salir;
        }
      }
      acumulado = 0;
      for (int m = i; m < valores.length; m ++) {
        // Armar las n-tuplas de elementos del arreglo
        acumulado = valores[i] + valores[m];
        if (acumulado == monto)
          break salir;
      }

    }
    for (int i=0; i<valores.length ; i++ ) {
    acumulado = 0;
      for (int k = i+1; k < valores.length; k ++) {
        // Armar las n-tuplas de elementos del arreglo
        acumulado = valores[i] + valores[k];
        //continue seguir;
      }
    }

    double aux = valores[0];

  }

  private int[] getNumbers(int[] valores) {

    SecureRandom choice = new SecureRandom();
    int[] numbers = new int[valores.length];   // Store for the numbers to be returned
    int candidate = 0;                      // Stores a candidate selection
    for(int i = 0; i < valores.length; i++) { // Loop to find the selections
      search:
      // Loop to find a new selection
      for(;;) { // different from any found so far
        candidate = valores[choice.nextInt(valores.length)];
        for(int j = 0 ; j<i ; j++)          // Check against existing selections
          if(candidate==numbers[j])         // If it is the same
            continue search;                // get another random selection

        numbers[i] = candidate;             // Store the selection in numbers array
        break;                              // and go to find the next
      }
    }
    int[] numeros = new int[3];
    for (int j=0;j<numeros.length ;j++ ) {
      numeros[j] = j+1;
    }
    String[] permuta = new String[(int)Math.pow(2,numeros.length)-2];
    for (int i=0;i<permuta.length ;i++ ) {
      permuta[i] = "0-0-0";
    }
    busqueda:
      for (; ; ) {
        int candidato = choice.nextInt(numeros.length);
        for (int i=0;i<permuta.length ;i++ ) {
          for (int j=0;j<numeros.length ;j++ ) {
            //if ()

          }


        }
       break;
      }


    return numbers;                         // Return the selections
  }

}

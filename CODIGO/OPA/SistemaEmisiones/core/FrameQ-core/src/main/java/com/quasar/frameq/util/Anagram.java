package com.quasar.frameq.util;

import java.util.*;


  public class Anagram {


    public Vector MixItUp(String TheInput) {
      Vector permuta = new Vector();
      String seed = null;
      StringBuffer sb = new StringBuffer();

        for (int i=0; i<TheInput.length() ;i++){
          seed = TheInput.substring(i,i+1);
          seguir:
          for (int j=0;j<TheInput.length();j++) {
              sb = new StringBuffer(TheInput);
              sb.deleteCharAt(i);
              sb.insert(j,seed);
              for (int k=0; k<permuta.size() ; k++ ) {
                if (permuta.elementAt(k).equals(sb.toString()))
                  continue seguir;
              }
              permuta.add(sb.toString());
          }
        }
      return permuta;
    }


    public static void main (String[] args) {
      String testString = "123";
      Anagram testGram = new Anagram();
      Vector myAnagram = new Vector();
      myAnagram = testGram.MixItUp(testString);
      myAnagram.trimToSize();
      String temp = null;


      for (int i=0; i<myAnagram.size(); i++){
        temp = myAnagram.get(i).toString();
        temp = temp.trim();

        if (temp.equals((String)"genuine")) {
        }
      }
    }
  }
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.domain;

/**
 *
 * @author Roger Padilla C.
 */
public class BasicData implements Comparable<BasicData> {

  private String label;
  private String value;

  public BasicData() {
  }

  public BasicData(String label, String value) {
    this.label = label;
    this.value = value;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public int compareTo(BasicData o) {
    return label.compareTo(o.getLabel());
  }

}

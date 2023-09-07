package com.framework.common.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Roger Padilla C.
 */
public class TwoObjectsDate implements Serializable {

  private Object object1;
  private Object object2;
  private Date date;

  public Object getObject1() {
    return object1;
  }

  public void setObject1(Object object1) {
    this.object1 = object1;
  }

  public Object getObject2() {
    return object2;
  }

  public void setObject2(Object object2) {
    this.object2 = object2;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "TwoObjectsDate{" + "object1=" + object1 + ", object2=" + object2 + ", date=" + date + '}';
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 97 * hash + (this.object1 != null ? this.object1.hashCode() : 0);
    hash = 97 * hash + (this.object2 != null ? this.object2.hashCode() : 0);
    hash = 97 * hash + (this.date != null ? this.date.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final TwoObjectsDate other = (TwoObjectsDate) obj;
    if (this.object1 != other.object1 && (this.object1 == null || !this.object1.equals(other.object1))) {
      return false;
    }
    if (this.object2 != other.object2 && (this.object2 == null || !this.object2.equals(other.object2))) {
      return false;
    }
    if (this.date != other.date && (this.date == null || !this.date.equals(other.date))) {
      return false;
    }
    return true;
  }

}
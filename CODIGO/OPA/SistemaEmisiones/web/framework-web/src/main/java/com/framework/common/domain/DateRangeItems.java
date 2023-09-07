package com.framework.common.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * @author Roger Padilla C.
 */
public class DateRangeItems implements Serializable {

    private Date dateStart;
    private Date dateEnd;
    private Collection<String> items;

    public Date getDateStart() {
      return dateStart;
    }

    public void setDateStart(Date dateStart) {
      this.dateStart = dateStart;
    }

    public Date getDateEnd() {
      return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
      this.dateEnd = dateEnd;
    }

    public Collection<String> getItems() {
      return items;
    }

    public void setItems(Collection<String> items) {
      this.items = items;
    }

    @Override
    public int hashCode() {
      int hash = 3;
      hash = 53 * hash + (this.dateStart != null ? this.dateStart.hashCode() : 0);
      hash = 53 * hash + (this.dateEnd != null ? this.dateEnd.hashCode() : 0);
      hash = 53 * hash + (this.items != null ? this.items.hashCode() : 0);
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
      final DateRangeItems other = (DateRangeItems) obj;
      if (this.dateStart != other.dateStart && (this.dateStart == null || !this.dateStart.equals(other.dateStart))) {
        return false;
      }
      if (this.dateEnd != other.dateEnd && (this.dateEnd == null || !this.dateEnd.equals(other.dateEnd))) {
        return false;
      }
      if (this.items != other.items && (this.items == null || !this.items.equals(other.items))) {
        return false;
      }
      return true;
    }

    @Override
    public String toString() {
      return "DateRangeNemotecnicos{" + "dateStart=" + dateStart + ", dateEnd=" + dateEnd + ", items=" + items + '}';
    }
  }
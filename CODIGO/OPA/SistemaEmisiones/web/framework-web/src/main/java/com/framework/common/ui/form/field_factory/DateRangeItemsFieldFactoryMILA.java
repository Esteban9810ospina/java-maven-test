/*
 * Información de Valoración framework, Bolsa de Valores de Colombia BVC
 * Copyright (C) 2012 Quasar Software Ltda.
 */
package com.framework.common.ui.form.field_factory;

import com.quasar.frameq.db.DataSourceUtil;
import com.quasar.frameq.util.DateUtil;
import com.vaadin.data.Item;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TwinColSelect;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Roger Padilla C.
 */
public class DateRangeItemsFieldFactoryMILA extends DefaultFieldFactory {

  @Override
  public Field createField(Item item, Object propertyId, Component uiContext) {
    Field f = null;
    if ("dateStart".equals(propertyId)) {
      f = createPopupDateField("Fecha inicial");
    } else if ("dateEnd".equals(propertyId)) {
      f = createPopupDateField("Fecha final");
    } else if ("items".equals(propertyId)) {
      f = createItemsField();
    }
    return f;
  }

  protected Field createPopupDateField(String name) {
    PopupDateField field = new PopupDateField(name);
    field.setDateFormat(DateUtil.YYYY_MM_DD);
    field.setResolution(PopupDateField.RESOLUTION_DAY);
    field.setRequired(true);
    field.setRequiredError("Ingrese la " + name);
    return field;
  }

  protected Field createItemsField() {
    JdbcTemplate jt = new JdbcTemplate(DataSourceUtil.getInstance().obtainDataSource());
    List<String> itemsData = jt.queryForList("SELECT DISTINCT c_nemotecnico"
            + " FROM va_especie where c_mgc in ('I') ORDER BY c_nemotecnico", String.class);
    TwinColSelect field = new TwinColSelect("Nemotécnico", itemsData);
    field.setRequired(true);
    field.setRequiredError("Seleccione un ítem al menos");
    field.setMultiSelect(true);
    field.setLeftColumnCaption("No seleccionados");
    field.setRightColumnCaption("Seleccionados");
    return field;
  }
}

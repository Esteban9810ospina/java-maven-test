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
public class DateRangeTwinColSelectFieldFactoryMI extends DateRangeItemsFieldFactory {
    
    @Override
  protected TwinColSelect createItemsField() {
    JdbcTemplate jt = new JdbcTemplate(DataSourceUtil.getInstance().obtainDataSource());
    List<String> itemsData = jt.queryForList("SELECT DISTINCT c_nemotecnico"
            + " FROM va_especie ORDER BY c_nemotecnico", String.class);
    TwinColSelect field = new TwinColSelect("Nemotécnico", itemsData);
    field.setRequired(true);
    field.setRequiredError("Seleccione un ítem al menos");
    field.setMultiSelect(true);
    field.setLeftColumnCaption("No seleccionados");
    field.setRightColumnCaption("Seleccionados");
    return field;
  }
}

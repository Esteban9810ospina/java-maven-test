/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.persistence.jdbc.rowmapper;

import com.framework.common.domain.BasicData;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Carlos Uribe
 */
public class BasicDataMapper implements RowMapper<BasicData> {

  @Override
  public BasicData mapRow(ResultSet rs, int rowNum) throws SQLException {

    BasicData basicData = new BasicData();
    basicData.setLabel(rs.getString("label"));
    basicData.setValue(rs.getString("value"));
    return basicData;
  }
}

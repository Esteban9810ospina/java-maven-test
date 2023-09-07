/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common.service;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 *
 * @author Roger Padilla C.
 */
public abstract class AbstractServiceDao extends AbstractService {

  protected JdbcTemplate jdbcTemplate;
  protected NamedParameterJdbcTemplate namedTemplate;

	/**
	 * Set the JDBC DataSource to be used by this DAO.
	 */
  @Autowired
	public final void setDataSource(DataSource dataSource) {
		if (this.jdbcTemplate == null || dataSource != this.jdbcTemplate.getDataSource()) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
      this.namedTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate);
		}
	}

  public JdbcTemplate getJdbcTemplate() {
    return jdbcTemplate;
  }

}

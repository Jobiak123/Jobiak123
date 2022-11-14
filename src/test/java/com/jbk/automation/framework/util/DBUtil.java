package com.jbk.automation.framework.util;



/**
 * @author SYalavarthi
 *
 */

import java.util.List;
import java.util.Map;
import java.util.Properties;

//import org.apache.poi.ss.formula.functions.T;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.jbk.mh.beans.TempBean;


@Component(value = "dbUtil")
public class DBUtil {

	private static final Properties queries = new Properties();
	static {
		try {
			queries.loadFromXML(DBUtil.class.getClassLoader()
					.getResourceAsStream("sql.xml"));
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static String getNamedQuery(String queryName) {
		return queries.getProperty(queryName);
	}

	public Object getObject(JdbcTemplate jdbcTemplate, String query) {
		
		return jdbcTemplate.queryForObject(query, Object.class);
	}

	public Object getObject(JdbcTemplate jdbcTemplate,
			String query, Object[] params) {
		return jdbcTemplate.queryForObject(query, params,Object.class);
	}
	
	public List<Map<String, Object>> getRows(JdbcTemplate jdbcTemplate,
			String query, Object[] params) {
		return jdbcTemplate.queryForList(query, params);
	}

	public List<Map<String, Object>> getRows(JdbcTemplate jdbcTemplate,
			String query) {
		return jdbcTemplate.queryForList(query);
	}
	
	
	
	
	  public List<TempBean> getRowsUsingRowMapper(JdbcTemplate jdbcTemplate, String
	  query,RowMapper<TempBean> rowMapper) { return
	  jdbcTemplate.query(query,rowMapper); }
	 
	
	public int setObject(JdbcTemplate jdbcTemplate,
			String query, Object[] params) {
		return jdbcTemplate.update(query,params);
	}
	
	public int setObject(JdbcTemplate jdbcTemplate,
			String query) {
		return jdbcTemplate.update(query);
	} 
	
	
}

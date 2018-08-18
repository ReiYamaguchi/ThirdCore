package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;


public interface DaoInterface {
	public String[] selectall(String arrayed);
	public int select(String[] arrayed);
	public int alter(String[] arrayed);
	public List<Map<String,Object>> mention(String arrayed2);
	public void proce(MapSqlParameterSource in,String proce);

	
}

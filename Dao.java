package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
/*
 * SQL文を受けとり実行するクラスです。
 */
@Repository
public class Dao implements DaoInterface {

	
	@Autowired
	JdbcTemplate jdbctemplate;
	
	//検索判定
	public int dao;
	
	/*
	 * データベースのデータを根こそぎ持ってくる
	 * @see com.dao.DaoInterface#selectall(java.lang.String[])
	 */
	
	@Override
	public String[] selectall(String arrayed) {
		
		List<Map<String, Object>> list = jdbctemplate.queryForList(arrayed);
		
		String[] dao=new String[4];
		dao[0] = list.get(0).get("user_name").toString();
		dao[1] = list.get(0).get("birth_day").toString();
		dao[2] = list.get(0).get("birth_place").toString();
		dao[3] = list.get(0).get("user_memo").toString();
	
		return dao;
	}
	
	
	
	/*
	 *検索メゾット 
	 */
	public int select(String[] arrayed) {
		dao=2;
		//失敗0,成功1,初期2
		if(arrayed[0]!=null) {
			
		dao = jdbctemplate.queryForObject(arrayed[1],Integer.class);
		return dao;
		}
		return dao;
	}
	
	/*
	 * 追加、更新、削除メゾット
	 */
	public int alter(String[] arrayed) {
		dao=2;
		if(arrayed[0]!=null) {
			dao=jdbctemplate.update(arrayed[1]);
			return dao;
		}
		return dao;
	}
	
	
	public List<Map<String,Object>> mention(String arrayed2){
		List<Map<String, Object>> list = jdbctemplate.queryForList(arrayed2);
		return list;
	}
	
	
	/*
	 * プロシージャ起動メゾット
	 */
	public void proce(MapSqlParameterSource in,String proce) {	
		jdbctemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall callProcedure =new SimpleJdbcCall(jdbctemplate);
		callProcedure.withProcedureName(proce);
		callProcedure.execute();
		
	}

	


	
	


	
}

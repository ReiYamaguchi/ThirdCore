package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
/*
 * SQL�����󂯂Ƃ���s����N���X�ł��B
 */
@Repository
public class Dao implements DaoInterface {

	
	@Autowired
	JdbcTemplate jdbctemplate;
	
	//��������
	public int dao;
	
	/*
	 * �f�[�^�x�[�X�̃f�[�^���������������Ă���
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
	 *�������]�b�g 
	 */
	public int select(String[] arrayed) {
		dao=2;
		//���s0,����1,����2
		if(arrayed[0]!=null) {
			
		dao = jdbctemplate.queryForObject(arrayed[1],Integer.class);
		return dao;
		}
		return dao;
	}
	
	/*
	 * �ǉ��A�X�V�A�폜���]�b�g
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
	 * �v���V�[�W���N�����]�b�g
	 */
	public void proce(MapSqlParameterSource in,String proce) {	
		jdbctemplate.setResultsMapCaseInsensitive(true);
		SimpleJdbcCall callProcedure =new SimpleJdbcCall(jdbctemplate);
		callProcedure.withProcedureName(proce);
		callProcedure.execute();
		
	}

	


	
	


	
}

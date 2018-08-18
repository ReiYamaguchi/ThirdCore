package com.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.dao.DaoInterface;
import com.form.FormLogin;
import com.form.HomeForm;




@Service
@ComponentScan("com.dao")
public class HomeService implements HomeInterface {

	
	ModelAndView model = new ModelAndView();
	
	public String code_master;
	public int count;
	
	@Autowired
	public DaoInterface dao;
	
	public Object homesyoki(String code) {
		code_master=code;
		
		String arrayed2="select mention_content from base.user_mention order by insert_date desc";
		
		model.addObject("customers",dao.mention(arrayed2));
		
		String arrayed ="select user_name,birth_day,birth_place,user_memo from base.user_info where user_id='"+code+"';";
		String[] profile=dao.selectall(arrayed);
		
		//テスト
		model.addObject("user_name",profile[0]);
		model.addObject("birth_day",profile[1]);
		model.addObject("birth_place",profile[2]);
		model.addObject("user_memo",profile[3]);
		model.addObject("hyouzi",true);
		model.addObject("change","change");
		model.setViewName("home.html");
		return model;
	}
	
	public Object syokiupdate(HomeForm form)
	{
		
		
		String array ="update base.user_info set user_name='"+form.getUser_name()+"',birth_day='"+form.getBirth_day()+"',birth_place='"+form.getBirth_place()+"',user_memo='"+form.getUser_memo()+"'where user_id='"+ code_master+"';";
		
		String arrayed[]= {"引数なし",array};
		model.addObject("hyouzi",false);
		model.addObject("change","update");
		dao.alter(arrayed);
		if(0==count) {
			count+=1;
			model.setViewName("home.html");
		return model;
		}
		count-=1;
		
		return "redirect:http://localhost:8080/login/home";
	}

	@Override
	public Object altermention(HomeForm form) {
		
String array ="insert into base.user_mention(user_id,mention_content,insert_date,update_date) values ('"+code_master+"','"+form.getMention_content()+"',now(),now());";		
		String arrayed[]= {"引数なし",array};
	
		dao.alter(arrayed);
		
		return "redirect:http://localhost:8080/login/home";
	}
	
	
	
	public Object bbb(String code) {
		code_master=code;
		
		String arrayed2="select mention_content from base.user_mention order by insert_date desc";
		
		model.addObject("customers",dao.mention(arrayed2));
				
		//テスト
		model.setViewName("chart.html");
		return model;
	}
	
}

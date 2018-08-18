package com.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.form.FormLogin;
import com.form.HomeForm;
import com.home.service.HomeInterface;

/*
 * ThirdCore ver1.0
 * ホーム画面
 */
@Controller
@ComponentScan("com.form")
@ComponentScan("com.home.service")
public class HomeController {

	@Autowired
	public HomeInterface service;
	@Autowired
	public HomeForm form;
	
	ModelAndView model = new ModelAndView();
	
	/*
	 *ログイン画面(初期)
	 *profile欄の読み込み 
	 *
	 */
	@RequestMapping(value = "/login/home", method = RequestMethod.GET)
	public Object home() {
		String  name="@yamaguchi";
		
		return service.homesyoki(name);
	}
	
	@RequestMapping(value = "/login/home", method = RequestMethod.POST)
	public Object profileupdate(@ModelAttribute HomeForm form) {
		return service.syokiupdate(form);
	}
	
	@RequestMapping(value = "/mention", method = RequestMethod.POST)
	public Object mentionalter(@ModelAttribute HomeForm form) {
		return service.altermention(form);
	}
	
	@RequestMapping(value = "/chart", method = RequestMethod.GET)
	public Object aaa(@ModelAttribute HomeForm form) {
		String  name="@yamaguchi";
		
		return service.bbb(name);
	}
	
	
	
	
}

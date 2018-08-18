package com.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.form.FormLogin;
import com.login.service.LoginInterface;

/*
 * Controllerクラス
 * 
 * <遷移先>
 * ログイン画面⇔登録画面
 * ログイン画面⇒ホーム画面
 * 
 * @version ThridCore ver1.0
 * @author Rei.Yamaguchi
 */
@Controller
@ComponentScan("com.login.service")
@ComponentScan("com.form")
public class LoginController {
	/*
	 * 自動マッピング先
	 * @param serivce com.login.LoginServiceクラスのインスタンスが含まれている
	 * @param form com.from.FormLoginクラスのインスタンスが含まれている
	 */
	@Autowired
	public LoginInterface service;
	@Autowired
	public FormLogin form;
    //ModelAndViewの統一化
	ModelAndView model = new ModelAndView();
	
	/*
	 * フォームにnullの投入
	 */
	@InitBinder
	public void initbinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	/*
	 *ログイン画面(初期)
	 *@return model 
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public Object login() {
		model.addObject("isEven", false);
		model.setViewName("login.html");
		return model;
	}
	
	/*
	 *アカウント作成画面(初期)
	 *@return model
	 */
	@RequestMapping(value = "new", method = RequestMethod.GET)
	public Object NewAccount() {
		//model.addObject("isEven", false);
		model.setViewName("login.html");
		return model;
	}
	
	/*
	 *ログイン画面(ログインイベント)
	 *return 成功時home画面 失敗時login画面 
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public Object login(RedirectAttributes attributes,@ModelAttribute FormLogin form) {
		//受け渡し
		attributes.addFlashAttribute("name",form.getName());
		return service.Shyouzi(form);
	}

	/*
	 * 新規アカウント作成画面(アカウント作成イベント時)
	 * return 成功時　アカウント作成画面　失敗時　アカウント作成画面(失敗表示)
	 */
	@RequestMapping(value = "new", method = RequestMethod.POST)
	public Object NewAccount(@ModelAttribute FormLogin form) {

		return service.Snew(form);
	}
}

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
 * Controller�N���X
 * 
 * <�J�ڐ�>
 * ���O�C����ʁ̓o�^���
 * ���O�C����ʁ˃z�[�����
 * 
 * @version ThridCore ver1.0
 * @author Rei.Yamaguchi
 */
@Controller
@ComponentScan("com.login.service")
@ComponentScan("com.form")
public class LoginController {
	/*
	 * �����}�b�s���O��
	 * @param serivce com.login.LoginService�N���X�̃C���X�^���X���܂܂�Ă���
	 * @param form com.from.FormLogin�N���X�̃C���X�^���X���܂܂�Ă���
	 */
	@Autowired
	public LoginInterface service;
	@Autowired
	public FormLogin form;
    //ModelAndView�̓��ꉻ
	ModelAndView model = new ModelAndView();
	
	/*
	 * �t�H�[����null�̓���
	 */
	@InitBinder
	public void initbinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	/*
	 *���O�C�����(����)
	 *@return model 
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public Object login() {
		model.addObject("isEven", false);
		model.setViewName("login.html");
		return model;
	}
	
	/*
	 *�A�J�E���g�쐬���(����)
	 *@return model
	 */
	@RequestMapping(value = "new", method = RequestMethod.GET)
	public Object NewAccount() {
		//model.addObject("isEven", false);
		model.setViewName("login.html");
		return model;
	}
	
	/*
	 *���O�C�����(���O�C���C�x���g)
	 *return ������home��� ���s��login��� 
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public Object login(RedirectAttributes attributes,@ModelAttribute FormLogin form) {
		//�󂯓n��
		attributes.addFlashAttribute("name",form.getName());
		return service.Shyouzi(form);
	}

	/*
	 * �V�K�A�J�E���g�쐬���(�A�J�E���g�쐬�C�x���g��)
	 * return �������@�A�J�E���g�쐬��ʁ@���s���@�A�J�E���g�쐬���(���s�\��)
	 */
	@RequestMapping(value = "new", method = RequestMethod.POST)
	public Object NewAccount(@ModelAttribute FormLogin form) {

		return service.Snew(form);
	}
}

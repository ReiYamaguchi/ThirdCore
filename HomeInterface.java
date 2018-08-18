package com.home.service;


import com.form.HomeForm;


public interface HomeInterface {
	public Object homesyoki(String code);
	public Object syokiupdate(HomeForm form);
	public Object altermention(HomeForm form);
	public Object bbb(String code);
}

package com.login.service;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.form.FormLogin;


public interface LoginInterface {
  public Object Shyouzi(FormLogin from);
  public Object Snew(FormLogin from);
}

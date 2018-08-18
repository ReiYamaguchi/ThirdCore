package com.form;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Component
public class FormLogin {
	private String name;
	private String password;
}

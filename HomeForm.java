package com.form;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Component
public class HomeForm {
	private String user_name;
	private String birth_day;
	private String birth_place;
	private String user_memo;
	
	private String mention_content;
}

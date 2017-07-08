package com.intv.appone.vo;

import lombok.AllArgsConstructor;
import lombok.Data;


public class ServiceResponse {
	
	public ServiceResponse(String message) {
		super();
		this.message = message;
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}

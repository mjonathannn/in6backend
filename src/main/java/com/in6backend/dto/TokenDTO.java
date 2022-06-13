package com.in6backend.dto;

import java.io.Serializable;

public class TokenDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String token;

	public TokenDTO() {
		super();
	}

	public TokenDTO(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
package com.in6backend.dto;

import java.io.Serializable;

import com.in6backend.entities.TypeOfPay;

public class TypeOfPayDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String type;

	public TypeOfPayDTO() {
		super();
	}

	public TypeOfPayDTO(Long id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public TypeOfPayDTO(TypeOfPay typeOfPay) {
		id = typeOfPay.getId();
		type = typeOfPay.getType();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}

package com.in6backend.dto;

import java.io.Serializable;

import com.in6backend.entities.TypeOfWorkload;

public class TypeOfWorkloadDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String type;

	public TypeOfWorkloadDTO() {
		super();
	}

	public TypeOfWorkloadDTO(Long id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public TypeOfWorkloadDTO(TypeOfWorkload typeOfWorkload) {
		id = typeOfWorkload.getId();
		type = typeOfWorkload.getType();
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
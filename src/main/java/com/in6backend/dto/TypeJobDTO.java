package com.in6backend.dto;

import java.io.Serializable;

import com.in6backend.entities.TypeJob;

public class TypeJobDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String type;

	public TypeJobDTO() {
		super();
	}

	public TypeJobDTO(Long id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public TypeJobDTO(TypeJob typeJob) {
		id = typeJob.getId();
		type = typeJob.getType();
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

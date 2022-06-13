package com.in6backend.dto;

import java.io.Serializable;

import com.in6backend.entities.State;

public class StateDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;

	public StateDTO() {
		super();
	}

	public StateDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public StateDTO(State state) {
		id = state.getId();
		name = state.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
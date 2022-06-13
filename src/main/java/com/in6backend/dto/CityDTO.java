package com.in6backend.dto;

import java.io.Serializable;

import com.in6backend.entities.City;

public class CityDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private StateDTO stateDTO;

	public CityDTO() {
		super();
	}

	public CityDTO(Long id, String name, StateDTO stateDTO) {
		super();
		this.id = id;
		this.name = name;
		this.stateDTO = stateDTO;
	}

	public CityDTO(City city) {
		id = city.getId();
		name = city.getName();
		stateDTO = new StateDTO(city.getState());
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

	public StateDTO getStateDTO() {
		return stateDTO;
	}

	public void setStateDTO(StateDTO stateDTO) {
		this.stateDTO = stateDTO;
	}
}
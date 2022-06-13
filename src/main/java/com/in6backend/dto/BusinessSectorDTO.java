package com.in6backend.dto;

import java.io.Serializable;

import com.in6backend.entities.BusinessSector;

public class BusinessSectorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String sector;

	public BusinessSectorDTO() {
		super();
	}

	public BusinessSectorDTO(Long id, String sector) {
		super();
		this.id = id;
		this.sector = sector;
	}

	public BusinessSectorDTO(BusinessSector businessSector) {
		id = businessSector.getId();
		sector = businessSector.getSector();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}
}

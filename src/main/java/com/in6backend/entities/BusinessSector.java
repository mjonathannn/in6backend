package com.in6backend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.in6backend.dto.BusinessSectorDTO;

@Entity
@Table(name = "tb_business_sector")
public class BusinessSector {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String sector;

	@OneToOne
	@JoinColumn(name = "id_company")
	private Company company;

	public BusinessSector() {
		super();
	}

	public BusinessSector(Long id, String sector, Company company) {
		super();
		this.id = id;
		this.sector = sector;
		this.company = company;
	}

	public BusinessSector(BusinessSectorDTO businessSectorDTO) {
		id = businessSectorDTO.getId();
		sector = businessSectorDTO.getSector();
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}

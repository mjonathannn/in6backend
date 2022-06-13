package com.in6backend.dto;

import java.io.Serializable;

public class CompanyDTOInput implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String email;
	private String password;
	private String phone;
	private CityDTO cityDTO;
	private BusinessSectorDTO businessSectorDTO;

	public CompanyDTOInput() {
		super();
	}

	public CompanyDTOInput(Long id, String name, String email, String password, String phone, CityDTO cityDTO,
			BusinessSectorDTO businessSectorDTO) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.cityDTO = cityDTO;
		this.businessSectorDTO = businessSectorDTO;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public CityDTO getCityDTO() {
		return cityDTO;
	}

	public void setCityDTO(CityDTO cityDTO) {
		this.cityDTO = cityDTO;
	}

	public BusinessSectorDTO getBusinessSectorDTO() {
		return businessSectorDTO;
	}

	public void setBusinessSectorDTO(BusinessSectorDTO businessSectorDTO) {
		this.businessSectorDTO = businessSectorDTO;
	}
}

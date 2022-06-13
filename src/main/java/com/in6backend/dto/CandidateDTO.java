package com.in6backend.dto;

import java.io.Serializable;

import com.in6backend.entities.Candidate;

public class CandidateDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String cpf;
	private String name;
	private String lastName;
	private String email;
	private String phone;
	private String occupation;
	private String whatsapp;
	private CityDTO cityDTO;

	public CandidateDTO() {
		super();
	}

	public CandidateDTO(Long id, String cpf, String name, String lastName, String email, String phone,
			String occupation, String whatsapp, CityDTO cityDTO) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.occupation = occupation;
		this.whatsapp = whatsapp;
		this.cityDTO = cityDTO;
	}

	public CandidateDTO(Candidate candidate) {
		this.id = candidate.getId();
		this.cpf = candidate.getCpf();
		this.name = candidate.getName();
		this.lastName = candidate.getLastName();
		this.email = candidate.getEmail();
		this.phone = candidate.getPhone();
		this.occupation = candidate.getOccupation();
		this.whatsapp = candidate.getWhatsapp();
		this.cityDTO = new CityDTO(candidate.getCity());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public CityDTO getCityDTO() {
		return cityDTO;
	}

	public void setCityDTO(CityDTO cityDTO) {
		this.cityDTO = cityDTO;
	}
}

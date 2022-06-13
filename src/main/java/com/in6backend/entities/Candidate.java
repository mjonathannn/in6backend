package com.in6backend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.in6backend.dto.CandidateDTO;

@Entity
@Table(name = "tb_candidate")
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String cpf;
	private String name;
	private String lastName;
	private String email;
	private String phone;
	private String occupation;
	private String whatsapp;
	// private StatusDoCandidatoEnum statusDoCandidato;
	// private boolean aindaEstaEmUmaVaga;

	@ManyToOne
	@JoinColumn(name = "id_city")
	private City city;

	public Candidate() {
		super();
	}

	public Candidate(Long id, String cpf, String name, String lastName, String email, String phone, String occupation,
			String whatsapp, City city) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.occupation = occupation;
		this.whatsapp = whatsapp;
		this.city = city;
	}

	public Candidate(CandidateDTO candidateDTOInput) {
		id = candidateDTOInput.getId();
		cpf = candidateDTOInput.getCpf();
		name = candidateDTOInput.getName();
		lastName = candidateDTOInput.getLastName();
		email = candidateDTOInput.getEmail();
		phone = candidateDTOInput.getPhone();
		occupation = candidateDTOInput.getOccupation();
		whatsapp = candidateDTOInput.getWhatsapp();
		city = new City(candidateDTOInput.getCityDTO());
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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
}
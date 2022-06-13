package com.in6backend.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.in6backend.dto.CityDTO;

@Entity
@Table(name = "tb_city")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@ManyToOne
	@JoinColumn(name = "id_state")
	private State state;

	@OneToMany(mappedBy = "city")
	private List<Company> companies = new ArrayList<>();

	@OneToMany(mappedBy = "city")
	private List<Vacancy> vacancies;

	@OneToMany(mappedBy = "city")
	private List<Candidate> candidates = new ArrayList<>();

	public City() {
		super();
	}

	public City(Long id, String name, State state, List<Company> companies, List<Vacancy> vacancies,
			List<Candidate> candidates) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
		this.companies = companies;
		this.vacancies = vacancies;
		this.candidates = candidates;
	}

	public City(CityDTO cityDTO) {
		id = cityDTO.getId();
		name = cityDTO.getName();
		state = new State(cityDTO.getStateDTO());
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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public List<Vacancy> getVacancies() {
		return vacancies;
	}

	public void setVacancies(List<Vacancy> vacancies) {
		this.vacancies = vacancies;
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}
}
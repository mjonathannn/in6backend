package com.in6backend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_vacancy_candidate")
public class VacancyCandidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long idVacancy;
	private String cpfCandidate;

	public VacancyCandidate() {
		super();
	}

	public VacancyCandidate(Long id, Long idVacancy, String cpfCandidate) {
		super();
		this.id = id;
		this.idVacancy = idVacancy;
		this.cpfCandidate = cpfCandidate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdVacancy() {
		return idVacancy;
	}

	public void setIdVacancy(Long idVacancy) {
		this.idVacancy = idVacancy;
	}

	public String getCpfCandidate() {
		return cpfCandidate;
	}

	public void setCpfCandidate(String cpfCandidate) {
		this.cpfCandidate = cpfCandidate;
	}
}

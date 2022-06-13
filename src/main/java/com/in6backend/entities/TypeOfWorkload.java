package com.in6backend.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.in6backend.dto.TypeOfWorkloadDTO;

@Entity
@Table(name = "tb_type_of_workload")
public class TypeOfWorkload {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String type;

	@OneToMany(mappedBy = "typeOfWorkload")
	private List<Vacancy> vacancies;

	public TypeOfWorkload() {
		super();
	}

	public TypeOfWorkload(Long id, String type, List<Vacancy> vacancies) {
		super();
		this.id = id;
		this.type = type;
		this.vacancies = vacancies;
	}

	public TypeOfWorkload(TypeOfWorkloadDTO typeOfWorkloadDTO) {
		id = typeOfWorkloadDTO.getId();
		type = typeOfWorkloadDTO.getType();
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

	public List<Vacancy> getVacancies() {
		return vacancies;
	}

	public void setVacancies(List<Vacancy> vacancies) {
		this.vacancies = vacancies;
	}
}

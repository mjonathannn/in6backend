package com.in6backend.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.in6backend.dto.TypeJobDTO;

@Entity
@Table(name = "tb_type_job")
public class TypeJob {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String type;

	@OneToMany(mappedBy = "typeJob")
	private List<Vacancy> vacancies;

	public TypeJob() {
		super();
	}

	public TypeJob(Long id, String type, List<Vacancy> vacancies) {
		super();
		this.id = id;
		this.type = type;
		this.vacancies = vacancies;
	}

	public TypeJob(TypeJobDTO typeJobDTO) {
		id = typeJobDTO.getId();
		type = typeJobDTO.getType();
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

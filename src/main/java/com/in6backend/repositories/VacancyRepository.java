package com.in6backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in6backend.entities.Vacancy;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {

	List<Vacancy> findByCompanyEmail(String email);
}

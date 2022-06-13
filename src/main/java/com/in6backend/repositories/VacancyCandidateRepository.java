package com.in6backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in6backend.entities.VacancyCandidate;

public interface VacancyCandidateRepository extends JpaRepository<VacancyCandidate, Long> {

	List<VacancyCandidate> findByIdVacancy(Long vacancyId);
}

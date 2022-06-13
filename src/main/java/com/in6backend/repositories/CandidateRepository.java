package com.in6backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in6backend.entities.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
	
	boolean existsByCpf(String cpf);
	Candidate findByCpf(String cpf);
}

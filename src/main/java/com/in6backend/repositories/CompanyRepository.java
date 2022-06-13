package com.in6backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in6backend.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

	boolean existsByEmail(String email);
	boolean existsByPhone(String phone);
	Company findByEmail(String email);
}

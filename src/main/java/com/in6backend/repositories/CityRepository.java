package com.in6backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.in6backend.entities.City;

public interface CityRepository extends JpaRepository<City, Long>{
	
	@Query(value = "SELECT * FROM tb_city WHERE id_state = ?", nativeQuery = true)
	List<City> findAllCitiesByState(Long id);
}

package com.in6backend.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in6backend.dto.CityDTO;
import com.in6backend.entities.City;
import com.in6backend.repositories.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository cityRepository;

	public List<CityDTO> findAllCitiesByState(Long id) {
		List<City> result = cityRepository.findAllCitiesByState(id);
		
		return result.stream().map(item -> new CityDTO(item)).collect(Collectors.toList());
	}
}
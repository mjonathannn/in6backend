package com.in6backend.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in6backend.dto.BusinessSectorDTO;
import com.in6backend.entities.BusinessSector;
import com.in6backend.repositories.BusinessSectorRepository;

@Service
public class BusinessSectorService {

	@Autowired
	private BusinessSectorRepository businessSectorRepository;

	public List<BusinessSectorDTO> findAllBusinessSector() {
		List<BusinessSector> result = businessSectorRepository.findAll();
		
		return result.stream().map(item -> new BusinessSectorDTO(item)).collect(Collectors.toList());
	}
}

package com.in6backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in6backend.dto.CityDTO;
import com.in6backend.services.CityService;

@RestController
@RequestMapping(value = "/city")
public class CityController {

	@Autowired
	private CityService cityService;

	@GetMapping("/findAllCitiesByState/{id}")
	public ResponseEntity<?> findAllCitiesByState(@PathVariable Long id) {
		List<CityDTO> result = cityService.findAllCitiesByState(id);

		if (result.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}
package com.in6backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in6backend.dto.VacancyDTOInput;
import com.in6backend.dto.VacancyDTOOutput;
import com.in6backend.dto.VacancyDTOUpdate;
import com.in6backend.services.VacancyService;

@RestController
@RequestMapping(value = "/vacancy")
public class VacancyController {

	@Autowired
	private VacancyService vacancyService;

	@GetMapping("/findAllVacancies")
	public ResponseEntity<?> findAllVacancies() {
		List<VacancyDTOOutput> result = vacancyService.findAllVacancies();

		if (result.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@GetMapping("/findAllVacanciesByCompany/{email}")
	public ResponseEntity<?> findAllVacanciesByCompany(@PathVariable String email) {
		List<VacancyDTOOutput> result = vacancyService.findAllVacanciesByCompany(email);

		if (result == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		if (result.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@GetMapping("/findOneVacancy/{id}")
	public ResponseEntity<?> findOneVacancy(@PathVariable Long id) {
		VacancyDTOOutput result = vacancyService.findOneVacancy(id);

		if (result == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@PostMapping("/createVacancy")
	public ResponseEntity<?> createVacancy(@RequestBody VacancyDTOInput vacancyDTOInput) {
		VacancyDTOOutput vacancyDTOOutput = vacancyService.createVacancy(vacancyDTOInput);

		return ResponseEntity.status(HttpStatus.CREATED).body(vacancyDTOOutput);
	}

	@PutMapping("/updateVacancy")
	public ResponseEntity<?> updateVacancy(@RequestBody VacancyDTOUpdate vacancyDTOUpdate) {
		VacancyDTOOutput vacancyDTOOutput = vacancyService.updateVacancy(vacancyDTOUpdate);
		
		return ResponseEntity.status(HttpStatus.OK).body(vacancyDTOOutput);
	}

	@DeleteMapping("/deleteVacancy/{id}")
	public ResponseEntity<?> deleteVacancy(@PathVariable Long id) {
		vacancyService.deleteVacancy(id);
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
package com.in6backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in6backend.dto.CandidateDTO;
import com.in6backend.services.CandidateService;

@RestController
@RequestMapping(value = "/candidate")
public class CandidateController {

	@Autowired
	private CandidateService candidateService;
	
	@GetMapping("/findAllCandidates")
	public ResponseEntity<?> findAllCandidates() {
		List<CandidateDTO> result = candidateService.findAllCandidates();

		if (result.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(result);
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@GetMapping("/findOneCandidate/{cpf}")
	public ResponseEntity<?> findOneCandidate(@PathVariable String cpf) {
		CandidateDTO result = candidateService.findOneCandidate(cpf);

		if (result == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@GetMapping("/findAllCandidatesByVacancy/{vacancyId}")
	public ResponseEntity<?> findAllCandidatesByVacancy(@PathVariable Long vacancyId) {
		List<CandidateDTO> result = candidateService.findAllCandidatesByVacancy(vacancyId);
		
		if (result == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		if (result.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@PostMapping("/createCandidate/{vacancyId}")
	public ResponseEntity<?> createCandidate(@RequestBody CandidateDTO candidateDTO, @PathVariable Long vacancyId) {
		CandidateDTO result = candidateService.createCandidate(candidateDTO, vacancyId);
		
		if (result == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}
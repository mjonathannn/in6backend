package com.in6backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in6backend.dto.StateDTO;
import com.in6backend.services.StateService;

@RestController
@RequestMapping(value = "/state")
public class StateController {

	@Autowired
	private StateService stateService;

	@GetMapping("/findAllStates")
	public ResponseEntity<?> findAllStates() {
		List<StateDTO> result = stateService.findAllStates();

		if (result.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}
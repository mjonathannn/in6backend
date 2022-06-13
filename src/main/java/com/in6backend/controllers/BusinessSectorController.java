package com.in6backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in6backend.dto.BusinessSectorDTO;
import com.in6backend.services.BusinessSectorService;

@RestController
@RequestMapping(value = "/businessSector")
public class BusinessSectorController {

	@Autowired
	private BusinessSectorService businessSectorService;

	@GetMapping("/findAllBusinessSector")
	public ResponseEntity<?> findAllBusinessSector() {
		List<BusinessSectorDTO> result = businessSectorService.findAllBusinessSector();

		if (result.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}

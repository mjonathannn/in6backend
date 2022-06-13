package com.in6backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in6backend.repositories.CompanyRepository;
import com.in6backend.services.ActivationAccountService;

@RestController
@RequestMapping(value = "/activateAccount")
public class ActivationAccountController {

	@Autowired
	private ActivationAccountService activationAccountService;

	@Autowired
	private CompanyRepository companyRepository;

	@GetMapping("/activate/{id}")
	public ResponseEntity<?> activate(@PathVariable Long id) {
		if (companyRepository.existsById(id)) {
			activationAccountService.activate(id);

			return ResponseEntity.status(HttpStatus.OK).build();
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@GetMapping("/sendEmail/{companyId}/{to}/{host}")
	public ResponseEntity<?> sendEmail(@PathVariable Long companyId, @PathVariable String to,
			@PathVariable String host) {
		if (companyRepository.existsById(companyId)) {
			try {
				if (activationAccountService.sendEmail(to, companyId, host)) {
					activationAccountService.activationEmailSended(companyId);

					return ResponseEntity.status(HttpStatus.OK).build();
				}
			} catch (Exception e) {
				e.printStackTrace();

				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
			}
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}

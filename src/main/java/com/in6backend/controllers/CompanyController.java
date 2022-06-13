package com.in6backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in6backend.dto.CompanyDTOInput;
import com.in6backend.dto.CompanyDTOOutput;
import com.in6backend.dto.CompanyDTOUpdate;
import com.in6backend.dto.EmailSendedDTO;
import com.in6backend.dto.LoginDTOInput;
import com.in6backend.dto.TokenDTO;
import com.in6backend.services.CompanyService;
import com.in6backend.services.TokenService;

@RestController
@RequestMapping(value = "/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenService tokenService;

	@GetMapping("/findAllCompanies")
	public ResponseEntity<?> findAllCompanies() {
		List<CompanyDTOOutput> result = companyService.findAllCompanies();

		if (result.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@GetMapping("/findOneCompany/{email}")
	public ResponseEntity<?> findOneCompany(@PathVariable String email) {
		CompanyDTOOutput result = companyService.findOneCompany(email);

		if (result == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@PostMapping("/createCompany")
	public ResponseEntity<?> createCompany(@RequestBody CompanyDTOInput companyDTOInput) {
		CompanyDTOOutput companyDTOOutput = companyService.createCompany(companyDTOInput);

		return ResponseEntity.status(HttpStatus.CREATED).body(companyDTOOutput);
	}

	@PutMapping("/updateCompany")
	public ResponseEntity<?> updateCompany(@RequestBody CompanyDTOUpdate companyDTOUpdate) {
		CompanyDTOOutput companyDTOOutput = companyService.updateCompany(companyDTOUpdate);

		return ResponseEntity.status(HttpStatus.OK).body(companyDTOOutput);
	}

	@PutMapping("/updateCompanyPassword")
	public ResponseEntity<?> updateCompanyPassword(@RequestBody LoginDTOInput loginDTOInput) {
		CompanyDTOOutput companyDTOOutput = companyService.updateCompanyPassword(loginDTOInput);

		return ResponseEntity.status(HttpStatus.OK).body(companyDTOOutput);
	}
	
	@PutMapping("/updateCompanyEmail/{actualEmail}/{newEmail}")
	public ResponseEntity<?> updateCompanyEmail(@PathVariable String actualEmail, @PathVariable String newEmail) {
		CompanyDTOOutput companyDTOOutput = companyService.updateCompanyEmail(actualEmail, newEmail);

		return ResponseEntity.status(HttpStatus.OK).body(companyDTOOutput);
	}

	@DeleteMapping("/deleteCompany/{id}")
	public ResponseEntity<?> deleteCompany(@PathVariable Long id) {
		companyService.deleteCompany(id);
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping("/existsEmail/{email}")
	public ResponseEntity<?> existsEmail(@PathVariable String email) {

		return ResponseEntity.status(HttpStatus.OK).body(companyService.existsEmail(email));
	}

	@GetMapping("/existsPhone/{phone}")
	public ResponseEntity<?> existsPhone(@PathVariable String phone) {

		return ResponseEntity.status(HttpStatus.OK).body(companyService.existsPhone(phone));
	}

	@GetMapping("/verifyActivation/{email}")
	public ResponseEntity<?> verifyActivation(@PathVariable String email) {
		
		return ResponseEntity.status(HttpStatus.OK).body(companyService.verifyActivation(email));
	}

	@GetMapping("/verifyActivationEmailSended/{email}")
	public ResponseEntity<?> verifyActivationEmailSended(@PathVariable String email) {
		EmailSendedDTO result = companyService.verifyActivationEmailSended(email);
		
		if (result == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		}
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@PostMapping("/authenticateCompany")
	public ResponseEntity<?> authenticateCompany(@RequestBody LoginDTOInput loginInputDTO) {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				loginInputDTO.getEmail(), loginInputDTO.getPassword());
		Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		TokenDTO token = new TokenDTO(tokenService.generateToken(authentication));

		return ResponseEntity.status(HttpStatus.OK).body(token);
	}
	
	@PostMapping("/authenticateCompanyNonExpireToken")
	public ResponseEntity<?> authenticateCompanyNonExpireToken(@RequestBody LoginDTOInput loginInputDTO) {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				loginInputDTO.getEmail(), loginInputDTO.getPassword());
		Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		TokenDTO token = new TokenDTO(tokenService.generateNonExpireToken(authentication));

		return ResponseEntity.status(HttpStatus.OK).body(token);
	}

	@PostMapping("/isAuthenticated")
	public ResponseEntity<?> isAuthenticated(@RequestBody TokenDTO tokenDTO) {
		boolean result = tokenService.isTokenValid(tokenDTO.getToken());
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}
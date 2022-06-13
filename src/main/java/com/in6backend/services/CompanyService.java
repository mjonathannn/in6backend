package com.in6backend.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.in6backend.dto.CompanyDTOInput;
import com.in6backend.dto.CompanyDTOOutput;
import com.in6backend.dto.CompanyDTOUpdate;
import com.in6backend.dto.EmailSendedDTO;
import com.in6backend.dto.LoginDTOInput;
import com.in6backend.entities.BusinessSector;
import com.in6backend.entities.City;
import com.in6backend.entities.Company;
import com.in6backend.repositories.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<CompanyDTOOutput> findAllCompanies() {
		List<Company> result = companyRepository.findAll();
		
		return result.stream().map(item -> new CompanyDTOOutput(item)).collect(Collectors.toList());
	}

	public CompanyDTOOutput findOneCompany(String email) {
		if (existsEmail(email)) {
			return new CompanyDTOOutput(companyRepository.findByEmail(email));
		}
		return null;
	}
	
	public CompanyDTOOutput createCompany(CompanyDTOInput companyDTOInput) {
		Company company = new Company(companyDTOInput);
		company.setPassword(passwordEncoder.encode(companyDTOInput.getPassword()));
		companyRepository.save(company);
		
		return new CompanyDTOOutput(company);
	}

	public CompanyDTOOutput updateCompany(CompanyDTOUpdate companyDTOUpdate) {
		Company company = companyRepository.findByEmail(companyDTOUpdate.getEmail());
		company.setName(companyDTOUpdate.getName());
		company.setCnpj(companyDTOUpdate.getCnpj());
		company.setPhone(companyDTOUpdate.getPhone());
		company.setAbout(companyDTOUpdate.getAbout());
		company.setDesktopNotification(companyDTOUpdate.isDesktopNotifications());
		company.setEmailNotification(companyDTOUpdate.isEmailNotifications());
		company.setWhatsappNotification(companyDTOUpdate.isWhatsappNotifications());
		company.setCity(new City(companyDTOUpdate.getCityDTO()));
		company.setBusinessSector(new BusinessSector(companyDTOUpdate.getBusinessSectorDTO()));
		
		companyRepository.save(company);
		
		return new CompanyDTOOutput(company);
	}
	
	public CompanyDTOOutput updateCompanyPassword(LoginDTOInput loginDTOInput) {
		Company company = companyRepository.findByEmail(loginDTOInput.getEmail());
		company.setPassword(passwordEncoder.encode(loginDTOInput.getPassword()));
		companyRepository.save(company);
		
		return new CompanyDTOOutput(company);
	}
	
	public CompanyDTOOutput updateCompanyEmail(String actualEmail, String newEmail) {
		Company company = companyRepository.findByEmail(actualEmail);
		company.setEmail(newEmail);
		companyRepository.save(company);
		
		return new CompanyDTOOutput(company);
	}
	
	public void deleteCompany(Long id) {
		companyRepository.deleteById(id);
	}

	public boolean existsEmail(String email) {
		return companyRepository.existsByEmail(email);
	}

	public boolean existsPhone(String phone) {
		return companyRepository.existsByPhone(phone);
	}
	
	public boolean verifyActivation(String email) {
		return companyRepository.findByEmail(email).isActivated();
	}
	
	public EmailSendedDTO verifyActivationEmailSended(String email) {
		if (existsEmail(email)) {
			Company company = companyRepository.findByEmail(email);
			EmailSendedDTO emailSendedDTO = new EmailSendedDTO(company);
			
			return emailSendedDTO;
		}
		return null;
	}
}

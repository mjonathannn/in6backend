package com.in6backend.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in6backend.dto.VacancyDTOInput;
import com.in6backend.dto.VacancyDTOOutput;
import com.in6backend.dto.VacancyDTOUpdate;
import com.in6backend.entities.City;
import com.in6backend.entities.TypeJob;
import com.in6backend.entities.TypeOfPay;
import com.in6backend.entities.TypeOfWorkload;
import com.in6backend.entities.Vacancy;
import com.in6backend.enumerator.VacancyStatusEnum;
import com.in6backend.repositories.CompanyRepository;
import com.in6backend.repositories.VacancyRepository;

@Service
public class VacancyService {

	@Autowired
	private VacancyRepository vacancyRepository;
	
	@Autowired
	private CompanyRepository companyRepository;

	public List<VacancyDTOOutput> findAllVacancies() {
		List<Vacancy> result = vacancyRepository.findAll();
		
		return result.stream().map(item -> new VacancyDTOOutput(item)).collect(Collectors.toList());
	}

	public List<VacancyDTOOutput> findAllVacanciesByCompany(String email) {
		if (companyRepository.existsByEmail(email)) {
			List<Vacancy> result = vacancyRepository.findByCompanyEmail(email);
			
			return result.stream().map(item -> new VacancyDTOOutput(item)).collect(Collectors.toList());
		}
		
		return null;
	}
	
	public VacancyDTOOutput findOneVacancy(Long id) {
		if (vacancyRepository.existsById(id)) {
			Vacancy result = vacancyRepository.findById(id).orElse(null);
			
			return new VacancyDTOOutput(result);
		}
		
		return null;
	}

	public VacancyDTOOutput createVacancy(VacancyDTOInput vagaDTOInput) {
		Vacancy vacancy = new Vacancy(vagaDTOInput);
		vacancy.setVacancyStatus(VacancyStatusEnum.ACEITANDOCURRICULOS);
		vacancy.setDateOfActivation("");

		vacancy = vacancyRepository.save(vacancy);
		return findOneVacancy(vacancy.getId());
	}

	public VacancyDTOOutput updateVacancy(VacancyDTOUpdate vacancyDTOUpdate) {
		Vacancy vaga = vacancyRepository.findById(vacancyDTOUpdate.getId()).orElse(null);
		vaga.setId(vacancyDTOUpdate.getId());
		vaga.setName(vacancyDTOUpdate.getName());
		vaga.setImmediateHiring(vacancyDTOUpdate.isImmediateHiring());
		vaga.setNeedExperience(vacancyDTOUpdate.isNeedExperience());
		vaga.setDisabledPeople(vacancyDTOUpdate.isDisabledPeople());
		vaga.setForStudents(vacancyDTOUpdate.isForStudents());
		vaga.setVacancyStatus(vacancyDTOUpdate.getVacancyStatus());
		vaga.setWorkSchedule(vacancyDTOUpdate.getWorkSchedule());
		vaga.setSalary(vacancyDTOUpdate.getSalary());
		vaga.setSalaryToNegotiate(vacancyDTOUpdate.isSalaryToNegotiate());
		vaga.setDescription(vacancyDTOUpdate.getDescription());
		vaga.setBenefits(vacancyDTOUpdate.getBenefits());
		vaga.setTypeJob(new TypeJob(vacancyDTOUpdate.getTypeJobDTO()));
		vaga.setTypeOfWorkload(new TypeOfWorkload(vacancyDTOUpdate.getTypeOfWorkloadDTO()));
		vaga.setTypeOfPay(new TypeOfPay(vacancyDTOUpdate.getTypeOfPayDTO()));
		vaga.setCity(new City(vacancyDTOUpdate.getCityDTO()));
		
		vacancyRepository.save(vaga);
		
		return new VacancyDTOOutput(vaga);
	}

	public void deleteVacancy(Long id) {
		vacancyRepository.deleteById(id);
	}
}
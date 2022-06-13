package com.in6backend.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in6backend.dto.CandidateDTO;
import com.in6backend.entities.Candidate;
import com.in6backend.entities.VacancyCandidate;
import com.in6backend.repositories.CandidateRepository;
import com.in6backend.repositories.VacancyCandidateRepository;
import com.in6backend.repositories.VacancyRepository;

@Service
public class CandidateService {

	@Autowired
	private CandidateRepository candidateRepository;

	@Autowired
	private VacancyRepository vacancyRepository;

	@Autowired
	private VacancyCandidateRepository vacancyCandidateRepository;

	public List<CandidateDTO> findAllCandidates() {
		List<Candidate> result = candidateRepository.findAll();

		return result.stream().map(item -> new CandidateDTO(item)).collect(Collectors.toList());
	}

	public CandidateDTO findOneCandidate(String cpf) {
		if (candidateRepository.existsByCpf(cpf)) {
			Candidate result = candidateRepository.findByCpf(cpf);

			return new CandidateDTO(result);
		}
		return null;
	}

	public List<CandidateDTO> findAllCandidatesByVacancy(Long vacancyId) {
		if (vacancyRepository.existsById(vacancyId)) {
			List<VacancyCandidate> result = vacancyCandidateRepository.findByIdVacancy(vacancyId);
			List<CandidateDTO> candidateDTOs = result.stream().map(item -> findOneCandidate(item.getCpfCandidate()))
					.collect(Collectors.toList());

			return candidateDTOs;
		}
		return null;
	}

	public CandidateDTO createCandidate(CandidateDTO candidateDTO, Long vacancyId) {
		if (vacancyRepository.existsById(vacancyId)) {
			Candidate candidato = new Candidate(candidateDTO);
			candidateRepository.save(candidato);

			VacancyCandidate vacancyCandidate = new VacancyCandidate();
			vacancyCandidate.setCpfCandidate(candidateDTO.getCpf());
			vacancyCandidate.setIdVacancy(vacancyId);
			vacancyCandidateRepository.save(vacancyCandidate);

			return candidateDTO;
		}
		return null;
	}
}
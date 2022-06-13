package com.in6backend.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in6backend.dto.StateDTO;
import com.in6backend.entities.State;
import com.in6backend.repositories.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;

	public List<StateDTO> findAllStates() {
		List<State> result = stateRepository.findAll();
		
		return result.stream().map(item -> new StateDTO(item)).collect(Collectors.toList());
	}
}

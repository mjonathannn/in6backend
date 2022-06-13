package com.in6backend.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.in6backend.entities.Company;
import com.in6backend.repositories.CompanyRepository;

@Service
public class AuthenticationService implements UserDetailsService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Company empresa = companyRepository.findByEmail(email);

		return new org.springframework.security.core.userdetails.User(empresa.getEmail(), empresa.getPassword(), new ArrayList<>());
	}
}

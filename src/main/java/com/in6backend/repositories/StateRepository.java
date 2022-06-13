package com.in6backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in6backend.entities.State;

public interface StateRepository extends JpaRepository<State, Long> {

}

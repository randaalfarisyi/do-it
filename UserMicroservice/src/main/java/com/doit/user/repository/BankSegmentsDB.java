package com.doit.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doit.user.model.BankSegmentsModel;

@Repository
public interface BankSegmentsDB extends JpaRepository<BankSegmentsModel, Long> {

	Optional<BankSegmentsModel> findByUuid(String uuidBorrower);
	

}


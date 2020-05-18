package com.doit.user.repository;

import java.util.List;
import java.util.Optional;

import com.doit.user.model.BorrowerModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerDB extends JpaRepository<BorrowerModel, Long> {
	Optional<BorrowerModel> findByUuid(String uuid);

	List<BorrowerModel> findByOrderByUpdatedTimeDesc();
}
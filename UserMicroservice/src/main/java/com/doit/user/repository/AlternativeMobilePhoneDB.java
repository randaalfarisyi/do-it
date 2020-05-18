package com.doit.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doit.user.model.AlternativeMobilePhoneModel;

@Repository
public interface AlternativeMobilePhoneDB extends JpaRepository<AlternativeMobilePhoneModel, Long> {
	

}
package com.doit.user.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doit.user.model.EmergencyContactSegmentsModel;

@Repository
public interface EmergencyContactSegmentsDB extends JpaRepository<EmergencyContactSegmentsModel, Long> {
	
	

}


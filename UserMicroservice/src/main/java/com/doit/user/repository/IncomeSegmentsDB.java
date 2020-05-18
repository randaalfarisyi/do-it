package com.doit.user.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doit.user.model.IncomeSegmentsModel;

@Repository
public interface IncomeSegmentsDB extends JpaRepository<IncomeSegmentsModel, Long> {
	
	

}

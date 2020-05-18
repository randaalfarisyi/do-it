package com.doit.user.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doit.user.model.WorkAddrRegionModel;

@Repository
public interface WorkAddrRegionDB extends JpaRepository<WorkAddrRegionModel, Long> {
	
	

}

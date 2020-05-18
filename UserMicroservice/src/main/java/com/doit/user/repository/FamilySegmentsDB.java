package com.doit.user.repository;

import com.doit.user.model.FamilySegmentsModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilySegmentsDB extends JpaRepository<FamilySegmentsModel, Long> {

}

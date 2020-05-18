package com.doit.user.repository;

import java.util.Optional;

import com.doit.user.model.ProductiveSegmentsModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductiveSegmentsDB extends JpaRepository<ProductiveSegmentsModel, Long> {
    Optional<ProductiveSegmentsModel> findByUuid(String uuid);
}
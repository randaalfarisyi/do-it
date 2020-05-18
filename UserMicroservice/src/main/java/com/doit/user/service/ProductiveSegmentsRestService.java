package com.doit.user.service;

import com.doit.user.model.ProductiveSegmentsModel;

import org.springframework.stereotype.Service;

@Service
public interface ProductiveSegmentsRestService {
    ProductiveSegmentsModel getProductiveSegmentsByUuidBorrower(String uuidBorrower);

}
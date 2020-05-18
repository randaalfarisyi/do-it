package com.doit.user.service;

import org.springframework.stereotype.Service;

import com.doit.user.model.IncomeSegmentsModel;

@Service
public interface IncomeSegmentsRestService {
	IncomeSegmentsModel getIncomeSegmentsByUuidBorrower(String uuidBorrower);
}

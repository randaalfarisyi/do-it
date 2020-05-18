package com.doit.user.service;

import com.doit.user.model.FamilySegmentsModel;

import org.springframework.stereotype.Service;

@Service
public interface FamilySegmentsRestService {
	FamilySegmentsModel getFamilySegmentsByUuidBorrower(String uuidBorrower);
}

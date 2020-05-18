package com.doit.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.doit.user.model.EmergencyContactSegmentsModel;

@Service
public interface EmergencyContactSegmentsRestService {
	List<EmergencyContactSegmentsModel> getEmergencyContactSegmentsByUuidBorrower(String uuidBorrower);
}

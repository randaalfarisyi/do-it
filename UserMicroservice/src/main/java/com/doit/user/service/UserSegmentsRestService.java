package com.doit.user.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.doit.user.model.UserSegmentsModel;

@Service
public interface UserSegmentsRestService {
	UserSegmentsModel getUserSegmentsByUuidBorrower(String uuidBorrower);

	UserSegmentsModel changeUserSegments(UserSegmentsModel userSegmentsupdated);
}

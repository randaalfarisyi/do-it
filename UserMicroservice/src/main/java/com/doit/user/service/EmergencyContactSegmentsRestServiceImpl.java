package com.doit.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doit.user.model.BorrowerModel;
import com.doit.user.model.EmergencyContactSegmentsModel;
import com.doit.user.model.UserSegmentsModel;
import com.doit.user.repository.BorrowerDB;

@Service
@Transactional
public class EmergencyContactSegmentsRestServiceImpl implements EmergencyContactSegmentsRestService {
	@Autowired
	private BorrowerDB borrowerDB;
	
	@Override
	public List<EmergencyContactSegmentsModel> getEmergencyContactSegmentsByUuidBorrower(String uuidBorrower) {
		Optional<BorrowerModel> borrower = borrowerDB.findByUuid(uuidBorrower);
		if (borrower.isPresent()) {
			List<EmergencyContactSegmentsModel> emergencyContactSegmentsList = borrower.get().getEmergencyContactSegmentsList();
			List<EmergencyContactSegmentsModel> result = new ArrayList<>();
			for (EmergencyContactSegmentsModel emergencyContactSegments:emergencyContactSegmentsList) {
				if (emergencyContactSegments.getDisabled() == 0) {
					result.add(emergencyContactSegments);
				}
			}
			if (result.size() != 0) {
				return result;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
}

package com.doit.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doit.user.model.AlternativeMobilePhoneModel;
import com.doit.user.model.BorrowerModel;
import com.doit.user.model.UserSegmentsModel;
import com.doit.user.repository.BorrowerDB;

@Service
@Transactional
public class AlternativeMobilePhoneRestServiceImpl implements AlternativeMobilePhoneRestService {
	@Autowired
	private BorrowerDB borrowerDB;
	
	@Override
	public List<AlternativeMobilePhoneModel> getAlternativeMobilePhoneByUuidBorrower(String uuidBorrower) {
		Optional<BorrowerModel> borrower = borrowerDB.findByUuid(uuidBorrower);
		if (borrower.isPresent()) {
			List<UserSegmentsModel> userSegmentsList = borrower.get().getUserSegmentsList();
			for (UserSegmentsModel userSegments:userSegmentsList) {
				if (userSegments.getDisabled() == 0) {
					List<AlternativeMobilePhoneModel> result = new ArrayList<>();
					for(AlternativeMobilePhoneModel alternativeMobilePhone:userSegments.getAlternativeMobilePhoneList()) {
						if(alternativeMobilePhone.getDisabled() == 0) {
							result.add(alternativeMobilePhone);
						}
					}
					if (result.size() != 0) {
						return result;
					} else {
						return null;
					}
				}
			}
			return null;
		} else {
			return null;
		}
	}
}

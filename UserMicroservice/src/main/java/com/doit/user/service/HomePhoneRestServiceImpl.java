package com.doit.user.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doit.user.model.BorrowerModel;
import com.doit.user.model.HomePhoneModel;
import com.doit.user.model.UserSegmentsModel;
import com.doit.user.repository.BorrowerDB;

@Service
@Transactional
public class HomePhoneRestServiceImpl implements HomePhoneRestService {
	@Autowired
	private BorrowerDB borrowerDB;
	
	@Override
	public HomePhoneModel getHomePhoneByUuidBorrower(String uuidBorrower) {
		Optional<BorrowerModel> borrower = borrowerDB.findByUuid(uuidBorrower);
		if (borrower.isPresent()) {
			List<UserSegmentsModel> userSegmentsList = borrower.get().getUserSegmentsList();
			for (UserSegmentsModel userSegments:userSegmentsList) {
				if (userSegments.getDisabled() == 0) {
					for(HomePhoneModel homePhone:userSegments.getHomePhoneList()) {
						if(homePhone.getDisabled() == 0) {
							return homePhone;
						}
					}
					return null;
				}
			}
			return null;
		} else {
			return null;
		}
	}
}

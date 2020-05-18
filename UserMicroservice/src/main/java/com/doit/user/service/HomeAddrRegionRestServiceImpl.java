package com.doit.user.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doit.user.model.BorrowerModel;
import com.doit.user.model.HomeAddrRegionModel;
import com.doit.user.model.UserSegmentsModel;
import com.doit.user.repository.BorrowerDB;

@Service
@Transactional
public class HomeAddrRegionRestServiceImpl implements HomeAddrRegionRestService {
	@Autowired
	private BorrowerDB borrowerDB;
	
	@Override
	public HomeAddrRegionModel getHomeAddrRegionByUuidBorrower(String uuidBorrower) {
		Optional<BorrowerModel> borrower = borrowerDB.findByUuid(uuidBorrower);
		if (borrower.isPresent()) {
			List<UserSegmentsModel> userSegmentsList = borrower.get().getUserSegmentsList();
			for (UserSegmentsModel userSegments:userSegmentsList) {
				if (userSegments.getDisabled() == 0) {
					for(HomeAddrRegionModel homeAddrRegion:userSegments.getHomeAddrRegionList()) {
						if(homeAddrRegion.getDisabled() == 0) {
							return homeAddrRegion;
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

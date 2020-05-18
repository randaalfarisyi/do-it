package com.doit.user.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doit.user.model.BorrowerModel;
import com.doit.user.model.IncomeSegmentsModel;
import com.doit.user.model.WorkAddrRegionModel;
import com.doit.user.repository.BorrowerDB;

@Service
@Transactional
public class WorkAddrRegionRestServiceImpl implements WorkAddrRegionRestService {
	@Autowired
	private BorrowerDB borrowerDB;
	
	@Override
	public WorkAddrRegionModel getWorkAddrRegionByUuidBorrower(String uuidBorrower) {
		Optional<BorrowerModel> borrower = borrowerDB.findByUuid(uuidBorrower);
		if (borrower.isPresent()) {
			List<IncomeSegmentsModel> incomeSegmentsList = borrower.get().getIncomeSegmentsList();
			for (IncomeSegmentsModel incomeSegments:incomeSegmentsList) {
				if (incomeSegments.getDisabled() == 0) {
					for(WorkAddrRegionModel workAddrRegion:incomeSegments.getWorkAddrRegionList()) {
						if(workAddrRegion.getDisabled() == 0) {
							return workAddrRegion;
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

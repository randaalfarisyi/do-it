package com.doit.user.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doit.user.model.BorrowerModel;
import com.doit.user.model.IncomeSegmentsModel;
import com.doit.user.model.WorkAddrRegionModel;
import com.doit.user.model.WorkPhoneModel;
import com.doit.user.repository.BorrowerDB;

@Service
@Transactional
public class WorkPhoneRestServiceImpl implements WorkPhoneRestService {
	@Autowired
	private BorrowerDB borrowerDB;
	
	@Override
	public WorkPhoneModel getWorkPhoneByUuidBorrower(String uuidBorrower) {
		Optional<BorrowerModel> borrower = borrowerDB.findByUuid(uuidBorrower);
		if (borrower.isPresent()) {
			List<IncomeSegmentsModel> incomeSegmentsList = borrower.get().getIncomeSegmentsList();
			for (IncomeSegmentsModel incomeSegments:incomeSegmentsList) {
				if (incomeSegments.getDisabled() == 0) {
					for(WorkPhoneModel workPhone:incomeSegments.getWorkPhoneList()) {
						if(workPhone.getDisabled() == 0) {
							return workPhone;
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

package com.doit.user.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doit.user.model.BorrowerModel;
import com.doit.user.model.IncomeSegmentsModel;
import com.doit.user.repository.BorrowerDB;

@Service
@Transactional
public class IncomeSegmentsRestServiceImpl implements IncomeSegmentsRestService {
	@Autowired
	private BorrowerDB borrowerDB;
	
	@Override
	public IncomeSegmentsModel getIncomeSegmentsByUuidBorrower(String uuidBorrower) {
		Optional<BorrowerModel> borrower = borrowerDB.findByUuid(uuidBorrower);
		if (borrower.isPresent()) {
			List<IncomeSegmentsModel> incomeSegmentsList = borrower.get().getIncomeSegmentsList();
			for (IncomeSegmentsModel incomeSegments:incomeSegmentsList) {
				if (incomeSegments.getDisabled() == 0) {
					return incomeSegments;
				}
			}
			return null;
		} else {
			return null;
		}
	}
}

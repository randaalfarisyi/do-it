package com.doit.user.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.doit.user.model.BorrowerModel;
import com.doit.user.model.FamilySegmentsModel;
import com.doit.user.repository.BorrowerDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FamilySegmentsRestServiceImpl implements FamilySegmentsRestService {
    @Autowired
	private BorrowerDB borrowerDB;

    @Override
    public FamilySegmentsModel getFamilySegmentsByUuidBorrower(String uuidBorrower) {
        Optional<BorrowerModel> borrower = borrowerDB.findByUuid(uuidBorrower);
		if (borrower.isPresent()) {
			List<FamilySegmentsModel> famSegmentsList = borrower.get().getFamilySegmentsList();
			for (FamilySegmentsModel famSegments:famSegmentsList) {
				if (famSegments.getDisabled() == 0) {
					return famSegments;
				}
			}
			return null;
		} else {
			return null;
		}
    }

}
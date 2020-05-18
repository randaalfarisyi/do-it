package com.doit.user.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.doit.user.model.BorrowerModel;
import com.doit.user.model.ProductiveSegmentsModel;
import com.doit.user.repository.BorrowerDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductiveSegmentsRestServiceImpl implements ProductiveSegmentsRestService{
    @Autowired
	private BorrowerDB borrowerDB;
	
	@Override
	public ProductiveSegmentsModel getProductiveSegmentsByUuidBorrower(String uuidBorrower) {
		Optional<BorrowerModel> borrower = borrowerDB.findByUuid(uuidBorrower);
		if (borrower.isPresent()) {
			List<ProductiveSegmentsModel> prodSegmentsList = borrower.get().getProductiveSegmentsList();
			for (ProductiveSegmentsModel prodSegments:prodSegmentsList) {
				if (prodSegments.getDisabled() == 0) {
					return prodSegments;
				}
			}
			return null;
		} else {
			return null;
		}
	}

}
package com.doit.user.service;

import java.util.List;
import java.util.Optional;

import com.doit.user.model.BorrowerModel;

import org.springframework.stereotype.Service;

@Service
public interface BorrowerRestService {
	BorrowerModel addBorrower(BorrowerModel borrower);
	List<BorrowerModel> getBorrrowerList();
	Optional<BorrowerModel> getBorrowerByIdBorrower(long idBorrower);
	BorrowerModel changeBorrower(BorrowerModel borrroweModel, String uuid);
	BorrowerModel getBorrowerByUuid(String uuidBorrower); 

}

package com.doit.user.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import com.doit.user.model.BorrowerModel;
import com.doit.user.repository.BorrowerDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BorrowerRestServiceImpl implements BorrowerRestService {

    @Autowired
    private BorrowerDB borrowerDB;

	@Override
	public BorrowerModel addBorrower(BorrowerModel borrower) {
		borrowerDB.save(borrower);
		return borrower;
	}

	@Override
	public List<BorrowerModel> getBorrrowerList() {
		List<BorrowerModel> nonSaring = borrowerDB.findByOrderByUpdatedTimeDesc();
		System.out.println(nonSaring.get(0).getEmail());
		// List<BorrowerModel> saring = borrowerDB.findAll();
		// for(BorrowerModel bb : nonSaring){
		// 	if(bb.getDisabled()!=1){
		// 		saring.add(bb);
		// 	}
		// };
		return nonSaring;
	}

	@Override
	public Optional<BorrowerModel> getBorrowerByIdBorrower(long idBorrower) {
		return null;
	}

	@Override
	public BorrowerModel changeBorrower(BorrowerModel borrower,String uuid) {
		Optional<BorrowerModel> peminjam = borrowerDB.findByUuid(uuid);
		if (peminjam.isPresent()){
			try{
				BorrowerModel brr = peminjam.get();
				brr.setDisabled(borrower.getDisabled());
				brr.setEmail(borrower.getEmail());
				brr.setMobilePhoneNumber(borrower.getMobilePhoneNumber());
				Date formatter = new Date();
				brr.setCreatedTime(formatter);
				borrowerDB.save(brr);
				return brr;
			}catch(NullPointerException nullException) {
				return null;
			}
		} else {
			return null;
		}
	}
    
	@Override
	public BorrowerModel getBorrowerByUuid(String uuidBorrower) {
		Optional<BorrowerModel> borrower = borrowerDB.findByUuid(uuidBorrower);
		if (borrower.isPresent()) {
			return borrower.get();
		} else {
			return null;
		}
	}

    

}

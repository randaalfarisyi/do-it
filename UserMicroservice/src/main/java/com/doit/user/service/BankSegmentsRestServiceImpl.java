package com.doit.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doit.user.model.BorrowerModel;
import com.doit.user.model.BankSegmentsModel;
import com.doit.user.model.UserSegmentsModel;
import com.doit.user.repository.BankSegmentsDB;
import com.doit.user.repository.BorrowerDB;

@Service
@Transactional
public class BankSegmentsRestServiceImpl implements BankSegmentsRestService {
	@Autowired
	private BankSegmentsDB bankDB;
	
    @Override
    public List<BankSegmentsModel> getBankSegmentsModelByUuidBorrower(String uuidBorrower) {
		return null;
    }
}
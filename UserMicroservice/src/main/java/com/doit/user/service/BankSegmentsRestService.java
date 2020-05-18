package com.doit.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.doit.user.model.BankSegmentsModel;

@Service
public interface BankSegmentsRestService {
	List<BankSegmentsModel> getBankSegmentsModelByUuidBorrower(String uuidBorrower);
}
package com.doit.user.service;

import org.springframework.stereotype.Service;

import com.doit.user.model.WorkPhoneModel;

@Service
public interface WorkPhoneRestService {
	WorkPhoneModel getWorkPhoneByUuidBorrower(String uuidBorrower);
}

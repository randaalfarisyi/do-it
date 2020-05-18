package com.doit.user.service;

import org.springframework.stereotype.Service;

import com.doit.user.model.HomePhoneModel;

@Service
public interface HomePhoneRestService {
	HomePhoneModel getHomePhoneByUuidBorrower(String uuidBorrower);
}

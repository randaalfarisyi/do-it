package com.doit.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.doit.user.model.AlternativeMobilePhoneModel;

@Service
public interface AlternativeMobilePhoneRestService {
	List<AlternativeMobilePhoneModel> getAlternativeMobilePhoneByUuidBorrower(String uuidBorrower);
}

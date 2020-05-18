package com.doit.user.service;

import org.springframework.stereotype.Service;

import com.doit.user.model.WorkAddrRegionModel;

@Service
public interface WorkAddrRegionRestService {
	WorkAddrRegionModel getWorkAddrRegionByUuidBorrower(String uuidBorrower);
}

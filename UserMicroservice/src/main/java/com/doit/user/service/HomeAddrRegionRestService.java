package com.doit.user.service;

import org.springframework.stereotype.Service;

import com.doit.user.model.HomeAddrRegionModel;

@Service
public interface HomeAddrRegionRestService {
	HomeAddrRegionModel getHomeAddrRegionByUuidBorrower(String uuidBorrower);
}

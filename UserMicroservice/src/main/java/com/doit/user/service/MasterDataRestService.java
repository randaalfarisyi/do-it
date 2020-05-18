package com.doit.user.service;

import org.springframework.stereotype.Service;

import com.doit.user.model.MasterDataModel;

@Service
public interface MasterDataRestService {
	MasterDataModel getMasterDataByGroupDataAndCode(String groupData, String code);
	MasterDataModel getMasterDataByGroupDataAndCodeAndParentUuid(String groupData, String code, String parentUuid);
}

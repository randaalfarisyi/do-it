package com.doit.user.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doit.user.model.MasterDataModel;
import com.doit.user.repository.MasterDataDB;

@Service
@Transactional
public class MasterDataRestServiceImpl implements MasterDataRestService {
	@Autowired
	private MasterDataDB masterDataDB;
	
	@Override
	public MasterDataModel getMasterDataByGroupDataAndCode(String groupData, String code) {
		Optional<MasterDataModel> masterData = masterDataDB.findByGroupDataAndCode(groupData, code);
		if (masterData.isPresent()) {
			return masterData.get();
		} else {
			return null;
		}
	}
	
	@Override
	public MasterDataModel getMasterDataByGroupDataAndCodeAndParentUuid(String groupData, String code, String parentUuid) {
		Optional<MasterDataModel> masterData = masterDataDB.findByGroupDataAndCodeAndParentUuid(groupData, code, parentUuid);
		if (masterData.isPresent()) {
			return masterData.get();
		} else {
			return null;
		}
	}
}

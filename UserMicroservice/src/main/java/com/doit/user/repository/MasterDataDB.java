package com.doit.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doit.user.model.MasterDataModel;

@Repository
public interface MasterDataDB extends JpaRepository<MasterDataModel, Long> {
	Optional<MasterDataModel> findByGroupDataAndCode(String groupData, String code);
	Optional<MasterDataModel> findByGroupDataAndCodeAndParentUuid(String groupData, String code, String parentUuid);
}

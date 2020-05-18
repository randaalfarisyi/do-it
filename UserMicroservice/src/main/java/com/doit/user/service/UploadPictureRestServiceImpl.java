package com.doit.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.doit.user.model.BorrowerModel;
import com.doit.user.model.UploadPictureModel;
import com.doit.user.repository.BorrowerDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UploadPictureRestServiceImpl implements UploadPictureRestService {
    @Autowired
    private BorrowerDB borrowerDB;

    @Override
    public List<UploadPictureModel> getUploadPictureModelByUuidBorrower(String uuidBorrower) {
        Optional<BorrowerModel> borrower = borrowerDB.findByUuid(uuidBorrower);
        if (borrower.isPresent()) {
            List<UploadPictureModel> uploadPictList = borrower.get().getUploadPictureList();
            List<UploadPictureModel> result = new ArrayList<>();
            for (UploadPictureModel pict : uploadPictList) {
                if (pict.getDisabled() == 0) {
                    result.add(pict);
                }
            }
            if (result.size() != 0) {
                return result;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

}
package com.doit.user.service;

import java.util.List;

import com.doit.user.model.UploadPictureModel;

import org.springframework.stereotype.Service;

@Service
public interface UploadPictureRestService {
    List<UploadPictureModel> getUploadPictureModelByUuidBorrower(String uuidBorrower);
}
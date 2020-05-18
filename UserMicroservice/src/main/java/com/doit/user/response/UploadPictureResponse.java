package com.doit.user.response;

import java.util.List;

import com.doit.user.model.BankMutationModel;

public class UploadPictureResponse {
    private long id;
    private String uuid;
    private String uuidBorrower;
    private String nameBorrower;
    private String idCard;
    private String selfie;
    private String selfieIdCard;
    private String taxCard;
    private String paySlip;
    private List<BankMutationModel> bankMutationList;
}
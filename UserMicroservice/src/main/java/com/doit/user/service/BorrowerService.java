package com.doit.user.service;

import java.util.List;
import java.util.Optional;

import com.doit.user.model.BorrowerModel;

import org.springframework.stereotype.Service;

@Service
public interface BorrowerService {
    void addBorrower(BorrowerModel borrower);
    
    List<BorrowerModel> getBorrrowerList();

    Optional<BorrowerModel> getBorrowerByUuid(String uuid);

    BorrowerModel changeBorrower(BorrowerModel borrroweModel);

}

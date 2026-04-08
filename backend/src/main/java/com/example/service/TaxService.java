package com.example.service;

import java.util.List;
import com.example.dto.TaxRequest;
import com.example.dto.TaxResponse;
import com.example.entity.TaxRecord;

public interface TaxService {

    TaxResponse calculateTax(TaxRequest request);

    List<TaxRecord> getAllRecords();
}
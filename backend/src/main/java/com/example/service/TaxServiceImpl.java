package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.TaxRequest;
import com.example.dto.TaxResponse;
import com.example.entity.TaxRecord;
import com.example.repository.TaxRepository;

@Service
public class TaxServiceImpl implements TaxService {

    @Autowired
    private TaxRepository taxRepository;

    @Override
    public TaxResponse calculateTax(TaxRequest request) {

        double totalIncome = request.getSalaryIncome() + request.getOtherIncome();
        double taxableIncome = totalIncome - request.getDeductions();

        if (taxableIncome < 0) taxableIncome = 0;

        double oldTax = taxableIncome * 0.2;
        double newTax = taxableIncome * 0.15;

        String best = oldTax < newTax ? "OLD REGIME" : "NEW REGIME";

        TaxResponse response = new TaxResponse();
        response.setTotalIncome(totalIncome);
        response.setTaxableIncome(taxableIncome);
        response.setOldRegimeTax(oldTax);
        response.setNewRegimeTax(newTax);
        response.setRecommendedRegime(best);

        // SAVE
        TaxRecord record = new TaxRecord();
        record.setSalaryIncome(request.getSalaryIncome());
        record.setOtherIncome(request.getOtherIncome());
        record.setDeductions(request.getDeductions());
        record.setTotalIncome(totalIncome);
        record.setTaxableIncome(taxableIncome);
        record.setOldRegimeTax(oldTax);
        record.setNewRegimeTax(newTax);
        record.setRecommendedRegime(best);

        taxRepository.save(record);

        return response;
    }

    @Override
    public List<TaxRecord> getAllRecords() {
        return taxRepository.findAll();
    }
}
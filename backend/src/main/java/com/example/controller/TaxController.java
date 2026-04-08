package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.dto.TaxRequest;
import com.example.dto.TaxResponse;
import com.example.entity.TaxRecord;
import com.example.service.TaxService;

@RestController
@RequestMapping("/api/tax")
@CrossOrigin(origins = "*")
public class TaxController {

    @Autowired
    private TaxService taxService;

    @PostMapping("/calculate")
    public TaxResponse calculate(@RequestBody TaxRequest request) {
        return taxService.calculateTax(request);
    }

    @GetMapping("/history")
    public List<TaxRecord> history() {
        return taxService.getAllRecords();
    }
}
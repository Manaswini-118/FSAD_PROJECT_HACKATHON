package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.TaxRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRepository extends JpaRepository<TaxRecord, Long> {}


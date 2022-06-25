package org.example.secvices.interfaces;

import org.example.model.Bill;
import org.example.model.Warehouse;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IBillService {
    @Transactional
    Page<Bill> findAll(int pageNumber, String sortField, String sortDirection);

    @Transactional
    List<Bill> findAll();

    @Transactional
    Bill findBillById(int id);

    @Transactional
    void deleteBillById(int id);

}

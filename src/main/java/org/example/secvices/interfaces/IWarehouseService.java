package org.example.secvices.interfaces;

import org.example.model.Warehouse;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IWarehouseService {
    @Transactional
    boolean productExistByName(String product);

    @Transactional
    void save(Warehouse warehouse);

    @Transactional
    Page<Warehouse> findAll(int pageNumber, String sortField, String sortDirection);

    @Transactional
    Warehouse findProductById(Integer id);

    @Transactional
    void deleteById(Integer id);
}

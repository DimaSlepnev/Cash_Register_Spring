package org.example.secvices;

import org.example.model.Warehouse;
import org.example.repository.WarehouseRepository;
import org.example.secvices.interfaces.IWarehouseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService implements IWarehouseService {
    private final WarehouseRepository warehouseRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public WarehouseService(WarehouseRepository warehouseRepository, ModelMapper modelMapper) {
        this.warehouseRepository = warehouseRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public Warehouse findByProduct(String product){
       return warehouseRepository.findWarehouseByProduct(product);
    }


    @Override
    @Transactional
    public boolean productExistByName(String product) {
        if(warehouseRepository.existsWarehouseByProduct(product)){
            return true;
        }
        return false;
    }

    @Override
    public void save(Warehouse warehouse) {
        warehouseRepository.save(warehouse);
    }

    @Override
    @Transactional
    public Page<Warehouse> findAll(int pageNumber, String sortField, String sortDirection) {
        Sort sort = Sort.by(sortField);
        sort = (sortDirection.equals("ASC")) ? sort.ascending() : sort.descending();
        Pageable pageable = PageRequest.of(pageNumber - 1, 5, sort);
        return warehouseRepository.findAll(pageable);
    }

    @Override
    public Warehouse findProductById( Integer id) {
        return  warehouseRepository.findWarehouseByProductId(id);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        warehouseRepository.deleteWarehouseByProductId(id);
    }

}

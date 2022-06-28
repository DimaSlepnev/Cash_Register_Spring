package org.example.secvices;

import org.example.model.Warehouse;
import org.example.repository.WarehouseRepository;
import org.example.secvices.interfaces.IWarehouseService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WarehouseService implements IWarehouseService {
    private final WarehouseRepository warehouseRepository;
    private final ModelMapper modelMapper;

    private final Logger logger = LoggerFactory.getLogger(WarehouseService.class);

    @Autowired
    public WarehouseService(WarehouseRepository warehouseRepository, ModelMapper modelMapper) {
        this.warehouseRepository = warehouseRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public Warehouse findByProduct(String product) {
        return warehouseRepository.findWarehouseByProduct(product);
    }


    @Override
    @Transactional
    public boolean productExistByName(String product) {
        if (warehouseRepository.existsWarehouseByProduct(product)) {
            logger.warn("Product with name {} already exists", product);
            return true;
        } else {
            logger.info("Product with name {} have`t exists yet", product);
            return false;
        }
    }

    @Override
    public void save(Warehouse warehouse) {
        logger.debug("Product {} was added to warehouse", warehouse);
        warehouseRepository.save(warehouse);
    }

    @Override
    @Transactional
    public Page<Warehouse> findAll(int pageNumber, String sortField, String sortDirection) {
        logger.info("Find warehouse on page: {}, sorted field: {}, sorted direction: {}", pageNumber, sortField, sortDirection);
        Sort sort = Sort.by(sortField);
        sort = (sortDirection.equals("ASC")) ? sort.ascending() : sort.descending();
        Pageable pageable = PageRequest.of(pageNumber - 1, 5, sort);
        return warehouseRepository.findAll(pageable);
    }

    @Override
    public Warehouse findProductById(Integer id) {
        logger.info("Try to find product with id: {}",id);
        return warehouseRepository.findWarehouseByProductId(id);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        logger.debug("Product with id {} was removed", id);
        warehouseRepository.deleteWarehouseByProductId(id);
    }

}

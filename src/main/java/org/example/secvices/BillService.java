package org.example.secvices;

import org.example.model.Bill;
import org.example.repository.BillRepository;
import org.example.secvices.interfaces.IBillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BillService implements IBillService {

    static final Logger logger = LoggerFactory.getLogger(BillService.class);

    @Autowired
    BillRepository billRepository;

    @Override
    @Transactional
    public List<Bill> findAll() {
        return (List<Bill>) billRepository.findAll();
    }

    @Override
    @Transactional
    public Page<Bill> findAll(int pageNumber, String sortField, String sortDirection) {
        logger.info("Find bills on page: {}, sorted field: {}, sorted direction: {}", pageNumber, sortField, sortDirection);
        Sort sort = Sort.by(sortField);
        sort = (sortDirection.equals("ASC")) ? sort.ascending() : sort.descending();
        Pageable pageable = PageRequest.of(pageNumber - 1, 5, sort);
        return billRepository.findAll(pageable);
    }

    @Override
    public Bill findBillById(int id) {
        return billRepository.findBillById(id);
    }

    @Override
    @Transactional
    public void deleteBillById(int id) {
        logger.debug("Bill with id {} was deleted",id);
        billRepository.deleteBillByBillId(id);
    }

    @Transactional
    public void save(Bill bill) {
        logger.debug("Add or edit bill {}",bill);
        billRepository.save(bill);
    }
}

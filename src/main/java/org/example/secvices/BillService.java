package org.example.secvices;

import org.example.model.Bill;
import org.example.repository.BillRepository;
import org.example.secvices.interfaces.IBillService;
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
        billRepository.deleteBillByBillId(id);
    }

    @Transactional
    public void save(Bill bill){
        billRepository.save(bill);
    }
}

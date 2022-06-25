package org.example.repository;

import org.example.model.Bill;
import org.example.model.Warehouse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface BillRepository extends CrudRepository<Bill,Long>, PagingAndSortingRepository<Bill,Long> {

    @Query("SELECT b FROM Bill b WHERE b.billId = :id")
    Bill findBillById(@Param("id") int id);

    void deleteBillByBillId(int id);

}

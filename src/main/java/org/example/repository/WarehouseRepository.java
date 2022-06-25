package org.example.repository;

import org.example.model.Warehouse;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends CrudRepository<Warehouse,Long>, PagingAndSortingRepository<Warehouse, Long> {
    @Query("SELECT w FROM Warehouse w WHERE w.productId = :id")
    Warehouse findWarehouseByProductId(@Param("id") Integer id);

    boolean existsWarehouseByProduct(String product);
    Warehouse findWarehouseByProduct(String product);

    @Modifying
    @Query("DELETE FROM Warehouse w WHERE w.productId = :id")
    void deleteWarehouseByProductId(@Param("id") Integer id);
}

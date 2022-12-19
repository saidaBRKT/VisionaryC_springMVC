package com.visionaryCrofting.demo.Repositories;

import com.visionaryCrofting.demo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findByRef(String ref);
    int deleteByRef(String ref);
    public Page<Product> findByNameContains(String mc, Pageable pageable);

    @Query("select  p from Product  p where p.name like :x and p.price>:y")
    public Page<Product> chercher(
            @Param("x")String mc,
            @Param("y")double prixMin,Pageable pageable
    );
}

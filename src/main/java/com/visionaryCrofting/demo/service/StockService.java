package com.visionaryCrofting.demo.service;

import com.visionaryCrofting.demo.entity.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public interface StockService {
    Stock save(Stock stock);
    void deleteById(Long id);
    Stock updateStock(Stock stock);

    Optional<Stock> getById(Long id);
    List<Stock> getAll();
    Specification<AppelOffre> getSpec(String refProduit ,String status , String fournisseur);

    Collection<AppelOffre> search(String refProduit , String status , String fournisseur);
}



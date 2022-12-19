package com.visionaryCrofting.demo.Repositories;

import com.visionaryCrofting.demo.entity.AppelOffre;
import com.visionaryCrofting.demo.entity.Stock;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {

     List<Stock> findAll(Specification<AppelOffre> specification);

     @Query("SELECT u FROM AppelOffre u WHERE u.status=:status")
     Collection<AppelOffre> findAllAppelDoffreByStatus(@Param("status") String status);

}

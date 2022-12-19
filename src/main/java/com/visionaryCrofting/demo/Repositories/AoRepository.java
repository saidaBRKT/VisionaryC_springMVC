package com.visionaryCrofting.demo.Repositories;

import com.visionaryCrofting.demo.entity.AppelOffre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AoRepository extends JpaRepository<AppelOffre,Long> {
    int deleteByRef(String ref);
    AppelOffre findByRef(String ref);




}

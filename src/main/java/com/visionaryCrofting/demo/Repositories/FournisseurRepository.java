package com.visionaryCrofting.demo.Repositories;

import com.visionaryCrofting.demo.entity.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {
    // get fournisseur by email
    Fournisseur findByEmail(String email);
}

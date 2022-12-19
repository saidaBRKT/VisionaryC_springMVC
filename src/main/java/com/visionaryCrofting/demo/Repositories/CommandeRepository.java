package com.visionaryCrofting.demo.Repositories;

import com.visionaryCrofting.demo.entity.Commande;
import com.visionaryCrofting.demo.entity.StatusCmd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande,Long> {
    Commande findByRef(String ref);
    Commande getByClient_id(Long id);
    @Query("select c from Commande  c where c.client.id = :id and c.status = :statusCmd")
    public Commande getCommadeClient(Long id, StatusCmd statusCmd);

}

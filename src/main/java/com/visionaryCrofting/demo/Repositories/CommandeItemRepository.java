package com.visionaryCrofting.demo.Repositories;

import com.visionaryCrofting.demo.entity.CommandeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeItemRepository extends JpaRepository<CommandeItem,Long> {




}

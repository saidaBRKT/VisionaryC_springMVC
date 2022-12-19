package com.visionaryCrofting.demo.service;

import com.visionaryCrofting.demo.entity.Commande;
import com.visionaryCrofting.demo.entity.StatusCmd;

import java.util.List;

public interface CommandService {
    List<Commande> getAllCommande();
    Commande getCommandeById(Long id);
    Commande getCommandeByRef(String ref);
    Commande addCommande(Commande commande);
    String deleteCommande(Long id);
    Commande getCommandeInProgress(Long id_cl, StatusCmd statusCmd);
    Commande save(Commande commande);

    Commande saveCommand(Commande commande);
}

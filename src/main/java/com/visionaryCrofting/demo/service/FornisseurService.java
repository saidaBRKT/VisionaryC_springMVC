package com.visionaryCrofting.demo.service;

import com.visionaryCrofting.demo.entity.AppelOffre;
import com.visionaryCrofting.demo.entity.Fournisseur;

import java.util.List;

public interface FornisseurService {

    List<Fournisseur> getAllFournisseur();
    Fournisseur getFournisseurById(Long id);
    Fournisseur getFournisseurByEmail(String email);
    Fournisseur addFournisseur(Fournisseur fournisseur);
    String deleteFournisseur(Long id);
    Fournisseur updateFournisseur(Long id, Fournisseur fournisseur);
    AppelOffre validate(Long id_fournisseur ,Long ao);


}

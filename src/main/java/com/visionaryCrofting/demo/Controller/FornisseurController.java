package com.visionaryCrofting.demo.Controller;

import com.visionaryCrofting.demo.entity.AppelOffre;
import com.visionaryCrofting.demo.entity.Fournisseur;
import com.visionaryCrofting.demo.service.implementation.FornisseurServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornisseur")
public class FornisseurController {
    public final FornisseurServiceImp fornisseurService;

    @Autowired
    public FornisseurController(FornisseurServiceImp fornisseurService) {
        this.fornisseurService = fornisseurService;
    }

    // get all fournisseur
    @GetMapping("/all")
    public List<Fournisseur> getAllFournisseur(){
        return fornisseurService.getAllFournisseur();
    }
    // get fournisseur by id
    @GetMapping("/id/{id}")
    public Fournisseur getFournisseurById(Long id){
        return fornisseurService.getFournisseurById(id);
    }
    // get fournisseur by Email
    @GetMapping("/email/{email}")
    public Fournisseur getFournisseurByEmail(String email){
        return fornisseurService.getFournisseurByEmail(email);
    }
    // add fournisseur
    @PostMapping("/add")
    public Fournisseur addFournisseur(@RequestBody Fournisseur fournisseur){
        return fornisseurService.addFournisseur(fournisseur);
    }
    // delete fournisseur
    @GetMapping("/delete/{id}")
    public String deleteFournisseur(Long id){
        return fornisseurService.deleteFournisseur(id);
    }
    // update fournisseur
    @PutMapping("/update/{id}")
    public Fournisseur updateFournisseur(Long id, Fournisseur fournisseur){
        return fornisseurService.updateFournisseur(id, fournisseur);
    }
    @PutMapping("/validate/{id_fournissuer}")
    public AppelOffre validate(@PathVariable Long id_fournissuer , @RequestBody Long id_AppelOffre ){
        return fornisseurService.validate(id_fournissuer, id_AppelOffre);
    }

}

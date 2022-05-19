package com.example.produitapi.controller;

import com.example.produitapi.model.Produit;
import com.example.produitapi.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//cette annotation permet de dire que cette classe est un controller avec api rest
@RestController
public class ProduitController {

    @Autowired
    ProduitService produitService;

    @GetMapping("/produits")
    public List<Produit> getProduit() {
        return produitService.getAllProduit();
    }

    @GetMapping("/produit/{id}")
    public Produit getProduit(@PathVariable("id") long id) {
        Optional<Produit> produit = produitService.getProduit(id);
        return produit.get();
    }

    //supprimer un produit
    @GetMapping("/produit/delete/{id}")
    public void deleteProduit(@PathVariable("id") long id) {
        produitService.deleteProduit(id);
    }

    //création d'un produit
    @PostMapping("/produit/create")
    public Produit createProduit(@RequestBody Produit produit) {
        return produitService.saveProduit(produit);
    }

    //modification d'un produit
    @PutMapping("/produit/update/{id}")
    public Produit updateProduit(@PathVariable("id") long id, @RequestBody Produit produit) {
        Optional<Produit> prod = produitService.getProduit(id);
        if (prod.isPresent()) {
            Produit p = prod.get();
            String libelle = produit.getLibelle();
            if (libelle != null) {
                p.setLibelle(libelle);
            }

            int quantite = produit.getQuantite();
            if (quantite != 0) {
                p.setQuantite(quantite);
            }
            double prix = produit.getPrix();
            if (prix != 0) {
                p.setPrix(prix);
            }

            produitService.saveProduit(p);
            return p;
        } else {
            return null;
        }
    }
}

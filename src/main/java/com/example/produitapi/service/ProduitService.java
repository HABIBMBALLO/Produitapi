package com.example.produitapi.service;

import com.example.produitapi.model.Produit;
import com.example.produitapi.repository.ProduitRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class ProduitService {
    @Autowired
    ProduitRepository produitRepository;
    public List<Produit> getAllProduit(){
        return produitRepository.findAll();
    }
    public Produit saveProduit(Produit produit){
        return produitRepository.save(produit);
    }
    public Produit getProduitById(long id){
        return produitRepository.findById(id);
    }
    public Optional<Produit> getProduit(long id){
        Produit p = produitRepository.findById(produit);
        return p;
    }
    public void deleteProduit(long id){
        produitRepository.deleteById(id);
    }
}

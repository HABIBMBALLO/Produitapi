package com.example.produitapi.repository;

import com.example.produitapi.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public class ProduitRepository {

    public interface ProduitRepository extends JpaRepository<Produit, Integer> {

        // Méthode pour récupérer le produit par son nom
        Produit findByName(String name);

    }
    }



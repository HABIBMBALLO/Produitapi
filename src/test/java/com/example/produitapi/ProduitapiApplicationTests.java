package com.example.produitapi;

import com.example.produitapi.model.Produit;
import com.example.produitapi.service.ProduitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProduitapiApplicationTests {
    @Autowired
    ProduitService produitService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testAjoutProduit() {
        Produit p = new Produit();
        p.setLibelle("oignon");
        p.setQuantite(10);
        p.setPrix(243.0);

        produitService.saveProduit(p);

    }

}

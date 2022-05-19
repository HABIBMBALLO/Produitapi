package com.example.produitapi;

import com.example.produitapi.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProduitapiApplication {
    @Autowired
    prroduiService produitService;
@SpringBootApplication
    void contextLoads() {
    }
    @SpringBootApplication
    public void SpringBootApplicationAjout() {
        Produit p = new Produit();
        p.setLibelle("oignon");
        p.setQuantite(10);
        p.setPrix(243.0);

        produitService.saveProduit(p);

    }


}

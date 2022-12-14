package com.springboot.springbootproject;

import com.springboot.springbootproject.model.Produit;
import com.springboot.springbootproject.repos.ProduitRepository;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.List;


@SpringBootTest
@IncludeEngines("junit-jupiter")
@SelectPackages("org.jsmart.zerocode.samplesjunit5.loadjupiter")
@TargetEnv("application-config.properties")
@ActiveProfiles("test")
class DataBaseTests {

    // database testing
    @Autowired
    private ProduitRepository produitRepository;

    @Profile("test")

    @Test
    public void testCreateProduit() {
        Produit prod = new Produit("ASUS",1500.00,new Date());
        produitRepository.save(prod);
        System.out.println(prod);
    }

    @Test
    public void testFindProduit() {
        Produit p = produitRepository.findById(1L).get();
        System.out.println(p);
    }

    @Test
    public void testUpdateProduit() {
        Produit p = produitRepository.findById(1L).get();
        p.setPrixProduit(2000.0);
        p.setIdProduit(10L);
        produitRepository.save(p);
        System.out.println(p);
    }

    @Test
    public void testDeleteProduit()
    {
        produitRepository.deleteById(1L);
    }

    @Test
    public void testFindAllProduits() {
        List<Produit> prods = produitRepository.findAll();
        for (Produit p:prods)
            System.out.println(p);
    }
}

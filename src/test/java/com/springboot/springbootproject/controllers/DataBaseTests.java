package com.springboot.springbootproject.controllers;

import com.springboot.springbootproject.model.Produit;
import com.springboot.springbootproject.repos.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class DataBaseTests {

    // database testing
    @Autowired
    private ProduitRepository produitRepository;



    @Test
    public void testCreateProduit() {
        Produit prod = new Produit("ASUS",1500.00,new Date());
        produitRepository.save(prod);
        System.out.println(prod);
    }

    @Test
    public void testFindProduit() {
        Produit p = produitRepository.findById(77L).get();
        System.out.println(p);
    }

    @Test
    public void testUpdateProduit() {
        Produit p = produitRepository.findById(77L).get();
        p.setPrixProduit(2000.0);
        p.setIdProduit(10L);
        produitRepository.save(p);
        System.out.println(p);
    }

    @Test
    public void testDeleteProduit()
    {
        produitRepository.deleteById(77L);
    }

    @Test
    public void testFindAllProduits() {
        List<Produit> prods = produitRepository.findAll();
        for (Produit p:prods)
            System.out.println(p);
    }
}

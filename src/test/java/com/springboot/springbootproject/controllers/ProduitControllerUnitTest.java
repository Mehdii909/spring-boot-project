package com.springboot.springbootproject.controllers;

import com.springboot.springbootproject.model.Produit;
import com.springboot.springbootproject.repos.ProduitRepository;
import com.springboot.springbootproject.service.ProduitService;
import com.springboot.springbootproject.service.ProduitServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProduitControllerUnitTest {
    private ProduitRepository produitRepository;
    private ProduitServiceImpl produitService;
    @BeforeEach
    void setUp() {
    produitRepository = mock(ProduitRepository.class);
    produitService = new ProduitServiceImpl(produitRepository);
    }

    @Test
    void showHello() {
        ProduitController produitController = new ProduitController();
        assertEquals("Hello from ProduitController", produitController.showHello());
        System.out.println("ShowHello() Test passed");
    }

    @Test
    void saveProduit() {
        Produit prod = new Produit("ASUS",1500.500,new Date());
        when(produitRepository.save(any())).then(returnsFirstArg());

        assertEquals("ASUS", prod.getNomProduit());
        assertEquals(1500.500, prod.getPrixProduit());
        System.out.println("saveProduit() Test passed");
    }

    @Test
    void listeProduits() {

    }

    @Test
    void supprimerProduit() {
    }

    @Test
    void updateProduit() {

    }
}

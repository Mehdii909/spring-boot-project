package com.springboot.springbootproject.service;

import com.springboot.springbootproject.model.Produit;

import java.util.List;
public interface ProduitService {

    Produit saveProduit(Produit p);
    void updateProduit(Produit p);
    void deleteProduit(Produit p);
    void deleteProduitById(Long id);
    Produit getProduit(Long id);
    List<Produit> getAllProduits();
}

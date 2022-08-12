package com.springboot.springbootproject.service;

import com.springboot.springbootproject.model.Produit;
import com.springboot.springbootproject.repos.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    ProduitRepository produitRepository;

    public ProduitServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public Produit saveProduit(Produit p) {
        produitRepository.save(p);
        return p;
    }

    @Override
    public void updateProduit(Produit p) {
        produitRepository
                .findById(p.getIdProduit()) // returns Optional<User>
                .ifPresent(p1 -> {
                    p1.setNomProduit(p.getNomProduit());
                    p1.setPrixProduit(p.getPrixProduit());

                    produitRepository.save(p1);
                });

    }

    @Override
    public void deleteProduit(Produit p) {
        produitRepository.delete(p);
    }

    @Override
    public void deleteProduitById(Long id) {
        produitRepository.deleteById(id);
    }

    @Override
    public Produit getProduit(Long id) {
        return produitRepository.findById(id).get();
    }

    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

}

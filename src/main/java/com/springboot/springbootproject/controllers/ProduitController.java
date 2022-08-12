package com.springboot.springbootproject.controllers;

import java.util.List;

import com.springboot.springbootproject.model.Produit;
import com.springboot.springbootproject.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProduitController {
    @Autowired
    ProduitService produitService;

    @RequestMapping("/showHello")
    public String showHello()
    {
        return "Hello from ProduitController";
    }

    @PostMapping(value = "/saveProduit")
    public Produit saveProduit(@RequestBody Produit produit)
    {
        produitService.saveProduit(produit);
        System.out.println(produit.toString());
        return produit;
    }


    @RequestMapping("/ListeProduits")
    public List<Produit> listeProduits(ModelMap modelMap)
    {
        List<Produit> prods = produitService.getAllProduits();
        modelMap.addAttribute("produits", prods);
        return prods;
    }

    @RequestMapping("/supprimerProduit")
    public List<Produit> supprimerProduit(@RequestParam("id") Long id, ModelMap modelMap)
    {
        produitService.deleteProduitById(id);

        List<Produit> prods = produitService.getAllProduits();
        modelMap.addAttribute("produits", prods);
        return prods;
    }


    @PostMapping(value = "/modifierProduit")
    public Produit updateProduit(@RequestBody Produit produit,
                                 @RequestParam("id") Long id)
    {
        produit.setIdProduit(id);
        produitService.updateProduit(produit);
        return produitService.getProduit(id);
    }


}

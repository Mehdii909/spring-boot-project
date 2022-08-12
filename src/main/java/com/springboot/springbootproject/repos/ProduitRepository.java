package com.springboot.springbootproject.repos;

import com.springboot.springbootproject.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProduitRepository extends JpaRepository<Produit, Long> {

}

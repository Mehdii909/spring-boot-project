package com.springboot.springbootproject.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Produit {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idProduit;
    private String nomProduit;
    private Double prixProduit;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateCreation;

    public Produit() {

    }
    public Produit(String nomProduit, double prixProduit, Date dateCreation) {
        this.nomProduit=nomProduit;
        this.prixProduit=prixProduit;
        this.dateCreation=dateCreation;
    }


    @PrePersist
    private void onCreate() {
        dateCreation = new Date();
    }



    public Long getIdProduit() {
        return idProduit;
    }
    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }
    public String getNomProduit() {
        return nomProduit;
    }
    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }
    public Double getPrixProduit() {
        return prixProduit;
    }
    public void setPrixProduit(Double prixProduit) {
        this.prixProduit = prixProduit;
    }
    public Date getDateCreation() {
        return dateCreation;
    }
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }


    @Override
    public String toString() {
        return "Produit [idProduit=" + idProduit + ", nomProduit=" + nomProduit + ", prixProduit=" + prixProduit
                + ", dateCreation=" + dateCreation + "]";
    }



}

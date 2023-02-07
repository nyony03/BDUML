package model.produit;

import java.util.Objects;

public class Produit implements I_Produit {

    private int quantiteStock;
    private String nom;
    private Double prixUnitaireHT;
    private Double tauxTVA = 0.2;

    public Produit(String nom, Double prixUnitaireHT, int quantiteStock) {
        this.nom = nom;
        this.prixUnitaireHT = prixUnitaireHT;
        this.quantiteStock = quantiteStock;
    }

    @Override
    public boolean ajouter(int qteAchetee) {
        quantiteStock += qteAchetee;
        return true;
    }

    @Override
    public boolean enlever(int qteVendue) {
        if (qteVendue > quantiteStock) {
            return false;
        } else {
            quantiteStock -= qteVendue;
        }
        return true;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public int getQuantite() {
        return quantiteStock;
    }

    @Override
    public double getPrixUnitaireHT() {
        return prixUnitaireHT;
    }

    @Override
    public double getPrixUnitaireTTC() {
        return prixUnitaireHT*(1+tauxTVA);
    }

    @Override
    public double getPrixStockTTC() {
        return getPrixUnitaireTTC()*quantiteStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return nom.equals(produit.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }
}

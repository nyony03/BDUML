package model.catalogue;

import model.produit.I_Produit;
import model.produit.Produit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Catalogue implements I_Catalogue{
    private Collection<I_Produit> produits;

    public Catalogue() {
        this.produits = new ArrayList<>();
    }

    @Override
    public boolean addProduit(I_Produit produit) {
        if(produits.contains(produit) || produit == null || produit.getPrixUnitaireHT() <= 0 || produit.getQuantite() < 0)
            return false;
        produits.add(produit);
        return true;
    }

    @Override
    public boolean addProduit(String nom, double prix, int qte) {
        if (prix <= 0 || qte < 0)
            return false;
        Produit produit = new Produit(nom, prix, qte);
        return addProduit(produit);
    }

    @Override
    public int addProduits(List<I_Produit> l) {
        if (l == null)
            return 0;
        int nbProduitAjoute = 0;
        for (I_Produit produit : l) {
            if (addProduit(produit)) {
                nbProduitAjoute ++;
            }
        }
        return nbProduitAjoute;
    }

    @Override
    public boolean removeProduit(String nom) {
        for(I_Produit produit : produits){
            if(produit.getNom().equals(nom)){
                produits.remove(produit);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean acheterStock(String nomProduit, int qteAchetee) {
        for(I_Produit produit : produits){
            if(produit.getNom().equals(nomProduit) && qteAchetee > 0){
                produit.ajouter(qteAchetee);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean vendreStock(String nomProduit, int qteVendue) {
        for(I_Produit produit : produits){
            if(produit.getNom().equals(nomProduit) && qteVendue > 0 && qteVendue <= produit.getQuantite()){
                produit.enlever(qteVendue);
                return true;
            }
        }
        return false;
    }

    @Override
    public String[] getNomProduits() {
        String[] nomProduits = new String[produits.size()];
        int i = 0;
        for(I_Produit produit : produits){
            nomProduits[i] += produit.getNom();
            i++;
        }
        return nomProduits;
    }

    @Override
    public double getMontantTotalTTC() {
        double montantTotalTTC = 0;
        for(I_Produit produit : produits){
            montantTotalTTC += produit.getPrixStockTTC();
        }
        return Math.round(montantTotalTTC * 100.0) / 100.0;
    }

    @Override
    public void clear() {
        produits.clear();
    }
}

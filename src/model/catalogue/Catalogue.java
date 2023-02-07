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
        if(produits.contains(produit))
            return false;
        produits.add(produit);
        return true;
    }

    @Override
    public boolean addProduit(String nom, double prix, int qte) {
        Produit produit = new Produit(nom, prix, qte);

        if(produits.contains(produit))
            return false;

        produits.add(produit);
        return true;
    }

    @Override
    public int addProduits(List<I_Produit> l) {
        if(produits.containsAll(l))
            return 0;

        produits.addAll(l);
        return 1;
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
            if(produit.getNom().equals(nomProduit)){
                produit.ajouter(qteAchetee);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean vendreStock(String nomProduit, int qteVendue) {
        for(I_Produit produit : produits){
            if(produit.getNom().equals(nomProduit)){
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
            montantTotalTTC += produit.getPrixUnitaireTTC() * produit.getQuantite();
        }
        return montantTotalTTC;
    }

    @Override
    public void clear() {
        produits.clear();
    }
}
package model.produit;

public class Produit implements I_Produit {

    private int quantiteStock;
    private String nom;
    private Double prixUnitaireHT;
    private Double tauxTVA = 2.0;

    public Produit(String nom, Double prixUnitaireHT) {
        this.nom = nom;
        this.prixUnitaireHT = prixUnitaireHT;
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
        return prixUnitaireHT*tauxTVA;
    }

    @Override
    public double getPrixStockTTC() {
        return getPrixUnitaireTTC()*quantiteStock;
    }
}

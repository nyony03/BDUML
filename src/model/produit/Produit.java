package model.produit;

public class Produit implements I_Produit{
    private String nom;
    private double prix;
    private int qte;

    public Produit(String nom, double prix, int qte) {
        this.nom = nom;
        this.prix = prix;
        this.qte = qte;
    }

    @Override
    public boolean ajouter(int qteAchetee) {
        return false;
    }

    @Override
    public boolean enlever(int qteVendue) {
        return false;
    }

    @Override
    public String getNom() {
        return null;
    }

    @Override
    public int getQuantite() {
        return 0;
    }

    @Override
    public double getPrixUnitaireHT() {
        return 0;
    }

    @Override
    public double getPrixUnitaireTTC() {
        return 0;
    }

    @Override
    public double getPrixStockTTC() {
        return 0;
    }
}

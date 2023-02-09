package Controler;


import model.catalogue.Catalogue;

public class CreerSupprimerController {

    public String[] demandeSuppression(){
        return Catalogue.getInstance().getNomProduits();
    }

    public boolean supprimerProduit(String nomProduit){
        return Catalogue.getInstance().removeProduit(nomProduit);
    }

    public boolean demandeAjoutProduit(String nom, double prix, int qte){
        return Catalogue.getInstance().addProduit(nom, prix, qte);
    }


}

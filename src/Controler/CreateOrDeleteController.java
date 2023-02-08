package Controler;


import model.catalogue.Catalogue;

public class CreateOrDeleteController {

    public String[] demandeSuppression(Catalogue catalogue){

        return Catalogue.getInstance().getNomProduits();
    }

    public boolean supprimerProduit(String nomProduit){

        return Catalogue.getInstance().removeProduit(nomProduit);
    }

    public boolean demandeAjoutProduit(Catalogue catalogue,String nom, double prix, int qte){
        return Catalogue.getInstance().addProduit(nom, prix, qte);
    }


}

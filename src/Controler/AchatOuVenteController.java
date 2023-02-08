package Controler;

import model.catalogue.Catalogue;

public class AchatOuVenteController {

    public String[] demandeAchat(){

        return Catalogue.getInstance().getNomProduits();
    }

    public boolean acheterProduit(String nomProduit, int qteAchetee){
        return Catalogue.getInstance().acheterStock(nomProduit, qteAchetee);
    }

    public String[] demandeVente(){

        return Catalogue.getInstance().getNomProduits();
    }

    public boolean vendreProduit(String nomProduit, int qteAchetee){
        return Catalogue.getInstance().vendreStock(nomProduit, qteAchetee);
    }

}

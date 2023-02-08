package Controler;

import model.catalogue.Catalogue;

public class EtatStockController {

    public String demandeAffichageStock(){
        return Catalogue.getInstance().toString();
    }
}

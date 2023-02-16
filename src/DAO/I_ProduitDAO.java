package DAO;

import model.produit.I_Produit;
import java.util.Collection;

public interface I_ProduitDAO {

    boolean create(I_Produit iProduit);

    Collection<I_Produit> readAll();

    I_Produit findOne(String nomProduit);

    boolean update(I_Produit iProduit);

    boolean delete(I_Produit iProduit);

}

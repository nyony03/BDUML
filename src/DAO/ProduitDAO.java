package DAO;

import model.produit.I_Produit;
import model.produit.Produit;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class ProduitDAO {

    ConnexionBD connexionBD = ConnexionBD.getInstance();

    public ProduitDAO() throws SQLException, ClassNotFoundException {
    }

    public boolean create(I_Produit produit) throws SQLException {
        try {
            PreparedStatement pst = connexionBD.getCn().prepareStatement(
                    "INSERT INTO produits('nom', 'prixHT', 'quantite') VALUES ( ?, ?, ?)",
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            pst.setString(1, produit.getNom());
            pst.setDouble(2, produit.getPrixUnitaireHT());
            pst.setDouble(3, produit.getQuantite());
            pst.executeQuery();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public Collection<I_Produit> readAll() throws SQLException {
        Collection<I_Produit> produits = new ArrayList<>();
        connexionBD.st = connexionBD.getCn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        connexionBD.rs = connexionBD.st.executeQuery("SELECT * FROM produits");
        while (!connexionBD.rs.isAfterLast()) {
            produits.add(new Produit(
                    connexionBD.rs.getString(2),
                    connexionBD.rs.getDouble(3),
                    connexionBD.rs.getInt(4)
                    ));
        }
        return produits;
    }
}

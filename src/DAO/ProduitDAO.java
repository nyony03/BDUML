package DAO;

import model.produit.I_Produit;
import model.produit.Produit;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class ProduitDAO implements I_ProduitDAO {

    ConnexionBD connexionBD = ConnexionBD.getInstance();

    public ProduitDAO() throws SQLException, ClassNotFoundException {
    }

    @Override
    public boolean create(I_Produit produit) {
        try {
            PreparedStatement pst = connexionBD.getCn().prepareStatement(
                    "INSERT INTO produits('nom', 'prixHT', 'quantite') VALUES ( ?, ?, ?)"
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

    @Override
    public Collection<I_Produit> readAll() {
        Collection<I_Produit> produits = new ArrayList<>();
        try {
            connexionBD.st = connexionBD.getCn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            connexionBD.rs = connexionBD.st.executeQuery("SELECT * FROM produits");
            connexionBD.rs.first();
            while (!connexionBD.rs.isAfterLast()) {
                produits.add(new Produit(
                        connexionBD.rs.getString(2),
                        connexionBD.rs.getDouble(3),
                        connexionBD.rs.getInt(4)
                ));
                connexionBD.rs.next();
            }
            return produits;
        } catch (Exception e) {
            return produits;
        }
    }

    @Override
    public I_Produit findOne(String nomProduit) {
        try {
            PreparedStatement pst = connexionBD.getCn().prepareStatement(
                    "SELECT * FROM produits WHERE 'nom' = ?"
            );
            pst.setString(1, nomProduit);
            ResultSet rs = pst.executeQuery();
            I_Produit produit = null;
            if (rs.next()) {
                 produit = new Produit(
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4)
                );
            }
            return produit;
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    public boolean update(I_Produit produit) {
        try {
            PreparedStatement pst = connexionBD.getCn().prepareStatement(
                    "UPDATE produits SET 'prixHT' = ?, 'quantite' = ? WHERE nom = ?"
            );
            pst.setDouble(1, produit.getPrixUnitaireHT());
            pst.setInt(2, produit.getQuantite());
            pst.executeQuery();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(I_Produit produit) {
        try {
            PreparedStatement pst = connexionBD.getCn().prepareStatement(
                    "DELETE FROM produits WHERE 'nom' = ?"
            );
            pst.setString(1, produit.getNom());
            pst.executeQuery();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

package view;

import Controler.CreerSupprimerController;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FenetreSuppressionProduit extends JFrame implements ActionListener {

	private JButton btSupprimer;
	private JComboBox<String> combo;
	private CreerSupprimerController creerSupprimerController;
	
	public FenetreSuppressionProduit(String lesProduits[]) {
		
		setTitle("Suppression produit");
		setBounds(500, 500, 200, 105);
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		btSupprimer = new JButton("Supprimer");

		combo = new JComboBox<String>(lesProduits);
		combo.setPreferredSize(new Dimension(100, 20));
		contentPane.add(new JLabel("Produit"));
		contentPane.add(combo);
		contentPane.add(btSupprimer);

		btSupprimer.addActionListener(this);

		this.setVisible(true);

		creerSupprimerController = new CreerSupprimerController();
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (creerSupprimerController.supprimerProduit(combo.getSelectedItem().toString())) {
				new FenetreAffichage(combo.getSelectedItem().toString()+ " supprimé");
			} else {
				new FenetreAffichage("Erreur de saisie");
			}
		} catch (Exception exception) {
		new FenetreAffichage("Erreur de saisie");
	}

	}

}

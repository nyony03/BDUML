package view;

import Controler.AchatOuVenteController;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FenetreAchat extends JFrame implements ActionListener {

	private JButton btAchat;
	private JTextField txtQuantite;
	private JComboBox<String> combo;
	private AchatOuVenteController achatOuVenteController;

	public FenetreAchat(String[] lesProduits) {

		setTitle("Achat");
		setBounds(500, 500, 200, 125);
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		btAchat = new JButton("Achat");
		txtQuantite = new JTextField(5);
		txtQuantite.setText("0");

		combo = new JComboBox<String>(lesProduits);
		combo.setPreferredSize(new Dimension(100, 20));
		contentPane.add(new JLabel("Produit"));
		contentPane.add(combo);
		contentPane.add(new JLabel("Quantit� achet�e"));
		contentPane.add(txtQuantite);
		contentPane.add(btAchat);

		btAchat.addActionListener(this);

		this.setVisible(true);

		achatOuVenteController = new AchatOuVenteController();
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (achatOuVenteController.acheterProduit(combo.getSelectedItem().toString(), Integer.parseInt(txtQuantite.getText()))) {
				new FenetreAffichage(combo.getSelectedItem().toString() + " acheté");
			} else {
				new FenetreAffichage("Erreur de saisie");
			}
		} catch (Exception exception) {
			new FenetreAffichage("Erreur de saisie");
		}
	}
}

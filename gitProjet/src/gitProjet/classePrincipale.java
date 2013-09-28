package gitProjet;

import javax.swing.JFrame;

/**
 * @date {date}
 * @authors Thomas Brunel et Gabriel Guilbart
 * 
 */
public class classePrincipale {

	/**
	 * 
	 * @param args Arguments de la commande.
	 */
	public static void main(String[] args){
		//Création de la fenêtre :				
		JFrame fenetre = new JFrame();
		fenetre.setSize(600,600);
		fenetre.setTitle("Lena");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Création du panneau qui contiendra l'image :		
		Panneau pan = new Panneau();
		fenetre.setContentPane(pan);

		//Affichage de la fenêtre :
		fenetre.setVisible(true);
	}
}

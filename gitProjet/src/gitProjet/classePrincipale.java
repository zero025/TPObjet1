package gitProjet;

import javax.swing.JFrame;

/**
 * @date {date}
 * @author Thomas Brunel
 * 
 */
public class classePrincipale {

	/**
	 * 
	 * @param args Arguments de la commande.
	 */
	public static void main(String[] args){
		JFrame fenetre = new JFrame();
		fenetre.setSize(600,600);
		fenetre.setTitle("Lena");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Panneau pan = new Panneau();
		fenetre.setContentPane(pan);
		fenetre.setVisible(true);
	}
}

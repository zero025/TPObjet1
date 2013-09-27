package gitProjet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @date {date}
 * @author Thomas Brunel
 * 
 */
public class classePrincipale {

	/**
	 * 
	 * @param args Arguments de la commande.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		 
		try {
			Vector<Integer> img = new Vector<Integer>();
			int currentChar;
			int largeur, hauteur;
			int lastChar=32;
			int currentNumber=0;
			br = new BufferedReader(new FileReader("lena.pgm"));
			
			for(int i=0;i<2;i++)
			{
				br.readLine();
			}
			largeur = (br.read()-48)*100+(br.read()-48)*10+(br.read()-48);
			br.read();
			hauteur = (br.read()-48)*100+(br.read()-48)*10+(br.read()-48);
			br.readLine();
			
			while ((currentChar = br.read()) != -1) {
				if (lastChar >=48 && lastChar <=57 && currentChar>=48 && currentChar<=57 )
				{
					currentNumber = currentNumber*10+currentChar-48;
				}
				else if ((lastChar<48 || lastChar>57)&&(currentChar>=48 && currentChar<=57))
				{
					currentNumber=currentChar-48;
				}
				else if ((lastChar<48 || lastChar>57)&&(currentChar<48|| currentChar>57))
				{
					currentNumber=0;
				}
				else
				{
					img.add(currentNumber);
					currentNumber=0;
				}
				lastChar = currentChar;
			}
			for(int i=0;i<img.size();i++)
			{
				System.out.println(img.elementAt(i));
				
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
 
	}
}

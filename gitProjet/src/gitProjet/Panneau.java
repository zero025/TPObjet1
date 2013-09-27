package gitProjet;
	
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JPanel;

public class Panneau extends JPanel{
	public void paintComponent(Graphics g){
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

        BufferedImage image = new BufferedImage(largeur,hauteur,BufferedImage.TYPE_BYTE_BINARY);
        for (int i=0;i<hauteur;i++){
            for (int j=0;j<largeur;j++){
                image.setRGB(j,i,convertir(img.elementAt(i*hauteur+j)));
            }
        }

        g.drawImage(image, 0, 0, this);
		      
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
	
	public static int convertir(int gris){
	    return((gris<<16)+(gris<<8)+gris);
	}
}



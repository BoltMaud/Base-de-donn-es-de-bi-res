/**
 * Fichier de la Classe Vecteurs contenant les bouteilles: initisalitation et cherche
 * @autor Mathilde Boltenhagen, Arthur Scheidel
 */
import java.io.Serializable;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.util.StringTokenizer;
import java.io.*;
import java.util.*;
import java.net.URL;



/**
 * vecteur_Bouteilles contient les bouteilles du tableau
 */
 @SuppressWarnings("serial")
public class Vecteurs implements Serializable{//prévoit que l'objet sera serialisé
	Vector <Bouteille> vecteur_Bouteilles;

    /**
     * INITIALISATION
     * Au debut de notre logiciel, nous donnons un exemple de bouteille avec initialisation()
     * @return void : ajoute la bouteille au vecteur_Bouteilles
     */
	public  void initialisation(){// on met un 
		vecteur_Bouteilles=new Vector<Bouteille>();

		LieuO l1= new LieuO("Abbay de leffe","Belgique");
		Brasserie Br1 = new Brasserie("InBev Belgium",l1);
		Breuvage B1= new Breuvage("Leffe",Br1,"6.6", "blonde", "abbay", "spontanee", Breuvage.fermentationliste[0], "1152","","");
		Bouteille b1= new Bouteille(B1,	"25.0", "classique", Bouteille.fermetures[0], new ImageIcon(getClass().getClassLoader().getResource("images.jpeg")));
		vecteur_Bouteilles.add(b1);
	}
	/**
	 * BOUTEILLE CHERCHEE
	 * Cette fonction renvoie la bouteille avec les paramètres données du vecteur_Bouteilles de la classe Vecteurs
	 * @param nomBreuvage : nom du Breuvage cherchée
	 * @param bouchon : type du bouchon cherchée
	 * @param type : type de la bouteille cherchée
	 * @param taille : taille en Cl de la bouteille cherchée
	 * @return (Bouteille) la bouteille cherchée
	 */
	public  Bouteille bonnebouteille(String nomBreuvage,String bouchon, String type, String taille){
		int i=0;
		//			System.out.println(Bouteille.Fermeture.capsule.toString());
		for( i=0; i<vecteur_Bouteilles.size() 
				&&( (!vecteur_Bouteilles.get(i).getbouchon().equals(bouchon)) || (!vecteur_Bouteilles.get(i).gettype().equals(type)) 
						|| (!vecteur_Bouteilles.get(i).gettaille().equals(taille)) || (!vecteur_Bouteilles.get(i).getbreuvage().getnom().equals(nomBreuvage))); i++) 

		{;}
		return vecteur_Bouteilles.get(i);	
	}
} 


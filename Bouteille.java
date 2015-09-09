/**
 * Fichier de la L'objet Bouteille : sa classe, son constructeurs et ses accesseurs
 * @autor Mathilde Boltenhagen, Arthur Scheidel
 */
 
import java.io.*;
import java.util.StringTokenizer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
@SuppressWarnings("serial")
public class Bouteille implements Serializable{
	Breuvage breuvage;
	private String taille="<unknown>";//en cl
    private	String type="<unknown>";
	private ImageIcon image;
	public static String[] fermetures = {
		"capsule",
		"capsule_vis",
		"bouchon",
		"bouchon_mecanique",
		"pull_off"
	};
	private String bouchon="<unknown>";
	/**
	 * CONSTRUCTEUR
	 * @param Br (Breuvage) : le breuvage de la bouteille
	 * @param taille (String) : en Cl
	 * @param type (String) : classique, champagne , magnum, gros cul
	 * @param bouchon (String) : capsule, champagne
	 * @param image (ImageIcon) : une photo
	 */
	public Bouteille(Breuvage Br, String taille, String type, String bouchon, ImageIcon image){
		this.breuvage=Br;
		this.taille=taille;
		this.type=type;
		this.bouchon=bouchon;
		this.image=image;
	}

	public String toString() {
		return breuvage.toString() + taille + type + bouchon + image;
	}

	/**
	 * @param vide : un breuvage vide sur lequel cette bouteille pointera, ce breuvage vide pointe sur Brasserie vide etc
	 */
	public String gettype(){
		return type;
	}

	public void settype(String type){
		this.type=type;
	}


	public String gettaille(){
		return taille;
	}

	public void settaille(String taille){
		this.taille=taille;
	}
	public String getbouchon(){
		return bouchon;
	}

	public void setbouchon(String bouchon){
		this.bouchon=bouchon;
	}

	public Icon getimage(){
		return image;
	}
	public String getsimage(){
		String renvoie =image.toString();
		StringTokenizer tok= new StringTokenizer(renvoie,"/");
		while(tok.hasMoreTokens()){
			renvoie =tok.nextToken();
		}
		return renvoie;
	}
	public void setimage(ImageIcon image){
		this.image=image;
	}
	public Breuvage getbreuvage(){
		return breuvage;
	}

}

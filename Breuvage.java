/**
 * Fichier de la L'objet Breuvage : sa classe, son constructeurs et ses accesseurs
 * @autor Mathilde Boltenhagen, Arthur Scheidel
 */
import java.io.Serializable;
import java.util.*;

@SuppressWarnings("serial")
public class Breuvage implements Serializable{
	private String nom="<unkonwn>";
	Brasserie Br;
	private String tauxdAlcool="<unknown>";
	private String couleur="<unknown>";
	private String provenance="<unknown>";
	String typefermentation="<unknown>";
	private String annee="<unknown>";
	
	public static String[] fermentationliste = {
		"simple",
		"double",
		"triple",
		"quadruple"
	};
	String fermentation="<unknown>";
	String comdegustation="<unknown>";
	String comlibre="<unknown>";
	/**
	 * CONSTRUCTEUR
	 * @param nom (String) : son nom
	 * @param brasserie (Brasserie) : sa brasserie
	 * @param tauxalc (String) : son taux d'alcool'
	 * @param couleur (String) : sa couleur
	 * @param provenance (String) : sa provenance
	 * @param ferm (String) : son type de fermentation
	 * @param fermentation (String) : sa fermentation
	 * @param annee (String) : l'annee de sa creation
	 * @param comdegustation (String) : commentaire de degustation
	 * @param comlibre (String) : autre commentaire libre
	 */
	public Breuvage (String nom, Brasserie brasserie, String tauxalc, String couleur, String provenance, String ferm, String fermentation,String annee,String comdegustation,String comlibre){
		this.nom=nom;
		this.Br=brasserie;
		this.tauxdAlcool=tauxalc;
		this.couleur=couleur;
		this.provenance=provenance;
		this.fermentation=fermentation;
		this.typefermentation=ferm;
		this.annee=annee;
		this.comdegustation=comdegustation;
		this.comlibre=comlibre;
	}

	public String getnom(){
		return nom;
	}

	public void setnom(String nom) {
		this.nom = nom;
	}

	public String gettauxdalcool(){
		return tauxdAlcool;
	}

	public void settauxdAlcool(String taux) {
		this.tauxdAlcool = taux;
	}

	public String getcouleur(){
		return couleur;
	}

	public void setcouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getprovenance(){
		return provenance;
	}

	public void setprovenance(String provenance) {
		this.provenance = provenance;
	}

	public String gettypefermentation(){
		return typefermentation;
	}

	public void settypefermentation(String typefermentation) {
		this.typefermentation = typefermentation;
	}

	public String getfermentation(){
		return this.fermentation;
	}

	public void setfermentation(String ferm) {
		this.fermentation = ferm;
	}

	public String getannee(){
		return annee;
	}

	public void setannee(String annee) {
		this.annee = annee;
	}

	public String getdegust(){
		return comdegustation;
	}

	public void setdegust(String degust) {
		this.comdegustation = degust;
	}

	public String getlibre(){
		return comlibre;
	}

	public void setlibre(String libre) {
		this.comdegustation = libre;
	}

}

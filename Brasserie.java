/**
 * Fichier de la L'objet Brasserie : sa classe, son constructeurs et ses accesseurs
 * @autor Mathilde Boltenhagen, Arthur Scheidel
 */
import java.io.Serializable;
@SuppressWarnings("serial")
public class Brasserie implements Serializable{
	String nom="<unkonwn>";
	LieuO origine;
	/**
	 * CONSTRUCTEUR
	 * @param nom (String) : le nom de la brasserie
	 * @param origine (LieuO) : l'objet de son lieu d'origine
	 */
	public Brasserie (String nom, LieuO origine){
		this.nom=nom;
		this.origine=origine;
	}

	public String getnom(){
		return nom;
	}

	public void setnom(String nom) {
		this.nom = nom;
	}

	public LieuO getorignie(){
		return origine;
	}

	public void setorigine(LieuO origine) {
		this.origine = origine;
	}

}

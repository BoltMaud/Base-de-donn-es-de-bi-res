/**
 * Fichier de la L'objet LieuO : sa classe, son constructeurs et ses accesseurs
 * @autor Mathilde Boltenhagen, Arthur Scheidel
 */
import java.io.Serializable;
@SuppressWarnings("serial")
public class LieuO implements Serializable{
	private String nom="<unknown>";
	private String pays="<unknown>";

	/**
	 * CONSTRUCTEUR
	 * @param nom (String) : le nom du lieu
	 * @param pays (String) : le pays d'origine
	 */
	public LieuO (String nom, String pays){
		this.nom=nom;
		this.pays=pays;
	}

	public String getnom(){
		return nom;
	}

	public void setnom(String nom) {
		this.nom = nom;
	}

	public String getpays(){
		return pays;
	}

	public void setpays(String pays) {
		this.pays = pays;
	}

}

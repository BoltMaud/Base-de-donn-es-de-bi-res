/**
 * Fichier de la la classe Model : il modelise les objets dans le tableau en initialisant les bonnes colonnes pour chaque element,
 * on peut acceder a l'element d'une case et le modifier'
 * @autor Mathilde Boltenhagen, Arthur Scheidel
 */
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;



public class Model<Fermentation> extends AbstractTableModel {
	private final List<Bouteille> bouteilles = new ArrayList<Bouteille>();

	private final String[] entetes = {"Nom Breuvage", "Nom Brasserie",
			"Nom lieu","Pays",
			"Taux d'alcool","Couleur",
			"Provenance","Type de Fermentation",
			"Fermentation","Année",
			"Centilitres","type",
			"bouchon","photo",
			"com. degustation","com. libre"};
	/**
	 * CONSTRUCTEUR
	 * @param v (Vecteur) : le vecteur qui contient les anciennes donnees ou un exemple d'une leffe blonde
	 */
	public Model(Vecteurs v) {
		super();
		for(int i=0;i<v.vecteur_Bouteilles.size();i++){
			bouteilles.add(v.vecteur_Bouteilles.get(i));
		}
	}

	public int getRowCount() {
		return bouteilles.size();
	}

	public int getColumnCount() {
		return entetes.length;
	}

	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}
	
	/**
	 * ACCESSEUR
	 * accede a la donnee de la ligne et colonne donnee
	 * @param rowIndex (int) : la ligne
	 * @param column (int) : la colonne
	 */
	 
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex){ // recupere la donnee de chaque colonne : 14 colonnes
		case 0:
			return bouteilles.get(rowIndex).breuvage.getnom();
		case 1:
			return bouteilles.get(rowIndex).breuvage.Br.getnom();
		case 2:
			return bouteilles.get(rowIndex).breuvage.Br.origine.getnom();
		case 3:
			return bouteilles.get(rowIndex).breuvage.Br.origine.getpays();
		case 4:
			return bouteilles.get(rowIndex).breuvage.gettauxdalcool();
		case 5:
			return bouteilles.get(rowIndex).breuvage.getcouleur();
		case 6:
			return bouteilles.get(rowIndex).breuvage.getprovenance();
		case 7:
			return bouteilles.get(rowIndex).breuvage.gettypefermentation();
		case 8:
			return bouteilles.get(rowIndex).breuvage.getfermentation();
		case 9:
			return bouteilles.get(rowIndex).breuvage.getannee();
		case 10:
			return bouteilles.get(rowIndex).gettaille();
		case 11:
			return bouteilles.get(rowIndex).gettype();
		case 12:
			return bouteilles.get(rowIndex).getbouchon();
		case 13:
			return bouteilles.get(rowIndex).getimage();

		default:        
			return null; //Ne devrait jamais arriver
		}
	}

	/**
	 * ACCESSEUR
	 * accede a la classe de la colonne donnee
	 * @param column (int) : la colonne
	 */
	public Class getColumnClass(int columnIndex){
		switch(columnIndex){
		case 8:
			return String.class;
		case 13:
			return ImageIcon.class;
		default:
			return Object.class;
		}
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true; //Toutes les cellules sont editables
	}

	/**
	 * ACCESSEUR
	 * modifie la valeur de la ligne et colonne donnee
	 * @param aValue (Objet) : la nouvelle valeur, de type generique 
	 * @param rowIndex (int) : la ligne
	 * @param column (int) : la colonne
	 */
	 
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		if(aValue != null){
			Bouteille bouteille = bouteilles.get(rowIndex);

			switch(columnIndex){
			case 0:
				bouteilles.get(rowIndex).breuvage.setnom((String)aValue);
				break;
			case 1:
				bouteilles.get(rowIndex).breuvage.Br.setnom((String)aValue);
				break;
			case 2:
				bouteilles.get(rowIndex).breuvage.Br.origine.setnom((String)aValue);
				break;
			case 3:
				bouteilles.get(rowIndex).breuvage.Br.origine.setpays((String)aValue);
				break;
			case 4:
				bouteilles.get(rowIndex).breuvage.settauxdAlcool((String)aValue);
				break;
			case 5:
				bouteilles.get(rowIndex).breuvage.setcouleur((String)aValue);
				break;
			case 6:
				bouteilles.get(rowIndex).breuvage.setprovenance((String)aValue);
				break;
			case 7:
				bouteilles.get(rowIndex).breuvage.settypefermentation((String)aValue);
				break;
			case 8:
				bouteilles.get(rowIndex).breuvage.setfermentation((String)aValue);
				break;
			case 9:
				bouteilles.get(rowIndex).breuvage.setannee((String)aValue);
				break;
			case 10:
				bouteilles.get(rowIndex).settaille((String)aValue);
				break;
			case 11:
				bouteilles.get(rowIndex).settype((String)aValue);
				break;
			case 12:
				bouteilles.get(rowIndex).setbouchon((String)aValue);
				break;
			case 13:
				bouteilles.get(rowIndex).setimage((ImageIcon)aValue);
				break;
			}
		}
	}

	public void addBouteille(Bouteille bouteille) {
		bouteilles.add(bouteille);

		fireTableRowsInserted(bouteilles.size()-1 , bouteilles.size()-1 );
	}

	public void removeBouteille(int rowIndex) {
		bouteilles.remove(rowIndex);

		fireTableRowsDeleted(rowIndex, rowIndex);
	}
}





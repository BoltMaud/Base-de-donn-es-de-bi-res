/**
 * Fichier de la classe Tableau base de l'interface du logiciel, contient le main qui lance la fenetre, les constructeur,
 * modificateur de la fenetre, les regles d'affichages et les boutons'
 * @autor Mathilde Boltenhagen, Arthur Scheidel
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.awt.Color;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;



public class Tableau extends JFrame {

	private Model modele;
	private JTable tableau;
	private TableRowSorter<TableModel> sorter;
	private Data donnees;
	private boolean printimage = false;

	@SuppressWarnings("static-access")
	/**
	 * CONSTRUCTEUR
	 * Initialise les donnees dans le tableau, les dimension de la fenetre et des cases du la base de donnee, puis les boutons.
	 */
	public Tableau() throws IOException, ClassNotFoundException{
		super();

		Vecteurs v = new Vecteurs();
		File fichier= new File("data.ser");
		if(!fichier.exists()) 
		{
			v.initialisation();
			donnees = new Data(v);
			donnees.saveData();
		}
		else {
			donnees=new Data();
			v=donnees.getVecteurs();
		}



		modele=new Model(v);

		setTitle("Biere Book");
		setSize(200,200);
		setPreferredSize(new Dimension(1200,300));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tableau = new JTable(modele){

			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component component = super.prepareRenderer(renderer, row, column);
				int rendererWidth = component.getPreferredSize().width;
				TableColumn tableColumn = getColumnModel().getColumn(column);
				tableColumn.setPreferredWidth(Math.max(rendererWidth +
						getIntercellSpacing().width,
						tableColumn.getPreferredWidth()));
				return component;
			}

		};
		tableau.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		sorter = new TableRowSorter<TableModel>(tableau.getModel());
		tableau.setRowSorter(sorter);

		getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);

		JPanel boutons = new JPanel();

		boutons.add(new JButton(new AddAction()));
		boutons.add(new JButton(new RemoveAction()));
		boutons.add(new JButton(new Modifier()));
		boutons.add(new JButton(new Retour()));
		boutons.add(new JButton(new FilterAction()));
		boutons.add(new JButton(new Save()));
		boutons.add(new JButton(new ExportAction()));
		boutons.add(new JButton(new ImageAction()));


		getContentPane().add(boutons, BorderLayout.SOUTH);

		if (printimage == false){
			tableau.getColumnModel().getColumn(13).setMinWidth(0);
			tableau.getColumnModel().getColumn(13).setMaxWidth(0);
		}
		pack();
	}

	/**
	 * methode MAIN
	 * se contente de rendre le tableau visible
	 */
	 
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		new Tableau().setVisible(true);

	}

	/**
	 * classe et methode du bouton AJOUTER
	 * ajoute le bouton Ajouter et instancie un Ajout 
	 * @see Ajout.java
	 */

	private class AddAction extends AbstractAction {
		private AddAction() {
			super("Ajouter");
		}

		public void actionPerformed(ActionEvent e) {
			Ajout a=new Ajout(modele,donnees.v,sorter,tableau);
			tableau.revalidate();
		}

	}

	/**
	 * classe et methode du bouton SUPPRIMER
	 * ajoute le bouton Ajouter et supprime la ligne selectionner
	 */
	 
	private class RemoveAction extends AbstractAction {
		private RemoveAction() {
			super("Supprimer");
		}
		public void actionPerformed(ActionEvent e) {
			int[] selection = tableau.getSelectedRows();
			int[] modelIndexes = new int[selection.length];
			int l=tableau.getSelectedRow(); 

			String nomBreuvage =(String) (modele.getValueAt(l,0)); 
			String bouchon=(String)(modele.getValueAt(l,12));
			String type =(String) (modele.getValueAt(l,10));
			String taille=(String) (modele.getValueAt(l,11));
			donnees.v.vecteur_Bouteilles.removeElement(donnees.v.bonnebouteille(nomBreuvage,bouchon, type, taille));

			for(int i = 0; i < selection.length; i++){ 
				modelIndexes[i] = tableau.getRowSorter().convertRowIndexToModel(selection[i]);
			}

			Arrays.sort(modelIndexes);

			for(int i = modelIndexes.length - 1; i >= 0; i--){
				modele.removeBouteille(modelIndexes[i]);
			}
		}
	}

	/**
	 * classe et methode du bouton MODIFIER
	 * ajoute le bouton Modifier et instancie un Modif
	 * @see Modif.java
	 */
	 
	private class Modifier extends AbstractAction {
		private Modifier() {
			super("Modifier");
		}

		public void actionPerformed(ActionEvent e) {
			int[] selection = tableau.getSelectedRows();
			int[] modelIndexes = new int[selection.length];
			int l=tableau.getSelectedRow(); 

			String nomBreuvage =(String) (modele.getValueAt(l,0)); 
			String bouchon=(String) (modele.getValueAt(l,12));
			String type =(String) (modele.getValueAt(l,10));
			String taille=(String) (modele.getValueAt(l,11));
			Bouteille bout =donnees.v.bonnebouteille(nomBreuvage,bouchon, type, taille);

			for(int i = 0; i < selection.length; i++){ 
				modelIndexes[i] = tableau.getRowSorter().convertRowIndexToModel(selection[i]);
			}

			Arrays.sort(modelIndexes);

			for(int i = modelIndexes.length - 1; i >= 0; i--){
				modele.removeBouteille(modelIndexes[i]);
			}
			Modif mod=new Modif(modele,donnees.v,bout, sorter,tableau);
			tableau.revalidate();
		}
	}
	
	/**
	 * classe et methode du bouton FILTRE
	 * ajoute le bouton Filtre et initialise un redex sur toute les colonnes
	 */
	 
	private class FilterAction extends AbstractAction {
		private FilterAction() {
			super("Filtrer");
		}

		public void actionPerformed(ActionEvent e) {
			String regex = JOptionPane.showInputDialog("filtre : ");
			sorter.setRowFilter(RowFilter.regexFilter(regex, 0, 1,2,3,4,5,6,7,8,9,10,11,12,13));
		}
	}

	/**
	 * classe et methode du bouton AFFICHE/MASQUER IMG
	 * ajoute le bouton Ajoute/Masquer image et adapte la colonne image en fonction du boolean printimage 
	 * soit la taille est reduite a 0 soit la taille est redefinit a la taille de la plus grande image
	 */
	 
	private class ImageAction extends AbstractAction {
		private ImageAction() {
			super("Afficher/masquer image");
		}

		public void actionPerformed(ActionEvent e) {
			if (printimage == true){
				tableau.getColumnModel().getColumn(13).setMinWidth(0);
				tableau.getColumnModel().getColumn(13).setMaxWidth(0);
				tableau.setRowHeight(16);
				printimage = false;
			}
			else {
				printimage = true;
				try
				{
					int widthmax = 0;
					for (int row = 0; row < tableau.getRowCount(); row++)
					{
						ImageIcon img = (ImageIcon) (modele.getValueAt(row,13));
						if (widthmax < img.getIconWidth()) widthmax = img.getIconWidth();
						tableau.setRowHeight(row, img.getIconHeight());
						tableau.getColumnModel().getColumn(13).setMinWidth(0);
						tableau.getColumnModel().getColumn(13).setMaxWidth(widthmax);
					}
				}
				catch(ClassCastException e1) {}
			}
			tableau.revalidate();
		}
	}
	
	/**
	 * classe et methode du bouton SAUVEGARDER
	 * sauvegarde les donnee du vecteur dans le fichier .ser
	 */

	private class Save extends AbstractAction {
		private Save() {
			super("Sauvegarder");
		}
		@SuppressWarnings("static-access")
		public void actionPerformed(ActionEvent e)  {
			try {
				donnees.saveData();
				donnees.saveData();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}   		 

		}
	}

	/**
	 * methode du bouton EXPORT 
	 * recopie dans un fichier .txt chaque element d'une ligne, les separe par une tabulation et separe les lignes par des retour a la ligne
	 */
	 
	public void totxt(JTable table, File file){
		try{
			TableModel model = table.getModel();
			FileWriter txt = new FileWriter(file);

			for(int i = 0; i < model.getColumnCount(); i++){
				txt.write(model.getColumnName(i) + "\t");
			}

			txt.write("\n");

			for(int i=0; i< model.getRowCount(); i++) {
				for(int j=0; j < model.getColumnCount(); j++) {
					txt.write(model.getValueAt(i,j).toString()+"\t");
				}
				txt.write("\n");
			}

			txt.close();
		}catch(IOException e){ System.out.println(e); }
		tableau.setSelectionBackground(Color.cyan);
	}
	
	/**
	 * classe du bouton EXPORT 
	 * ouvre une fenetre d'enregistrement et enregistre le fichier'
	 */
	 
	private class ExportAction extends AbstractAction{
		private ExportAction() {
			super("Exporter");
		}
		public void actionPerformed(ActionEvent e){
			JFileChooser fc = new JFileChooser();
			int option = fc.showSaveDialog(Tableau.this);
			if(option == JFileChooser.APPROVE_OPTION){
				String filename = fc.getSelectedFile().getName(); 
				String path = fc.getSelectedFile().getParentFile().getPath();

				int len = filename.length();
				String ext = "";
				String file = "";

				if(len > 4){
					ext = filename.substring(len-4, len);
				}

				if(ext.equals(".txt")){
					file = path + "/" + filename; 
				}else{
					file = path + "/" + filename + ".txt"; 
				}
				totxt(tableau, new File(file));
			}

		}
	}
	
	/**
	 * classe du bouton QUITTER FILTRE 
	 * permet de revenir au tableau general apres une recherche filtree
	 */
	private class Retour extends AbstractAction {
		private Retour(){
			super("Quitte Filtre");
		}
		public void actionPerformed(ActionEvent e) {
			sorter = new TableRowSorter<TableModel>(tableau.getModel());
			tableau.setRowSorter(sorter);
			try
			{
				for (int row = 0; row < tableau.getRowCount(); row++)
				{
					ImageIcon img = (ImageIcon) (modele.getValueAt(row,13));
					tableau.setRowHeight(row, img.getIconHeight());
				}
			}
			catch(ClassCastException er) {
				pack();
			}
			tableau.revalidate();

		}
	}
}
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JDialog;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Modif extends JDialog{
	private static final long serialVersionUID = 1L;

	JPanel panel;
	JLabel LabelNomBreuvage, LabelNomBrasserie, LabelLieu, LabelPays, LabelTaux,LabelCouleur,LabelProvenance,LabelType,LabelFermt,LabelAnnee,Labeltaille,Labeltype,Labelbouchon,Labelphoto,Labelcom1,Labelcom2;
	JTextField FieldNomBreuvage, FieldNomBrasserie, FieldLieu, FieldPays, FieldTaux,FieldCouleur,FieldProvenance,FieldType,FieldAnnee,Fieldtaille,Fieldtype,Fieldphoto,Fieldcom1,Fieldcom2;

	JComboBox FieldFermt,Fieldbouchon;
	JButton add;
	Vecteurs v;
	Model m;
	Bouteille temp;
	TableRowSorter<TableModel> s;
	JTable t;


	public Modif(Model mo,Vecteurs ve,Bouteille b,TableRowSorter<TableModel> sorter,JTable Tableau)
	{
		v=ve;
		m=mo;
		temp=b;
		s=sorter;
		t=Tableau;
		this.setTitle("Modification d'une bière");
		this.setSize(800,520);
		this.setResizable(false);
		centerOnScreen(this);
		panel = new JPanel();
		panel.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.add(panel);
		this.setVisible(true);
		JComboBox comboF = new JComboBox(Breuvage.fermentationliste);
		JComboBox comboB = new JComboBox(Bouteille.fermetures);

		LabelNomBreuvage = new JLabel("Nom Breuvage");
		LabelNomBreuvage.setSize(110, 30);
		LabelNomBreuvage.setLocation(30,20);
		panel.add(LabelNomBreuvage);

		FieldNomBreuvage = new JTextField(b.getbreuvage().getnom());
		FieldNomBreuvage.setSize(180, 30);
		FieldNomBreuvage.setLocation(170,20);
		panel.add(FieldNomBreuvage);

		LabelNomBrasserie = new JLabel("Brasserie");
		LabelNomBrasserie.setSize(70,30);
		LabelNomBrasserie.setLocation(400, 20);
		panel.add(LabelNomBrasserie);

		FieldNomBrasserie = new JTextField(b.getbreuvage().Br.getnom());
		FieldNomBrasserie.setSize(180, 30);
		FieldNomBrasserie.setLocation(520, 20);
		panel.add(FieldNomBrasserie);

		LabelLieu = new JLabel("Lieu");
		LabelLieu.setSize(70,30);
		LabelLieu.setLocation(30, 70);
		panel.add(LabelLieu);

		FieldLieu = new JTextField(b.getbreuvage().Br.getorignie().getnom());
		FieldLieu.setSize(180,30);
		FieldLieu.setLocation(170,70);
		panel.add(FieldLieu);

		LabelPays = new JLabel("Pays");
		LabelPays.setSize(70, 30);
		LabelPays.setLocation(400,70);
		panel.add(LabelPays);

		FieldPays = new JTextField(b.getbreuvage().Br.getorignie().getpays());
		FieldPays.setSize(180, 30);
		FieldPays.setLocation(520, 70);
		panel.add(FieldPays);

		LabelTaux = new JLabel("Taux d'alcool");
		LabelTaux.setSize(120, 30);
		LabelTaux.setLocation(30, 120);
		panel.add(LabelTaux);

		FieldTaux = new JTextField(b.breuvage.gettauxdalcool());
		FieldTaux.setSize(180, 30);
		FieldTaux.setLocation(170, 120);
		panel.add(FieldTaux);

		LabelCouleur = new JLabel("Couleur ");
		LabelCouleur.setSize(70, 30);
		LabelCouleur.setLocation(400, 120);
		panel.add(LabelCouleur);

		FieldCouleur = new JTextField(b.breuvage.getcouleur());
		FieldCouleur.setSize(180, 30);
		FieldCouleur.setLocation(520, 120);
		panel.add(FieldCouleur);

		LabelProvenance = new JLabel("Provenance");
		LabelProvenance.setSize(70, 30);
		LabelProvenance.setLocation(30, 170);
		panel.add(LabelProvenance);

		FieldProvenance = new JTextField(b.breuvage.getprovenance());
		FieldProvenance.setSize(180, 30);
		FieldProvenance.setLocation(170, 170);
		panel.add(FieldProvenance);

		LabelType = new JLabel("Type Ferm ");
		LabelType.setSize(100, 30);
		LabelType.setLocation(400, 170);
		panel.add(LabelType);

		FieldType = new JTextField(b.breuvage.typefermentation); 
		FieldType.setSize(180, 30);
		FieldType.setLocation(520, 170);
		panel.add(FieldType);

		LabelFermt = new JLabel("Fermenation");
		LabelFermt.setSize(100, 30);
		LabelFermt.setLocation(30, 220);
		panel.add(LabelFermt);

		FieldFermt = comboF;
		FieldFermt.setSize(180, 30);
		FieldFermt.setLocation(170, 220);
		panel.add(FieldFermt);

		LabelAnnee = new JLabel("Annee");
		LabelAnnee.setSize(70, 30);
		LabelAnnee.setLocation(400, 220);
		panel.add(LabelAnnee);

		FieldAnnee = new JTextField(b.breuvage.getannee());
		FieldAnnee.setSize(180, 30);
		FieldAnnee.setLocation(520, 220);
		panel.add(FieldAnnee);

		Labeltaille = new JLabel("Taille (en cl)");
		Labeltaille.setSize(70, 30);
		Labeltaille.setLocation(30, 270);
		panel.add(Labeltaille);

		Fieldtaille = new JTextField(b.gettaille());
		Fieldtaille.setSize(180, 30);
		Fieldtaille.setLocation(170, 270);
		panel.add(Fieldtaille);

		Labeltype = new JLabel("Type bouteille");
		Labeltype.setSize(110, 30);
		Labeltype.setLocation(400, 270);
		panel.add(Labeltype);

		Fieldtype = new JTextField(b.gettype());
		Fieldtype.setSize(180, 30);
		Fieldtype.setLocation(520, 270);
		panel.add(Fieldtype);

		Labelbouchon = new JLabel("Bouchon");
		Labelbouchon.setSize(70, 30);
		Labelbouchon.setLocation(30, 320);
		panel.add(Labelbouchon);

		Fieldbouchon = comboB;
		Fieldbouchon.setSize(180, 30);
		Fieldbouchon.setLocation(170, 320);
		panel.add(Fieldbouchon);

		Labelphoto = new JLabel("Photo");
		Labelphoto.setSize(70, 30);
		Labelphoto.setLocation(400, 320);
		panel.add(Labelphoto);

		Fieldphoto = new JTextField(b.getsimage());
		Fieldphoto.setSize(180, 30);
		Fieldphoto.setLocation(520, 320);
		panel.add(Fieldphoto);

		Labelcom1 = new JLabel("Com. degustation");
		Labelcom1.setSize(100, 30);
		Labelcom1.setLocation(30, 370);
		panel.add(Labelcom1);

		Fieldcom1 = new JTextField("");
		Fieldcom1 .setSize(180, 50);
		Fieldcom1 .setLocation(170, 370);
		panel.add(Fieldcom1 );

		Labelcom2 = new JLabel("Com. libre");
		Labelcom2.setSize(110, 30);
		Labelcom2.setLocation(400, 370);
		panel.add(Labelcom2);

		Fieldcom2 = new JTextField("");
		Fieldcom2 .setSize(180, 50);
		Fieldcom2 .setLocation(520, 370);
		panel.add(Fieldcom2 );


		add = new JButton("Modifier");
		add.setHorizontalAlignment(SwingConstants.CENTER);
		add.setSize(150,30);
		add.setLocation(350,450);
		add.addActionListener(new modifLister());
		panel.add(add);

	}

	public void centerOnScreen(Window w) 
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		w.setLocation(screenSize.width / 2 - (w.getWidth() / 2),
				screenSize.height / 2 - (w.getHeight() / 2));
	}

	class modifLister implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			LieuO l1= new LieuO(FieldLieu.getText(),FieldPays.getText());
			Brasserie Br1 = new Brasserie(FieldNomBrasserie.getText(),l1);
			Breuvage B1= new Breuvage(FieldNomBreuvage.getText(),Br1,FieldTaux.getText(),FieldCouleur.getText() , FieldProvenance.getText(), FieldType.getText(), (String) FieldFermt.getSelectedItem(), FieldAnnee.getText(),Fieldcom1.getText(),Fieldcom2.getText());
			Bouteille bout;
			if(Fieldphoto.getText().equals("")){
				System.out.println("là");
				bout= new Bouteille(B1,	Fieldtaille.getText(), Fieldtype.getText(), (String) Fieldbouchon.getSelectedItem(), new ImageIcon(getClass().getClassLoader().getResource("vide.jpeg")));
			}
			else {
				System.out.println("li");
				bout= new Bouteille(B1,	Fieldtaille.getText(), Fieldtype.getText(), (String) Fieldbouchon.getSelectedItem(), new ImageIcon(getClass().getClassLoader().getResource(Fieldphoto.getText())));
			}

			m.addBouteille(bout);
			v.vecteur_Bouteilles.add(bout);
			v.vecteur_Bouteilles.removeElement(temp);

			s = new TableRowSorter<TableModel>(t.getModel());
			t.setRowSorter(s);
			try
			{
				for (int	 row = 0; row < t.getRowCount(); row++)
				{
					ImageIcon img = (ImageIcon) (m.getValueAt(row,13));
					t.setRowHeight(row, img.getIconHeight());
				}
			}
			catch(ClassCastException er) {
				pack();
			}
			t.revalidate();
			dispose(); 
		}
	}

}
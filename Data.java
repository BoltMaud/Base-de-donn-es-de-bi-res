/**
 * CONSTRUCTEUR 
 * @param v : un élément de la classe Vecteurs (donc avec les 4vecteurs)
 */
import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.io.Serializable;

public class Data
{
	static Vecteurs v;

	/**
	 * CONSTRUCTEUR 
	 * @param v : un élément de la classe Vecteurs (donc avec les 4vecteurs)
	 */
	public Data(Vecteurs v)
	{
		Data.v =v;
	}

	/**
	 * CONSTRUCTEUR 
	 * à partir du fichier "data.ser""
	 * @see loadData()
	 */
	public  Data() throws ClassNotFoundException, IOException
	{ 
		Data.loadData();
	}

	/**
	 * SAVE 
	 * met à jour le fichier "data.ser"
	 */
	public static void saveData() throws IOException
	{
		File file = new File("data.ser");
		FileOutputStream fileOut = new FileOutputStream(file);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(Data.v);
		out.close();
		fileOut.close();
	}

	/**
	 * LOAD
	 * récupère les données du fichier "data.ser"
	 * l'objet 'v' de la classe est alors rempli
	 */
	public static void loadData() throws IOException, ClassNotFoundException
	{
		FileInputStream fileIn = new FileInputStream("data.ser");
		ObjectInputStream in = new ObjectInputStream(fileIn);
		Data.v = (Vecteurs) in.readObject();
		in.close();
		fileIn.close();
	}

	/**
	 * @return l'objet de classe Vecteur de data
	 */
	public Vecteurs getVecteurs()
	{
		return v;
	}
}
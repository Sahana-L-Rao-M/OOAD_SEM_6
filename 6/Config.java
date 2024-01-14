import java.io.*;
import java.util.*;

public class Config implements Serializable {

    private HashMap<String, String> keyValues;

    public Config() {
        this.keyValues = new HashMap<String, String>();
        // set default values to null
        this.keyValues.put("Path", null);
        this.keyValues.put("Version", null);
        this.keyValues.put("System_Name", null);
    }

    public void set(String key, String value) {
        this.keyValues.put(key, value);
    }

    public String get(String key) {
        return this.keyValues.get(key);
    }

    public void serialize() {
        try {
            FileOutputStream fileOut = new FileOutputStream("config.cfg");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        } catch(IOException i) {
            i.printStackTrace();
        }
    }

    public static Config deserialize() {
        Config config = null;
        try {
            FileInputStream fileIn = new FileInputStream("config.cfg");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            config = (Config) in.readObject();
            in.close();
            fileIn.close();
        } catch(IOException i) {
            i.printStackTrace();
        } catch(ClassNotFoundException c) {
            c.printStackTrace();
        }
        return config;
    }

    public static void main(String[] args) 
	{
        Config config = null;
        File configFile = new File("config.cfg");
        if (configFile.exists()) 
		{
            config = Config.deserialize();
        } 
		else 
		{
            config = new Config();
        }
		
		//To update/insert values by application element
		Scanner scan=new Scanner(System.in);
		System.out.println("Do you want to update?\n1-Yes 2-No:	 ");
		int a=scan.nextInt();
		if(a==1)
		{
			Scanner st=new Scanner(System.in);
			System.out.println("Enter Path: ");
			String s=st.nextLine();
			config.set("Path", s);
			System.out.println("Enter Version: ");
			s=st.nextLine();
			config.set("Version", s);
			System.out.println("Enter System_Name: ");
			s=st.nextLine();
			config.set("System_Name", s);
			config.serialize();
			config = Config.deserialize();
			System.out.println(config.keyValues);
			
		}
		else if(a==2)
		{
			// print updated config object
			config.serialize();			
			config = Config.deserialize();
			System.out.println(config.keyValues);
		}
		else
		{
			System.exit(0);
			
		}
	}
}

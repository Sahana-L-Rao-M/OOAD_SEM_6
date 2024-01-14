import java.io.*;
import java.util.HashMap;

public class Config implements Serializable {

    private HashMap<String, String> keyValues;

    public Config() {
        this.keyValues = new HashMap<String, String>();
        // set default values
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

    public static void main(String[] args) {
        Config config = null;
        File configFile = new File("config.cfg");
        if (configFile.exists()) {
            config = Config.deserialize();
        } else {
            config = new Config();
        }

        // update config values
        /*config.set("Path", "/usr/local");
        config.set("Version", "1.0");
        config.set("System_Name", "My System");*/

        // serialize and store
        config.serialize();

        // print updated config object
        System.out.println(config.keyValues);
    }
}

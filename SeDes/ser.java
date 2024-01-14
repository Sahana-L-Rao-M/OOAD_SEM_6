import java.io.*;
class Vehicle implements Serializable {
    private String name;
    private String color;
	private int speed;

    public Vehicle(String name, String color, int speed) {
        this.name = name;
		this.color=color;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }
	
	public String getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }
}

public class ser {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Vehicle v = new Vehicle("Baleno","Grey",120);

        // Serialize the object to a file
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("vehicle.ser"));
        out.writeObject(v);
        out.close();

        // Deserialize the object from the file
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("vehicle.ser"));
        Vehicle getVehicle = (Vehicle) in.readObject();
        in.close();

        // Print the deserialized object's properties
        System.out.println(getVehicle.getName());
		System.out.println(getVehicle.getColor());
        System.out.println(getVehicle.getSpeed());
    }
}

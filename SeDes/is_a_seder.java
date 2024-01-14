import java.io.*;

class Automobile implements Serializable {
    private String manufacturer;
    private String color;
    private int year;

    public Automobile(String manufacturer, String color, int year) {
        this.manufacturer = manufacturer;
        this.color = color;
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return color;
    }

    public int getYear() {
        return year;
    }
}

class Vehicle extends Automobile implements Serializable {
    private String type;

    public Vehicle(String manufacturer, String color, int speed, String type) {
        super(manufacturer, color, speed);
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

public class is_a_seder {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("Baleno", "Grey", 120, "Hatchback");

        try {
            FileOutputStream fileOut = new FileOutputStream("vehicle.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(vehicle);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in vehicle.ser");
        } 
		catch (IOException e) {
            e.printStackTrace();
        }
		
		try {
            FileInputStream fileIn = new FileInputStream("vehicle.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Vehicle inVehicle = (Vehicle) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Deserialized data:");
            System.out.println("Manufacturer: " + inVehicle.getManufacturer());
            System.out.println("Model: " + inVehicle.getModel());
            System.out.println("Year: " + inVehicle.getYear());
            System.out.println("Type: " + inVehicle.getType());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
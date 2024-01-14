import java.io.*;

class Driver implements Serializable {
    private String name;
	private int age;

    public Driver(String name, int age) {
        this.name = name;
		this.age = age;
    }

    public String getName() {
        return name;
    }
	
	public int getAge() {
        return age;
    }
}

class Vehicle implements Serializable {
    private String vehicleName;
    private String color;
    private int speed;
    private Driver driver;

    public Vehicle(String vehicleName, String color, int speed, Driver driver) {
        this.vehicleName = vehicleName;
        this.color = color;
        this.speed = speed;
        this.driver = driver;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public String getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }

    public Driver getDriver() {
        return driver;
    }
}
public class has_a_serder{
    public static void main(String[] args) {
        Driver driver = new Driver("Satyendar Roy",35);
        Vehicle vehicle = new Vehicle("Baleno", "Grey", 120, driver);

        try {
            FileOutputStream fileOut = new FileOutputStream("vehicle.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(vehicle);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in vehicle.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		try {
            FileInputStream fileIn = new FileInputStream("vehicle.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Vehicle inVehicle = (Vehicle) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Deserialized data:");
            System.out.println("Name: " + inVehicle.getVehicleName());
            System.out.println("Color: " + inVehicle.getColor());
            System.out.println("Speed: " + inVehicle.getSpeed());
            System.out.println("Driver: " + inVehicle.getDriver().getName() + " Age: "+inVehicle.getDriver().getAge());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

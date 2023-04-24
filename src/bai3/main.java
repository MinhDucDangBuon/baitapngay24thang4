package bai3;
import java.util.Scanner;
class Vehicle{
    private String ownerName;
    private String vehicleType;
    private double capacity;
    private double value;

    public Vehicle(String ownerName, String vehicleType, double capacity, double value){
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.capacity = capacity;
        this.value = value;
    }
    public Vehicle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter owner name:");
        this.ownerName = scanner.nextLine();
        System.out.println("Enter vehicle type:");
        this.vehicleType = scanner.nextLine();
        System.out.println("Enter vehicle capacity:");
        this.capacity = scanner.nextInt();
        System.out.println("Enter vehicle value:");
        this.value = scanner.nextDouble();
    }
    public String getOwnerName() {
        return ownerName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getValue() {
        return value;
    }
    public double calculateTax() {
        if (capacity < 100) {
            return value * 0.01;
        } else if (capacity >= 100 && capacity <= 200) {
            return value * 0.03;
        } else {
            return value * 0.05;
        }
    }
}
public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Vehicle xe1 = null;
        Vehicle xe2 = null;
        Vehicle xe3 = null;

        int selection = 0;

        do {
            System.out.println("+-------------------------+");
            System.out.println("| Vehicle Management Menu |");
            System.out.println("+-------------------------+");
            System.out.println("| 1. Enter information    |");
            System.out.println("| 2. Export tax sheet     |");
            System.out.println("| 3. Exit                 |");
            System.out.println("+-------------------------+");

            System.out.print("Please select an option: ");
            selection = input.nextInt();

            switch (selection) {
                case 1:
                    input.nextLine(); // consume the leftover newline
                    System.out.println("+----------------------------------+");
                    System.out.println("| Enter Vehicle Information        |");
                    System.out.println("+----------------------------------+");

                    System.out.print("Enter Owner Name: ");
                    String ownerName = input.nextLine();

                    System.out.print("Enter Vehicle Type: ");
                    String vehicleType = input.nextLine();

                    System.out.print("Enter Cylinder Capacity: ");
                    int capacity = input.nextInt();

                    System.out.print("Enter Vehicle Value: ");
                    double value = input.nextDouble();

                    if (xe1 == null) {
                        xe1 = new Vehicle(ownerName, vehicleType, capacity, value);
                    } else if (xe2 == null) {
                        xe2 = new Vehicle(ownerName, vehicleType, capacity, value);
                    } else if (xe3 == null) {
                        xe3 = new Vehicle(ownerName, vehicleType, capacity, value);
                    } else {
                        System.out.println("All vehicle slots are full. Cannot add more vehicles.");
                    }
                    break;

                case 2:
                    if (xe1 == null || xe2 == null || xe3 == null) {
                        System.out.println("Please create vehicles first.");
                    } else {
                        System.out.println("+----------------------------------------------------------------+");
                        System.out.printf("| %-15s | %-15s | %-8s | %-12s | %-6s |\n", "Owner Name", "Vehicle Type", "Capacity", "Value", "Tax");
                        System.out.println("+----------------------------------------------------------------+");
                        System.out.printf("| %-15s | %-15s | %-8g | %-12.2f | %-6.2f |\n", xe1.getOwnerName(), xe1.getVehicleType(), xe1.getCapacity(), xe1.getValue(), xe1.calculateTax());
                        System.out.printf("| %-15s | %-15s | %-8g | %-12.2f | %-6.2f |\n", xe2.getOwnerName(), xe2.getVehicleType(), xe2.getCapacity(), xe2.getValue(), xe2.calculateTax());
                        System.out.printf("| %-15s | %-15s | %-8g | %-12.2f | %-6.2f |\n", xe3.getOwnerName(), xe3.getVehicleType(), xe3.getCapacity(), xe3.getValue(), xe3.calculateTax());
                        System.out.println("+----------------------------------------------------------------+");
                    }
                    break;

                case 3:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }

        } while (selection != 3);

        input.close();
    }


}

// 1. Abstract Base Class
abstract class VehicleC {
    String model;
    String company;

    // Constructor
    VehicleC(String model, String company) {
        this.model = model;
        this.company = company;
    }

    // Abstract method to be implemented by subclasses
    abstract void displayInfo();
}

// 2. Car inherits from Vehicle
class Car extends VehicleC {
    int doors;
    String fuelType;

    Car(String model, String company, int doors, String fuelType) {
        super(model, company); // Calling parent constructor
        this.doors = doors;
        this.fuelType = fuelType;
    }

    @Override
    void displayInfo() {
        System.out.println("Car: " + company + " " + model + " | Fuel: " + fuelType + " | Doors: " + doors);
    }
}

// 3. Electric inherits from Car
class Electric extends Car {
    int batteryCapacity;

    Electric(String model, String company, int doors, int batteryCapacity) {
        // Passing 'Electric' as the fuel type automatically
        super(model, company, doors, "Electric");
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    void displayInfo() {
        System.out.println("EV: " + company + " " + model + " | Battery: " + batteryCapacity + "kWh | Doors: " + doors);
    }
}

public class Vehicle {
    public static void main(String[] args) {
        // Dynamic Method Dispatch
        // The reference is of type Vehicle, but the object is Electric
        VehicleC myRide = new Electric("Model S", "Tesla", 4, 100);

        // At runtime, Java decides to call the Electric version of displayInfo()
        myRide.displayInfo();
        
        // Another example of Dispatch
        VehicleC myOldCar = new Car("Camry", "Toyota", 4, "Gasoline");
        myOldCar.displayInfo();
    }
}

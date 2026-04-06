interface Vehicle {
    String getType();
}

class Car implements Vehicle {
    @Override
    public String getType() {
        return "Car";
    }
}

class Bike implements Vehicle {
    @Override
    public String getType() {
        return "Bike";
    }
}

class Truck implements Vehicle {
    @Override
    public String getType() {
        return "Truck";
    }
}

abstract class VehicleFactory {
    abstract Vehicle createVehicle();
}

class CarFactory extends VehicleFactory {
    // Write your code here
    public Vehicle createVehicle() {
        Vehicle vehicle = new Car();
        return vehicle;
    }
}

class BikeFactory extends VehicleFactory {
    // Write your code here
    public Vehicle createVehicle() {
        Vehicle vehicle = new Bike();
        return vehicle;
    }
}

class TruckFactory extends VehicleFactory {
    // Write your code here
    public Vehicle createVehicle() {
        Vehicle vehicle = new Truck();
        return vehicle;
    }
}

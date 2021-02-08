package learnjava.cars;

import java.util.ArrayList;

public class VehicleCarrier extends Vehicle implements Drivable{
    ArrayList<Vehicle> vehiclesCarried = new ArrayList<>();

    public ArrayList<Vehicle> getVehiclesCarried() {
        return vehiclesCarried;
    }

    public void setVehiclesCarried(ArrayList<Vehicle> vehiclesCarried) {
        this.vehiclesCarried = vehiclesCarried;
    }

    public void CarryVehicle(Vehicle vehicleToCarry){
        vehiclesCarried.add(vehicleToCarry);
    }
    public void ParkAll() {
        for (Vehicle v : vehiclesCarried) {
            v.Park();  // Polymorphism
        }
    }
    
    public void DriveAll() {
    	for (Vehicle v : vehiclesCarried) {
    		if (v instanceof Drivable) {
    			Drivable d = (Drivable)v;
    			d.DriveTo("home");
    		}
    	}
    }

}
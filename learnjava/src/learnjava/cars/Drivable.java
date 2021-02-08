package learnjava.cars;

public interface Drivable {
	
	default void DriveTo(String destination) {
		System.out.println("Drivable DriveTO: " + destination);
	}
	
}
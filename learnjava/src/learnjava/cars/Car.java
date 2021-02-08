package learnjava.cars;

public class Car extends Vehicle implements Drivable, SecondDrivable{

    boolean hasSunroof;

    String headlightType;

    String tireType;

    public Car() {
        super();
    }
    public Car(String modelName) {
        super(modelName);
    }

    public void ShiftGear(int gear) {

    }

    public void DriveTo(String destination) {

        this.ShiftGear(2);
        this.isParked = false;
        System.out.println("car DriveTo");
        super.Move(destination);

    }

    private boolean parkingBrake = false;

    public void Park() {
        System.out.println("Parking the " + getModelName());
        this.parkingBrake = true;
        super.Park();
    }


}
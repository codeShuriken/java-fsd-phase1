package learnjava.cars;

public class Motorcycle extends Vehicle implements Drivable, SecondDrivable{


    private boolean kickstand = false;
    public void Park() {

        kickstand = true;
        System.out.println("Parking the " + getModelName());
        super.Park();
    }

    public void DriveTo(String destination) {
        kickstand = false;
        super.Move(destination);
        System.out.println("Motorcycle");
    }

    public Motorcycle() {
        super();

    }
    public Motorcycle(String name) {
        super(name);
    }
}
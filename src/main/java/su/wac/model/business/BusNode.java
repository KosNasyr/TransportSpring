package su.wac.model.business;

public class BusNode extends VehicleNode {
    private int capacity;

    public BusNode(){
    }

    public BusNode(double tankAverage, int capacity, String  registrationPlate, String driver){
        super (tankAverage, registrationPlate, driver);
        this.capacity = capacity;
    }

    public BusNode(int id, HierarchyType type, double tankAverage, int capacity, String  registrationPlate, String driver){
        super (id, type,tankAverage, registrationPlate, driver);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return ""+getId() +"|" + getTankAverage() +"|" + getCapacity() +"|"  + getDriver() +"|" + getRegistrationPlate();
    }
}
package su.wac.model.business;

public abstract class VehicleNode extends HierarchyObjectNode {

    private double tankAverage;
    private String driver;
    private String registrationPlate;

    public VehicleNode(){
    }

    public VehicleNode(double tankAverage, String driver, String  registrationPlate){
        this.tankAverage= tankAverage;
        this.driver = driver;
        this.registrationPlate = registrationPlate;
    }

    public VehicleNode(int id, HierarchyType type , double tankAverage, String driver, String  registrationPlate){
        super(id, type);
        this.tankAverage= tankAverage;
        this.driver = driver;
        this.registrationPlate = registrationPlate;
    }


    public double getTankAverage() {
        return tankAverage;
    }

    public void setTankAverage(double tankAverage) {
        this.tankAverage = tankAverage;
    }

    public String getRegistrationPlate() {
        return registrationPlate;
    }

    public void setRegistrationPlate(String registrationPlate) {
        this.registrationPlate = registrationPlate;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
package vehicle;

public class Bus extends VehicleImpl{

    private final double AIR_CONDITION = 1.4;
    protected Bus(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }


    public void driveEmpty(double km) {
        setFuelConsumption(getFuelConsumption() + AIR_CONDITION);
        drive(km);
    }

    @Override
    public String drive(double km) {
        setFuelConsumption(getFuelConsumption() - AIR_CONDITION);
        return super.drive(km);
    }
}

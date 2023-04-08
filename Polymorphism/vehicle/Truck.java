package vehicle;

public class Truck extends VehicleImpl{
    private final double AIR_CONDITION = 1.6;
//    private final double TANK_SIZE = 0.95;
    protected Truck(double fuelQuantity, double fuelConsumption,int tankCapacity) {
        super(fuelQuantity, fuelConsumption,tankCapacity);
        setFuelConsumption(getFuelConsumption() + AIR_CONDITION);
    }
    @Override
    public void refuel(double quantity) {
        super.refuel(quantity * getTankCapacity());
    }
}

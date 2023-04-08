package vehicle;

public class Car extends VehicleImpl {
    private final double AIR_CONDITION = 0.9;

    protected Car(double fuelQuantity, double fuelConsumption,int tankCapacity) {
        super(fuelQuantity, fuelConsumption,tankCapacity);
        setFuelConsumption(getFuelConsumption() + AIR_CONDITION);
    }

    @Override
    public void refuel(double quantity) {
        super.refuel(quantity * getTankCapacity());
    }
}


package vehicle;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle{
    private double fuelQuantity;
    private double fuelConsumption;

    private int tankCapacity;


    protected VehicleImpl(double fuelQuantity, double fuelConsumption,int tankCapacity) {
        setFuelQuantity(fuelQuantity);
        this.fuelConsumption = fuelConsumption;
        setTankCapacity(tankCapacity);
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(int tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    @Override
    public void refuel(double quantity) {
        if (quantity <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if(fuelQuantity + quantity > tankCapacity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += quantity;
    }

    @Override
    public String drive(double km) {
        double fuelNeeded = km * getFuelConsumption();
        if(fuelNeeded > getFuelQuantity()){
            return this.getClass().getSimpleName() + " needs refueling";
        }
        setFuelQuantity(getFuelQuantity() - fuelNeeded);
        DecimalFormat df = new DecimalFormat("##.##");
        return String.format("%s travelled %s km",this.getClass().getSimpleName(), df.format(km));
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }


    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), fuelQuantity);
    }
}

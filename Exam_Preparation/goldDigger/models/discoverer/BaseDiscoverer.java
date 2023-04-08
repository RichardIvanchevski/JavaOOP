package goldDigger.models.discoverer;

import goldDigger.models.museum.BaseMuseum;
import goldDigger.models.museum.Museum;

public abstract class BaseDiscoverer implements Discoverer{
    private String name;
    private double energy;

    private BaseMuseum baseMuseum;



    public BaseDiscoverer(String name, double energy) {
        setName(name);
        setEnergy(energy);
        this.baseMuseum = new BaseMuseum();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException("Discoverer name cannot be null or empty.");
        }
        this.name = name;
    }

    public void setEnergy(double energy) {
        if (energy < 0){
            throw new IllegalArgumentException("Cannot create Discoverer with negative energy.");
        }

        this.energy = energy;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getEnergy() {
        return energy;
    }

    @Override
    public boolean canDig() {
        if (energy <= 0){
            return false;
        }
        return true;
    }

    @Override
    public Museum getMuseum() {
        return this.baseMuseum;
    }

    @Override
    public abstract void dig();
}

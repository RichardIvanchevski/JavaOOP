package carShop;

public abstract class CarImpl implements Car {

    private String model;
    private String color;
    private int hp;
    private String countryProducer;


    public CarImpl(String model, String color, int hp, String countryProducer) {
        this.model = model;
        this.color = color;
        this.hp = hp;
        this.countryProducer = countryProducer;
    }

    @Override
    public int getTires() {
        return 4;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public int getHorsePower() {
        return this.hp;
    }

    @Override
    public String countryProduced() {
        return this.countryProducer;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires",model,countryProducer,Car.TIRES);
    }
}

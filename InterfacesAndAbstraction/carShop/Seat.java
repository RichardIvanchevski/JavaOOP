package carShop;

public class Seat extends CarImpl implements Sellable{
    private double price;
    public Seat(String model, String color, int hp, String countryProducer,double price) {
        super(model, color, hp, countryProducer);
        this.price = price;
    }
    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%n%s sells for %f",getModel(),price);
    }
}

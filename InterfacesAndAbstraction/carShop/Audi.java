package carShop;

public class Audi extends CarImpl implements Rentable{
    private int minRentDay;
    private double pricePerDay;

    public Audi(String model, String color, int hp, String countryProducer,int minRentDay,double pricePerDay) {
        super(model, color, hp, countryProducer);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public int getMinRentDay() {
        return minRentDay;
    }

    @Override
    public double getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append(System.lineSeparator())
                .append(String.format("Minimum rental period of %d days.Price per day %f",minRentDay,pricePerDay));
        return sb.toString();
    }
}

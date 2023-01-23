package pizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        //•	Meat – 1.2;
        //•	Veggies – 0.8;
        //•	Cheese – 1.1;
        //•	Sauce – 0.9;
        switch (toppingType){
            case "Meat":
            case "Veggies":
            case "Cheese":
            case "Sauce":
                this.toppingType = toppingType;
                break;
            default:
                String errorMsg = String.format("Cannot place %s on top of your pizza.",toppingType);
                throw new IllegalArgumentException(errorMsg);
        }

    }

    private void setWeight(double weight) {
        if (weight < 0 || weight > 50){
            throw new IllegalArgumentException("Weight should be in the range [1..50].");
        }
        this.weight = weight;
    }
    public double calculateCalories(){
        return 2 * weight * getModifier();
    }


    private double getModifier(){
        switch (toppingType) {
            case "Meat":
                return 1.2;
            case "Veggies":
                return 0.8;
            case "Cheese":
                return 1.1;
            case "Sauce":
                return 0.9;
            default:
                return 0;
        }
    }
}

package pizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
       //Pizza name should be between 1 and 15 symbols.
        if (name.trim().isEmpty() || name.length() > 15 || name.length() < 1){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings(int countOfToppings) {
        if(countOfToppings < 0 || countOfToppings > 10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>();
    }

    public void addTopping(Topping topping){
        toppings.add(topping);
    }
    public double getOverallCalories(){
        return dough.calculateCalories() + toppings.stream().mapToDouble(Topping::calculateCalories).sum();
    }
}
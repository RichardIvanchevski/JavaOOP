package wildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime{
   private String breed;
    public Cat(String animalName, String animalType, double animalWeight, int foodEaten, String livingRegion,String breed) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    void eat(Food food) {
        setFoodEaten(food.getQuantity());
    }
    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.##");
        return this.getClass().getSimpleName() + "[" + this.getAnimalName() + ", " + this.getBreed() + ", " +  df.format(this.getAnimalWeight())
                + ", " + this.getLivingRegion() + ", " + (this.getFoodEaten()) + "]";
    }
}


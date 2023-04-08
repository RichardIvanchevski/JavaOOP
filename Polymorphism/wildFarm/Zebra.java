package wildFarm;

public class Zebra extends Mammal{
    public Zebra(String animalName, String animalType, double animalWeight, int foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("Zs");
    }

    @Override
    void eat(Food food) {
        if (!(food instanceof Vegetable)){
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }else{
            setFoodEaten(food.getQuantity());
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

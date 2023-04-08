package wildFarm;

public class Tiger extends Felime{
    public Tiger(String animalName, String animalType, double animalWeight, int foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
    }

    @Override
    void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    void eat(Food food) {
        if (!(food instanceof Meat)){
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }else {
            setFoodEaten(food.getQuantity());
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

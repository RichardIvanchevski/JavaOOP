package wildFarm;

public abstract class Felime extends Mammal {
    protected Felime(String animalName, String animalType, double animalWeight, int foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
    }

    @Override
    abstract void makeSound();

    @Override
    abstract void eat(Food food);
}

package wildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal{
    private String livingRegion;
    protected Mammal(String animalName, String animalType, double animalWeight, int foodEaten,String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten);
        this.livingRegion = livingRegion;
    }

    protected String getLivingRegion() {
        return livingRegion;
    }

    protected void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    abstract void makeSound();

    @Override
    abstract void eat(Food food);

    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.##");
        return this.getClass().getSimpleName() + "[" + this.getAnimalName() +  ", " +  df.format(this.getAnimalWeight())
                + ", " + getLivingRegion()+ ", " + (this.getFoodEaten()) + "]";
    }
}

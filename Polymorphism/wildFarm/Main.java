package wildFarm;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            createAnimal(animals, input);

            input = scanner.nextLine();
            String[] foodData = input.split("\\s+");
            String foodType = foodData[0];
            int quantity = Integer.parseInt(foodData[1]);

            Food food = null;
            switch (foodType) {
                case "Vegetable":
                    food = new Vegetable(quantity);
                    break;
                case "Meat":
                    food = new Meat(quantity);
                    break;
            }

            eatFoodAndProduceSound(animals, quantity, food);
            input = scanner.nextLine();
        }
        animals.forEach(System.out::println);
    }

    private static void eatFoodAndProduceSound(List<Animal> animals, int quantity, Food food) {
        Animal currentAnimal = animals.get(animals.size() - 1);
        currentAnimal.makeSound();
        try {
            currentAnimal.eat(food);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void createAnimal(List<Animal> animals, String input) {
        String[] animalData = input.split("\\s+");
        String animalType = animalData[0];
        String animalName = animalData[1];
        double animalWeight = Double.parseDouble(animalData[2]);
        String animalLivingRegion = animalData[3];

        Animal animal = null;
        switch (animalType) {
            case "Mouse":
                animal = new Mouse(animalName, animalType, animalWeight, 0, animalLivingRegion);
                break;
            case "Zebra":
                animal = new Zebra(animalName, animalType, animalWeight, 0, animalLivingRegion);
                break;
            case "Cat":
                String catBreed = animalData[4];
                animal = new Cat(animalName, animalType, animalWeight, 0, animalLivingRegion, catBreed);
                break;
            case "Tiger":
                animal = new Tiger(animalName, animalType, animalWeight, 0, animalLivingRegion);
                break;
        }
        animals.add(animal);
    }
}
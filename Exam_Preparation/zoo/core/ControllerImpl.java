package zoo.core;

import zoo.common.ConstantMessages;
import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepository;
import zoo.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {
    private FoodRepository foodRepository;
    private List<Area> areaList;


    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areaList = new ArrayList<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        Area area;
        switch (areaType) {
            case "LandArea":
                area = new LandArea(areaName);
                break;
            case "WaterArea":
                area = new WaterArea(areaName);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_AREA_TYPE);
        }
        areaList.add(area);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {
        Food food;
        switch (foodType) {
            case "Meat":
                food = new Meat();
                break;
            case "Vegetable":
                food = new Vegetable();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_FOOD_TYPE);

        }
        foodRepository.add(food);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Area area = null;
        for (Area area1 : areaList) {
            if (area1.getName().equals(areaName)) {
                area = area1;
            }
        }
        Food food = foodRepository.findByType(foodType);
        if (food == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_FOOD_FOUND, foodType));
        }

        foodRepository.remove(food);
        if (area != null) {
            area.addFood(food);
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Animal animal;
        Area area = null;
        for (Area currentArea : areaList) {
            if (currentArea.getName().equals(areaName)) {
                area = currentArea;
            }
        }
        switch (animalType) {
            case "AquaticAnimal":
                animal = new AquaticAnimal(animalName, kind, price);
                break;
            case "TerrestrialAnimal":
                animal = new TerrestrialAnimal(animalName, kind, price);
                break;
            default:
                throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_ANIMAL_TYPE));
        }

        if (area != null) {
            if (area.getClass().getSimpleName().equals("WaterArea") && animalType.equals("AquaticAnimal")) {
                area.addAnimal(animal);
            } else if (area.getClass().getSimpleName().equals("LandArea") && animalType.equals("TerrestrialAnimal")) {
                area.addAnimal(animal);
            } else {
                return ConstantMessages.AREA_NOT_SUITABLE;
            }
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);


    }

    @Override
    public String feedAnimal(String areaName) {
        int count = 0;
        Area area = null;
        for (Area currentArea : areaList) {
            if (currentArea.getName().equals(areaName)) {
                area = currentArea;
            }
        }
        assert area != null;
        for (Animal animal : area.getAnimals()) {
            animal.eat();
            count++;
        }
        return String.format("Animals fed: %d", count);
    }

    @Override
    public String calculateKg(String areaName) {
        Area area = null;
        double areaKg = 0;
        for (Area area1 : areaList) {
            if (area1.getName().equals(areaName)) {
                area = area1;
            }
        }
        assert area != null;
        for (Animal animal : area.getAnimals()) {
            areaKg += animal.getKg();
        }
        return String.format("The kilograms of Area %s is %.2f.", area.getName(), areaKg);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Area area : areaList) {
            sb.append(area.getInfo());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
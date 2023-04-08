package vehicle;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();

        String[] carData = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carData[1]), Double.parseDouble(carData[2]),Integer.parseInt(carData[3]));

        String[] truckData = scanner.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckData[1]), Double.parseDouble(truckData[2]),Integer.parseInt(truckData[3]));

        String[] busData = scanner.nextLine().split("\\s+");
        Bus bus = new Bus(Double.parseDouble(busData[1]), Double.parseDouble(busData[2]),Integer.parseInt(busData[3]));
        vehicleMap.put("Car", car);
        vehicleMap.put("Truck", truck);
        vehicleMap.put("Bus",bus);

        int nOfCommands = Integer.parseInt(scanner.nextLine());

        while (nOfCommands-- > 0) {
            String[] commandParts = scanner.nextLine().split("\\s+");
            String command = commandParts[0];
            String vehicleType = commandParts[1];

            switch (command) {
                case "Drive":
                    driveTheVehicle(vehicleMap.get(vehicleType), commandParts);
                    break;
                case "Refuel":
                   try{
                       double quantity = Double.parseDouble(commandParts[2]);
                       vehicleMap.get(vehicleType).refuel(quantity);
                   }catch (Exception ex){
                       System.out.println(ex.getMessage());
                   }
                   break;
                case "DriveEmpty":
                   double distanceKm = Double.parseDouble(commandParts[2]);
                   try{
                      bus.driveEmpty(distanceKm);
                   }catch (Exception ex){
                       System.out.println(ex.getMessage());
                   }
                    break;

            }
        }
        vehicleMap.values().forEach(System.out::println);
    }

    private static void driveTheVehicle(Vehicle vehicle, String[] commandParts) {
        double km = Double.parseDouble(commandParts[2]);
        try {
            System.out.println(vehicle.drive(km));
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}


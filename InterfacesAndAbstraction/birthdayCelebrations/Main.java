package birthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Birthable> birthables = new ArrayList<>();
        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] commandParts = input.split("\\s+");
           Birthable object = createObject(commandParts);
            birthables.add(object);

            input = scanner.nextLine();
        }

        String date = scanner.nextLine();

        findObjectByBirth(birthables, date);
    }

    private static void findObjectByBirth(List<Birthable> birthables, String date) {
        for (Birthable birthable : birthables) {
            if (birthable != null && birthable.getBirthDate().endsWith(date)){
                System.out.println(birthable.getBirthDate());
            }
        }
    }

    private static Birthable createObject(String[] commandParts) {
        String command = commandParts[0];
        String name = commandParts[1];
        switch (command){
            case "Citizen":
                return new Citizen(name,Integer.parseInt(commandParts[2]),commandParts[3],commandParts[4]);
            case "Pet":
                return new Pet(name,commandParts[2]);
        }
        return null;
    }
}

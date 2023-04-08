package borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Identifiable> identifiables = new ArrayList<>();
        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] data = input.split("\\s+");
            String name = data[0];
            String id;

            if (data.length == 3) {
                int age = Integer.parseInt(data[1]);
                id = data[2];
                Identifiable citizen = new Citizen(name, age, id);
                identifiables.add(citizen);
            } else {
                id = data[1];
                Identifiable robot = new Robot(id, name);
                identifiables.add(robot);
            }

            input = scanner.nextLine();
        }
        String search = scanner.nextLine();
        for (Identifiable identifiable : identifiables) {
            if (identifiable.getId().endsWith(search)){
                System.out.println(identifiable.getId());
            }
        }
    }
}

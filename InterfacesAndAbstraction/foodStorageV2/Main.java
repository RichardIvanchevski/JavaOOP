package foodStorageV2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        List<Person> buyers = new ArrayList<>();

        while (numberOfPeople-- > 0){
         String[] input = scanner.nextLine().split("\\s+");
         String name = input[0];
         int age = Integer.parseInt(input[1]);
         Person buyer;
         if (input.length > 3){
             String id = input[2];
             String birth = input[3];
             buyer = new Citizen(name,age,id,birth);

         }else {
             String group = input[2];
             buyer = new Rebel(name,age,group);
         }
         buyers.add(buyer);
        }

        String name = scanner.nextLine();

        while (!"End".equals(name)){
            String finalName = name;
            buyers.stream()
                    .filter(human -> human.getName().equals(finalName)).forEach(Buyer::buyFood);

            name = scanner.nextLine();
        }

        int countOfFood = buyers.stream()
                .mapToInt(Buyer::getFood)
                .sum();

        System.out.println(countOfFood);
    }
}

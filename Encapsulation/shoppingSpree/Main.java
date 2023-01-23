package shoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Peter=11;George=4
        //Bread=10;Milk=2
        Map<String,Person> personMap = new LinkedHashMap<>();
        Map<String,Product> productMap = new LinkedHashMap<>();
        String[] personData = scanner.nextLine().split(";");
        String[] productData = scanner.nextLine().split(";");

        generatePerson(personMap, personData);

        generateProduct(productMap, productData);

        String command = scanner.nextLine();
        while(!"END".equals(command)){
            String[] commandParts = command.split("\\s+");
            String personName = commandParts[0];
            String productName = commandParts[1];

            Person person = personMap.get(personName);
            Product product = productMap.get(productName);
            try{
                person.buyProduct(product);
                System.out.printf("%s bought %s%n",person.getName(),productName);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
            command = scanner.nextLine();
        }
        personMap.values().forEach(System.out::println);
    }

    private static void generateProduct(Map<String, Product> productMap, String[] productData) {
        for (String productDatum : productData) {
            String[] productDataParts = productDatum.split("=");
            try {
                Product product = new Product(productDataParts[0], Double.parseDouble(productDataParts[1]));
                productMap.put(productDataParts[0],product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void generatePerson(Map<String, Person> personMap, String[] personData) {
        for (String personDatum : personData) {
            String[] personDataParts = personDatum.split("=");
            try {
                 Person person = new Person(personDataParts[0], Double.parseDouble(personDataParts[1]));
                personMap.put(personDataParts[0],person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

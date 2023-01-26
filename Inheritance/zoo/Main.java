package zoo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Animal animal = new Lizard(scanner.nextLine());

        System.out.print(animal.getName());

    }
}

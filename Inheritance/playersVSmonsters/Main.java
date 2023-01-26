package playersVSmonsters;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Elf elf = new Elf(scanner.nextLine(),Integer.parseInt(scanner.nextLine()));

        System.out.println(elf.getUsername());
        System.out.println(elf.getLevel());

        System.out.println(elf.toString());
    }
}

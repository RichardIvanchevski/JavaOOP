package box;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double length = Double.parseDouble(scanner.nextLine());
        double weight = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        Box box = null;
        try {
             box = new Box(length,weight,height);
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
        //Surface Area - 30.20
        //Lateral Surface Area - 27.60
        //Volume - 7.80
        if (box != null) {
            System.out.printf("Surface Area - %.2f%n", box.calculateSurfaceArea());
            System.out.printf("Lateral Surface Area - %.2f%n", box.calculateLateralSurfaceArea());
            System.out.printf("Volume - %.2f%n", box.calculateVolume());
        }
    }
}

package trafficLight;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] signals = scanner.nextLine().split(" ");
        int iterations = Integer.parseInt(scanner.nextLine());


        List<TrafficLight> trafficLights = Arrays.stream(signals)
                .map(Color::valueOf)
                .map(TrafficLight::new).toList();

        for (int i = 0; i < iterations; i++) {
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.setColor();
                System.out.print(trafficLight.getColor() + " ");
            }
            System.out.println();
        }
    }
}
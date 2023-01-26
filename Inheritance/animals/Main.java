package animals;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       List<Animal> zoo = new ArrayList<>();
        String animal = scanner.nextLine();

        while (!"Beast!".equals(animal)){
            String[] data = scanner.nextLine().split("\\s+");
            try{
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                switch (animal){
                    case "Dog":
                        String gender = data[2];
                        Dog dog = new Dog(name, age, gender);
                        zoo.add(dog);
                        break;
                    case "Cat":
                        gender = data[2];
                        Cat cat = new Cat(name, age, gender);
                        zoo.add(cat);
                        break;
                    case "Frog":
                        gender = data[2];
                        Frog frog = new Frog(name,age,gender);
                        zoo.add(frog);
                        break;
                    case "Kittens":
                        Kitten kitten = new Kitten(name,age);
                        zoo.add(kitten);
                        break;
                    case "Tomcat":
                        Tomcat tomcat = new Tomcat(name,age);
                        zoo.add(tomcat);
                        break;
                }

            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            animal = scanner.nextLine();
        }

       zoo.forEach(System.out::println);



    }
}

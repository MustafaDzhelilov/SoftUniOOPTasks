package animal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String typeOfAnimal = sc.nextLine();

            while (!typeOfAnimal.equals("Beast!")) {
                String[] input = sc.nextLine().split("\\s+");
                String name = input[0];
                int age = Integer.parseInt(input[1]);
                String gender = input[2];

                if (!invalidInput(gender, age)) {

                    switch (typeOfAnimal) {

                        case "Frog":
                            Frog frog = new Frog(name, age, gender);
                            System.out.println(frog);
                            break;
                        case "Dog":
                            Dog dog = new Dog(name, age, gender);
                            System.out.println(dog);
                            break;
                        case "Cat":
                            Cat cat = new Cat(name, age, gender);
                            System.out.println(cat);
                            break;
                        case "Kitten":
                            Kitten kitten = new Kitten(name, age);
                            System.out.println(kitten);
                            break;
                        case "Tomcat":
                            Tomcat tomcat = new Tomcat(name, age);
                            System.out.println(tomcat);
                            break;
                    }
                }
                typeOfAnimal = sc.nextLine();

            }  // while

        }

    private static boolean invalidInput( String gender, int age) {
        boolean inputIsInvalid = false;
        try {
            if (age < 0) {
                inputIsInvalid = true;
                throw new IllegalArgumentException("Invalid input!");
            }
            if ((!gender.equals("Male")
                    && !gender.equals("Female"))) {
                inputIsInvalid = true;
                throw new IllegalArgumentException("Invalid input!");

            }
        }
        catch(IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println("Invalid input!");

        }
        return inputIsInvalid;
    }

    }



package Abstraction_Exercises.TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] colors = sc.nextLine().split("\\s+");
        int changeCounter = Integer.parseInt(sc.nextLine());
        List<Lights> lightList = new ArrayList<>();

        for (String color : colors) {
            Lights lights = new Lights(Color.valueOf(color));
            lightList.add(lights);
        }

        for (int i = 0; i < changeCounter; i++) {
            lightList.forEach(lights ->{
                    lights.changeColor();
            System.out.print(lights.getColor() + " ");
            });
            System.out.println();
        }


    }
}

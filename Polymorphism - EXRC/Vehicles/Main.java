import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String [] input = sc.nextLine().split("\\s+");

        Map<String, Vehicles> vehiclesMap = new LinkedHashMap<>();

        vehiclesMap.put("Car", new Car(Double.parseDouble(input[1]),Double.parseDouble(input[2])));
        input = sc.nextLine().split("\\s+");
        vehiclesMap.put("Truck", new Truck(Double.parseDouble(input[1]),Double.parseDouble(input[2])));

        int countCommands = Integer.parseInt(sc.nextLine());

        while (countCommands-- > 0){
            String command = sc.nextLine();
            String[] splittedCommand = command.split("\\s+");

            double argument = Double.parseDouble(splittedCommand[2]);

            if(command.contains("Drive")){
                System.out.println(vehiclesMap.get(splittedCommand[1]).drive(argument));
            }else{
                vehiclesMap.get(splittedCommand[1]).refuel(argument);
            }

        }

        for (Vehicles vehicles : vehiclesMap.values()) {
            System.out.println(vehicles.toString());
        }

    }
}

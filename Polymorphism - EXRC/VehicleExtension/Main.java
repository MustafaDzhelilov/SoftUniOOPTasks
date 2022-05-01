import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Vehicles> vehiclesMap = new LinkedHashMap<>();

        vehiclesMap.put("Car", createVehicle(sc.nextLine().split("\\s+")));
        vehiclesMap.put("Truck", createVehicle(sc.nextLine().split("\\s+")));

        Bus bus = createBus(sc.nextLine().split("\\s+"));

        vehiclesMap.put("Bus", bus);

        int countCommands = Integer.parseInt(sc.nextLine());

        while (countCommands-- > 0) {
            String command = sc.nextLine();
            String[] splittedCommand = command.split("\\s+");

            double argument = Double.parseDouble(splittedCommand[2]);

            if(command.contains("Drive") && command.contains("Bus")){
                System.out.println(bus.driveWithPassengers(argument));
            } else if (command.contains("Drive")) {
                System.out.println(vehiclesMap.get(splittedCommand[1]).drive(argument));
            } else {
                try {
                    vehiclesMap.get(splittedCommand[1]).refuel(argument);
                } catch (IllegalArgumentException exception) {
                    System.out.println(exception.getMessage());
                }
            }

        }

        for (Vehicles vehicles : vehiclesMap.values()) {
            System.out.println(vehicles.toString());
        }

    }

    private static Vehicles createVehicle(String[] tokens) {
        switch (tokens[0]){
            case "Car":
                return new Car(Double.parseDouble(tokens[1]),
                        Double.parseDouble(tokens[2]),
                        Double.parseDouble(tokens[3]));
            case "Truck":
                return new Truck(Double.parseDouble(tokens[1]),
                        Double.parseDouble(tokens[2]),
                        Double.parseDouble(tokens[3]));
                
            case "Bus":
                return createBus(tokens);
            default:
                throw new IllegalStateException("Unknown Vehicle type for " + tokens[0]);

        }
    }

    private static Bus createBus(String[] tokens) {
        return new Bus(Double.parseDouble(tokens[1]),
                Double.parseDouble(tokens[2]),
                Double.parseDouble(tokens[3]));
    }
}

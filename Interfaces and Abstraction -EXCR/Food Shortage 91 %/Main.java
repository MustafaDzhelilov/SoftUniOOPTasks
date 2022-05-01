import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Map<String, Buyer> buyersByName = new HashMap<>();

        while (n-- > 0){
            Buyer buyer =  createBuyer(sc.nextLine());
            buyersByName.put(buyer.getName(), buyer);
        }

        String line = sc.nextLine();

        while (!line.equals("End")){

            Buyer buyer = buyersByName.get(line);

            if(buyer != null){
                buyer.buyFood();
            }

            line = sc.nextLine();
        }

        System.out.println(buyersByName.values().stream()
                .mapToInt(Buyer::getFood)
                .sum());

    }
    private static Buyer createBuyer(String input){
        String [] tokens  = input.split("\\s+");
        if(tokens.length == 4){
            return new Citizen(tokens[0],Integer.parseInt(tokens[1]), tokens[2],tokens[3] );
        }
            return new Rebel(tokens[0],Integer.parseInt(tokens[1]), tokens[2] );
    }

}

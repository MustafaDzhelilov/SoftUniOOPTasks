import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        List<Identifiable> identifiables = new ArrayList<>();



        while (!input.equals("End")){
            String [] tokens = input.split("\\s+");
            Identifiable identifiable = null;
            if(tokens.length == 2){
               identifiable = new Robot(tokens[0],tokens[1]);
            }else if(tokens.length == 3){
                identifiable = new Citizen(tokens[0],Integer.parseInt(tokens[1]), tokens[2] );
            }
            identifiables.add(identifiable);
            input = sc.nextLine();
        }

        String singleNumber = sc.nextLine();

        for (Identifiable identifiable : identifiables) {
            if(identifiable.getId().endsWith(singleNumber)){
                System.out.println(identifiable.getId());
            }
        }
    }
}

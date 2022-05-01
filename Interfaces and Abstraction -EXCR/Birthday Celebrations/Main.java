import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

       String input = sc.nextLine();

        List<Citizen> citizens = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();

       while (!input.equals("End")){
           String[] tokens = input.split("\\s+");

           if(tokens[0].equals("Citizen")){
               Citizen citizen = new Citizen(tokens[1],Integer.parseInt(tokens[2]),tokens[3],tokens[4] );
               citizens.add(citizen);
           }else if(tokens[0].equals("Pet")){
               Pet pet =  new Pet(tokens[1],tokens[2] );
               pets.add(pet);
           }else if(tokens[0].equals("Robot")){
               Identifiable identifiable = new Robot(tokens[1],tokens[2] );
           }

           input= sc.nextLine();
       }


       String date = sc.nextLine();

       boolean isTrue = false;

        for (Citizen citizen : citizens) {
            if(citizen.getBirthDate().endsWith(date)){
                System.out.println(citizen.getBirthDate());
            }else{
                isTrue = true;
            }
        }
        for (Pet pet : pets) {
            if(pet.getBirthDate().endsWith(date)){
                System.out.println(pet.getBirthDate());
            }else{
                isTrue = true;
            }
        }

        if(isTrue = true){
            System.out.println("<no output>");
        }

    }
}

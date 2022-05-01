import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> numbers = Arrays.asList(sc.nextLine().split("\\s+"));
        List<String> sites = Arrays.asList(sc.nextLine().split("\\s+"));

        Smartphone smartphone = new Smartphone(numbers,sites);

        System.out.print(smartphone.call());
        System.out.print(smartphone.browse());






    }
}

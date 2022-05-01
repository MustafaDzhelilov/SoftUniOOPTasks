package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        Scanner sc = new Scanner(System.in);

        Class clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();
        List<Method> methods = Arrays.asList(clazz.getDeclaredMethods());
        Field innerValue = clazz.getDeclaredField("innerValue");
        innerValue.setAccessible(true);
        String input = sc.nextLine();

        while (!input.equals("END")){
            String[] tokens = input.split("_");
            String command = tokens[0];
            int number = Integer.parseInt(tokens[1]);

            Method currentMethod = getCurrentMethod(methods, command);
            // with stream
                    //methods.stream()
                   // .filter(method1 -> method1.getName()
                   // .equals(command))
                   // .findFirst()
                   // .orElse(null);
            currentMethod.setAccessible(true);
            currentMethod.invoke(blackBoxInt, number);
            System.out.println(innerValue.get(blackBoxInt));

            input = sc.nextLine();
        }

    }
    private static Method getCurrentMethod(List<Method> methods, String command) {
        for (Method method : methods) {
            if(method.getName().equals(command)){
                return  method;
            }
        }
        return null;
    }
}

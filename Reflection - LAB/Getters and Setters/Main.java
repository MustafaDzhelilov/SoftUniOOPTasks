import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class reflection = Reflection.class;


        Method[] declaredMethods = reflection.getDeclaredMethods();

        Arrays.stream(declaredMethods).filter(n -> n.getName().contains("set") || n.getName().contains("get"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(Main::printMethod);

    }

    public  static String formatType(Class<?> type){
        return type == int.class ? "class " + type : type.toString();
    }

    public static void printMethod(Method method){
        String out = method.getName().contains("set")
            ? String.format("%s and will set field of %s",
                method.getName(), formatType(method.getParameterTypes()[0]))
           : String.format("%s will return %s",method.getName(), formatType(method.getReturnType()));
        System.out.println(out);
    }
}

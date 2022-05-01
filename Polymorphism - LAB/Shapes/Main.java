import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Shape shape = new Circle(3D);
        Shape shape2 = new Rectangle(13.00, 2.00);

        List<Shape> shapes = new ArrayList<>();

        shapes.add(shape);
        shapes.add(shape2);

        for (Shape s : shapes) {
            System.out.println(s.getArea());
            System.out.println(s.getPerimeter());
        }

    }
}

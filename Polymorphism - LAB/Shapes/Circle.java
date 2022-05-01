public class Circle extends Shape{

    private Double radius;

    public Circle(Double radius) {
        this.setRadius(radius);
        calculatePerimeter();
        calculateArea();
    }

    @Override
    protected void calculatePerimeter() {
        Double result =  2 * Math.PI * radius;
        setPerimeter(result);
    }

    @Override
    protected void calculateArea() {
        Double result =  Math.PI * radius * radius;
        setArea(result);
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return radius;
    }
}

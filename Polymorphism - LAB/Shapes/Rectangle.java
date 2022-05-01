public class Rectangle extends Shape{

    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
       this.setHeight(height);
       this.setWidth(width);
       this.calculatePerimeter();
       this.calculateArea();

    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    @Override
    public void calculatePerimeter() {
       Double result = this.height * 2 + this.width * 2;
       setPerimeter(result);
    }

    @Override
     public  void calculateArea() {
        Double result =  this.height * this.width;
        setArea(result);
    }
}

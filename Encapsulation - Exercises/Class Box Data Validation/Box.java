package Encapsulation_Exerc;

public class Box {

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height){
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if(length <= 0){
            System.out.println("Length cannot be zero or negative.");
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if(width <= 0){
            System.out.println("Width cannot be zero or negative.");
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if(height <= 0){
            System.out.println("Height cannot be zero or negative.");
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public double calculateSurfaceArea(){
        return 2 * (length * width) + 2 * (length * height) + 2 * (width * height);
    }
    public double calculateLateralSurfaceArea(){
        return 2 *(length * height) + 2 * (width * height);
    }
    public double calculateVolume(){
        return length * width * height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }


      @Override
    public String toString() {
        return String.format("Surface Area - %.2f%nLateral Surface Area - %.2f%nVolume - %.2f%n"
          , calculateSurfaceArea(), calculateLateralSurfaceArea(), calculateVolume());
  }
}

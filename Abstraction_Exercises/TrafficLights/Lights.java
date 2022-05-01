package Abstraction_Exercises.TrafficLights;

public class Lights {
    private Color color;

    //конструктор
    public Lights(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    // метод за замяна на цветове

    public  void changeColor(){
        switch (this.color){
            case RED:
                this.color = Color.GREEN;
                break;
            case YELLOW:
                this.color = Color.RED;
                break;
            case GREEN:
                this.color = Color.YELLOW;
                break;
        }
    }
}

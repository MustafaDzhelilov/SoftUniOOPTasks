import java.text.DecimalFormat;

public  class Vehicles {

    private double fuel;
    private double consumption;
    private double tankCapacity;

    protected Vehicles(double fuel, double consumption, double tankCapacity) {
        this.tankCapacity = tankCapacity;
        this.setFuel(fuel);
        this.consumption = consumption;

    }
    protected void addConsumption(double additionalConsumption){
        this.consumption += additionalConsumption;
    }

    protected void subtractConsumption( double subConsumption){
        this.consumption -= subConsumption;
    }

    public String drive(double distance){
        double fuelNeeded = distance * this.consumption;
        if(fuelNeeded > this.fuel){
            return this.getClass().getSimpleName() + " needs refueling";
        }
        this.setFuel(this.fuel - fuelNeeded);

        DecimalFormat formatter = new DecimalFormat("##.##");
        return String.format("%s travelled %s km"
                ,this.getClass().getSimpleName()
                ,formatter.format(distance));
    }

    public void refuel(double liters){
        validateNonZero(liters);
        validateNonMaxCapacity(liters);
       this.setFuel(this.fuel + liters);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(), this.fuel);
    }

    public void setFuel(double fuel) {
        validateNonZero(fuel);
        validateNonMaxCapacity(fuel);
        this.fuel = fuel;
    }

    private void  validateNonZero(double fuel){
        if(fuel <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
    }

    private void validateNonMaxCapacity(double additionalfuel){
         if(additionalfuel > this.tankCapacity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
    }

}

public class Ferrari implements Car{

    private String driverName;
    private String model;
    private String brakes;
    private String gas;

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    public String getDriverName() {
        return driverName;
    }

    public String getModel() {
        return model = "488-Spider";
    }
}

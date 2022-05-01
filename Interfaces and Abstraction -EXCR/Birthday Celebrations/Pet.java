public class Pet implements Birthable,Identifiable{

    private String name;
    private String birthDate;

    public Pet(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return null;
    }
}

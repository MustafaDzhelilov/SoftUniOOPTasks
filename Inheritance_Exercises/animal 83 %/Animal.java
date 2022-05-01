package animal;

public class Animal {

    private String name;
    private int age;
    private String gender;


    public Animal(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    protected String produceSound(){
        return "";
    }

    @Override
    public String toString() {
        return String.format("%s%n%s %d %s%n%s",
                this.getClass().getSimpleName(),
                getName(),
                getAge(),
                getGender(),
                this.produceSound());
    }

}

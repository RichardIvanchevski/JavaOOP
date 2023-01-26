package animals;

public class Tomcat extends Cat{

    public static final String TOM_GENDER = "Male";
    public Tomcat(String name, int age) {
        super(name, age, TOM_GENDER);
    }

    @Override
    public String produceSound() {
        return "MEOW";
    }
}

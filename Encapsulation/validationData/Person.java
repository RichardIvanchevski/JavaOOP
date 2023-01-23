package validationData;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age,double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
       checkLength(firstName,"First");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        checkLength(lastName,"Last");
       this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0){
            throw new IllegalArgumentException("Age must not be zero or negative");
        }
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 460.0){
            throw new IllegalArgumentException("Salary can't be less than 460 leva");
        }
        this.salary = salary;
    }
    public void increaseSalary(double bonus){
        double bonusAmount = (age <= 30) ? (this.getSalary() * bonus / 200) : (this.getSalary() * bonus / 100);
        double newSalary = this.getSalary() + bonusAmount;
        setSalary(newSalary);

    }
    private void checkLength (String name , String prefix){
        if (name.length() <= 3){
            throw new IllegalArgumentException(prefix + " name cannot be less than 3 symbols");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %.2f leva",firstName,lastName,salary);
    }
}

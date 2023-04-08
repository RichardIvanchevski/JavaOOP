package militaryEliteV2.Classes;

public class PrivateImpl extends Soldier{

    private double salary;

    public PrivateImpl(int id, String firstName, String lastName,double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format(" Salary: %.2f", salary);
    }
}

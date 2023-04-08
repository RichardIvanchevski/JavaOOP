package militaryEliteV2.Classes;

import militaryEliteV2.enums.Corps;

public abstract class SpecialisedSoldierImpl extends Soldier {

    private double salary;

    private Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName,double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Corps getCorps() {
        return corps;
    }

    public void setCorps(Corps corps) {
        this.corps = corps;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append(String.format(" Salary: %.2f",salary))
                .append(System.lineSeparator())
                .append(String.format("Corps: %s",corps));
        return sb.toString();
    }
}

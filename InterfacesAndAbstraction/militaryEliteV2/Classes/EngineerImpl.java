package militaryEliteV2.Classes;

import java.util.*;

public class EngineerImpl extends SpecialisedSoldierImpl{

    private List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.repairs = new ArrayList<>();
    }

    public void addRepair(Repair repair){
        repairs.add(repair);
    }

    public Collection<Repair> getRepairs(){
        return repairs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append(System.lineSeparator())
                .append("Repairs:");

        for (Repair repair : repairs) {
            sb.append(System.lineSeparator())
                    .append(repair.toString());
        }
        return sb.toString();
    }
}

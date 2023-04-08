package militaryEliteV2.Classes;

public class Repair {

    private String partName;
    private int hourWorked;

    public Repair(String partName, int hourWorked) {
        this.partName = partName;
        this.hourWorked = hourWorked;
    }


    @Override
    public String toString() {
        return String.format("  Part Name: %s Hours Worked: %d",partName,hourWorked);
    }
}

package militaryEliteV2.Classes;

import java.util.*;
import java.util.stream.Collectors;

public class LieutenantGeneralImpl extends PrivateImpl{

    private List<PrivateImpl> soldiers;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.soldiers = new ArrayList<>();
    }

    public void addPrivate(PrivateImpl privateSoldier){
        soldiers.add(privateSoldier);
    }

    public List<PrivateImpl> getSoldiers() {
        return soldiers;
    }

    @Override
    public String toString() {

        List<PrivateImpl> sortedSoldiers = soldiers.stream()
                .sorted(Comparator.comparing(Soldier::getId).reversed())
                .collect(Collectors.toCollection(ArrayList::new));

        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator())
                .append("Privates:");


        for (PrivateImpl soldier : sortedSoldiers) {
            sb.append(System.lineSeparator())
            .append(" ").append(soldier.toString());
        }
        return sb.toString();
    }
}

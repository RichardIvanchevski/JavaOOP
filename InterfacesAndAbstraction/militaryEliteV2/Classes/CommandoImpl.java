package militaryEliteV2.Classes;

import java.util.LinkedHashSet;
import java.util.Set;

public class CommandoImpl extends SpecialisedSoldierImpl{

    private Set<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.missions = new LinkedHashSet<>();
    }
    public void addMission(Mission missionName){
        missions.add(missionName);
    }

    public Set<Mission> getMissions() {
        return missions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator())
                .append("Missions:");

        for (Mission mission : missions) {
            sb.append(System.lineSeparator())
                    .append(mission.toString());
        }
        return sb.toString();
    }
}

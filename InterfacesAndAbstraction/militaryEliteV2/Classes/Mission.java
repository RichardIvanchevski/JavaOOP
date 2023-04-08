package militaryEliteV2.Classes;

import militaryEliteV2.enums.State;

public class Mission {
    private String codeName;
    private State state;

    public Mission(String codeName) {
        this.codeName = codeName;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public String getCodeName() {
        return codeName;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",codeName,state);
    }
}
